package portugal_travel;

/**
 * Uma review e os metodos associados
 * @author David Gago 41361
 */
public interface Review {
	
	/**
	 * Retorna o nome do utilizador que fez a review.
	 * @return user
	 */
	public String getUser();
	
	/**
	 * Retorna a classificacao geral
	 * @return classification
	 */
	public int getClassification();
	
	/**
	 * Retorna o comentario
	 * @return comment
	 */
	public String getComment();
	
	/**
	 * Retorna a qualificaca da qualidade de servico
	 * @return service
	 */
	public int getService();
	
	/**
	 * Retorna a qualificacao da localizacao
	 * @return location
	 */
	public int getLocation();
	
	/**
	 * Retorna a qualificacao da qualidade da comida
	 * @return food
	 */
	public int getFood();
	
	/**
	 * Retorna a qualificacao do ambiente
	 * @return ambience
	 */
	public int getAmbience();
	
	/**
	 * Sobrepoe os dados de uma review
	 * @param user - nome do utilizador que fez a review
	 * @param classification - classificacao geral
	 * @param comment - comentario
	 * @param food - qualidade de sevico ou comida
	 * @param ambience - qualidade da localizacao ou ambiente
	 */
	public void overrideReview(String user, int classification, String comment, int food, int ambience);
	
	/**
	 * Adiciona um like 'a review.
	 */
	public void like();
	
	/**
	 * Retorna o numero de likes da review.
	 * @return likes
	 */
	public int getLikes();

}
