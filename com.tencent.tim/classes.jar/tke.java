import android.os.Bundle;
import org.json.JSONObject;

class tke
  implements skj.a
{
  tke(tkd paramtkd, tjs paramtjs, String paramString, String[] paramArrayOfString, skj paramskj) {}
  
  public void callback(Bundle paramBundle)
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
      tkw.d("GdtGetUserInfoHandler", "handleJsCallRequest() called with: webPlugin = [" + this.a + "], callback = [" + this.val$callback + "], args = [" + this.val$args + "], result = [" + paramBundle + "]");
      this.a.callJs(this.val$callback, new String[] { paramBundle });
      this.jdField_b_of_type_Skj.bzk();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        tkw.e("GdtGetUserInfoHandler", localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tke
 * JD-Core Version:    0.7.0.1
 */