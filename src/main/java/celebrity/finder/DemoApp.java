package celebrity.finder;

public class DemoApp {
    public static void main (String [] args) {
       
       int party[][] = Data.fromClass();
        
       CelebrityFinder celebrityFinder = new FinderAlgorithm();
       celebrityFinder.setParty(party);
       int result = celebrityFinder.find(); 
       if (result == -1){ 
          System.out.println("No Celebrity"); 
      }else {
          System.out.println("Celebrity ID " +  
                                      result);
      }

   }
}
