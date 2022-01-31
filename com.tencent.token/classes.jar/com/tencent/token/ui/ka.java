package com.tencent.token.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.core.bean.h;
import com.tencent.token.dr;
import com.tencent.token.dw;
import com.tencent.token.ui.base.dj;

class ka
  implements CompoundButton.OnCheckedChangeListener
{
  ka(jy paramjy) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = (dj)paramCompoundButton.getTag();
    if (paramCompoundButton == null) {}
    h localh;
    do
    {
      return;
      localh = paramCompoundButton.a();
    } while ((localh == null) || (paramCompoundButton.h() == null) || (!dr.a().o()) || (paramBoolean != localh.c) || (localh.e) || (jy.a(this.a)));
    jy.a(this.a, localh);
    jy.a(this.a, paramCompoundButton);
    localh.e = true;
    jy.a(this.a, true);
    this.a.a(paramCompoundButton, false);
    dw.a().a(3, jy.b(this.a).getHandler());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ka
 * JD-Core Version:    0.7.0.1
 */