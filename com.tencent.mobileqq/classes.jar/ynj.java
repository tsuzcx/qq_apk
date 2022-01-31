import android.os.Bundle;
import org.json.JSONObject;

class ynj
  implements wiu
{
  ynj(yni paramyni, ymw paramymw, String paramString, String[] paramArrayOfString, wis paramwis) {}
  
  public void a(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("phone");
    String str2 = paramBundle.getString("name");
    String str3 = paramBundle.getString("city");
    String str4 = paramBundle.getString("area");
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("phone", str1);
      paramBundle.put("name", str2);
      paramBundle.put("city", str3);
      paramBundle.put("area", str4);
      paramBundle = paramBundle.toString();
      yny.a("GdtGetUserInfoHandler", "handleJsCallRequest() called with: webPlugin = [" + this.jdField_a_of_type_Ymw + "], callback = [" + this.jdField_a_of_type_JavaLangString + "], args = [" + this.jdField_a_of_type_ArrayOfJavaLangString + "], result = [" + paramBundle + "]");
      this.jdField_a_of_type_Ymw.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle });
      this.jdField_a_of_type_Wis.b();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        yny.d("GdtGetUserInfoHandler", localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ynj
 * JD-Core Version:    0.7.0.1
 */