let index = {
    init: function(){
        // on(event, do)
        $("#btn-save").on("click", ()=>{
            this.save();
        });
        $("#btn-update").on("click", ()=>{
            this.update();
        });
    },
    save: function(){
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };
        $.ajax({
            type: "POST",
            url: "/auth/join-proc",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8", // 요청 body 데이터 타입(MIME 방식)
            dataType: "json" // 서버에서 응답하는 문자열의 형태가 json이면 javascript object로 변경해 줌.
        }).done(function(res){
            alert("회원가입이 완료되었습니다.");
            console.log(res);
            location.href="/";
        }).fail(function(error){
            alert("JSON.stringify(error)");
        });
    },
    update: function(){
        let data = {
            id: $("#id").val(),
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };
        $.ajax({
            type: "PUT",
            url: "/user/",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8", // 요청 body 데이터 타입(MIME 방식)
            dataType: "json" // 서버에서 응답하는 문자열의 형태가 json이면 javascript object로 변경해 줌.
        }).done(function(res){
            alert("회원 정보 수정이 완료되었습니다.");
            console.log(res);
            location.href="/";
        }).fail(function(error){
            alert("JSON.stringify(error)");
        });
    }
}

index.init();