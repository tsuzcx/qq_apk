import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aepe
{
  private Map<String, aepe.a> mConfigMap = new HashMap();
  
  public static aepe.a a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (aepb.a() != null)) {
      return (aepe.a)aepb.a().getConfigMap().get(paramString);
    }
    return null;
  }
  
  public static aepe b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      return null;
    }
    localaepe = new aepe();
    try
    {
      paramArrayOfaeic = new JSONObject(paramArrayOfaeic[0].content);
      Iterator localIterator = paramArrayOfaeic.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramArrayOfaeic.getJSONObject(str);
        localaepe.mConfigMap.put(str, aepe.a.a(localJSONObject));
      }
      return localaepe;
    }
    catch (JSONException paramArrayOfaeic) {}
  }
  
  public Map<String, aepe.a> getConfigMap()
  {
    return this.mConfigMap;
  }
  
  public static class a
  {
    private String buttonText = "";
    private String icon = "";
    private String tips = "";
    private String url = "";
    
    public static a a(JSONObject paramJSONObject)
      throws JSONException
    {
      if (paramJSONObject == null) {
        return null;
      }
      a locala = new a();
      locala.tips = paramJSONObject.getString("tips");
      locala.buttonText = paramJSONObject.getString("buttonText");
      locala.url = paramJSONObject.getString("url");
      locala.icon = paramJSONObject.getString("icon");
      return locala;
    }
    
    public String getIcon()
    {
      return this.icon;
    }
    
    public String getTips()
    {
      return this.tips;
    }
    
    public String getUrl()
    {
      return this.url;
    }
    
    public boolean isEmpty()
    {
      return (TextUtils.isEmpty(this.tips)) && (TextUtils.isEmpty(this.buttonText)) && (TextUtils.isEmpty(this.url)) && (TextUtils.isEmpty(this.icon));
    }
    
    public String tD()
    {
      return this.buttonText;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aepe
 * JD-Core Version:    0.7.0.1
 */