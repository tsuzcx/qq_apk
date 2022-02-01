import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import org.json.JSONException;
import org.json.JSONObject;

public class wqz
{
  @zkv(a="gametype")
  public int a;
  @zkv(a="gameid")
  public String a;
  @zkv(a="name")
  public String b;
  @zkv(a="result")
  public String c;
  
  public static wqz a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = (wqz)JsonORM.a(new JSONObject(paramString), wqz.class);
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
 * Qualified Name:     wqz
 * JD-Core Version:    0.7.0.1
 */