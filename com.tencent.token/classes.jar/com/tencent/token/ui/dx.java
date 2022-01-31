package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.x;

final class dx
  extends dz
{
  dx(FaceChangePwdIndexActivity paramFaceChangePwdIndexActivity)
  {
    super(paramFaceChangePwdIndexActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    int i = paramMessage.what;
    int j = paramMessage.arg1;
    this.a.dismissDialog();
    e.a("handleMessage" + i + paramMessage.arg1);
    e.a("on" + FaceChangePwdIndexActivity.access$800(this.a));
    switch (i)
    {
    }
    label178:
    label447:
    do
    {
      return;
      if (paramMessage.arg1 == 0)
      {
        e.a("mIsCheckedRET_CODE_OK" + FaceChangePwdIndexActivity.access$100(this.a).isChecked());
        if (!FaceChangePwdIndexActivity.access$800(this.a))
        {
          FaceChangePwdIndexActivity.access$200(this.a).setVisibility(4);
          FaceChangePwdIndexActivity.access$300(this.a).setVisibility(4);
          FaceChangePwdIndexActivity.access$400(this.a).setVisibility(4);
          paramMessage = FaceChangePwdIndexActivity.access$100(this.a);
          if (FaceChangePwdIndexActivity.access$800(this.a)) {
            break label270;
          }
        }
        for (;;)
        {
          paramMessage.a(bool, false);
          if (FaceChangePwdIndexActivity.access$800(this.a)) {
            break;
          }
          this.a.showOrangeToast(this.a.getResources().getString(2131362821), 0);
          return;
          FaceChangePwdIndexActivity.access$200(this.a).setVisibility(0);
          FaceChangePwdIndexActivity.access$300(this.a).setVisibility(0);
          FaceChangePwdIndexActivity.access$400(this.a).setVisibility(0);
          break label178;
          bool = false;
        }
      }
      e.a("mIsChecked" + FaceChangePwdIndexActivity.access$100(this.a).isChecked());
      if (FaceChangePwdIndexActivity.access$800(this.a))
      {
        FaceChangePwdIndexActivity.access$200(this.a).setVisibility(4);
        FaceChangePwdIndexActivity.access$300(this.a).setVisibility(4);
      }
      for (;;)
      {
        FaceChangePwdIndexActivity.access$100(this.a).a(FaceChangePwdIndexActivity.access$800(this.a), false);
        if (j != 185) {
          break label447;
        }
        if (ax.a().e() == null) {
          break;
        }
        x.a(RqdApplication.i()).a(this.a, "" + ax.a().e().mRealUin, this.a.fHandler, true);
        return;
        FaceChangePwdIndexActivity.access$200(this.a).setVisibility(0);
        FaceChangePwdIndexActivity.access$300(this.a).setVisibility(0);
      }
    } while (j == 270);
    label270:
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dx
 * JD-Core Version:    0.7.0.1
 */