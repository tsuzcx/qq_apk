package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ch;

class qw
  implements View.OnClickListener
{
  qw(qv paramqv) {}
  
  public void onClick(View paramView)
  {
    ch.a().a(System.currentTimeMillis(), 223);
    paramView = new Intent(this.a.a, IndexActivity.class);
    paramView.putExtra("snap", true);
    paramView.putExtra("index_from", 16);
    this.a.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qw
 * JD-Core Version:    0.7.0.1
 */