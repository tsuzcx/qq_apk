import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.struct.PushBanner;
import com.tencent.mobileqq.widget.WorkSpaceView;

public class hhz
  extends Handler
{
  public hhz(WorkSpaceView paramWorkSpaceView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      int i = ((PushBanner)this.a.getChildAt(this.a.a).getTag()).a;
      if ((this.a.getChildCount() > 1) && (this.a.getWidth() > 0)) {
        this.a.a(this.a.a() + 1);
      }
      WorkSpaceView.a(this.a).sendEmptyMessageDelayed(0, i * 1000);
      continue;
      WorkSpaceView.a(this.a).removeMessages(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hhz
 * JD-Core Version:    0.7.0.1
 */