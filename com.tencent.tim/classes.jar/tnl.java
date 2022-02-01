import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class tnl
  extends tnk
{
  private int bCy;
  
  public tnl(JSONObject paramJSONObject)
  {
    readFromJson(paramJSONObject);
  }
  
  public boolean ae(boolean paramBoolean)
  {
    return super.ae(paramBoolean);
  }
  
  public String or()
  {
    String str = super.or();
    try
    {
      Object localObject = new JSONObject(str);
      ((JSONObject)localObject).put("patchName", this.aJC);
      ((JSONObject)localObject).put("patch7zUrl", this.patchUrl);
      ((JSONObject)localObject).put("patchSize", this.bCx);
      ((JSONObject)localObject).put("patch7zSize", this.bCy);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("PatchLogTag", 1, "DexPatchItemConfigArtGeN writeToJsonString", localJSONException);
    }
    return str;
  }
  
  protected void readFromJson(JSONObject paramJSONObject)
  {
    super.readFromJson(paramJSONObject);
    this.aJC = paramJSONObject.optString("patchName", null);
    this.patchUrl = paramJSONObject.optString("patch7zUrl", null);
    this.bCx = paramJSONObject.optInt("patchSize", 0);
    this.bCy = paramJSONObject.optInt("patch7zSize", 0);
  }
  
  public int uW()
  {
    return this.bCy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tnl
 * JD-Core Version:    0.7.0.1
 */