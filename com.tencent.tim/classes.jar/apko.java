import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class apko
{
  static HashMap<String, Integer> oj = new HashMap();
  
  static
  {
    oj.put("str", Integer.valueOf(0));
    oj.put("img", Integer.valueOf(1));
    oj.put("video", Integer.valueOf(2));
    oj.put("voice", Integer.valueOf(3));
    oj.put("recite", Integer.valueOf(4));
    oj.put("calculation", Integer.valueOf(7));
  }
  
  public static apkn a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = a(new JSONObject(paramString));
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static apkn a(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = paramJSONObject.getString("type");
      localObject = (Integer)oj.get(localObject);
      if (localObject == null) {
        return null;
      }
      switch (((Integer)localObject).intValue())
      {
      case 0: 
        paramJSONObject = new apkt(paramJSONObject);
        return paramJSONObject;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      break label142;
      return new apks(paramJSONObject);
      return new apkv(paramJSONObject);
      return new apkm(paramJSONObject);
      return new apkp(paramJSONObject);
      paramJSONObject = new apkl(paramJSONObject);
      return paramJSONObject;
    }
    label142:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apko
 * JD-Core Version:    0.7.0.1
 */