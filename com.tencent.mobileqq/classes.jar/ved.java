import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.LightReplyMsgRich2;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;

public class ved
  implements View.OnClickListener
{
  public ved(ReplyTextItemBuilder paramReplyTextItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (ReplyTextItemBuilder.a(this.a)) {}
    do
    {
      do
      {
        Object localObject1;
        Object localObject2;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                localObject1 = AIOUtils.a(paramView);
                if ((localObject1 instanceof MessageForReplyText)) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForReplyText");
              return;
              localObject1 = (MessageForReplyText)localObject1;
              localObject2 = ((MessageForReplyText)localObject1).mSourceMsgInfo;
              if (localObject2 != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) sourceMsgInfo is null");
            return;
            if (((MessageForReplyText.SourceMsgInfo)localObject2).mType == 2)
            {
              localObject2 = ReplyTextItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForReplyText)localObject1).frienduin, ((MessageForReplyText)localObject1).istroop, ((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgSeq);
              if (localObject2 == null) {
                ThreadManager.post(new vee(this, (MessageForReplyText)localObject1, paramView), 8, null, true);
              }
              for (;;)
              {
                paramView = new MessageForReplyText.LightReplyMsgRich2(((MessageForReplyText)localObject1).mSourceMsgInfo.mRichMsg2).emotionId;
                ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_replyPic", "", "replyPic_bubble", "open_oringal", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView, "", "");
                return;
                this.a.a((MessageForReplyText)localObject1, (MessageRecord)localObject2, paramView);
              }
            }
            if (((MessageForReplyText)localObject1).msgtype == -1003)
            {
              AIOUtils.m = true;
              String str = PkgTools.a(((MessageForReplyText)localObject1).action);
              paramView = JumpParser.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), str);
              if (paramView != null) {
                paramView.b();
              }
            }
          } while (!(this.a.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity));
          paramView = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment();
          if (paramView == null) {
            break;
          }
          paramView = paramView.a();
        } while (!paramView.f());
        paramView.a(20, ((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgSeq, (int)(((MessageForReplyText)localObject1).shmsgseq - ((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgSeq), (MessageRecord)localObject1);
        MessageForReplyText.reportReplyMsg(null, "replyMsg_bubble", "clk_original", ((MessageForReplyText)localObject1).frienduin, (ChatMessage)localObject1);
      } while (!QLog.isColorLevel());
      QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: isReplyMsg = true");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("ChatItemBuilder", 2, "getChatFragment() is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ved
 * JD-Core Version:    0.7.0.1
 */