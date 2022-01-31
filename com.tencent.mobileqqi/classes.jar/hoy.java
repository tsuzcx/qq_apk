import android.os.Bundle;
import com.tencent.open.appcommon.AppViewBaseActivity;
import com.tencent.open.appcommon.js.BaseJsCallBack;
import org.json.JSONException;
import org.json.JSONObject;

public class hoy
  implements Runnable
{
  public hoy(BaseJsCallBack paramBaseJsCallBack, String paramString) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.jdField_a_of_type_JavaLangString);
      Bundle localBundle = new Bundle();
      localBundle.putString("iconType", localJSONObject.optString("iconType"));
      localBundle.putString("visible", localJSONObject.optString("visible"));
      localBundle.putString("callBackKey", localJSONObject.optString("callBackKey"));
      if ((this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack.activity instanceof AppViewBaseActivity)) {
        ((AppViewBaseActivity)this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack.activity).b(localBundle);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hoy
 * JD-Core Version:    0.7.0.1
 */