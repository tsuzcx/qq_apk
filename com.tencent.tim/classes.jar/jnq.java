import android.os.Bundle;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.observer.BusinessObserver;

public class jnq
  implements BusinessObserver
{
  jnq(jnp paramjnp, List paramList) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManager.post(new TroopRedTouchHandler.2.1(this, paramBoolean, paramBundle), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jnq
 * JD-Core Version:    0.7.0.1
 */