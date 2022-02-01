import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.c;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class str
  implements IphonePickerView.c
{
  public str(NewerGuidePlugin paramNewerGuidePlugin, IphonePickerView paramIphonePickerView, ausj paramausj) {}
  
  public void dn()
  {
    int i = NewerGuidePlugin.b(this.a) + 1897;
    int j = NewerGuidePlugin.c(this.a) + 1;
    int k = NewerGuidePlugin.d(this.a) + 1;
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("onDismissOperations year=%s month=%s day=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if ((this.val$actionSheet != null) && (this.val$actionSheet.isShowing())) {
      this.val$actionSheet.dismiss();
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", 1);
      localJSONObject.put("year", i);
      localJSONObject.put("month", j);
      localJSONObject.put("date", k);
      this.a.callJs("respDatePicker", new String[] { localJSONObject.toString() });
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
  
  public void w(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if ((this.e != null) && ((paramInt1 == 0) || (paramInt1 == 1))) {
        this.e.LV(2);
      }
      return;
      NewerGuidePlugin.b(this.a, paramInt2);
      continue;
      NewerGuidePlugin.c(this.a, paramInt2);
      continue;
      NewerGuidePlugin.d(this.a, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     str
 * JD-Core Version:    0.7.0.1
 */