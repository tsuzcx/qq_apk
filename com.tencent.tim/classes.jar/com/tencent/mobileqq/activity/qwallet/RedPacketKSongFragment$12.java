package com.tencent.mobileqq.activity.qwallet;

import acfp;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView;
import com.tencent.mobileqq.activity.qwallet.voice.KSongVolumeView;

class RedPacketKSongFragment$12
  implements Runnable
{
  RedPacketKSongFragment$12(RedPacketKSongFragment paramRedPacketKSongFragment, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.this$0.isFinish()) {
      return;
    }
    if (this.buF)
    {
      this.this$0.Ap.setText(acfp.m(2131713802));
      RedPacketKSongFragment.a(this.this$0, this.bbx);
      this.this$0.close();
    }
    for (;;)
    {
      RedPacketKSongFragment.c(this.this$0);
      return;
      this.this$0.Ap.setText(acfp.m(2131713804));
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongVolumeView.setVisibility(8);
      this.this$0.csE();
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongMicView.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment.12
 * JD-Core Version:    0.7.0.1
 */