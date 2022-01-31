import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.takevideo.rmw.RMWService;

public class vsw
  extends Handler
{
  public vsw(RMWService paramRMWService) {}
  
  public void handleMessage(Message paramMessage)
  {
    vsu.b("RMWService", "service.handle : " + vsv.a(paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vsw
 * JD-Core Version:    0.7.0.1
 */