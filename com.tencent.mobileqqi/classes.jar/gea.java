import com.tencent.mobileqq.jsbridge.WebBridge.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public class gea
  implements Runnable
{
  public gea(WebBridge.JsBridgeListener paramJsBridgeListener, String paramString, WebView paramWebView) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("responseId", this.jdField_a_of_type_ComTencentMobileqqJsbridgeWebBridge$JsBridgeListener.jdField_a_of_type_JavaLangString);
      localJSONObject.put("responseData", new JSONObject("{'result':-1,'message':'" + this.jdField_a_of_type_JavaLangString + "'}"));
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
 * Qualified Name:     gea
 * JD-Core Version:    0.7.0.1
 */