package com.tencent.token;

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
import com.tencent.turingfd.sdk.base.Date;
import com.tencent.turingfd.sdk.base.Dew;
import com.tencent.turingfd.sdk.base.Fig;
import com.tencent.turingfd.sdk.base.Flat;
import com.tencent.turingfd.sdk.base.Guava;
import com.tencent.turingfd.sdk.base.Herbaceous;
import com.tencent.turingfd.sdk.base.Lemon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ado
{
  public static final afk<ado> a = new a();
  public static int b = -1;
  public static final int[] c = { 1, 5, 4, 8, 9, 2 };
  public Context d;
  public final Handler e;
  public AtomicBoolean f = new AtomicBoolean(false);
  public adh g;
  
  public ado()
  {
    HandlerThread localHandlerThread = new HandlerThread("TuringMMCore");
    localHandlerThread.start();
    this.e = new Handler(localHandlerThread.getLooper());
  }
  
  public static ado a()
  {
    return (ado)a.b();
  }
  
  private static Dew b(Context paramContext, String paramString, Dew paramDew)
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
      label45:
      int j;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      break label45;
    }
    i = 0;
    paramDew.Mb = i;
    paramDew.S = "09AEBC42447E1917";
    paramDew.Nb = afi.a;
    paramDew.Ob = 0;
    localObject1 = paramContext.getPackageName();
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    paramDew.Pb = paramString;
    localObject1 = aez.e(paramContext);
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    paramDew.H = paramString;
    localObject1 = aez.f(paramContext);
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
      if (paramString != null)
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
    paramDew.Tb = b;
    localObject2 = new StringBuilder();
    localObject1 = aez.a(true);
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("_");
    localObject1 = aez.a(false);
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("_");
    localObject1 = aez.g(paramContext);
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    ((StringBuilder)localObject2).append(paramString);
    paramDew.Xb = ((StringBuilder)localObject2).toString();
    paramDew.Yb = 49;
    paramDew._b = acs.c();
    paramDew.bc = acs.b();
    if (paramDew.cc == null) {
      paramDew.cc = new ArrayList();
    }
    paramDew.cc.addAll(afc.b(paramContext));
    paramDew.cc.addAll(afc.a(paramContext));
    paramDew.cc.addAll(aew.a(paramContext));
    localObject2 = paramDew.cc;
    localObject1 = afd.a;
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = afd.a(paramContext);
    }
    ((ArrayList)localObject2).addAll(paramString);
    paramString = paramDew.cc;
    localObject1 = new ArrayList();
    localObject2 = aez.d(paramContext);
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = new Flat();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(afn.c);
      ((StringBuilder)localObject4).append(afn.f);
      ((Flat)localObject3).sc = ((StringBuilder)localObject4).toString();
      ((Flat)localObject3).tc = ((String)localObject2);
      ((ArrayList)localObject1).add(localObject3);
    }
    paramString.addAll((Collection)localObject1);
    paramDew.cc.addAll(aey.a());
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
        String str = aez.c(((AccessibilityServiceInfo)localObject4).getId().getBytes()).toUpperCase();
        if (!((aeo)aeo.b.b()).c.contains(str))
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
      label764:
      break label764;
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
      ((StringBuilder)localObject4).append(afn.c);
      ((StringBuilder)localObject4).append(afn.j);
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
      ((StringBuilder)localObject3).append(afn.c);
      ((StringBuilder)localObject3).append(afn.k);
      ((Flat)localObject2).sc = ((StringBuilder)localObject3).toString();
      ((Flat)localObject2).tc = "1";
      ((ArrayList)localObject1).add(localObject2);
    }
    paramString.addAll((Collection)localObject1);
    paramString = paramDew.cc;
    localObject1 = new ArrayList();
    i = aeu.a(paramContext);
    localObject2 = new Flat();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(afn.c);
    ((StringBuilder)localObject3).append(afn.m);
    ((Flat)localObject2).sc = ((StringBuilder)localObject3).toString();
    ((Flat)localObject2).tc = aev.a("", i);
    ((ArrayList)localObject1).add(localObject2);
    paramString.addAll((Collection)localObject1);
    paramString = paramDew.cc;
    localObject1 = (acq)acq.a.b();
    localObject2 = new ArrayList();
    localObject3 = new Flat();
    ((Flat)localObject3).sc = aev.a(new StringBuilder(), afn.c, "sign");
    localObject4 = aev.a("");
    ((StringBuilder)localObject4).append(((acq)localObject1).a(paramContext));
    ((Flat)localObject3).tc = ((StringBuilder)localObject4).toString();
    ((ArrayList)localObject2).add(localObject3);
    paramString.addAll((Collection)localObject2);
    localObject1 = paramDew.cc;
    localObject2 = new ArrayList();
    localObject3 = new Flat();
    ((Flat)localObject3).sc = aev.a(new StringBuilder(), afn.c, "vpn");
    if (aez.c()) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    ((Flat)localObject3).tc = paramString;
    ((ArrayList)localObject2).add(localObject3);
    ((Flat)localObject3).sc = aev.a(new StringBuilder(), afn.c, "proxy");
    if (aez.c(paramContext)) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    ((Flat)localObject3).tc = paramString;
    ((ArrayList)localObject2).add(localObject3);
    ((ArrayList)localObject1).addAll((Collection)localObject2);
    paramDew.fc = afb.a(paramContext);
    return paramDew;
  }
  
  public final void a(final Context paramContext, final int paramInt, final String paramString, final acz paramacz)
  {
    try
    {
      this.d = paramContext.getApplicationContext();
      Context localContext = this.d;
      if (localContext == null) {
        return;
      }
      this.e.post(new c(paramInt, paramacz, paramContext, paramString));
      return;
    }
    finally {}
  }
  
  public final boolean a(adh paramadh)
  {
    try
    {
      this.d = paramadh.c;
      this.g = paramadh;
      Object localObject = new d();
      acl localacl = (acl)acl.a.b();
      Handler localHandler = this.e;
      localacl.h = ((acf)localObject);
      if (localacl.b) {
        localacl.a(localHandler, (acf)localObject);
      }
      localacl.g = paramadh;
      localacl.b = true;
      if (localacl.c == null) {
        localacl.c = new acg(paramadh.c);
      }
      localacl.a();
      localacl.d = localHandler;
      localHandler.post(localacl.j);
      boolean bool = this.f.get();
      if (bool) {
        return true;
      }
      paramadh = (acn)acn.a.b();
      localObject = new b();
      paramadh.b.postDelayed((Runnable)localObject, 0L);
      return true;
    }
    finally {}
  }
  
  public static final class a
    extends afk<ado>
  {
    public final Object a()
    {
      return new ado((byte)0);
    }
  }
  
  public final class b
    extends ack
  {
    public b() {}
    
    public final void a()
    {
      ado.a(ado.this).set(true);
      if (aey.b == null) {
        aey.b = aey.b();
      }
      Context localContext = ado.b(ado.this);
      if (afd.a == null) {
        afd.a = afd.a(localContext);
      }
      acs.a();
      aey.a();
      ado.a(ado.this).set(false);
    }
  }
  
  public final class c
    extends ack
  {
    public c(int paramInt, acz paramacz, Context paramContext, String paramString) {}
    
    public final void a()
    {
      aea.a.b();
      adm localadm = aea.a(ado.b(ado.this), paramInt);
      if (localadm == null) {
        return;
      }
      Dew localDew = localadm.a;
      localDew = ado.a(paramContext, paramString, localDew);
      if (!ado.a(paramacz, localDew)) {
        return;
      }
      ado.a(localadm.b);
    }
  }
  
  public final class d
    implements acf
  {
    public final void a()
    {
      ado.d(this.a);
    }
    
    public final class a
      extends ack
    {
      public a(SparseArray paramSparseArray, List paramList, adh paramadh) {}
      
      public final void a()
      {
        int k = this.a;
        adh localadh = this.d;
        SparseArray localSparseArray = this.b;
        List localList = this.c;
        Dew localDew = new Dew();
        Lemon localLemon = localadh.e;
        Object localObject1 = new ArrayList();
        int i = 0;
        Object localObject2;
        while (i < localSparseArray.size())
        {
          localObject2 = ((acm)localSparseArray.valueAt(i)).a(localList);
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
          long l = localadh.e.od;
          i = localadh.d;
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
          aea.a.b();
          aea.a(this.d.c, this.a, localDew);
          localObject1 = this.d.f;
          if (localObject1 != null) {
            act.a(this.a, ((act.b)localObject1).a);
          }
          return;
        }
        throw new IllegalArgumentException("invalid stateUnits");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ado
 * JD-Core Version:    0.7.0.1
 */