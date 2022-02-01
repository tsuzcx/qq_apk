import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class aoph
{
  public int aON;
  public String mIp;
  public int mPort;
  public int mType;
  
  public aoph() {}
  
  public aoph(String paramString, int paramInt1, int paramInt2)
  {
    this.mIp = paramString;
    this.mPort = paramInt1;
    this.mType = paramInt2;
  }
  
  public static String P(List<aoph> paramList)
  {
    if (paramList == null) {
      return null;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        aoph localaoph = (aoph)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("i", localaoph.mIp);
        if (localaoph.mPort != 80) {
          localJSONObject.put("p", localaoph.mPort);
        }
        if (localaoph.mType != 1) {
          localJSONObject.put("t", localaoph.mType);
        }
        localJSONArray.put(localJSONObject);
      }
      paramList = localJSONArray.toString();
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
      return null;
    }
    return paramList;
  }
  
  public static ArrayList<aoph> aa(String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      JSONArray localJSONArray = new JSONArray(paramString);
      int i = 0;
      for (;;)
      {
        paramString = localArrayList;
        if (i >= localJSONArray.length()) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        localArrayList.add(new aoph(paramString.getString("i"), paramString.optInt("p", 80), paramString.optInt("t", 1)));
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
 * Qualified Name:     aoph
 * JD-Core Version:    0.7.0.1
 */