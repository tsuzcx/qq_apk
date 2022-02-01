import com.tencent.mobileqq.search.searchengine.OnlineFileSearchEngine;
import com.tencent.mobileqq.search.searchengine.OnlineFileSearchEngine.a;
import java.util.Comparator;

public class amwm
  implements Comparator<OnlineFileSearchEngine.a>
{
  public amwm(OnlineFileSearchEngine paramOnlineFileSearchEngine) {}
  
  public int a(OnlineFileSearchEngine.a parama1, OnlineFileSearchEngine.a parama2)
  {
    if (parama1.opTime - parama2.opTime > 0L) {
      return -1;
    }
    if (parama1.opTime - parama2.opTime < 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amwm
 * JD-Core Version:    0.7.0.1
 */