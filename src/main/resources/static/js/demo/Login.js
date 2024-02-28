// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function LoginUsuarios() {

  let datos={};
  datos.apellido=document.getElementById('exampleInputEmail').value;
  datos.contraseña =document.querySelector('#exampleInputPassword').value;



  const RequestUser = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
     body: JSON.stringify(datos)
  });

  const User = await RequestUser.text();
  console.log(User);

  if(User!="FAIl"){
    localStorage.token= User;
    localStorage.email= datos.apellido;

    window.location.href='usuarios.html'
  }else{
      alert("Contraseña incorrecta")
  }


}

