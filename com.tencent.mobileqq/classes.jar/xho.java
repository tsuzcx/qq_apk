import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.takevideo.rmw.RMWService;

public class xho
  extends Handler
{
  public xho(RMWService paramRMWService) {}
  
  public void handleMessage(Message paramMessage)
  {
    xhm.b("RMWService", "service.handle : " + xhn.a(paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xho
 * JD-Core Version:    0.7.0.1
 */