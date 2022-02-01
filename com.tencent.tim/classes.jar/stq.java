import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.c;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class stq
  implements IphonePickerView.c
{
  public stq(NewerGuidePlugin paramNewerGuidePlugin, ausj paramausj) {}
  
  public void dn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("onConfirmBtClicked mSelectedIndex=%s", new Object[] { Integer.valueOf(NewerGuidePlugin.a(this.a)) }));
    }
    if ((this.val$actionSheet != null) && (this.val$actionSheet.isShowing())) {
      this.val$actionSheet.dismiss();
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", 1);
      localJSONObject.put("index", NewerGuidePlugin.a(this.a));
      this.a.callJs("respSelector", new String[] { localJSONObject.toString() });
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
  
  public void w(int paramInt1, int paramInt2)
  {
    NewerGuidePlugin.a(this.a, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     stq
 * JD-Core Version:    0.7.0.1
 */