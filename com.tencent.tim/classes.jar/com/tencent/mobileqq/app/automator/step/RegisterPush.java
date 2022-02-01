package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

public class RegisterPush
  extends AsyncStep
{
  private AccountObserver f;
  
  public int od()
  {
    this.a.app.a().cKf();
    this.a.app.cLA();
    return 2;
  }
  
  public void onCreate()
  {
    if (this.cyx == 13) {}
    for (this.cyy = 0;; this.cyy = 10)
    {
      this.f = new a(null);
      this.a.app.registObserver(this.f);
      return;
    }
  }
  
  public void onDestroy()
  {
    if (this.f != null)
    {
      this.a.app.unRegistObserver(this.f);
      this.f = null;
    }
    if ((this.cyx == 12) && (this.mResult == 6)) {
      this.a.onDestroy();
    }
  }
  
  class a
    extends AccountObserver
  {
    private a() {}
    
    public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "onOnlineStatusChanged isSuccess=" + paramBoolean1 + ",curStatus=" + paramStatus.toString() + ",isFriendListChang=" + paramBoolean3 + ",timeStamp=" + paramLong + ",isGatherListChange=" + paramBoolean4);
      }
      if (paramBoolean1)
      {
        RegisterPush.this.setResult(7);
        return;
      }
      RegisterPush.this.setResult(6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.RegisterPush
 * JD-Core Version:    0.7.0.1
 */