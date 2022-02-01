package com.meri.service.monitor;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import taiji.b;
import taiji.bp.a;
import taiji.bp.b;
import taiji.bp.c;
import taiji.c;
import taiji.d;

@SuppressLint({"NewApi"})
public class AccessibilityDispatcher
  extends AccessibilityService
{
  public static a a;
  private static AccessibilityDispatcher b;
  private static boolean d = false;
  private static boolean e = false;
  private static Set<String> f = new HashSet();
  private static Map<bp.b, List<taiji.a>> g = new HashMap();
  private b c;
  
  public static int a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return 1;
    }
    if (!b())
    {
      if (b(paramContext)) {
        return 4;
      }
      return 2;
    }
    paramContext = b.c;
    if ((paramContext != null) && ((b.a(paramContext) != null) || (b.b(paramContext) != null))) {
      return 3;
    }
    return 0;
  }
  
  public static void a()
  {
    Object localObject = b;
    if (localObject == null) {}
    for (localObject = "service not started, why cancel?";; localObject = "hasn't play, why cancel?")
    {
      Log.e("AccessibilityDispatcher", (String)localObject);
      return;
      localObject = ((AccessibilityDispatcher)localObject).c;
      if (localObject != null) {
        break;
      }
    }
    ((b)localObject).a();
  }
  
  public static void a(Context paramContext, b paramb, bp.a parama)
  {
    if ((paramb != null) && (paramb.c != null))
    {
      int i = a(paramContext);
      if (i != 0)
      {
        paramContext = new StringBuilder("canPlay error is ");
        paramContext.append(i);
        Log.e("AccessibilityDispatcher", paramContext.toString());
        return;
      }
      paramContext = b.e();
      if (paramContext != null)
      {
        b.a(paramContext, -1);
        if (parama != null) {
          parama.a();
        }
        b.a(paramContext, System.currentTimeMillis());
        b.a(paramContext, paramb);
        b.a(paramContext, parama);
        b.a(paramContext, new bp.c());
        b.c(paramContext).a = paramb.b;
        paramContext.sendEmptyMessage(1001);
      }
      return;
    }
    Log.e("AccessibilityDispatcher", "no action to play");
  }
  
  public static boolean b()
  {
    if (e)
    {
      localObject = b;
      if ((localObject == null) || (((AccessibilityDispatcher)localObject).getServiceInfo() == null)) {
        e = false;
      }
    }
    Object localObject = new StringBuilder("isServerStart: ");
    ((StringBuilder)localObject).append(e);
    Log.i("AccessibilityDispatcher", ((StringBuilder)localObject).toString());
    return e;
  }
  
  public static boolean b(Context paramContext)
  {
    int j;
    int i;
    label157:
    do
    {
      try
      {
        localObject = paramContext.getPackageName();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return false;
        }
        paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_accessibility_services");
        if (TextUtils.isEmpty(paramContext)) {
          return false;
        }
        paramContext = paramContext.split(":");
        if (paramContext == null) {
          break label157;
        }
        if (paramContext.length <= 0) {
          return false;
        }
        localObject = new StringBuilder(String.valueOf(localObject));
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(AccessibilityDispatcher.class.getName());
        localObject = ((StringBuilder)localObject).toString();
        j = paramContext.length;
        i = 0;
      }
      catch (Throwable paramContext)
      {
        CharSequence localCharSequence;
        boolean bool;
        Object localObject = a;
        if (localObject == null) {
          break label157;
        }
        ((a)localObject).onException(paramContext);
      }
      localCharSequence = paramContext[i];
      if (!TextUtils.isEmpty(localCharSequence))
      {
        bool = localCharSequence.equals(localObject);
        if (bool) {
          return true;
        }
      }
      i += 1;
      continue;
      return false;
    } while (i < j);
    return false;
  }
  
  private b e()
  {
    Object localObject = this.c;
    if (localObject != null) {
      return localObject;
    }
    localObject = getResources().getDisplayMetrics();
    HandlerThread localHandlerThread = a.getHandlerThread("puppet_thread");
    localHandlerThread.start();
    this.c = new b(localHandlerThread.getLooper(), this, ((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    return this.c;
  }
  
  public void onAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent == null) {
      return;
    }
    int i = paramAccessibilityEvent.getEventType();
    Object localObject = new StringBuilder("eventType=");
    ((StringBuilder)localObject).append(i);
    Log.i("AccessibilityDispatcher", ((StringBuilder)localObject).toString());
    if (this.c == null) {
      return;
    }
    if ((32 == i) || (4096 == i)) {
      this.c.a(i);
    }
    if ((32 == i) && (b.d(this.c) != null))
    {
      localObject = paramAccessibilityEvent.getPackageName();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        b.a(this.c, ((CharSequence)localObject).toString());
      }
    }
    if (g.size() > 0) {
      Message.obtain(this.c, 1104, AccessibilityEvent.obtain(paramAccessibilityEvent)).sendToTarget();
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    a locala = a;
    if (locala != null) {
      locala.onCreate();
    }
  }
  
  public void onDestroy()
  {
    Log.i("AccessibilityDispatcher", "onDestroy");
    e = false;
    b = null;
    super.onDestroy();
  }
  
  public void onInterrupt()
  {
    Log.e("AccessibilityDispatcher", "onInterrupt");
  }
  
  protected void onServiceConnected()
  {
    Log.i("AccessibilityDispatcher", "onServiceConnected");
    Object localObject = a;
    if (localObject != null)
    {
      localObject = ((a)localObject).onConnected(null);
      boolean bool1;
      if (localObject != null) {
        bool1 = ((Bundle)localObject).getBoolean("key.c.u.a", true);
      } else {
        bool1 = true;
      }
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (Build.VERSION.SDK_INT < 16) {
          bool2 = false;
        }
      }
      if (!bool2)
      {
        stopSelf();
        return;
      }
      b = this;
      e = true;
      localObject = b.e();
      if (d)
      {
        d = false;
        if (localObject != null)
        {
          b.a((b)localObject, "");
          ((b)localObject).sendEmptyMessageDelayed(1100, 200L);
        }
      }
      else if (localObject != null)
      {
        ((b)localObject).sendEmptyMessage(1103);
      }
      return;
    }
    Log.e("AccessibilityDispatcher", "mConfigAndObserver is null!");
    stopSelf();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    Log.i("AccessibilityDispatcher", "onUnbind");
    e = false;
    b = null;
    return super.onUnbind(paramIntent);
  }
  
  private static class a
  {
    public taiji.a a;
    public long b;
    public bp.b c;
    public List<taiji.a> d;
  }
  
  private class b
    extends Handler
  {
    private int b = -1;
    private long c = 0L;
    private b d = null;
    private bp.a e = null;
    private bp.c f = null;
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
    
    public b(Looper paramLooper, Context paramContext, int paramInt1, int paramInt2)
    {
      super();
      this.j = paramInt1;
      this.k = paramInt2;
      paramLooper = AccessibilityDispatcher.this.getServiceInfo();
      if (paramLooper != null)
      {
        this.l = paramLooper.flags;
        if (AccessibilityDispatcher.a == null) {
          return;
        }
        if (AccessibilityDispatcher.a.forceMonitorAllPkg()) {
          return;
        }
        paramLooper.packageNames = new String[] { paramContext.getPackageName(), "com.android.settings" };
        AccessibilityDispatcher.this.setServiceInfo(paramLooper);
        return;
      }
      this.l = 0;
    }
    
    private int a(taiji.a parama, boolean paramBoolean)
    {
      Object localObject1 = new StringBuilder("scrollList, isForward=");
      ((StringBuilder)localObject1).append(paramBoolean);
      Log.i("AccessibilityDispatcher", ((StringBuilder)localObject1).toString());
      if (parama != null)
      {
        if (parama.k == null) {
          return 3;
        }
        AccessibilityNodeInfo localAccessibilityNodeInfo = AccessibilityDispatcher.this.getRootInActiveWindow();
        if (localAccessibilityNodeInfo == null) {
          return 3;
        }
        Object localObject3 = parama.k.iterator();
        do
        {
          boolean bool = ((Iterator)localObject3).hasNext();
          Object localObject2 = null;
          localObject1 = null;
          if (!bool)
          {
            localObject2 = new ArrayList();
            if (!TextUtils.isEmpty(parama.m))
            {
              localObject3 = new d();
              ((d)localObject3).a = parama.m;
              ((d)localObject3).e = parama.n;
              ((ArrayList)localObject2).add(localObject3);
            }
            if (parama.w != null) {
              ((ArrayList)localObject2).addAll(parama.w);
            }
            localObject2 = ((ArrayList)localObject2).iterator();
            parama = (taiji.a)localObject1;
            while (((Iterator)localObject2).hasNext())
            {
              parama = (d)((Iterator)localObject2).next();
              localObject1 = a(localAccessibilityNodeInfo, parama.a, parama.e);
              parama = (taiji.a)localObject1;
              if (localObject1 != null) {
                parama = (taiji.a)localObject1;
              }
            }
            if (parama == null)
            {
              localAccessibilityNodeInfo.recycle();
              return 3;
            }
            a(parama, paramBoolean);
            parama.recycle();
            localAccessibilityNodeInfo.recycle();
            return 2;
          }
          localObject1 = (String)((Iterator)localObject3).next();
          switch (parama.j)
          {
          default: 
            localObject1 = localObject2;
            break;
          case 2: 
            localObject1 = b(localAccessibilityNodeInfo, parama.b, (String)localObject1);
            break;
          case 1: 
          case 3: 
          case 4: 
          case 5: 
            localObject1 = a(localAccessibilityNodeInfo, parama.b, null, (String)localObject1, parama.j);
          }
        } while (localObject1 == null);
        ((AccessibilityNodeInfo)localObject1).recycle();
        localAccessibilityNodeInfo.recycle();
        return 1;
      }
      return 3;
    }
    
    private Bundle a(ArrayList<c> paramArrayList)
    {
      Bundle localBundle = new Bundle();
      paramArrayList = paramArrayList.iterator();
      for (;;)
      {
        if (!paramArrayList.hasNext()) {
          return localBundle;
        }
        c localc = (c)paramArrayList.next();
        try
        {
          switch (localc.b)
          {
          case 6: 
            short s = Short.parseShort(localc.c);
            localBundle.putShort(localc.a, s);
          }
        }
        catch (Throwable paramArrayList)
        {
          boolean bool;
          long l1;
          int i1;
          Log.e("AccessibilityDispatcher", paramArrayList.getMessage(), paramArrayList);
          return null;
        }
        bool = Boolean.parseBoolean(localc.c);
        localBundle.putBoolean(localc.a, bool);
        continue;
        localBundle.putString(localc.a, localc.c);
        continue;
        l1 = Long.parseLong(localc.c);
        localBundle.putLong(localc.a, l1);
        continue;
        i1 = Integer.parseInt(localc.c);
        localBundle.putInt(localc.a, i1);
      }
    }
    
    private AccessibilityNodeInfo a(AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString1, String paramString2)
    {
      Object localObject = new StringBuilder("findNodeByClassName nodeClass=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" parentClass=");
      ((StringBuilder)localObject).append(paramString2);
      Log.i("AccessibilityDispatcher", ((StringBuilder)localObject).toString());
      if (paramAccessibilityNodeInfo != null)
      {
        if (paramString1 == null) {
          return null;
        }
        if (paramString1.equals(paramAccessibilityNodeInfo.getClassName().toString())) {
          if (!TextUtils.isEmpty(paramString2))
          {
            localObject = paramAccessibilityNodeInfo.getParent();
            if (localObject != null)
            {
              boolean bool = paramString2.equals(((AccessibilityNodeInfo)localObject).getClassName().toString());
              ((AccessibilityNodeInfo)localObject).recycle();
              if ((bool) && (paramAccessibilityNodeInfo.isVisibleToUser())) {
                return paramAccessibilityNodeInfo;
              }
            }
          }
          else if (paramAccessibilityNodeInfo.isVisibleToUser())
          {
            return paramAccessibilityNodeInfo;
          }
        }
        int i1 = 0;
        for (;;)
        {
          if (i1 >= paramAccessibilityNodeInfo.getChildCount()) {
            return null;
          }
          localObject = paramAccessibilityNodeInfo.getChild(i1);
          if (localObject != null)
          {
            AccessibilityNodeInfo localAccessibilityNodeInfo = a((AccessibilityNodeInfo)localObject, paramString1, paramString2);
            if (localAccessibilityNodeInfo != localObject) {
              ((AccessibilityNodeInfo)localObject).recycle();
            }
            if (localAccessibilityNodeInfo != null) {
              return localAccessibilityNodeInfo;
            }
          }
          i1 += 1;
        }
      }
      return null;
    }
    
    private AccessibilityNodeInfo a(AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString1, String paramString2, String paramString3, int paramInt)
    {
      Object localObject1 = paramString3;
      boolean bool3;
      if ((paramInt != 1) && (paramInt != 5)) {
        bool3 = false;
      } else {
        bool3 = true;
      }
      Object localObject2 = new StringBuilder("findNodeByApi, clsName=");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(" parentCls=");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(" rawText=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" textType=");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" exactMatch=");
      ((StringBuilder)localObject2).append(bool3);
      Log.i("AccessibilityDispatcher", ((StringBuilder)localObject2).toString());
      if (paramAccessibilityNodeInfo == null)
      {
        Log.w("AccessibilityDispatcher", "root node is null");
        return null;
      }
      if (TextUtils.isEmpty(paramString3)) {
        return null;
      }
      Object localObject3 = localObject1;
      int i1;
      if (paramInt == 5) {
        try
        {
          localObject1 = ((String)localObject1).split(":");
          if ((localObject1 != null) && (localObject1.length == 2) && (!TextUtils.isEmpty(localObject1[0])) && (!TextUtils.isEmpty(localObject1[1])) && (localObject1[1].startsWith("string/")))
          {
            paramString3 = localObject1[0];
            localObject1 = localObject1[1].substring(7);
            localObject2 = AccessibilityDispatcher.this.getPackageManager().getResourcesForApplication(paramString3);
            i1 = ((Resources)localObject2).getIdentifier((String)localObject1, "string", paramString3);
            if (i1 > 0)
            {
              localObject3 = ((Resources)localObject2).getString(i1);
              paramString3 = new StringBuilder("result|");
              paramString3.append((String)localObject3);
              Log.i("AccessibilityDispatcher", paramString3.toString());
            }
            else
            {
              paramAccessibilityNodeInfo = new StringBuilder("can't find res|");
              paramAccessibilityNodeInfo.append((String)localObject1);
              Log.w("AccessibilityDispatcher", paramAccessibilityNodeInfo.toString());
              return null;
            }
          }
          else
          {
            Log.e("AccessibilityDispatcher", "the format of text isnot meet the requirements");
            return null;
          }
        }
        catch (Throwable paramAccessibilityNodeInfo)
        {
          Log.e("AccessibilityDispatcher", paramAccessibilityNodeInfo.getMessage(), paramAccessibilityNodeInfo);
          return null;
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        return null;
      }
      if ((paramInt != 1) && (paramInt != 4) && (paramInt != 5))
      {
        if ((paramInt == 3) && (Build.VERSION.SDK_INT >= 18)) {
          paramString3 = paramAccessibilityNodeInfo.findAccessibilityNodeInfosByViewId((String)localObject3);
        } else {
          paramString3 = null;
        }
      }
      else {
        paramString3 = paramAccessibilityNodeInfo.findAccessibilityNodeInfosByText((String)localObject3);
      }
      if (paramString3 != null)
      {
        if (paramString3.size() <= 0) {
          return null;
        }
        int i3 = paramString3.size();
        paramAccessibilityNodeInfo = null;
        i1 = 0;
        AccessibilityNodeInfo localAccessibilityNodeInfo2;
        if (i1 < i3)
        {
          localAccessibilityNodeInfo2 = (AccessibilityNodeInfo)paramString3.get(i1);
          if (!a(localAccessibilityNodeInfo2)) {}
          boolean bool2;
          for (localObject1 = "cannot ClickNode";; localObject1 = "text not match")
          {
            Log.i("AccessibilityDispatcher", (String)localObject1);
            break label830;
            if (bool3)
            {
              localObject1 = localAccessibilityNodeInfo2.getText();
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                bool2 = ((String)localObject3).equals(((CharSequence)localObject1).toString());
              } else {
                bool2 = false;
              }
            }
            else
            {
              bool2 = true;
            }
            if (bool2) {
              break;
            }
          }
          if (TextUtils.isEmpty(paramString1))
          {
            paramAccessibilityNodeInfo = (AccessibilityNodeInfo)paramString3.remove(i1);
          }
          else
          {
            boolean bool1 = TextUtils.isEmpty(paramString2) ^ true;
            bool2 = paramString1.equals(localAccessibilityNodeInfo2.getClassName());
            if (bool1) {
              paramInt = 0;
            } else {
              paramInt = 1;
            }
            int i2;
            if (bool1)
            {
              localObject2 = localAccessibilityNodeInfo2.getParent();
              localObject1 = localObject2;
              i2 = paramInt;
              if (localObject2 != null)
              {
                localObject1 = localObject2;
                i2 = paramInt;
                if (paramString2.equals(((AccessibilityNodeInfo)localObject2).getClassName()))
                {
                  i2 = 1;
                  localObject1 = localObject2;
                }
              }
            }
            else
            {
              localObject1 = null;
              i2 = paramInt;
            }
            if ((!bool2) || (i2 == 0)) {
              break label764;
            }
            paramString1 = (AccessibilityNodeInfo)paramString3.remove(i1);
            paramAccessibilityNodeInfo = paramString1;
            if (localObject1 != null)
            {
              ((AccessibilityNodeInfo)localObject1).recycle();
              paramAccessibilityNodeInfo = paramString1;
            }
          }
        }
        for (;;)
        {
          if (paramString3.size() <= 0) {
            return paramAccessibilityNodeInfo;
          }
          ((AccessibilityNodeInfo)paramString3.remove(paramString3.size() - 1)).recycle();
        }
        label764:
        AccessibilityNodeInfo localAccessibilityNodeInfo1 = paramAccessibilityNodeInfo;
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localAccessibilityNodeInfo2.getParent();
          localAccessibilityNodeInfo1 = paramAccessibilityNodeInfo;
        }
        for (;;)
        {
          if (localObject2 == null)
          {
            paramAccessibilityNodeInfo = localAccessibilityNodeInfo1;
          }
          else
          {
            localAccessibilityNodeInfo1 = a((AccessibilityNodeInfo)localObject2, paramString1, paramString2);
            if (localAccessibilityNodeInfo1 == null) {
              break label839;
            }
            paramAccessibilityNodeInfo = localAccessibilityNodeInfo1;
            if (localAccessibilityNodeInfo1 != localObject2)
            {
              ((AccessibilityNodeInfo)localObject2).recycle();
              paramAccessibilityNodeInfo = localAccessibilityNodeInfo1;
            }
          }
          label830:
          i1 += 1;
          break;
          label839:
          paramAccessibilityNodeInfo = ((AccessibilityNodeInfo)localObject2).getParent();
          ((AccessibilityNodeInfo)localObject2).recycle();
          localObject2 = paramAccessibilityNodeInfo;
        }
      }
      return null;
    }
    
    private void a(final AccessibilityEvent paramAccessibilityEvent)
    {
      Log.i("AccessibilityDispatcher", "dispatchUiEvent");
      if (paramAccessibilityEvent == null) {
        return;
      }
      CharSequence localCharSequence = paramAccessibilityEvent.getPackageName();
      if (TextUtils.isEmpty(localCharSequence)) {
        return;
      }
      Object localObject1 = null;
      Iterator localIterator1 = AccessibilityDispatcher.d().entrySet().iterator();
      for (;;)
      {
        if (!localIterator1.hasNext())
        {
          if (localObject1 != null) {
            ((AccessibilityNodeInfo)localObject1).recycle();
          }
          return;
        }
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        Object localObject2 = (List)localEntry.getValue();
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          Iterator localIterator2 = ((List)localObject2).iterator();
          while (localIterator2.hasNext())
          {
            Object localObject3 = (taiji.a)localIterator2.next();
            if ((((taiji.a)localObject3).q & paramAccessibilityEvent.getEventType()) != 0)
            {
              int i1;
              if ((((taiji.a)localObject3).r != null) && (((taiji.a)localObject3).r.size() > 0))
              {
                localObject2 = ((taiji.a)localObject3).r.iterator();
                do
                {
                  if (!((Iterator)localObject2).hasNext())
                  {
                    i1 = 0;
                    break;
                  }
                } while (!localCharSequence.equals((String)((Iterator)localObject2).next()));
                i1 = 1;
                if (i1 == 0) {}
              }
              else
              {
                if ((((taiji.a)localObject3).k != null) && (((taiji.a)localObject3).k.size() > 0))
                {
                  localObject2 = localObject1;
                  if (localObject1 == null) {
                    localObject2 = AccessibilityDispatcher.this.getRootInActiveWindow();
                  }
                  localObject1 = ((taiji.a)localObject3).k.iterator();
                  i1 = 0;
                }
                while (((Iterator)localObject1).hasNext())
                {
                  localObject3 = a((AccessibilityNodeInfo)localObject2, null, null, (String)((Iterator)localObject1).next(), 1);
                  if (localObject3 != null)
                  {
                    ((AccessibilityNodeInfo)localObject3).recycle();
                    i1 = 1;
                    continue;
                    i1 = 1;
                    localObject2 = localObject1;
                  }
                }
                if (i1 == 0)
                {
                  localObject1 = localObject2;
                }
                else
                {
                  localObject3 = (bp.b)localEntry.getKey();
                  localObject1 = localObject2;
                  if (AccessibilityDispatcher.a != null)
                  {
                    Handler localHandler = AccessibilityDispatcher.a.getMonitorCallbackHandler();
                    localObject1 = localObject2;
                    if (localHandler != null)
                    {
                      localHandler.post(new Runnable()
                      {
                        public void run()
                        {
                          this.b.a(paramAccessibilityEvent);
                        }
                      });
                      localObject1 = localObject2;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    
    private void a(AccessibilityDispatcher.a parama)
    {
      Object localObject = parama.a;
      long l2 = parama.b;
      StringBuilder localStringBuilder = new StringBuilder("performAction: ");
      localStringBuilder.append(((taiji.a)localObject).a);
      localStringBuilder.append(" mWaitEventType=");
      localStringBuilder.append(this.h);
      Log.i("AccessibilityDispatcher", localStringBuilder.toString());
      int i2 = ((taiji.a)localObject).a;
      long l1 = 10L;
      int i1 = 1500;
      switch (i2)
      {
      default: 
        return;
      case 4: 
      case 3: 
      case 2: 
        for (;;)
        {
          boolean bool1;
          try
          {
            bool1 = c((taiji.a)localObject);
            localStringBuilder = new StringBuilder("globalAction result: ");
            localStringBuilder.append(bool1);
            Log.i("AccessibilityDispatcher", localStringBuilder.toString());
            if (bool1) {
              break label463;
            }
            if (((taiji.a)localObject).s != 0) {
              i1 = ((taiji.a)localObject).s;
            }
            if (System.currentTimeMillis() > l2 + i1) {
              break label547;
            }
            localObject = Message.obtain();
            ((Message)localObject).what = 1002;
            ((Message)localObject).obj = parama;
            sendMessageDelayed((Message)localObject, l1);
            return;
          }
          catch (Throwable parama)
          {
            a((taiji.a)localObject, parama);
            return;
          }
          try
          {
            i1 = this.h;
            boolean bool2 = false;
            bool1 = bool2;
            if (i1 < 0)
            {
              this.h = 4096;
              i1 = a((taiji.a)localObject, true);
              if (i1 == 1)
              {
                bool1 = true;
              }
              else
              {
                bool1 = bool2;
                if (i1 == 3)
                {
                  this.h = -1;
                  bool1 = bool2;
                }
              }
            }
            localStringBuilder = new StringBuilder("scrollList result: ");
            localStringBuilder.append(bool1);
            Log.i("AccessibilityDispatcher", localStringBuilder.toString());
            if (bool1)
            {
              this.h = -1;
              localObject = Message.obtain();
              ((Message)localObject).what = 1003;
              ((Message)localObject).arg1 = 1;
              ((Message)localObject).obj = parama;
              sendMessageDelayed((Message)localObject, 100L);
              return;
            }
            if (((taiji.a)localObject).s != 0) {
              i1 = ((taiji.a)localObject).s;
            } else {
              i1 = 3000;
            }
            if (System.currentTimeMillis() <= l2 + i1)
            {
              localObject = Message.obtain();
              ((Message)localObject).what = 1002;
            }
          }
          catch (Throwable parama)
          {
            a((taiji.a)localObject, parama);
            return;
          }
          try
          {
            bool1 = b((taiji.a)localObject);
            localStringBuilder = new StringBuilder("clickWidget result: ");
            localStringBuilder.append(bool1);
            Log.i("AccessibilityDispatcher", localStringBuilder.toString());
            if (bool1)
            {
              label463:
              c();
              return;
            }
            if (((taiji.a)localObject).s != 0) {
              i1 = ((taiji.a)localObject).s;
            }
            l1 = System.currentTimeMillis();
            if (l1 <= i1 + l2)
            {
              l1 -= l2;
              if (l1 >= 30000L) {
                l1 = 1000L;
              } else if (l1 >= 10000L) {
                l1 = 100L;
              } else {
                l1 = 10L;
              }
            }
            else
            {
              label547:
              a(((taiji.a)localObject).c);
              return;
            }
          }
          catch (Throwable parama)
          {
            a((taiji.a)localObject, parama);
            return;
          }
        }
      }
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
      }
    }
    
    private void a(AccessibilityDispatcher.a parama, int paramInt)
    {
      Object localObject = parama.a;
      long l1 = parama.b;
      StringBuilder localStringBuilder = new StringBuilder("checkAction=");
      localStringBuilder.append(((taiji.a)localObject).a);
      localStringBuilder.append(" mWaitEventType=");
      localStringBuilder.append(this.h);
      Log.i("AccessibilityDispatcher", localStringBuilder.toString());
      int i1 = ((taiji.a)localObject).a;
      if (i1 != 1)
      {
        if (i1 != 3) {
          return;
        }
        try
        {
          i1 = this.h;
          boolean bool2 = false;
          boolean bool1 = bool2;
          if (i1 < 0)
          {
            this.h = 4096;
            i1 = a((taiji.a)localObject, false);
            if (i1 == 1)
            {
              bool1 = true;
            }
            else
            {
              bool1 = bool2;
              if (i1 == 3)
              {
                this.h = -1;
                bool1 = bool2;
              }
            }
          }
          localStringBuilder = new StringBuilder("check scrollList result: ");
          localStringBuilder.append(bool1);
          Log.i("AccessibilityDispatcher", localStringBuilder.toString());
          if (bool1) {
            break label240;
          }
          if (paramInt > 2) {
            break label308;
          }
          localObject = Message.obtain();
          ((Message)localObject).what = 1003;
          ((Message)localObject).arg1 = (paramInt + 1);
          ((Message)localObject).obj = parama;
          sendMessageDelayed((Message)localObject, 100L);
          return;
        }
        catch (Throwable parama)
        {
          a((taiji.a)localObject, parama);
          return;
        }
      }
      else
      {
        if (this.h >= 0) {
          break label245;
        }
      }
      label240:
      c();
      return;
      label245:
      if (((taiji.a)localObject).s != 0) {
        paramInt = ((taiji.a)localObject).s;
      } else {
        paramInt = 6000;
      }
      if (System.currentTimeMillis() <= l1 + paramInt)
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 1003;
        ((Message)localObject).obj = parama;
        sendMessageDelayed((Message)localObject, 20L);
        return;
      }
      label308:
      a(((taiji.a)localObject).c);
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
      if (parama.w != null)
      {
        localObject1 = parama.w.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (d)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(((d)localObject2).g)) {
            AccessibilityDispatcher.c().add(((d)localObject2).g);
          }
        }
      }
      if ((parama.r != null) && (parama.r.size() > 0)) {
        AccessibilityDispatcher.c().addAll(parama.r);
      }
      d();
      Object localObject1 = new ArrayList();
      Object localObject2 = new d();
      ((d)localObject2).a = parama.b;
      ((d)localObject2).b = parama.j;
      if (parama.k != null)
      {
        ((d)localObject2).c = new ArrayList();
        ((d)localObject2).c.addAll(parama.k);
      }
      ((d)localObject2).e = parama.n;
      ((d)localObject2).f = parama.e;
      ((d)localObject2).g = parama.f;
      ((d)localObject2).h = parama.g;
      ((d)localObject2).i = parama.p;
      if (parama.h != null)
      {
        ((d)localObject2).j = new ArrayList();
        ((d)localObject2).j.addAll(parama.h);
      }
      ((d)localObject2).k = parama.i;
      ((ArrayList)localObject1).add(localObject2);
      if (parama.w != null) {
        ((ArrayList)localObject1).addAll(parama.w);
      }
      parama = null;
      localObject1 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext())
        {
          if (parama == null) {
            return;
          }
          throw parama;
        }
        parama = (d)((Iterator)localObject1).next();
        localObject2 = new Intent();
        if (!TextUtils.isEmpty(parama.f)) {
          ((Intent)localObject2).setAction(parama.f);
        }
        if (!TextUtils.isEmpty(parama.g)) {
          if (!TextUtils.isEmpty(parama.a)) {
            ((Intent)localObject2).setClassName(parama.g, parama.a);
          } else {
            ((Intent)localObject2).setPackage(parama.g);
          }
        }
        boolean bool1 = TextUtils.isEmpty(parama.h) ^ true;
        boolean bool2 = TextUtils.isEmpty(parama.i) ^ true;
        if ((bool1) && (bool2)) {
          ((Intent)localObject2).setDataAndType(Uri.parse(parama.h), parama.i);
        } else if ((bool1) && (!bool2)) {
          ((Intent)localObject2).setData(Uri.parse(parama.h));
        } else if ((!bool1) && (bool2)) {
          ((Intent)localObject2).setType(parama.i);
        }
        if (parama.j != null)
        {
          Bundle localBundle = a(parama.j);
          if (localBundle != null) {
            ((Intent)localObject2).putExtras(localBundle);
          }
        }
        int i1;
        if (parama.k != 0) {
          i1 = parama.k;
        } else {
          i1 = 1350926336;
        }
        ((Intent)localObject2).setFlags(i1);
        try
        {
          AccessibilityDispatcher.this.startActivity((Intent)localObject2);
          localObject2 = new StringBuilder("open suc. pkg=");
          ((StringBuilder)localObject2).append(parama.g);
          ((StringBuilder)localObject2).append(" cls=");
          ((StringBuilder)localObject2).append(parama.a);
          Log.i("AccessibilityDispatcher", ((StringBuilder)localObject2).toString());
          return;
        }
        catch (Exception parama) {}
      }
    }
    
    private void a(taiji.a parama, Throwable paramThrowable)
    {
      Log.e("AccessibilityDispatcher", paramThrowable.getMessage(), paramThrowable);
      if (AccessibilityDispatcher.a != null) {
        AccessibilityDispatcher.a.onException(paramThrowable);
      }
      parama = this.e;
      if (parama != null) {
        parama.a(this.b, 2);
      }
      parama = this.f;
      if (parama != null)
      {
        parama.b = 3;
        parama.c = this.b;
      }
      b();
    }
    
    private void a(boolean paramBoolean)
    {
      if (!paramBoolean)
      {
        localObject = this.e;
        if (localObject != null) {
          ((bp.a)localObject).a(this.b, 2);
        }
        localObject = this.f;
        if (localObject != null)
        {
          ((bp.c)localObject).b = 2;
          ((bp.c)localObject).c = this.b;
          localObject = AccessibilityDispatcher.this.getRootInActiveWindow();
          if (localObject != null) {
            this.f.e = c((AccessibilityNodeInfo)localObject);
          }
        }
        b();
        return;
      }
      Object localObject = this.e;
      if (localObject != null) {
        ((bp.a)localObject).a(this.b, 1);
      }
      localObject = this.f;
      if (localObject != null)
      {
        ((bp.c)localObject).b = 1;
        bp.c localc;
        if (TextUtils.isEmpty(((bp.c)localObject).d))
        {
          localc = this.f;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.b);
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localc = this.f;
          localObject = new StringBuilder(String.valueOf(localc.d));
          ((StringBuilder)localObject).append("|");
          ((StringBuilder)localObject).append(this.b);
          localObject = ((StringBuilder)localObject).toString();
        }
        localc.d = ((String)localObject);
      }
      sendEmptyMessageDelayed(1001, 100L);
    }
    
    private boolean a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      boolean bool2 = paramAccessibilityNodeInfo.isVisibleToUser();
      boolean bool3 = true;
      if (!bool2)
      {
        Rect localRect = new Rect();
        paramAccessibilityNodeInfo.getBoundsInScreen(localRect);
        int i1 = this.k;
        int i2 = this.j;
        paramAccessibilityNodeInfo = new StringBuilder("l=");
        paramAccessibilityNodeInfo.append(localRect.left);
        paramAccessibilityNodeInfo.append(" r=");
        paramAccessibilityNodeInfo.append(localRect.right);
        paramAccessibilityNodeInfo.append(" t=");
        paramAccessibilityNodeInfo.append(localRect.top);
        paramAccessibilityNodeInfo.append(" b=");
        paramAccessibilityNodeInfo.append(localRect.bottom);
        paramAccessibilityNodeInfo.append("\nw=");
        paramAccessibilityNodeInfo.append(i2);
        paramAccessibilityNodeInfo.append(" h=");
        paramAccessibilityNodeInfo.append(i1);
        Log.i("AccessibilityDispatcher", paramAccessibilityNodeInfo.toString());
        bool1 = bool3;
        if (i2 <= 0) {
          break label242;
        }
        bool1 = bool3;
        if (i1 <= 0) {
          break label242;
        }
        if ((localRect.top >= 0) && (localRect.top <= i1) && (localRect.bottom >= 0) && (localRect.bottom <= i1) && (localRect.left >= 0) && (localRect.left <= i2) && (localRect.right >= 0) && (localRect.right <= i2)) {
          return true;
        }
      }
      boolean bool1 = bool2;
      label242:
      return bool1;
    }
    
    private boolean a(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt, d paramd)
    {
      Object localObject1 = new StringBuilder("needIgnoreClick ignoreState=");
      ((StringBuilder)localObject1).append(paramInt);
      Log.i("AccessibilityDispatcher", ((StringBuilder)localObject1).toString());
      boolean bool2 = false;
      int i1;
      if ((paramd != null) && (((paramd.c != null) && (paramd.c.size() > 0)) || (!TextUtils.isEmpty(paramd.a)))) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      Object localObject2 = null;
      localObject1 = null;
      if (i1 != 0)
      {
        if ((paramd.c == null) && (TextUtils.isEmpty(paramd.a))) {
          return false;
        }
        i1 = paramd.d;
        Object localObject4;
        for (Object localObject3 = paramAccessibilityNodeInfo; (i1 > 0) && (localObject3 != null); localObject3 = localObject4)
        {
          localObject4 = ((AccessibilityNodeInfo)localObject3).getParent();
          if (localObject3 != paramAccessibilityNodeInfo) {
            ((AccessibilityNodeInfo)localObject3).recycle();
          }
          i1 -= 1;
        }
        if (localObject3 != null)
        {
          if (paramd.c == null)
          {
            localObject1 = a((AccessibilityNodeInfo)localObject3, paramd.a, null);
          }
          else
          {
            localObject4 = paramd.c.iterator();
            localObject2 = localObject1;
            do
            {
              if (!((Iterator)localObject4).hasNext())
              {
                localObject1 = localObject2;
                break;
              }
              localObject1 = (String)((Iterator)localObject4).next();
              switch (paramd.b)
              {
              default: 
                localObject1 = localObject2;
                break;
              case 2: 
                localObject1 = b((AccessibilityNodeInfo)localObject3, paramd.a, (String)localObject1);
                break;
              case 1: 
              case 3: 
              case 4: 
              case 5: 
                localObject1 = a((AccessibilityNodeInfo)localObject3, paramd.a, null, (String)localObject1, paramd.b);
              }
              localObject2 = localObject1;
            } while (localObject1 == null);
          }
          localObject2 = localObject1;
          if (localObject3 != paramAccessibilityNodeInfo)
          {
            ((AccessibilityNodeInfo)localObject3).recycle();
            localObject2 = localObject1;
          }
        }
      }
      else
      {
        localObject2 = paramAccessibilityNodeInfo;
      }
      if (localObject2 == null) {
        return false;
      }
      switch (paramInt)
      {
      default: 
        bool1 = bool2;
        if (paramd == null) {
          break label448;
        }
        if (paramd.c != null) {
          if (paramd.c.size() > 0) {
            break label436;
          }
        }
        break;
      case 2: 
        bool1 = ((AccessibilityNodeInfo)localObject2).isChecked() ^ true;
        break;
      case 1: 
        bool1 = ((AccessibilityNodeInfo)localObject2).isChecked();
        break;
      }
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty(paramd.a))
      {
        label436:
        bool1 = bool2;
        if (localObject2 != null) {
          bool1 = true;
        }
      }
      label448:
      if (localObject2 != paramAccessibilityNodeInfo) {
        ((AccessibilityNodeInfo)localObject2).recycle();
      }
      return bool1;
    }
    
    private boolean a(AccessibilityNodeInfo paramAccessibilityNodeInfo, boolean paramBoolean)
    {
      Log.i("AccessibilityDispatcher", "doScroll");
      if (paramAccessibilityNodeInfo == null) {
        return false;
      }
      int i1 = 4096;
      if (!paramBoolean) {
        i1 = 8192;
      }
      return paramAccessibilityNodeInfo.performAction(i1);
    }
    
    private AccessibilityNodeInfo b(AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString1, String paramString2)
    {
      Object localObject = new StringBuilder("findNodeByDescription clsName=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" text=");
      ((StringBuilder)localObject).append(paramString2);
      Log.i("AccessibilityDispatcher", ((StringBuilder)localObject).toString());
      if (paramAccessibilityNodeInfo == null) {
        return null;
      }
      localObject = paramAccessibilityNodeInfo.getContentDescription();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((CharSequence)localObject).toString().equals(paramString2)))
      {
        if (TextUtils.isEmpty(paramString1)) {
          return paramAccessibilityNodeInfo;
        }
        if (paramString1.equals(paramAccessibilityNodeInfo.getClassName())) {
          return paramAccessibilityNodeInfo;
        }
      }
      int i2 = paramAccessibilityNodeInfo.getChildCount();
      int i1 = 0;
      for (;;)
      {
        if (i1 >= i2) {
          return null;
        }
        localObject = paramAccessibilityNodeInfo.getChild(i1);
        if (localObject != null)
        {
          AccessibilityNodeInfo localAccessibilityNodeInfo = b((AccessibilityNodeInfo)localObject, paramString1, paramString2);
          if (localAccessibilityNodeInfo != localObject) {
            ((AccessibilityNodeInfo)localObject).recycle();
          }
          if (localAccessibilityNodeInfo != null) {
            return localAccessibilityNodeInfo;
          }
        }
        i1 += 1;
      }
    }
    
    private void b()
    {
      AccessibilityDispatcher.c().clear();
      this.d = null;
      d();
      this.b = -1;
      this.c = 0L;
      this.g = false;
      bp.a locala = this.e;
      if (locala != null)
      {
        this.e = null;
        locala.b();
      }
    }
    
    private boolean b(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      Log.i("AccessibilityDispatcher", "doClick");
      boolean bool1 = false;
      if (paramAccessibilityNodeInfo == null) {
        return false;
      }
      if (paramAccessibilityNodeInfo.isEnabled())
      {
        Log.i("AccessibilityDispatcher", "perform click");
        bool1 = paramAccessibilityNodeInfo.performAction(16);
      }
      boolean bool2 = bool1;
      if (!bool1)
      {
        paramAccessibilityNodeInfo = paramAccessibilityNodeInfo.getParent();
        bool2 = bool1;
        if (paramAccessibilityNodeInfo != null)
        {
          bool2 = b(paramAccessibilityNodeInfo);
          paramAccessibilityNodeInfo.recycle();
        }
      }
      return bool2;
    }
    
    private boolean b(taiji.a parama)
    {
      Log.i("AccessibilityDispatcher", "clickWidget");
      if (parama != null)
      {
        if (parama.k == null) {
          return false;
        }
        AccessibilityNodeInfo localAccessibilityNodeInfo = AccessibilityDispatcher.this.getRootInActiveWindow();
        if (localAccessibilityNodeInfo == null) {
          return false;
        }
        Object localObject1 = parama.t;
        boolean bool = true;
        if ((localObject1 != null) && (parama.t.size() > 0))
        {
          localObject1 = parama.t.iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext())
            {
              i1 = 1;
              break;
            }
            localObject2 = a(localAccessibilityNodeInfo, null, null, (String)((Iterator)localObject1).next(), 1);
          } while (localObject2 == null);
          ((AccessibilityNodeInfo)localObject2).recycle();
          return true;
        }
        int i1 = 0;
        localObject1 = new ArrayList();
        if ((parama.k != null) && (parama.k.size() > 0))
        {
          localObject2 = new d();
          ((d)localObject2).b = parama.j;
          ((d)localObject2).c = new ArrayList();
          ((d)localObject2).c.addAll(parama.k);
          ((d)localObject2).a = parama.b;
          ((d)localObject2).e = parama.n;
          ((ArrayList)localObject1).add(localObject2);
        }
        if (parama.w != null) {
          ((ArrayList)localObject1).addAll(parama.w);
        }
        Object localObject2 = null;
        Iterator localIterator1 = ((ArrayList)localObject1).iterator();
        do
        {
          d locald;
          Iterator localIterator2;
          while (!localIterator2.hasNext())
          {
            if (!localIterator1.hasNext())
            {
              localAccessibilityNodeInfo.recycle();
              return false;
            }
            locald = (d)localIterator1.next();
            localIterator2 = locald.c.iterator();
          }
          localObject1 = (String)localIterator2.next();
          switch (locald.b)
          {
          default: 
            localObject1 = localObject2;
            break;
          case 2: 
            localObject1 = b(localAccessibilityNodeInfo, locald.a, (String)localObject1);
            break;
          case 1: 
          case 3: 
          case 4: 
          case 5: 
            localObject1 = a(localAccessibilityNodeInfo, locald.a, locald.e, (String)localObject1, locald.b);
          }
          localObject2 = localObject1;
        } while (localObject1 == null);
        if (!a((AccessibilityNodeInfo)localObject1, parama.l, parama.v)) {
          bool = b((AccessibilityNodeInfo)localObject1);
        } else {
          Log.d("AccessibilityDispatcher", "ignore to click");
        }
        ((AccessibilityNodeInfo)localObject1).recycle();
        localAccessibilityNodeInfo.recycle();
        if (i1 == 0) {
          return bool;
        }
      }
      return false;
    }
    
    private String c(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      if ((paramAccessibilityNodeInfo != null) && (paramAccessibilityNodeInfo.isVisibleToUser()))
      {
        Object localObject3 = paramAccessibilityNodeInfo.getText();
        Object localObject2 = paramAccessibilityNodeInfo.getClassName().toString();
        Object localObject1 = localObject2;
        if (((String)localObject2).toString().startsWith("android.widget.")) {
          localObject1 = ((String)localObject2).substring(15);
        }
        localObject2 = localObject1;
        if (((String)localObject1).toString().startsWith("android.view.")) {
          localObject2 = ((String)localObject1).substring(13);
        }
        localObject2 = new StringBuilder(String.valueOf(localObject2));
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject1 = "";
        }
        else
        {
          localObject1 = new StringBuilder("@");
          ((StringBuilder)localObject1).append(localObject3);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject3 = ((StringBuilder)localObject2).toString();
        int i3 = paramAccessibilityNodeInfo.getChildCount();
        int i1 = 0;
        localObject1 = "";
        int i2 = 0;
        for (;;)
        {
          if (i1 >= i3)
          {
            localObject2 = localObject1;
            if (i2 > 1)
            {
              localObject2 = new StringBuilder("{");
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append("}");
              localObject2 = ((StringBuilder)localObject2).toString();
            }
            paramAccessibilityNodeInfo.recycle();
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              return localObject2;
            }
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              return ((String)localObject3).toString();
            }
            if (((String)localObject2).startsWith("{"))
            {
              paramAccessibilityNodeInfo = new StringBuilder(String.valueOf(localObject3));
              paramAccessibilityNodeInfo.append(",");
              paramAccessibilityNodeInfo.append((String)localObject2);
            }
            for (;;)
            {
              return paramAccessibilityNodeInfo.toString();
              paramAccessibilityNodeInfo = new StringBuilder(String.valueOf(localObject3));
              paramAccessibilityNodeInfo.append(",{");
              paramAccessibilityNodeInfo.append((String)localObject2);
              paramAccessibilityNodeInfo.append("}");
            }
          }
          localObject2 = c(paramAccessibilityNodeInfo.getChild(i1));
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            i2 += 1;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject1 = localObject2;
            }
            else
            {
              localObject1 = new StringBuilder(String.valueOf(localObject1));
              ((StringBuilder)localObject1).append(",");
              ((StringBuilder)localObject1).append((String)localObject2);
              localObject1 = ((StringBuilder)localObject1).toString();
            }
          }
          i1 += 1;
        }
      }
      return "";
    }
    
    private void c()
    {
      bp.a locala = this.e;
      if (locala != null) {
        locala.a(this.b, 0);
      }
      sendEmptyMessageDelayed(1001, 100L);
    }
    
    private boolean c(taiji.a parama)
    {
      Log.i("AccessibilityDispatcher", "globalAction");
      if (parama == null) {
        return false;
      }
      Object localObject1 = null;
      Object localObject2 = null;
      int i1;
      if ((parama.k != null) && (parama.k.size() > 0))
      {
        i1 = 1;
        AccessibilityNodeInfo localAccessibilityNodeInfo = AccessibilityDispatcher.this.getRootInActiveWindow();
        if (localAccessibilityNodeInfo != null)
        {
          Iterator localIterator = parama.k.iterator();
          do
          {
            if (!localIterator.hasNext())
            {
              localObject1 = localObject2;
              break;
            }
            localObject1 = (String)localIterator.next();
            switch (parama.j)
            {
            default: 
              localObject1 = localObject2;
              break;
            case 2: 
              localObject1 = b(localAccessibilityNodeInfo, parama.b, (String)localObject1);
              break;
            case 1: 
            case 3: 
            case 4: 
            case 5: 
              localObject1 = a(localAccessibilityNodeInfo, parama.b, parama.n, (String)localObject1, parama.j);
            }
            localObject2 = localObject1;
          } while (localObject1 == null);
          localAccessibilityNodeInfo.recycle();
        }
      }
      else
      {
        i1 = 0;
      }
      if ((i1 != 0) && (localObject1 != null)) {
        ((AccessibilityNodeInfo)localObject1).recycle();
      }
      while (i1 == 0) {
        return AccessibilityDispatcher.this.performGlobalAction(parama.o);
      }
      return false;
    }
    
    private void d()
    {
      AccessibilityServiceInfo localAccessibilityServiceInfo = AccessibilityDispatcher.this.getServiceInfo();
      if (localAccessibilityServiceInfo == null)
      {
        Log.e("AccessibilityDispatcher", "service is not start, can't setServiceInfo");
        return;
      }
      Object localObject3 = new HashSet();
      int i1 = AccessibilityDispatcher.c().size();
      int i3 = 0;
      if (i1 > 0)
      {
        ((Set)localObject3).addAll(AccessibilityDispatcher.c());
        i1 = -1;
      }
      else
      {
        i1 = 0;
      }
      Object localObject1 = AccessibilityDispatcher.d().values().iterator();
      for (;;)
      {
        int i4;
        if (!((Iterator)localObject1).hasNext())
        {
          i2 = ((Set)localObject3).size();
          localObject1 = null;
          if (!AccessibilityDispatcher.a.forceMonitorAllPkg()) {
            if (i2 <= 0)
            {
              localObject1 = this.n;
            }
            else
            {
              localObject1 = new String[i2];
              localObject3 = ((Set)localObject3).iterator();
              i2 = 0;
              while (((Iterator)localObject3).hasNext())
              {
                localObject1[i2] = ((String)((Iterator)localObject3).next());
                i2 += 1;
              }
            }
          }
          i4 = this.l;
        }
        try
        {
          localObject3 = localAccessibilityServiceInfo.getClass();
          i2 = ((Integer)((Class)localObject3).getField("teacher").get(localObject3)).intValue();
        }
        catch (Exception localException2)
        {
          label213:
          Object localObject2;
          Object localObject4;
          break label213;
        }
        int i2 = 16;
        i4 |= i2;
        localObject3 = this.d;
        i2 = i4;
        if (localObject3 != null) {
          i2 = i4 | ((b)localObject3).e;
        }
        localAccessibilityServiceInfo.packageNames = ((String[])localObject1);
        localAccessibilityServiceInfo.eventTypes = i1;
        localAccessibilityServiceInfo.notificationTimeout = 80L;
        localAccessibilityServiceInfo.feedbackType = 16;
        localAccessibilityServiceInfo.flags = i2;
        try
        {
          localObject1 = localAccessibilityServiceInfo.getClass().getDeclaredField("mCanRetrieveWindowContent");
          ((Field)localObject1).setAccessible(true);
          ((Field)localObject1).set(localAccessibilityServiceInfo, Boolean.valueOf(true));
        }
        catch (Exception localException1)
        {
          Log.w("AccessibilityDispatcher", localException1.getMessage());
        }
        if (localAccessibilityServiceInfo.packageNames != null)
        {
          localObject2 = localAccessibilityServiceInfo.packageNames;
          i2 = localObject2.length;
          i1 = i3;
          while (i1 < i2)
          {
            localObject3 = localObject2[i1];
            localObject4 = new StringBuilder("[setServiceInfo]");
            ((StringBuilder)localObject4).append((String)localObject3);
            Log.i("AccessibilityDispatcher", ((StringBuilder)localObject4).toString());
            i1 += 1;
          }
        }
        localObject2 = new StringBuilder("[setServiceInfo]event types: ");
        ((StringBuilder)localObject2).append(localAccessibilityServiceInfo.eventTypes);
        Log.i("AccessibilityDispatcher", ((StringBuilder)localObject2).toString());
        AccessibilityDispatcher.this.setServiceInfo(localAccessibilityServiceInfo);
        return;
        localObject4 = ((List)((Iterator)localObject2).next()).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          taiji.a locala = (taiji.a)((Iterator)localObject4).next();
          if (locala.r != null) {
            ((Set)localObject3).addAll(locala.r);
          }
          i1 |= locala.q;
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
      int i1 = this.h;
      if ((i1 > 0) && (i1 == paramInt)) {
        this.h = -1;
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i2 = paramMessage.what;
      int i1 = 0;
      switch (i2)
      {
      default: 
        switch (i2)
        {
        default: 
          return;
        case 1104: 
          a((AccessibilityEvent)paramMessage.obj);
          return;
        case 1102: 
          paramMessage = (AccessibilityDispatcher.a)paramMessage.obj;
          AccessibilityDispatcher.d().remove(paramMessage.c);
          break;
        case 1101: 
          paramMessage = (AccessibilityDispatcher.a)paramMessage.obj;
          AccessibilityDispatcher.d().put(paramMessage.c, paramMessage.d);
        case 1103: 
          d();
          return;
        }
        taiji.a locala1 = new taiji.a();
        locala1.a = 2;
        locala1.j = 2;
        locala1.k = new ArrayList();
        paramMessage = this.o;
        i2 = paramMessage.length;
        for (;;)
        {
          if (i1 >= i2)
          {
            boolean bool;
            if (!b(locala1))
            {
              try
              {
                String str1 = AccessibilityDispatcher.this.getPackageName();
                Iterator localIterator = ((AccessibilityManager)AccessibilityDispatcher.this.getSystemService("accessibility")).getInstalledAccessibilityServiceList().iterator();
                Object localObject1 = null;
                for (;;)
                {
                  paramMessage = (Message)localObject1;
                  try
                  {
                    if (!localIterator.hasNext()) {
                      break label364;
                    }
                    AccessibilityServiceInfo localAccessibilityServiceInfo = (AccessibilityServiceInfo)localIterator.next();
                    if (localAccessibilityServiceInfo == null)
                    {
                      localObject1 = paramMessage;
                    }
                    else
                    {
                      String str2 = localAccessibilityServiceInfo.getId();
                      if (str2 == null)
                      {
                        localObject1 = paramMessage;
                      }
                      else
                      {
                        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1));
                        localStringBuilder.append("/");
                        localObject1 = paramMessage;
                        if (str2.startsWith(localStringBuilder.toString())) {
                          localObject1 = localAccessibilityServiceInfo.loadDescription(AccessibilityDispatcher.this.getPackageManager());
                        }
                      }
                    }
                  }
                  catch (Throwable localThrowable1) {}
                }
                Log.e("AccessibilityDispatcher", localThrowable2.getMessage(), localThrowable2);
              }
              catch (Throwable localThrowable2)
              {
                paramMessage = null;
              }
              ??? = new taiji.a();
              ((taiji.a)???).a = 4;
              ((taiji.a)???).o = 1;
              if (!TextUtils.isEmpty(paramMessage))
              {
                ((taiji.a)???).j = 1;
                ((taiji.a)???).k = new ArrayList();
                ((taiji.a)???).k.add(paramMessage);
              }
              bool = c((taiji.a)???);
              paramMessage = new StringBuilder("globalRes1=");
              paramMessage.append(bool);
              Log.i("AccessibilityDispatcher", paramMessage.toString());
            }
            else
            {
              Log.i("AccessibilityDispatcher", "closeRes1 success");
            }
            try
            {
              Thread.sleep(100L);
            }
            catch (InterruptedException paramMessage)
            {
              Log.i("AccessibilityDispatcher", paramMessage.getMessage());
            }
            if (!b(locala1))
            {
              if ("com.android.settings".equals(this.i))
              {
                paramMessage = new taiji.a();
                paramMessage.a = 4;
                paramMessage.o = 1;
                bool = c(paramMessage);
                paramMessage = new StringBuilder("globalRes2=");
                paramMessage.append(bool);
                Log.i("AccessibilityDispatcher", paramMessage.toString());
              }
            }
            else {
              Log.i("AccessibilityDispatcher", "closeRes2 success");
            }
            this.i = null;
            AccessibilityDispatcher.c().clear();
            d();
            if (AccessibilityDispatcher.a == null) {
              break;
            }
            AccessibilityDispatcher.a.onAutoReturn();
            return;
          }
          ??? = paramMessage[i1];
          locala1.k.add(???);
          i1 += 1;
        }
      case 1003: 
        if (!this.g)
        {
          a((AccessibilityDispatcher.a)paramMessage.obj, paramMessage.arg1);
          return;
        }
        paramMessage = this.f;
        if (paramMessage == null) {}
        break;
      case 1002: 
        label364:
        if (!this.g)
        {
          a((AccessibilityDispatcher.a)paramMessage.obj);
          return;
        }
        paramMessage = this.f;
        if (paramMessage != null)
        {
          paramMessage.b = 4;
          paramMessage.c = (System.currentTimeMillis() - this.c);
        }
        label709:
        b();
        return;
      }
      this.b += 1;
      i1 = this.b;
      for (;;)
      {
        AccessibilityDispatcher.a locala;
        synchronized (this.m)
        {
          if (i1 < this.d.c.size())
          {
            paramMessage = new StringBuilder("get action, index ");
            paramMessage.append(i1);
            Log.i("AccessibilityDispatcher", paramMessage.toString());
            paramMessage = (taiji.a)this.d.c.get(i1);
            if ((paramMessage != null) && (!this.g))
            {
              if (paramMessage.u != 0)
              {
                try
                {
                  Thread.sleep(paramMessage.u);
                }
                catch (InterruptedException localInterruptedException)
                {
                  Log.e("AccessibilityDispatcher", localInterruptedException.getMessage(), localInterruptedException);
                }
                paramMessage.u = 0;
              }
              locala = new AccessibilityDispatcher.a(null);
              locala.a = paramMessage;
              locala.b = System.currentTimeMillis();
              a(locala);
              return;
            }
            paramMessage = this.f;
            if (paramMessage == null) {
              break label709;
            }
            break;
            return;
          }
        }
        paramMessage = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.meri.service.monitor.AccessibilityDispatcher
 * JD-Core Version:    0.7.0.1
 */