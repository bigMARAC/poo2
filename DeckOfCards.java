import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DeckOfCards {
   private Card[] deck; 
   private int currentCard;
   private static final int NUMBER_OF_CARDS = 52;
   private static final SecureRandom randomNumbers = new SecureRandom();
   private final String[] faces = {"As", "Dois", "Três", "Quatro", "Cinco", "Seis", 
      "Sete", "Oito", "Nove", "Dez", "Valete", "Rainha", "Rei"};
   private final String[] suits = {"Copas", "Ouro", "Paus", "Espadas"};

   public DeckOfCards() {
      deck = new Card[NUMBER_OF_CARDS];
      currentCard = 0;

      for (int count = 0; count < deck.length; count++) 
         deck[count] = 
            new Card(faces[count % 13], suits[count / 13]);
   } 

   public void shuffle() {
      currentCard = 0; 

      for (int first = 0; first < deck.length; first++) {
         int second =  randomNumbers.nextInt(NUMBER_OF_CARDS);
         
         Card temp = deck[first];        
         deck[first] = deck[second];   
         deck[second] = temp;            
      } 
   } 

   public Card[][] dealCard(int hands) {
      Card[][] allHands = new Card[hands][NUMBER_OF_CARDS / hands];
      
      for (int i = 0; i < allHands.length; i++) {
         for (int j = 0; j < allHands[i].length; j++) {
            allHands[i][j] = currentCard < deck.length ? deck[currentCard++] : null;
         }
      }
      
      return allHands;
   }
   
   private Map<String, Integer> countRepetitions(String [] element) {
      Map<String, Integer> aux = new HashMap<String, Integer>();
      
      for (int i = 0; i < element.length; i++) {
         if (aux.get(element[i]) != null) {
            aux.put(element[i], aux.get(element[i]) + 1);
         } else {
            aux.put(element[i], 1);
         }
      }
      
      return aux;
   }
   
   public String getCombinations(Card[] hand) {
      String[] faces = Card.getFaces(hand);
      String[] suits = Card.getSuits(hand);
      Map<String, Integer> suitsAux = this.countRepetitions(suits);
      Map<String, Integer> facesAux = this.countRepetitions(faces);
      Map<String, Integer> suitsRealValues = new HashMap<String, Integer>();
      
      for (int i = 0; i < this.faces.length; i++) {
         suitsRealValues.put(this.faces[i], i + 1);
      }
      
      int[] values = new int[5];
      for (int i = 0; i < values.length; i++) {
         for (int j = 0; j < faces.length; j++) {
            values[j] = suitsRealValues.get(faces[j]);
         }
      }
      Arrays.sort(values);
      
      int counter = 0;
      if (facesAux.size() == 5) {
         for (int i = 0; i < values.length; i++) {
            if (i == 0) {
               if (values[i] == 1 && (values[i+1] == 2) && (values[i+2]) == 3) counter++;
               continue;
            }
            
            if (i == values.length - 1) {
               if (values[i] == 1 && (values[i-1] == 13) && (values[i-2]) == 12) counter++;
               continue;
            }
            
            if ((values[i] - 1 == values[i-1]) && (values[i] + 1 == values[i+1])) counter++;
         }
         
         if (counter >= 3) return "STRAIGHT";
      }
      
      // full house, quadra
      if (facesAux.size() == 2) {
         for (Map.Entry<String, Integer> entry : facesAux.entrySet()) {
            if (entry.getValue() == 4) return "QUADRA";
         }
         
         return "FULL HOUSE";
      }
      
      if (suitsAux.size() == 1) return "FLUSH";
      
      // trinca ou dois pares
      if (facesAux.size() == 3) {
         for (Map.Entry<String, Integer> entry : facesAux.entrySet()) {
            if (entry.getValue() == 3) return "TRINCA";
         }
         
         return "DOIS PARES";
      }
      
      if (facesAux.size() == 4) return "UM PAR";
      
      if (values[0] == 1) return "CARTA ALTA: As";
      
      return "CARTA ALTA: " + this.faces[values[4] - 1];
   }
}
