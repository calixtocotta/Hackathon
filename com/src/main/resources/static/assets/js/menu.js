$("#iniTest").click(function () {
    /*
    let id = localStorage.getItem("object_name");
    id = JSON.parse(id);
    id = id.id;
    console.log(id);
    let myData = localStorage.getItem("object_name");
    //localStorage.removeItem( 'object_name' ); // Clear the localStorage
    firstData = JSON.parse(myData);
    $.ajax({
        url: "http://144.22.228.79:80/api/user/" + id,
        type: "GET",
        datatype: "JSON",
        success: function (response) {
            console.log(response);
            if (response.test.length == 0) {
                $.ajax({
                    url: "http://144.22.228.79:80/api/test/new",
                    type: "GET",
                    datatype: "JSON",
                    success: function (res) {
                        console.log(res);
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        swal("Validación", "Error en la aplicacion, comuniquese conel administrador del sistema", "error");
                    }
                });
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            swal("Validación", "Error en la aplicacion, comuniquese conel administrador del sistema", "error");
        }

    });
    */
    $(location).attr('href', "test.html");
})