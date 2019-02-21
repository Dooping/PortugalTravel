package portugal_travel;

public abstract class ReviewAbstractClass implements Review,Comparable<ReviewAbstractClass> {
	protected String user;
	protected int classification;
	protected String comment;
	protected int likes=0;
	
	public ReviewAbstractClass(String user, int classification, String comment) {
		this.user=user;
		this.classification=classification;
		this.comment=comment;
	}
	
	public String getUser() {
		return user;
	}
	
	public int getClassification() {
		return classification;
	}
	
	public String getComment() {
		return comment;
	}
	
	public String toString() {
		return user;
	}
	
	public boolean equals(Object o2) {			
		return toString().equals(o2.toString());
	}
	
	public void like(){
		likes++;
	}
	
	public int getLikes(){
		return likes;
	}
	
	public int compareTo(ReviewAbstractClass o1) {
		if (likes-o1.getLikes()==0) return toString().compareTo(o1.toString());
		else return o1.getLikes()-likes;
	}
}
