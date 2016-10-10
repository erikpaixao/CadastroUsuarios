app.controller('HomeCtrl', function($rootScope, $location)
{
   $rootScope.activetab = $location.path();
});
 
app.controller('AgendamentosCtrl', function($rootScope, $location)
{
   $rootScope.activetab = $location.path();
});
 
app.controller('UsuariosCtrl', function($rootScope, $location)
{
   $rootScope.activetab = $location.path();
});
app.controller('LojasCtrl', function($rootScope, $location)
{
   $rootScope.activetab = $location.path();
});