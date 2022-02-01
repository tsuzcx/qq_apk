import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class aopc
{
  public String mDomain;
  public ArrayList<aoph> xp;
  
  public aopc(String paramString, ArrayList<aoph> paramArrayList)
  {
    this.mDomain = paramString;
    this.xp = paramArrayList;
  }
  
  public static String b(HashMap<String, aopc> paramHashMap)
  {
    if (paramHashMap == null) {
      return null;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramHashMap = paramHashMap.values().iterator();
      while (paramHashMap.hasNext())
      {
        aopc localaopc = (aopc)paramHashMap.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("n", localaopc.mDomain);
        localJSONObject.put("l", aoph.P(localaopc.xp));
        localJSONArray.put(localJSONObject);
      }
      paramHashMap = localJSONArray.toString();
    }
    catch (Exception paramHashMap)
    {
      paramHashMap.printStackTrace();
      return null;
    }
    return paramHashMap;
  }
  
  public static HashMap<String, aopc> w(String paramString)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      JSONArray localJSONArray = new JSONArray(paramString);
      int i = 0;
      for (;;)
      {
        paramString = localHashMap;
        if (i >= localJSONArray.length()) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        String str = paramString.getString("n");
        localHashMap.put(str, new aopc(str, aoph.aa(paramString.getString("l"))));
        i += 1;
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aopc
 * JD-Core Version:    0.7.0.1
 */