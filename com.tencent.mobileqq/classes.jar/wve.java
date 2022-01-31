import android.os.Bundle;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.observer.VipGifObserver;

public class wve
  extends VipGifObserver
{
  public wve(MainAssistObserver paramMainAssistObserver) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBoolean == true)) {
      MainAssistObserver.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wve
 * JD-Core Version:    0.7.0.1
 */