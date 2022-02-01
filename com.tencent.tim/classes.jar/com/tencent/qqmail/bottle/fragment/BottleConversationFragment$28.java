package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.bottle.view.ReplyListView.onResizeListener;

class BottleConversationFragment$28
  implements ReplyListView.onResizeListener
{
  BottleConversationFragment$28(BottleConversationFragment paramBottleConversationFragment) {}
  
  public void onSizeChange(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 == 0) && (paramInt4 == 0) && (BottleConversationFragment.access$2500(this.this$0) == -1)) {
      BottleConversationFragment.access$2502(this.this$0, paramInt2);
    }
    if ((paramInt1 == paramInt3) && (paramInt2 < BottleConversationFragment.access$2500(this.this$0))) {
      if (!BottleConversationFragment.access$2400(this.this$0))
      {
        BottleConversationFragment.access$2402(this.this$0, true);
        BottleConversationFragment.access$2600(this.this$0, true);
      }
    }
    while ((paramInt1 != paramInt3) || (paramInt2 != BottleConversationFragment.access$2500(this.this$0)) || (!BottleConversationFragment.access$2400(this.this$0))) {
      return;
    }
    BottleConversationFragment.access$2402(this.this$0, false);
    BottleConversationFragment.access$2600(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.28
 * JD-Core Version:    0.7.0.1
 */