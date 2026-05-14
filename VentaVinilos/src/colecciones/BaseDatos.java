/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import modelos.Producto;

/**
 *
 * @author jesusrosales
 */
public class BaseDatos {

    public static ArrayList<Producto>
    listaProductos = new ArrayList<>();

    public static HashMap<Integer, Producto>
    mapaProductos = new HashMap<>();

    public static HashSet<String>
    categorias = new HashSet<>();

    // METODO
    public static void agregarProducto(
        int id,
        String nombre,
        String artista,
        double precio,
        int stock
            
     
    ){

        Producto p = new Producto(
            id,
            nombre,
            artista,
            precio,
            stock
        );

        listaProductos.add(p);

        mapaProductos.put(id, p);
    }


    // PRODUCTOS PRECARGADOS
    static {

        agregarProducto(1,"DAMN","Kendrick Lamar",850,10);
        agregarProducto(2,"Graduation","Kanye West",950,5);
        agregarProducto(3, "To Pimp a Butterfly", "Kendrick Lamar", 1100, 8);
        agregarProducto(4, "good kid, m.A.A.d city", "Kendrick Lamar", 1050, 6);
        agregarProducto(5, "Astroworld", "Travis Scott", 980, 9);
        agregarProducto(6, "Rodeo", "Travis Scott", 920, 7);
        agregarProducto(7, "Utopia", "Travis Scott", 1200, 5);
        agregarProducto(8, "My Beautiful Dark Twisted Fantasy", "Kanye West", 1300, 6);
        agregarProducto(9, "The College Dropout", "Kanye West", 1000, 7);
        agregarProducto(10, "Late Registration", "Kanye West", 990, 5);
        agregarProducto(11, "808s & Heartbreak", "Kanye West", 950, 8);
        agregarProducto(12, "Yeezus", "Kanye West", 980, 7);
        agregarProducto(13, "Blonde", "Frank Ocean", 1500, 4);
        agregarProducto(14, "Channel Orange", "Frank Ocean", 1200, 6);
        agregarProducto(15, "IGOR", "Tyler, The Creator", 980, 8);
        agregarProducto(16, "Flower Boy", "Tyler, The Creator", 950, 9);
        agregarProducto(17, "Call Me If You Get Lost", "Tyler, The Creator", 1100, 5);
        agregarProducto(18, "The Eminem Show", "Eminem", 890, 10);
        agregarProducto(19, "Marshall Mathers LP", "Eminem", 950, 8);
        agregarProducto(20, "Recovery", "Eminem", 870, 7);
        agregarProducto(21, "Get Rich or Die Tryin", "50 Cent", 920, 6);
        agregarProducto(22, "Ready to Die", "The Notorious B.I.G.", 1150, 4);
        agregarProducto(23, "Illmatic", "Nas", 1250, 5);
        agregarProducto(24, "Enter the Wu-Tang", "Wu-Tang Clan", 990, 6);
        agregarProducto(25, "The Blueprint", "Jay-Z", 950, 7);
        agregarProducto(26, "Reasonable Doubt", "Jay-Z", 1200, 4);
        agregarProducto(27, "Take Care", "Drake", 980, 8);
        agregarProducto(28, "Nothing Was The Same", "Drake", 970, 7);
        agregarProducto(29, "Views", "Drake", 900, 9);
        agregarProducto(30, "2014 Forest Hills Drive", "J. Cole", 990, 8);
        agregarProducto(31, "The Off-Season", "J. Cole", 930, 6);
        agregarProducto(32, "Man on the Moon", "Kid Cudi", 980, 5);
        agregarProducto(33, "Currents", "Tame Impala", 1250, 6);
        agregarProducto(34, "The Slow Rush", "Tame Impala", 1180, 5);
        agregarProducto(35, "After Hours", "The Weeknd", 1100, 7);
        agregarProducto(36, "Starboy", "The Weeknd", 990, 8);
        agregarProducto(37, "Dawn FM", "The Weeknd", 1050, 6);
        agregarProducto(38, "Thriller", "Michael Jackson", 1500, 5);
        agregarProducto(39, "Bad", "Michael Jackson", 1300, 5);
        agregarProducto(40, "Purple Rain", "Prince", 1250, 4);
        agregarProducto(41, "Rumours", "Fleetwood Mac", 1350, 6);
        agregarProducto(42, "Back in Black", "AC/DC", 1200, 7);
        agregarProducto(43, "Abbey Road", "The Beatles", 1600, 5);
        agregarProducto(44, "Sgt. Pepper's Lonely Hearts Club Band", "The Beatles", 1650, 4);
        agregarProducto(45, "Nevermind", "Nirvana", 1200, 6);
        agregarProducto(46, "The Dark Side of the Moon", "Pink Floyd", 1700, 5);
        agregarProducto(47, "Wish You Were Here", "Pink Floyd", 1500, 5);
        agregarProducto(48, "Led Zeppelin IV", "Led Zeppelin", 1450, 4);
        agregarProducto(49, "Hotel California", "Eagles", 1300, 5);
        agregarProducto(50, "Random Access Memories", "Daft Punk", 1150, 6);
    }
}

