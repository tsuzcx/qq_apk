import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.qphone.base.util.QLog;

public class ainu
  implements Handler.Callback
{
  public ainu(ListenTogetherManager paramListenTogetherManager) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    paramMessage = this.this$0.a();
    if (paramMessage != null)
    {
      paramMessage.abP = (SystemClock.elapsedRealtime() - paramMessage.abQ + paramMessage.abP);
      paramMessage.abQ = SystemClock.elapsedRealtime();
      boolean bool = ListenTogetherManager.a(this.this$0).a(paramMessage);
      QLog.i("ListenTogether.Seek", 1, "MSG_TYPE_TIME_SYNC seek is: " + paramMessage.abP + " currentTime: " + System.currentTimeMillis() + " result: " + bool);
    }
    for (;;)
    {
      ListenTogetherManager.a(this.this$0).removeMessages(1001);
      ListenTogetherManager.a(this.this$0).sendEmptyMessageDelayed(1001, aini.a().abL);
      return true;
      QLog.i("ListenTogether.Manager", 1, "MSG_TYPE_TIME_SYNC startPlay musicInfo is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ainu
 * JD-Core Version:    0.7.0.1
 */