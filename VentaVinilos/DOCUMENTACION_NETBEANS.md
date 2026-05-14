# Documentacion de NetBeans y la interfaz grafica

Este proyecto fue desarrollado en NetBeans usando Java Swing. NetBeans permite
crear ventanas de forma visual con el editor grafico, y por eso el proyecto
incluye archivos `.java` y archivos `.form`.

## Archivos `.java`

Los archivos `.java` contienen el codigo fuente del programa. En este proyecto
hay clases para la interfaz grafica, modelos y colecciones.

Las ventanas principales son:

- `Login.java`: ventana de inicio de sesion.
- `Principal.java`: ventana principal de la tienda.
- `CrudProductos.java`: ventana para agregar, buscar, editar y eliminar productos.
- `CrudVentas.java`: ventana preparada para el modulo de ventas.

Las clases de datos son:

- `Producto.java`: representa un vinilo del inventario.
- `Venta.java`: clase reservada para futuras ventas.
- `BaseDatos.java`: almacena productos en memoria usando colecciones.

## Archivos `.form`

Los archivos `.form` son creados automaticamente por NetBeans cuando se usa el
editor grafico de Swing.

Estos archivos guardan la informacion visual del formulario, por ejemplo:

- Posicion de botones, etiquetas, paneles y tablas.
- Colores, fuentes y tamanos.
- Distribucion de los componentes.
- Relacion entre el diseno visual y el archivo `.java`.

Ejemplos del proyecto:

- `Login.form`
- `Principal.form`
- `CrudProductos.form`
- `CrudVentas.form`

Normalmente no se editan manualmente, porque NetBeans los usa internamente para
abrir y modificar la ventana desde el modo Design.

## Metodo `initComponents()`

En las ventanas creadas con NetBeans aparece un metodo llamado `initComponents()`.
Este metodo es generado automaticamente por el editor visual.

Su funcion es crear y configurar todos los componentes de la ventana, como:

- `JPanel`: paneles que agrupan otros componentes.
- `JButton`: botones.
- `JLabel`: textos o imagenes.
- `JTextField`: campos de texto.
- `JPasswordField`: campo para contrasena.
- `JTable`: tabla para mostrar productos.
- `JScrollPane`: panel con barra de desplazamiento.

Tambien configura propiedades como:

- Color de fondo.
- Fuente del texto.
- Tamano de los componentes.
- Eventos de botones.
- Distribucion visual con `GroupLayout`, `GridLayout`, `BoxLayout` o
  `AbsoluteLayout`.

NetBeans coloca un comentario parecido a este:

```java
// <editor-fold defaultstate="collapsed" desc="Generated Code">
```

Eso significa que el codigo fue generado por NetBeans. Es recomendable no
modificarlo directamente, porque si se cambia el formulario desde el modo Design,
NetBeans puede volver a generar ese codigo y borrar cambios manuales.

## Eventos generados por NetBeans

Cuando se da doble clic a un boton en el editor grafico, NetBeans crea un metodo
de evento. Por ejemplo:

```java
private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt)
```

Ese metodo se ejecuta cuando el usuario presiona el boton `btnIngresar`.

En este proyecto los eventos mas importantes son:

- `btnIngresarActionPerformed`: valida usuario y contrasena.
- `btnAgregarActionPerformed` en `Principal`: abre el CRUD de productos.
- `btnComprarActionPerformed`: muestra el ticket de venta.
- `jButton3ActionPerformed`: cierra sesion y regresa al login.
- `btnAgregarActionPerformed` en `CrudProductos`: agrega un producto nuevo.
- `btnBuscarActionPerformed`: busca productos por artista.
- `btnEditarActionPerformed`: actualiza los datos de un producto.
- `btnEliminarActionPerformed`: elimina un producto.
- `tablaProductosMouseClicked`: carga en los campos el producto seleccionado.

## Uso de Swing en el proyecto

Swing es la libreria de Java usada para crear interfaces graficas de escritorio.
El proyecto usa varios componentes de Swing:

### `JFrame`

Es una ventana completa de la aplicacion.

Ejemplos:

- `Login extends javax.swing.JFrame`
- `Principal extends javax.swing.JFrame`
- `CrudProductos extends javax.swing.JFrame`

Cada clase que extiende `JFrame` representa una pantalla del sistema.

### `JPanel`

Sirve para organizar componentes dentro de una ventana. En el proyecto se usan
paneles para separar zonas como menu lateral, productos, carrito y totales.

### `JButton`

Representa botones que ejecutan acciones. Por ejemplo, iniciar sesion, agregar
productos, editar o eliminar.

### `JLabel`

Muestra textos o imagenes. En el login se usa para mostrar el nombre de la
tienda y una imagen.

### `JTextField`

Permite escribir texto. Se usa en el CRUD para capturar ID, album, artista,
precio y stock.

### `JPasswordField`

Es un campo especial para escribir contrasenas. Oculta los caracteres mientras
el usuario escribe.

### `JTable`

Muestra informacion en forma de tabla. En `CrudProductos` se usa para listar el
inventario de vinilos.

### `JOptionPane`

Muestra mensajes emergentes al usuario. Se usa para errores, confirmaciones y
avisos como "Producto agregado" o "Stock insuficiente".

## Distribuciones visuales usadas

NetBeans y el codigo del proyecto usan varios tipos de layout.

### `GroupLayout`

Es el layout que NetBeans genera normalmente para acomodar componentes en el
editor grafico.

### `AbsoluteLayout`

Permite colocar componentes usando coordenadas exactas. Se usa en algunas
ventanas para ubicar paneles en posiciones especificas.

### `GridLayout`

En `Principal.java` se usa para mostrar los productos en una cuadricula de tres
columnas.

```java
jPanel8.setLayout(new GridLayout(0, 3, 15, 15));
```

Esto significa:

- `0`: el numero de filas se calcula automaticamente.
- `3`: se muestran tres columnas.
- `15, 15`: separacion horizontal y vertical entre productos.

### `BoxLayout`

En `Principal.java` se usa para acomodar los productos del carrito de arriba
hacia abajo.

```java
jPanel6.setLayout(new BoxLayout(jPanel6, BoxLayout.Y_AXIS));
```

## Flujo de pantallas

El flujo principal del programa es:

1. Se abre `Login`.
2. El usuario escribe usuario y contrasena.
3. Si los datos son correctos, se abre `Principal`.
4. En `Principal` se muestran los productos disponibles.
5. El usuario puede agregar productos al carrito.
6. El sistema calcula subtotal, IVA y total.
7. Desde `Principal` se puede abrir `CrudProductos`.
8. En `CrudProductos` se administra el inventario.
9. Al cerrar sesion, se regresa a `Login`.

## Recomendacion para modificar la interfaz

Si se quiere cambiar la parte visual de una ventana, lo mejor es abrir el
archivo `.java` desde NetBeans y usar la pestana `Design`.

Si se quiere cambiar la logica del programa, se debe editar el codigo que esta
fuera de `initComponents()`, especialmente los metodos de eventos y metodos
propios como:

- `mostrarProductos()`
- `agregarAlCarrito()`
- `btnAgregarActionPerformed()`
- `btnBuscarActionPerformed()`
- `btnEditarActionPerformed()`
- `btnEliminarActionPerformed()`

Asi se evita que NetBeans borre cambios cuando vuelva a generar el codigo visual.

## Forma recomendada para comentar variables

Para este proyecto se puede explicar cada variable indicando primero su tipo de
dato y despues para que sirve.

Ejemplos:

```java
// Esta es una variable de tipo int que guarda el identificador unico del producto.
private int id;

// Esta es una variable de tipo String que guarda el nombre del album.
private String nombre;

// Esta es una variable de tipo double que guarda el precio unitario.
private double precio;

// Esta es una variable de tipo ArrayList<Producto> que guarda los productos.
public static ArrayList<Producto> listaProductos = new ArrayList<>();
```

Esta forma ayuda a identificar rapidamente el tipo de dato usado y la funcion
que cumple dentro del programa.
