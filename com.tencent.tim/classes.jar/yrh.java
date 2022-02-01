import android.support.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class yrh
{
  public String aZA;
  public String aZB;
  public String aZz;
  public boolean boq;
  public int caI;
  public int tab_id;
  
  public static JSONObject a(yrh paramyrh)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramyrh != null) {}
    try
    {
      localJSONObject.put("tab_id", paramyrh.tab_id);
      localJSONObject.put("recommend_count", paramyrh.caI);
      localJSONObject.put("tab_name", paramyrh.aZz);
      localJSONObject.put("icon_url_select", paramyrh.aZA);
      localJSONObject.put("icon_url_unselect", paramyrh.aZB);
      return localJSONObject;
    }
    catch (JSONException paramyrh) {}
    return localJSONObject;
  }
  
  public static yrh a(JSONObject paramJSONObject)
  {
    yrh localyrh = new yrh();
    if (paramJSONObject != null)
    {
      localyrh.tab_id = paramJSONObject.optInt("tab_id", -1);
      localyrh.caI = paramJSONObject.optInt("recommend_count", 0);
      localyrh.aZz = paramJSONObject.optString("tab_name");
      localyrh.aZA = paramJSONObject.optString("icon_url_select");
      localyrh.aZB = paramJSONObject.optString("icon_url_unselect");
    }
    return localyrh;
  }
  
  public static yrh a(yrh paramyrh)
  {
    yrh localyrh = new yrh();
    if (paramyrh != null)
    {
      localyrh.tab_id = paramyrh.tab_id;
      localyrh.aZz = paramyrh.aZz;
      localyrh.caI = paramyrh.caI;
      localyrh.aZA = paramyrh.aZA;
      localyrh.aZB = paramyrh.aZB;
    }
    return localyrh;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof yrh)) {
      return this.tab_id == ((yrh)paramObject).tab_id;
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    return "tab_id=" + this.tab_id + " recommend_count=" + this.caI + " tab_name=" + this.aZz + " icon_url_select=" + this.aZA + " icon_url_unselect=" + this.aZB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yrh
 * JD-Core Version:    0.7.0.1
 */