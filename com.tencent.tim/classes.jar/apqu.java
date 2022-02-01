import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.7.1;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.7.2;
import com.tencent.qphone.base.util.QLog;

public class apqu
  extends apsy
{
  apqu(apqk paramapqk, MessageForDeliverGiftTips paramMessageForDeliverGiftTips, String paramString, boolean paramBoolean) {}
  
  public void a(TroopGiftBagInfo paramTroopGiftBagInfo)
  {
    if (paramTroopGiftBagInfo.myGrabResult == null)
    {
      this.a.hasFetchButFailed = true;
      this.a.showButton = true;
      if (!(this.this$0.mApp instanceof QQAppInterface)) {
        break label105;
      }
    }
    label105:
    for (this.a.senderName = aqgv.h((QQAppInterface)this.this$0.mApp, this.Uf, "" + this.a.senderUin);; this.a.senderName = this.this$0.mApp.getDisplayName(1, this.Uf, this.a.senderUin + ""))
    {
      this.this$0.mHandler.post(new AIOAnimationControlManager.7.1(this));
      return;
    }
  }
  
  public void onError(int paramInt, String paramString)
  {
    this.a.hasFetchButFailed = true;
    this.a.showButton = true;
    if ((this.this$0.mApp instanceof QQAppInterface)) {}
    for (this.a.senderName = aqgv.h((QQAppInterface)this.this$0.mApp, this.Uf, "" + this.a.senderUin);; this.a.senderName = this.this$0.mApp.getDisplayName(1, this.Uf, this.a.senderUin + ""))
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "playGiftBigAnimation getGrabBagInfo onError. errorCode:" + paramInt + " errorMsg:" + paramString);
      }
      this.this$0.mHandler.post(new AIOAnimationControlManager.7.2(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apqu
 * JD-Core Version:    0.7.0.1
 */