import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.AdvancedTipsBar;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class aeaq
  implements Manager
{
  QQAppInterface app;
  
  public aeaq(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public static aeaq a(QQAppInterface paramQQAppInterface)
  {
    return (aeaq)paramQQAppInterface.getManager(157);
  }
  
  private boolean agf()
  {
    long l = aqmj.be(this.app.getCurrentUin());
    return System.currentTimeMillis() - l < aelf.a().ft();
  }
  
  private void b(aahb paramaahb, Message paramMessage)
  {
    paramaahb.gm(18, 2);
    paramaahb.d(18, paramMessage);
    anot.c(this.app, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 23, 0, "", "", "", "");
  }
  
  private void o(BaseActivity paramBaseActivity)
  {
    Intent localIntent = aqin.d(this.app.getApp());
    if (BaseActivity.sTopActivity != null)
    {
      BaseActivity.sTopActivity.startActivity(localIntent);
      return;
    }
    paramBaseActivity.startActivity(localIntent);
  }
  
  public void a(aahb paramaahb)
  {
    paramaahb.gm(18, 0);
    paramaahb.d(-1, null);
  }
  
  public void a(aahb paramaahb, Message paramMessage)
  {
    if (agg())
    {
      b(paramaahb, paramMessage);
      return;
    }
    a(paramaahb);
  }
  
  public void a(aahb paramaahb, View paramView)
  {
    paramView = (TipsBar)paramView;
    a(paramaahb, null, paramView);
    paramaahb.a(paramView);
    if (agg())
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  public void a(aahb paramaahb, BaseActivity paramBaseActivity, TipsBar paramTipsBar)
  {
    String str1 = aelf.a().tw();
    String str2 = aelf.a().tx();
    paramTipsBar.setTipsIcon(this.app.getApp().getResources().getDrawable(2130842132));
    paramTipsBar.setTipsText(str1);
    paramTipsBar.getButton().setClickable(false);
    paramTipsBar.setButtonText(str2);
    paramTipsBar.TB(true);
    if ((paramTipsBar instanceof AdvancedTipsBar)) {
      ((AdvancedTipsBar)paramTipsBar).ehG();
    }
    paramTipsBar.getButton().setBackgroundResource(0);
    paramTipsBar.setCloseListener(new aear(this, paramaahb));
    if (paramBaseActivity != null) {
      paramTipsBar.setOriginalOnClickListener(new aeas(this, paramBaseActivity));
    }
    paramTipsBar.setVisibility(8);
  }
  
  public boolean age()
  {
    boolean bool = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplicationImpl.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("NotificationBannerManager", 2, new Object[] { "systemNotificationEnabled: invoked. ", " enable: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean agg()
  {
    boolean bool1 = aelf.a().visible();
    boolean bool2 = age();
    boolean bool3 = agf();
    if (QLog.isColorLevel()) {
      QLog.d("NotificationBannerManager", 2, new Object[] { "bannerVisible: invoked. ", " confVisible: ", Boolean.valueOf(bool1), " systemNotificationEnabled: ", Boolean.valueOf(bool2), " limitedByDuration: ", Boolean.valueOf(bool3) });
    }
    return (bool1) && (!bool2) && (!bool3);
  }
  
  public void cVw()
  {
    long l = System.currentTimeMillis();
    aqmj.bo(this.app.getCurrentUin(), l);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeaq
 * JD-Core Version:    0.7.0.1
 */