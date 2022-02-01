import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class aklk
  implements BusinessObserver
{
  protected void f(boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 10000) {
      f(paramBoolean, paramBundle.getBoolean("new"), paramBundle.getInt("gc_notify_type", 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aklk
 * JD-Core Version:    0.7.0.1
 */