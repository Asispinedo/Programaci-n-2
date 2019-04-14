package ORDENAR;

import java.util.Comparator;

import COMUN.Constantes;
import LN.clsJugadores;

public class compararJugadores implements Comparator<clsJugadores> {
	
	
	
	@Override
	public int compare(clsJugadores p1, clsJugadores p2) { // Compara y ordena de menor a mayor
		
		Integer obj1 = (Integer) p1.getObjectProperty(Constantes.ID);
		Integer obj2 = (Integer) p2.getObjectProperty(Constantes.ID);
		
		return ( obj1 - obj2);
		
	}
}
