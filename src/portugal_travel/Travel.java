package portugal_travel;
import java.util.Iterator;

/**
 * PortugalTravel
 * @author David Gago 41361
 */	
public interface Travel {
	
	/**
	 * Metodo para encontrar o tipo de um utilizador.
	 * @param name - nome do utilizador
	 * @return 1 - nao registado, 2 - Advisor, 3 - Author
	 */
	public int userType(String name);
	
	/**
	 * Procura os hoteis de uma cidade e ordena-os.
	 * @param city - cidade da procura
	 * @return iterador com os hoteis
	 */
	public Iterator<HotelClass> listAllHotels(String city);
	
	/**
	 * Procura os hoteis com a classificacao pedida numa cidade.
	 * @param city - cidade da procura
	 * @param classif - classificacao escolhida
	 * @return iterador com os resultados da procura
	 */
	public Iterator<HotelClass> listHotelsByClass(String city, int classif);
	
	/**
	 * Procura os hoteis com preco por noite menor que o pedido.
	 * @param city - cidade da procura
	 * @param price - preco medio por noite maximo
	 * @return iterador com os resultados da procura
	 */
	public Iterator<HotelClass> listHotelsByPrice(String city, int price);
	
	/**
	 * Procura todos os restaurantes de uma cidade e ordena-os
	 * @param city - cidade da procura
	 * @return iterador com os resultados da procura
	 */
	public Iterator<RestaurantClass> listAllRestaurants(String city);
	
	/**
	 * Procura todos os restaurantes de um tipo numa cidade
	 * @param city - cidade da procura
	 * @param type - tipo de cozinha do restaurante
	 * @return iterador com os resultados da procura
	 */
	public Iterator<RestaurantClass> listRestaurantsByType(String city, String type);
	
	/**
	 * Procura todos os restaurantes de uma classificacao de preco numa cidade
	 * @param city - cidade da procura
	 * @param price - classificacao do preco
	 * @return iterador com os resultados da procura
	 */
	public Iterator<RestaurantClass> listRestaurantsByPrice(String city, String price);
	
	/**
	 * Procura um restaurante e devolve-o
	 * @param name - nome do restaurante
	 * @param city - cidade da procura
	 * @return a estrutura com o restaurante
	 */
	public RestaurantClass getRestaurant(String name, String city);
	
	/**
	 * Procura um hotel e devolve-o
	 * @param name - nome do hotel
	 * @param city - cidade da procura
	 * @return a estrutura com o hotel
	 */
	public HotelClass getHotel(String name, String city);
	
	/**
	 * Retorna a lista de reviews de um hotel
	 * @param hotel - estrutura com o hotel
	 * @return iterador com as reviews
	 */
	public Iterator<ReviewHotelClass> listHotelReviews(HotelClass hotel);
	
	/**
	 * Retorna a lista de reviews de um restaurante
	 * @param restaurant - estrutura com o restaurante
	 * @return iterador com as reviews
	 */
	public Iterator<ReviewRestaurantClass> listRestaurantReviews(RestaurantClass restaurant);
	
	/**
	 * Adiciona um like numa review
	 * @pre activity != null
	 * @param username - nome do utilizador que fez a review
	 * @param activity - estrutura em que esta a review
	 * @return True - a review existe, False - a review nao existe
	 */
	public boolean likeReview(String username, Activity activity);
	
	/**
	 * Regista um novo utilizador
	 * @pre username nao existe 
	 * @param type - 3 Author, 2 Advisor
	 * @param username - nome usado para fazer login
	 * @param name - nome do utilizador
	 * @param address - endereco do utilizador
	 * @param email - email do utilizador
	 * @return password gerada para o utilizador
	 */
	public String registeruser(int type, String username, String name, String address, String email);
	
	/**
	 * Tenta fazer login
	 * @pre nenhum utilizador logado
	 * @param username
	 * @param password
	 * @return True - login bem sucedido, False - password errada
	 */
	public boolean login(String username, String password);
	
	/**
	 * Verifica se o utilizador ja esta logado
	 * @param username - utilizador a ser testado
	 * @return 0 - nenhum utilizador logado, 1 - outro utilizador logado, 2 - utilizador logado
	 */
	public int logged(String username);
	
	/**
	 * Metodo para retornar o username do utilizador logado
	 * @return username ou null caso nao haja utilizador logado
	 */
	public String logged();
	
	/**
	 * Faz logout ao utilizador que esteja ligado
	 * @return username do utilizador que estava ligado, null caso nao haja nenhum
	 */
	public String logout();
	
	/**
	 * Adiciona uma review a um hotel
	 * @param user - utilizador que fez a review
	 * @param hotel - hotel ao qual a review vai ser adicionada
	 * @param classification - classificacao geral do hotel
	 * @param comment - comentario
	 * @param service - nota da qualidade de servico
	 * @param location - nota da qualidade de localizacao
	 */
	public void doHotelReview(String user, HotelClass hotel, int classification, 
									String comment, int service, int location);
	
	/**
	 * Adiciona uma review a um restaurante
	 * @param user - utilizador que fez a review
	 * @param restaurant - restaurante ao qual a review vai ser adicionada
	 * @param classification - classificacao geral do restaurante
	 * @param comment - comentario
	 * @param food - nota da qualidade da comida
	 * @param ambience - nota da qualidade do ambiente
	 */
	public void doRestaurantReview(String user, RestaurantClass restaurant,
			int classification, String comment, int food, int ambience);
	
	/**
	 * Adiciona um hotel
	 * @pre getHotel == null
	 * @param author - utilizador que esta a adicionar o hotel
	 * @param city - cidade em que o hotel esta situado
	 * @param name - nome do hotel
	 * @param description - descricao
	 * @param address - morada
	 * @param classification - número de estrelas
	 * @param price - preco medio por noite
	 */
	public void addHotel(String author, String city, String name,String description
					, String address, int classification, int price);
	
	/**
	 * Adiciona um restaurante
	 * @pre getRestaurant == null
	 * @param author - utilizador que esta a adicionar o restaurante
	 * @param city - cidade em que o restaurante esta situado
	 * @param name - nome do restaurante
	 * @param description - descricao
	 * @param address - morada
	 * @param type - tipo de cozinha
	 * @param classification - classificacao em termos de preco
	 */
	public void addRestaurant(String author, String city, String name,String description
					, String address, String type, String classification);

}




