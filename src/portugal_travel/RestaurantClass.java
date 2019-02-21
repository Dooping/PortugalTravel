package portugal_travel;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class RestaurantClass extends ActivityAbstractClass implements Comparable<RestaurantClass> {
	
	private String type;
	private String classificationPrice;
	private LinkedList<ReviewRestaurantClass> reviews;
	
	public RestaurantClass(String author, String name, String address,
			String description, String type, String classificationPrice) {
		super(author, name, address, description);
		this.type = type;
		this.classificationPrice = classificationPrice;
		reviews = new LinkedList<ReviewRestaurantClass>();
	}
	
	@Override
	public int getClassification() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
	@Override
	public String getClassificationPrice() {
		// TODO Auto-generated method stub
		return classificationPrice;
	}

	@Override
	public void addReview(String user, int classification, String comment,
			int food, int ambience) {
		// TODO Auto-generated method stub
		ReviewRestaurantClass a = new ReviewRestaurantClass(user, classification, comment, food, ambience);
		if (!reviews.contains(a))
			reviews.add(a);
		else 
			reviews.get(reviews.indexOf(a)).overrideReview(user, classification, comment, food, ambience);
	}

	@Override
	public Iterator<ReviewRestaurantClass> listReviewsR() {
		// TODO Auto-generated method stub
		Collections.sort(reviews);
		return reviews.iterator();
	}

	@Override
	public Iterator<ReviewHotelClass> listReviewsH() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean likereview(String name) {
		// TODO Auto-generated method stub
		ReviewRestaurantClass a = new ReviewRestaurantClass(name, 0, name, 0, 0);
		if (reviews.contains(a))
			reviews.get(reviews.indexOf(a)).like();
		return reviews.contains(a);
	}

	@Override
	public int getNrReviews() {
		// TODO Auto-generated method stub
		return reviews.size();
	}

	@Override
	public int countReviews(int classification) {
		// TODO Auto-generated method stub
		Iterator<ReviewRestaurantClass> it = reviews.iterator();
		int count=0;
		while (it.hasNext())
			if (it.next().getClassification()==classification)
				count++;
		return count;
	}

	@Override
	public int reviewAverage(int type) {
		// TODO Auto-generated method stub
		Iterator<ReviewRestaurantClass> it = reviews.iterator();
		int count=0;
		while (it.hasNext())
			if (type==0) count += + it.next().getFood();
			else if (type==1) count += + it.next().getAmbience();
			else count += it.next().getClassification();

		if ((count%2==1) && (reviews.size()>1)) count++;
		if (getNrReviews()==0) return 0;
		else return count/getNrReviews();
	}

	@Override
	public int getLikes(String user) {
		// TODO Auto-generated method stub
		Iterator<ReviewRestaurantClass> it = reviews.iterator();
		while (it.hasNext()){
			ReviewRestaurantClass a = it.next();
			if (a.getUser().equals(user)) return a.getLikes();			
		}
		return 0;
	}
	
	public int compareTo(RestaurantClass o) {		
		int comp= o.reviewAverage(3)-this.reviewAverage(3);
		if (comp==0)
			return name.compareTo(o.getName());
		return comp;
	}
}
