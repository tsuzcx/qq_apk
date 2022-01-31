import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.observer.BusinessObserver;

class xet
  implements BusinessObserver
{
  xet(xes paramxes, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManager.postImmediately(new xeu(this, paramBoolean, paramBundle, paramInt), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xet
 * JD-Core Version:    0.7.0.1
 */