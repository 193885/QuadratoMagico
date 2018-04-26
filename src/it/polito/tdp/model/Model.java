package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	List <Quadrato> soluzione;

	public List<Quadrato> findMagicSquare(int n) {

		soluzione = new ArrayList<Quadrato>();
		
		int step=0;
		
		Quadrato parziale = new Quadrato(n);
		
		recursive (step, parziale, n);
	
		return soluzione;
	}
	
	
	private void recursive(int step, Quadrato parziale, int dim) {
				
		if(step >= dim*dim) {
			
			//soluzione completa
			
			if(parziale.isValid()) {
				
				//devo salvare la soluzione completa
				
				soluzione.add(new Quadrato(parziale));
			}	
		}
		
		for (int i = 1 ; i <= dim*dim ; i++) {
			
			if (!parziale.contains(i)) {
			
			parziale.add(i);
			
			recursive (step+1, parziale, dim);
						
			parziale.remove(i);
			
			}
		}
	}
}
