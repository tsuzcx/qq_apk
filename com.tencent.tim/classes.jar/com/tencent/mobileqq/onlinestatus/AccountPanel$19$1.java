package com.tencent.mobileqq.onlinestatus;

import akrv;
import aksd;
import akti;
import akum;
import android.content.res.Resources;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class AccountPanel$19$1
  implements Runnable
{
  public AccountPanel$19$1(aksd paramaksd, boolean paramBoolean, AppRuntime.Status paramStatus) {}
  
  public void run()
  {
    long l;
    if (this.val$isSuccess)
    {
      l = akti.a().k(akrv.a(this.a.this$0));
      if ((akrv.a(this.a.this$0) != 1000L) || (l != 1000L)) {
        break label197;
      }
    }
    label197:
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (akrv.c(this.a.this$0)))
      {
        String str = akti.a().a(l, this.d);
        str = akrv.a(this.a.this$0).getResources().getString(2131700583, new Object[] { str });
        QQToast.a(akrv.a(this.a.this$0), 2, str, 1).show();
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "Show toast in account panel mAccountObserver");
        }
      }
      akum.b().aw(akrv.a(this.a.this$0), l);
      akrv.a(this.a.this$0, l);
      return;
      QQToast.a(akrv.a(this.a.this$0), 1, 2131700573, 1).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.19.1
 * JD-Core Version:    0.7.0.1
 */