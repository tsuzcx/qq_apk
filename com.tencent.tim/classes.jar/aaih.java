import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager.36.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;
import mqq.os.MqqHandler;

public class aaih
  implements View.OnClickListener
{
  aaih(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    if (!aahb.a(this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aahb.a(this.this$0, false);
      new Handler().postDelayed(new BannerManager.36.1(this), 1000L);
      QQAppInterface localQQAppInterface = (QQAppInterface)aahb.a(this.this$0).getAppRuntime();
      String str = localQQAppInterface.getCurrentAccountUin();
      Object localObject = new StringBuilder("https://aq.qq.com/cn2/change_psw/mobile/mobile_change_psw_reg_input_psw");
      ((StringBuilder)localObject).append("?");
      ((StringBuilder)localObject).append("uin=");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("&plat=1");
      ((StringBuilder)localObject).append("&app=1");
      ((StringBuilder)localObject).append("&version=3.4.4.3058");
      ((StringBuilder)localObject).append("&device=" + URLEncoder.encode(Build.DEVICE));
      ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
      ((StringBuilder)localObject).append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
      localObject = ((StringBuilder)localObject).toString();
      Intent localIntent = new Intent();
      localIntent.putExtra("portraitOnly", true);
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("uin", str);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      VasWebviewUtil.openQQBrowserActivity(aahb.a(this.this$0), (String)localObject, 32768L, localIntent, false, -1);
      akwp.a().dC(localQQAppInterface);
      aahb.a(this.this$0).sendEmptyMessageDelayed(4, 1000L);
      anot.a(localQQAppInterface, "CliOper", "", "", "Mobile_signup", "Clk_blue_pw", 0, 0, "", "", "", "");
      anot.c(aahb.a(this.this$0).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 18, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaih
 * JD-Core Version:    0.7.0.1
 */