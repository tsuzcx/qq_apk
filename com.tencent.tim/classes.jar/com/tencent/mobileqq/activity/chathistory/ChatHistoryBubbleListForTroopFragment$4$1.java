package com.tencent.mobileqq.activity.chathistory;

import acfp;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import ymg;

class ChatHistoryBubbleListForTroopFragment$4$1
  implements Runnable
{
  ChatHistoryBubbleListForTroopFragment$4$1(ChatHistoryBubbleListForTroopFragment.4 param4, List paramList) {}
  
  public void run()
  {
    int i = 1;
    int k = 0;
    if (this.a.bZV != this.a.this$0.bZU)
    {
      if (QLog.isColorLevel()) {
        QLog.d("chatHistory.troop.msgList", 2, "loadingContext changed, ignored result local=" + this.a.bZV + ", global=" + this.a.this$0.bZU);
      }
      return;
    }
    ymg localymg = this.a.this$0.b;
    List localList = this.sN;
    boolean bool;
    label115:
    int m;
    label237:
    int j;
    if (this.sN.size() < 20)
    {
      bool = true;
      m = localymg.c(localList, bool);
      if (this.a.this$0.b.getCount() > 0)
      {
        this.a.this$0.Kr = ((MessageRecord)this.a.this$0.b.getItem(0)).shmsgseq;
        this.a.this$0.Ks = ((MessageRecord)this.a.this$0.b.getItem(this.a.this$0.b.getCount() - 1)).shmsgseq;
      }
      if ((m == 0) || (this.a.this$0.d.getChildCount() <= 0)) {
        break label419;
      }
      if (i == 0) {
        break label424;
      }
      j = this.a.this$0.d.getFirstVisiblePosition();
      k = this.a.this$0.d.getChildAt(0).getTop();
    }
    for (;;)
    {
      this.a.this$0.KO.setText(acfp.m(2131703628));
      this.a.this$0.bf(this.a.this$0.b.bnz, this.a.this$0.b.mHasMore);
      this.a.this$0.b.notifyDataSetChanged();
      if (i == 0) {
        break;
      }
      this.a.this$0.d.setSelectionFromTop(j + m, k);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("chatHistory.troop.msgList", 2, "update position pos=" + j + ", offset=" + m + ", top=" + k);
      return;
      bool = false;
      break label115;
      label419:
      i = 0;
      break label237;
      label424:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment.4.1
 * JD-Core Version:    0.7.0.1
 */