import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ProfilePerformanceReport.1;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class aurh
{
  public static aurh b;
  public static aurh c;
  private static final String[] iH = { "param_click2create", "param_first_draw", "param_first_show", "param_open", "param_run_delay", "param_init_data", "param_fetch_data", "param_prepare_res", "param_refresh_from_cache", "param_refresh_from_net" };
  private final long[] aN;
  private final long[] aO;
  private StringBuilder aa;
  private long ib;
  private int mState;
  private final String mTag;
  
  public static void ews() {}
  
  public static void ewt() {}
  
  public void Zy(String paramString)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    long l2 = 0L;
    long l1 = 0L;
    if (i <= 9)
    {
      label58:
      String str;
      if ((this.aO[i] != 0L) && (this.aN[i] != 0L))
      {
        l1 = this.aO[i] - this.aN[i];
        if (i == 3) {
          l2 = l1;
        }
        str = iH[i];
        if (l1 <= 0L) {
          break label107;
        }
      }
      label107:
      for (long l3 = l1;; l3 = 0L)
      {
        localHashMap.put(str, String.valueOf(l3));
        i += 1;
        break;
        l1 = 0L;
        break label58;
      }
    }
    this.ib = SystemClock.elapsedRealtime();
    this.mState = 1;
    if (QLog.isDevelopLevel())
    {
      this.aa.setLength(0);
      this.aa.append("reportPerformance, [").append(l1).append(",").append(localHashMap.toString()).append("]");
      QLog.i("ProfilePerformanceReport", 4, this.aa.toString());
    }
    ThreadManager.getSubThreadHandler().post(new ProfilePerformanceReport.1(this, paramString, l2, localHashMap));
  }
  
  public boolean aJB()
  {
    return (this.mState == 2) || (this.mState == 3);
  }
  
  public void aaY(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 9)) {}
    do
    {
      do
      {
        return;
      } while (this.aN[paramInt] != 0L);
      this.aN[paramInt] = SystemClock.elapsedRealtime();
      if (paramInt == 0)
      {
        this.mState = 2;
        this.aN[3] = this.aN[paramInt];
      }
    } while (!QLog.isDevelopLevel());
    this.aa.setLength(0);
    this.aa.append("markStart, [").append(iH[paramInt]).append(",").append(this.aN[paramInt]).append(",").append(this.mState).append("]");
    QLog.i("ProfilePerformanceReport", 4, this.aa.toString());
  }
  
  public void aaZ(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 9)) {}
    for (;;)
    {
      return;
      if ((this.aN[paramInt] != 0L) && (this.aO[paramInt] == 0L))
      {
        this.aO[paramInt] = SystemClock.elapsedRealtime();
        if (paramInt == 1)
        {
          this.aO[3] = this.aO[paramInt];
          this.mState = 3;
        }
        while (QLog.isDevelopLevel())
        {
          this.aa.setLength(0);
          this.aa.append("markEnd, [").append(iH[paramInt]).append(",").append(this.aO[paramInt]).append(",").append(this.aO[paramInt] - this.aN[paramInt]).append(",").append(this.mState).append("]");
          QLog.i("ProfilePerformanceReport", 4, this.aa.toString());
          return;
          if (paramInt == 9) {
            this.mState = 4;
          }
        }
      }
    }
  }
  
  public boolean bJ(boolean paramBoolean)
  {
    if (this.mState < 3) {}
    while ((this.mState != 4) && (!paramBoolean)) {
      return false;
    }
    return true;
  }
  
  public boolean mZ(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 9)) {}
    while ((this.aN[paramInt] == 0L) || (this.aO[paramInt] == 0L)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aurh
 * JD-Core Version:    0.7.0.1
 */