import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.microapp.sdk.OnUpdateListener;

class aadd
  implements OnUpdateListener
{
  aadd(aacv paramaacv, ResultReceiver paramResultReceiver) {}
  
  public void onCheckForUpdate(boolean paramBoolean)
  {
    if (this.o != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("action", 0);
      localBundle.putBoolean("res", paramBoolean);
      this.o.send(0, localBundle);
    }
  }
  
  public void onUpdateSucc(boolean paramBoolean)
  {
    if (this.o != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("action", 1);
      localBundle.putBoolean("res", paramBoolean);
      this.o.send(0, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aadd
 * JD-Core Version:    0.7.0.1
 */