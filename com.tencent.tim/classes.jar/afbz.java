import org.json.JSONException;
import org.json.JSONObject;

public class afbz
  extends afbe
{
  public afca a;
  public String action;
  public boolean bXe;
  
  public static afbz a(JSONObject paramJSONObject)
  {
    afbz localafbz = new afbz();
    localafbz.name = paramJSONObject.optString("name");
    localafbz.action = paramJSONObject.optString("action");
    localafbz.isChecked = paramJSONObject.optBoolean("isChecked", true);
    localafbz.bXe = paramJSONObject.optBoolean("isAddByUser");
    return localafbz;
  }
  
  public boolean aiH()
  {
    return this.bXe;
  }
  
  public boolean isChecked()
  {
    if (this.a == null) {
      return this.isChecked;
    }
    return this.a.isChecked;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("name", this.name);
      localJSONObject.put("action", this.action);
      localJSONObject.put("isChecked", this.isChecked);
      localJSONObject.put("isAddByUser", this.bXe);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     afbz
 * JD-Core Version:    0.7.0.1
 */