'use strict';

var BASE_URL = 'http://localhost:8080/api';

angular.module('app', ['checklist-model', 'ngNotify', 'ngRoute', 'ngCookies', 'ngStorage'])
  .constant('SERVICE_PATH', {
    'ROOT_PATH': BASE_URL,
    'PUBLIC_PATH': BASE_URL + '/public',
    'PRIVATE_PATH': BASE_URL + '/private'
  })

app.config(function($routeProvider, $locationProvider){
   // remove o # da url
   $locationProvider.html5Mode(true);

   $routeProvider

   // para a rota '/', carregaremos o template home.html e o controller 'HomeCtrl'
   .when('/', {
      templateUrl : 'app/views/home.html',
      controller     : 'HomeCtrl',
   })

   // para a rota '/sobre', carregaremos o template sobre.html e o controller 'SobreCtrl'
   .when('/agendamentos', {
      templateUrl : 'app/views/agendamentos.html',
      controller  : 'AgendamentosCtrl',
   })

   // para a rota '/contato', carregaremos o template contato.html e o controller 'ContatoCtrl'
   .when('/usuarios', {
      templateUrl : 'app/views/usuarios.html',
      controller  : 'UsuariosCtrl',
   })

    .when('/lojas', {
      templateUrl : 'app/views/lojas.html',
      controller  : 'LojasCtrl',
   })

   // caso não seja nenhum desses, redirecione para a rota '/'
   .otherwise ({ redirectTo: '/' });
})

.config(function($httpProvider) {
  $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
  $httpProvider.defaults.withCredentials = true;
  $httpProvider.interceptors.push('httpRequestInterceptor');
})
.run(function($rootScope, ngNotify, LoginLogoutSrv) {
  $rootScope.authDetails = { name: '', authenticated: false, permissions: [] };

  ngNotify.config({
    theme: 'pastel'
  });

  LoginLogoutSrv.verifyAuth();
});
