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
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.token.alr;
import com.tencent.token.amf;
import com.tencent.token.amz;
import com.tencent.token.ano;
import com.tencent.token.aoe.a;
import com.tencent.token.aoe.b;
import com.tencent.token.aoe.c;
import com.tencent.token.kf;
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

@SuppressLint({"NewApi"})
public class AccessibilityDispatcher
  extends AccessibilityService
{
  public static kf a;
  private static AccessibilityDispatcher b;
  private static boolean d = false;
  private static boolean e = false;
  private static Set<String> f = new HashSet();
  private static Map<aoe.b, List<alr>> g = new HashMap();
  private b c;
  
  public static int a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return 1;
    }
    if (e)
    {
      AccessibilityDispatcher localAccessibilityDispatcher = b;
      if ((localAccessibilityDispatcher == null) || (localAccessibilityDispatcher.getServiceInfo() == null)) {
        e = false;
      }
    }
    new StringBuilder("isServerStart: ").append(e);
    if (!e)
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
    ??? = b;
    if (??? == null) {
      return;
    }
    b localb = ((AccessibilityDispatcher)???).c;
    if (localb == null) {
      return;
    }
    if (localb.a != null)
    {
      localb.b = true;
      synchronized (localb.d)
      {
        if (localb.a.c != null) {
          localb.a.c.clear();
        }
        return;
      }
    }
  }
  
  public static void a(Context paramContext, amf paramamf, aoe.a parama)
  {
    if (paramamf != null)
    {
      if (paramamf.c == null) {
        return;
      }
      int i = a(paramContext);
      if (i != 0)
      {
        "canPlay error is ".concat(String.valueOf(i));
        return;
      }
      paramContext = b.d();
      if (paramContext != null)
      {
        b.c(paramContext);
        b.a(paramContext, System.currentTimeMillis());
        b.a(paramContext, paramamf);
        b.a(paramContext, parama);
        b.a(paramContext, new aoe.c());
        b.d(paramContext).a = paramamf.b;
        paramContext.sendEmptyMessage(1001);
      }
    }
  }
  
  private static boolean b(Context paramContext)
  {
    int j;
    int i;
    do
    {
      try
      {
        Object localObject = paramContext.getPackageName();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_accessibility_services");
          if (!TextUtils.isEmpty(paramContext))
          {
            paramContext = paramContext.split(":");
            if ((paramContext != null) && (paramContext.length > 0))
            {
              localObject = new StringBuilder(String.valueOf(localObject));
              ((StringBuilder)localObject).append("/");
              ((StringBuilder)localObject).append(AccessibilityDispatcher.class.getName());
              localObject = ((StringBuilder)localObject).toString();
              j = paramContext.length;
              i = 0;
              continue;
              CharSequence localCharSequence = paramContext[i];
              if (!TextUtils.isEmpty(localCharSequence))
              {
                boolean bool = localCharSequence.equals(localObject);
                if (bool) {
                  return true;
                }
              }
              i += 1;
              continue;
            }
          }
        }
        return false;
      }
      catch (Throwable paramContext)
      {
        return false;
      }
    } while (i < j);
    return false;
  }
  
  private b d()
  {
    Object localObject = this.c;
    if (localObject != null) {
      return localObject;
    }
    localObject = getResources().getDisplayMetrics();
    HandlerThread localHandlerThread = a.a();
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
    "eventType=".concat(String.valueOf(i));
    if (this.c == null) {
      return;
    }
    Object localObject;
    if ((32 == i) || (4096 == i))
    {
      localObject = this.c;
      if ((((b)localObject).c > 0) && (((b)localObject).c == i)) {
        ((b)localObject).c = -1;
      }
    }
    if ((32 == i) && (b.e(this.c) != null))
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
  }
  
  public void onDestroy()
  {
    e = false;
    b = null;
    super.onDestroy();
  }
  
  public void onInterrupt() {}
  
  protected void onServiceConnected()
  {
    if (a == null)
    {
      stopSelf();
      return;
    }
    b = this;
    e = true;
    b localb = b.d();
    if (d)
    {
      d = false;
      if (localb != null)
      {
        b.a(localb, "");
        localb.sendEmptyMessageDelayed(1100, 200L);
      }
    }
    else if (localb != null)
    {
      localb.sendEmptyMessage(1103);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    e = false;
    b = null;
    return super.onUnbind(paramIntent);
  }
  
  static final class a
  {
    public alr a;
    public long b;
    public aoe.b c;
    public List<alr> d;
  }
  
  final class b
    extends Handler
  {
    amf a = null;
    boolean b = false;
    int c = -1;
    final Object d = new Object();
    private int f = -1;
    private long g = 0L;
    private aoe.a h = null;
    private aoe.c i = null;
    private String j = "";
    private final int k;
    private final int l;
    private final int m;
    private final String[] n = { "" };
    private final String[] o = { "返回", "向上导航" };
    private final String p = "com.android.settings";
    
    public b(Looper paramLooper, Context paramContext, int paramInt1, int paramInt2)
    {
      super();
      this.k = paramInt1;
      this.l = paramInt2;
      paramLooper = AccessibilityDispatcher.this.getServiceInfo();
      if (paramLooper != null)
      {
        this.m = paramLooper.flags;
        if (AccessibilityDispatcher.a != null)
        {
          kf localkf = AccessibilityDispatcher.a;
          paramLooper.packageNames = new String[] { paramContext.getPackageName(), "com.android.settings" };
          AccessibilityDispatcher.this.setServiceInfo(paramLooper);
        }
      }
      else
      {
        this.m = 0;
      }
    }
    
    private int a(alr paramalr, boolean paramBoolean)
    {
      "scrollList, isForward=".concat(String.valueOf(paramBoolean));
      if (paramalr != null)
      {
        if (paramalr.k == null) {
          return 3;
        }
        AccessibilityNodeInfo localAccessibilityNodeInfo = AccessibilityDispatcher.this.getRootInActiveWindow();
        if (localAccessibilityNodeInfo == null) {
          return 3;
        }
        Object localObject3 = paramalr.k.iterator();
        Object localObject1;
        do
        {
          boolean bool = ((Iterator)localObject3).hasNext();
          Object localObject2 = null;
          localObject1 = null;
          if (!bool)
          {
            localObject2 = new ArrayList();
            if (!TextUtils.isEmpty(paramalr.m))
            {
              localObject3 = new ano();
              ((ano)localObject3).a = paramalr.m;
              ((ano)localObject3).e = paramalr.n;
              ((ArrayList)localObject2).add(localObject3);
            }
            if (paramalr.w != null) {
              ((ArrayList)localObject2).addAll(paramalr.w);
            }
            localObject2 = ((ArrayList)localObject2).iterator();
            paramalr = (alr)localObject1;
            do
            {
              if (!((Iterator)localObject2).hasNext())
              {
                localObject1 = paramalr;
                break;
              }
              paramalr = (ano)((Iterator)localObject2).next();
              paramalr = a(localAccessibilityNodeInfo, paramalr.a, paramalr.e);
              localObject1 = paramalr;
            } while (paramalr == null);
            if (localObject1 == null)
            {
              localAccessibilityNodeInfo.recycle();
              return 3;
            }
            if (localObject1 != null)
            {
              int i1;
              if (paramBoolean) {
                i1 = 4096;
              } else {
                i1 = 8192;
              }
              ((AccessibilityNodeInfo)localObject1).performAction(i1);
            }
            ((AccessibilityNodeInfo)localObject1).recycle();
            localAccessibilityNodeInfo.recycle();
            return 2;
          }
          localObject1 = (String)((Iterator)localObject3).next();
          switch (paramalr.j)
          {
          default: 
            localObject1 = localObject2;
            break;
          case 2: 
            localObject1 = b(localAccessibilityNodeInfo, paramalr.b, (String)localObject1);
            break;
          case 1: 
          case 3: 
          case 4: 
          case 5: 
            localObject1 = a(localAccessibilityNodeInfo, paramalr.b, null, (String)localObject1, paramalr.j);
          }
        } while (localObject1 == null);
        ((AccessibilityNodeInfo)localObject1).recycle();
        localAccessibilityNodeInfo.recycle();
        return 1;
      }
      return 3;
    }
    
    private static Bundle a(ArrayList<amz> paramArrayList)
    {
      Bundle localBundle = new Bundle();
      paramArrayList = paramArrayList.iterator();
      for (;;)
      {
        if (!paramArrayList.hasNext()) {
          return localBundle;
        }
        amz localamz = (amz)paramArrayList.next();
        try
        {
          switch (localamz.b)
          {
          case 6: 
            short s = Short.parseShort(localamz.c);
            localBundle.putShort(localamz.a, s);
          }
        }
        catch (Throwable paramArrayList)
        {
          boolean bool;
          long l1;
          int i1;
          paramArrayList.getMessage();
          return null;
        }
        bool = Boolean.parseBoolean(localamz.c);
        localBundle.putBoolean(localamz.a, bool);
        continue;
        localBundle.putString(localamz.a, localamz.c);
        continue;
        l1 = Long.parseLong(localamz.c);
        localBundle.putLong(localamz.a, l1);
        continue;
        i1 = Integer.parseInt(localamz.c);
        localBundle.putInt(localamz.a, i1);
      }
    }
    
    private AccessibilityNodeInfo a(AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString1, String paramString2)
    {
      Object localObject = new StringBuilder("findNodeByClassName nodeClass=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" parentClass=");
      ((StringBuilder)localObject).append(paramString2);
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
      if (paramAccessibilityNodeInfo == null) {
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
          if ((localObject1 != null) && (localObject1.length == 2) && (!TextUtils.isEmpty(localObject1[0])) && (!TextUtils.isEmpty(localObject1[1])))
          {
            if (!localObject1[1].startsWith("string/")) {
              return null;
            }
            paramString3 = localObject1[0];
            localObject1 = localObject1[1].substring(7);
            localObject2 = AccessibilityDispatcher.this.getPackageManager().getResourcesForApplication(paramString3);
            i1 = ((Resources)localObject2).getIdentifier((String)localObject1, "string", paramString3);
            if (i1 > 0)
            {
              localObject3 = ((Resources)localObject2).getString(i1);
              "result|".concat(String.valueOf(localObject3));
            }
            else
            {
              "can't find res|".concat(String.valueOf(localObject1));
            }
          }
          else
          {
            return null;
          }
        }
        catch (Throwable paramAccessibilityNodeInfo)
        {
          paramAccessibilityNodeInfo.getMessage();
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
      if ((paramString3 != null) && (paramString3.size() > 0))
      {
        int i4 = paramString3.size();
        paramAccessibilityNodeInfo = null;
        i1 = 0;
        for (;;)
        {
          AccessibilityNodeInfo localAccessibilityNodeInfo2;
          if (i1 < i4)
          {
            localAccessibilityNodeInfo2 = (AccessibilityNodeInfo)paramString3.get(i1);
            boolean bool4 = localAccessibilityNodeInfo2.isVisibleToUser();
            boolean bool2 = bool4;
            if (!bool4)
            {
              localObject1 = new Rect();
              localAccessibilityNodeInfo2.getBoundsInScreen((Rect)localObject1);
              paramInt = this.l;
              int i2 = this.k;
              localObject2 = new StringBuilder("l=");
              ((StringBuilder)localObject2).append(((Rect)localObject1).left);
              ((StringBuilder)localObject2).append(" r=");
              ((StringBuilder)localObject2).append(((Rect)localObject1).right);
              ((StringBuilder)localObject2).append(" t=");
              ((StringBuilder)localObject2).append(((Rect)localObject1).top);
              ((StringBuilder)localObject2).append(" b=");
              ((StringBuilder)localObject2).append(((Rect)localObject1).bottom);
              ((StringBuilder)localObject2).append("\nw=");
              ((StringBuilder)localObject2).append(i2);
              ((StringBuilder)localObject2).append(" h=");
              ((StringBuilder)localObject2).append(paramInt);
              if ((i2 > 0) && (paramInt > 0))
              {
                bool2 = bool4;
                if (((Rect)localObject1).top >= 0)
                {
                  bool2 = bool4;
                  if (((Rect)localObject1).top <= paramInt)
                  {
                    bool2 = bool4;
                    if (((Rect)localObject1).bottom >= 0)
                    {
                      bool2 = bool4;
                      if (((Rect)localObject1).bottom <= paramInt)
                      {
                        bool2 = bool4;
                        if (((Rect)localObject1).left >= 0)
                        {
                          bool2 = bool4;
                          if (((Rect)localObject1).left <= i2)
                          {
                            bool2 = bool4;
                            if (((Rect)localObject1).right >= 0)
                            {
                              bool2 = bool4;
                              if (((Rect)localObject1).right > i2) {}
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
              else
              {
                bool2 = true;
              }
            }
            if (!bool2) {
              break label1028;
            }
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
            if (!bool2) {
              break label1028;
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
              int i3;
              if (bool1)
              {
                localObject2 = localAccessibilityNodeInfo2.getParent();
                localObject1 = localObject2;
                i3 = paramInt;
                if (localObject2 != null)
                {
                  localObject1 = localObject2;
                  i3 = paramInt;
                  if (paramString2.equals(((AccessibilityNodeInfo)localObject2).getClassName()))
                  {
                    i3 = 1;
                    localObject1 = localObject2;
                  }
                }
              }
              else
              {
                localObject1 = null;
                i3 = paramInt;
              }
              if ((!bool2) || (i3 == 0)) {
                break label942;
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
          label942:
          localObject2 = localObject1;
          AccessibilityNodeInfo localAccessibilityNodeInfo1 = paramAccessibilityNodeInfo;
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
              break;
            }
            localAccessibilityNodeInfo1 = a((AccessibilityNodeInfo)localObject2, paramString1, paramString2);
            if (localAccessibilityNodeInfo1 != null)
            {
              paramAccessibilityNodeInfo = localAccessibilityNodeInfo1;
              if (localAccessibilityNodeInfo1 == localObject2) {
                break;
              }
              ((AccessibilityNodeInfo)localObject2).recycle();
              paramAccessibilityNodeInfo = localAccessibilityNodeInfo1;
              break;
            }
            paramAccessibilityNodeInfo = ((AccessibilityNodeInfo)localObject2).getParent();
            ((AccessibilityNodeInfo)localObject2).recycle();
            localObject2 = paramAccessibilityNodeInfo;
          }
          label1028:
          i1 += 1;
        }
      }
      return null;
    }
    
    private void a()
    {
      AccessibilityDispatcher.b().clear();
      this.a = null;
      c();
      this.f = -1;
      this.g = 0L;
      this.b = false;
      aoe.a locala = this.h;
      if (locala != null)
      {
        this.h = null;
        locala.a();
      }
    }
    
    private void a(final AccessibilityEvent paramAccessibilityEvent)
    {
      if (paramAccessibilityEvent == null) {
        return;
      }
      CharSequence localCharSequence = paramAccessibilityEvent.getPackageName();
      if (TextUtils.isEmpty(localCharSequence)) {
        return;
      }
      Object localObject1 = null;
      Iterator localIterator1 = AccessibilityDispatcher.c().entrySet().iterator();
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
            Object localObject3 = (alr)localIterator2.next();
            if ((((alr)localObject3).q & paramAccessibilityEvent.getEventType()) != 0)
            {
              int i1;
              if ((((alr)localObject3).r != null) && (((alr)localObject3).r.size() > 0))
              {
                localObject2 = ((alr)localObject3).r.iterator();
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
                if ((((alr)localObject3).k != null) && (((alr)localObject3).k.size() > 0))
                {
                  localObject2 = localObject1;
                  if (localObject1 == null) {
                    localObject2 = AccessibilityDispatcher.this.getRootInActiveWindow();
                  }
                  localObject1 = ((alr)localObject3).k.iterator();
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
                localObject1 = localObject2;
                if (i1 != 0)
                {
                  localObject3 = (aoe.b)localEntry.getKey();
                  localObject1 = localObject2;
                  if (AccessibilityDispatcher.a != null)
                  {
                    AccessibilityDispatcher.a.b().post(new Runnable()
                    {
                      public final void run() {}
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
    
    private void a(AccessibilityDispatcher.a parama)
    {
      Object localObject = parama.a;
      long l1 = parama.b;
      StringBuilder localStringBuilder = new StringBuilder("performAction: ");
      localStringBuilder.append(((alr)localObject).a);
      localStringBuilder.append(" mWaitEventType=");
      localStringBuilder.append(this.c);
      int i2 = ((alr)localObject).a;
      int i1 = 1500;
      boolean bool1;
      switch (i2)
      {
      default: 
        return;
      case 4: 
        try
        {
          bool1 = c((alr)localObject);
          "globalAction result: ".concat(String.valueOf(bool1));
          if (bool1)
          {
            b();
            return;
          }
          if (((alr)localObject).s != 0) {
            i1 = ((alr)localObject).s;
          }
          if (System.currentTimeMillis() <= l1 + i1)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 1002;
            ((Message)localObject).obj = parama;
            sendMessageDelayed((Message)localObject, 10L);
            return;
          }
          a(((alr)localObject).c);
          return;
        }
        catch (Throwable parama)
        {
          a(parama);
          return;
        }
      case 3: 
        try
        {
          i1 = this.c;
          boolean bool2 = false;
          bool1 = bool2;
          if (i1 < 0)
          {
            this.c = 4096;
            i1 = a((alr)localObject, true);
            if (i1 == 1)
            {
              bool1 = true;
            }
            else
            {
              bool1 = bool2;
              if (i1 == 3)
              {
                this.c = -1;
                bool1 = bool2;
              }
            }
          }
          "scrollList result: ".concat(String.valueOf(bool1));
          if (bool1)
          {
            this.c = -1;
            localObject = Message.obtain();
            ((Message)localObject).what = 1003;
            ((Message)localObject).arg1 = 1;
            ((Message)localObject).obj = parama;
            sendMessageDelayed((Message)localObject, 100L);
            return;
          }
          if (((alr)localObject).s != 0) {
            i1 = ((alr)localObject).s;
          } else {
            i1 = 3000;
          }
          if (System.currentTimeMillis() <= l1 + i1)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 1002;
            ((Message)localObject).obj = parama;
            sendMessageDelayed((Message)localObject, 20L);
            return;
          }
          a(((alr)localObject).c);
          return;
        }
        catch (Throwable parama)
        {
          a(parama);
          return;
        }
      case 2: 
        try
        {
          bool1 = b((alr)localObject);
          "clickWidget result: ".concat(String.valueOf(bool1));
          if (bool1)
          {
            b();
            return;
          }
          if (((alr)localObject).s != 0) {
            i1 = ((alr)localObject).s;
          }
          long l2 = System.currentTimeMillis();
          if (l2 <= i1 + l1)
          {
            l1 = l2 - l1;
            if (l1 >= 30000L) {
              l1 = 1000L;
            } else if (l1 >= 10000L) {
              l1 = 100L;
            } else {
              l1 = 10L;
            }
            localObject = Message.obtain();
            ((Message)localObject).what = 1002;
            ((Message)localObject).obj = parama;
            sendMessageDelayed((Message)localObject, l1);
            return;
          }
          a(((alr)localObject).c);
          return;
        }
        catch (Throwable parama)
        {
          a(parama);
          return;
        }
      }
      try
      {
        this.c = 32;
        a((alr)localObject);
        localObject = Message.obtain();
        ((Message)localObject).what = 1003;
        ((Message)localObject).obj = parama;
        sendMessageDelayed((Message)localObject, 20L);
        return;
      }
      catch (Throwable parama)
      {
        a(parama);
      }
    }
    
    private void a(alr paramalr)
    {
      if (paramalr == null) {
        return;
      }
      AccessibilityDispatcher.b().clear();
      if (!TextUtils.isEmpty(paramalr.f)) {
        AccessibilityDispatcher.b().add(paramalr.f);
      }
      if (paramalr.w != null)
      {
        localObject1 = paramalr.w.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ano)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(((ano)localObject2).g)) {
            AccessibilityDispatcher.b().add(((ano)localObject2).g);
          }
        }
      }
      if ((paramalr.r != null) && (paramalr.r.size() > 0)) {
        AccessibilityDispatcher.b().addAll(paramalr.r);
      }
      c();
      Object localObject1 = new ArrayList();
      Object localObject2 = new ano();
      ((ano)localObject2).a = paramalr.b;
      ((ano)localObject2).b = paramalr.j;
      if (paramalr.k != null)
      {
        ((ano)localObject2).c = new ArrayList();
        ((ano)localObject2).c.addAll(paramalr.k);
      }
      ((ano)localObject2).e = paramalr.n;
      ((ano)localObject2).f = paramalr.e;
      ((ano)localObject2).g = paramalr.f;
      ((ano)localObject2).h = paramalr.g;
      ((ano)localObject2).i = paramalr.p;
      if (paramalr.h != null)
      {
        ((ano)localObject2).j = new ArrayList();
        ((ano)localObject2).j.addAll(paramalr.h);
      }
      ((ano)localObject2).k = paramalr.i;
      ((ArrayList)localObject1).add(localObject2);
      if (paramalr.w != null) {
        ((ArrayList)localObject1).addAll(paramalr.w);
      }
      paramalr = null;
      localObject1 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext())
        {
          if (paramalr == null) {
            return;
          }
          throw paramalr;
        }
        paramalr = (ano)((Iterator)localObject1).next();
        localObject2 = new Intent();
        if (!TextUtils.isEmpty(paramalr.f)) {
          ((Intent)localObject2).setAction(paramalr.f);
        }
        if (!TextUtils.isEmpty(paramalr.g)) {
          if (!TextUtils.isEmpty(paramalr.a)) {
            ((Intent)localObject2).setClassName(paramalr.g, paramalr.a);
          } else {
            ((Intent)localObject2).setPackage(paramalr.g);
          }
        }
        boolean bool1 = TextUtils.isEmpty(paramalr.h) ^ true;
        boolean bool2 = TextUtils.isEmpty(paramalr.i) ^ true;
        if ((bool1) && (bool2)) {
          ((Intent)localObject2).setDataAndType(Uri.parse(paramalr.h), paramalr.i);
        } else if ((bool1) && (!bool2)) {
          ((Intent)localObject2).setData(Uri.parse(paramalr.h));
        } else if ((!bool1) && (bool2)) {
          ((Intent)localObject2).setType(paramalr.i);
        }
        if (paramalr.j != null)
        {
          Bundle localBundle = a(paramalr.j);
          if (localBundle != null) {
            ((Intent)localObject2).putExtras(localBundle);
          }
        }
        int i1;
        if (paramalr.k != 0) {
          i1 = paramalr.k;
        } else {
          i1 = 1350926336;
        }
        ((Intent)localObject2).setFlags(i1);
        try
        {
          AccessibilityDispatcher.this.startActivity((Intent)localObject2);
          localObject2 = new StringBuilder("open suc. pkg=");
          ((StringBuilder)localObject2).append(paramalr.g);
          ((StringBuilder)localObject2).append(" cls=");
          ((StringBuilder)localObject2).append(paramalr.a);
          return;
        }
        catch (Exception paramalr) {}
      }
    }
    
    private void a(Throwable paramThrowable)
    {
      paramThrowable.getMessage();
      if (AccessibilityDispatcher.a != null) {
        paramThrowable = AccessibilityDispatcher.a;
      }
      paramThrowable = this.h;
      if (paramThrowable != null) {
        paramThrowable.a(this.f, 2);
      }
      paramThrowable = this.i;
      if (paramThrowable != null)
      {
        paramThrowable.b = 3;
        paramThrowable.c = this.f;
      }
      a();
    }
    
    private void a(boolean paramBoolean)
    {
      if (!paramBoolean)
      {
        localObject = this.h;
        if (localObject != null) {
          ((aoe.a)localObject).a(this.f, 2);
        }
        localObject = this.i;
        if (localObject != null)
        {
          ((aoe.c)localObject).b = 2;
          ((aoe.c)localObject).c = this.f;
          localObject = AccessibilityDispatcher.this.getRootInActiveWindow();
          if (localObject != null) {
            this.i.e = b((AccessibilityNodeInfo)localObject);
          }
        }
        a();
        return;
      }
      Object localObject = this.h;
      if (localObject != null) {
        ((aoe.a)localObject).a(this.f, 1);
      }
      localObject = this.i;
      if (localObject != null)
      {
        ((aoe.c)localObject).b = 1;
        aoe.c localc;
        if (TextUtils.isEmpty(((aoe.c)localObject).d))
        {
          localc = this.i;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.f);
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localc = this.i;
          localObject = new StringBuilder(String.valueOf(localc.d));
          ((StringBuilder)localObject).append("|");
          ((StringBuilder)localObject).append(this.f);
          localObject = ((StringBuilder)localObject).toString();
        }
        localc.d = ((String)localObject);
      }
      sendEmptyMessageDelayed(1001, 100L);
    }
    
    private boolean a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      boolean bool1 = false;
      if (paramAccessibilityNodeInfo == null) {
        return false;
      }
      if (paramAccessibilityNodeInfo.isEnabled()) {
        bool1 = paramAccessibilityNodeInfo.performAction(16);
      }
      boolean bool2 = bool1;
      if (!bool1)
      {
        paramAccessibilityNodeInfo = paramAccessibilityNodeInfo.getParent();
        bool2 = bool1;
        if (paramAccessibilityNodeInfo != null)
        {
          bool2 = a(paramAccessibilityNodeInfo);
          paramAccessibilityNodeInfo.recycle();
        }
      }
      return bool2;
    }
    
    private boolean a(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt, ano paramano)
    {
      "needIgnoreClick ignoreState=".concat(String.valueOf(paramInt));
      boolean bool2 = false;
      int i1;
      if ((paramano != null) && (((paramano.c != null) && (paramano.c.size() > 0)) || (!TextUtils.isEmpty(paramano.a)))) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      Object localObject2 = null;
      Object localObject1 = null;
      if (i1 != 0)
      {
        if ((paramano.c == null) && (TextUtils.isEmpty(paramano.a))) {
          return false;
        }
        i1 = paramano.d;
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
          if (paramano.c == null)
          {
            localObject1 = a((AccessibilityNodeInfo)localObject3, paramano.a, null);
          }
          else
          {
            localObject4 = paramano.c.iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject2 = (String)((Iterator)localObject4).next();
              switch (paramano.b)
              {
              default: 
                localObject2 = localObject1;
                break;
              case 2: 
                localObject2 = b((AccessibilityNodeInfo)localObject3, paramano.a, (String)localObject2);
                break;
              case 1: 
              case 3: 
              case 4: 
              case 5: 
                localObject2 = a((AccessibilityNodeInfo)localObject3, paramano.a, null, (String)localObject2, paramano.b);
              }
              localObject1 = localObject2;
              if (localObject2 != null) {
                break;
              }
              localObject1 = localObject2;
            }
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
        if (paramano == null) {
          break label428;
        }
        if (paramano.c != null) {
          if (paramano.c.size() > 0) {
            break label416;
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
      if (!TextUtils.isEmpty(paramano.a))
      {
        label416:
        bool1 = bool2;
        if (localObject2 != null) {
          bool1 = true;
        }
      }
      label428:
      if (localObject2 != paramAccessibilityNodeInfo) {
        ((AccessibilityNodeInfo)localObject2).recycle();
      }
      return bool1;
    }
    
    private AccessibilityNodeInfo b(AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString1, String paramString2)
    {
      Object localObject = new StringBuilder("findNodeByDescription clsName=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" text=");
      ((StringBuilder)localObject).append(paramString2);
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
    
    private String b(AccessibilityNodeInfo paramAccessibilityNodeInfo)
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
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = "";
        } else {
          localObject1 = "@".concat(String.valueOf(localObject3));
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        String str = ((StringBuilder)localObject2).toString();
        int i4 = paramAccessibilityNodeInfo.getChildCount();
        int i1 = 0;
        localObject1 = "";
        int i2 = 0;
        for (;;)
        {
          if (i1 >= i4)
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
            if (TextUtils.isEmpty(str)) {
              return localObject2;
            }
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              return str.toString();
            }
            if (((String)localObject2).startsWith("{"))
            {
              paramAccessibilityNodeInfo = new StringBuilder(String.valueOf(str));
              paramAccessibilityNodeInfo.append(",");
              paramAccessibilityNodeInfo.append((String)localObject2);
            }
            for (;;)
            {
              return paramAccessibilityNodeInfo.toString();
              paramAccessibilityNodeInfo = new StringBuilder(String.valueOf(str));
              paramAccessibilityNodeInfo.append(",{");
              paramAccessibilityNodeInfo.append((String)localObject2);
              paramAccessibilityNodeInfo.append("}");
            }
          }
          localObject3 = b(paramAccessibilityNodeInfo.getChild(i1));
          int i3 = i2;
          localObject2 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            i3 = i2 + 1;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject2 = localObject3;
            }
            else
            {
              localObject1 = new StringBuilder(String.valueOf(localObject1));
              ((StringBuilder)localObject1).append(",");
              ((StringBuilder)localObject1).append((String)localObject3);
              localObject2 = ((StringBuilder)localObject1).toString();
            }
          }
          i1 += 1;
          i2 = i3;
          localObject1 = localObject2;
        }
      }
      return "";
    }
    
    private void b()
    {
      aoe.a locala = this.h;
      if (locala != null) {
        locala.a(this.f, 0);
      }
      sendEmptyMessageDelayed(1001, 100L);
    }
    
    private boolean b(alr paramalr)
    {
      if (paramalr != null)
      {
        if (paramalr.k == null) {
          return false;
        }
        AccessibilityNodeInfo localAccessibilityNodeInfo = AccessibilityDispatcher.this.getRootInActiveWindow();
        if (localAccessibilityNodeInfo == null) {
          return false;
        }
        Object localObject1 = paramalr.t;
        boolean bool = true;
        if ((localObject1 != null) && (paramalr.t.size() > 0))
        {
          localObject1 = paramalr.t.iterator();
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
        if ((paramalr.k != null) && (paramalr.k.size() > 0))
        {
          localObject2 = new ano();
          ((ano)localObject2).b = paramalr.j;
          ((ano)localObject2).c = new ArrayList();
          ((ano)localObject2).c.addAll(paramalr.k);
          ((ano)localObject2).a = paramalr.b;
          ((ano)localObject2).e = paramalr.n;
          ((ArrayList)localObject1).add(localObject2);
        }
        if (paramalr.w != null) {
          ((ArrayList)localObject1).addAll(paramalr.w);
        }
        Object localObject2 = null;
        Iterator localIterator1 = ((ArrayList)localObject1).iterator();
        do
        {
          ano localano;
          Iterator localIterator2;
          while (!localIterator2.hasNext())
          {
            if (!localIterator1.hasNext())
            {
              localAccessibilityNodeInfo.recycle();
              return false;
            }
            localano = (ano)localIterator1.next();
            localIterator2 = localano.c.iterator();
          }
          localObject1 = (String)localIterator2.next();
          switch (localano.b)
          {
          default: 
            localObject1 = localObject2;
            break;
          case 2: 
            localObject1 = b(localAccessibilityNodeInfo, localano.a, (String)localObject1);
            break;
          case 1: 
          case 3: 
          case 4: 
          case 5: 
            localObject1 = a(localAccessibilityNodeInfo, localano.a, localano.e, (String)localObject1, localano.b);
          }
          localObject2 = localObject1;
        } while (localObject1 == null);
        if (!a((AccessibilityNodeInfo)localObject1, paramalr.l, paramalr.v)) {
          bool = a((AccessibilityNodeInfo)localObject1);
        }
        ((AccessibilityNodeInfo)localObject1).recycle();
        localAccessibilityNodeInfo.recycle();
        if (i1 == 0) {
          return bool;
        }
      }
      return false;
    }
    
    private void c()
    {
      AccessibilityServiceInfo localAccessibilityServiceInfo = AccessibilityDispatcher.this.getServiceInfo();
      if (localAccessibilityServiceInfo == null) {
        return;
      }
      Object localObject2 = new HashSet();
      int i1 = AccessibilityDispatcher.b().size();
      int i3 = 0;
      if (i1 > 0)
      {
        ((Set)localObject2).addAll(AccessibilityDispatcher.b());
        i1 = -1;
      }
      else
      {
        i1 = 0;
      }
      Object localObject1 = AccessibilityDispatcher.c().values().iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext())
        {
          int i2 = ((Set)localObject2).size();
          localObject1 = AccessibilityDispatcher.a;
          if (i2 <= 0)
          {
            localObject1 = this.n;
          }
          else
          {
            localObject1 = new String[i2];
            localObject2 = ((Set)localObject2).iterator();
            i2 = 0;
          }
          for (;;)
          {
            int i4;
            if (!((Iterator)localObject2).hasNext()) {
              i4 = this.m;
            }
            try
            {
              localObject2 = localAccessibilityServiceInfo.getClass();
              i2 = ((Integer)((Class)localObject2).getField("teacher").get(localObject2)).intValue();
            }
            catch (Exception localException2)
            {
              label171:
              String[] arrayOfString;
              Iterator localIterator;
              break label171;
            }
            i2 = 16;
            i4 |= i2;
            localObject2 = this.a;
            i2 = i4;
            if (localObject2 != null) {
              i2 = i4 | ((amf)localObject2).e;
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
              ((Field)localObject1).set(localAccessibilityServiceInfo, Boolean.TRUE);
            }
            catch (Exception localException1)
            {
              localException1.getMessage();
            }
            if (localAccessibilityServiceInfo.packageNames != null)
            {
              arrayOfString = localAccessibilityServiceInfo.packageNames;
              i2 = arrayOfString.length;
              i1 = i3;
              while (i1 < i2)
              {
                "[setServiceInfo]".concat(String.valueOf(arrayOfString[i1]));
                i1 += 1;
              }
            }
            new StringBuilder("[setServiceInfo]event types: ").append(localAccessibilityServiceInfo.eventTypes);
            AccessibilityDispatcher.this.setServiceInfo(localAccessibilityServiceInfo);
            return;
            arrayOfString[i2] = ((String)((Iterator)localObject2).next());
            i2 += 1;
          }
        }
        localIterator = ((List)arrayOfString.next()).iterator();
        while (localIterator.hasNext())
        {
          alr localalr = (alr)localIterator.next();
          if (localalr.r != null) {
            ((Set)localObject2).addAll(localalr.r);
          }
          i1 |= localalr.q;
        }
      }
    }
    
    private boolean c(alr paramalr)
    {
      if (paramalr == null) {
        return false;
      }
      Object localObject = null;
      AccessibilityNodeInfo localAccessibilityNodeInfo1 = null;
      int i1;
      if ((paramalr.k != null) && (paramalr.k.size() > 0))
      {
        int i2 = 1;
        AccessibilityNodeInfo localAccessibilityNodeInfo2 = AccessibilityDispatcher.this.getRootInActiveWindow();
        i1 = i2;
        if (localAccessibilityNodeInfo2 != null)
        {
          Iterator localIterator = paramalr.k.iterator();
          do
          {
            if (!localIterator.hasNext())
            {
              localObject = localAccessibilityNodeInfo1;
              break;
            }
            localObject = (String)localIterator.next();
            switch (paramalr.j)
            {
            default: 
              break;
            case 2: 
              localAccessibilityNodeInfo1 = b(localAccessibilityNodeInfo2, paramalr.b, (String)localObject);
              break;
            case 1: 
            case 3: 
            case 4: 
            case 5: 
              localAccessibilityNodeInfo1 = a(localAccessibilityNodeInfo2, paramalr.b, paramalr.n, (String)localObject, paramalr.j);
            }
            localObject = localAccessibilityNodeInfo1;
          } while (localAccessibilityNodeInfo1 == null);
          localAccessibilityNodeInfo2.recycle();
          i1 = i2;
        }
      }
      else
      {
        i1 = 0;
      }
      if ((i1 != 0) && (localObject != null)) {
        ((AccessibilityNodeInfo)localObject).recycle();
      }
      while (i1 == 0) {
        return AccessibilityDispatcher.this.performGlobalAction(paramalr.o);
      }
      return false;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int i2 = paramMessage.what;
      Object localObject1 = null;
      boolean bool2 = false;
      int i1 = 0;
      Object localObject3;
      label362:
      Object localObject2;
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
        case 1103: 
          c();
          return;
        case 1102: 
          paramMessage = (AccessibilityDispatcher.a)paramMessage.obj;
          AccessibilityDispatcher.c().remove(paramMessage.c);
          c();
          return;
        case 1101: 
          paramMessage = (AccessibilityDispatcher.a)paramMessage.obj;
          AccessibilityDispatcher.c().put(paramMessage.c, paramMessage.d);
          c();
          return;
        }
        localObject3 = new alr();
        ((alr)localObject3).a = 2;
        ((alr)localObject3).j = 2;
        ((alr)localObject3).k = new ArrayList();
        paramMessage = this.o;
        i2 = paramMessage.length;
        for (;;)
        {
          if (i1 >= i2)
          {
            if (!b((alr)localObject3))
            {
              try
              {
                String str1 = AccessibilityDispatcher.this.getPackageName();
                Iterator localIterator = ((AccessibilityManager)AccessibilityDispatcher.this.getSystemService("accessibility")).getInstalledAccessibilityServiceList().iterator();
                localObject1 = null;
                for (;;)
                {
                  paramMessage = (Message)localObject1;
                  try
                  {
                    if (!localIterator.hasNext()) {
                      break label362;
                    }
                    AccessibilityServiceInfo localAccessibilityServiceInfo = (AccessibilityServiceInfo)localIterator.next();
                    localObject1 = paramMessage;
                    if (localAccessibilityServiceInfo != null)
                    {
                      String str2 = localAccessibilityServiceInfo.getId();
                      localObject1 = paramMessage;
                      if (str2 != null)
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
                localThrowable2.getMessage();
              }
              catch (Throwable localThrowable2)
              {
                paramMessage = null;
              }
              localObject2 = new alr();
              ((alr)localObject2).a = 4;
              ((alr)localObject2).o = 1;
              if (!TextUtils.isEmpty(paramMessage))
              {
                ((alr)localObject2).j = 1;
                ((alr)localObject2).k = new ArrayList();
                ((alr)localObject2).k.add(paramMessage);
              }
              "globalRes1=".concat(String.valueOf(c((alr)localObject2)));
            }
            try
            {
              Thread.sleep(100L);
            }
            catch (InterruptedException paramMessage)
            {
              paramMessage.getMessage();
            }
            if ((!b((alr)localObject3)) && ("com.android.settings".equals(this.j)))
            {
              paramMessage = new alr();
              paramMessage.a = 4;
              paramMessage.o = 1;
              "globalRes2=".concat(String.valueOf(c(paramMessage)));
            }
            this.j = null;
            AccessibilityDispatcher.b().clear();
            c();
            if (AccessibilityDispatcher.a != null) {
              paramMessage = AccessibilityDispatcher.a;
            }
            return;
          }
          localObject2 = paramMessage[i1];
          ((alr)localObject3).k.add(localObject2);
          i1 += 1;
        }
      case 1003: 
        if (!this.b)
        {
          localObject2 = (AccessibilityDispatcher.a)paramMessage.obj;
          i1 = paramMessage.arg1;
          paramMessage = ((AccessibilityDispatcher.a)localObject2).a;
          long l1 = ((AccessibilityDispatcher.a)localObject2).b;
          localObject3 = new StringBuilder("checkAction=");
          ((StringBuilder)localObject3).append(paramMessage.a);
          ((StringBuilder)localObject3).append(" mWaitEventType=");
          ((StringBuilder)localObject3).append(this.c);
          i2 = paramMessage.a;
          if (i2 != 1)
          {
            if (i2 != 3) {
              return;
            }
            boolean bool1 = bool2;
            try
            {
              if (this.c < 0)
              {
                this.c = 4096;
                i2 = a(paramMessage, false);
                if (i2 == 1)
                {
                  bool1 = true;
                }
                else
                {
                  bool1 = bool2;
                  if (i2 == 3)
                  {
                    this.c = -1;
                    bool1 = bool2;
                  }
                }
              }
              "check scrollList result: ".concat(String.valueOf(bool1));
              if (bool1)
              {
                b();
                return;
              }
              if (i1 <= 2)
              {
                paramMessage = Message.obtain();
                paramMessage.what = 1003;
                paramMessage.arg1 = (i1 + 1);
                paramMessage.obj = localObject2;
                sendMessageDelayed(paramMessage, 100L);
                return;
              }
              a(paramMessage.c);
              return;
            }
            catch (Throwable paramMessage)
            {
              a(paramMessage);
              return;
            }
          }
          if (this.c < 0)
          {
            b();
            return;
          }
          if (paramMessage.s != 0) {
            i1 = paramMessage.s;
          } else {
            i1 = 6000;
          }
          if (System.currentTimeMillis() <= l1 + i1)
          {
            paramMessage = Message.obtain();
            paramMessage.what = 1003;
            paramMessage.obj = localObject2;
            sendMessageDelayed(paramMessage, 20L);
            return;
          }
          a(paramMessage.c);
          return;
        }
        paramMessage = this.i;
        if (paramMessage != null)
        {
          paramMessage.b = 4;
          paramMessage.c = (System.currentTimeMillis() - this.g);
        }
        a();
        return;
      case 1002: 
        if (!this.b) {
          paramMessage = (AccessibilityDispatcher.a)paramMessage.obj;
        }
        break;
      }
      for (;;)
      {
        a(paramMessage);
        return;
        paramMessage = this.i;
        if (paramMessage != null)
        {
          paramMessage.b = 4;
          paramMessage.c = (System.currentTimeMillis() - this.g);
        }
        a();
        return;
        this.f += 1;
        i1 = this.f;
        localObject3 = this.d;
        paramMessage = (Message)localObject2;
        try
        {
          if (i1 < this.a.c.size())
          {
            "get action, index ".concat(String.valueOf(i1));
            paramMessage = (alr)this.a.c.get(i1);
          }
          if ((paramMessage != null) && (!this.b))
          {
            if (paramMessage.u != 0)
            {
              try
              {
                Thread.sleep(paramMessage.u);
              }
              catch (InterruptedException localInterruptedException)
              {
                localInterruptedException.getMessage();
              }
              paramMessage.u = 0;
            }
            AccessibilityDispatcher.a locala = new AccessibilityDispatcher.a((byte)0);
            locala.a = paramMessage;
            locala.b = System.currentTimeMillis();
            paramMessage = locala;
            continue;
          }
          paramMessage = this.i;
          if (paramMessage != null) {
            paramMessage.c = (System.currentTimeMillis() - this.g);
          }
          a();
          return;
        }
        finally {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.meri.service.monitor.AccessibilityDispatcher
 * JD-Core Version:    0.7.0.1
 */