import android.content.Context;
import android.view.View;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;

final class xmd
  implements xmb.e
{
  xmd(ETTextView paramETTextView1, ETTextView paramETTextView2, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, BubbleImageView paramBubbleImageView, int paramInt, String paramString, MessageRecord paramMessageRecord, Context paramContext) {}
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, View paramView, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, String paramString)
  {
    if ((paramView instanceof ChatThumbView))
    {
      if (paramMessageRecord2 == null) {
        break label154;
      }
      if ((!(paramMessageRecord2 instanceof MessageForText)) || (((MessageForText)paramMessageRecord2).msg == null)) {
        break label84;
      }
      xmb.b(this.f, this.g, 1, this.a.mSourceMsgText, paramMessageRecord2);
      QLog.e("ReplyTextItemBuilder", 1, "returned text msg error!" + this.a.mSourceMsgText);
    }
    label84:
    do
    {
      return;
      if (((paramMessageRecord1 instanceof MessageForReplyText)) && (((MessageForReplyText)paramMessageRecord1).getSourceMessage() != null)) {
        ((MessageForReplyText)paramMessageRecord1).setSourceMessageRecord(paramMessageRecord2);
      }
      xmb.b(paramMessageRecord2, this.a, this.h, this.f, this.g, this.bVp, this.aVF, this.b, this.I, paramQQAppInterface, paramString);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("ReplyTextItemBuilder", 2, "processReplyMsg:source msg has been deleted.");
      }
    } while (this.h == null);
    label154:
    this.h.setVisibility(0);
    xmb.a(this.I, paramQQAppInterface, this.h, this.b, null);
    xmb.b(this.f, this.g, 1, this.a.mSourceMsgText, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xmd
 * JD-Core Version:    0.7.0.1
 */