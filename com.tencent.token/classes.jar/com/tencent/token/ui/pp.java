package com.tencent.token.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class pp
  extends pq
{
  pp(pg parampg)
  {
    super(parampg);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = 0;
    switch (paramMessage.what)
    {
    }
    f localf;
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
            paramMessage = do.a().e();
          } while (paramMessage == null);
          cw.a().b(paramMessage.mUin, paramMessage.mRealUin, 1, this.a.c);
          return;
        } while (pg.a(this.a) == null);
        ((BaseActivity)pg.a(this.a)).dismissDialog();
        localf = (f)paramMessage.obj;
        f.a(pg.a(this.a).getResources(), localf);
        h.c("modqqpwd: " + localf.a + ", " + localf.c + ", arg=" + paramMessage.arg1);
      } while (pg.a(this.a) == null);
      if ((localf.c == null) || (localf.c.length() == 0)) {
        f.a(pg.a(this.a).getResources(), localf);
      }
      if ((pg.a(this.a) instanceof BaseActivity)) {
        ((BaseActivity)pg.a(this.a)).showUserDialog(2131230843, localf.c, 2131230897, null);
      }
      this.a.b();
      return;
      if (paramMessage.arg1 != 0) {
        break;
      }
      paramMessage = (Integer)paramMessage.obj;
      if ((pg.c(this.a) == 3) && (this.a.a != null))
      {
        this.a.a.a(paramMessage.intValue());
        this.a.a = null;
        if ((pg.a(this.a) instanceof BaseActivity)) {
          ((BaseActivity)pg.a(this.a)).dismissDialog();
        }
        this.a.b();
        return;
      }
    } while (pg.a(this.a) == null);
    if (pg.c(this.a) == 1) {}
    for (;;)
    {
      for (;;)
      {
        try
        {
          if ((paramMessage.intValue() != 1) && (paramMessage.intValue() != 3)) {
            continue;
          }
          paramMessage = new Intent(pg.a(this.a).getApplicationContext(), FaceRecognitionCameraActivity.class);
          paramMessage.putExtra("flag", 2);
          paramMessage.putExtra("scene", 8);
          paramMessage.putExtra("source_id", pg.d(this.a));
          pg.a(this.a).startActivity(paramMessage);
          if ((pg.a(this.a) instanceof BaseActivity)) {
            ((BaseActivity)pg.a(this.a)).dismissDialog();
          }
        }
        catch (Exception paramMessage)
        {
          continue;
        }
        this.a.b();
        return;
        paramMessage = new Intent(pg.a(this.a).getApplicationContext(), ModifyQQPwdActivity.class);
        paramMessage.putExtra("source_id", pg.d(this.a));
        pg.a(this.a).startActivity(paramMessage);
        continue;
        if (pg.c(this.a) == 2) {
          try
          {
            if (pg.e(this.a) != null) {
              i = pg.e(this.a).getIntExtra("page_id", 0);
            }
            if ((paramMessage.intValue() == 2) || (paramMessage.intValue() == 3))
            {
              pg.a(this.a, new Intent(pg.a(this.a).getApplicationContext(), FaceRecognitionCameraActivity.class));
              pg.e(this.a).putExtra("page_id", i);
              pg.e(this.a).putExtra("flag", 2);
              pg.e(this.a).putExtra("scene", 10);
              pg.e(this.a).putExtra("source_id", pg.d(this.a));
              pg.a(this.a).startActivity(pg.e(this.a));
            }
            while ((pg.a(this.a) instanceof BaseActivity))
            {
              ((BaseActivity)pg.a(this.a)).dismissDialog();
              break;
              pg.a(this.a).startActivity(pg.e(this.a));
            }
            if (pg.a(this.a) == null) {
              break;
            }
            ((BaseActivity)pg.a(this.a)).dismissDialog();
            if (pg.a(this.a) == null) {
              break;
            }
            localf = (f)paramMessage.obj;
            f.a(pg.a(this.a).getResources(), localf);
            h.c("modqqpwd: " + localf.a + ", " + localf.c + ", arg=" + paramMessage.arg1);
            if ((localf.c == null) || (localf.c.length() == 0)) {
              f.a(pg.a(this.a).getResources(), localf);
            }
            if ((pg.a(this.a) instanceof BaseActivity)) {
              ((BaseActivity)pg.a(this.a)).showUserDialog(2131230843, localf.c, 2131230897, null);
            }
          }
          catch (Exception paramMessage) {}
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.pp
 * JD-Core Version:    0.7.0.1
 */