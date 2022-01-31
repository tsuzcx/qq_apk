import android.os.Message;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

public class ykq
  extends TransProcessorHandler
{
  public ykq(HotChatCenterFragment paramHotChatCenterFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i == 1003) || (i == 2003)) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ykq
 * JD-Core Version:    0.7.0.1
 */