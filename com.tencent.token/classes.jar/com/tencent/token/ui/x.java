package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ax;

final class x
  implements View.OnClickListener
{
  x(AccountPageActivity paramAccountPageActivity) {}
  
  public final void onClick(View paramView)
  {
    if (ax.a().e() == null) {
      this.a.showNoAccountTipDialog(this.a, 18, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.x
 * JD-Core Version:    0.7.0.1
 */