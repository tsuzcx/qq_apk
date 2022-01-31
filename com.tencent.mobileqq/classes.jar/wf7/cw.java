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
  private bj iH = null;
  private cy iI;
  
  private cw()
  {
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
  
  private void bv()
  {
    SparseArray localSparseArray = this.iD;
    int i = 4;
    for (;;)
    {
      if (i >= 1) {}
      try
      {
        Object localObject1 = (ArrayList)this.iD.get(i);
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ct localct = p((bn)((Iterator)localObject1).next());
            if (localct.L() == 24)
            {
              ((bl)localct.getData()).t(-1);
              ((Iterator)localObject1).remove();
            }
          }
        }
      }
      catch (Exception localException)
      {
        i -= 1;
        continue;
        return;
      }
      finally {}
    }
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
    for (;;)
    {
      bi localbi;
      synchronized (this.iE)
      {
        Iterator localIterator = this.iE.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localbi = (bi)localIterator.next();
        if (localbi == null) {
          continue;
        }
        if (paramBoolean) {
          localbi.G();
        }
      }
      localbi.H();
    }
  }
  
  private void o(bn parambn)
  {
    int m = parambn.ac().getLevel();
    ct localct = p(parambn);
    d locald = localct.R();
    int i;
    float f1;
    label402:
    float f2;
    label423:
    int k;
    if (ck.f(localct.L(), parambn.ab()))
    {
      if (locald != null) {}
      for (int j = locald.score; (j <= 0) || (j > 6); j = 0)
      {
        i = 1;
        f1 = 1.0F;
        ((bl)localct.getData()).u(i);
        ((bl)localct.getData()).a(f1);
        return;
      }
      if ((this.iF != null) && (this.iF.ap))
      {
        double d1 = Math.min(1.0F, Math.max(0.0F, j / 6.0F));
        double d2 = Math.min(1.0F, Math.max(0.0F, m / 100.0F));
        double d3 = this.iF.aq;
        double d4 = this.iF.ar;
        double d5 = this.iF.as;
        double d6 = this.iF.at;
        double d7 = this.iF.au;
        d1 = 1.0D / (Math.pow(2.718281828459045D, -(d1 * this.iF.av * d2 * d2 + (d3 + d4 * d1 + d5 * d2 + d6 * d1 * d2 + d7 * d1 * d1 * d2))) + 1.0D);
        d2 = this.iF.aw;
        d3 = this.iF.ax;
        d4 = this.iF.ay;
        d5 = this.iF.az;
        d6 = this.iF.aA;
        if (d1 <= d2) {
          i = 1;
        }
        for (;;)
        {
          f1 = (float)(d1 * 6.0D);
          break;
          if (d1 <= d3) {
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
        }
      }
      if (locald.Q > 0.0F)
      {
        f1 = locald.Q / 10.0F;
        if (locald.R <= 0.0F) {
          break label488;
        }
        f2 = locald.R / 10.0F;
        k = 1;
        if ((m < 0) || (m >= 30)) {
          break label496;
        }
        i = 1;
        label441:
        float f3 = i;
        f1 = j * f2 + f1 * f3;
        if ((0.0F >= f1) || (f1 > 1.0F)) {
          break label605;
        }
        i = 1;
      }
    }
    for (;;)
    {
      break;
      f1 = 0.6F;
      break label402;
      label488:
      f2 = 0.4F;
      break label423;
      label496:
      if ((30 <= m) && (m < 50))
      {
        i = 2;
        break label441;
      }
      if ((50 <= m) && (m < 70))
      {
        i = 3;
        break label441;
      }
      if ((70 <= m) && (m < 80))
      {
        i = 4;
        break label441;
      }
      if ((80 <= m) && (m < 90))
      {
        i = 5;
        break label441;
      }
      i = k;
      if (90 > m) {
        break label441;
      }
      i = k;
      if (m > 100) {
        break label441;
      }
      i = 6;
      break label441;
      label605:
      if ((1.0F < f1) && (f1 <= 2.0F))
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
      else
      {
        if ((5.0F < f1) && (f1 <= 6.0F))
        {
          i = 6;
          continue;
          i = 0;
          f1 = 0.0F;
          break;
        }
        i = 0;
      }
    }
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
      if (localIterator.hasNext()) {
        ((bi)localIterator.next()).b(parambn);
      }
    }
  }
  
  public List<bn> V(int paramInt)
  {
    Object localObject = new ArrayList();
    if (paramInt <= 0) {
      return localObject;
    }
    ((bq)ao.c().i(1)).a(new cw.9(this, (List)localObject));
    try
    {
      Collections.sort((List)localObject, new bn.c());
      if (((List)localObject).size() > 0) {
        if (((List)localObject).size() > paramInt)
        {
          localObject = ((List)localObject).subList(0, paramInt);
          return localObject;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        continue;
        paramInt = ((List)localObject).size();
      }
    }
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
    boolean bool5 = true;
    bn localbn2;
    int i;
    int k;
    int m;
    for (;;)
    {
      synchronized (this.iD)
      {
        localbn2 = r(2, 5);
        this.iD.clear();
        Object localObject3 = new ArrayList();
        ((bq)ao.c().i(1)).a(new cw.3(this, (ArrayList)localObject3));
        i = ((ArrayList)localObject3).size();
        if (i <= 0) {
          break label349;
        }
        try
        {
          Collections.sort((List)localObject3, new bn.b());
          Object localObject1 = null;
          this.iD.put(1, localObject3);
          Iterator localIterator = ((ArrayList)localObject3).iterator();
          j = 0;
          i = 0;
          if (!localIterator.hasNext()) {
            break label337;
          }
          localObject3 = (bn)localIterator.next();
          if (localObject3 == null) {
            continue;
          }
          ct localct = p((bn)localObject3);
          k = j;
          m = i;
          if (cu.bf().i((bn)localObject3))
          {
            a(2, (bn)localObject3);
            ((bl)localct.getData()).t(2);
            if (localct.L() == 24)
            {
              k = 1;
              k = j | k;
              if (localct.L() == 24) {
                break;
              }
              j = 1;
              break label475;
            }
          }
          else
          {
            label207:
            if (cu.bf().j((bn)localObject3))
            {
              a(3, (bn)localObject3);
              ((bl)localct.getData()).t(3);
            }
            if (cu.bf().k((bn)localObject3))
            {
              a(4, (bn)localObject3);
              ((bl)localct.getData()).t(4);
            }
            if ((localObject1 != null) || (!cu.bf().m((bn)localObject3))) {
              break label472;
            }
            a(5, (bn)localObject3);
            ((bl)localct.getData()).t(5);
            localObject1 = localObject3;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          continue;
        }
      }
      k = 0;
    }
    int j = 0;
    break label475;
    label337:
    if ((j != 0) && (i != 0)) {
      bv();
    }
    label349:
    bn localbn1 = r(2, 5);
    boolean bool1;
    label373:
    boolean bool3;
    if ((localbn2 == null) && (localbn1 != null))
    {
      bool1 = true;
      break label491;
      if ((localbn2 == null) || (localbn1 == null) || (localbn1.Y() == localbn2.Y())) {
        break label545;
      }
      bool3 = true;
    }
    for (;;)
    {
      label402:
      boolean bool2;
      if ((!bool1) && (!bool2) && (!bool3) && (!bool4) && (!bool5)) {
        return;
      }
      bz.av().u().v().a(new cw.4(this, bool1, bool2, bool3, localbn1, bool4, bool5), "refreshFreeWifi callback");
      return;
      label472:
      break label483;
      label475:
      m = j | i;
      break label207;
      label483:
      j = k;
      i = m;
      break;
      label491:
      if ((localbn2 != null) && (localbn1 == null))
      {
        bool2 = true;
        break label373;
        label507:
        if ((localbn2 != null) || (localbn1 == null)) {
          break label551;
        }
      }
      label545:
      label551:
      for (boolean bool4 = true;; bool4 = false)
      {
        if ((localbn2 == null) || (localbn1 != null)) {
          break label557;
        }
        break label402;
        bool1 = false;
        break label491;
        bool2 = false;
        break;
        bool3 = false;
        break label507;
      }
      label557:
      bool5 = false;
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
    //   8: getfield 39	wf7/cw:iD	Landroid/util/SparseArray;
    //   11: astore_3
    //   12: aload_3
    //   13: monitorenter
    //   14: iload_2
    //   15: iload_1
    //   16: if_icmplt +61 -> 77
    //   19: aload_0
    //   20: getfield 39	wf7/cw:iD	Landroid/util/SparseArray;
    //   23: iload_2
    //   24: invokevirtual 97	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   27: checkcast 41	java/util/ArrayList
    //   30: astore 4
    //   32: aload 4
    //   34: ifnull +36 -> 70
    //   37: aload 4
    //   39: invokevirtual 171	java/util/ArrayList:size	()I
    //   42: ifle +28 -> 70
    //   45: aload 4
    //   47: iconst_0
    //   48: invokevirtual 481	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   51: checkcast 110	wf7/bn
    //   54: astore 4
    //   56: aload_3
    //   57: monitorexit
    //   58: aload 4
    //   60: areturn
    //   61: astore 4
    //   63: aload_3
    //   64: monitorexit
    //   65: aload 4
    //   67: athrow
    //   68: astore 4
    //   70: iload_2
    //   71: iconst_1
    //   72: isub
    //   73: istore_2
    //   74: goto -60 -> 14
    //   77: aload_3
    //   78: monitorexit
    //   79: aconst_null
    //   80: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	cw
    //   0	81	1	paramInt1	int
    //   0	81	2	paramInt2	int
    //   11	67	3	localSparseArray	SparseArray
    //   30	29	4	localObject1	Object
    //   61	5	4	localObject2	Object
    //   68	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   19	32	61	finally
    //   37	56	61	finally
    //   56	58	61	finally
    //   63	65	61	finally
    //   77	79	61	finally
    //   19	32	68	java/lang/Exception
    //   37	56	68	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.cw
 * JD-Core Version:    0.7.0.1
 */