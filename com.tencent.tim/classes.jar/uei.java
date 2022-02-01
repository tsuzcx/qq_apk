import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class uei
  implements View.OnClickListener
{
  public uei(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    if (!AddFriendVerifyActivity.a(this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.this$0.d != null)
      {
        this.this$0.getWindow().setSoftInputMode(2);
        this.this$0.d.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.this$0).getWindowToken(), 0);
        AddFriendVerifyActivity.a(this.this$0).clearFocus();
      }
      if (AddFriendVerifyActivity.a(this.this$0).getText().toString().length() > 90)
      {
        ReportDialog localReportDialog = new ReportDialog(this.this$0, 2131756467);
        localReportDialog.setContentView(2131562991);
        ((TextView)localReportDialog.findViewById(2131365863)).setText(this.this$0.getString(2131692107));
        ((ProgressBar)localReportDialog.findViewById(2131367453)).setVisibility(8);
        ((ImageView)localReportDialog.findViewById(2131381312)).setImageResource(2130840117);
        localReportDialog.show();
      }
      else
      {
        this.this$0.aN(AddFriendVerifyActivity.a(this.this$0).getText().toString(), true);
        if (aqiw.isNetSupport(this.this$0))
        {
          if (AddFriendVerifyActivity.a(this.this$0) != null) {}
          for (int i = AddFriendVerifyActivity.a(this.this$0).uG();; i = 2000)
          {
            QLog.e("AddFriendVerifyActivity", 1, "joinTroop templateId: " + i);
            AddFriendVerifyActivity.a(this.this$0, AddFriendVerifyActivity.a(this.this$0), AddFriendVerifyActivity.a(this.this$0).getText().toString(), this.this$0.getIntent().getIntExtra("stat_option", 0), i);
            anot.a(null, "dc00898", "", "", "qq_vip", "0X800A62B", xko.fj(i), 0, "", "", "", "");
            if (!"d2g".equals(this.this$0.getIntent().getStringExtra("jump_from"))) {
              break;
            }
            anot.a(this.this$0.app, "P_CliOper", "Grp_discuss", "", "discuss_set", "send_ask", 0, 0, AddFriendVerifyActivity.a(this.this$0), "", "", "");
            break;
          }
        }
        QQToast.a(this.this$0, 1, 2131696272, 0).show(this.this$0.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uei
 * JD-Core Version:    0.7.0.1
 */