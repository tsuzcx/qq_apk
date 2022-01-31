package com.tencent.token.ui;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.widget.Toast;
import com.tencent.token.dm;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.UserTask;

class ll
  extends UserTask
{
  ll(IndexActivity paramIndexActivity) {}
  
  public f a(String... paramVarArgs)
  {
    if (IndexActivity.s_FromPush) {
      return dm.a().a(dm.e, IndexActivity.access$2100(this.a));
    }
    return dm.a().a(dm.a, IndexActivity.access$2100(this.a));
  }
  
  public void a(f paramf)
  {
    IndexActivity.access$2202(this.a, false);
    if (this.a.isFinishing()) {}
    do
    {
      do
      {
        return;
        this.a.dismissDialog();
        h.c("other app: " + IndexActivity.s_FromOtherApp + ", retcode=" + paramf.a);
        if (IndexActivity.s_FromOtherApp)
        {
          IndexActivity.s_FromOtherApp = false;
          if (paramf.b())
          {
            if (dm.a().b() > 0)
            {
              IndexActivity.access$2300(this.a, true);
              return;
            }
            IndexActivity.access$2400(this.a, 4);
            return;
          }
          if (110 == paramf.a)
          {
            IndexActivity.access$2400(this.a, 2);
            return;
          }
          if (10029 == paramf.a)
          {
            IndexActivity.access$2400(this.a, 1);
            return;
          }
          f.a(this.a.getResources(), paramf);
          this.a.dismissDialog();
          IndexActivity.access$2502(this.a, new AlertDialog.Builder(this.a).setTitle(2131230843).setMessage(paramf.c).setPositiveButton(2131231388, new lm(this)).create());
          IndexActivity.access$2500(this.a).show();
          return;
        }
      } while (!paramf.b());
      if (dm.a().b() > 0)
      {
        IndexActivity.access$2300(this.a, false);
        return;
      }
    } while (!IndexActivity.s_FromPush);
    Toast.makeText(this.a, 2131230949, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ll
 * JD-Core Version:    0.7.0.1
 */