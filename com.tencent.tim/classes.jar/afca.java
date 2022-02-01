import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class afca
  extends afbe
{
  public ArrayList<afbz> vW;
  
  public static afca a(JSONObject paramJSONObject)
  {
    afca localafca = new afca();
    localafca.name = paramJSONObject.optString("group");
    paramJSONObject = paramJSONObject.optJSONArray("configs");
    localafca.vW = new ArrayList(paramJSONObject.length());
    int i = 0;
    while (i < paramJSONObject.length())
    {
      afbz localafbz = afbz.a(paramJSONObject.optJSONObject(i));
      localafbz.a = localafca;
      localafca.vW.add(localafbz);
      i += 1;
    }
    return localafca;
  }
  
  public boolean aiH()
  {
    return false;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("group", this.name);
      localJSONObject.put("isChecked", this.isChecked);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.vW.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((afbz)localIterator.next()).toJson());
      }
      localJSONObject.put("configs", localJSONException);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return localJSONObject;
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     afca
 * JD-Core Version:    0.7.0.1
 */