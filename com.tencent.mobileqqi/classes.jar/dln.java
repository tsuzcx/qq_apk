import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.international.LocaleUtil;

public class dln
  implements View.OnClickListener
{
  public dln(RegisterPhoneNumActivity paramRegisterPhoneNumActivity) {}
  
  public void onClick(View paramView)
  {
    if (!RegisterPhoneNumActivity.a(this.a)) {
      return;
    }
    RegisterPhoneNumActivity.a(this.a, false);
    this.a.b.postDelayed(new dlo(this), 1000L);
    paramView = new Intent(this.a, QQBrowserActivity.class);
    if (LocaleUtil.a(this.a.getApplicationContext()) == 2) {
      this.a.f = this.a.f.replace("{language}", "ch_simple");
    }
    for (;;)
    {
      paramView.putExtra("url", this.a.f);
      this.a.startActivity(paramView);
      return;
      if (LocaleUtil.a(this.a.getApplicationContext()) == 3) {
        this.a.f = this.a.f.replace("{language}", "ch_chT");
      } else if (LocaleUtil.a(this.a.getApplicationContext()) == 1) {
        this.a.f = this.a.f.replace("{language}", "English");
      } else if (LocaleUtil.a(this.a.getApplicationContext()) == 4) {
        this.a.f = this.a.f.replace("{language}", "Japanese");
      } else if (LocaleUtil.a(this.a.getApplicationContext()) == 5) {
        this.a.f = this.a.f.replace("{language}", "Korean");
      } else if (LocaleUtil.a(this.a.getApplicationContext()) == 6) {
        this.a.f = this.a.f.replace("{language}", "Deutsch");
      } else if (LocaleUtil.a(this.a.getApplicationContext()) == 7) {
        this.a.f = this.a.f.replace("{language}", "Fran");
      } else if (LocaleUtil.a(this.a.getApplicationContext()) == 8) {
        this.a.f = this.a.f.replace("{language}", "Espa");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dln
 * JD-Core Version:    0.7.0.1
 */