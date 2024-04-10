public class Card {
   private final String face;
   private final String suit;

   public String getFace() {
      return face;
   }
   
   public static String[] getFaces(Card[] hand) {
      String[] allFaces = new String[hand.length];
      for (int i = 0; i < allFaces.length; i++) {
         allFaces[i] = hand[i].getFace();
      }
      
      return allFaces;
   }

   public String getSuit() {
      return suit;
   }
   
   public static String[] getSuits(Card[] hand) {
      String[] allFaces = new String[hand.length];
      for (int i = 0; i < allFaces.length; i++) {
         allFaces[i] = hand[i].getSuit();
      }
      
      return allFaces;
   }

   public Card(String face, String suit) {
      this.face = face;
      this.suit = suit; 
   }

   public String toString() { 
      return face + " de " + suit;
   } 
}