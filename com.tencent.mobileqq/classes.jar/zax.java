import android.text.TextUtils;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class zax
  implements Runnable
{
  String jdField_a_of_type_JavaLangString = null;
  
  zax(BrowserAppInterface paramBrowserAppInterface, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApp(), this.jdField_a_of_type_JavaLangString, 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zax
 * JD-Core Version:    0.7.0.1
 */