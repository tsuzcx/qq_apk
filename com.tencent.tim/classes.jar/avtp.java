import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class avtp
  implements BusinessObserver
{
  protected void ac(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void ad(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void ae(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void af(boolean paramBoolean, Bundle paramBundle) {}
  
  protected boolean b(boolean paramBoolean, Bundle paramBundle)
  {
    return false;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!b(paramBoolean, paramBundle)) {}
    do
    {
      return;
      if (paramInt == 0)
      {
        ad(paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1)
      {
        ae(paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 2)
      {
        ac(paramBoolean, paramBundle);
        return;
      }
    } while (paramInt != 100);
    af(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avtp
 * JD-Core Version:    0.7.0.1
 */