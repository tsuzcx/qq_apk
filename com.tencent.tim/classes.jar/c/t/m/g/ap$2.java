package c.t.m.g;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import java.util.concurrent.CountDownLatch;

final class ap$2
  implements Runnable
{
  ap$2(ap paramap) {}
  
  public final void run()
  {
    ap.a(this.a);
    ap localap = this.a;
    for (;;)
    {
      try
      {
        al localal = localap.b;
        PackageInfo localPackageInfo = localap.f();
        localal.i = localPackageInfo.versionCode;
        localal.h = localPackageInfo.versionName;
        localObject = localap.a.getApplicationInfo().loadLabel(localap.e);
        if (localObject == null) {
          continue;
        }
        localObject = ((CharSequence)localObject).toString();
        localal.j = ((String)localObject);
        localObject = localap.f;
        if (localObject != null)
        {
          localal.a = ((TelephonyManager)localObject).getPhoneType();
          localObject = ce.a("", ce.a);
          String str = ce.a("", ce.b);
          localap.i = ((String)localObject);
          localal.b = ((String)localObject);
          localal.c = str;
          localal.d = "";
        }
        localal.e = ce.a("", ce.c);
        localObject = localap.e;
        boolean bool1 = ((PackageManager)localObject).hasSystemFeature("android.hardware.location.gps");
        boolean bool2 = ((PackageManager)localObject).hasSystemFeature("android.hardware.wifi");
        boolean bool3 = ((PackageManager)localObject).hasSystemFeature("android.hardware.telephony");
        localal.n = bool1;
        localal.m = bool2;
        localal.l = bool3;
        new StringBuilder("doInBg: hasGps=").append(bool1).append(",hasWifi=").append(bool2).append(",hasCell=").append(bool3);
        new StringBuilder("os:").append(Build.MODEL).append(" ").append(Build.VERSION.RELEASE).append(" ").append(localal.a()).append(" net:").append(localPackageInfo.versionCode).append(" ").append(localPackageInfo.versionName).append(" sdk: ").append(localal.d()).append(" ").append(localal.e());
        localal.o = ap.b(localap.a);
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        continue;
      }
      ap.b(this.a).countDown();
      return;
      localObject = "unknown";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.ap.2
 * JD-Core Version:    0.7.0.1
 */