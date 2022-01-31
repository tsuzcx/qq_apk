package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.er;

class su
  implements View.OnClickListener
{
  su(OpreateMsgActivity paramOpreateMsgActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.isListEdit())
    {
      this.a.hideListEdit();
      OpreateMsgActivity.access$200(this.a).c();
      this.a.mAdapter.notifyDataSetChanged();
    }
    while (OpreateMsgActivity.access$200(this.a).g() <= 0) {
      return;
    }
    this.a.showListEdit();
    this.a.mAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.su
 * JD-Core Version:    0.7.0.1
 */