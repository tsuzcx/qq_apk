import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.NearbyActivity;

public class tgw
  extends Handler
{
  public tgw(NearbyActivity paramNearbyActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.a.c)
    {
      this.a.f();
      this.a.b.removeMessages(this.a.d);
      sendEmptyMessageDelayed(this.a.d, this.a.n);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tgw
 * JD-Core Version:    0.7.0.1
 */