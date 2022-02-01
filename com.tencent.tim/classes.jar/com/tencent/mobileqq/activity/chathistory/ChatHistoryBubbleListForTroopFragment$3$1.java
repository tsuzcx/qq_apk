package com.tencent.mobileqq.activity.chathistory;

import acfp;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import ymg;

class ChatHistoryBubbleListForTroopFragment$3$1
  implements Runnable
{
  ChatHistoryBubbleListForTroopFragment$3$1(ChatHistoryBubbleListForTroopFragment.3 param3, List paramList) {}
  
  public void run()
  {
    ymg localymg = this.a.this$0.b;
    List localList = this.sN;
    if (this.sN.size() < 21) {}
    for (boolean bool = true;; bool = false)
    {
      localymg.c(localList, bool);
      if (this.a.this$0.b.getCount() > 0)
      {
        this.a.this$0.Kr = ((MessageRecord)this.a.this$0.b.getItem(0)).shmsgseq;
        this.a.this$0.Ks = ((MessageRecord)this.a.this$0.b.getItem(this.a.this$0.b.getCount() - 1)).shmsgseq;
      }
      this.a.this$0.b.bnz = true;
      this.a.this$0.KO.setText(acfp.m(2131703666));
      this.a.this$0.bf(this.a.this$0.b.bnz, this.a.this$0.b.mHasMore);
      this.a.this$0.b.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment.3.1
 * JD-Core Version:    0.7.0.1
 */