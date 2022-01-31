import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.music.QQPlayerService;

public final class ghj
  extends Handler
{
  public ghj(QQPlayerService paramQQPlayerService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QQPlayerService.a(this.a, (Intent)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ghj
 * JD-Core Version:    0.7.0.1
 */