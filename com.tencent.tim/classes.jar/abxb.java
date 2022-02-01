import com.tencent.mobileqq.apollo.trace.sdk.data.TraceData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class abxb
  implements abwu
{
  private static int ctm = 3;
  public static int ctn = 30000;
  private static int cto = 10000;
  private long OO = System.currentTimeMillis() - 540000L;
  private abwi a;
  private boolean bGb = true;
  private int ctp;
  private int ctq;
  private long ib;
  private boolean mActive = true;
  private List<TraceData> wG = new ArrayList();
  
  private void b(TraceData paramTraceData)
  {
    if ((paramTraceData == null) || (paramTraceData.result == null)) {}
    do
    {
      return;
      l1 = System.currentTimeMillis();
      if (l1 - this.OO < 1000L)
      {
        paramTraceData.result.cth = this.ctp;
        paramTraceData.result.cti = this.ctq;
        return;
      }
    } while ((l1 - this.OO <= 600000L) && ((!paramTraceData.isSampleFocus) || (l1 - this.OO <= 300000L)));
    this.OO = l1;
    long l1 = System.currentTimeMillis();
    this.ctp = abwp.getMemoryInfo();
    this.ctq = abwp.jM();
    long l2 = System.currentTimeMillis();
    QLog.i("TraceReport", 1, "samplingCpuAndMemory cpu:" + this.ctq + ",memory:" + this.ctp + ",isSampleFocus:" + paramTraceData.isSampleFocus + ",cost:" + (l2 - l1));
    paramTraceData.result.cth = this.ctp;
    paramTraceData.result.cti = this.ctq;
  }
  
  private void ik(List<TraceData> paramList)
  {
    abwv localabwv = this.a.a();
    if (localabwv != null) {
      localabwv.ae(paramList);
    }
  }
  
  public boolean a(TraceData paramTraceData)
  {
    long l1 = System.currentTimeMillis();
    b(paramTraceData);
    this.wG.add(paramTraceData);
    if (this.mActive)
    {
      boolean bool2 = aqiw.isNetworkAvailable(null);
      long l2 = l1 - this.ib;
      int i = this.wG.size();
      if ((paramTraceData.result != null) && (paramTraceData.result.errCode != 0) && (this.bGb))
      {
        bool1 = true;
        if (((i < ctm) || (l2 <= cto)) && (((l2 <= ctn) && (!bool1)) || (!bool2))) {
          break label254;
        }
        ii(this.wG);
        ik(this.wG);
        this.wG.clear();
        long l3 = System.currentTimeMillis();
        this.ib = l3;
        if (QLog.isColorLevel()) {
          QLog.d("TraceReport", 2, new Object[] { "handleAddTraceReporting interval:", Long.valueOf(l2), ",reportSize:", Integer.valueOf(i), ",report all cost:", Long.valueOf(l3 - l1), ",isFailReport:", Boolean.valueOf(bool1) });
        }
      }
      for (boolean bool1 = false;; bool1 = true)
      {
        if ((!bool2) && (QLog.isColorLevel())) {
          QLog.d("TraceReport", 2, "handleAddTraceReporting not network and save");
        }
        return bool1;
        bool1 = false;
        break;
        label254:
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramTraceData);
        ij(localArrayList);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TraceReport", 2, "handleAddTraceReporting not active and save");
    }
    ij(this.wG);
    return false;
  }
  
  public void c(abwi paramabwi)
  {
    this.a = paramabwi;
    paramabwi = this.a.a();
    if (paramabwi != null) {
      paramabwi.a(this);
    }
    this.ib = System.currentTimeMillis();
    this.mActive = true;
  }
  
  public void cFR()
  {
    Object localObject = this.a.a();
    if (localObject != null)
    {
      localObject = ((abwv)localObject).dH();
      if (localObject != null) {
        this.wG = ((List)localObject);
      }
    }
  }
  
  public void cFS()
  {
    int i = this.wG.size();
    boolean bool = aqiw.isNetworkAvailable(null);
    if ((i <= 0) || (!bool) || (!this.mActive)) {
      if (QLog.isColorLevel()) {
        QLog.d("TraceReport", 2, new Object[] { "flushDelayReport reportSize:", Integer.valueOf(i), ", net:", Boolean.valueOf(bool), ",mActive:", Boolean.valueOf(this.mActive) });
      }
    }
    do
    {
      return;
      ii(this.wG);
      ik(this.wG);
      this.wG.clear();
      this.ib = System.currentTimeMillis();
    } while (!QLog.isColorLevel());
    QLog.d("TraceReport", 2, new Object[] { "handleAddTraceReporting flushDelayReport reportSize:", Integer.valueOf(i) });
  }
  
  public void ii(List<TraceData> paramList)
  {
    abwt localabwt = this.a.a();
    if (localabwt != null)
    {
      localabwt.ig(paramList);
      localabwt.ih(paramList);
    }
  }
  
  public void ij(List<TraceData> paramList)
  {
    abwv localabwv = this.a.a();
    if (localabwv != null) {
      localabwv.ad(paramList);
    }
  }
  
  public void onDestroy()
  {
    this.mActive = false;
    ij(this.wG);
  }
  
  public void w(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TraceReport", 2, new Object[] { "onReportStrategyChange reportInterval:", Integer.valueOf(paramInt1), ",reportNum:", Integer.valueOf(paramInt2), ", isFailReport:", Boolean.valueOf(paramBoolean) });
    }
    if (paramInt1 > 0) {
      ctn = paramInt1 * 1000;
    }
    if (paramInt2 > 0) {
      ctm = paramInt2;
    }
    this.bGb = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abxb
 * JD-Core Version:    0.7.0.1
 */