package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class uj
  implements View.OnClickListener
{
  uj(RealNameActivity paramRealNameActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, RealNameDetailActivity.class);
    paramView.putExtra("index", 0);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.uj
 * JD-Core Version:    0.7.0.1
 */