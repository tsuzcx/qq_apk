import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class tnm
  extends tnk
{
  public tnm(JSONObject paramJSONObject)
  {
    readFromJson(paramJSONObject);
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
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("PatchLogTag", 1, "DexPatchItemConfigArtLM writeToJsonString", localJSONException);
    }
    return str;
  }
  
  protected void readFromJson(JSONObject paramJSONObject)
  {
    super.readFromJson(paramJSONObject);
    this.aJC = paramJSONObject.optString("patchName", null);
    this.patchUrl = paramJSONObject.optString("patchUrl", null);
    this.bCx = paramJSONObject.optInt("patchSize", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tnm
 * JD-Core Version:    0.7.0.1
 */