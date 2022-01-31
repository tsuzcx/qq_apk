import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

public class hou
  implements Runnable
{
  public hou(BaseInterface paramBaseInterface, long paramLong, String paramString, WebView paramWebView) {}
  
  public void run()
  {
    String str = "javascript:QzoneApp.fire('batchCallback',{guid:" + this.jdField_a_of_type_Long + ",'r':-2,'data':['" + this.jdField_a_of_type_JavaLangString + "']});";
    LogUtility.e("Response<callBatch>", str);
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(str);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hou
 * JD-Core Version:    0.7.0.1
 */