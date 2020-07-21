import java.util.Arrays;

public class SentimentAnalyzer {
    // Tip: labeled continue can be used when iterating featureSet + convert review to lower-case
	public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords,
			String[] negOpinionWords) {
		int[] featureOpinions = new int[featureSet.length]; // output [0,1,0,0,1]
		review = review.toLowerCase();
		
		for(int i=0; i<featureSet.length; i++){
		    outerloop:for(String feature: featureSet[i]){
		        if(review.contains(feature)){
		             int featureOpinion = getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);
		             if(featureOpinion != 0){
		                featureOpinions[i] = featureOpinion;
		                break outerloop;
		             }
		             
		        }
		    }
		    
		}
		//so find if any of the features are subterms
        // your code ~ you will be invoking getOpinionOnFeature		
 
		return featureOpinions;
	}

	// First invoke checkForWasPhrasePattern and 
	// if it cannot find an opinion only then invoke checkForOpinionFirstPattern
	private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, 
	String[] negOpinionWords) {
	    //System.out.println(feature);
	    int opinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
	    
	    if(opinion == 0){
	        opinion = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
	    } 
	
		return opinion; 
		
	}	

	// Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
	// Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
	// You can first look for positive opinion. If not found, only then you can look for negative opinion
	private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
		int opinion = 0;
		String pattern = feature + " was ";
		int endPatternLocation = review.indexOf(pattern) + pattern.length(); 
		
		for(String positive: posOpinionWords){
		    int posLength = positive.length();
		    if(review.substring(endPatternLocation, endPatternLocation + posLength).equals(positive)){
				opinion = 1;
		        break; 
		    }
		}
		
		 if(opinion == 0){
		    for(String negative: negOpinionWords){
		        int negLength = negative.length();
		        if((review.substring(endPatternLocation, endPatternLocation + negLength)) == negative){
		            opinion = -1;
		            break; 
		        }
		    }
		}
		
		return opinion; 	
	
	}
	
	// You can first look for positive opinion. If not found, only then you can look for negative opinion
 	private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
 
 		String[] sentences = review.split("[,!?.@]");
 		int opinion = 0;
		int featureLength = feature.length();
		
		for(String sentence: sentences){
			int featureLocation = sentence.indexOf(feature);
			if(featureLocation == -1){continue;}

			for(String positive: posOpinionWords){
				int posLength = positive.length();
				if(sentence.substring(featureLocation - posLength -1, featureLocation-1).equals(positive)){
					return opinion = 1;
				}
			}
		
			for(String negative: negOpinionWords){
				int negLength = negative.length();
				if(sentence.substring(featureLocation - negLength -1, featureLocation-1).equals(negative)){
					return opinion = -1;
				}
			}
	    }
		
					

 		return opinion;
 	}

	public static void main(String[] args) {
		//String review = "Haven't been here in years. Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
		
		String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";
		
		String[][] featureSet = { 
		        { "ambiance", "ambience", "atmosphere", "decor" },
				{ "dessert", "ice cream", "desert" }, 
				{ "food" }, 
				{ "soup" },
				{ "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
		String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome",
				"delicious" };
		String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

		int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
		System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
	}
}