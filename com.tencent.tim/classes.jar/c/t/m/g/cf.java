package c.t.m.g;

import android.location.Location;
import android.telephony.NeighboringCellInfo;
import android.util.Pair;
import com.tencent.tencentmap.lbssdk.service.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cf
  implements bo
{
  private byte[] a = new byte[512];
  
  private static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble1 = a(paramDouble1);
    paramDouble3 = a(paramDouble3);
    paramDouble2 = a(paramDouble2);
    paramDouble4 = a(paramDouble4);
    double d = Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D);
    return Math.round(Math.asin(Math.sqrt(Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D) + d)) * 2.0D * 6378.1369999999997D * 10000.0D) / 10000.0D * 1000.0D;
  }
  
  public static double a(double paramDouble, int paramInt)
  {
    try
    {
      if (Double.isNaN(paramDouble)) {
        return 0.0D;
      }
      paramDouble = BigDecimal.valueOf(paramDouble).setScale(paramInt, RoundingMode.HALF_DOWN).doubleValue();
      return paramDouble;
    }
    catch (Exception localException) {}
    return 0.0D;
  }
  
  private static String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"mcc\":");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",\"mnc\":");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",\"lac\":");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(",\"cellid\":");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append(",\"rss\":");
    localStringBuilder.append(paramInt5);
    if ((paramInt6 != 2147483647) && (paramInt7 != 2147483647))
    {
      localStringBuilder.append(",\"stationLat\":");
      localStringBuilder.append(String.format("%.6f", new Object[] { Float.valueOf(paramInt6 / 14400.0F) }));
      localStringBuilder.append(",\"stationLng\":");
      localStringBuilder.append(String.format("%.6f", new Object[] { Float.valueOf(paramInt7 / 14400.0F) }));
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static String a(bj parambj, boolean paramBoolean)
  {
    if (parambj == null) {
      return "[]";
    }
    int j = parambj.b;
    int k = parambj.c;
    int m = parambj.a.ordinal();
    Object localObject1 = new ArrayList();
    Object localObject2 = parambj.a();
    int i;
    int n;
    Object localObject4;
    if (bz.a(m, j, k, parambj.d, parambj.e))
    {
      i = parambj.d;
      int i2 = parambj.e;
      int i3 = parambj.f;
      n = parambj.g;
      int i1 = parambj.h;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("{");
      ((StringBuilder)localObject4).append("\"mcc\":");
      ((StringBuilder)localObject4).append(j);
      ((StringBuilder)localObject4).append(",\"mnc\":");
      ((StringBuilder)localObject4).append(k);
      ((StringBuilder)localObject4).append(",\"lac\":");
      ((StringBuilder)localObject4).append(i);
      ((StringBuilder)localObject4).append(",\"cellid\":");
      ((StringBuilder)localObject4).append(i2);
      ((StringBuilder)localObject4).append(",\"rss\":");
      ((StringBuilder)localObject4).append(i3);
      ((StringBuilder)localObject4).append(",\"seed\":");
      if (paramBoolean)
      {
        i = 1;
        ((StringBuilder)localObject4).append(i);
        ((StringBuilder)localObject4).append(",\"networktype\":");
        ((StringBuilder)localObject4).append(m);
        if ((n != 2147483647) && (i1 != 2147483647))
        {
          ((StringBuilder)localObject4).append(",\"stationLat\":");
          ((StringBuilder)localObject4).append(String.format("%.6f", new Object[] { Float.valueOf(n / 14400.0F) }));
          ((StringBuilder)localObject4).append(",\"stationLng\":");
          ((StringBuilder)localObject4).append(String.format("%.6f", new Object[] { Float.valueOf(i1 / 14400.0F) }));
        }
        ((StringBuilder)localObject4).append("}");
        ((ArrayList)localObject1).add(((StringBuilder)localObject4).toString());
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = (NeighboringCellInfo)((Iterator)localObject2).next();
          i = ((NeighboringCellInfo)localObject4).getLac();
          n = ((NeighboringCellInfo)localObject4).getCid();
          if (!bz.a(m, j, k, i, n)) {
            break label585;
          }
          ((ArrayList)localObject1).add(a(j, k, i, n, (((NeighboringCellInfo)localObject4).getRssi() << 1) - 113, 2147483647, 2147483647));
          continue;
        }
      }
      catch (Exception localException)
      {
        try
        {
          parambj = parambj.b().iterator();
          Object localObject3;
          if (parambj.hasNext())
          {
            localObject3 = (bj)parambj.next();
            ((ArrayList)localObject1).add(a(((bj)localObject3).b, ((bj)localObject3).c, ((bj)localObject3).d, ((bj)localObject3).e, ((bj)localObject3).f, ((bj)localObject3).g, ((bj)localObject3).h));
            continue;
          }
          i = 0;
        }
        catch (Throwable parambj)
        {
          parambj = new StringBuilder("[");
          localObject3 = new cb(",");
          localObject1 = ((Iterable)localObject1).iterator();
          parambj.append(((cb)localObject3).a(new StringBuilder(), (Iterator)localObject1).toString());
          parambj.append("]");
          return parambj.toString();
        }
      }
      a("illeagal main cell! ", j, k, m, parambj.d, parambj.e);
      continue;
      label585:
      a("illeagal neighboringCell! ", j, k, m, i, n);
    }
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    boolean bool = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCellInfoWithJsonFormat: ");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.append("isGsm=");
    if (paramInt3 == 1) {}
    for (;;)
    {
      paramString.append(bool);
      localStringBuilder.append(", mcc,mnc=").append(paramInt1).append(",").append(paramInt2);
      localStringBuilder.append(", lac,cid=").append(paramInt4).append(",").append(paramInt5);
      return;
      bool = false;
    }
  }
  
  public static boolean a(Location paramLocation, double[] paramArrayOfDouble)
  {
    int n = (int)(paramLocation.getLatitude() * 1000000.0D);
    int i1 = (int)(paramLocation.getLongitude() * 1000000.0D);
    paramLocation = ai.d("tencent_loc_lib");
    int k = 0;
    int m = 0;
    while (k < paramLocation.length())
    {
      int i2 = paramLocation.charAt(k);
      int j = 256;
      int i = j;
      if (i2 >= 65)
      {
        i = j;
        if (i2 <= 90) {
          i = i2 - 65;
        }
      }
      j = i;
      if (i2 >= 97)
      {
        j = i;
        if (i2 <= 122) {
          j = i2 - 97 + 64;
        }
      }
      i = j;
      if (i2 >= 48)
      {
        i = j;
        if (i2 <= 57) {
          i = i2 + 128 - 48;
        }
      }
      m += i;
      k += 1;
    }
    paramLocation = new double[2];
    try
    {
      e.b(n ^ m, m ^ i1, paramLocation);
      label169:
      paramArrayOfDouble[0] = paramLocation[0];
      paramArrayOfDouble[1] = paramLocation[1];
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      break label169;
    }
  }
  
  public static boolean a(String paramString)
  {
    do
    {
      JSONObject localJSONObject;
      do
      {
        try
        {
          localJSONObject = new JSONObject(paramString);
          if (paramString.contains("latitude")) {
            return true;
          }
        }
        catch (Exception paramString)
        {
          return false;
        }
        paramString = localJSONObject.optJSONArray("cells");
      } while ((paramString != null) && (paramString.length() > 0));
      paramString = localJSONObject.optJSONArray("wifis");
    } while ((paramString != null) && (paramString.length() > 0));
    return false;
  }
  
  private byte[] a(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(256);
    for (;;)
    {
      int i = paramInputStream.read(this.a);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(this.a, 0, i);
    }
    paramInputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static String b(String paramString)
  {
    String str2 = "GBK";
    String str1 = str2;
    int j;
    int i;
    if (paramString != null)
    {
      paramString = paramString.split(";");
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      str1 = str2;
      if (i < j)
      {
        str1 = paramString[i].trim();
        int k = str1.indexOf("charset=");
        if (-1 != k) {
          str1 = str1.substring(k + 8, str1.length());
        }
      }
      else
      {
        return str1;
      }
      i += 1;
    }
  }
  
  public final Pair<byte[], String> a(String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    for (;;)
    {
      try
      {
        paramString.setRequestProperty("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
        paramString.setRequestMethod("POST");
        paramString.setConnectTimeout(10000);
        paramString.setDoOutput(true);
        paramString.setFixedLengthStreamingMode(paramArrayOfByte.length);
        localObject = paramString.getOutputStream();
        ((OutputStream)localObject).write(paramArrayOfByte);
        ((OutputStream)localObject).flush();
        ((OutputStream)localObject).close();
        int i = paramString.getResponseCode();
        switch (i)
        {
        case 200: 
          throw new IOException("net sdk error: ".concat(String.valueOf(i)));
        }
      }
      finally
      {
        paramString.disconnect();
      }
      paramArrayOfByte = b(paramString.getHeaderField("content-type"));
      Object localObject = a(paramString.getInputStream());
      if ((localObject == null) || (localObject.length == 0))
      {
        paramArrayOfByte = Pair.create("{}".getBytes(), "utf-8");
        paramString.disconnect();
        return paramArrayOfByte;
      }
      paramArrayOfByte = Pair.create(localObject, paramArrayOfByte);
      paramString.disconnect();
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.cf
 * JD-Core Version:    0.7.0.1
 */