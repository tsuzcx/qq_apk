import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;

public class wke
  implements View.OnLongClickListener
{
  public wke(BaseBubbleBuilder paramBaseBubbleBuilder) {}
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return false;
        localObject1 = paramView.getContext();
        if (!(localObject1 instanceof FragmentActivity)) {
          return true;
        }
        localObject2 = (FragmentActivity)localObject1;
        localObject1 = (String)paramView.getTag(2131364512);
        paramView = (ChatMessage)paramView.getTag();
        if (paramView == null) {
          break;
        }
        localObject2 = ((FragmentActivity)localObject2).getChatFragment();
      } while (localObject2 == null);
      localObject2 = ((ChatFragment)localObject2).a();
    } while (localObject2 == null);
    if ((localObject2 instanceof yam))
    {
      HotChatManager localHotChatManager = (HotChatManager)this.this$0.app.getManager(60);
      HotChatInfo localHotChatInfo = localHotChatManager.a(this.this$0.sessionInfo.aTl);
      if ((localHotChatInfo != null) && (localHotChatInfo.isGameRoom)) {
        return true;
      }
      aptw localaptw = (aptw)this.this$0.app.getManager(203);
      if ((localHotChatInfo != null) && ((this.this$0.app.getCurrentAccountUin().equals(localHotChatInfo.ownerUin)) || (((localHotChatInfo.isOwnerOrAdmin(this.this$0.app.getCurrentAccountUin())) || (localHotChatManager.aap())) && (!localHotChatInfo.isOwnerOrAdmin(paramView.senderuin)) && ((!localHotChatInfo.isRobotHotChat) || (!localaptw.gM(paramView.senderuin)))))) {
        ((yam)localObject2).h(paramView, (String)localObject1);
      }
    }
    for (;;)
    {
      return true;
      ((yam)localObject2).b(paramView.senderuin, (String)localObject1, false, 1);
      continue;
      if ((localObject2 instanceof TroopChatPie))
      {
        ((TroopChatPie)localObject2).b(paramView.senderuin, (String)localObject1, false, 1);
      }
      else if ((localObject2 instanceof xyi))
      {
        if (aqgv.aa(this.this$0.app, paramView.frienduin)) {
          return true;
        }
        ((xyi)localObject2).s(paramView.senderuin, (String)localObject1, false);
        anot.a(this.this$0.app, "CliOper", "", "", "0X8006210", "0X8006210", 0, 0, "", "", "", "");
      }
      else if ((localObject2 instanceof xys))
      {
        ((BaseChatPie)localObject2).bJd();
        anot.a(this.this$0.app, "dc00898", "", "", "0X800A010", "0X800A010", 0, 0, "", "", "", "");
      }
      else if (((localObject2 instanceof ydz)) || ((localObject2 instanceof ybt)) || ((localObject2 instanceof ycd)))
      {
        ((BaseChatPie)localObject2).bJd();
        anot.a(this.this$0.app, "dc00898", "", "", "0X800A011", "0X800A011", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wke
 * JD-Core Version:    0.7.0.1
 */