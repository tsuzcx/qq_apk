package com.tencent.mobileqq.app.automator.step;

import acms;
import acnd;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class UpdateTroop
  extends AsyncStep
{
  private acnd n;
  
  private void cMF()
  {
    if (this.n == null)
    {
      this.n = new a(null);
      this.a.app.addObserver(this.n);
    }
    ((acms)this.a.app.getBusinessHandler(20)).cMF();
  }
  
  public int od()
  {
    if (this.cyx == 4)
    {
      this.a.bJJ = this.a.O.getBoolean("isTrooplistok", false);
      Object localObject = this.a.app.a();
      if (((localObject instanceof QQEntityManagerFactory)) && (((QQEntityManagerFactory)localObject).isUpdated())) {
        this.a.bJJ = false;
      }
      localObject = (TroopManager)this.a.app.getManager(52);
      if (this.a.bJJ)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "onCheckTroopList:Done");
        }
        acms localacms = (acms)this.a.app.getBusinessHandler(20);
        ((TroopManager)localObject).cMQ();
        localacms.notifyUI(2, true, null);
        this.a.notifyUI(3, true, Integer.valueOf(2));
        return 7;
      }
      ((TroopManager)localObject).cMQ();
      cMF();
    }
    for (;;)
    {
      return 2;
      cMF();
    }
  }
  
  public void onCreate()
  {
    this.cyy = 2;
  }
  
  public void onDestroy()
  {
    if (this.n != null)
    {
      this.a.app.removeObserver(this.n);
      this.n = null;
    }
  }
  
  class a
    extends acnd
  {
    private a() {}
    
    public void jc(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "updateTroopList:" + paramBoolean);
      }
      if (!paramBoolean)
      {
        UpdateTroop.this.setResult(6);
        return;
      }
      UpdateTroop.this.a.O.edit().putBoolean("isTrooplistok", true).commit();
      UpdateTroop.this.a.notifyUI(3, true, Integer.valueOf(2));
      UpdateTroop.this.setResult(7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateTroop
 * JD-Core Version:    0.7.0.1
 */