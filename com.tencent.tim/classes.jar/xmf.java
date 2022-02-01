import android.content.Context;
import android.view.View;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.BubbleImageView;

final class xmf
  implements xmb.e
{
  xmf(MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, BubbleImageView paramBubbleImageView, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString, MessageRecord paramMessageRecord) {}
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, View paramView, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, String paramString)
  {
    if ((paramMessageRecord2 != null) && (xmb.K(paramMessageRecord2)))
    {
      if (((paramMessageRecord1 instanceof MessageForReplyText)) && (((MessageForReplyText)paramMessageRecord1).getSourceMessage() == null)) {
        ((MessageForReplyText)paramMessageRecord1).setSourceMessageRecord(paramMessageRecord2);
      }
      xmb.b(paramMessageRecord2, this.a, this.i, this.f, this.g, this.bVp, this.aVF, this.b, paramContext, paramQQAppInterface, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xmf
 * JD-Core Version:    0.7.0.1
 */