import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;

public class cgz
  extends Handler
{
  public cgz(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((16711681 == paramMessage.what) && (DiscussionInfoCardActivity.a(this.a) == 0))
    {
      paramMessage = (String)paramMessage.obj;
      if ((DiscussionInfoCardActivity.a(this.a) != null) && (paramMessage != null) && (DiscussionInfoCardActivity.a(this.a).equals(paramMessage))) {
        this.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cgz
 * JD-Core Version:    0.7.0.1
 */