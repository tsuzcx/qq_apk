import android.os.Handler;
import android.os.Message;
import com.tencent.biz.subscribe.widget.AlphaLoadingView;

public class sik
  extends Handler
{
  public sik(AlphaLoadingView paramAlphaLoadingView) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (!AlphaLoadingView.a(this.a))
    {
      this.a.invalidate();
      sendEmptyMessageDelayed(1, AlphaLoadingView.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sik
 * JD-Core Version:    0.7.0.1
 */