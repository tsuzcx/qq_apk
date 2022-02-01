import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.activity.PublicAccountListActivity.a;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.a;
import java.util.Comparator;

public class vnc
  implements Comparator<PublicAccountListActivity.a>
{
  public vnc(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(PublicAccountListActivity.a parama1, PublicAccountListActivity.a parama2)
  {
    parama1 = parama1.a.name;
    parama2 = parama2.a.name;
    if ((parama1 == null) && (parama2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
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
          parama1 = ChnToSpell.a(c1, i);
          parama2 = ChnToSpell.a(c2, i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vnc
 * JD-Core Version:    0.7.0.1
 */