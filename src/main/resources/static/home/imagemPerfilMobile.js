document.addEventListener("DOMContentLoaded", function() {
  const foto_perfil_home = document.querySelector('.btmobilemo');
  const userId = localStorage.getItem('userId');

  fetch(`https://urbtech-app-3f539deca240.herokuapp.com/urbtech-app/usuario/retornaUrlFotoPerfil/${userId}`)
    .then(function (res){
        if (res.status === 200){
            return res.json();
        }else{
            console.log("Não foi possível carregar a imagem do perfil.")
        }
    })
    .then(function (userData){
        const urlFotoPerfil = userData.urlFotoPerfil;
        foto_perfil_home.style.backgroundImage = `url("${urlFotoPerfil}")`;
    })
    .catch(function (error){
        console.log("Não foi possível carregar os dados");
    });
});