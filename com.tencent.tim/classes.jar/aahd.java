import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.UpgradeTIMManager;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aahd
  implements View.OnClickListener
{
  aahd(aahb paramaahb, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "UpgradeTIMWrapper click banner, jump");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)aahb.a(this.this$0).getAppRuntime();
    ((UpgradeTIMManager)localQQAppInterface.getManager(256)).cl(aahb.a(this.this$0), this.b.cja);
    anot.a(localQQAppInterface, "CliOper", "", "", "0X8008659", "0X8008659", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aahd
 * JD-Core Version:    0.7.0.1
 */