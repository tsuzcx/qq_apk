import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.biz.qqstory.utils.JsonORM.a;
import org.json.JSONException;
import org.json.JSONObject;

public class ptw
{
  @JsonORM.a(key="gameid")
  public String id;
  @JsonORM.a(key="name")
  public String name;
  @JsonORM.a(key="result")
  public String result;
  @JsonORM.a(key="gametype")
  public int type;
  
  public static ptw a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = (ptw)JsonORM.parseFrom(new JSONObject(paramString), ptw.class);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ptw
 * JD-Core Version:    0.7.0.1
 */