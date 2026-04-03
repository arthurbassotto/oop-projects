public class Fracao {
	
	//--------------------------------- ATRIBUTOS ----------------------------------
	
	private int numerador;
	private int denominador;
	private boolean sinal; // True = positivo ou zero, False = negativo
	
	//------------------------------- CONSTRUTORES ---------------------------------
	
	public Fracao(int numerador, int denominador) {
		
		if(denominador == 0) {
			throw new ArithmeticException("Divisão por zero");
		}

		this.numerador = numerador;
		this.denominador = denominador;

		// Condicao que atribui o sinal correto
		if(numerador < 0){
			if(denominador < 0) {
				this.sinal = true;
			} else {
				this.sinal = false;
			}
		} else {
			if(denominador < 0) {
				this.sinal = false;
			} else {
				this.sinal = true;
			}
		}
	}

	public Fracao(int numerador, int denominador, boolean sinal) {
		
		if(denominador == 0) {
			throw new ArithmeticException("Divisão por zero");
		}

		if(numerador < 0 || denominador < 0) {
			throw new IllegalArgumentException("Sinal especificado como parâmetro, forneca numerador e denominador positivos.");
		}

		this.numerador = numerador;
		this.denominador = denominador;
		this.sinal = sinal;
	}

	//------------------------------ OUTROS METODOS --------------------------------
	
	// Retorna o numerador
	public int getNumerador(){
		return this.numerador;
	}

	// Retorna o denominador
	public int getDenominador() {
		return this.denominador;
	}
	
	// Retorna o sinal
	public boolean getSinal() {
		return this.sinal;
	}

	// Formata a fracao em String
	public String toString() {

		// Condicao que elimina o denominador se for igual a 1
		if(this.denominador == 1){
			if(this.sinal == false){
				return "-" + this.numerador;
			} else {
				return String.format("%d", this.numerador);
			}
		
		} else {

			if(this.sinal == false){
				return this.numerador +"/"+ this.denominador;
			} else {
				return "-" + this.numerador + "/" + this.denominador;
			}
		}
	}

	// Realiza a divisao numerador/denominador e retorna o resultado do tipo double
	public double getValorNumerico() {

		double resultado = (double) this.numerador / (double) this.denominador;
		
		if(this.sinal == false) {
			return -1 * resultado;	
		} else {
			return resultado;
		}
	}

	// Simplifica a fracao e retorna o resultado
	public Fracao getFracaoIrredutivel() {

		// Calcula o MDC entre o numerador e o denominador
		int mdcNumeradorDenominador = Aritmetica.calcularMdc(this.numerador, this.denominador);

		// Se ja for irredutivel, retorna a propria fracao
		if(mdcNumeradorDenominador == 1){
			return this;
		}

		// Simplifica o numerador e o denominador
		int numeradorSimplificado = this.numerador / mdcNumeradorDenominador;
		int denominadorSimplificado = this.denominador / mdcNumeradorDenominador;

		Fracao fracaoIrredutivel = new Fracao(numeradorSimplificado, denominadorSimplificado, this.sinal);
		
		return fracaoIrredutivel;
	}

	public boolean equals(Fracao outra) {

		Fracao essaSimplificada = this.getFracaoIrredutivel();
		Fracao outraSimplificada = outra.getFracaoIrredutivel();

		if(essaSimplificada == outraSimplificada) {
			return true;
		} else {
			return false;
		}
	}
}
