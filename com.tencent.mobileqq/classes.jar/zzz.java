import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.Display;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.step.AutomatorFinish;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

@TargetApi(16)
public class zzz
{
  private static long jdField_a_of_type_Long;
  private static zzz jdField_a_of_type_Zzz;
  private int jdField_a_of_type_Int;
  private aaac jdField_a_of_type_Aaac;
  private Choreographer.FrameCallback jdField_a_of_type_AndroidViewChoreographer$FrameCallback;
  private Choreographer jdField_a_of_type_AndroidViewChoreographer;
  private final RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(aaac.class, 4);
  private AbstractUnifiedMonitor.ThreadMonitorCallback jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback = new aaab(this);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long d;
  
  @TargetApi(17)
  private float a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    if (Build.VERSION.SDK_INT >= 17) {
      try
      {
        float f = ((DisplayManager)localBaseApplicationImpl.getSystemService("display")).getDisplay(0).getRefreshRate();
        return f;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AutoMonitor.DropFrame", 2, "", localException);
        }
      }
    }
    return 60.0F;
  }
  
  private final int a(int paramInt)
  {
    int i = 1;
    if (paramInt <= 0) {
      i = 0;
    }
    while (paramInt == 1) {
      return i;
    }
    if (paramInt < 4) {
      return 2;
    }
    if (paramInt < 8) {
      return 3;
    }
    if (paramInt < 15) {
      return 4;
    }
    return 5;
  }
  
  private final long a(long paramLong)
  {
    return paramLong / 1000000L;
  }
  
  public static zzz a()
  {
    if (jdField_a_of_type_Zzz == null) {}
    try
    {
      if (jdField_a_of_type_Zzz == null) {
        jdField_a_of_type_Zzz = new zzz();
      }
      return jdField_a_of_type_Zzz;
    }
    finally {}
  }
  
  public static void a()
  {
    jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  private boolean a()
  {
    return 1 == BaseApplicationImpl.sProcessId;
  }
  
  private boolean b()
  {
    return 2 == BaseApplicationImpl.sProcessId;
  }
  
  private void d()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Aaac == null)
    {
      this.jdField_a_of_type_AndroidViewChoreographer.removeFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
      this.d = 0L;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public int a()
  {
    return UnifiedMonitor.a().getThreshold(9);
  }
  
  public void a(long paramLong)
  {
    long l = paramLong - this.d;
    if (this.jdField_a_of_type_Aaac != null)
    {
      if (this.jdField_a_of_type_Aaac.jdField_b_of_type_Long == 0L) {
        this.jdField_a_of_type_Aaac.jdField_b_of_type_Long = paramLong;
      }
    }
    else if ((a()) && (this.jdField_b_of_type_Boolean))
    {
      if ((this.d == 0L) || (l <= this.jdField_b_of_type_Long)) {
        break label225;
      }
      if (UnifiedMonitor.a().whetherReportThisTime(10)) {
        break label186;
      }
      this.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      if (UnifiedMonitor.a().whetherStackEnabled(10)) {
        UnifiedMonitor.a().reportStackIfTimeout(10);
      }
      this.d = paramLong;
      this.jdField_a_of_type_AndroidViewChoreographer.postFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
      return;
      int i = a((int)((l - this.jdField_c_of_type_Long) / this.jdField_c_of_type_Long));
      Object localObject = this.jdField_a_of_type_Aaac;
      ((aaac)localObject).jdField_a_of_type_Long += 1L;
      localObject = this.jdField_a_of_type_Aaac.jdField_a_of_type_ArrayOfLong;
      localObject[i] += 1L;
      this.jdField_a_of_type_Aaac.jdField_c_of_type_Long = paramLong;
      break;
      label186:
      localObject = UnifiedMonitor.a();
      UnifiedMonitor.a().addEvent(10, null, (int)a(paramLong - this.d), this.jdField_a_of_type_Int, (Map)localObject);
      this.jdField_a_of_type_Int = 0;
      continue;
      label225:
      if (UnifiedMonitor.a().whetherStackEnabled(10)) {
        UnifiedMonitor.a().notifyNotTimeout(10);
      }
      this.jdField_a_of_type_Int += 1;
    }
  }
  
  public void a(String paramString)
  {
    if (!aabg.jdField_a_of_type_Boolean) {
      if (UnifiedMonitor.a().whetherReportDuringThisStartup(9)) {}
    }
    while ((!this.jdField_a_of_type_Boolean) || ((this.jdField_a_of_type_Aaac != null) && (this.jdField_a_of_type_Aaac.jdField_a_of_type_JavaLangString.equals(paramString)))) {
      do
      {
        return;
      } while (!UnifiedMonitor.a().whetherReportThisTime(9));
    }
    if (paramString.equals("qzone_homepage")) {
      aabg.a().a(0, 1, 1, 0, 1500, 701, 32L, Process.myTid(), "qzoneList", false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aaac = ((aaac)this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(aaac.class));
      this.jdField_a_of_type_Aaac.jdField_a_of_type_JavaLangString = paramString;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidViewChoreographer.removeFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
        this.jdField_a_of_type_AndroidViewChoreographer.postFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
      }
      this.jdField_c_of_type_Boolean = true;
      return;
      if (paramString.equals("list_photo")) {
        aabg.a().a(0, 1, 1, 0, 1500, 702, 32L, Process.myTid(), "photoList", false);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    long l1;
    HashMap localHashMap;
    String str1;
    String str2;
    String str3;
    String str4;
    if (this.jdField_a_of_type_Aaac != null) {
      if (!paramBoolean)
      {
        l1 = a(this.jdField_a_of_type_Aaac.jdField_c_of_type_Long - this.jdField_a_of_type_Aaac.jdField_b_of_type_Long);
        if ((this.jdField_a_of_type_Aaac.jdField_a_of_type_Long > 0L) && (l1 > a()))
        {
          long l2 = (this.jdField_a_of_type_Aaac.jdField_c_of_type_Long - this.jdField_a_of_type_Aaac.jdField_b_of_type_Long) / this.jdField_c_of_type_Long + 1L - this.jdField_a_of_type_Aaac.jdField_a_of_type_Long;
          bhwh.a().a(paramString, l2, this.jdField_a_of_type_Aaac.jdField_a_of_type_ArrayOfLong, l1);
          if (QLog.isColorLevel()) {
            Log.d("AutoMonitor.DropFrame", "tag = " + paramString + ", dropCount = " + l2 + ", " + Arrays.toString(this.jdField_a_of_type_Aaac.jdField_a_of_type_ArrayOfLong) + ", totalMs = " + l1);
          }
          if (b()) {}
          double d1 = this.jdField_a_of_type_Aaac.jdField_a_of_type_ArrayOfLong[4];
          double d2 = this.jdField_a_of_type_Aaac.jdField_a_of_type_ArrayOfLong[5];
          double d3 = this.jdField_a_of_type_Aaac.jdField_a_of_type_ArrayOfLong[0];
          double d4 = this.jdField_a_of_type_Aaac.jdField_a_of_type_ArrayOfLong[1];
          double d5 = this.jdField_a_of_type_Aaac.jdField_a_of_type_ArrayOfLong[2];
          double d6 = this.jdField_a_of_type_Aaac.jdField_a_of_type_ArrayOfLong[3];
          localHashMap = new HashMap(10);
          localHashMap.put("dropCount", String.valueOf(l2));
          localHashMap.put("totalMs", String.valueOf(l1));
          localHashMap.put("scene", this.jdField_a_of_type_Aaac.jdField_a_of_type_JavaLangString);
          localHashMap.put("dropTimes", Arrays.toString(this.jdField_a_of_type_Aaac.jdField_a_of_type_ArrayOfLong));
          localHashMap.put("themeId", QQAppInterface.d());
          localHashMap.put("isFirstLaunch", String.valueOf(BaseApplicationImpl.isFirstLaunchNew));
          if (jdField_a_of_type_Long <= 0L) {
            break label730;
          }
          l1 = SystemClock.uptimeMillis() - jdField_a_of_type_Long;
          localHashMap.put("intervalAfterSyncMsg", String.valueOf(l1));
          localHashMap.put("hcState", String.valueOf(aabg.a().a()));
          localHashMap.put("dropFenzi", String.valueOf(266.72000000000003D * d2 + 200.04000000000002D * d1));
          localHashMap.put("dropFenzi2", String.valueOf(100.19999999999999D * d6 + (16.699999999999999D * d3 + 25.049999999999997D * d4 + 50.099999999999994D * d5)));
          if (axnx.j)
          {
            str1 = "-1";
            str2 = "-1";
            str3 = "-1";
            str4 = "-1";
            l1 = System.currentTimeMillis();
            if (AutomatorFinish.jdField_a_of_type_Long != -1L) {
              break label738;
            }
          }
        }
      }
    }
    label730:
    label738:
    for (paramString = "-1";; paramString = String.valueOf(l1 - AutomatorFinish.jdField_a_of_type_Long))
    {
      if (axnx.e != 0L) {
        str1 = String.valueOf(l1 - axnx.e);
      }
      if (axnx.d != 0L) {
        str2 = String.valueOf(l1 - axnx.d);
      }
      if (axnx.g != 0L) {
        str3 = String.valueOf(l1 - axnx.g);
      }
      if (axnx.f != 0L) {
        str4 = String.valueOf(l1 - axnx.f);
      }
      localHashMap.put("perfConfigReportValue", String.valueOf(axnx.c));
      localHashMap.put("qZoneInterval", str1);
      localHashMap.put("miniInterval", str2);
      localHashMap.put("troopListInterval", str3);
      localHashMap.put("preDownloadInterval", str4);
      localHashMap.put("automatorFinishtime", paramString);
      UnifiedMonitor.a().addEvent(9, null, 0, 0, localHashMap);
      aaai.a().a(localHashMap);
      this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(this.jdField_a_of_type_Aaac);
      this.jdField_a_of_type_Aaac = null;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidViewChoreographer.removeFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
        this.d = 0L;
      }
      this.jdField_c_of_type_Boolean = false;
      return;
      l1 = -1L;
      break;
    }
  }
  
  @Deprecated
  public void b()
  {
    QLog.d("AutoMonitor.DropFrame", 1, "prepare");
    UnifiedMonitor.a().b();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean) {}
    float f;
    do
    {
      do
      {
        return;
        if (Build.VERSION.SDK_INT >= 16) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AutoMonitor.DropFrame", 2, "build version is low");
      return;
      f = a();
      if ((f >= 58.0F) && (f <= 62.0F)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AutoMonitor.DropFrame", 2, "refresh rate is valid, " + f);
    return;
    try
    {
      this.jdField_a_of_type_AndroidViewChoreographer = Choreographer.getInstance();
      this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback = new aaaa(this);
      this.jdField_c_of_type_Long = ((1.0E+009F / f));
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException) {}
  }
  
  public String toString()
  {
    if (this.jdField_c_of_type_Boolean) {
      return "y";
    }
    return "n";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zzz
 * JD-Core Version:    0.7.0.1
 */