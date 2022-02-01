import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Scroller;
import com.tencent.widget.MovingView;

public class auuj
  extends Handler
{
  public auuj(MovingView paramMovingView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if ((this.a.mIsAnimStart) && (!this.a.mIsPause)) {}
    }
    while (paramMessage.what != 2)
    {
      return;
      if (this.a.mScroller.computeScrollOffset())
      {
        int i = this.a.mScroller.getCurrX();
        int j = this.a.mScroller.getCurrY();
        int k = this.a.lastX;
        int m = this.a.lastY;
        this.a.lastX = i;
        this.a.lastY = j;
        paramMessage = this.a;
        paramMessage.left += i - k;
        paramMessage = this.a;
        paramMessage.top += j - m;
        this.a.invalidate();
        this.a.handler.sendEmptyMessageDelayed(1, 40L);
        return;
      }
      this.a.Yc();
      return;
    }
    this.a.Yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auuj
 * JD-Core Version:    0.7.0.1
 */