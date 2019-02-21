package portugal_travel;

import java.util.Iterator;

/**
 * Uma actividade. Hotel ou Restaurante
 * @author David Gago 41361
 */
public interface Activity {
	
	/**
	 * Retorna o nome da actividade.
	 * @return name
	 */
	public String getName();
	
	/**
	 * Retorna a morada da actividade.
	 * @return address
	 */
	public String getAddress();
	
	/**
	 * Retorna a descricao da actividade.
	 * @return description
	 */
	public String getDescription();
	
	/**
	 * Retorna o numero de estrelas do Hotel.
	 * @return classification
	 */
	public int getClassification();
	
	/**
	 * Retorna o preco medio por noite de um Hotel.
	 * @return price
	 */
	public int getPrice();
	
	/**
	 * Retorna o tipo de um Restaurante.
	 * @return type
	 */
	public String getType();
	
	/**
	 * Retorna a classificacao do Restaurante.
	 * @return classificationPrice
	 */
	public String getClassificationPrice();
	
	/**
	 * Adiciona uma review 'a actividade.
	 * @param user - utilizador que submeteu a review
	 * @param classification - classificacao geral
	 * @param comment - comentario sobre a actividade
	 * @param service - qualidade do servico ou da comida
	 * @param location - qualidade da localizacao ou ambiente
	 */
	public void addReview(String user, int classification, String comment, int service, int location);
	
	/**
	 * Retorna a lista de reviews dos restaurantes.
	 * @return Iterador
	 */
	public Iterator<ReviewRestaurantClass> listReviewsR();
	
	/**
	 * Retorna a lista de reviews dos hoteis.
	 * @return Iterador
	 */
	public Iterator<ReviewHotelClass> listReviewsH();
	
	/**
	 * Procura a review e acrescenta-lhe um like.
	 * @param name - nome do utilizador que fez a review
	 * @return True - a review existe, False - a review nao existe
	 */
	public boolean likereview(String name);
	
	/**
	 * Conta o numero de reviews da actividade.
	 * @return numero de reviews
	 */
	public int getNrReviews();
	
	/**
	 * Retorna o nome do utilizador que acrescentou a actividade.
	 * @return author
	 */
	public String getAuthor();
	
	/**
	 * Conta o numero de reviews de uma certa classificacao.
	 * @pre getNrReviews()>0
	 * @param classification de 1 a 5
	 * @return contagem
	 */
	public int countReviews(int classification);
	
	/**
	 * Media das reviews.
	 * @pre getNrReviews()>0
	 * @param type - servico/comida ou localizacao/ambiente
	 * @return media
	 */
	public int reviewAverage(int type);
	
	/**
	 * Procura uma review e retorna o numero de likes.
	 * @pre getNrReviews()>0
	 * @param user - autor da review
	 * @return numero de likes
	 */
	public int getLikes(String user);
}
