import android.os.Handler;
import android.os.Message;
import com.tencent.biz.subscribe.widget.AlphaLoadingView;

public class wuo
  extends Handler
{
  public wuo(AlphaLoadingView paramAlphaLoadingView) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wuo
 * JD-Core Version:    0.7.0.1
 */