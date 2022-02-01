import android.os.Bundle;
import mqq.observer.BusinessObserver;

final class aneh
  implements aneg.a
{
  aneh(BusinessObserver paramBusinessObserver) {}
  
  public void onFailure(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("dataErrorMsg", paramString);
    localBundle.putInt("dataErrorCode", paramInt);
    this.val$observer.onReceive(0, false, localBundle);
  }
  
  public void onSuccess(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("data", paramString.getBytes());
    localBundle.putString("cmd", "getTmpkey");
    this.val$observer.onReceive(0, true, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aneh
 * JD-Core Version:    0.7.0.1
 */