import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class zcn
  extends zcl
{
  public zcn(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  public String a()
  {
    String str = super.a();
    try
    {
      Object localObject = new JSONObject(str);
      ((JSONObject)localObject).put("patchName", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("patchUrl", this.b);
      ((JSONObject)localObject).put("patchSize", this.jdField_a_of_type_Int);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("PatchLogTag", 1, "DexPatchItemConfigArtLM writeToJsonString", localJSONException);
    }
    return str;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("patchName", null);
    this.b = paramJSONObject.optString("patchUrl", null);
    this.jdField_a_of_type_Int = paramJSONObject.optInt("patchSize", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zcn
 * JD-Core Version:    0.7.0.1
 */