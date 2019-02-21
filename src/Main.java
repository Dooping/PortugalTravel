import java.util.Iterator;
import java.util.Scanner;
import portugal_travel.*;


/**
 * 
 * @author David Gago 41361
 *
 */
class Main {

	/**
	 * @param args
	 */
	public static final String EXIT = "EXIT";
	public static final String ALL = "ALL";
	public static final String HOTELS = "HOTELS";
	public static final String STARS = "STARS";
	public static final String PRICE = "PRICE";
	public static final String RESTAURANTS = "RESTAURANTS";
	public static final String CUISINE = "CUISINE";
	public static final String COST = "COST";
	public static final String REVIEWS = "REVIEWS";
	public static final String HOTEL = "HOTEL";
	public static final String RESTAURANT = "RESTAURANT";
	public static final String REGISTER = "REGISTER";
	public static final String AUTHOR = "AUTHOR";
	public static final String ADVISOR = "ADVISOR";
	public static final String LOGIN = "LOGIN";
	public static final String LOGOUT = "LOGOUT";
	public static final String REVIEW = "REVIEW";
	public static final String ADD = "ADD";
	public static final String LIKE = "LIKE";	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Travel travel = new TravelClass();
		String command;
		do {
			command = in.next();
			Interpretador(command, in, travel);
			System.out.println();
		} while (!command.equalsIgnoreCase(EXIT));
		in.close();
	}
	
	private static int grade2int(String grade){
		if (grade.equals("Excellent")) return 5;
		else if (grade.equals("Good")) return 4;
		else if (grade.equals("Average")) return 3;
		else if (grade.equals("Poor")) return 2;
		else if (grade.equals("Terrible")) return 1;
		else return 0;
	}
	
	private static String int2grade(int grade){
		if (grade==5) return "Excellent";
		else if (grade==4) return "Good";
		else if (grade==3) return "Average";
		else if (grade==2) return "Poor";
		else return "Terrible";
	}

	private static void Interpretador(String cmd, Scanner in, Travel travel) {
		// TODO Auto-generated method stub
		if (cmd.equalsIgnoreCase(HOTELS)){
			cmd=in.next();
			if (cmd.equalsIgnoreCase(ALL)){
				String city = in.next();
				Iterator<HotelClass> it = travel.listAllHotels(city);
				if (it!=null){
					System.out.printf("> All hotels in %s:\n",city);
					int i=1;
					while(it.hasNext()){
						HotelClass a = it.next();
						System.out.printf("> Ranked %s (%s reviews): %s | %s | %s\n"
								,i++,a.getNrReviews(),a.getName(),a.getClassification(),a.getPrice());
					}
				}
				else System.out.printf("> No registered hotels in %s.\n",city);
			}
			else if (cmd.equalsIgnoreCase(STARS)){
				String city = in.next();
				int stars = in.nextInt();
				Iterator<HotelClass> it = travel.listHotelsByClass(city, stars);
				if (it!=null){
					System.out.printf("> All hotels in %s with %s stars:\n",city,stars);
					int i=1;
					while(it.hasNext()){
						HotelClass a = it.next();
						System.out.printf("> Ranked %s (%s reviews): %s | %s | %s\n"
								,i++,a.getNrReviews(),a.getName(),a.getClassification(),a.getPrice());
					}
				}
				else System.out.printf("> No registered hotels in %s with %s stars.\n",city,stars);
			}
			else if (cmd.equalsIgnoreCase(PRICE)){
				String city = in.next();
				int price = in.nextInt();
				Iterator<HotelClass> it = travel.listHotelsByPrice(city, price);
				if (it!=null){
					System.out.printf("> All hotels in %s bellow %s:\n",city,price);
					int i=1;
					while(it.hasNext()){
						HotelClass a = it.next();
						System.out.printf("> Ranked %s (%s reviews): %s | %s | %s\n"
								,i++,a.getNrReviews(),a.getName(),a.getClassification(),a.getPrice());
					}
				}
				else System.out.printf("> No registered hotels in %s with price by night bellow %s.\n",city,price);
			}
		}
		else if (cmd.equalsIgnoreCase(RESTAURANTS)){
			cmd=in.next();
			if (cmd.equalsIgnoreCase(ALL)){
				String city = in.next();
				Iterator<RestaurantClass> it = travel.listAllRestaurants(city);
				if (it!=null){
					System.out.printf("> All restaurants in %s:\n",city);
					int i=1;
					while(it.hasNext()){
						RestaurantClass a = it.next();
						System.out.printf("> Ranked %s (%s reviews): %s | %s | %s\n"
								,i++,a.getNrReviews(),a.getName(),a.getType(),a.getClassificationPrice());
					}
				}
				else System.out.printf("> No registered restaurants in %s.\n",city);
			}
			else if (cmd.equalsIgnoreCase(CUISINE)){
				String city = in.next();
				String cuisine = in.next();
				Iterator<RestaurantClass> it = travel.listRestaurantsByType(city, cuisine);
				if (it!=null){
					System.out.printf("> All restaurants in %s with cuisine %s:\n",city, cuisine);
					int i=1;
					while(it.hasNext()){
						RestaurantClass a = it.next();
						System.out.printf("> Ranked %s (%s reviews): %s | %s | %s\n"
								,i++,a.getNrReviews(),a.getName(),a.getType(),a.getClassificationPrice());
					}
				}
				else System.out.printf("> No registered restaurants in %s with cuisine %s.\n",city,cuisine);
			}
			else if (cmd.equalsIgnoreCase(COST)){
				String city = in.next();
				String price = in.next();
				Iterator<RestaurantClass> it = travel.listRestaurantsByPrice(city, price);
				if (it!=null){
					System.out.printf("> All restaurants in %s within price range %s:\n",city, price);
					int i=1;
					while(it.hasNext()){
						RestaurantClass a = it.next();
						System.out.printf("> Ranked %s (%s reviews): %s | %s | %s\n"
								,i++,a.getNrReviews(),a.getName(),a.getType(),a.getClassificationPrice());
					}
				}
				else System.out.printf("> No registered restaurants in %s within price range %s.\n",city,price);
			}
		}
		else if (cmd.equalsIgnoreCase(REVIEWS)){
			cmd=in.next();
			if (cmd.equalsIgnoreCase(HOTEL)){
				String city = in.next();
				String hotel = in.next();
				HotelClass a = travel.getHotel(hotel, city);
				if (a != null) {
					Iterator<ReviewHotelClass> it = travel.listHotelReviews(a);
				//	if (it != null) {
					System.out.printf("> Reviews for hotel %s (by %s):\n> %s\n> %s\n> Overall review:\n",
								hotel, a.getAuthor(), a.getAddress(),a.getDescription());
					System.out.printf("> Excellent: %s\n> Good: %s\n> Average: %s\n> Poor: %s\n> Terrible: %s\n",
							a.countReviews(5), a.countReviews(4), a.countReviews(3), a.countReviews(2)
							, a.countReviews(1));
					System.out.printf("> Service review: %s\n> Location review: %s\n",
							int2grade(a.reviewAverage(0)), int2grade(a.reviewAverage(1)));
					if (it != null) {	
						while (it.hasNext()) {
							ReviewHotelClass b = it.next();
							System.out.printf("> Reviewer %s (%s likes): %s\n",
									b.getUser(), b.getLikes(), b.getComment());
						}
					}
				}
				else System.out.println("> Hotel does not exist.");
			}
			if (cmd.equalsIgnoreCase(RESTAURANT)){
				String city = in.next();
				String restaurant = in.next();
				RestaurantClass a = travel.getRestaurant(restaurant, city);
				if (a!=null){
					Iterator<ReviewRestaurantClass> it = travel.listRestaurantReviews(a);
				//	if (it!=null){
					System.out.printf("> Reviews for restaurant %s (by %s):\n> %s\n> %s\n> Overall review:\n",
							restaurant,a.getAuthor(), a.getAddress(),a.getDescription());
					System.out.printf("> Excellent: %s\n> Good: %s\n> Average: %s\n> Poor: %s\n> Terrible: %s\n",
							a.countReviews(5), a.countReviews(4), a.countReviews(3), a.countReviews(2)
							, a.countReviews(1));
					System.out.printf("> Food review: %s\n> Atmosphere review: %s\n",
							int2grade(a.reviewAverage(0)), int2grade(a.reviewAverage(1)));
					if (it != null) {
						while(it.hasNext()){
							ReviewRestaurantClass b = it.next();
							System.out.printf("> Reviewer %s (%s likes): %s\n",
								b.getUser(), b.getLikes(), b.getComment());
						}
					}
				}
				else System.out.println("> Restaurant does not exist.");
			}
		}
		if (cmd.equalsIgnoreCase(LIKE))
			if (in.next().equalsIgnoreCase(REVIEW)){
				String city = in.next();
				String name = in.next();
				String user = in.next();
				Activity a = travel.getHotel(name, city);
				if (a==null) a= travel.getRestaurant(name, city);
				if (a!=null) 
					if (travel.userType(user)>1)
						if(travel.likeReview(user, a))
							System.out.printf("> Number of likes for review %s by %s: %s.\n",
									name, user, a.getLikes(user));
						else System.out.printf("> User has not reviewed activity %s.\n",name);
					else System.out.println("> User does not exist.");
				else System.out.println("> Activity does not exist.");
		}
		if (cmd.equalsIgnoreCase(REGISTER)){
			cmd=in.next();
			String username = in.next();in.nextLine();
			String name = in.nextLine();
			String address = in.nextLine();
			String email = in.nextLine();
			if (cmd.equalsIgnoreCase(AUTHOR))
				if (travel.logged(username)==0)
					if (travel.userType(username)==1)
						System.out.printf("> User was registered: %s.\n",
								travel.registeruser(3, username, name, address, email));
					else System.out.println("> Username already registered.");				
				else System.out.println("> There is a user logged in.");
			else if (cmd.equalsIgnoreCase(ADVISOR))
				if (travel.logged(username)==0)
					if (travel.userType(username)==1)
						System.out.printf("> User was registered: %s.\n",
								travel.registeruser(2, username, name, address, email));
					else System.out.println("> Username already registered.");				
				else System.out.println("> There is a user logged in.");			
		}
		else if (cmd.equalsIgnoreCase(EXIT))
			System.out.println("> Exiting...");
		else if (cmd.equalsIgnoreCase(LOGIN)){
			String username = in.next();
			String password = in.next();
			if (travel.userType(username)>1){
				if (travel.logged(username)<2){
					if (travel.logged(username)==0){
						if (travel.login(username, password))
							System.out.printf("> Welcome %s.\n", username);
						else System.out.println("> Wrong password.");
					}
					else System.out.println("> Another user is logged in.");
				}
				else System.out.println("> User is already logged in.");
			}
			else System.out.println("> User does not exist.");
		}
		else if (cmd.equalsIgnoreCase(LOGOUT)){
			String name = travel.logout();
			if (name!=null) System.out.printf("> Goodbye %s.\n",name);
			else System.out.println("> No user is logged in.");
		}
		else if (cmd.equalsIgnoreCase(REVIEW)){
			cmd = in.next();
			String city = in.next();
			String name = in.next();in.nextLine();
			String grade = in.next();in.nextLine();
			String comment = in.nextLine();
			String sorf = in.next();in.nextLine();
			String lora = in.next();in.nextLine();
			if (cmd.equalsIgnoreCase(HOTEL)){
				if (travel.logged()!=null){
					HotelClass a = travel.getHotel(name, city);
					if (a!=null){
						travel.doHotelReview(travel.logged(), a, grade2int(grade),
								comment, grade2int(sorf), grade2int(lora));
						System.out.println("> Review was registered.");
					}
					else System.out.println("> Hotel does not exist.");
				}
				else System.out.println("> Login to add a review.");
			}
			else if (cmd.equalsIgnoreCase(RESTAURANT)){
				if (travel.logged()!=null){
					RestaurantClass a = travel.getRestaurant(name, city);
					if (a!=null){
						travel.doRestaurantReview(travel.logged(), a, grade2int(grade),
								comment, grade2int(sorf), grade2int(lora));
						System.out.println("> Review was registered.");
					}
					else System.out.println("> Restaurant does not exist.");
				}
				else System.out.println("> Login to add a review.");
			}
		}
		else if (cmd.equalsIgnoreCase(ADD)){
			cmd = in.next();
			String city = in.next();
			String name = in.next();in.nextLine();
			String description = in.nextLine();
			String address = in.nextLine();
			if (cmd.equalsIgnoreCase(HOTEL)){
				int classification = in.nextInt();
				int price = in.nextInt();
				if (travel.userType(travel.logged())==3)
					if ((travel.getHotel(name, city)==null) && (travel.getRestaurant(name, city)==null)){
						travel.addHotel(travel.logged(), city, name, description, address, classification, price);
						System.out.println("> Hotel was registered.");
					}
					else System.out.println("> Activity already exists.");
				else System.out.println("> Only Author users may add hotels.");
			}
			else if (cmd.equalsIgnoreCase(RESTAURANT)){
				String food = in.nextLine();
				String cost = in.nextLine();
				if (travel.userType(travel.logged())==3)
					if ((travel.getHotel(name, city)==null) && (travel.getRestaurant(name, city)==null)){
						travel.addRestaurant(travel.logged(), city, name, description, address, food, cost);
						System.out.println("> Restaurant was registered.");
					}
					else System.out.println("> Activity already exists.");
				else System.out.println("> Only Author users may add restaurants.");
			}
		}
	}

}
