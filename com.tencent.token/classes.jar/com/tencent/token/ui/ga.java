package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class ga
  implements View.OnClickListener
{
  ga(fz paramfz) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, IndexActivity.class);
    paramView.addFlags(67108864);
    this.a.a.startActivity(paramView);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ga
 * JD-Core Version:    0.7.0.1
 */