package com.tencent.token.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.utils.t;

public final class pv
{
  public static int b = -1;
  private static pv d = null;
  qe a;
  public Handler c = new qc(this);
  private Activity e = null;
  private View.OnClickListener f = new py(this);
  private Handler.Callback g = new qb(this);
  
  public static pv a()
  {
    if (d == null) {
      d = new pv();
    }
    return d;
  }
  
  public final void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if ((paramIntent == null) || (paramActivity == null)) {}
    do
    {
      return;
      QQUser localQQUser = ax.a().e();
      if (localQQUser == null)
      {
        if ((paramActivity instanceof BaseActivity))
        {
          paramIntent = paramActivity.getResources().getString(2131362635);
          ((BaseActivity)paramActivity).showUserDialog(2131361808, paramIntent, 2131361800, new pz(this, paramActivity), new qa(this, paramActivity));
          return;
        }
        paramActivity.startActivity(new Intent(paramActivity, WtLoginAccountInput.class));
        paramActivity.finish();
        return;
      }
      if (((t.l() != 0) || (!localQQUser.mIsZzb)) && ((t.l() != 1) || (!ax.a().j()))) {
        break;
      }
      this.e = paramActivity;
      af.a().c(localQQUser.mUin, localQQUser.mRealUin, this.c);
    } while (!(paramActivity instanceof BaseActivity));
    ((BaseActivity)paramActivity).showProDialog(paramActivity, 2131361808, 2131362485, this.f);
    return;
    if (paramInt == b)
    {
      paramActivity.startActivity(paramIntent);
      return;
    }
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public final void a(Activity paramActivity, qe paramqe)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {}
    for (;;)
    {
      return;
      QQUser localQQUser = ax.a().e();
      if (localQQUser == null)
      {
        if ((paramActivity instanceof BaseActivity))
        {
          paramqe = paramActivity.getResources().getString(2131362635);
          ((BaseActivity)paramActivity).showUserDialog(2131361808, paramqe, 2131361800, new pw(this, paramActivity), new px(this, paramActivity));
          return;
        }
        paramActivity.startActivity(new Intent(paramActivity, WtLoginAccountInput.class));
        paramActivity.finish();
        return;
      }
      if (ax.a().j())
      {
        this.e = paramActivity;
        this.a = paramqe;
        if (localQQUser.mRealUin == 0L) {
          af.a().b(this.c);
        }
        while ((paramActivity instanceof BaseActivity))
        {
          ((BaseActivity)paramActivity).showProDialog(paramActivity, 2131361808, 2131362485, this.f);
          return;
          af.a().c(localQQUser.mUin, localQQUser.mRealUin, this.c);
        }
      }
    }
  }
  
  public final void b()
  {
    if (this.e != null) {
      this.e = null;
    }
    this.a = null;
    d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.pv
 * JD-Core Version:    0.7.0.1
 */