import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AboutActivity;

public class uu
  implements View.OnClickListener
{
  public uu(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    AboutActivity.a(this.a);
    if (AboutActivity.b(this.a) < 6) {
      return;
    }
    paramView = AppSetting.a(this.a);
    String str = ((TelephonyManager)this.a.getSystemService("phone")).getDeviceId();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("渠道号:").append(paramView).append("\n\r").append("IMEI:").append(str);
    AboutActivity.a(this.a, localStringBuilder.toString());
    AboutActivity.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     uu
 * JD-Core Version:    0.7.0.1
 */