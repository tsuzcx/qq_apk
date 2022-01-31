package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class uk
  implements View.OnClickListener
{
  uk(RealNameActivity paramRealNameActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, RealNameDetailActivity.class);
    paramView.putExtra("index", 1);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.uk
 * JD-Core Version:    0.7.0.1
 */