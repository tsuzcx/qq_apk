import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class aigm
  implements Callable<Bundle>
{
  aigm(aigi paramaigi, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public Bundle call()
    throws Exception
  {
    aica localaica = new aica();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Bundle[] arrayOfBundle = new Bundle[1];
    localaica.a(this.b.mApp.getCurrentUin(), this.val$pluginId, this.abn, this.val$appId, new aign(this, localaica, arrayOfBundle, localCountDownLatch), true, this.val$sign);
    localCountDownLatch.await();
    return arrayOfBundle[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aigm
 * JD-Core Version:    0.7.0.1
 */