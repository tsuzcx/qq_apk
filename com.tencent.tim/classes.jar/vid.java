import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.NearbyActivity;

public class vid
  extends Handler
{
  public vid(NearbyActivity paramNearbyActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.this$0.aYJ)
    {
      this.this$0.bRN();
      this.this$0.bN.removeMessages(this.this$0.bID);
      sendEmptyMessageDelayed(this.this$0.bID, this.this$0.Gy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vid
 * JD-Core Version:    0.7.0.1
 */