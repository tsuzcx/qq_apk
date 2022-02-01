import java.util.Comparator;
import org.json.JSONObject;

public class kex
  implements Comparator<JSONObject>
{
  String YR;
  
  public kex(String paramString)
  {
    this.YR = paramString;
  }
  
  public int a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    long l = paramJSONObject1.optLong(this.YR);
    return (int)(paramJSONObject2.optLong(this.YR) - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kex
 * JD-Core Version:    0.7.0.1
 */