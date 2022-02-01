import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vashealth.SportManager.3.1;
import mqq.observer.BusinessObserver;

public class aqub
  implements BusinessObserver
{
  aqub(aqtz paramaqtz) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      ThreadManager.post(new SportManager.3.1(this, paramBundle.getString("StepInfoJSON")), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqub
 * JD-Core Version:    0.7.0.1
 */