package com.tencent.token.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.t;

final class qc
  extends qd
{
  qc(pv parampv)
  {
    super(parampv);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramMessage.arg1 != 0) {
              break;
            }
            paramMessage = ax.a().e();
          } while (paramMessage == null);
          af.a().c(paramMessage.mUin, paramMessage.mRealUin, this.a.c);
          return;
        } while (pv.a(this.a) == null);
        ((BaseActivity)pv.a(this.a)).dismissDialog();
        localObject = (d)paramMessage.obj;
        d.a(pv.a(this.a).getResources(), (d)localObject);
        e.c("modqqpwd: " + ((d)localObject).a + ", " + ((d)localObject).c + ", arg=" + paramMessage.arg1);
      } while (pv.a(this.a) == null);
      if ((((d)localObject).c == null) || (((d)localObject).c.length() == 0)) {
        d.a(pv.a(this.a).getResources(), (d)localObject);
      }
      if ((pv.a(this.a) instanceof BaseActivity)) {
        ((BaseActivity)pv.a(this.a)).showUserDialog(2131361808, ((d)localObject).c, 2131361800, null);
      }
      this.a.b();
      return;
      if (paramMessage.arg1 != 0) {
        break;
      }
      paramMessage = (Integer)paramMessage.obj;
      if (this.a.a != null)
      {
        localObject = this.a.a;
        if (paramMessage.intValue() == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((qe)localObject).a(bool);
          this.a.a = null;
          if ((pv.a(this.a) instanceof BaseActivity)) {
            ((BaseActivity)pv.a(this.a)).dismissDialog();
          }
          this.a.b();
          return;
        }
      }
    } while (pv.a(this.a) == null);
    for (;;)
    {
      try
      {
        if (paramMessage.intValue() != 1) {
          continue;
        }
        if (t.l() != 0) {
          continue;
        }
        paramMessage = new Intent(pv.a(this.a).getApplicationContext(), FaceRecognitionCameraActivityOld.class);
        paramMessage.putExtra("istry", 4);
        paramMessage.putExtra("flag", 2);
        paramMessage.putExtra("scene", 8);
        pv.a(this.a).startActivity(paramMessage);
        if ((pv.a(this.a) instanceof BaseActivity)) {
          ((BaseActivity)pv.a(this.a)).dismissDialog();
        }
      }
      catch (Exception paramMessage)
      {
        continue;
      }
      this.a.b();
      return;
      paramMessage = new Intent(pv.a(this.a).getApplicationContext(), FaceRecognitionCameraActivity.class);
      continue;
      paramMessage = new Intent(pv.a(this.a).getApplicationContext(), ModifyQQPwdActivity.class);
      pv.a(this.a).startActivity(paramMessage);
      continue;
      if (pv.a(this.a) == null) {
        break;
      }
      ((BaseActivity)pv.a(this.a)).dismissDialog();
      if (pv.a(this.a) == null) {
        break;
      }
      localObject = (d)paramMessage.obj;
      d.a(pv.a(this.a).getResources(), (d)localObject);
      e.c("modqqpwd: " + ((d)localObject).a + ", " + ((d)localObject).c + ", arg=" + paramMessage.arg1);
      if ((((d)localObject).c == null) || (((d)localObject).c.length() == 0)) {
        d.a(pv.a(this.a).getResources(), (d)localObject);
      }
      if ((pv.a(this.a) instanceof BaseActivity)) {
        ((BaseActivity)pv.a(this.a)).showUserDialog(2131361808, ((d)localObject).c, 2131361800, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qc
 * JD-Core Version:    0.7.0.1
 */