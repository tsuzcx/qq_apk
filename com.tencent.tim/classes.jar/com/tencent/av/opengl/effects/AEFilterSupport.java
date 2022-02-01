package com.tencent.av.opengl.effects;

import alwy;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import ankq.b;
import aqgz;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import imm;
import iow;
import jkn;

public class AEFilterSupport
{
  private static a jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterSupport$a;
  private static final b jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterSupport$b = new b(21, 4, 1.1F, 3.0F);
  private static int aqZ = 0;
  private static int ara = 0;
  private static int arb;
  private static final b b = new b(21, 4, 1.4F, 2.7F);
  private static Runnable bo;
  private static final b c = new b(27, 8, 1.8F, 5.0F);
  private static long ml;
  private static final Object sLock = new Object();
  
  @NonNull
  public static a a()
  {
    if (jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterSupport$a == null)
    {
      a locala = new a();
      locala.apiLevel = Build.VERSION.SDK_INT;
      locala.gJ = ((float)aqgz.getSystemTotalMemory() / 1.073742E+009F);
      locala.Gq = aqgz.getCpuNumber();
      locala.gI = ((float)imm.getMaxCpuFreq() / 1048576.0F);
      jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterSupport$a = locala;
    }
    return jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterSupport$a;
  }
  
  private static void aoP()
  {
    if (!iow.uW())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterSupport", 2, "checkAndLoadAEKitSo, not support AEKit.");
      }
      return;
    }
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      l1 = SystemClock.elapsedRealtime();
    }
    boolean bool = ankq.b.aye();
    if (!bool) {
      bool = alwy.bi(false);
    }
    for (;;)
    {
      for (;;)
      {
        int i;
        if (bool)
        {
          i = 1;
          if (aqZ == 1) {}
        }
        synchronized (sLock)
        {
          if (aqZ != 1) {
            aqZ = i;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          long l2 = SystemClock.elapsedRealtime();
          QLog.i("AEFilterSupport", 2, "checkAndLoadAEKitSo ret[" + bool + "], cost[" + (l2 - l1) + "], flag[" + aqZ + "]");
          return;
          i = -1;
        }
      }
    }
  }
  
  public static boolean cp(int paramInt)
  {
    boolean bool = true;
    if (!iow.uW())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterSupport", 2, "isAEKitSoReady, not support AEKit.");
      }
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (aqZ != 1)
      {
        if (ankq.b.aye())
        {
          aqZ = 1;
          return true;
        }
        if (paramInt != 1) {
          break label68;
        }
        ml = SystemClock.elapsedRealtime();
        aoP();
      }
      while (aqZ != 1)
      {
        return false;
        label68:
        if ((paramInt == 2) && (bo == null) && (Math.abs(SystemClock.elapsedRealtime() - ml) > 30000L))
        {
          ml = SystemClock.elapsedRealtime();
          bo = new CheckAEFilterTask();
          ThreadManager.excute(bo, 16, null, false);
        }
      }
    }
  }
  
  public static int lo()
  {
    if (arb != 0) {
      return arb;
    }
    String str1 = jkn.dB("machineMiddleLine");
    String str2 = jkn.dB("machineHighLine");
    b.bj(str1);
    c.bj(str2);
    a locala = a();
    if (c.a(locala)) {
      arb = 7;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterSupport", 2, String.format("getCurMachineLevel, level: %s, middle[%s], high[%s], cur[%s], config[%s, %s]", new Object[] { Integer.valueOf(arb), b, c, locala, str1, str2 }));
      }
      return arb;
      if (b.a(locala)) {
        arb = 4;
      } else {
        arb = 3;
      }
    }
  }
  
  public static boolean uP()
  {
    boolean bool = true;
    if (!iow.uW())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterSupport", 2, "isSupportPtuNew, not support AEKit.");
      }
      return false;
    }
    if (ara == 0)
    {
      String str = jkn.dB("ptuNewRenderLimit");
      jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterSupport$b.bj(str);
      a locala = a();
      if (!jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterSupport$b.a(locala)) {
        break label114;
      }
      ara = 1;
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterSupport", 2, String.format("isSupportPtuNew, flag: %s, line: %s, cur: %s, config[%s]", new Object[] { Integer.valueOf(ara), jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterSupport$b, locala, str }));
      }
    }
    if (ara == 1) {}
    for (;;)
    {
      return bool;
      label114:
      ara = -1;
      break;
      bool = false;
    }
  }
  
  static final class CheckAEFilterTask
    implements Runnable
  {
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterSupport", 2, "CheckAEFilterTask before[" + AEFilterSupport.aqZ + "]");
      }
      if (AEFilterSupport.aqZ != 1) {
        AEFilterSupport.access$100();
      }
      AEFilterSupport.c(null);
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterSupport", 2, "CheckAEFilterTask after[" + AEFilterSupport.aqZ + "]");
      }
    }
  }
  
  public static class a
  {
    public int Gq;
    public int apiLevel;
    public float gI;
    public float gJ;
    
    @NonNull
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append("[apiLevel: ").append(this.apiLevel).append(", cpuNum: ").append(this.Gq).append(", maxFreqGHZ: ").append(this.gI).append(", ramSizeGB:").append(this.gJ).append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static class b
    extends AEFilterSupport.a
  {
    b(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
    {
      this.apiLevel = paramInt1;
      this.Gq = paramInt2;
      this.gI = paramFloat1;
      this.gJ = paramFloat2;
    }
    
    boolean a(@NonNull AEFilterSupport.a parama)
    {
      return (this.apiLevel <= parama.apiLevel) && (this.Gq <= parama.Gq) && (this.gI <= parama.gI) && (this.gJ <= parama.gJ);
    }
    
    void bj(String paramString)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.split(";");
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          if (localObject == null) {}
          for (;;)
          {
            i += 1;
            break;
            int k = localObject.indexOf('=');
            if ((k > 0) && (k < localObject.length()))
            {
              String str;
              float f;
              try
              {
                str = localObject.substring(0, k);
                f = Float.parseFloat(localObject.substring(k + 1));
                if (!"MemoryLimit".equalsIgnoreCase(str)) {
                  break label118;
                }
                this.gJ = f;
              }
              catch (Throwable localThrowable)
              {
                localThrowable.printStackTrace();
              }
              continue;
              label118:
              if ("CpuNumLimit".equalsIgnoreCase(str)) {
                this.Gq = ((int)f);
              } else if ("CpuFreqLimit".equalsIgnoreCase(str)) {
                this.gI = f;
              } else if ("APILevelLimit".equalsIgnoreCase(str)) {
                this.apiLevel = ((int)f);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AEFilterSupport
 * JD-Core Version:    0.7.0.1
 */