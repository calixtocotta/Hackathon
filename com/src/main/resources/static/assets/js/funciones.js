/**
 * 
 * 
 */
$("#formularioReg").validate({
    rules: {
        name: {
            required: true,
            minlength: 3,
            maxlength: 80,
        },
        email: {
            required: true,
            minlength: 3,
            maxlength: 50,
            email: true,
        },
        password: {
            required: true,
            minlength: 6,
            maxlength: 16,
        },
        password_confirm: {
            required: true,
            minlength: 6,
            maxlength: 16,
            equalTo: "#password",
        },
        cellPhone: {
            required: true,
            minlength: 3,
            maxlength: 10,
        },
        identification: {
            required: true,
            minlength: 3,
            maxlength: 50,
        },
        age: {
            required: true,
            maxlength: 3,
        }
    }
})

/**
 * 
 */
$("#registrar").click(function () {
    if ($("#formularioReg").valid() == false) {
        return;
    }
    if ($("#password").val() == $("#password_confirm").val()) {
        /*
        let name = $("#name").val()
        let identification = $("#identification").val()
        let cellPhone = $("#cellPhone").val()
        let email = $("#email").val()
        let password = $("#password").val()
        let age = $("#age").val()
        */
        guardarUsuarios
    }
    else {
        swal("la contraseña no coincide", "Validación incorrecta", "error");
    }
})


/**
 * 
 */
function guardarUsuarios() {
    var email = $("#email").val();

    $.ajax({
        url: "http://144.22.228.79:80/api/user/emailexist/" + email,
        type: "GET",
        datatype: "JSON",
        success: function (response) {
            //console.log(response)
            if (response == true) {
                swal("El usuario ya existe, valide los datos o ingrese al sistema por el Login", "Validación Incorrecta", "error");
            } else {
                let myData = {
                    name: $("#name").val(),
                    identification: $("#identification").val(),
                    cellPhone: $("#cellPhone").val(),
                    email: $("#email").val(),
                    password: $("#password").val(),
                    age: $("#age").val()
                };
                let dataToSend = JSON.stringify(myData);
                //console.log(dataToSend);
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
                });
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            swal("Validación", "Error en la aplicacion, comuniquese conel administrador del sistema", "error");
        }
    });
}