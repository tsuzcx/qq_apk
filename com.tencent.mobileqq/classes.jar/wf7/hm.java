package wf7;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.util.Pair;
import com.tencent.qqpimsecure.wificore.api.event.CurrentSessionItem;
import com.tencent.qqpimsecure.wificore.api.event.b;
import com.tencent.wifisdk.TMSDKFreeWifiInfo;
import java.util.List;

public class hm
{
  private static final String TAG = "hm";
  
  public static int a(@NonNull bl parambl)
  {
    int j = parambl.J();
    int i = 3;
    if ((j != 1) && (j != 2))
    {
      if (j == 3) {
        return 2;
      }
      if (j == 4) {
        return 3;
      }
      if (j == 5) {
        return 4;
      }
      if (j == 6) {
        return 5;
      }
    }
    else
    {
      i = 1;
    }
    return i;
  }
  
  public static Pair<Boolean, String> b(@NonNull bl parambl)
  {
    int i = parambl.I();
    String str = "";
    boolean bool1;
    if (i == 5)
    {
      boolean bool2 = true;
      d locald = parambl.R();
      bool1 = bool2;
      parambl = str;
      if (locald != null)
      {
        parambl = locald.X;
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
      parambl = str;
    }
    return new Pair(Boolean.valueOf(bool1), parambl);
  }
  
  public static boolean d(@NonNull bn parambn)
  {
    return parambn.ad().I() >= 2;
  }
  
  public static bq fq()
  {
    return (bq)ao.c().i(1);
  }
  
  public static bk fr()
  {
    return (bk)ao.c().i(2);
  }
  
  public static b fs()
  {
    return (b)ao.c().i(3);
  }
  
  public static com.tencent.qqpimsecure.wificore.api.connect.d ft()
  {
    return (com.tencent.qqpimsecure.wificore.api.connect.d)ao.c().i(4);
  }
  
  public static boolean fu()
  {
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = true;
    fq().a(new hm.1(arrayOfBoolean));
    return arrayOfBoolean[0];
  }
  
  public static List<bn> fv()
  {
    return fr().s(2);
  }
  
  public static int fw()
  {
    if (!dj.e(gv.dE())) {
      return -1;
    }
    if (!dj.g(gv.dE())) {
      return -3;
    }
    return -4;
  }
  
  public static bn g(CurrentSessionItem paramCurrentSessionItem)
  {
    if (paramCurrentSessionItem == null) {
      return null;
    }
    return fq().a(paramCurrentSessionItem.ey, paramCurrentSessionItem.eV);
  }
  
  public static TMSDKFreeWifiInfo h(@NonNull CurrentSessionItem paramCurrentSessionItem)
  {
    bn localbn = fq().a(paramCurrentSessionItem.ey, paramCurrentSessionItem.eV);
    if (localbn != null) {
      return x(localbn);
    }
    return new TMSDKFreeWifiInfo(paramCurrentSessionItem.ey, paramCurrentSessionItem.eV);
  }
  
  public static boolean v(@NonNull bn parambn)
  {
    int i = parambn.ab();
    return (i == 0) || (i == -1);
  }
  
  public static boolean w(@NonNull bn parambn)
  {
    int i = parambn.ad().L();
    return (ck.m(i, parambn.ab())) || (ck.P(i)) || (ck.Q(i)) || (i == 2) || (i == 4) || (i == 5) || (i == 6) || (i == 7) || (i == 8) || (i == 9) || (i == 10) || (i == 13) || (i == 12) || (i == 16) || (i == 18) || (i == 21);
  }
  
  public static TMSDKFreeWifiInfo x(@NonNull bn parambn)
  {
    TMSDKFreeWifiInfo localTMSDKFreeWifiInfo = new TMSDKFreeWifiInfo();
    localTMSDKFreeWifiInfo.ssid = parambn.Z();
    localTMSDKFreeWifiInfo.bssid = parambn.aa();
    localTMSDKFreeWifiInfo.security = parambn.ab();
    localTMSDKFreeWifiInfo.signalLevel = z(parambn.ac().getLevel(), 4);
    parambn = parambn.ad();
    localTMSDKFreeWifiInfo.starLevel = a(parambn);
    localTMSDKFreeWifiInfo.poi = parambn.N();
    parambn = b(parambn);
    if (((Boolean)parambn.first).booleanValue())
    {
      localTMSDKFreeWifiInfo.isBestWiFi = true;
      localTMSDKFreeWifiInfo.recommendReason = ((String)parambn.second);
    }
    return localTMSDKFreeWifiInfo;
  }
  
  public static int z(@IntRange(from=0L, to=100L) int paramInt1, @IntRange(from=4L, to=5L) int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= 100)) {
      return paramInt1 / (100 / (paramInt2 - 1));
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.hm
 * JD-Core Version:    0.7.0.1
 */