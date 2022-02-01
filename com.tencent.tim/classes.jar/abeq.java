import java.util.Comparator;
import org.json.JSONObject;

class abeq
  implements Comparator<JSONObject>
{
  abeq(abep paramabep) {}
  
  public int a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    return Long.valueOf(paramJSONObject2.optLong("time")).compareTo(Long.valueOf(paramJSONObject1.optLong("time")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abeq
 * JD-Core Version:    0.7.0.1
 */