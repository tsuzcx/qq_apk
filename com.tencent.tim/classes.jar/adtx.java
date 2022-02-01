import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class adtx
{
  public String SB;
  public String bvA;
  public String bvz;
  public long costTime;
  public long endTime;
  public String os;
  public String qqver;
  public String scene;
  public long startTime;
  public ArrayList<adtw> uK;
  public String uin;
  
  public JSONObject getJsonObject()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(this.uin))
        {
          Object localObject = this.uin;
          localJSONObject.put("uin", localObject);
          if (TextUtils.isEmpty(this.SB)) {
            break label285;
          }
          localObject = this.SB;
          localJSONObject.put("phone", localObject);
          if (TextUtils.isEmpty(this.os)) {
            break label291;
          }
          localObject = this.os;
          localJSONObject.put("os", localObject);
          if (TextUtils.isEmpty(this.qqver)) {
            break label297;
          }
          localObject = this.qqver;
          localJSONObject.put("qqver", localObject);
          if (TextUtils.isEmpty(this.scene)) {
            break label303;
          }
          localObject = this.scene;
          localJSONObject.put("scene", localObject);
          if (TextUtils.isEmpty(this.bvz)) {
            break label309;
          }
          localObject = this.bvz;
          localJSONObject.put("startEvt", localObject);
          if (TextUtils.isEmpty(this.bvA)) {
            break label315;
          }
          localObject = this.bvA;
          localJSONObject.put("endEvt", localObject);
          localJSONObject.put("startTime", this.startTime);
          localJSONObject.put("endTime", this.endTime);
          localJSONObject.put("costTime", this.costTime);
          localObject = new JSONArray();
          if (this.uK != null)
          {
            int i = 0;
            if (i < this.uK.size())
            {
              ((JSONArray)localObject).put(i, ((adtw)this.uK.get(i)).getJsonObject());
              i += 1;
              continue;
            }
          }
          localJSONObject.put("evtlist", localObject);
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("ArkVipReportScene", 1, "getJsonObject()", localJSONException);
        return localJSONObject;
      }
      String str = "";
      continue;
      label285:
      str = "";
      continue;
      label291:
      str = "";
      continue;
      label297:
      str = "";
      continue;
      label303:
      str = "";
      continue;
      label309:
      str = "";
      continue;
      label315:
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adtx
 * JD-Core Version:    0.7.0.1
 */