package com.tencent.token.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.ba;
import com.tencent.token.bf;
import com.tencent.token.core.bean.g;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.ui.base.ds;

final class kw
  implements CompoundButton.OnCheckedChangeListener
{
  kw(ku paramku) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = (ds)((SwitchButton)paramCompoundButton).getTag();
    if (paramCompoundButton == null) {}
    g localg;
    do
    {
      return;
      localg = paramCompoundButton.a();
    } while ((localg == null) || (paramCompoundButton.h() == null) || (!ba.a().n()) || (paramBoolean != localg.c) || (localg.e) || (ku.a(this.a)));
    ku.a(this.a, localg);
    ku.a(this.a, paramCompoundButton);
    localg.e = true;
    ku.b(this.a);
    this.a.a(paramCompoundButton, false);
    bf.a().a(3, ku.c(this.a).getHandler());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.kw
 * JD-Core Version:    0.7.0.1
 */