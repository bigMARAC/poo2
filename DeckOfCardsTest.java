public class DeckOfCardsTest {
   public static void main(String[] args) {
      DeckOfCards myDeckOfCards = new DeckOfCards();
      myDeckOfCards.shuffle();
      int hands = 1;
      
      Card[][] cards = myDeckOfCards.dealCard(hands);
      
      for (int i = 0; i < cards.length; i++) {
         System.out.println();
         
         String combinations = myDeckOfCards.getCombinations(cards[i]); 
         if (combinations != null) {
            System.out.println(combinations);
         }
         
         for (int j = 0; j < cards[i].length; j++) {
            System.out.println(cards[i][j]);
         }
         
         System.out.println();
      }
   } 
}