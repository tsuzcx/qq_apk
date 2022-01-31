import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class ww
  implements View.OnClickListener
{
  public ww(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    if (AddFriendVerifyActivity.a(this.a).getText().toString().length() > 30)
    {
      paramView = new Dialog(this.a, 2131624119);
      paramView.setContentView(2130903599);
      ((TextView)paramView.findViewById(2131296470)).setText(this.a.getString(2131363514));
      ((ProgressBar)paramView.findViewById(2131296469)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131298695)).setImageResource(2130837987);
      paramView.show();
      return;
    }
    this.a.a(AddFriendVerifyActivity.a(this.a).getText().toString(), true);
    if (NetworkUtil.e(this.a))
    {
      AddFriendVerifyActivity.a(this.a, AddFriendVerifyActivity.a(this.a), AddFriendVerifyActivity.a(this.a).getText().toString(), this.a.getIntent().getIntExtra("stat_option", 0));
      if ("d2g".equals(this.a.getIntent().getStringExtra("jump_from"))) {
        ReportController.b(this.a.app, "P_CliOper", "Grp_discuss", "", "discuss_set", "send_ask", 0, 0, AddFriendVerifyActivity.a(this.a), "", "", "");
      }
      this.a.a.b(2131363381);
      this.a.a.show();
      return;
    }
    QQToast.a(this.a, 1, 2131363516, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ww
 * JD-Core Version:    0.7.0.1
 */