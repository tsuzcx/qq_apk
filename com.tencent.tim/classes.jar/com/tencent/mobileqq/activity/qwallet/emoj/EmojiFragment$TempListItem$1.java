package com.tencent.mobileqq.activity.qwallet.emoj;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmojiFragment$TempListItem$1
  implements View.OnClickListener
{
  EmojiFragment$TempListItem$1(EmojiFragment.TempListItem paramTempListItem, EmojiFragment.TemplateInfo paramTemplateInfo) {}
  
  public void onClick(View paramView)
  {
    this.this$1.this$0.availableRight = 0;
    EmojiFragment.access$100(this.this$1.this$0).zY("phiz.wrappacket.choosephiz");
    this.this$1.this$0.onTempSelected(this.val$data, EmojiFragment.TempListItem.access$200(this.this$1));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiFragment.TempListItem.1
 * JD-Core Version:    0.7.0.1
 */