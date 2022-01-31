import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;

public class wat
  implements MessageQueue.IdleHandler
{
  public wat(ZhituManager paramZhituManager) {}
  
  public boolean queueIdle()
  {
    this.a.b();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wat
 * JD-Core Version:    0.7.0.1
 */