import android.os.Bundle;
import java.util.concurrent.CountDownLatch;

class aigo
  implements aica.b
{
  aigo(aigi.a parama, aica paramaica, Bundle[] paramArrayOfBundle, CountDownLatch paramCountDownLatch) {}
  
  public void l(String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      paramString = new Bundle();
      paramString.putString("authid", this.c.a().mOpenID);
      paramString.putString("authKey", this.c.a().mAccessToken);
      paramString.putLong("accountUpdateTime", this.c.a().abj);
      paramString.putString("payToken", this.c.a().bMP);
      Bundle localBundle = new Bundle();
      localBundle.putBundle("data", paramString);
      localBundle.putBoolean("isSuccess", true);
      localBundle.putInt("code", paramInt);
      this.val$result[0] = localBundle;
    }
    for (;;)
    {
      this.val$latch.countDown();
      return;
      paramString = new Bundle();
      paramString.putBoolean("isSuccess", false);
      paramString.putInt("code", paramInt);
      this.val$result[0] = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aigo
 * JD-Core Version:    0.7.0.1
 */