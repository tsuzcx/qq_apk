import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class zem
  implements nbs
{
  zem(zej paramzej, JsBridgeListener paramJsBridgeListener) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject();
        paramString.put("retcode", -1);
        paramString.put("msg", "error");
        this.jdField_a_of_type_Zej.callJs(this.jdField_a_of_type_Zej.jdField_a_of_type_JavaLangString, new String[] { paramString.toString() });
        return;
      }
      catch (JSONException paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, batchCheckUpdate, JSONException :" + paramString);
        return;
      }
    }
    Message localMessage = Message.obtain();
    localMessage.what = 121;
    localMessage.obj = new Object[] { this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener, paramString };
    this.jdField_a_of_type_Zej.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zem
 * JD-Core Version:    0.7.0.1
 */