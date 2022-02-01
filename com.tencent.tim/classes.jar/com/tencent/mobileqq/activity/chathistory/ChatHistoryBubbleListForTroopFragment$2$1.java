package com.tencent.mobileqq.activity.chathistory;

import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import ymg;

class ChatHistoryBubbleListForTroopFragment$2$1
  implements Runnable
{
  ChatHistoryBubbleListForTroopFragment$2$1(ChatHistoryBubbleListForTroopFragment.2 param2, List paramList) {}
  
  public void run()
  {
    ymg localymg = this.a.this$0.b;
    List localList = this.sN;
    if (this.sN.size() < 20) {}
    for (boolean bool = true;; bool = false)
    {
      localymg.b(localList, bool);
      if (this.a.this$0.b.getCount() > 0)
      {
        this.a.this$0.Kr = ((MessageRecord)this.a.this$0.b.getItem(0)).shmsgseq;
        this.a.this$0.Ks = ((MessageRecord)this.a.this$0.b.getItem(this.a.this$0.b.getCount() - 1)).shmsgseq;
      }
      this.a.this$0.bf(this.a.this$0.b.bnz, this.a.this$0.b.mHasMore);
      this.a.this$0.b.notifyDataSetChanged();
      this.a.this$0.d.setSelection(this.a.this$0.b.getCount() - 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment.2.1
 * JD-Core Version:    0.7.0.1
 */