package com.tencent.mobileqq.activity.qwallet;

import acfp;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView;
import com.tencent.mobileqq.activity.qwallet.voice.KSongVolumeView;

class RedPacketKSongFragment$13
  implements Runnable
{
  RedPacketKSongFragment$13(RedPacketKSongFragment paramRedPacketKSongFragment, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.this$0.isFinish()) {
      return;
    }
    String str2 = this.this$0.getResources().getString(2131697521);
    String str1;
    if (this.val$type == 2) {
      str1 = this.val$errorMsg;
    }
    for (;;)
    {
      this.this$0.Ap.setText(str1);
      this.this$0.Ap.setText(acfp.m(2131713812));
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongVolumeView.setVisibility(8);
      this.this$0.csE();
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongMicView.reset();
      RedPacketKSongFragment.c(this.this$0);
      return;
      str1 = str2;
      if (this.val$type == 3)
      {
        this.this$0.dv(this.this$0.getActivity());
        str1 = str2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment.13
 * JD-Core Version:    0.7.0.1
 */