package com.tencent.beacon.event.open;

import com.tencent.beacon.a.b.a;
import com.tencent.beacon.base.net.adapter.AbstractNetAdapter;
import java.util.concurrent.ScheduledExecutorService;

public class BeaconConfig
{
  private final int a;
  private final boolean b;
  private final boolean c;
  private final boolean d;
  private final long e;
  private final long f;
  private final boolean g;
  private final AbstractNetAdapter h;
  private final String i;
  private final String j;
  private final boolean k;
  private final boolean l;
  private final boolean m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  
  public BeaconConfig(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong1, long paramLong2, boolean paramBoolean4, AbstractNetAdapter paramAbstractNetAdapter, String paramString1, String paramString2, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    this.a = paramInt;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramBoolean3;
    this.e = paramLong1;
    this.f = paramLong2;
    this.g = paramBoolean4;
    this.h = paramAbstractNetAdapter;
    this.i = paramString1;
    this.j = paramString2;
    this.k = paramBoolean5;
    this.l = paramBoolean6;
    this.m = paramBoolean7;
    this.n = paramString3;
    this.o = paramString4;
    this.p = paramString5;
    this.q = paramString6;
    this.r = paramString7;
    this.s = paramString8;
    this.t = paramString9;
    this.u = paramString10;
    this.v = paramString11;
    this.w = paramString12;
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public String getAndroidID()
  {
    return this.n;
  }
  
  public String getConfigHost()
  {
    return this.j;
  }
  
  public AbstractNetAdapter getHttpAdapter()
  {
    return this.h;
  }
  
  public String getImei()
  {
    return this.o;
  }
  
  public String getImei2()
  {
    return this.p;
  }
  
  public String getImsi()
  {
    return this.q;
  }
  
  public String getMac()
  {
    return this.t;
  }
  
  public int getMaxDBCount()
  {
    return this.a;
  }
  
  public String getMeid()
  {
    return this.r;
  }
  
  public String getModel()
  {
    return this.s;
  }
  
  public long getNormalPollingTIme()
  {
    return this.f;
  }
  
  public String getOaid()
  {
    return this.w;
  }
  
  public long getRealtimePollingTime()
  {
    return this.e;
  }
  
  public String getUploadHost()
  {
    return this.i;
  }
  
  public String getWifiMacAddress()
  {
    return this.u;
  }
  
  public String getWifiSSID()
  {
    return this.v;
  }
  
  public boolean isAuditEnable()
  {
    return this.c;
  }
  
  public boolean isBidEnable()
  {
    return this.d;
  }
  
  public boolean isEnableQmsp()
  {
    return this.l;
  }
  
  public boolean isEventReportEnable()
  {
    return this.b;
  }
  
  public boolean isForceEnableAtta()
  {
    return this.k;
  }
  
  public boolean isPagePathEnable()
  {
    return this.m;
  }
  
  public boolean isSocketMode()
  {
    return this.g;
  }
  
  public String toString()
  {
    return "BeaconConfig{maxDBCount=" + this.a + ", eventReportEnable=" + this.b + ", auditEnable=" + this.c + ", bidEnable=" + this.d + ", realtimePollingTime=" + this.e + ", normalPollingTIme=" + this.f + ", httpAdapter=" + this.h + ", uploadHost='" + this.i + '\'' + ", configHost='" + this.j + '\'' + ", forceEnableAtta=" + this.k + ", enableQmsp=" + this.l + ", pagePathEnable=" + this.m + ", androidID=" + this.n + '\'' + ", imei='" + this.o + '\'' + ", imei2='" + this.p + '\'' + ", imsi='" + this.q + '\'' + ", meid='" + this.r + '\'' + ", model='" + this.s + '\'' + ", mac='" + this.t + '\'' + ", wifiMacAddress='" + this.u + '\'' + ", wifiSSID='" + this.v + '\'' + ", oaid='" + this.w + '\'' + '}';
  }
  
  public static final class Builder
  {
    private int a = 10000;
    private boolean b = true;
    private boolean c = true;
    private boolean d = true;
    private ScheduledExecutorService e;
    private boolean f = true;
    private AbstractNetAdapter g;
    private long h;
    private long i;
    private String j;
    private String k;
    private boolean l = false;
    private boolean m = true;
    private boolean n = true;
    private String o = "";
    private String p = "";
    private String q = "";
    private String r = "";
    private String s = "";
    private String t = "";
    private String u = "";
    private String v = "";
    private String w = "";
    private String x = "";
    
    public Builder auditEnable(boolean paramBoolean)
    {
      this.c = paramBoolean;
      return this;
    }
    
    public Builder bidEnable(boolean paramBoolean)
    {
      this.d = paramBoolean;
      return this;
    }
    
    public BeaconConfig build()
    {
      ScheduledExecutorService localScheduledExecutorService = this.e;
      if (localScheduledExecutorService != null) {
        a.a(localScheduledExecutorService);
      }
      return new BeaconConfig(this.a, this.b, this.c, this.d, this.h, this.i, this.f, this.g, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x);
    }
    
    @Deprecated
    public Builder collectAndroidIdEnable(boolean paramBoolean)
    {
      return this;
    }
    
    @Deprecated
    public Builder collectIMEIEnable(boolean paramBoolean)
    {
      return this;
    }
    
    @Deprecated
    public Builder collectMACEnable(boolean paramBoolean)
    {
      return this;
    }
    
    @Deprecated
    public Builder collectProcessInfoEnable(boolean paramBoolean)
    {
      return this;
    }
    
    public Builder eventReportEnable(boolean paramBoolean)
    {
      this.b = paramBoolean;
      return this;
    }
    
    public Builder maxDBCount(int paramInt)
    {
      this.a = paramInt;
      return this;
    }
    
    public Builder pagePathEnable(boolean paramBoolean)
    {
      this.n = paramBoolean;
      return this;
    }
    
    public Builder qmspEnable(boolean paramBoolean)
    {
      this.m = paramBoolean;
      return this;
    }
    
    public Builder setAndroidID(String paramString)
    {
      this.o = paramString;
      return this;
    }
    
    public Builder setConfigHost(String paramString)
    {
      this.k = paramString;
      return this;
    }
    
    public Builder setExecutorService(ScheduledExecutorService paramScheduledExecutorService)
    {
      this.e = paramScheduledExecutorService;
      return this;
    }
    
    public Builder setForceEnableAtta(boolean paramBoolean)
    {
      this.l = paramBoolean;
      return this;
    }
    
    public Builder setHttpAdapter(AbstractNetAdapter paramAbstractNetAdapter)
    {
      this.g = paramAbstractNetAdapter;
      return this;
    }
    
    public Builder setImei(String paramString)
    {
      this.p = paramString;
      return this;
    }
    
    public Builder setImei2(String paramString)
    {
      this.q = paramString;
      return this;
    }
    
    public Builder setImsi(String paramString)
    {
      this.r = paramString;
      return this;
    }
    
    public Builder setIsSocketMode(boolean paramBoolean)
    {
      this.f = paramBoolean;
      return this;
    }
    
    public Builder setMac(String paramString)
    {
      this.u = paramString;
      return this;
    }
    
    public Builder setMeid(String paramString)
    {
      this.s = paramString;
      return this;
    }
    
    public Builder setModel(String paramString)
    {
      this.t = paramString;
      return this;
    }
    
    public Builder setNormalPollingTime(long paramLong)
    {
      this.i = paramLong;
      return this;
    }
    
    public Builder setOaid(String paramString)
    {
      this.x = paramString;
      return this;
    }
    
    public Builder setRealtimePollingTime(long paramLong)
    {
      this.h = paramLong;
      return this;
    }
    
    public Builder setUploadHost(String paramString)
    {
      this.j = paramString;
      return this;
    }
    
    public Builder setWifiMacAddress(String paramString)
    {
      this.v = paramString;
      return this;
    }
    
    public Builder setWifiSSID(String paramString)
    {
      this.w = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.open.BeaconConfig
 * JD-Core Version:    0.7.0.1
 */