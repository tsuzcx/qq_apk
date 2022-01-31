package com.tencent.token.ui.base;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.token.global.h;

class ad
  implements View.OnClickListener
{
  ad(FreezeUinDialog paramFreezeUinDialog, CheckBox paramCheckBox) {}
  
  public void onClick(View paramView)
  {
    this.b.dismiss();
    if (FreezeUinDialog.a(this.b) != null)
    {
      h.a("freeze: msg=4009");
      paramView = FreezeUinDialog.a(this.b).obtainMessage(4009);
      if (!this.a.isChecked()) {
        break label64;
      }
      paramView.arg1 = 1;
    }
    for (;;)
    {
      FreezeUinDialog.a(this.b).sendMessage(paramView);
      return;
      label64:
      paramView.arg2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ad
 * JD-Core Version:    0.7.0.1
 */