package com.tencent.mobileqq.app.automator.step;

import achq;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;

public class GetTroopAssisMsg
  extends AsyncStep
{
  private achq j;
  
  public int od()
  {
    this.a.app.a().bn(3, true);
    return 2;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.j == null)
    {
      this.j = new a(null);
      this.a.app.addDefaultObservers(this.j);
    }
  }
  
  public void onDestroy()
  {
    if (this.j != null)
    {
      this.a.app.removeObserver(this.j);
      this.j = null;
    }
  }
  
  class a
    extends achq
  {
    private a() {}
    
    public void a(boolean paramBoolean, String[] paramArrayOfString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "on GetTroopMsg Fin:" + paramBoolean);
      }
      MsgAutoMonitorUtil.getInstance().markGrpFinishCost();
      GetTroopAssisMsg.this.setResult(7);
    }
    
    public void ap(boolean paramBoolean, Object paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "on RegisterProxy Fin:" + paramBoolean);
      }
      if (!paramBoolean) {
        GetTroopAssisMsg.this.setResult(6);
      }
    }
    
    public void d(boolean paramBoolean, long paramLong1, long paramLong2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "onGetAllProxyMsgFin:" + paramBoolean + ", timeoutFlag=" + paramLong1 + ", type=" + paramLong2);
      }
      if (paramLong2 == 1L) {
        if ((!paramBoolean) || (paramLong1 == 8L) || (paramLong1 == 4L)) {
          break label95;
        }
      }
      label95:
      for (int i = 1; i == 0; i = 0)
      {
        GetTroopAssisMsg.this.setResult(6);
        return;
      }
      GetTroopAssisMsg.this.setResult(7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetTroopAssisMsg
 * JD-Core Version:    0.7.0.1
 */