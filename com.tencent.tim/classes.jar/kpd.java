import com.tencent.common.app.BaseApplicationImpl;
import org.json.JSONException;
import org.json.JSONObject;

public class kpd
{
  private JSONObject al = new JSONObject();
  
  public kpd a()
  {
    try
    {
      this.al.put("network", kvp.U(BaseApplicationImpl.getApplication().getApplicationContext()));
      this.al.put("version", kct.XU);
      this.al.put("os", "1");
      this.al.put("uin", kxm.getAccount());
      this.al.put("city", kvp.iJ());
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public kpd a(int paramInt)
  {
    int i = 0;
    if (paramInt == 41516) {
      i = 3;
    }
    for (;;)
    {
      try
      {
        this.al.put("source", i);
        return this;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (paramInt == 41522) {
        i = 16;
      }
    }
    return this;
  }
  
  public String build()
  {
    return this.al.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kpd
 * JD-Core Version:    0.7.0.1
 */