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
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.utils.w;
import java.util.ArrayList;

class eq
  extends et
{
  eq(FaceChangeMobileActivity paramFaceChangeMobileActivity)
  {
    super(paramFaceChangeMobileActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    int i = paramMessage.what;
    int j = paramMessage.arg1;
    this.a.dismissDialog();
    h.a("handleMessage" + i + paramMessage.arg1);
    h.a("on" + FaceChangeMobileActivity.access$900(this.a));
    Object localObject;
    switch (i)
    {
    default: 
    case 3010: 
    case 4002: 
      do
      {
        do
        {
          for (;;)
          {
            return;
            this.a.dismissDialog();
            if (paramMessage.arg1 != 0) {
              break;
            }
            paramMessage = com.tencent.token.eq.a().c();
            if ((paramMessage != null) && (paramMessage.mMbInfoItems != null))
            {
              i = 0;
              while (i < paramMessage.mMbInfoItems.size())
              {
                localObject = (MbInfoResult.MbInfoItem)paramMessage.mMbInfoItems.get(i);
                FaceChangeMobileActivity.access$1000(this.a, (MbInfoResult.MbInfoItem)localObject, i);
                i += 1;
              }
            }
          }
          paramMessage = (f)paramMessage.obj;
        } while ((paramMessage.c != null) && (paramMessage.c.length() != 0));
        f.a(this.a.getResources(), paramMessage);
        this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
        return;
        if (paramMessage.arg1 == 0)
        {
          h.a("mIsCheckedRET_CODE_OK" + FaceChangeMobileActivity.access$200(this.a).isChecked());
          if (!FaceChangeMobileActivity.access$900(this.a))
          {
            FaceChangeMobileActivity.access$300(this.a).setVisibility(4);
            FaceChangeMobileActivity.access$400(this.a).setVisibility(4);
            FaceChangeMobileActivity.access$500(this.a).setVisibility(4);
            paramMessage = FaceChangeMobileActivity.access$200(this.a);
            if (FaceChangeMobileActivity.access$900(this.a)) {
              break label438;
            }
          }
          for (;;)
          {
            paramMessage.a(bool, false);
            if (FaceChangeMobileActivity.access$900(this.a)) {
              break;
            }
            this.a.showOrangeToast(this.a.getResources().getString(2131231005), 0);
            return;
            FaceChangeMobileActivity.access$300(this.a).setVisibility(0);
            FaceChangeMobileActivity.access$400(this.a).setVisibility(0);
            FaceChangeMobileActivity.access$500(this.a).setVisibility(0);
            break label346;
            bool = false;
          }
        }
        h.a("mIsChecked" + FaceChangeMobileActivity.access$200(this.a).isChecked());
        if (FaceChangeMobileActivity.access$900(this.a))
        {
          FaceChangeMobileActivity.access$300(this.a).setVisibility(4);
          FaceChangeMobileActivity.access$400(this.a).setVisibility(4);
        }
        for (;;)
        {
          FaceChangeMobileActivity.access$200(this.a).a(FaceChangeMobileActivity.access$900(this.a), false);
          if (j != 185) {
            break label618;
          }
          if (do.a().e() == null) {
            break;
          }
          paramMessage = do.a().e();
          cp.a(RqdApplication.l()).a("" + paramMessage.mRealUin, FaceChangeMobileActivity.access$000(this.a), 523005419L, 64);
          return;
          FaceChangeMobileActivity.access$300(this.a).setVisibility(0);
          FaceChangeMobileActivity.access$400(this.a).setVisibility(0);
        }
      } while (j == 270);
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
      return;
    case 4097: 
    case 4098: 
      localObject = (byte[])paramMessage.obj;
      if ((paramMessage.arg1 == 0) && (localObject != null) && (localObject.length > 0))
      {
        FaceChangeMobileActivity.access$1102(this.a, w.a((byte[])localObject));
        h.b("login protect a2=" + FaceChangeMobileActivity.access$1100(this.a) + ", length=" + FaceChangeMobileActivity.access$1100(this.a).length());
        FaceChangeMobileActivity.access$700(this.a, FaceChangeMobileActivity.access$900(this.a));
        return;
      }
      if (paramMessage.arg1 == -1000)
      {
        this.a.dismissDialog();
        this.a.showUserDialog(this.a.getResources().getString(2131230960));
        return;
      }
      if (paramMessage.arg1 == 8192)
      {
        this.a.dismissDialog();
        this.a.showUserDialog(this.a.getResources().getString(2131231407));
        return;
      }
      if ((paramMessage.arg1 == 1) || (paramMessage.arg1 == 15) || (paramMessage.arg1 == 16) || (paramMessage.arg1 == 2))
      {
        this.a.dismissDialog();
        this.a.showUserDialog(2131231654, this.a.getResources().getString(2131231653), 2131230897, new er(this));
        return;
      }
      this.a.dismissDialog();
      if ((paramMessage.getData() != null) && (paramMessage.getData().getString("loginerror") != null))
      {
        this.a.showUserDialog(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("loginerror"));
        return;
      }
      this.a.showUserDialog(this.a.getResources().getString(2131231411));
      return;
    case 4104: 
      label346:
      label618:
      this.a.dismissDialog();
      label438:
      if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
      {
        this.a.showUserDialog(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
        return;
      }
      this.a.showUserDialog(this.a.getResources().getString(2131231411));
      return;
    }
    FaceChangeMobileActivity.access$1300(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.eq
 * JD-Core Version:    0.7.0.1
 */