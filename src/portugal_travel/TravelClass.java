package portugal_travel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class TravelClass implements Travel{
	private Map<String, HashMap<String, RestaurantClass>> restaurants;
	private Map<String, HashMap<String, HotelClass>> hotels;
	private Map<String, User> users;
	private User logged=null;
	private int author= 0 ;
	private int advisor = 0;
	
	public TravelClass(){
		hotels = new HashMap<String, HashMap<String, HotelClass>>();
		restaurants = new HashMap<String, HashMap<String, RestaurantClass>>();
		users = new HashMap<String, User>();
	}
	
	@Override
	public int userType(String name) {
		// TODO Auto-generated method stub
		User u = users.get(name);		
		if (u!=null)
			return u.getType();
		return 1;
	}
	@Override
	public Iterator<HotelClass> listAllHotels(String city) {
		// TODO Auto-generated method stub
		if (hotels.get(city)==null) return null;
		Collection<HotelClass> c = hotels.get(city).values();
		List<HotelClass> s = new LinkedList<HotelClass>(c);
		Collections.sort(s);
		return s.iterator();
	}
	@Override
	public Iterator<RestaurantClass> listAllRestaurants(String city) {
		// TODO Auto-generated method stub
		if (restaurants.get(city)==null) return null;
		Collection<RestaurantClass> c = restaurants.get(city).values();
		List<RestaurantClass> s = new LinkedList<RestaurantClass>(c);
		Collections.sort(s);
		return s.iterator();
	}
	@Override
	public RestaurantClass getRestaurant(String name, String city) {
		// TODO Auto-generated method stub
		if (restaurants.get(city)==null) return null;
		Collection<RestaurantClass> c = restaurants.get(city).values();
		List<RestaurantClass> s = new LinkedList<RestaurantClass>(c);
	
		Iterator <RestaurantClass> it = s.iterator();
		RestaurantClass a;
		while (it.hasNext()){
			a = it.next();
			if (a.getName().equals(name)) return a;
		
		}
		return null;
	}
	@Override
	public HotelClass getHotel(String name, String city) {
		// TODO Auto-generated method stub
		if (hotels.get(city)==null) return null;
		Collection<HotelClass> c = hotels.get(city).values();
		List<HotelClass> s = new LinkedList<HotelClass>(c);
		
		Iterator <HotelClass> it = s.iterator();
		HotelClass a;
		while (it.hasNext()){
			 a = it.next();
			if (a.getName().equals(name)) return a;
			
		}
		return null;
	}
	@Override
	public Iterator<ReviewHotelClass> listHotelReviews(HotelClass hotel) {
		// TODO Auto-generated method stub
		return hotel.listReviewsH();
	}
	@Override
	public Iterator<ReviewRestaurantClass> listRestaurantReviews(
			RestaurantClass restaurant) {
		// TODO Auto-generated method stub
		return restaurant.listReviewsR();
	}
	@Override
	public boolean likeReview(String username, Activity activity) {
		// TODO Auto-generated method stub
		return activity.likereview(username);
	}
	@Override
	public String registeruser(int type, String username, String name,
			String address, String email) {
		// TODO Auto-generated method stub
		int password;
		if (type==3) password = ++this.author;
		else password = ++this.advisor;
		User a = new UserClass(username, name, address, email, type, password);
		users.put(username,a);
		if (type==3) return "author"+password;
		else return "advisor"+password;
	}
	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		User u = users.get(username);
		if (u!=null)
			if (u.login(password)){
				logged = u;
				return true;
			}
		return false;
	}
	@Override
	public int logged(String username) {
		// TODO Auto-generated method stub
		if (logged==null) return 0;
		else if (logged.toString().equals(username))return 2;		
		else return 1;
	}
	
	public String logged(){
		if(logged!=null) return logged.toString();
		else return null;
	}
	@Override
	public String logout() {
		// TODO Auto-generated method stub
		String result;
		if (logged!=null) {
			result=logged.toString();
			logged=null;
			return result;
		}
		else return null;
	}
	@Override
	public void doHotelReview(String user, HotelClass hotel,
			int classification, String comment, int service,
			int location) {
		// TODO Auto-generated method stub
		hotel.addReview(user, classification, comment, service, location);
	}
	@Override
	public void doRestaurantReview(String user, RestaurantClass restaurant,
			int classification, String comment, int food, int ambience) {
		// TODO Auto-generated method stub
		restaurant.addReview(user, classification, comment, food, ambience);
	}
	@Override
	public void addHotel(String author, String city, String name, String description,
			String address, int classification, int price) {
		// TODO Auto-generated method stub
		HotelClass a = new HotelClass(author, name, address, description, classification, price);
		HashMap<String, HotelClass> s = hotels.get(city);
		if(s==null) {
			s=new HashMap<String, HotelClass>();
			hotels.put(city, s);
		}
		s.put(name, a);		
	}
	@Override
	public void addRestaurant(String author, String city, String name, String description,
			String address, String type, String classification) {
		// TODO Auto-generated method stub
		RestaurantClass a = new RestaurantClass(author, name, address, description, type, classification);
		HashMap<String, RestaurantClass> s = restaurants.get(city);
		if(s==null) {
			s=new HashMap<String, RestaurantClass>();
			restaurants.put(city, s);
		}
		s.put(name, a);
		
	}
	@Override
	public Iterator<HotelClass> listHotelsByClass(String city, int classif) {
		// TODO Auto-generated method stub
		Iterator<HotelClass> it = listAllHotels(city);
		if (it==null) return null;
		SortedSet<HotelClass> s = new TreeSet<HotelClass>();
		while(it.hasNext()){
			HotelClass a = it.next();
			if (a.getClassification()==classif)
				s.add(a);
		}
		if (s.size()>0) return s.iterator();
		else return null;
	}
	@Override
	public Iterator<HotelClass> listHotelsByPrice(String city, int price) {
		// TODO Auto-generated method stub
		Iterator<HotelClass> it = listAllHotels(city);
		if (it==null) return null;
		SortedSet<HotelClass> s = new TreeSet<HotelClass>();
		while(it.hasNext()){
			HotelClass a = it.next();
			if (a.getPrice()<=price)
				s.add(a);
		}
		if (s.size()>0) return s.iterator();
		else return null;
	}
	@Override
	public Iterator<RestaurantClass> listRestaurantsByType(String city,
			String type) {
		// TODO Auto-generated method stub
		Iterator<RestaurantClass> it = listAllRestaurants(city);
		if (it==null) return null;
		SortedSet<RestaurantClass> s = new TreeSet<RestaurantClass>();
		while(it.hasNext()){
			RestaurantClass a = it.next();
			if (a.getType().equals(type))
				s.add(a);
		}
		if (s.size()>0) return s.iterator();
		else return null;
	}
	@Override
	public Iterator<RestaurantClass> listRestaurantsByPrice(String city,
			String price) {
		// TODO Auto-generated method stub
		Iterator<RestaurantClass> it = listAllRestaurants(city);
		if (it==null) return null;
		SortedSet<RestaurantClass> s = new TreeSet<RestaurantClass>();
		while(it.hasNext()){
			RestaurantClass a = it.next();
			if (a.getClassificationPrice().equals(price))
				s.add(a);
		}
		if (s.size()>0) return s.iterator();
		else return null;
	}

}
