import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpic.HotPicTab;

public class ahzn
  extends Handler
{
  public ahzn(HotPicTab paramHotPicTab) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      HotPicTab.a(this.this$0, 0.0F);
      HotPicTab.a(this.this$0, (float)(HotPicTab.a(this.this$0) + 0.1D));
      this.this$0.invalidate();
      sendMessageDelayed(HotPicTab.a(this.this$0).obtainMessage(1), 10L);
      return;
    case 1: 
      HotPicTab.a(this.this$0, (float)(HotPicTab.a(this.this$0) + 0.1D));
      if (HotPicTab.a(this.this$0) < 1.0F)
      {
        this.this$0.invalidate();
        sendMessageDelayed(HotPicTab.a(this.this$0).obtainMessage(1), 10L);
        return;
      }
      sendMessageDelayed(HotPicTab.a(this.this$0).obtainMessage(2), 10L);
      return;
    }
    HotPicTab.a(this.this$0, 1.0F);
    HotPicTab.a(this.this$0, HotPicTab.a(this.this$0));
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahzn
 * JD-Core Version:    0.7.0.1
 */