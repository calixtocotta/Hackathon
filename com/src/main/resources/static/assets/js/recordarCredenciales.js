function validar(id){
    //onsole.log("Entro aqui " + $("#password").val() + id);
    if($("#password").val()==""){
        swal("Error", "Debe ingresar su contraseña actual", "error");
    }else{
        $.ajax({
            url: "http://144.22.228.79:80/api/user/all",
            type: "GET",
            datatype: "JSON",
            success: function (response) {
                console.log(response);
                for (i=0; i<response.length; i++ ) {
                    if(response[i].id==id){
                        swal("Sus credenciales para iniciar session son", "Correo: " +response[i].email + "   Contraseña: "+ response[i].password, "success");

                    }
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                swal("Validación", "Error en la aplicacion, comuniquese conel administrador del sistema", "error");
            }
        });
    }
}
