package cooperation.qqreader.net;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class QueryUserIdentityTask
  extends BaseCgiTask
{
  protected BaseCgiTask.RequestType a()
  {
    return BaseCgiTask.RequestType.POST;
  }
  
  protected HashMap<String, String> getHeaders()
  {
    return f();
  }
  
  protected String getUrl()
  {
    return "https://app.books.qq.com/webapp/json/reader_webapp_newuser/GetUserIdentity";
  }
  
  protected byte[] p()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("origin", 1);
      return localJSONObject.toString().getBytes();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.net.QueryUserIdentityTask
 * JD-Core Version:    0.7.0.1
 */