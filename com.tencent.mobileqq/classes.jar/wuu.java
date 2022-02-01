import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import org.json.JSONException;
import org.json.JSONObject;

public class wuu
{
  @zoq(a="gametype")
  public int a;
  @zoq(a="gameid")
  public String a;
  @zoq(a="name")
  public String b;
  @zoq(a="result")
  public String c;
  
  public static wuu a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = (wuu)JsonORM.a(new JSONObject(paramString), wuu.class);
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
 * Qualified Name:     wuu
 * JD-Core Version:    0.7.0.1
 */