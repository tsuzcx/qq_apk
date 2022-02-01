import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class nny
{
  protected abstract void aCG();
  
  public abstract void e(ListView paramListView);
  
  protected void m(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("folder_status", kxm.aMw);
      paramJSONObject.put("kandian_mode", kxm.nR());
      paramJSONObject = paramJSONObject.toString();
      kbp.a(null, "", paramString, paramString, 0, 0, "", "", "", paramJSONObject, false);
      QLog.d("HeaderViewController", 2, "report: T - " + paramString + " r5 - " + paramJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.d("HeaderViewController", 2, "report failed due to JSONException: " + paramString.getMessage());
      throw new IllegalArgumentException("fail to construct r5 json");
    }
  }
  
  public abstract void onDestroy();
  
  public void onPause() {}
  
  public void onRefresh() {}
  
  public void onResume()
  {
    aCG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nny
 * JD-Core Version:    0.7.0.1
 */