import com.tencent.mobileqq.jsbridge.WebBridge.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public class fzl
  implements Runnable
{
  public fzl(WebBridge.JsBridgeListener paramJsBridgeListener, JSONObject paramJSONObject, WebView paramWebView) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("responseId", this.jdField_a_of_type_ComTencentMobileqqJsbridgeWebBridge$JsBridgeListener.a);
      localJSONObject.put("responseData", this.jdField_a_of_type_OrgJsonJSONObject);
      if (QLog.isColorLevel()) {
        QLog.i("BaseWebActivity.WebBridge", 2, "WebBridge onComplete setMessage message:" + localJSONObject.toString());
      }
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("javascript:qqJSBridge.setMessage('" + localJSONObject.toString() + "');");
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BaseWebActivity.WebBridge", 2, "WebBridge onComplete Exception:" + localJSONException.getMessage());
      }
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fzl
 * JD-Core Version:    0.7.0.1
 */