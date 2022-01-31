package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class bg
  implements View.OnClickListener
{
  bg(BaseActivity paramBaseActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(BaseActivity.access$100(this.a), IndexActivity.class);
    paramView.putExtra("index_from", 16);
    BaseActivity.access$100(this.a).startActivity(paramView);
    BaseActivity.access$100(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.bg
 * JD-Core Version:    0.7.0.1
 */