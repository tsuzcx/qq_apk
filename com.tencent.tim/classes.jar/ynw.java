import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ynw
  implements View.OnClickListener
{
  public ynw(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((TextUtils.isEmpty(this.this$0.aN.getText())) || (this.this$0.mSource == ClassificationSearchActivity.caf))
    {
      localObject = (InputMethodManager)this.this$0.getSystemService("input_method");
      if ((localObject != null) && (((InputMethodManager)localObject).isActive())) {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(this.this$0.getWindow().getDecorView().getWindowToken(), 0);
      }
      this.this$0.setResult(0);
      this.this$0.finish();
      if ((this.this$0.mSource == ClassificationSearchActivity.cag) || (this.this$0.mSource == ClassificationSearchActivity.cah)) {
        this.this$0.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = this.this$0.aN.getText().toString();
      if ((this.this$0.mSource == ClassificationSearchActivity.cad) && (!TextUtils.isEmpty(((String)localObject).trim())))
      {
        this.this$0.oR((String)localObject);
        ClassificationSearchActivity.a(this.this$0, (String)localObject);
        kbp.a(null, "dc00899", "Pb_account_lifeservice", "", "0X80067C4", "0X80067C4", 0, 0, "", "", (String)localObject, "", true);
      }
      else if (this.this$0.mSource == ClassificationSearchActivity.cag)
      {
        kbp.a(null, "", "0X800742D", "0X800742D", 0, 0, (String)localObject, "", "", "");
        ClassificationSearchActivity.a(this.this$0, (String)localObject);
      }
      else
      {
        this.this$0.a.bc((String)localObject, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ynw
 * JD-Core Version:    0.7.0.1
 */