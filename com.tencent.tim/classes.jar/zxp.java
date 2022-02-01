import Wallet.IdiomRedPackMatchRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class zxp
  implements BusinessObserver
{
  zxp(zxo paramzxo) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 26)
    {
      paramBundle = (IdiomRedPackMatchRsp)paramBundle.getSerializable("rsp");
      if ((QLog.isColorLevel()) && (paramBundle != null)) {
        QLog.d("PasswdRedBagManager", 2, "openSolitaireRedBagByIdiom reportObserver: " + paramBoolean + "|status: " + paramBundle.status + " |hbIdiom： " + paramBundle.hbIdiom + " |hbIdiomLastPY: " + paramBundle.hbIdiomLastPY + " |idiomSeq: " + paramBundle.idiomSeq + " |subchannel: " + paramBundle.subchannel);
      }
      if ((paramBoolean) && (paramBundle != null))
      {
        if (paramBundle.status != 0) {
          break label159;
        }
        this.a.this$0.m(this.a.b.redBagId, paramBundle.hbIdiom, paramBundle.hbIdiomLastPY, paramBundle.idiomSeq);
      }
    }
    label159:
    do
    {
      return;
      if (paramBundle.status == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PasswdRedBagManager", 2, "sessionInfo.curType: " + this.a.a.cZ);
        }
        if (this.a.a.cZ == 0) {
          this.a.this$0.z(this.a.b.redBagId, this.a.a.aTl, this.a.a.cZ);
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("answer", this.a.SS);
        localBundle.putInt("subchannel", paramBundle.subchannel);
        this.a.this$0.a(this.a.a, this.a.b, this.a.val$reportSeq, this.a.cfv, localBundle);
        return;
      }
    } while (paramBundle.status != 2);
    long l = NetConnInfoCenter.getServerTime();
    zyn.putLong(zxj.a(this.a.this$0).getCurrentAccountUin(), "idiom_match_in_phone", l + paramBundle.timeInterval);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zxp
 * JD-Core Version:    0.7.0.1
 */