import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class acjn
  extends Handler
{
  public acjn(QQAppInterface paramQQAppInterface, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    if (paramMessage.what == 990)
    {
      paramMessage = new ArrayList();
      synchronized (QQAppInterface.c(this.this$0))
      {
        paramMessage.addAll(QQAppInterface.c(this.this$0));
        QQAppInterface.c(this.this$0).clear();
        QQAppInterface.a(this.this$0).removeMessages(990);
        ??? = new ArrayList();
        if ((paramMessage == null) || (paramMessage.size() <= 0)) {
          break label138;
        }
        i = 0;
        if (i < paramMessage.size())
        {
          ???.add(this.this$0.getCustomFaceFilePath(1, (String)paramMessage.get(i), 0));
          i += 1;
        }
      }
      QQAppInterface.a(this.this$0, 1, paramMessage, ???);
      label138:
      if (QLog.isColorLevel()) {
        aqlr.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, user getQQHead resp uinList: ", paramMessage);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramMessage.what != 991) {
              break;
            }
            paramMessage = new ArrayList();
            synchronized (QQAppInterface.d(this.this$0))
            {
              paramMessage.addAll(QQAppInterface.d(this.this$0));
              QQAppInterface.d(this.this$0).clear();
              QQAppInterface.a(this.this$0).removeMessages(991);
              ??? = new ArrayList();
              if ((paramMessage == null) || (paramMessage.size() <= 0)) {
                continue;
              }
              i = 0;
              if (i < paramMessage.size())
              {
                ???.add(this.this$0.getCustomFaceFilePath(4, (String)paramMessage.get(i), 0));
                i += 1;
              }
            }
            QQAppInterface.a(this.this$0, 4, paramMessage, ???);
          } while (!QLog.isColorLevel());
          aqlr.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, group getQQHead resp uinList: ", paramMessage);
          return;
          if (paramMessage.what != 993) {
            break;
          }
          paramMessage = new ArrayList();
          synchronized (QQAppInterface.e(this.this$0))
          {
            paramMessage.addAll(QQAppInterface.e(this.this$0));
            QQAppInterface.e(this.this$0).clear();
            QQAppInterface.a(this.this$0).removeMessages(993);
            ??? = new ArrayList();
            if ((paramMessage == null) || (paramMessage.size() <= 0)) {
              continue;
            }
            i = 0;
            if (i < paramMessage.size())
            {
              ???.add(this.this$0.getCustomFaceFilePath(101, (String)paramMessage.get(i), 0));
              i += 1;
            }
          }
          QQAppInterface.a(this.this$0, 101, paramMessage, ???);
        } while (!QLog.isColorLevel());
        aqlr.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, dis getQQHead resp uinList: ", paramMessage);
        return;
      } while (paramMessage.what != 992);
      paramMessage = new ArrayList();
      synchronized (QQAppInterface.f(this.this$0))
      {
        paramMessage.addAll(QQAppInterface.f(this.this$0));
        QQAppInterface.f(this.this$0).clear();
        QQAppInterface.a(this.this$0).removeMessages(992);
        ??? = new ArrayList();
        if ((paramMessage == null) || (paramMessage.size() <= 0)) {
          continue;
        }
        i = 0;
        if (i < paramMessage.size())
        {
          ???.add(this.this$0.getCustomFaceFilePath(113, (String)paramMessage.get(i), 0));
          i += 1;
        }
      }
      QQAppInterface.a(this.this$0, 113, paramMessage, ???);
    } while (!QLog.isColorLevel());
    aqlr.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, newGroup getQQHead resp uinList: ", paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acjn
 * JD-Core Version:    0.7.0.1
 */