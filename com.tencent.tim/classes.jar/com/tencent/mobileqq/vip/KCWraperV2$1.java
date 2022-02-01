package com.tencent.mobileqq.vip;

import android.content.Context;
import aqvf;
import aqvg;
import aqvg.a;
import aqvh;
import aqvi;
import aqvn;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.qphone.base.util.QLog;
import dualsim.common.IKingCardInterface;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import tmsdk.common.KcSdkShellManager;

public class KCWraperV2$1
  implements Runnable
{
  public KCWraperV2$1(aqvg paramaqvg, File paramFile, Context paramContext) {}
  
  public void run()
  {
    int i = 0;
    long l = IOUtil.getCRC32Value(this.B);
    QLog.d(this.this$0.tag(), 1, "tryLoad " + this.B.getName() + " crc32: " + Long.toHexString(l));
    QLog.flushLog();
    for (;;)
    {
      synchronized (this.this$0.ew)
      {
        if (this.this$0.ew.get()) {
          return;
        }
        if (QLog.isColorLevel()) {
          KcSdkShellManager.getInstance().setLogPrint(new aqvh(this));
        }
        KcSdkShellManager.getInstance().setTMSDKLogEnable(QLog.isColorLevel());
        KcSdkShellManager.getInstance().setPhoneInfoBridge(new aqvi(this));
        if (aqvn.isMainProcess(this.val$context))
        {
          boolean bool = KcSdkShellManager.getInstance().initInBaseProcess(this.val$context, this.B.getAbsolutePath(), "00047", "ck_shoujiqq_dfhdsuif5f6d_f4d89e");
          QLog.e(this.this$0.tag(), 1, "initInBaseProcess");
          i = bool;
          if (KcSdkShellManager.getInstance().getKingCardInterface() != null)
          {
            KcSdkShellManager.getInstance().getKingCardInterface().registerOnChangeListener(new aqvg.a());
            i = bool;
          }
          if (i != 0) {
            break label268;
          }
          QLog.e(this.this$0.tag(), 1, "tryLoad failed");
          aqvf.SV(false);
          this.this$0.ew.notify();
          return;
        }
      }
      QLog.w(this.this$0.tag(), 1, "only load in main process!");
      continue;
      label268:
      this.this$0.ew.set(true);
      aqvf.SV(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.KCWraperV2.1
 * JD-Core Version:    0.7.0.1
 */