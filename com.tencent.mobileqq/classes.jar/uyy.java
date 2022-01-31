import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class uyy
  implements View.OnClickListener
{
  public uyy(MixedMsgItemBuilder paramMixedMsgItemBuilder) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    int j = 0;
    if (MixedMsgItemBuilder.c(this.a)) {
      return;
    }
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if ((localChatMessage instanceof MessageForMixedMsg))
    {
      paramView = (MessageRecord)((MessageForMixedMsg)localChatMessage).msgElemList.get(0);
      if (!(paramView instanceof MessageForReplyText)) {
        break label271;
      }
      paramView = (MessageForReplyText)paramView;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("MixedMsgItemBuilder", 2, "MixedMsgItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForMixedMsg or not contain replyText");
        return;
        if (!(localChatMessage instanceof MessageForLongMsg)) {
          break label264;
        }
        paramView = (MessageForLongMsg)localChatMessage;
        if (paramView.longMsgFragmentList == null) {
          break label264;
        }
        paramView = paramView.longMsgFragmentList;
        if (paramView.size() <= 0) {
          break label264;
        }
        paramView = (MessageRecord)paramView.get(0);
        if (!(paramView instanceof MessageForMixedMsg)) {
          break label264;
        }
        paramView = (MessageRecord)((MessageForMixedMsg)paramView).msgElemList.get(0);
        if (!(paramView instanceof MessageForReplyText)) {
          break label264;
        }
        paramView = (MessageForReplyText)paramView;
        i = 1;
        continue;
      }
      if (!(this.a.a instanceof FragmentActivity)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("MixedMsgItemBuilder", 2, "MixedMsgItemBuilder onClickListener: isReplyMsg = true");
      }
      BaseChatPie localBaseChatPie = ((FragmentActivity)this.a.a).getChatFragment().a();
      if (!localBaseChatPie.f()) {
        break;
      }
      localBaseChatPie.a(20, paramView.mSourceMsgInfo.mSourceMsgSeq, (int)(localChatMessage.shmsgseq - paramView.mSourceMsgInfo.mSourceMsgSeq), localChatMessage);
      MessageForReplyText.reportReplyMsg(null, "replyMsg_bubble", "clk_original", localChatMessage.frienduin, localChatMessage);
      return;
      label264:
      paramView = null;
      i = j;
      continue;
      label271:
      paramView = null;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uyy
 * JD-Core Version:    0.7.0.1
 */