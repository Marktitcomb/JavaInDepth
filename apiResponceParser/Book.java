public class Book {		
        private String title;
		private String author;
		private int publicationYear;
		private double averageRating;
		private int ratingsCount;
		private String imageUrl;
		
		// Add getters & setters for author, averageRating, and ratingsCount
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
		public void setAuthor(String author){
			this.author = author;
		}
		
		public String getAuthor(){
			return author;
		}
		
		public void setAvgRating(double averageRating){
			this.averageRating = averageRating;
		}
		
		public double getAvgRating(){
			return averageRating;
		}
		
		public void setRatingCount(int ratingsCount){
			this.ratingsCount = ratingsCount;
		}
		
		public int getRatingCount(){
			return ratingsCount;
		}
		
		
		public int getPublicationYear() {
			return publicationYear;
		}
		public void setPublicationYear(int publicationYear) {
			this.publicationYear = publicationYear;
		}
		
		public String getImageUrl() {
			return imageUrl;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
	}