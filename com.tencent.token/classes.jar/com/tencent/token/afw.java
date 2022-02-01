package com.tencent.token;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.turingfd.sdk.qps.Peach;
import com.tencent.turingfd.sdk.qps.Pistachio;
import com.tencent.turingfd.sdk.qps.Pomegranate;
import com.tencent.turingfd.sdk.qps.TNative.aa;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public final class afw
{
  public static AtomicBoolean a = new AtomicBoolean(false);
  public static AtomicBoolean b = new AtomicBoolean(false);
  public static final Object c = new Object();
  public static AtomicBoolean d = new AtomicBoolean(false);
  public static afu e;
  
  public static int a()
  {
    if (!a.get()) {
      return -10001;
    }
    if (agb.a == 0) {
      return -10018;
    }
    if (!b.get()) {
      return -10002;
    }
    afq localafq2 = e.b;
    afq localafq1 = localafq2;
    if (localafq2 == null) {
      localafq1 = afu.a;
    }
    if (!localafq1.a()) {
      return -10019;
    }
    return 0;
  }
  
  public static void a(afu paramafu)
  {
    Object localObject1 = afc.a;
    ((afc)localObject1).e = paramafu;
    Object localObject2;
    label64:
    Object localObject3;
    if (!((afc)localObject1).g)
    {
      ((afc)localObject1).g = true;
      localObject2 = paramafu.d;
      try
      {
        if ((ahr.a == null) && (localObject2 != null))
        {
          localObject2 = ((Context)localObject2).getApplicationContext();
          if (localObject2 != null)
          {
            ahr.a = (Context)localObject2;
            break label64;
          }
        }
        localObject2 = new StringBuilder("TuringFdCore_69_");
        ((StringBuilder)localObject2).append(agb.a);
        ((StringBuilder)localObject2).append("_qps");
        localObject2 = new HandlerThread(((StringBuilder)localObject2).toString(), -8);
        ((HandlerThread)localObject2).start();
        ((afc)localObject1).f = new afc.b((afc)localObject1, ((HandlerThread)localObject2).getLooper(), paramafu.d);
        localObject2 = new Peach(((afc)localObject1).f);
        ((afc)localObject1).h = ((Peach)localObject2);
        localObject3 = afn.a;
        ((afn)localObject3).g = new aex((afc)localObject1);
        ((afn)localObject3).h = paramafu;
        ((afn)localObject3).i = ((Peach)localObject2);
        new aey((afc)localObject1).start();
      }
      finally {}
    }
    localObject1 = paramafu.d;
    aet.c = paramafu;
    aeo.f = (Context)localObject1;
    if (Pistachio.b.a((Context)localObject1, "enable_risk_click", false))
    {
      localObject2 = aeo.g;
      localObject3 = aeo.h;
      try
      {
        adm.a.add(localObject2);
        adm.b = (adr)localObject3;
        localObject2 = ((Context)localObject1).getApplicationContext();
        adt.e = adm.e;
        if (!adt.a)
        {
          adt.a = true;
          try
          {
            localObject3 = new HandlerThread("TuringDispatch");
            ((HandlerThread)localObject3).start();
            adt.b = new adt.d(((HandlerThread)localObject3).getLooper());
            localObject2 = (Application)localObject2;
            try
            {
              localObject3 = adt.h;
              ((Application)localObject2).unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject3);
              ((Application)localObject2).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject3);
            }
            finally
            {
              paramafu = finally;
              throw paramafu;
            }
          }
          finally {}
        }
        adt.f = true;
      }
      finally {}
    }
    if (Pistachio.b.a((Context)localObject1, "enable_auto_detect", false))
    {
      localObject2 = new HandlerThread("TuringRiskThread", 0);
      ((HandlerThread)localObject2).start();
      localObject1 = new aet.a(((HandlerThread)localObject2).getLooper(), (Context)localObject1);
      aet.h = (aet.a)localObject1;
      ((Handler)localObject1).sendEmptyMessage(1);
    }
    localObject1 = Pomegranate.a;
    new afo(paramafu.d).start();
  }
  
  public static int b(afu paramafu)
  {
    if (a.get()) {
      return 0;
    }
    boolean bool2 = paramafu.g;
    boolean bool1 = true;
    if (bool2)
    {
      TextUtils.isEmpty(paramafu.h);
      paramafu = paramafu.h;
    }
    try
    {
      if (TextUtils.isEmpty(paramafu)) {
        System.loadLibrary("turingqps");
      } else {
        System.load(paramafu);
      }
    }
    finally
    {
      label58:
      break label58;
    }
    bool1 = false;
    a.set(bool1);
    break label77;
    a.set(true);
    label77:
    if (a.get()) {
      return 0;
    }
    return -10001;
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format(Locale.getDefault(), "TuringFD v%d", new Object[] { Integer.valueOf(69) }));
    localStringBuilder.append(" (704117AC825FFCE2");
    localStringBuilder.append(", qps");
    localStringBuilder.append(", 9668c19");
    Object localObject = new StringBuilder();
    if (((StringBuilder)localObject).toString().length() > 0) {
      ((StringBuilder)localObject).append(";");
    }
    ((StringBuilder)localObject).append("rs");
    localObject = ((StringBuilder)localObject).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localStringBuilder.append(", ");
      localStringBuilder.append((String)localObject);
    }
    localStringBuilder.append(", ");
    localObject = new StringBuilder();
    if (((StringBuilder)localObject).toString().length() > 0) {
      ((StringBuilder)localObject).append(";");
    }
    ((StringBuilder)localObject).append("w");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localStringBuilder.append(String.format(Locale.getDefault(), ", compiled %s)", new Object[] { "2021_11_26_11_44_02" }));
    return localStringBuilder.toString();
  }
  
  public static int c(afu paramafu)
  {
    Context localContext = paramafu.d;
    HashMap localHashMap = new HashMap();
    Pistachio localPistachio = Pistachio.b;
    if (localPistachio.a(localContext, "e_w_d", false)) {
      paramafu = "1";
    } else {
      paramafu = "0";
    }
    localHashMap.put("2008", paramafu);
    if (localPistachio.a(localContext, "e_r_d", true)) {
      paramafu = "1";
    } else {
      paramafu = "0";
    }
    localHashMap.put("2009", paramafu);
    if (localPistachio.a(localContext, "e_w_nd", false)) {
      paramafu = "1";
    } else {
      paramafu = "0";
    }
    localHashMap.put("2010", paramafu);
    if (localPistachio.a(localContext, "e_r_nd", true)) {
      paramafu = "1";
    } else {
      paramafu = "0";
    }
    localHashMap.put("2011", paramafu);
    try
    {
      paramafu = TNative.aa.i(new SparseArray(), localContext, localHashMap);
      if (ahr.a(paramafu) != 0) {
        return -10020;
      }
      return 0;
    }
    finally {}
    return -10020;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afw
 * JD-Core Version:    0.7.0.1
 */