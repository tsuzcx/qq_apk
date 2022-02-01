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
  private static eo on = null;
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
  
  /* Error */
  private void a(long paramLong, ae paramae, byte[] paramArrayOfByte, ed<JceStruct, du, eo.b> paramed)
  {
    // Byte code:
    //   0: aload_3
    //   1: getfield 136	wf7/ae:data	[B
    //   4: ifnull +202 -> 206
    //   7: aload 5
    //   9: getfield 142	wf7/ed:fd	Ljava/lang/Object;
    //   12: checkcast 144	wf7/eo$b
    //   15: getfield 147	wf7/eo$b:oL	Z
    //   18: ifeq +128 -> 146
    //   21: aload_0
    //   22: getfield 124	wf7/eo:mContext	Landroid/content/Context;
    //   25: aload 4
    //   27: aload_3
    //   28: getfield 136	wf7/ae:data	[B
    //   31: aload_3
    //   32: getfield 151	wf7/ae:cf	I
    //   35: invokestatic 156	wf7/ee:a	(Landroid/content/Context;[B[BI)[B
    //   38: astore 4
    //   40: aconst_null
    //   41: astore 6
    //   43: aload 5
    //   45: getfield 142	wf7/ed:fd	Ljava/lang/Object;
    //   48: checkcast 144	wf7/eo$b
    //   51: getfield 147	wf7/eo$b:oL	Z
    //   54: ifeq +161 -> 215
    //   57: aload 5
    //   59: getfield 159	wf7/ed:second	Ljava/lang/Object;
    //   62: checkcast 161	wf7/dv
    //   65: aload_3
    //   66: getfield 164	wf7/ae:bZ	I
    //   69: lload_1
    //   70: aload_3
    //   71: getfield 167	wf7/ae:bH	I
    //   74: aload 4
    //   76: invokeinterface 170 6 0
    //   81: astore 4
    //   83: aload 4
    //   85: ifnull +33 -> 118
    //   88: aload_0
    //   89: aload_3
    //   90: getfield 164	wf7/ae:bZ	I
    //   93: lload_1
    //   94: aload 4
    //   96: getfield 159	wf7/ed:second	Ljava/lang/Object;
    //   99: checkcast 172	java/lang/Integer
    //   102: invokevirtual 176	java/lang/Integer:intValue	()I
    //   105: aload 4
    //   107: getfield 142	wf7/ed:fd	Ljava/lang/Object;
    //   110: checkcast 178	com/qq/taf/jce/JceStruct
    //   113: iconst_1
    //   114: invokevirtual 181	wf7/eo:a	(IJILcom/qq/taf/jce/JceStruct;I)Ljava/lang/ref/WeakReference;
    //   117: pop
    //   118: return
    //   119: astore 4
    //   121: aload_0
    //   122: aload_3
    //   123: getfield 164	wf7/ae:bZ	I
    //   126: lload_1
    //   127: aload_3
    //   128: getfield 167	wf7/ae:bH	I
    //   131: aconst_null
    //   132: iconst_m1
    //   133: invokevirtual 181	wf7/eo:a	(IJILcom/qq/taf/jce/JceStruct;I)Ljava/lang/ref/WeakReference;
    //   136: pop
    //   137: aconst_null
    //   138: astore 4
    //   140: aconst_null
    //   141: astore 6
    //   143: goto -100 -> 43
    //   146: aload 5
    //   148: getfield 184	wf7/ed:first	Ljava/lang/Object;
    //   151: ifnull +55 -> 206
    //   154: aload_0
    //   155: getfield 124	wf7/eo:mContext	Landroid/content/Context;
    //   158: aload 4
    //   160: aload_3
    //   161: getfield 136	wf7/ae:data	[B
    //   164: aload 5
    //   166: getfield 184	wf7/ed:first	Ljava/lang/Object;
    //   169: checkcast 178	com/qq/taf/jce/JceStruct
    //   172: iconst_1
    //   173: aload_3
    //   174: getfield 151	wf7/ae:cf	I
    //   177: invokestatic 187	wf7/ee:a	(Landroid/content/Context;[B[BLcom/qq/taf/jce/JceStruct;ZI)Lcom/qq/taf/jce/JceStruct;
    //   180: astore 6
    //   182: aconst_null
    //   183: astore 4
    //   185: goto -142 -> 43
    //   188: astore 4
    //   190: aload_0
    //   191: aload_3
    //   192: getfield 164	wf7/ae:bZ	I
    //   195: lload_1
    //   196: aload_3
    //   197: getfield 167	wf7/ae:bH	I
    //   200: aconst_null
    //   201: iconst_m1
    //   202: invokevirtual 181	wf7/eo:a	(IJILcom/qq/taf/jce/JceStruct;I)Ljava/lang/ref/WeakReference;
    //   205: pop
    //   206: aconst_null
    //   207: astore 4
    //   209: aconst_null
    //   210: astore 6
    //   212: goto -169 -> 43
    //   215: aload 5
    //   217: getfield 159	wf7/ed:second	Ljava/lang/Object;
    //   220: checkcast 189	wf7/du
    //   223: aload_3
    //   224: getfield 164	wf7/ae:bZ	I
    //   227: lload_1
    //   228: aload_3
    //   229: getfield 167	wf7/ae:bH	I
    //   232: aload 6
    //   234: invokeinterface 193 6 0
    //   239: astore 4
    //   241: goto -158 -> 83
    //   244: astore_3
    //   245: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	eo
    //   0	246	1	paramLong	long
    //   0	246	3	paramae	ae
    //   0	246	4	paramArrayOfByte	byte[]
    //   0	246	5	paramed	ed<JceStruct, du, eo.b>
    //   41	192	6	localJceStruct	JceStruct
    // Exception table:
    //   from	to	target	type
    //   21	40	119	java/lang/Exception
    //   154	182	188	java/lang/Exception
    //   43	83	244	java/lang/Exception
    //   88	118	244	java/lang/Exception
    //   215	241	244	java/lang/Exception
  }
  
  public static boolean a(ae paramae)
  {
    if (paramae == null) {}
    while (paramae.ca == 0) {
      return false;
    }
    return true;
  }
  
  /* Error */
  private void b(long paramLong, ae paramae, byte[] paramArrayOfByte, ed<JceStruct, du, eo.b> paramed)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_3
    //   4: getfield 136	wf7/ae:data	[B
    //   7: ifnull +229 -> 236
    //   10: aload 5
    //   12: getfield 142	wf7/ed:fd	Ljava/lang/Object;
    //   15: checkcast 144	wf7/eo$b
    //   18: getfield 147	wf7/eo$b:oL	Z
    //   21: ifeq +115 -> 136
    //   24: aload_0
    //   25: getfield 124	wf7/eo:mContext	Landroid/content/Context;
    //   28: aload_0
    //   29: getfield 211	wf7/eo:lT	Lwf7/em;
    //   32: invokevirtual 217	wf7/em:cO	()Lwf7/dx;
    //   35: getfield 222	wf7/dx:lv	Ljava/lang/String;
    //   38: invokevirtual 228	java/lang/String:getBytes	()[B
    //   41: aload_3
    //   42: getfield 136	wf7/ae:data	[B
    //   45: aload_3
    //   46: getfield 151	wf7/ae:cf	I
    //   49: invokestatic 156	wf7/ee:a	(Landroid/content/Context;[B[BI)[B
    //   52: astore 4
    //   54: aload 5
    //   56: getfield 142	wf7/ed:fd	Ljava/lang/Object;
    //   59: checkcast 144	wf7/eo$b
    //   62: getfield 147	wf7/eo$b:oL	Z
    //   65: ifeq +140 -> 205
    //   68: aload 5
    //   70: getfield 159	wf7/ed:second	Ljava/lang/Object;
    //   73: checkcast 161	wf7/dv
    //   76: aload_3
    //   77: getfield 164	wf7/ae:bZ	I
    //   80: lload_1
    //   81: aload_3
    //   82: getfield 167	wf7/ae:bH	I
    //   85: aload 4
    //   87: invokeinterface 170 6 0
    //   92: astore 4
    //   94: aload 4
    //   96: ifnull +31 -> 127
    //   99: aload_0
    //   100: aload_3
    //   101: getfield 164	wf7/ae:bZ	I
    //   104: aload 4
    //   106: getfield 159	wf7/ed:second	Ljava/lang/Object;
    //   109: checkcast 172	java/lang/Integer
    //   112: invokevirtual 176	java/lang/Integer:intValue	()I
    //   115: aload 4
    //   117: getfield 142	wf7/ed:fd	Ljava/lang/Object;
    //   120: checkcast 178	com/qq/taf/jce/JceStruct
    //   123: invokevirtual 231	wf7/eo:a	(IILcom/qq/taf/jce/JceStruct;)Ljava/lang/ref/WeakReference;
    //   126: pop
    //   127: return
    //   128: astore 4
    //   130: aconst_null
    //   131: astore 4
    //   133: goto -79 -> 54
    //   136: aload 5
    //   138: getfield 184	wf7/ed:first	Ljava/lang/Object;
    //   141: ifnull +95 -> 236
    //   144: aload_0
    //   145: getfield 124	wf7/eo:mContext	Landroid/content/Context;
    //   148: aload_0
    //   149: getfield 211	wf7/eo:lT	Lwf7/em;
    //   152: invokevirtual 217	wf7/em:cO	()Lwf7/dx;
    //   155: getfield 222	wf7/dx:lv	Ljava/lang/String;
    //   158: invokevirtual 228	java/lang/String:getBytes	()[B
    //   161: aload_3
    //   162: getfield 136	wf7/ae:data	[B
    //   165: aload 5
    //   167: getfield 184	wf7/ed:first	Ljava/lang/Object;
    //   170: checkcast 178	com/qq/taf/jce/JceStruct
    //   173: iconst_1
    //   174: aload_3
    //   175: getfield 151	wf7/ae:cf	I
    //   178: invokestatic 187	wf7/ee:a	(Landroid/content/Context;[B[BLcom/qq/taf/jce/JceStruct;ZI)Lcom/qq/taf/jce/JceStruct;
    //   181: astore 4
    //   183: aconst_null
    //   184: astore 7
    //   186: aload 4
    //   188: astore 6
    //   190: aload 7
    //   192: astore 4
    //   194: goto -140 -> 54
    //   197: astore 4
    //   199: aconst_null
    //   200: astore 4
    //   202: goto -148 -> 54
    //   205: aload 5
    //   207: getfield 159	wf7/ed:second	Ljava/lang/Object;
    //   210: checkcast 189	wf7/du
    //   213: aload_3
    //   214: getfield 164	wf7/ae:bZ	I
    //   217: lload_1
    //   218: aload_3
    //   219: getfield 167	wf7/ae:bH	I
    //   222: aload 6
    //   224: invokeinterface 193 6 0
    //   229: astore 4
    //   231: goto -137 -> 94
    //   234: astore_3
    //   235: return
    //   236: aconst_null
    //   237: astore 4
    //   239: goto -185 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	eo
    //   0	242	1	paramLong	long
    //   0	242	3	paramae	ae
    //   0	242	4	paramArrayOfByte	byte[]
    //   0	242	5	paramed	ed<JceStruct, du, eo.b>
    //   1	222	6	arrayOfByte	byte[]
    //   184	7	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   24	54	128	java/lang/Exception
    //   144	183	197	java/lang/Exception
    //   54	94	234	java/lang/Exception
    //   99	127	234	java/lang/Exception
    //   205	231	234	java/lang/Exception
  }
  
  public static boolean b(ae paramae)
  {
    if (paramae == null) {}
    while ((paramae.ca != 0) || (paramae.cp == null) || (paramae.cp.bY == 0L)) {
      return false;
    }
    return true;
  }
  
  public static boolean c(ae paramae)
  {
    if (paramae == null) {}
    while ((a(paramae)) || (b(paramae))) {
      return false;
    }
    return true;
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
    if ((paramae == null) || (!b(paramae))) {
      return -1L;
    }
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
    ed localed;
    synchronized (this.nP)
    {
      localed = (ed)this.nP.get(Integer.valueOf(paramae.bH));
      if (localed != null) {
        break label223;
      }
    }
    synchronized (this.oo)
    {
      this.oo.put(Integer.valueOf(paramae.bH), new eo.a(this, 0, System.currentTimeMillis(), l, paramae, this.lT.cO().lv.getBytes()));
      this.nj.removeMessages(3);
      this.nj.sendEmptyMessageDelayed(3, 1800000L);
      return -1L;
      paramae = finally;
      throw paramae;
    }
    label223:
    a(l, paramae, this.lT.cO().lv.getBytes(), localed);
    if (localed.fd != null) {
      return ((eo.b)localed.fd).lM;
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
    if (paramInt2 == 156) {}
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
    if (paramdu == null) {}
    for (;;)
    {
      return;
      synchronized (this.nP)
      {
        this.nP.put(Integer.valueOf(paramInt1), new ed(paramJceStruct, paramdu, new eo.b(paramBoolean, paramLong)));
        if (!ea.lz) {
          continue;
        }
        this.nj.obtainMessage(5, paramInt1, 0).sendToTarget();
        return;
      }
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
    if ((paramae == null) || (!c(paramae))) {
      return -1L;
    }
    if (paramae.cc != 0) {
      return -1L;
    }
    ed localed;
    synchronized (this.nP)
    {
      localed = (ed)this.nP.get(Integer.valueOf(paramae.bH));
      if (localed != null) {
        break label154;
      }
    }
    synchronized (this.oo)
    {
      this.oo.put(Integer.valueOf(paramae.bH), new eo.a(this, 1, System.currentTimeMillis(), 0L, paramae, this.lT.cO().lv.getBytes()));
      this.nj.removeMessages(3);
      this.nj.sendEmptyMessageDelayed(3, 1800000L);
      return -1L;
      paramae = finally;
      throw paramae;
    }
    label154:
    b(0L, paramae, this.lT.cO().lv.getBytes(), localed);
    if (localed.fd != null) {
      return ((eo.b)localed.fd).lM;
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
      if (this.lT == null) {
        return;
      }
      this.lT.bL();
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
    if (this.lT == null) {
      return "";
    }
    return this.lT.cC();
  }
  
  public void cU()
  {
    if (ea.lz)
    {
      if (this.lT != null) {
        this.lT.cU();
      }
      return;
    }
    this.ot = true;
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
      if (this.lT == null) {
        return;
      }
      this.lT.onReady();
      return;
    }
    this.os = true;
  }
  
  public du w(int paramInt1, int paramInt2)
  {
    du localdu = null;
    synchronized (this.nP)
    {
      if (this.nP.containsKey(Integer.valueOf(paramInt1))) {
        localdu = (du)((ed)this.nP.remove(Integer.valueOf(paramInt1))).second;
      }
      return localdu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.eo
 * JD-Core Version:    0.7.0.1
 */