import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.smtt.sdk.WebView;

public final class dhk
  implements Runnable
{
  public dhk(WebView paramWebView, String paramString) {}
  
  public void run()
  {
    try
    {
      ((CustomWebView)this.jdField_a_of_type_ComTencentSmttSdkWebView).a("javascript:" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dhk
 * JD-Core Version:    0.7.0.1
 */