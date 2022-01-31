import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import java.lang.ref.WeakReference;

public class yuf
  extends Handler
{
  private WeakReference<SquareRoundImageView> a;
  
  private yuf(Looper paramLooper, SquareRoundImageView paramSquareRoundImageView)
  {
    super(paramLooper);
    this.a = new WeakReference(paramSquareRoundImageView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = (SquareRoundImageView)this.a.get();
      if (paramMessage != null) {
        SquareRoundImageView.a(paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yuf
 * JD-Core Version:    0.7.0.1
 */