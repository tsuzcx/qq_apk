import Wallet.VoiceRedPackMatchRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.OnVoiceRedPacketListener;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.RecogResult;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class xhz
  implements Runnable
{
  xhz(xhy paramxhy, boolean paramBoolean, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Xhy.jdField_a_of_type_Long;
    VoiceRedPacketHelper.OnVoiceRedPacketListener localOnVoiceRedPacketListener = (VoiceRedPacketHelper.OnVoiceRedPacketListener)this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localOnVoiceRedPacketListener != null) {}
    for (int i = localOnVoiceRedPacketListener.hashCode();; i = 0)
    {
      QQAppInterface localQQAppInterface = QWalletTools.a();
      if (!this.jdField_a_of_type_Boolean) {
        VoiceRedPacketHelper.a(this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper, 3, l, 1, this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      }
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidOsBundle == null) || (this.jdField_a_of_type_Int != 13) || (localQQAppInterface == null) || (this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (localOnVoiceRedPacketListener == null) || (localOnVoiceRedPacketListener.e()) || (this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.b) || (i != this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.b("onReceive VoiceRedPackMatchRsp erorr");
        return;
      }
      Object localObject1 = (VoiceRedPackMatchRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp onReceive:" + localObject1);
      }
      if ((localObject1 != null) && (((VoiceRedPackMatchRsp)localObject1).grabUin == localQQAppInterface.getLongAccountUin()) && (((VoiceRedPackMatchRsp)localObject1).billno != null) && (((VoiceRedPackMatchRsp)localObject1).billno.equals(this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp status:" + ((VoiceRedPackMatchRsp)localObject1).status);
        }
        Object localObject2 = this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper;
        ((VoiceRedPacketHelper)localObject2).jdField_c_of_type_Int += 1;
        VoiceRedPacketHelper.a(this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper, ((VoiceRedPackMatchRsp)localObject1).status, l, 1, this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
        switch (((VoiceRedPackMatchRsp)localObject1).status)
        {
        }
        for (;;)
        {
          this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
          return;
          localOnVoiceRedPacketListener.a(false, "");
          continue;
          localOnVoiceRedPacketListener.a(true, ((VoiceRedPackMatchRsp)localObject1).degree);
          VoiceRedPacketHelper.a(((VoiceRedPackMatchRsp)localObject1).degree, this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqTransfileBaseUploadProcessor);
          localQQAppInterface.a().a(this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
          continue;
          localObject2 = ((VoiceRedPackMatchRsp)localObject1).strErr;
          l = NetConnInfoCenter.getServerTime();
          QWalletSetting.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone", l + ((VoiceRedPackMatchRsp)localObject1).timeInterval);
          QWalletSetting.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone_tips", (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "server is busy interval is " + ((VoiceRedPackMatchRsp)localObject1).timeInterval + ",tips is " + (String)localObject2);
          }
          if (this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.jdField_c_of_type_Boolean)
          {
            localObject1 = VoiceRedPacketHelper.a(this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper, this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
            if (((VoiceRedPacketHelper.RecogResult)localObject1).jdField_a_of_type_Boolean)
            {
              VoiceRedPacketHelper.a(((VoiceRedPacketHelper.RecogResult)localObject1).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqTransfileBaseUploadProcessor);
              localQQAppInterface.a().a(this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
            }
            localOnVoiceRedPacketListener.a(((VoiceRedPacketHelper.RecogResult)localObject1).jdField_a_of_type_Boolean, ((VoiceRedPacketHelper.RecogResult)localObject1).jdField_a_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("VoiceRedPacketHelper", 2, "check in phone, result is " + localObject1);
            }
          }
          else
          {
            VoiceRedPacketHelper.a(this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper, (String)localObject2);
          }
        }
      }
      this.jdField_a_of_type_Xhy.jdField_a_of_type_Xhx.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.b("rsp is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xhz
 * JD-Core Version:    0.7.0.1
 */