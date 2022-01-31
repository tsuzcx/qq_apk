import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.export.js.VipDownloadInterface;
import com.tencent.smtt.sdk.WebView;

public class hos
  implements Runnable
{
  public hos(VipDownloadInterface paramVipDownloadInterface, String paramString) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentOpenExportJsVipDownloadInterface.jdField_a_of_type_ComTencentSmttSdkWebView != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentOpenExportJsVipDownloadInterface.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception localException)
    {
      LogUtility.a(this.jdField_a_of_type_ComTencentOpenExportJsVipDownloadInterface.jdField_a_of_type_JavaLangString, "webview loadUrl>>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hos
 * JD-Core Version:    0.7.0.1
 */