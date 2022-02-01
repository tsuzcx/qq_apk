package com.tencent.qqlive.tvkplayer.vinfo.ckey;

import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.DeviceInfoUtil;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsAppKeyBean;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsLog;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsReporter;

class CKeyFacade$1
  implements Runnable
{
  CKeyFacade$1(CKeyFacade paramCKeyFacade, String paramString, VsAppKeyBean paramVsAppKeyBean) {}
  
  public void run()
  {
    try
    {
      if (CKeyFacade.access$000() != null) {
        CKeyFacade.access$400(CKeyFacade.access$100(), CKeyFacade.access$200(), CKeyFacade.access$300(), CKeyFacade.access$000());
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          CKeyFacade.access$600();
          CKeyFacade.access$502(CKeyBeaconReport.getQIMEI());
          CKeyFacade.access$202("");
          java.lang.Thread.currentThread().getStackTrace()[2].getMethodName();
          VsReporter.reportInit(CKeyFacade.access$000(), CKeyFacade.access$700(), CKeyFacade.access$800(), CKeyFacade.access$300(), CKeyFacade.access$200(), this.val$bsGuid, CKeyFacade.access$500(), 0, CKeyFacade.access$900());
          DeviceInfoUtil.getQimei36();
          if ((CKeyFacade.access$700() != null) && (!CKeyFacade.access$700().isEmpty()) && (this.val$vsAppKeyBean != null)) {
            this.this$0.initStartrail(this.val$vsAppKeyBean.getPlatform());
          }
          return;
          localThrowable1 = localThrowable1;
          VsLog.error("ckeyMoudleInit failed!", new Object[0]);
          localThrowable1.printStackTrace();
          CKeyFacade.bLoadSucc = false;
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          localThrowable2.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade.1
 * JD-Core Version:    0.7.0.1
 */