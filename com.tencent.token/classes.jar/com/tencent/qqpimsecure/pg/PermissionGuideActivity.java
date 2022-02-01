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
import com.tencent.qqpimsecure.taiji.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import taiji.bg;
import taiji.bp.a;
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
  private HashSet<Integer> k;
  private HashSet<Integer> l;
  private ArrayList<Integer> m;
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
    c.a().e().reportString(paramInt2, localArrayList);
  }
  
  private void a(MSolution paramMSolution, g paramg, int[] paramArrayOfInt, PageNextCallback paramPageNextCallback)
  {
    if (paramg.d == null) {
      return;
    }
    int i1 = paramMSolution.mHelpStyle;
    boolean bool2 = true;
    boolean bool1 = true;
    switch (i1)
    {
    default: 
      return;
    case 5: 
      b(paramMSolution);
      localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      a(paramMSolution, localArrayList1, localArrayList2, localArrayList3);
      paramg = paramg.d;
      i1 = this.d;
      bool2 = paramMSolution.mNoTrustAll;
      if (this.n < this.c.length - 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramg.onShowDoraemon(paramArrayOfInt, i1, bool2 ^ true, localArrayList2, localArrayList1, localArrayList3, bool1, paramPageNextCallback, this);
      return;
    case 4: 
      paramg = paramg.d;
      i1 = this.d;
      int i2 = paramMSolution.mHelpAnimation;
      if (this.n >= this.c.length - 1) {
        bool1 = false;
      }
      paramg.onShowAnimation(paramArrayOfInt, i1, i2, bool1, paramPageNextCallback, this);
      return;
    case 3: 
      paramg = paramg.d;
      i1 = this.d;
      bool2 = paramMSolution.mNoTrustAll;
      localArrayList1 = paramMSolution.mHelpTextList;
      paramMSolution = paramMSolution.mHelpImageList;
      if (this.n < this.c.length - 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramg.onShowImageText(paramArrayOfInt, i1, bool2 ^ true, localArrayList1, paramMSolution, bool1, paramPageNextCallback, this);
      return;
    case 2: 
      paramg = paramg.d;
      i1 = this.d;
      paramMSolution = paramMSolution.mHelpInfo;
      if (this.n < this.c.length - 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      paramg.onShowText(paramArrayOfInt, i1, paramMSolution, bool1, paramPageNextCallback, this);
      return;
    }
    paramg = paramg.d;
    i1 = this.d;
    ArrayList localArrayList1 = paramMSolution.mHelpTextList;
    paramMSolution = paramMSolution.mHelpImageList;
    if (this.n < this.c.length - 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramg.onShowImage(paramArrayOfInt, i1, localArrayList1, paramMSolution, bool1, paramPageNextCallback, this);
  }
  
  private void a(MSolution paramMSolution, ArrayList<Integer> paramArrayList, ArrayList<String> paramArrayList1, ArrayList<ArrayList<String>> paramArrayList2)
  {
    if (paramMSolution.mHelpDoraemonZip == null) {
      return;
    }
    paramMSolution = paramMSolution.mHelpDoraemonZip.mDoraemonResList;
    if ((paramMSolution != null) && (!paramMSolution.isEmpty()))
    {
      Iterator localIterator = paramMSolution.iterator();
      while (localIterator.hasNext())
      {
        MDoraemonRes localMDoraemonRes = (MDoraemonRes)localIterator.next();
        paramArrayList.add(Integer.valueOf(localMDoraemonRes.mDoraemonType));
        if (!TextUtils.isEmpty(localMDoraemonRes.mDoraemonText)) {
          paramMSolution = localMDoraemonRes.mDoraemonText;
        } else {
          paramMSolution = "";
        }
        paramArrayList1.add(paramMSolution);
        if (localMDoraemonRes.mFileList != null) {
          paramMSolution = localMDoraemonRes.mFileList;
        } else {
          paramMSolution = new ArrayList();
        }
        paramArrayList2.add(paramMSolution);
      }
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2, ArrayList<taiji.b> paramArrayList)
  {
    if (paramBoolean)
    {
      boolean bool2 = false;
      if (paramInt1 != 30004)
      {
        if (paramInt1 != 30009)
        {
          switch (paramInt1)
          {
          default: 
            switch (paramInt1)
            {
            default: 
              break;
            case 30023: 
              localObject = this.k;
              i1 = 41;
              break;
            case 30022: 
              localObject = this.k;
              i1 = 40;
              break;
            case 30021: 
              localObject = this.k;
              i1 = 39;
              break;
            case 30020: 
              localObject = this.k;
              i1 = 38;
            }
            break;
          case 30017: 
          case 30018: 
            this.k.add(Integer.valueOf(4));
            break;
          }
        }
        else
        {
          this.k.add(Integer.valueOf(5));
          f.b(this, 0);
          break label186;
        }
      }
      else
      {
        localObject = this.k;
        i1 = 3;
      }
      ((HashSet)localObject).add(Integer.valueOf(i1));
      label186:
      Object localObject = bg.c(paramInt1);
      g localg = g.a();
      int i2 = localObject.length;
      int i1 = 0;
      int i3;
      while (i1 < i2)
      {
        i3 = localObject[i1];
        i3 = localg.a.checkPermission(i3);
        bool1 = bool2;
        if (i3 == -1) {
          break label268;
        }
        if (i3 == 1)
        {
          bool1 = bool2;
          break label268;
        }
        i1 += 1;
      }
      boolean bool1 = paramBoolean;
      label268:
      if (bool1)
      {
        a(paramInt1, 271337);
        i1 = 1;
        i2 = this.d;
        i3 = 0;
      }
      else
      {
        i1 = 0;
        i2 = this.d;
        i3 = -1;
      }
      a.a(this, paramInt1, i1, i2, i3, paramString);
    }
    if ((paramInt2 < paramArrayList.size()) && (!this.j))
    {
      a(paramInt2, paramArrayList);
      return;
    }
    paramString = new Intent(this, PermissionGuideActivity.class);
    paramString.setFlags(603979776);
    startActivity(paramString);
  }
  
  private boolean a(final int paramInt, final ArrayList<taiji.b> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()) && (paramInt < paramArrayList.size()))
    {
      Object localObject = g.a();
      if (((g)localObject).b != null) {
        ((g)localObject).b.onProcessHelper((int)(paramInt / paramArrayList.size() * 100.0F));
      }
      localObject = (taiji.b)paramArrayList.get(paramInt);
      a(((taiji.b)localObject).b, 271336);
      AccessFactoryManager.get().accessFactory().startPlay(this, (taiji.b)localObject, new bp.a()
      {
        private String e;
        private boolean f;
        
        public void a() {}
        
        public void a(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          taiji.a locala = (taiji.a)paramArrayList.get(paramAnonymousInt1);
          if (locala.a == 1) {
            this.e = locala.f;
          }
          if (paramAnonymousInt2 == 2)
          {
            this.f = true;
            a.a(PermissionGuideActivity.this, paramInt, 0, PermissionGuideActivity.a(PermissionGuideActivity.this), paramAnonymousInt1, this.e);
          }
        }
        
        public void b()
        {
          PermissionGuideActivity.b(PermissionGuideActivity.this).post(new Runnable()
          {
            public void run()
            {
              PermissionGuideActivity.a(PermissionGuideActivity.this, PermissionGuideActivity.1.a(PermissionGuideActivity.1.this) ^ true, PermissionGuideActivity.1.this.a.b, PermissionGuideActivity.1.b(PermissionGuideActivity.1.this), PermissionGuideActivity.1.this.b + 1, PermissionGuideActivity.1.this.c);
            }
          });
        }
      });
      return true;
    }
    return false;
  }
  
  private boolean a(MSolution paramMSolution)
  {
    int i1 = 0;
    if (paramMSolution == null) {
      return false;
    }
    Intent localIntent = e.a(paramMSolution);
    if (localIntent == null) {
      return false;
    }
    if (this.f == 2)
    {
      localObject2 = new int[this.m.size()];
      Iterator localIterator = this.m.iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2[i1] = ((Integer)localIterator.next()).intValue();
        i1 += 1;
      }
    }
    Object localObject1 = this.c;
    Object localObject2 = g.a();
    boolean bool;
    if (paramMSolution.mHelpStyle == 0)
    {
      bool = a(localIntent, paramMSolution, (g)localObject2, (int[])localObject1);
    }
    else if ((((g)localObject2).a.checkPermission(37) != 0) && (((g)localObject2).a.checkPermission(5) != 0))
    {
      localIntent.setFlags(411140096);
      bool = c(localIntent, paramMSolution, (g)localObject2, (int[])localObject1);
    }
    else
    {
      localIntent.setFlags(411140096);
      bool = b(localIntent, paramMSolution, (g)localObject2, (int[])localObject1);
    }
    this.p = paramMSolution.mJumpIntent.mPackage;
    return bool;
  }
  
  /* Error */
  private boolean a(final Intent paramIntent, MSolution paramMSolution, g paramg, final int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 144	Protocol/MGuide/MSolution:mHelpTextList	Ljava/util/ArrayList;
    //   4: ifnull +87 -> 91
    //   7: aload_2
    //   8: getfield 144	Protocol/MGuide/MSolution:mHelpTextList	Ljava/util/ArrayList;
    //   11: invokevirtual 175	java/util/ArrayList:isEmpty	()Z
    //   14: ifeq +6 -> 20
    //   17: goto +74 -> 91
    //   20: aload_3
    //   21: getfield 110	com/tencent/qqpimsecure/pg/g:d	Ltmsdk/common/module/pgsdk/PageCallback;
    //   24: ifnull +42 -> 66
    //   27: aload_3
    //   28: getfield 110	com/tencent/qqpimsecure/pg/g:d	Ltmsdk/common/module/pgsdk/PageCallback;
    //   31: aload 4
    //   33: aload_0
    //   34: getfield 68	com/tencent/qqpimsecure/pg/PermissionGuideActivity:d	I
    //   37: aload_2
    //   38: getfield 144	Protocol/MGuide/MSolution:mHelpTextList	Ljava/util/ArrayList;
    //   41: aload_2
    //   42: getfield 147	Protocol/MGuide/MSolution:mHelpImageList	Ljava/util/ArrayList;
    //   45: iconst_0
    //   46: new 14	com/tencent/qqpimsecure/pg/PermissionGuideActivity$2
    //   49: dup
    //   50: aload_0
    //   51: aload_1
    //   52: aload 4
    //   54: invokespecial 351	com/tencent/qqpimsecure/pg/PermissionGuideActivity$2:<init>	(Lcom/tencent/qqpimsecure/pg/PermissionGuideActivity;Landroid/content/Intent;[I)V
    //   57: aload_0
    //   58: invokeinterface 162 8 0
    //   63: goto +35 -> 98
    //   66: aload_1
    //   67: ldc_w 331
    //   70: invokevirtual 274	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   73: pop
    //   74: aload_0
    //   75: aload_1
    //   76: invokevirtual 278	com/tencent/qqpimsecure/pg/PermissionGuideActivity:startActivity	(Landroid/content/Intent;)V
    //   79: invokestatic 356	com/tencent/qqpimsecure/pg/d:a	()Lcom/tencent/qqpimsecure/pg/d;
    //   82: aload 4
    //   84: aload_0
    //   85: invokevirtual 359	com/tencent/qqpimsecure/pg/d:a	([ILandroid/app/Activity;)V
    //   88: goto +10 -> 98
    //   91: aload_0
    //   92: aload_1
    //   93: bipush 100
    //   95: invokevirtual 363	com/tencent/qqpimsecure/pg/PermissionGuideActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   98: iconst_1
    //   99: ireturn
    //   100: astore_1
    //   101: iconst_0
    //   102: ireturn
    //   103: astore_1
    //   104: iconst_0
    //   105: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	PermissionGuideActivity
    //   0	106	1	paramIntent	Intent
    //   0	106	2	paramMSolution	MSolution
    //   0	106	3	paramg	g
    //   0	106	4	paramArrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   66	88	100	java/lang/Throwable
    //   91	98	103	java/lang/Throwable
  }
  
  private void b()
  {
    if (AccessFactoryManager.get().accessFactory().canPlay(this) != 0)
    {
      h();
      return;
    }
    g localg = g.a();
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = this.c;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = arrayOfInt[i1];
      if ((this.h) || (localg.a.checkPermission(i3) != 0)) {
        localArrayList.add(Integer.valueOf(i3));
      }
      i1 += 1;
    }
    if (localArrayList.isEmpty())
    {
      g();
      return;
    }
    if (!a(0, b.a(this, localArrayList)))
    {
      h();
      return;
    }
    if (localg.b != null) {
      localg.b.onStartHelper(this);
    }
    this.b = 2;
  }
  
  private void b(MSolution paramMSolution)
  {
    if (paramMSolution != null)
    {
      if (paramMSolution.mHelpDoraemonZip == null) {
        return;
      }
      if (paramMSolution.mHelpDoraemonZip.mDoraemonResList != null)
      {
        if (paramMSolution.mHelpDoraemonZip.mDoraemonResList.isEmpty()) {
          return;
        }
        int i1 = 0;
        while (i1 < paramMSolution.mHelpDoraemonZip.mDoraemonResList.size())
        {
          if (paramMSolution.mHelpDoraemonZip.mDoraemonResList.get(i1) != null)
          {
            String str = ((MDoraemonRes)paramMSolution.mHelpDoraemonZip.mDoraemonResList.get(i1)).mDoraemonText;
            if ((!TextUtils.isEmpty(str)) && (str.contains("%pkg"))) {
              ((MDoraemonRes)paramMSolution.mHelpDoraemonZip.mDoraemonResList.get(i1)).mDoraemonText = str.replace("%pkg", getApplicationInfo().loadLabel(getPackageManager()).toString());
            }
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void b(MSolution paramMSolution, g paramg, int[] paramArrayOfInt, PageNextCallback paramPageNextCallback)
  {
    if (paramg.c == null) {
      return;
    }
    switch (paramMSolution.mHelpStyle)
    {
    default: 
      return;
    case 5: 
      b(paramMSolution);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      a(paramMSolution, localArrayList1, localArrayList2, localArrayList3);
      paramg.c.onShowPreviewDoraemon(paramArrayOfInt, this.d, paramMSolution.mNoTrustAll ^ true, localArrayList2, localArrayList1, localArrayList3, paramPageNextCallback, this);
      return;
    case 4: 
      paramg.c.onShowPreviewAnimation(paramArrayOfInt, this.d, paramMSolution.mHelpAnimation, paramPageNextCallback, this);
      return;
    case 3: 
      paramg.c.onShowPreviewImageText(paramArrayOfInt, this.d, paramMSolution.mNoTrustAll ^ true, paramMSolution.mHelpTextList, paramMSolution.mHelpImageList, paramPageNextCallback, this);
      return;
    case 2: 
      paramg.c.onShowPreviewText(paramArrayOfInt, this.d, paramMSolution.mHelpInfo, paramPageNextCallback, this);
      return;
    }
    paramg.c.onShowPreviewImage(paramArrayOfInt, this.d, paramMSolution.mHelpTextList, paramMSolution.mHelpImageList, paramPageNextCallback, this);
  }
  
  private boolean b(Intent paramIntent, MSolution paramMSolution, g paramg, int[] paramArrayOfInt)
  {
    try
    {
      startActivity(paramIntent);
      d.a().a(paramArrayOfInt, this);
      if (paramg.e != null)
      {
        int i1;
        boolean bool;
        switch (paramMSolution.mHelpStyle)
        {
        default: 
          break;
        case 5: 
          b(paramMSolution);
          paramIntent = new ArrayList();
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          a(paramMSolution, paramIntent, localArrayList1, localArrayList2);
          paramg = paramg.e;
          i1 = this.d;
          if (paramMSolution.mHelpTech != 1) {
            bool = true;
          } else {
            bool = false;
          }
          paramg.onShowDoraemon(paramArrayOfInt, i1, bool, paramMSolution.mNoTrustAll ^ true, localArrayList1, paramIntent, localArrayList2, this);
          break;
        case 4: 
          paramIntent = paramg.e;
          i1 = this.d;
          if (paramMSolution.mHelpTech != 1) {
            bool = true;
          } else {
            bool = false;
          }
          paramIntent.onShowAnimation(paramArrayOfInt, i1, bool, paramMSolution.mHelpAnimation, this);
          break;
        case 3: 
          paramIntent = paramg.e;
          i1 = this.d;
          if (paramMSolution.mHelpTech != 1) {
            bool = true;
          } else {
            bool = false;
          }
          paramIntent.onShowImageText(paramArrayOfInt, i1, bool, paramMSolution.mNoTrustAll ^ true, paramMSolution.mHelpTextList, paramMSolution.mHelpImageList, this);
          break;
        case 2: 
          paramIntent = paramg.e;
          i1 = this.d;
          if (paramMSolution.mHelpTech != 1) {
            bool = true;
          } else {
            bool = false;
          }
          paramIntent.onShowText(paramArrayOfInt, i1, bool, paramMSolution.mHelpInfo, this);
          break;
        case 1: 
          paramIntent = paramg.e;
          i1 = this.d;
          if (paramMSolution.mHelpTech != 1) {
            bool = true;
          } else {
            bool = false;
          }
          paramIntent.onShowImage(paramArrayOfInt, i1, bool, paramMSolution.mHelpTextList, paramMSolution.mHelpImageList, this);
        }
      }
      if ((!this.m.isEmpty()) && (((Integer)this.m.get(0)).intValue() == 5))
      {
        f.b(this, 2);
        f.b(this, System.currentTimeMillis());
        f.a(this, 5, this.d);
      }
      this.i = true;
      return true;
    }
    catch (Throwable paramIntent) {}
    return false;
  }
  
  private void c()
  {
    g localg = g.a();
    Object localObject1 = null;
    int i3 = 0;
    int i1 = 1;
    while (i3 < this.c.length)
    {
      int i4;
      Object localObject2;
      if (!this.h)
      {
        i4 = i1;
        localObject2 = localObject1;
        if (localg.a.checkPermission(this.c[i3]) == 0) {}
      }
      else
      {
        this.l.add(Integer.valueOf(this.c[i3]));
        int i2 = i1;
        if (i1 != 0) {
          i2 = 0;
        }
        if (localObject1 == null)
        {
          localObject2 = e.a(this, this.c[i3]);
          this.m.clear();
          this.m.add(Integer.valueOf(this.c[i3]));
          this.n = i3;
          this.o = bg.b(this.c[i3]);
          i4 = i2;
        }
        else
        {
          i4 = i2;
          localObject2 = localObject1;
          if (bg.b(this.c[i3]) == this.o)
          {
            this.m.add(Integer.valueOf(this.c[i3]));
            localObject2 = localObject1;
            i4 = i2;
          }
        }
      }
      i3 += 1;
      i1 = i4;
      localObject1 = localObject2;
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
  
  private boolean c(final Intent paramIntent, final MSolution paramMSolution, final g paramg, final int[] paramArrayOfInt)
  {
    paramIntent = new PageNextCallback()
    {
      public void onCallback()
      {
        try
        {
          PermissionGuideActivity.this.startActivity(paramIntent);
          PermissionGuideActivity.this.overridePendingTransition(0, 0);
          d.a().a(paramArrayOfInt, PermissionGuideActivity.this);
          if ((!PermissionGuideActivity.c(PermissionGuideActivity.this).isEmpty()) && (((Integer)PermissionGuideActivity.c(PermissionGuideActivity.this).get(0)).intValue() == 5))
          {
            f.b(PermissionGuideActivity.this, 2);
            f.b(PermissionGuideActivity.this, System.currentTimeMillis());
            f.a(PermissionGuideActivity.this, 5, PermissionGuideActivity.a(PermissionGuideActivity.this));
          }
          return;
        }
        catch (Throwable localThrowable) {}
      }
      
      public void setIntentExtras(Bundle paramAnonymousBundle)
      {
        paramIntent.putExtras(paramAnonymousBundle);
      }
    };
    if (paramg.c != null)
    {
      this.q = new Runnable()
      {
        public void run()
        {
          if (paramg.d != null) {
            PermissionGuideActivity.a(PermissionGuideActivity.this, paramMSolution, paramg, paramArrayOfInt, paramIntent);
          }
        }
      };
      b(paramMSolution, paramg, paramArrayOfInt, paramIntent);
    }
    else if (paramg.d != null)
    {
      a(paramMSolution, paramg, paramArrayOfInt, paramIntent);
    }
    else
    {
      paramIntent.onCallback();
    }
    return true;
  }
  
  private void d()
  {
    Object localObject1;
    if (this.i)
    {
      localObject1 = g.a();
      if (((g)localObject1).e != null) {
        ((g)localObject1).e.onDismissWindow();
      }
    }
    if (this.f == 2)
    {
      g localg = g.a();
      for (;;)
      {
        i1 = this.n;
        localObject1 = this.c;
        if ((i1 >= localObject1.length) || (bg.b(localObject1[i1]) != this.o)) {
          break;
        }
        if (localg.a.checkPermission(this.c[this.n]) != 0)
        {
          i1 = 1;
          break label117;
        }
        this.n += 1;
      }
      int i1 = 0;
      label117:
      if (i1 == 0)
      {
        if ((!this.m.isEmpty()) && (((Integer)this.m.get(0)).intValue() == 5)) {
          f.b(this, 0L);
        }
        if (localg.a.checkPermission(((Integer)this.m.get(0)).intValue()) == 2) {
          i1 = -1;
        } else {
          i1 = 1;
        }
        if (i1 == 1) {
          a(this.o, 271337);
        }
        a.a(this, this.o, i1, this.d, 0, this.p);
        int i3 = this.n;
        localObject1 = null;
        i1 = 1;
        while (i3 < this.c.length)
        {
          int i4 = i1;
          Object localObject2 = localObject1;
          if (localg.a.checkPermission(this.c[i3]) != 0)
          {
            this.l.add(Integer.valueOf(this.c[this.n]));
            int i2 = i1;
            if (i1 != 0) {
              i2 = 0;
            }
            if (localObject1 == null)
            {
              localObject2 = e.a(this, this.c[i3]);
              this.m.clear();
              this.m.add(Integer.valueOf(this.c[i3]));
              this.n = i3;
              this.o = bg.b(this.c[i3]);
              i4 = i2;
            }
            else
            {
              i4 = i2;
              localObject2 = localObject1;
              if (bg.b(this.c[i3]) == this.o)
              {
                this.m.add(Integer.valueOf(this.c[i3]));
                localObject2 = localObject1;
                i4 = i2;
              }
            }
          }
          i3 += 1;
          i1 = i4;
          localObject1 = localObject2;
        }
        if (i1 != 0)
        {
          g();
          return;
        }
        Toast.makeText(this, "开启成功！\n前往开启下一个权限", 1).show();
        a(this.o, 271336);
        if (!a((MSolution)localObject1)) {
          h();
        }
        return;
      }
    }
    h();
  }
  
  private void e()
  {
    if (this.q == null)
    {
      d();
      return;
    }
    g localg = g.a();
    int i1 = this.f;
    int i2 = 0;
    if (i1 == 2)
    {
      int[] arrayOfInt2 = new int[this.m.size()];
      Iterator localIterator = this.m.iterator();
      i1 = 0;
      for (;;)
      {
        arrayOfInt1 = arrayOfInt2;
        if (!localIterator.hasNext()) {
          break;
        }
        arrayOfInt2[i1] = ((Integer)localIterator.next()).intValue();
        i1 += 1;
      }
    }
    int[] arrayOfInt1 = this.c;
    i1 = 0;
    while (i1 < arrayOfInt1.length)
    {
      if (localg.a.checkPermission(arrayOfInt1[i1]) != 0)
      {
        i1 = i2;
        break label131;
      }
      i1 += 1;
    }
    i1 = 1;
    label131:
    if (i1 != 0)
    {
      d();
      return;
    }
    if (localg.c != null) {
      localg.c.onDismissPreview();
    }
    this.q.run();
    this.q = null;
  }
  
  private void f()
  {
    finish();
    g localg = g.a();
    RequestCallback localRequestCallback = (RequestCallback)localg.f.get(Integer.valueOf(this.e));
    if (localRequestCallback != null)
    {
      localRequestCallback.onCallback(null, null);
      localg.f.remove(Integer.valueOf(this.e));
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
    g localg = g.a();
    RequestCallback localRequestCallback = (RequestCallback)localg.f.get(Integer.valueOf(this.e));
    if (localRequestCallback != null)
    {
      localRequestCallback.onCallback(this.c, arrayOfInt);
      localg.f.remove(Integer.valueOf(this.e));
    }
  }
  
  private void h()
  {
    finish();
    g localg = g.a();
    if (this.f == 1)
    {
      localObject2 = new int[this.c.length];
      i1 = 0;
      for (;;)
      {
        int[] arrayOfInt = this.c;
        localObject1 = localObject2;
        if (i1 >= arrayOfInt.length) {
          break;
        }
        if ((this.k.contains(Integer.valueOf(arrayOfInt[i1]))) && (localg.a.checkPermission(this.c[i1]) == 2)) {
          localObject2[i1] = 0;
        } else {
          localObject2[i1] = localg.a.checkPermission(this.c[i1]);
        }
        i1 += 1;
      }
    }
    Object localObject2 = localg.b(this.c);
    int i2 = 0;
    int i1 = 1;
    int i3;
    for (;;)
    {
      localObject1 = this.c;
      i3 = i1;
      if (i2 >= localObject1.length) {
        break;
      }
      if (this.l.contains(Integer.valueOf(localObject1[i2])))
      {
        if (localObject2[i2] == 0)
        {
          i3 = 1;
          break;
        }
        if (localObject2[i2] == 2) {
          i1 = -1;
        } else {
          i1 = 0;
        }
      }
      i2 += 1;
    }
    if ((!this.m.isEmpty()) && (((Integer)this.m.get(0)).intValue() == 5) && (i3 != -1)) {
      f.b(this, 0L);
    }
    i1 = bg.b(((Integer)this.m.get(0)).intValue());
    if (i3 == 1) {
      a(i1, 271337);
    }
    Object localObject1 = localObject2;
    if (!this.h)
    {
      a.a(this, i1, i3, this.d, 0, this.p);
      localObject1 = localObject2;
    }
    localObject2 = (RequestCallback)localg.f.get(Integer.valueOf(this.e));
    if (localObject2 != null)
    {
      if (this.f == 2) {
        ((QuickCallback)localObject2).onCallback(this.c, (int[])localObject1, this.n);
      } else {
        ((RequestCallback)localObject2).onCallback(this.c, (int[])localObject1);
      }
      localg.f.remove(Integer.valueOf(this.e));
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
    int[] arrayOfInt = this.c;
    if ((arrayOfInt != null) && (arrayOfInt.length != 0))
    {
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
      return;
    }
    f();
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
    paramIntent = g.a();
    if (paramIntent.b != null) {
      paramIntent.b.onStopHelper();
    }
    h();
  }
  
  protected void onResume()
  {
    super.onResume();
    int i1 = this.b;
    if (i1 != 1)
    {
      if (i1 != 3) {
        return;
      }
      e();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.PermissionGuideActivity
 * JD-Core Version:    0.7.0.1
 */