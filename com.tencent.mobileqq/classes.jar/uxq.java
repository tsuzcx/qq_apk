import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.qphone.base.util.QLog;

public class uxq
  implements View.OnClickListener
{
  public uxq(LongMsgItemBuilder paramLongMsgItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (LongMsgItemBuilder.a(this.a)) {}
    BaseChatPie localBaseChatPie;
    do
    {
      do
      {
        do
        {
          return;
          paramView = AIOUtils.a(paramView);
          if ((paramView instanceof MessageForLongMsg)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForLongMsg");
        return;
        paramView = (MessageForLongMsg)paramView;
      } while ((paramView.mSourceMsgInfo == null) || (!(this.a.a instanceof FragmentActivity)));
      if (QLog.isColorLevel()) {
        QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: isReplyMsg = true");
      }
      localBaseChatPie = ((FragmentActivity)this.a.a).getChatFragment().a();
    } while (!localBaseChatPie.f());
    localBaseChatPie.a(20, paramView.mSourceMsgInfo.mSourceMsgSeq, (int)(paramView.shmsgseq - paramView.mSourceMsgInfo.mSourceMsgSeq), paramView);
    MessageForReplyText.reportReplyMsg(null, "replyMsg_bubble", "clk_original", paramView.frienduin, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uxq
 * JD-Core Version:    0.7.0.1
 */