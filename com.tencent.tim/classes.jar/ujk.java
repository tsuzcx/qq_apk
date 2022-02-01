import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class ujk
  implements View.OnClickListener
{
  public ujk(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.this$0.a.getTag(2131374473);
      if ((localObject instanceof appe))
      {
        localObject = (appe)localObject;
        if ((localObject != null) && (this.this$0.sessionInfo != null))
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.aio.BaseChatPie", 2, "TextItemBuilder onClickListener: isReplyMsg = true, mSourceMsgSeq = " + ((appe)localObject).mSourceMsgSeq);
          }
          BaseChatPie localBaseChatPie = this.this$0.mActivity.getChatFragment().a();
          if ((this.this$0.sessionInfo.cZ == 0) && ((localBaseChatPie instanceof xys)))
          {
            ((xys)localBaseChatPie).a(22, ((appe)localObject).origUid, ((appe)localObject).arQ, null);
          }
          else if (localBaseChatPie.OP())
          {
            QQMessageFacade.Message localMessage = this.this$0.app.b().a(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ);
            localBaseChatPie.a(22, ((appe)localObject).mSourceMsgSeq, (int)(localMessage.shmsgseq - ((appe)localObject).mSourceMsgSeq), null);
            MessageForReplyText.reportReplyMsg(null, "typebox", "clk_original", this.this$0.sessionInfo.aTl, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ujk
 * JD-Core Version:    0.7.0.1
 */