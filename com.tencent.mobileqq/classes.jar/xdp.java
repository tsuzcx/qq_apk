import Wallet.GetSkinListRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class xdp
  implements BusinessObserver
{
  public xdp(RedPacketManager paramRedPacketManager, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    GetSkinListRsp localGetSkinListRsp = (GetSkinListRsp)paramBundle.getSerializable("rsp");
    paramBundle.putBoolean("isCache", false);
    if (RedPacketManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager) == null) {}
    do
    {
      return;
      RedPacketManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager).onReceive(paramInt, paramBoolean, paramBundle);
      ThreadManager.post(new xdq(this, localGetSkinListRsp), 5, null, false);
    } while (!QLog.isColorLevel());
    QLog.d("RedPacketManager", 2, "requestRedPacketSkinList onReceive isSuccess:" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdp
 * JD-Core Version:    0.7.0.1
 */