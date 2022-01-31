package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class adq
  implements View.OnClickListener
{
  private int b;
  
  public adq(UtilsActivity paramUtilsActivity, int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void onClick(View paramView)
  {
    UtilsActivity.access$000(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.adq
 * JD-Core Version:    0.7.0.1
 */