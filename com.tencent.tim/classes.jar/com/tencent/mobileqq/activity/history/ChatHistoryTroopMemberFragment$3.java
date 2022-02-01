package com.tencent.mobileqq.activity.history;

import acff;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import aqgx;
import com.tencent.mobileqq.data.TroopMemberInfo;
import java.util.List;

class ChatHistoryTroopMemberFragment$3
  implements Runnable
{
  ChatHistoryTroopMemberFragment$3(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, acff paramacff) {}
  
  public void run()
  {
    Object localObject1 = aqgx.a().a(this.this$0.getActivity().app, this.this$0.mTroopUin, this.this$0.aRb);
    aqgx.a().a(this.this$0.getActivity().app, this.this$0.mTroopUin, this.this$0.aRb);
    if ((localObject1 != null) && (this.g != null))
    {
      this.this$0.a(this.this$0.aRb);
      synchronized (this.this$0)
      {
        localObject1 = this.this$0.a((TroopMemberInfo)localObject1, this.g);
        this.this$0.pr.add(localObject1);
        this.this$0.mHandler.sendEmptyMessage(9);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.3
 * JD-Core Version:    0.7.0.1
 */