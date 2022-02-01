package mqq.app;

import android.content.Intent;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.QLog;

class MobileQQ$1
  implements Runnable
{
  MobileQQ$1(MobileQQ paramMobileQQ, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      if (MobileQQ.access$000(this.this$0) == null) {
        this.this$0.waitAppRuntime(null);
      }
      if (!this.this$0.getQQProcessName().endsWith(":video"))
      {
        MobileQQ.access$000(this.this$0).onDestroy();
        if (!this.val$callByMSF) {
          MobileQQ.access$100(this.this$0).msfSub.unRegisterMsfService();
        }
        MobileQQ.access$100(this.this$0).msfSub.unbindMsfService();
      }
      if (MobileQQ.access$200(this.this$0))
      {
        Object localObject = new Intent("mqq.intent.action.EXIT_" + MobileQQ.processName);
        this.this$0.sendBroadcast((Intent)localObject);
        localObject = this.this$0.getQQProcessName();
        if ((((String)localObject).equals("com.tencent.tim")) && (MobileQQ.access$300(this.this$0)))
        {
          QLog.d("mqq", 1, "stop msf service");
          MobileQQ.access$100(this.this$0).msfSub.stopMsfService();
          System.exit(0);
          return;
        }
        if (((String)localObject).endsWith(":video")) {
          MobileQQ.access$000(this.this$0).onDestroy();
        }
        System.exit(0);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "exit exception=" + localException);
      }
      System.exit(0);
      return;
    }
    MobileQQ.access$400(this.this$0).run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.MobileQQ.1
 * JD-Core Version:    0.7.0.1
 */