/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazG;
import colecciones.BaseDatos;
import modelos.Producto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;

/**
 * Ventana principal del sistema.
 *
 * Muestra los productos disponibles, permite agregarlos al carrito, calcula el
 * subtotal, IVA y total de la compra, y da acceso al CRUD de productos.
 */
public class Principal extends javax.swing.JFrame {
    
    // Esta es una variable de tipo double que guarda el subtotal de la venta actual.
    double subtotal = 0;

    // Esta es una variable de tipo double que guarda el IVA calculado.
    double iva = 0;

    // Esta es una variable de tipo double que guarda el total final de la compra.
    double totalFinal = 0;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Principal.class.getName());

    /**
     * Constructor de la ventana principal.
     *
     * Configura los paneles, centra la ventana, inicializa los importes en cero
     * y carga visualmente los productos desde BaseDatos.
     */
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        
        // GridLayout acomoda las tarjetas de productos en 3 columnas.
         jPanel8.setLayout(new GridLayout(0, 3, 15, 15));
        mostrarProductos();
        
        // BoxLayout acomoda los productos del carrito de arriba hacia abajo.
        jPanel6.setLayout(
    new BoxLayout(jPanel6, BoxLayout.Y_AXIS));
        
     jPanel8.setBackground(Color.BLACK);

    jPanel6.setBackground(Color.BLACK);

    jPanel7.setBackground(Color.BLACK);
        
    txtSubtotal.setText("0.00");
    txtIVA.setText("0.00");
    txtTotal.setText("0.00");
    mostrarProductos();
        
        
    }

    /**
     * Carga una imagen de forma segura para los componentes de la interfaz.
     *
     * Primero la busca como recurso del proyecto y, si NetBeans no la copio a
     * build/classes, intenta cargarla desde la carpeta src.
     */
    private javax.swing.ImageIcon cargarIcono(String ruta) {
        // Esta es una variable de tipo URL que guarda la ubicacion del recurso.
        java.net.URL ubicacion = getClass().getResource(ruta);

        if (ubicacion != null) {
            return new javax.swing.ImageIcon(ubicacion);
        }

        // Esta es una variable de tipo File que representa la imagen en src.
        java.io.File archivo = new java.io.File("src", ruta.replaceFirst("^/", ""));

        if (archivo.exists()) {
            return new javax.swing.ImageIcon(archivo.getAbsolutePath());
        }

        return new javax.swing.ImageIcon();
    }
    
    /**
     * Dibuja en pantalla todos los productos guardados en BaseDatos.
     *
     * Por cada Producto se crea una tarjeta con nombre, artista, precio, un
     * selector de cantidad y un boton para agregarlo al carrito.
     */
    private void mostrarProductos() {

    // Limpia el panel para evitar duplicar productos al refrescar.
    jPanel8.removeAll();

    // Recorre la lista principal de productos.
    for (Producto p : BaseDatos.listaProductos) {

        // Panel que representa visualmente un solo producto.
        JPanel panelProducto = new JPanel();
        
    panelProducto.setPreferredSize(
            new Dimension(140, 170));

    panelProducto.setBackground(Color.WHITE);

    panelProducto.setBorder(
            BorderFactory.createLineBorder(Color.GRAY)
        );

        panelProducto.setLayout(
            new BoxLayout(panelProducto, BoxLayout.Y_AXIS)
        );

        // Etiqueta con el nombre del album.
        JLabel lblNombre =
            new JLabel(p.getNombre());
        

        lblNombre.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );

        // Etiqueta con el artista del album.
        JLabel lblArtista =
            new JLabel(p.getArtista());

        lblArtista.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );

        // Etiqueta con el precio unitario.
        JLabel lblPrecio =
            new JLabel("$" + p.getPrecio());

        lblPrecio.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );

        // Texto que indica el selector de cantidad.
        JLabel lblCantidad =
            new JLabel("Cantidad");

        lblCantidad.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );

        // Spinner usado para elegir cuantas unidades se agregaran al carrito.
        JSpinner spCantidad = new JSpinner();

        spCantidad.setMaximumSize(
            new Dimension(60, 25)
        );

        // Boton que intenta agregar el producto seleccionado al carrito.
        JButton btnAgregar =
            new JButton("Add to Cart");
        
        btnAgregar.setMaximumSize(
    new Dimension(120, 20));

        btnAgregar.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );

        // Evento del boton: valida cantidad y stock antes de agregar.
        btnAgregar.addActionListener(e -> {

    int cantidad =
        (int) spCantidad.getValue();

    // No se permite agregar cero o cantidades negativas.
    if(cantidad <= 0){JOptionPane.showMessageDialog(null,"La cantidad debe ser mayor a 0");
    return;}
    
    // Valida que exista suficiente inventario.
    if(cantidad > p.getStock()){

        JOptionPane.showMessageDialog(
            null,
            "Stock insuficiente"
        );

        return;
    }

    agregarAlCarrito(p, cantidad);
});

         // Se agregan los componentes a la tarjeta del producto.
        panelProducto.add(Box.createVerticalStrut(10));
        panelProducto.add(lblNombre);
        
        panelProducto.add(Box.createVerticalStrut(10));
        panelProducto.add(lblArtista);
        
        panelProducto.add(Box.createVerticalStrut(10));
        panelProducto.add(lblPrecio);
        
        panelProducto.add(Box.createVerticalStrut(10));
        panelProducto.add(lblCantidad);
        
        panelProducto.add(Box.createVerticalStrut(10));
        panelProducto.add(spCantidad);
        
        panelProducto.add(Box.createVerticalStrut(10));
        panelProducto.add(btnAgregar);

        // Se agrega la tarjeta al panel principal de productos.
        jPanel8.add(panelProducto);
    }

    // Revalida y repinta para que Swing muestre los cambios en pantalla.
    jPanel8.revalidate();

    jPanel8.repaint();
}
    
    /**
     * Agrega un producto al carrito visual y actualiza los importes.
     *
     * @param p producto seleccionado
     * @param cantidad unidades que se desean comprar
     */
    private void agregarAlCarrito(
    Producto p,
    int cantidad
) {

    // Panel que representa una linea del carrito.
    JPanel itemCarrito = new JPanel();

    itemCarrito.setMaximumSize(
        new Dimension(250, 80)
    );

    itemCarrito.setBackground(Color.WHITE);

    itemCarrito.setBorder(
        BorderFactory.createLineBorder(Color.GRAY)
    );

    itemCarrito.setLayout(
        new BoxLayout(itemCarrito, BoxLayout.Y_AXIS)
    );

    // Nombre del producto agregado.
    JLabel lblNombre =
        new JLabel(p.getNombre());

    lblNombre.setAlignmentX(
        Component.CENTER_ALIGNMENT
    );

    // Informacion de cantidad y precio unitario.
    JLabel lblInfo =
        new JLabel(
            cantidad
            + " x $"
            + p.getPrecio()
        );

    lblInfo.setAlignmentX(
        Component.CENTER_ALIGNMENT
    );

    // Total de esta linea del carrito: cantidad por precio.
    double total =
        cantidad * p.getPrecio();

    JLabel lblTotal =
        new JLabel(
            "Total: $" + total
        );

    lblTotal.setAlignmentX(
        Component.CENTER_ALIGNMENT
    );

    // Se agregan etiquetas y espacios al panel del item.
    itemCarrito.add(
        Box.createVerticalStrut(5)
    );

    itemCarrito.add(lblNombre);

    itemCarrito.add(lblInfo);

    itemCarrito.add(lblTotal);

    itemCarrito.add(
        Box.createVerticalStrut(5)
    );

    // Se agrega el item al panel derecho, que funciona como carrito.
    jPanel6.add(itemCarrito);

    // Se refresca el panel para mostrar el nuevo item.
    jPanel6.revalidate();

    jPanel6.repaint();
    
// Suma el total del item al subtotal de la venta.
subtotal += total;

// Calcula el IVA del 16%.
iva = subtotal * 0.16;

// Calcula el total final sumando subtotal mas IVA.
totalFinal = subtotal + iva;

// Muestra los importes formateados con dos decimales.
txtSubtotal.setText(
    String.format("%.2f", subtotal)
);

txtIVA.setText(
    String.format("%.2f", iva)
);

txtTotal.setText(
    String.format("%.2f", totalFinal)
);
    
    // Resta del inventario la cantidad agregada al carrito.
    p.setStock(
    p.getStock() - cantidad
            
);
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIVA = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        btnComprar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Bebas Neue", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vinil's House");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/calaca.jpg"))); // NOI18N

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(51, 0, 255));
        jTextField1.setFont(new java.awt.Font("Bebas Neue", 3, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Administrador");

        btnAgregar.setBackground(new java.awt.Color(51, 51, 255));
        btnAgregar.setFont(new java.awt.Font("Bebas Neue", 3, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar Producto");
        btnAgregar.setToolTipText("");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnVentas.setBackground(new java.awt.Color(51, 0, 255));
        btnVentas.setFont(new java.awt.Font("Bebas Neue", 3, 14)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnVentas.setText("Ventas");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Bebas Neue", 3, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Cerrar Sesion");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 76, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 650));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Bebas Neue", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Productos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 210, 70));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Bebas Neue", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("IVA");

        jLabel6.setFont(new java.awt.Font("Bebas Neue", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Subtotal");

        jLabel7.setFont(new java.awt.Font("Bebas Neue", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Total");

        txtIVA.setEditable(false);
        txtIVA.setBackground(new java.awt.Color(0, 0, 0));
        txtIVA.setFont(new java.awt.Font("Bebas Neue", 3, 14)); // NOI18N
        txtIVA.setForeground(new java.awt.Color(51, 0, 255));
        txtIVA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtSubtotal.setEditable(false);
        txtSubtotal.setBackground(new java.awt.Color(0, 0, 0));
        txtSubtotal.setFont(new java.awt.Font("Bebas Neue", 3, 14)); // NOI18N
        txtSubtotal.setForeground(new java.awt.Color(51, 51, 255));
        txtSubtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(0, 0, 0));
        txtTotal.setFont(new java.awt.Font("Bebas Neue", 3, 14)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(51, 0, 255));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnComprar.setText("Finalizar Compra");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIVA, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(109, 109, 109)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(117, 117, 117)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnComprar, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                        .addGap(24, 24, 24))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(173, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 550, 700, -1));

        jPanel8.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane1.setViewportView(jPanel8);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 520, 480));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 160, 70));

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Bebas Neue", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Carrito");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 180, 70));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel6);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, 180, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
         // Abre la ventana donde se pueden agregar, buscar, editar o eliminar productos.
         CrudProductos crud = new CrudProductos();

    crud.setVisible(true);
    
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
 // Lista preparada para guardar detalles del carrito en el ticket.
 // Actualmente no se llena; el ticket muestra principalmente los totales.
 java.util.List<String[]> itemsCarrito = new java.util.ArrayList<>();        
 
// Crear ventana del ticket
        
JDialog ticket = new JDialog(this, "Ticket de Venta", true);
ticket.setSize(400, 500);
ticket.setLocationRelativeTo(this);

// Construir el texto del ticket
StringBuilder sb = new StringBuilder();
sb.append("================================\n");
sb.append("        VINIL'S HOUSE\n");
sb.append("================================\n\n");

for (String[] item : itemsCarrito) {
    // Cada arreglo representa: producto, artista, cantidad, precio y total.
    sb.append(item[0]).append(" - ").append(item[1]).append("\n");
    sb.append("  ").append(item[2]).append(" x $").append(item[3])
      .append("  =  $").append(item[4]).append("\n\n");
}

sb.append("--------------------------------\n");
sb.append("Subtotal: $").append(String.format("%.2f", subtotal)).append("\n");
sb.append("IVA:      $").append(String.format("%.2f", iva)).append("\n");
sb.append("TOTAL:    $").append(String.format("%.2f", totalFinal)).append("\n");
sb.append("================================\n");
sb.append("     ¡Gracias por tu compra!\n");
sb.append("================================");

// Mostrar ticket
javax.swing.JTextArea area = new javax.swing.JTextArea(sb.toString());
area.setEditable(false);
area.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 13));
ticket.add(new javax.swing.JScrollPane(area));
ticket.setVisible(true);

    }//GEN-LAST:event_btnComprarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// Cierra la sesion actual y regresa a la ventana de Login.
Login login = new Login();
login.setVisible(true);
this.dispose();    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        // TODO add your handling code here:
        
            CrudVentas Crudventas = new CrudVentas();
            Crudventas.setVisible(true);
                this.dispose();
            
    }//GEN-LAST:event_btnVentasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Principal().setVisible(true));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
