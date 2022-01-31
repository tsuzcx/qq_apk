import android.app.Activity;
import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import org.json.JSONObject;

public class yzp
{
  public yzp(NewerGuidePlugin paramNewerGuidePlugin, JSONObject paramJSONObject, Activity paramActivity) {}
  
  @QQPermissionDenied(1)
  public void deniedReadContacts()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "deniedReadContacts");
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 0);
      this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin.callJs("respUploadContacts", new String[] { localJSONObject.toString() });
      bdfq.showPermissionSettingDialog(this.jdField_a_of_type_AndroidAppActivity, alpo.a(2131707809));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("NewerGuidePlugin", 1, "deniedReadContacts fail.", localException);
    }
  }
  
  @QQPermissionGrant(1)
  public void grandReadContacts()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "grandReadContacts");
    }
    try
    {
      NewerGuidePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin, this.jdField_a_of_type_OrgJsonJSONObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("NewerGuidePlugin", 1, "grandReadContacts fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yzp
 * JD-Core Version:    0.7.0.1
 */