package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.g;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import com.tencent.token.x;

final class aem
  extends bo
{
  aem(UtilsMailProtectActivity paramUtilsMailProtectActivity)
  {
    super(paramUtilsMailProtectActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.isFinishing())) {}
    Object localObject;
    do
    {
      return;
      localObject = UtilsMailProtectActivity.access$100(this.a);
      int i = paramMessage.arg1;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 3054: 
        if (paramMessage.arg1 == 0)
        {
          UtilsMailProtectActivity.access$600(this.a).setVisibility(0);
          UtilsMailProtectActivity.access$700(this.a).setVisibility(8);
          UtilsMailProtectActivity.access$800(this.a);
          return;
        }
      case 4097: 
      case 4098: 
        localObject = (byte[])paramMessage.obj;
        if ((i == 0) && (localObject != null) && (localObject.length > 0))
        {
          UtilsMailProtectActivity.access$402(this.a, s.a((byte[])localObject));
          UtilsMailProtectActivity.access$500(this.a);
          return;
        }
        if (i == -1000)
        {
          this.a.dismissDialog();
          this.a.showToast(2131361943);
          return;
        }
        if (i == 8192)
        {
          this.a.dismissDialog();
          this.a.showToast(2131362089);
          return;
        }
        if ((i == 1) || (i == 15) || (i == 16) || (i == 2))
        {
          this.a.dismissDialog();
          this.a.showUserDialog(2131362364, this.a.getResources().getString(2131362365), 2131361800, new aen(this));
          return;
        }
        this.a.dismissDialog();
        if ((paramMessage.getData() != null) && (paramMessage.getData().getString("loginerror") != null))
        {
          this.a.showToast(this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("loginerror"));
          return;
        }
        this.a.showToast(2131362091);
        return;
      case 4104: 
        this.a.dismissDialog();
        if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
        {
          this.a.showToast(this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("exception"));
          return;
        }
        this.a.showToast(2131362091);
        return;
        if ((111 == paramMessage.arg1) || (110 == paramMessage.arg1) || (103 == paramMessage.arg1))
        {
          UtilsMailProtectActivity.access$1100(this.a, paramMessage.arg1, UtilsMailProtectActivity.access$900(this.a), UtilsMailProtectActivity.access$1000(this.a), true);
          return;
        }
        if (185 != paramMessage.arg1) {
          break label583;
        }
      }
    } while (ax.a().e() == null);
    x.a(RqdApplication.i()).a(this.a, "" + ax.a().e().mRealUin, UtilsMailProtectActivity.access$000(this.a), true);
    return;
    label583:
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    e.c("mailprotect load failed:" + paramMessage.a + "-" + paramMessage.b);
    UtilsMailProtectActivity.access$1100(this.a, paramMessage.a, paramMessage.c, null, false);
    return;
    ((g)localObject).e = false;
    boolean bool;
    if (paramMessage.arg1 == 0) {
      if (!((g)localObject).c)
      {
        bool = true;
        ((g)localObject).c = bool;
      }
    }
    for (;;)
    {
      UtilsMailProtectActivity.access$800(this.a);
      return;
      bool = false;
      break;
      localObject = (d)paramMessage.obj;
      d.a(this.a.getResources(), (d)localObject);
      if ((111 == paramMessage.arg1) || (110 == paramMessage.arg1) || (103 == paramMessage.arg1))
      {
        UtilsMailProtectActivity.access$1100(this.a, ((d)localObject).a, UtilsMailProtectActivity.access$900(this.a), UtilsMailProtectActivity.access$1000(this.a), true);
      }
      else if (158 == paramMessage.arg1)
      {
        this.a.showUserDialog(2131361849, ((d)localObject).c, this.a.getResources().getString(2131361850), this.a.getResources().getString(2131361851), new aeo(this), new aep(this));
      }
      else
      {
        d.a(this.a.getResources(), (d)localObject);
        UtilsMailProtectActivity.access$1300(this.a, ((d)localObject).c);
      }
    }
    if (paramMessage.arg1 == 0)
    {
      UtilsMailProtectActivity.access$500(this.a);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    UtilsMailProtectActivity.access$1300(this.a, paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aem
 * JD-Core Version:    0.7.0.1
 */