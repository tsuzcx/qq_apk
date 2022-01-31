import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class zed
  implements aoil
{
  public zed(NewerGuidePlugin paramNewerGuidePlugin, IphonePickerView paramIphonePickerView, bhuf parambhuf) {}
  
  public void a()
  {
    int i = NewerGuidePlugin.b(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin) + 1897;
    int j = NewerGuidePlugin.c(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin) + 1;
    int k = NewerGuidePlugin.d(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin) + 1;
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("onDismissOperations year=%s month=%s day=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if ((this.jdField_a_of_type_Bhuf != null) && (this.jdField_a_of_type_Bhuf.isShowing())) {
      this.jdField_a_of_type_Bhuf.dismiss();
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", 1);
      localJSONObject.put("year", i);
      localJSONObject.put("month", j);
      localJSONObject.put("date", k);
      this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin.callJs("respDatePicker", new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("NewerGuidePlugin", 1, "sendDatePickerResp fail", localException);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null) && ((paramInt1 == 0) || (paramInt1 == 1))) {
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
      }
      return;
      NewerGuidePlugin.b(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin, paramInt2);
      continue;
      NewerGuidePlugin.c(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin, paramInt2);
      continue;
      NewerGuidePlugin.d(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zed
 * JD-Core Version:    0.7.0.1
 */