import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class xbh
  implements wiu
{
  xbh(xbe paramxbe, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    Object localObject = null;
    String str;
    if (paramBundle != null)
    {
      str = paramBundle.getString("content");
      paramBundle = paramBundle.getString("url");
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("content", str);
      localJSONObject.put("url", paramBundle);
      paramBundle = localJSONObject.toString();
      this.jdField_a_of_type_Xbe.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        paramBundle = localObject;
        if (QLog.isColorLevel())
        {
          QLog.i("HotchatPlugin", 2, localJSONException.getMessage());
          paramBundle = localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xbh
 * JD-Core Version:    0.7.0.1
 */