package com.meri.service.monitor;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import taiji.cq;
import taiji.cr;
import taiji.ct;

class b
  extends Handler
{
  private int b = -1;
  private long c = 0L;
  private taiji.b d = null;
  private cq e = null;
  private ct f = null;
  private boolean g = false;
  private int h = -1;
  private String i = "";
  private final int j;
  private final int k;
  private final int l;
  private final Object m = new Object();
  private final String[] n = { "" };
  private final String[] o = { "返回", "向上导航" };
  private final String p = "com.android.settings";
  
  public b(AccessibilityDispatcher paramAccessibilityDispatcher, Looper paramLooper, Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramLooper);
    this.j = paramInt1;
    this.k = paramInt2;
    paramLooper = paramAccessibilityDispatcher.getServiceInfo();
    if (paramLooper != null)
    {
      this.l = paramLooper.flags;
      if (AccessibilityDispatcher.a == null) {}
      while (AccessibilityDispatcher.a.forceMonitorAllPkg()) {
        return;
      }
      paramLooper.packageNames = new String[] { paramContext.getPackageName(), "com.android.settings" };
      paramAccessibilityDispatcher.setServiceInfo(paramLooper);
      return;
    }
    this.l = 0;
  }
  
  private int a(taiji.a parama, boolean paramBoolean)
  {
    Object localObject2 = null;
    Log.i("AccessibilityDispatcher", "scrollList, isForward=" + paramBoolean);
    if ((parama == null) || (parama.k == null)) {
      return 3;
    }
    AccessibilityNodeInfo localAccessibilityNodeInfo = this.a.getRootInActiveWindow();
    if (localAccessibilityNodeInfo == null) {
      return 3;
    }
    Object localObject3 = parama.k.iterator();
    Object localObject1;
    if (!((Iterator)localObject3).hasNext())
    {
      localObject1 = new ArrayList();
      if (!TextUtils.isEmpty(parama.m))
      {
        localObject3 = new taiji.d();
        ((taiji.d)localObject3).a = parama.m;
        ((taiji.d)localObject3).e = parama.n;
        ((ArrayList)localObject1).add(localObject3);
      }
      if (parama.w != null) {
        ((ArrayList)localObject1).addAll(parama.w);
      }
      localObject3 = ((ArrayList)localObject1).iterator();
      parama = localObject2;
      label150:
      if (((Iterator)localObject3).hasNext()) {
        break label272;
      }
    }
    for (;;)
    {
      if (parama != null) {
        break label309;
      }
      localAccessibilityNodeInfo.recycle();
      return 3;
      localObject1 = (String)((Iterator)localObject3).next();
      switch (parama.j)
      {
      default: 
        localObject1 = null;
      }
      while (localObject1 != null)
      {
        ((AccessibilityNodeInfo)localObject1).recycle();
        localAccessibilityNodeInfo.recycle();
        return 1;
        localObject1 = a(localAccessibilityNodeInfo, parama.b, null, (String)localObject1, parama.j);
        continue;
        localObject1 = b(localAccessibilityNodeInfo, parama.b, (String)localObject1);
      }
      label272:
      parama = (taiji.d)((Iterator)localObject3).next();
      localObject1 = a(localAccessibilityNodeInfo, parama.a, parama.e);
      parama = (taiji.a)localObject1;
      if (localObject1 == null) {
        break label150;
      }
      parama = (taiji.a)localObject1;
    }
    label309:
    a(parama, paramBoolean);
    parama.recycle();
    localAccessibilityNodeInfo.recycle();
    return 2;
  }
  
  private Bundle a(ArrayList paramArrayList)
  {
    Bundle localBundle = new Bundle();
    paramArrayList = paramArrayList.iterator();
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        return localBundle;
      }
      taiji.c localc = (taiji.c)paramArrayList.next();
      try
      {
        switch (localc.b)
        {
        case 1: 
          int i1 = Integer.parseInt(localc.c);
          localBundle.putInt(localc.a, i1);
        }
      }
      catch (Throwable paramArrayList)
      {
        Log.e("AccessibilityDispatcher", paramArrayList.getMessage(), paramArrayList);
        return null;
      }
      localBundle.putString(localc.a, localc.c);
      continue;
      long l1 = Long.parseLong(localc.c);
      localBundle.putLong(localc.a, l1);
      continue;
      boolean bool = Boolean.parseBoolean(localc.c);
      localBundle.putBoolean(localc.a, bool);
      continue;
      short s = Short.parseShort(localc.c);
      localBundle.putShort(localc.a, s);
    }
  }
  
  private AccessibilityNodeInfo a(AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString1, String paramString2)
  {
    Log.i("AccessibilityDispatcher", "findNodeByClassName nodeClass=" + paramString1 + " parentClass=" + paramString2);
    if ((paramAccessibilityNodeInfo == null) || (paramString1 == null)) {
      localAccessibilityNodeInfo1 = null;
    }
    do
    {
      return localAccessibilityNodeInfo1;
      if (!paramString1.equals(paramAccessibilityNodeInfo.getClassName().toString())) {
        break;
      }
      if (TextUtils.isEmpty(paramString2)) {
        break label131;
      }
      localAccessibilityNodeInfo1 = paramAccessibilityNodeInfo.getParent();
      if (localAccessibilityNodeInfo1 == null) {
        break;
      }
      bool = paramString2.equals(localAccessibilityNodeInfo1.getClassName().toString());
      localAccessibilityNodeInfo1.recycle();
      if (!bool) {
        break;
      }
      localAccessibilityNodeInfo1 = paramAccessibilityNodeInfo;
    } while (paramAccessibilityNodeInfo.isVisibleToUser());
    int i1;
    label131:
    while (!paramAccessibilityNodeInfo.isVisibleToUser())
    {
      boolean bool;
      i1 = 0;
      if (i1 < paramAccessibilityNodeInfo.getChildCount()) {
        break;
      }
      return null;
    }
    return paramAccessibilityNodeInfo;
    AccessibilityNodeInfo localAccessibilityNodeInfo1 = paramAccessibilityNodeInfo.getChild(i1);
    if (localAccessibilityNodeInfo1 == null) {}
    AccessibilityNodeInfo localAccessibilityNodeInfo2;
    do
    {
      i1 += 1;
      break;
      localAccessibilityNodeInfo2 = a(localAccessibilityNodeInfo1, paramString1, paramString2);
      if (localAccessibilityNodeInfo2 != localAccessibilityNodeInfo1) {
        localAccessibilityNodeInfo1.recycle();
      }
    } while (localAccessibilityNodeInfo2 == null);
    return localAccessibilityNodeInfo2;
  }
  
  private AccessibilityNodeInfo a(AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 5)) {}
    for (boolean bool2 = false;; bool2 = true)
    {
      Log.i("AccessibilityDispatcher", "findNodeByApi, clsName=" + paramString1 + " parentCls=" + paramString2 + " rawText=" + paramString3 + " textType=" + paramInt + " exactMatch=" + bool2);
      if (paramAccessibilityNodeInfo != null) {
        break;
      }
      Log.w("AccessibilityDispatcher", "root node is null");
      paramString1 = null;
      return paramString1;
    }
    if (TextUtils.isEmpty(paramString3)) {
      return null;
    }
    Object localObject2 = paramString3;
    if (paramInt == 5) {}
    Object localObject1;
    int i1;
    try
    {
      localObject1 = paramString3.split(":");
      if ((localObject1 == null) || (localObject1.length != 2) || (TextUtils.isEmpty(localObject1[0])) || (TextUtils.isEmpty(localObject1[1])) || (!localObject1[1].startsWith("string/")))
      {
        Log.e("AccessibilityDispatcher", "the format of text isnot meet the requirements");
        return null;
      }
      paramString3 = localObject1[0];
      localObject1 = localObject1[1].substring("string/".length());
      localObject2 = this.a.getPackageManager().getResourcesForApplication(paramString3);
      i1 = ((Resources)localObject2).getIdentifier((String)localObject1, "string", paramString3);
      if (i1 > 0)
      {
        localObject2 = ((Resources)localObject2).getString(i1);
        Log.i("AccessibilityDispatcher", "result|" + (String)localObject2);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return null;
        }
      }
      else
      {
        Log.w("AccessibilityDispatcher", "can't find res|" + (String)localObject1);
        return null;
      }
    }
    catch (Throwable paramAccessibilityNodeInfo)
    {
      Log.e("AccessibilityDispatcher", paramAccessibilityNodeInfo.getMessage(), paramAccessibilityNodeInfo);
      return null;
    }
    if ((paramInt == 1) || (paramInt == 4) || (paramInt == 5)) {
      localObject1 = paramAccessibilityNodeInfo.findAccessibilityNodeInfosByText((String)localObject2);
    }
    for (;;)
    {
      if ((localObject1 == null) || (((List)localObject1).size() <= 0))
      {
        return null;
        if ((paramInt == 3) && (Build.VERSION.SDK_INT >= 18)) {
          localObject1 = paramAccessibilityNodeInfo.findAccessibilityNodeInfosByViewId((String)localObject2);
        }
      }
      else
      {
        paramAccessibilityNodeInfo = null;
        int i3 = ((List)localObject1).size();
        i1 = 0;
        label409:
        if (i1 >= i3) {}
        AccessibilityNodeInfo localAccessibilityNodeInfo;
        label485:
        boolean bool1;
        for (;;)
        {
          paramString1 = paramAccessibilityNodeInfo;
          if (((List)localObject1).size() <= 0) {
            break;
          }
          ((AccessibilityNodeInfo)((List)localObject1).remove(((List)localObject1).size() - 1)).recycle();
          continue;
          localAccessibilityNodeInfo = (AccessibilityNodeInfo)((List)localObject1).get(i1);
          if (!a(localAccessibilityNodeInfo))
          {
            Log.i("AccessibilityDispatcher", "cannot ClickNode");
            i1 += 1;
            break label409;
          }
          bool1 = true;
          if (bool2)
          {
            paramString3 = localAccessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(paramString3)) {
              break label548;
            }
          }
          label548:
          for (bool1 = ((String)localObject2).equals(paramString3.toString());; bool1 = false)
          {
            if (bool1) {
              break label554;
            }
            Log.i("AccessibilityDispatcher", "text not match");
            break;
          }
          label554:
          if (!TextUtils.isEmpty(paramString1)) {
            break label577;
          }
          paramAccessibilityNodeInfo = (AccessibilityNodeInfo)((List)localObject1).remove(i1);
        }
        label577:
        int i2;
        if (TextUtils.isEmpty(paramString2))
        {
          i2 = 0;
          label587:
          bool1 = paramString1.equals(localAccessibilityNodeInfo.getClassName());
          if (i2 == 0) {
            break label680;
          }
          paramInt = 0;
          label606:
          if (i2 == 0) {
            break label768;
          }
          paramString3 = localAccessibilityNodeInfo.getParent();
          if ((paramString3 == null) || (!paramString2.equals(paramString3.getClassName()))) {
            break label765;
          }
          paramInt = 1;
        }
        for (;;)
        {
          if ((bool1) && (paramInt != 0))
          {
            paramAccessibilityNodeInfo = (AccessibilityNodeInfo)((List)localObject1).remove(i1);
            if (paramString3 == null) {
              break label762;
            }
            paramString3.recycle();
            break;
            i2 = 1;
            break label587;
            label680:
            paramInt = 1;
            break label606;
          }
          if (paramString3 == null) {
            paramString3 = localAccessibilityNodeInfo.getParent();
          }
          for (;;)
          {
            if (paramString3 == null) {
              break label760;
            }
            localAccessibilityNodeInfo = a(paramString3, paramString1, paramString2);
            if (localAccessibilityNodeInfo != null)
            {
              paramAccessibilityNodeInfo = localAccessibilityNodeInfo;
              if (localAccessibilityNodeInfo == paramString3) {
                break;
              }
              paramString3.recycle();
              paramAccessibilityNodeInfo = localAccessibilityNodeInfo;
              break;
            }
            paramAccessibilityNodeInfo = paramString3.getParent();
            paramString3.recycle();
            paramString3 = paramAccessibilityNodeInfo;
            paramAccessibilityNodeInfo = localAccessibilityNodeInfo;
          }
          label760:
          break label485;
          label762:
          break;
          label765:
          continue;
          label768:
          paramString3 = null;
        }
      }
      localObject1 = null;
    }
  }
  
  private void a(AccessibilityEvent paramAccessibilityEvent)
  {
    Log.i("AccessibilityDispatcher", "dispatchUiEvent");
    if (paramAccessibilityEvent == null) {}
    CharSequence localCharSequence;
    do
    {
      return;
      localCharSequence = paramAccessibilityEvent.getPackageName();
    } while (TextUtils.isEmpty(localCharSequence));
    Iterator localIterator1 = AccessibilityDispatcher.d().entrySet().iterator();
    Object localObject2 = null;
    Map.Entry localEntry;
    do
    {
      if (!localIterator1.hasNext())
      {
        if (localObject2 == null) {
          break;
        }
        ((AccessibilityNodeInfo)localObject2).recycle();
        return;
      }
      localEntry = (Map.Entry)localIterator1.next();
      localObject1 = (List)localEntry.getValue();
    } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
    Iterator localIterator2 = ((List)localObject1).iterator();
    Object localObject1 = localObject2;
    do
    {
      localObject2 = localObject1;
      if (!localIterator2.hasNext()) {
        break;
      }
      localObject2 = (taiji.a)localIterator2.next();
    } while ((((taiji.a)localObject2).q & paramAccessibilityEvent.getEventType()) == 0);
    Object localObject3;
    label181:
    int i1;
    if ((((taiji.a)localObject2).r != null) && (((taiji.a)localObject2).r.size() > 0))
    {
      localObject3 = ((taiji.a)localObject2).r.iterator();
      if (!((Iterator)localObject3).hasNext())
      {
        i1 = 0;
        label193:
        if (i1 == 0) {
          break label343;
        }
      }
    }
    else
    {
      if ((((taiji.a)localObject2).k == null) || (((taiji.a)localObject2).k.size() <= 0)) {
        break label383;
      }
      if (localObject1 != null) {
        break label380;
      }
      localObject1 = this.a.getRootInActiveWindow();
      label228:
      localObject2 = ((taiji.a)localObject2).k.iterator();
      i1 = 0;
      label240:
      if (((Iterator)localObject2).hasNext()) {
        break label345;
      }
    }
    for (localObject2 = localObject1;; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      if (i1 == 0) {
        break;
      }
      localObject3 = (cr)localEntry.getKey();
      localObject1 = localObject2;
      if (AccessibilityDispatcher.a == null) {
        break;
      }
      Handler localHandler = AccessibilityDispatcher.a.getMonitorCallbackHandler();
      localObject1 = localObject2;
      if (localHandler == null) {
        break;
      }
      localHandler.post(new c(this, (cr)localObject3, paramAccessibilityEvent));
      localObject1 = localObject2;
      break;
      if (!localCharSequence.equals((String)((Iterator)localObject3).next())) {
        break label181;
      }
      i1 = 1;
      break label193;
      label343:
      break;
      label345:
      localObject3 = a((AccessibilityNodeInfo)localObject1, null, null, (String)((Iterator)localObject2).next(), 1);
      if (localObject3 == null) {
        break label240;
      }
      ((AccessibilityNodeInfo)localObject3).recycle();
      i1 = 1;
      break label240;
      label380:
      break label228;
      label383:
      i1 = 1;
    }
  }
  
  private void a(a parama)
  {
    boolean bool2 = false;
    Object localObject = parama.a;
    long l2 = parama.b;
    Log.i("AccessibilityDispatcher", "performAction: " + ((taiji.a)localObject).a + " mWaitEventType=" + this.h);
    boolean bool1;
    switch (((taiji.a)localObject).a)
    {
    default: 
      return;
    case 1: 
      try
      {
        this.h = 32;
        a((taiji.a)localObject);
        localObject = Message.obtain();
        ((Message)localObject).what = 1003;
        ((Message)localObject).obj = parama;
        sendMessageDelayed((Message)localObject, 20L);
        return;
      }
      catch (Throwable parama)
      {
        a((taiji.a)localObject, parama);
        return;
      }
    case 2: 
      try
      {
        bool1 = b((taiji.a)localObject);
        Log.i("AccessibilityDispatcher", "clickWidget result: " + bool1);
        if (bool1)
        {
          c();
          return;
        }
      }
      catch (Throwable parama)
      {
        a((taiji.a)localObject, parama);
        return;
      }
      long l3;
      long l1;
      if (((taiji.a)localObject).s != 0)
      {
        i1 = ((taiji.a)localObject).s;
        l3 = System.currentTimeMillis();
        if (l3 > i1 + l2) {
          break label300;
        }
        l1 = 10L;
        if (l3 - l2 < 30000L) {
          break label280;
        }
        l1 = 1000L;
      }
      for (;;)
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 1002;
        ((Message)localObject).obj = parama;
        sendMessageDelayed((Message)localObject, l1);
        return;
        i1 = 1500;
        break;
        if (l3 - l2 >= 10000L) {
          l1 = 100L;
        }
      }
      a(((taiji.a)localObject).c);
      return;
    case 3: 
      label280:
      label300:
      bool1 = bool2;
      try
      {
        if (this.h < 0)
        {
          this.h = 4096;
          i1 = a((taiji.a)localObject, true);
          if (i1 != 1) {
            break label410;
          }
          bool1 = true;
        }
        for (;;)
        {
          Log.i("AccessibilityDispatcher", "scrollList result: " + bool1);
          if (!bool1) {
            break;
          }
          this.h = -1;
          localObject = Message.obtain();
          ((Message)localObject).what = 1003;
          ((Message)localObject).arg1 = 1;
          ((Message)localObject).obj = parama;
          sendMessageDelayed((Message)localObject, 100L);
          return;
          label410:
          bool1 = bool2;
          if (i1 == 3)
          {
            this.h = -1;
            bool1 = bool2;
          }
        }
        if (((taiji.a)localObject).s == 0) {}
      }
      catch (Throwable parama)
      {
        a((taiji.a)localObject, parama);
        return;
      }
      for (i1 = ((taiji.a)localObject).s; System.currentTimeMillis() <= i1 + l2; i1 = 3000)
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 1002;
        ((Message)localObject).obj = parama;
        sendMessageDelayed((Message)localObject, 20L);
        return;
      }
      a(((taiji.a)localObject).c);
      return;
    }
    try
    {
      bool1 = c((taiji.a)localObject);
      Log.i("AccessibilityDispatcher", "globalAction result: " + bool1);
      if (bool1)
      {
        c();
        return;
      }
    }
    catch (Throwable parama)
    {
      a((taiji.a)localObject, parama);
      return;
    }
    if (((taiji.a)localObject).s != 0) {}
    for (int i1 = ((taiji.a)localObject).s; System.currentTimeMillis() <= i1 + l2; i1 = 1500)
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 1002;
      ((Message)localObject).obj = parama;
      sendMessageDelayed((Message)localObject, 10L);
      return;
    }
    a(((taiji.a)localObject).c);
  }
  
  private void a(a parama, int paramInt)
  {
    boolean bool = true;
    Object localObject = parama.a;
    long l1 = parama.b;
    Log.i("AccessibilityDispatcher", "checkAction=" + ((taiji.a)localObject).a + " mWaitEventType=" + this.h);
    switch (((taiji.a)localObject).a)
    {
    case 2: 
    default: 
      return;
    case 1: 
      if (this.h < 0)
      {
        c();
        return;
      }
      if (((taiji.a)localObject).s != 0) {}
      for (paramInt = ((taiji.a)localObject).s; System.currentTimeMillis() <= paramInt + l1; paramInt = 6000)
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 1003;
        ((Message)localObject).obj = parama;
        sendMessageDelayed((Message)localObject, 20L);
        return;
      }
      a(((taiji.a)localObject).c);
      return;
    }
    for (;;)
    {
      try
      {
        if (this.h >= 0) {
          break label313;
        }
        this.h = 4096;
        int i1 = a((taiji.a)localObject, false);
        if (i1 == 1)
        {
          Log.i("AccessibilityDispatcher", "check scrollList result: " + bool);
          if (bool) {
            c();
          }
        }
        else
        {
          if (i1 != 3) {
            break label313;
          }
          this.h = -1;
          bool = false;
          continue;
        }
        if (paramInt > 2) {
          break label303;
        }
      }
      catch (Throwable parama)
      {
        a((taiji.a)localObject, parama);
        return;
      }
      localObject = Message.obtain();
      ((Message)localObject).what = 1003;
      ((Message)localObject).arg1 = (paramInt + 1);
      ((Message)localObject).obj = parama;
      sendMessageDelayed((Message)localObject, 100L);
      return;
      label303:
      a(((taiji.a)localObject).c);
      return;
      label313:
      bool = false;
    }
  }
  
  private void a(taiji.a parama)
  {
    Log.i("AccessibilityDispatcher", "openView");
    if (parama == null) {
      return;
    }
    AccessibilityDispatcher.c().clear();
    if (!TextUtils.isEmpty(parama.f)) {
      AccessibilityDispatcher.c().add(parama.f);
    }
    Object localObject1;
    if (parama.w != null) {
      localObject1 = parama.w.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        if ((parama.r != null) && (parama.r.size() > 0)) {
          AccessibilityDispatcher.c().addAll(parama.r);
        }
        d();
        localObject1 = new ArrayList();
        localObject2 = new taiji.d();
        ((taiji.d)localObject2).a = parama.b;
        ((taiji.d)localObject2).b = parama.j;
        if (parama.k != null)
        {
          ((taiji.d)localObject2).c = new ArrayList();
          ((taiji.d)localObject2).c.addAll(parama.k);
        }
        ((taiji.d)localObject2).e = parama.n;
        ((taiji.d)localObject2).f = parama.e;
        ((taiji.d)localObject2).g = parama.f;
        ((taiji.d)localObject2).h = parama.g;
        ((taiji.d)localObject2).i = parama.p;
        if (parama.h != null)
        {
          ((taiji.d)localObject2).j = new ArrayList();
          ((taiji.d)localObject2).j.addAll(parama.h);
        }
        ((taiji.d)localObject2).k = parama.i;
        ((ArrayList)localObject1).add(localObject2);
        if (parama.w != null) {
          ((ArrayList)localObject1).addAll(parama.w);
        }
        parama = null;
        localObject1 = ((ArrayList)localObject1).iterator();
        if (((Iterator)localObject1).hasNext()) {
          break label349;
        }
        if (parama == null) {
          break;
        }
        throw parama;
      }
      localObject2 = (taiji.d)((Iterator)localObject1).next();
      if (!TextUtils.isEmpty(((taiji.d)localObject2).g)) {
        AccessibilityDispatcher.c().add(((taiji.d)localObject2).g);
      }
    }
    label349:
    parama = (taiji.d)((Iterator)localObject1).next();
    Object localObject2 = new Intent();
    if (!TextUtils.isEmpty(parama.f)) {
      ((Intent)localObject2).setAction(parama.f);
    }
    label423:
    int i1;
    label435:
    int i2;
    if (!TextUtils.isEmpty(parama.g))
    {
      if (!TextUtils.isEmpty(parama.a)) {
        ((Intent)localObject2).setClassName(parama.g, parama.a);
      }
    }
    else
    {
      if (!TextUtils.isEmpty(parama.h)) {
        break label585;
      }
      i1 = 0;
      if (!TextUtils.isEmpty(parama.i)) {
        break label590;
      }
      i2 = 0;
      label447:
      if ((i1 == 0) || (i2 == 0)) {
        break label595;
      }
      ((Intent)localObject2).setDataAndType(Uri.parse(parama.h), parama.i);
      label472:
      if (parama.j != null)
      {
        Bundle localBundle = a(parama.j);
        if (localBundle != null) {
          ((Intent)localObject2).putExtras(localBundle);
        }
      }
      if (parama.k == 0) {
        break label640;
      }
      ((Intent)localObject2).setFlags(parama.k);
    }
    for (;;)
    {
      try
      {
        this.a.startActivity((Intent)localObject2);
        Log.i("AccessibilityDispatcher", "open suc. pkg=" + parama.g + " cls=" + parama.a);
        return;
      }
      catch (Exception parama) {}
      break;
      ((Intent)localObject2).setPackage(parama.g);
      break label423;
      label585:
      i1 = 1;
      break label435;
      label590:
      i2 = 1;
      break label447;
      label595:
      if ((i1 != 0) && (i2 == 0))
      {
        ((Intent)localObject2).setData(Uri.parse(parama.h));
        break label472;
      }
      if ((i1 != 0) || (i2 == 0)) {
        break label472;
      }
      ((Intent)localObject2).setType(parama.i);
      break label472;
      label640:
      ((Intent)localObject2).setFlags(1350926336);
    }
  }
  
  private void a(taiji.a parama, Throwable paramThrowable)
  {
    Log.e("AccessibilityDispatcher", paramThrowable.getMessage(), paramThrowable);
    if (AccessibilityDispatcher.a != null) {
      AccessibilityDispatcher.a.onException(paramThrowable);
    }
    if (this.e != null) {
      this.e.a(this.b, 2);
    }
    if (this.f != null)
    {
      this.f.b = 3;
      this.f.c = this.b;
    }
    b();
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject;
    if (!paramBoolean)
    {
      if (this.e != null) {
        this.e.a(this.b, 2);
      }
      if (this.f != null)
      {
        this.f.b = 2;
        this.f.c = this.b;
        localObject = this.a.getRootInActiveWindow();
        if (localObject != null) {
          this.f.e = c((AccessibilityNodeInfo)localObject);
        }
      }
      b();
      return;
    }
    if (this.e != null) {
      this.e.a(this.b, 1);
    }
    if (this.f != null)
    {
      this.f.b = 1;
      if (!TextUtils.isEmpty(this.f.d)) {
        break label162;
      }
    }
    for (this.f.d = this.b;; ((ct)localObject).d = (((ct)localObject).d + "|" + this.b))
    {
      sendEmptyMessageDelayed(1001, 100L);
      return;
      label162:
      localObject = this.f;
    }
  }
  
  private boolean a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    boolean bool = paramAccessibilityNodeInfo.isVisibleToUser();
    if (!bool)
    {
      Rect localRect = new Rect();
      paramAccessibilityNodeInfo.getBoundsInScreen(localRect);
      int i1 = this.k;
      int i2 = this.j;
      Log.i("AccessibilityDispatcher", "l=" + localRect.left + " r=" + localRect.right + " t=" + localRect.top + " b=" + localRect.bottom + "\nw=" + i2 + " h=" + i1);
      if ((i2 <= 0) || (i1 <= 0) || ((localRect.top >= 0) && (localRect.top <= i1) && (localRect.bottom >= 0) && (localRect.bottom <= i1) && (localRect.left >= 0) && (localRect.left <= i2) && (localRect.right >= 0) && (localRect.right <= i2))) {
        return true;
      }
    }
    return bool;
  }
  
  private boolean a(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt, taiji.d paramd)
  {
    Object localObject2 = null;
    boolean bool3 = true;
    boolean bool4 = false;
    boolean bool2 = false;
    Log.i("AccessibilityDispatcher", "needIgnoreClick ignoreState=" + paramInt);
    if ((paramd != null) && (((paramd.c != null) && (paramd.c.size() > 0)) || (!TextUtils.isEmpty(paramd.a)))) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        if ((paramd.c != null) || (!TextUtils.isEmpty(paramd.a))) {}
      }
      label138:
      label281:
      label293:
      label445:
      label455:
      for (;;)
      {
        return bool2;
        i1 = paramd.d;
        Object localObject3 = paramAccessibilityNodeInfo;
        label103:
        Object localObject1;
        if ((i1 <= 0) || (localObject3 == null)) {
          if (localObject3 != null)
          {
            if (paramd.c != null) {
              break label281;
            }
            localObject1 = a((AccessibilityNodeInfo)localObject3, paramd.a, null);
            localObject2 = localObject1;
            if (localObject3 != paramAccessibilityNodeInfo) {
              ((AccessibilityNodeInfo)localObject3).recycle();
            }
          }
        }
        for (localObject2 = localObject1;; localObject2 = paramAccessibilityNodeInfo)
        {
          if (localObject2 == null) {
            break label455;
          }
          boolean bool1;
          switch (paramInt)
          {
          default: 
            bool1 = bool4;
            if (paramd != null) {
              if ((paramd.c == null) || (paramd.c.size() <= 0))
              {
                bool1 = bool4;
                if (TextUtils.isEmpty(paramd.a)) {
                  break;
                }
              }
              else
              {
                if (localObject2 == null) {
                  break label445;
                }
                bool1 = bool3;
              }
            }
            break;
          }
          for (;;)
          {
            bool2 = bool1;
            if (localObject2 == paramAccessibilityNodeInfo) {
              break;
            }
            ((AccessibilityNodeInfo)localObject2).recycle();
            return bool1;
            localObject1 = ((AccessibilityNodeInfo)localObject3).getParent();
            if (localObject3 != paramAccessibilityNodeInfo) {
              ((AccessibilityNodeInfo)localObject3).recycle();
            }
            i1 -= 1;
            localObject3 = localObject1;
            break label103;
            Iterator localIterator = paramd.c.iterator();
            localObject2 = null;
            if (!localIterator.hasNext())
            {
              localObject1 = localObject2;
              break label138;
            }
            localObject1 = (String)localIterator.next();
            switch (paramd.b)
            {
            default: 
              localObject1 = localObject2;
            }
            for (;;)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                break label293;
              }
              break;
              localObject1 = a((AccessibilityNodeInfo)localObject3, paramd.a, null, (String)localObject1, paramd.b);
              continue;
              localObject1 = b((AccessibilityNodeInfo)localObject3, paramd.a, (String)localObject1);
            }
            bool1 = ((AccessibilityNodeInfo)localObject2).isChecked();
            continue;
            if (((AccessibilityNodeInfo)localObject2).isChecked()) {}
            for (bool1 = false;; bool1 = true) {
              break;
            }
            bool1 = false;
          }
        }
      }
    }
  }
  
  private boolean a(AccessibilityNodeInfo paramAccessibilityNodeInfo, boolean paramBoolean)
  {
    Log.i("AccessibilityDispatcher", "doScroll");
    if (paramAccessibilityNodeInfo == null) {
      return false;
    }
    int i1 = 4096;
    if (paramBoolean) {}
    for (;;)
    {
      return paramAccessibilityNodeInfo.performAction(i1);
      i1 = 8192;
    }
  }
  
  private AccessibilityNodeInfo b(AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString1, String paramString2)
  {
    Log.i("AccessibilityDispatcher", "findNodeByDescription clsName=" + paramString1 + " text=" + paramString2);
    if (paramAccessibilityNodeInfo == null) {
      localObject = null;
    }
    do
    {
      do
      {
        return localObject;
        localObject = paramAccessibilityNodeInfo.getContentDescription();
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((CharSequence)localObject).toString().equals(paramString2))) {
          break;
        }
        localObject = paramAccessibilityNodeInfo;
      } while (TextUtils.isEmpty(paramString1));
      localObject = paramAccessibilityNodeInfo;
    } while (paramString1.equals(paramAccessibilityNodeInfo.getClassName()));
    int i2 = paramAccessibilityNodeInfo.getChildCount();
    int i1 = 0;
    if (i1 >= i2) {
      return null;
    }
    Object localObject = paramAccessibilityNodeInfo.getChild(i1);
    if (localObject == null) {}
    AccessibilityNodeInfo localAccessibilityNodeInfo;
    do
    {
      i1 += 1;
      break;
      localAccessibilityNodeInfo = b((AccessibilityNodeInfo)localObject, paramString1, paramString2);
      if (localAccessibilityNodeInfo != localObject) {
        ((AccessibilityNodeInfo)localObject).recycle();
      }
    } while (localAccessibilityNodeInfo == null);
    return localAccessibilityNodeInfo;
  }
  
  private void b()
  {
    AccessibilityDispatcher.c().clear();
    this.d = null;
    d();
    this.b = -1;
    this.c = 0L;
    this.g = false;
    if (this.e != null)
    {
      cq localcq = this.e;
      this.e = null;
      localcq.b();
    }
  }
  
  private boolean b(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Log.i("AccessibilityDispatcher", "doClick");
    if (paramAccessibilityNodeInfo == null) {}
    do
    {
      do
      {
        return bool2;
        if (paramAccessibilityNodeInfo.isEnabled())
        {
          Log.i("AccessibilityDispatcher", "perform click");
          bool1 = paramAccessibilityNodeInfo.performAction(16);
        }
        bool2 = bool1;
      } while (bool1);
      paramAccessibilityNodeInfo = paramAccessibilityNodeInfo.getParent();
      bool2 = bool1;
    } while (paramAccessibilityNodeInfo == null);
    bool1 = b(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.recycle();
    return bool1;
  }
  
  private boolean b(taiji.a parama)
  {
    Object localObject1 = null;
    boolean bool = true;
    Log.i("AccessibilityDispatcher", "clickWidget");
    if ((parama == null) || (parama.k == null)) {}
    AccessibilityNodeInfo localAccessibilityNodeInfo;
    do
    {
      return false;
      localAccessibilityNodeInfo = this.a.getRootInActiveWindow();
    } while (localAccessibilityNodeInfo == null);
    Object localObject2;
    if ((parama.t != null) && (parama.t.size() > 0))
    {
      localObject2 = parama.t.iterator();
      label67:
      if (((Iterator)localObject2).hasNext()) {}
    }
    for (int i1 = 1;; i1 = 0)
    {
      localObject2 = new ArrayList();
      if ((parama.k != null) && (parama.k.size() > 0))
      {
        localObject3 = new taiji.d();
        ((taiji.d)localObject3).b = parama.j;
        ((taiji.d)localObject3).c = new ArrayList();
        ((taiji.d)localObject3).c.addAll(parama.k);
        ((taiji.d)localObject3).a = parama.b;
        ((taiji.d)localObject3).e = parama.n;
        ((ArrayList)localObject2).add(localObject3);
      }
      if (parama.w != null) {
        ((ArrayList)localObject2).addAll(parama.w);
      }
      Object localObject3 = ((ArrayList)localObject2).iterator();
      if (!((Iterator)localObject3).hasNext())
      {
        localAccessibilityNodeInfo.recycle();
        return false;
        localObject3 = a(localAccessibilityNodeInfo, null, null, (String)((Iterator)localObject2).next(), 1);
        if (localObject3 == null) {
          break label67;
        }
        ((AccessibilityNodeInfo)localObject3).recycle();
        return true;
      }
      taiji.d locald = (taiji.d)((Iterator)localObject3).next();
      Iterator localIterator = locald.c.iterator();
      localObject2 = localObject1;
      label344:
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (String)localIterator.next();
        switch (locald.b)
        {
        default: 
          localObject1 = localObject2;
          localObject2 = localObject1;
        }
      } while (localObject1 == null);
      if (!a((AccessibilityNodeInfo)localObject1, parama.l, parama.v)) {
        bool = b((AccessibilityNodeInfo)localObject1);
      }
      for (;;)
      {
        ((AccessibilityNodeInfo)localObject1).recycle();
        localAccessibilityNodeInfo.recycle();
        if (i1 != 0) {
          break;
        }
        return bool;
        localObject1 = a(localAccessibilityNodeInfo, locald.a, locald.e, (String)localObject1, locald.b);
        break label344;
        localObject1 = b(localAccessibilityNodeInfo, locald.a, (String)localObject1);
        break label344;
        Log.d("AccessibilityDispatcher", "ignore to click");
      }
    }
  }
  
  private String c(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if ((paramAccessibilityNodeInfo == null) || (!paramAccessibilityNodeInfo.isVisibleToUser()))
    {
      paramAccessibilityNodeInfo = "";
      return paramAccessibilityNodeInfo;
    }
    Object localObject3 = paramAccessibilityNodeInfo.getText();
    Object localObject2 = paramAccessibilityNodeInfo.getClassName().toString();
    Object localObject1 = localObject2;
    if (((String)localObject2).toString().startsWith("android.widget.")) {
      localObject1 = ((String)localObject2).substring("android.widget.".length());
    }
    localObject2 = localObject1;
    if (((String)localObject1).toString().startsWith("android.view.")) {
      localObject2 = ((String)localObject1).substring("android.view.".length());
    }
    localObject2 = new StringBuilder(String.valueOf(localObject2));
    if (TextUtils.isEmpty((CharSequence)localObject3)) {}
    int i1;
    int i2;
    for (localObject1 = "";; localObject1 = "@" + localObject3)
    {
      localObject3 = (String)localObject1;
      int i3 = paramAccessibilityNodeInfo.getChildCount();
      i1 = 0;
      localObject1 = "";
      i2 = 0;
      if (i1 < i3) {
        break label240;
      }
      localObject2 = localObject1;
      if (i2 > 1) {
        localObject2 = "{" + (String)localObject1 + "}";
      }
      paramAccessibilityNodeInfo.recycle();
      paramAccessibilityNodeInfo = (AccessibilityNodeInfo)localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        break;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label316;
      }
      return ((String)localObject3).toString();
    }
    label240:
    localObject2 = c(paramAccessibilityNodeInfo.getChild(i1));
    if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    for (;;)
    {
      i1 += 1;
      break;
      i2 += 1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = localObject2;
      } else {
        localObject1 = localObject1 + "," + (String)localObject2;
      }
    }
    label316:
    if (((String)localObject2).startsWith("{")) {
      return localObject3 + "," + (String)localObject2;
    }
    return localObject3 + ",{" + (String)localObject2 + "}";
  }
  
  private void c()
  {
    if (this.e != null) {
      this.e.a(this.b, 0);
    }
    sendEmptyMessageDelayed(1001, 100L);
  }
  
  private boolean c(taiji.a parama)
  {
    Log.i("AccessibilityDispatcher", "globalAction");
    if (parama == null) {
      return false;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    int i1;
    if (parama.k != null) {
      if (parama.k.size() <= 0) {
        i1 = 0;
      }
    }
    for (;;)
    {
      if ((i1 != 0) && (localObject1 != null))
      {
        ((AccessibilityNodeInfo)localObject1).recycle();
        return this.a.performGlobalAction(parama.o);
        AccessibilityNodeInfo localAccessibilityNodeInfo = this.a.getRootInActiveWindow();
        if (localAccessibilityNodeInfo == null)
        {
          i1 = 1;
        }
        else
        {
          Iterator localIterator = parama.k.iterator();
          if (!localIterator.hasNext())
          {
            localObject1 = localObject2;
            label104:
            localAccessibilityNodeInfo.recycle();
            i1 = 1;
          }
          else
          {
            localObject1 = (String)localIterator.next();
            switch (parama.j)
            {
            default: 
              localObject1 = localObject2;
            }
            for (;;)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                break;
              }
              break label104;
              localObject1 = a(localAccessibilityNodeInfo, parama.b, parama.n, (String)localObject1, parama.j);
              continue;
              localObject1 = b(localAccessibilityNodeInfo, parama.b, (String)localObject1);
            }
          }
        }
      }
      else
      {
        if (i1 == 0) {
          return this.a.performGlobalAction(parama.o);
        }
        return false;
        i1 = 0;
      }
    }
  }
  
  private void d()
  {
    int i3 = 0;
    AccessibilityServiceInfo localAccessibilityServiceInfo = this.a.getServiceInfo();
    if (localAccessibilityServiceInfo == null)
    {
      Log.e("AccessibilityDispatcher", "service is not start, can't setServiceInfo");
      return;
    }
    Object localObject3 = new HashSet();
    if (AccessibilityDispatcher.c().size() > 0) {
      ((Set)localObject3).addAll(AccessibilityDispatcher.c());
    }
    for (int i1 = -1;; i1 = 0)
    {
      Object localObject1 = AccessibilityDispatcher.d().values().iterator();
      int i2;
      if (!((Iterator)localObject1).hasNext())
      {
        i2 = ((Set)localObject3).size();
        if (AccessibilityDispatcher.a.forceMonitorAllPkg()) {
          break label487;
        }
        if (i2 > 0) {
          break label375;
        }
      }
      label375:
      Object localObject2;
      label487:
      for (localObject1 = this.n;; localObject2 = null) {
        for (;;)
        {
          int i4 = this.l;
          try
          {
            localObject3 = localAccessibilityServiceInfo.getClass();
            i2 = ((Integer)((Class)localObject3).getField("teacher").get(localObject3)).intValue();
            i4 = i2 | i4;
            i2 = i4;
            if (this.d != null) {
              i2 = i4 | this.d.e;
            }
            localAccessibilityServiceInfo.packageNames = ((String[])localObject1);
            localAccessibilityServiceInfo.eventTypes = i1;
            localAccessibilityServiceInfo.notificationTimeout = 80L;
            localAccessibilityServiceInfo.feedbackType = 16;
            localAccessibilityServiceInfo.flags = i2;
          }
          catch (Exception localException2)
          {
            try
            {
              localObject1 = localAccessibilityServiceInfo.getClass().getDeclaredField("mCanRetrieveWindowContent");
              ((Field)localObject1).setAccessible(true);
              ((Field)localObject1).set(localAccessibilityServiceInfo, Boolean.valueOf(true));
              if (localAccessibilityServiceInfo.packageNames != null)
              {
                localObject1 = localAccessibilityServiceInfo.packageNames;
                i2 = localObject1.length;
                i1 = i3;
                if (i1 < i2) {}
              }
              else
              {
                Log.i("AccessibilityDispatcher", "[setServiceInfo]event types: " + localAccessibilityServiceInfo.eventTypes);
                this.a.setServiceInfo(localAccessibilityServiceInfo);
                return;
                Iterator localIterator = ((List)((Iterator)localObject1).next()).iterator();
                i2 = i1;
                for (;;)
                {
                  i1 = i2;
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  taiji.a locala = (taiji.a)localIterator.next();
                  if (locala.r != null) {
                    ((Set)localObject3).addAll(locala.r);
                  }
                  i2 |= locala.q;
                }
                localObject1 = new String[i2];
                localObject3 = ((Set)localObject3).iterator();
                i2 = 0;
                while (((Iterator)localObject3).hasNext())
                {
                  localObject1[i2] = ((String)((Iterator)localObject3).next());
                  i2 += 1;
                }
                localException2 = localException2;
                i2 = 16;
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                Log.w("AccessibilityDispatcher", localException1.getMessage());
                continue;
                String str = localException1[i1];
                Log.i("AccessibilityDispatcher", "[setServiceInfo]" + str);
                i1 += 1;
              }
            }
          }
        }
      }
    }
  }
  
  public void a()
  {
    if (this.d != null)
    {
      this.g = true;
      synchronized (this.m)
      {
        if (this.d.c != null) {
          this.d.c.clear();
        }
        return;
      }
    }
    Log.e("AccessibilityDispatcher", "not play, why cancel?");
  }
  
  public void a(int paramInt)
  {
    if ((this.h > 0) && (this.h == paramInt)) {
      this.h = -1;
    }
  }
  
  /* Error */
  public void handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 482	android/os/Message:what	I
    //   4: lookupswitch	default:+76->80, 1001:+77->81, 1002:+269->273, 1003:+323->327, 1100:+381->385, 1101:+841->845, 1102:+871->875, 1103:+897->901, 1104:+902->906
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 39	com/meri/service/monitor/b:b	I
    //   86: iconst_1
    //   87: iadd
    //   88: putfield 39	com/meri/service/monitor/b:b	I
    //   91: aload_0
    //   92: getfield 39	com/meri/service/monitor/b:b	I
    //   95: istore_2
    //   96: aload_0
    //   97: getfield 62	com/meri/service/monitor/b:m	Ljava/lang/Object;
    //   100: astore 5
    //   102: aload 5
    //   104: monitorenter
    //   105: iload_2
    //   106: aload_0
    //   107: getfield 43	com/meri/service/monitor/b:d	Ltaiji/b;
    //   110: getfield 838	taiji/b:c	Ljava/util/ArrayList;
    //   113: invokevirtual 437	java/util/ArrayList:size	()I
    //   116: if_icmpge +807 -> 923
    //   119: ldc 119
    //   121: new 121	java/lang/StringBuilder
    //   124: dup
    //   125: ldc_w 848
    //   128: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: iload_2
    //   132: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   135: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 138	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   141: pop
    //   142: aload_0
    //   143: getfield 43	com/meri/service/monitor/b:d	Ltaiji/b;
    //   146: getfield 838	taiji/b:c	Ljava/util/ArrayList;
    //   149: iload_2
    //   150: invokevirtual 849	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   153: checkcast 140	taiji/a
    //   156: astore_1
    //   157: aload 5
    //   159: monitorexit
    //   160: aload_1
    //   161: ifnull +85 -> 246
    //   164: aload_0
    //   165: getfield 49	com/meri/service/monitor/b:g	Z
    //   168: ifne +78 -> 246
    //   171: aload_1
    //   172: getfield 852	taiji/a:u	I
    //   175: ifeq +16 -> 191
    //   178: aload_1
    //   179: getfield 852	taiji/a:u	I
    //   182: i2l
    //   183: invokestatic 858	java/lang/Thread:sleep	(J)V
    //   186: aload_1
    //   187: iconst_0
    //   188: putfield 852	taiji/a:u	I
    //   191: new 459	com/meri/service/monitor/a
    //   194: dup
    //   195: aconst_null
    //   196: invokespecial 860	com/meri/service/monitor/a:<init>	(Lcom/meri/service/monitor/a;)V
    //   199: astore 5
    //   201: aload 5
    //   203: aload_1
    //   204: putfield 462	com/meri/service/monitor/a:a	Ltaiji/a;
    //   207: aload 5
    //   209: invokestatic 510	java/lang/System:currentTimeMillis	()J
    //   212: putfield 464	com/meri/service/monitor/a:b	J
    //   215: aload_0
    //   216: aload 5
    //   218: invokespecial 862	com/meri/service/monitor/b:a	(Lcom/meri/service/monitor/a;)V
    //   221: return
    //   222: astore_1
    //   223: aload 5
    //   225: monitorexit
    //   226: aload_1
    //   227: athrow
    //   228: astore 5
    //   230: ldc 119
    //   232: aload 5
    //   234: invokevirtual 863	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   237: aload 5
    //   239: invokestatic 238	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   242: pop
    //   243: goto -57 -> 186
    //   246: aload_0
    //   247: getfield 47	com/meri/service/monitor/b:f	Ltaiji/ct;
    //   250: ifnull +18 -> 268
    //   253: aload_0
    //   254: getfield 47	com/meri/service/monitor/b:f	Ltaiji/ct;
    //   257: invokestatic 510	java/lang/System:currentTimeMillis	()J
    //   260: aload_0
    //   261: getfield 41	com/meri/service/monitor/b:c	J
    //   264: lsub
    //   265: putfield 644	taiji/ct:c	J
    //   268: aload_0
    //   269: invokespecial 646	com/meri/service/monitor/b:b	()V
    //   272: return
    //   273: aload_0
    //   274: getfield 49	com/meri/service/monitor/b:g	Z
    //   277: ifne +15 -> 292
    //   280: aload_0
    //   281: aload_1
    //   282: getfield 485	android/os/Message:obj	Ljava/lang/Object;
    //   285: checkcast 459	com/meri/service/monitor/a
    //   288: invokespecial 862	com/meri/service/monitor/b:a	(Lcom/meri/service/monitor/a;)V
    //   291: return
    //   292: aload_0
    //   293: getfield 47	com/meri/service/monitor/b:f	Ltaiji/ct;
    //   296: ifnull +26 -> 322
    //   299: aload_0
    //   300: getfield 47	com/meri/service/monitor/b:f	Ltaiji/ct;
    //   303: iconst_4
    //   304: putfield 643	taiji/ct:b	I
    //   307: aload_0
    //   308: getfield 47	com/meri/service/monitor/b:f	Ltaiji/ct;
    //   311: invokestatic 510	java/lang/System:currentTimeMillis	()J
    //   314: aload_0
    //   315: getfield 41	com/meri/service/monitor/b:c	J
    //   318: lsub
    //   319: putfield 644	taiji/ct:c	J
    //   322: aload_0
    //   323: invokespecial 646	com/meri/service/monitor/b:b	()V
    //   326: return
    //   327: aload_0
    //   328: getfield 49	com/meri/service/monitor/b:g	Z
    //   331: ifne +19 -> 350
    //   334: aload_0
    //   335: aload_1
    //   336: getfield 485	android/os/Message:obj	Ljava/lang/Object;
    //   339: checkcast 459	com/meri/service/monitor/a
    //   342: aload_1
    //   343: getfield 532	android/os/Message:arg1	I
    //   346: invokespecial 865	com/meri/service/monitor/b:a	(Lcom/meri/service/monitor/a;I)V
    //   349: return
    //   350: aload_0
    //   351: getfield 47	com/meri/service/monitor/b:f	Ltaiji/ct;
    //   354: ifnull +26 -> 380
    //   357: aload_0
    //   358: getfield 47	com/meri/service/monitor/b:f	Ltaiji/ct;
    //   361: iconst_4
    //   362: putfield 643	taiji/ct:b	I
    //   365: aload_0
    //   366: getfield 47	com/meri/service/monitor/b:f	Ltaiji/ct;
    //   369: invokestatic 510	java/lang/System:currentTimeMillis	()J
    //   372: aload_0
    //   373: getfield 41	com/meri/service/monitor/b:c	J
    //   376: lsub
    //   377: putfield 644	taiji/ct:c	J
    //   380: aload_0
    //   381: invokespecial 646	com/meri/service/monitor/b:b	()V
    //   384: return
    //   385: new 140	taiji/a
    //   388: dup
    //   389: invokespecial 866	taiji/a:<init>	()V
    //   392: astore 6
    //   394: aload 6
    //   396: iconst_2
    //   397: putfield 468	taiji/a:a	I
    //   400: aload 6
    //   402: iconst_2
    //   403: putfield 197	taiji/a:j	I
    //   406: aload 6
    //   408: new 149	java/util/ArrayList
    //   411: dup
    //   412: invokespecial 159	java/util/ArrayList:<init>	()V
    //   415: putfield 143	taiji/a:k	Ljava/util/ArrayList;
    //   418: aload_0
    //   419: getfield 72	com/meri/service/monitor/b:o	[Ljava/lang/String;
    //   422: astore_1
    //   423: aload_1
    //   424: arraylength
    //   425: istore_3
    //   426: iconst_0
    //   427: istore_2
    //   428: iload_2
    //   429: iload_3
    //   430: if_icmplt +256 -> 686
    //   433: aload_0
    //   434: aload 6
    //   436: invokespecial 497	com/meri/service/monitor/b:b	(Ltaiji/a;)Z
    //   439: ifne +368 -> 807
    //   442: aload_0
    //   443: getfield 34	com/meri/service/monitor/b:a	Lcom/meri/service/monitor/AccessibilityDispatcher;
    //   446: invokevirtual 867	com/meri/service/monitor/AccessibilityDispatcher:getPackageName	()Ljava/lang/String;
    //   449: astore 7
    //   451: aload_0
    //   452: getfield 34	com/meri/service/monitor/b:a	Lcom/meri/service/monitor/AccessibilityDispatcher;
    //   455: ldc_w 869
    //   458: invokevirtual 873	com/meri/service/monitor/AccessibilityDispatcher:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   461: checkcast 875	android/view/accessibility/AccessibilityManager
    //   464: invokevirtual 879	android/view/accessibility/AccessibilityManager:getInstalledAccessibilityServiceList	()Ljava/util/List;
    //   467: invokeinterface 427 1 0
    //   472: astore 8
    //   474: aconst_null
    //   475: astore_1
    //   476: aload 8
    //   478: invokeinterface 158 1 0
    //   483: istore 4
    //   485: iload 4
    //   487: ifne +222 -> 709
    //   490: new 140	taiji/a
    //   493: dup
    //   494: invokespecial 866	taiji/a:<init>	()V
    //   497: astore 5
    //   499: aload 5
    //   501: iconst_4
    //   502: putfield 468	taiji/a:a	I
    //   505: aload 5
    //   507: iconst_1
    //   508: putfield 765	taiji/a:o	I
    //   511: aload_1
    //   512: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   515: ifne +31 -> 546
    //   518: aload 5
    //   520: iconst_1
    //   521: putfield 197	taiji/a:j	I
    //   524: aload 5
    //   526: new 149	java/util/ArrayList
    //   529: dup
    //   530: invokespecial 159	java/util/ArrayList:<init>	()V
    //   533: putfield 143	taiji/a:k	Ljava/util/ArrayList;
    //   536: aload 5
    //   538: getfield 143	taiji/a:k	Ljava/util/ArrayList;
    //   541: aload_1
    //   542: invokevirtual 180	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   545: pop
    //   546: aload_0
    //   547: aload 5
    //   549: invokespecial 534	com/meri/service/monitor/b:c	(Ltaiji/a;)Z
    //   552: istore 4
    //   554: ldc 119
    //   556: new 121	java/lang/StringBuilder
    //   559: dup
    //   560: ldc_w 881
    //   563: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   566: iload 4
    //   568: invokevirtual 130	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   571: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 138	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   577: pop
    //   578: ldc2_w 519
    //   581: invokestatic 858	java/lang/Thread:sleep	(J)V
    //   584: aload_0
    //   585: aload 6
    //   587: invokespecial 497	com/meri/service/monitor/b:b	(Ltaiji/a;)Z
    //   590: ifne +243 -> 833
    //   593: ldc 74
    //   595: aload_0
    //   596: getfield 55	com/meri/service/monitor/b:i	Ljava/lang/String;
    //   599: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   602: ifeq +52 -> 654
    //   605: new 140	taiji/a
    //   608: dup
    //   609: invokespecial 866	taiji/a:<init>	()V
    //   612: astore_1
    //   613: aload_1
    //   614: iconst_4
    //   615: putfield 468	taiji/a:a	I
    //   618: aload_1
    //   619: iconst_1
    //   620: putfield 765	taiji/a:o	I
    //   623: aload_0
    //   624: aload_1
    //   625: invokespecial 534	com/meri/service/monitor/b:c	(Ltaiji/a;)Z
    //   628: istore 4
    //   630: ldc 119
    //   632: new 121	java/lang/StringBuilder
    //   635: dup
    //   636: ldc_w 883
    //   639: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   642: iload 4
    //   644: invokevirtual 130	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   647: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: invokestatic 138	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   653: pop
    //   654: aload_0
    //   655: aconst_null
    //   656: putfield 55	com/meri/service/monitor/b:i	Ljava/lang/String;
    //   659: invokestatic 553	com/meri/service/monitor/AccessibilityDispatcher:c	()Ljava/util/Set;
    //   662: invokeinterface 556 1 0
    //   667: aload_0
    //   668: invokespecial 562	com/meri/service/monitor/b:d	()V
    //   671: getstatic 96	com/meri/service/monitor/AccessibilityDispatcher:a	Lcom/meri/service/monitor/d;
    //   674: ifnull -594 -> 80
    //   677: getstatic 96	com/meri/service/monitor/AccessibilityDispatcher:a	Lcom/meri/service/monitor/d;
    //   680: invokeinterface 886 1 0
    //   685: return
    //   686: aload_1
    //   687: iload_2
    //   688: aaload
    //   689: astore 5
    //   691: aload 6
    //   693: getfield 143	taiji/a:k	Ljava/util/ArrayList;
    //   696: aload 5
    //   698: invokevirtual 180	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   701: pop
    //   702: iload_2
    //   703: iconst_1
    //   704: iadd
    //   705: istore_2
    //   706: goto -278 -> 428
    //   709: aload 8
    //   711: invokeinterface 196 1 0
    //   716: checkcast 88	android/accessibilityservice/AccessibilityServiceInfo
    //   719: astore 5
    //   721: aload 5
    //   723: ifnull -247 -> 476
    //   726: aload 5
    //   728: invokevirtual 889	android/accessibilityservice/AccessibilityServiceInfo:getId	()Ljava/lang/String;
    //   731: astore 9
    //   733: aload 9
    //   735: ifnull -259 -> 476
    //   738: aload 9
    //   740: new 121	java/lang/StringBuilder
    //   743: dup
    //   744: aload 7
    //   746: invokestatic 661	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   749: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   752: ldc_w 891
    //   755: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   761: invokevirtual 331	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   764: ifeq -288 -> 476
    //   767: aload 5
    //   769: aload_0
    //   770: getfield 34	com/meri/service/monitor/b:a	Lcom/meri/service/monitor/AccessibilityDispatcher;
    //   773: invokevirtual 346	com/meri/service/monitor/AccessibilityDispatcher:getPackageManager	()Landroid/content/pm/PackageManager;
    //   776: invokevirtual 895	android/accessibilityservice/AccessibilityServiceInfo:loadDescription	(Landroid/content/pm/PackageManager;)Ljava/lang/String;
    //   779: astore 5
    //   781: aload 5
    //   783: astore_1
    //   784: goto -308 -> 476
    //   787: astore 5
    //   789: aconst_null
    //   790: astore_1
    //   791: ldc 119
    //   793: aload 5
    //   795: invokevirtual 235	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   798: aload 5
    //   800: invokestatic 238	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   803: pop
    //   804: goto -314 -> 490
    //   807: ldc 119
    //   809: ldc_w 897
    //   812: invokestatic 138	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   815: pop
    //   816: goto -238 -> 578
    //   819: astore_1
    //   820: ldc 119
    //   822: aload_1
    //   823: invokevirtual 863	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   826: invokestatic 138	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   829: pop
    //   830: goto -246 -> 584
    //   833: ldc 119
    //   835: ldc_w 899
    //   838: invokestatic 138	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   841: pop
    //   842: goto -188 -> 654
    //   845: aload_1
    //   846: getfield 485	android/os/Message:obj	Ljava/lang/Object;
    //   849: checkcast 459	com/meri/service/monitor/a
    //   852: astore_1
    //   853: invokestatic 412	com/meri/service/monitor/AccessibilityDispatcher:d	()Ljava/util/Map;
    //   856: aload_1
    //   857: getfield 902	com/meri/service/monitor/a:c	Ltaiji/cr;
    //   860: aload_1
    //   861: getfield 905	com/meri/service/monitor/a:d	Ljava/util/List;
    //   864: invokeinterface 909 3 0
    //   869: pop
    //   870: aload_0
    //   871: invokespecial 562	com/meri/service/monitor/b:d	()V
    //   874: return
    //   875: aload_1
    //   876: getfield 485	android/os/Message:obj	Ljava/lang/Object;
    //   879: checkcast 459	com/meri/service/monitor/a
    //   882: astore_1
    //   883: invokestatic 412	com/meri/service/monitor/AccessibilityDispatcher:d	()Ljava/util/Map;
    //   886: aload_1
    //   887: getfield 902	com/meri/service/monitor/a:c	Ltaiji/cr;
    //   890: invokeinterface 911 2 0
    //   895: pop
    //   896: aload_0
    //   897: invokespecial 562	com/meri/service/monitor/b:d	()V
    //   900: return
    //   901: aload_0
    //   902: invokespecial 562	com/meri/service/monitor/b:d	()V
    //   905: return
    //   906: aload_0
    //   907: aload_1
    //   908: getfield 485	android/os/Message:obj	Ljava/lang/Object;
    //   911: checkcast 407	android/view/accessibility/AccessibilityEvent
    //   914: invokespecial 913	com/meri/service/monitor/b:a	(Landroid/view/accessibility/AccessibilityEvent;)V
    //   917: return
    //   918: astore 5
    //   920: goto -129 -> 791
    //   923: aconst_null
    //   924: astore_1
    //   925: goto -768 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	928	0	this	b
    //   0	928	1	paramMessage	Message
    //   95	611	2	i1	int
    //   425	6	3	i2	int
    //   483	160	4	bool	boolean
    //   100	124	5	localObject1	Object
    //   228	10	5	localInterruptedException	java.lang.InterruptedException
    //   497	285	5	localObject2	Object
    //   787	12	5	localThrowable1	Throwable
    //   918	1	5	localThrowable2	Throwable
    //   392	300	6	locala	taiji.a
    //   449	296	7	str1	String
    //   472	238	8	localIterator	Iterator
    //   731	8	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   105	157	222	finally
    //   157	160	222	finally
    //   223	226	222	finally
    //   178	186	228	java/lang/InterruptedException
    //   442	474	787	java/lang/Throwable
    //   578	584	819	java/lang/InterruptedException
    //   476	485	918	java/lang/Throwable
    //   709	721	918	java/lang/Throwable
    //   726	733	918	java/lang/Throwable
    //   738	781	918	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.meri.service.monitor.b
 * JD-Core Version:    0.7.0.1
 */