let respuesta;
let testId;
let idQuestion;
let reseña;
let numeroPreguntas=0;
let itemsAleatorio=0;
let idUser;
let registradasQuestion = new Array()

function cerrar() {
    $(document).ready(function () {
        localStorage.removeItem('object_name');
        $(location).attr('href', "index.html");
    });
}
function test(id){
    idUser=id;
    $.ajax({
        url: "http://144.22.228.79:80/api/test/all",
        type: "GET",
        datatype: "JSON",
        success: function (response) {
            var option=0;
            if(response.length==0){
                guardarTest(id);
            }else{
                for (i=0; i<response.length; i++ ) {

                    if(id==response[i].user.id){
                        option = 1; 
                        testId=response[i].id;
                        console.log("no hago nada")
                        break
                    }else{
                        option=0;
                    }
                }
                if(option==1){
                    //console.log("test ya esta registrado")
                    respuestaRestantes();
                }else{
                    console.log("Registrando test")
                    guardarTest(id);
                }
            }
            
        },
        error: function (jqXHR, textStatus, errorThrown) {
            swal("Validación", "Error en la aplicacion, comuniquese conel administrador del sistema", "error");
        }
    });
}

function respuestaRestantes(){
    $.ajax({
        url: "http://144.22.228.79:80/api/testQuestion/all",
        type: "GET",
        datatype: "JSON",
        success: function (response) {
            //console.log(response);
            

            for (i=0; i<response.length; i++ ) {
                let k=0;
                //console.log(testId + " "+ response[i].test.id)
                if(testId==response[i].test.id){

                    registradasQuestion[k]=response[i].question.id;
                    k+=1;
                    numeroPreguntas+=1;
                    //console.log(numeroPreguntas);
                    
                    
                }
                //console.log(numeroAleatorio);
            }
            testCompletado(numeroPreguntas);
            
        },
        error: function (jqXHR, textStatus, errorThrown) {
            swal("Validación", "Error en la aplicacion, comuniquese conel administrador del sistema", "error");
        }
    });
}
function testCompletado(numero){
    if(numero>=5){
        console.log("primero aqui");
        $("#formulario").html("");
        
       actualizarTest();
    }else{

        preguntas();
    }
}
 //_____________________________________________________________ ESTOY AQUI
function actualizarTest(){
    let puntaje=0;
    $.ajax({
        url: "http://144.22.228.79:80/api/testQuestion/all",
        type: "GET",
        datatype: "JSON",
        success: function (response) {
            
            for(i=0; i< response.length; i++){
                if(response[i].test.id==testId){
                    if(response[i].answer==true){
                        puntaje+=20
                    }
                }
            }
            swal("Test completado, ya puede registrar nuevas preguntas", "Su puntaje es "+ puntaje, "success");
            let myData={
                id:testId,
                score:puntaje,
                user:{"id":idUser}
            };
            let dataToSend=JSON.stringify(myData);
            //console.log(dataToSend);
            $.ajax({
                type: 'PUT',
                contentType: "application/json; charset=utf-8",
                dataType: 'JSON',
                data: dataToSend,
                url: "http://144.22.228.79:80/api/test/update",
                success: function (response) { 
                    
                    setTimeout(
                        function(){ 
                            $(document).ready(function(){
                                $(location).attr('href',"menuUser.html");
                            });
                        }, 5000
                    );
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    swal("No se guardo correctamente, valido los campos", "Validación Incorrecta", "error");
                }
            });
        },
        error: function (jqXHR, textStatus, errorThrown) {
            swal("No se guardo correctamente, valido los campos", "Validación Incorrecta", "error");
        }
    });
}

function guardarTest(id){

    let myData={
        user:{"id":id}
    };
    let dataToSend=JSON.stringify(myData);
    
    $.ajax({
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: dataToSend,
        url: "http://144.22.228.79:80/api/test/new",
        success: function (response) {
            console.log(response);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            swal("No se guardo correctamente, valido los campos", "Validación Incorrecta", "error");
        }
    });
}

function preguntas() {
    $.ajax({
        url: "http://144.22.228.79:80/api/question/all",
        type: "GET",
        datatype: "JSON",
        success: function (response) {
            //console.log(response.length);
            let numberQuestion = new Array(response.length) 
            for (i=0; i<response.length; i++ ) {
                numberQuestion[i] = response[i].id;
            }
            numeroAleatorio(response.length,numberQuestion);

            $("#validacion").html("");
        },
        error: function (jqXHR, textStatus, errorThrown) {
            swal("Validación", "Error en la aplicacion, comuniquese conel administrador del sistema", "error");
        }
    });
}

function numeroAleatorio(max,numberQuestion) {
    //console.log(max);
    //let numero = Math.round(Math.random() * (max - 0) + 0);
    let preguntaExistente = false;
    //console.log(numberQuestion);
    $.ajax({
        url: "http://144.22.228.79:80/api/testQuestion/all",
        type: "GET",
        datatype: "JSON",
        success: function (response) {
            
            //console.log(numero);
            //console.log(numberQuestion); //lista con todos los id de las preguntas
            //console.log(preguntaExistente); boolean para identificar si la pregunta ya fue contestada

            let preguntasRegistradas = new Array(response.length)
            let k=0;
            //console.log(response);
            for (i=0; i<response.length; i++ ) {
                if(response[i].test.id==testId){
                    preguntasRegistradas[k]=response[i].question.id;
                    k+=1
                }
            }
            //console.log(testId);//id del test de usuario logeado
            
            console.log(preguntasRegistradas);
            llamarPreguntas(preguntasRegistradas,max);
            
        },
        error: function (jqXHR, textStatus, errorThrown) {
            swal("Validación", "Error en la aplicacion, comuniquese conel administrador del sistema", "error");
        }
    })
    
}




function llamarPreguntas(preguntasRegistradas,max) {
    $.ajax({
        url: "http://144.22.228.79:80/api/question/all",
        type: "GET",
        datatype: "JSON",
        success: function (response) {
            let questionId = new Array(response.length)
            for(i=0; i< response.length; i++){
                questionId[i]=response[i].id;
                
            }
            console.log(questionId);
            questionId.sort(function() { return Math.random() - 0.5 });
            console.log(questionId);
            let numero=0;
            for(i=0; i < questionId.length; i++){
                console.log(questionId[i]);
                if(preguntasRegistradas.includes(questionId[i])){
                    console.log("La pregunta ya fue realizada");
                }else{
                    numero=questionId[i];
                    console.log("la pregunta no ha sido resuelta");
                    break
                }
            }

            for(i=0; i< response.length; i++){
                if(response[i].id==numero)
                $("#textoPregunta").html(response[i].description);
                $("#a").val(response[i].a);
                $("#c").val(response[i].c);
                $("#b").val(response[i].b);
                respuesta = response[i].answer;
                idQuestion = response[i].id;
                reseña = response[i].review;
            }
            $("#validacion").html("");
        },
        error: function (jqXHR, textStatus, errorThrown) {
            swal("Validación", "Error en la aplicacion, comuniquese conel administrador del sistema", "error");
        }
    });
    
}

let answer=false;
$("#a").click(function(){
    if($("#a").val()==respuesta){
        $("#validacion").html("RESPUESTA CORRECTA");
        $("#siguiente").attr("disabled",false);
        answer=true;
    }else{
        $("#validacion").html("RESPUESTA INCORRECTA");
        $("#siguiente").attr("disabled",false);
        answer=false;
    }
    $("#reseña").html(reseña);
})

$("#b").click(function(){
    if($("#b").val()==respuesta){
        $("#validacion").html("RESPUESTA CORRECTA");
        $("#siguiente").attr("disabled",false);
        answer=true;
    }else{
        $("#validacion").html("RESPUESTA INCORRECTA");
        $("#siguiente").attr("disabled",false);
        answer=false;
    }
    $("#reseña").html(reseña);
})

$("#c").click(function(){
    if($("#c").val()==respuesta){
        $("#validacion").html("RESPUESTA CORRECTA");
        $("#siguiente").attr("disabled",false);
        answer=true;
    }else{
        $("#validacion").html("RESPUESTA INCORRECTA");
        $("#siguiente").attr("disabled",false);
        answer=false;
    }
    $("#reseña").html(reseña);
    
})
$("#siguiente").click(function(){
    $("#reseña").html("");
    $("#siguiente").attr("disabled",true);
    guardarTestQuestion(answer);
})

function guardarTestQuestion(respuesta){
    //console.log(respuesta+" / "+testId);
    let myData={
        answer:respuesta,
        question:{"id":idQuestion},
        test:{"id":testId}
    };
    let dataToSend=JSON.stringify(myData);
    console.log(dataToSend);
    
    $.ajax({
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: dataToSend,
        url: "http://144.22.228.79:80/api/testQuestion/new",
        success: function (response) {
            //console.log(response);
            //respuestaRestantes()
            $(location).attr('href', "test.html");
        },
        error: function (jqXHR, textStatus, errorThrown) {
            swal("No se guardo correctamente, valido los campos", "Validación Incorrecta", "error");
        }
    });
}




$("#salir").click(function(){
    $(location).attr('href', "menuUser.html");
})


