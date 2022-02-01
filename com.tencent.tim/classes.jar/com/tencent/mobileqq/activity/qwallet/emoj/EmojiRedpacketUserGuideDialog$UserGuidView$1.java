package com.tencent.mobileqq.activity.qwallet.emoj;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmojiRedpacketUserGuideDialog$UserGuidView$1
  implements View.OnClickListener
{
  EmojiRedpacketUserGuideDialog$UserGuidView$1(EmojiRedpacketUserGuideDialog.UserGuidView paramUserGuidView, EmojiRedpacketUserGuideDialog paramEmojiRedpacketUserGuideDialog) {}
  
  public void onClick(View paramView)
  {
    if (this.this$1.this$0.isShowing()) {
      this.this$1.this$0.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiRedpacketUserGuideDialog.UserGuidView.1
 * JD-Core Version:    0.7.0.1
 */