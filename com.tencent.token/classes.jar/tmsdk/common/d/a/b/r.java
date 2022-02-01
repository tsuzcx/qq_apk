package tmsdk.common.d.a.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Pair;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.ef;
import com.tencent.token.eg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class r
  extends tmsdk.common.a.a
{
  private final String a = "SharkProtocolQueue";
  private final int b = 1073741824;
  private final long c = -1L;
  private Context d;
  private o e;
  private ExecutorService f;
  private TreeMap g = new TreeMap();
  private ArrayList h = new ArrayList();
  private Handler i = new s(this, Looper.getMainLooper());
  
  private boolean b(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  private boolean c(int paramInt)
  {
    return b(paramInt, 1);
  }
  
  private boolean d(int paramInt)
  {
    return b(paramInt, 4);
  }
  
  public eg a(int paramInt1, int paramInt2)
  {
    boolean bool = c(paramInt2);
    eg localeg = null;
    if (bool) {
      return z.a().a(paramInt1, null);
    }
    synchronized (this.g)
    {
      if (this.g.containsKey(Integer.valueOf(paramInt1))) {
        localeg = (eg)((Pair)this.g.remove(Integer.valueOf(paramInt1))).second;
      }
      return localeg;
    }
  }
  
  public WeakReference a(long paramLong, int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, ef paramef)
  {
    return a(paramLong, paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramef, -1L);
  }
  
  public WeakReference a(long paramLong1, int paramInt1, JceStruct arg4, JceStruct paramJceStruct2, int paramInt2, ef paramef, long paramLong2)
  {
    if (c(paramInt2)) {
      return z.a().a(this.e, paramInt1, paramInt2, ???, paramJceStruct2, paramef, paramLong2);
    }
    paramJceStruct2 = new t(this, paramLong1, paramInt1, ???, paramJceStruct2, paramInt2, paramef);
    paramJceStruct2.g = this.e.c().a();
    paramJceStruct2.i = paramLong2;
    synchronized (this.h)
    {
      this.h.add(paramJceStruct2);
      this.i.sendEmptyMessage(1);
      return new WeakReference(paramJceStruct2.h);
    }
  }
  
  public void a(int paramInt)
  {
    if (c(paramInt))
    {
      z.a().d();
      if (d(paramInt)) {
        z.a().b();
      }
    }
  }
  
  public void a(int paramInt1, JceStruct paramJceStruct, int paramInt2, eg parameg)
  {
    if (parameg != null)
    {
      if (c(paramInt2))
      {
        z.a().a(paramInt2, paramInt1, paramJceStruct, parameg);
        return;
      }
      Object localObject = null;
      synchronized (this.g)
      {
        if (!this.g.containsKey(Integer.valueOf(paramInt1)))
        {
          this.g.put(Integer.valueOf(paramInt1), new Pair(paramJceStruct, parameg));
          paramJceStruct = localObject;
        }
        else
        {
          paramJceStruct = new ClassCastException();
        }
        if (paramJceStruct == null) {
          return;
        }
        throw paramJceStruct;
      }
    }
    throw new NullPointerException();
  }
  
  public void a(g paramg, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pid: ");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("SharkProtocolQueue init()");
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("init is Test server : ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.toString();
    this.e = new o(tmsdk.common.a.a(), paramg, paramBoolean);
    z.a().a(paramg, paramBoolean);
    this.f = Executors.newSingleThreadExecutor();
    this.e.d();
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setIsTest is Test server : ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.toString();
    z.a().a(paramBoolean);
    this.e.a(paramBoolean);
  }
  
  public void b(int paramInt)
  {
    if (c(paramInt)) {
      z.a().e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.r
 * JD-Core Version:    0.7.0.1
 */