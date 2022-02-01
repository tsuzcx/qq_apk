import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import org.json.JSONException;
import org.json.JSONObject;

public class wlf
{
  @zef(a="gametype")
  public int a;
  @zef(a="gameid")
  public String a;
  @zef(a="name")
  public String b;
  @zef(a="result")
  public String c;
  
  public static wlf a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = (wlf)JsonORM.a(new JSONObject(paramString), wlf.class);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wlf
 * JD-Core Version:    0.7.0.1
 */