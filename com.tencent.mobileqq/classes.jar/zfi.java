import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.takevideo.rmw.RMWService;

public class zfi
  extends Handler
{
  public zfi(RMWService paramRMWService) {}
  
  public void handleMessage(Message paramMessage)
  {
    zfg.b("RMWService", "service.handle : " + zfh.a(paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zfi
 * JD-Core Version:    0.7.0.1
 */