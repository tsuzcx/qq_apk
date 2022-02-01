package com.tencent.qmsp.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qmsp.sdk.a.c;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.f.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class k
{
  private static final byte[][] i;
  private static k j;
  private ConcurrentHashMap<Integer, f> a = new ConcurrentHashMap();
  private CopyOnWriteArrayList<f> b = new CopyOnWriteArrayList();
  private j c = new j();
  private g d;
  private Handler e = new g(com.tencent.qmsp.sdk.app.b.e().c());
  private boolean f = false;
  private boolean g = false;
  private CopyOnWriteArrayList<e> h = new CopyOnWriteArrayList();
  
  static
  {
    byte[] arrayOfByte1 = { 44, 116 };
    byte[] arrayOfByte2 = { 35, 124, -78, 71 };
    byte[] arrayOfByte3 = { 40, 127, -73, 69 };
    byte[] arrayOfByte4 = { 51, 117, -95 };
    byte[] arrayOfByte5 = { 20, 65, -125, 82, 33, 47, 114, -2, 49, 62, -126, 125, -96, 80 };
    i = new byte[][] { arrayOfByte1, { 49, 105, -93, 69 }, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, { 20, 125, -96, 80, 29, 11 } };
  }
  
  private f a(j.a parama)
  {
    f localf = new f(null);
    localf.a = parama.a;
    localf.b = parama.b;
    localf.c = parama.c;
    localf.h = parama.e;
    localf.g = parama.d;
    localf.e = 4;
    return localf;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Notify listener [%d:%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      locale.a(paramInt1, paramInt2);
    }
  }
  
  private void a(f paramf)
  {
    this.b.add(paramf);
  }
  
  private void a(f paramf, String paramString1, String paramString2)
  {
    e(paramf);
    if (paramf.e == 4)
    {
      String str = paramf.h;
      if ((str != null) && (!str.equals(paramString2)))
      {
        d.a(paramf.h, false);
        paramf.h = paramString2;
      }
      paramString2 = paramf.g;
      if ((paramString2 != null) && (!paramString2.equals(paramString1))) {
        paramf.g = paramString1;
      }
      paramf.f = 0;
      d(paramf);
      a(paramf);
    }
  }
  
  private void a(List<j.a> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (j.a)paramList.next();
      this.c.a(((j.a)localObject).a, false);
      localObject = ((j.a)localObject).e;
      if (localObject != null) {
        d.a((String)localObject, false);
      }
    }
    this.c.a();
  }
  
  private static String b(int paramInt)
  {
    return com.tencent.qmsp.sdk.f.k.a(i[paramInt]);
  }
  
  private void b(f paramf)
  {
    try
    {
      com.tencent.qmsp.sdk.a.g localg = new com.tencent.qmsp.sdk.a.g();
      localg.a(paramf.a).a(paramf.g).a(paramf.d);
      com.tencent.qmsp.sdk.a.f.a(localg.toString(), 3);
      return;
    }
    catch (Exception paramf)
    {
      paramf.printStackTrace();
    }
  }
  
  private void b(List<Pair<Integer, Integer>> paramList)
  {
    if ((paramList == null) || (!this.f)) {}
    LinkedList localLinkedList;
    do
    {
      return;
      localLinkedList = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (Pair)paramList.next();
        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("cb changed: id(%d), cb(%d)", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second }));
        Object localObject2 = (f)this.a.get(((Pair)localObject1).first);
        if (localObject2 == null)
        {
          localObject2 = this.c.a(((Integer)((Pair)localObject1).first).intValue());
          if (localObject2 != null) {
            if (((Integer)((Pair)localObject1).second).intValue() == 1) {
              c(a((j.a)localObject2));
            } else if (((Integer)((Pair)localObject1).second).intValue() == 2) {
              localLinkedList.add(localObject2);
            }
          }
        }
        else if (((Integer)((Pair)localObject1).second).intValue() == 1)
        {
          if (((f)localObject2).e == 4)
          {
            d((f)localObject2);
            if (((f)localObject2).d != 0) {
              this.a.remove(Integer.valueOf(((f)localObject2).a));
            }
            a((f)localObject2);
          }
        }
        else if ((((Integer)((Pair)localObject1).second).intValue() == 2) && (((f)localObject2).e == 4))
        {
          this.a.remove(((Pair)localObject1).first);
          localObject1 = this.c.a(((Integer)((Pair)localObject1).first).intValue());
          if (localObject1 != null) {
            localLinkedList.add(localObject1);
          }
        }
      }
    } while (localLinkedList.isEmpty());
    a(localLinkedList);
  }
  
  private void c(e parame)
  {
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((f)localEntry.getValue()).e == 1)
      {
        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Notify listener [%d:%d]", new Object[] { Integer.valueOf(1), localEntry.getKey() }));
        parame.a(1, ((Integer)localEntry.getKey()).intValue());
      }
    }
  }
  
  private void c(f paramf)
  {
    d(paramf);
    if (paramf.d == 0)
    {
      this.a.put(Integer.valueOf(paramf.a), paramf);
      a(1, paramf.a);
    }
    a(paramf);
  }
  
  private void d()
  {
    com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, "addLostUpgradeLibs");
    new h(new i(null)).a(1);
  }
  
  private void d(f paramf)
  {
    paramf.e = 2;
    Object localObject = new k.b(this);
    ((k.b)localObject).a = paramf;
    new a(String.format("Lib%d_%s", new Object[] { Integer.valueOf(paramf.a), paramf.g }), 43200000L).a((a.a)localObject);
    String str = paramf.h;
    localObject = str;
    if (str == null) {
      localObject = "null";
    }
    com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("load: %s ver: %s error: %08X", new Object[] { localObject, c.a(paramf.f), Integer.valueOf(paramf.d) }));
    if (paramf.d == 0) {}
    for (int k = 1;; k = 4)
    {
      paramf.e = k;
      return;
    }
  }
  
  public static k e()
  {
    if (j == null) {}
    try
    {
      if (j == null) {
        j = new k();
      }
      return j;
    }
    finally {}
  }
  
  private void e(f paramf)
  {
    com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Prepare to unload: %d,%d,%d,%d,%s,%s", new Object[] { Integer.valueOf(paramf.a), Integer.valueOf(paramf.b), Integer.valueOf(paramf.c), Integer.valueOf(paramf.e), paramf.g, paramf.h }));
    if ((paramf.c & 0x1) == 0) {}
    while (paramf.e != 1) {
      return;
    }
    paramf.e = 3;
    paramf.i.c();
    int k = f.a(3L, paramf.a, 0L, 0L, null, null, null, null);
    com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Unload ret: %d", new Object[] { Integer.valueOf(k) }));
    if (k == 0)
    {
      paramf.e = 4;
      a(2, paramf.a);
      return;
    }
    paramf.e = 5;
    paramf.d = k;
  }
  
  private void f()
  {
    Object localObject = this.c.b();
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((List)localObject).iterator();
    label43:
    label224:
    label250:
    for (;;)
    {
      j.a locala;
      int k;
      if (localIterator.hasNext())
      {
        locala = (j.a)localIterator.next();
        k = this.d.a(locala.a);
        int m = locala.a;
        int n = locala.b;
        int i1 = locala.c;
        String str2 = locala.d;
        String str1 = locala.e;
        localObject = str1;
        if (str1 == null) {
          localObject = "null";
        }
        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("%d,%d,%d,%s,%s,%d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), str2, localObject, Integer.valueOf(k) }));
        if ((k == 0) || (-1 == k)) {
          continue;
        }
        if (2 != k) {
          break label224;
        }
        localLinkedList.add(locala);
      }
      for (;;)
      {
        if (localLinkedList.isEmpty()) {
          break label250;
        }
        a(localLinkedList);
        break label43;
        break;
        if (1 == k)
        {
          localObject = a(locala);
          c((f)localObject);
          a((f)localObject);
        }
      }
    }
  }
  
  private void g()
  {
    if (!this.f)
    {
      this.g = true;
      return;
    }
    this.g = false;
    new h(new k.c(this)).a(1);
  }
  
  private void h()
  {
    com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, "onLoadLocalLibs");
    if (this.f) {
      return;
    }
    this.f = true;
    d();
    f();
    if (this.g) {
      b();
    }
    j();
  }
  
  private void i()
  {
    SharedPreferences localSharedPreferences = QmspSDK.getContext().getSharedPreferences(b.a + b(6), 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    long l1 = 28800000L;
    long l2 = l1;
    try
    {
      Iterator localIterator = this.b.iterator();
      for (;;)
      {
        l2 = l1;
        if (!localIterator.hasNext()) {
          break;
        }
        l2 = l1;
        f localf = (f)localIterator.next();
        l2 = l1;
        String str1 = localf.g;
        l2 = l1;
        if (localf.f != 0)
        {
          l2 = l1;
          str1 = c.a(localf.f);
        }
        l2 = l1;
        String str2 = String.format("Lib%d_%s_%s", new Object[] { Integer.valueOf(localf.a), QmspSDK.getUid(), str1 });
        l2 = l1;
        String str3 = String.format("Lib%d_%s_%s_lpt", new Object[] { Integer.valueOf(localf.a), QmspSDK.getUid(), str1 });
        l2 = l1;
        int k = localSharedPreferences.getInt(str2, -1);
        l2 = l1;
        long l3 = localSharedPreferences.getLong(str3, 0L);
        l2 = l1;
        l3 = System.currentTimeMillis() - l3;
        if (l3 < 28800000L)
        {
          l2 = l1;
          int m = localf.d;
          if (m == k)
          {
            l2 = l1;
            com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Ignore rp for: %d,%08X,%s", new Object[] { Integer.valueOf(localf.a), Integer.valueOf(localf.d), str1 }));
            l2 = 28800000L - l3;
            if (l1 <= l2) {
              continue;
            }
            l1 = l2;
            continue;
          }
        }
        l2 = l1;
        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Rp: %d,%d,%s", new Object[] { Integer.valueOf(localf.a), Integer.valueOf(localf.d), str1 }));
        l2 = l1;
        localEditor.putInt(str2, localf.d);
        l2 = l1;
        localEditor.putLong(str3, System.currentTimeMillis());
        l2 = l1;
        b(localf);
        l2 = l1;
        this.b.remove(localf);
      }
      localEditor.commit();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, "next rp interval: " + l2);
      f.i().c().postDelayed(new k.d(this), l2);
      return;
      l2 = l1;
    }
  }
  
  private void j()
  {
    Handler localHandler = this.e;
    localHandler.sendMessage(localHandler.obtainMessage(4));
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    f localf = (f)this.a.get(Integer.valueOf(paramInt1));
    if (localf == null) {
      if (this.c.a(paramInt1) == null) {
        paramInt2 = 4;
      }
    }
    for (;;)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("dispatch to id: %d, cmd: %d, err: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) }));
      return paramInt2;
      paramInt2 = 17;
      continue;
      if ((paramInt2 != 0) && (paramInt2 != localf.f))
      {
        paramInt2 = 32;
      }
      else if (localf.a != paramInt1)
      {
        paramInt2 = 5;
      }
      else
      {
        int k = this.d.a(paramInt1);
        if ((1 != k) && (k != -1))
        {
          paramInt2 = 6;
        }
        else
        {
          if (localf.e != 1) {}
          while (!localf.i.a())
          {
            paramInt2 = 7;
            break;
          }
          paramInt2 = f.a(4L, localf.a, paramInt2, paramInt3, null, null, paramArrayOfObject1, paramArrayOfObject2);
          localf.i.b();
        }
      }
    }
  }
  
  public void a()
  {
    try
    {
      if (this.a != null)
      {
        Iterator localIterator = this.a.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          ((f)localEntry.getValue()).c = 1;
          e((f)localEntry.getValue());
        }
      }
      while (j == null) {}
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    j = null;
  }
  
  public void a(g paramg)
  {
    this.d = paramg;
    this.d.a(new k.a(this));
  }
  
  public void a(e parame)
  {
    this.h.add(parame);
    Handler localHandler = this.e;
    localHandler.sendMessage(localHandler.obtainMessage(5, parame));
  }
  
  public void b()
  {
    Handler localHandler = this.e;
    localHandler.sendMessage(localHandler.obtainMessage(1));
  }
  
  public void b(e parame)
  {
    this.h.remove(parame);
  }
  
  public void c()
  {
    com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("OnEveryLogin mHasLoadLocal = %b", new Object[] { Boolean.valueOf(this.f) }));
    if (!this.f)
    {
      Handler localHandler = this.e;
      localHandler.sendMessage(localHandler.obtainMessage(3));
    }
  }
  
  public static abstract interface e
  {
    public abstract void a(int paramInt1, int paramInt2);
  }
  
  static class f
  {
    public int a;
    public int b;
    public int c;
    public int d = -1;
    public int e;
    public int f;
    public String g = "";
    public String h = "";
    public o i;
  }
  
  class g
    extends Handler
  {
    public g(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
      case 5: 
      case 4: 
      case 3: 
      case 2: 
        do
        {
          do
          {
            return;
            paramMessage = paramMessage.obj;
          } while (paramMessage == null);
          k.a(k.this, (k.e)paramMessage);
          return;
          k.d(k.this);
          return;
          k.c(k.this);
          return;
          paramMessage = paramMessage.obj;
        } while (paramMessage == null);
        k.a(k.this, (List)paramMessage);
        return;
      }
      k.a(k.this);
    }
  }
  
  static class h
  {
    private k.i a;
    
    public h(k.i parami)
    {
      this.a = parami;
    }
    
    /* Error */
    public void a(int paramInt)
    {
      // Byte code:
      //   0: ldc 22
      //   2: iconst_1
      //   3: ldc 24
      //   5: iconst_1
      //   6: anewarray 4	java/lang/Object
      //   9: dup
      //   10: iconst_0
      //   11: iload_1
      //   12: invokestatic 30	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   15: aastore
      //   16: invokestatic 36	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   19: invokestatic 41	com/tencent/qmsp/sdk/f/g:a	(Ljava/lang/String;ILjava/lang/String;)V
      //   22: new 43	com/tencent/qmsp/sdk/d/b
      //   25: dup
      //   26: invokespecial 44	com/tencent/qmsp/sdk/d/b:<init>	()V
      //   29: lconst_1
      //   30: invokevirtual 47	com/tencent/qmsp/sdk/d/b:a	(J)Ljava/util/List;
      //   33: astore 6
      //   35: aload 6
      //   37: ifnull +302 -> 339
      //   40: ldc 22
      //   42: iconst_1
      //   43: ldc 49
      //   45: iconst_1
      //   46: anewarray 4	java/lang/Object
      //   49: dup
      //   50: iconst_0
      //   51: aload 6
      //   53: invokeinterface 55 1 0
      //   58: invokestatic 30	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   61: aastore
      //   62: invokestatic 36	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   65: invokestatic 41	com/tencent/qmsp/sdk/f/g:a	(Ljava/lang/String;ILjava/lang/String;)V
      //   68: aload 6
      //   70: invokeinterface 59 1 0
      //   75: astore 7
      //   77: aload 7
      //   79: invokeinterface 65 1 0
      //   84: ifeq +255 -> 339
      //   87: aload 7
      //   89: invokeinterface 69 1 0
      //   94: checkcast 71	com/tencent/qmsp/sdk/d/d$b
      //   97: astore 6
      //   99: aload 6
      //   101: getfield 75	com/tencent/qmsp/sdk/d/d$b:b	J
      //   104: iload_1
      //   105: i2l
      //   106: lcmp
      //   107: ifne -30 -> 77
      //   110: aload 6
      //   112: getfield 79	com/tencent/qmsp/sdk/d/d$b:o	Ljava/util/List;
      //   115: ifnull -38 -> 77
      //   118: aload 6
      //   120: getfield 79	com/tencent/qmsp/sdk/d/d$b:o	Ljava/util/List;
      //   123: invokeinterface 59 1 0
      //   128: astore 8
      //   130: aload 8
      //   132: invokeinterface 65 1 0
      //   137: ifeq -60 -> 77
      //   140: aload 8
      //   142: invokeinterface 69 1 0
      //   147: checkcast 81	com/tencent/qmsp/sdk/d/d$a
      //   150: astore 9
      //   152: aload 9
      //   154: getfield 85	com/tencent/qmsp/sdk/d/d$a:i	Ljava/lang/String;
      //   157: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   160: ifne -30 -> 130
      //   163: aload 9
      //   165: getfield 94	com/tencent/qmsp/sdk/d/d$a:f	Ljava/lang/String;
      //   168: astore 6
      //   170: aload 9
      //   172: getfield 97	com/tencent/qmsp/sdk/d/d$a:g	Ljava/lang/String;
      //   175: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   178: ifne +10 -> 188
      //   181: aload 9
      //   183: getfield 97	com/tencent/qmsp/sdk/d/d$a:g	Ljava/lang/String;
      //   186: astore 6
      //   188: aload 6
      //   190: ifnull -60 -> 130
      //   193: ldc 22
      //   195: iconst_1
      //   196: ldc 99
      //   198: iconst_2
      //   199: anewarray 4	java/lang/Object
      //   202: dup
      //   203: iconst_0
      //   204: aload 9
      //   206: getfield 85	com/tencent/qmsp/sdk/d/d$a:i	Ljava/lang/String;
      //   209: aastore
      //   210: dup
      //   211: iconst_1
      //   212: aload 6
      //   214: aastore
      //   215: invokestatic 36	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   218: invokestatic 41	com/tencent/qmsp/sdk/f/g:a	(Ljava/lang/String;ILjava/lang/String;)V
      //   221: new 101	org/json/JSONObject
      //   224: dup
      //   225: aload 9
      //   227: getfield 85	com/tencent/qmsp/sdk/d/d$a:i	Ljava/lang/String;
      //   230: invokespecial 104	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   233: astore 9
      //   235: aload 9
      //   237: iconst_0
      //   238: invokestatic 107	com/tencent/qmsp/sdk/c/k:a	(I)Ljava/lang/String;
      //   241: invokevirtual 111	org/json/JSONObject:getInt	(Ljava/lang/String;)I
      //   244: istore_2
      //   245: aload 9
      //   247: iconst_1
      //   248: invokestatic 107	com/tencent/qmsp/sdk/c/k:a	(I)Ljava/lang/String;
      //   251: invokevirtual 111	org/json/JSONObject:getInt	(Ljava/lang/String;)I
      //   254: istore_3
      //   255: aload 9
      //   257: iconst_2
      //   258: invokestatic 107	com/tencent/qmsp/sdk/c/k:a	(I)Ljava/lang/String;
      //   261: invokevirtual 111	org/json/JSONObject:getInt	(Ljava/lang/String;)I
      //   264: istore 4
      //   266: aload 9
      //   268: iconst_3
      //   269: invokestatic 107	com/tencent/qmsp/sdk/c/k:a	(I)Ljava/lang/String;
      //   272: invokevirtual 111	org/json/JSONObject:getInt	(Ljava/lang/String;)I
      //   275: istore 5
      //   277: aload 9
      //   279: iconst_4
      //   280: invokestatic 107	com/tencent/qmsp/sdk/c/k:a	(I)Ljava/lang/String;
      //   283: invokevirtual 115	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   286: astore 9
      //   288: aload_0
      //   289: getfield 16	com/tencent/qmsp/sdk/c/k$h:a	Lcom/tencent/qmsp/sdk/c/k$i;
      //   292: ifnull -162 -> 130
      //   295: aload_0
      //   296: getfield 16	com/tencent/qmsp/sdk/c/k$h:a	Lcom/tencent/qmsp/sdk/c/k$i;
      //   299: aload 6
      //   301: aload 9
      //   303: iload_2
      //   304: iload_3
      //   305: iload 4
      //   307: iload 5
      //   309: invokevirtual 120	com/tencent/qmsp/sdk/c/k$i:a	(Ljava/lang/String;Ljava/lang/String;IIII)V
      //   312: goto -182 -> 130
      //   315: astore 6
      //   317: aload 6
      //   319: invokevirtual 123	java/lang/Exception:printStackTrace	()V
      //   322: aload_0
      //   323: getfield 16	com/tencent/qmsp/sdk/c/k$h:a	Lcom/tencent/qmsp/sdk/c/k$i;
      //   326: astore 6
      //   328: aload 6
      //   330: ifnull +8 -> 338
      //   333: aload 6
      //   335: invokevirtual 125	com/tencent/qmsp/sdk/c/k$i:a	()V
      //   338: return
      //   339: aload_0
      //   340: getfield 16	com/tencent/qmsp/sdk/c/k$h:a	Lcom/tencent/qmsp/sdk/c/k$i;
      //   343: astore 6
      //   345: aload 6
      //   347: ifnull -9 -> 338
      //   350: goto -17 -> 333
      //   353: astore 6
      //   355: aload_0
      //   356: getfield 16	com/tencent/qmsp/sdk/c/k$h:a	Lcom/tencent/qmsp/sdk/c/k$i;
      //   359: astore 7
      //   361: aload 7
      //   363: ifnull +8 -> 371
      //   366: aload 7
      //   368: invokevirtual 125	com/tencent/qmsp/sdk/c/k$i:a	()V
      //   371: aload 6
      //   373: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	374	0	this	h
      //   0	374	1	paramInt	int
      //   244	60	2	i	int
      //   254	51	3	j	int
      //   264	42	4	k	int
      //   275	33	5	m	int
      //   33	267	6	localObject1	Object
      //   315	3	6	localException	Exception
      //   326	20	6	locali	k.i
      //   353	19	6	localObject2	Object
      //   75	292	7	localObject3	Object
      //   128	13	8	localIterator	Iterator
      //   150	152	9	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   22	35	315	java/lang/Exception
      //   40	77	315	java/lang/Exception
      //   77	130	315	java/lang/Exception
      //   130	170	315	java/lang/Exception
      //   170	188	315	java/lang/Exception
      //   193	312	315	java/lang/Exception
      //   22	35	353	finally
      //   40	77	353	finally
      //   77	130	353	finally
      //   130	170	353	finally
      //   170	188	353	finally
      //   193	312	353	finally
      //   317	322	353	finally
    }
  }
  
  class i
  {
    protected boolean a = false;
    
    private i() {}
    
    public void a()
    {
      if (this.a) {
        k.f(k.this).a();
      }
    }
    
    public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("visitQSecSFUItem libPath = %s libVer = %s libId = %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1) }));
      if (TextUtils.isEmpty(paramString2)) {}
      j.a locala;
      do
      {
        return;
        locala = k.f(k.this).a(paramInt1);
      } while ((locala != null) && (paramString1.equals(locala.e)) && (paramString2.equals(locala.d)) && (paramInt2 == locala.b) && (paramInt3 == locala.c));
      if (locala == null) {
        locala = new j.a();
      }
      for (;;)
      {
        locala.a = paramInt1;
        locala.b = paramInt2;
        locala.c = paramInt3;
        locala.e = paramString1;
        locala.d = paramString2;
        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Add lost lib: %d,%d,%d,%s", new Object[] { Integer.valueOf(locala.a), Integer.valueOf(locala.b), Integer.valueOf(locala.c), locala.e }));
        k.f(k.this).a(locala, false);
        this.a = true;
        return;
        k.f(k.this).a(paramInt1, false);
        com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Database info mismatch for lib: %d", new Object[] { Integer.valueOf(paramInt1) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.k
 * JD-Core Version:    0.7.0.1
 */