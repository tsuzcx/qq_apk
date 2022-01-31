import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class xbx
  implements alxp
{
  public xbx(NewerGuidePlugin paramNewerGuidePlugin, begr parambegr) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("onConfirmBtClicked mSelectedIndex=%s", new Object[] { Integer.valueOf(NewerGuidePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin)) }));
    }
    if ((this.jdField_a_of_type_Begr != null) && (this.jdField_a_of_type_Begr.isShowing())) {
      this.jdField_a_of_type_Begr.dismiss();
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", 1);
      localJSONObject.put("index", NewerGuidePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin));
      this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin.callJs("respSelector", new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("NewerGuidePlugin", 1, "sendSelectorResp fail", localException);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    NewerGuidePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xbx
 * JD-Core Version:    0.7.0.1
 */