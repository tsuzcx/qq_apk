import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x438.oidb_0x438.RedBagInfo;

public class zxk
  extends Handler
{
  zxk(zxj paramzxj, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    boolean bool;
    if (paramMessage.arg1 == 1)
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "receive passwdredbags from group or disgroup, isSuccess = " + bool);
      }
      if (bool) {
        break label56;
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label56:
      if ((i == 1) || (i == 0))
      {
        ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.1.1(this, i));
        paramMessage = (List)paramMessage.obj;
        if (paramMessage != null)
        {
          paramMessage = paramMessage.iterator();
          while (paramMessage.hasNext())
          {
            oidb_0x438.RedBagInfo localRedBagInfo = (oidb_0x438.RedBagInfo)paramMessage.next();
            this.this$0.a(localRedBagInfo);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zxk
 * JD-Core Version:    0.7.0.1
 */