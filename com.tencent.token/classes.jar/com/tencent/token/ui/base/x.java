package com.tencent.token.ui.base;

import android.view.View;
import android.view.View.OnClickListener;

class x
  implements View.OnClickListener
{
  x(ErrorView paramErrorView) {}
  
  public void onClick(View paramView)
  {
    if (ErrorView.a(this.a) != null)
    {
      paramView.setTag(this.a.getTag());
      ErrorView.a(this.a).onClick(paramView);
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.x
 * JD-Core Version:    0.7.0.1
 */