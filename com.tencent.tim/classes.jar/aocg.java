import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aocg
{
  public String cjI;
  public String cjc;
  public int dNU;
  public int domainId;
  public boolean isCache;
  public String title;
  public String url;
  
  public static aocg a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if ((paramJSONObject.has("retcode")) && (paramJSONObject.getInt("retcode") == 0) && (paramJSONObject.has("data")))
        {
          aocg localaocg = new aocg();
          paramJSONObject = paramJSONObject.getJSONObject("data");
          if (paramJSONObject != null)
          {
            localaocg.url = paramJSONObject.optString("url");
            localaocg.title = paramJSONObject.optString("title");
            localaocg.domainId = paramJSONObject.optInt("localPadId");
            localaocg.cjc = paramJSONObject.optString("localPadId");
            localaocg.cjI = paramJSONObject.optString("doc_id");
            localaocg.dNU = paramJSONObject.optInt("doc_type");
            localaocg.isCache = paramJSONObject.optBoolean("isCache");
          }
          return localaocg;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("ImportFormData", 1, paramJSONObject.getLocalizedMessage(), paramJSONObject);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aocg
 * JD-Core Version:    0.7.0.1
 */