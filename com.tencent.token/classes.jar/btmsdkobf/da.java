package btmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Pair;
import com.qq.taf.jce.JceStruct;
import com.tmsdk.base.utils.NetworkUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class da
{
  private static da ks;
  private cl hS;
  private final Object hT = new Object();
  private Handler jA = new Handler(cx.getLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if (paramAnonymousMessage.what != 0) {
        return;
      }
      da.a(da.this, (da.a)paramAnonymousMessage.obj);
    }
  };
  private Handler jy = new Handler(cx.getLooper())
  {
    public final void handleMessage(Message arg1)
    {
      if (???.what != 1) {
        return;
      }
      try
      {
        da.a(da.this).removeMessages(1);
        da.b localb = new da.b(da.this, (byte)0);
        synchronized (da.b(da.this))
        {
          Iterator localIterator = da.c(da.this).iterator();
          while (localIterator.hasNext())
          {
            da.a locala = (da.a)localIterator.next();
            int i = locala.kC;
            localb.a.put(Integer.valueOf(i), locala);
            if ((locala.kJ & 0x40000000) == 0) {
              da.d(da.this).put(Integer.valueOf(locala.kC), locala);
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(da.e(da.this));
            localStringBuilder.append(" sendShark() MSG_SEND_PROXY_TASK task.mIpcSeqNo: ");
            localStringBuilder.append(locala.kC);
            eh.e("SharkProcessProxy", localStringBuilder.toString());
          }
          da.c(da.this).clear();
          da.f(da.this).submit(localb);
          return;
        }
        return;
      }
      catch (Exception ???)
      {
        eh.h("SharkProcessProxy", "exception: ".concat(String.valueOf(???)));
      }
    }
  };
  private cu.a kl;
  private int km = Process.myPid();
  private ExecutorService kn;
  private ArrayList<a> ko = new ArrayList();
  private TreeMap<Integer, a> kp = new TreeMap();
  private TreeMap<Integer, Pair<JceStruct, cm>> kq = new TreeMap();
  private Handler kr = new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what != 11) {
        return;
      }
      paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
      da.a locala = (da.a)paramAnonymousMessage[0];
      if (locala.kK != null) {
        locala.kK.onFinish(((Integer)paramAnonymousMessage[1]).intValue(), locala.kF, ((Integer)paramAnonymousMessage[2]).intValue(), ((Integer)paramAnonymousMessage[3]).intValue(), locala.kI);
      }
    }
  };
  
  private da(cl paramcl)
  {
    this.hS = paramcl;
    this.kl = new cu.a();
    this.kn = Executors.newSingleThreadExecutor();
  }
  
  private void a(final a parama)
  {
    ??? = new StringBuilder("runTimeout() sharkProxyTask: ");
    ((StringBuilder)???).append(parama.kC);
    eh.e("SharkProcessProxy", ((StringBuilder)???).toString());
    this.jA.removeMessages(0, parama);
    synchronized (this.hT)
    {
      if (!this.kp.containsKey(Integer.valueOf(parama.kC))) {
        return;
      }
      ee.cT().addTask(new Runnable()
      {
        public final void run()
        {
          da.this.a(Process.myPid(), parama.kC, 0, parama.kF, null, bz.p(-2050000), 0);
        }
      }, "sharkProcessProxyTimeout");
      return;
    }
  }
  
  public static da bW()
  {
    try
    {
      if (ks == null) {
        ks = new da(db.bZ().bL());
      }
      da localda = ks;
      return localda;
    }
    finally {}
  }
  
  public final void a(int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final byte[] paramArrayOfByte, final int paramInt5, final int paramInt6)
  {
    if (this.km != paramInt1)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(this.km);
      paramArrayOfByte.append(" callBack() not my pid's response, its pid is: ");
      paramArrayOfByte.append(paramInt1);
      eh.g("SharkProcessProxy", paramArrayOfByte.toString());
      return;
    }
    ee.cT().addTask(new Runnable()
    {
      public final void run()
      {
        try
        {
          synchronized (da.b(da.this))
          {
            Object localObject1 = (da.a)da.d(da.this).remove(Integer.valueOf(paramInt2));
            if (localObject1 == null)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(da.e(da.this));
              ((StringBuilder)localObject1).append(" callBack(), no callback for ipcSeqNo: ");
              ((StringBuilder)localObject1).append(paramInt2);
              eh.h("SharkProcessProxy", ((StringBuilder)localObject1).toString());
              return;
            }
            da.h(da.this).removeMessages(0, localObject1);
            ??? = cd.a(paramArrayOfByte, ((da.a)localObject1).kI);
            if (((da.a)localObject1).kI != ???) {
              ((da.a)localObject1).kI = ((JceStruct)???);
            }
            ((da.a)localObject1).kF = paramInt4;
            ??? = new StringBuilder();
            ((StringBuilder)???).append(da.e(da.this));
            ((StringBuilder)???).append(" callBack() ipcSeqNo: ");
            ((StringBuilder)???).append(paramInt2);
            ((StringBuilder)???).append(" seqNo: ");
            ((StringBuilder)???).append(paramInt3);
            ((StringBuilder)???).append(" cmdId: ");
            ((StringBuilder)???).append(paramInt4);
            ((StringBuilder)???).append(" retCode: ");
            ((StringBuilder)???).append(paramInt5);
            ((StringBuilder)???).append(" dataRetCode: ");
            ((StringBuilder)???).append(paramInt6);
            eh.f("SharkProcessProxy", ((StringBuilder)???).toString());
            da.this.a((da.a)localObject1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6));
            return;
          }
          return;
        }
        catch (Exception localException)
        {
          eh.h("SharkProcessProxy", "exception: ".concat(String.valueOf(localException)));
        }
      }
    }, "shark callback");
  }
  
  public final void a(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, JceStruct arg8, JceStruct paramJceStruct2, int paramInt4, cj paramcj, long paramLong3, long paramLong4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.km);
    localStringBuilder.append(" sendShark()");
    eh.e("SharkProcessProxy", localStringBuilder.toString());
    paramJceStruct2 = new a(paramInt1, this.kl.bm(), paramInt2, paramLong2, paramLong1, paramInt3, ???, paramJceStruct2, paramInt4, paramcj, paramLong3, paramLong4);
    synchronized (this.hT)
    {
      this.ko.add(paramJceStruct2);
      this.jy.sendEmptyMessage(1);
      return;
    }
  }
  
  public final void a(final long paramLong, int paramInt1, JceStruct paramJceStruct, final int paramInt2, cm paramcm)
  {
    synchronized (this.kq)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.km);
      localStringBuilder.append(" registerSharkPush() callIdent: ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" cmdId: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" flag: ");
      localStringBuilder.append(paramInt2);
      eh.e("SharkProcessProxy", localStringBuilder.toString());
      if (!this.kq.containsKey(Integer.valueOf(paramInt1)))
      {
        this.kq.put(Integer.valueOf(paramInt1), new Pair(paramJceStruct, paramcm));
        ee.cT().addTask(new Runnable()
        {
          public final void run()
          {
            if (da.g(da.this) != null)
            {
              da.g(da.this).a(paramLong, paramInt2, this.c);
              return;
            }
            eh.h("SharkProcessProxy", "shark register push failed");
          }
        }, "shark register push");
      }
      else
      {
        paramJceStruct = new StringBuilder("[shark_push]registerSharkPush(), only one listener is allowed for current version! callIdent: ");
        paramJceStruct.append(paramLong);
        paramJceStruct.append(" cmdId: ");
        paramJceStruct.append(paramInt1);
        paramJceStruct.append(" flag: ");
        paramJceStruct.append(paramInt2);
        paramJceStruct = paramJceStruct.toString();
        if (cx.bD()) {
          break label219;
        }
        eh.h("SharkProcessProxy", paramJceStruct);
      }
      return;
      label219:
      throw new RuntimeException(paramJceStruct);
    }
  }
  
  protected final void a(a parama, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    if (parama.kK == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("[ocean]procallback: ECmd|");
    localStringBuilder.append(parama.kF);
    localStringBuilder.append("|ipcSeqNo|");
    localStringBuilder.append(parama.kC);
    localStringBuilder.append("|seqNo|");
    localStringBuilder.append(paramInteger1);
    localStringBuilder.append("|ret|");
    localStringBuilder.append(paramInteger2);
    localStringBuilder.append("|dataRetCode|");
    localStringBuilder.append(paramInteger3);
    localStringBuilder.append("|ident|");
    localStringBuilder.append(parama.kG);
    eh.e("ocean", localStringBuilder.toString());
    int i = bv.k(parama.kJ);
    if (i != 8)
    {
      if (i != 16)
      {
        parama.kK.onFinish(paramInteger1.intValue(), parama.kF, paramInteger2.intValue(), paramInteger3.intValue(), parama.kI);
        return;
      }
      parama.kK.onFinish(paramInteger1.intValue(), parama.kF, paramInteger2.intValue(), paramInteger3.intValue(), parama.kI);
      return;
    }
    parama = this.kr.obtainMessage(11, new Object[] { parama, paramInteger1, paramInteger2, paramInteger3 });
    this.kr.sendMessage(parama);
  }
  
  public final cm e(final int paramInt1, final int paramInt2)
  {
    for (;;)
    {
      synchronized (this.kq)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.km);
        ((StringBuilder)localObject1).append("unregisterSharkPush() cmdId: ");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(" flag: ");
        ((StringBuilder)localObject1).append(paramInt2);
        eh.e("SharkProcessProxy", ((StringBuilder)localObject1).toString());
        if (this.kq.containsKey(Integer.valueOf(paramInt1)))
        {
          localObject1 = (cm)((Pair)this.kq.remove(Integer.valueOf(paramInt1))).second;
          ee.cT().addTask(new Runnable()
          {
            public final void run()
            {
              da.g(da.this).f(paramInt1, paramInt2);
            }
          }, "shark unregist push");
          return localObject1;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public class a
  {
    public int kC;
    public int kD;
    public long kE;
    public int kF;
    public long kG;
    public JceStruct kH;
    public JceStruct kI;
    public int kJ;
    public cj kK;
    public long kL = -1L;
    public long kM = -1L;
    public long kN = System.currentTimeMillis();
    public int km;
    
    a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt5, cj paramcj, long paramLong3, long paramLong4)
    {
      this.km = paramInt1;
      this.kC = paramInt2;
      this.kD = paramInt3;
      this.kE = paramLong1;
      this.kF = paramInt4;
      this.kG = paramLong2;
      this.kH = paramJceStruct1;
      this.kI = paramJceStruct2;
      this.kJ = paramInt5;
      this.kK = paramcj;
      this.kL = paramLong3;
      this.kM = paramLong4;
    }
    
    public boolean bP()
    {
      long l2 = Math.abs(System.currentTimeMillis() - this.kN);
      long l1 = this.kL;
      if (l1 <= 0L) {
        l1 = 35000L;
      }
      boolean bool;
      if (l2 >= l1) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("cmdId|");
        localStringBuilder1.append(this.kF);
        localStringBuilder1.append("|mIpcSeqNo|");
        localStringBuilder1.append(this.kC);
        localStringBuilder1.append("|mPushSeqNo|");
        localStringBuilder1.append(this.kD);
        localStringBuilder1.append("|mPushId|");
        localStringBuilder1.append(this.kE);
        localStringBuilder1.append("|mCallerIdent|");
        localStringBuilder1.append(this.kG);
        localStringBuilder1.append("|mTimeout|");
        localStringBuilder1.append(this.kL);
        localStringBuilder1.append("|time(s)|");
        localStringBuilder1.append(l2 / 1000L);
        StringBuilder localStringBuilder2 = new StringBuilder("[ocean][time_out]SharkProcessProxy.SharkProxyTask.isTimeOut(), ");
        localStringBuilder2.append(localStringBuilder1.toString());
        eh.h("ocean", localStringBuilder2.toString());
      }
      return bool;
    }
  }
  
  final class b
    implements Runnable
  {
    TreeMap<Integer, da.a> a = new TreeMap();
    
    private b() {}
    
    private Set<Map.Entry<Integer, da.a>> a()
    {
      synchronized (this.a)
      {
        TreeMap localTreeMap2 = (TreeMap)this.a.clone();
        return localTreeMap2.entrySet();
      }
    }
    
    public final void run()
    {
      boolean bool = NetworkUtil.isNetworkConnected();
      Iterator localIterator = a().iterator();
      for (;;)
      {
        Object localObject1 = this;
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        int i;
        if (!bool)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(da.e(((b)localObject1).b));
          ((StringBuilder)localObject2).append(" run, 无物理网络");
          eh.f("SharkProcessProxy", ((StringBuilder)localObject2).toString());
          ((b)localObject1).b.a(Process.myPid(), ((da.a)localEntry.getValue()).kC, 0, ((da.a)localEntry.getValue()).kF, null, -1000002, 0);
          localObject2 = new StringBuilder("[ocean]SharkProxyTaskRunnable.run(), no network: cmdId: ");
          ((StringBuilder)localObject2).append(((da.a)localEntry.getValue()).kF);
          ((StringBuilder)localObject2).append(" retCode: -1000002");
          eh.g("SharkProcessProxy", ((StringBuilder)localObject2).toString());
          localObject1 = da.g(((b)localObject1).b);
          i = ((da.a)localEntry.getValue()).kF;
        }
        for (int j = -1000002;; j = -1000017)
        {
          ((cl)localObject1).i(i, j);
          break;
          if (!((da.a)localEntry.getValue()).bP()) {
            break label348;
          }
          ((b)localObject1).b.a(Process.myPid(), ((da.a)localEntry.getValue()).kC, 0, ((da.a)localEntry.getValue()).kF, null, -1000017, 0);
          localObject2 = new StringBuilder("[ocean][time_out]SharkProxyTaskRunnable.run(), send time out, stats by onConnnect(): cmdId: ");
          ((StringBuilder)localObject2).append(((da.a)localEntry.getValue()).kF);
          ((StringBuilder)localObject2).append(" retCode: -1000017");
          eh.g("SharkProcessProxy", ((StringBuilder)localObject2).toString());
          localObject1 = da.g(((b)localObject1).b);
          i = ((da.a)localEntry.getValue()).kF;
        }
        label348:
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(da.e(((b)localObject1).b));
        ((StringBuilder)localObject2).append(" onPostToSendingProcess() mPid: ");
        ((StringBuilder)localObject2).append(((da.a)localEntry.getValue()).km);
        ((StringBuilder)localObject2).append(" mCallerIdent: ");
        ((StringBuilder)localObject2).append(((da.a)localEntry.getValue()).kG);
        ((StringBuilder)localObject2).append(" mIpcSeqNo: ");
        ((StringBuilder)localObject2).append(((da.a)localEntry.getValue()).kC);
        ((StringBuilder)localObject2).append(" mPushSeqNo: ");
        ((StringBuilder)localObject2).append(((da.a)localEntry.getValue()).kD);
        ((StringBuilder)localObject2).append(" mPushId: ");
        ((StringBuilder)localObject2).append(((da.a)localEntry.getValue()).kE);
        ((StringBuilder)localObject2).append(" mCmdId: ");
        ((StringBuilder)localObject2).append(((da.a)localEntry.getValue()).kF);
        ((StringBuilder)localObject2).append(" mFlag: ");
        ((StringBuilder)localObject2).append(((da.a)localEntry.getValue()).kJ);
        ((StringBuilder)localObject2).append(" mTimeout: ");
        ((StringBuilder)localObject2).append(((da.a)localEntry.getValue()).kL);
        eh.f("SharkProcessProxy", ((StringBuilder)localObject2).toString());
        localObject2 = Message.obtain(da.h(((b)localObject1).b), 0, localEntry.getValue());
        da.h(((b)localObject1).b).sendMessageDelayed((Message)localObject2, 35000L);
        localObject2 = cd.a(((da.a)localEntry.getValue()).kH);
        da.g(((b)localObject1).b).a(((da.a)localEntry.getValue()).km, ((da.a)localEntry.getValue()).kG, ((da.a)localEntry.getValue()).kC, ((da.a)localEntry.getValue()).kD, ((da.a)localEntry.getValue()).kE, ((da.a)localEntry.getValue()).kF, (byte[])localObject2, ((da.a)localEntry.getValue()).kJ, ((da.a)localEntry.getValue()).kL, ((da.a)localEntry.getValue()).kM, ((da.a)localEntry.getValue()).kN);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.da
 * JD-Core Version:    0.7.0.1
 */