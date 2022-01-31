package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.utils.w;

class fa
  extends fd
{
  fa(FaceChangePwdIndexActivity paramFaceChangePwdIndexActivity)
  {
    super(paramFaceChangePwdIndexActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    int j = paramMessage.arg1;
    this.a.dismissDialog();
    h.a("handleMessage" + i + paramMessage.arg1);
    h.a("on" + FaceChangePwdIndexActivity.access$800(this.a));
    switch (i)
    {
    default: 
    case 4002: 
      do
      {
        return;
        if (paramMessage.arg1 == 0)
        {
          h.a("mIsCheckedRET_CODE_OK" + FaceChangePwdIndexActivity.access$100(this.a).isChecked());
          if (!FaceChangePwdIndexActivity.access$800(this.a))
          {
            FaceChangePwdIndexActivity.access$200(this.a).setVisibility(4);
            FaceChangePwdIndexActivity.access$300(this.a).setVisibility(4);
            FaceChangePwdIndexActivity.access$400(this.a).setVisibility(4);
            paramMessage = FaceChangePwdIndexActivity.access$100(this.a);
            if (FaceChangePwdIndexActivity.access$800(this.a)) {
              break label301;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            paramMessage.a(bool, false);
            if (FaceChangePwdIndexActivity.access$800(this.a)) {
              break;
            }
            this.a.showOrangeToast(this.a.getResources().getString(2131231004), 0);
            return;
            FaceChangePwdIndexActivity.access$200(this.a).setVisibility(0);
            FaceChangePwdIndexActivity.access$300(this.a).setVisibility(0);
            FaceChangePwdIndexActivity.access$400(this.a).setVisibility(0);
            break label206;
          }
        }
        h.a("mIsChecked" + FaceChangePwdIndexActivity.access$100(this.a).isChecked());
        if (FaceChangePwdIndexActivity.access$800(this.a))
        {
          FaceChangePwdIndexActivity.access$200(this.a).setVisibility(4);
          FaceChangePwdIndexActivity.access$300(this.a).setVisibility(4);
        }
        for (;;)
        {
          FaceChangePwdIndexActivity.access$100(this.a).a(FaceChangePwdIndexActivity.access$800(this.a), false);
          if (j != 185) {
            break label481;
          }
          if (do.a().e() == null) {
            break;
          }
          paramMessage = do.a().e();
          cp.a(RqdApplication.l()).a("" + paramMessage.mRealUin, FaceChangePwdIndexActivity.access$900(this.a), 523005419L, 64);
          return;
          FaceChangePwdIndexActivity.access$200(this.a).setVisibility(0);
          FaceChangePwdIndexActivity.access$300(this.a).setVisibility(0);
        }
      } while (j == 270);
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
      return;
    case 4097: 
    case 4098: 
      byte[] arrayOfByte = (byte[])paramMessage.obj;
      if ((paramMessage.arg1 == 0) && (arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        FaceChangePwdIndexActivity.access$1002(this.a, w.a(arrayOfByte));
        h.b("login protect a2=" + FaceChangePwdIndexActivity.access$1000(this.a) + ", length=" + FaceChangePwdIndexActivity.access$1000(this.a).length());
        FaceChangePwdIndexActivity.access$600(this.a, FaceChangePwdIndexActivity.access$800(this.a));
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
        this.a.showUserDialog(2131231654, this.a.getResources().getString(2131231653), 2131230897, new fb(this));
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
      label206:
      label481:
      this.a.dismissDialog();
      label301:
      if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
      {
        this.a.showUserDialog(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
        return;
      }
      this.a.showUserDialog(this.a.getResources().getString(2131231411));
      return;
    }
    FaceChangePwdIndexActivity.access$1200(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.fa
 * JD-Core Version:    0.7.0.1
 */