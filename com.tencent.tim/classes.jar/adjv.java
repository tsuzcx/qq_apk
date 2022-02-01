import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport.1;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport.2;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport.3;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport.4;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport.5;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport.6;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport.7;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport.8;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport.9;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class adjv
{
  private static long Um;
  private static adjv.a a;
  private static int cHp;
  private static int cHq = -1;
  
  private static void B(HashMap<String, String> paramHashMap)
  {
    String str2 = Build.MODEL;
    int i = Build.VERSION.SDK_INT;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramHashMap.put("report_key_device_model", str1);
    paramHashMap.put("report_key_device_sdk", String.valueOf(i));
  }
  
  public static void Lc(int paramInt)
  {
    adjv.a locala = a;
    if (locala == null) {}
    long l;
    do
    {
      return;
      a = null;
      l = System.currentTimeMillis() - locala.Uo;
    } while ((l > 600000L) || (locala.cHD <= 0));
    int k = locala.cHD;
    int m = locala.cHE;
    int n = locala.cHF;
    int i1 = locala.cHG / k;
    int i;
    if (m <= 0)
    {
      i = 0;
      if (n > 0) {
        break label124;
      }
    }
    label124:
    for (int j = 0;; j = locala.cHI / n)
    {
      ThreadManager.post(new MiniScanReport.1(i1, l, k, paramInt, m, i, n, j), 5, null, false);
      return;
      i = locala.cHH / m;
      break;
    }
  }
  
  public static void Ld(int paramInt)
  {
    ThreadManager.post(new MiniScanReport.6(paramInt), 5, null, false);
  }
  
  public static boolean aeJ()
  {
    if (cHq == -1) {
      if (!BaseApplication.getContext().getSharedPreferences("envSwitch", 4).getBoolean("key_base_test_scan_on", false)) {
        break label42;
      }
    }
    label42:
    for (int i = 1;; i = 0)
    {
      cHq = i;
      if (cHq != 1) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static void af(String paramString, long paramLong)
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("sp_mini_scan_report", 4).edit().putLong(paramString, paramLong).apply();
  }
  
  public static void bO(boolean paramBoolean1, boolean paramBoolean2)
  {
    ThreadManager.post(new MiniScanReport.5(paramBoolean1, paramBoolean2), 5, null, false);
  }
  
  public static void cSg()
  {
    a = new adjv.a(null);
    a.Uo = System.currentTimeMillis();
  }
  
  public static void cSh()
  {
    if ((Um == 0L) || (cHp == 0))
    {
      Um = 0L;
      cHp = 0;
      return;
    }
    long l = (SystemClock.uptimeMillis() - Um) / 1000L;
    if (l != 0L)
    {
      int i = (int)(cHp / l);
      if ((QLog.isColorLevel()) || (aeJ())) {
        QLog.i("MiniRecog.MiniScanReport", 1, String.format("base_test_scan frame_rate=%d", new Object[] { Integer.valueOf(i) }));
      }
    }
    Um = 0L;
    cHp = 0;
  }
  
  public static void doFrame()
  {
    if (Um == 0L) {
      Um = SystemClock.uptimeMillis();
    }
    cHp += 1;
  }
  
  public static long h(String paramString, long paramLong)
  {
    return BaseApplicationImpl.sApplication.getSharedPreferences("sp_mini_scan_report", 4).getLong(paramString, paramLong);
  }
  
  public static void hr(int paramInt1, int paramInt2)
  {
    if ((a == null) || (paramInt1 <= 1) || (paramInt1 > 15000)) {
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      locala = a;
      locala.cHD += 1;
      locala = a;
      locala.cHG += paramInt1;
      return;
    case 1: 
      locala = a;
      locala.cHE += 1;
      locala = a;
      locala.cHH += paramInt1;
      return;
    }
    adjv.a locala = a;
    locala.cHF += 1;
    locala = a;
    locala.cHI += paramInt1;
  }
  
  public static void hs(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new MiniScanReport.3(paramInt1, paramInt2), 5, null, false);
  }
  
  public static void ht(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new MiniScanReport.4(paramInt2, paramInt1), 5, null, false);
  }
  
  public static void hu(int paramInt1, int paramInt2)
  {
    if ((paramInt2 <= 0) || (paramInt2 > 180000)) {
      return;
    }
    ThreadManager.post(new MiniScanReport.7(paramInt1, paramInt2), 5, null, false);
  }
  
  public static void hv(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new MiniScanReport.8(paramInt1, paramInt2), 5, null, false);
  }
  
  public static void hw(int paramInt1, int paramInt2)
  {
    if ((paramInt2 <= 0) || (paramInt2 > 180000)) {
      return;
    }
    ThreadManager.post(new MiniScanReport.9(paramInt1, paramInt2), 5, null, false);
  }
  
  public static void k(boolean paramBoolean, int paramInt, String paramString)
  {
    ThreadManager.post(new MiniScanReport.2(paramBoolean, paramInt, paramString), 5, null, false);
  }
  
  static class a
  {
    long Uo;
    int cHD;
    int cHE;
    int cHF;
    int cHG;
    int cHH;
    int cHI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adjv
 * JD-Core Version:    0.7.0.1
 */