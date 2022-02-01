package com.tencent.mobileqq.activity.qwallet;

import acfp;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import anot;
import aqgz;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

class RedPacketVoiceFragment$3
  implements Runnable
{
  RedPacketVoiceFragment$3(RedPacketVoiceFragment paramRedPacketVoiceFragment, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.this$0.isFinish()) {
      return;
    }
    label51:
    QQAppInterface localQQAppInterface;
    if (this.buF)
    {
      this.this$0.Ap.setText(acfp.m(2131713788));
      RedPacketVoiceFragment.a(this.this$0, this.bbx);
      this.this$0.close();
      if (RedPacketVoiceFragment.a(this.this$0))
      {
        localQQAppInterface = this.this$0.getActivity().app;
        if (!this.buF) {
          break label233;
        }
      }
    }
    label233:
    for (int i = 1;; i = 0)
    {
      anot.a(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.result", 0, i, this.this$0.b.mQQWalletRedPacketMsg.elem.title.length() + "", this.this$0.getActivity().app.getCurrentAccountUin(), aqgz.getDeviceOSVersion() + "|" + aqgz.getModel(), "");
      this.this$0.a.reset();
      if (RedPacketVoiceFragment.a(this.this$0) == null) {
        break;
      }
      RedPacketVoiceFragment.a(this.this$0).removeCallbacksAndMessages(null);
      return;
      this.this$0.Ap.setText(this.this$0.getResources().getString(2131697521));
      break label51;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketVoiceFragment.3
 * JD-Core Version:    0.7.0.1
 */