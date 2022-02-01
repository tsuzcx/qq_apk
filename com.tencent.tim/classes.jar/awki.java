import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class awki
{
  public static Map<String, Object> B(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    try
    {
      paramString = e(new JSONObject(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localLinkedHashMap;
  }
  
  public static Map<String, Object> e(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject == null) {
      return null;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = localIterator.next() + "";
      Object localObject = paramJSONObject.get(str);
      if (localObject != null) {
        if (localObject.getClass() == JSONObject.class) {
          localLinkedHashMap.put(str, e((JSONObject)localObject));
        } else if (localObject.getClass() == JSONArray.class) {
          localLinkedHashMap.put(str, h((JSONArray)localObject));
        } else {
          localLinkedHashMap.put(str, localObject);
        }
      }
    }
    return localLinkedHashMap;
  }
  
  public static ArrayList<Object> h(JSONArray paramJSONArray)
    throws JSONException
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.opt(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (localObject.getClass() == JSONObject.class) {
          localArrayList.add(e((JSONObject)localObject));
        } else if (localObject.getClass() == JSONArray.class) {
          localArrayList.add(h((JSONArray)localObject));
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awki
 * JD-Core Version:    0.7.0.1
 */