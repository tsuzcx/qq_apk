import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;

public class vs
  implements View.OnClickListener
{
  public vs(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!PhoneNumLoginImpl.a().a(this.a.app, this.a)) {}
    while ((this.a.b != null) && (this.a.b.isShowing())) {
      return;
    }
    AccountManageActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     vs
 * JD-Core Version:    0.7.0.1
 */