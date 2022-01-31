package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.tencent.token.core.bean.LoginProtectResult;
import com.tencent.token.core.bean.MbInfoResult;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.eq;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.ArrayList;

class acq
  extends cb
{
  acq(UtilsLoginProtectActivity paramUtilsLoginProtectActivity)
  {
    super(paramUtilsLoginProtectActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    do
    {
      return;
      h.c("account page: what=" + paramMessage.what + ", arg1=" + paramMessage.arg1);
      switch (paramMessage.what)
      {
      default: 
        return;
      case 3010: 
        if (paramMessage.arg1 != 0) {
          break label878;
        }
        paramMessage = eq.a().c();
      }
    } while ((paramMessage == null) || (paramMessage.mMbInfoItems == null));
    int i = 0;
    while (i < paramMessage.mMbInfoItems.size())
    {
      Object localObject = (MbInfoResult.MbInfoItem)paramMessage.mMbInfoItems.get(i);
      if (((MbInfoResult.MbInfoItem)localObject).mId == 51)
      {
        int j = ((MbInfoResult.MbInfoItem)localObject).mValue;
        paramMessage = ((MbInfoResult.MbInfoItem)localObject).mName;
        UtilsLoginProtectActivity.access$302(this.a, true);
        if (j == 1)
        {
          this.a.queryLoginProtect();
          return;
          if (paramMessage.arg1 == 0)
          {
            UtilsLoginProtectActivity.mNeedRefreshLoginProtect = false;
            this.a.mLoginProtectResult = ((LoginProtectResult)paramMessage.obj);
            this.a.hideTip();
            UtilsLoginProtectActivity.access$000(this.a).notifyDataSetChanged();
            return;
          }
          paramMessage = (f)paramMessage.obj;
          f.a(this.a.getResources(), paramMessage);
          h.c("game protect load failed:" + paramMessage.a + "-" + paramMessage.b);
          if (paramMessage.a == 185)
          {
            if (do.a().e() == null) {
              break;
            }
            paramMessage = do.a().e();
            cp.a(RqdApplication.l()).a("" + paramMessage.mRealUin, this.a.mHandler, 523005419L, 64);
            return;
          }
          this.a.showTip(paramMessage.a);
          this.a.showUserDialog(paramMessage.c);
          return;
          localObject = null;
          if (paramMessage.arg1 == 0)
          {
            localObject = new f(0);
            int[] arrayOfInt = (int[])paramMessage.obj;
            paramMessage = (Message)localObject;
            localObject = arrayOfInt;
          }
          for (;;)
          {
            UtilsLoginProtectActivity.access$000(this.a).a(paramMessage, (int[])localObject);
            return;
            paramMessage = (f)paramMessage.obj;
          }
          localObject = (byte[])paramMessage.obj;
          if ((paramMessage.arg1 == 0) && (localObject != null) && (localObject.length > 0))
          {
            this.a.mA2 = w.a((byte[])localObject);
            h.b("login protect a2=" + this.a.mA2 + ", length=" + this.a.mA2.length());
            cw.a().c(0L, this.a.mA2, this.a.mHandler);
            return;
          }
          if (paramMessage.arg1 == -1000)
          {
            this.a.dismissDialog();
            this.a.showUserDialog(this.a.getResources().getString(2131230960));
            this.a.showTip(10001);
            return;
          }
          if (paramMessage.arg1 == 8192)
          {
            this.a.dismissDialog();
            this.a.showUserDialog(this.a.getResources().getString(2131231407));
            this.a.showTip(10002);
            return;
          }
          this.a.dismissDialog();
          this.a.showUserDialog(2131231654, this.a.getResources().getString(2131231653), 2131230897, new acr(this));
          this.a.showTip(paramMessage.arg1);
          return;
          this.a.dismissDialog();
          if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
          {
            this.a.showUserDialog(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
            return;
          }
          this.a.showUserDialog(this.a.getResources().getString(2131231411));
          return;
          UtilsLoginProtectActivity.access$200(this.a);
          return;
        }
        this.a.setContentView(2130968800);
        this.a.findViewById(2131559392).setOnClickListener(new acs(this, paramMessage, i));
        return;
      }
      i += 1;
    }
    label878:
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    h.c("game protect load failed:" + paramMessage.a + "-" + paramMessage.b);
    this.a.showTip(paramMessage.a);
    this.a.showUserDialog(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.acq
 * JD-Core Version:    0.7.0.1
 */