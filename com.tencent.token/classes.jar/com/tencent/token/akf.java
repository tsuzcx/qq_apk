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

public final class akf
{
  public lk a = null;
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
    //   57: new 6	com/tencent/token/akf$a
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 74	com/tencent/token/akf$a:<init>	(Lcom/tencent/token/akf;)V
    //   65: invokevirtual 78	com/oasisfeng/condom/CondomOptions:setOutboundJudge	(Lcom/oasisfeng/condom/OutboundJudge;)Lcom/oasisfeng/condom/CondomOptions;
    //   68: pop
    //   69: ldc2_w 79
    //   72: lload_2
    //   73: land
    //   74: lconst_0
    //   75: lcmp
    //   76: ifeq +17 -> 93
    //   79: aload 4
    //   81: new 8	com/tencent/token/akf$b
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 81	com/tencent/token/akf$b:<init>	(Lcom/tencent/token/akf;)V
    //   89: invokevirtual 85	com/oasisfeng/condom/CondomOptions:setPackageManagerFactory	(Lcom/tencent/token/ajv;)Lcom/oasisfeng/condom/CondomOptions;
    //   92: pop
    //   93: ldc2_w 86
    //   96: lload_2
    //   97: land
    //   98: lconst_0
    //   99: lcmp
    //   100: ifeq +17 -> 117
    //   103: aload 4
    //   105: new 12	com/tencent/token/akf$c
    //   108: dup
    //   109: aload_0
    //   110: invokespecial 88	com/tencent/token/akf$c:<init>	(Lcom/tencent/token/akf;)V
    //   113: invokevirtual 92	com/oasisfeng/condom/CondomOptions:addKit	(Lcom/tencent/token/la;)Lcom/oasisfeng/condom/CondomOptions;
    //   116: pop
    //   117: ldc2_w 93
    //   120: lload_2
    //   121: land
    //   122: lconst_0
    //   123: lcmp
    //   124: ifeq +17 -> 141
    //   127: aload 4
    //   129: new 18	com/tencent/token/akf$d
    //   132: dup
    //   133: aload_0
    //   134: invokespecial 95	com/tencent/token/akf$d:<init>	(Lcom/tencent/token/akf;)V
    //   137: invokevirtual 92	com/oasisfeng/condom/CondomOptions:addKit	(Lcom/tencent/token/la;)Lcom/oasisfeng/condom/CondomOptions;
    //   140: pop
    //   141: ldc2_w 96
    //   144: lload_2
    //   145: land
    //   146: lconst_0
    //   147: lcmp
    //   148: ifeq +17 -> 165
    //   151: aload 4
    //   153: new 24	com/tencent/token/akf$e
    //   156: dup
    //   157: aload_0
    //   158: invokespecial 98	com/tencent/token/akf$e:<init>	(Lcom/tencent/token/akf;)V
    //   161: invokevirtual 92	com/oasisfeng/condom/CondomOptions:addKit	(Lcom/tencent/token/la;)Lcom/oasisfeng/condom/CondomOptions;
    //   164: pop
    //   165: aload_0
    //   166: new 100	com/tencent/token/ajw
    //   169: dup
    //   170: aload_1
    //   171: aload_1
    //   172: ldc 102
    //   174: aload 4
    //   176: invokestatic 108	com/oasisfeng/condom/CondomContext:wrap	(Landroid/content/Context;Ljava/lang/String;Lcom/oasisfeng/condom/CondomOptions;)Lcom/oasisfeng/condom/CondomContext;
    //   179: lload_2
    //   180: invokespecial 111	com/tencent/token/ajw:<init>	(Landroid/content/Context;Lcom/oasisfeng/condom/CondomContext;J)V
    //   183: putfield 113	com/tencent/token/akf:b	Landroid/content/Context;
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
    //   222: getfield 113	com/tencent/token/akf:b	Landroid/content/Context;
    //   225: astore 4
    //   227: aload 4
    //   229: ifnonnull +5 -> 234
    //   232: aload_1
    //   233: areturn
    //   234: aload 4
    //   236: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	akf
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
    implements ajv
  {
    b() {}
    
    public final PackageManagerWrapper a(Context paramContext)
    {
      ajz.a = paramContext.getPackageManager();
      return new a(ajz.a);
    }
    
    final class a
      extends aka
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
        if (ll.a())
        {
          localObject = akf.this.a;
          if (localObject != null)
          {
            localObject = ((lk)localObject).a("getInstalledApplications");
            if (localObject == null) {
              return ajz.b(paramInt);
            }
            if (((ll.a)localObject).b) {
              return (List)((ll.a)localObject).a;
            }
            ((ll.a)localObject).a = ajz.b(paramInt);
            return (List)((ll.a)localObject).a;
          }
        }
        return ajz.b(paramInt);
      }
      
      public final List<PackageInfo> getInstalledPackages(int paramInt)
      {
        Object localObject = new StringBuilder("getInstalledPackages, flags:[");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("]");
        if (ll.a())
        {
          localObject = akf.this.a;
          if (localObject != null)
          {
            localObject = ((lk)localObject).a("getInstalledPackages");
            if (localObject == null) {
              return ajz.a(paramInt);
            }
            if (((ll.a)localObject).b) {
              return (List)((ll.a)localObject).a;
            }
            ((ll.a)localObject).a = ajz.a(paramInt);
            return (List)((ll.a)localObject).a;
          }
        }
        return ajz.a(paramInt);
      }
      
      public final List<ResolveInfo> queryBroadcastReceivers(Intent paramIntent, int paramInt)
      {
        Object localObject = new StringBuilder("queryBroadcastReceivers, flags:[");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("]");
        if (ll.a())
        {
          localObject = akf.this.a;
          if (localObject != null)
          {
            localObject = ((lk)localObject).a("queryBroadcastReceivers");
            if (localObject == null) {
              return ajz.a(paramIntent, paramInt);
            }
            if (((ll.a)localObject).b) {
              return (List)((ll.a)localObject).a;
            }
            ((ll.a)localObject).a = ajz.a(paramIntent, paramInt);
            return (List)((ll.a)localObject).a;
          }
        }
        return ajz.a(paramIntent, paramInt);
      }
      
      public final List<ResolveInfo> queryIntentActivities(Intent paramIntent, int paramInt)
      {
        Object localObject = new StringBuilder("queryIntentActivities, flags:[");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("]");
        if (ll.a())
        {
          localObject = akf.this.a;
          if (localObject != null)
          {
            localObject = ((lk)localObject).a("queryIntentActivities");
            if (localObject == null) {
              return ajz.c(paramIntent, paramInt);
            }
            if (((ll.a)localObject).b) {
              return (List)((ll.a)localObject).a;
            }
            ((ll.a)localObject).a = ajz.c(paramIntent, paramInt);
            return (List)((ll.a)localObject).a;
          }
        }
        return ajz.c(paramIntent, paramInt);
      }
      
      public final List<ResolveInfo> queryIntentActivityOptions(ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt)
      {
        Object localObject = new StringBuilder("queryIntentActivityOptions, caller:[");
        ((StringBuilder)localObject).append(paramComponentName);
        ((StringBuilder)localObject).append("]flags:[");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("]");
        if (ll.a())
        {
          localObject = akf.this.a;
          if (localObject != null)
          {
            localObject = ((lk)localObject).a("queryIntentActivityOptions");
            if (localObject == null) {
              return ajz.a(paramComponentName, paramArrayOfIntent, paramIntent, paramInt);
            }
            if (((ll.a)localObject).b) {
              return (List)((ll.a)localObject).a;
            }
            ((ll.a)localObject).a = ajz.a(paramComponentName, paramArrayOfIntent, paramIntent, paramInt);
            return (List)((ll.a)localObject).a;
          }
        }
        return ajz.a(paramComponentName, paramArrayOfIntent, paramIntent, paramInt);
      }
      
      public final List<ResolveInfo> queryIntentServices(Intent paramIntent, int paramInt)
      {
        Object localObject = new StringBuilder("queryIntentServices, flags:[");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("]");
        if (ll.a())
        {
          localObject = akf.this.a;
          if (localObject != null)
          {
            localObject = ((lk)localObject).a("queryIntentServices");
            if (localObject == null) {
              return ajz.b(paramIntent, paramInt);
            }
            if (((ll.a)localObject).b) {
              return (List)((ll.a)localObject).a;
            }
            ((ll.a)localObject).a = ajz.b(paramIntent, paramInt);
            return (List)((ll.a)localObject).a;
          }
        }
        return ajz.b(paramIntent, paramInt);
      }
    }
  }
  
  final class c
    implements la
  {
    c() {}
    
    public final void a(la.a parama)
    {
      parama.a("phone", new a());
    }
    
    final class a
      implements la.b
    {
      a() {}
      
      public final Object a(Context paramContext)
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
        akb.a = localTelephonyManager;
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
        extends akc
      {
        a(Context paramContext, TelephonyManager paramTelephonyManager)
        {
          super(paramTelephonyManager);
        }
        
        @SuppressLint({"MissingPermission"})
        public final List<CellInfo> getAllCellInfo()
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getAllCellInfo");
              if (localObject == null) {
                return akb.b();
              }
              if (((ll.a)localObject).b) {
                return (List)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = akb.b();
              return (List)((ll.a)localObject).a;
            }
          }
          return akb.b();
        }
        
        @SuppressLint({"MissingPermission"})
        public final CellLocation getCellLocation()
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getCellLocation");
              if (localObject == null) {
                return akb.a();
              }
              if (((ll.a)localObject).b) {
                return (CellLocation)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = akb.a();
              return (CellLocation)((ll.a)localObject).a;
            }
          }
          return akb.a();
        }
        
        @SuppressLint({"MissingPermission"})
        public final String getDeviceId()
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getDeviceId");
              if (localObject == null) {
                return akb.c();
              }
              if (((ll.a)localObject).b) {
                return (String)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = akb.c();
              return (String)((ll.a)localObject).a;
            }
          }
          return akb.c();
        }
        
        @SuppressLint({"MissingPermission"})
        public final String getDeviceId(int paramInt)
        {
          Object localObject = new StringBuilder("getDeviceId, slot:[");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append("]");
          if (ll.a())
          {
            localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getDeviceId");
              if (localObject == null) {
                return akb.a(paramInt);
              }
              if (((ll.a)localObject).b) {
                return (String)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = akb.a(paramInt);
              return (String)((ll.a)localObject).a;
            }
          }
          return akb.a(paramInt);
        }
        
        @SuppressLint({"MissingPermission"})
        public final String getImei()
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getImei");
              if (localObject == null) {
                return akb.d();
              }
              if (((ll.a)localObject).b) {
                return (String)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = akb.d();
              return (String)((ll.a)localObject).a;
            }
          }
          return akb.d();
        }
        
        @SuppressLint({"MissingPermission"})
        public final String getImei(int paramInt)
        {
          Object localObject = new StringBuilder("getImei, slot:[");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append("]");
          if (ll.a())
          {
            localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getImei");
              if (localObject == null) {
                return akb.b(paramInt);
              }
              if (((ll.a)localObject).b) {
                return (String)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = akb.b(paramInt);
              return (String)((ll.a)localObject).a;
            }
          }
          return akb.b(paramInt);
        }
        
        @SuppressLint({"MissingPermission"})
        public final String getLine1Number()
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getLine1Number");
              if (localObject == null) {
                return akb.h();
              }
              if (((ll.a)localObject).b) {
                return (String)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = akb.h();
              return (String)((ll.a)localObject).a;
            }
          }
          return akb.h();
        }
        
        @SuppressLint({"MissingPermission"})
        public final String getMeid()
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getMeid");
              if (localObject == null) {
                return akb.f();
              }
              if (((ll.a)localObject).b) {
                return (String)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = akb.f();
              return (String)((ll.a)localObject).a;
            }
          }
          return akb.f();
        }
        
        @SuppressLint({"MissingPermission"})
        public final String getMeid(int paramInt)
        {
          Object localObject = new StringBuilder("getMeid, slot:[");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append("]");
          if (ll.a())
          {
            localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getMeid");
              if (localObject == null) {
                return akb.c(paramInt);
              }
              if (((ll.a)localObject).b) {
                return (String)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = akb.c(paramInt);
              return (String)((ll.a)localObject).a;
            }
          }
          return akb.c(paramInt);
        }
        
        @SuppressLint({"MissingPermission", "NewApi"})
        public final ServiceState getServiceState()
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getServiceState");
              if (localObject == null) {
                return akb.i();
              }
              if (((ll.a)localObject).b) {
                return (ServiceState)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = akb.i();
              return (ServiceState)((ll.a)localObject).a;
            }
          }
          return akb.i();
        }
        
        @SuppressLint({"MissingPermission"})
        public final String getSimSerialNumber()
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getSimSerialNumber");
              if (localObject == null) {
                return akb.g();
              }
              if (((ll.a)localObject).b) {
                return (String)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = akb.g();
              return (String)((ll.a)localObject).a;
            }
          }
          return akb.g();
        }
        
        @SuppressLint({"MissingPermission"})
        public final String getSubscriberId()
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getSubscriberId");
              if (localObject == null) {
                return akb.e();
              }
              if (((ll.a)localObject).b) {
                return (String)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = akb.e();
              return (String)((ll.a)localObject).a;
            }
          }
          return akb.e();
        }
        
        public final void listen(PhoneStateListener paramPhoneStateListener, int paramInt)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("listen");
              if (localObject == null)
              {
                akb.a(paramPhoneStateListener, paramInt);
                return;
              }
              if (((ll.a)localObject).b) {
                return;
              }
              akb.a(paramPhoneStateListener, ((Integer)((ll.a)localObject).a).intValue());
              return;
            }
          }
          akb.a(paramPhoneStateListener, paramInt);
        }
      }
    }
  }
  
  final class d
    implements la
  {
    d() {}
    
    public final void a(la.a parama)
    {
      parama.a("wifi", new a());
    }
    
    final class a
      implements la.b
    {
      a() {}
      
      public final Object a(Context paramContext)
      {
        paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
        akd.a = paramContext;
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
        extends ake
      {
        a(WifiManager paramWifiManager)
        {
          super();
        }
        
        @SuppressLint({"MissingPermission"})
        public final List<WifiConfiguration> getConfiguredNetworks()
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getConfiguredNetworks");
              if (localObject == null) {
                return akd.c();
              }
              if (((ll.a)localObject).b) {
                return (List)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = akd.c();
              return (List)((ll.a)localObject).a;
            }
          }
          return akd.c();
        }
        
        @SuppressLint({"MissingPermission"})
        public final WifiInfo getConnectionInfo()
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getConnectionInfo");
              if (localObject == null) {
                return akd.a();
              }
              if (((ll.a)localObject).b) {
                return (WifiInfo)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = akd.a();
              return (WifiInfo)((ll.a)localObject).a;
            }
          }
          return akd.a();
        }
        
        @SuppressLint({"MissingPermission"})
        public final List<ScanResult> getScanResults()
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getScanResults");
              if (localObject == null) {
                return akd.b();
              }
              if (((ll.a)localObject).b) {
                return (List)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = akd.b();
              return (List)((ll.a)localObject).a;
            }
          }
          return akd.b();
        }
        
        public final void startLocalOnlyHotspot(WifiManager.LocalOnlyHotspotCallback paramLocalOnlyHotspotCallback, Handler paramHandler)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("startLocalOnlyHotspot");
              if (localObject == null)
              {
                akd.a(paramLocalOnlyHotspotCallback, paramHandler);
                return;
              }
              if (((ll.a)localObject).b) {
                return;
              }
              akd.a(paramLocalOnlyHotspotCallback, paramHandler);
              return;
            }
          }
          akd.a(paramLocalOnlyHotspotCallback, paramHandler);
        }
        
        @SuppressLint({"MissingPermission"})
        public final boolean startScan()
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("startScan");
              if (localObject == null) {
                return akd.d();
              }
              if (((ll.a)localObject).b) {
                return ((Boolean)((ll.a)localObject).a).booleanValue();
              }
              ((ll.a)localObject).a = Boolean.valueOf(akd.d());
              return ((Boolean)((ll.a)localObject).a).booleanValue();
            }
          }
          return akd.d();
        }
      }
    }
  }
  
  final class e
    implements la
  {
    e() {}
    
    public final void a(la.a parama)
    {
      parama.a("location", new a());
    }
    
    final class a
      implements la.b
    {
      a() {}
      
      public final Object a(Context paramContext)
      {
        paramContext = (LocationManager)paramContext.getApplicationContext().getSystemService("location");
        try
        {
          ajx.a = paramContext;
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
        extends ajy
      {
        a(LocationManager paramLocationManager)
        {
          super();
        }
        
        @SuppressLint({"MissingPermission"})
        public final boolean addGpsStatusListener(GpsStatus.Listener paramListener)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("addGpsStatusListener");
              if (localObject == null) {
                return ajx.a(paramListener);
              }
              if (((ll.a)localObject).b) {
                return ((Boolean)((ll.a)localObject).a).booleanValue();
              }
              ((ll.a)localObject).a = Boolean.valueOf(ajx.a(paramListener));
              return ((Boolean)((ll.a)localObject).a).booleanValue();
            }
          }
          return ajx.a(paramListener);
        }
        
        @SuppressLint({"MissingPermission"})
        public final boolean addNmeaListener(OnNmeaMessageListener paramOnNmeaMessageListener)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("addNmeaListener");
              if (localObject == null) {
                return ajx.a(paramOnNmeaMessageListener);
              }
              if (((ll.a)localObject).b) {
                return ((Boolean)((ll.a)localObject).a).booleanValue();
              }
              ((ll.a)localObject).a = Boolean.valueOf(ajx.a(paramOnNmeaMessageListener));
              return ((Boolean)((ll.a)localObject).a).booleanValue();
            }
          }
          return ajx.a(paramOnNmeaMessageListener);
        }
        
        @SuppressLint({"MissingPermission"})
        public final boolean addNmeaListener(OnNmeaMessageListener paramOnNmeaMessageListener, Handler paramHandler)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("addNmeaListener");
              if (localObject == null) {
                return ajx.a(paramOnNmeaMessageListener, paramHandler);
              }
              if (((ll.a)localObject).b) {
                return ((Boolean)((ll.a)localObject).a).booleanValue();
              }
              ((ll.a)localObject).a = Boolean.valueOf(ajx.a(paramOnNmeaMessageListener, paramHandler));
              return ((Boolean)((ll.a)localObject).a).booleanValue();
            }
          }
          return ajx.a(paramOnNmeaMessageListener, paramHandler);
        }
        
        @SuppressLint({"MissingPermission"})
        public final void addProximityAlert(double paramDouble1, double paramDouble2, float paramFloat, long paramLong, PendingIntent paramPendingIntent)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("addProximityAlert");
              if (localObject == null)
              {
                ajx.a(paramDouble1, paramDouble2, paramFloat, paramLong, paramPendingIntent);
                return;
              }
              if (((ll.a)localObject).b) {
                return;
              }
              ajx.a(paramDouble1, paramDouble2, paramFloat, paramLong, paramPendingIntent);
              return;
            }
          }
          ajx.a(paramDouble1, paramDouble2, paramFloat, paramLong, paramPendingIntent);
        }
        
        public final List<String> getAllProviders()
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getAllProviders");
              if (localObject == null) {
                return ajx.a();
              }
              if (((ll.a)localObject).b) {
                return (List)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = ajx.a();
              return (List)((ll.a)localObject).a;
            }
          }
          return ajx.a();
        }
        
        public final String getBestProvider(Criteria paramCriteria, boolean paramBoolean)
        {
          Object localObject = new StringBuilder("getBestProvider, enabledOnly:[");
          ((StringBuilder)localObject).append(paramBoolean);
          ((StringBuilder)localObject).append("]");
          if (ll.a())
          {
            localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getBestProvider");
              if (localObject == null) {
                return ajx.b(paramCriteria, paramBoolean);
              }
              if (((ll.a)localObject).b) {
                return (String)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = ajx.b(paramCriteria, paramBoolean);
              return (String)((ll.a)localObject).a;
            }
          }
          return ajx.b(paramCriteria, paramBoolean);
        }
        
        @SuppressLint({"MissingPermission"})
        public final GpsStatus getGpsStatus(GpsStatus paramGpsStatus)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getGpsStatus");
              if (localObject == null) {
                return ajx.a(paramGpsStatus);
              }
              if (((ll.a)localObject).b) {
                return (GpsStatus)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = ajx.a(paramGpsStatus);
              return (GpsStatus)((ll.a)localObject).a;
            }
          }
          return ajx.a(paramGpsStatus);
        }
        
        @SuppressLint({"MissingPermission"})
        public final Location getLastKnownLocation(String paramString)
        {
          Object localObject = new StringBuilder("getLastKnownLocation, provider:[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("]");
          if (ll.a())
          {
            localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getLastKnownLocation");
              if (localObject == null) {
                return ajx.c(paramString);
              }
              if (((ll.a)localObject).b) {
                return (Location)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = ajx.c(paramString);
              return (Location)((ll.a)localObject).a;
            }
          }
          return ajx.c(paramString);
        }
        
        public final LocationProvider getProvider(String paramString)
        {
          Object localObject = new StringBuilder("getProvider, name:[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("]");
          if (ll.a())
          {
            localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getProvider");
              if (localObject == null) {
                return ajx.b(paramString);
              }
              if (((ll.a)localObject).b) {
                return (LocationProvider)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = ajx.b(paramString);
              return (LocationProvider)((ll.a)localObject).a;
            }
          }
          return ajx.b(paramString);
        }
        
        public final List<String> getProviders(Criteria paramCriteria, boolean paramBoolean)
        {
          Object localObject = new StringBuilder("getProviders, enabledOnly:[");
          ((StringBuilder)localObject).append(paramBoolean);
          ((StringBuilder)localObject).append("]");
          if (ll.a())
          {
            localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getProviders");
              if (localObject == null) {
                return ajx.a(paramCriteria, paramBoolean);
              }
              if (((ll.a)localObject).b) {
                return (List)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = ajx.a(paramCriteria, paramBoolean);
              return (List)((ll.a)localObject).a;
            }
          }
          return ajx.a(paramCriteria, paramBoolean);
        }
        
        public final List<String> getProviders(boolean paramBoolean)
        {
          Object localObject = new StringBuilder("getProviders, enabledOnly:[");
          ((StringBuilder)localObject).append(paramBoolean);
          ((StringBuilder)localObject).append("]");
          if (ll.a())
          {
            localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("getProviders");
              if (localObject == null) {
                return ajx.a(paramBoolean);
              }
              if (((ll.a)localObject).b) {
                return (List)((ll.a)localObject).a;
              }
              ((ll.a)localObject).a = ajx.a(paramBoolean);
              return (List)((ll.a)localObject).a;
            }
          }
          return ajx.a(paramBoolean);
        }
        
        public final boolean isProviderEnabled(String paramString)
        {
          Object localObject = new StringBuilder("isProviderEnabled, provider:[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("]");
          if (ll.a())
          {
            localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("isProviderEnabled");
              if (localObject == null) {
                return ajx.a(paramString);
              }
              if (((ll.a)localObject).b) {
                return ((Boolean)((ll.a)localObject).a).booleanValue();
              }
              ((ll.a)localObject).a = Boolean.valueOf(ajx.a(paramString));
              return ((Boolean)((ll.a)localObject).a).booleanValue();
            }
          }
          return ajx.a(paramString);
        }
        
        @SuppressLint({"MissingPermission"})
        public final boolean registerGnssMeasurementsCallback(GnssMeasurementsEvent.Callback paramCallback)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("registerGnssMeasurementsCallback");
              if (localObject == null) {
                return ajx.a(paramCallback);
              }
              if (((ll.a)localObject).b) {
                return ((Boolean)((ll.a)localObject).a).booleanValue();
              }
              ((ll.a)localObject).a = Boolean.valueOf(ajx.a(paramCallback));
              return ((Boolean)((ll.a)localObject).a).booleanValue();
            }
          }
          return ajx.a(paramCallback);
        }
        
        @SuppressLint({"MissingPermission"})
        public final boolean registerGnssMeasurementsCallback(GnssMeasurementsEvent.Callback paramCallback, Handler paramHandler)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("registerGnssMeasurementsCallback");
              if (localObject == null) {
                return ajx.a(paramCallback, paramHandler);
              }
              if (((ll.a)localObject).b) {
                return ((Boolean)((ll.a)localObject).a).booleanValue();
              }
              ((ll.a)localObject).a = Boolean.valueOf(ajx.a(paramCallback, paramHandler));
              return ((Boolean)((ll.a)localObject).a).booleanValue();
            }
          }
          return ajx.a(paramCallback, paramHandler);
        }
        
        @SuppressLint({"MissingPermission"})
        public final boolean registerGnssNavigationMessageCallback(GnssNavigationMessage.Callback paramCallback, Handler paramHandler)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("registerGnssNavigationMessageCallback");
              if (localObject == null) {
                return ajx.a(paramCallback, paramHandler);
              }
              if (((ll.a)localObject).b) {
                return ((Boolean)((ll.a)localObject).a).booleanValue();
              }
              ((ll.a)localObject).a = Boolean.valueOf(ajx.a(paramCallback, paramHandler));
              return ((Boolean)((ll.a)localObject).a).booleanValue();
            }
          }
          return ajx.a(paramCallback, paramHandler);
        }
        
        @SuppressLint({"MissingPermission"})
        public final boolean registerGnssStatusCallback(GnssStatus.Callback paramCallback)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("registerGnssStatusCallback");
              if (localObject == null) {
                return ajx.a(paramCallback);
              }
              if (((ll.a)localObject).b) {
                return ((Boolean)((ll.a)localObject).a).booleanValue();
              }
              ((ll.a)localObject).a = Boolean.valueOf(ajx.a(paramCallback));
              return ((Boolean)((ll.a)localObject).a).booleanValue();
            }
          }
          return ajx.a(paramCallback);
        }
        
        @SuppressLint({"MissingPermission"})
        public final boolean registerGnssStatusCallback(GnssStatus.Callback paramCallback, Handler paramHandler)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("registerGnssStatusCallback");
              if (localObject == null) {
                return ajx.a(paramCallback, paramHandler);
              }
              if (((ll.a)localObject).b) {
                return ((Boolean)((ll.a)localObject).a).booleanValue();
              }
              ((ll.a)localObject).a = Boolean.valueOf(ajx.a(paramCallback, paramHandler));
              return ((Boolean)((ll.a)localObject).a).booleanValue();
            }
          }
          return ajx.a(paramCallback, paramHandler);
        }
        
        public final void removeGpsStatusListener(GpsStatus.Listener paramListener)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("removeGpsStatusListener");
              if (localObject == null)
              {
                ajx.b(paramListener);
                return;
              }
              if (((ll.a)localObject).b) {
                return;
              }
              ajx.b(paramListener);
              return;
            }
          }
          ajx.b(paramListener);
        }
        
        public final void removeUpdates(PendingIntent paramPendingIntent)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("removeUpdates");
              if (localObject == null)
              {
                ajx.a(paramPendingIntent);
                return;
              }
              if (((ll.a)localObject).b) {
                return;
              }
              ajx.a(paramPendingIntent);
              return;
            }
          }
          ajx.a(paramPendingIntent);
        }
        
        public final void removeUpdates(LocationListener paramLocationListener)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("removeUpdates");
              if (localObject == null)
              {
                ajx.a(paramLocationListener);
                return;
              }
              if (((ll.a)localObject).b) {
                return;
              }
              ajx.a(paramLocationListener);
              return;
            }
          }
          ajx.a(paramLocationListener);
        }
        
        public final void requestLocationUpdates(long paramLong, float paramFloat, Criteria paramCriteria, PendingIntent paramPendingIntent)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("requestLocationUpdates");
              if (localObject == null)
              {
                ajx.a(paramLong, paramFloat, paramCriteria, paramPendingIntent);
                return;
              }
              if (((ll.a)localObject).b) {
                return;
              }
              ajx.a(paramLong, paramFloat, paramCriteria, paramPendingIntent);
              return;
            }
          }
          ajx.a(paramLong, paramFloat, paramCriteria, paramPendingIntent);
        }
        
        public final void requestLocationUpdates(long paramLong, float paramFloat, Criteria paramCriteria, LocationListener paramLocationListener, Looper paramLooper)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("requestLocationUpdates");
              if (localObject == null)
              {
                ajx.a(paramLong, paramFloat, paramCriteria, paramLocationListener, paramLooper);
                return;
              }
              if (((ll.a)localObject).b) {
                return;
              }
              ajx.a(paramLong, paramFloat, paramCriteria, paramLocationListener, paramLooper);
              return;
            }
          }
          ajx.a(paramLong, paramFloat, paramCriteria, paramLocationListener, paramLooper);
        }
        
        public final void requestLocationUpdates(String paramString, long paramLong, float paramFloat, PendingIntent paramPendingIntent)
        {
          Object localObject = new StringBuilder("requestLocationUpdates, provider:[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("]");
          if (ll.a())
          {
            localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("requestLocationUpdates");
              if (localObject == null)
              {
                ajx.a(paramString, paramLong, paramFloat, paramPendingIntent);
                return;
              }
              if (((ll.a)localObject).b) {
                return;
              }
              ajx.a(paramString, paramLong, paramFloat, paramPendingIntent);
              return;
            }
          }
          ajx.a(paramString, paramLong, paramFloat, paramPendingIntent);
        }
        
        public final void requestLocationUpdates(String paramString, long paramLong, float paramFloat, LocationListener paramLocationListener)
        {
          Object localObject = new StringBuilder("requestLocationUpdates, provider:[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("]");
          if (ll.a())
          {
            localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("requestLocationUpdates");
              if (localObject == null)
              {
                ajx.a(paramString, paramLong, paramFloat, paramLocationListener);
                return;
              }
              if (((ll.a)localObject).b) {
                return;
              }
              ajx.a(paramString, paramLong, paramFloat, paramLocationListener);
              return;
            }
          }
          ajx.a(paramString, paramLong, paramFloat, paramLocationListener);
        }
        
        public final void requestLocationUpdates(String paramString, long paramLong, float paramFloat, LocationListener paramLocationListener, Looper paramLooper)
        {
          Object localObject = new StringBuilder("requestLocationUpdates, provider:[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("]");
          if (ll.a())
          {
            localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("requestLocationUpdates");
              if (localObject == null)
              {
                ajx.a(paramString, paramLong, paramFloat, paramLocationListener, paramLooper);
                return;
              }
              if (((ll.a)localObject).b) {
                return;
              }
              ajx.a(paramString, paramLong, paramFloat, paramLocationListener, paramLooper);
              return;
            }
          }
          ajx.a(paramString, paramLong, paramFloat, paramLocationListener, paramLooper);
        }
        
        public final void requestSingleUpdate(Criteria paramCriteria, PendingIntent paramPendingIntent)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("requestSingleUpdate");
              if (localObject == null)
              {
                ajx.a(paramCriteria, paramPendingIntent);
                return;
              }
              if (((ll.a)localObject).b) {
                return;
              }
              ajx.a(paramCriteria, paramPendingIntent);
              return;
            }
          }
          ajx.a(paramCriteria, paramPendingIntent);
        }
        
        public final void requestSingleUpdate(Criteria paramCriteria, LocationListener paramLocationListener, Looper paramLooper)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("requestSingleUpdate");
              if (localObject == null)
              {
                ajx.a(paramCriteria, paramLocationListener, paramLooper);
                return;
              }
              if (((ll.a)localObject).b) {
                return;
              }
              ajx.a(paramCriteria, paramLocationListener, paramLooper);
              return;
            }
          }
          ajx.a(paramCriteria, paramLocationListener, paramLooper);
        }
        
        public final void requestSingleUpdate(String paramString, PendingIntent paramPendingIntent)
        {
          Object localObject = new StringBuilder("requestSingleUpdate, provider:[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("]");
          if (ll.a())
          {
            localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("requestSingleUpdate");
              if (localObject == null)
              {
                ajx.a(paramString, paramPendingIntent);
                return;
              }
              if (((ll.a)localObject).b) {
                return;
              }
              ajx.a(paramString, paramPendingIntent);
              return;
            }
          }
          ajx.a(paramString, paramPendingIntent);
        }
        
        public final void requestSingleUpdate(String paramString, LocationListener paramLocationListener, Looper paramLooper)
        {
          Object localObject = new StringBuilder("requestSingleUpdate, provider:[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("]");
          if (ll.a())
          {
            localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("requestSingleUpdate");
              if (localObject == null)
              {
                ajx.a(paramString, paramLocationListener, paramLooper);
                return;
              }
              if (((ll.a)localObject).b) {
                return;
              }
              ajx.a(paramString, paramLocationListener, paramLooper);
              return;
            }
          }
          ajx.a(paramString, paramLocationListener, paramLooper);
        }
        
        public final void unregisterGnssStatusCallback(GnssStatus.Callback paramCallback)
        {
          if (ll.a())
          {
            Object localObject = akf.this.a;
            if (localObject != null)
            {
              localObject = ((lk)localObject).a("unregisterGnssStatusCallback");
              if (localObject == null)
              {
                ajx.b(paramCallback);
                return;
              }
              if (((ll.a)localObject).b) {
                return;
              }
              ajx.b(paramCallback);
              return;
            }
          }
          ajx.b(paramCallback);
        }
      }
    }
  }
  
  public static final class f
  {
    public static akf a = new akf((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.akf
 * JD-Core Version:    0.7.0.1
 */