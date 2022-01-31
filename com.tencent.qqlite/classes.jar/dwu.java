import android.app.Activity;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

class dwu
  implements Runnable
{
  dwu(dwt paramdwt, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Activity localActivity = this.jdField_a_of_type_Dwt.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    do
    {
      return;
      try
      {
        if ((!"2".equals(this.jdField_a_of_type_Dwt.d)) && (!"3".equals(this.jdField_a_of_type_Dwt.d))) {
          break;
        }
        QQApiPlugin.a(this.jdField_a_of_type_Dwt.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin, this.jdField_a_of_type_Dwt.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Dwt.d, this.jdField_a_of_type_Dwt.e, this.jdField_a_of_type_Dwt.f, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Dwt.g, this.c);
        return;
      }
      catch (JSONException localJSONException) {}
    } while (!QLog.isColorLevel());
    QLog.d("QQApi", 2, "shareMsg error: " + localJSONException.toString());
    return;
    QQApiPlugin.b(this.jdField_a_of_type_Dwt.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin, this.jdField_a_of_type_Dwt.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Dwt.d, this.jdField_a_of_type_Dwt.e, this.jdField_a_of_type_Dwt.f, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Dwt.g, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dwu
 * JD-Core Version:    0.7.0.1
 */