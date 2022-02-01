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
  private static da ks = null;
  private cl hS;
  private final Object hT = new Object();
  private Handler jA = new Handler(cx.getLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      da.a(da.this, (da.a)paramAnonymousMessage.obj);
    }
  };
  private Handler jy = new Handler(cx.getLooper())
  {
    public void handleMessage(Message arg1)
    {
      switch (???.what)
      {
      default: 
        return;
      }
      try
      {
        da.a(da.this).removeMessages(1);
        da.b localb = new da.b(da.this, null);
        synchronized (da.b(da.this))
        {
          Iterator localIterator = da.c(da.this).iterator();
          if (localIterator.hasNext())
          {
            da.a locala = (da.a)localIterator.next();
            localb.a(Integer.valueOf(locala.kC), locala);
            if ((locala.kJ & 0x40000000) == 0) {
              da.d(da.this).put(Integer.valueOf(locala.kC), locala);
            }
            eh.e("SharkProcessProxy", da.e(da.this) + " sendShark() MSG_SEND_PROXY_TASK task.mIpcSeqNo: " + locala.kC);
          }
        }
        da.c(da.this).clear();
      }
      catch (Exception ???)
      {
        eh.h("SharkProcessProxy", "exception: " + ???);
        return;
      }
      da.f(da.this).submit(localRunnable);
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
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      da.a locala;
      do
      {
        return;
        paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
        locala = (da.a)paramAnonymousMessage[0];
      } while (locala.kK == null);
      locala.kK.onFinish(((Integer)paramAnonymousMessage[1]).intValue(), locala.kF, ((Integer)paramAnonymousMessage[2]).intValue(), ((Integer)paramAnonymousMessage[3]).intValue(), locala.kI);
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
    eh.e("SharkProcessProxy", "runTimeout() sharkProxyTask: " + parama.kC);
    this.jA.removeMessages(0, parama);
    synchronized (this.hT)
    {
      if (!this.kp.containsKey(Integer.valueOf(parama.kC))) {
        return;
      }
      ee.cT().addTask(new Runnable()
      {
        public void run()
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
  
  public void a(int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final byte[] paramArrayOfByte, final int paramInt5, final int paramInt6)
  {
    if (this.km != paramInt1)
    {
      eh.g("SharkProcessProxy", this.km + " callBack() not my pid's response, its pid is: " + paramInt1);
      return;
    }
    ee.cT().addTask(new Runnable()
    {
      public void run()
      {
        try
        {
          synchronized (da.b(da.this))
          {
            da.a locala = (da.a)da.d(da.this).remove(Integer.valueOf(paramInt2));
            if (locala == null)
            {
              eh.h("SharkProcessProxy", da.e(da.this) + " callBack(), no callback for ipcSeqNo: " + paramInt2);
              return;
            }
          }
          da.h(da.this).removeMessages(0, localObject2);
        }
        catch (Exception localException)
        {
          eh.h("SharkProcessProxy", "exception: " + localException);
          return;
        }
        JceStruct localJceStruct = cd.a(paramArrayOfByte, localObject2.kI);
        if (localObject2.kI != localJceStruct) {
          localObject2.kI = localJceStruct;
        }
        localObject2.kF = paramInt4;
        eh.f("SharkProcessProxy", da.e(da.this) + " callBack() ipcSeqNo: " + paramInt2 + " seqNo: " + paramInt3 + " cmdId: " + paramInt4 + " retCode: " + paramInt5 + " dataRetCode: " + paramInt6);
        da.this.a(localObject2, Integer.valueOf(paramInt3), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6));
      }
    }, "shark callback");
  }
  
  public void a(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, JceStruct arg8, JceStruct paramJceStruct2, int paramInt4, cj paramcj, long paramLong3, long paramLong4)
  {
    eh.e("SharkProcessProxy", this.km + " sendShark()");
    paramJceStruct2 = new a(paramInt1, this.kl.bm(), paramInt2, paramLong2, paramLong1, paramInt3, ???, paramJceStruct2, paramInt4, paramcj, paramLong3, paramLong4);
    synchronized (this.hT)
    {
      this.ko.add(paramJceStruct2);
      this.jy.sendEmptyMessage(1);
      return;
    }
  }
  
  public void a(final long paramLong, int paramInt1, JceStruct paramJceStruct, final int paramInt2, cm paramcm)
  {
    for (;;)
    {
      synchronized (this.kq)
      {
        eh.e("SharkProcessProxy", this.km + " registerSharkPush() callIdent: " + paramLong + " cmdId: " + paramInt1 + " flag: " + paramInt2);
        if (!this.kq.containsKey(Integer.valueOf(paramInt1)))
        {
          this.kq.put(Integer.valueOf(paramInt1), new Pair(paramJceStruct, paramcm));
          ee.cT().addTask(new Runnable()
          {
            public void run()
            {
              if (da.g(da.this) != null)
              {
                da.g(da.this).a(paramLong, paramInt2, this.c);
                return;
              }
              eh.h("SharkProcessProxy", "shark register push failed");
            }
          }, "shark register push");
          return;
        }
        paramJceStruct = "[shark_push]registerSharkPush(), only one listener is allowed for current version! callIdent: " + paramLong + " cmdId: " + paramInt1 + " flag: " + paramInt2;
        if (cx.bD()) {
          throw new RuntimeException(paramJceStruct);
        }
      }
      eh.h("SharkProcessProxy", paramJceStruct);
    }
  }
  
  protected void a(a parama, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    if (parama.kK == null) {
      return;
    }
    eh.e("ocean", "[ocean]procallback: ECmd|" + parama.kF + "|ipcSeqNo|" + parama.kC + "|seqNo|" + paramInteger1 + "|ret|" + paramInteger2 + "|dataRetCode|" + paramInteger3 + "|ident|" + parama.kG);
    switch (bv.k(parama.kJ))
    {
    default: 
      parama.kK.onFinish(paramInteger1.intValue(), parama.kF, paramInteger2.intValue(), paramInteger3.intValue(), parama.kI);
      return;
    case 16: 
      parama.kK.onFinish(paramInteger1.intValue(), parama.kF, paramInteger2.intValue(), paramInteger3.intValue(), parama.kI);
      return;
    }
    parama = this.kr.obtainMessage(11, new Object[] { parama, paramInteger1, paramInteger2, paramInteger3 });
    this.kr.sendMessage(parama);
  }
  
  public cm e(final int paramInt1, final int paramInt2)
  {
    cm localcm = null;
    synchronized (this.kq)
    {
      eh.e("SharkProcessProxy", this.km + "unregisterSharkPush() cmdId: " + paramInt1 + " flag: " + paramInt2);
      if (this.kq.containsKey(Integer.valueOf(paramInt1)))
      {
        localcm = (cm)((Pair)this.kq.remove(Integer.valueOf(paramInt1))).second;
        ee.cT().addTask(new Runnable()
        {
          public void run()
          {
            da.g(da.this).f(paramInt1, paramInt2);
          }
        }, "shark unregist push");
      }
      return localcm;
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
      long l1;
      if (this.kL > 0L)
      {
        l1 = this.kL;
        if (l2 < l1) {
          break label193;
        }
      }
      label193:
      for (boolean bool = true;; bool = false)
      {
        if (bool)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("cmdId|").append(this.kF);
          localStringBuilder.append("|mIpcSeqNo|").append(this.kC);
          localStringBuilder.append("|mPushSeqNo|").append(this.kD);
          localStringBuilder.append("|mPushId|").append(this.kE);
          localStringBuilder.append("|mCallerIdent|").append(this.kG);
          localStringBuilder.append("|mTimeout|").append(this.kL);
          localStringBuilder.append("|time(s)|").append(l2 / 1000L);
          eh.h("ocean", "[ocean][time_out]SharkProcessProxy.SharkProxyTask.isTimeOut(), " + localStringBuilder.toString());
        }
        return bool;
        l1 = 35000L;
        break;
      }
    }
  }
  
  private class b
    implements Runnable
  {
    private TreeMap<Integer, da.a> b = new TreeMap();
    
    private b() {}
    
    public Set<Map.Entry<Integer, da.a>> a()
    {
      synchronized (this.b)
      {
        TreeMap localTreeMap2 = (TreeMap)this.b.clone();
        return localTreeMap2.entrySet();
      }
    }
    
    public void a(Integer paramInteger, da.a parama)
    {
      this.b.put(paramInteger, parama);
    }
    
    public void run()
    {
      boolean bool = NetworkUtil.isNetworkConnected();
      Iterator localIterator = a().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!bool)
        {
          eh.f("SharkProcessProxy", da.e(da.this) + " run, 无物理网络");
          da.this.a(Process.myPid(), ((da.a)localEntry.getValue()).kC, 0, ((da.a)localEntry.getValue()).kF, null, -1000002, 0);
          eh.g("SharkProcessProxy", "[ocean]SharkProxyTaskRunnable.run(), no network: cmdId: " + ((da.a)localEntry.getValue()).kF + " retCode: " + -1000002);
          da.g(da.this).i(((da.a)localEntry.getValue()).kF, -1000002);
        }
        else if (((da.a)localEntry.getValue()).bP())
        {
          da.this.a(Process.myPid(), ((da.a)localEntry.getValue()).kC, 0, ((da.a)localEntry.getValue()).kF, null, -1000017, 0);
          eh.g("SharkProcessProxy", "[ocean][time_out]SharkProxyTaskRunnable.run(), send time out, stats by onConnnect(): cmdId: " + ((da.a)localEntry.getValue()).kF + " retCode: " + -1000017);
          da.g(da.this).i(((da.a)localEntry.getValue()).kF, -1000017);
        }
        else
        {
          eh.f("SharkProcessProxy", da.e(da.this) + " onPostToSendingProcess() mPid: " + ((da.a)localEntry.getValue()).km + " mCallerIdent: " + ((da.a)localEntry.getValue()).kG + " mIpcSeqNo: " + ((da.a)localEntry.getValue()).kC + " mPushSeqNo: " + ((da.a)localEntry.getValue()).kD + " mPushId: " + ((da.a)localEntry.getValue()).kE + " mCmdId: " + ((da.a)localEntry.getValue()).kF + " mFlag: " + ((da.a)localEntry.getValue()).kJ + " mTimeout: " + ((da.a)localEntry.getValue()).kL);
          Object localObject = Message.obtain(da.h(da.this), 0, localEntry.getValue());
          da.h(da.this).sendMessageDelayed((Message)localObject, 35000L);
          localObject = cd.a(((da.a)localEntry.getValue()).kH);
          da.g(da.this).a(((da.a)localEntry.getValue()).km, ((da.a)localEntry.getValue()).kG, ((da.a)localEntry.getValue()).kC, ((da.a)localEntry.getValue()).kD, ((da.a)localEntry.getValue()).kE, ((da.a)localEntry.getValue()).kF, (byte[])localObject, ((da.a)localEntry.getValue()).kJ, ((da.a)localEntry.getValue()).kL, ((da.a)localEntry.getValue()).kM, ((da.a)localEntry.getValue()).kN);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.da
 * JD-Core Version:    0.7.0.1
 */