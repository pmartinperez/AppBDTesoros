# AppBDTesoros

<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/8901638/14192820/5d9ef8ae-f7a0-11e5-816d-0602082f72d3.png" width="200"/>
  <img src="https://cloud.githubusercontent.com/assets/8901638/14192822/62f5d25a-f7a0-11e5-8e07-725110847dcc.png" width="200"/>
  <img src="https://cloud.githubusercontent.com/assets/8901638/14192826/65db7420-f7a0-11e5-8875-f844305b5310.png" width="200"/>
</p>

### Pantalla 1: Lista de tesoros
La primera pantalla muestra una lista de los tesoros guardados en la base de datos.
Para rellenar la lista con los objetos se utiliza el metodo **populateTesoroList()**:
Con este método recogemos de la base de datos todos los objetos de tipo Tesoro y los guardamos en un array. 
Este array lo pasamos como parametro en el constructor de nuestro objeto de tipo CustomAdapter. El CustomAdapter recoge cada objeto del array y le da el formato el cual se define en el layout item_tesoro.xml y se devuelve esta vista.
Despues se recoge el ListView donde se van a mostrar los objetos y se le coloca el adaptador con el metodo setAdapter().

Cada vez que pulsemos sobre un elemento de la lista se crea un Intent con el id del tesoro y se manda a la activity de la pantalla 2.

### Pantalla 2: Mapa del tesoro
Recogemos el intent con el id del Tesoro seleccionado.Con este id se recogen todas las pistas pertenecientes este tesoro y se crea un boton por cada pista. Estos programas se crean por codigo ya que el numero de pistas de cada tesoro no es fijo. 
Las pistas se iran desbloqueando segun las vayamos realizando correctamente. Esto se consigue con el metodo setEnabled(boolean) del boton.

Si pulsamos sobre un boton se crea un Intent con el id de la pista y se manda a la activity de la pantalla 3.

### Pantalla 3: Pista del tesoro
Se muestra el texto de la pista y un boton para obtener el resultado. La pista puede realizarse mediante geolocalización o reconocimiento de objetos.
- **Geolocalizacion**. Utilizamos la clae LocationManager la cual nos da acceso al servicio de localización de Android. Este servicio nos permite registrar la localización, acceso a proveedores de la posición, alertas de proximidad, etc.
La clase LocationProvider guarda la información de la posición actual en la clase Location. Para elegir el proveedor que nos da información de la posición usaremos un objeto Criteria. 
De esta forma utilizamos los metodos getLatitude() y getLongitude() para recoger la localización actual.

Necesitamos varios permisos que incluiremos en el manifest.

- **Reconocimiento de objetos**. Lo explicamos en su repositorio https://github.com/pmartinperez/VuforiaSamples-5-5-9

