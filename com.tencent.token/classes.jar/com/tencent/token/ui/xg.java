package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.token.core.bean.RealNameRegResult;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.er;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;

final class xg
  extends bo
{
  xg(RealNameStep1InputNameIdActivity paramRealNameStep1InputNameIdActivity)
  {
    super(paramRealNameStep1InputNameIdActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    e.c("upload image what=" + paramMessage.what + ", arg1=" + paramMessage.arg1 + ", optype=" + RealNameStep1InputNameIdActivity.access$000(this.a));
    switch (paramMessage.what)
    {
    case -100: 
    default: 
      return;
    case 3083: 
      if (paramMessage.arg1 == 0)
      {
        if (paramMessage.arg2 == 1)
        {
          RealNameStep1InputNameIdActivity.access$102(this.a, true);
          return;
        }
        RealNameStep1InputNameIdActivity.access$102(this.a, false);
        return;
      }
      RealNameStep1InputNameIdActivity.access$102(this.a, false);
      return;
    case 3064: 
      if (paramMessage.arg1 == 0)
      {
        this.a.dismissDialog();
        RealNameStep1InputNameIdActivity.access$202(this.a, (RealNameStatusResult)paramMessage.obj);
        RealNameStep1InputNameIdActivity.access$300(this.a);
        return;
      }
      this.a.finish();
      return;
    case 3080: 
      RealNameStep1InputNameIdActivity.access$400(this.a).setVisibility(4);
      d locald = (d)paramMessage.obj;
      if (paramMessage.arg1 != 0) {
        if ((locald.a == 250) || (locald.a == 251) || (locald.a == 252))
        {
          RealNameStep1InputNameIdActivity.access$502(this.a, true);
          RealNameStep1InputNameIdActivity.access$602(this.a, false);
          RealNameStep1InputNameIdActivity.access$700(this.a).setVisibility(0);
          RealNameStep1InputNameIdActivity.access$700(this.a).setText(locald.b);
          RealNameStep1InputNameIdActivity.access$700(this.a).setTextColor(-65536);
          if ((RealNameStep1InputNameIdActivity.access$800(this.a) != null) && (RealNameStep1InputNameIdActivity.access$800(this.a).getVisibility() == 0)) {
            RealNameStep1InputNameIdActivity.access$900(this.a).scrollTo(0, RealNameStep1InputNameIdActivity.access$700(this.a).getMeasuredHeight() + s.a(this.a, 20.0F) + RealNameStep1InputNameIdActivity.access$800(this.a).getMeasuredHeight());
          }
        }
      }
      for (;;)
      {
        RealNameStep1InputNameIdActivity.access$1000(this.a);
        return;
        RealNameStep1InputNameIdActivity.access$900(this.a).scrollTo(0, RealNameStep1InputNameIdActivity.access$700(this.a).getMeasuredHeight() + s.a(this.a, 20.0F));
        continue;
        RealNameStep1InputNameIdActivity.access$502(this.a, false);
        this.a.showUserDialog(locald.c);
        continue;
        RealNameStep1InputNameIdActivity.access$502(this.a, true);
        RealNameStep1InputNameIdActivity.access$700(this.a).setVisibility(0);
        RealNameStep1InputNameIdActivity.access$700(this.a).setText(this.a.getResources().getString(2131362554));
        RealNameStep1InputNameIdActivity.access$700(this.a).setTextColor(-7829368);
        RealNameStep1InputNameIdActivity.access$602(this.a, true);
      }
    case 3078: 
      if (paramMessage.arg1 == 0)
      {
        paramMessage = (RealNameRegResult)paramMessage.obj;
        RealNameStep1InputNameIdActivity.access$1100(this.a, paramMessage);
        return;
      }
      this.a.dismissDialog();
      paramMessage = (d)paramMessage.obj;
      d.a(this.a.getResources(), paramMessage);
      RealNameStep1InputNameIdActivity.access$1200(this.a, paramMessage.c, true, false);
      return;
    }
    this.a.dismissDialog();
    if (RealNameStep1InputNameIdActivity.access$1300(this.a) != null)
    {
      RealNameStep1InputNameIdActivity.access$1300(this.a).b();
      RealNameStep1InputNameIdActivity.access$1400(this.a).setEnabled(true);
      this.a.animLayout.setVisibility(4);
    }
    if (paramMessage.arg1 == 0)
    {
      paramMessage = (RealNameRegResult)paramMessage.obj;
      RealNameStep1InputNameIdActivity.access$1100(this.a, paramMessage);
      return;
    }
    this.a.dismissDialog();
    paramMessage = (d)paramMessage.obj;
    switch (paramMessage.a)
    {
    default: 
      d.a(this.a.getResources(), paramMessage);
      RealNameStep1InputNameIdActivity.access$1200(this.a, paramMessage.c, false, false);
      return;
    case 180: 
    case 181: 
      this.a.showUserDialogComfig(2130903167, er.h, er.i, 2130837618, new xh(this), new xi(this));
      return;
    case 182: 
      this.a.showUserDialogComfig(2130903167, er.h, er.i, 2130837696, new xj(this), new xk(this));
      return;
    case 103: 
      d.a(this.a.getResources(), paramMessage);
      this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, new xl(this), new xm(this));
      return;
    }
    RealNameStep1InputNameIdActivity.access$1200(this.a, paramMessage.c, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xg
 * JD-Core Version:    0.7.0.1
 */