import Wallet.GetSkinListRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager.3.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;

public class aadq
  implements BusinessObserver
{
  public aadq(RedPacketManager paramRedPacketManager, String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    GetSkinListRsp localGetSkinListRsp = (GetSkinListRsp)paramBundle.getSerializable("rsp");
    paramBundle.putBoolean("isCache", false);
    if (RedPacketManager.a(this.this$0).isEmpty()) {}
    do
    {
      return;
      Iterator localIterator = RedPacketManager.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((BusinessObserver)localIterator.next()).onReceive(paramInt, paramBoolean, paramBundle);
      }
      if (!this.bcu.equals("100")) {
        ThreadManager.post(new RedPacketManager.3.1(this, localGetSkinListRsp), 5, null, false);
      }
    } while (!QLog.isColorLevel());
    QLog.d("RedPacketManager", 2, "requestRedPacketSkinList onReceive isSuccess:" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aadq
 * JD-Core Version:    0.7.0.1
 */