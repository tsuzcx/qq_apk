package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class mx
  implements View.OnClickListener
{
  mx(mw parammw) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, FindItemsActivity.class);
    paramView.addFlags(67108864);
    this.a.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.mx
 * JD-Core Version:    0.7.0.1
 */