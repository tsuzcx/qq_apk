import org.json.JSONException;
import org.json.JSONObject;

public class aogj
{
  private JSONObject data;
  public String msg;
  public int result;
  
  public aogj(int paramInt, String paramString)
  {
    this.result = paramInt;
    this.msg = paramString;
  }
  
  public String toJsonString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", this.result);
      localJSONObject.put("message", this.msg);
      localJSONObject.put("data", this.data);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogj
 * JD-Core Version:    0.7.0.1
 */