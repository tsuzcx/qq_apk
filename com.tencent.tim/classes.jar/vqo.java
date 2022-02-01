import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class vqo
  implements BusinessObserver
{
  protected void bMO() {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 10000) {
      bMO();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vqo
 * JD-Core Version:    0.7.0.1
 */