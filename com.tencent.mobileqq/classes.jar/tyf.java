import com.tencent.mobileqq.activity.SpaceLowNoticeActiviy;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.view.ApolloGameHotChatController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.qphone.base.util.QLog;

public class tyf
  implements Runnable
{
  public tyf(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    long l = SpaceLowNoticeActiviy.a(this.a.app, "conf_space_low_shreshold", 104857600L);
    if (SpaceLowNoticeActiviy.a(SpaceLowNoticeActiviy.a(this.a.app, "conf_space_check_interval", 259200000L)))
    {
      if (SdCardUtil.b(this.a) + SdCardUtil.b() >= l) {
        break label146;
      }
      QLog.i("SplashActivity", 1, "qqclean conf did notice");
      SpaceLowNoticeActiviy.a(this.a);
      ReportController.b(this.a.app, "dc00898", "", "", "0X8007545", "0X8007545", 0, 0, this.a.app.getCurrentAccountUin(), "", "", "");
    }
    for (;;)
    {
      ApolloManager localApolloManager = (ApolloManager)this.a.app.getManager(152);
      if (localApolloManager != null) {
        localApolloManager.a().a(this.a.app, this.a);
      }
      return;
      label146:
      QLog.i("SplashActivity", 1, "qqclean conf not need notice");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tyf
 * JD-Core Version:    0.7.0.1
 */