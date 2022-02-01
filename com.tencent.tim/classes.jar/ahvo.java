import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

class ahvo
  extends Handler
{
  ahvo(ahvn paramahvn, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ahvn.a(this.this$0).get();
    if (localQQAppInterface == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = "https://openmobile.qq.com/gameteam/get_team_context?uin=" + localQQAppInterface.getCurrentAccountUin();
    this.this$0.a(paramMessage, null);
    this.this$0.dqr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahvo
 * JD-Core Version:    0.7.0.1
 */