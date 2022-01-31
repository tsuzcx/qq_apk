import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.system.Os;
import android.system.OsConstants;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import org.jetbrains.annotations.NotNull;

public class zrc
{
  private static long jdField_a_of_type_Long = a(0L);
  public static Vector<zrf> a;
  @Nullable
  private static volatile zrc jdField_a_of_type_Zrc;
  @Nullable
  private static volatile zrf jdField_a_of_type_Zrf;
  @NonNull
  private static zri jdField_a_of_type_Zri = new zri();
  public static Vector<zrk> b;
  
  static
  {
    jdField_a_of_type_JavaUtilVector = new Vector();
    b = new Vector();
  }
  
  @SuppressLint({"ObsoleteSdkInt"})
  public static long a(long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      try
      {
        long l2 = Os.sysconf(OsConstants._SC_PAGESIZE);
        l1 = l2;
        if (l2 <= 0L) {
          l1 = Os.sysconf(OsConstants._SC_PAGE_SIZE);
        }
      }
      catch (Exception localException)
      {
        l1 = 0L;
        continue;
      }
      if (l1 > 0L) {
        paramLong = l1;
      }
      return paramLong;
      long l1 = paramLong;
    }
  }
  
  @Nullable
  public static zrc a()
  {
    if (jdField_a_of_type_Zrc == null) {}
    try
    {
      if (jdField_a_of_type_Zrc == null) {
        jdField_a_of_type_Zrc = new zrc();
      }
      return jdField_a_of_type_Zrc;
    }
    finally {}
  }
  
  @NonNull
  private zre a()
  {
    zre localzre = new zre(this, null);
    try
    {
      long[] arrayOfLong = jdField_a_of_type_Zri.a();
      if (arrayOfLong != null)
      {
        zre.a(localzre, arrayOfLong[0]);
        zre.b(localzre, arrayOfLong[1]);
        zre.c(localzre, arrayOfLong[2]);
        zre.d(localzre, arrayOfLong[4]);
      }
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MagnifierSDK", 2, "collectStatInfo: Failed. info: exception: ", localException);
    }
    return localzre;
    return localzre;
  }
  
  @SuppressLint({"ObsoleteSdkInt"})
  public static long b(long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      try
      {
        l = Os.sysconf(OsConstants._SC_CLK_TCK);
        if (l > 0L) {
          paramLong = l;
        }
        return paramLong;
      }
      catch (Exception localException)
      {
        l = 0L;
        continue;
      }
      long l = paramLong;
    }
  }
  
  @NotNull
  private zrf b()
  {
    double d2 = 0.0D;
    zrf localzrf = new zrf();
    localzrf.f = System.currentTimeMillis();
    localzrf.jdField_a_of_type_Long = (localzrf.f / 1000L);
    Object localObject;
    long l1;
    double d1;
    if (zrh.a().a())
    {
      localObject = a();
      if ((zre.a((zre)localObject) == 9223372036854775807L) || (zre.b((zre)localObject) == 9223372036854775807L) || (zre.c((zre)localObject) == 9223372036854775807L) || (zre.d((zre)localObject) == 9223372036854775807L)) {
        return null;
      }
      localzrf.c = zre.a((zre)localObject);
      localzrf.d = zre.b((zre)localObject);
      localzrf.e = zre.c((zre)localObject);
      localzrf.jdField_b_of_type_Long = (zre.d((zre)localObject) * jdField_a_of_type_Long);
      if (jdField_a_of_type_Zrf == null) {
        break label467;
      }
      jdField_a_of_type_Zrf.f = localzrf.f;
      jdField_a_of_type_Zrf.jdField_a_of_type_Long = localzrf.jdField_a_of_type_Long;
      if ((jdField_a_of_type_Zrf.c == 9223372036854775807L) || (jdField_a_of_type_Zrf.d == 9223372036854775807L) || (jdField_a_of_type_Zrf.e == 9223372036854775807L)) {
        break label452;
      }
      l1 = localzrf.c;
      long l2 = jdField_a_of_type_Zrf.c;
      long l3 = localzrf.d - jdField_a_of_type_Zrf.d;
      long l4 = localzrf.e;
      long l5 = jdField_a_of_type_Zrf.e;
      if (l3 > 0L)
      {
        localzrf.jdField_a_of_type_Double = ((l1 - l2) * 1.0D / l3);
        localzrf.jdField_b_of_type_Double = ((l4 - l5) * 1.0D / l3);
      }
      if (localzrf.jdField_a_of_type_Double <= 0.0D) {
        break label447;
      }
      d1 = localzrf.jdField_a_of_type_Double;
      label310:
      localzrf.jdField_a_of_type_Double = d1;
      d1 = d2;
      if (localzrf.jdField_b_of_type_Double > 0.0D) {
        d1 = localzrf.jdField_b_of_type_Double;
      }
      localzrf.jdField_b_of_type_Double = d1;
      label340:
      jdField_a_of_type_Zrf.c = localzrf.c;
      jdField_a_of_type_Zrf.d = localzrf.d;
      jdField_a_of_type_Zrf.e = localzrf.e;
    }
    for (;;)
    {
      return localzrf;
      localObject = new ajma();
      MemoryManager.a(Process.myPid(), (ajma)localObject);
      localzrf.jdField_b_of_type_Long = ((ajma)localObject).jdField_a_of_type_Long;
      l1 = b(10L);
      localzrf.c = (Process.getElapsedCpuTime() / l1);
      localzrf.d = (SystemClock.elapsedRealtime() / l1);
      localzrf.e = (SystemClock.uptimeMillis() / l1);
      break;
      label447:
      d1 = 0.0D;
      break label310;
      label452:
      localzrf.jdField_a_of_type_Double = 0.0D;
      localzrf.jdField_b_of_type_Double = 0.0D;
      break label340;
      label467:
      jdField_a_of_type_Zrf = new zrf();
      jdField_a_of_type_Zrf.f = localzrf.f;
      jdField_a_of_type_Zrf.jdField_a_of_type_Long = localzrf.jdField_a_of_type_Long;
      jdField_a_of_type_Zrf.c = localzrf.c;
      jdField_a_of_type_Zrf.d = localzrf.d;
      jdField_a_of_type_Zrf.e = localzrf.e;
      localzrf.jdField_a_of_type_Double = 0.0D;
      localzrf.jdField_b_of_type_Double = 0.0D;
    }
  }
  
  public zrf a()
  {
    zrf localzrf = b();
    if (localzrf != null) {
      jdField_a_of_type_JavaUtilVector.add(localzrf);
    }
    return localzrf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zrc
 * JD-Core Version:    0.7.0.1
 */