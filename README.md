# AppBDTesoros

<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/8901638/14192820/5d9ef8ae-f7a0-11e5-816d-0602082f72d3.png" width="200"/>
  <img src="https://cloud.githubusercontent.com/assets/8901638/14192822/62f5d25a-f7a0-11e5-8e07-725110847dcc.png" width="200"/>
  <img src="https://cloud.githubusercontent.com/assets/8901638/14192826/65db7420-f7a0-11e5-8875-f844305b5310.png" width="200"/>
</p>

Pantalla 1: Lista de tesoros
La primera pantalla muestra una lista de los tesoros guardados en la base de datos. 

Pantalla 2: Mapa del tesoro
Se recogen todas las pistas pertenecientes al tesoro seleccionado en la BD y se crea un boton para cada pista.

Pantalla 3: Pista del tesoro
Se muestra el texto de la pista y un boton para obtener el resultado.

Recursos utilizados:
- Base de datos embebida de SQLite para guardar todos los datos de la aplicacion
- CustomAdapter para mostrar los datos de los tesoros de una forma concreta. DefaultAdapter solo muestra el metodo toString del objeto.
- LocationManager para la geolocalizacion. Necesitamos permisos.

