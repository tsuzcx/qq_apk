package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.global.h;
import com.tencent.token.utils.x;

class rh
  implements View.OnClickListener
{
  rh(NetActiveVryQuesActivity paramNetActiveVryQuesActivity) {}
  
  public void onClick(View paramView)
  {
    x.a(this.a);
    NetActiveVryQuesActivity.access$900(this.a)[0] = ((EditText)this.a.findViewById(2131559089)).getText().toString();
    NetActiveVryQuesActivity.access$900(this.a)[1] = ((EditText)this.a.findViewById(2131559091)).getText().toString();
    NetActiveVryQuesActivity.access$900(this.a)[2] = ((EditText)this.a.findViewById(2131559093)).getText().toString();
    h.c(NetActiveVryQuesActivity.access$900(this.a)[0] + "|" + NetActiveVryQuesActivity.access$900(this.a)[1] + "|" + NetActiveVryQuesActivity.access$900(this.a)[2]);
    int i = 0;
    while (i < 3)
    {
      NetActiveVryQuesActivity.access$900(this.a)[i] = NetActiveVryQuesActivity.access$900(this.a)[i].trim();
      if (1 != NetActiveVryQuesActivity.access$1100(this.a, NetActiveVryQuesActivity.access$900(this.a)[i], NetActiveVryQuesActivity.access$1000(this.a)[i]))
      {
        switch (NetActiveVryQuesActivity.access$1000(this.a)[i])
        {
        default: 
          paramView = this.a.getResources().getString(2131230790);
        }
        for (;;)
        {
          this.a.showToast(paramView);
          return;
          paramView = this.a.getResources().getString(2131230792);
          continue;
          paramView = this.a.getResources().getString(2131230793);
          continue;
          paramView = this.a.getResources().getString(2131230794);
        }
      }
      i += 1;
    }
    NetActiveVryQuesActivity.access$1200(this.a).a(NetActiveVryQuesActivity.access$500(this.a).mRealUin, NetActiveVryQuesActivity.access$200(this.a).k(), NetActiveVryQuesActivity.access$900(this.a), NetActiveVryQuesActivity.access$300(this.a));
    this.a.showProDialog(this.a, 2131230843, 2131231298, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rh
 * JD-Core Version:    0.7.0.1
 */