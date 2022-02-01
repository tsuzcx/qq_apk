import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ScanEntranceReport.1;
import com.tencent.mobileqq.ar.ScanEntranceReport.4;
import com.tencent.mobileqq.ar.ScanEntranceReport.5;
import com.tencent.mobileqq.ar.ScanEntranceReport.6;
import com.tencent.mobileqq.ar.ScanEntranceReport.9;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class adfx
{
  private static adfx a;
  private boolean bMN;
  private boolean bMO;
  
  public static adfx a()
  {
    if (a == null) {
      a = new adfx();
    }
    return a;
  }
  
  private boolean bQ(long paramLong)
  {
    return (paramLong >= 0L) && (paramLong <= 600000L);
  }
  
  public void Ga(boolean paramBoolean)
  {
    QLog.d("ScanEntranceReport", 2, String.format("reportQBarSoLoadFail systemLoadSuccess=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    HashMap localHashMap = new HashMap();
    anpc.a(BaseApplication.getContext()).collectPerformance("", "scanner_qbar_so_load_fail", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void H(boolean paramBoolean, long paramLong)
  {
    if (paramLong <= 0L) {}
    do
    {
      return;
      paramLong = System.currentTimeMillis() - paramLong;
    } while (!bQ(paramLong));
    QLog.d("ScanEntranceReport", 2, String.format("reportARCloudFirstResult success=%s totalTime=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) }));
    ThreadManager.post(new ScanEntranceReport.5(this, paramBoolean, paramLong), 5, null, false);
  }
  
  public void aD(long paramLong, int paramInt)
  {
    if (paramLong <= 0L) {}
    do
    {
      return;
      paramLong = System.currentTimeMillis() - paramLong;
    } while (!bQ(paramLong));
    QLog.d("ScanEntranceReport", 2, String.format("reportARCloudFirstSuccess totalTime=%s", new Object[] { Long.valueOf(paramLong) }));
    ThreadManager.post(new ScanEntranceReport.6(this, paramInt, paramLong), 5, null, false);
  }
  
  public void b(boolean paramBoolean, long paramLong1, long paramLong2, String paramString)
  {
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L)) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      paramLong1 = paramLong2 - paramLong1;
      paramLong2 = l - paramLong2;
      l = paramLong1 + paramLong2;
    } while ((!bQ(paramLong1)) || (!bQ(paramLong2)) || (!bQ(l)));
    this.bMN = paramBoolean;
    if ((paramBoolean) && (paramLong1 > 500L)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.bMO = paramBoolean;
      QLog.d("ScanEntranceReport", 2, String.format("reportActivityLaunchTime procExist=%s procRestart=%s procLoadTimeCost=%s activityLaunchTimeCost=%s totalTimeCost=%s source=%s", new Object[] { Boolean.valueOf(this.bMN), Boolean.valueOf(this.bMO), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l), paramString }));
      ThreadManager.post(new ScanEntranceReport.1(this, paramLong1, paramLong2, paramString, l), 5, null, false);
      return;
    }
  }
  
  public void cRq()
  {
    QLog.d("ScanEntranceReport", 2, "reportZoomCamera");
    ThreadManager.post(new ScanEntranceReport.9(this), 5, null, false);
  }
  
  public void d(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L) || (paramLong3 <= 0L)) {
      return;
    }
    long l = System.currentTimeMillis();
    if ((!this.bMN) || (this.bMO)) {}
    for (boolean bool = true;; bool = false)
    {
      paramLong1 = paramLong2 - paramLong1;
      paramLong2 = paramLong3 - paramLong2;
      paramLong3 = l - paramLong3;
      l = paramLong1 + paramLong2 + paramLong3;
      if ((!bQ(paramLong1)) || (!bQ(paramLong2)) || (!bQ(paramLong3)) || (!bQ(l))) {
        break;
      }
      QLog.d("ScanEntranceReport", 2, String.format("reportARCloudFirstUpload firstInit=%s startDelay=%s firstSelectTime=%s firstUploadDelay=%s totalTime=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(l) }));
      ThreadManager.post(new ScanEntranceReport.4(this, bool, paramLong1, paramLong2, paramLong3, paramInt, l), 5, null, false);
      return;
    }
  }
  
  public void reset()
  {
    this.bMN = false;
    this.bMO = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adfx
 * JD-Core Version:    0.7.0.1
 */