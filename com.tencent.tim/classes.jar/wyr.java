import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Apollo3DMessage;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wyr
  implements View.OnClickListener
{
  public wyr(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    int k = 1;
    Object localObject;
    int i;
    int j;
    label72:
    ApolloMessage localApolloMessage;
    Apollo3DMessage localApollo3DMessage;
    if (ApolloItemBuilder.a(this.this$0) != null)
    {
      localObject = ((FragmentActivity)this.this$0.mContext).getChatFragment().a();
      if (localObject != null)
      {
        if (((BaseChatPie)localObject).vm() != 21) {
          break label155;
        }
        i = 1;
        localObject = this.this$0.app;
        if (!ApolloItemBuilder.a(this.this$0).isDoubleAction()) {
          break label160;
        }
        j = 1;
        VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "groupplusclick", i, j, new String[] { Integer.toString(ApolloItemBuilder.a(this.this$0).mApolloMessage.id) });
      }
      localApolloMessage = ApolloItemBuilder.a(this.this$0).mApolloMessage;
      localApollo3DMessage = ApolloItemBuilder.a(this.this$0).mApollo3DMessage;
      if ((localApolloMessage != null) && (this.this$0.app != null)) {
        break label165;
      }
    }
    label155:
    label160:
    label165:
    acad localacad;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
      break;
      j = 0;
      break label72;
      localacad = new acad(this.this$0.app.getCurrentUin());
      localObject = new ApolloActionData();
      abxk localabxk = (abxk)this.this$0.app.getManager(155);
      if (localabxk == null) {
        break label437;
      }
      j = localApolloMessage.id;
      i = j;
      if (localApollo3DMessage != null)
      {
        i = j;
        if (ApolloActionData.isAction3DModel(localApollo3DMessage.actionID_3D)) {
          i = localApollo3DMessage.actionID_3D;
        }
      }
      localObject = localabxk.a(i);
    } while (localObject == null);
    label437:
    for (;;)
    {
      ((ApolloActionData)localObject).peerUin = (localApolloMessage.peer_uin + "");
      if (localApolloMessage.text != null) {
        ((ApolloActionData)localObject).atNickName = new String(localApolloMessage.text);
      }
      ((ApolloActionData)localObject).inputText = ApolloItemBuilder.a(this.this$0).inputText;
      localacad.c = ((ApolloActionData)localObject);
      if (ApolloItemBuilder.a(this.this$0).isBarrageMode()) {}
      for (i = k;; i = 0)
      {
        localacad.cue = i;
        localacad.bkj = ApolloItemBuilder.a(this.this$0).inputText;
        localacad.cre = ApolloItemBuilder.a(this.this$0).audioId;
        localacad.sC = ApolloItemBuilder.a(this.this$0).audioStartTime;
        ujt.a(this.this$0.app, this.this$0.mContext, this.this$0.sessionInfo, localacad);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyr
 * JD-Core Version:    0.7.0.1
 */