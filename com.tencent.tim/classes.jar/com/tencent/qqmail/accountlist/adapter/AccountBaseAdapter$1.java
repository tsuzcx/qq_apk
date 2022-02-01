package com.tencent.qqmail.accountlist.adapter;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qqmail.view.keeppressed.KeepPressedRelativeLayout;

class AccountBaseAdapter$1
  implements View.OnLayoutChangeListener
{
  AccountBaseAdapter$1(AccountBaseAdapter paramAccountBaseAdapter, KeepPressedRelativeLayout paramKeepPressedRelativeLayout, AccountBaseAdapter.ViewHolder paramViewHolder) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramInt3 - paramInt1 != paramInt7 - paramInt5)
    {
      this.val$layout.updateDividerInsetLeft(0, this.val$fHolder.getInsetLeft(this.this$0.mContext));
      this.val$layout.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.adapter.AccountBaseAdapter.1
 * JD-Core Version:    0.7.0.1
 */