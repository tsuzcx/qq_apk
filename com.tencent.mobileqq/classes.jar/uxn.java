import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import org.json.JSONException;
import org.json.JSONObject;

public class uxn
{
  @xrk(a="gametype")
  public int a;
  @xrk(a="gameid")
  public String a;
  @xrk(a="name")
  public String b;
  @xrk(a="result")
  public String c;
  
  public static uxn a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = (uxn)JsonORM.a(new JSONObject(paramString), uxn.class);
      return paramString;
    }
    catch (JsonORM.JsonParseException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uxn
 * JD-Core Version:    0.7.0.1
 */