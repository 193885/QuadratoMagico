package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class Quadrato {
	
	private int dimensione;
	private int magic;
	
	private List <Integer> matrice;

	public Quadrato(Quadrato other) {
		
		dimensione = other.dimensione;
		magic = other.magic;
		matrice = new ArrayList<Integer>(other.matrice);
		
	}

	public Quadrato(int n) {
		
		dimensione = n;
		magic = n*(n*n+1)/2;
		matrice = new ArrayList<Integer>();
	}
	
	public boolean isValid() {
		
		return checkRows() & checkColumns() & checkDiagonals();
		
	}
	
	private boolean checkColumns() {
		
		for (int j=0 ; j< dimensione ; j++){
			
			int somma=0;
			
			for ( int i = 0; i < dimensione ; i++) 
				
				somma += matrice.get(i*dimensione+j);
		
		
		if(somma!= magic)
			
			return false;
		}
		
		return true;
	}

	private boolean checkDiagonals() {
		
		return checkMainDiagonal() & checkSecondaryDiagonal();
	}

	private boolean checkSecondaryDiagonal() {

		int somma=0;
		
		for ( int i=0; i <dimensione ; i++ ) {
			somma+= matrice.get(i*dimensione+dimensione-1-i);
		}
		
		if(somma!= magic)
			
			return false;
		
		else 
			return true;
	}

	private boolean checkMainDiagonal() {
		
		int somma=0;
		
		for ( int i=0; i <dimensione ; i++ ) {
			somma+= matrice.get(i*dimensione+i);
		}
		
		if(somma!= magic)
			
			return false;
		
		else 
			return true;
	}

	private boolean checkRows() {

		for ( int i = 0; i < dimensione ; i++) {
			
			int somma=0;
			
			for (int j=0 ; j< dimensione ; j++)
				
				somma += matrice.get(i*dimensione+j);
		
		
		if(somma!= magic)
			
			return false;
		}
		
		return true;
	}

	public boolean contains(int i) {
		
		return matrice.contains(i);
		
	}
	
	public void add(int i) {
		
		matrice.add(i);
	}
	
	public void remove(int i ) {
		
		matrice.remove(Integer.valueOf(i));
	}

	@Override
	public String toString() {
		return "Quadrato [matrice=" + matrice + "]";
	}
	
	

}
