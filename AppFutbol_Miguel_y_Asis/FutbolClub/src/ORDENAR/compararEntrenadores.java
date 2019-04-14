package ORDENAR;

import java.util.Comparator;

import COMUN.Constantes;
import LN.clsEntrenador;

public class compararEntrenadores implements Comparator<clsEntrenador> {
	
	
	
	@Override
	public int compare(clsEntrenador p1, clsEntrenador p2) { // Compara y ordena de menor a mayor
		
		Integer obj1 = (Integer) p1.getObjectProperty(Constantes.ID);
		Integer obj2 = (Integer) p2.getObjectProperty(Constantes.ID);
		
		return ( obj1 - obj2);
		
	}
}
