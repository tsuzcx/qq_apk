import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper.2.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class wwp
  implements View.OnClickListener
{
  wwp(wwn paramwwn) {}
  
  public void onClick(View paramView)
  {
    try
    {
      anot.a(wwn.a(this.a), "P_CliOper", "Vip_pay_mywallet", "", "500", "idiom.tips.click", 0, 0, "", "", "", "");
      wwn.a(this.a).getUIHandler().postDelayed(new QWalletAIOLifeCycleHelper.2.1(this), 200L);
      this.a.ccE();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("QWalletAIOLifeCycleHelper", 1, "onclick  IdiomRedBagTips throw an exception: " + localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wwp
 * JD-Core Version:    0.7.0.1
 */