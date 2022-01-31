package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

final class nu
  implements View.OnClickListener
{
  nu(KnowTokenActivity paramKnowTokenActivity) {}
  
  public final void onClick(View paramView)
  {
    KnowTokenActivity.access$600(this.a).setEnabled(false);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nu
 * JD-Core Version:    0.7.0.1
 */