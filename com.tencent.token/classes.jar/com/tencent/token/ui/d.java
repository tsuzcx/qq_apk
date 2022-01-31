package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;

class d
  implements View.OnLongClickListener
{
  d(AboutActivity paramAboutActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = new Intent(this.a, ShowLogActivity.class);
    this.a.startActivity(paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.d
 * JD-Core Version:    0.7.0.1
 */