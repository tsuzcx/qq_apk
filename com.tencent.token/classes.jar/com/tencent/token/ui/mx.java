package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

class mx
  implements View.OnClickListener
{
  mx(KnowTokenActivity paramKnowTokenActivity) {}
  
  public void onClick(View paramView)
  {
    KnowTokenActivity.access$600(this.a).setEnabled(false);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.mx
 * JD-Core Version:    0.7.0.1
 */