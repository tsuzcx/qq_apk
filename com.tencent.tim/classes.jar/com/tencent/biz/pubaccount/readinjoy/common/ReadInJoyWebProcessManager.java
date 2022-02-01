package com.tencent.biz.pubaccount.readinjoy.common;

import android.os.Build.VERSION;
import anpc;
import aqgz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kxm;

public class ReadInJoyWebProcessManager
{
  public static void R(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new InitWebProcessRunnable(paramQQAppInterface));
  }
  
  static class InitWebProcessRunnable
    implements Runnable
  {
    private QQAppInterface d;
    
    public InitWebProcessRunnable(QQAppInterface paramQQAppInterface)
    {
      this.d = paramQQAppInterface;
    }
    
    private void pZ(int paramInt)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
        localHashMap.put("param_totalMem", String.valueOf(aqgz.getSystemTotalMemory()));
        localHashMap.put("param_availableMem", String.valueOf(aqgz.getSystemAvaialbeMemory()));
        localHashMap.put("param_cpuNum", String.valueOf(aqgz.getCpuNumber()));
        localHashMap.put("param_cpuFreq", String.valueOf(aqgz.getCpuFrequency()));
        localHashMap.put("param_preloadLevel", String.valueOf(paramInt));
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.ReadInJoyWebProcessManager", 2, "preloadToolProcessReport:" + localHashMap.toString());
        }
        anpc.a(this.d.getApp()).collectPerformance(this.d.getCurrentAccountUin(), "actReadInJoyToolPreload", true, 0L, 0L, localHashMap, "");
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("Q.readinjoy.ReadInJoyWebProcessManager", 2, "Exception: " + localException);
      }
    }
    
    public void run()
    {
      if ((WebProcessManager.aFS()) || (this.d == null)) {}
      for (;;)
      {
        return;
        WebProcessManager localWebProcessManager = (WebProcessManager)this.d.getManager(13);
        if (localWebProcessManager != null)
        {
          int i = kxm.nS();
          if (kxm.AO()) {
            pZ(i);
          }
          if (i == 1) {
            localWebProcessManager.Yc(200);
          }
          while (QLog.isColorLevel())
          {
            QLog.d("Q.readinjoy.ReadInJoyWebProcessManager", 2, "enter folder preload web process");
            return;
            if (i == 2) {
              localWebProcessManager.Yc(201);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyWebProcessManager
 * JD-Core Version:    0.7.0.1
 */