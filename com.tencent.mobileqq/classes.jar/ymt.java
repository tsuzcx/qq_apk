import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler;
import com.tencent.mobileqq.app.ThreadManager;

public class ymt
  implements Runnable
{
  public ymt(VipSpecialCareHandler paramVipSpecialCareHandler) {}
  
  public void run()
  {
    VipSpecialCareHandler.a(this.a, ThreadManager.newFreeHandlerThread("special-timer", 0));
    VipSpecialCareHandler.a(this.a).start();
    Looper localLooper = VipSpecialCareHandler.a(this.a).getLooper();
    if (localLooper == null) {
      return;
    }
    VipSpecialCareHandler.a(this.a, new ymu(this, localLooper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ymt
 * JD-Core Version:    0.7.0.1
 */