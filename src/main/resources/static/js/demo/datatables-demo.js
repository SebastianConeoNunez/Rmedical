// Call the dataTables jQuery plugin
$(document).ready(function() {
  CargarUsuarios();
  $('#TablaUsuario').DataTable();
});

async function CargarUsuarios() {
  const RequestUser = await fetch('api/usuario', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
      'Authorization': localStorage.token
    }
  });



  const User = await RequestUser.json();

  let ListaUs= '';
  for(let Persona of User){
        let telefono = Persona.numero==0 ? '-': Persona.numero
        let Humano = ' <tr><td>'+Persona.nombre+'</td><td>'+Persona.apellido+'</td><td>'+telefono+'</td><td>'+Persona.id+'</td><td><a href="#" onclick="DeleteUsuario('+Persona.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';
        ListaUs = ListaUs+Humano;
  }
  document.querySelector('#TablaUsuario tbody').outerHTML= ListaUs;

  console.log(User);
}

async function DeleteUsuario(id){

    if(!confirm('¿Quieres eliminar el usuario?')){
        return;
    }

    const RequestUser = await fetch('api/usuario/'+ id, {
        method: 'DELETE',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
          'Authorization': localStorage.token
        }
      });

      location.reload();

}

