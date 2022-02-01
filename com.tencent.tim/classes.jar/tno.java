import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class tno
  extends tnk
{
  private String aJD;
  private String aJE;
  private boolean aPR;
  
  public tno(JSONObject paramJSONObject)
  {
    readFromJson(paramJSONObject);
  }
  
  public boolean ae(boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.aJD))
    {
      QLog.d("PatchLogTag", 1, "NativePatchItemConfig isValidConfig driverVersion is null");
      return false;
    }
    return super.ae(paramBoolean);
  }
  
  public String or()
  {
    String str = super.or();
    try
    {
      Object localObject = new JSONObject(str);
      ((JSONObject)localObject).put("patchName", this.aJC);
      ((JSONObject)localObject).put("patchUrl", this.patchUrl);
      ((JSONObject)localObject).put("patchSize", this.bCx);
      ((JSONObject)localObject).put("driverVersion", this.aJD);
      ((JSONObject)localObject).put("previousPatch", this.aJE);
      ((JSONObject)localObject).put("isDelayLoad", this.aPR);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("PatchLogTag", 1, "NativePatchItemConfig writeToJsonString", localJSONException);
    }
    return str;
  }
  
  protected void readFromJson(JSONObject paramJSONObject)
  {
    super.readFromJson(paramJSONObject);
    this.aJC = paramJSONObject.optString("patchName", null);
    this.patchUrl = paramJSONObject.optString("patchUrl", null);
    this.bCx = paramJSONObject.optInt("patchSize", 0);
    this.aJD = paramJSONObject.optString("driverVersion", null);
    this.aJE = paramJSONObject.optString("previousPatch", null);
    this.aPR = paramJSONObject.optBoolean("isDelayLoad", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tno
 * JD-Core Version:    0.7.0.1
 */