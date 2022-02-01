import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.widget.WorkSpaceView;

public class arjv
  extends Handler
{
  public arjv(WorkSpaceView paramWorkSpaceView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      int i = ((anqr)this.b.getChildAt(this.b.mCurrentScreen).getTag()).ac;
      if ((this.b.getChildCount() > 1) && (this.b.getWidth() > 0)) {
        this.b.snapToScreen(this.b.getCurrentScreen() + 1);
      }
      WorkSpaceView.a(this.b).sendEmptyMessageDelayed(0, i * 1000);
      continue;
      WorkSpaceView.a(this.b).removeMessages(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arjv
 * JD-Core Version:    0.7.0.1
 */