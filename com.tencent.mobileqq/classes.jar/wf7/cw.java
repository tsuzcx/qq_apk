package wf7;

import android.util.SparseArray;
import com.tencent.qqpimsecure.wificore.api.event.b;
import com.tencent.qqpimsecure.wificore.api.recognize.monitor.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class cw
  implements bk
{
  private static String iB = "QOS";
  private bm iC;
  private final SparseArray<ArrayList<bn>> iD = new SparseArray();
  private final ArrayList<bi> iE = new ArrayList();
  private g iF;
  private final cx iG = new cx();
  private bj iH;
  private cy iI;
  
  private cw()
  {
    g localg = null;
    this.iH = null;
    bq();
    String str = ch.aP().getString("p_s_c", null);
    if (str != null) {
      localg = (g)df.a(str.getBytes(), new g(), true);
    }
    this.iF = localg;
    this.iI = new cy();
  }
  
  private void a(int paramInt, bn parambn)
  {
    ArrayList localArrayList2 = (ArrayList)this.iD.get(paramInt);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      this.iD.put(paramInt, localArrayList1);
    }
    localArrayList1.add(parambn);
  }
  
  public static void a(bn parambn, ct paramct)
  {
    parambn.a(ct.class, paramct);
  }
  
  public static cw bo()
  {
    return cw.a.iV;
  }
  
  private void bq()
  {
    ax localax = bz.av().u().w();
    localax.q(13713);
    localax.a(13713, new g(), new cw.8(this));
  }
  
  /* Error */
  private void bv()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	wf7/cw:iD	Landroid/util/SparseArray;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: iconst_4
    //   8: istore_1
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmplt +92 -> 103
    //   14: aload_0
    //   15: getfield 37	wf7/cw:iD	Landroid/util/SparseArray;
    //   18: iload_1
    //   19: invokevirtual 95	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   22: checkcast 39	java/util/ArrayList
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +69 -> 96
    //   30: aload_3
    //   31: invokevirtual 169	java/util/ArrayList:size	()I
    //   34: ifle +62 -> 96
    //   37: aload_3
    //   38: invokevirtual 173	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   41: astore_3
    //   42: aload_3
    //   43: invokeinterface 179 1 0
    //   48: ifeq +48 -> 96
    //   51: aload_3
    //   52: invokeinterface 183 1 0
    //   57: checkcast 108	wf7/bn
    //   60: invokestatic 187	wf7/cw:p	(Lwf7/bn;)Lwf7/ct;
    //   63: astore 4
    //   65: aload 4
    //   67: invokevirtual 190	wf7/ct:L	()I
    //   70: bipush 24
    //   72: if_icmpne -30 -> 42
    //   75: aload 4
    //   77: invokevirtual 193	wf7/ct:getData	()Ljava/lang/Object;
    //   80: checkcast 195	wf7/bl
    //   83: iconst_m1
    //   84: invokevirtual 198	wf7/bl:t	(I)V
    //   87: aload_3
    //   88: invokeinterface 201 1 0
    //   93: goto -51 -> 42
    //   96: iload_1
    //   97: iconst_1
    //   98: isub
    //   99: istore_1
    //   100: goto -91 -> 9
    //   103: aload_2
    //   104: monitorexit
    //   105: return
    //   106: astore_3
    //   107: aload_2
    //   108: monitorexit
    //   109: goto +5 -> 114
    //   112: aload_3
    //   113: athrow
    //   114: goto -2 -> 112
    //   117: astore_3
    //   118: goto -22 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	cw
    //   8	92	1	i	int
    //   4	104	2	localSparseArray	SparseArray
    //   25	63	3	localObject1	Object
    //   106	7	3	localObject2	Object
    //   117	1	3	localException	Exception
    //   63	13	4	localct	ct
    // Exception table:
    //   from	to	target	type
    //   14	26	106	finally
    //   30	42	106	finally
    //   42	93	106	finally
    //   103	105	106	finally
    //   107	109	106	finally
    //   14	26	117	java/lang/Exception
    //   30	42	117	java/lang/Exception
    //   42	93	117	java/lang/Exception
  }
  
  public static ct f(String paramString, int paramInt)
  {
    paramString = ((bq)ao.c().i(1)).a(paramString, paramInt);
    if (paramString == null) {
      return null;
    }
    return p(paramString);
  }
  
  private void g(boolean paramBoolean)
  {
    synchronized (this.iE)
    {
      Iterator localIterator = this.iE.iterator();
      while (localIterator.hasNext())
      {
        bi localbi = (bi)localIterator.next();
        if (localbi != null) {
          if (paramBoolean) {
            localbi.G();
          } else {
            localbi.H();
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void o(bn parambn)
  {
    int k = parambn.ac().getLevel();
    ct localct = p(parambn);
    d locald = localct.R();
    boolean bool = ck.f(localct.L(), parambn.ab());
    int i = 0;
    float f1 = 0.0F;
    if (bool)
    {
      int j;
      if (locald != null) {
        j = locald.score;
      } else {
        j = 0;
      }
      if ((j > 0) && (j <= 6))
      {
        parambn = this.iF;
        if ((parambn != null) && (parambn.ap))
        {
          double d1 = Math.min(1.0F, Math.max(0.0F, j / 6.0F));
          double d2 = Math.min(1.0F, Math.max(0.0F, k / 100.0F));
          double d3 = this.iF.aq;
          double d4 = this.iF.ar;
          double d5 = this.iF.as;
          double d6 = this.iF.at;
          double d7 = this.iF.au;
          double d8 = this.iF.av;
          Double.isNaN(d1);
          Double.isNaN(d2);
          Double.isNaN(d1);
          Double.isNaN(d2);
          Double.isNaN(d1);
          Double.isNaN(d1);
          Double.isNaN(d2);
          Double.isNaN(d1);
          Double.isNaN(d2);
          Double.isNaN(d2);
          d1 = 1.0D / (Math.pow(2.718281828459045D, -(d3 + d4 * d1 + d5 * d2 + d6 * d1 * d2 + d7 * d1 * d1 * d2 + d8 * d1 * d2 * d2)) + 1.0D);
          d2 = this.iF.aw;
          d3 = this.iF.ax;
          d4 = this.iF.ay;
          d5 = this.iF.az;
          d6 = this.iF.aA;
          if (d1 <= d2) {
            i = 1;
          } else if (d1 <= d3) {
            i = 2;
          } else if (d1 <= d4) {
            i = 3;
          } else if (d1 <= d5) {
            i = 4;
          } else if (d1 <= d6) {
            i = 5;
          } else {
            i = 6;
          }
          f1 = (float)(d1 * 6.0D);
        }
      }
      for (;;)
      {
        break;
        if (locald.Q > 0.0F) {
          f1 = locald.Q / 10.0F;
        } else {
          f1 = 0.6F;
        }
        float f2;
        if (locald.R > 0.0F) {
          f2 = locald.R / 10.0F;
        } else {
          f2 = 0.4F;
        }
        if ((k >= 0) && (k < 30)) {}
        do
        {
          i = 1;
          break;
          if ((30 <= k) && (k < 50))
          {
            i = 2;
            break;
          }
          if ((50 <= k) && (k < 70))
          {
            i = 3;
            break;
          }
          if ((70 <= k) && (k < 80))
          {
            i = 4;
            break;
          }
          if ((80 <= k) && (k < 90))
          {
            i = 5;
            break;
          }
        } while ((90 > k) || (k > 100));
        i = 6;
        f1 = i * f1 + j * f2;
        if ((0.0F < f1) && (f1 <= 1.0F))
        {
          i = 1;
        }
        else if ((1.0F < f1) && (f1 <= 2.0F))
        {
          i = 2;
        }
        else if ((2.0F < f1) && (f1 <= 3.0F))
        {
          i = 3;
        }
        else if ((3.0F < f1) && (f1 <= 4.0F))
        {
          i = 4;
        }
        else if ((4.0F < f1) && (f1 <= 5.0F))
        {
          i = 5;
        }
        else if ((5.0F < f1) && (f1 <= 6.0F))
        {
          i = 6;
        }
        else
        {
          i = 0;
          continue;
          i = 1;
          f1 = 1.0F;
        }
      }
    }
    ((bl)localct.getData()).u(i);
    ((bl)localct.getData()).a(f1);
  }
  
  public static ct p(bn parambn)
  {
    ct localct2 = (ct)parambn.b(ct.class);
    ct localct1 = localct2;
    if (localct2 == null)
    {
      localct1 = new ct(parambn);
      a(parambn, localct1);
    }
    return localct1;
  }
  
  private void q(bn parambn)
  {
    synchronized (this.iE)
    {
      Iterator localIterator = this.iE.iterator();
      while (localIterator.hasNext()) {
        ((bi)localIterator.next()).b(parambn);
      }
      return;
    }
    for (;;)
    {
      throw parambn;
    }
  }
  
  public List<bn> V(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt <= 0) {
      return localArrayList;
    }
    ((bq)ao.c().i(1)).a(new cw.9(this, localArrayList));
    try
    {
      Collections.sort(localArrayList, new bn.c());
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    Object localObject = localArrayList;
    if (localArrayList.size() > 0)
    {
      if (localArrayList.size() <= paramInt) {
        paramInt = localArrayList.size();
      }
      localObject = localArrayList.subList(0, paramInt);
    }
    return localObject;
  }
  
  public void a() {}
  
  public void a(long paramLong, int paramInt, bh parambh)
  {
    bz.av().u().v().a(new cw.7(this, paramLong, paramInt, parambh), "wifi_startRecogniz");
  }
  
  public void a(bi parambi)
  {
    if (parambi != null) {
      synchronized (this.iE)
      {
        this.iE.add(parambi);
        return;
      }
    }
  }
  
  public void b() {}
  
  public void b(bi parambi)
  {
    synchronized (this.iE)
    {
      Iterator localIterator = this.iE.iterator();
      while (localIterator.hasNext()) {
        if ((bi)localIterator.next() == parambi) {
          localIterator.remove();
        }
      }
      return;
    }
    for (;;)
    {
      throw parambi;
    }
  }
  
  public bm bp()
  {
    if (this.iC == null) {
      this.iC = new bm();
    }
    return this.iC;
  }
  
  public a br()
  {
    return this.iI;
  }
  
  public bj bs()
  {
    return this.iH;
  }
  
  public void bt()
  {
    ((bq)ao.c().i(1)).a(new cw.2(this));
    bu();
  }
  
  protected void bu()
  {
    bn localbn2;
    int i;
    int j;
    int k;
    int m;
    boolean bool1;
    boolean bool3;
    boolean bool2;
    boolean bool4;
    boolean bool5;
    label486:
    label491:
    label493:
    label504:
    synchronized (this.iD)
    {
      localbn2 = r(2, 5);
      this.iD.clear();
      Object localObject1 = new ArrayList();
      ((bq)ao.c().i(1)).a(new cw.3(this, (ArrayList)localObject1));
      i = ((ArrayList)localObject1).size();
      if (i > 0)
      {
        try
        {
          Collections.sort((List)localObject1, new bn.b());
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        this.iD.put(1, localObject1);
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        localObject1 = null;
        j = 0;
        i = 0;
        while (localIterator.hasNext())
        {
          bn localbn1 = (bn)localIterator.next();
          if (localbn1 != null)
          {
            ct localct = p(localbn1);
            k = j;
            m = i;
            if (cu.bf().i(localbn1))
            {
              a(2, localbn1);
              ((bl)localct.getData()).t(2);
              if (localct.L() != 24) {
                break label486;
              }
              k = 1;
              k = j | k;
              if (localct.L() == 24) {
                break label491;
              }
              j = 1;
              break label493;
            }
            if (cu.bf().j(localbn1))
            {
              a(3, localbn1);
              ((bl)localct.getData()).t(3);
            }
            if (cu.bf().k(localbn1))
            {
              a(4, localbn1);
              ((bl)localct.getData()).t(4);
            }
            j = k;
            i = m;
            if (localObject1 == null)
            {
              j = k;
              i = m;
              if (cu.bf().m(localbn1))
              {
                a(5, localbn1);
                ((bl)localct.getData()).t(5);
                localObject1 = localbn1;
                j = k;
                i = m;
              }
            }
          }
        }
        if ((j != 0) && (i != 0)) {
          bv();
        }
      }
      localObject1 = r(2, 5);
      if ((localbn2 == null) && (localObject1 != null))
      {
        bool1 = true;
        break label504;
        if ((localbn2 == null) || (localObject1 == null) || (((bn)localObject1).Y() == localbn2.Y())) {
          break label526;
        }
        bool3 = true;
        break label529;
        if ((!bool1) && (!bool2) && (!bool3) && (!bool4) && (!bool5)) {
          return;
        }
        bz.av().u().v().a(new cw.4(this, bool1, bool2, bool3, (bn)localObject1, bool4, bool5), "refreshFreeWifi callback");
      }
    }
  }
  
  public bl c(bn parambn)
  {
    return (bl)p(parambn).getData();
  }
  
  public boolean d(bn parambn)
  {
    return ((bl)p(parambn).getData()).S();
  }
  
  public void onCreate()
  {
    ((bq)ao.c().i(1)).a(new cw.1(this));
    b localb = (b)ao.c().i(3);
    localb.a(new cw.5(this));
    localb.a(new cw.6(this));
  }
  
  /* Error */
  public bn r(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iload_1
    //   1: iload_2
    //   2: if_icmple +5 -> 7
    //   5: aconst_null
    //   6: areturn
    //   7: aload_0
    //   8: getfield 37	wf7/cw:iD	Landroid/util/SparseArray;
    //   11: astore_3
    //   12: aload_3
    //   13: monitorenter
    //   14: iload_2
    //   15: iload_1
    //   16: if_icmplt +45 -> 61
    //   19: aload_0
    //   20: getfield 37	wf7/cw:iD	Landroid/util/SparseArray;
    //   23: iload_2
    //   24: invokevirtual 95	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   27: checkcast 39	java/util/ArrayList
    //   30: astore 4
    //   32: aload 4
    //   34: ifnull +46 -> 80
    //   37: aload 4
    //   39: invokevirtual 169	java/util/ArrayList:size	()I
    //   42: ifle +38 -> 80
    //   45: aload 4
    //   47: iconst_0
    //   48: invokevirtual 485	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   51: checkcast 108	wf7/bn
    //   54: astore 4
    //   56: aload_3
    //   57: monitorexit
    //   58: aload 4
    //   60: areturn
    //   61: aload_3
    //   62: monitorexit
    //   63: aconst_null
    //   64: areturn
    //   65: astore 4
    //   67: aload_3
    //   68: monitorexit
    //   69: goto +6 -> 75
    //   72: aload 4
    //   74: athrow
    //   75: goto -3 -> 72
    //   78: astore 4
    //   80: iload_2
    //   81: iconst_1
    //   82: isub
    //   83: istore_2
    //   84: goto -70 -> 14
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	cw
    //   0	87	1	paramInt1	int
    //   0	87	2	paramInt2	int
    //   11	57	3	localSparseArray	SparseArray
    //   30	29	4	localObject1	Object
    //   65	8	4	localObject2	Object
    //   78	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   19	32	65	finally
    //   37	56	65	finally
    //   56	58	65	finally
    //   61	63	65	finally
    //   67	69	65	finally
    //   19	32	78	java/lang/Exception
    //   37	56	78	java/lang/Exception
  }
  
  public List<bn> s(int paramInt)
  {
    synchronized (this.iD)
    {
      ArrayList localArrayList = (ArrayList)this.iD.get(paramInt);
      if (localArrayList != null)
      {
        localArrayList = new ArrayList(localArrayList);
        return localArrayList;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.cw
 * JD-Core Version:    0.7.0.1
 */