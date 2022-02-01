package wf7;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Pair;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class en
{
  private static en nR = null;
  private dt li;
  private ew.a nK;
  private int nL = Process.myPid();
  private ExecutorService nM;
  private ArrayList<en.a> nN = new ArrayList();
  private TreeMap<Integer, en.a> nO = new TreeMap();
  private TreeMap<Integer, Pair<JceStruct, du>> nP = new TreeMap();
  private Handler nQ = new en.1(this, Looper.getMainLooper());
  private Handler nj = new en.2(this, ea.getLooper());
  private Handler nl = new en.3(this, ea.getLooper());
  
  private en(dt paramdt)
  {
    this.li = paramdt;
    this.nK = new ew.a();
    this.nM = Executors.newSingleThreadExecutor();
  }
  
  private void a(en.a parama)
  {
    this.nl.removeMessages(0, parama);
    if (!this.nO.containsKey(Integer.valueOf(parama.ob))) {
      return;
    }
    ea.bV().a(new en.7(this, parama), "sharkProcessProxyTimeout");
  }
  
  public static en cY()
  {
    try
    {
      if (nR == null) {
        nR = new en(ea.cs());
      }
      en localen = nR;
      return localen;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte, int paramInt5, int paramInt6)
  {
    if (this.nL != paramInt1) {
      return;
    }
    ea.bV().a(new en.6(this, paramInt2, paramArrayOfByte, paramInt4, paramInt3, paramInt5, paramInt6), "shark callback");
  }
  
  public void a(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, JceStruct arg8, JceStruct paramJceStruct2, int paramInt4, dq paramdq, long paramLong3, long paramLong4)
  {
    paramJceStruct2 = new en.a(this, paramInt1, this.nK.di(), paramInt2, paramLong2, paramLong1, paramInt3, ???, paramJceStruct2, paramInt4, paramdq, paramLong3, paramLong4);
    synchronized (this.nN)
    {
      this.nN.add(paramJceStruct2);
      this.nj.sendEmptyMessage(1);
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, JceStruct paramJceStruct, int paramInt2, du paramdu)
  {
    synchronized (this.nP)
    {
      if (!this.nP.containsKey(Integer.valueOf(paramInt1)))
      {
        this.nP.put(Integer.valueOf(paramInt1), new Pair(paramJceStruct, paramdu));
        ea.bV().a(new en.4(this, paramLong, paramInt1, paramInt2), "shark register push");
      }
      do
      {
        return;
        paramJceStruct = "[shark_push]registerSharkPush(), only one listener is allowed for current version! callIdent: " + paramLong + " cmdId: " + paramInt1 + " flag: " + paramInt2;
      } while (!ea.cv());
      throw new RuntimeException(paramJceStruct);
    }
  }
  
  protected void a(en.a parama, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    if (parama.oi == null) {
      return;
    }
    switch (dy.af(parama.oh))
    {
    default: 
      parama.oi.a(paramInteger1.intValue(), parama.gV, paramInteger2.intValue(), paramInteger3.intValue(), parama.og);
      return;
    case 16: 
      parama.oi.a(paramInteger1.intValue(), parama.gV, paramInteger2.intValue(), paramInteger3.intValue(), parama.og);
      return;
    }
    parama = this.nQ.obtainMessage(11, new Object[] { parama, paramInteger1, paramInteger2, paramInteger3 });
    this.nQ.sendMessage(parama);
  }
  
  public du w(int paramInt1, int paramInt2)
  {
    du localdu = null;
    synchronized (this.nP)
    {
      if (this.nP.containsKey(Integer.valueOf(paramInt1)))
      {
        localdu = (du)((Pair)this.nP.remove(Integer.valueOf(paramInt1))).second;
        ea.bV().a(new en.5(this, paramInt1, paramInt2), "shark unregist push");
      }
      return localdu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.en
 * JD-Core Version:    0.7.0.1
 */