package com.tencent.token.ui.base;

import android.view.View;
import android.view.View.OnClickListener;

class cx
  implements View.OnClickListener
{
  cx(TitleOptionMenu paramTitleOptionMenu) {}
  
  public void onClick(View paramView)
  {
    if (TitleOptionMenu.a(this.a) != null) {
      TitleOptionMenu.a(this.a).a(((Integer)paramView.getTag()).intValue());
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.cx
 * JD-Core Version:    0.7.0.1
 */