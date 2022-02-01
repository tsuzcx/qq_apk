package com.tencent.mobileqq.activity.qwallet.voice;

import Wallet.SongRedPackMatchRsp;
import aagd;
import aagm;
import aagm.b;
import aagq;
import aagr;
import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import zyn;

public class VoiceRedPacketHelper$4$1$1
  implements Runnable
{
  public VoiceRedPacketHelper$4$1$1(aagr paramaagr, boolean paramBoolean, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.a.val$startTime;
    Object localObject = (aagm.b)this.a.a.this$0.eS.get();
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      QQAppInterface localQQAppInterface = aagd.getQQAppInterface();
      if (!this.val$isSuccess) {
        aagm.a(this.a.a.this$0, 3, l1 - l2, 1, this.a.a.jdField_d_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      }
      if ((!this.val$isSuccess) || (this.val$bundle == null) || (this.val$type != 21) || (localQQAppInterface == null) || (this.a.a.e == null) || (localObject == null) || (((aagm.b)localObject).isFinish()) || (this.a.a.this$0.isCancel) || (i != this.a.a.this$0.identify))
      {
        this.a.a.this$0.onError("onReceive SongRedPackMatchRsp erorr");
        return;
      }
      SongRedPackMatchRsp localSongRedPackMatchRsp = (SongRedPackMatchRsp)this.val$bundle.getSerializable("rsp");
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "SongRedPackMatchRsp onReceive:" + localSongRedPackMatchRsp);
      }
      if ((localSongRedPackMatchRsp != null) && (localSongRedPackMatchRsp.grabUin == localQQAppInterface.getLongAccountUin()) && (localSongRedPackMatchRsp.billno != null) && (localSongRedPackMatchRsp.billno.equals(this.a.a.e.mQQWalletRedPacketMsg.redPacketId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp status:" + localSongRedPackMatchRsp.status);
        }
        aagm localaagm = this.a.a.this$0;
        localaagm.serverTryTime += 1;
        switch (localSongRedPackMatchRsp.status)
        {
        }
        for (;;)
        {
          this.a.a.this$0.hT.remove(this.a.a.jdField_d_of_type_ComTencentMobileqqDataMessageForPtt);
          this.a.a.this$0.iA.remove(this.a.a.jdField_d_of_type_ComTencentMobileqqDataMessageForPtt);
          return;
          ((aagm.b)localObject).ap(false, "");
          continue;
          aagm.a(localSongRedPackMatchRsp.degree, this.a.a.jdField_d_of_type_ComTencentMobileqqDataMessageForPtt, this.a.a.a);
          aagm.d(localSongRedPackMatchRsp.degree, this.a.a.e);
          ((aagm.b)localObject).ap(true, localSongRedPackMatchRsp.degree);
          localQQAppInterface.b().a(this.a.a.jdField_d_of_type_ComTencentMobileqqDataMessageForPtt, this.a.a.i);
          continue;
          localObject = localSongRedPackMatchRsp.strErr;
          l1 = NetConnInfoCenter.getServerTime();
          zyn.putLong(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone", l1 + localSongRedPackMatchRsp.timeInterval);
          zyn.putString(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone_tips", (String)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "server is busy interval is " + localSongRedPackMatchRsp.timeInterval + ",tips is " + (String)localObject);
          }
          aagm.a(this.a.a.this$0, (String)localObject);
        }
      }
      this.a.a.this$0.onError("rsp is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.4.1.1
 * JD-Core Version:    0.7.0.1
 */