import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class ahei
  implements BusinessObserver
{
  public void A(boolean paramBoolean, Bundle paramBundle) {}
  
  public void J(boolean paramBoolean, Bundle paramBundle) {}
  
  public void dmV() {}
  
  public void onGetConfig() {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 967: 
      J(paramBoolean, paramBundle);
      return;
    case 968: 
      A(paramBoolean, paramBundle);
      return;
    case 969: 
      dmV();
      return;
    }
    onGetConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahei
 * JD-Core Version:    0.7.0.1
 */