package principal;
import java.util.Scanner;

public class RetoEjercicio {

	static final String ENUNCIADO = "Ingrese su orden de pedido: ";
	static final String PREGUNTA = "Desea ingresar un nuevo pedido: (S / N)";
	static final String ERROR = "La orden ingresada no es correcta";
	public static int unidadMillar = 0, unidadCentena = 0, unidadDecena = 0, unidad = 0;
	public static String[][] numerosMarcianos = { { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
			{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXX", "XC" },
			{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
			{ "", "M", "MM", "MMM", "Mv", "v", "vM", "vMM", "vMMM", "Mx" } };
	private static Scanner scan;

	public static void main(String[] args) {
		System.out.print(ENUNCIADO);
		scan = new Scanner(System.in);
		String numero = scan.nextLine();
		Boolean op=true;
			RetoEjercicio.obtenerValorPedido(numero);
			System.out.print(PREGUNTA);
			
	}

	public static void obtenerValorPedido(String numero) {
		try { 
			RetoEjercicio.descomponerNumero(Integer.valueOf(numero));
			System.out.println(RetoEjercicio.obtenerNumeroMarciano());
		} catch (NumberFormatException e) {
			try { 
				System.out.println("Your order cost in human coins is : "+RetoEjercicio.transformarNumeroMarciano(numero.trim()));
			} catch (Exception e1) {
				System.out.println(ERROR);
			}
		} catch (Exception e) {
			System.out.println(ERROR);
		}

	}

	private static void descomponerNumero(int numero) {
		unidadMillar = (int) numero / 1000;
		unidadCentena = (int) numero % 1000 / 100;
		unidadDecena = (int) numero % 1000 % 100 / 10;
		unidad = (int) numero % 1000 % 100 % 10;
	}

	private static String obtenerNumeroMarciano() {
		return "Your order cost in Marcian coins is : " + numerosMarcianos[3][unidadMillar] + "" + numerosMarcianos[2][unidadCentena] + "" + numerosMarcianos[1][unidadDecena] + "" + numerosMarcianos[0][unidad]
				+ "";
	}

	private static String transformarNumeroMarciano(String numero) {
		int size = numero.length();
		String monedaTerrestre = "";
		for (int i = 3; i > -1; i--) {
			for (int j = size; j > -1; j--) {
				int valor = -1;
				valor = evaluar(numero.substring(0, j), i);
				if (valor > -1) {
					monedaTerrestre = monedaTerrestre + valor;
					numero = numero.substring(j, size);
					size = numero.length();
					break;
				}
			}
		}
		return monedaTerrestre;
	}

	private static int evaluar(String cadena, int orden) {
		for (int j = 9; j > -1; j--) {
			if (numerosMarcianos[orden][j].equals(cadena)) {
				return j;
			}
		}
		return -1;
	}
}
