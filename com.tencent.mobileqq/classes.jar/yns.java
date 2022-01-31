import com.tencent.mobileqq.adapter.HotChatPostListAdapter;
import java.util.Comparator;
import org.json.JSONObject;

public class yns
  implements Comparator
{
  public yns(HotChatPostListAdapter paramHotChatPostListAdapter) {}
  
  public int a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    return Long.valueOf(paramJSONObject2.optLong("time")).compareTo(Long.valueOf(paramJSONObject1.optLong("time")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yns
 * JD-Core Version:    0.7.0.1
 */