import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.TabBarView;

public class hmb
  extends Handler
{
  public hmb(TabBarView paramTabBarView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      TabBarView.a(this.a, 0.0F);
      TabBarView.a(this.a, 0.1D);
      this.a.invalidate();
      sendMessageDelayed(TabBarView.a(this.a).obtainMessage(1), 10L);
      return;
    case 1: 
      if (TabBarView.a(this.a) < 1.0F)
      {
        TabBarView.a(this.a, 0.1D);
        this.a.invalidate();
        sendMessageDelayed(TabBarView.a(this.a).obtainMessage(1), 10L);
        return;
      }
      sendMessageDelayed(TabBarView.a(this.a).obtainMessage(2), 10L);
      return;
    }
    TabBarView.a(this.a, 1.0F);
    TabBarView.a(this.a, TabBarView.a(this.a), TabBarView.b(this.a));
    TabBarView.a(this.a, TabBarView.b(this.a));
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hmb
 * JD-Core Version:    0.7.0.1
 */