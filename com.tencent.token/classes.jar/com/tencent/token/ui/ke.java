package com.tencent.token.ui;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.core.bean.h;
import com.tencent.token.dr;

class ke
  implements CompoundButton.OnCheckedChangeListener
{
  ke(kb paramkb) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = (kf)paramCompoundButton.getTag();
    if (paramCompoundButton == null) {}
    h localh;
    View localView;
    do
    {
      return;
      localh = paramCompoundButton.a();
      localView = paramCompoundButton.f();
    } while ((localh == null) || (localView == null) || (!dr.a().p()) || (paramBoolean != localh.c) || (localh.e));
    localh.e = true;
    this.a.a(paramCompoundButton, false);
    this.a.a(paramCompoundButton);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ke
 * JD-Core Version:    0.7.0.1
 */