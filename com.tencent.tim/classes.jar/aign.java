import android.content.Intent;
import android.os.Bundle;
import java.util.concurrent.CountDownLatch;

class aign
  implements aica.b
{
  aign(aigm paramaigm, aica paramaica, Bundle[] paramArrayOfBundle, CountDownLatch paramCountDownLatch) {}
  
  public void l(String paramString, boolean paramBoolean, int paramInt)
  {
    paramString = new Bundle(this.c.a().ac.getExtras());
    Bundle localBundle = new Bundle();
    localBundle.putBundle("data", paramString);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putInt("code", paramInt);
    this.val$result[0] = localBundle;
    this.val$latch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aign
 * JD-Core Version:    0.7.0.1
 */