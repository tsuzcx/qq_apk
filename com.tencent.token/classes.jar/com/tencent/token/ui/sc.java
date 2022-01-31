package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.af;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.global.e;
import com.tencent.token.utils.t;

final class sc
  implements View.OnClickListener
{
  sc(NetActiveVryQuesActivity paramNetActiveVryQuesActivity) {}
  
  public final void onClick(View paramView)
  {
    t.a(this.a);
    NetActiveVryQuesActivity.access$1000(this.a)[0] = ((EditText)this.a.findViewById(2131296895)).getText().toString();
    NetActiveVryQuesActivity.access$1000(this.a)[1] = ((EditText)this.a.findViewById(2131296897)).getText().toString();
    NetActiveVryQuesActivity.access$1000(this.a)[2] = ((EditText)this.a.findViewById(2131296899)).getText().toString();
    e.c(NetActiveVryQuesActivity.access$1000(this.a)[0] + "|" + NetActiveVryQuesActivity.access$1000(this.a)[1] + "|" + NetActiveVryQuesActivity.access$1000(this.a)[2]);
    int i = 0;
    while (i < 3)
    {
      NetActiveVryQuesActivity.access$1000(this.a)[i] = NetActiveVryQuesActivity.access$1000(this.a)[i].trim();
      if (1 != NetActiveVryQuesActivity.access$1200(this.a, NetActiveVryQuesActivity.access$1000(this.a)[i], NetActiveVryQuesActivity.access$1100(this.a)[i]))
      {
        switch (NetActiveVryQuesActivity.access$1100(this.a)[i])
        {
        default: 
          paramView = this.a.getResources().getString(2131361833);
        }
        for (;;)
        {
          this.a.showToast(paramView);
          return;
          paramView = this.a.getResources().getString(2131361835);
          continue;
          paramView = this.a.getResources().getString(2131361836);
          continue;
          paramView = this.a.getResources().getString(2131361837);
        }
      }
      i += 1;
    }
    NetActiveVryQuesActivity.access$1500(this.a).a(NetActiveVryQuesActivity.access$1300(this.a).mRealUin, NetActiveVryQuesActivity.access$000(this.a).mQuesInfo, NetActiveVryQuesActivity.access$1000(this.a), NetActiveVryQuesActivity.access$1400(this.a));
    this.a.showProDialog(this.a, 2131361808, 2131361817, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.sc
 * JD-Core Version:    0.7.0.1
 */