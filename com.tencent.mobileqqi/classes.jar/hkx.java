import android.text.TextUtils;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

public class hkx
  implements Runnable
{
  public hkx(DownloadInterface paramDownloadInterface, String paramString) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.webview != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.webview.loadUrl(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception localException)
    {
      LogUtility.a(this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.TAG, "webview loadUrl>>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hkx
 * JD-Core Version:    0.7.0.1
 */