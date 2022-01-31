import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.music.QQPlayerService;

public final class dys
  extends Handler
{
  public dys(QQPlayerService paramQQPlayerService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QQPlayerService.a(this.a, (Intent)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dys
 * JD-Core Version:    0.7.0.1
 */