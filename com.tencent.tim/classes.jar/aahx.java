import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager.27.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_dc00307;
import cooperation.qzone.report.lp.LpReportManager;
import java.net.URLEncoder;
import mqq.os.MqqHandler;

public class aahx
  implements View.OnClickListener
{
  aahx(aahb paramaahb, String paramString, Long paramLong, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!aahb.a(this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aahb.a(this.this$0, false);
      new Handler().postDelayed(new BannerManager.27.1(this), 1000L);
      Object localObject1 = (QQAppInterface)aahb.a(this.this$0).getAppRuntime();
      String str = ((QQAppInterface)localObject1).getCurrentAccountUin();
      Object localObject2 = new StringBuilder(this.bdf);
      ((StringBuilder)localObject2).append("?");
      ((StringBuilder)localObject2).append("uin=");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("&plat=1");
      ((StringBuilder)localObject2).append("&app=1");
      ((StringBuilder)localObject2).append("&version=3.4.4.3058");
      ((StringBuilder)localObject2).append("&device=" + URLEncoder.encode(Build.DEVICE));
      ((StringBuilder)localObject2).append("&system=" + Build.VERSION.RELEASE);
      ((StringBuilder)localObject2).append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
      localObject2 = ((StringBuilder)localObject2).toString();
      Intent localIntent = new Intent();
      localIntent.putExtra("portraitOnly", true);
      localIntent.putExtra("url", (String)localObject2);
      localIntent.putExtra("uin", str);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      VasWebviewUtil.openQQBrowserActivity(aahb.a(this.this$0), (String)localObject2, 32768L, localIntent, false, -1);
      if (this.O.longValue() == 3L)
      {
        localObject1 = ((QQAppInterface)localObject1).getHandler(Conversation.class);
        if (localObject1 == null) {}
      }
      try
      {
        ((MqqHandler)localObject1).sendMessage(((MqqHandler)localObject1).obtainMessage(1134044));
        localObject1 = new LpReportInfo_dc00307(LpReportInfo_dc00307.ACTION_TYPE_RED_PACK, LpReportInfo_dc00307.SUB_ACTION_TYPE_RED_PACK_CLICK, this.Og);
        LpReportManager.getInstance().reportToDC00307((LpReportInfo_dc00307)localObject1, false, true);
        anot.c(aahb.a(this.this$0).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 9, 0, "", "", "", "");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.fillInStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aahx
 * JD-Core Version:    0.7.0.1
 */