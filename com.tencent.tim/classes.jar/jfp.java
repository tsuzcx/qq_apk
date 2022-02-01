import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jfp
{
  public static String TAG = "VoiceChangeData";
  private static jfp a;
  private final int SIZE = 40;
  private boolean YT;
  private Object ay = new Object();
  private jfp.a[] b;
  
  public static jfp a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new jfp();
      }
      return a;
    }
    finally {}
  }
  
  public jfp.a[] a()
  {
    if (this.b == null) {
      bj(igl.b(172).content);
    }
    if ((this.b == null) && (!this.YT))
    {
      jfq.reportClickEvent("0X8007EFD", "");
      this.YT = true;
    }
    return this.b;
  }
  
  protected void bj(String paramString)
  {
    if (paramString == null) {
      return;
    }
    synchronized (this.ay)
    {
      this.b = null;
      try
      {
        Object localObject2 = new JSONObject(paramString);
        if (((JSONObject)localObject2).has("voices"))
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("voices");
          igd.aK(TAG, "parseConfig|voices size= " + ((JSONArray)localObject2).length());
          this.b = new jfp.a[((JSONArray)localObject2).length()];
          int i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
            jfp.a locala = new jfp.a();
            locala.name = localJSONObject.getString("name");
            locala.RO = localJSONObject.getString("icon1");
            locala.RP = localJSONObject.getString("icon2");
            locala.type = Integer.parseInt(localJSONObject.getString("type"));
            locala.vipLevel = Integer.parseInt(localJSONObject.getString("vip_level"));
            this.b[i] = locala;
            i += 1;
          }
        }
        paramString = finally;
      }
      catch (JSONException localJSONException)
      {
        QLog.w(TAG, 1, "parseConfig, JSONException, \ncontent[" + paramString + "]", localJSONException);
        this.b = null;
        return;
      }
    }
  }
  
  public static class a
  {
    public String RO;
    public String RP;
    public String name;
    public int type;
    public int vipLevel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jfp
 * JD-Core Version:    0.7.0.1
 */