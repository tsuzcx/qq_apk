package com.tencent.token.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.do;

public class pg
{
  public static int b = -1;
  private static pg d = null;
  pr a;
  public Handler c = new pp(this);
  private Activity e = null;
  private int f;
  private Intent g;
  private int h = 0;
  private View.OnClickListener i = new pj(this);
  private Handler.Callback j = new po(this);
  
  public static pg a()
  {
    if (d == null) {
      d = new pg();
    }
    return d;
  }
  
  public void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if ((paramIntent == null) || (paramActivity == null)) {}
    do
    {
      return;
      if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
        this.h = paramIntent.getIntExtra("source_id", 0);
      }
      QQUser localQQUser = do.a().e();
      if (localQQUser == null)
      {
        if ((paramActivity instanceof BaseActivity))
        {
          paramIntent = paramActivity.getResources().getString(2131230770);
          ((BaseActivity)paramActivity).showUserDialog(2131230843, paramIntent, 2131230897, new pk(this, paramActivity), new pl(this, paramActivity));
          return;
        }
        paramActivity.startActivity(new Intent(paramActivity, WtLoginAccountInput.class));
        paramActivity.finish();
        return;
      }
      if (!do.a().j()) {
        break;
      }
      this.e = paramActivity;
      cw.a().b(localQQUser.mUin, localQQUser.mRealUin, 1, this.c);
      this.f = 1;
    } while (!(paramActivity instanceof BaseActivity));
    ((BaseActivity)paramActivity).showProDialog(paramActivity, 2131230843, 2131231030, this.i);
    return;
    if (paramInt == b)
    {
      paramActivity.startActivity(paramIntent);
      return;
    }
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public void a(Activity paramActivity, pr parampr)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {}
    for (;;)
    {
      return;
      QQUser localQQUser = do.a().e();
      if (localQQUser == null)
      {
        if ((paramActivity instanceof BaseActivity))
        {
          parampr = paramActivity.getResources().getString(2131230770);
          ((BaseActivity)paramActivity).showUserDialog(2131230843, parampr, 2131230897, new ph(this, paramActivity), new pi(this, paramActivity));
          return;
        }
        paramActivity.startActivity(new Intent(paramActivity, WtLoginAccountInput.class));
        paramActivity.finish();
        return;
      }
      if (do.a().j())
      {
        this.e = paramActivity;
        this.a = parampr;
        if (localQQUser.mRealUin == 0L) {
          cw.a().b(this.c);
        }
        while ((paramActivity instanceof BaseActivity))
        {
          ((BaseActivity)paramActivity).showProDialog(paramActivity, 2131230843, 2131231030, this.i);
          return;
          this.f = 3;
          cw.a().b(localQQUser.mUin, localQQUser.mRealUin, 3, this.c);
        }
      }
    }
  }
  
  public void b()
  {
    if (this.e != null) {
      this.e = null;
    }
    this.a = null;
    d = null;
    this.f = 0;
    this.g = null;
  }
  
  public void b(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if ((paramIntent == null) || (paramActivity == null)) {}
    do
    {
      return;
      QQUser localQQUser = do.a().e();
      if (localQQUser == null)
      {
        if ((paramActivity instanceof BaseActivity))
        {
          paramIntent = paramActivity.getResources().getString(2131230770);
          ((BaseActivity)paramActivity).showUserDialog(2131230843, paramIntent, 2131230897, new pm(this, paramActivity), new pn(this, paramActivity));
          return;
        }
        paramActivity.startActivity(new Intent(paramActivity, WtLoginAccountInput.class));
        paramActivity.finish();
        return;
      }
      if (!do.a().j()) {
        break;
      }
      this.e = paramActivity;
      cw.a().b(localQQUser.mUin, localQQUser.mRealUin, 2, this.c);
      this.f = 2;
      this.g = paramIntent;
    } while (!(paramActivity instanceof BaseActivity));
    ((BaseActivity)paramActivity).showProDialog(paramActivity, 2131230843, 2131231030, this.i);
    return;
    if (paramInt == b)
    {
      paramActivity.startActivity(paramIntent);
      return;
    }
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.pg
 * JD-Core Version:    0.7.0.1
 */