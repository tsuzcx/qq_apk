package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.util.Pair;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class bl
{
  public static int a = 0;
  public final bn b;
  public final bj c;
  public final bk d;
  
  public bl(bn parambn, bj parambj, bk parambk)
  {
    this.b = parambn;
    this.c = parambj;
    this.d = parambk;
  }
  
  private String a(int paramInt1, int paramInt2, String paramString, ap paramap, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramap == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject4;
        if (this.c == null)
        {
          bool = true;
          localObject1 = this.b;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label1118;
            localObject4 = cf.a(this.c, bool);
            localObject2 = this.d;
            if (localObject2 != null) {
              continue;
            }
            localObject2 = "{}";
            al localal = paramap.b;
            localObject3 = new HashMap();
            ((HashMap)localObject3).put("imei", localal.a());
            ((HashMap)localObject3).put("imsi", localal.b());
            if (localal.p == null) {
              localal.p = new Pair((String)am.b("LocationSDK", "location_device_id_type", ""), (String)am.b("LocationSDK", "location_device_id", ""));
            }
            ((HashMap)localObject3).put("idfa", localal.p.second);
            ((HashMap)localObject3).put("phonenum", ai.e(localal.d));
            ((HashMap)localObject3).put("qq", ai.e(localal.f));
            ((HashMap)localObject3).put("mac", localal.c().toLowerCase(Locale.ENGLISH));
            localObject5 = new JSONObject((Map)localObject3).toString();
            String str2 = localal.f();
            cc.a();
            int k = cc.a(paramap.a);
            String str1 = cg.c(paramap);
            localObject3 = localal.j;
            paramap = (ap)localObject3;
            if (localObject3 != null) {
              paramap = ((String)localObject3).replace("\"", "");
            }
            localObject3 = paramap;
            if (paramap != null) {
              localObject3 = paramap.replace("|", "");
            }
            paramap = (String)localObject3 + "_" + localal.h;
            int j = 203;
            i = j;
            if (paramBoolean2)
            {
              localObject3 = localal.a();
              i = j;
              if (localObject3 != null) {
                i = Math.abs(((String)localObject3).hashCode()) % 1000 + 1001;
              }
            }
            localObject3 = "{\"version\":\"" + localal.d() + "\",\"address\":" + paramInt1;
            paramap = (String)localObject3 + ",\"source\":" + i + ",\"access_token\":\"" + str2 + "\",\"app_name\":\"" + paramString + "\",\"app_label\":\"" + paramap + "\",\"bearing\":1";
            paramString = paramap;
            if (paramInt2 >= 0) {
              paramString = paramap + ",\"control\":" + paramInt2;
            }
            if ((!paramBoolean1) || (paramBoolean2)) {
              continue;
            }
            paramString = paramString + ",\"detectgps\":1";
            paramString = paramString + ",\"pstat\":" + k;
            paramString = paramString + ",\"wlan\":" + str1;
            return paramString + ",\"attribute\":" + (String)localObject5 + ",\"location\":" + (String)localObject2 + ",\"cells\":" + (String)localObject4 + ",\"wifis\":" + (String)localObject1 + "}";
          }
        }
        else
        {
          if (a == this.c.e) {
            break label1131;
          }
          bool = true;
          a = this.c.e;
          continue;
        }
        localObject1 = Collections.unmodifiableList(((bn)localObject1).b);
        break label1118;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        if (((List)localObject1).size() <= 0)
        {
          ((StringBuilder)localObject2).append("]");
          localObject1 = ((StringBuilder)localObject2).toString();
          continue;
        }
        Object localObject3 = ((List)localObject1).iterator();
        int i = 0;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ScanResult)((Iterator)localObject3).next();
          ((List)localObject1).size();
          if (i > 0) {
            ((StringBuilder)localObject2).append(",");
          }
          ((StringBuilder)localObject2).append("{\"mac\":\"").append(((ScanResult)localObject4).BSSID).append("\",");
          ((StringBuilder)localObject2).append("\"rssi\":").append(((ScanResult)localObject4).level).append("}");
          i += 1;
          continue;
        }
        ((StringBuilder)localObject2).append("]");
        localObject1 = ((StringBuilder)localObject2).toString();
        continue;
        localObject3 = ((bk)localObject2).a;
        Object localObject5 = new StringBuilder();
        double d1 = cf.a(((Location)localObject3).getLatitude(), 6);
        double d2 = cf.a(((Location)localObject3).getLongitude(), 6);
        double d3 = cf.a(((Location)localObject3).getAltitude(), 1);
        double d4 = cf.a(((Location)localObject3).getAccuracy(), 1);
        double d5 = cf.a(((Location)localObject3).getBearing(), 1);
        double d6 = cf.a(((Location)localObject3).getSpeed(), 1);
        ((StringBuilder)localObject5).append("{");
        ((StringBuilder)localObject5).append("\"latitude\":");
        ((StringBuilder)localObject5).append(d1);
        ((StringBuilder)localObject5).append(",\"longitude\":");
        ((StringBuilder)localObject5).append(d2);
        ((StringBuilder)localObject5).append(",\"additional\":");
        ((StringBuilder)localObject5).append("\"" + d3 + "," + d4 + "," + d5 + "," + d6 + "," + ((bk)localObject2).b + "\"");
        ((StringBuilder)localObject5).append("}");
        localObject2 = ((StringBuilder)localObject5).toString();
        continue;
        paramString = paramString + ",\"detectgps\":0";
        continue;
        if (localObject1 != null) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
      label1118:
      Object localObject1 = "[]";
      continue;
      label1131:
      boolean bool = false;
    }
  }
  
  public final String a(int paramInt, String paramString, ap paramap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean2) {
      return a(paramInt, 1, paramString, paramap, paramBoolean1, paramBoolean3);
    }
    return a(paramInt, 0, paramString, paramap, paramBoolean1, paramBoolean3);
  }
  
  public final boolean a()
  {
    return this.c != null;
  }
  
  public final boolean b()
  {
    return this.b != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.bl
 * JD-Core Version:    0.7.0.1
 */