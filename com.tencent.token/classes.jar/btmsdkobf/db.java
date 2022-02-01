package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
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
  private Handler jy = new Handler(cx.getLooper())
  {
    public void handleMessage(Message arg1)
    {
      final int i;
      label358:
      db.e locale;
      final ArrayList localArrayList2;
      switch (???.what)
      {
      default: 
      case 2: 
        do
        {
          return;
          cx.iT = true;
          eh.e("SharkProtocolQueue", "[shark_init]=========== MSG_INIT_FINISH ==========");
          synchronized (db.a(db.this))
          {
            i = db.a(db.this).size();
            if (i > 0) {
              db.b(db.this).sendEmptyMessage(1);
            }
            if (db.c(db.this)) {
              db.this.x(false);
            }
            if (db.d(db.this)) {
              db.this.x(true);
            }
            if (db.e(db.this)) {
              db.this.ca();
            }
            if (db.f(db.this)) {
              db.this.bH();
            }
            if (db.g(db.this)) {
              db.this.onReady();
            }
            if (db.h(db.this)) {
              db.this.cb();
            }
            if (db.i(db.this)) {
              db.this.bM();
            }
            if (db.j(db.this)) {
              db.this.bN();
            }
            if (db.k(db.this)) {
              db.this.av();
            }
            if (db.l(db.this)) {
              db.this.bY();
            }
            if (db.m(db.this) == null) {
              break label358;
            }
            ??? = db.m(db.this).iterator();
            while (???.hasNext())
            {
              cq localcq = (cq)???.next();
              if (localcq != null) {
                db.this.b(localcq.a, localcq.b, localcq.c);
              }
            }
          }
          db.a(db.this, null);
          if (db.n(db.this))
          {
            db.a(db.this, false);
            ??? = db.this.getGuid();
            if (!TextUtils.isEmpty(???))
            {
              eh.f("SharkProtocolQueue", "[cu_guid] notifyGuidGot on init finished");
              db.a(db.this, 0, ???);
            }
          }
          if (db.o(db.this)) {
            db.this.cc();
          }
        } while (!db.p(db.this));
        db.this.cd();
        return;
      case 1: 
        db.b(db.this).removeMessages(1);
        i = 0;
        locale = new db.e(db.this, null);
        localArrayList2 = new ArrayList();
      }
      label1807:
      for (;;)
      {
        Object localObject7;
        Object localObject8;
        synchronized (db.a(db.this))
        {
          localObject7 = db.a(db.this).iterator();
          if (((Iterator)localObject7).hasNext())
          {
            localObject8 = (db.d)((Iterator)localObject7).next();
            boolean bool = true;
            if (db.q(db.this) != null) {
              bool = db.q(db.this).b(((db.d)localObject8).d, ((db.d)localObject8).c);
            }
            if ((((db.d)localObject8).i & 0x40000000) == 0)
            {
              if (!((db.d)localObject8).o.bA())
              {
                if (bool)
                {
                  locale.a(Integer.valueOf(((db.d)localObject8).l), (db.d)localObject8);
                  i += 1;
                  break label1807;
                }
                localArrayList2.add(localObject8);
                break label1807;
              }
              cv.by().w(((db.d)localObject8).l);
              break label1807;
            }
            if (bool)
            {
              db.e.a(locale).add(localObject8);
              i += 1;
              break label1807;
            }
            localArrayList2.add(localObject8);
            break label1807;
          }
          db.a(db.this).clear();
          if (localArrayList2.size() > 0) {
            db.a(db.this).addAll(localArrayList2);
          }
          if (i <= 0) {
            break;
          }
          db.r(db.this).submit(locale);
          return;
        }
        eh.e("SharkProtocolQueue", "[shark_push]handle MSG_CLEAR_EXPIRED_PUSH");
        ArrayList localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        for (;;)
        {
          synchronized (db.s(db.this))
          {
            if (db.s(db.this).size() <= 0) {
              break label889;
            }
            long l = System.currentTimeMillis();
            localObject7 = db.s(db.this).iterator();
            if (!((Iterator)localObject7).hasNext()) {
              break;
            }
            localObject8 = (db.b)((Iterator)localObject7).next();
            if (l - ((db.b)localObject8).a >= 600000L) {
              localArrayList1.add(localObject8);
            }
          }
          localArrayList2.add(localObject8);
        }
        db.s(db.this).clear();
        db.s(db.this).addAll(localArrayList2);
        label889:
        eh.e("SharkProtocolQueue", "[shark_push]handle MSG_CLEAR_EXPIRED_PUSH, expired: " + localObject3.size() + " remain: " + localArrayList2.size());
        if (localObject3.size() <= 0) {
          break;
        }
        ??? = localObject3.iterator();
        while (???.hasNext())
        {
          localObject4 = (db.b)???.next();
          if (((db.b)localObject4).e == 0)
          {
            eh.e("SharkProtocolQueue", "[shark_push]sendPushResp() for expired push, cmd: " + ((db.b)localObject4).c.bM + " pushId: " + ((db.b)localObject4).b);
            db.this.a(((db.b)localObject4).c.dc, ((db.b)localObject4).b, ((db.b)localObject4).c.bM, null, null, -2, -1000000001);
          }
          else
          {
            eh.e("SharkProtocolQueue", "[shark_push]no need to sendPushResp() for expired gift, cmd: " + ((db.b)localObject4).c.bM + " pushId: " + ((db.b)localObject4).b);
          }
        }
        eh.e("SharkProtocolQueue", "[shark_push]handle MSG_CLEAR_PUSH_CACHE");
        Object localObject4 = new ArrayList();
        for (;;)
        {
          synchronized (db.s(db.this))
          {
            if (db.s(db.this).size() > 0)
            {
              ((List)localObject4).addAll(db.s(db.this));
              db.s(db.this).clear();
            }
            eh.e("SharkProtocolQueue", "[shark_push]handle MSG_CLEAR_PUSH_CACHE, " + ((List)localObject4).size() + " -> 0");
            if (((List)localObject4).size() <= 0) {
              break;
            }
            ??? = ((List)localObject4).iterator();
            if (!???.hasNext()) {
              break;
            }
            localObject4 = (db.b)???.next();
            if (((db.b)localObject4).e == 0)
            {
              eh.e("SharkProtocolQueue", "[shark_push]sendPushResp() on push cleared, cmd: " + ((db.b)localObject4).c.bM + " pushId: " + ((db.b)localObject4).b);
              db.this.a(((db.b)localObject4).c.dc, ((db.b)localObject4).b, ((db.b)localObject4).c.bM, null, null, -2, -1000000001);
            }
          }
          eh.e("SharkProtocolQueue", "[shark_push]no need to sendPushResp() on gift cleared, cmd: " + localObject5.c.bM + " pushId: " + localObject5.b);
        }
        i = ???.arg1;
        eh.e("SharkProtocolQueue", "[shark_push]handle MSG_CHECK_CACHED_PUSH for cmd: " + i);
        for (;;)
        {
          db.b localb;
          synchronized (db.t(db.this))
          {
            ??? = (dj)db.t(db.this).get(Integer.valueOf(i));
            localArrayList2 = new ArrayList();
            localObject7 = new ArrayList();
            synchronized (db.s(db.this))
            {
              if (db.s(db.this).size() <= 0) {
                break label1634;
              }
              localObject8 = db.s(db.this).iterator();
              if (!((Iterator)localObject8).hasNext()) {
                break;
              }
              localb = (db.b)((Iterator)localObject8).next();
              if (localb.c.bM == i) {
                localArrayList2.add(localb);
              }
            }
          }
          ((List)localObject7).add(localb);
        }
        db.s(db.this).clear();
        db.s(db.this).addAll((Collection)localObject7);
        label1634:
        eh.e("SharkProtocolQueue", "[shark_push]handle MSG_CHECK_CACHED_PUSH, fixed: " + localArrayList2.size() + " remain: " + ((List)localObject7).size());
        if ((??? == null) || (localArrayList2 == null) || (localArrayList2.size() <= 0)) {
          break;
        }
        ee.cT().addTask(new Runnable()
        {
          public void run()
          {
            Iterator localIterator = localArrayList2.iterator();
            while (localIterator.hasNext())
            {
              db.b localb = (db.b)localIterator.next();
              if (localb.e == 0)
              {
                eh.e("SharkProtocolQueue", "[shark_push]handle cached push, cmd: " + i + " pushId: " + localb.b);
                db.a(db.this, localb.b, localb.c, localb.d, paramAnonymousMessage);
              }
              else
              {
                eh.e("SharkProtocolQueue", "[shark_push]handle cached gift, cmd: " + i + " pushId: " + localb.b);
                db.b(db.this, localb.b, localb.c, localb.d, paramAnonymousMessage);
              }
            }
          }
        }, "shark callback: check cached push");
        return;
        eh.f("SharkProtocolQueue", "[shark_vip] handle: MSG_RESET_VIP_RULE, expired VipRule: " + db.q(db.this));
        db.a(db.this, null);
        eh.f("SharkProtocolQueue", "[shark_vip] triggle MSG_SEND_SHARK on VipRule expired ");
        if (!cx.iT) {
          break;
        }
        db.b(db.this).sendEmptyMessage(1);
        return;
        eh.f("SharkProtocolQueue", "[cu_guid]handle: MSG_REQUEST_REG_GUID");
        cf.f(bc.n());
        return;
      }
    }
  };
  private List<b> kP = new ArrayList();
  private ArrayList<d> kQ = new ArrayList();
  private dn<Long> kR = new dn(1000);
  private dl kS;
  private boolean kT = false;
  private boolean kU = false;
  private boolean kV = false;
  private boolean kW = false;
  private boolean kX = false;
  private boolean kY = false;
  private boolean kZ = false;
  private TreeMap<Integer, dj<JceStruct, cm, c>> kq = new TreeMap();
  private Handler kr = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      db.d locald;
      do
      {
        return;
        paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
        locald = (db.d)paramAnonymousMessage[0];
        if (locald.b <= 0) {
          break;
        }
      } while (locald.k == null);
      locald.k.a(locald.a, locald.b, locald.l, ((Integer)paramAnonymousMessage[1]).intValue(), ((Integer)paramAnonymousMessage[2]).intValue(), ((Integer)paramAnonymousMessage[3]).intValue(), locald.h);
      return;
      locald.j.onFinish(locald.l, ((Integer)paramAnonymousMessage[1]).intValue(), ((Integer)paramAnonymousMessage[2]).intValue(), ((Integer)paramAnonymousMessage[3]).intValue(), locald.g);
    }
  };
  private boolean la = false;
  private boolean lb = false;
  private LinkedList<cq> ld = null;
  private boolean le = false;
  private boolean lf = false;
  private boolean lg = false;
  private boolean lh = false;
  private List<ch> ll = new ArrayList();
  private List<ch> lm = new ArrayList();
  private List<cy.a> ln = new ArrayList();
  private a lo = null;
  private Context mContext = bc.n();
  
  /* Error */
  private void a(long paramLong, ba paramba, byte[] paramArrayOfByte, dj<JceStruct, cm, c> paramdj)
  {
    // Byte code:
    //   0: aload_3
    //   1: getfield 224	btmsdkobf/ba:data	[B
    //   4: ifnull +314 -> 318
    //   7: aload 5
    //   9: getfield 230	btmsdkobf/dj:mU	Ljava/lang/Object;
    //   12: checkcast 28	btmsdkobf/db$c
    //   15: getfield 233	btmsdkobf/db$c:lE	Z
    //   18: ifeq +211 -> 229
    //   21: aload_0
    //   22: getfield 210	btmsdkobf/db:mContext	Landroid/content/Context;
    //   25: aload 4
    //   27: aload_3
    //   28: getfield 224	btmsdkobf/ba:data	[B
    //   31: aload_3
    //   32: getfield 236	btmsdkobf/ba:di	I
    //   35: invokestatic 241	btmsdkobf/cd:a	(Landroid/content/Context;[B[BI)[B
    //   38: astore 4
    //   40: aconst_null
    //   41: astore 6
    //   43: aload 5
    //   45: getfield 230	btmsdkobf/dj:mU	Ljava/lang/Object;
    //   48: checkcast 28	btmsdkobf/db$c
    //   51: getfield 233	btmsdkobf/db$c:lE	Z
    //   54: ifeq +273 -> 327
    //   57: aload 5
    //   59: getfield 244	btmsdkobf/dj:second	Ljava/lang/Object;
    //   62: checkcast 246	btmsdkobf/cn
    //   65: aload_3
    //   66: getfield 249	btmsdkobf/ba:dc	I
    //   69: lload_1
    //   70: aload_3
    //   71: getfield 252	btmsdkobf/ba:bM	I
    //   74: aload 4
    //   76: invokeinterface 255 6 0
    //   81: astore 4
    //   83: aload 4
    //   85: ifnull +271 -> 356
    //   88: ldc 126
    //   90: new 257	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 260
    //   100: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: lload_1
    //   104: invokevirtual 267	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   107: ldc_w 269
    //   110: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload 4
    //   115: getfield 244	btmsdkobf/dj:second	Ljava/lang/Object;
    //   118: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   121: ldc_w 274
    //   124: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload 4
    //   129: getfield 230	btmsdkobf/dj:mU	Ljava/lang/Object;
    //   132: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 284	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload_0
    //   142: aload_3
    //   143: getfield 249	btmsdkobf/ba:dc	I
    //   146: lload_1
    //   147: aload 4
    //   149: getfield 244	btmsdkobf/dj:second	Ljava/lang/Object;
    //   152: checkcast 286	java/lang/Integer
    //   155: invokevirtual 290	java/lang/Integer:intValue	()I
    //   158: aload 4
    //   160: getfield 230	btmsdkobf/dj:mU	Ljava/lang/Object;
    //   163: checkcast 292	com/qq/taf/jce/JceStruct
    //   166: aconst_null
    //   167: iconst_1
    //   168: invokevirtual 295	btmsdkobf/db:a	(IJILcom/qq/taf/jce/JceStruct;[BI)Ljava/lang/ref/WeakReference;
    //   171: pop
    //   172: return
    //   173: astore 4
    //   175: ldc 126
    //   177: new 257	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   184: ldc_w 297
    //   187: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload 4
    //   192: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: aload 4
    //   200: invokestatic 300	btmsdkobf/eh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   203: aload_0
    //   204: aload_3
    //   205: getfield 249	btmsdkobf/ba:dc	I
    //   208: lload_1
    //   209: aload_3
    //   210: getfield 252	btmsdkobf/ba:bM	I
    //   213: aconst_null
    //   214: aconst_null
    //   215: iconst_m1
    //   216: invokevirtual 295	btmsdkobf/db:a	(IJILcom/qq/taf/jce/JceStruct;[BI)Ljava/lang/ref/WeakReference;
    //   219: pop
    //   220: aconst_null
    //   221: astore 4
    //   223: aconst_null
    //   224: astore 6
    //   226: goto -183 -> 43
    //   229: aload 5
    //   231: getfield 303	btmsdkobf/dj:first	Ljava/lang/Object;
    //   234: ifnull +84 -> 318
    //   237: aload_0
    //   238: getfield 210	btmsdkobf/db:mContext	Landroid/content/Context;
    //   241: aload 4
    //   243: aload_3
    //   244: getfield 224	btmsdkobf/ba:data	[B
    //   247: aload 5
    //   249: getfield 303	btmsdkobf/dj:first	Ljava/lang/Object;
    //   252: checkcast 292	com/qq/taf/jce/JceStruct
    //   255: iconst_1
    //   256: aload_3
    //   257: getfield 236	btmsdkobf/ba:di	I
    //   260: invokestatic 306	btmsdkobf/cd:a	(Landroid/content/Context;[B[BLcom/qq/taf/jce/JceStruct;ZI)Lcom/qq/taf/jce/JceStruct;
    //   263: astore 6
    //   265: aconst_null
    //   266: astore 4
    //   268: goto -225 -> 43
    //   271: astore 4
    //   273: ldc 126
    //   275: new 257	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   282: ldc_w 308
    //   285: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload 4
    //   290: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: aload 4
    //   298: invokestatic 300	btmsdkobf/eh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   301: aload_0
    //   302: aload_3
    //   303: getfield 249	btmsdkobf/ba:dc	I
    //   306: lload_1
    //   307: aload_3
    //   308: getfield 252	btmsdkobf/ba:bM	I
    //   311: aconst_null
    //   312: aconst_null
    //   313: iconst_m1
    //   314: invokevirtual 295	btmsdkobf/db:a	(IJILcom/qq/taf/jce/JceStruct;[BI)Ljava/lang/ref/WeakReference;
    //   317: pop
    //   318: aconst_null
    //   319: astore 4
    //   321: aconst_null
    //   322: astore 6
    //   324: goto -281 -> 43
    //   327: aload 5
    //   329: getfield 244	btmsdkobf/dj:second	Ljava/lang/Object;
    //   332: checkcast 310	btmsdkobf/cm
    //   335: aload_3
    //   336: getfield 249	btmsdkobf/ba:dc	I
    //   339: lload_1
    //   340: aload_3
    //   341: getfield 252	btmsdkobf/ba:bM	I
    //   344: aload 6
    //   346: invokeinterface 313 6 0
    //   351: astore 4
    //   353: goto -270 -> 83
    //   356: ldc 126
    //   358: new 257	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   365: ldc_w 315
    //   368: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: lload_1
    //   372: invokevirtual 267	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   375: ldc_w 269
    //   378: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_3
    //   382: getfield 252	btmsdkobf/ba:bM	I
    //   385: invokevirtual 318	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 284	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: return
    //   395: astore_3
    //   396: ldc 126
    //   398: new 257	java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   405: ldc_w 320
    //   408: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_3
    //   412: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: aload_3
    //   419: invokestatic 300	btmsdkobf/eh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   422: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	this	db
    //   0	423	1	paramLong	long
    //   0	423	3	paramba	ba
    //   0	423	4	paramArrayOfByte	byte[]
    //   0	423	5	paramdj	dj<JceStruct, cm, c>
    //   41	304	6	localJceStruct	JceStruct
    // Exception table:
    //   from	to	target	type
    //   21	40	173	java/lang/Exception
    //   237	265	271	java/lang/Exception
    //   43	83	395	java/lang/Exception
    //   88	172	395	java/lang/Exception
    //   327	353	395	java/lang/Exception
    //   356	394	395	java/lang/Exception
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
          ((cy.a)((Iterator)???).next()).a(paramInt, paramb);
        }
      }
    }
  }
  
  /* Error */
  private void b(long paramLong, ba paramba, byte[] paramArrayOfByte, dj<JceStruct, cm, c> paramdj)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_3
    //   4: getfield 224	btmsdkobf/ba:data	[B
    //   7: ifnull +248 -> 255
    //   10: aload 5
    //   12: getfield 230	btmsdkobf/dj:mU	Ljava/lang/Object;
    //   15: checkcast 28	btmsdkobf/db$c
    //   18: getfield 233	btmsdkobf/db$c:lE	Z
    //   21: ifeq +143 -> 164
    //   24: aload_0
    //   25: getfield 210	btmsdkobf/db:mContext	Landroid/content/Context;
    //   28: aload_0
    //   29: getfield 368	btmsdkobf/db:hF	Lbtmsdkobf/cy;
    //   32: invokevirtual 374	btmsdkobf/cy:ai	()Lbtmsdkobf/cs$b;
    //   35: getfield 379	btmsdkobf/cs$b:is	Ljava/lang/String;
    //   38: invokevirtual 385	java/lang/String:getBytes	()[B
    //   41: aload_3
    //   42: getfield 224	btmsdkobf/ba:data	[B
    //   45: aload_3
    //   46: getfield 236	btmsdkobf/ba:di	I
    //   49: invokestatic 241	btmsdkobf/cd:a	(Landroid/content/Context;[B[BI)[B
    //   52: astore 4
    //   54: aload 5
    //   56: getfield 230	btmsdkobf/dj:mU	Ljava/lang/Object;
    //   59: checkcast 28	btmsdkobf/db$c
    //   62: getfield 233	btmsdkobf/db$c:lE	Z
    //   65: ifeq +196 -> 261
    //   68: aload 5
    //   70: getfield 244	btmsdkobf/dj:second	Ljava/lang/Object;
    //   73: checkcast 246	btmsdkobf/cn
    //   76: aload_3
    //   77: getfield 249	btmsdkobf/ba:dc	I
    //   80: lload_1
    //   81: aload_3
    //   82: getfield 252	btmsdkobf/ba:bM	I
    //   85: aload 4
    //   87: invokeinterface 255 6 0
    //   92: astore 4
    //   94: aload 4
    //   96: ifnull +31 -> 127
    //   99: aload_0
    //   100: aload_3
    //   101: getfield 249	btmsdkobf/ba:dc	I
    //   104: aload 4
    //   106: getfield 244	btmsdkobf/dj:second	Ljava/lang/Object;
    //   109: checkcast 286	java/lang/Integer
    //   112: invokevirtual 290	java/lang/Integer:intValue	()I
    //   115: aload 4
    //   117: getfield 230	btmsdkobf/dj:mU	Ljava/lang/Object;
    //   120: checkcast 292	com/qq/taf/jce/JceStruct
    //   123: invokevirtual 388	btmsdkobf/db:a	(IILcom/qq/taf/jce/JceStruct;)Ljava/lang/ref/WeakReference;
    //   126: pop
    //   127: return
    //   128: astore 4
    //   130: ldc 126
    //   132: new 257	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 390
    //   142: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload 4
    //   147: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: aload 4
    //   155: invokestatic 300	btmsdkobf/eh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: aconst_null
    //   159: astore 4
    //   161: goto -107 -> 54
    //   164: aload 5
    //   166: getfield 303	btmsdkobf/dj:first	Ljava/lang/Object;
    //   169: ifnull +86 -> 255
    //   172: aload_0
    //   173: getfield 210	btmsdkobf/db:mContext	Landroid/content/Context;
    //   176: aload_0
    //   177: getfield 368	btmsdkobf/db:hF	Lbtmsdkobf/cy;
    //   180: invokevirtual 374	btmsdkobf/cy:ai	()Lbtmsdkobf/cs$b;
    //   183: getfield 379	btmsdkobf/cs$b:is	Ljava/lang/String;
    //   186: invokevirtual 385	java/lang/String:getBytes	()[B
    //   189: aload_3
    //   190: getfield 224	btmsdkobf/ba:data	[B
    //   193: aload 5
    //   195: getfield 303	btmsdkobf/dj:first	Ljava/lang/Object;
    //   198: checkcast 292	com/qq/taf/jce/JceStruct
    //   201: iconst_1
    //   202: aload_3
    //   203: getfield 236	btmsdkobf/ba:di	I
    //   206: invokestatic 306	btmsdkobf/cd:a	(Landroid/content/Context;[B[BLcom/qq/taf/jce/JceStruct;ZI)Lcom/qq/taf/jce/JceStruct;
    //   209: astore 4
    //   211: aconst_null
    //   212: astore 7
    //   214: aload 4
    //   216: astore 6
    //   218: aload 7
    //   220: astore 4
    //   222: goto -168 -> 54
    //   225: astore 4
    //   227: ldc 126
    //   229: new 257	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 392
    //   239: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 4
    //   244: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: aload 4
    //   252: invokestatic 300	btmsdkobf/eh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   255: aconst_null
    //   256: astore 4
    //   258: goto -204 -> 54
    //   261: aload 5
    //   263: getfield 244	btmsdkobf/dj:second	Ljava/lang/Object;
    //   266: checkcast 310	btmsdkobf/cm
    //   269: aload_3
    //   270: getfield 249	btmsdkobf/ba:dc	I
    //   273: lload_1
    //   274: aload_3
    //   275: getfield 252	btmsdkobf/ba:bM	I
    //   278: aload 6
    //   280: invokeinterface 313 6 0
    //   285: astore 4
    //   287: goto -193 -> 94
    //   290: astore_3
    //   291: ldc 126
    //   293: new 257	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   300: ldc_w 394
    //   303: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_3
    //   307: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: aload_3
    //   314: invokestatic 300	btmsdkobf/eh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   317: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	db
    //   0	318	1	paramLong	long
    //   0	318	3	paramba	ba
    //   0	318	4	paramArrayOfByte	byte[]
    //   0	318	5	paramdj	dj<JceStruct, cm, c>
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
        this.kP.add(new b(0, System.currentTimeMillis(), l, paramba, this.hF.ai().is.getBytes()));
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
      return ((c)localdj.mU).t;
    }
    return -1L;
  }
  
  public WeakReference<cw> a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, JceStruct arg9, byte[] paramArrayOfByte, JceStruct paramJceStruct2, int paramInt5, cj paramcj, ck paramck, long paramLong3, long paramLong4)
  {
    eh.e("SharkProtocolQueue", "sendShark() cmdId: " + paramInt4 + " pushSeqNo: " + paramInt3);
    if (paramInt3 > 0) {
      return a(paramInt3, paramLong1, paramInt4, ???, paramArrayOfByte, 1);
    }
    paramArrayOfByte = new d(paramInt1, paramInt2, paramLong2, paramInt4, ???, paramArrayOfByte, paramJceStruct2, paramInt5, paramcj, paramck);
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
  
  public WeakReference<cw> a(int paramInt1, final int paramInt2, JceStruct paramJceStruct)
  {
    eh.f("SharkProtocolQueue", "[shark_push]sendGiftResp(): giftSeqNo: " + paramInt1 + " acmdId: " + paramInt2 + " respStruct: " + paramJceStruct);
    if (paramInt2 == 156) {
      eh.i("SharkProtocolQueue", "[ip_list]sendGiftResp(): giftSeqNo: " + paramInt1 + " acmdId: " + paramInt2 + " respStruct: " + paramJceStruct);
    }
    cx.bE().a(paramInt2, paramJceStruct, null, 0, new cj()
    {
      public void onFinish(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, JceStruct paramAnonymousJceStruct)
      {
        eh.f("SharkProtocolQueue", "[shark_push]sendGiftResp()-onFinish() seqNo: " + paramAnonymousInt1 + " cmdId: " + paramAnonymousInt2 + " retCode: " + paramAnonymousInt3 + " dataRetCode: " + paramAnonymousInt4);
        if (paramInt2 == 156) {
          eh.i("SharkProtocolQueue", "[ip_list]sendGiftResp()-onFinish() seqNo: " + paramAnonymousInt1 + " cmdId: " + paramAnonymousInt2 + " retCode: " + paramAnonymousInt3 + " dataRetCode: " + paramAnonymousInt4 + " resp: " + paramAnonymousJceStruct);
        }
      }
    });
  }
  
  public WeakReference<cw> a(int paramInt1, long paramLong, int paramInt2, JceStruct paramJceStruct, byte[] paramArrayOfByte, int paramInt3)
  {
    return a(paramInt1, paramLong, paramInt2, paramJceStruct, paramArrayOfByte, paramInt3, 0);
  }
  
  public WeakReference<cw> a(int paramInt1, long paramLong, int paramInt2, JceStruct arg5, byte[] paramArrayOfByte, int paramInt3, int paramInt4)
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
      paramArrayOfByte = new d(0, 0, -1L, 1103, ???, cd.a(localak), null, 1073741824, null, null);
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
    d locald = new d(Process.myPid(), 0, 0L, paramInt1, null, new byte[0], null, 1073741824, null, null);
    locald.m = paramInt4;
    locald.l = paramInt3;
    locald.r = paramLong;
    synchronized (this.kQ)
    {
      this.kQ.add(locald);
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
        this.kq.put(Integer.valueOf(paramInt1), new dj(paramJceStruct, paramcm, new c(paramBoolean, paramLong)));
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
  
  public void a(cy.a parama)
  {
    if (parama == null) {
      return;
    }
    synchronized (this.ln)
    {
      if (!this.ln.contains(parama)) {
        this.ln.add(parama);
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
        this.kP.add(new b(1, System.currentTimeMillis(), 0L, paramba, this.hF.ai().is.getBytes()));
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
      return ((c)localdj.mU).t;
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
    this.ld.add(new cq(paramInt1, paramInt2, paramInt3));
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
  
  public void b(cy.a parama)
  {
    if (parama == null) {
      return;
    }
    synchronized (this.ln)
    {
      if (this.ln.contains(parama)) {
        this.ln.remove(parama);
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
        this.lo = new a(null);
        a.a(this.lo, this.mContext);
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
  
  private final class a
    extends BroadcastReceiver
  {
    private boolean b;
    
    private a() {}
    
    private void a(Context paramContext)
    {
      if (!this.b) {}
      try
      {
        String str = paramContext.getPackageName();
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction(String.format("action.guid.got:%s", new Object[] { str }));
        localIntentFilter.addAction(String.format("action.rsa.got:%s", new Object[] { str }));
        localIntentFilter.addAction(String.format("action.reg.guid:%s", new Object[] { str }));
        localIntentFilter.addAction(String.format("action.up.rsa:%s", new Object[] { str }));
        localIntentFilter.addAction(String.format("action.d.a:%s", new Object[] { str }));
        paramContext.registerReceiver(this, localIntentFilter);
        this.b = true;
        return;
      }
      catch (Throwable paramContext)
      {
        eh.a("SharkProtocolQueue", "[cu_guid] register: " + paramContext, paramContext);
        paramContext.printStackTrace();
      }
    }
    
    public void onReceive(final Context paramContext, final Intent paramIntent)
    {
      final String str = paramIntent.getAction();
      if (paramIntent.getPackage().compareToIgnoreCase(bc.n().getPackageName()) != 0) {
        return;
      }
      ee.cT().addTask(new Runnable()
      {
        public void run()
        {
          String str3 = paramContext.getPackageName();
          Object localObject1 = String.format("action.guid.got:%s", new Object[] { str3 });
          Object localObject2 = String.format("action.rsa.got:%s", new Object[] { str3 });
          String str1 = String.format("action.reg.guid:%s", new Object[] { str3 });
          String str2 = String.format("action.up.rsa:%s", new Object[] { str3 });
          str3 = String.format("action.d.a:%s", new Object[] { str3 });
          int i;
          if (((String)localObject1).equals(str))
          {
            db.b(db.this).removeMessages(7);
            i = paramIntent.getIntExtra("k.rc", -1);
            localObject1 = paramIntent.getStringExtra("k.g");
            if ((i == 0) && (!cx.ax()))
            {
              eh.f("SharkProtocolQueue", "[cu_guid] doOnRecv(), !sendProcess, refreshGuid on recv broadcast");
              db.this.x(true);
            }
            eh.f("SharkProtocolQueue", "[cu_guid] doOnRecv(), notifyGuidGot on recv broadcast: " + str);
            db.a(db.this, i, (String)localObject1);
          }
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (((String)localObject2).equals(str))
                  {
                    i = paramIntent.getIntExtra("k.rc", -1);
                    localObject1 = null;
                    if (i == 0)
                    {
                      localObject2 = new cs.b();
                      ((cs.b)localObject2).is = paramIntent.getStringExtra("k.r.k");
                      ((cs.b)localObject2).ir = paramIntent.getStringExtra("k.r.s");
                      localObject1 = localObject2;
                      if (!cx.ax())
                      {
                        eh.f("SharkProtocolQueue", "[rsa_key] doOnRecv(), !sendProcess, refreshRsaKey on recv broadcast");
                        db.this.x(false);
                        localObject1 = localObject2;
                      }
                    }
                    eh.f("SharkProtocolQueue", "[rsa_key] doOnRecv(), notifyRsaKeyGot on recv broadcast: " + str);
                    db.a(db.this, i, (cs.b)localObject1);
                    return;
                  }
                  if (!str1.equals(str)) {
                    break;
                  }
                } while (!cx.ax());
                eh.f("SharkProtocolQueue", "[rsa_key] doOnRecv(), triggerRegGuid on recv broadcast: " + str);
                db.this.bH();
                return;
                if (!str2.equals(str)) {
                  break;
                }
              } while (!cx.ax());
              eh.f("SharkProtocolQueue", "[rsa_key] doOnRecv(), triggerUpdateRsaKey on recv broadcast: " + str);
              db.this.ca();
              return;
            } while ((!str3.equals(str)) || (!cx.ax()));
            try
            {
              i = paramIntent.getIntExtra("k.sa", 0);
              if (i == 1)
              {
                localObject1 = paramIntent.getExtras();
                localObject2 = (dl)((Bundle)localObject1).getSerializable("v.r");
                long l = ((Bundle)localObject1).getLong("vt.m", 35000L);
                db.this.a((dl)localObject2, l);
                return;
              }
            }
            catch (Throwable localThrowable)
            {
              eh.a("SharkProtocolQueue", "[shark_vip] doOnRecv(), setVipRule: " + localThrowable, localThrowable);
              return;
            }
          } while (i != 2);
          db.this.bY();
        }
      }, "GuidOrRsaKeyGotReceiver onRecv");
    }
  }
  
  private class b
  {
    long a;
    long b;
    ba c;
    byte[] d;
    int e = 0;
    
    public b(int paramInt, long paramLong1, long paramLong2, ba paramba, byte[] paramArrayOfByte)
    {
      this.e = paramInt;
      this.a = paramLong1;
      this.b = paramLong2;
      this.c = paramba;
      this.d = paramArrayOfByte;
    }
  }
  
  public static class c
  {
    public boolean lE;
    public long t;
    
    public c(boolean paramBoolean, long paramLong)
    {
      this.lE = paramBoolean;
      this.t = paramLong;
    }
  }
  
  private class d
  {
    public int a;
    public int b;
    public long c;
    public int d;
    public JceStruct e;
    public byte[] f;
    public JceStruct g;
    public byte[] h;
    public int i;
    public cj j;
    public ck k;
    public int l;
    public int m;
    public int n;
    public cw o;
    public long p = -1L;
    public long q = 0L;
    public long r;
    public long s = System.currentTimeMillis();
    
    d(int paramInt1, int paramInt2, long paramLong, int paramInt3, JceStruct paramJceStruct1, byte[] paramArrayOfByte, JceStruct paramJceStruct2, int paramInt4, cj paramcj, ck paramck)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramLong;
      this.d = paramInt3;
      this.e = paramJceStruct1;
      this.f = paramArrayOfByte;
      this.g = paramJceStruct2;
      this.i = paramInt4;
      this.j = paramcj;
      this.k = paramck;
      this.o = new cw();
    }
    
    public boolean a()
    {
      long l2 = Math.abs(System.currentTimeMillis() - this.s);
      long l1;
      if (this.p > 0L)
      {
        l1 = this.p;
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
          localStringBuilder.append("cmdId|").append(this.d);
          localStringBuilder.append("|mIpcSeqNo|").append(this.b);
          localStringBuilder.append("|mSeqNo|").append(this.l);
          localStringBuilder.append("|pushId|").append(this.r);
          localStringBuilder.append("|mCallerIdent|").append(this.c);
          localStringBuilder.append("|callBackTimeout|").append(this.p);
          localStringBuilder.append("|time(s)|").append(l2 / 1000L);
          eh.h("ocean", "[ocean][time_out]SharkProtocolQueue.SharkSendTask.isTimeOut(), " + localStringBuilder.toString());
        }
        return bool;
        l1 = 30000L;
        break;
      }
    }
  }
  
  private class e
    implements Runnable
  {
    private TreeMap<Integer, db.d> b = new TreeMap();
    private ArrayList<db.d> c = new ArrayList();
    private Handler d = new Handler(cx.getLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        dh localdh = (dh)paramAnonymousMessage.obj;
        ba localba = new ba();
        localba.df = -11050000;
        localba.dd = paramAnonymousMessage.what;
        if (localdh != null) {
          localba.bM = localdh.a;
        }
        eh.h("SharkProtocolQueue", "接收超时：seq: " + localba.dd + " cmdId: " + localba.bM);
        db.e.a(db.e.this, localba);
      }
    };
    private Handler e = new Handler(cx.getLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default: 
          return;
        }
        ba localba = new ba();
        localba.df = -10000017;
        localba.dd = paramAnonymousMessage.arg1;
        localba.bM = paramAnonymousMessage.arg2;
        eh.h("SharkProtocolQueue", "[time_out]发送请求超时： seq: " + localba.dd + " cmdId: " + localba.bM);
        db.e.a(db.e.this, localba);
      }
    };
    
    private e() {}
    
    private void a(ba paramba)
    {
      Object localObject6 = null;
      Object localObject1 = null;
      Object localObject3 = null;
      this.d.removeMessages(paramba.dd);
      db.d locald;
      synchronized (this.b)
      {
        locald = (db.d)this.b.get(Integer.valueOf(paramba.dd));
        if (locald == null) {
          return;
        }
        this.b.remove(Integer.valueOf(paramba.dd));
        if ((paramba.data == null) || (paramba.df != 0)) {}
      }
      for (;;)
      {
        try
        {
          if ((locald.k != null) && (locald.b > 0))
          {
            ??? = cd.a(db.u(db.this), db.v(db.this).ai().is.getBytes(), paramba.data, paramba.di);
            localObject1 = localObject3;
            localObject3 = ???;
            localObject6 = localObject1;
            if (localObject1 == null)
            {
              localObject3 = ???;
              localObject6 = localObject1;
              if (??? == null)
              {
                localObject3 = ???;
                localObject6 = localObject1;
              }
            }
          }
        }
        catch (Throwable localThrowable1)
        {
          ??? = null;
        }
        try
        {
          if (locald.g != null)
          {
            paramba.df = bz.p(-11000300);
            localObject6 = localObject1;
            localObject3 = ???;
          }
          if (locald.h != localObject3) {
            locald.h = localObject3;
          }
          if (locald.g != localObject6) {
            locald.g = localObject6;
          }
          try
          {
            a(paramba, locald, Integer.valueOf(paramba.bM), Integer.valueOf(paramba.df), Integer.valueOf(paramba.dg));
            return;
          }
          catch (Exception paramba)
          {
            eh.a("SharkProtocolQueue", "callback crash", paramba);
            return;
          }
          paramba = finally;
          throw paramba;
        }
        catch (Throwable localThrowable2)
        {
          Object localObject4;
          break label317;
        }
        ??? = cd.a(db.u(db.this), db.v(db.this).ai().is.getBytes(), paramba.data, locald.g, false, paramba.di);
        localObject1 = ???;
        ??? = null;
        continue;
        label317:
        eh.b("SharkProtocolQueue", "sashimi decode fail", localThrowable1);
        paramba.df = bz.p(-11000900);
        localObject4 = ???;
        localObject6 = localObject1;
        continue;
        Object localObject5 = null;
      }
    }
    
    private void a(ba paramba, final db.d paramd, final Integer paramInteger1, Integer paramInteger2, final Integer paramInteger3)
    {
      paramd.o.setState(2);
      final int i = bz.p(paramInteger2.intValue());
      if (paramba == null)
      {
        cv.by().a("SharkProtocolQueue", paramInteger1.intValue(), paramd.l, paramba, 30, i);
        cv.by().x(paramd.l);
      }
      while ((paramd.j == null) && (paramd.k == null))
      {
        return;
        cv.by().a("SharkProtocolQueue", paramInteger1.intValue(), paramba.dd, paramba, 30, i);
        cv.by().x(paramba.dd);
      }
      switch (bv.k(paramd.i))
      {
      default: 
        paramba = new Runnable()
        {
          public void run()
          {
            if ((paramd.k != null) && (paramd.b > 0))
            {
              paramd.k.a(paramd.a, paramd.b, paramd.l, paramInteger1.intValue(), i, paramInteger3.intValue(), paramd.h);
              return;
            }
            paramd.j.onFinish(paramd.l, paramInteger1.intValue(), i, paramInteger3.intValue(), paramd.g);
          }
        };
        if ((paramInteger1.intValue() == 2016) || (paramInteger1.intValue() == 12016))
        {
          ee.cT().addUrgentTask(paramba, "shark callback(urgent)");
          return;
        }
        break;
      case 16: 
        if ((paramd.k != null) && (paramd.b > 0))
        {
          paramd.k.a(paramd.a, paramd.b, paramd.l, paramInteger1.intValue(), i, paramInteger3.intValue(), paramd.h);
          return;
        }
        paramd.j.onFinish(paramd.l, paramInteger1.intValue(), i, paramInteger3.intValue(), paramd.g);
        return;
      case 8: 
        paramba = db.w(db.this).obtainMessage(11, new Object[] { paramd, paramInteger1, Integer.valueOf(i), paramInteger3 });
        db.w(db.this).sendMessage(paramba);
        return;
      }
      ee.cT().addTask(paramba, "shark callback");
    }
    
    private void a(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList<ba> paramArrayList)
    {
      if (paramInt1 == 0)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          ba localba = (ba)paramArrayList.next();
          if (a(localba.dd)) {
            a(localba);
          } else if (db.b(localba)) {
            db.this.a(paramBoolean, paramInt2, localba);
          } else if (db.c(localba)) {
            db.this.b(paramBoolean, paramInt2, localba);
          } else {
            eh.g("SharkProtocolQueue", "No callback xx: cmd : " + localba.bM + " seqNo : " + localba.dc + " refSeqNo : " + localba.dd);
          }
        }
      }
      b(paramInt1);
    }
    
    private void b(int paramInt)
    {
      Object localObject2 = a();
      synchronized (this.b)
      {
        this.b.clear();
        ??? = ((Set)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)???).hasNext())
          {
            localObject2 = (Map.Entry)((Iterator)???).next();
            try
            {
              a(null, (db.d)((Map.Entry)localObject2).getValue(), Integer.valueOf(((db.d)((Map.Entry)localObject2).getValue()).d), Integer.valueOf(paramInt), Integer.valueOf(-1));
            }
            catch (Throwable localThrowable)
            {
              eh.b("SharkProtocolQueue", "callback crash", localThrowable);
            }
          }
        }
      }
    }
    
    public Set<Map.Entry<Integer, db.d>> a()
    {
      synchronized (this.b)
      {
        TreeMap localTreeMap2 = (TreeMap)this.b.clone();
        return localTreeMap2.entrySet();
      }
    }
    
    public void a(Integer paramInteger, db.d paramd)
    {
      this.b.put(paramInteger, paramd);
    }
    
    public boolean a(int paramInt)
    {
      synchronized (this.b)
      {
        boolean bool = this.b.containsKey(Integer.valueOf(paramInt));
        return bool;
      }
    }
    
    public void run()
    {
      long l1 = 0L;
      label569:
      label1245:
      for (;;)
      {
        ArrayList localArrayList2;
        ArrayList localArrayList3;
        ArrayList localArrayList4;
        Object localObject1;
        try
        {
          ArrayList localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          localArrayList3 = new ArrayList();
          localArrayList4 = new ArrayList();
          localIterator = a().iterator();
          if (!localIterator.hasNext()) {
            break label642;
          }
          localObject1 = (Map.Entry)localIterator.next();
          if (((db.d)((Map.Entry)localObject1).getValue()).o.bA()) {
            break label1245;
          }
          if (((db.d)((Map.Entry)localObject1).getValue()).a())
          {
            this.e.obtainMessage(1, ((db.d)((Map.Entry)localObject1).getValue()).l, ((db.d)((Map.Entry)localObject1).getValue()).d).sendToTarget();
            continue;
          }
          ((db.d)((Map.Entry)localObject1).getValue()).o.setState(1);
        }
        catch (Exception localException1)
        {
          eh.b("SharkProtocolQueue", "run shark task e: " + localException1.toString(), localException1);
          b(-10001200);
          return;
        }
        as localas = new as();
        localas.bM = ((db.d)((Map.Entry)localObject1).getValue()).d;
        localas.dc = ((db.d)((Map.Entry)localObject1).getValue()).l;
        localas.de = ((db.d)((Map.Entry)localObject1).getValue()).c;
        localas.dd = 0;
        localas.data = null;
        Object localObject2;
        if (((db.d)((Map.Entry)localObject1).getValue()).f != null)
        {
          localObject2 = ((db.d)((Map.Entry)localObject1).getValue()).f;
          localas.data = cd.a(db.u(db.this), (byte[])localObject2, localas.bM, localas);
          long l3 = ((db.d)((Map.Entry)localObject1).getValue()).p;
          long l2 = l3;
          if (l3 <= 0L) {
            l2 = 30000L;
          }
          eh.i("SharkProtocolQueue", "[shark_timer]对seq: " + localas.dc + "计时(ms): " + l2);
          localObject2 = new dh(localas.bM);
          localObject2 = Message.obtain(this.d, localas.dc, localObject2);
          this.d.sendMessageDelayed((Message)localObject2, l2);
          if ((((db.d)((Map.Entry)localObject1).getValue()).i & 0x800) == 0) {
            break label569;
          }
          localException1.add(localas);
        }
        for (;;)
        {
          cv.by().a("SharkProtocolQueue", localas.bM, localas.dc, localas, 0);
          if (((db.d)((Map.Entry)localObject1).getValue()).q <= l1) {
            break label1245;
          }
          l1 = ((db.d)((Map.Entry)localObject1).getValue()).q;
          break label1245;
          localObject2 = ((db.d)((Map.Entry)localObject1).getValue()).e;
          localas.data = cd.a(db.u(db.this), (JceStruct)localObject2, localas.bM, localas);
          break;
          if ((((db.d)((Map.Entry)localObject1).getValue()).i & 0x200) != 0) {
            localArrayList2.add(localas);
          } else if ((((db.d)((Map.Entry)localObject1).getValue()).i & 0x400) != 0) {
            localArrayList3.add(localas);
          } else {
            localArrayList4.add(localas);
          }
        }
        Iterator localIterator = this.c.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject1 = (db.d)localIterator.next();
            if (((db.d)localObject1).a())
            {
              if (((db.d)localObject1).d == 1103)
              {
                eh.h("SharkProtocolQueue", "[time_out]发送push的业务回包超时： mSeqNo: " + ((db.d)localObject1).l + " pushId: " + ((db.d)localObject1).r);
                continue;
              }
              eh.h("SharkProtocolQueue", "[time_out]发送push的自动回包超时： mSeqNo: " + ((db.d)localObject1).l + " pushId: " + ((db.d)localObject1).r + " mCmdId: " + ((db.d)localObject1).d);
              continue;
            }
            localas = new as();
            localas.bM = ((db.d)localObject1).d;
            localas.dc = cu.bu().bm();
            localas.dd = ((db.d)localObject1).l;
            localas.data = null;
            localas.df = ((db.d)localObject1).m;
            localas.dg = ((db.d)localObject1).n;
            localObject2 = new ar();
            ((ar)localObject2).db = ((db.d)localObject1).r;
            localas.dh = ((ar)localObject2);
            eh.f("SharkProtocolQueue", "resp push, seqNo: " + localas.dc + " pushId: " + ((db.d)localObject1).r);
            try
            {
              if (((db.d)localObject1).f != null) {
                localObject2 = ((db.d)localObject1).f;
              }
              for (localas.data = cd.a(db.u(db.this), (byte[])localObject2, localas.bM, localas);; localas.data = cd.a(db.u(db.this), (JceStruct)localObject2, localas.bM, localas))
              {
                if ((((db.d)localObject1).i & 0x800) == 0) {
                  break label1057;
                }
                localException1.add(localas);
                cv.by().a("SharkProtocolQueue", localas.bM, localas.dc, localas, 0);
                break;
                localObject2 = ((db.d)localObject1).e;
              }
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                continue;
                if ((((db.d)localObject1).i & 0x200) != 0) {
                  localArrayList2.add(localas);
                } else if ((((db.d)localObject1).i & 0x400) != 0) {
                  localArrayList3.add(localas);
                } else {
                  localArrayList4.add(localas);
                }
              }
            }
          }
        }
        if (localException1.size() > 0) {
          db.v(db.this).a(2048, l1, true, localException1, new cy.b()
          {
            public void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, ArrayList<ba> paramAnonymousArrayList)
            {
              db.e.a(db.e.this, paramAnonymousBoolean, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayList);
            }
          });
        }
        if (localArrayList2.size() > 0) {
          db.v(db.this).a(512, l1, true, localArrayList2, new cy.b()
          {
            public void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, ArrayList<ba> paramAnonymousArrayList)
            {
              db.e.a(db.e.this, paramAnonymousBoolean, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayList);
            }
          });
        }
        if (localArrayList3.size() > 0) {
          db.v(db.this).a(1024, l1, true, localArrayList3, new cy.b()
          {
            public void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, ArrayList<ba> paramAnonymousArrayList)
            {
              db.e.a(db.e.this, paramAnonymousBoolean, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayList);
            }
          });
        }
        if (localArrayList4.size() > 0)
        {
          db.v(db.this).a(0, l1, true, localArrayList4, new cy.b()
          {
            public void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, ArrayList<ba> paramAnonymousArrayList)
            {
              db.e.a(db.e.this, paramAnonymousBoolean, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayList);
            }
          });
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.db
 * JD-Core Version:    0.7.0.1
 */