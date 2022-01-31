package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class rt
  implements View.OnClickListener
{
  rt(NetActiveVryQQTokenActivity paramNetActiveVryQQTokenActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, IndexActivity.class);
    paramView.putExtra("index_from", 16);
    this.a.startActivity(paramView);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rt
 * JD-Core Version:    0.7.0.1
 */