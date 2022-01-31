import android.content.Intent;
import android.os.Build;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.QZoneHelper;

class bku
  implements ActionSheet.OnButtonClickListener
{
  bku(bkt parambkt) {}
  
  public void a(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      for (;;)
      {
        SplashActivity.a(this.a.a).dismiss();
        return;
        SplashActivity.a(this.a.a);
        continue;
        SplashActivity.b(this.a.a);
        continue;
        SplashActivity.c(this.a.a);
        continue;
        this.a.a.g();
      }
    }
    paramView = "&version=3.4.0.607&appid=" + AppSetting.a + "&QUA=" + QZoneHelper.a() + "&sid=" + this.a.a.app.getSid();
    paramView = paramView + "&adtag=607";
    String str = "http://mma.qq.com/feedback/qqlite.html#_rc=mqq_faq_feedback?fid=1113" + paramView;
    if (QLog.isColorLevel()) {
      QLog.i("About-Feedback", 2, "feedfack before: url = " + str);
    }
    paramView = Build.MODEL;
    if (paramView != null)
    {
      paramView = paramView.replaceAll(" ", "_");
      label246:
      localObject = Build.MANUFACTURER;
      if (localObject == null) {
        break label500;
      }
    }
    label500:
    for (Object localObject = ((String)localObject).replaceAll(" ", "_");; localObject = "")
    {
      for (;;)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str).append("&model=").append(paramView).append("&manufacture=").append((String)localObject).append("&cpunum=").append(DeviceInfoUtil.b()).append("&cpurate=").append(DeviceInfoUtil.a()).append("&mem=").append(DeviceInfoUtil.c() / 1024L / 1024L).append("&amem=").append(DeviceInfoUtil.d() / 1024L / 1024L).append("&w=").append(DeviceInfoUtil.f()).append("&h=").append(DeviceInfoUtil.g());
        paramView = localStringBuilder.toString();
        if (QLog.isColorLevel()) {
          QLog.i("About-Feedback", 2, "feedfack after: url = " + paramView);
        }
        localObject = new Intent(SplashActivity.a(), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("portraitOnly", true);
        ((Intent)localObject).putExtra("url", paramView).putExtra("bFormatUrl", false);
        ((Intent)localObject).putExtra("uin", this.a.a.app.a());
        ((Intent)localObject).putExtra("reportMsfLog", true);
        try
        {
          SplashActivity.a().startActivity((Intent)localObject);
        }
        catch (SecurityException paramView) {}
      }
      break;
      paramView = "";
      break label246;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bku
 * JD-Core Version:    0.7.0.1
 */