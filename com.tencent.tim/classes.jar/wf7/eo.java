package wf7;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
  private TreeMap<Integer, ed<JceStruct, du, b>> nP = new TreeMap();
  private Handler nQ = new eo.1(this, Looper.getMainLooper());
  private ExecutorService na;
  private Handler nj = new eo.2(this, ea.getLooper());
  private Map<Integer, a> oo = new HashMap();
  private ArrayList<c> op = new ArrayList();
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
  private void a(long paramLong, ae paramae, byte[] paramArrayOfByte, ed<JceStruct, du, b> paramed)
  {
    // Byte code:
    //   0: aload_3
    //   1: getfield 147	wf7/ae:data	[B
    //   4: ifnull +202 -> 206
    //   7: aload 5
    //   9: getfield 153	wf7/ed:fd	Ljava/lang/Object;
    //   12: checkcast 13	wf7/eo$b
    //   15: getfield 156	wf7/eo$b:oL	Z
    //   18: ifeq +128 -> 146
    //   21: aload_0
    //   22: getfield 136	wf7/eo:mContext	Landroid/content/Context;
    //   25: aload 4
    //   27: aload_3
    //   28: getfield 147	wf7/ae:data	[B
    //   31: aload_3
    //   32: getfield 160	wf7/ae:cf	I
    //   35: invokestatic 165	wf7/ee:a	(Landroid/content/Context;[B[BI)[B
    //   38: astore 4
    //   40: aconst_null
    //   41: astore 6
    //   43: aload 5
    //   45: getfield 153	wf7/ed:fd	Ljava/lang/Object;
    //   48: checkcast 13	wf7/eo$b
    //   51: getfield 156	wf7/eo$b:oL	Z
    //   54: ifeq +161 -> 215
    //   57: aload 5
    //   59: getfield 168	wf7/ed:second	Ljava/lang/Object;
    //   62: checkcast 170	wf7/dv
    //   65: aload_3
    //   66: getfield 173	wf7/ae:bZ	I
    //   69: lload_1
    //   70: aload_3
    //   71: getfield 176	wf7/ae:bH	I
    //   74: aload 4
    //   76: invokeinterface 179 6 0
    //   81: astore 4
    //   83: aload 4
    //   85: ifnull +33 -> 118
    //   88: aload_0
    //   89: aload_3
    //   90: getfield 173	wf7/ae:bZ	I
    //   93: lload_1
    //   94: aload 4
    //   96: getfield 168	wf7/ed:second	Ljava/lang/Object;
    //   99: checkcast 181	java/lang/Integer
    //   102: invokevirtual 185	java/lang/Integer:intValue	()I
    //   105: aload 4
    //   107: getfield 153	wf7/ed:fd	Ljava/lang/Object;
    //   110: checkcast 187	com/qq/taf/jce/JceStruct
    //   113: iconst_1
    //   114: invokevirtual 190	wf7/eo:a	(IJILcom/qq/taf/jce/JceStruct;I)Ljava/lang/ref/WeakReference;
    //   117: pop
    //   118: return
    //   119: astore 4
    //   121: aload_0
    //   122: aload_3
    //   123: getfield 173	wf7/ae:bZ	I
    //   126: lload_1
    //   127: aload_3
    //   128: getfield 176	wf7/ae:bH	I
    //   131: aconst_null
    //   132: iconst_m1
    //   133: invokevirtual 190	wf7/eo:a	(IJILcom/qq/taf/jce/JceStruct;I)Ljava/lang/ref/WeakReference;
    //   136: pop
    //   137: aconst_null
    //   138: astore 4
    //   140: aconst_null
    //   141: astore 6
    //   143: goto -100 -> 43
    //   146: aload 5
    //   148: getfield 193	wf7/ed:first	Ljava/lang/Object;
    //   151: ifnull +55 -> 206
    //   154: aload_0
    //   155: getfield 136	wf7/eo:mContext	Landroid/content/Context;
    //   158: aload 4
    //   160: aload_3
    //   161: getfield 147	wf7/ae:data	[B
    //   164: aload 5
    //   166: getfield 193	wf7/ed:first	Ljava/lang/Object;
    //   169: checkcast 187	com/qq/taf/jce/JceStruct
    //   172: iconst_1
    //   173: aload_3
    //   174: getfield 160	wf7/ae:cf	I
    //   177: invokestatic 196	wf7/ee:a	(Landroid/content/Context;[B[BLcom/qq/taf/jce/JceStruct;ZI)Lcom/qq/taf/jce/JceStruct;
    //   180: astore 6
    //   182: aconst_null
    //   183: astore 4
    //   185: goto -142 -> 43
    //   188: astore 4
    //   190: aload_0
    //   191: aload_3
    //   192: getfield 173	wf7/ae:bZ	I
    //   195: lload_1
    //   196: aload_3
    //   197: getfield 176	wf7/ae:bH	I
    //   200: aconst_null
    //   201: iconst_m1
    //   202: invokevirtual 190	wf7/eo:a	(IJILcom/qq/taf/jce/JceStruct;I)Ljava/lang/ref/WeakReference;
    //   205: pop
    //   206: aconst_null
    //   207: astore 4
    //   209: aconst_null
    //   210: astore 6
    //   212: goto -169 -> 43
    //   215: aload 5
    //   217: getfield 168	wf7/ed:second	Ljava/lang/Object;
    //   220: checkcast 198	wf7/du
    //   223: aload_3
    //   224: getfield 173	wf7/ae:bZ	I
    //   227: lload_1
    //   228: aload_3
    //   229: getfield 176	wf7/ae:bH	I
    //   232: aload 6
    //   234: invokeinterface 201 6 0
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
    //   0	246	5	paramed	ed<JceStruct, du, b>
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
  private void b(long paramLong, ae paramae, byte[] paramArrayOfByte, ed<JceStruct, du, b> paramed)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_3
    //   4: getfield 147	wf7/ae:data	[B
    //   7: ifnull +229 -> 236
    //   10: aload 5
    //   12: getfield 153	wf7/ed:fd	Ljava/lang/Object;
    //   15: checkcast 13	wf7/eo$b
    //   18: getfield 156	wf7/eo$b:oL	Z
    //   21: ifeq +115 -> 136
    //   24: aload_0
    //   25: getfield 136	wf7/eo:mContext	Landroid/content/Context;
    //   28: aload_0
    //   29: getfield 218	wf7/eo:lT	Lwf7/em;
    //   32: invokevirtual 224	wf7/em:cO	()Lwf7/dx;
    //   35: getfield 229	wf7/dx:lv	Ljava/lang/String;
    //   38: invokevirtual 235	java/lang/String:getBytes	()[B
    //   41: aload_3
    //   42: getfield 147	wf7/ae:data	[B
    //   45: aload_3
    //   46: getfield 160	wf7/ae:cf	I
    //   49: invokestatic 165	wf7/ee:a	(Landroid/content/Context;[B[BI)[B
    //   52: astore 4
    //   54: aload 5
    //   56: getfield 153	wf7/ed:fd	Ljava/lang/Object;
    //   59: checkcast 13	wf7/eo$b
    //   62: getfield 156	wf7/eo$b:oL	Z
    //   65: ifeq +140 -> 205
    //   68: aload 5
    //   70: getfield 168	wf7/ed:second	Ljava/lang/Object;
    //   73: checkcast 170	wf7/dv
    //   76: aload_3
    //   77: getfield 173	wf7/ae:bZ	I
    //   80: lload_1
    //   81: aload_3
    //   82: getfield 176	wf7/ae:bH	I
    //   85: aload 4
    //   87: invokeinterface 179 6 0
    //   92: astore 4
    //   94: aload 4
    //   96: ifnull +31 -> 127
    //   99: aload_0
    //   100: aload_3
    //   101: getfield 173	wf7/ae:bZ	I
    //   104: aload 4
    //   106: getfield 168	wf7/ed:second	Ljava/lang/Object;
    //   109: checkcast 181	java/lang/Integer
    //   112: invokevirtual 185	java/lang/Integer:intValue	()I
    //   115: aload 4
    //   117: getfield 153	wf7/ed:fd	Ljava/lang/Object;
    //   120: checkcast 187	com/qq/taf/jce/JceStruct
    //   123: invokevirtual 238	wf7/eo:a	(IILcom/qq/taf/jce/JceStruct;)Ljava/lang/ref/WeakReference;
    //   126: pop
    //   127: return
    //   128: astore 4
    //   130: aconst_null
    //   131: astore 4
    //   133: goto -79 -> 54
    //   136: aload 5
    //   138: getfield 193	wf7/ed:first	Ljava/lang/Object;
    //   141: ifnull +95 -> 236
    //   144: aload_0
    //   145: getfield 136	wf7/eo:mContext	Landroid/content/Context;
    //   148: aload_0
    //   149: getfield 218	wf7/eo:lT	Lwf7/em;
    //   152: invokevirtual 224	wf7/em:cO	()Lwf7/dx;
    //   155: getfield 229	wf7/dx:lv	Ljava/lang/String;
    //   158: invokevirtual 235	java/lang/String:getBytes	()[B
    //   161: aload_3
    //   162: getfield 147	wf7/ae:data	[B
    //   165: aload 5
    //   167: getfield 193	wf7/ed:first	Ljava/lang/Object;
    //   170: checkcast 187	com/qq/taf/jce/JceStruct
    //   173: iconst_1
    //   174: aload_3
    //   175: getfield 160	wf7/ae:cf	I
    //   178: invokestatic 196	wf7/ee:a	(Landroid/content/Context;[B[BLcom/qq/taf/jce/JceStruct;ZI)Lcom/qq/taf/jce/JceStruct;
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
    //   207: getfield 168	wf7/ed:second	Ljava/lang/Object;
    //   210: checkcast 198	wf7/du
    //   213: aload_3
    //   214: getfield 173	wf7/ae:bZ	I
    //   217: lload_1
    //   218: aload_3
    //   219: getfield 176	wf7/ae:bH	I
    //   222: aload 6
    //   224: invokeinterface 201 6 0
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
    //   0	242	5	paramed	ed<JceStruct, du, b>
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
      this.oo.put(Integer.valueOf(paramae.bH), new a(0, System.currentTimeMillis(), l, paramae, this.lT.cO().lv.getBytes()));
      this.nj.removeMessages(3);
      this.nj.sendEmptyMessageDelayed(3, 1800000L);
      return -1L;
      paramae = finally;
      throw paramae;
    }
    label223:
    a(l, paramae, this.lT.cO().lv.getBytes(), localed);
    if (localed.fd != null) {
      return ((b)localed.fd).lM;
    }
    return -1L;
  }
  
  public WeakReference<dz> a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, JceStruct arg9, byte[] paramArrayOfByte, JceStruct paramJceStruct2, int paramInt5, dq paramdq, dr paramdr, long paramLong3, long paramLong4)
  {
    if (paramInt3 > 0) {
      return a(paramInt3, paramLong1, paramInt4, ???, 1);
    }
    paramArrayOfByte = new c(paramInt1, paramInt2, paramLong2, paramInt4, ???, paramArrayOfByte, paramJceStruct2, paramInt5, paramdq, paramdr);
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
    localObject1 = new c(0, 0, -1L, 1103, ???, df.a((JceStruct)localObject1), null, 1073741824, null, null);
    ((c)localObject1).oP = paramInt1;
    ((c)localObject1).bY = paramLong;
    ((c)localObject1).cc = paramInt4;
    synchronized (this.op)
    {
      this.op.add(localObject1);
      if (ea.lz) {
        this.nj.sendEmptyMessage(1);
      }
      return new WeakReference(((c)localObject1).oR);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c localc = new c(Process.myPid(), 0, 0L, paramInt1, null, new byte[0], null, 1073741824, null, null);
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
        this.nP.put(Integer.valueOf(paramInt1), new ed(paramJceStruct, paramdu, new b(paramBoolean, paramLong)));
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
      this.oo.put(Integer.valueOf(paramae.bH), new a(1, System.currentTimeMillis(), 0L, paramae, this.lT.cO().lv.getBytes()));
      this.nj.removeMessages(3);
      this.nj.sendEmptyMessageDelayed(3, 1800000L);
      return -1L;
      paramae = finally;
      throw paramae;
    }
    label154:
    b(0L, paramae, this.lT.cO().lv.getBytes(), localed);
    if (localed.fd != null) {
      return ((b)localed.fd).lM;
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
  
  class a
  {
    long bY;
    long oH;
    ae oI;
    byte[] oJ;
    int oK = 0;
    
    public a(int paramInt, long paramLong1, long paramLong2, ae paramae, byte[] paramArrayOfByte)
    {
      this.oK = paramInt;
      this.oH = paramLong1;
      this.bY = paramLong2;
      this.oI = paramae;
      this.oJ = paramArrayOfByte;
    }
  }
  
  public static class b
  {
    public long lM;
    public boolean oL;
    
    public b(boolean paramBoolean, long paramLong)
    {
      this.oL = paramBoolean;
      this.lM = paramLong;
    }
  }
  
  class c
  {
    public long bY;
    public int cc;
    public int gV;
    public long nG = System.currentTimeMillis();
    public int nL;
    public byte[] oM;
    public byte[] oN;
    public dr oO;
    public int oP;
    public int oQ;
    public dz oR;
    public long oS = -1L;
    public long oT = 0L;
    public int ob;
    public long oe;
    public JceStruct of;
    public JceStruct og;
    public int oh;
    public dq oi;
    
    c(int paramInt1, int paramInt2, long paramLong, int paramInt3, JceStruct paramJceStruct1, byte[] paramArrayOfByte, JceStruct paramJceStruct2, int paramInt4, dq paramdq, dr paramdr)
    {
      this.nL = paramInt1;
      this.ob = paramInt2;
      this.oe = paramLong;
      this.gV = paramInt3;
      this.of = paramJceStruct1;
      this.oM = paramArrayOfByte;
      this.og = paramJceStruct2;
      this.oh = paramInt4;
      this.oi = paramdq;
      this.oO = paramdr;
      this.oR = new dz();
    }
    
    public boolean cW()
    {
      long l2 = Math.abs(System.currentTimeMillis() - this.nG);
      long l1;
      if (this.oS > 0L)
      {
        l1 = this.oS;
        if (l2 < l1) {
          break label50;
        }
      }
      label50:
      for (boolean bool = true;; bool = false)
      {
        if (bool) {}
        return bool;
        l1 = 180000L;
        break;
      }
    }
  }
  
  class d
    implements Runnable
  {
    private TreeMap<Integer, eo.c> oU = new TreeMap();
    private ArrayList<eo.c> oV = new ArrayList();
    private Handler oW = new eo.d.1(this, ea.getLooper());
    private Handler oX = new eo.d.2(this, ea.getLooper());
    
    private d() {}
    
    private void a(ae paramae, eo.c paramc, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
    {
      paramc.oR.setState(2);
      int i = dm.ad(paramInteger2.intValue());
      if (paramae == null)
      {
        el.cP().a("SharkProtocolQueue", paramInteger1.intValue(), paramc.oP, paramae, 30, i);
        el.cP().aj(paramc.oP);
      }
      while ((paramc.oi == null) && (paramc.oO == null))
      {
        return;
        el.cP().a("SharkProtocolQueue", paramInteger1.intValue(), paramae.ca, paramae, 30, i);
        el.cP().aj(paramae.ca);
      }
      switch (dy.af(paramc.oh))
      {
      default: 
        ea.bV().a(new eo.d.6(this, paramc, paramInteger1, i, paramInteger3), "shark callback");
        return;
      case 16: 
        if ((paramc.oO != null) && (paramc.ob > 0))
        {
          paramc.oO.a(paramc.nL, paramc.ob, paramc.oP, paramInteger1.intValue(), i, paramInteger3.intValue(), paramc.oN);
          return;
        }
        paramc.oi.a(paramc.oP, paramInteger1.intValue(), i, paramInteger3.intValue(), paramc.og);
        return;
      }
      paramae = eo.o(eo.this).obtainMessage(11, new Object[] { paramc, paramInteger1, Integer.valueOf(i), paramInteger3 });
      eo.o(eo.this).sendMessage(paramae);
    }
    
    private void an(int paramInt)
    {
      Object localObject2 = cZ();
      synchronized (this.oU)
      {
        this.oU.clear();
        ??? = ((Set)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)???).hasNext())
          {
            localObject2 = (Map.Entry)((Iterator)???).next();
            try
            {
              a(null, (eo.c)((Map.Entry)localObject2).getValue(), Integer.valueOf(((eo.c)((Map.Entry)localObject2).getValue()).gV), Integer.valueOf(paramInt), Integer.valueOf(-1));
            }
            catch (Exception localException) {}
          }
        }
      }
    }
    
    private void b(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList<ae> paramArrayList)
    {
      if (paramInt1 == 0)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          ae localae = (ae)paramArrayList.next();
          if (am(localae.ca)) {
            d(localae);
          } else if (eo.b(localae)) {
            eo.this.a(paramBoolean, paramInt2, localae);
          } else if (eo.c(localae)) {
            eo.this.b(paramBoolean, paramInt2, localae);
          }
        }
      }
      an(paramInt1);
    }
    
    private void d(ae paramae)
    {
      Object localObject6 = null;
      Object localObject1 = null;
      Object localObject4 = null;
      this.oW.removeMessages(paramae.ca);
      eo.c localc;
      synchronized (this.oU)
      {
        localc = (eo.c)this.oU.get(Integer.valueOf(paramae.ca));
        if (localc == null) {
          return;
        }
        this.oU.remove(Integer.valueOf(paramae.ca));
        if ((paramae.data == null) || (paramae.cc != 0)) {}
      }
      for (;;)
      {
        Object localObject3;
        try
        {
          if ((localc.oO != null) && (localc.ob > 0))
          {
            ??? = ee.a(eo.n(eo.this), eo.m(eo.this).cO().lv.getBytes(), paramae.data, paramae.cf);
            localObject1 = localObject4;
            localObject4 = ???;
            localObject6 = localObject1;
            if (localObject1 == null)
            {
              localObject4 = ???;
              localObject6 = localObject1;
              if (??? == null)
              {
                localObject4 = ???;
                localObject6 = localObject1;
              }
            }
          }
        }
        catch (Exception localException1)
        {
          localObject3 = null;
        }
        try
        {
          if (localc.og != null)
          {
            paramae.cc = dm.ad(-11000300);
            localObject6 = localObject1;
            localObject4 = ???;
          }
          if (localc.oN != localObject4) {
            localc.oN = localObject4;
          }
          if (localc.og != localObject6) {
            localc.og = localObject6;
          }
          try
          {
            a(paramae, localc, Integer.valueOf(paramae.bH), Integer.valueOf(paramae.cc), Integer.valueOf(paramae.cd));
            return;
          }
          catch (Exception paramae)
          {
            return;
          }
          paramae = finally;
          throw paramae;
        }
        catch (Exception localException2)
        {
          break label309;
        }
        ??? = ee.a(eo.n(eo.this), eo.m(eo.this).cO().lv.getBytes(), paramae.data, localc.og, false, paramae.cf);
        localObject1 = ???;
        ??? = null;
        continue;
        label309:
        paramae.cc = dm.ad(-11000900);
        localObject4 = localObject3;
        localObject6 = localObject1;
        continue;
        Object localObject5 = null;
      }
    }
    
    public void a(Integer paramInteger, eo.c paramc)
    {
      this.oU.put(paramInteger, paramc);
    }
    
    public boolean am(int paramInt)
    {
      synchronized (this.oU)
      {
        boolean bool = this.oU.containsKey(Integer.valueOf(paramInt));
        return bool;
      }
    }
    
    public Set<Map.Entry<Integer, eo.c>> cZ()
    {
      synchronized (this.oU)
      {
        TreeMap localTreeMap2 = (TreeMap)this.oU.clone();
        return localTreeMap2.entrySet();
      }
    }
    
    public void run()
    {
      long l = 0L;
      label522:
      label564:
      label844:
      label976:
      for (;;)
      {
        ArrayList localArrayList2;
        ArrayList localArrayList3;
        dx localdx;
        Object localObject1;
        try
        {
          ArrayList localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          new ArrayList();
          localArrayList3 = new ArrayList();
          localdx = eo.m(eo.this).cO();
          localIterator = cZ().iterator();
          if (!localIterator.hasNext()) {
            break label564;
          }
          localObject1 = (Map.Entry)localIterator.next();
          if (((eo.c)((Map.Entry)localObject1).getValue()).oR.cq()) {
            break label976;
          }
          if (((eo.c)((Map.Entry)localObject1).getValue()).cW())
          {
            this.oX.obtainMessage(1, ((eo.c)((Map.Entry)localObject1).getValue()).oP, ((eo.c)((Map.Entry)localObject1).getValue()).gV).sendToTarget();
            continue;
          }
          ((eo.c)((Map.Entry)localObject1).getValue()).oR.setState(1);
        }
        catch (Exception localException1)
        {
          an(-10001200);
          return;
        }
        x localx = new x();
        localx.bH = ((eo.c)((Map.Entry)localObject1).getValue()).gV;
        localx.bZ = ((eo.c)((Map.Entry)localObject1).getValue()).oP;
        localx.cb = ((eo.c)((Map.Entry)localObject1).getValue()).oe;
        localx.ca = 0;
        localx.data = null;
        Object localObject2;
        if ((!TextUtils.isEmpty(localdx.lv)) || (((eo.c)((Map.Entry)localObject1).getValue()).oM != null))
        {
          localObject2 = ((eo.c)((Map.Entry)localObject1).getValue()).oM;
          localx.data = ee.a(eo.n(eo.this), (byte[])localObject2, localx.bH, localx);
          if (((eo.c)((Map.Entry)localObject1).getValue()).oS > 0L)
          {
            localObject2 = new eq(localx.bH);
            localObject2 = Message.obtain(this.oW, localx.bZ, localObject2);
            this.oW.sendMessageDelayed((Message)localObject2, ((eo.c)((Map.Entry)localObject1).getValue()).oS);
          }
          if ((((eo.c)((Map.Entry)localObject1).getValue()).oh & 0x800) == 0) {
            break label522;
          }
          localException1.add(localx);
        }
        for (;;)
        {
          el.cP().a("SharkProtocolQueue", localx.bH, localx.bZ, localx, 0);
          if (((eo.c)((Map.Entry)localObject1).getValue()).oT <= l) {
            break label976;
          }
          l = ((eo.c)((Map.Entry)localObject1).getValue()).oT;
          break label976;
          localObject2 = ((eo.c)((Map.Entry)localObject1).getValue()).of;
          localx.data = ee.a(eo.n(eo.this), (JceStruct)localObject2, localx.bH, localx);
          break;
          if ((((eo.c)((Map.Entry)localObject1).getValue()).oh & 0x200) != 0) {
            localArrayList2.add(localx);
          } else {
            localArrayList3.add(localx);
          }
        }
        Iterator localIterator = this.oV.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject1 = (eo.c)localIterator.next();
            if (((eo.c)localObject1).cW())
            {
              if (((eo.c)localObject1).gV != 1103) {
                continue;
              }
              continue;
            }
            localx = new x();
            localx.bH = ((eo.c)localObject1).gV;
            localx.bZ = ew.dg().di();
            localx.ca = ((eo.c)localObject1).oP;
            localx.data = null;
            localx.cc = ((eo.c)localObject1).cc;
            localx.cd = ((eo.c)localObject1).oQ;
            localObject2 = new w();
            ((w)localObject2).bY = ((eo.c)localObject1).bY;
            localx.ce = ((w)localObject2);
            boolean bool = TextUtils.isEmpty(localdx.lv);
            if (bool) {}
            try
            {
              if (((eo.c)localObject1).oM != null) {
                localObject2 = ((eo.c)localObject1).oM;
              }
              for (localx.data = ee.a(eo.n(eo.this), (byte[])localObject2, localx.bH, localx);; localx.data = ee.a(eo.n(eo.this), (JceStruct)localObject2, localx.bH, localx))
              {
                if ((((eo.c)localObject1).oh & 0x800) == 0) {
                  break label844;
                }
                localException1.add(localx);
                el.cP().a("SharkProtocolQueue", localx.bH, localx.bZ, localx, 0);
                break;
                localObject2 = ((eo.c)localObject1).of;
              }
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                continue;
                if ((((eo.c)localObject1).oh & 0x200) != 0) {
                  localArrayList2.add(localx);
                } else {
                  localArrayList3.add(localx);
                }
              }
            }
          }
        }
        if (localException1.size() > 0) {
          eo.m(eo.this).a(2048, l, true, localException1, new eo.d.3(this));
        }
        if (localArrayList2.size() > 0) {
          eo.m(eo.this).a(512, l, true, localArrayList2, new eo.d.4(this));
        }
        if (localArrayList3.size() > 0)
        {
          eo.m(eo.this).a(0, l, true, localArrayList3, new eo.d.5(this));
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.eo
 * JD-Core Version:    0.7.0.1
 */