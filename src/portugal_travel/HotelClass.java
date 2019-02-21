package portugal_travel;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HotelClass extends ActivityAbstractClass implements Comparable<HotelClass> {
	private int classification;
	private int price;
	private List<ReviewHotelClass> reviews;
	
	public HotelClass(String author, String name, String address,
			String description, int classification, int price) {
		super(author, name, address, description);
		this.classification = classification;
		this.price = price;
		reviews = new LinkedList<ReviewHotelClass>();
	}
	
	@Override
	public int getClassification() {
		// TODO Auto-generated method stub
		return classification;
	}
	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getClassificationPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addReview(String user, int classification, String comment, int service, int location) {
		// TODO Auto-generated method stub
		ReviewHotelClass a = new ReviewHotelClass(user, classification, comment, service, location);
		if (!reviews.contains(a))
			reviews.add(a);
		else 
			reviews.get(reviews.indexOf(a)).overrideReview(user, classification, comment, service, location);
	}

	@Override
	public Iterator<ReviewRestaurantClass> listReviewsR() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<ReviewHotelClass> listReviewsH() {
		// TODO Auto-generated method stub
		Collections.sort(reviews);
		return reviews.iterator();
	}

	@Override
	public boolean likereview(String name) {
		// TODO Auto-generated method stub
		ReviewHotelClass a = new ReviewHotelClass(name, 0, name, 0, 0);
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
		Iterator<ReviewHotelClass> it = reviews.iterator();
		int count=0;
		while (it.hasNext())
			if (it.next().getClassification()==classification)
				count++;
		return count;
	}

	@Override
	public int reviewAverage(int type) {
		// TODO Auto-generated method stub
		Iterator<ReviewHotelClass> it = reviews.iterator();
		int count=0;
		while (it.hasNext())
			if (type==0) count += it.next().getService();
			else if (type==1) count += it.next().getLocation();
			else count += it.next().getClassification();
		
		if ((count%2==1) && (reviews.size()>1)) count++;
		if (getNrReviews()==0) return 0;
		else return count/getNrReviews();
	}

	@Override
	public int getLikes(String user) {
		// TODO Auto-generated method stub		
		Iterator<ReviewHotelClass> it = reviews.iterator();
		if (it!=null)
			while (it.hasNext()){
				ReviewHotelClass a = it.next();
				if (a.getUser().equals(user)) return a.getLikes();			
			}
		return 0;
	}

	public int compareTo(HotelClass o) {
		int comp= o.reviewAverage(3)-this.reviewAverage(3);
		if (comp==0)
			return name.compareTo(o.getName());
		return comp;
	}
}
