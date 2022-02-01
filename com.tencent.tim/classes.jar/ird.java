import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.perfstat.MemoryPerfStat.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ird
  implements Handler.Callback
{
  private static ird jdField_a_of_type_Ird;
  private String PP;
  private final auru jdField_a_of_type_Auru = new auru(Looper.getMainLooper(), this);
  private int ash;
  private long mF = aqgz.getSystemTotalMemory() / 124L;
  private int mFlag;
  private long mG;
  private final HashMap<String, ird.a> mMap = new HashMap(5);
  private int mState = 0;
  private final int[] mTemp = new int[1];
  
  public static ird a()
  {
    if (jdField_a_of_type_Ird == null) {
      jdField_a_of_type_Ird = new ird();
    }
    return jdField_a_of_type_Ird;
  }
  
  private void apE()
  {
    String str = igv.a().a().peerUin;
    this.PP = hc();
    if (QLog.isColorLevel()) {
      QLog.i("MemoryPerfStat", 2, String.format("updatePerfInfo, peer[%s], key[%s], value[%s]", new Object[] { str, "PerfInfo", this.PP }));
    }
    if (!TextUtils.isEmpty(str)) {
      VideoController.a().a(str, "PerfInfo", this.PP);
    }
  }
  
  public static void bJ(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramInt1 != 0);
      a().start();
      return;
    } while (paramInt1 == 0);
    a().stop();
  }
  
  @TargetApi(23)
  private void bt(Context paramContext)
  {
    long l2 = SystemClock.elapsedRealtime();
    if (paramContext == null) {}
    for (;;)
    {
      return;
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext == null) {
        continue;
      }
      this.ash += 1;
      this.mTemp[0] = Process.myPid();
      try
      {
        paramContext = paramContext.getProcessMemoryInfo(this.mTemp);
        if ((paramContext != null) && (paramContext.length > 0))
        {
          paramContext = paramContext[0];
          if (paramContext == null) {
            continue;
          }
          if (Build.VERSION.SDK_INT >= 23)
          {
            paramContext = paramContext.getMemoryStats();
            localIterator = paramContext.keySet().iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              str1 = (String)localIterator.next();
              str2 = (String)paramContext.get(str1);
            } while ((str2 == null) || (str2.length() == 0));
          }
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          Iterator localIterator;
          String str1;
          try
          {
            String str2;
            l1 = Long.parseLong(str2);
            if (l1 == 0L) {
              continue;
            }
            s(str1, l1);
            continue;
            paramContext = paramContext;
            paramContext = null;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            l1 = 0L;
            continue;
          }
          s("summary.total-pss", paramContext.getTotalPss());
          s("summary.java-heap", paramContext.dalvikPrivateDirty);
          s("summary.native-heap", paramContext.nativePrivateDirty);
          long l1 = Math.abs(SystemClock.elapsedRealtime() - l2);
          if (this.mG == 0L) {
            this.mG = l1;
          }
          while (QLog.isColorLevel())
          {
            paramContext = new StringBuilder(200);
            paramContext.append("getMemoryInfoFromAM, cost[").append(l1).append("], avgCost[").append(this.mG).append("], cnt[").append(this.ash).append("], flag[").append(this.mFlag).append("], \n{");
            try
            {
              localIterator = this.mMap.keySet().iterator();
              while (localIterator.hasNext())
              {
                str1 = (String)localIterator.next();
                ird.a locala = (ird.a)this.mMap.get(str1);
                if (locala != null) {
                  paramContext.append(String.format("%s : [avg:%s, max: %s, min: %s]  KB \n", new Object[] { str1, Long.valueOf(locala.mJ), Long.valueOf(locala.mH), Long.valueOf(locala.mI) }));
                }
              }
              this.mG = ((this.mG + l1) / 2L);
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
              paramContext.append("}");
              QLog.i("MemoryPerfStat", 2, paramContext.toString());
              return;
            }
          }
          paramContext = null;
        }
      }
    }
  }
  
  private void s(String paramString, long paramLong)
  {
    if ((paramLong == 0L) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ird.a locala = (ird.a)this.mMap.get(paramString);
    if (locala == null)
    {
      locala = new ird.a(paramString, paramLong);
      this.mMap.put(paramString, locala);
      return;
    }
    locala.update(paramLong);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (this.mState == 1)) {
      ThreadManager.excute(new MemoryPerfStat.1(this), 16, null, false);
    }
    return true;
  }
  
  public String hc()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(this.mF);
    ird.a locala = (ird.a)this.mMap.get("summary.total-pss");
    if (locala != null) {
      localStringBuilder.append(';').append(locala.mJ).append(';').append(locala.mH).append(';').append(locala.mI).append(';').append(this.mFlag);
    }
    if (QLog.isColorLevel()) {
      QLog.i("MemoryPerfStat", 2, "getStatsInfo, [" + localStringBuilder.toString() + "]");
    }
    return localStringBuilder.toString();
  }
  
  public void lu(int paramInt)
  {
    if ((this.mFlag & 0x1) == 0) {
      this.mFlag |= 0x1;
    }
    if ((paramInt & 0x8) == 8)
    {
      if (!AEFilterSupport.uP()) {
        break label146;
      }
      if ((this.mFlag & 0x4) == 0) {
        this.mFlag |= 0x4;
      }
    }
    for (;;)
    {
      if (((paramInt & 0x10) == 16) && ((this.mFlag & 0x8) == 0)) {
        this.mFlag |= 0x8;
      }
      if (((paramInt & 0x20) == 32) && ((this.mFlag & 0x10) == 0)) {
        this.mFlag |= 0x10;
      }
      if (((paramInt & 0x100) == 256) && ((this.mFlag & 0x20) == 0)) {
        this.mFlag |= 0x20;
      }
      return;
      label146:
      if ((this.mFlag & 0x2) == 0) {
        this.mFlag |= 0x2;
      }
    }
  }
  
  public void start()
  {
    if (this.mState == 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MemoryPerfStat", 2, "start");
    }
    this.mState = 1;
    this.mFlag = 0;
    this.mMap.clear();
    this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(1, 200L);
  }
  
  public void stop()
  {
    if (this.mState != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MemoryPerfStat", 2, "stop");
    }
    this.mState = -1;
    this.jdField_a_of_type_Auru.removeMessages(1);
    this.PP = hc();
  }
  
  static class a
  {
    public long mH;
    public long mI;
    public long mJ;
    public final String tag;
    
    public a(String paramString, long paramLong)
    {
      this.tag = paramString;
      this.mH = paramLong;
      this.mI = paramLong;
      this.mJ = paramLong;
    }
    
    public void update(long paramLong)
    {
      if (this.mH < paramLong) {
        this.mH = paramLong;
      }
      if (this.mI > paramLong) {
        this.mI = paramLong;
      }
      this.mJ = ((this.mJ + paramLong) / 2L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ird
 * JD-Core Version:    0.7.0.1
 */