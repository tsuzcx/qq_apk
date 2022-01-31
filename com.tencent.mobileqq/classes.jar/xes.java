import Wallet.C2CVoiceInfo;
import Wallet.GroupVoiceInfo;
import Wallet.VoiceMatchStatus;
import Wallet.VoiceRedPackMatchReq;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRecognizer;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.qphone.base.util.QLog;

public class xes
  implements xew
{
  public xes(VoiceRedPacketHelper paramVoiceRedPacketHelper, QQAppInterface paramQQAppInterface, MessageForQQWalletMsg paramMessageForQQWalletMsg, int paramInt, long paramLong, byte[] paramArrayOfByte, String paramString, MessageForPtt paramMessageForPtt, BaseUploadProcessor paramBaseUploadProcessor, MessageObserver paramMessageObserver) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.b("skey is null");
      return;
    }
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    String str1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId;
    String str2 = VoiceRedPacketHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title);
    long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin);
    long l3 = AppSetting.jdField_a_of_type_Int;
    int j = this.jdField_a_of_type_Int;
    GroupVoiceInfo localGroupVoiceInfo = new GroupVoiceInfo(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin), this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte);
    C2CVoiceInfo localC2CVoiceInfo = new C2CVoiceInfo(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.jdField_c_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      QWalletCommonServlet.a(new VoiceRedPackMatchReq(l1, str1, str2, l2, paramString, l3, j, localGroupVoiceInfo, 0, localC2CVoiceInfo, "7.6.0", new VoiceMatchStatus(i, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.b, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.jdField_c_of_type_Int, VoiceRecognizer.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))), new xet(this, System.currentTimeMillis()));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VoiceRedPacketHelper", 2, "checkAndSendMessage() sendRequest");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xes
 * JD-Core Version:    0.7.0.1
 */