package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import java.util.ArrayList;

public class WalletHomeResp
  extends BaseResp
{
  public boolean isAppLoadFinished;
  public ArrayList<QWalletRedTouchInfo> resp;
  public int type;
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.resp = ((ArrayList)paramBundle.getSerializable("_qwallet_ipc_WalletHome_resp"));
    this.isAppLoadFinished = paramBundle.getBoolean("_qwallet_ipc_WalletHome_isAppLoadFinished");
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    if (this.resp != null) {
      paramBundle.putSerializable("_qwallet_ipc_WalletHome_resp", this.resp);
    }
    paramBundle.putBoolean("_qwallet_ipc_WalletHome_isAppLoadFinished", this.isAppLoadFinished);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.WalletHomeResp
 * JD-Core Version:    0.7.0.1
 */