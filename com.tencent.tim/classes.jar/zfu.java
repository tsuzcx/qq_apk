import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zfu
  implements View.OnClickListener
{
  public zfu(ChatHistoryC2CLinkFragment paramChatHistoryC2CLinkFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof String))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Object localObject1 = (ChatMessage)((zfr.b)paramView.getTag()).entity;
    if (this.this$0.aTT)
    {
      this.this$0.a.aL(localObject1);
      this.this$0.b.notifyDataSetChanged();
    }
    while ((!(localObject1 instanceof MessageForStructing)) || (((MessageForStructing)localObject1).structingMsg == null) || (!(((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg)))
    {
      this.this$0.b.notifyDataSetChanged();
      break;
    }
    localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
    Object localObject2;
    if ((localObject1 instanceof StructMsgForGeneralShare))
    {
      localObject2 = (StructMsgForGeneralShare)localObject1;
      StructMsgForGeneralShare.a locala = new StructMsgForGeneralShare.a(this.this$0.mApp, paramView, (StructMsgForGeneralShare)localObject2);
      StructMsgForGeneralShare.onClickEvent(this.this$0.mApp, this.this$0.mContext, (StructMsgForGeneralShare)localObject2, paramView, locala);
    }
    for (;;)
    {
      ((AbsShareMsg)localObject1).getOnClickListener().onClick(paramView);
      break;
      if ((localObject1 instanceof StructMsgForAudioShare))
      {
        localObject2 = (StructMsgForAudioShare)localObject1;
        StructMsgForAudioShare.onClickEvent(this.this$0.mContext, (StructMsgForAudioShare)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zfu
 * JD-Core Version:    0.7.0.1
 */