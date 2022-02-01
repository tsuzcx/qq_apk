import Wallet.FocusMpIdRsp;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import mqq.observer.BusinessObserver;

class asuf
  implements BusinessObserver
{
  asuf(astt paramastt, AsyncResult paramAsyncResult) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (FocusMpIdRsp)paramBundle.getSerializable("rsp");
    if ((paramBundle == null) || (paramBundle.err_code != 0))
    {
      this.val$result.onReceiveResult(false, null);
      return;
    }
    this.val$result.onReceiveResult(true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asuf
 * JD-Core Version:    0.7.0.1
 */