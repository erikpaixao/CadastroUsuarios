var app = angular.module('app',['ngRoute']);
 
app.config(function($routeProvider, $locationProvider)
{
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
});

app.controller('MyController', ['$scope', '$http', function($scope, $http) {
  $scope.users;
  var baseUrl = '/api/users';

  $http.get(baseUrl).then(function(response) {
    $scope.users = response.data;
  }, function(err) {
    console.log(err);
  });
}]);