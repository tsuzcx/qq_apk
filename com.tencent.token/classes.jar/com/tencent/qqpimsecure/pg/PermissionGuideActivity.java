package com.tencent.qqpimsecure.pg;

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
import com.tencent.token.als;
import com.tencent.token.amg;
import com.tencent.token.anw;
import com.tencent.token.aof.a;
import com.tencent.token.arw;
import com.tencent.token.ary;
import com.tencent.token.asb;
import com.tencent.token.asd;
import com.tencent.token.asd.b;
import com.tencent.token.ase;
import com.tencent.token.asi;
import com.tencent.token.b;
import com.tencent.token.c;
import com.tencent.token.d;
import com.tencent.token.e;
import com.tencent.token.qg;
import com.tencent.token.qh;
import com.tencent.token.qj;
import com.tencent.token.qj.a;
import com.tencent.token.qk;
import com.tencent.token.ql;
import com.tencent.token.qm;
import com.tencent.token.qm.a;
import com.tencent.token.qq;
import com.tencent.token.qq.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class PermissionGuideActivity
  extends Activity
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
    qq.a.a().b().a(paramInt2, localArrayList);
  }
  
  private void a(e parame, qm paramqm, int[] paramArrayOfInt, ary paramary)
  {
    if (paramqm.f == null) {
      return;
    }
    int i1 = parame.e;
    if (i1 != 5)
    {
      switch (i1)
      {
      default: 
        return;
      }
      return;
    }
    b(parame);
    a(parame, new ArrayList(), new ArrayList(), new ArrayList());
  }
  
  private void a(e parame, ArrayList<Integer> paramArrayList, ArrayList<String> paramArrayList1, ArrayList<ArrayList<String>> paramArrayList2)
  {
    if (parame.p == null) {
      return;
    }
    parame = parame.p.b;
    if ((parame != null) && (!parame.isEmpty()))
    {
      Iterator localIterator = parame.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        paramArrayList.add(Integer.valueOf(localb.b));
        if (!TextUtils.isEmpty(localb.c)) {
          parame = localb.c;
        } else {
          parame = "";
        }
        paramArrayList1.add(parame);
        if (localb.a != null) {
          parame = localb.a;
        } else {
          parame = new ArrayList();
        }
        paramArrayList2.add(parame);
      }
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2, ArrayList<amg> paramArrayList)
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
          ql.b(0);
          break label185;
        }
      }
      else
      {
        localObject = this.k;
        i1 = 3;
      }
      ((HashSet)localObject).add(Integer.valueOf(i1));
      label185:
      Object localObject = anw.c(paramInt1);
      qm localqm = qm.a.a();
      int i2 = localObject.length;
      int i1 = 0;
      int i3;
      while (i1 < i2)
      {
        i3 = localObject[i1];
        i3 = localqm.c.a(i3);
        bool1 = bool2;
        if (i3 == -1) {
          break label267;
        }
        if (i3 == 1)
        {
          bool1 = bool2;
          break label267;
        }
        i1 += 1;
      }
      boolean bool1 = paramBoolean;
      label267:
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
      qg.a(this, paramInt1, i1, i2, i3, paramString);
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
  
  private boolean a(final int paramInt, final ArrayList<amg> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()) && (paramInt < paramArrayList.size()))
    {
      if (qm.a.a().d != null) {
        paramArrayList.size();
      }
      final amg localamg = (amg)paramArrayList.get(paramInt);
      a(localamg.b, 271336);
      asd.b.a().a().a(this, localamg, new aof.a()
      {
        String a;
        boolean b;
        
        public final void a()
        {
          PermissionGuideActivity.b(PermissionGuideActivity.this).post(new Runnable()
          {
            public final void run()
            {
              PermissionGuideActivity.a(PermissionGuideActivity.this, PermissionGuideActivity.1.this.b ^ true, PermissionGuideActivity.1.this.c.b, PermissionGuideActivity.1.this.a, PermissionGuideActivity.1.this.d + 1, PermissionGuideActivity.1.this.e);
            }
          });
        }
        
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          als localals = (als)localamg.c.get(paramAnonymousInt1);
          if (localals.a == 1) {
            this.a = localals.f;
          }
          if (paramAnonymousInt2 == 2)
          {
            this.b = true;
            qg.a(PermissionGuideActivity.this, localamg.b, 0, PermissionGuideActivity.a(PermissionGuideActivity.this), paramAnonymousInt1, this.a);
          }
        }
      });
      return true;
    }
    return false;
  }
  
  /* Error */
  private boolean a(final Intent paramIntent, e parame, qm paramqm, final int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 264	com/tencent/token/e:m	Ljava/util/ArrayList;
    //   4: ifnull +63 -> 67
    //   7: aload_2
    //   8: getfield 264	com/tencent/token/e:m	Ljava/util/ArrayList;
    //   11: invokevirtual 135	java/util/ArrayList:isEmpty	()Z
    //   14: ifeq +6 -> 20
    //   17: goto +50 -> 67
    //   20: aload_3
    //   21: getfield 114	com/tencent/token/qm:f	Lcom/tencent/token/arx;
    //   24: ifnull +18 -> 42
    //   27: new 10	com/tencent/qqpimsecure/pg/PermissionGuideActivity$2
    //   30: dup
    //   31: aload_0
    //   32: aload_1
    //   33: aload 4
    //   35: invokespecial 267	com/tencent/qqpimsecure/pg/PermissionGuideActivity$2:<init>	(Lcom/tencent/qqpimsecure/pg/PermissionGuideActivity;Landroid/content/Intent;[I)V
    //   38: pop
    //   39: goto +35 -> 74
    //   42: aload_1
    //   43: ldc_w 268
    //   46: invokevirtual 225	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   49: pop
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 229	com/tencent/qqpimsecure/pg/PermissionGuideActivity:startActivity	(Landroid/content/Intent;)V
    //   55: invokestatic 273	com/tencent/token/qj$a:a	()Lcom/tencent/token/qj;
    //   58: aload 4
    //   60: aload_0
    //   61: invokevirtual 278	com/tencent/token/qj:a	([ILandroid/app/Activity;)V
    //   64: goto +10 -> 74
    //   67: aload_0
    //   68: aload_1
    //   69: bipush 100
    //   71: invokevirtual 282	com/tencent/qqpimsecure/pg/PermissionGuideActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   74: iconst_1
    //   75: ireturn
    //   76: astore_1
    //   77: iconst_0
    //   78: ireturn
    //   79: astore_1
    //   80: iconst_0
    //   81: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	PermissionGuideActivity
    //   0	82	1	paramIntent	Intent
    //   0	82	2	parame	e
    //   0	82	3	paramqm	qm
    //   0	82	4	paramArrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   42	64	76	java/lang/Throwable
    //   67	74	79	java/lang/Throwable
  }
  
  private boolean a(e parame)
  {
    int i1 = 0;
    if (parame == null) {
      return false;
    }
    Intent localIntent = qk.a(parame);
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
    Object localObject2 = qm.a.a();
    boolean bool;
    if (parame.e == 0)
    {
      bool = a(localIntent, parame, (qm)localObject2, (int[])localObject1);
    }
    else if ((((qm)localObject2).c.a(37) != 0) && (((qm)localObject2).c.a(5) != 0))
    {
      localIntent.setFlags(411140096);
      bool = c(localIntent, parame, (qm)localObject2, (int[])localObject1);
    }
    else
    {
      localIntent.setFlags(411140096);
      bool = b(localIntent, parame, (qm)localObject2, (int[])localObject1);
    }
    this.p = parame.a.d;
    return bool;
  }
  
  private void b()
  {
    if (asd.b.a().a().a(this) != 0)
    {
      h();
      return;
    }
    qm localqm = qm.a.a();
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = this.c;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = arrayOfInt[i1];
      if ((this.h) || (localqm.c.a(i3) != 0)) {
        localArrayList.add(Integer.valueOf(i3));
      }
      i1 += 1;
    }
    if (localArrayList.isEmpty())
    {
      g();
      return;
    }
    if (!a(0, qh.a(this, localArrayList)))
    {
      h();
      return;
    }
    this.b = 2;
  }
  
  private void b(e parame)
  {
    if (parame != null)
    {
      if (parame.p == null) {
        return;
      }
      if (parame.p.b != null)
      {
        if (parame.p.b.isEmpty()) {
          return;
        }
        int i1 = 0;
        while (i1 < parame.p.b.size())
        {
          if (parame.p.b.get(i1) != null)
          {
            String str = ((b)parame.p.b.get(i1)).c;
            if ((!TextUtils.isEmpty(str)) && (str.contains("%pkg"))) {
              ((b)parame.p.b.get(i1)).c = str.replace("%pkg", getApplicationInfo().loadLabel(getPackageManager()).toString());
            }
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void b(e parame, qm paramqm, int[] paramArrayOfInt, ary paramary)
  {
    if (paramqm.e == null) {
      return;
    }
    int i1 = parame.e;
    if (i1 != 5)
    {
      switch (i1)
      {
      default: 
        return;
      }
      return;
    }
    b(parame);
    a(parame, new ArrayList(), new ArrayList(), new ArrayList());
  }
  
  private boolean b(Intent paramIntent, e parame, qm paramqm, int[] paramArrayOfInt)
  {
    try
    {
      startActivity(paramIntent);
      qj.a.a().a(paramArrayOfInt, this);
      if (paramqm.g != null)
      {
        int i1 = parame.e;
        if (i1 != 5) {}
        switch (i1)
        {
        default: 
          break;
          b(parame);
          a(parame, new ArrayList(), new ArrayList(), new ArrayList());
        }
      }
      if ((!this.m.isEmpty()) && (((Integer)this.m.get(0)).intValue() == 5))
      {
        ql.b(2);
        ql.a(System.currentTimeMillis());
        ql.c(this.d);
      }
      this.i = true;
      return true;
    }
    catch (Throwable paramIntent) {}
    return false;
  }
  
  private void c()
  {
    qm localqm = qm.a.a();
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
        if (localqm.c.a(this.c[i3]) == 0) {}
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
          localObject2 = qk.a(this, this.c[i3]);
          this.m.clear();
          this.m.add(Integer.valueOf(this.c[i3]));
          this.n = i3;
          this.o = anw.b(this.c[i3]);
          i4 = i2;
        }
        else
        {
          i4 = i2;
          localObject2 = localObject1;
          if (anw.b(this.c[i3]) == this.o)
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
  
  private boolean c(final Intent paramIntent, final e parame, final qm paramqm, final int[] paramArrayOfInt)
  {
    paramIntent = new ary()
    {
      public final void a()
      {
        try
        {
          PermissionGuideActivity.this.startActivity(paramIntent);
          PermissionGuideActivity.this.overridePendingTransition(0, 0);
          qj.a.a().a(paramArrayOfInt, PermissionGuideActivity.this);
          if ((!PermissionGuideActivity.c(PermissionGuideActivity.this).isEmpty()) && (((Integer)PermissionGuideActivity.c(PermissionGuideActivity.this).get(0)).intValue() == 5))
          {
            ql.b(2);
            ql.a(System.currentTimeMillis());
            ql.c(PermissionGuideActivity.a(PermissionGuideActivity.this));
          }
          return;
        }
        catch (Throwable localThrowable) {}
      }
    };
    if (paramqm.e != null)
    {
      this.q = new Runnable()
      {
        public final void run()
        {
          if (paramqm.f != null) {
            PermissionGuideActivity.a(PermissionGuideActivity.this, parame, paramqm, paramArrayOfInt, paramIntent);
          }
        }
      };
      b(parame, paramqm, paramArrayOfInt, paramIntent);
    }
    else if (paramqm.f != null)
    {
      a(parame, paramqm, paramArrayOfInt, paramIntent);
    }
    else
    {
      paramIntent.a();
    }
    return true;
  }
  
  private void d()
  {
    if (this.i) {
      qm.a.a();
    }
    if (this.f == 2)
    {
      qm localqm = qm.a.a();
      Object localObject1;
      for (;;)
      {
        i1 = this.n;
        localObject1 = this.c;
        if ((i1 >= localObject1.length) || (anw.b(localObject1[i1]) != this.o)) {
          break;
        }
        if (localqm.c.a(this.c[this.n]) != 0)
        {
          i1 = 1;
          break label98;
        }
        this.n += 1;
      }
      int i1 = 0;
      label98:
      if (i1 == 0)
      {
        if ((!this.m.isEmpty()) && (((Integer)this.m.get(0)).intValue() == 5)) {
          ql.a(0L);
        }
        if (localqm.c.a(((Integer)this.m.get(0)).intValue()) == 2) {
          i1 = -1;
        } else {
          i1 = 1;
        }
        if (i1 == 1) {
          a(this.o, 271337);
        }
        qg.a(this, this.o, i1, this.d, 0, this.p);
        int i3 = this.n;
        localObject1 = null;
        i1 = 1;
        while (i3 < this.c.length)
        {
          int i4 = i1;
          Object localObject2 = localObject1;
          if (localqm.c.a(this.c[i3]) != 0)
          {
            this.l.add(Integer.valueOf(this.c[this.n]));
            int i2 = i1;
            if (i1 != 0) {
              i2 = 0;
            }
            if (localObject1 == null)
            {
              localObject2 = qk.a(this, this.c[i3]);
              this.m.clear();
              this.m.add(Integer.valueOf(this.c[i3]));
              this.n = i3;
              this.o = anw.b(this.c[i3]);
              i4 = i2;
            }
            else
            {
              i4 = i2;
              localObject2 = localObject1;
              if (anw.b(this.c[i3]) == this.o)
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
        if (!a((e)localObject1)) {
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
    qm localqm = qm.a.a();
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
      if (localqm.c.a(arrayOfInt1[i1]) != 0)
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
    this.q.run();
    this.q = null;
  }
  
  private void f()
  {
    finish();
    qm localqm = qm.a.a();
    asb localasb = (asb)localqm.h.get(Integer.valueOf(this.e));
    if (localasb != null)
    {
      localasb.a(null);
      localqm.h.remove(Integer.valueOf(this.e));
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
    qm localqm = qm.a.a();
    asb localasb = (asb)localqm.h.get(Integer.valueOf(this.e));
    if (localasb != null)
    {
      localasb.a(arrayOfInt);
      localqm.h.remove(Integer.valueOf(this.e));
    }
  }
  
  private void h()
  {
    finish();
    qm localqm = qm.a.a();
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
        if ((this.k.contains(Integer.valueOf(arrayOfInt[i1]))) && (localqm.c.a(this.c[i1]) == 2)) {
          localObject2[i1] = 0;
        } else {
          localObject2[i1] = localqm.c.a(this.c[i1]);
        }
        i1 += 1;
      }
    }
    Object localObject2 = localqm.b(this.c);
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
      ql.a(0L);
    }
    i1 = anw.b(((Integer)this.m.get(0)).intValue());
    if (i3 == 1) {
      a(i1, 271337);
    }
    Object localObject1 = localObject2;
    if (!this.h)
    {
      qg.a(this, i1, i3, this.d, 0, this.p);
      localObject1 = localObject2;
    }
    localObject2 = (asb)localqm.h.get(Integer.valueOf(this.e));
    if (localObject2 != null)
    {
      if (this.f != 2) {
        ((asb)localObject2).a((int[])localObject1);
      }
      localqm.h.remove(Integer.valueOf(this.e));
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
    asd.b.a().a().a();
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
    qm.a.a();
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