package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class sc
  implements View.OnClickListener
{
  sc(OpMsgDisplayActivity paramOpMsgDisplayActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, IndexActivity.class);
    paramView.putExtra("index_from", 17);
    this.a.startActivity(paramView);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.sc
 * JD-Core Version:    0.7.0.1
 */