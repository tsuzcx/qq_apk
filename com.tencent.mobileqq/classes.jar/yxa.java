import android.os.Bundle;
import org.json.JSONObject;

class yxa
  implements wxw
{
  yxa(ywz paramywz, ywn paramywn, String paramString, String[] paramArrayOfString, wxu paramwxu) {}
  
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
      yxs.a("GdtGetUserInfoHandler", "handleJsCallRequest() called with: webPlugin = [" + this.jdField_a_of_type_Ywn + "], callback = [" + this.jdField_a_of_type_JavaLangString + "], args = [" + this.jdField_a_of_type_ArrayOfJavaLangString + "], result = [" + paramBundle + "]");
      this.jdField_a_of_type_Ywn.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle });
      this.jdField_a_of_type_Wxu.b();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        yxs.d("GdtGetUserInfoHandler", localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yxa
 * JD-Core Version:    0.7.0.1
 */