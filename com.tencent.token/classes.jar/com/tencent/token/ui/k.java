package com.tencent.token.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.global.j;
import com.tencent.token.ui.base.UtilsAccountLockTipDialog;
import com.tencent.token.ui.base.dj;

class k
  implements CompoundButton.OnCheckedChangeListener
{
  k(i parami) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = (dj)paramCompoundButton.getTag();
    if (paramCompoundButton == null) {
      return;
    }
    if ((!j.e()) && (!paramBoolean))
    {
      j.b(true);
      new UtilsAccountLockTipDialog(i.a(this.a), 2131362182, i.b(this.a), paramCompoundButton, paramBoolean).show();
      return;
    }
    this.a.b(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.k
 * JD-Core Version:    0.7.0.1
 */