package cooperation.qwallet.plugin;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import java.lang.ref.WeakReference;

final class QWalletHelper$1
  implements Runnable
{
  QWalletHelper$1(WeakReference paramWeakReference, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    AppInterface localAppInterface = (AppInterface)this.val$weakRefApp.get();
    if (localAppInterface == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.val$uin);
    localBundle.putString("skey", this.val$skey);
    localBundle.putString("skey_type", "2");
    localBundle.putString("preload_from", this.val$from);
    localBundle.putInt("PayInvokerId", 21);
    QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, localAppInterface, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletHelper.1
 * JD-Core Version:    0.7.0.1
 */