import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ascf
  extends asbu
{
  private List<String> JK = new ArrayList();
  
  public void parse(String paramString)
  {
    super.parse(paramString);
    try
    {
      paramString = new JSONObject(paramString).getJSONArray(this.key);
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        this.JK.add(paramString.getString(i));
        i += 1;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ascf
 * JD-Core Version:    0.7.0.1
 */