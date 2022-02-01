package wf7;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class eo
  implements em.b, em.c
{
  private static eo on;
  private final String TAG = "SharkProtocolQueue";
  private em lT;
  private dt mC;
  private Context mContext;
  private TreeMap<Integer, ed<JceStruct, du, eo.b>> nP = new TreeMap();
  private Handler nQ = new eo.1(this, Looper.getMainLooper());
  private ExecutorService na;
  private Handler nj = new eo.2(this, ea.getLooper());
  private Map<Integer, eo.a> oo = new HashMap();
  private ArrayList<eo.c> op = new ArrayList();
  private fl<Long> oq = new fl(1000);
  private boolean or = false;
  private boolean os = false;
  private boolean ot = false;
  private boolean ou = false;
  private LinkedList<eg> ov = null;
  private boolean ow = false;
  private boolean ox = false;
  private List<do> oy = new ArrayList();
  
  private eo(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void a(long paramLong, ae paramae, byte[] paramArrayOfByte, ed<JceStruct, du, eo.b> paramed)
  {
    if ((paramae.data == null) || (((eo.b)paramed.fd).oL)) {}
    try
    {
      paramArrayOfByte = ee.a(this.mContext, paramArrayOfByte, paramae.data, paramae.cf);
      localObject = null;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        try
        {
          Object localObject;
          if (((eo.b)paramed.fd).oL) {
            paramArrayOfByte = ((dv)paramed.second).a(paramae.bZ, paramLong, paramae.bH, paramArrayOfByte);
          } else {
            paramArrayOfByte = ((du)paramed.second).b(paramae.bZ, paramLong, paramae.bH, (JceStruct)localObject);
          }
          if (paramArrayOfByte != null) {
            a(paramae.bZ, paramLong, ((Integer)paramArrayOfByte.second).intValue(), (JceStruct)paramArrayOfByte.fd, 1);
          }
          return;
        }
        catch (Exception paramae) {}
        paramArrayOfByte = paramArrayOfByte;
      }
    }
    a(paramae.bZ, paramLong, paramae.bH, null, -1);
    break label123;
    if (paramed.first != null) {}
    try
    {
      localObject = ee.a(this.mContext, paramArrayOfByte, paramae.data, (JceStruct)paramed.first, true, paramae.cf);
      paramArrayOfByte = null;
    }
    catch (Exception paramArrayOfByte)
    {
      label107:
      break label107;
    }
    a(paramae.bZ, paramLong, paramae.bH, null, -1);
    label123:
    paramArrayOfByte = null;
    localObject = paramArrayOfByte;
  }
  
  public static boolean a(ae paramae)
  {
    boolean bool = false;
    if (paramae == null) {
      return false;
    }
    if (paramae.ca != 0) {
      bool = true;
    }
    return bool;
  }
  
  private void b(long paramLong, ae paramae, byte[] paramArrayOfByte, ed<JceStruct, du, eo.b> paramed)
  {
    if ((paramae.data == null) || (((eo.b)paramed.fd).oL)) {}
    try
    {
      paramArrayOfByte = ee.a(this.mContext, this.lT.cO().lv.getBytes(), paramae.data, paramae.cf);
      localObject = null;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        try
        {
          Object localObject;
          if (((eo.b)paramed.fd).oL) {
            paramArrayOfByte = ((dv)paramed.second).a(paramae.bZ, paramLong, paramae.bH, paramArrayOfByte);
          } else {
            paramArrayOfByte = ((du)paramed.second).b(paramae.bZ, paramLong, paramae.bH, (JceStruct)localObject);
          }
          if (paramArrayOfByte != null) {
            a(paramae.bZ, ((Integer)paramArrayOfByte.second).intValue(), (JceStruct)paramArrayOfByte.fd);
          }
          return;
        }
        catch (Exception paramae) {}
        paramArrayOfByte = paramArrayOfByte;
      }
    }
    if (paramed.first != null)
    {
      localObject = ee.a(this.mContext, this.lT.cO().lv.getBytes(), paramae.data, (JceStruct)paramed.first, true, paramae.cf);
      paramArrayOfByte = null;
    }
    else
    {
      paramArrayOfByte = null;
      localObject = paramArrayOfByte;
    }
  }
  
  public static boolean b(ae paramae)
  {
    if (paramae == null) {
      return false;
    }
    if (paramae.ca != 0) {
      return false;
    }
    return (paramae.cp != null) && (paramae.cp.bY != 0L);
  }
  
  public static boolean c(ae paramae)
  {
    boolean bool2 = false;
    if (paramae == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (!a(paramae))
    {
      bool1 = bool2;
      if (!b(paramae)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void d(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.oy)
    {
      if (this.oy.size() > 0)
      {
        localArrayList.addAll(this.oy);
        this.oy.clear();
      }
      if (localArrayList.size() > 0) {
        ea.bV().a(new eo.5(this, localArrayList, paramInt, paramString), "shark callback: guid got");
      }
      return;
    }
  }
  
  public static eo da()
  {
    try
    {
      if (on == null) {
        on = new eo(ea.cr());
      }
      eo localeo = on;
      return localeo;
    }
    finally {}
  }
  
  public long a(boolean paramBoolean, int paramInt, ae paramae)
  {
    if ((paramae != null) && (b(paramae)))
    {
      long l = 0L;
      if (paramae.cp != null) {
        l = paramae.cp.bY;
      }
      a(l, paramae.bH, paramInt, paramae.bZ, -1000000001);
      if (paramae.cc != 0) {
        return -1L;
      }
      if (this.oq.b(Long.valueOf(l))) {
        return -1L;
      }
      this.oq.push(Long.valueOf(l));
      synchronized (this.nP)
      {
        ed localed = (ed)this.nP.get(Integer.valueOf(paramae.bH));
        if (localed == null) {
          synchronized (this.oo)
          {
            this.oo.put(Integer.valueOf(paramae.bH), new eo.a(this, 0, System.currentTimeMillis(), l, paramae, this.lT.cO().lv.getBytes()));
            this.nj.removeMessages(3);
            this.nj.sendEmptyMessageDelayed(3, 1800000L);
            return -1L;
          }
        }
        a(l, paramae, this.lT.cO().lv.getBytes(), localed);
        if (localed.fd != null) {
          return ((eo.b)localed.fd).lM;
        }
        return -1L;
      }
    }
    return -1L;
  }
  
  public WeakReference<dz> a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, JceStruct arg9, byte[] paramArrayOfByte, JceStruct paramJceStruct2, int paramInt5, dq paramdq, dr paramdr, long paramLong3, long paramLong4)
  {
    if (paramInt3 > 0) {
      return a(paramInt3, paramLong1, paramInt4, ???, 1);
    }
    paramArrayOfByte = new eo.c(this, paramInt1, paramInt2, paramLong2, paramInt4, ???, paramArrayOfByte, paramJceStruct2, paramInt5, paramdq, paramdr);
    paramArrayOfByte.oP = ew.dg().di();
    paramArrayOfByte.oS = paramLong3;
    paramArrayOfByte.oT = paramLong4;
    synchronized (this.op)
    {
      this.op.add(paramArrayOfByte);
      el.cP().a(paramArrayOfByte.oP, paramLong3, null);
      if (ea.lz) {
        this.nj.sendEmptyMessage(1);
      }
      return new WeakReference(paramArrayOfByte.oR);
    }
  }
  
  public WeakReference<dz> a(int paramInt1, int paramInt2, JceStruct paramJceStruct)
  {
    return ea.cw().a(paramInt2, paramJceStruct, null, 0, new eo.3(this, paramInt2));
  }
  
  public WeakReference<dz> a(int paramInt1, long paramLong, int paramInt2, JceStruct paramJceStruct, int paramInt3)
  {
    return a(paramInt1, paramLong, paramInt2, paramJceStruct, paramInt3, 0);
  }
  
  public WeakReference<dz> a(int paramInt1, long paramLong, int paramInt2, JceStruct arg5, int paramInt3, int paramInt4)
  {
    Object localObject1 = new o();
    ((o)localObject1).bH = paramInt2;
    ((o)localObject1).status = paramInt3;
    if (??? != null) {
      ((o)localObject1).bI = df.a(???);
    }
    localObject1 = new eo.c(this, 0, 0, -1L, 1103, ???, df.a((JceStruct)localObject1), null, 1073741824, null, null);
    ((eo.c)localObject1).oP = paramInt1;
    ((eo.c)localObject1).bY = paramLong;
    ((eo.c)localObject1).cc = paramInt4;
    synchronized (this.op)
    {
      this.op.add(localObject1);
      if (ea.lz) {
        this.nj.sendEmptyMessage(1);
      }
      return new WeakReference(((eo.c)localObject1).oR);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    eo.c localc = new eo.c(this, Process.myPid(), 0, 0L, paramInt1, null, new byte[0], null, 1073741824, null, null);
    localc.cc = paramInt4;
    localc.oP = paramInt3;
    localc.bY = paramLong;
    synchronized (this.op)
    {
      this.op.add(localc);
      if (ea.lz) {
        this.nj.sendEmptyMessage(1);
      }
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, JceStruct paramJceStruct, int paramInt2, du paramdu, boolean paramBoolean)
  {
    if (paramdu == null) {
      return;
    }
    synchronized (this.nP)
    {
      this.nP.put(Integer.valueOf(paramInt1), new ed(paramJceStruct, paramdu, new eo.b(paramBoolean, paramLong)));
      if (ea.lz) {
        this.nj.obtainMessage(5, paramInt1, 0).sendToTarget();
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    ea.q(paramBoolean);
    this.lT = new em(ea.cr(), this.mC, this, this, paramBoolean, paramString);
    this.na = Executors.newSingleThreadExecutor();
    if (ea.bX())
    {
      ei.cI().a(new eo.4(this));
      eh.cE();
      el.cP().b(this.mC);
    }
    this.nj.sendEmptyMessage(2);
  }
  
  public long b(boolean paramBoolean, int paramInt, ae paramae)
  {
    if (paramae != null)
    {
      if (!c(paramae)) {
        return -1L;
      }
      if (paramae.cc != 0) {
        return -1L;
      }
      synchronized (this.nP)
      {
        ed localed = (ed)this.nP.get(Integer.valueOf(paramae.bH));
        if (localed == null) {
          synchronized (this.oo)
          {
            this.oo.put(Integer.valueOf(paramae.bH), new eo.a(this, 1, System.currentTimeMillis(), 0L, paramae, this.lT.cO().lv.getBytes()));
            this.nj.removeMessages(3);
            this.nj.sendEmptyMessageDelayed(3, 1800000L);
            return -1L;
          }
        }
        b(0L, paramae, this.lT.cO().lv.getBytes(), localed);
        if (localed.fd != null) {
          return ((eo.b)localed.fd).lM;
        }
        return -1L;
      }
    }
    return -1L;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (ea.lz)
    {
      this.lT.b(paramInt1, paramInt2, paramInt3);
      return;
    }
    if (this.ov == null) {
      this.ov = new LinkedList();
    }
    this.ov.add(new eg(paramInt1, paramInt2, paramInt3));
  }
  
  public void bL()
  {
    if (ea.lz)
    {
      em localem = this.lT;
      if (localem == null) {
        return;
      }
      localem.bL();
      return;
    }
    this.or = true;
  }
  
  public void c(dt paramdt)
  {
    this.mC = paramdt;
  }
  
  public String cC()
  {
    em localem = this.lT;
    if (localem == null) {
      return "";
    }
    return localem.cC();
  }
  
  public void cU()
  {
    if (ea.lz)
    {
      em localem = this.lT;
      if (localem != null) {
        localem.cU();
      }
    }
    else
    {
      this.ot = true;
    }
  }
  
  public void cV()
  {
    if (ea.lz)
    {
      this.lT.cV();
      return;
    }
    this.ou = true;
  }
  
  public void db()
  {
    if (ea.lz)
    {
      this.nj.removeMessages(4);
      this.nj.sendEmptyMessage(4);
      return;
    }
    this.ow = true;
  }
  
  public void onReady()
  {
    if (ea.lz)
    {
      em localem = this.lT;
      if (localem == null) {
        return;
      }
      localem.onReady();
      return;
    }
    this.os = true;
  }
  
  public du w(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      synchronized (this.nP)
      {
        if (this.nP.containsKey(Integer.valueOf(paramInt1)))
        {
          du localdu = (du)((ed)this.nP.remove(Integer.valueOf(paramInt1))).second;
          return localdu;
        }
      }
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.eo
 * JD-Core Version:    0.7.0.1
 */