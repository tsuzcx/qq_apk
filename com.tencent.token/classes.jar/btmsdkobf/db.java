package btmsdkobf;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class db
  implements cy.c, cy.d, cy.e
{
  private static volatile db li = null;
  private static int lj = 0;
  private static final long[] lk = { 100L, 60000L, 120000L };
  private final String TAG = "SharkProtocolQueue";
  private cy hF;
  private cl he;
  private ExecutorService jn;
  private Handler jy = new hb(this, cx.getLooper());
  private List kP = new ArrayList();
  private ArrayList kQ = new ArrayList();
  private dn kR = new dn(1000);
  private dl kS;
  private boolean kT = false;
  private boolean kU = false;
  private boolean kV = false;
  private boolean kW = false;
  private boolean kX = false;
  private boolean kY = false;
  private boolean kZ = false;
  private TreeMap kq = new TreeMap();
  private Handler kr = new ha(this, Looper.getMainLooper());
  private boolean la = false;
  private boolean lb = false;
  private LinkedList ld = null;
  private boolean le = false;
  private boolean lf = false;
  private boolean lg = false;
  private boolean lh = false;
  private List ll = new ArrayList();
  private List lm = new ArrayList();
  private List ln = new ArrayList();
  private he lo = null;
  private Context mContext = bc.n();
  
  /* Error */
  private void a(long paramLong, ba paramba, byte[] paramArrayOfByte, dj paramdj)
  {
    // Byte code:
    //   0: aload_3
    //   1: getfield 183	btmsdkobf/ba:data	[B
    //   4: ifnull +311 -> 315
    //   7: aload 5
    //   9: getfield 189	btmsdkobf/dj:mU	Ljava/lang/Object;
    //   12: checkcast 191	btmsdkobf/db$c
    //   15: getfield 194	btmsdkobf/db$c:lE	Z
    //   18: ifeq +208 -> 226
    //   21: aload_0
    //   22: getfield 168	btmsdkobf/db:mContext	Landroid/content/Context;
    //   25: aload 4
    //   27: aload_3
    //   28: getfield 183	btmsdkobf/ba:data	[B
    //   31: aload_3
    //   32: getfield 197	btmsdkobf/ba:di	I
    //   35: invokestatic 202	btmsdkobf/cd:a	(Landroid/content/Context;[B[BI)[B
    //   38: astore 4
    //   40: aconst_null
    //   41: astore 6
    //   43: aload 5
    //   45: getfield 189	btmsdkobf/dj:mU	Ljava/lang/Object;
    //   48: checkcast 191	btmsdkobf/db$c
    //   51: getfield 194	btmsdkobf/db$c:lE	Z
    //   54: ifeq +270 -> 324
    //   57: aload 5
    //   59: getfield 205	btmsdkobf/dj:second	Ljava/lang/Object;
    //   62: checkcast 207	btmsdkobf/cn
    //   65: aload_3
    //   66: getfield 210	btmsdkobf/ba:dc	I
    //   69: lload_1
    //   70: aload_3
    //   71: getfield 213	btmsdkobf/ba:bM	I
    //   74: aload 4
    //   76: invokeinterface 216 6 0
    //   81: astore 4
    //   83: aload 4
    //   85: ifnull +268 -> 353
    //   88: ldc 80
    //   90: new 218	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   97: ldc 221
    //   99: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: lload_1
    //   103: invokevirtual 228	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   106: ldc 230
    //   108: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 4
    //   113: getfield 205	btmsdkobf/dj:second	Ljava/lang/Object;
    //   116: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   119: ldc 235
    //   121: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 4
    //   126: getfield 189	btmsdkobf/dj:mU	Ljava/lang/Object;
    //   129: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 245	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload_0
    //   139: aload_3
    //   140: getfield 210	btmsdkobf/ba:dc	I
    //   143: lload_1
    //   144: aload 4
    //   146: getfield 205	btmsdkobf/dj:second	Ljava/lang/Object;
    //   149: checkcast 247	java/lang/Integer
    //   152: invokevirtual 251	java/lang/Integer:intValue	()I
    //   155: aload 4
    //   157: getfield 189	btmsdkobf/dj:mU	Ljava/lang/Object;
    //   160: checkcast 253	com/qq/taf/jce/JceStruct
    //   163: aconst_null
    //   164: iconst_1
    //   165: invokevirtual 256	btmsdkobf/db:a	(IJILcom/qq/taf/jce/JceStruct;[BI)Ljava/lang/ref/WeakReference;
    //   168: pop
    //   169: return
    //   170: astore 4
    //   172: ldc 80
    //   174: new 218	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   181: ldc_w 258
    //   184: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 4
    //   189: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: aload 4
    //   197: invokestatic 261	btmsdkobf/eh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   200: aload_0
    //   201: aload_3
    //   202: getfield 210	btmsdkobf/ba:dc	I
    //   205: lload_1
    //   206: aload_3
    //   207: getfield 213	btmsdkobf/ba:bM	I
    //   210: aconst_null
    //   211: aconst_null
    //   212: iconst_m1
    //   213: invokevirtual 256	btmsdkobf/db:a	(IJILcom/qq/taf/jce/JceStruct;[BI)Ljava/lang/ref/WeakReference;
    //   216: pop
    //   217: aconst_null
    //   218: astore 4
    //   220: aconst_null
    //   221: astore 6
    //   223: goto -180 -> 43
    //   226: aload 5
    //   228: getfield 264	btmsdkobf/dj:first	Ljava/lang/Object;
    //   231: ifnull +84 -> 315
    //   234: aload_0
    //   235: getfield 168	btmsdkobf/db:mContext	Landroid/content/Context;
    //   238: aload 4
    //   240: aload_3
    //   241: getfield 183	btmsdkobf/ba:data	[B
    //   244: aload 5
    //   246: getfield 264	btmsdkobf/dj:first	Ljava/lang/Object;
    //   249: checkcast 253	com/qq/taf/jce/JceStruct
    //   252: iconst_1
    //   253: aload_3
    //   254: getfield 197	btmsdkobf/ba:di	I
    //   257: invokestatic 267	btmsdkobf/cd:a	(Landroid/content/Context;[B[BLcom/qq/taf/jce/JceStruct;ZI)Lcom/qq/taf/jce/JceStruct;
    //   260: astore 6
    //   262: aconst_null
    //   263: astore 4
    //   265: goto -222 -> 43
    //   268: astore 4
    //   270: ldc 80
    //   272: new 218	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   279: ldc_w 269
    //   282: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload 4
    //   287: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: aload 4
    //   295: invokestatic 261	btmsdkobf/eh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   298: aload_0
    //   299: aload_3
    //   300: getfield 210	btmsdkobf/ba:dc	I
    //   303: lload_1
    //   304: aload_3
    //   305: getfield 213	btmsdkobf/ba:bM	I
    //   308: aconst_null
    //   309: aconst_null
    //   310: iconst_m1
    //   311: invokevirtual 256	btmsdkobf/db:a	(IJILcom/qq/taf/jce/JceStruct;[BI)Ljava/lang/ref/WeakReference;
    //   314: pop
    //   315: aconst_null
    //   316: astore 4
    //   318: aconst_null
    //   319: astore 6
    //   321: goto -278 -> 43
    //   324: aload 5
    //   326: getfield 205	btmsdkobf/dj:second	Ljava/lang/Object;
    //   329: checkcast 271	btmsdkobf/cm
    //   332: aload_3
    //   333: getfield 210	btmsdkobf/ba:dc	I
    //   336: lload_1
    //   337: aload_3
    //   338: getfield 213	btmsdkobf/ba:bM	I
    //   341: aload 6
    //   343: invokeinterface 274 6 0
    //   348: astore 4
    //   350: goto -267 -> 83
    //   353: ldc 80
    //   355: new 218	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   362: ldc_w 276
    //   365: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: lload_1
    //   369: invokevirtual 228	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   372: ldc 230
    //   374: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: aload_3
    //   378: getfield 213	btmsdkobf/ba:bM	I
    //   381: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   384: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 245	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: return
    //   391: astore_3
    //   392: ldc 80
    //   394: new 218	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   401: ldc_w 281
    //   404: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload_3
    //   408: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: aload_3
    //   415: invokestatic 261	btmsdkobf/eh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   418: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	this	db
    //   0	419	1	paramLong	long
    //   0	419	3	paramba	ba
    //   0	419	4	paramArrayOfByte	byte[]
    //   0	419	5	paramdj	dj
    //   41	301	6	localJceStruct	JceStruct
    // Exception table:
    //   from	to	target	type
    //   21	40	170	java/lang/Exception
    //   234	262	268	java/lang/Exception
    //   43	83	391	java/lang/Exception
    //   88	169	391	java/lang/Exception
    //   324	350	391	java/lang/Exception
    //   353	390	391	java/lang/Exception
  }
  
  public static boolean a(ba paramba)
  {
    if (paramba == null) {}
    while (paramba.dd == 0) {
      return false;
    }
    return true;
  }
  
  private void b(int paramInt, cs.b paramb)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.ln)
    {
      if (this.ln.size() > 0) {
        localArrayList.addAll(this.ln);
      }
      if (localArrayList.size() > 0)
      {
        ??? = localArrayList.iterator();
        if (((Iterator)???).hasNext()) {
          ((gm)((Iterator)???).next()).a(paramInt, paramb);
        }
      }
    }
  }
  
  /* Error */
  private void b(long paramLong, ba paramba, byte[] paramArrayOfByte, dj paramdj)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_3
    //   4: getfield 183	btmsdkobf/ba:data	[B
    //   7: ifnull +248 -> 255
    //   10: aload 5
    //   12: getfield 189	btmsdkobf/dj:mU	Ljava/lang/Object;
    //   15: checkcast 191	btmsdkobf/db$c
    //   18: getfield 194	btmsdkobf/db$c:lE	Z
    //   21: ifeq +143 -> 164
    //   24: aload_0
    //   25: getfield 168	btmsdkobf/db:mContext	Landroid/content/Context;
    //   28: aload_0
    //   29: getfield 328	btmsdkobf/db:hF	Lbtmsdkobf/cy;
    //   32: invokevirtual 334	btmsdkobf/cy:ai	()Lbtmsdkobf/cs$b;
    //   35: getfield 339	btmsdkobf/cs$b:is	Ljava/lang/String;
    //   38: invokevirtual 345	java/lang/String:getBytes	()[B
    //   41: aload_3
    //   42: getfield 183	btmsdkobf/ba:data	[B
    //   45: aload_3
    //   46: getfield 197	btmsdkobf/ba:di	I
    //   49: invokestatic 202	btmsdkobf/cd:a	(Landroid/content/Context;[B[BI)[B
    //   52: astore 4
    //   54: aload 5
    //   56: getfield 189	btmsdkobf/dj:mU	Ljava/lang/Object;
    //   59: checkcast 191	btmsdkobf/db$c
    //   62: getfield 194	btmsdkobf/db$c:lE	Z
    //   65: ifeq +196 -> 261
    //   68: aload 5
    //   70: getfield 205	btmsdkobf/dj:second	Ljava/lang/Object;
    //   73: checkcast 207	btmsdkobf/cn
    //   76: aload_3
    //   77: getfield 210	btmsdkobf/ba:dc	I
    //   80: lload_1
    //   81: aload_3
    //   82: getfield 213	btmsdkobf/ba:bM	I
    //   85: aload 4
    //   87: invokeinterface 216 6 0
    //   92: astore 4
    //   94: aload 4
    //   96: ifnull +31 -> 127
    //   99: aload_0
    //   100: aload_3
    //   101: getfield 210	btmsdkobf/ba:dc	I
    //   104: aload 4
    //   106: getfield 205	btmsdkobf/dj:second	Ljava/lang/Object;
    //   109: checkcast 247	java/lang/Integer
    //   112: invokevirtual 251	java/lang/Integer:intValue	()I
    //   115: aload 4
    //   117: getfield 189	btmsdkobf/dj:mU	Ljava/lang/Object;
    //   120: checkcast 253	com/qq/taf/jce/JceStruct
    //   123: invokevirtual 348	btmsdkobf/db:a	(IILcom/qq/taf/jce/JceStruct;)Ljava/lang/ref/WeakReference;
    //   126: pop
    //   127: return
    //   128: astore 4
    //   130: ldc 80
    //   132: new 218	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 350
    //   142: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload 4
    //   147: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: aload 4
    //   155: invokestatic 261	btmsdkobf/eh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: aconst_null
    //   159: astore 4
    //   161: goto -107 -> 54
    //   164: aload 5
    //   166: getfield 264	btmsdkobf/dj:first	Ljava/lang/Object;
    //   169: ifnull +86 -> 255
    //   172: aload_0
    //   173: getfield 168	btmsdkobf/db:mContext	Landroid/content/Context;
    //   176: aload_0
    //   177: getfield 328	btmsdkobf/db:hF	Lbtmsdkobf/cy;
    //   180: invokevirtual 334	btmsdkobf/cy:ai	()Lbtmsdkobf/cs$b;
    //   183: getfield 339	btmsdkobf/cs$b:is	Ljava/lang/String;
    //   186: invokevirtual 345	java/lang/String:getBytes	()[B
    //   189: aload_3
    //   190: getfield 183	btmsdkobf/ba:data	[B
    //   193: aload 5
    //   195: getfield 264	btmsdkobf/dj:first	Ljava/lang/Object;
    //   198: checkcast 253	com/qq/taf/jce/JceStruct
    //   201: iconst_1
    //   202: aload_3
    //   203: getfield 197	btmsdkobf/ba:di	I
    //   206: invokestatic 267	btmsdkobf/cd:a	(Landroid/content/Context;[B[BLcom/qq/taf/jce/JceStruct;ZI)Lcom/qq/taf/jce/JceStruct;
    //   209: astore 4
    //   211: aconst_null
    //   212: astore 7
    //   214: aload 4
    //   216: astore 6
    //   218: aload 7
    //   220: astore 4
    //   222: goto -168 -> 54
    //   225: astore 4
    //   227: ldc 80
    //   229: new 218	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 352
    //   239: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 4
    //   244: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: aload 4
    //   252: invokestatic 261	btmsdkobf/eh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   255: aconst_null
    //   256: astore 4
    //   258: goto -204 -> 54
    //   261: aload 5
    //   263: getfield 205	btmsdkobf/dj:second	Ljava/lang/Object;
    //   266: checkcast 271	btmsdkobf/cm
    //   269: aload_3
    //   270: getfield 210	btmsdkobf/ba:dc	I
    //   273: lload_1
    //   274: aload_3
    //   275: getfield 213	btmsdkobf/ba:bM	I
    //   278: aload 6
    //   280: invokeinterface 274 6 0
    //   285: astore 4
    //   287: goto -193 -> 94
    //   290: astore_3
    //   291: ldc 80
    //   293: new 218	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   300: ldc_w 354
    //   303: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_3
    //   307: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: aload_3
    //   314: invokestatic 261	btmsdkobf/eh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   317: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	db
    //   0	318	1	paramLong	long
    //   0	318	3	paramba	ba
    //   0	318	4	paramArrayOfByte	byte[]
    //   0	318	5	paramdj	dj
    //   1	278	6	arrayOfByte	byte[]
    //   212	7	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   24	54	128	java/lang/Exception
    //   172	211	225	java/lang/Exception
    //   54	94	290	java/lang/Exception
    //   99	127	290	java/lang/Exception
    //   261	287	290	java/lang/Exception
  }
  
  public static boolean b(ba paramba)
  {
    if (paramba == null) {}
    while ((paramba.dd != 0) || (paramba.ds == null) || (paramba.ds.db == 0L)) {
      return false;
    }
    return true;
  }
  
  public static db bZ()
  {
    if (li == null) {}
    try
    {
      if (li == null) {
        li = new db();
      }
      return li;
    }
    finally {}
  }
  
  public static boolean c(ba paramba)
  {
    if (paramba == null) {}
    while ((a(paramba)) || (b(paramba))) {
      return false;
    }
    return true;
  }
  
  private void f(int paramInt, String paramString)
  {
    Object localObject = new ArrayList();
    synchronized (this.ll)
    {
      if (this.ll.size() > 0)
      {
        ((List)localObject).addAll(this.ll);
        this.ll.clear();
      }
    }
    synchronized (this.lm)
    {
      if (this.lm.size() > 0) {
        ((List)localObject).addAll(this.lm);
      }
      if (((List)localObject).size() > 0)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ((ch)((Iterator)localObject).next()).e(paramInt, paramString);
          continue;
          paramString = finally;
          throw paramString;
        }
      }
    }
  }
  
  public long a(boolean paramBoolean, int paramInt, ba paramba)
  {
    if ((paramba == null) || (!b(paramba))) {
      return -1L;
    }
    long l = 0L;
    if (paramba.ds != null) {
      l = paramba.ds.db;
    }
    eh.e("SharkProtocolQueue", "[shark_push]onPush(), ECmd: " + paramba.bM + " seqNo: " + paramba.dc + " pushId: " + l + " isTcpChannel: " + paramBoolean);
    a(l, paramba.bM, paramInt, paramba.dc, -1000000001);
    if (paramba.df != 0)
    {
      eh.h("SharkProtocolQueue", "[shark_push]onPush(), push with error, drop it, ECmd: " + paramba.bM + " seqNo: " + paramba.dc + " pushId: " + l + " isTcpChannel: " + paramBoolean + " retCode: " + paramba.df);
      return -1L;
    }
    if (this.kR.b(Long.valueOf(l)))
    {
      eh.g("SharkProtocolQueue", "[shark_push]onPush(), push duplicate, drop it, ECmd: " + paramba.bM + " seqNo: " + paramba.dc + " pushId: " + l);
      return -1L;
    }
    this.kR.push(Long.valueOf(l));
    dj localdj;
    synchronized (this.kq)
    {
      localdj = (dj)this.kq.get(Integer.valueOf(paramba.bM));
      if (localdj != null) {
        break label528;
      }
    }
    for (;;)
    {
      synchronized (this.kP)
      {
        this.kP.add(new hg(this, 0, System.currentTimeMillis(), l, paramba, this.hF.ai().is.getBytes()));
        paramInt = this.kP.size();
        eh.g("SharkProtocolQueue", "[shark_push]onPush(), nobody listen to it, ECmd: " + paramba.bM + " seqNo: " + paramba.dc + " pushId: " + l + " cache for " + 600 + "s" + " pushSize: " + paramInt);
        this.jy.removeMessages(3);
        if (paramInt >= 20)
        {
          this.jy.sendEmptyMessageDelayed(3, 2000L);
          this.jy.sendEmptyMessageDelayed(3, 600000L);
          return -1L;
          paramba = finally;
          throw paramba;
        }
      }
      this.jy.sendEmptyMessageDelayed(3, 600000L);
    }
    label528:
    eh.e("SharkProtocolQueue", "[shark_push]onPush(), someone listen to it, callback now, ECmd: " + paramba.bM + " seqNo: " + paramba.dc + " pushId: " + l);
    a(l, paramba, this.hF.ai().is.getBytes(), localdj);
    if (localdj.mU != null) {
      return ((db.c)localdj.mU).t;
    }
    return -1L;
  }
  
  public WeakReference a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, JceStruct arg9, byte[] paramArrayOfByte, JceStruct paramJceStruct2, int paramInt5, cj paramcj, ck paramck, long paramLong3, long paramLong4)
  {
    eh.e("SharkProtocolQueue", "sendShark() cmdId: " + paramInt4 + " pushSeqNo: " + paramInt3);
    if (paramInt3 > 0) {
      return a(paramInt3, paramLong1, paramInt4, ???, paramArrayOfByte, 1);
    }
    paramArrayOfByte = new hh(this, paramInt1, paramInt2, paramLong2, paramInt4, ???, paramArrayOfByte, paramJceStruct2, paramInt5, paramcj, paramck);
    paramArrayOfByte.l = cu.bu().bm();
    paramArrayOfByte.p = paramLong3;
    paramArrayOfByte.q = paramLong4;
    synchronized (this.kQ)
    {
      this.kQ.add(paramArrayOfByte);
      cv.by().a(paramArrayOfByte.l, paramLong3, null);
      if (cx.iT) {
        this.jy.sendEmptyMessage(1);
      }
      return new WeakReference(paramArrayOfByte.o);
    }
  }
  
  public WeakReference a(int paramInt1, int paramInt2, JceStruct paramJceStruct)
  {
    eh.f("SharkProtocolQueue", "[shark_push]sendGiftResp(): giftSeqNo: " + paramInt1 + " acmdId: " + paramInt2 + " respStruct: " + paramJceStruct);
    if (paramInt2 == 156) {
      eh.i("SharkProtocolQueue", "[ip_list]sendGiftResp(): giftSeqNo: " + paramInt1 + " acmdId: " + paramInt2 + " respStruct: " + paramJceStruct);
    }
    return cx.bE().a(paramInt2, paramJceStruct, null, 0, new hd(this, paramInt2));
  }
  
  public WeakReference a(int paramInt1, long paramLong, int paramInt2, JceStruct paramJceStruct, byte[] paramArrayOfByte, int paramInt3)
  {
    return a(paramInt1, paramLong, paramInt2, paramJceStruct, paramArrayOfByte, paramInt3, 0);
  }
  
  public WeakReference a(int paramInt1, long paramLong, int paramInt2, JceStruct arg5, byte[] paramArrayOfByte, int paramInt3, int paramInt4)
  {
    eh.e("SharkProtocolQueue", "[shark_push]sendPushResp(), pushSeqNo: " + paramInt1 + " pushId: " + paramLong + " cmdId: " + paramInt2 + " result: " + paramInt3 + " retCode: " + paramInt4);
    ak localak = new ak();
    localak.bM = paramInt2;
    localak.status = paramInt3;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      localak.bN = paramArrayOfByte;
    }
    for (;;)
    {
      paramArrayOfByte = new hh(this, 0, 0, -1L, 1103, ???, cd.a(localak), null, 1073741824, null, null);
      paramArrayOfByte.l = paramInt1;
      paramArrayOfByte.r = paramLong;
      paramArrayOfByte.m = paramInt4;
      synchronized (this.kQ)
      {
        this.kQ.add(paramArrayOfByte);
        if (cx.iT) {
          this.jy.sendEmptyMessage(1);
        }
        return new WeakReference(paramArrayOfByte.o);
        if (??? == null) {
          continue;
        }
        localak.bN = cp.b(???);
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    eh.e("SharkProtocolQueue", "autoReplyPush()  pushId: " + paramLong + " cmdId: " + paramInt1 + " serverSharkSeqNo: " + paramInt2 + " serverSashimiSeqNo: " + paramInt3 + " errCode: " + paramInt4);
    hh localhh = new hh(this, Process.myPid(), 0, 0L, paramInt1, null, new byte[0], null, 1073741824, null, null);
    localhh.m = paramInt4;
    localhh.l = paramInt3;
    localhh.r = paramLong;
    synchronized (this.kQ)
    {
      this.kQ.add(localhh);
      if (cx.iT) {
        this.jy.sendEmptyMessage(1);
      }
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, JceStruct paramJceStruct, int paramInt2, cm paramcm, boolean paramBoolean)
  {
    if (paramcm == null) {}
    for (;;)
    {
      return;
      synchronized (this.kq)
      {
        this.kq.put(Integer.valueOf(paramInt1), new dj(paramJceStruct, paramcm, new db.c(paramBoolean, paramLong)));
        eh.e("SharkProtocolQueue", "[shark_push]registerSharkPush(), for cmd: " + paramInt1);
        if (!cx.iT) {
          continue;
        }
        this.jy.obtainMessage(5, paramInt1, 0).sendToTarget();
        return;
      }
    }
  }
  
  public void a(ch paramch)
  {
    if (paramch == null) {
      return;
    }
    synchronized (this.lm)
    {
      if (!this.lm.contains(paramch)) {
        this.lm.add(paramch);
      }
      return;
    }
  }
  
  public void a(dl paramdl, long paramLong)
  {
    if (paramdl == null) {}
    do
    {
      return;
      eh.f("SharkProtocolQueue", "[shark_vip] setVipRule(): " + paramdl + ", valid time(ms): " + paramLong);
      this.kS = paramdl;
      this.jy.removeMessages(6);
    } while (paramLong <= 0L);
    this.jy.sendEmptyMessageDelayed(6, paramLong);
  }
  
  public void a(gm paramgm)
  {
    if (paramgm == null) {
      return;
    }
    synchronized (this.ln)
    {
      if (!this.ln.contains(paramgm)) {
        this.ln.add(paramgm);
      }
      return;
    }
  }
  
  public void at()
  {
    eh.f("SharkProtocolQueue", "[shark_init]initAsync()");
    this.hF = new cy(bc.n(), this.he, this, this, this, cx.bB(), cx.bC());
    this.jn = Executors.newSingleThreadExecutor();
    cv.by().b(this.he);
    this.jy.sendEmptyMessage(2);
  }
  
  public void av()
  {
    if (cx.iT)
    {
      this.hF.bO();
      return;
    }
    this.lb = true;
  }
  
  public long b(boolean paramBoolean, int paramInt, ba paramba)
  {
    if ((paramba == null) || (!c(paramba))) {
      return -1L;
    }
    eh.e("SharkProtocolQueue", "[shark_push]onGotGift(), ECmd: " + paramba.bM + " seqNo: " + paramba.dc + " pushId: " + 0L + " isTcpChannel: " + paramBoolean);
    if (paramba.df != 0)
    {
      eh.h("SharkProtocolQueue", "[shark_push]onGotGift(), gift with error, drop it, ECmd: " + paramba.bM + " seqNo: " + paramba.dc + " pushId: " + 0L + " isTcpChannel: " + paramBoolean + " retCode: " + paramba.df);
      return -1L;
    }
    dj localdj;
    synchronized (this.kq)
    {
      localdj = (dj)this.kq.get(Integer.valueOf(paramba.bM));
      if (localdj != null) {
        break label394;
      }
    }
    for (;;)
    {
      synchronized (this.kP)
      {
        this.kP.add(new hg(this, 1, System.currentTimeMillis(), 0L, paramba, this.hF.ai().is.getBytes()));
        paramInt = this.kP.size();
        eh.g("SharkProtocolQueue", "[shark_push]onGotGift(), nobody listen to it, ECmd: " + paramba.bM + " seqNo: " + paramba.dc + " cache for " + 600 + "s" + " pushSize: " + paramInt);
        this.jy.removeMessages(3);
        if (paramInt >= 20)
        {
          this.jy.sendEmptyMessageDelayed(3, 2000L);
          this.jy.sendEmptyMessageDelayed(3, 600000L);
          return -1L;
          paramba = finally;
          throw paramba;
        }
      }
      this.jy.sendEmptyMessageDelayed(3, 600000L);
    }
    label394:
    eh.e("SharkProtocolQueue", "[shark_push]onGotGift(), someone listen to it, callback now, ECmd: " + paramba.bM + " seqNo: " + paramba.dc);
    b(0L, paramba, this.hF.ai().is.getBytes(), localdj);
    if (localdj.mU != null) {
      return ((db.c)localdj.mU).t;
    }
    return -1L;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (cx.iT)
    {
      this.hF.b(paramInt1, paramInt2, paramInt3);
      return;
    }
    if (this.ld == null) {
      this.ld = new LinkedList();
    }
    this.ld.add(new fr(paramInt1, paramInt2, paramInt3));
  }
  
  public void b(ch paramch)
  {
    if (paramch == null) {
      return;
    }
    synchronized (this.lm)
    {
      if (this.lm.contains(paramch)) {
        this.lm.remove(paramch);
      }
      return;
    }
  }
  
  public void b(gm paramgm)
  {
    if (paramgm == null) {
      return;
    }
    synchronized (this.ln)
    {
      if (this.ln.contains(paramgm)) {
        this.ln.remove(paramgm);
      }
      return;
    }
  }
  
  public void bH()
  {
    if (cx.iT)
    {
      this.hF.bH();
      return;
    }
    this.kW = true;
  }
  
  public cl bL()
  {
    return this.he;
  }
  
  public void bM()
  {
    if (cx.iT)
    {
      this.hF.bM();
      return;
    }
    this.kZ = true;
  }
  
  public void bN()
  {
    if (cx.iT)
    {
      this.hF.bN();
      return;
    }
    this.la = true;
  }
  
  void bY()
  {
    if (cx.iT)
    {
      this.jy.removeMessages(4);
      this.jy.sendEmptyMessage(4);
      return;
    }
    this.le = true;
  }
  
  public void c(cl paramcl)
  {
    eh.e("SharkProtocolQueue", "[shark_init]initSync()");
    this.he = paramcl;
    try
    {
      if (this.lo == null)
      {
        this.lo = new he(this, null);
        he.a(this.lo, this.mContext);
        eh.e("SharkProtocolQueue", "[shark_init][cu_guid][rsa_key] initSync(), register guid & rsakey event");
      }
      return;
    }
    finally {}
  }
  
  public void ca()
  {
    if (cx.iT)
    {
      this.hF.f(1000L);
      return;
    }
    this.kV = true;
  }
  
  public void cb()
  {
    if (!cx.ax()) {
      return;
    }
    if (cx.iT)
    {
      this.hF.bJ().cb();
      return;
    }
    this.kY = true;
  }
  
  public void cc()
  {
    if (!cx.ax()) {
      return;
    }
    if (cx.iT)
    {
      this.hF.bJ().cc();
      return;
    }
    this.lg = true;
  }
  
  public void cd()
  {
    if (!cx.ax()) {
      return;
    }
    if (cx.iT)
    {
      this.hF.bJ().cd();
      return;
    }
    this.lh = true;
  }
  
  public cm e(int paramInt1, int paramInt2)
  {
    cm localcm = null;
    synchronized (this.kq)
    {
      if (this.kq.containsKey(Integer.valueOf(paramInt1))) {
        localcm = (cm)((dj)this.kq.remove(Integer.valueOf(paramInt1))).second;
      }
      return localcm;
    }
  }
  
  public String getGuid()
  {
    if (this.hF == null) {
      return "";
    }
    return this.hF.getGuid();
  }
  
  public void onReady()
  {
    if (cx.iT)
    {
      if (this.hF == null) {
        return;
      }
      this.hF.onReady();
      return;
    }
    this.kX = true;
  }
  
  public void x(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (cx.iT)
      {
        this.hF.ba();
        return;
      }
      this.kU = true;
      return;
    }
    if (cx.iT)
    {
      this.hF.bK();
      return;
    }
    this.kT = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.db
 * JD-Core Version:    0.7.0.1
 */