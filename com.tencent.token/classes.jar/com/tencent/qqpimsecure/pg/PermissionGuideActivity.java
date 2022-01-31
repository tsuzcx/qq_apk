package com.tencent.qqpimsecure.pg;

import Protocol.MGuide.MDoraemonRes;
import Protocol.MGuide.MDoraemonZip;
import Protocol.MGuide.MIntent;
import Protocol.MGuide.MSolution;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import taiji.b;
import taiji.ca;
import tmsdk.common.module.pgsdk.ConfirmCallback;
import tmsdk.common.module.pgsdk.ExecuteHelperCallback;
import tmsdk.common.module.pgsdk.ExecuteHelperCallback.HelperAbortCallback;
import tmsdk.common.module.pgsdk.IPermissionChecker;
import tmsdk.common.module.pgsdk.PageCallback;
import tmsdk.common.module.pgsdk.PageNextCallback;
import tmsdk.common.module.pgsdk.PreviewCallback;
import tmsdk.common.module.pgsdk.QuickCallback;
import tmsdk.common.module.pgsdk.RequestCallback;
import tmsdk.common.module.pgsdk.WindowCallback;
import tmsdk.common.module.pgsdk.manager.AccessFactoryManager;
import tmsdk.common.module.pgsdk.manager.IAccessFactory;
import tmsdk.common.module.pgsdk.manager.ITaijiReportManager;

public class PermissionGuideActivity
  extends Activity
  implements ConfirmCallback, ExecuteHelperCallback.HelperAbortCallback
{
  public static final int EMID_Secure_Authority_Page_Execute = 271336;
  private Handler a = new Handler(Looper.getMainLooper());
  private int b;
  private int[] c;
  private int d;
  private int e;
  private int f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private HashSet k;
  private HashSet l;
  private ArrayList m;
  private int n;
  private int o;
  private String p;
  private Runnable q;
  
  private void a()
  {
    if (this.f == 1)
    {
      b();
      return;
    }
    c();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (!this.g) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(String.valueOf(this.d));
    localArrayList.add(String.valueOf(paramInt1));
    com.tencent.qqpimsecure.taiji.f.a().e().reportString(paramInt2, localArrayList);
  }
  
  private void a(MSolution paramMSolution, r paramr, int[] paramArrayOfInt, PageNextCallback paramPageNextCallback)
  {
    boolean bool2 = false;
    if (paramr.d == null) {
      return;
    }
    ArrayList localArrayList1;
    switch (paramMSolution.mHelpStyle)
    {
    default: 
      return;
    case 1: 
      paramr = paramr.d;
      i1 = this.d;
      localArrayList1 = paramMSolution.mHelpTextList;
      paramMSolution = paramMSolution.mHelpImageList;
      if (this.n >= this.c.length - 1) {
        break;
      }
    case 2: 
      for (bool1 = true;; bool1 = false)
      {
        paramr.onShowImage(paramArrayOfInt, i1, localArrayList1, paramMSolution, bool1, paramPageNextCallback, this);
        return;
        paramr = paramr.d;
        i1 = this.d;
        paramMSolution = paramMSolution.mHelpInfo;
        if (this.n < this.c.length - 1) {}
        for (bool1 = true;; bool1 = false)
        {
          paramr.onShowText(paramArrayOfInt, i1, paramMSolution, bool1, paramPageNextCallback, this);
          return;
        }
      }
    case 3: 
      paramr = paramr.d;
      i1 = this.d;
      if (!paramMSolution.mNoTrustAll)
      {
        bool1 = true;
        localArrayList1 = paramMSolution.mHelpTextList;
        paramMSolution = paramMSolution.mHelpImageList;
        if (this.n >= this.c.length - 1) {
          break label242;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        paramr.onShowImageText(paramArrayOfInt, i1, bool1, localArrayList1, paramMSolution, bool2, paramPageNextCallback, this);
        return;
        bool1 = false;
        break;
      }
    case 5: 
      label242:
      b(paramMSolution);
      localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      a(paramMSolution, localArrayList1, localArrayList2, localArrayList3);
      paramr = paramr.d;
      i1 = this.d;
      if (!paramMSolution.mNoTrustAll) {}
      for (bool1 = true;; bool1 = false)
      {
        if (this.n < this.c.length - 1) {
          bool2 = true;
        }
        paramr.onShowDoraemon(paramArrayOfInt, i1, bool1, localArrayList2, localArrayList1, localArrayList3, bool2, paramPageNextCallback, this);
        return;
      }
    }
    paramr = paramr.d;
    int i1 = this.d;
    int i2 = paramMSolution.mHelpAnimation;
    if (this.n < this.c.length - 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramr.onShowAnimation(paramArrayOfInt, i1, i2, bool1, paramPageNextCallback, this);
      return;
    }
  }
  
  private void a(MSolution paramMSolution, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    if (paramMSolution.mHelpDoraemonZip == null) {}
    do
    {
      return;
      paramMSolution = paramMSolution.mHelpDoraemonZip.mDoraemonResList;
    } while ((paramMSolution == null) || (paramMSolution.isEmpty()));
    Iterator localIterator = paramMSolution.iterator();
    label33:
    MDoraemonRes localMDoraemonRes;
    if (localIterator.hasNext())
    {
      localMDoraemonRes = (MDoraemonRes)localIterator.next();
      paramArrayList1.add(Integer.valueOf(localMDoraemonRes.mDoraemonType));
      if (TextUtils.isEmpty(localMDoraemonRes.mDoraemonText)) {
        break label115;
      }
      paramMSolution = localMDoraemonRes.mDoraemonText;
      label85:
      paramArrayList2.add(paramMSolution);
      if (localMDoraemonRes.mFileList == null) {
        break label121;
      }
    }
    label115:
    label121:
    for (paramMSolution = localMDoraemonRes.mFileList;; paramMSolution = new ArrayList())
    {
      paramArrayList3.add(paramMSolution);
      break label33;
      break;
      paramMSolution = "";
      break label85;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2, ArrayList paramArrayList)
  {
    int i1;
    if (paramBoolean) {
      switch (paramInt1)
      {
      default: 
        int[] arrayOfInt = ca.c(paramInt1);
        r localr = r.a();
        int i2 = arrayOfInt.length;
        i1 = 0;
        label99:
        boolean bool = paramBoolean;
        if (i1 < i2)
        {
          int i3 = arrayOfInt[i1];
          i3 = localr.a.checkPermission(i3);
          if ((i3 == -1) || (i3 == 1)) {
            bool = false;
          }
        }
        else
        {
          if (!bool) {
            break label334;
          }
          a(paramInt1, 271337);
          f.a(this, paramInt1, 1, this.d, 0, paramString);
        }
        break;
      }
    }
    for (;;)
    {
      if ((paramInt2 >= paramArrayList.size()) || (this.j)) {
        break label349;
      }
      a(paramInt2, paramArrayList);
      return;
      this.k.add(Integer.valueOf(3));
      break;
      this.k.add(Integer.valueOf(4));
      break;
      this.k.add(Integer.valueOf(5));
      q.b(this, 0);
      break;
      this.k.add(Integer.valueOf(4));
      break;
      this.k.add(Integer.valueOf(38));
      break;
      this.k.add(Integer.valueOf(39));
      break;
      this.k.add(Integer.valueOf(40));
      break;
      this.k.add(Integer.valueOf(41));
      break;
      i1 += 1;
      break label99;
      label334:
      f.a(this, paramInt1, 0, this.d, -1, paramString);
    }
    label349:
    paramString = new Intent(this, PermissionGuideActivity.class);
    paramString.setFlags(603979776);
    startActivity(paramString);
  }
  
  private boolean a(int paramInt, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (paramInt >= paramArrayList.size())) {
      return false;
    }
    Object localObject = r.a();
    if (((r)localObject).b != null) {
      ((r)localObject).b.onProcessHelper((int)(paramInt / paramArrayList.size() * 100.0F));
    }
    localObject = (b)paramArrayList.get(paramInt);
    a(((b)localObject).b, 271336);
    AccessFactoryManager.get().accessFactory().startPlay(this, (b)localObject, new a(this, (b)localObject, paramInt, paramArrayList));
    return true;
  }
  
  private boolean a(MSolution paramMSolution)
  {
    if (paramMSolution == null) {}
    Intent localIntent;
    do
    {
      return false;
      localIntent = m.a(paramMSolution);
    } while (localIntent == null);
    int[] arrayOfInt;
    Object localObject;
    boolean bool;
    if (this.f == 2)
    {
      arrayOfInt = new int[this.m.size()];
      localObject = this.m.iterator();
      int i1 = 0;
      while (((Iterator)localObject).hasNext())
      {
        arrayOfInt[i1] = ((Integer)((Iterator)localObject).next()).intValue();
        i1 += 1;
      }
      localObject = r.a();
      if (paramMSolution.mHelpStyle != 0) {
        break label127;
      }
      bool = a(localIntent, paramMSolution, (r)localObject, arrayOfInt);
    }
    for (;;)
    {
      this.p = paramMSolution.mJumpIntent.mPackage;
      return bool;
      arrayOfInt = this.c;
      break;
      label127:
      if ((((r)localObject).a.checkPermission(37) == 0) || (((r)localObject).a.checkPermission(5) == 0))
      {
        localIntent.setFlags(411140096);
        bool = b(localIntent, paramMSolution, (r)localObject, arrayOfInt);
      }
      else
      {
        localIntent.setFlags(411140096);
        bool = c(localIntent, paramMSolution, (r)localObject, arrayOfInt);
      }
    }
  }
  
  private boolean a(Intent paramIntent, MSolution paramMSolution, r paramr, int[] paramArrayOfInt)
  {
    if ((paramMSolution.mHelpTextList == null) || (paramMSolution.mHelpTextList.isEmpty())) {}
    for (;;)
    {
      try
      {
        startActivityForResult(paramIntent, 100);
        return true;
      }
      catch (Throwable paramIntent) {}
      if (paramr.d != null) {
        paramr.d.onShowImage(paramArrayOfInt, this.d, paramMSolution.mHelpTextList, paramMSolution.mHelpImageList, false, new c(this, paramIntent, paramArrayOfInt), this);
      } else {
        try
        {
          paramIntent.setFlags(411140096);
          startActivity(paramIntent);
          i.a().a(paramArrayOfInt, this);
        }
        catch (Throwable paramIntent)
        {
          return false;
        }
      }
    }
    return false;
  }
  
  private void b()
  {
    if (AccessFactoryManager.get().accessFactory().canPlay(this) != 0)
    {
      h();
      return;
    }
    r localr = r.a();
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = this.c;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = arrayOfInt[i1];
      if ((this.h) || (localr.a.checkPermission(i3) != 0)) {
        localArrayList.add(Integer.valueOf(i3));
      }
      i1 += 1;
    }
    if (localArrayList.isEmpty())
    {
      g();
      return;
    }
    if (!a(0, g.a(this, localArrayList)))
    {
      h();
      return;
    }
    if (localr.b != null) {
      localr.b.onStartHelper(this);
    }
    this.b = 2;
  }
  
  private void b(MSolution paramMSolution)
  {
    if ((paramMSolution == null) || (paramMSolution.mHelpDoraemonZip == null)) {}
    while ((paramMSolution.mHelpDoraemonZip.mDoraemonResList == null) || (paramMSolution.mHelpDoraemonZip.mDoraemonResList.isEmpty())) {
      return;
    }
    int i1 = 0;
    label37:
    if (i1 < paramMSolution.mHelpDoraemonZip.mDoraemonResList.size()) {
      if (paramMSolution.mHelpDoraemonZip.mDoraemonResList.get(i1) != null) {
        break label72;
      }
    }
    for (;;)
    {
      i1 += 1;
      break label37;
      break;
      label72:
      String str = ((MDoraemonRes)paramMSolution.mHelpDoraemonZip.mDoraemonResList.get(i1)).mDoraemonText;
      if ((!TextUtils.isEmpty(str)) && (str.contains("%pkg"))) {
        ((MDoraemonRes)paramMSolution.mHelpDoraemonZip.mDoraemonResList.get(i1)).mDoraemonText = str.replace("%pkg", getApplicationInfo().loadLabel(getPackageManager()).toString());
      }
    }
  }
  
  private void b(MSolution paramMSolution, r paramr, int[] paramArrayOfInt, PageNextCallback paramPageNextCallback)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramr.c == null) {
      return;
    }
    int i1;
    switch (paramMSolution.mHelpStyle)
    {
    default: 
      return;
    case 1: 
      paramr.c.onShowPreviewImage(paramArrayOfInt, this.d, paramMSolution.mHelpTextList, paramMSolution.mHelpImageList, paramPageNextCallback, this);
      return;
    case 2: 
      paramr.c.onShowPreviewText(paramArrayOfInt, this.d, paramMSolution.mHelpInfo, paramPageNextCallback, this);
      return;
    case 3: 
      paramr = paramr.c;
      i1 = this.d;
      if (!paramMSolution.mNoTrustAll) {}
      for (;;)
      {
        paramr.onShowPreviewImageText(paramArrayOfInt, i1, bool1, paramMSolution.mHelpTextList, paramMSolution.mHelpImageList, paramPageNextCallback, this);
        return;
        bool1 = false;
      }
    case 5: 
      b(paramMSolution);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      a(paramMSolution, localArrayList1, localArrayList2, localArrayList3);
      paramr = paramr.c;
      i1 = this.d;
      if (!paramMSolution.mNoTrustAll) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramr.onShowPreviewDoraemon(paramArrayOfInt, i1, bool1, localArrayList2, localArrayList1, localArrayList3, paramPageNextCallback, this);
        return;
      }
    }
    paramr.c.onShowPreviewAnimation(paramArrayOfInt, this.d, paramMSolution.mHelpAnimation, paramPageNextCallback, this);
  }
  
  private boolean b(Intent paramIntent, MSolution paramMSolution, r paramr, int[] paramArrayOfInt)
  {
    try
    {
      startActivity(paramIntent);
      i.a().a(paramArrayOfInt, this);
      if (paramr.e != null) {}
      switch (paramMSolution.mHelpStyle)
      {
      default: 
        if ((!this.m.isEmpty()) && (((Integer)this.m.get(0)).intValue() == 5))
        {
          q.b(this, 2);
          q.b(this, System.currentTimeMillis());
          q.a(this, 5, this.d);
        }
        this.i = true;
        return true;
      }
    }
    catch (Throwable paramIntent)
    {
      return false;
    }
    paramIntent = paramr.e;
    int i1 = this.d;
    if (paramMSolution.mHelpTech != 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramIntent.onShowText(paramArrayOfInt, i1, bool1, paramMSolution.mHelpInfo, this);
      break;
    }
    paramIntent = paramr.e;
    i1 = this.d;
    if (paramMSolution.mHelpTech != 1) {}
    for (bool1 = true;; bool1 = false)
    {
      paramIntent.onShowImage(paramArrayOfInt, i1, bool1, paramMSolution.mHelpTextList, paramMSolution.mHelpImageList, this);
      break;
    }
    paramIntent = paramr.e;
    i1 = this.d;
    if (paramMSolution.mHelpTech != 1)
    {
      bool1 = true;
      label241:
      if (paramMSolution.mNoTrustAll) {
        break label283;
      }
    }
    label283:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramIntent.onShowImageText(paramArrayOfInt, i1, bool1, bool2, paramMSolution.mHelpTextList, paramMSolution.mHelpImageList, this);
      break;
      bool1 = false;
      break label241;
    }
    b(paramMSolution);
    paramIntent = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(paramMSolution, paramIntent, localArrayList1, localArrayList2);
    paramr = paramr.e;
    i1 = this.d;
    if (paramMSolution.mHelpTech != 1)
    {
      bool1 = true;
      label352:
      if (paramMSolution.mNoTrustAll) {
        break label391;
      }
    }
    label391:
    for (bool2 = true;; bool2 = false)
    {
      paramr.onShowDoraemon(paramArrayOfInt, i1, bool1, bool2, localArrayList1, paramIntent, localArrayList2, this);
      break;
      bool1 = false;
      break label352;
    }
    paramIntent = paramr.e;
    i1 = this.d;
    if (paramMSolution.mHelpTech != 1) {}
    for (bool1 = true;; bool1 = false)
    {
      paramIntent.onShowAnimation(paramArrayOfInt, i1, bool1, paramMSolution.mHelpAnimation, this);
      break;
    }
  }
  
  private void c()
  {
    r localr = r.a();
    Object localObject1 = null;
    int i1 = 1;
    int i3 = 0;
    if (i3 < this.c.length)
    {
      int i4;
      Object localObject2;
      int i2;
      if (!this.h)
      {
        i4 = i1;
        localObject2 = localObject1;
        if (localr.a.checkPermission(this.c[i3]) == 0) {}
      }
      else
      {
        this.l.add(Integer.valueOf(this.c[i3]));
        i2 = i1;
        if (i1 != 0) {
          i2 = 0;
        }
        if (localObject1 != null) {
          break label155;
        }
        localObject2 = m.a(this, this.c[i3]);
        this.m.clear();
        this.m.add(Integer.valueOf(this.c[i3]));
        this.n = i3;
        this.o = ca.b(this.c[i3]);
        i4 = i2;
      }
      for (;;)
      {
        i3 += 1;
        i1 = i4;
        localObject1 = localObject2;
        break;
        label155:
        i4 = i2;
        localObject2 = localObject1;
        if (ca.b(this.c[i3]) == this.o)
        {
          this.m.add(Integer.valueOf(this.c[i3]));
          i4 = i2;
          localObject2 = localObject1;
        }
      }
    }
    if (i1 != 0)
    {
      g();
      return;
    }
    a(this.o, 271336);
    if (!a(localObject1))
    {
      h();
      return;
    }
    this.b = 3;
  }
  
  private boolean c(Intent paramIntent, MSolution paramMSolution, r paramr, int[] paramArrayOfInt)
  {
    paramIntent = new d(this, paramIntent, paramArrayOfInt);
    if (paramr.c != null)
    {
      this.q = new e(this, paramr, paramMSolution, paramArrayOfInt, paramIntent);
      b(paramMSolution, paramr, paramArrayOfInt, paramIntent);
    }
    for (;;)
    {
      return true;
      if (paramr.d != null) {
        a(paramMSolution, paramr, paramArrayOfInt, paramIntent);
      } else {
        paramIntent.onCallback();
      }
    }
  }
  
  private void d()
  {
    Object localObject1;
    if (this.i)
    {
      localObject1 = r.a();
      if (((r)localObject1).e != null) {
        ((r)localObject1).e.onDismissWindow();
      }
    }
    r localr;
    if (this.f == 2)
    {
      localr = r.a();
      if ((this.n >= this.c.length) || (ca.b(this.c[this.n]) != this.o)) {
        break label464;
      }
      if (localr.a.checkPermission(this.c[this.n]) == 0) {}
    }
    label459:
    label464:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        if ((!this.m.isEmpty()) && (((Integer)this.m.get(0)).intValue() == 5)) {
          q.b(this, 0L);
        }
        if (localr.a.checkPermission(((Integer)this.m.get(0)).intValue()) != 2) {
          break label459;
        }
      }
      for (i1 = -1;; i1 = 1)
      {
        if (i1 == 1) {
          a(this.o, 271337);
        }
        f.a(this, this.o, i1, this.d, 0, this.p);
        int i3 = this.n;
        localObject1 = null;
        i1 = 1;
        label208:
        if (i3 < this.c.length)
        {
          int i4 = i1;
          Object localObject2 = localObject1;
          int i2;
          if (localr.a.checkPermission(this.c[i3]) != 0)
          {
            this.l.add(Integer.valueOf(this.c[this.n]));
            i2 = i1;
            if (i1 != 0) {
              i2 = 0;
            }
            if (localObject1 != null) {
              break label360;
            }
            localObject2 = m.a(this, this.c[i3]);
            this.m.clear();
            this.m.add(Integer.valueOf(this.c[i3]));
            this.n = i3;
            this.o = ca.b(this.c[i3]);
            i4 = i2;
          }
          for (;;)
          {
            i3 += 1;
            i1 = i4;
            localObject1 = localObject2;
            break label208;
            this.n += 1;
            break;
            label360:
            i4 = i2;
            localObject2 = localObject1;
            if (ca.b(this.c[i3]) == this.o)
            {
              this.m.add(Integer.valueOf(this.c[i3]));
              i4 = i2;
              localObject2 = localObject1;
            }
          }
        }
        if (i1 != 0) {
          g();
        }
        do
        {
          return;
          Toast.makeText(this, "开启成功！\n前往开启下一个权限", 1).show();
          a(this.o, 271336);
        } while (a((MSolution)localObject1));
        h();
        return;
        h();
        return;
      }
    }
  }
  
  private void e()
  {
    int i2 = 0;
    if (this.q == null)
    {
      d();
      return;
    }
    r localr = r.a();
    int[] arrayOfInt;
    if (this.f == 2)
    {
      arrayOfInt = new int[this.m.size()];
      Iterator localIterator = this.m.iterator();
      i1 = 0;
      while (localIterator.hasNext())
      {
        arrayOfInt[i1] = ((Integer)localIterator.next()).intValue();
        i1 += 1;
      }
      i1 = 0;
      label83:
      if (i1 >= arrayOfInt.length) {
        break label164;
      }
      if (localr.a.checkPermission(arrayOfInt[i1]) == 0) {
        break label124;
      }
    }
    label164:
    for (int i1 = i2;; i1 = 1)
    {
      if (i1 != 0)
      {
        d();
        return;
        arrayOfInt = this.c;
        break;
        label124:
        i1 += 1;
        break label83;
      }
      if (localr.c != null) {
        localr.c.onDismissPreview();
      }
      this.q.run();
      this.q = null;
      return;
    }
  }
  
  private void f()
  {
    finish();
    r localr = r.a();
    RequestCallback localRequestCallback = (RequestCallback)localr.f.get(Integer.valueOf(this.e));
    if (localRequestCallback != null)
    {
      localRequestCallback.onCallback(null, null);
      localr.f.remove(Integer.valueOf(this.e));
    }
  }
  
  private void g()
  {
    finish();
    int[] arrayOfInt = new int[this.c.length];
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      arrayOfInt[i1] = 0;
      i1 += 1;
    }
    r localr = r.a();
    RequestCallback localRequestCallback = (RequestCallback)localr.f.get(Integer.valueOf(this.e));
    if (localRequestCallback != null)
    {
      localRequestCallback.onCallback(this.c, arrayOfInt);
      localr.f.remove(Integer.valueOf(this.e));
    }
  }
  
  private void h()
  {
    finish();
    r localr = r.a();
    Object localObject2;
    int i1;
    Object localObject1;
    int i2;
    if (this.f == 1)
    {
      localObject2 = new int[this.c.length];
      i1 = 0;
      localObject1 = localObject2;
      if (i1 < this.c.length)
      {
        if ((this.k.contains(Integer.valueOf(this.c[i1]))) && (localr.a.checkPermission(this.c[i1]) == 2)) {
          localObject2[i1] = 0;
        }
        for (;;)
        {
          i1 += 1;
          break;
          localObject2[i1] = localr.a.checkPermission(this.c[i1]);
        }
      }
    }
    else
    {
      localObject1 = localr.b(this.c);
      i2 = 0;
      i1 = 1;
      if (i2 >= this.c.length) {
        break label359;
      }
      if (!this.l.contains(Integer.valueOf(this.c[i2]))) {
        break label332;
      }
      if (localObject1[i2] != 0) {
        break label323;
      }
      i1 = 1;
    }
    label323:
    label332:
    label344:
    label359:
    for (;;)
    {
      if ((!this.m.isEmpty()) && (((Integer)this.m.get(0)).intValue() == 5) && (i1 != -1)) {
        q.b(this, 0L);
      }
      i2 = ca.b(((Integer)this.m.get(0)).intValue());
      if (i1 == 1) {
        a(i2, 271337);
      }
      if (!this.h) {
        f.a(this, i2, i1, this.d, 0, this.p);
      }
      localObject2 = (RequestCallback)localr.f.get(Integer.valueOf(this.e));
      if (localObject2 != null)
      {
        if (this.f != 2) {
          break label344;
        }
        ((QuickCallback)localObject2).onCallback(this.c, (int[])localObject1, this.n);
      }
      for (;;)
      {
        localr.f.remove(Integer.valueOf(this.e));
        return;
        if (localObject1[i2] == 2) {}
        for (i1 = -1;; i1 = 0)
        {
          i2 += 1;
          break;
        }
        ((RequestCallback)localObject2).onCallback(this.c, (int[])localObject1);
      }
    }
  }
  
  public void onBackPressed()
  {
    if (this.b != 2) {
      super.onBackPressed();
    }
  }
  
  public void onCallback()
  {
    AccessFactoryManager.get().accessFactory().cancelPlay();
    this.j = true;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      f();
      return;
    }
    this.c = paramBundle.getIntArrayExtra("e_pms");
    this.e = paramBundle.getIntExtra("e_uid", 0);
    if ((this.c == null) || (this.c.length == 0))
    {
      f();
      return;
    }
    this.d = paramBundle.getIntExtra("e_src", 0);
    this.h = paramBundle.getBooleanExtra("e_s_c", false);
    this.f = paramBundle.getIntExtra("e_md", 3);
    this.g = paramBundle.getBooleanExtra("e_m", false);
    this.b = 1;
    if (this.f == 1)
    {
      this.k = new HashSet();
      return;
    }
    this.l = new HashSet();
    this.m = new ArrayList();
  }
  
  @TargetApi(11)
  public void onGranted()
  {
    this.n += 1;
    ActivityManager localActivityManager = (ActivityManager)getSystemService("activity");
    if (localActivityManager != null) {
      localActivityManager.moveTaskToFront(getTaskId(), 0);
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("e_mab", false)) {
      return;
    }
    paramIntent = r.a();
    if (paramIntent.b != null) {
      paramIntent.b.onStopHelper();
    }
    h();
  }
  
  protected void onResume()
  {
    super.onResume();
    switch (this.b)
    {
    case 2: 
    default: 
      return;
    case 1: 
      a();
      return;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.PermissionGuideActivity
 * JD-Core Version:    0.7.0.1
 */