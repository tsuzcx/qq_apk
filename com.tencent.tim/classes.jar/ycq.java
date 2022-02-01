import android.os.Bundle;
import android.os.Handler;
import mqq.observer.BusinessObserver;

class ycq
  implements BusinessObserver
{
  ycq(ycd paramycd) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramInt = paramBundle.getInt("update_type");
      if (paramInt != 2) {}
    }
    else
    {
      return;
    }
    if (paramInt == 1) {}
    this.this$0.mHandler.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ycq
 * JD-Core Version:    0.7.0.1
 */