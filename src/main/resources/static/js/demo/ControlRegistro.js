// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function RegistrarUsuarios() {

  let datos={};
  datos.nombre=document.querySelector('#exampleFirstName').value;
  datos.apellido=document.getElementById('exampleLastName').value;
  datos.contraseña =document.querySelector('#exampleInputPassword').value;

  let ContraseñaDos=document.querySelector('#exampleRepeatPassword').value;


  if(datos.contraseña!= ContraseñaDos){
        alert("la constraseña no coinciden");
        return;
  }


  const RequestUser = await fetch('api/usuario', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
     body: JSON.stringify(datos)
  });


}

