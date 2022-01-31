package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.do;

class acw
  implements View.OnClickListener
{
  acw(UtilsMailProtectActivity paramUtilsMailProtectActivity) {}
  
  public void onClick(View paramView)
  {
    if (do.a().e() == null) {
      return;
    }
    UtilsMailProtectActivity.access$000(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.acw
 * JD-Core Version:    0.7.0.1
 */