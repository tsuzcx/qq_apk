import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.takevideo.rmw.RMWService;

public class xlx
  extends Handler
{
  public xlx(RMWService paramRMWService) {}
  
  public void handleMessage(Message paramMessage)
  {
    xlv.b("RMWService", "service.handle : " + xlw.a(paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xlx
 * JD-Core Version:    0.7.0.1
 */