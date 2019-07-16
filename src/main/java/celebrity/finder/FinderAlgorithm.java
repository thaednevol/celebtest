package celebrity.finder;

import java.util.LinkedList;
import java.util.Queue;

public class FinderAlgorithm implements CelebrityFinder {

   private int[][] party;

   @Override
   public void setParty(int[][] party) {
      int length = party.length;
      int[][] target = new int[length][party[0].length];
      for (int i = 0; i < length; i++) {
          System.arraycopy(party[i], 0, target[i], 0, party[i].length);
      }
      this.party=target;
   }

   @Override
   public int find() {
      Queue<Integer> possibleCelebrity = new LinkedList<>();

      for (int i = 0; i < party.length; i++) {
         possibleCelebrity.offer(i);
      }

      while (possibleCelebrity.size() > 1) {
         int a = possibleCelebrity.poll();
         int b = possibleCelebrity.poll();

         if (knows(a, b)) {
            possibleCelebrity.offer(b);
         } else {
            possibleCelebrity.offer(a);
         }
      }

      int c = possibleCelebrity.poll();

      for (int i = 0; i < party.length; i++) {
         if (i != c && (knows(c, i) || !knows(i, c))) {
            return -1;
         }
      }

      return c;
   }

   private boolean knows(int a, int b) {
      return party[a][b] == 1;
   }
}
