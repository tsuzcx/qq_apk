package com.tencent.mobileqq.activity.aio.item;

import abxk;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ApolloItemBuilder$1
  implements Runnable
{
  ApolloItemBuilder$1(ApolloItemBuilder paramApolloItemBuilder, MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, ApolloItemBuilder.b paramb) {}
  
  public void run()
  {
    Object localObject;
    int i;
    if (this.b.mApolloMessage != null)
    {
      localObject = ((abxk)this.this$0.app.getManager(155)).a(this.b.mApolloMessage.id);
      if ((localObject == null) || (this.this$0.sessionInfo == null) || (this.c == null) || (this.b.hasPlayed) || (((ApolloActionData)localObject).feeType != 1) || (this.this$0.sessionInfo.cZ != 1) || (ApolloGameUtil.ib(this.b.msgType))) {
        break label342;
      }
      localObject = new ApolloItemBuilder.PlusOneManagerTask(this.this$0, this.a, this.b, 0);
      ((ApolloItemBuilder.PlusOneManagerTask)localObject).bgx = this.this$0.bdn;
      ThreadManager.getUIHandler().post((Runnable)localObject);
      localObject = new ApolloItemBuilder.PlusOneManagerTask(this.this$0, this.a, this.b, 1);
      ThreadManager.getUIHandler().postDelayed((Runnable)localObject, 8000L);
      if ((this.this$0.mContext != null) && (((FragmentActivity)this.this$0.mContext).getChatFragment() != null))
      {
        localObject = ((FragmentActivity)this.this$0.mContext).getChatFragment().a();
        if ((localObject != null) && (!this.b.hasPlayed) && (ApolloItemBuilder.a(this.this$0) != this.b.uniseq))
        {
          if (((BaseChatPie)localObject).vm() != 21) {
            break label332;
          }
          i = 1;
          localObject = this.this$0.app;
          if (!this.b.isDoubleAction()) {
            break label337;
          }
        }
      }
    }
    label332:
    label337:
    for (int j = 1;; j = 0)
    {
      VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "grouppluspv", i, j, new String[] { Integer.toString(this.b.mApolloMessage.id) });
      ApolloItemBuilder.a(this.this$0, this.b.uniseq);
      return;
      i = 0;
      break;
    }
    label342:
    if (this.c != null)
    {
      ThreadManager.getUIHandler().post(new ApolloItemBuilder.1.1(this));
      return;
    }
    QLog.i("ApolloItemBuilder", 1, "convertView is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */