import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class xox
  implements View.OnClickListener
{
  xox(xov paramxov) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = wja.a(paramView);
    if (!(localObject1 instanceof MessageForText)) {
      if (QLog.isColorLevel()) {
        QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForText");
      }
    }
    MessageForText localMessageForText;
    label56:
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localMessageForText = (MessageForText)localObject1;
      if (localMessageForText.sb == null) {
        break;
      }
      localObject1 = localMessageForText.sb.toString();
      ujt.d locald = new ujt.d();
      if ((this.this$0.mContext instanceof FragmentActivity))
      {
        localObject2 = ((FragmentActivity)this.this$0.mContext).getChatFragment().a();
        if (localObject2 != null)
        {
          localObject2 = (wwn)((BaseChatPie)localObject2).a(27);
          if (localObject2 != null) {
            ((wwn)localObject2).a((String)localObject1, locald, 0);
          }
        }
      }
      Object localObject2 = MessageForText.getTroopMemberInfoFromExtrJson(localMessageForText.getExtInfoFromExtStr(anbb.ccR));
      ujt.a(this.this$0.app, this.this$0.mContext, this.this$0.sessionInfo, (String)localObject1, (ArrayList)localObject2, locald);
    } while (this.this$0.sessionInfo.cZ != 1);
    localObject1 = (HotChatManager)this.this$0.app.getManager(60);
    if ((localObject1 != null) && (((HotChatManager)localObject1).kj(this.this$0.sessionInfo.aTl))) {}
    for (localObject1 = "2";; localObject1 = "1")
    {
      anot.a(this.this$0.app, "dc00899", "Grp_msg", "", "grp_msg", "clk_like", 0, 0, localMessageForText.frienduin, "", (String)localObject1, "");
      break;
      localObject1 = localMessageForText.msg;
      break label56;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xox
 * JD-Core Version:    0.7.0.1
 */