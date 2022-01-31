package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.core.bean.LoginProtectResult;
import com.tencent.token.core.bean.MbInfoResult;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.fn;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import com.tencent.token.x;
import java.util.ArrayList;

final class aec
  extends bo
{
  aec(UtilsLoginProtectActivity paramUtilsLoginProtectActivity)
  {
    super(paramUtilsLoginProtectActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject = null;
    if (this.a.isFinishing()) {}
    do
    {
      return;
      e.c("account page: what=" + paramMessage.what + ", arg1=" + paramMessage.arg1);
      switch (paramMessage.what)
      {
      default: 
        return;
      case 3010: 
        if (paramMessage.arg1 != 0) {
          break label1050;
        }
        paramMessage = fn.a().c();
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
        UtilsLoginProtectActivity.access$402(this.a, true);
        if (j == 1)
        {
          if (ax.a().e() == null) {
            break;
          }
          paramMessage = x.a(RqdApplication.i()).a(ax.a().e().mRealUin);
          if (paramMessage != null)
          {
            this.a.mA2 = s.a(paramMessage);
            af.a().d(0L, this.a.mA2, this.a.mHandler);
            return;
            UtilsLoginProtectActivity.access$002(this.a, false);
            if (paramMessage.arg1 == 0)
            {
              UtilsLoginProtectActivity.mNeedRefreshLoginProtect = false;
              this.a.mLoginProtectResult = ((LoginProtectResult)paramMessage.obj);
              this.a.hideTip();
              UtilsLoginProtectActivity.access$100(this.a).notifyDataSetChanged();
              return;
            }
            paramMessage = (d)paramMessage.obj;
            d.a(this.a.getResources(), paramMessage);
            e.c("game protect load failed:" + paramMessage.a + "-" + paramMessage.b);
            if (paramMessage.a == 185)
            {
              if (ax.a().e() == null) {
                break;
              }
              x.a(RqdApplication.i()).a(this.a, "" + ax.a().e().mRealUin, this.a.mHandler, true);
              return;
            }
            if ((111 == paramMessage.a) || (110 == paramMessage.a) || (103 == paramMessage.a))
            {
              this.a.showTip(paramMessage.a, UtilsLoginProtectActivity.access$200(this.a), UtilsLoginProtectActivity.access$300(this.a), true);
              return;
            }
            this.a.showTip(paramMessage.a, paramMessage.c, null, false);
            return;
            if (paramMessage.arg1 == 0)
            {
              localObject = new d();
              int[] arrayOfInt = (int[])paramMessage.obj;
              paramMessage = (Message)localObject;
              localObject = arrayOfInt;
            }
            for (;;)
            {
              UtilsLoginProtectActivity.access$100(this.a).a(paramMessage, (int[])localObject);
              return;
              paramMessage = (d)paramMessage.obj;
            }
            localObject = (byte[])paramMessage.obj;
            if ((paramMessage.arg1 == 0) && (localObject != null) && (localObject.length > 0))
            {
              this.a.mA2 = s.a((byte[])localObject);
              e.b("login protect a2=" + this.a.mA2 + ", length=" + this.a.mA2.length());
              af.a().d(0L, this.a.mA2, this.a.mHandler);
              return;
            }
            if (paramMessage.arg1 == -1000)
            {
              this.a.showTip(-1000, this.a.getResources().getString(2131361943), null, false);
              UtilsLoginProtectActivity.access$002(this.a, false);
              return;
            }
            if (paramMessage.arg1 == 8192)
            {
              this.a.showTip(8192, this.a.getResources().getString(2131362089), null, false);
              UtilsLoginProtectActivity.access$002(this.a, false);
              return;
            }
            if ((paramMessage.arg1 == 1) || (paramMessage.arg1 == 15) || (paramMessage.arg1 == 16) || (paramMessage.arg1 == 2))
            {
              this.a.showUserDialog(2131362364, this.a.getResources().getString(2131362365), 2131361800, new aed(this));
              UtilsLoginProtectActivity.access$002(this.a, false);
              return;
            }
            if ((paramMessage.getData() != null) && (paramMessage.getData().getString("loginerror") != null)) {
              this.a.showTip(paramMessage.arg1, this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("loginerror"), null, false);
            }
            for (;;)
            {
              UtilsLoginProtectActivity.access$002(this.a, false);
              return;
              this.a.showTip(paramMessage.arg1, this.a.getResources().getString(2131362091), null, false);
            }
          }
          x.a(RqdApplication.i()).a(this.a, "" + ax.a().e().mRealUin, this.a.mHandler, true);
          return;
        }
        UtilsLoginProtectActivity.access$002(this.a, false);
        this.a.setContentView(2130903238);
        this.a.findViewById(2131297233).setOnClickListener(new aee(this, paramMessage, i));
        return;
      }
      i += 1;
    }
    label1050:
    UtilsLoginProtectActivity.access$002(this.a, false);
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    e.c("game protect load failed:" + paramMessage.a + "-" + paramMessage.b);
    this.a.showTip(paramMessage.a, paramMessage.c, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aec
 * JD-Core Version:    0.7.0.1
 */