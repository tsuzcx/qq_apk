package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.core.bean.f;
import com.tencent.token.cw;
import com.tmsdk.TMSDKContext;

class nw
  implements CompoundButton.OnCheckedChangeListener
{
  private ob b;
  
  nw(nu paramnu) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    paramCompoundButton = (ob)paramCompoundButton.getTag();
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
      if (!paramBoolean) {
        TMSDKContext.saveActionData(1150077);
      }
      for (;;)
      {
        paramCompoundButton.f.d = true;
        nu.a(this.a, paramCompoundButton);
        localObject = nu.a(this.a).getItem(82);
        if ((!paramCompoundButton.f.e) || (!((f)localObject).c)) {
          break;
        }
        nu.a(this.a).showUserDialog(2131230843, nu.a(this.a).getResources().getString(2131231537), 2131231555, 2131230886, new nx(this), new ny(this));
        return;
        TMSDKContext.saveActionData(1150078);
      }
      if (paramCompoundButton.f.e) {}
      for (i = 0;; i = 1)
      {
        paramCompoundButton = cw.a();
        localObject = nu.a(this.a).mA2;
        localHandler = nu.a(this.a).mHandler;
        paramCompoundButton.a(0L, new int[] { 71 }, new int[] { i }, (String)localObject, localHandler);
        return;
      }
    } while (paramBoolean != paramCompoundButton.f.c);
    paramCompoundButton.f.d = true;
    nu.a(this.a, paramCompoundButton);
    Object localObject = nu.a(this.a).getItem(80);
    if ((!paramCompoundButton.f.c) && (!((f)localObject).e))
    {
      nu.a(this.a).showUserDialog(2131230843, nu.a(this.a).getResources().getString(2131231556), 2131231555, 2131230886, new nz(this), new oa(this));
      return;
    }
    int j = paramCompoundButton.f.a;
    if (paramCompoundButton.f.c) {
      i = 0;
    }
    paramCompoundButton = cw.a();
    localObject = nu.a(this.a).mA2;
    Handler localHandler = nu.a(this.a).mHandler;
    paramCompoundButton.a(0L, new int[] { j }, new int[] { i }, (String)localObject, localHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nw
 * JD-Core Version:    0.7.0.1
 */