import android.os.Looper;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;

public class wja
  implements Runnable
{
  public wja(ZhituManager paramZhituManager) {}
  
  public void run()
  {
    ZhituManager.a(this.a, Looper.myQueue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wja
 * JD-Core Version:    0.7.0.1
 */