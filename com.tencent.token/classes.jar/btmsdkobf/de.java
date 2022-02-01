package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import com.tmsdk.base.utils.NetworkUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tmsdk.QQPIM.ConnectType;

public class de
{
  private cl he;
  private PowerManager iB;
  private a lW;
  private b lX;
  private v lY;
  private AtomicInteger lZ = new AtomicInteger(0);
  private Context mContext = bc.n();
  private Handler mHandler = new Handler(cx.getLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      case 2: 
      default: 
        return;
      case 0: 
        eh.f("SharkTcpControler", "[tcp_control][shark_conf] MSG_EXE_RULE_OPEN");
        de.a(de.this);
        de.b(de.this).cp();
        return;
      case 1: 
        eh.f("SharkTcpControler", "[tcp_control][shark_conf] MSG_EXE_RULE_CLOSE");
        de.this.ci();
        return;
      }
      eh.f("SharkTcpControler", "[tcp_control][shark_conf] MSG_EXE_RULE_CYCLE");
      de.c(de.this);
    }
  };
  private boolean ma = false;
  private Runnable mb = new Runnable()
  {
    public void run()
    {
      synchronized (de.this)
      {
        if (de.d(de.this))
        {
          eh.e("SharkTcpControler", "[tcp_control][shark_conf][shark_alarm] keep after send timeout, tryCloseConnectionAsyn()");
          de.this.ci();
          de.a(de.this, false);
        }
        eh.e("SharkTcpControler", "[tcp_control][shark_conf][shark_alarm] keep after send timeout(by alarm), delay 5s by handler");
        return;
      }
    }
  };
  private boolean mc = false;
  
  public de(cl paramcl, a parama)
  {
    this.he = paramcl;
    this.lW = parama;
    try
    {
      this.iB = ((PowerManager)this.mContext.getSystemService("power"));
      return;
    }
    catch (Throwable paramcl) {}
  }
  
  private static final int G(int paramInt)
  {
    return paramInt * 60;
  }
  
  private static final int H(int paramInt)
  {
    return G(paramInt * 60);
  }
  
  private static void b(List<t> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    if (((t)paramList.get(0)).aD > 0)
    {
      t localt1 = (t)paramList.get(paramList.size() - 1);
      t localt2 = new t();
      localt2.aD = H(0);
      localt2.aE = localt1.aE;
      localt2.aF = localt1.aF;
      paramList.add(0, localt2);
    }
    try
    {
      Collections.sort(paramList, new Comparator()
      {
        public int a(t paramAnonymoust1, t paramAnonymoust2)
        {
          return paramAnonymoust1.aD - paramAnonymoust2.aD;
        }
      });
      return;
    }
    catch (Throwable paramList)
    {
      eh.b("SharkTcpControler", "[tcp_control][shark_conf]checkAndSort() exception: " + paramList, paramList);
    }
  }
  
  private void cj()
  {
    if (this.lZ.get() < 0) {
      this.lZ.set(0);
    }
    int i = this.lZ.incrementAndGet();
    eh.f("SharkTcpControler", "[tcp_control][shark_conf]markKeepAlive(), refCount: " + i);
  }
  
  private static ArrayList<t> ck()
  {
    ArrayList localArrayList = new ArrayList();
    t localt = new t();
    localt.aD = H(0);
    localt.aE = G(10);
    localt.aF = G(60);
    localArrayList.add(localt);
    localt = new t();
    localt.aD = H(8);
    localt.aE = G(15);
    localt.aF = G(15);
    localArrayList.add(localt);
    localt = new t();
    localt.aD = H(15);
    localt.aE = G(10);
    localt.aF = G(20);
    localArrayList.add(localt);
    return localArrayList;
  }
  
  private void cl()
  {
    t localt = cn();
    if (localt == null)
    {
      eh.g("SharkTcpControler", "[tcp_control][shark_conf]no KeepAlivePolicy for current time!");
      return;
    }
    cm();
    if (B("execRule"))
    {
      this.mHandler.sendEmptyMessage(0);
      dm.a(this.mContext, "action_keep_alive_close", localt.aE * 1000);
      eh.i("SharkTcpControler", "[tcp_control][shark_conf]now open connection, after " + localt.aE + "s close connection");
    }
    for (;;)
    {
      dm.a(this.mContext, "action_keep_alive_cycle", (localt.aE + localt.aF) * 1000);
      StringBuilder localStringBuilder = new StringBuilder().append("[tcp_control][shark_conf]execRule(), next cycle in ");
      int i = localt.aE;
      eh.i("SharkTcpControler", localt.aF + i + "s");
      return;
      eh.g("SharkTcpControler", "[tcp_control][f_p][h_b][shark_conf]execRule(), scSharkConf: donnot keepAlive!");
    }
  }
  
  private void cm()
  {
    eh.e("SharkTcpControler", "[tcp_control][shark_conf]cancelOldAction()");
    dm.a(this.mContext, "action_keep_alive_close");
    dm.a(this.mContext, "action_keep_alive_cycle");
    this.mHandler.removeMessages(1);
    this.mHandler.removeMessages(3);
    this.mHandler.removeMessages(0);
  }
  
  private t cn()
  {
    for (;;)
    {
      int i;
      try
      {
        v localv = aq();
        if ((localv != null) && (localv.aO != null) && (localv.aO.size() > 0))
        {
          int j = co();
          i = localv.aO.size() - 1;
          if (i >= 0)
          {
            t localt = (t)localv.aO.get(i);
            if (localt.aD > j) {
              break label158;
            }
            eh.f("SharkTcpControler", "[tcp_control][shark_conf]getRuleAtNow(), fixed policy: start hour: " + localt.aD / 3600 + " start: " + localt.aD + " keep: " + localt.aE + " close: " + localt.aF);
            return localt;
          }
        }
        return null;
      }
      finally {}
      label158:
      i -= 1;
    }
  }
  
  private int co()
  {
    Calendar localCalendar = Calendar.getInstance();
    if (localCalendar == null) {
      return 0;
    }
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    return localCalendar.get(13) + (i * 3600 + j * 60);
  }
  
  private static void d(v paramv)
  {
    if (paramv == null) {
      return;
    }
    if ((paramv.aO != null) && (paramv.aO.size() > 0)) {
      b(paramv.aO);
    }
    for (;;)
    {
      if (paramv.aM <= 30) {
        paramv.aM = 30;
      }
      if (paramv.aP <= 0) {
        paramv.aP = 300;
      }
      if (paramv.aS <= 0) {
        paramv.aS = 120;
      }
      if (paramv.aT <= 0) {
        paramv.aT = 2;
      }
      eh.e("SharkTcpControler", "[shark_push][shark_conf]------------- ensureValid() ---------------------");
      eh.f("SharkTcpControler", "[shark_push][shark_conf] hash : " + paramv.ay);
      if (paramv.az != null) {
        eh.f("SharkTcpControler", "[shark_push][shark_conf] info.taskNo: " + paramv.az.aB + " info.seqNo: " + paramv.az.aC);
      }
      eh.f("SharkTcpControler", "[shark_push][shark_conf] hb interval: " + paramv.aM);
      eh.f("SharkTcpControler", "[shark_push][shark_conf] KeepAliveAfterSendInSeconds: " + paramv.aP);
      if (paramv.aO == null) {
        break;
      }
      eh.f("SharkTcpControler", "[shark_push][shark_conf]scSharkConf.policy.size(): " + paramv.aO.size());
      Iterator localIterator = paramv.aO.iterator();
      while (localIterator.hasNext())
      {
        t localt = (t)localIterator.next();
        eh.f("SharkTcpControler", "[shark_push][shark_conf]start: " + localt.aD + " keepAlive: " + localt.aE + " connPan: " + localt.aF);
      }
      paramv.aO = ck();
    }
    eh.f("SharkTcpControler", "[shark_push][shark_conf] scSharkConf.connIfNotWifi: " + paramv.aQ);
    eh.f("SharkTcpControler", "[shark_push][shark_conf] scSharkConf.connIfScreenOff: " + paramv.aR);
    eh.f("SharkTcpControler", "[shark_push][shark_conf] scSharkConf.reconnectInterval: " + paramv.aS);
    eh.f("SharkTcpControler", "[shark_push][shark_conf] scSharkConf.delayOnNetworkChanging: " + paramv.aT);
    eh.e("SharkTcpControler", "[shark_push][shark_conf]-----------------------------------------------------------");
  }
  
  boolean B(String paramString)
  {
    int i = 1;
    boolean bool2 = false;
    v localv = aq();
    if (localv == null) {
      return true;
    }
    if ((!localv.aQ) && (ConnectType.CT_WIFI != NetworkUtil.getNetworkType())) {
      eh.i("SharkTcpControler", "[tcp_control][shark_conf] shouldKeepAlive(), not allow in none wifi! timing: " + paramString);
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      if ((bool1) && (!localv.aR)) {
        if (this.iB == null) {
          break label144;
        }
      }
      for (;;)
      {
        try
        {
          boolean bool3 = this.iB.isScreenOn();
          if (bool3) {
            continue;
          }
        }
        catch (Throwable localThrowable)
        {
          i = 0;
          continue;
        }
        if (i != 0)
        {
          eh.i("SharkTcpControler", "[tcp_control][shark_conf] shouldKeepAlive(), not allow on screen off! timing: " + paramString);
          bool1 = bool2;
          return bool1;
          i = 0;
        }
        else
        {
          continue;
          label144:
          i = 0;
        }
      }
    }
  }
  
  public v aq()
  {
    for (;;)
    {
      try
      {
        if (this.lY == null)
        {
          this.lY = this.he.aL();
          if (this.lY != null) {
            d(this.lY);
          }
        }
        else
        {
          return this.lY;
        }
        this.lY = new v();
        if (cx.bB())
        {
          this.lY.aM = 30;
          this.lY.aP = 60;
          this.lY.aN = new ArrayList();
          this.lY.aO = ck();
          this.lY.aQ = true;
          this.lY.aR = true;
          this.lY.aS = 120;
          this.lY.aT = 2;
          continue;
        }
        this.lY.aM = 270;
      }
      finally {}
      this.lY.aP = 300;
    }
  }
  
  public void c(v paramv)
  {
    if (paramv == null)
    {
      eh.g("SharkTcpControler", "[tcp_control][shark_conf]onSharkConfPush(), scSharkConf == null");
      return;
    }
    try
    {
      this.lY = paramv;
      this.he.b(this.lY);
      d(this.lY);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void cc()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	btmsdkobf/de:mc	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: ldc 145
    //   16: ldc_w 420
    //   19: invokestatic 249	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: getfield 422	btmsdkobf/de:lX	Lbtmsdkobf/de$b;
    //   26: ifnonnull +49 -> 75
    //   29: aload_0
    //   30: new 15	btmsdkobf/de$b
    //   33: dup
    //   34: aload_0
    //   35: aconst_null
    //   36: invokespecial 425	btmsdkobf/de$b:<init>	(Lbtmsdkobf/de;Lbtmsdkobf/de$1;)V
    //   39: putfield 422	btmsdkobf/de:lX	Lbtmsdkobf/de$b;
    //   42: new 427	android/content/IntentFilter
    //   45: dup
    //   46: invokespecial 428	android/content/IntentFilter:<init>	()V
    //   49: astore_2
    //   50: aload_2
    //   51: ldc 224
    //   53: invokevirtual 432	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   56: aload_2
    //   57: ldc 238
    //   59: invokevirtual 432	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: getfield 79	btmsdkobf/de:mContext	Landroid/content/Context;
    //   66: aload_0
    //   67: getfield 422	btmsdkobf/de:lX	Lbtmsdkobf/de$b;
    //   70: aload_2
    //   71: invokevirtual 436	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   74: pop
    //   75: aload_0
    //   76: getfield 64	btmsdkobf/de:mHandler	Landroid/os/Handler;
    //   79: iconst_3
    //   80: invokevirtual 222	android/os/Handler:sendEmptyMessage	(I)Z
    //   83: pop
    //   84: aload_0
    //   85: iconst_1
    //   86: putfield 71	btmsdkobf/de:mc	Z
    //   89: goto -78 -> 11
    //   92: astore_2
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_2
    //   96: athrow
    //   97: astore_2
    //   98: ldc 145
    //   100: new 147	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 438
    //   110: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_2
    //   114: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 207	btmsdkobf/eh:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: goto -48 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	de
    //   6	2	1	bool	boolean
    //   49	22	2	localIntentFilter	android.content.IntentFilter
    //   92	4	2	localObject	Object
    //   97	17	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	7	92	finally
    //   14	62	92	finally
    //   62	75	92	finally
    //   75	89	92	finally
    //   98	123	92	finally
    //   62	75	97	java/lang/Throwable
  }
  
  /* Error */
  public void cd()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	btmsdkobf/de:mc	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: ldc 145
    //   16: ldc_w 441
    //   19: invokestatic 249	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: invokespecial 210	btmsdkobf/de:cm	()V
    //   26: aload_0
    //   27: getfield 422	btmsdkobf/de:lX	Lbtmsdkobf/de$b;
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull +19 -> 51
    //   35: aload_0
    //   36: getfield 79	btmsdkobf/de:mContext	Landroid/content/Context;
    //   39: aload_0
    //   40: getfield 422	btmsdkobf/de:lX	Lbtmsdkobf/de$b;
    //   43: invokevirtual 445	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 422	btmsdkobf/de:lX	Lbtmsdkobf/de$b;
    //   51: aload_0
    //   52: invokevirtual 448	btmsdkobf/de:ci	()V
    //   55: aload_0
    //   56: iconst_0
    //   57: putfield 71	btmsdkobf/de:mc	Z
    //   60: goto -49 -> 11
    //   63: astore_2
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    //   68: astore_2
    //   69: ldc 145
    //   71: new 147	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   78: ldc_w 450
    //   81: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_2
    //   85: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 207	btmsdkobf/eh:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: goto -43 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	de
    //   6	2	1	bool	boolean
    //   30	2	2	localb	b
    //   63	4	2	localObject	Object
    //   68	17	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	7	63	finally
    //   14	31	63	finally
    //   35	51	63	finally
    //   51	60	63	finally
    //   69	94	63	finally
    //   35	51	68	java/lang/Throwable
  }
  
  public int cg()
  {
    return this.lZ.get();
  }
  
  public void ch()
  {
    this.lZ.set(0);
  }
  
  void ci()
  {
    int i = this.lZ.decrementAndGet();
    eh.f("SharkTcpControler", "[tcp_control][shark_conf]tryCloseConnectionAsyn, refCount: " + i);
    if (i <= 0)
    {
      this.lZ.set(0);
      this.lW.onClose();
    }
  }
  
  void g(long paramLong)
  {
    long l2 = 1000L * aq().aP;
    long l1 = l2;
    if (l2 < paramLong) {
      l1 = paramLong;
    }
    try
    {
      if (!this.ma)
      {
        eh.f("SharkTcpControler", "[tcp_control][shark_conf] extendConnectOnSend(), markKeepConnection()");
        cj();
        this.ma = true;
      }
      eh.f("SharkTcpControler", "[tcp_control][shark_conf] " + l1 / 1000L);
      dv.cQ().D("action_keep_alive_after_send_end");
      dv.cQ().a("action_keep_alive_after_send_end", l1, this.mb, 0);
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void cp();
    
    public abstract void onClose();
  }
  
  private class b
    extends BroadcastReceiver
  {
    private b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      eh.e("SharkTcpControler", "[tcp_control][shark_conf]doOnRecv()");
      paramContext = paramIntent.getAction();
      paramIntent = paramIntent.getPackage();
      if ((paramContext == null) || (paramIntent == null) || (!paramIntent.equals(bc.n().getPackageName()))) {
        eh.e("SharkTcpControler", "[tcp_control][shark_conf]TcpControlReceiver.onReceive(), null action or from other pkg, ignore");
      }
      do
      {
        return;
        if (paramContext.equals("action_keep_alive_cycle"))
        {
          de.e(de.this).sendEmptyMessage(3);
          return;
        }
      } while (!paramContext.equals("action_keep_alive_close"));
      de.e(de.this).sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.de
 * JD-Core Version:    0.7.0.1
 */