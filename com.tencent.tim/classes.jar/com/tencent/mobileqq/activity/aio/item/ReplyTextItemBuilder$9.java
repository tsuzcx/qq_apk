package com.tencent.mobileqq.activity.aio.item;

import android.text.SpannableString;
import android.widget.TextView;
import aofe;
import aqgv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import mqq.os.MqqHandler;

public final class ReplyTextItemBuilder$9
  implements Runnable
{
  public ReplyTextItemBuilder$9(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, TextView paramTextView1, TextView paramTextView2, String paramString2) {}
  
  public void run()
  {
    String str = aqgv.b(this.val$app, this.bUS, this.aVH, this.a.mSourceMsgSenderUin + "");
    SpannableString localSpannableString = new aofe(str, 16).k();
    ThreadManager.getUIHandler().post(new ReplyTextItemBuilder.9.1(this, str, localSpannableString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.9
 * JD-Core Version:    0.7.0.1
 */