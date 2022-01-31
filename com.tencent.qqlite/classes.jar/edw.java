import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;

public class edw
  extends Handler
{
  public edw(BaseShortVideoOprerator paramBaseShortVideoOprerator, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    BaseShortVideoOprerator.a(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     edw
 * JD-Core Version:    0.7.0.1
 */