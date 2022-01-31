import android.app.Activity;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

class dxx
  implements Runnable
{
  dxx(dxw paramdxw, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Activity localActivity = this.jdField_a_of_type_Dxw.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    do
    {
      return;
      try
      {
        if ((!"2".equals(this.jdField_a_of_type_Dxw.d)) && (!"3".equals(this.jdField_a_of_type_Dxw.d))) {
          break;
        }
        QQApiPlugin.a(this.jdField_a_of_type_Dxw.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin, this.jdField_a_of_type_Dxw.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Dxw.d, this.jdField_a_of_type_Dxw.e, this.jdField_a_of_type_Dxw.f, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Dxw.g, this.c);
        return;
      }
      catch (JSONException localJSONException) {}
    } while (!QLog.isColorLevel());
    QLog.d("QQApi", 2, "shareMsg error: " + localJSONException.toString());
    return;
    QQApiPlugin.b(this.jdField_a_of_type_Dxw.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin, this.jdField_a_of_type_Dxw.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Dxw.d, this.jdField_a_of_type_Dxw.e, this.jdField_a_of_type_Dxw.f, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Dxw.g, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dxx
 * JD-Core Version:    0.7.0.1
 */