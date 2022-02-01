import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.SlideTabWidget;

public class arjg
  extends Handler
{
  public arjg(SlideTabWidget paramSlideTabWidget) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      SlideTabWidget.a(this.this$0, 0.0F);
      SlideTabWidget.a(this.this$0, (float)(SlideTabWidget.a(this.this$0) + 0.1D));
      this.this$0.invalidate();
      sendMessageDelayed(SlideTabWidget.a(this.this$0).obtainMessage(1), 10L);
      return;
    case 1: 
      if (SlideTabWidget.a(this.this$0) < 1.0F)
      {
        SlideTabWidget.a(this.this$0, (float)(SlideTabWidget.a(this.this$0) + 0.1D));
        if (SlideTabWidget.a(this.this$0) >= 1.0F) {
          SlideTabWidget.a(this.this$0, false);
        }
        this.this$0.invalidate();
        sendMessageDelayed(SlideTabWidget.a(this.this$0).obtainMessage(1), 10L);
        return;
      }
      sendMessageDelayed(SlideTabWidget.a(this.this$0).obtainMessage(2), 10L);
      return;
    }
    SlideTabWidget.a(this.this$0, 1.0F);
    SlideTabWidget.a(this.this$0, SlideTabWidget.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arjg
 * JD-Core Version:    0.7.0.1
 */