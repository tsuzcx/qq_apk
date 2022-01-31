import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class bkv
  implements View.OnClickListener
{
  public bkv(SplashActivity paramSplashActivity) {}
  
  public void onClick(View paramView)
  {
    if (SplashActivity.a(this.a) == null)
    {
      SplashActivity.a(this.a, (ActionSheet)ActionSheetHelper.a(this.a, null));
      SplashActivity.a(this.a).c(this.a.getString(2131363980));
      SplashActivity.a(this.a).c(this.a.getString(2131363356));
      SplashActivity.a(this.a).c(this.a.getString(2131363770));
      SplashActivity.a(this.a).c(this.a.getString(2131364088));
      if (SplashActivity.c()) {
        SplashActivity.a(this.a).c(this.a.getString(2131363741));
      }
    }
    SplashActivity.a(this.a).a(new bkw(this));
    SplashActivity.a(this.a).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bkv
 * JD-Core Version:    0.7.0.1
 */