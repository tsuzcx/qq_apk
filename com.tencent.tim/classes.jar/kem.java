import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class kem
{
  public String YJ = "#FFFFFF";
  public int aIm;
  public int aIn;
  public ArrayList<kem.a> ka = new ArrayList();
  
  public static kem a(String paramString)
  {
    int i = 0;
    kem localkem = new kem();
    if (!aqmr.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localkem.aIm = paramString.optInt("tab_switch");
        localkem.YJ = paramString.optString("tab_background", "#FFFFFF");
        localkem.aIn = paramString.optInt("is_preload");
        paramString = paramString.optJSONArray("tabs");
        if ((paramString != null) && (paramString.length() > 0))
        {
          ArrayList localArrayList = new ArrayList(paramString.length());
          if (i < paramString.length())
          {
            JSONObject localJSONObject = paramString.optJSONObject(i);
            kem.a locala = new kem.a();
            locala.aCj = localJSONObject.optInt("tabid");
            locala.nV = localJSONObject.optString("icon_normal");
            locala.YK = localJSONObject.optString("icon_selected");
            locala.YL = localJSONObject.optString("textcolor_normal", "#CCCCCC");
            locala.YM = localJSONObject.optString("textcolor_selected", "#000000");
            locala.jumpUrl = localJSONObject.optString("jump_url");
            locala.name = localJSONObject.optString("name");
            locala.pageType = localJSONObject.optInt("page_type", 0);
            locala.minAppVersion = localJSONObject.optString("min_app_version", "8.3.3");
            if (!localArrayList.contains(locala)) {
              localArrayList.add(locala);
            }
          }
          else
          {
            localkem.ka = localArrayList;
          }
        }
        else
        {
          return localkem;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return localkem;
      }
      i += 1;
    }
  }
  
  public kem.a a(int paramInt)
  {
    if (this.ka.isEmpty()) {
      return null;
    }
    Iterator localIterator = this.ka.iterator();
    while (localIterator.hasNext())
    {
      kem.a locala = (kem.a)localIterator.next();
      if (locala.aCj == paramInt) {
        return locala;
      }
    }
    return null;
  }
  
  public static class a
  {
    public String YK = "";
    public String YL = "";
    public String YM = "";
    public int aCj;
    public String jumpUrl = "";
    public String minAppVersion;
    public String nV = "";
    public String name = "";
    public int pageType;
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (a)paramObject;
      } while (this.aCj == paramObject.aCj);
      return false;
    }
    
    public int hashCode()
    {
      return this.aCj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kem
 * JD-Core Version:    0.7.0.1
 */