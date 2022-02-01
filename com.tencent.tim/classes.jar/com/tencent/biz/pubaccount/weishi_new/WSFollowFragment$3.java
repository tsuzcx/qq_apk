package com.tencent.biz.pubaccount.weishi_new;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import ojm;
import olu;
import ooz;

class WSFollowFragment$3
  implements Runnable
{
  WSFollowFragment$3(WSFollowFragment paramWSFollowFragment, String paramString1, String paramString2) {}
  
  public void run()
  {
    RecyclerView.ViewHolder localViewHolder = this.this$0.b.a().findViewHolderForLayoutPosition(((olu)this.this$0.a).rE());
    ooz.bY("WSFollowContinuePlayLog", "[WSFollowFragment.java][onActivityResult] from vertical getLastPosition:" + ((olu)this.this$0.a).rE() + ", holder:" + localViewHolder);
    if ((localViewHolder instanceof ojm)) {
      this.this$0.a((ojm)localViewHolder, this.val$from, this.apX);
    }
    WSFollowFragment.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowFragment.3
 * JD-Core Version:    0.7.0.1
 */