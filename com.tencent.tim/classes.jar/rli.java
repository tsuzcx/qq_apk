import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.takevideo.rmw.RMWService;

public class rli
  extends Handler
{
  public rli(RMWService paramRMWService) {}
  
  public void handleMessage(Message paramMessage)
  {
    rlg.d("RMWService", "service.handle : " + rlh.a(paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rli
 * JD-Core Version:    0.7.0.1
 */