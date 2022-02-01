import org.json.JSONException;
import org.json.JSONObject;

class tzg
  implements qii
{
  tzg(tyo paramtyo, String paramString) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("button", paramInt1);
      localJSONObject.put("result", paramInt2);
      this.jdField_a_of_type_Tyo.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tzg
 * JD-Core Version:    0.7.0.1
 */