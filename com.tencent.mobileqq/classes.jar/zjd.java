import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.takevideo.rmw.RMWService;

public class zjd
  extends Handler
{
  public zjd(RMWService paramRMWService) {}
  
  public void handleMessage(Message paramMessage)
  {
    zjb.b("RMWService", "service.handle : " + zjc.a(paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjd
 * JD-Core Version:    0.7.0.1
 */