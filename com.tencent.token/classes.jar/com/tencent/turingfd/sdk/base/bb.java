package com.tencent.turingfd.sdk.base;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.accessibility.AccessibilityManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class bb
{
  public static final cx<bb> a = new a();
  public static int b = -1;
  public static final int[] c = { 1, 5, 4, 8, 9, 2 };
  public Context d;
  public final Handler e;
  public AtomicBoolean f = new AtomicBoolean(false);
  public at g;
  
  public bb()
  {
    HandlerThread localHandlerThread = new HandlerThread("TuringMMCore");
    localHandlerThread.start();
    this.e = new Handler(localHandlerThread.getLooper());
  }
  
  public static bb a()
  {
    return (bb)a.b();
  }
  
  public final Dew a(Context paramContext, String paramString, Dew paramDew)
  {
    paramDew.Jb = System.currentTimeMillis();
    paramDew.Kb = paramString;
    paramString = paramContext.getPackageName();
    int m = 0;
    try
    {
      paramString = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      localObject1 = paramString.versionName;
      i = paramString.versionCode;
    }
    catch (Throwable paramString)
    {
      Object localObject1;
      int i;
      label46:
      int j;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      break label46;
    }
    i = 0;
    paramDew.Mb = i;
    paramDew.S = "09AEBC42447E1917";
    paramDew.Nb = cv.a;
    paramDew.Ob = 0;
    localObject1 = paramContext.getPackageName();
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    paramDew.Pb = paramString;
    localObject1 = cm.e(paramContext);
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    paramDew.H = paramString;
    localObject1 = cm.f(paramContext);
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    paramDew.I = paramString;
    localObject1 = Build.BRAND;
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    paramDew.Qb = paramString;
    localObject1 = Build.MODEL;
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    paramDew.Rb = paramString;
    localObject1 = Build.FINGERPRINT;
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    paramDew.Sb = paramString;
    paramDew.Ub = Build.VERSION.SDK_INT;
    paramDew.W = 2;
    if (b == -1)
    {
      paramString = (SensorManager)paramContext.getSystemService("sensor");
      if (paramString == null)
      {
        i = b;
      }
      else
      {
        i = 0;
        j = 1;
        for (;;)
        {
          localObject1 = c;
          if (i >= localObject1.length) {
            break;
          }
          int k;
          if (paramString.getDefaultSensor(localObject1[i]) == null) {
            k = 0;
          } else {
            k = 1;
          }
          j |= k << i;
          i += 1;
        }
        b = j;
      }
    }
    else
    {
      i = b;
    }
    paramDew.Tb = i;
    localObject2 = new StringBuilder();
    localObject1 = cm.a(true);
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("_");
    localObject1 = cm.a(false);
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("_");
    localObject1 = cm.g(paramContext);
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    ((StringBuilder)localObject2).append(paramString);
    paramDew.Xb = ((StringBuilder)localObject2).toString();
    paramDew.Yb = 49;
    paramDew._b = af.c();
    paramDew.bc = af.b();
    if (paramDew.cc == null) {
      paramDew.cc = new ArrayList();
    }
    paramDew.cc.addAll(cp.b(paramContext));
    paramDew.cc.addAll(cp.a(paramContext));
    paramDew.cc.addAll(cj.a(paramContext));
    localObject1 = paramDew.cc;
    paramString = cq.a;
    if (paramString == null) {
      paramString = cq.a(paramContext);
    }
    ((ArrayList)localObject1).addAll(paramString);
    paramString = paramDew.cc;
    localObject1 = new ArrayList();
    localObject2 = cm.d(paramContext);
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = new Flat();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(da.c);
      ((StringBuilder)localObject4).append(da.f);
      ((Flat)localObject3).sc = ((StringBuilder)localObject4).toString();
      ((Flat)localObject3).tc = ((String)localObject2);
      ((ArrayList)localObject1).add(localObject3);
    }
    paramString.addAll((Collection)localObject1);
    paramDew.cc.addAll(cl.a());
    paramString = paramDew.cc;
    localObject1 = new ArrayList();
    if (Build.VERSION.SDK_INT >= 14) {
      localObject2 = new HashSet();
    }
    try
    {
      localObject3 = ((AccessibilityManager)paramContext.getSystemService("accessibility")).getEnabledAccessibilityServiceList(-1);
      localObject3 = ((List)localObject3).iterator();
      i = 0;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (AccessibilityServiceInfo)((Iterator)localObject3).next();
        String str = cm.d(((AccessibilityServiceInfo)localObject4).getId().getBytes()).toUpperCase();
        if (!((cb)cb.b.b()).c.contains(str))
        {
          ((Set)localObject2).add(((AccessibilityServiceInfo)localObject4).getId());
          if (i >= 5) {
            break;
          }
          i += 1;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label793:
      break label793;
    }
    localObject3 = new StringBuilder();
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ((StringBuilder)localObject3).append((String)((Iterator)localObject2).next());
      ((StringBuilder)localObject3).append("_");
    }
    localObject2 = ((StringBuilder)localObject3).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = new Flat();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(da.c);
      ((StringBuilder)localObject4).append(da.j);
      ((Flat)localObject3).sc = ((StringBuilder)localObject4).toString();
      ((Flat)localObject3).tc = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
      ((List)localObject1).add(localObject3);
    }
    paramString.addAll((Collection)localObject1);
    paramString = paramDew.cc;
    localObject1 = new ArrayList();
    i = m;
    if (Settings.Secure.getInt(paramContext.getContentResolver(), "mock_location", 0) != 0) {
      i = 1;
    }
    if (i != 0)
    {
      localObject2 = new Flat();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(da.c);
      ((StringBuilder)localObject3).append(da.k);
      ((Flat)localObject2).sc = ((StringBuilder)localObject3).toString();
      ((Flat)localObject2).tc = "1";
      ((ArrayList)localObject1).add(localObject2);
    }
    paramString.addAll((Collection)localObject1);
    paramString = paramDew.cc;
    localObject1 = new ArrayList();
    i = ch.a(paramContext);
    localObject2 = new Flat();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(da.c);
    ((StringBuilder)localObject3).append(da.m);
    ((Flat)localObject2).sc = ((StringBuilder)localObject3).toString();
    ((Flat)localObject2).tc = ci.a("", i);
    ((ArrayList)localObject1).add(localObject2);
    paramString.addAll((Collection)localObject1);
    paramDew.cc.addAll(((ad)ad.a.b()).a(paramContext));
    localObject1 = paramDew.cc;
    localObject2 = new ArrayList();
    localObject3 = new Flat();
    ((Flat)localObject3).sc = ci.a(new StringBuilder(), da.c, "vpn");
    if (cm.c()) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    ((Flat)localObject3).tc = paramString;
    ((ArrayList)localObject2).add(localObject3);
    ((Flat)localObject3).sc = ci.a(new StringBuilder(), da.c, "proxy");
    if (cm.c(paramContext)) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    ((Flat)localObject3).tc = paramString;
    ((ArrayList)localObject2).add(localObject3);
    ((ArrayList)localObject1).addAll((Collection)localObject2);
    paramDew.fc = co.a(paramContext);
    return paramDew;
  }
  
  public void a(final Context paramContext, final int paramInt, final String paramString, final am paramam)
  {
    try
    {
      this.d = paramContext.getApplicationContext();
      Context localContext = this.d;
      if (localContext == null) {
        return;
      }
      this.e.post(new c("identify", paramInt, paramam, paramContext, paramString));
      return;
    }
    finally {}
  }
  
  public final void a(Collection<String> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      try
      {
        new File(str).delete();
      }
      catch (Throwable localThrowable)
      {
        label41:
        break label41;
      }
    }
  }
  
  public final boolean a(am paramam, Dew paramDew)
  {
    String str1 = da.a;
    String str2 = da.b;
    paramam = ((ah)paramam).a(4103, 14103, str1, str2, paramDew);
    return (paramam != null) && (paramam.hc == 0);
  }
  
  public boolean a(at paramat)
  {
    try
    {
      this.d = paramat.c;
      this.g = paramat;
      Object localObject = new d(null);
      y localy = (y)y.a.b();
      Handler localHandler = this.e;
      localy.h = ((s)localObject);
      if (localy.b) {
        localy.a(localHandler, (s)localObject);
      }
      localy.g = paramat;
      localy.b = true;
      if (localy.c == null) {
        localy.c = new t(paramat.c);
      }
      localy.a();
      localy.d = localHandler;
      localHandler.post(localy.j);
      boolean bool = this.f.get();
      if (bool) {
        return true;
      }
      paramat = (aa)aa.a.b();
      localObject = new b("pre");
      paramat.b.postDelayed((Runnable)localObject, 0);
      return true;
    }
    finally {}
  }
  
  public static final class a
    extends cx<bb>
  {
    public Object a()
    {
      return new bb(null);
    }
  }
  
  public class b
    extends x
  {
    public b(String paramString)
    {
      super();
    }
    
    public void a()
    {
      bb.a(bb.this).set(true);
      if (cl.b == null) {
        cl.b = cl.b();
      }
      Context localContext = bb.b(bb.this);
      if (cq.a == null) {
        cq.a = cq.a(localContext);
      }
      af.a();
      cl.a();
      bb.a(bb.this).set(false);
    }
  }
  
  public class c
    extends x
  {
    public c(String paramString1, int paramInt, am paramam, Context paramContext, String paramString2)
    {
      super();
    }
    
    public void a()
    {
      az localaz = ((bn)bn.a.b()).a(bb.b(bb.this), paramInt);
      if (localaz == null)
      {
        ((ah)paramam).a(-1);
        return;
      }
      Dew localDew = localaz.a;
      localDew = bb.a(bb.this, paramContext, paramString, localDew);
      if (!bb.a(bb.this, paramam, localDew)) {
        return;
      }
      bb.a(bb.this, localaz.b);
    }
  }
  
  private final class d
    implements s
  {
    public void a(int paramInt)
    {
      Object localObject = bb.d(this.a).f;
      if (localObject != null) {
        localObject = (ag.b)localObject;
      }
    }
    
    public void a(final at paramat, final List<ac> paramList, final SparseArray<z> paramSparseArray)
    {
      final int i = paramat.a;
      bb.a(this.a, false);
      bb.c(this.a).post(new a("saveSensorFile", i, paramSparseArray, paramList, paramat));
    }
    
    public class a
      extends x
    {
      public a(String paramString, int paramInt, SparseArray paramSparseArray, List paramList, at paramat)
      {
        super();
      }
      
      public void a()
      {
        int k = i;
        at localat = paramat;
        SparseArray localSparseArray = paramSparseArray;
        List localList = paramList;
        Dew localDew = new Dew();
        Lemon localLemon = localat.e;
        Object localObject1 = new ArrayList();
        int i = 0;
        Object localObject2;
        while (i < localSparseArray.size())
        {
          localObject2 = ((z)localSparseArray.valueAt(i)).a(localList);
          if (((ArrayList)localObject1).size() != 0)
          {
            int j = 0;
            while (j < ((ArrayList)localObject2).size())
            {
              ((Herbaceous)((ArrayList)localObject2).get(j)).Uc.putAll(((Herbaceous)((ArrayList)localObject1).get(j)).Uc);
              j += 1;
            }
          }
          i += 1;
          localObject1 = localObject2;
        }
        if ((((ArrayList)localObject1).size() > 0) && (((ArrayList)localObject1).get(0) != null))
        {
          localObject2 = new Guava();
          ((Guava)localObject2).Mc = ((Herbaceous)((ArrayList)localObject1).get(0)).Tc;
          ((Guava)localObject2).Nc = ((ArrayList)localObject1);
          ((Guava)localObject2).oc = k;
          ((Guava)localObject2).action = 1;
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(localLemon);
          ((Guava)localObject2).Qc = ((ArrayList)localObject1);
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(localObject2);
          localDew.Lb = ((ArrayList)localObject1);
          long l = localat.e.od;
          i = localat.d;
          localObject2 = new Fig();
          ((Fig)localObject2).nc = l;
          ((Fig)localObject2).oc = k;
          ((Fig)localObject2).mc = i;
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(localObject2);
          localObject2 = new Date();
          ((Date)localObject2).zb = ((ArrayList)localObject1);
          localDew.ac = ((Date)localObject2);
          localDew.cc = new ArrayList();
          ((bn)bn.a.b()).a(paramat.c, i, 0, localDew);
          localObject1 = paramat.f;
          if (localObject1 != null) {
            ag.a(i, ((ag.b)localObject1).a);
          }
          return;
        }
        throw new IllegalArgumentException("invalid stateUnits");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bb
 * JD-Core Version:    0.7.0.1
 */