package com.tencent.token;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.Criteria;
import android.location.GnssMeasurementsEvent.Callback;
import android.location.GnssNavigationMessage.Callback;
import android.location.GnssStatus.Callback;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.location.OnNmeaMessageListener;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.LocalOnlyHotspotCallback;
import android.os.Handler;
import android.os.Looper;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import com.oasisfeng.condom.OutboundJudge;
import com.oasisfeng.condom.OutboundType;
import com.oasisfeng.condom.PackageManagerWrapper;
import java.util.List;

public final class ajh
{
  public kw a = null;
  private Context b;
  
  /* Error */
  public final Context a(Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: new 47	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 49
    //   6: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: astore 4
    //   11: aload 4
    //   13: lload_2
    //   14: invokevirtual 56	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 4
    //   20: ldc 58
    //   22: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_1
    //   27: ifnonnull +5 -> 32
    //   30: aconst_null
    //   31: areturn
    //   32: new 63	com/oasisfeng/condom/CondomOptions
    //   35: dup
    //   36: invokespecial 64	com/oasisfeng/condom/CondomOptions:<init>	()V
    //   39: astore 4
    //   41: aload 4
    //   43: iconst_0
    //   44: invokevirtual 68	com/oasisfeng/condom/CondomOptions:preventBroadcastToBackgroundPackages	(Z)Lcom/oasisfeng/condom/CondomOptions;
    //   47: pop
    //   48: aload 4
    //   50: iconst_0
    //   51: invokevirtual 71	com/oasisfeng/condom/CondomOptions:preventServiceInBackgroundPackages	(Z)Lcom/oasisfeng/condom/CondomOptions;
    //   54: pop
    //   55: aload 4
    //   57: new 6	com/tencent/token/ajh$a
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 74	com/tencent/token/ajh$a:<init>	(Lcom/tencent/token/ajh;)V
    //   65: invokevirtual 78	com/oasisfeng/condom/CondomOptions:setOutboundJudge	(Lcom/oasisfeng/condom/OutboundJudge;)Lcom/oasisfeng/condom/CondomOptions;
    //   68: pop
    //   69: ldc2_w 79
    //   72: lload_2
    //   73: land
    //   74: lconst_0
    //   75: lcmp
    //   76: ifeq +17 -> 93
    //   79: aload 4
    //   81: new 8	com/tencent/token/ajh$b
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 81	com/tencent/token/ajh$b:<init>	(Lcom/tencent/token/ajh;)V
    //   89: invokevirtual 85	com/oasisfeng/condom/CondomOptions:setPackageManagerFactory	(Lcom/tencent/token/aix;)Lcom/oasisfeng/condom/CondomOptions;
    //   92: pop
    //   93: ldc2_w 86
    //   96: lload_2
    //   97: land
    //   98: lconst_0
    //   99: lcmp
    //   100: ifeq +17 -> 117
    //   103: aload 4
    //   105: new 12	com/tencent/token/ajh$c
    //   108: dup
    //   109: aload_0
    //   110: invokespecial 88	com/tencent/token/ajh$c:<init>	(Lcom/tencent/token/ajh;)V
    //   113: invokevirtual 92	com/oasisfeng/condom/CondomOptions:addKit	(Lcom/tencent/token/km;)Lcom/oasisfeng/condom/CondomOptions;
    //   116: pop
    //   117: ldc2_w 93
    //   120: lload_2
    //   121: land
    //   122: lconst_0
    //   123: lcmp
    //   124: ifeq +17 -> 141
    //   127: aload 4
    //   129: new 18	com/tencent/token/ajh$d
    //   132: dup
    //   133: aload_0
    //   134: invokespecial 95	com/tencent/token/ajh$d:<init>	(Lcom/tencent/token/ajh;)V
    //   137: invokevirtual 92	com/oasisfeng/condom/CondomOptions:addKit	(Lcom/tencent/token/km;)Lcom/oasisfeng/condom/CondomOptions;
    //   140: pop
    //   141: ldc2_w 96
    //   144: lload_2
    //   145: land
    //   146: lconst_0
    //   147: lcmp
    //   148: ifeq +17 -> 165
    //   151: aload 4
    //   153: new 24	com/tencent/token/ajh$e
    //   156: dup
    //   157: aload_0
    //   158: invokespecial 98	com/tencent/token/ajh$e:<init>	(Lcom/tencent/token/ajh;)V
    //   161: invokevirtual 92	com/oasisfeng/condom/CondomOptions:addKit	(Lcom/tencent/token/km;)Lcom/oasisfeng/condom/CondomOptions;
    //   164: pop
    //   165: aload_0
    //   166: new 100	com/tencent/token/aiy
    //   169: dup
    //   170: aload_1
    //   171: aload_1
    //   172: ldc 102
    //   174: aload 4
    //   176: invokestatic 108	com/oasisfeng/condom/CondomContext:wrap	(Landroid/content/Context;Ljava/lang/String;Lcom/oasisfeng/condom/CondomOptions;)Lcom/oasisfeng/condom/CondomContext;
    //   179: lload_2
    //   180: invokespecial 111	com/tencent/token/aiy:<init>	(Landroid/content/Context;Lcom/oasisfeng/condom/CondomContext;J)V
    //   183: putfield 113	com/tencent/token/ajh:b	Landroid/content/Context;
    //   186: goto +35 -> 221
    //   189: astore 4
    //   191: new 47	java/lang/StringBuilder
    //   194: dup
    //   195: ldc 115
    //   197: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   200: astore 5
    //   202: aload 5
    //   204: aload 4
    //   206: invokevirtual 121	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   209: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 5
    //   215: ldc 58
    //   217: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_0
    //   222: getfield 113	com/tencent/token/ajh:b	Landroid/content/Context;
    //   225: astore 4
    //   227: aload 4
    //   229: ifnonnull +5 -> 234
    //   232: aload_1
    //   233: areturn
    //   234: aload 4
    //   236: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	ajh
    //   0	237	1	paramContext	Context
    //   0	237	2	paramLong	long
    //   9	166	4	localObject1	Object
    //   189	16	4	localObject2	Object
    //   225	10	4	localContext	Context
    //   200	14	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   165	186	189	finally
  }
  
  final class a
    implements OutboundJudge
  {
    a() {}
    
    public final boolean shouldAllow(OutboundType paramOutboundType, Intent paramIntent, String paramString)
    {
      return true;
    }
  }
  
  final class b
    implements aix
  {
    b() {}
    
    public final PackageManagerWrapper a(Context paramContext)
    {
      ajb.a = paramContext.getPackageManager();
      return new a(ajb.a);
    }
    
    final class a
      extends ajc
    {
      a(PackageManager paramPackageManager)
      {
        super();
      }
      
      public final List<ApplicationInfo> getInstalledApplications(int paramInt)
      {
        Object localObject = new StringBuilder("getInstalledApplications, flags:[");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("]");
        if (kx.a())
        {
          localObject = ajh.this.a;
          if (localObject != null)
          {
            localObject = ((kw)localObject).a("getInstalledApplications");
            if (localObject == null) {
              return ajb.b(paramInt);
            }
            if (((kx.a)localObject).b) {
              return (List)((kx.a)localObject).a;
            }
            ((kx.a)localObject).a = ajb.b(paramInt);
            return (List)((kx.a)localObject).a;
          }
        }
        return ajb.b(paramInt);
      }
      
      public final List<PackageInfo> getInstalledPackages(int paramInt)
      {
        Object localObject = new StringBuilder("getInstalledPackages, flags:[");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("]");
        if (kx.a())
        {
          localObject = ajh.this.a;
          if (localObject != null)
          {
            localObject = ((kw)localObject).a("getInstalledPackages");
            if (localObject == null) {
              return ajb.a(paramInt);
            }
            if (((kx.a)localObject).b) {
              return (List)((kx.a)localObject).a;
            }
            ((kx.a)localObject).a = ajb.a(paramInt);
            return (List)((kx.a)localObject).a;
          }
        }
        return ajb.a(paramInt);
      }
      
      public final List<ResolveInfo> queryBroadcastReceivers(Intent paramIntent, int paramInt)
      {
        Object localObject = new StringBuilder("queryBroadcastReceivers, flags:[");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("]");
        if (kx.a())
        {
          localObject = ajh.this.a;
          if (localObject != null)
          {
            localObject = ((kw)localObject).a("queryBroadcastReceivers");
            if (localObject == null) {
              return ajb.a(paramIntent, paramInt);
            }
            if (((kx.a)localObject).b) {
              return (List)((kx.a)localObject).a;
            }
            ((kx.a)localObject).a = ajb.a(paramIntent, paramInt);
            return (List)((kx.a)localObject).a;
          }
        }
        return ajb.a(paramIntent, paramInt);
      }
      
      public final List<ResolveInfo> queryIntentActivities(Intent paramIntent, int paramInt)
      {
        Object localObject = new StringBuilder("queryIntentActivities, flags:[");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("]");
        if (kx.a())
        {
          localObject = ajh.this.a;
          if (localObject != null)
          {
            localObject = ((kw)localObject).a("queryIntentActivities");
            if (localObject == null) {
              return ajb.c(paramIntent, paramInt);
            }
            if (((kx.a)localObject).b) {
              return (List)((kx.a)localObject).a;
            }
            ((kx.a)localObject).a = ajb.c(paramIntent, paramInt);
            return (List)((kx.a)localObject).a;
          }
        }
        return ajb.c(paramIntent, paramInt);
      }
      
      public final List<ResolveInfo> queryIntentActivityOptions(ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt)
      {
        Object localObject = new StringBuilder("queryIntentActivityOptions, caller:[");
        ((StringBuilder)localObject).append(paramComponentName);
        ((StringBuilder)localObject).append("]flags:[");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("]");
        if (kx.a())
        {
          localObject = ajh.this.a;
          if (localObject != null)
          {
            localObject = ((kw)localObject).a("queryIntentActivityOptions");
            if (localObject == null) {
              return ajb.a(paramComponentName, paramArrayOfIntent, paramIntent, paramInt);
            }
            if (((kx.a)localObject).b) {
              return (List)((kx.a)localObject).a;
            }
            ((kx.a)localObject).a = ajb.a(paramComponentName, paramArrayOfIntent, paramIntent, paramInt);
            return (List)((kx.a)localObject).a;
          }
        }
        return ajb.a(paramComponentName, paramArrayOfIntent, paramIntent, paramInt);
      }
      
      public final List<ResolveInfo> queryIntentServices(Intent paramIntent, int paramInt)
      {
        Object localObject = new StringBuilder("queryIntentServices, flags:[");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("]");
        if (kx.a())
        {
          localObject = ajh.this.a;
          if (localObject != null)
          {
            localObject = ((kw)localObject).a("queryIntentServices");
            if (localObject == null) {
              return ajb.b(paramIntent, paramInt);
            }
            if (((kx.a)localObject).b) {
              return (List)((kx.a)localObject).a;
            }
            ((kx.a)localObject).a = ajb.b(paramIntent, paramInt);
            return (List)((kx.a)localObject).a;
          }
        }
        return ajb.b(paramIntent, paramInt);
      }
    }
  }
  
  final class c
    implements km
  {
    c() {}
    
    public final void a(km.a parama)
    {
      parama.a("phone", new a());
    }
    
    final class a
      implements km.b
    {
      a() {}
      
      public final Object a(Context paramContext)
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
        ajd.a = localTelephonyManager;
        try
        {
          paramContext = new a(paramContext, localTelephonyManager);
          return paramContext;
        }
        finally
        {
          StringBuilder localStringBuilder = new StringBuilder("e:[");
          localStringBuilder.append(paramContext.getMessage());
          localStringBuilder.append("]");
        }
        return localTelephonyManager;
      }
      
      final class a
        extends aje
      {
        a(Context paramContext, TelephonyManager paramTelephonyManager)
        {
          super(paramTelephonyManager);
        }
        
        @SuppressLint({"MissingPermission"})
        public final List<CellInfo> getAllCellInfo()
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getAllCellInfo");
              if (localObject == null) {
                return ajd.b();
              }
              if (((kx.a)localObject).b) {
                return (List)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = ajd.b();
              return (List)((kx.a)localObject).a;
            }
          }
          return ajd.b();
        }
        
        @SuppressLint({"MissingPermission"})
        public final CellLocation getCellLocation()
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getCellLocation");
              if (localObject == null) {
                return ajd.a();
              }
              if (((kx.a)localObject).b) {
                return (CellLocation)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = ajd.a();
              return (CellLocation)((kx.a)localObject).a;
            }
          }
          return ajd.a();
        }
        
        @SuppressLint({"MissingPermission"})
        public final String getDeviceId()
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getDeviceId");
              if (localObject == null) {
                return ajd.c();
              }
              if (((kx.a)localObject).b) {
                return (String)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = ajd.c();
              return (String)((kx.a)localObject).a;
            }
          }
          return ajd.c();
        }
        
        @SuppressLint({"MissingPermission"})
        public final String getDeviceId(int paramInt)
        {
          Object localObject = new StringBuilder("getDeviceId, slot:[");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append("]");
          if (kx.a())
          {
            localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getDeviceId");
              if (localObject == null) {
                return ajd.a(paramInt);
              }
              if (((kx.a)localObject).b) {
                return (String)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = ajd.a(paramInt);
              return (String)((kx.a)localObject).a;
            }
          }
          return ajd.a(paramInt);
        }
        
        @SuppressLint({"MissingPermission"})
        public final String getImei()
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getImei");
              if (localObject == null) {
                return ajd.d();
              }
              if (((kx.a)localObject).b) {
                return (String)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = ajd.d();
              return (String)((kx.a)localObject).a;
            }
          }
          return ajd.d();
        }
        
        @SuppressLint({"MissingPermission"})
        public final String getImei(int paramInt)
        {
          Object localObject = new StringBuilder("getImei, slot:[");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append("]");
          if (kx.a())
          {
            localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getImei");
              if (localObject == null) {
                return ajd.b(paramInt);
              }
              if (((kx.a)localObject).b) {
                return (String)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = ajd.b(paramInt);
              return (String)((kx.a)localObject).a;
            }
          }
          return ajd.b(paramInt);
        }
        
        @SuppressLint({"MissingPermission"})
        public final String getLine1Number()
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getLine1Number");
              if (localObject == null) {
                return ajd.h();
              }
              if (((kx.a)localObject).b) {
                return (String)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = ajd.h();
              return (String)((kx.a)localObject).a;
            }
          }
          return ajd.h();
        }
        
        @SuppressLint({"MissingPermission"})
        public final String getMeid()
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getMeid");
              if (localObject == null) {
                return ajd.f();
              }
              if (((kx.a)localObject).b) {
                return (String)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = ajd.f();
              return (String)((kx.a)localObject).a;
            }
          }
          return ajd.f();
        }
        
        @SuppressLint({"MissingPermission"})
        public final String getMeid(int paramInt)
        {
          Object localObject = new StringBuilder("getMeid, slot:[");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append("]");
          if (kx.a())
          {
            localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getMeid");
              if (localObject == null) {
                return ajd.c(paramInt);
              }
              if (((kx.a)localObject).b) {
                return (String)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = ajd.c(paramInt);
              return (String)((kx.a)localObject).a;
            }
          }
          return ajd.c(paramInt);
        }
        
        @SuppressLint({"MissingPermission", "NewApi"})
        public final ServiceState getServiceState()
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getServiceState");
              if (localObject == null) {
                return ajd.i();
              }
              if (((kx.a)localObject).b) {
                return (ServiceState)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = ajd.i();
              return (ServiceState)((kx.a)localObject).a;
            }
          }
          return ajd.i();
        }
        
        @SuppressLint({"MissingPermission"})
        public final String getSimSerialNumber()
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getSimSerialNumber");
              if (localObject == null) {
                return ajd.g();
              }
              if (((kx.a)localObject).b) {
                return (String)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = ajd.g();
              return (String)((kx.a)localObject).a;
            }
          }
          return ajd.g();
        }
        
        @SuppressLint({"MissingPermission"})
        public final String getSubscriberId()
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getSubscriberId");
              if (localObject == null) {
                return ajd.e();
              }
              if (((kx.a)localObject).b) {
                return (String)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = ajd.e();
              return (String)((kx.a)localObject).a;
            }
          }
          return ajd.e();
        }
        
        public final void listen(PhoneStateListener paramPhoneStateListener, int paramInt)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("listen");
              if (localObject == null)
              {
                ajd.a(paramPhoneStateListener, paramInt);
                return;
              }
              if (((kx.a)localObject).b) {
                return;
              }
              ajd.a(paramPhoneStateListener, ((Integer)((kx.a)localObject).a).intValue());
              return;
            }
          }
          ajd.a(paramPhoneStateListener, paramInt);
        }
      }
    }
  }
  
  final class d
    implements km
  {
    d() {}
    
    public final void a(km.a parama)
    {
      parama.a("wifi", new a());
    }
    
    final class a
      implements km.b
    {
      a() {}
      
      public final Object a(Context paramContext)
      {
        paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
        ajf.a = paramContext;
        try
        {
          a locala = new a(paramContext);
          return locala;
        }
        finally
        {
          StringBuilder localStringBuilder = new StringBuilder("e:[");
          localStringBuilder.append(localObject.getMessage());
          localStringBuilder.append("]");
        }
        return paramContext;
      }
      
      final class a
        extends ajg
      {
        a(WifiManager paramWifiManager)
        {
          super();
        }
        
        @SuppressLint({"MissingPermission"})
        public final List<WifiConfiguration> getConfiguredNetworks()
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getConfiguredNetworks");
              if (localObject == null) {
                return ajf.c();
              }
              if (((kx.a)localObject).b) {
                return (List)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = ajf.c();
              return (List)((kx.a)localObject).a;
            }
          }
          return ajf.c();
        }
        
        @SuppressLint({"MissingPermission"})
        public final WifiInfo getConnectionInfo()
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getConnectionInfo");
              if (localObject == null) {
                return ajf.a();
              }
              if (((kx.a)localObject).b) {
                return (WifiInfo)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = ajf.a();
              return (WifiInfo)((kx.a)localObject).a;
            }
          }
          return ajf.a();
        }
        
        @SuppressLint({"MissingPermission"})
        public final List<ScanResult> getScanResults()
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getScanResults");
              if (localObject == null) {
                return ajf.b();
              }
              if (((kx.a)localObject).b) {
                return (List)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = ajf.b();
              return (List)((kx.a)localObject).a;
            }
          }
          return ajf.b();
        }
        
        public final void startLocalOnlyHotspot(WifiManager.LocalOnlyHotspotCallback paramLocalOnlyHotspotCallback, Handler paramHandler)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("startLocalOnlyHotspot");
              if (localObject == null)
              {
                ajf.a(paramLocalOnlyHotspotCallback, paramHandler);
                return;
              }
              if (((kx.a)localObject).b) {
                return;
              }
              ajf.a(paramLocalOnlyHotspotCallback, paramHandler);
              return;
            }
          }
          ajf.a(paramLocalOnlyHotspotCallback, paramHandler);
        }
        
        @SuppressLint({"MissingPermission"})
        public final boolean startScan()
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("startScan");
              if (localObject == null) {
                return ajf.d();
              }
              if (((kx.a)localObject).b) {
                return ((Boolean)((kx.a)localObject).a).booleanValue();
              }
              ((kx.a)localObject).a = Boolean.valueOf(ajf.d());
              return ((Boolean)((kx.a)localObject).a).booleanValue();
            }
          }
          return ajf.d();
        }
      }
    }
  }
  
  final class e
    implements km
  {
    e() {}
    
    public final void a(km.a parama)
    {
      parama.a("location", new a());
    }
    
    final class a
      implements km.b
    {
      a() {}
      
      public final Object a(Context paramContext)
      {
        paramContext = (LocationManager)paramContext.getApplicationContext().getSystemService("location");
        try
        {
          aiz.a = paramContext;
          a locala = new a(paramContext);
          return locala;
        }
        finally
        {
          StringBuilder localStringBuilder = new StringBuilder("e:[");
          localStringBuilder.append(localObject.getMessage());
          localStringBuilder.append("]");
        }
        return paramContext;
      }
      
      final class a
        extends aja
      {
        a(LocationManager paramLocationManager)
        {
          super();
        }
        
        @SuppressLint({"MissingPermission"})
        public final boolean addGpsStatusListener(GpsStatus.Listener paramListener)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("addGpsStatusListener");
              if (localObject == null) {
                return aiz.a(paramListener);
              }
              if (((kx.a)localObject).b) {
                return ((Boolean)((kx.a)localObject).a).booleanValue();
              }
              ((kx.a)localObject).a = Boolean.valueOf(aiz.a(paramListener));
              return ((Boolean)((kx.a)localObject).a).booleanValue();
            }
          }
          return aiz.a(paramListener);
        }
        
        @SuppressLint({"MissingPermission"})
        public final boolean addNmeaListener(OnNmeaMessageListener paramOnNmeaMessageListener)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("addNmeaListener");
              if (localObject == null) {
                return aiz.a(paramOnNmeaMessageListener);
              }
              if (((kx.a)localObject).b) {
                return ((Boolean)((kx.a)localObject).a).booleanValue();
              }
              ((kx.a)localObject).a = Boolean.valueOf(aiz.a(paramOnNmeaMessageListener));
              return ((Boolean)((kx.a)localObject).a).booleanValue();
            }
          }
          return aiz.a(paramOnNmeaMessageListener);
        }
        
        @SuppressLint({"MissingPermission"})
        public final boolean addNmeaListener(OnNmeaMessageListener paramOnNmeaMessageListener, Handler paramHandler)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("addNmeaListener");
              if (localObject == null) {
                return aiz.a(paramOnNmeaMessageListener, paramHandler);
              }
              if (((kx.a)localObject).b) {
                return ((Boolean)((kx.a)localObject).a).booleanValue();
              }
              ((kx.a)localObject).a = Boolean.valueOf(aiz.a(paramOnNmeaMessageListener, paramHandler));
              return ((Boolean)((kx.a)localObject).a).booleanValue();
            }
          }
          return aiz.a(paramOnNmeaMessageListener, paramHandler);
        }
        
        @SuppressLint({"MissingPermission"})
        public final void addProximityAlert(double paramDouble1, double paramDouble2, float paramFloat, long paramLong, PendingIntent paramPendingIntent)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("addProximityAlert");
              if (localObject == null)
              {
                aiz.a(paramDouble1, paramDouble2, paramFloat, paramLong, paramPendingIntent);
                return;
              }
              if (((kx.a)localObject).b) {
                return;
              }
              aiz.a(paramDouble1, paramDouble2, paramFloat, paramLong, paramPendingIntent);
              return;
            }
          }
          aiz.a(paramDouble1, paramDouble2, paramFloat, paramLong, paramPendingIntent);
        }
        
        public final List<String> getAllProviders()
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getAllProviders");
              if (localObject == null) {
                return aiz.a();
              }
              if (((kx.a)localObject).b) {
                return (List)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = aiz.a();
              return (List)((kx.a)localObject).a;
            }
          }
          return aiz.a();
        }
        
        public final String getBestProvider(Criteria paramCriteria, boolean paramBoolean)
        {
          Object localObject = new StringBuilder("getBestProvider, enabledOnly:[");
          ((StringBuilder)localObject).append(paramBoolean);
          ((StringBuilder)localObject).append("]");
          if (kx.a())
          {
            localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getBestProvider");
              if (localObject == null) {
                return aiz.b(paramCriteria, paramBoolean);
              }
              if (((kx.a)localObject).b) {
                return (String)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = aiz.b(paramCriteria, paramBoolean);
              return (String)((kx.a)localObject).a;
            }
          }
          return aiz.b(paramCriteria, paramBoolean);
        }
        
        @SuppressLint({"MissingPermission"})
        public final GpsStatus getGpsStatus(GpsStatus paramGpsStatus)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getGpsStatus");
              if (localObject == null) {
                return aiz.a(paramGpsStatus);
              }
              if (((kx.a)localObject).b) {
                return (GpsStatus)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = aiz.a(paramGpsStatus);
              return (GpsStatus)((kx.a)localObject).a;
            }
          }
          return aiz.a(paramGpsStatus);
        }
        
        @SuppressLint({"MissingPermission"})
        public final Location getLastKnownLocation(String paramString)
        {
          Object localObject = new StringBuilder("getLastKnownLocation, provider:[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("]");
          if (kx.a())
          {
            localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getLastKnownLocation");
              if (localObject == null) {
                return aiz.c(paramString);
              }
              if (((kx.a)localObject).b) {
                return (Location)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = aiz.c(paramString);
              return (Location)((kx.a)localObject).a;
            }
          }
          return aiz.c(paramString);
        }
        
        public final LocationProvider getProvider(String paramString)
        {
          Object localObject = new StringBuilder("getProvider, name:[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("]");
          if (kx.a())
          {
            localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getProvider");
              if (localObject == null) {
                return aiz.b(paramString);
              }
              if (((kx.a)localObject).b) {
                return (LocationProvider)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = aiz.b(paramString);
              return (LocationProvider)((kx.a)localObject).a;
            }
          }
          return aiz.b(paramString);
        }
        
        public final List<String> getProviders(Criteria paramCriteria, boolean paramBoolean)
        {
          Object localObject = new StringBuilder("getProviders, enabledOnly:[");
          ((StringBuilder)localObject).append(paramBoolean);
          ((StringBuilder)localObject).append("]");
          if (kx.a())
          {
            localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getProviders");
              if (localObject == null) {
                return aiz.a(paramCriteria, paramBoolean);
              }
              if (((kx.a)localObject).b) {
                return (List)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = aiz.a(paramCriteria, paramBoolean);
              return (List)((kx.a)localObject).a;
            }
          }
          return aiz.a(paramCriteria, paramBoolean);
        }
        
        public final List<String> getProviders(boolean paramBoolean)
        {
          Object localObject = new StringBuilder("getProviders, enabledOnly:[");
          ((StringBuilder)localObject).append(paramBoolean);
          ((StringBuilder)localObject).append("]");
          if (kx.a())
          {
            localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("getProviders");
              if (localObject == null) {
                return aiz.a(paramBoolean);
              }
              if (((kx.a)localObject).b) {
                return (List)((kx.a)localObject).a;
              }
              ((kx.a)localObject).a = aiz.a(paramBoolean);
              return (List)((kx.a)localObject).a;
            }
          }
          return aiz.a(paramBoolean);
        }
        
        public final boolean isProviderEnabled(String paramString)
        {
          Object localObject = new StringBuilder("isProviderEnabled, provider:[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("]");
          if (kx.a())
          {
            localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("isProviderEnabled");
              if (localObject == null) {
                return aiz.a(paramString);
              }
              if (((kx.a)localObject).b) {
                return ((Boolean)((kx.a)localObject).a).booleanValue();
              }
              ((kx.a)localObject).a = Boolean.valueOf(aiz.a(paramString));
              return ((Boolean)((kx.a)localObject).a).booleanValue();
            }
          }
          return aiz.a(paramString);
        }
        
        @SuppressLint({"MissingPermission"})
        public final boolean registerGnssMeasurementsCallback(GnssMeasurementsEvent.Callback paramCallback)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("registerGnssMeasurementsCallback");
              if (localObject == null) {
                return aiz.a(paramCallback);
              }
              if (((kx.a)localObject).b) {
                return ((Boolean)((kx.a)localObject).a).booleanValue();
              }
              ((kx.a)localObject).a = Boolean.valueOf(aiz.a(paramCallback));
              return ((Boolean)((kx.a)localObject).a).booleanValue();
            }
          }
          return aiz.a(paramCallback);
        }
        
        @SuppressLint({"MissingPermission"})
        public final boolean registerGnssMeasurementsCallback(GnssMeasurementsEvent.Callback paramCallback, Handler paramHandler)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("registerGnssMeasurementsCallback");
              if (localObject == null) {
                return aiz.a(paramCallback, paramHandler);
              }
              if (((kx.a)localObject).b) {
                return ((Boolean)((kx.a)localObject).a).booleanValue();
              }
              ((kx.a)localObject).a = Boolean.valueOf(aiz.a(paramCallback, paramHandler));
              return ((Boolean)((kx.a)localObject).a).booleanValue();
            }
          }
          return aiz.a(paramCallback, paramHandler);
        }
        
        @SuppressLint({"MissingPermission"})
        public final boolean registerGnssNavigationMessageCallback(GnssNavigationMessage.Callback paramCallback, Handler paramHandler)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("registerGnssNavigationMessageCallback");
              if (localObject == null) {
                return aiz.a(paramCallback, paramHandler);
              }
              if (((kx.a)localObject).b) {
                return ((Boolean)((kx.a)localObject).a).booleanValue();
              }
              ((kx.a)localObject).a = Boolean.valueOf(aiz.a(paramCallback, paramHandler));
              return ((Boolean)((kx.a)localObject).a).booleanValue();
            }
          }
          return aiz.a(paramCallback, paramHandler);
        }
        
        @SuppressLint({"MissingPermission"})
        public final boolean registerGnssStatusCallback(GnssStatus.Callback paramCallback)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("registerGnssStatusCallback");
              if (localObject == null) {
                return aiz.a(paramCallback);
              }
              if (((kx.a)localObject).b) {
                return ((Boolean)((kx.a)localObject).a).booleanValue();
              }
              ((kx.a)localObject).a = Boolean.valueOf(aiz.a(paramCallback));
              return ((Boolean)((kx.a)localObject).a).booleanValue();
            }
          }
          return aiz.a(paramCallback);
        }
        
        @SuppressLint({"MissingPermission"})
        public final boolean registerGnssStatusCallback(GnssStatus.Callback paramCallback, Handler paramHandler)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("registerGnssStatusCallback");
              if (localObject == null) {
                return aiz.a(paramCallback, paramHandler);
              }
              if (((kx.a)localObject).b) {
                return ((Boolean)((kx.a)localObject).a).booleanValue();
              }
              ((kx.a)localObject).a = Boolean.valueOf(aiz.a(paramCallback, paramHandler));
              return ((Boolean)((kx.a)localObject).a).booleanValue();
            }
          }
          return aiz.a(paramCallback, paramHandler);
        }
        
        public final void removeGpsStatusListener(GpsStatus.Listener paramListener)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("removeGpsStatusListener");
              if (localObject == null)
              {
                aiz.b(paramListener);
                return;
              }
              if (((kx.a)localObject).b) {
                return;
              }
              aiz.b(paramListener);
              return;
            }
          }
          aiz.b(paramListener);
        }
        
        public final void removeUpdates(PendingIntent paramPendingIntent)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("removeUpdates");
              if (localObject == null)
              {
                aiz.a(paramPendingIntent);
                return;
              }
              if (((kx.a)localObject).b) {
                return;
              }
              aiz.a(paramPendingIntent);
              return;
            }
          }
          aiz.a(paramPendingIntent);
        }
        
        public final void removeUpdates(LocationListener paramLocationListener)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("removeUpdates");
              if (localObject == null)
              {
                aiz.a(paramLocationListener);
                return;
              }
              if (((kx.a)localObject).b) {
                return;
              }
              aiz.a(paramLocationListener);
              return;
            }
          }
          aiz.a(paramLocationListener);
        }
        
        public final void requestLocationUpdates(long paramLong, float paramFloat, Criteria paramCriteria, PendingIntent paramPendingIntent)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("requestLocationUpdates");
              if (localObject == null)
              {
                aiz.a(paramLong, paramFloat, paramCriteria, paramPendingIntent);
                return;
              }
              if (((kx.a)localObject).b) {
                return;
              }
              aiz.a(paramLong, paramFloat, paramCriteria, paramPendingIntent);
              return;
            }
          }
          aiz.a(paramLong, paramFloat, paramCriteria, paramPendingIntent);
        }
        
        public final void requestLocationUpdates(long paramLong, float paramFloat, Criteria paramCriteria, LocationListener paramLocationListener, Looper paramLooper)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("requestLocationUpdates");
              if (localObject == null)
              {
                aiz.a(paramLong, paramFloat, paramCriteria, paramLocationListener, paramLooper);
                return;
              }
              if (((kx.a)localObject).b) {
                return;
              }
              aiz.a(paramLong, paramFloat, paramCriteria, paramLocationListener, paramLooper);
              return;
            }
          }
          aiz.a(paramLong, paramFloat, paramCriteria, paramLocationListener, paramLooper);
        }
        
        public final void requestLocationUpdates(String paramString, long paramLong, float paramFloat, PendingIntent paramPendingIntent)
        {
          Object localObject = new StringBuilder("requestLocationUpdates, provider:[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("]");
          if (kx.a())
          {
            localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("requestLocationUpdates");
              if (localObject == null)
              {
                aiz.a(paramString, paramLong, paramFloat, paramPendingIntent);
                return;
              }
              if (((kx.a)localObject).b) {
                return;
              }
              aiz.a(paramString, paramLong, paramFloat, paramPendingIntent);
              return;
            }
          }
          aiz.a(paramString, paramLong, paramFloat, paramPendingIntent);
        }
        
        public final void requestLocationUpdates(String paramString, long paramLong, float paramFloat, LocationListener paramLocationListener)
        {
          Object localObject = new StringBuilder("requestLocationUpdates, provider:[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("]");
          if (kx.a())
          {
            localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("requestLocationUpdates");
              if (localObject == null)
              {
                aiz.a(paramString, paramLong, paramFloat, paramLocationListener);
                return;
              }
              if (((kx.a)localObject).b) {
                return;
              }
              aiz.a(paramString, paramLong, paramFloat, paramLocationListener);
              return;
            }
          }
          aiz.a(paramString, paramLong, paramFloat, paramLocationListener);
        }
        
        public final void requestLocationUpdates(String paramString, long paramLong, float paramFloat, LocationListener paramLocationListener, Looper paramLooper)
        {
          Object localObject = new StringBuilder("requestLocationUpdates, provider:[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("]");
          if (kx.a())
          {
            localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("requestLocationUpdates");
              if (localObject == null)
              {
                aiz.a(paramString, paramLong, paramFloat, paramLocationListener, paramLooper);
                return;
              }
              if (((kx.a)localObject).b) {
                return;
              }
              aiz.a(paramString, paramLong, paramFloat, paramLocationListener, paramLooper);
              return;
            }
          }
          aiz.a(paramString, paramLong, paramFloat, paramLocationListener, paramLooper);
        }
        
        public final void requestSingleUpdate(Criteria paramCriteria, PendingIntent paramPendingIntent)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("requestSingleUpdate");
              if (localObject == null)
              {
                aiz.a(paramCriteria, paramPendingIntent);
                return;
              }
              if (((kx.a)localObject).b) {
                return;
              }
              aiz.a(paramCriteria, paramPendingIntent);
              return;
            }
          }
          aiz.a(paramCriteria, paramPendingIntent);
        }
        
        public final void requestSingleUpdate(Criteria paramCriteria, LocationListener paramLocationListener, Looper paramLooper)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("requestSingleUpdate");
              if (localObject == null)
              {
                aiz.a(paramCriteria, paramLocationListener, paramLooper);
                return;
              }
              if (((kx.a)localObject).b) {
                return;
              }
              aiz.a(paramCriteria, paramLocationListener, paramLooper);
              return;
            }
          }
          aiz.a(paramCriteria, paramLocationListener, paramLooper);
        }
        
        public final void requestSingleUpdate(String paramString, PendingIntent paramPendingIntent)
        {
          Object localObject = new StringBuilder("requestSingleUpdate, provider:[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("]");
          if (kx.a())
          {
            localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("requestSingleUpdate");
              if (localObject == null)
              {
                aiz.a(paramString, paramPendingIntent);
                return;
              }
              if (((kx.a)localObject).b) {
                return;
              }
              aiz.a(paramString, paramPendingIntent);
              return;
            }
          }
          aiz.a(paramString, paramPendingIntent);
        }
        
        public final void requestSingleUpdate(String paramString, LocationListener paramLocationListener, Looper paramLooper)
        {
          Object localObject = new StringBuilder("requestSingleUpdate, provider:[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("]");
          if (kx.a())
          {
            localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("requestSingleUpdate");
              if (localObject == null)
              {
                aiz.a(paramString, paramLocationListener, paramLooper);
                return;
              }
              if (((kx.a)localObject).b) {
                return;
              }
              aiz.a(paramString, paramLocationListener, paramLooper);
              return;
            }
          }
          aiz.a(paramString, paramLocationListener, paramLooper);
        }
        
        public final void unregisterGnssStatusCallback(GnssStatus.Callback paramCallback)
        {
          if (kx.a())
          {
            Object localObject = ajh.this.a;
            if (localObject != null)
            {
              localObject = ((kw)localObject).a("unregisterGnssStatusCallback");
              if (localObject == null)
              {
                aiz.b(paramCallback);
                return;
              }
              if (((kx.a)localObject).b) {
                return;
              }
              aiz.b(paramCallback);
              return;
            }
          }
          aiz.b(paramCallback);
        }
      }
    }
  }
  
  public static final class f
  {
    public static ajh a = new ajh((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajh
 * JD-Core Version:    0.7.0.1
 */