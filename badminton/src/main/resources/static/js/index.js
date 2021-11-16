//let courts; //배드민턴장 리스트를 저장하는 전역변수
let selectedCourt;  //배드민턴장 목록에서 선택한 배드민턴장을 저장하는 전역변수

//광역시도 드롭다운 클릭 리스너 -> 선택한 li 텍스트가 화면에 보이도록 한다.
$('.dropdown-menu.sigungu').children('li').off().on('click', function(e) {
    $('#sigungu_btn').text($(this).text());
})

//시군구 드롭다운 클릭 리스너
$('.dropdown-menu.gungu').children('li').off().on('click', function(e) {
    let gungu = $(this).text(); //선택한 시군구
    let eupmyeonri;

    $('#gungu_btn').text(gungu);    //선택한 시군구 텍스트가 화면에 보이도록 한다.

    switch(gungu) { //선택된 시군구에 맞춰 읍면동리 리스트를 작성한다.
        case "강화군":
            eupmyeonri = ["송해면"];
            break
        case "계양구":
            eupmyeonri = ["계산동", "서운동", "선주지동", "효성동", "작전동", "병방동", "방축동", "귤현동"];
            break
        case "남동구":
            eupmyeonri = ["구월동", "논현동", "만수동", "서창동"];
            break
        case "동구":
            eupmyeonri = ["송림동"];
            break
        case "미추홀구":
            eupmyeonri = ["학익동", "도화동", "주안동", "용현동"];
            break
        case "부평구":
            eupmyeonri = ["일신동", "삼산동", "산곡동", "청천동", "갈산동", "부개동", "십정동", "부평동"];
            break
        case "서구":
            eupmyeonri = ["오류동", "백석동", "청라동", "불로동", "가정동", "가좌동", "원당동", "당하동", "심곡동", "마전동", "시천동"];
            break
        case "연수구":
            eupmyeonri = ["송도동", "연수동", "동춘동", "선학동"];
            break
        case "중구":
            eupmyeonri = ["도원동", "신흥동3가", "운서동", "중산동", "운남동", "북성동3가", "운북동"];
            break
    }

    setEupmyeonri(eupmyeonri);
})

//읍면동리 드롭다운 클릭 리스너 -> 선택한 li 텍스트가 화면에 보이도록 한다.
$(document).ready(function() {
    $(document).on('click', '.dropdown-item.eupmyeonri', function(event) {
        $('#eupmyeonri_btn').text($(this).text());
    })
})

//선택된 시군구 데이터에 맞춰 읍면동리 데이터를 보여주는 html을 작성하는 함수
function setEupmyeonri(eupmyeonri) {
    let html = "";

    eupmyeonri.forEach(function(value, index) {
        html += `<li><a class="dropdown-item eupmyeonri">${value}</a></li>`;
    })

    $('.dropdown-menu.eupmyeonri').html(html);
}

//드롭다운에서 선택한 위치에 있는 배드민턴장 리스트 전달받기
$('.btn.btn-region.btn-search').on('click', function(e) {
    let metropolitanCity = $('#sigungu_btn').text();
    let sigungu = $('#gungu_btn').text();
    let eupmyeonri = $('#eupmyeonri_btn').text();
    // let url = escape(encodeURIComponent(`http://localhost:8080/courts?metropolitanCity=${metropolitanCity}&sigungu=${sigungu}&eupmyeonri=${eupmyeonri}`));
    // console.log();
    $.ajax({
        url: `http://localhost:8080/courts?metropolitanCity=${metropolitanCity}&sigungu=${sigungu}&eupmyeonri=${eupmyeonri}`,
        type: 'GET',
        success: function(response) {
            //courts = ;  //전역변수인 courts에 전달받은 배드민턴장 데이터 저장
            setCourtListHtml(response);
        },
        error: function(error) {
            console.log(error);
        }
    })
})

//배드민턴장 이름을 검색해 배드민턴장 리스트 전달받기
$('.btn.btn-court-name.btn-search').on('click', function(e) {
    let courtName = $('input[name=court-name]').val();
    
    $.ajax({
        url: `http://localhost:8080/courts?name=${courtName}`,
        type: 'GET',
        success: function(response) {
            //courts = response;  //전역변수인 courts에 전달받은 배드민턴장 데이터 저장
            setCourtListHtml(response);
        },
        error: function(error) {
            console.log(error);
        }
    })
})

//배드민턴장 목록 화면 구현하기 
function setCourtListHtml(courts) {
    let html = `<thead>
                    <tr>
                        <th scope="col">No</th>
                        <th scope="col">장소명</th>
                        <th scope="col">링크</th>
                    </tr>
                </thead>`;

    courts.forEach(function(value, index) {
        html += `<tr>
                    <th scope="col" id="court-id">${value.id}</th>
                    <th scope="col">${index+1}</th>
                    <th scope="col" class="court-name-th"><a class="court-col-name" href="#services">${value.name}</a></th>
                    <th scope="col"><a href="http://naver.me/Gvkc9FEP" target="_blank">${value.link}</a></th>
                </tr>`;
    })

    html += `</tbody>`;

    $('#court_table').html(html);
}

//배드민턴장 목록에서 장소명 클릭 리스너
$(document).ready(function() {
    $(document).on('click', '.court-name-th', function(event) {
        getCourt(true, $(this).parent('tr').children('#court-id').text());    //선택된 배드민턴장에 대한 상세정보를 요청하는 api 함수를 호출한다.
    })
})

//선택된 배드민턴장에 대한 상세정보를 요청하는 api 함수를 호출한다.
function getCourt(isGet, courtId) {
    $.ajax({
        url: `http://localhost:8080/courts/${courtId}`, 
        type: 'GET', 
        success: function(response) {
            selectedCourt = response;   //전역변수인 selectedCourt에 전달받은 배드민턴장 상세정보를 저장한다.

            if (isGet) {
                $('.mb-5.court-name').text(selectedCourt.name); //예약하기 화면에서 클래스명이 mb-5 court-name인 요소의 텍스트를 선택된 배드민턴장 이름으로 변경한다.
            } else {
                getReservedTime(courtId);
            }
        }, 
        error: function(error) {
            console.log(error);
        }
    })
}

//예약하기 화면에서 datetimepicker 설정
$(function () {
    $('#datetimepicker4').datetimepicker({
        format: 'L'
    });
});

//예약하기 화면에서 datetimepicker 날짜 변경된 이벤트 리스너
$('#datetimepicker4').on('change.datetimepicker', function (e) {
    //예약 불가능한 시간을 조회하는 API를 요청해서 시작시간과 종료시간 체크할 수 있는 html 코드 작성하는 함수 호출
    getReservedTime(selectedCourt.id);    
});

//예약 불가능한 시간을 조회하는 API를 요청해서 시작시간과 종료시간 체크할 수 있는 html 코드 작성하는 함수
function getReservedTime(courtId) {
    const date = $('input[name=reservationDate]').val().replaceAll('.', '-').slice(0, -1);  //선택된 날짜 데이터 가져오기

    //날짜와 배드민턴장을 검색해 예약 불가능한 시간을 조회하는 api를 요청한다.
    $.ajax({
        'url': `http://localhost:8080/reservations/reserved?date=${date}&courtId=${courtId}`,
        'type': 'GET', 
        'success': function(response) {
            //전달받은 데이터를 가지고 가능한 시작시간과 종료시간을 보여주는 html 코드를 호출한다.
            setReservationTimeHtml(true, response.reservedStartTime);
            setReservationTimeHtml(false, response.reservedEndTime);
        },
        'error': function(error) {
            console.log(error);
        }
    })
}

//선택한 날짜와 배드민턴장에서 예약 가능한 시간과 예약 불가능한 시간을 나타내는 html 코드 작성하는 함수
//isStartTime: true이면 시작 시간에 대한 html 코드를 작성하는 함수이고, false이면 종료 시간에 대한 html 코드를 작성한다.
//reservedTime: 서버에서 가져온 예약 불가능한 시간
function setReservationTimeHtml(isStartTime, reservedTime) {
    let openTime;  
    let closeTime;
    let html = "";

    //배드민턴장 오픈 시간 구하기 -> null이면 항상 열려 있다는 뜻이므로 openTime을 0으로 하고, 아니면 선택한 배드민턴장의 오픈시간을 가져온다.
    if (selectedCourt.openTime==null) {
        openTime = 0;
    } else {
        openTime = Number(selectedCourt.openTime.split(':')[0]);
    }
    //배드민턴장 닫는 시간 구하기 -> null이면 항상 열려 있다는 뜻이므로 loseTime을 0으로 하고, 아니면 선택한 배드민턴장의 닫는시간을 가져온다.
    if (selectedCourt.closeTime==null) {
        closeTime = 24;
    } else {
        closeTime = Number(selectedCourt.closeTime.split(':')[0]);
    }

    //시작 시간 중 예약 가능한 시간과 불가능한 시간을 표시하기
    if (isStartTime) {
        for (let hour=openTime; hour<closeTime; hour++) {
            if (reservedTime.includes(`${numberPad(hour, 2)}:00:00`)) {   //예약 불가능한 시간이면 input 태그에 disabled를 추가한다.
                html += `<input type="radio" class="btn-check" id="start${hour}" name="startTime" value="${numberPad(hour, 2)}:00" disabled="disabled">
                        <label class="btn btn-secondary" for="start${hour}">${numberPad(hour, 2)}:00</label>`;
            } else {
                html += `<input type="radio" class="btn-check" id="start${hour}" name="startTime" value="${numberPad(hour, 2)}:00">
                        <label class="btn btn-secondary" for="start${hour}">${numberPad(hour, 2)}:00</label>`;
            }
        }

        $('#reservation_start_time').html(html);
    } else {    //종료 시간 중 예약 가능한 시간과 불가능한 시간을 표시하기
        for (let hour=openTime+1; hour<=closeTime; hour++) {   
            if (reservedTime.includes(`${numberPad(hour, 2)}:00:00`)) {    //예약 불가능한 시간이면 input 태그에 disabled를 추가한다.
                html += `<input type="radio" class="btn-check" id="end${hour}" name="endTime" value="${numberPad(hour, 2)}:00" disabled="disabled">
                        <label class="btn btn-secondary" for="end${hour}">${numberPad(hour, 2)}:00</label>`;  
            } else {
                html += `<input type="radio" class="btn-check" id="end${hour}" name="endTime" value="${numberPad(hour, 2)}:00">
                        <label class="btn btn-secondary" for="end${hour}">${numberPad(hour, 2)}:00</label>`;
            }
        }
        $('#reservation_end_time').html(html);
    }
}

//숫자 앞에 0을 붙이는 함수. ex)3 -> 03
function numberPad(n, width) {
    n = n + '';
    return n.length >= width ? n : new Array(width - n.length + 1).join('0') + n;
}

//예약하기/수정하기 버튼 클릭 리스너
$('#reservation_btn').on('click', function(e) {
    //request data 만들기
    const reservationDate = $('input[name=reservationDate]').val().replaceAll('.', '-').slice(0, -1);
    const startTime = $("input:radio[name='startTime']:checked").val();
    const endTime = $("input:radio[name='endTime']:checked").val();
    const userName = $('input[name=bookerName]').val();
    const userPhone = $('input[name=bookerPhone]').val();
    const courtId = selectedCourt.id;
    const reservation = {"reservationDate": reservationDate, "startTime": startTime, "endTime": endTime, "userName": userName, "userPhone": userPhone, "courtId": courtId};

    if ($(this).val()=="예약하기") {    //버튼의 텍스트가 '예약하기' 이면 -> 예약하기 API 요청 함수 호출
        //API 요청
        makeReservation(reservation);
    } else {    //버튼의 텍스트가 '수정하기' 이면 -> 예약 수정하기 API 요청 함수 호출
        reservation['id'] = $('#reservation-id').text();    //예약 수정에서는 request body에 예약 id가 있어야 하므로 예약 id를 추가한다.
        updateReservation(reservation); 
    }
    
})

//예약하기 API 요청 함수
function makeReservation(reservation) {
    $.ajax({
        url: 'http://localhost:8080/reservations',
        type: 'POST',
        headers: {"Content-Type": "application/json", "X-HTTP-Method-Override": "POST"},
        data: JSON.stringify(reservation),
        success: function(response) {
            alert(`예약을 완료했습니다!\n예약 날짜: ${reservation.reservationDate}\n장소: ${selectedCourt.name}\n예약시간: ${reservation.startTime}~${reservation.endTime}`);   //예약 완료 alert창을 띄운다.
            window.location = '/';  //페이지를 새로고침한다.
            //location.reload();  //페이지를 새로고침한다.
        },
        error: function(error) {
            alert("예약 중 문제가 발생했습니다. 다시 시도해 주세요!");
        }
    })
}

//예약 수정하기 API 요청 함수
function updateReservation(reservation) {
    $.ajax({
        url: `http://localhost:8080/reservations/${reservation.id}`,
        type: 'PATCH',
        headers: {"Content-Type": "application/json", "X-HTTP-Method-Override": "PATCH"},
        data: JSON.stringify(reservation),
        success: function(response) {
            alert(`성공적으로 수정이 완료됐습니다!\n예약 날짜: ${reservation.reservationDate}\n장소: ${selectedCourt.name}\n예약시간: ${reservation.startTime}~${reservation.endTime}`);   //예약 완료 alert창을 띄운다.
            window.location = '/';  //페이지를 새로고침한다.
            //location.reload();  //페이지를 새로고침한다.
        },
        error: function(error) {
            alert("수정 중 문제가 발생했습니다. 다시 시도해 주세요!");
        }
    })
}

//예약 내역 조회 화면에서 조회하기 버튼 클릭 리스너
$('#btn-inquire').on('click', function(e) {
    //사용자가 입력한 이름과 전화번호 데이터를 가져온다.
    const name = $('#input-name').val();
    const phone = $('#input-phone').val();

    getReservations(name, phone);   //이름과 전화번호 데이터를 가지고 예약 내역 조회 API 요청을 보내는 함수 호출
})

//이름과 전화번호 데이터를 가지고 예약 내역 조회 API 요청을 보내는 함수
function getReservations(name, phone) {
    //가져온 이름과 전화번호 데이터를 가지고 예약 내역 조회 API 요청을 보낸다.
    $.ajax({
        url: `http://localhost:8080/reservations?name=${name}&phone=${phone}`,
        type: 'GET',
        success: function(response) {
            if (response==undefined) {  //response가 undefined라는건 예약내역이 없다는 것.
                $('#reservation-tbody').empty();    //예약내역 리스트 테이블의 tbody 안의 요소를 비운다.
                $('#reservation-table').css('visibility', 'hidden');    //예약 내역 리스트 테이블의 visibility를 hidden으로 바꾼다.
            } else {    //예약내역이 있다면
                setReservationsHtml(response);  //예약 내역 리스트 테이블의 html 코드를 구성하는 함수를 호출한다.
            }
        },
        error: function(error) {
            console.log(error);
        }
    })
}

//예약 내역 리스트 테이블의 html 코드를 구성하는 함수
function setReservationsHtml(reservations) {
    let html = "";
    $('#reservation-table').css('visibility', 'visible');   //예약 내역 테이블의 visibility를 visible로 변경한다.
    
    //예약 내역 테이블 html을 작성한다.
    reservations.forEach(function(reservation, index) {
        html += `<tr>
                    <th scope="col" class="reservation-id">${reservation.reservationId}</th>
                    <th scope="col" class="reservation-court-id">${reservation.courtId}</th>
                    <th scope="col" class="reservation-booker">${reservation.booker}</th>
                    <th scope="col" class="court-name-col"><a class="court-name" href="${reservation.link}" target="_blank">${reservation.court}</a></th>
                    <th scope="col"class="reservation-date">${reservation.date}</th>
                    <th scope="col" class="reservation-time">${reservation.startTime.slice(0, 5)}~${reservation.endTime.slice(0, 5)}</th>
                    <th scope="col"><a href="#services"><button type="button" class="btn btn-primary btn-sm btn-cancel-modify" id="reservation-modify-btn">수정</button></a></th>
                    <th scope="col"><button type="button" class="btn btn-danger btn-sm btn-cancel-modify" id="reservation-cancel-btn">취소</button></th>
                </tr>`;
    }) 

    $('#reservation-tbody').html(html);
}

//예약 내역 취소 버튼 클릭 리스너
$(document).ready(function() {
    $(document).on('click', '#reservation-cancel-btn', function(event) {
        const reservationId = $(this).parent('th').parent('tr').children('.reservation-id').text(); //예약Id 가져오기

        //예약 취소 요청 API 전송
        $.ajax({
            url: `http://localhost:8080/reservations/${reservationId}`,
            type: "DELETE",
            headers: {"X-HTTP-Method-Override": "DELETE"},
            success: function(response) {
                if (response==true) {   //예약이 성공적으로 취소되면
                    alert("예약이 취소되었습니다.");    //alert창을 띄운다.
                    const name = $('#input-name').val();    //입력돼 있는 예약자 이름과
                    const phone = $('#input-phone').val();  //전화번호르 가져와
                    getReservations(name, phone);   //예약 조회 요청을 다시보내고, 예약 내역 리스트 html을 다시 작성한다.
                } else {
                    alert("예약 취소 중 문제가 발생했습니다. 다시 시도해 주세요.");
                }
            },
            error: function(error) {
                console.log(error);
                alert("예약 취소 중 문제가 발생했습니다. 다시 시도해 주세요.");
            }
        })
    })
})

//예약 내역 조회 화면에서 수정 버튼 클릭 리스너
$(document).ready(function() {
    $(document).on('click', '#reservation-modify-btn', function(event) {
        //reservation 객체 만들기
        const reservation = {
            "id": $(this).parent('a').parent('th').parent('tr').children('.reservation-id').text(),
            "reservationDate": $(this).parent('a').parent('th').parent('tr').children('.reservation-date').text().replaceAll('-', '.') + '.',
            "startTime": $(this).parent('a').parent('th').parent('tr').children('.reservation-time').text().split('~')[0],
            "endTime": $(this).parent('a').parent('th').parent('tr').children('.reservation-time').text().split('~')[1],
            "userName": $('#input-name').val(),
            "userPhone": $('#input-phone').val(),
            "courtId": $(this).parent('a').parent('th').parent('tr').children('.reservation-court-id').text(),
            "courtName": $(this).parent('a').parent('th').parent('tr').children('.court-name-col').children('.court-name').text()
        }
        //예약하기 화면을 예약 수정하기 화면으로 변경하는 함수를 호출
        bindReservation(reservation);
        //수정하고자 하는 배드민턴장 데이터를 불러오는 함수를 호출한다.(시작 시간, 종료 시간 데이터를 위해)
        getCourt(false, reservation.courtId);
    })
})

//예약하기 화면을 예약 수정하기 화면으로 변경하는 함수
function bindReservation(reservation) {
    $('#reservation-id').text(reservation.id);  //예약id를 저장한다.
    $('.mb-5.court-name').text(reservation.courtName);  //예약을 수정할 배드민턴장의 이름을 화면에 보여준다.
    $('input[name=bookerName]').val(reservation.userName);  //예약자 이름을 화면에 보여준다.
    $('input[name=bookerPhone').val(reservation.userPhone); //예약자 전화번호를 화면에 보여준다.    
    $('input[name=reservationDate]').val(reservation.reservationDate);  //예약날짜를 화면에 보여준다.
    $('#reservation_btn').val("수정하기");  //예약하기 버튼의 텍스트를 수정하기로 바꾼다.
}