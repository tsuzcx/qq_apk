package com.tencent.mobileqq.activity.qwallet.voice;

import Wallet.VoiceRedPackMatchRsp;
import aagd;
import aagm;
import aagm.b;
import aagm.c;
import aago;
import aagp;
import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import zyn;

public class VoiceRedPacketHelper$3$1$1
  implements Runnable
{
  public VoiceRedPacketHelper$3$1$1(aagp paramaagp, boolean paramBoolean, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis() - this.a.val$startTime;
    aagm.b localb = (aagm.b)this.a.a.this$0.eS.get();
    if (localb != null) {}
    for (int i = localb.hashCode();; i = 0)
    {
      QQAppInterface localQQAppInterface = aagd.getQQAppInterface();
      if (!this.val$isSuccess) {
        aagm.a(this.a.a.this$0, 3, l, 1, this.a.a.d);
      }
      if ((!this.val$isSuccess) || (this.val$bundle == null) || (this.val$type != 13) || (localQQAppInterface == null) || (this.a.a.d == null) || (localb == null) || (localb.isFinish()) || (this.a.a.this$0.isCancel) || (i != this.a.a.this$0.identify))
      {
        this.a.a.this$0.onError("onReceive VoiceRedPackMatchRsp erorr");
        return;
      }
      Object localObject1 = (VoiceRedPackMatchRsp)this.val$bundle.getSerializable("rsp");
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp onReceive:" + localObject1);
      }
      if ((localObject1 != null) && (((VoiceRedPackMatchRsp)localObject1).grabUin == localQQAppInterface.getLongAccountUin()) && (((VoiceRedPackMatchRsp)localObject1).billno != null) && (((VoiceRedPackMatchRsp)localObject1).billno.equals(this.a.a.d.mQQWalletRedPacketMsg.redPacketId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp status:" + ((VoiceRedPackMatchRsp)localObject1).status);
        }
        Object localObject2 = this.a.a.this$0;
        ((aagm)localObject2).serverTryTime += 1;
        aagm.a(this.a.a.this$0, ((VoiceRedPackMatchRsp)localObject1).status, l, 1, this.a.a.d);
        switch (((VoiceRedPackMatchRsp)localObject1).status)
        {
        }
        for (;;)
        {
          this.a.a.this$0.hT.remove(this.a.a.c);
          return;
          localb.ap(false, "");
          continue;
          aagm.a(((VoiceRedPackMatchRsp)localObject1).degree, this.a.a.c, this.a.a.a);
          aagm.d(((VoiceRedPackMatchRsp)localObject1).degree, this.a.a.d);
          localb.ap(true, ((VoiceRedPackMatchRsp)localObject1).degree);
          localQQAppInterface.b().a(this.a.a.c, this.a.a.i);
          continue;
          localObject2 = ((VoiceRedPackMatchRsp)localObject1).strErr;
          l = NetConnInfoCenter.getServerTime();
          zyn.putLong(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone", l + ((VoiceRedPackMatchRsp)localObject1).timeInterval);
          zyn.putString(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone_tips", (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "server is busy interval is " + ((VoiceRedPackMatchRsp)localObject1).timeInterval + ",tips is " + (String)localObject2);
          }
          if (this.a.a.this$0.bvv)
          {
            localObject1 = aagm.a(this.a.a.this$0, this.a.a.this$0.cy, this.a.a.d);
            if (((aagm.c)localObject1).bvx)
            {
              aagm.a(((aagm.c)localObject1).bcY, this.a.a.c, this.a.a.a);
              localQQAppInterface.b().a(this.a.a.c, this.a.a.i);
            }
            localb.ap(((aagm.c)localObject1).bvx, ((aagm.c)localObject1).bcY);
            if (QLog.isColorLevel()) {
              QLog.d("VoiceRedPacketHelper", 2, "check in phone, result is " + localObject1);
            }
          }
          else
          {
            aagm.a(this.a.a.this$0, (String)localObject2);
          }
        }
      }
      this.a.a.this$0.onError("rsp is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.3.1.1
 * JD-Core Version:    0.7.0.1
 */