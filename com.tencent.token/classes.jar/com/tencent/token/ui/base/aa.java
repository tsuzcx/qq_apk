package com.tencent.token.ui.base;

import android.view.View;
import android.view.View.OnClickListener;

final class aa
  implements View.OnClickListener
{
  aa(ErrorView paramErrorView) {}
  
  public final void onClick(View paramView)
  {
    if (ErrorView.a(this.a) != null)
    {
      paramView.setTag(this.a.getTag());
      ErrorView.a(this.a).onClick(paramView);
    }
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.aa
 * JD-Core Version:    0.7.0.1
 */