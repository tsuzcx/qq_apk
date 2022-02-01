package com.tencent.mobileqq.activity.history;

import android.view.View;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import ymg;

class ChatHistoryTroopAllFragment$5$1
  implements Runnable
{
  ChatHistoryTroopAllFragment$5$1(ChatHistoryTroopAllFragment.5 param5, List paramList) {}
  
  public void run()
  {
    int j = 1;
    int i = 0;
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
    int i1;
    label237:
    int m;
    if (this.sN.size() < 20)
    {
      bool = true;
      i1 = localymg.b(localList, bool);
      if (this.a.this$0.b.getCount() > 0)
      {
        this.a.this$0.Kr = ((MessageRecord)this.a.this$0.b.getItem(0)).shmsgseq;
        this.a.this$0.Ks = ((MessageRecord)this.a.this$0.b.getItem(this.a.this$0.b.getCount() - 1)).shmsgseq;
      }
      if ((i1 == 0) || (this.a.this$0.d.getChildCount() <= 0)) {
        break label497;
      }
      if (j == 0) {
        break label502;
      }
      m = this.a.this$0.d.getFirstVisiblePosition();
      int n = this.a.this$0.d.getChildAt(0).getTop();
      k = m;
      i = n;
      if (this.a.this$0.d.getScrollY() < 0) {
        i = n - this.a.this$0.d.getScrollY();
      }
    }
    label497:
    label502:
    for (int k = m;; k = 0)
    {
      this.a.this$0.d.hideOverScrollHeaderView();
      this.a.this$0.bf(this.a.this$0.b.bnz, this.a.this$0.b.mHasMore);
      if (this.a.this$0.b.getCount() == 0) {
        this.a.this$0.d.setEmptyView(ChatHistoryTroopAllFragment.a(this.a.this$0));
      }
      this.a.this$0.b.notifyDataSetChanged();
      if (j == 0) {
        break;
      }
      this.a.this$0.d.setSelectionFromTop(k + i1, i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("chatHistory.troop.msgList", 2, "update position pos=" + k + ", offset=" + i1 + ", top=" + i);
      return;
      bool = false;
      break label115;
      j = 0;
      break label237;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment.5.1
 * JD-Core Version:    0.7.0.1
 */