package mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import mapa.cuadro.Cuadro;

public class MapaCargado extends Mapa {

	private int[] pixeles;

	public MapaCargado(String ruta) {
		super(ruta);
	}

	protected void cargarMapa(String ruta) {
		try {
			BufferedImage imagen = ImageIO.read(MapaCargado.class.getResource(ruta));

			ancho = imagen.getWidth();
			alto = imagen.getHeight();

			cuadrosCatalogo = new Cuadro[ancho * alto];
			pixeles = new int[ancho * alto];

			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void generarMapa() {
		for (int i = 0; i < pixeles.length; i++) {
			switch (pixeles[i]) {
				case 0xff2f2f2f :
					cuadrosCatalogo[i] = Cuadro.ASFALTO;
					continue;
				case 0xfffff3c3 :
					cuadrosCatalogo[i] = Cuadro.ARENA;
					continue;
				case 0xffbda43e :
					cuadrosCatalogo[i] = Cuadro.BORDE_CARRETERA_IZQUIERDO;
					continue;
				case 0xfff5ce2d :
					cuadrosCatalogo[i] = Cuadro.BORDE_CARRETERA_DERECHO;
					continue;
				case 0xfff9cb09 :
					cuadrosCatalogo[i] = Cuadro.BORDE_CARRETERA_INFERIOR;
					continue;
				case 0xfff9db5c :
					cuadrosCatalogo[i] = Cuadro.BORDE_CARRETERA_SUPERIOR;
					continue;
				case 0xffbfbfbf :
					cuadrosCatalogo[i] = Cuadro.CENTRO_CARRETERA_VERTICAL;
					continue;
				case 0xff94bab7 :
					cuadrosCatalogo[i] = Cuadro.CENTRO_CARRETERA_HORIZONTAL;
					continue;
				case 0xff8f8f8f :
					cuadrosCatalogo[i] = Cuadro.ESQUINA_CARRETERA_INFERIOR_IZQUIERDA;
					continue;
				case 0xffc02a2a :
					cuadrosCatalogo[i] = Cuadro.ESQUINA_CARRETERA_INFERIOR_DERECHA;
					continue;
				case 0xff876565 :
					cuadrosCatalogo[i] = Cuadro.ESQUINA_CARRETERA_SUPERIOR_IZQUIERDA;
					continue;
				case 0xffc74545 :
					cuadrosCatalogo[i] = Cuadro.ESQUINA_CARRETERA_SUPERIOR_DERECHA;
					continue;
				case 0xff434343 :
					cuadrosCatalogo[i] = Cuadro.PARED_PIEDRA;
					continue;
				case 0xff3c3322 :
					cuadrosCatalogo[i] = Cuadro.PARED_PIEDRA_INFERIOR;
					continue;
				case 0xff67593c :
					cuadrosCatalogo[i] = Cuadro.PARED_PIEDRA_CARRETERA;
					continue;
				case 0xffc39c49 :
					cuadrosCatalogo[i] = Cuadro.PARED_PIEDRA_CARRETERA_X_INVERTIDO;
					continue;
				case 0xff523f35 :
					cuadrosCatalogo[i] = Cuadro.PUERTA_INFERIOR;
					continue;
				case 0xff5f3722 :
					cuadrosCatalogo[i] = Cuadro.PUERTA_INTERMEDIA_IZQUIERDA;
					continue;
				case 0xff6b0505 :
					cuadrosCatalogo[i] = Cuadro.PUERTA_INTERMEDIA_DERECHA;
					continue;
				case 0xff602709 :
					cuadrosCatalogo[i] = Cuadro.PUERTA_SUPERIOR_IZQUIERDA;
					continue;
				case 0xffb41010 :
					cuadrosCatalogo[i] = Cuadro.PUERTA_SUPERIOR_DERECHA;
					continue;
				case 0xff3a1400 :
					cuadrosCatalogo[i] = Cuadro.PUERTA_SUPERIOR_CENTRAL;
					continue;
				case 0xff8f3100 :
					cuadrosCatalogo[i] = Cuadro.OXIDO;
					continue;
				default :
					cuadrosCatalogo[i] = Cuadro.VACIO;
			}
		}
	}

}
