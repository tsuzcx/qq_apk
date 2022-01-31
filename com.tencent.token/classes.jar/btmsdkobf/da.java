package btmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Pair;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class da
{
  private static da ks = null;
  private cl hS;
  private final Object hT = new Object();
  private Handler jA = new gu(this, cx.getLooper());
  private Handler jy = new gt(this, cx.getLooper());
  private cu.a kl;
  private int km = Process.myPid();
  private ExecutorService kn;
  private ArrayList ko = new ArrayList();
  private TreeMap kp = new TreeMap();
  private TreeMap kq = new TreeMap();
  private Handler kr = new gs(this, Looper.getMainLooper());
  
  private da(cl paramcl)
  {
    this.hS = paramcl;
    this.kl = new cu.a();
    this.kn = Executors.newSingleThreadExecutor();
  }
  
  private void a(da.a parama)
  {
    eh.e("SharkProcessProxy", "runTimeout() sharkProxyTask: " + parama.kC);
    this.jA.removeMessages(0, parama);
    synchronized (this.hT)
    {
      if (!this.kp.containsKey(Integer.valueOf(parama.kC))) {
        return;
      }
      ee.cT().addTask(new gy(this, parama), "sharkProcessProxyTimeout");
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
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte, int paramInt5, int paramInt6)
  {
    if (this.km != paramInt1)
    {
      eh.g("SharkProcessProxy", this.km + " callBack() not my pid's response, its pid is: " + paramInt1);
      return;
    }
    ee.cT().addTask(new gx(this, paramInt2, paramArrayOfByte, paramInt4, paramInt3, paramInt5, paramInt6), "shark callback");
  }
  
  public void a(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, JceStruct arg8, JceStruct paramJceStruct2, int paramInt4, cj paramcj, long paramLong3, long paramLong4)
  {
    eh.e("SharkProcessProxy", this.km + " sendShark()");
    paramJceStruct2 = new da.a(this, paramInt1, this.kl.bm(), paramInt2, paramLong2, paramLong1, paramInt3, ???, paramJceStruct2, paramInt4, paramcj, paramLong3, paramLong4);
    synchronized (this.hT)
    {
      this.ko.add(paramJceStruct2);
      this.jy.sendEmptyMessage(1);
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, JceStruct paramJceStruct, int paramInt2, cm paramcm)
  {
    for (;;)
    {
      synchronized (this.kq)
      {
        eh.e("SharkProcessProxy", this.km + " registerSharkPush() callIdent: " + paramLong + " cmdId: " + paramInt1 + " flag: " + paramInt2);
        if (!this.kq.containsKey(Integer.valueOf(paramInt1)))
        {
          this.kq.put(Integer.valueOf(paramInt1), new Pair(paramJceStruct, paramcm));
          ee.cT().addTask(new gv(this, paramLong, paramInt1, paramInt2), "shark register push");
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
  
  protected void a(da.a parama, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
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
  
  public cm e(int paramInt1, int paramInt2)
  {
    cm localcm = null;
    synchronized (this.kq)
    {
      eh.e("SharkProcessProxy", this.km + "unregisterSharkPush() cmdId: " + paramInt1 + " flag: " + paramInt2);
      if (this.kq.containsKey(Integer.valueOf(paramInt1)))
      {
        localcm = (cm)((Pair)this.kq.remove(Integer.valueOf(paramInt1))).second;
        ee.cT().addTask(new gw(this, paramInt1, paramInt2), "shark unregist push");
      }
      return localcm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.da
 * JD-Core Version:    0.7.0.1
 */