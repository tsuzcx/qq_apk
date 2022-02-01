import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class aigy
  implements BusinessObserver
{
  public void b(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    b(paramBoolean, paramBundle.getInt("appId"), paramBundle.getLong("uin", 0L), paramBundle.getString("openId"), paramBundle.getString("error_msg"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aigy
 * JD-Core Version:    0.7.0.1
 */