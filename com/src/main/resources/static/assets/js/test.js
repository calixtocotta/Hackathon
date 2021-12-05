var respuesta;
function preguntas() {
    /*
    $.ajax({
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: dataToSend,
        url: "http://144.22.228.79:80/api/user/new",
        success: function (response) {
            swal("Cuenta creada de forma correcta", "Validación Correcta", "success");
            $(".form-control").val("");
            setTimeout(
                function () {
                    $(document).ready(function () {
                        $(location).attr('href', "menuUser.html");
                    });
                }, 5000
            );
        },
        error: function (jqXHR, textStatus, errorThrown) {
            swal("No se guardo correctamente, valido los campos", "Validación Incorrecta", "error");
        }
    });*/
    $.ajax({
        url: "http://144.22.228.79:80/api/question/all",
        type: "GET",
        datatype: "JSON",
        success: function (response) {
            let numero = numeroAleatorio();
            $("#textoPregunta").html(response[numero].description);
            $("#a").val(response[numero].a);
            $("#b").val(response[numero].b);
            $("#c").val(response[numero].c);
            respuesta = response[numero].answer;
            console.log(response[numero].description);
            console.log(numero);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            swal("Validación", "Error en la aplicacion, comuniquese conel administrador del sistema", "error");
        }
    });
}

function numeroAleatorio() {
    return Math.round(Math.random() * (2 - 0) + 0);
}

$("#a").click(function(){
    if($("#a").val()==respuesta){
        $("#validacion").html("RESPUESTA CORRECTA");
    }else{
        $("#validacion").html("RESPUESTA INCORRECTA");
    }
})

$("#b").click(function(){
    if($("#b").val()==respuesta){
        $("#validacion").html("RESPUESTA CORRECTA");
    }else{
        $("#validacion").html("RESPUESTA INCORRECTA");
    }
})

$("#c").click(function(){
    if($("#c").val()==respuesta){
        $("#validacion").html("RESPUESTA CORRECTA");
    }else{
        $("#validacion").html("RESPUESTA INCORRECTA");
    }
})

$("#salir").click(function(){
    $(location).attr('href', "menuUser.html");
})