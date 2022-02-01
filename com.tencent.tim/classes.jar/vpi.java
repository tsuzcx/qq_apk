import MQQ.PayRuleCfg;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;

public class vpi
  extends Handler
{
  public vpi(QQSettingMe paramQQSettingMe, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.this$0.bTI();
      return;
    case 1: 
      QQSettingMe.a(this.this$0);
      return;
    case 2: 
      this.this$0.bTV();
      return;
    }
    int i = ((Bundle)paramMessage.obj).getInt("type");
    QLog.e("QQSettingRedesign", 1, "VipInfoHandler paySuccess " + i);
    if ((QQSettingMe.a(this.this$0) != null) && (QQSettingMe.a(this.this$0).payHide == 1))
    {
      QQSettingMe.a(this.this$0).enable = 0;
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler paySuccess clear bubble");
      acny.a(this.this$0.app.getCurrentUin(), QQSettingMe.a(this.this$0));
      sendEmptyMessage(2);
    }
    aqvl.d(this.this$0.app, "last_pull_pay_rule", 0L);
    paramMessage = ((TicketManager)this.this$0.app.getManager(2)).getSkey(this.this$0.app.getCurrentAccountUin());
    ((acny)this.this$0.app.getBusinessHandler(27)).fg(paramMessage, this.this$0.app.getCurrentUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vpi
 * JD-Core Version:    0.7.0.1
 */