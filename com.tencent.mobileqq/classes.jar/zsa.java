import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class zsa
  extends Handler
{
  public zsa(QQAppInterface paramQQAppInterface, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    if (paramMessage.what == 990)
    {
      paramMessage = new ArrayList();
      synchronized (QQAppInterface.a(this.a))
      {
        paramMessage.addAll(QQAppInterface.a(this.a));
        QQAppInterface.a(this.a).clear();
        QQAppInterface.a(this.a).removeMessages(990);
        ??? = new ArrayList();
        if ((paramMessage != null) && (paramMessage.size() > 0))
        {
          i = 0;
          if (i < paramMessage.size())
          {
            ???.add(this.a.a(1, (String)paramMessage.get(i), 0));
            i += 1;
          }
        }
      }
    }
    for (;;)
    {
      Intent localIntent;
      try
      {
        localIntent = new Intent("com.tencent.qqhead.getheadresp");
        localIntent.putExtra("faceType", 1);
        localIntent.putStringArrayListExtra("uinList", paramMessage);
        localIntent.putStringArrayListExtra("headPathList", ???);
        this.a.getApp().sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp");
        if (QLog.isColorLevel()) {
          QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, getQQHead resp uinList: ", paramMessage);
        }
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("Q.qqhead.broadcast", 2, "headQQHeadBroadcast error", localException1);
        continue;
      }
      if (paramMessage.what != 991) {
        continue;
      }
      paramMessage = new ArrayList();
      synchronized (QQAppInterface.b(this.a))
      {
        paramMessage.addAll(QQAppInterface.b(this.a));
        QQAppInterface.b(this.a).clear();
        QQAppInterface.a(this.a).removeMessages(991);
        ??? = new ArrayList();
        if ((paramMessage != null) && (paramMessage.size() > 0))
        {
          i = 0;
          if (i < paramMessage.size())
          {
            ???.add(this.a.a(4, (String)paramMessage.get(i), 0));
            i += 1;
          }
        }
      }
      try
      {
        localIntent = new Intent("com.tencent.qqhead.getheadresp");
        localIntent.setPackage(QQAppInterface.d(this.a).getPackageName());
        localIntent.putStringArrayListExtra("uinList", paramMessage);
        localIntent.putStringArrayListExtra("headPathList", ???);
        localIntent.putExtra("faceType", 4);
        this.a.getApp().sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp");
        if (!QLog.isColorLevel()) {
          continue;
        }
        QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, getQQHead resp uinList: ", paramMessage);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("Q.qqhead.broadcast", 2, "headQQHeadBroadcast error", localException2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zsa
 * JD-Core Version:    0.7.0.1
 */