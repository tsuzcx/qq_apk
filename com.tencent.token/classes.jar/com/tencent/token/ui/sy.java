package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.er;

class sy
  implements View.OnClickListener
{
  private sy(OpreateMsgActivity paramOpreateMsgActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.mIsSelectAll) {
      OpreateMsgActivity.access$200(this.a).c();
    }
    for (;;)
    {
      this.a.mAdapter.notifyDataSetChanged();
      return;
      OpreateMsgActivity.access$200(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.sy
 * JD-Core Version:    0.7.0.1
 */