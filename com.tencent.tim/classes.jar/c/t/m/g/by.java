package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public final class by
  implements Parcelable, TencentLocation
{
  public static final by a = new by(-1);
  public bu b;
  public String c;
  private bt d;
  private int e;
  private int f;
  private String g;
  private br h;
  private final Bundle i = new Bundle();
  private String j = "network";
  private String k = "network";
  private Location l;
  private final long m;
  private long n;
  private int o;
  private int p;
  
  static
  {
    new by.1();
  }
  
  private by(int paramInt)
  {
    this.e = paramInt;
    this.m = SystemClock.elapsedRealtime();
    this.n = System.currentTimeMillis();
  }
  
  /* Error */
  private by(String paramString)
    throws JSONException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 49	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 51	android/os/Bundle
    //   8: dup
    //   9: invokespecial 52	android/os/Bundle:<init>	()V
    //   12: putfield 54	c/t/m/g/by:i	Landroid/os/Bundle;
    //   15: aload_0
    //   16: ldc 56
    //   18: putfield 58	c/t/m/g/by:j	Ljava/lang/String;
    //   21: aload_0
    //   22: ldc 56
    //   24: putfield 60	c/t/m/g/by:k	Ljava/lang/String;
    //   27: aload_0
    //   28: invokestatic 68	android/os/SystemClock:elapsedRealtime	()J
    //   31: putfield 70	c/t/m/g/by:m	J
    //   34: aload_0
    //   35: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   38: putfield 77	c/t/m/g/by:n	J
    //   41: new 87	org/json/JSONObject
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 89	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   49: astore_1
    //   50: aload_0
    //   51: new 91	c/t/m/g/bu
    //   54: dup
    //   55: aload_1
    //   56: ldc 93
    //   58: invokevirtual 97	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   61: invokespecial 100	c/t/m/g/bu:<init>	(Lorg/json/JSONObject;)V
    //   64: putfield 102	c/t/m/g/by:b	Lc/t/m/g/bu;
    //   67: aload_0
    //   68: new 104	c/t/m/g/bt
    //   71: dup
    //   72: aload_1
    //   73: ldc 106
    //   75: invokevirtual 97	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   78: invokespecial 107	c/t/m/g/bt:<init>	(Lorg/json/JSONObject;)V
    //   81: putfield 109	c/t/m/g/by:d	Lc/t/m/g/bt;
    //   84: aload_0
    //   85: aload_1
    //   86: ldc 111
    //   88: invokevirtual 115	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   91: putfield 117	c/t/m/g/by:g	Ljava/lang/String;
    //   94: aload_0
    //   95: aload_1
    //   96: ldc 119
    //   98: iconst_0
    //   99: invokevirtual 123	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   102: putfield 125	c/t/m/g/by:f	I
    //   105: aload_0
    //   106: aload_1
    //   107: ldc 127
    //   109: ldc 129
    //   111: invokevirtual 132	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   114: putfield 134	c/t/m/g/by:c	Ljava/lang/String;
    //   117: aload_0
    //   118: getfield 134	c/t/m/g/by:c	Ljava/lang/String;
    //   121: ifnull +42 -> 163
    //   124: aload_0
    //   125: getfield 134	c/t/m/g/by:c	Ljava/lang/String;
    //   128: ldc 129
    //   130: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   133: ifne +30 -> 163
    //   136: aload_0
    //   137: aload_1
    //   138: ldc 142
    //   140: invokevirtual 146	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   143: putfield 77	c/t/m/g/by:n	J
    //   146: new 148	java/lang/StringBuilder
    //   149: dup
    //   150: ldc 150
    //   152: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload_0
    //   156: getfield 77	c/t/m/g/by:n	J
    //   159: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_0
    //   164: getfield 125	c/t/m/g/by:f	I
    //   167: ifle +19 -> 186
    //   170: aload_0
    //   171: ldc 157
    //   173: putfield 60	c/t/m/g/by:k	Ljava/lang/String;
    //   176: aload_0
    //   177: aload_0
    //   178: getfield 159	c/t/m/g/by:p	I
    //   181: iconst_1
    //   182: iadd
    //   183: putfield 159	c/t/m/g/by:p	I
    //   186: aload_1
    //   187: ldc 161
    //   189: invokevirtual 115	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   192: astore_2
    //   193: aload_2
    //   194: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   197: ifne +26 -> 223
    //   200: aload_0
    //   201: getfield 54	c/t/m/g/by:i	Landroid/os/Bundle;
    //   204: ldc 161
    //   206: aload_2
    //   207: ldc 169
    //   209: invokevirtual 173	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   212: iconst_0
    //   213: aaload
    //   214: invokestatic 179	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   217: invokevirtual 183	java/lang/Integer:intValue	()I
    //   220: invokevirtual 187	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   223: aload_1
    //   224: ldc 189
    //   226: invokevirtual 192	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   229: astore_2
    //   230: aload_2
    //   231: ifnull +56 -> 287
    //   234: aload_0
    //   235: new 194	c/t/m/g/br
    //   238: dup
    //   239: aload_2
    //   240: invokespecial 195	c/t/m/g/br:<init>	(Lorg/json/JSONObject;)V
    //   243: putfield 197	c/t/m/g/by:h	Lc/t/m/g/br;
    //   246: aload_0
    //   247: getfield 197	c/t/m/g/by:h	Lc/t/m/g/br;
    //   250: ifnull +30 -> 280
    //   253: aload_0
    //   254: getfield 197	c/t/m/g/by:h	Lc/t/m/g/br;
    //   257: getfield 200	c/t/m/g/br:c	Lc/t/m/g/bw;
    //   260: ifnull +20 -> 280
    //   263: aload_0
    //   264: getfield 54	c/t/m/g/by:i	Landroid/os/Bundle;
    //   267: aload_0
    //   268: getfield 197	c/t/m/g/by:h	Lc/t/m/g/br;
    //   271: getfield 200	c/t/m/g/br:c	Lc/t/m/g/bw;
    //   274: getfield 204	c/t/m/g/bw:m	Landroid/os/Bundle;
    //   277: invokevirtual 208	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   280: return
    //   281: astore_1
    //   282: aload_1
    //   283: athrow
    //   284: astore_1
    //   285: aload_1
    //   286: athrow
    //   287: aload_1
    //   288: ldc 210
    //   290: invokevirtual 192	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   293: astore_1
    //   294: aload_1
    //   295: ifnull -49 -> 246
    //   298: aload_1
    //   299: ldc 212
    //   301: invokevirtual 216	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   304: ifeq -58 -> 246
    //   307: aload_0
    //   308: new 194	c/t/m/g/br
    //   311: dup
    //   312: aload_1
    //   313: ldc 212
    //   315: invokevirtual 192	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   318: invokespecial 195	c/t/m/g/br:<init>	(Lorg/json/JSONObject;)V
    //   321: putfield 197	c/t/m/g/by:h	Lc/t/m/g/br;
    //   324: goto -78 -> 246
    //   327: astore_2
    //   328: goto -105 -> 223
    //   331: astore_2
    //   332: goto -248 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	by
    //   0	335	1	paramString	String
    //   192	48	2	localObject	Object
    //   327	1	2	localException	java.lang.Exception
    //   331	1	2	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   50	67	281	org/json/JSONException
    //   234	246	284	org/json/JSONException
    //   186	223	327	java/lang/Exception
    //   67	84	331	java/lang/Throwable
  }
  
  public static by a(by paramby, int paramInt)
  {
    paramby.o = paramInt;
    return paramby;
  }
  
  public static by a(by paramby, bj parambj, boolean paramBoolean)
  {
    int i3;
    int i1;
    if ((paramby != null) && (parambj != null) && (paramby.g != null))
    {
      String str = paramby.g;
      int i2 = 0;
      i3 = parambj.f;
      i1 = i2;
      if (str != null)
      {
        i1 = i2;
        if (str.split(",").length > 1) {
          i1 = Integer.parseInt(str.split(",")[1]);
        }
      }
      parambj = paramby.b;
      if (parambj == null) {}
    }
    try
    {
      parambj.d = ((float)e.r(parambj.d, i1, i3));
      label91:
      if (paramBoolean) {
        paramby.k = "fake";
      }
      if (!paramby.k.equals("fake"))
      {
        if (parambj.d > 150.0D) {
          break label133;
        }
        paramby.k = "wifi";
      }
      label133:
      do
      {
        do
        {
          return paramby;
          paramby.k = "cell";
          return paramby;
        } while (paramby == null);
        if (paramBoolean) {
          paramby.k = "fake";
        }
      } while (paramby.k.equals("fake"));
      if (paramby.getAccuracy() <= 150.0D)
      {
        paramby.k = "wifi";
        return paramby;
      }
      paramby.k = "cell";
      return paramby;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      break label91;
    }
  }
  
  public static void a(by paramby)
    throws JSONException
  {
    if (paramby == a) {
      throw new JSONException("location failed");
    }
  }
  
  public final by a(int paramInt)
  {
    this.p += paramInt;
    return this;
  }
  
  public final void a(Location paramLocation)
  {
    if (this.b != null)
    {
      double d2 = paramLocation.getLatitude();
      double d1 = paramLocation.getLongitude();
      d2 = Math.round(d2 * 1000000.0D) / 1000000.0D;
      d1 = Math.round(d1 * 1000000.0D) / 1000000.0D;
      this.b.a = d2;
      this.b.b = d1;
      this.b.c = paramLocation.getAltitude();
      this.b.d = paramLocation.getAccuracy();
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final float getAccuracy()
  {
    if (this.b != null) {
      return this.b.d;
    }
    return 0.0F;
  }
  
  public final String getAddress()
  {
    if (this.e == 5) {
      return this.i.getString("addrdesp.name");
    }
    if (this.e == 3)
    {
      if (this.h != null) {
        return this.h.c.l;
      }
      return "";
    }
    if (this.b != null) {
      return this.b.f;
    }
    return "";
  }
  
  public final double getAltitude()
  {
    if (this.b != null) {
      return this.b.c;
    }
    return 0.0D;
  }
  
  public final Integer getAreaStat()
  {
    if (this.h != null) {
      return Integer.valueOf(this.h.a);
    }
    return null;
  }
  
  public final float getBearing()
  {
    if (this.l == null) {
      return 0.0F;
    }
    return this.l.getBearing();
  }
  
  public final String getCity()
  {
    if (this.h != null) {
      return this.h.c.f;
    }
    return "";
  }
  
  public final String getCityCode()
  {
    if (this.h != null) {
      return this.h.c.d;
    }
    return "";
  }
  
  public final int getCoordinateType()
  {
    return this.o;
  }
  
  public final double getDirection()
  {
    return this.i.getDouble("direction");
  }
  
  public final String getDistrict()
  {
    if (this.h != null) {
      return this.h.c.g;
    }
    return "";
  }
  
  public final long getElapsedRealtime()
  {
    return this.m;
  }
  
  public final Bundle getExtra()
  {
    return this.i;
  }
  
  public final int getFakeReason()
  {
    return this.p;
  }
  
  public final String getIndoorBuildingFloor()
  {
    if (this.d != null) {
      return this.d.b;
    }
    return "1000";
  }
  
  public final String getIndoorBuildingId()
  {
    if (this.d != null) {
      return this.d.a;
    }
    return null;
  }
  
  public final int getIndoorLocationType()
  {
    if (this.d != null) {
      return this.d.c;
    }
    return -1;
  }
  
  public final double getLatitude()
  {
    if (this.b != null) {
      return this.b.a;
    }
    return 0.0D;
  }
  
  public final double getLongitude()
  {
    if (this.b != null) {
      return this.b.b;
    }
    return 0.0D;
  }
  
  public final String getMotion()
  {
    return this.i.getString("motion");
  }
  
  public final String getName()
  {
    if (this.e == 5) {
      return this.i.getString("addrdesp.name");
    }
    if (this.e == 3)
    {
      if (this.h != null) {
        return this.h.c.c;
      }
      return "";
    }
    if (this.b != null) {
      return this.b.e;
    }
    return "";
  }
  
  public final String getNation()
  {
    if (this.h != null) {
      return this.h.c.b;
    }
    return "";
  }
  
  public final List<TencentPoi> getPoiList()
  {
    if (this.h != null) {
      return new ArrayList(this.h.b);
    }
    return Collections.emptyList();
  }
  
  public final String getProvider()
  {
    return this.j;
  }
  
  public final String getProvince()
  {
    if (this.h != null) {
      return this.h.c.e;
    }
    return "";
  }
  
  public final String getRawData()
  {
    return this.i.getString("wifi_data");
  }
  
  public final int getRssi()
  {
    if (this.l == null) {}
    Bundle localBundle;
    do
    {
      return 0;
      localBundle = this.l.getExtras();
    } while (localBundle == null);
    return localBundle.getInt("rssi", 0);
  }
  
  public final String getSourceProvider()
  {
    return this.k;
  }
  
  public final float getSpeed()
  {
    if (this.l == null) {
      return 0.0F;
    }
    return this.l.getSpeed();
  }
  
  public final String getStreet()
  {
    if (this.h != null) {
      return this.h.c.j;
    }
    return "";
  }
  
  public final String getStreetNo()
  {
    if (this.h != null) {
      return this.h.c.k;
    }
    return "";
  }
  
  public final long getTime()
  {
    return this.n;
  }
  
  public final String getTown()
  {
    if (this.h != null) {
      return this.h.c.h;
    }
    return "";
  }
  
  public final String getVerifyKey()
  {
    return this.c;
  }
  
  public final String getVillage()
  {
    if (this.h != null) {
      return this.h.c.i;
    }
    return "";
  }
  
  public final int isMockGps()
  {
    return this.f;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TxLocation{");
    localStringBuilder.append("level=").append(this.e).append(",");
    localStringBuilder.append("name=").append(getName()).append(",");
    localStringBuilder.append("address=").append(getAddress()).append(",");
    localStringBuilder.append("provider=").append(getProvider()).append(",");
    localStringBuilder.append("latitude=").append(getLatitude()).append(",");
    localStringBuilder.append("longitude=").append(getLongitude()).append(",");
    localStringBuilder.append("altitude=").append(getAltitude()).append(",");
    localStringBuilder.append("accuracy=").append(getAccuracy()).append(",");
    localStringBuilder.append("cityCode=").append(getCityCode()).append(",");
    localStringBuilder.append("areaStat=").append(getAreaStat()).append(",");
    localStringBuilder.append("nation=").append(getNation()).append(",");
    localStringBuilder.append("province=").append(getProvince()).append(",");
    localStringBuilder.append("city=").append(getCity()).append(",");
    localStringBuilder.append("district=").append(getDistrict()).append(",");
    localStringBuilder.append("street=").append(getStreet()).append(",");
    localStringBuilder.append("streetNo=").append(getStreetNo()).append(",");
    localStringBuilder.append("town=").append(getTown()).append(",");
    localStringBuilder.append("village=").append(getVillage()).append(",");
    localStringBuilder.append("bearing=").append(getBearing()).append(",");
    localStringBuilder.append("time=").append(getTime()).append(",");
    localStringBuilder.append("poilist=[");
    Iterator localIterator = getPoiList().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((TencentPoi)localIterator.next()).append(",");
    }
    localStringBuilder.append("]");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.e);
    paramParcel.writeString(getProvider());
    paramParcel.writeDouble(getLatitude());
    paramParcel.writeDouble(getLongitude());
    paramParcel.writeDouble(getAccuracy());
    paramParcel.writeDouble(getAltitude());
    paramParcel.writeString(getAddress());
    paramParcel.writeString(getNation());
    paramParcel.writeString(getProvince());
    paramParcel.writeString(getCity());
    paramParcel.writeString(getDistrict());
    paramParcel.writeString(getStreet());
    paramParcel.writeString(getStreetNo());
    if (this.h != null) {}
    for (String str = this.h.c.d;; str = "")
    {
      paramParcel.writeString(str);
      paramParcel.writeString(getName());
      paramParcel.writeLong(this.n);
      paramParcel.writeBundle(this.i);
      return;
    }
  }
  
  public static final class a
  {
    public String a;
    public by b;
    public int c;
    public String d = "network";
    public String e = "network";
    private Location f;
    
    public final a a(Location paramLocation)
    {
      this.f = new Location(paramLocation);
      return this;
    }
    
    public final by a()
    {
      if (this.a != null) {}
      for (;;)
      {
        try
        {
          by localby1 = new by(this.a, (byte)0);
          by.a(by.c(by.b(by.b(localby1, this.c), this.d), this.e), this.f);
          TencentExtraKeys.setRawGps(localby1, this.f);
          return localby1;
        }
        catch (JSONException localJSONException)
        {
          return by.a;
        }
        by localby2 = by.c(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.by
 * JD-Core Version:    0.7.0.1
 */