import Wallet.C2CVoiceInfo;
import Wallet.GroupVoiceInfo;
import Wallet.VoiceMatchStatus;
import Wallet.VoiceRedPackMatchReq;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.qphone.base.util.QLog;

public class aago
  implements aagm.a
{
  aago(aagm paramaagm, QQAppInterface paramQQAppInterface, MessageForQQWalletMsg paramMessageForQQWalletMsg, int paramInt, long paramLong, byte[] paramArrayOfByte, String paramString, MessageForPtt paramMessageForPtt, aojr paramaojr, achq paramachq) {}
  
  public void zP(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.this$0.onError("skey is null");
      return;
    }
    long l1 = this.val$app.getLongAccountUin();
    String str1 = this.d.mQQWalletRedPacketMsg.redPacketId;
    String str2 = aagm.access$000(this.d.mQQWalletRedPacketMsg.elem.title);
    long l2 = Long.parseLong(this.d.senderuin);
    long l3 = AppSetting.getAppId();
    int k = this.cfn;
    GroupVoiceInfo localGroupVoiceInfo = new GroupVoiceInfo(Long.parseLong(this.d.frienduin), this.LR, this.cz);
    C2CVoiceInfo localC2CVoiceInfo = new C2CVoiceInfo(this.bcX);
    if (this.this$0.bvv) {}
    for (int j = 1;; j = 0)
    {
      zyb.a(new VoiceRedPackMatchReq(l1, str1, str2, l2, paramString, l3, k, localGroupVoiceInfo, 0, localC2CVoiceInfo, "3.4.4", new VoiceMatchStatus(j, this.this$0.clientTryTime, this.this$0.serverTryTime, aagl.a().e(this.val$app))), new aagp(this, System.currentTimeMillis()));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VoiceRedPacketHelper", 2, "checkAndSendMessage() sendRequest");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aago
 * JD-Core Version:    0.7.0.1
 */