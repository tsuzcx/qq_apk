import com.tencent.mobileqq.search.searchengine.GroupSearchEngine.a;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import java.util.Comparator;
import java.util.Map;

public final class amvm
  implements Comparator<GroupSearchEngine.a>
{
  public int a(GroupSearchEngine.a parama1, GroupSearchEngine.a parama2)
  {
    parama2 = (Integer)SearchConfigManager.searchEngineOrder.get(parama2.type);
    if (parama2 == null) {
      parama2 = Integer.valueOf(0);
    }
    for (;;)
    {
      Integer localInteger = (Integer)SearchConfigManager.searchEngineOrder.get(parama1.type);
      parama1 = localInteger;
      if (localInteger == null) {
        parama1 = Integer.valueOf(0);
      }
      return Integer.signum(parama2.intValue() - parama1.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amvm
 * JD-Core Version:    0.7.0.1
 */