import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
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

public class xc
  implements View.OnClickListener
{
  public xc(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = AddFriendVerifyActivity.a(this.a).getText().toString().trim();
    if (TextUtils.isEmpty(paramView))
    {
      if (!this.a.isFinishing()) {
        QQToast.a(this.a, 1, this.a.getString(2131363389), 0).b(this.a.getTitleBarHeight());
      }
      return;
    }
    if (paramView.length() > 30)
    {
      paramView = new Dialog(this.a, 2131624119);
      paramView.setContentView(2130903615);
      ((TextView)paramView.findViewById(2131296470)).setText(this.a.getString(2131363513));
      ((ProgressBar)paramView.findViewById(2131296469)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131298746)).setImageResource(2130837991);
      paramView.show();
      return;
    }
    this.a.a(paramView, true);
    if (NetworkUtil.e(this.a))
    {
      AddFriendVerifyActivity.a(this.a, AddFriendVerifyActivity.a(this.a), paramView, this.a.getIntent().getIntExtra("stat_option", 0));
      this.a.a.b(2131363378);
      this.a.a.show();
      return;
    }
    QQToast.a(this.a, 1, 2131363515, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     xc
 * JD-Core Version:    0.7.0.1
 */