package com.tencent.mobileqq.app.automator.step;

import aceb;
import acje;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class CheckPublicAccount
  extends AsyncStep
{
  acje d;
  
  void cNw()
  {
    if (this.d == null)
    {
      this.d = new a(null);
      this.a.app.addObserver(this.d);
    }
  }
  
  public int od()
  {
    Object localObject = (PublicAccountHandler)this.a.app.getBusinessHandler(11);
    if (this.cyx == 6)
    {
      if (!this.a.O.getBoolean("isPublicAccountListOK", false))
      {
        cNw();
        ((PublicAccountHandler)localObject).cLh();
        ((PublicAccountHandler)localObject).AF();
        return 2;
      }
    }
    else
    {
      boolean bool = ((PublicAccountHandler)localObject).isNeedUpdate();
      if (bool)
      {
        cNw();
        ((PublicAccountHandler)localObject).AF();
      }
      localObject = this.a.app.getApplication().getApplicationContext().getSharedPreferences(this.a.app.getAccount(), 0);
      long l = System.currentTimeMillis();
      if (l - ((SharedPreferences)localObject).getLong("eqqlist_login_update_ts", 0L) > 86400000L)
      {
        aceb localaceb = (aceb)this.a.app.getBusinessHandler(21);
        if (localaceb != null) {
          localaceb.hq(SystemClock.uptimeMillis());
        }
        ((SharedPreferences)localObject).edit().putLong("eqqlist_login_update_ts", l);
      }
      localObject = this.a.app.a().createEntityManager();
      this.a.app.b().b((EntityManager)localObject);
      if (bool) {
        return 2;
      }
    }
    return 7;
  }
  
  public void onDestroy()
  {
    if (this.d != null)
    {
      this.a.app.removeObserver(this.d);
      this.d = null;
    }
  }
  
  class a
    extends acje
  {
    private a() {}
    
    public void aH(int paramInt, boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "PublicAccount onUpdateUserFollowList:" + paramBoolean + " " + paramInt);
      }
      if ((paramBoolean) && (paramInt == 0))
      {
        CheckPublicAccount.this.a.O.edit().putBoolean("isPublicAccountListOK", true).commit();
        CheckPublicAccount.this.setResult(7);
      }
      while (paramInt == 0) {
        return;
      }
      CheckPublicAccount.this.setResult(6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckPublicAccount
 * JD-Core Version:    0.7.0.1
 */