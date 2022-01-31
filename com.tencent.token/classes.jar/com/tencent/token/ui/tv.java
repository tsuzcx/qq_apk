package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class tv
  implements View.OnClickListener
{
  tv(RealNameActivity paramRealNameActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, RealNameDetailActivity.class);
    paramView.putExtra("index", 1);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.tv
 * JD-Core Version:    0.7.0.1
 */