import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ffl
  extends Handler
{
  public ffl(QQAppInterface paramQQAppInterface, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 990)
    {
      paramMessage = QQAppInterface.a(this.a);
      QQAppInterface.a(this.a, null);
      QQAppInterface.a(this.a).removeMessages(990);
      ArrayList localArrayList = new ArrayList();
      if ((paramMessage != null) && (paramMessage.size() > 0))
      {
        int i = 0;
        while (i < paramMessage.size())
        {
          localArrayList.add(this.a.b(1, (String)paramMessage.get(i)));
          i += 1;
        }
        Intent localIntent = new Intent("com.tencent.qqhead.getheadresp");
        localIntent.putStringArrayListExtra("uinList", paramMessage);
        localIntent.putStringArrayListExtra("headPathList", localArrayList);
        this.a.a().sendBroadcast(localIntent);
      }
      if (QLog.isColorLevel()) {
        QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, getQQHead resp uinList: ", paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ffl
 * JD-Core Version:    0.7.0.1
 */