import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class bkt
  implements View.OnClickListener
{
  public bkt(SplashActivity paramSplashActivity) {}
  
  public void onClick(View paramView)
  {
    if (SplashActivity.a(this.a) == null)
    {
      SplashActivity.a(this.a, (ActionSheet)ActionSheetHelper.a(this.a, null));
      SplashActivity.a(this.a).c(this.a.getString(2131363969));
      SplashActivity.a(this.a).c(this.a.getString(2131363359));
      SplashActivity.a(this.a).c(this.a.getString(2131363762));
      SplashActivity.a(this.a).c(this.a.getString(2131364075));
      if (SplashActivity.c()) {
        SplashActivity.a(this.a).c(this.a.getString(2131363734));
      }
    }
    SplashActivity.a(this.a).a(new bku(this));
    SplashActivity.a(this.a).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bkt
 * JD-Core Version:    0.7.0.1
 */