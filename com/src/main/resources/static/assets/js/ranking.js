function traerInformacion(){
    $.ajax({
        url: "http://144.22.228.79:80/api/test/all",
        type: "GET",
        datatype: "JSON",
        success: function (response) {
            console.log(response);
            pintar(response);

            for (i=0; i<response.length; i++ ){

            }
            console.log(ranking);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            swal("Validación", "Error en la aplicacion, comuniquese conel administrador del sistema", "error");
        }
    });
}

function pintar(items){
    ordenarAsc(items, 'score');
    console.log(items);
    let myTable="<table id='informacion'>";
    let tableHeader = `<thead><tr>
    <th>IDENTIFICACIÓN</th>
    <th>NOMBRE</th>
    <th>CORREO</th>
    <th></th>
    </thead></tr>`;
    myTable += tableHeader;

    for (i=0; i<items.length; i++ ){
        myTable+="<tr>";
        myTable+="<td data-titulo='ID:'>"+items[i].identification+"</td>";
        myTable+="<td data-titulo='NOMBRE:'>"+items[i].name+"</td>";
        myTable+="<td data-titulo='CORREO:'>"+items[i].email+"</td>";
        myTable+="<td> <button class='mx-auto btn-danger btn-gradient' onclick='borrarElemento("+items[i].id+")'>Borrar</button> <button class='mx-auto btn-danger btn-gradient' id='editar' onclick='Editar("+items[i].id+")'>Editar</button> </td>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado").html(myTable);
}

function ordenarAsc(p_array_json, p_key) {
    p_array_json.sort(function (a, b) {
       return a[p_key] > b[p_key];
    });
 }