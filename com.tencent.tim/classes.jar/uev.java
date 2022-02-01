import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class uev
  implements View.OnClickListener
{
  public uev(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.d != null)
    {
      this.this$0.getWindow().setSoftInputMode(2);
      this.this$0.d.hideSoftInputFromWindow(this.this$0.aq.getWindowToken(), 0);
      this.this$0.aq.clearFocus();
    }
    Object localObject;
    if (this.this$0.aq.getText().toString().length() > 30)
    {
      localObject = new ReportDialog(this.this$0, 2131756467);
      ((Dialog)localObject).setContentView(2131562991);
      ((TextView)((Dialog)localObject).findViewById(2131365863)).setText(this.this$0.getString(2131692107));
      ((ProgressBar)((Dialog)localObject).findViewById(2131367453)).setVisibility(8);
      ((ImageView)((Dialog)localObject).findViewById(2131381312)).setImageResource(2130840117);
      ((Dialog)localObject).show();
    }
    label351:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = this.this$0.aq.getText().toString().trim();
      this.this$0.aN((String)localObject, false);
      if ((this.this$0.getString(2131693133).equals(localObject)) && (!AddFriendVerifyActivity.b(this.this$0))) {
        AddFriendVerifyActivity.a(this.this$0);
      }
      this.this$0.uS(this.this$0.aq.getText().toString().trim());
      if (this.bDK == 0) {
        anot.a(this.this$0.app, "dc00898", "", "", "0X800796F", "0X800796F", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (TextUtils.isEmpty(this.this$0.aKJ)) {
          break label351;
        }
        anot.a(this.this$0.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
        break;
        anot.a(this.this$0.app, "dc00898", "", "", "0X8007976", "0X8007976", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uev
 * JD-Core Version:    0.7.0.1
 */