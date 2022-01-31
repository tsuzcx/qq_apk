package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;

class afv
  implements View.OnClickListener
{
  afv(WtLoginAccountInput paramWtLoginAccountInput) {}
  
  public void onClick(View paramView)
  {
    if ((!WtLoginAccountInput.access$1000(this.a)) && (WtLoginAccountInput.access$1100(this.a) != 7))
    {
      WtLoginAccountInput.access$1200(this.a);
      return;
    }
    this.a.onBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afv
 * JD-Core Version:    0.7.0.1
 */