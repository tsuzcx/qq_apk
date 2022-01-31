package wf7;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class em
{
  private dt li;
  private final Object lk = new Object();
  private Context mContext;
  private ep mS;
  private ej mT;
  private ef mU;
  private er mV;
  private em.d mW = null;
  private em.d mX = null;
  private ArrayList<em.d> mY = new ArrayList();
  private LinkedHashMap<Integer, em.d> mZ = new LinkedHashMap();
  private ExecutorService na;
  private boolean nb;
  private long nc = 0L;
  private boolean nd = false;
  private boolean ne = false;
  private long nf = 0L;
  private long ng = 0L;
  private em.b nh;
  private ep.a ni = new em.1(this);
  private Handler nj = new em.2(this, ea.getLooper());
  private long nk = 0L;
  private Handler nl = new em.3(this, ea.getLooper());
  
  public em(Context paramContext, dt paramdt, em.b paramb, em.c paramc, boolean paramBoolean, String paramString)
  {
    this.mContext = paramContext;
    this.li = paramdt;
    this.nh = paramb;
    this.mT = new ej(paramContext, this);
    this.mU = new ef(paramContext, this, paramBoolean);
    this.mV = new er(paramContext, this, paramBoolean);
    this.na = Executors.newSingleThreadExecutor();
    this.mS = new ep(this.li.bX(), paramContext, paramdt, paramBoolean, this.ni, paramc, this, paramString);
    if (this.li.bX())
    {
      a(paramc);
      this.mV.b(paramc);
      cQ();
      cR();
    }
  }
  
  private final ArrayList<ae> a(em.d paramd, boolean paramBoolean, af paramaf, ArrayList<ae> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    paramd = new ArrayList();
    int j = paramArrayList.size();
    int i = 0;
    if (i < j)
    {
      ae localae = (ae)paramArrayList.get(i);
      if (localae == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (!a(paramBoolean, paramaf, localae)) {
          paramd.add(localae);
        }
      }
    }
    return paramd;
  }
  
  private ed<Long, Integer, JceStruct> a(long paramLong, int paramInt, m paramm)
  {
    if (paramm == null) {
      return null;
    }
    Object localObject = this.mS.dc();
    if (localObject != null) {
      ((eu)localObject).a(paramLong, paramInt, paramm);
    }
    localObject = new l();
    ((l)localObject).aO = paramm.aO;
    return new ed(Long.valueOf(paramLong), Integer.valueOf(156), localObject);
  }
  
  private void a(em.c paramc)
  {
    em.4 local4 = new em.4(this);
    paramc.a(0L, 10155, new m(), 0, local4, false);
  }
  
  private void a(boolean paramBoolean, int paramInt, em.d arg3)
  {
    if (??? == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.mW != null) && (this.mW.nB == ???.nB))
    {
      localArrayList.add(this.mW);
      al(this.mW.nB);
    }
    for (;;)
    {
      ??? = localArrayList.iterator();
      while (???.hasNext()) {
        a(paramBoolean, (em.d)???.next(), paramInt, 0, null);
      }
      break;
      if ((this.mX != null) && (this.mX.nB == ???.nB))
      {
        localArrayList.add(this.mX);
        al(this.mX.nB);
        continue;
      }
      localArrayList.add(???);
      al(???.nB);
      synchronized (this.mY)
      {
        localArrayList.addAll(this.mY);
        this.mY.clear();
      }
    }
  }
  
  private void a(boolean paramBoolean, em.d paramd, int paramInt1, int paramInt2, ArrayList<ae> paramArrayList)
  {
    a(false, paramBoolean, paramd, paramInt1, paramInt2, paramArrayList);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    Object localObject1 = new ArrayList();
    synchronized (this.mZ)
    {
      ((ArrayList)localObject1).addAll(this.mZ.values());
      this.mZ.clear();
    }
    synchronized (this.mY)
    {
      ((ArrayList)localObject1).addAll(this.mY);
      this.mY.clear();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        a(paramBoolean1, (em.d)((Iterator)localObject1).next(), paramInt, 0, null);
        continue;
        localObject2 = finally;
        throw localObject2;
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, em.d paramd, int paramInt1, int paramInt2, ArrayList<ae> paramArrayList)
  {
    if ((paramd == null) || (paramBoolean1)) {}
    try
    {
      if ((paramd.nE == null) || (paramd.nE.size() <= 0)) {
        al(paramd.nB);
      }
      paramd.nF.a(paramBoolean2, paramInt1, paramInt2, paramArrayList);
      return;
    }
    catch (Exception paramd) {}
  }
  
  private boolean a(boolean paramBoolean, af paramaf, ae paramae)
  {
    if (paramae == null) {
      return false;
    }
    StringBuilder localStringBuilder;
    Object localObject;
    if (eo.b(paramae))
    {
      this.nh.a(paramBoolean, paramaf.bZ, paramae);
      localStringBuilder = new StringBuilder().append("[ocean]guid|").append(this.mU.cC()).append("|push|通道|");
      if (paramBoolean)
      {
        localObject = "tcp|";
        localObject = localStringBuilder.append((String)localObject).append("sharkSeqNo|").append(paramaf.bZ).append("|ECmd|").append(paramae.bH).append("|seqNo|").append(paramae.bZ).append("|refSeqNo|").append(paramae.ca).append("|ret|").append(0);
        if (paramae.cp == null) {
          break label196;
        }
        paramaf = "|pushId|" + paramae.cp.bY;
        label174:
        ((StringBuilder)localObject).append(paramaf).toString();
        paramBoolean = true;
      }
    }
    for (;;)
    {
      return paramBoolean;
      localObject = "http|";
      break;
      label196:
      paramaf = "";
      break label174;
      if (eo.c(paramae))
      {
        this.nh.b(paramBoolean, paramaf.bZ, paramae);
        localStringBuilder = new StringBuilder().append("[ocean]guid|").append(this.mU.cC()).append("|gift|通道|");
        if (paramBoolean)
        {
          localObject = "tcp|";
          label266:
          localObject = localStringBuilder.append((String)localObject).append("sharkSeqNo|").append(paramaf.bZ).append("|ECmd|").append(paramae.bH).append("|seqNo|").append(paramae.bZ).append("|refSeqNo|").append(paramae.ca).append("|ret|").append(0);
          if (paramae.cp == null) {
            break label394;
          }
        }
        label394:
        for (paramaf = "|pushId|" + paramae.cp.bY;; paramaf = "")
        {
          ((StringBuilder)localObject).append(paramaf).toString();
          paramBoolean = true;
          break;
          localObject = "http|";
          break label266;
        }
      }
      paramBoolean = false;
    }
  }
  
  private void ak(int paramInt)
  {
    synchronized (this.mY)
    {
      Object localObject2 = (ArrayList)this.mY.clone();
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        x localx;
        do
        {
          ??? = ((ArrayList)localObject2).iterator();
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              if (!((Iterator)???).hasNext()) {
                break;
              }
              localObject2 = (em.d)((Iterator)???).next();
            } while ((localObject2 == null) || (((em.d)localObject2).nE == null) || (((em.d)localObject2).nE.size() <= 0));
            localObject2 = ((em.d)localObject2).nE.iterator();
          }
          localx = (x)((Iterator)localObject2).next();
        } while (localx == null);
        el.cP().a("SharkNetwork", localx.bH, localx.bZ, localx, paramInt);
      }
    }
  }
  
  private em.d al(int paramInt)
  {
    synchronized (this.mZ)
    {
      em.d locald = (em.d)this.mZ.remove(Integer.valueOf(paramInt));
      return locald;
    }
  }
  
  private void b(em.d paramd)
  {
    if (paramd == null) {
      return;
    }
    this.nl.removeMessages(1, paramd);
    ea.bV().a(new em.5(this, paramd), "runTimeout");
  }
  
  private void c(em.d paramd)
  {
    if ((paramd == null) || (paramd.nE == null) || (paramd.nC == null) || (paramd.nC.lv == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramd.nE.iterator();
      while (localIterator.hasNext())
      {
        x localx = (x)localIterator.next();
        if ((localx != null) && (localx.data != null))
        {
          if ((localx.cf & 0x2) == 0) {
            localx.data = ea.b(localx.data, paramd.nC.lv.getBytes());
          }
          if (localx.data != null) {}
          el.cP().a("SharkNetwork", localx.bH, localx.bZ, localx, 13);
        }
      }
    }
  }
  
  /* Error */
  private void cQ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 107	wf7/em:li	Lwf7/dt;
    //   6: invokevirtual 144	wf7/dt:bX	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 98	wf7/em:nk	J
    //   21: lconst_0
    //   22: lcmp
    //   23: ifeq +18 -> 41
    //   26: invokestatic 478	java/lang/System:currentTimeMillis	()J
    //   29: aload_0
    //   30: getfield 98	wf7/em:nk	J
    //   33: lsub
    //   34: ldc2_w 479
    //   37: lcmp
    //   38: ifle -24 -> 14
    //   41: aload_0
    //   42: invokestatic 478	java/lang/System:currentTimeMillis	()J
    //   45: putfield 98	wf7/em:nk	J
    //   48: aload_0
    //   49: getfield 96	wf7/em:nj	Landroid/os/Handler;
    //   52: bipush 8
    //   54: invokevirtual 482	android/os/Handler:removeMessages	(I)V
    //   57: aload_0
    //   58: getfield 96	wf7/em:nj	Landroid/os/Handler;
    //   61: bipush 8
    //   63: ldc2_w 483
    //   66: invokevirtual 488	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   69: pop
    //   70: goto -56 -> 14
    //   73: astore_2
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_2
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	em
    //   9	2	1	bool	boolean
    //   73	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	73	finally
    //   17	41	73	finally
    //   41	70	73	finally
  }
  
  /* Error */
  private void cR()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 107	wf7/em:li	Lwf7/dt;
    //   6: invokevirtual 144	wf7/dt:bX	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 96	wf7/em:nj	Landroid/os/Handler;
    //   21: bipush 10
    //   23: invokevirtual 482	android/os/Handler:removeMessages	(I)V
    //   26: aload_0
    //   27: getfield 96	wf7/em:nj	Landroid/os/Handler;
    //   30: bipush 10
    //   32: ldc2_w 489
    //   35: invokevirtual 488	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   38: pop
    //   39: goto -25 -> 14
    //   42: astore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_2
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	em
    //   9	2	1	bool	boolean
    //   42	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	42	finally
    //   17	39	42	finally
  }
  
  private void cS()
  {
    String str1 = this.li.bZ();
    String str2 = this.li.ca();
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!str1.equals(str2))) {
      cU();
    }
    do
    {
      for (;;)
      {
        str1 = this.li.cd();
        str2 = this.li.ce();
        if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (str1.equals(str2))) {
          break;
        }
        cV();
        return;
        if ((!TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) {
          this.li.x(str1);
        }
      }
    } while ((TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2)));
    this.li.d(str1, false);
  }
  
  private static void e(ArrayList<ae> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {}
    ae localae;
    do
    {
      return;
      while (!paramArrayList.hasNext()) {
        paramArrayList = paramArrayList.iterator();
      }
      localae = (ae)paramArrayList.next();
    } while ((localae == null) || (localae.cc != 3));
    ee.cz();
  }
  
  private boolean f(ArrayList<ae> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() != 1)) {
      return false;
    }
    paramArrayList = (ae)paramArrayList.get(0);
    if (paramArrayList == null) {
      return false;
    }
    if (2 == paramArrayList.cc) {}
    for (int i = 1; i == 0; i = 0) {
      return false;
    }
    return true;
  }
  
  public static af j(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = df.a(paramArrayOfByte, new af(), false);
    if (paramArrayOfByte == null) {
      return null;
    }
    return (af)paramArrayOfByte;
  }
  
  protected dx a(boolean paramBoolean, em.d paramd)
  {
    if (paramd == null) {
      return null;
    }
    dx localdx;
    x localx;
    if (paramBoolean)
    {
      localdx = this.mT.cO();
      paramd.nC = localdx;
      ??? = paramd.nE.iterator();
      while (((Iterator)???).hasNext())
      {
        localx = (x)((Iterator)???).next();
        if ((localx != null) && (localx.data != null) && (localx.data.length > 0) && ((localx.cf & 0x2) == 0))
        {
          localx.data = ea.a(localx.data, localdx.lv.getBytes());
          if (localx.data != null) {}
        }
      }
    }
    for (;;)
    {
      if ((paramd.nE != null) && (paramd.nE.size() > 0))
      {
        ??? = paramd.nE.iterator();
        while (((Iterator)???).hasNext())
        {
          localx = (x)((Iterator)???).next();
          if (localx != null)
          {
            if (localx.ca == 0) {
              paramd.nA = true;
            }
            el.cP().a("SharkNetwork", localx.bH, localx.bZ, localx, 5);
          }
        }
      }
      for (;;)
      {
        synchronized (this.mZ)
        {
          this.mZ.put(Integer.valueOf(paramd.nB), paramd);
          if (paramd.nJ > 0L)
          {
            l = paramd.nJ;
            ??? = Message.obtain(this.nl, 1, paramd);
            this.nl.sendMessageDelayed((Message)???, l);
            this.mS.d(paramd);
            return localdx;
          }
        }
        long l = 180000L;
      }
      localdx = null;
    }
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean, ArrayList<x> paramArrayList, em.a parama)
  {
    a(new em.d(paramInt, false, false, false, paramLong, paramArrayList, parama, 0L));
    if (paramBoolean) {
      this.mU.t(false);
    }
  }
  
  protected void a(ArrayList<x> paramArrayList, em.a parama)
  {
    this.mW = new em.d(0, true, false, false, 0L, paramArrayList, parama, 0L);
    this.mW.nu = true;
    this.nj.obtainMessage(0, 1, 0).sendToTarget();
  }
  
  public void a(em.d paramd)
  {
    if ((paramd == null) || (paramd.nF == null) || (paramd.nE == null) || (paramd.nE.size() <= 0)) {
      return;
    }
    synchronized (this.mY)
    {
      this.mY.add(paramd);
      paramd = paramd.nE.iterator();
      while (paramd.hasNext())
      {
        ??? = (x)paramd.next();
        if (??? != null) {
          el.cP().a("SharkNetwork", ((x)???).bH, ((x)???).bZ, (x)???, 1);
        }
      }
    }
    this.nj.sendEmptyMessage(1);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void b(ArrayList<x> paramArrayList, em.a parama)
  {
    this.mX = new em.d(0, true, false, false, 0L, paramArrayList, parama, 0L);
    this.mX.nv = true;
    this.nj.obtainMessage(0, 2, 0).sendToTarget();
  }
  
  public void bL()
  {
    if (!this.li.bX()) {}
    eu localeu;
    do
    {
      return;
      localeu = this.mS.dc();
    } while (localeu == null);
    localeu.bL();
  }
  
  public String cC()
  {
    return this.mU.cC();
  }
  
  protected dx cO()
  {
    return this.mT.cO();
  }
  
  protected dt cT()
  {
    return this.li;
  }
  
  public void cU()
  {
    if (this.nj != null)
    {
      this.nj.removeMessages(4);
      this.nj.sendEmptyMessageDelayed(4, 15000L);
    }
  }
  
  public void cV()
  {
    if (this.nj != null)
    {
      this.nj.removeMessages(9);
      this.nj.sendEmptyMessageDelayed(9, 2000L);
    }
  }
  
  public void onReady()
  {
    this.mU.t(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.em
 * JD-Core Version:    0.7.0.1
 */