package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public final class i
{
  private static volatile String a = "209";
  private static volatile String b = "fc_sdk";
  private static final Comparator<Object> c = new i.1();
  
  public static String a(aj paramaj, Location paramLocation, List<ScanResult> paramList, List<b> paramList1, boolean paramBoolean)
  {
    int i;
    int j;
    if (paramList != null)
    {
      try
      {
        i = paramList.size();
        if (paramList1 == null) {
          break label1018;
        }
        j = paramList1.size();
      }
      catch (Throwable paramaj)
      {
        label27:
        StringBuilder localStringBuilder2;
        StringBuilder localStringBuilder3;
        StringBuilder localStringBuilder4;
        StringBuilder localStringBuilder1;
        Object localObject1;
        label253:
        long l;
        label338:
        label506:
        ai.a("DCUtils", "get write string error!", paramaj);
        label406:
        label429:
        return "";
      }
      localStringBuilder2 = new StringBuilder();
      localStringBuilder3 = new StringBuilder();
      localStringBuilder4 = new StringBuilder();
      localStringBuilder1 = new StringBuilder();
      localStringBuilder2.append(0).append(",").append(String.format(Locale.ENGLISH, "%.6f", new Object[] { Double.valueOf(paramLocation.getLatitude()) })).append(",").append(String.format(Locale.ENGLISH, "%.6f", new Object[] { Double.valueOf(paramLocation.getLongitude()) })).append(",").append((int)paramLocation.getAltitude()).append(",").append((int)paramLocation.getAccuracy()).append(",").append((int)paramLocation.getBearing()).append(",").append(String.format(Locale.ENGLISH, "%.1f", new Object[] { Float.valueOf(paramLocation.getSpeed()) })).append(",").append(paramLocation.getTime());
      if (!ai.a(paramList1))
      {
        j = 0;
        while (j < paramList1.size())
        {
          localObject1 = (b)paramList1.get(j);
          if (j != 0) {
            break label1024;
          }
          paramLocation = "";
          paramLocation = localStringBuilder3.append(paramLocation).append(((b)localObject1).a).append(",").append(((b)localObject1).b).append(",").append(((b)localObject1).c).append(",").append(((b)localObject1).e).append(",").append(((b)localObject1).d).append(",");
          if (j != 0) {
            break label1037;
          }
          if (!paramBoolean) {
            break label1031;
          }
          i = 1;
          paramLocation.append(i).append(",").append(((b)localObject1).f);
          j += 1;
        }
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = paramList.toArray();
        Arrays.sort(paramList, c);
        l = SystemClock.elapsedRealtime() / 1000L;
        i = 0;
        if (i < paramList.length)
        {
          paramList1 = (ScanResult)paramList[i];
          if (i != 0) {
            break label1063;
          }
          paramLocation = "";
          localStringBuilder4.append(paramLocation).append(paramList1.BSSID.replaceAll(":", "").toLowerCase()).append("&").append(paramList1.level);
          if (Build.VERSION.SDK_INT < 17) {
            break label1054;
          }
          j = -1;
          if (paramList1.timestamp <= 0L) {
            break label1043;
          }
          j = (int)(l - paramList1.timestamp / 1000L / 1000L);
          break label1043;
          localStringBuilder1.append(paramLocation).append(j);
          break label1054;
        }
      }
      paramLocation = new StringBuilder();
      paramList = l.a();
      if (paramList != null)
      {
        i = paramList.length();
        if (i <= 5) {}
      }
    }
    for (;;)
    {
      try
      {
        paramList = new JSONObject(paramList);
        paramLocation.append(paramList.optString("mac").replaceAll(":", "").toLowerCase()).append("&").append(paramList.optString("ssid")).append("&").append(paramList.optString("rssi"));
        if (paramLocation.length() < 5) {
          paramLocation.setLength(0);
        }
        paramList = aj.a(paramaj.b).replaceAll("[| _]", "");
        paramList = paramList + "_" + aj.a(paramaj.a);
        paramList1 = aj.a(Build.MANUFACTURER).replaceAll("[| _]", "");
        paramList1 = paramList1 + "_" + aj.a(an.g()).replaceAll("[| _]", "");
        localObject1 = new StringBuilder();
        Object localObject2 = ae.a("yyyy-MM-dd HH:mm:ss");
        localObject2 = ((StringBuilder)localObject1).append("[").append(((SimpleDateFormat)localObject2).format(new Date())).append("]:1.7.1|").append(a).append("|").append(aj.a(paramaj.c)).append("|");
        if (h.d)
        {
          paramaj = k.a();
          localObject2 = ((StringBuilder)localObject2).append(paramaj).append("|");
          if (!h.d) {
            break label1075;
          }
          paramaj = k.c();
          paramLocation = ((StringBuilder)localObject2).append(paramaj).append("|||||||").append(localStringBuilder2).append("||").append(localStringBuilder3).append("|").append(localStringBuilder4).append("||||||||||||||||").append(b).append("||||").append(paramLocation).append("||");
          if (!h.d) {
            break label985;
          }
          paramaj = k.d().replaceAll(":", "").toLowerCase();
          paramLocation.append(paramaj).append("|").append(paramList).append("|||").append(paramList1).append("||||||||||||").append(localStringBuilder1.toString()).append("|");
          return ((StringBuilder)localObject1).toString();
        }
      }
      catch (Throwable paramList)
      {
        paramLocation.setLength(0);
        continue;
      }
      paramaj = "";
      continue;
      label985:
      paramaj = "";
      continue;
      for (;;)
      {
        if ((paramaj != null) && (paramLocation != null) && ((i != 0) || (j != 0))) {
          break label1022;
        }
        return "";
        i = 0;
        break;
        label1018:
        j = 0;
      }
      label1022:
      break label27;
      label1024:
      paramLocation = ";";
      break label253;
      label1031:
      i = 0;
      break label338;
      label1037:
      i = -1;
      break label338;
      label1043:
      if (i == 0)
      {
        paramLocation = "";
        break label506;
        label1054:
        i += 1;
        break label406;
        label1063:
        paramLocation = "&";
        break label429;
      }
      paramLocation = "&";
      break label506;
      label1075:
      paramaj = "";
    }
  }
  
  public static void a(String paramString)
  {
    b = paramString;
  }
  
  public static void b(String paramString)
  {
    a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.i
 * JD-Core Version:    0.7.0.1
 */