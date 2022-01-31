import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;

class xlf
  implements bcfb
{
  xlf(xlb paramxlb, long paramLong, String paramString) {}
  
  public void onCheckOfflineFinish(int paramInt)
  {
    this.jdField_a_of_type_Xlb.c = ((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long));
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "onCheckOfflineFinish, cost: " + this.jdField_a_of_type_Xlb.c + ", url: " + nau.b(this.jdField_a_of_type_JavaLangString, new String[0]));
    }
    this.jdField_a_of_type_Xlb.a(this.jdField_a_of_type_JavaLangString, paramInt);
    CustomWebView localCustomWebView = this.jdField_a_of_type_Xlb.mRuntime.a();
    if (localCustomWebView != null)
    {
      localCustomWebView.loadUrlOriginal(this.jdField_a_of_type_JavaLangString);
      return;
    }
    QLog.e("OfflinePluginQQ", 1, "error!!!! webview is null, now can not loadUrl " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xlf
 * JD-Core Version:    0.7.0.1
 */