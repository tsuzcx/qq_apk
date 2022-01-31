package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;

class js
  implements View.OnClickListener
{
  js(FreezeStatusActivity paramFreezeStatusActivity) {}
  
  public void onClick(View paramView)
  {
    if ((Integer)paramView.getTag() == null) {
      return;
    }
    this.a.queryFreezeStatus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.js
 * JD-Core Version:    0.7.0.1
 */