import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;

public class anfg
  extends Handler
{
  public anfg(BaseShortVideoOprerator paramBaseShortVideoOprerator, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.this$0.dispatchMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anfg
 * JD-Core Version:    0.7.0.1
 */