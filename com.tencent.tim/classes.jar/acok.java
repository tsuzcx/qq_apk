import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;
import java.util.Map.Entry;

class acok
  implements Comparator<Map.Entry<String, Entity>>
{
  acok(acoj paramacoj) {}
  
  public int compare(Map.Entry<String, Entity> paramEntry1, Map.Entry<String, Entity> paramEntry2)
  {
    paramEntry1 = ((String)paramEntry1.getKey()).split("&")[1];
    int i = Integer.parseInt(paramEntry1.split("-")[0]);
    int j = Integer.parseInt(paramEntry1.split("-")[1]);
    paramEntry1 = ((String)paramEntry2.getKey()).split("&")[1];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acok
 * JD-Core Version:    0.7.0.1
 */