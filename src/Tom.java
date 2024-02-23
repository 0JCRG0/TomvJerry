import java.util.Random;

public class Tom extends Combatiente{

	Random rand;
	public Tom() {
		
		this.name = "Tom";
		rand = new Random();
	}
	
	@Override
	public Decision comienza() {
		
		Decision[] opciones = Decision.values();
		int indiceAleatorio = rand.nextInt(opciones.length);

		decision = opciones[indiceAleatorio];//debe guardar la decision tomada	    		
		return decision;
	}

	@Override
	public Decision mover(Decision resultadoAnterior) {
		
		Decision[] opciones = Decision.values();
		int indiceAleatorio = rand.nextInt(opciones.length);

		decision = opciones[indiceAleatorio];//debe guardar la decision tomada	    		
		return decision;
	}

}
