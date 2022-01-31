package taiji;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class cg
{
  public static Object a(JSONArray paramJSONArray, int paramInt)
  {
    if ((paramJSONArray == null) || (paramInt < 0) || (paramInt >= paramJSONArray.length())) {
      return null;
    }
    try
    {
      paramJSONArray = paramJSONArray.get(paramInt);
      return paramJSONArray;
    }
    catch (Throwable paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
    return null;
  }
  
  public static Object a(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    try
    {
      paramJSONObject = paramJSONObject.get(paramString);
      return paramJSONObject;
    }
    catch (Throwable paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public static String b(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    try
    {
      paramJSONObject = paramJSONObject.getString(paramString);
      return paramJSONObject;
    }
    catch (Throwable paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public static Object c(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Iterator localIterator = paramJSONObject.keys();
    if (localIterator == null) {
      return null;
    }
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramString.equalsIgnoreCase(str)) {
        return a(paramJSONObject, str);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.cg
 * JD-Core Version:    0.7.0.1
 */