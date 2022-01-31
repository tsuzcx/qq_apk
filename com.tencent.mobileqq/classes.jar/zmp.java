import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import java.util.Comparator;
import java.util.Map.Entry;

public class zmp
  implements Comparator
{
  public zmp(RoamDateCache paramRoamDateCache) {}
  
  public int a(Map.Entry paramEntry1, Map.Entry paramEntry2)
  {
    paramEntry1 = ((java.lang.String)paramEntry1.getKey()).split("&")[1];
    int i = Integer.parseInt(paramEntry1.split("-")[0]);
    int j = Integer.parseInt(paramEntry1.split("-")[1]);
    paramEntry1 = ((java.lang.String)paramEntry2.getKey()).split("&")[1];
    int k = Integer.parseInt(paramEntry1.split("-")[0]);
    int m = Integer.parseInt(paramEntry1.split("-")[1]);
    if (i > k) {
      return 1;
    }
    if (i == k) {
      return j - m;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zmp
 * JD-Core Version:    0.7.0.1
 */