import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.takevideo.rmw.RMWService;

public class vgd
  extends Handler
{
  public vgd(RMWService paramRMWService) {}
  
  public void handleMessage(Message paramMessage)
  {
    vgb.b("RMWService", "service.handle : " + vgc.a(paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgd
 * JD-Core Version:    0.7.0.1
 */