import android.os.Looper;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;

public class wds
  implements Runnable
{
  public wds(ZhituManager paramZhituManager) {}
  
  public void run()
  {
    ZhituManager.a(this.a, Looper.myQueue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wds
 * JD-Core Version:    0.7.0.1
 */