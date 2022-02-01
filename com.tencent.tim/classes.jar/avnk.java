import com.tencent.qphone.base.util.QLog;
import cooperation.qqreader.net.BaseCgiTask;
import org.json.JSONException;
import org.json.JSONObject;

public class avnk
{
  private BaseCgiTask b;
  private String jI;
  
  public avnk(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    this.b = paramBaseCgiTask;
    this.jI = paramString;
  }
  
  public JSONObject f()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject(this.jI);
      return localJSONObject2;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ReaderCgiResponse", 2, "json format error", localJSONException);
    }
    return localJSONObject1;
  }
  
  public String getResult()
  {
    return this.jI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avnk
 * JD-Core Version:    0.7.0.1
 */