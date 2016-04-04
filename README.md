# AppBDTesoros

<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/8901638/14192820/5d9ef8ae-f7a0-11e5-816d-0602082f72d3.png" width="200"/>
  <img src="https://cloud.githubusercontent.com/assets/8901638/14192822/62f5d25a-f7a0-11e5-8e07-725110847dcc.png" width="200"/>
  <img src="https://cloud.githubusercontent.com/assets/8901638/14192826/65db7420-f7a0-11e5-8875-f844305b5310.png" width="200"/>
</p>

Pantalla 1: Lista de tesoros
La primera pantalla muestra una lista de los tesoros guardados en la base de datos.
Para rellenar la lista con los objetos se utiliza el metodo populateTesoroList()
Recogemos de la base de datos todos los objetos de tipo Tesoro y los guardamos en un array. 
Este array lo pasamos como parametro en el constructor de nuestro objeto de tipo CustomAdapter. El CustomAdapter recoge cada objeto del array y le da el formato que se define en el layout item_tesoro.xml y se devuelve esta vista.
Despues se recoge el ListView donde se van a mostrar los objetos y se le coloca el adaptador con el metodo setAdapter().

Pantalla 2: Mapa del tesoro
Se recogen todas las pistas pertenecientes al tesoro seleccionado en la BD y se crea un boton para cada pista.

Pantalla 3: Pista del tesoro
Se muestra el texto de la pista y un boton para obtener el resultado.

Recursos utilizados:
- Base de datos embebida de SQLite para guardar todos los datos de la aplicacion
- CustomAdapter para mostrar los datos de los tesoros de una forma concreta. DefaultAdapter solo muestra el metodo toString del objeto.
- LocationManager para la geolocalizacion. Necesitamos permisos.

