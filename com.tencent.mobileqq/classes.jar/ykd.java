import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.takevideo.rmw.RMWService;

public class ykd
  extends Handler
{
  public ykd(RMWService paramRMWService) {}
  
  public void handleMessage(Message paramMessage)
  {
    ykb.b("RMWService", "service.handle : " + ykc.a(paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ykd
 * JD-Core Version:    0.7.0.1
 */