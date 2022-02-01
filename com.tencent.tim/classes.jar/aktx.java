import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class aktx
  implements BusinessObserver
{
  public void U(boolean paramBoolean, Bundle paramBundle) {}
  
  public void Y(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1) {
      Y(paramBoolean, paramBundle);
    }
    while (paramInt != 2) {
      return;
    }
    U(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aktx
 * JD-Core Version:    0.7.0.1
 */