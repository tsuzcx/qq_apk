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
    while (i < j)
    {
      ae localae = (ae)paramArrayList.get(i);
      if ((localae != null) && (!a(paramBoolean, paramaf, localae))) {
        paramd.add(localae);
      }
      i += 1;
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
    em.d locald = this.mW;
    if ((locald != null) && (locald.nB == ???.nB))
    {
      localArrayList.add(this.mW);
      al(this.mW.nB);
    }
    else
    {
      locald = this.mX;
      if ((locald != null) && (locald.nB == ???.nB))
      {
        localArrayList.add(this.mX);
        al(this.mX.nB);
      }
      else
      {
        localArrayList.add(???);
        al(???.nB);
      }
    }
    synchronized (this.mY)
    {
      localArrayList.addAll(this.mY);
      this.mY.clear();
      ??? = localArrayList.iterator();
      while (???.hasNext()) {
        a(paramBoolean, (em.d)???.next(), paramInt, 0, null);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
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
      synchronized (this.mY)
      {
        ((ArrayList)localObject1).addAll(this.mY);
        this.mY.clear();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          a(paramBoolean1, (em.d)((Iterator)localObject1).next(), paramInt, 0, null);
        }
        return;
      }
    }
    for (;;)
    {
      throw localObject3;
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
    boolean bool = eo.b(paramae);
    String str1 = "";
    String str2 = "tcp|";
    StringBuilder localStringBuilder;
    if (bool)
    {
      this.nh.a(paramBoolean, paramaf.bZ, paramae);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ocean]guid|");
      localStringBuilder.append(this.mU.cC());
      localStringBuilder.append("|push|通道|");
      if (!paramBoolean) {
        str2 = "http|";
      }
      localStringBuilder.append(str2);
      localStringBuilder.append("sharkSeqNo|");
      localStringBuilder.append(paramaf.bZ);
      localStringBuilder.append("|ECmd|");
      localStringBuilder.append(paramae.bH);
      localStringBuilder.append("|seqNo|");
      localStringBuilder.append(paramae.bZ);
      localStringBuilder.append("|refSeqNo|");
      localStringBuilder.append(paramae.ca);
      localStringBuilder.append("|ret|");
      localStringBuilder.append(0);
      if (paramae.cp != null)
      {
        paramaf = new StringBuilder();
        paramaf.append("|pushId|");
        paramaf.append(paramae.cp.bY);
        str1 = paramaf.toString();
      }
      localStringBuilder.append(str1);
      localStringBuilder.toString();
    }
    for (;;)
    {
      return true;
      if (!eo.c(paramae)) {
        break;
      }
      this.nh.b(paramBoolean, paramaf.bZ, paramae);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ocean]guid|");
      localStringBuilder.append(this.mU.cC());
      localStringBuilder.append("|gift|通道|");
      if (!paramBoolean) {
        str2 = "http|";
      }
      localStringBuilder.append(str2);
      localStringBuilder.append("sharkSeqNo|");
      localStringBuilder.append(paramaf.bZ);
      localStringBuilder.append("|ECmd|");
      localStringBuilder.append(paramae.bH);
      localStringBuilder.append("|seqNo|");
      localStringBuilder.append(paramae.bZ);
      localStringBuilder.append("|refSeqNo|");
      localStringBuilder.append(paramae.ca);
      localStringBuilder.append("|ret|");
      localStringBuilder.append(0);
      if (paramae.cp != null)
      {
        paramaf = new StringBuilder();
        paramaf.append("|pushId|");
        paramaf.append(paramae.cp.bY);
        str1 = paramaf.toString();
      }
      localStringBuilder.append(str1);
      localStringBuilder.toString();
    }
    return false;
  }
  
  private void ak(int paramInt)
  {
    synchronized (this.mY)
    {
      Object localObject2 = (ArrayList)this.mY.clone();
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        ??? = ((ArrayList)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (em.d)((Iterator)???).next();
          if ((localObject2 != null) && (((em.d)localObject2).nE != null) && (((em.d)localObject2).nE.size() > 0))
          {
            localObject2 = ((em.d)localObject2).nE.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              x localx = (x)((Iterator)localObject2).next();
              if (localx != null) {
                el.cP().a("SharkNetwork", localx.bH, localx.bZ, localx, paramInt);
              }
            }
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
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
    if ((paramd != null) && (paramd.nE != null) && (paramd.nC != null))
    {
      if (paramd.nC.lv == null) {
        return;
      }
      Iterator localIterator = paramd.nE.iterator();
      while (localIterator.hasNext())
      {
        x localx = (x)localIterator.next();
        if ((localx != null) && (localx.data != null))
        {
          if ((localx.cf & 0x2) == 0) {
            localx.data = ea.b(localx.data, paramd.nC.lv.getBytes());
          }
          byte[] arrayOfByte = localx.data;
          el.cP().a("SharkNetwork", localx.bH, localx.bZ, localx, 13);
        }
      }
    }
  }
  
  private void cQ()
  {
    try
    {
      boolean bool = this.li.bX();
      if (!bool) {
        return;
      }
      if (this.nk != 0L)
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.nk;
        if (l1 - l2 <= 300000L) {
          return;
        }
      }
      this.nk = System.currentTimeMillis();
      this.nj.removeMessages(8);
      this.nj.sendEmptyMessageDelayed(8, 5000L);
      return;
    }
    finally {}
  }
  
  private void cR()
  {
    try
    {
      boolean bool = this.li.bX();
      if (!bool) {
        return;
      }
      this.nj.removeMessages(10);
      this.nj.sendEmptyMessageDelayed(10, 10000L);
      return;
    }
    finally {}
  }
  
  private void cS()
  {
    String str1 = this.li.bZ();
    String str2 = this.li.ca();
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!str1.equals(str2))) {
      cU();
    } else if ((!TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) {
      this.li.x(str1);
    }
    str1 = this.li.cd();
    str2 = this.li.ce();
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!str1.equals(str2)))
    {
      cV();
      return;
    }
    if ((!TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) {
      this.li.d(str1, false);
    }
  }
  
  private static void e(ArrayList<ae> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        ae localae = (ae)paramArrayList.next();
        if ((localae != null) && (localae.cc == 3)) {
          ee.cz();
        }
      }
    }
  }
  
  private boolean f(ArrayList<ae> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() != 1) {
        return false;
      }
      paramArrayList = (ae)paramArrayList.get(0);
      if (paramArrayList == null) {
        return false;
      }
      int i;
      if (2 == paramArrayList.cc) {
        i = 1;
      } else {
        i = 0;
      }
      return i != 0;
    }
    return false;
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
    Object localObject1 = null;
    if (paramd == null) {
      return null;
    }
    Object localObject3;
    if (paramBoolean)
    {
      ??? = this.mT.cO();
      paramd.nC = ((dx)???);
      localObject3 = paramd.nE.iterator();
      for (;;)
      {
        localObject1 = ???;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (x)((Iterator)localObject3).next();
        if ((localObject1 != null) && (((x)localObject1).data != null) && (((x)localObject1).data.length > 0) && ((((x)localObject1).cf & 0x2) == 0))
        {
          ((x)localObject1).data = ea.a(((x)localObject1).data, ((dx)???).lv.getBytes());
          localObject1 = ((x)localObject1).data;
        }
      }
    }
    if ((paramd.nE != null) && (paramd.nE.size() > 0))
    {
      ??? = paramd.nE.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (x)((Iterator)???).next();
        if (localObject3 != null)
        {
          if (((x)localObject3).ca == 0) {
            paramd.nA = true;
          }
          el.cP().a("SharkNetwork", ((x)localObject3).bH, ((x)localObject3).bZ, (x)localObject3, 5);
        }
      }
    }
    synchronized (this.mZ)
    {
      this.mZ.put(Integer.valueOf(paramd.nB), paramd);
      long l;
      if (paramd.nJ > 0L) {
        l = paramd.nJ;
      } else {
        l = 180000L;
      }
      ??? = Message.obtain(this.nl, 1, paramd);
      this.nl.sendMessageDelayed((Message)???, l);
      this.mS.d(paramd);
      return localObject1;
    }
    for (;;)
    {
      throw paramd;
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
    if ((paramd != null) && (paramd.nF != null) && (paramd.nE != null))
    {
      if (paramd.nE.size() <= 0) {
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
        this.nj.sendEmptyMessage(1);
        return;
      }
    }
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
    if (!this.li.bX()) {
      return;
    }
    eu localeu = this.mS.dc();
    if (localeu != null) {
      localeu.bL();
    }
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
    Handler localHandler = this.nj;
    if (localHandler != null)
    {
      localHandler.removeMessages(4);
      this.nj.sendEmptyMessageDelayed(4, 15000L);
    }
  }
  
  public void cV()
  {
    Handler localHandler = this.nj;
    if (localHandler != null)
    {
      localHandler.removeMessages(9);
      this.nj.sendEmptyMessageDelayed(9, 2000L);
    }
  }
  
  public void onReady()
  {
    this.mU.t(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.em
 * JD-Core Version:    0.7.0.1
 */