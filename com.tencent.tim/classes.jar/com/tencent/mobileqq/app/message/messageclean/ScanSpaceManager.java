package com.tencent.mobileqq.app.message.messageclean;

import acsm;
import acsr;
import ahaf;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import anql;
import aqmb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQSettingCleanActivity.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ScanSpaceManager
  implements Handler.Callback
{
  public static final ArrayList<String> pv = new ArrayList(2);
  public long GJ;
  public long GK;
  public long GL;
  private acsm a;
  private volatile boolean bKe;
  private Handler handler;
  
  public ScanSpaceManager()
  {
    cOm();
    this.bKe = false;
    this.handler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void Kj(int paramInt)
  {
    if (this.handler != null)
    {
      Message localMessage = this.handler.obtainMessage(1);
      localMessage.arg1 = paramInt;
      this.handler.sendMessage(localMessage);
    }
  }
  
  private void ahC()
  {
    if (this.handler != null)
    {
      Message localMessage = this.handler.obtainMessage(2);
      this.handler.sendMessageDelayed(localMessage, 200L);
    }
  }
  
  private void cOm()
  {
    String str1 = ahaf.a().vZ();
    String str2 = ahaf.a().vY();
    pv.clear();
    if (!TextUtils.isEmpty(str1))
    {
      pv.add(str1);
      QLog.d("ScanSpaceManager", 2, " need scan file path1 = " + str1);
    }
    if (!TextUtils.isEmpty(str2))
    {
      pv.add(str2);
      QLog.d("ScanSpaceManager", 2, " need scan file path2 = " + str2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScanSpaceManager", 2, " need scan file path1 = " + str1 + " path2 = " + str2);
    }
  }
  
  public void a(acsm paramacsm)
  {
    this.a = paramacsm;
  }
  
  public boolean acb()
  {
    return this.bKe;
  }
  
  public void bTy()
  {
    if (!this.bKe)
    {
      if (this.a != null)
      {
        this.a.bUv();
        this.a.Bs(0);
      }
      anql.y().post(new ScanSpaceTask());
    }
  }
  
  public long eZ()
  {
    if (this.bKe) {
      return this.GJ - this.GK - this.GL;
    }
    return 0L;
  }
  
  public long fa()
  {
    if (this.bKe) {
      return this.GL;
    }
    return 0L;
  }
  
  public long fb()
  {
    if (this.bKe) {
      return this.GJ;
    }
    return 0L;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.a != null)
      {
        this.a.Bs(paramMessage.arg1);
        continue;
        if (this.a != null) {
          this.a.a(this.GK, this.GJ - this.GK - this.GL, this.GL, this.GJ);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.bKe = false;
    anql.dTd();
    pv.clear();
    if (this.handler != null)
    {
      this.handler.removeCallbacksAndMessages(null);
      this.handler = null;
    }
    this.a = null;
  }
  
  public class ScanSpaceTask
    implements Runnable
  {
    ScanSpaceTask() {}
    
    public void run()
    {
      long l1 = aqmb.getTotalInternalMemorySize();
      long l2 = aqmb.s(BaseApplicationImpl.getApplication());
      long l3 = aqmb.getAvailableInternalMemorySize();
      long l4 = aqmb.t(BaseApplicationImpl.getApplication());
      ScanSpaceManager.this.GJ = (l1 + l2);
      ScanSpaceManager.this.GL = (l3 + l4);
      acsr localacsr = new acsr(this);
      ScanSpaceManager.this.GK = anql.a().a(localacsr, 0, 98);
      localacsr.Bq(100);
      QLog.d("ScanSpaceManager", 1, "SpaceInfo total: " + ScanSpaceManager.this.GJ + " ava: " + ScanSpaceManager.this.GL + " qq: " + ScanSpaceManager.this.GK);
      QLog.d("ScanSpaceManager", 1, "SpaceInfo totalIner: " + l1 + " totalExter: " + l2 + " avaInter: " + l3 + " avaExter: " + l4);
      ScanSpaceManager.a(ScanSpaceManager.this, true);
      ScanSpaceManager.a(ScanSpaceManager.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.ScanSpaceManager
 * JD-Core Version:    0.7.0.1
 */