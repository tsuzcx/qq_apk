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

public final class adn
{
  public static final afj<adn> a = new a();
  public static int b = -1;
  public static final int[] c = { 1, 5, 4, 8, 9, 2 };
  public Context d;
  public final Handler e;
  public AtomicBoolean f = new AtomicBoolean(false);
  public adg g;
  
  public adn()
  {
    HandlerThread localHandlerThread = new HandlerThread("TuringMMCore");
    localHandlerThread.start();
    this.e = new Handler(localHandlerThread.getLooper());
  }
  
  public static adn a()
  {
    return (adn)a.b();
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
    paramDew.Nb = afh.a;
    paramDew.Ob = 0;
    localObject1 = paramContext.getPackageName();
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    paramDew.Pb = paramString;
    localObject1 = aey.e(paramContext);
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    paramDew.H = paramString;
    localObject1 = aey.f(paramContext);
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
    localObject1 = aey.a(true);
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("_");
    localObject1 = aey.a(false);
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("_");
    localObject1 = aey.g(paramContext);
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    ((StringBuilder)localObject2).append(paramString);
    paramDew.Xb = ((StringBuilder)localObject2).toString();
    paramDew.Yb = 49;
    paramDew._b = acr.c();
    paramDew.bc = acr.b();
    if (paramDew.cc == null) {
      paramDew.cc = new ArrayList();
    }
    paramDew.cc.addAll(afb.b(paramContext));
    paramDew.cc.addAll(afb.a(paramContext));
    paramDew.cc.addAll(aev.a(paramContext));
    localObject2 = paramDew.cc;
    localObject1 = afc.a;
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = afc.a(paramContext);
    }
    ((ArrayList)localObject2).addAll(paramString);
    paramString = paramDew.cc;
    localObject1 = new ArrayList();
    localObject2 = aey.d(paramContext);
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = new Flat();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(afm.c);
      ((StringBuilder)localObject4).append(afm.f);
      ((Flat)localObject3).sc = ((StringBuilder)localObject4).toString();
      ((Flat)localObject3).tc = ((String)localObject2);
      ((ArrayList)localObject1).add(localObject3);
    }
    paramString.addAll((Collection)localObject1);
    paramDew.cc.addAll(aex.a());
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
        String str = aey.c(((AccessibilityServiceInfo)localObject4).getId().getBytes()).toUpperCase();
        if (!((aen)aen.b.b()).c.contains(str))
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
      ((StringBuilder)localObject4).append(afm.c);
      ((StringBuilder)localObject4).append(afm.j);
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
      ((StringBuilder)localObject3).append(afm.c);
      ((StringBuilder)localObject3).append(afm.k);
      ((Flat)localObject2).sc = ((StringBuilder)localObject3).toString();
      ((Flat)localObject2).tc = "1";
      ((ArrayList)localObject1).add(localObject2);
    }
    paramString.addAll((Collection)localObject1);
    paramString = paramDew.cc;
    localObject1 = new ArrayList();
    i = aet.a(paramContext);
    localObject2 = new Flat();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(afm.c);
    ((StringBuilder)localObject3).append(afm.m);
    ((Flat)localObject2).sc = ((StringBuilder)localObject3).toString();
    ((Flat)localObject2).tc = aeu.a("", i);
    ((ArrayList)localObject1).add(localObject2);
    paramString.addAll((Collection)localObject1);
    paramString = paramDew.cc;
    localObject1 = (acp)acp.a.b();
    localObject2 = new ArrayList();
    localObject3 = new Flat();
    ((Flat)localObject3).sc = aeu.a(new StringBuilder(), afm.c, "sign");
    localObject4 = aeu.a("");
    ((StringBuilder)localObject4).append(((acp)localObject1).a(paramContext));
    ((Flat)localObject3).tc = ((StringBuilder)localObject4).toString();
    ((ArrayList)localObject2).add(localObject3);
    paramString.addAll((Collection)localObject2);
    localObject1 = paramDew.cc;
    localObject2 = new ArrayList();
    localObject3 = new Flat();
    ((Flat)localObject3).sc = aeu.a(new StringBuilder(), afm.c, "vpn");
    if (aey.c()) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    ((Flat)localObject3).tc = paramString;
    ((ArrayList)localObject2).add(localObject3);
    ((Flat)localObject3).sc = aeu.a(new StringBuilder(), afm.c, "proxy");
    if (aey.c(paramContext)) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    ((Flat)localObject3).tc = paramString;
    ((ArrayList)localObject2).add(localObject3);
    ((ArrayList)localObject1).addAll((Collection)localObject2);
    paramDew.fc = afa.a(paramContext);
    return paramDew;
  }
  
  public final void a(final Context paramContext, final int paramInt, final String paramString, final acy paramacy)
  {
    try
    {
      this.d = paramContext.getApplicationContext();
      Context localContext = this.d;
      if (localContext == null) {
        return;
      }
      this.e.post(new c(paramInt, paramacy, paramContext, paramString));
      return;
    }
    finally {}
  }
  
  public final boolean a(adg paramadg)
  {
    try
    {
      this.d = paramadg.c;
      this.g = paramadg;
      Object localObject = new d();
      ack localack = (ack)ack.a.b();
      Handler localHandler = this.e;
      localack.h = ((ace)localObject);
      if (localack.b) {
        localack.a(localHandler, (ace)localObject);
      }
      localack.g = paramadg;
      localack.b = true;
      if (localack.c == null) {
        localack.c = new acf(paramadg.c);
      }
      localack.a();
      localack.d = localHandler;
      localHandler.post(localack.j);
      boolean bool = this.f.get();
      if (bool) {
        return true;
      }
      paramadg = (acm)acm.a.b();
      localObject = new b();
      paramadg.b.postDelayed((Runnable)localObject, 0L);
      return true;
    }
    finally {}
  }
  
  public static final class a
    extends afj<adn>
  {
    public final Object a()
    {
      return new adn((byte)0);
    }
  }
  
  public final class b
    extends acj
  {
    public b() {}
    
    public final void a()
    {
      adn.a(adn.this).set(true);
      if (aex.b == null) {
        aex.b = aex.b();
      }
      Context localContext = adn.b(adn.this);
      if (afc.a == null) {
        afc.a = afc.a(localContext);
      }
      acr.a();
      aex.a();
      adn.a(adn.this).set(false);
    }
  }
  
  public final class c
    extends acj
  {
    public c(int paramInt, acy paramacy, Context paramContext, String paramString) {}
    
    public final void a()
    {
      adz.a.b();
      adl localadl = adz.a(adn.b(adn.this), paramInt);
      if (localadl == null) {
        return;
      }
      Dew localDew = localadl.a;
      localDew = adn.a(paramContext, paramString, localDew);
      if (!adn.a(paramacy, localDew)) {
        return;
      }
      adn.a(localadl.b);
    }
  }
  
  public final class d
    implements ace
  {
    public final void a()
    {
      adn.d(this.a);
    }
    
    public final class a
      extends acj
    {
      public a(SparseArray paramSparseArray, List paramList, adg paramadg) {}
      
      public final void a()
      {
        int k = this.a;
        adg localadg = this.d;
        SparseArray localSparseArray = this.b;
        List localList = this.c;
        Dew localDew = new Dew();
        Lemon localLemon = localadg.e;
        Object localObject1 = new ArrayList();
        int i = 0;
        Object localObject2;
        while (i < localSparseArray.size())
        {
          localObject2 = ((acl)localSparseArray.valueAt(i)).a(localList);
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
          long l = localadg.e.od;
          i = localadg.d;
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
          adz.a.b();
          adz.a(this.d.c, this.a, localDew);
          localObject1 = this.d.f;
          if (localObject1 != null) {
            acs.a(this.a, ((acs.b)localObject1).a);
          }
          return;
        }
        throw new IllegalArgumentException("invalid stateUnits");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adn
 * JD-Core Version:    0.7.0.1
 */