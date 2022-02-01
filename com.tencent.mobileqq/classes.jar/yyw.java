import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.takevideo.rmw.RMWService;

public class yyw
  extends Handler
{
  public yyw(RMWService paramRMWService) {}
  
  public void handleMessage(Message paramMessage)
  {
    yyu.b("RMWService", "service.handle : " + yyv.a(paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyw
 * JD-Core Version:    0.7.0.1
 */