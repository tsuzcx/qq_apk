package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class nb
  implements View.OnClickListener
{
  nb(JLFindItems paramJLFindItems) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, JLFinditemsChooseZone.class);
    this.a.startActivityForResult(paramView, 100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nb
 * JD-Core Version:    0.7.0.1
 */