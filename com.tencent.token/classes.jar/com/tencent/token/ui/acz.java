package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.tencent.token.core.bean.MbInfoResult;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.do;
import com.tencent.token.eq;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.f;
import com.tencent.token.utils.w;
import java.util.ArrayList;

class acz
  extends cb
{
  acz(UtilsMailProtectActivity paramUtilsMailProtectActivity)
  {
    super(paramUtilsMailProtectActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = false;
    if ((this.a == null) || (this.a.isFinishing())) {}
    Object localObject;
    do
    {
      return;
      localObject = UtilsMailProtectActivity.access$100(this.a);
      i = paramMessage.arg1;
      com.tencent.token.global.h.a("msg.what=" + paramMessage.what + ",ret=" + paramMessage.arg1);
      switch (paramMessage.what)
      {
      default: 
        return;
      case 3010: 
        if (paramMessage.arg1 != 0) {
          break label993;
        }
        paramMessage = eq.a().c();
      }
    } while ((paramMessage == null) || (paramMessage.mMbInfoItems == null));
    int i = 0;
    while (i < paramMessage.mMbInfoItems.size())
    {
      localObject = (MbInfoResult.MbInfoItem)paramMessage.mMbInfoItems.get(i);
      if (((MbInfoResult.MbInfoItem)localObject).mId == 51)
      {
        int j = ((MbInfoResult.MbInfoItem)localObject).mValue;
        paramMessage = ((MbInfoResult.MbInfoItem)localObject).mName;
        UtilsMailProtectActivity.access$1302(this.a, true);
        if (j == 1)
        {
          UtilsMailProtectActivity.access$000(this.a);
          return;
          localObject = (byte[])paramMessage.obj;
          if ((i == 0) && (localObject != null) && (localObject.length > 0))
          {
            UtilsMailProtectActivity.access$402(this.a, w.a((byte[])localObject));
            UtilsMailProtectActivity.access$000(this.a);
            return;
          }
          if (i == -1000)
          {
            this.a.dismissDialog();
            this.a.showUserDialog(this.a.getResources().getString(2131230960));
            UtilsMailProtectActivity.access$600(this.a, 10001);
            return;
          }
          if (i == 8192)
          {
            this.a.dismissDialog();
            this.a.showUserDialog(this.a.getResources().getString(2131231407));
            UtilsMailProtectActivity.access$600(this.a, 10002);
            return;
          }
          this.a.dismissDialog();
          this.a.showUserDialog(2131231654, this.a.getResources().getString(2131231653), 2131230897, new ada(this));
          UtilsMailProtectActivity.access$600(this.a, paramMessage.arg1);
          return;
          this.a.dismissDialog();
          if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
          {
            this.a.showUserDialog(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
            return;
          }
          this.a.showUserDialog(this.a.getResources().getString(2131231411));
          return;
          UtilsMailProtectActivity.access$800(this.a);
          return;
          if (paramMessage.arg1 == 0)
          {
            UtilsMailProtectActivity.access$900(this.a).setVisibility(0);
            UtilsMailProtectActivity.access$1000(this.a).setVisibility(8);
            UtilsMailProtectActivity.access$1100(this.a);
            return;
          }
          if (185 == paramMessage.arg1)
          {
            if (do.a().e() == null) {
              break;
            }
            paramMessage = do.a().e();
            cp.a(RqdApplication.l()).a("" + paramMessage.mRealUin, UtilsMailProtectActivity.access$500(this.a), 523005419L, 64);
            return;
          }
          paramMessage = (f)paramMessage.obj;
          f.a(this.a.getResources(), paramMessage);
          com.tencent.token.global.h.c("mailprotect load failed:" + paramMessage.a + "-" + paramMessage.b);
          this.a.showUserDialog(paramMessage.c);
          UtilsMailProtectActivity.access$600(this.a, paramMessage.a);
          return;
          ((com.tencent.token.core.bean.h)localObject).e = false;
          if (paramMessage.arg1 == 0)
          {
            if (!((com.tencent.token.core.bean.h)localObject).c) {
              bool = true;
            }
            ((com.tencent.token.core.bean.h)localObject).c = bool;
          }
          for (;;)
          {
            UtilsMailProtectActivity.access$1100(this.a);
            return;
            localObject = (f)paramMessage.obj;
            f.a(this.a.getResources(), (f)localObject);
            if (158 == paramMessage.arg1)
            {
              this.a.showUserDialog(2131230869, ((f)localObject).c, this.a.getResources().getString(2131230867), this.a.getResources().getString(2131230868), new adb(this), new adc(this));
            }
            else
            {
              f.a(this.a.getResources(), (f)localObject);
              this.a.showUserDialog(((f)localObject).c);
            }
          }
          if (paramMessage.arg1 == 0)
          {
            UtilsMailProtectActivity.access$000(this.a);
            return;
          }
          paramMessage = (f)paramMessage.obj;
          f.a(this.a.getResources(), paramMessage);
          this.a.showUserDialog(paramMessage.c);
          return;
        }
        this.a.setContentView(2130968801);
        this.a.mRightOptionImage = null;
        this.a.setRightTitleImage(2130838011, new add(this));
        this.a.findViewById(2131559392).setOnClickListener(new ade(this, paramMessage, i));
        return;
      }
      i += 1;
    }
    label993:
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    com.tencent.token.global.h.c("game protect load failed:" + paramMessage.a + "-" + paramMessage.b);
    this.a.showUserDialog(paramMessage.c);
    UtilsMailProtectActivity.access$600(this.a, paramMessage.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.acz
 * JD-Core Version:    0.7.0.1
 */