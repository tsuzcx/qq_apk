package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class jx
  implements View.OnClickListener
{
  jx(jt paramjt) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, IndexActivity.class);
    paramView.putExtra("index_from", 16);
    paramView.addFlags(67108864);
    this.a.a.startActivity(paramView);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.jx
 * JD-Core Version:    0.7.0.1
 */