import MQQ.PayRuleCfg;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;

public class vpm
  implements View.OnClickListener
{
  public vpm(QQSettingMe paramQQSettingMe) {}
  
  public void onClick(View paramView)
  {
    if (QQSettingMe.a(this.this$0) == null) {}
    Object localObject;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QQSettingMe.a(this.this$0).clickHide == 1)
      {
        QQSettingMe.a(this.this$0).enable = 0;
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler click clear enable");
        acny.a(this.this$0.app.getCurrentUin(), QQSettingMe.a(this.this$0));
      }
      anot.b(null, "dc00898", "", "", "", "0X800A633", acny.a(QQSettingMe.a(this.this$0)), 1, 0, "1", QQSettingMe.a(this.this$0).advId, "", "");
      acny.cf(102, QQSettingMe.a(this.this$0).advId);
      if (!TextUtils.isEmpty(QQSettingMe.a(this.this$0).iconJumpUrl))
      {
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler click iconJumpUrl: " + QQSettingMe.a(this.this$0).iconJumpUrl);
        localObject = new Intent(this.this$0.c, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject).putExtra("url", QQSettingMe.a(this.this$0).iconJumpUrl);
        ((Intent)localObject).putExtra("isShowAd", false);
        this.this$0.c.startActivity((Intent)localObject);
      }
      else
      {
        switch (QQSettingMe.a(this.this$0).clubType)
        {
        default: 
          QLog.e("QQSettingRedesign", 1, "VipInfoHandler unknown clubType=" + QQSettingMe.a(this.this$0).clubType);
        }
      }
    }
    for (int i = 11;; i = 12)
    {
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler click type: " + QQSettingMe.a(this.this$0).clubType);
      localObject = URLEncoder.encode("jsbridge://vipclub/paySuccess?p={\"type\":" + i + "}");
      aqrf.a(this.this$0.c, QQSettingMe.a(this.this$0).aid, "CJCLUBT", 3, false, false, "", (String)localObject, true, true);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vpm
 * JD-Core Version:    0.7.0.1
 */