import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class acog
  implements BusinessObserver
{
  public void Ca(int paramInt) {}
  
  public void bYb() {}
  
  public void bYc() {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    case 111: 
    case 112: 
    case 114: 
    default: 
      return;
    case 113: 
      Ca(paramBundle.getInt("key_rt_type"));
      return;
    case 115: 
      bYb();
      return;
    }
    bYc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acog
 * JD-Core Version:    0.7.0.1
 */