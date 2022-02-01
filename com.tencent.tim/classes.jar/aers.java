import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class aers
{
  private static String bAE = "skin_leba_tongyong_bg";
  private static String bAF = "https://zb.vip.qq.com/v2/pages/themeMall?_wv=16778243&from=themeIcon";
  public static HashMap<String, String> ka = new HashMap();
  private boolean bVZ;
  
  private static void Ht(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONObject("android");
      JSONObject localJSONObject = paramString.getJSONObject("backgroundIconConfig");
      if (localJSONObject != null)
      {
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ka.put(str, localJSONObject.getString(str));
        }
      }
      bAE = paramString.getString("defaultIconName");
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    bAF = paramString.getString("themeStoreUrl");
  }
  
  @NonNull
  public static aers a(String paramString)
  {
    aers localaers = new aers();
    if (TextUtils.isEmpty(paramString))
    {
      localaers.bVZ = false;
      return localaers;
    }
    localaers.bVZ = true;
    Ht(paramString);
    return localaers;
  }
  
  public boolean aht()
  {
    return this.bVZ;
  }
  
  public String kk(String paramString)
  {
    String str = (String)ka.get(paramString);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = bAE;
    }
    return paramString;
  }
  
  public String tH()
  {
    return bAF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aers
 * JD-Core Version:    0.7.0.1
 */