package portugal_travel;

/**
 * Um utilizador e os metodos necessarios para interaccao com este
 * @author David Gago 41361
 */
public interface User {
	
	/**
	* Retorna o nome do utilizador.
	* @return name
	*/
	public String getName();
	
	/**
	* Retorna o tipo de utilizador.
	* @return type
	*/
	public int getType();
	
	/**
	* Verifica se a password fornecida e a correcta.
	* @param password - String a comparar.
	* @return true - password correcta, false - password incorrecta
	*/
	public boolean login(String password);
	
	/**
	 * Override da funcao toString que retorna o username.
	 * @return username
	 */
	public String toString();
	
	/**
	 * Compara o proprio User com outro.
	 * @param o2 - User a comparar com este.
	 * @return Comparacao das strings username
	 */
	public int compareTo(User o2);

}
