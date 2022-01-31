import android.os.Handler;
import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

public class bor
  implements AsyncCallBack
{
  public bor(OfflinePlugin paramOfflinePlugin, long paramLong) {}
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(OfflinePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin), 2, "webviewLoadUrl calll back. param2:" + paramString2 + "," + " time:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.jdField_a_of_type_Int = Integer.parseInt(paramString2);
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.jdField_a_of_type_Int == -1)
    {
      ((CustomWebView)this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.mRuntime.a()).a(paramString1);
      return;
    }
    paramString2 = this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    paramString2.arg1 = 1;
    paramString2.arg2 = this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.jdField_a_of_type_Int;
    paramString2.obj = paramString1;
    this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bor
 * JD-Core Version:    0.7.0.1
 */