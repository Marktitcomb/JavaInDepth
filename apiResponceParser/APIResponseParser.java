public class APIResponseParser {
    
     /**
	 * Parses the input text and returns a Book instance containing
	 * the parsed data. 
	 * @param response text to be parsed
	 * @return Book instance containing parsed data
	 */
     public static Book parse(String response) {
		
        Book book = new Book();
		char endRule = '<';
		
		String startRule = "<title>";		
		String title = parse(response, startRule, endRule);
	    book.setTitle(title);
		
		startRule = "<name>";		
		String author = parse(response, startRule, endRule); 
	    book.setAuthor(author);
		
		startRule = "<original_publication_year type=\"integer\">";		
		int publicationYear = Integer.parseInt(parse(response, startRule, endRule)); 
	    book.setPublicationYear(publicationYear);
		
		startRule = "<average_rating>";		
		double averageRating = Double.parseDouble(parse(response, startRule, endRule)); 
	    book.setAvgRating(averageRating);
		
		//ratnigns counts
		startRule = "<ratings_count type=\"integer\">";		
		int ratingsCount = Integer.parseInt(parse(response, startRule, endRule).replaceAll(",","")); 
	    book.setRatingCount(ratingsCount);
		
		//URL
		startRule = "<image_url>";		
		String imageUrl = parse(response, startRule, endRule); 
	    book.setImageUrl(imageUrl);
		
		
	    
	    // then maybe put new start and end rules for each part you need
	    
		
		// Your code
		return book;
     }
     
     private static String parse(String response, String startRule, char endRule){
		 StringBuilder field = new StringBuilder();
		 int startLocation = response.indexOf(startRule) + startRule.length();
		
		 
		 while(response.charAt(startLocation) != endRule){
			 field.append(response.charAt(startLocation));
			 startLocation +=1;	 
		 }
		 
		 
	
		 return field.toString();
         
         
     }
     // then the next part is the oarse overloaded functions which takes in 3 parameters
     // write overloaded parse method with the 3 parameters response, startRule, endRule
     // so you find the start of it uses the start rules take the strong inside until you find the end rule 
     
     public static void main(String[] args) {
		String response = "<work>" + 
	                            "<id type=\"integer\">2361393</id>" +
	                            "<books_count type=\"integer\">813</books_count>" +
	                            "<ratings_count type=\"integer\">1,16,315</ratings_count>" + 
	                            "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
	                            "<original_publication_year type=\"integer\">1854</original_publication_year>" +
								"<original_publication_month type=\"integer\" nil=\"true\"/>" +
								"<original_publication_day type=\"integer\" nil=\"true\"/>" +
								"<average_rating>3.79</average_rating>" +
								"<best_book type=\"Book\">" +
									"<id type=\"integer\">16902</id>" +
									"<title>Walden</title>" + 
									"<author>" +
										"<id type=\"integer\">10264</id>" + 
										"<name>Henry David Thoreau</name>" + 
									"</author>" +
									"<image_url>" + 
										"http://images.gr-assets.com/books/1465675526m/16902.jpg" +
									"</image_url>" +
									"<small_image_url>" + 
										"http://images.gr-assets.com/books/1465675526s/16902.jpg" +
									"</small_image_url>" +
								"</best_book>" +
							"</work>";
		
		Book book = APIResponseParser.parse(response);
		
		//System.out.println(book.getAuthor());
		//System.out.println(book.getTitle());
		//System.out.println(book.getAvgRating());
		//System.out.println(book.getRatingCount());
		//System.out.println(book.getPublicationYear());
		//System.out.println(book.getImageUrl());
	}
}