package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.af;
import com.tencent.token.core.bean.e;
import com.tencent.token.ui.base.SwitchButton;

final class ot
  implements CompoundButton.OnCheckedChangeListener
{
  private oy b;
  
  ot(or paramor) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    paramCompoundButton = (oy)((SwitchButton)paramCompoundButton).getTag();
    if ((paramCompoundButton == null) || (paramCompoundButton.f == null) || (paramCompoundButton.a == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          this.b = paramCompoundButton;
        } while (paramCompoundButton.f.d);
        switch (paramCompoundButton.f.a)
        {
        case 81: 
        default: 
          return;
        }
      } while (paramBoolean != paramCompoundButton.f.e);
      paramCompoundButton.f.d = true;
      or.a(this.a, paramCompoundButton);
      localObject = or.a(this.a).getItem(82);
      if ((paramCompoundButton.f.e) && (((e)localObject).c))
      {
        or.a(this.a).showUserDialog(2131361808, or.a(this.a).getResources().getString(2131362246), 2131362256, 2131361804, new ou(this), new ov(this));
        return;
      }
      if (paramCompoundButton.f.e) {}
      for (i = 0;; i = 1)
      {
        paramCompoundButton = af.a();
        localObject = or.a(this.a).mA2;
        localHandler = or.a(this.a).mHandler;
        paramCompoundButton.b(0L, new int[] { 71 }, new int[] { i }, (String)localObject, localHandler);
        return;
      }
    } while (paramBoolean != paramCompoundButton.f.c);
    paramCompoundButton.f.d = true;
    or.a(this.a, paramCompoundButton);
    Object localObject = or.a(this.a).getItem(80);
    if ((!paramCompoundButton.f.c) && (!((e)localObject).e))
    {
      or.a(this.a).showUserDialog(2131361808, or.a(this.a).getResources().getString(2131362255), 2131362256, 2131361804, new ow(this), new ox(this));
      return;
    }
    int j = paramCompoundButton.f.a;
    if (paramCompoundButton.f.c) {
      i = 0;
    }
    paramCompoundButton = af.a();
    localObject = or.a(this.a).mA2;
    Handler localHandler = or.a(this.a).mHandler;
    paramCompoundButton.b(0L, new int[] { j }, new int[] { i }, (String)localObject, localHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ot
 * JD-Core Version:    0.7.0.1
 */