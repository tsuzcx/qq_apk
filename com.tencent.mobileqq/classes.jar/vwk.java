import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import org.json.JSONException;
import org.json.JSONObject;

public class vwk
{
  @ypm(a="gametype")
  public int a;
  @ypm(a="gameid")
  public String a;
  @ypm(a="name")
  public String b;
  @ypm(a="result")
  public String c;
  
  public static vwk a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = (vwk)JsonORM.a(new JSONObject(paramString), vwk.class);
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
 * Qualified Name:     vwk
 * JD-Core Version:    0.7.0.1
 */