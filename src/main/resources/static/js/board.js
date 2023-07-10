let index = {
    init: function(){
        // on(event, do)
        $("#btn-save").on("click", ()=>{
            this.save();
        });
        $("#btn-update").on("click", ()=>{
            this.update();
        });
        $("#btn-delete").on("click", ()=>{
            this.deleteById();
        });
    },
    save: function(){
        let data = {
            title: $("#title").val(),
            content: $("#content").val()
        };
        $.ajax({
            type: "POST",
            url: "/api/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8", // 요청 body 데이터 타입(MIME 방식)
            dataType: "json" // 서버에서 응답하는 문자열의 형태가 json이면 javascript object로 변경해 줌.
        }).done(function(res){
            alert("글 쓰기가 완료되었습니다.");
            console.log(res);
            location.href="/";
        }).fail(function(error){
            alert("JSON.stringify(error)");
        });
    },
    update: function(){
        let id = $("#id").val();
        let data = {
            title: $("#title").val(),
            content: $("#content").val()
        };
        $.ajax({
            type: "PUT",
            url: "/api/board/" + id,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8", // 요청 body 데이터 타입(MIME 방식)
            dataType: "json" // 서버에서 응답하는 문자열의 형태가 json이면 javascript object로 변경해 줌.
        }).done(function(res){
            alert("글 수정이 완료되었습니다.");
            console.log(res);
            location.href="/";
        }).fail(function(error){
            alert("JSON.stringify(error)");
        });
    },
    deleteById: function(){
            let id = $("#id").text();
            console.log(id);
        $.ajax({
            type: "DELETE",
            url: "/api/board/" + id,
            dataType: "json" // 서버에서 응답하는 문자열의 형태가 json이면 javascript object로 변경해 줌.
        }).done(function(res){
            alert("삭제가 완료되었습니다.");
            console.log(res);
            location.href="/";
        }).fail(function(error){
            alert("JSON.stringify(error)");
        });
    }
}

index.init();