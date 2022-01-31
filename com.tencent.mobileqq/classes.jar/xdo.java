import Wallet.GetSkinListRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import mqq.observer.BusinessObserver;

class xdo
  implements Runnable
{
  xdo(xdn paramxdn, GetSkinListRsp paramGetSkinListRsp) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("rsp", this.jdField_a_of_type_WalletGetSkinListRsp);
    localBundle.putBoolean("isCache", true);
    if (RedPacketManager.a(this.jdField_a_of_type_Xdn.a) == null) {
      return;
    }
    RedPacketManager.a(this.jdField_a_of_type_Xdn.a).onReceive(14, true, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdo
 * JD-Core Version:    0.7.0.1
 */