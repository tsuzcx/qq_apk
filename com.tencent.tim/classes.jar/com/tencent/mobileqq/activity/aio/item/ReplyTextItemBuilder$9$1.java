package com.tencent.mobileqq.activity.aio.item;

import android.text.SpannableString;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;

class ReplyTextItemBuilder$9$1
  implements Runnable
{
  ReplyTextItemBuilder$9$1(ReplyTextItemBuilder.9 param9, String paramString, SpannableString paramSpannableString) {}
  
  public void run()
  {
    this.this$0.CO.setTag(2131379213, this.aVJ);
    this.this$0.CO.setTag(2131379214, Long.valueOf(this.this$0.a.mSourceMsgSenderUin));
    this.this$0.CO.setText(this.f);
    this.this$0.JJ.setText(" " + this.this$0.aVI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.9.1
 * JD-Core Version:    0.7.0.1
 */