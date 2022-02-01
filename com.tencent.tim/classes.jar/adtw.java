import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class adtw
{
  public long VB;
  public String bvy;
  public long costTime;
  public long endTime;
  public int index;
  public HashMap<String, String> params;
  public boolean result;
  public long startTime;
  
  public JSONObject getJsonObject()
  {
    JSONObject localJSONObject = new JSONObject();
    String str;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(this.bvy))
        {
          Object localObject = this.bvy;
          localJSONObject.put("evt", localObject);
          localJSONObject.put("index", this.index);
          localJSONObject.put("result", this.result);
          localJSONObject.put("startTime", this.startTime);
          localJSONObject.put("endTime", this.endTime);
          localJSONObject.put("costTime", this.costTime);
          localJSONObject.put("net", this.VB);
          localObject = new JSONObject();
          if (this.params == null) {
            break;
          }
          Iterator localIterator = this.params.entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          ((JSONObject)localObject).put((String)localEntry.getKey(), localEntry.getValue());
          continue;
        }
        str = "";
      }
      catch (JSONException localJSONException)
      {
        QLog.e("ArkVipReportItem", 1, "getJsonObject()", localJSONException);
        return localJSONObject;
      }
    }
    localJSONObject.put("param", str);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adtw
 * JD-Core Version:    0.7.0.1
 */