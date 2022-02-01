import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.TabBarView;

public class arji
  extends Handler
{
  public arji(TabBarView paramTabBarView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.f.ki = 0.0F;
      paramMessage = this.f;
      paramMessage.ki = ((float)(paramMessage.ki + 0.1D));
      this.f.invalidate();
      sendMessageDelayed(TabBarView.a(this.f).obtainMessage(1), 10L);
      return;
    case 1: 
      if (this.f.ki < 1.0F)
      {
        paramMessage = this.f;
        paramMessage.ki = ((float)(paramMessage.ki + 0.1D));
        this.f.invalidate();
        sendMessageDelayed(TabBarView.a(this.f).obtainMessage(1), 10L);
        return;
      }
      sendMessageDelayed(TabBarView.a(this.f).obtainMessage(2), 10L);
      return;
    }
    TabBarView.a(this.f, this.f.aXA, this.f.aXz);
    this.f.ki = 1.0F;
    TabBarView.b(this.f, this.f.aXA, this.f.aXz);
    this.f.aXA = this.f.aXz;
    this.f.invalidate();
    TabBarView.a(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arji
 * JD-Core Version:    0.7.0.1
 */