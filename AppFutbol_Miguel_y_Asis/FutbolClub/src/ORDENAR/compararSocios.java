package ORDENAR;

import java.util.Comparator;

import COMUN.Constantes;
import LN.clsSocios;

public class compararSocios implements Comparator<clsSocios> {
	
	
	
	@Override
	public int compare(clsSocios p1, clsSocios p2) { // Compara y ordena de menor a mayor
		
		Integer obj1 = (Integer) p1.getObjectProperty(Constantes.ID);
		Integer obj2 = (Integer) p2.getObjectProperty(Constantes.ID);
		
		return ( obj1 - obj2);
		
	}
}
