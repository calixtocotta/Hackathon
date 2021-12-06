function consultarCategoria() {

}

function crearPregunta() {
    let id;
    $.ajax({
        url: "http://144.22.228.79:80/api/category/all",
        type: "GET",
        datatype: "JSON",
        success: function (response) {

            for (let i = 0; i < response.length; i++) {
                if (response[i].name == $("#categoria").val()) {
                    id = response[i].id_Category;
                    let myData = {
                        description: $("#pregunta").val(),
                        a: $("#a").val(),
                        b: $("#b").val(),
                        c: $("#c").val(),
                        answer: $("#respuesta").val(),
                        review: $("#review").val(),
                        difficulty: $("#dificultad").val(),
                        category: { id_Category: id }
                    };

                    if (myData.description != "" && myData.a != "" && myData.b != "" && myData.c != "" && myData.review != "") {

                        let dataToSend = JSON.stringify(myData);
                        console.log(dataToSend);


                        $.ajax({
                            type: 'POST',
                            contentType: "application/json; charset=utf-8",
                            dataType: 'JSON',
                            data: dataToSend,
                            url: "http://144.22.228.79:80/api/question/new",
                            success: function (response) {
                                swal("Pregunta Válida", "La pregunta ha sido adjuntada al banco de preguntas, esperamos que con ella le aportes a los demás jovenes y te agradecemos por tu aporte", "success");
                                setTimeout(
                                    function () {
                                        $(document).ready(function () {
                                            $(location).attr('href', "menuUser.html");
                                        });
                                    }, 4000
                                );
                            },
                            error: function (jqXHR, textStatus, errorThrown) {
                                swal("No se guardó la pregunta", "Si este error persiste, contacte a soporte", "error");
                            }
                        });
                    } else {
                        swal("Campos incompletos", "No se puede enviar la información si TODOS los campos no están rellenos, intente de nuevo", "error");
                    }
                    console.log(response);
                }
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            swal("Validación", "Error en la aplicacion, comuniquese conel administrador del sistema", "error");
        }
    });

}

$("#enviar").click(function () {
    crearPregunta();
})


$("#salir").click(function () {
    $(location).attr('href', "menuUser.html");
})