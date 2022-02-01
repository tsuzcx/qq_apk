import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class akth
  implements BusinessObserver
{
  public void IX(int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 0;
    if (paramInt == 0)
    {
      paramInt = i;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("KEY_BATTERY", 0);
      }
      IX(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akth
 * JD-Core Version:    0.7.0.1
 */