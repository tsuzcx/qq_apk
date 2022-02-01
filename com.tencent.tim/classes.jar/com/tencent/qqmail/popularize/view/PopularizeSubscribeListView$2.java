package com.tencent.qqmail.popularize.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.qqmail.popularize.model.Popularize;

class PopularizeSubscribeListView$2
  implements View.OnLongClickListener
{
  PopularizeSubscribeListView$2(PopularizeSubscribeListView paramPopularizeSubscribeListView, int paramInt, Popularize paramPopularize) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.this$0.getOnSubscribeItemLongClickListener() != null) {
      this.this$0.getOnSubscribeItemLongClickListener().onItemLongClick(this.val$position, this.val$popularize, paramView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeSubscribeListView.2
 * JD-Core Version:    0.7.0.1
 */