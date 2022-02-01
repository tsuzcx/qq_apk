import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.a;
import java.util.Comparator;

class yyz
  implements Comparator<yyy.a>
{
  yyz(yyy paramyyy) {}
  
  public int a(yyy.a parama1, yyy.a parama2)
  {
    if ((parama1 == null) && (parama2 == null)) {}
    int j;
    int k;
    do
    {
      do
      {
        return 0;
        if ((parama1 == null) && (parama2 != null)) {
          return -1;
        }
        if ((parama1 != null) && (parama2 == null)) {
          return 1;
        }
        parama1 = parama1.name;
        parama2 = parama2.name;
      } while ((parama1 == null) && (parama2 == null));
      if ((parama1 == null) && (parama2 != null)) {
        return -1;
      }
      if ((parama1 != null) && (parama2 == null)) {
        return 1;
      }
      j = parama1.length();
      k = parama2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = parama1.charAt(i);
        char c2 = parama2.charAt(i);
        if (c1 != c2)
        {
          parama1 = ChnToSpell.a(c1);
          parama2 = ChnToSpell.a(c2);
          if (parama1.range == parama2.range) {
            return parama1.csW.compareTo(parama2.csW);
          }
          return parama1.range - parama2.range;
        }
        i += 1;
      }
      if (j < k) {
        return -1;
      }
    } while (j <= k);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yyz
 * JD-Core Version:    0.7.0.1
 */