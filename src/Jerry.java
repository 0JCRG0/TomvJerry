import java.util.Random;

public class Jerry extends Combatiente{
	
	Random rand;
	
	public Jerry() {
		name = "Jerry";
		rand = new Random(System.nanoTime());				
	}
	
	public Decision comienza() {
		
		Decision[] opciones = Decision.values();
		int indiceAleatorio = rand.nextInt(opciones.length);

		decision = opciones[indiceAleatorio];//debe guardar la decision tomada	    		
		return decision;
	}

	public Decision mover(Decision resultadoAnterior) {
		
		Decision[] opciones = Decision.values();
		int indiceAleatorio = rand.nextInt(opciones.length);

		decision = opciones[indiceAleatorio];//debe guardar la decision tomada	    		
		return decision;
	}

	
}
