import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class wz
  implements View.OnClickListener
{
  public wz(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    if (AddFriendVerifyActivity.a(this.a).getText().toString().length() > 30)
    {
      paramView = new Dialog(this.a, 2131624120);
      paramView.setContentView(2130903608);
      ((TextView)paramView.findViewById(2131296473)).setText(this.a.getString(2131363525));
      ((ProgressBar)paramView.findViewById(2131296472)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131298721)).setImageResource(2130838006);
      paramView.show();
      return;
    }
    this.a.a(AddFriendVerifyActivity.a(this.a).getText().toString(), true);
    if (NetworkUtil.e(this.a))
    {
      AddFriendVerifyActivity.a(this.a, AddFriendVerifyActivity.a(this.a), AddFriendVerifyActivity.a(this.a).getText().toString(), this.a.getIntent().getIntExtra("stat_option", 0));
      this.a.a.b(2131363392);
      this.a.a.show();
      return;
    }
    QQToast.a(this.a, 1, 2131363527, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     wz
 * JD-Core Version:    0.7.0.1
 */