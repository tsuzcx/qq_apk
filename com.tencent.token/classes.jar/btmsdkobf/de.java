package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import com.tencent.token.aqo;
import com.tmsdk.base.utils.NetworkUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
    public final void handleMessage(Message paramAnonymousMessage)
    {
      int i = paramAnonymousMessage.what;
      if (i != 3)
      {
        switch (i)
        {
        default: 
          return;
        case 1: 
          eh.f("SharkTcpControler", "[tcp_control][shark_conf] MSG_EXE_RULE_CLOSE");
          de.this.ci();
          return;
        }
        eh.f("SharkTcpControler", "[tcp_control][shark_conf] MSG_EXE_RULE_OPEN");
        de.a(de.this);
        de.b(de.this).cp();
        return;
      }
      eh.f("SharkTcpControler", "[tcp_control][shark_conf] MSG_EXE_RULE_CYCLE");
      de.c(de.this);
    }
  };
  private boolean ma = false;
  private Runnable mb = new Runnable()
  {
    public final void run()
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
    if (paramList != null)
    {
      if (paramList.size() == 0) {
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
        Collections.sort(paramList, new Comparator() {});
        return;
      }
      catch (Throwable paramList)
      {
        eh.b("SharkTcpControler", "[tcp_control][shark_conf]checkAndSort() exception: ".concat(String.valueOf(paramList)), paramList);
      }
    }
  }
  
  private void cj()
  {
    if (this.lZ.get() < 0) {
      this.lZ.set(0);
    }
    eh.f("SharkTcpControler", "[tcp_control][shark_conf]markKeepAlive(), refCount: ".concat(String.valueOf(this.lZ.incrementAndGet())));
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
      localStringBuilder = new StringBuilder("[tcp_control][shark_conf]now open connection, after ");
      localStringBuilder.append(localt.aE);
      localStringBuilder.append("s close connection");
      eh.i("SharkTcpControler", localStringBuilder.toString());
    }
    else
    {
      eh.g("SharkTcpControler", "[tcp_control][f_p][h_b][shark_conf]execRule(), scSharkConf: donnot keepAlive!");
    }
    dm.a(this.mContext, "action_keep_alive_cycle", (localt.aE + localt.aF) * 1000);
    StringBuilder localStringBuilder = new StringBuilder("[tcp_control][shark_conf]execRule(), next cycle in ");
    localStringBuilder.append(localt.aE + localt.aF);
    localStringBuilder.append("s");
    eh.i("SharkTcpControler", localStringBuilder.toString());
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
        Object localObject2 = aq();
        if ((localObject2 != null) && (((v)localObject2).aO != null) && (((v)localObject2).aO.size() > 0))
        {
          int j = co();
          i = ((v)localObject2).aO.size() - 1;
          if (i >= 0)
          {
            t localt = (t)((v)localObject2).aO.get(i);
            if (localt.aD > j) {
              break label179;
            }
            localObject2 = new StringBuilder("[tcp_control][shark_conf]getRuleAtNow(), fixed policy: start hour: ");
            ((StringBuilder)localObject2).append(localt.aD / 3600);
            ((StringBuilder)localObject2).append(" start: ");
            ((StringBuilder)localObject2).append(localt.aD);
            ((StringBuilder)localObject2).append(" keep: ");
            ((StringBuilder)localObject2).append(localt.aE);
            ((StringBuilder)localObject2).append(" close: ");
            ((StringBuilder)localObject2).append(localt.aF);
            eh.f("SharkTcpControler", ((StringBuilder)localObject2).toString());
            return localt;
          }
        }
        return null;
      }
      finally {}
      label179:
      i -= 1;
    }
  }
  
  private int co()
  {
    Calendar localCalendar = Calendar.getInstance();
    if (localCalendar == null) {
      return 0;
    }
    return localCalendar.get(11) * 3600 + localCalendar.get(12) * 60 + localCalendar.get(13);
  }
  
  private static void d(v paramv)
  {
    if (paramv == null) {
      return;
    }
    if ((paramv.aO != null) && (paramv.aO.size() > 0)) {
      b(paramv.aO);
    } else {
      paramv.aO = ck();
    }
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
    Object localObject = new StringBuilder("[shark_push][shark_conf] hash : ");
    ((StringBuilder)localObject).append(paramv.ay);
    eh.f("SharkTcpControler", ((StringBuilder)localObject).toString());
    if (paramv.az != null)
    {
      localObject = new StringBuilder("[shark_push][shark_conf] info.taskNo: ");
      ((StringBuilder)localObject).append(paramv.az.aB);
      ((StringBuilder)localObject).append(" info.seqNo: ");
      ((StringBuilder)localObject).append(paramv.az.aC);
      eh.f("SharkTcpControler", ((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder("[shark_push][shark_conf] hb interval: ");
    ((StringBuilder)localObject).append(paramv.aM);
    eh.f("SharkTcpControler", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder("[shark_push][shark_conf] KeepAliveAfterSendInSeconds: ");
    ((StringBuilder)localObject).append(paramv.aP);
    eh.f("SharkTcpControler", ((StringBuilder)localObject).toString());
    if (paramv.aO != null)
    {
      localObject = new StringBuilder("[shark_push][shark_conf]scSharkConf.policy.size(): ");
      ((StringBuilder)localObject).append(paramv.aO.size());
      eh.f("SharkTcpControler", ((StringBuilder)localObject).toString());
      localObject = paramv.aO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        t localt = (t)((Iterator)localObject).next();
        StringBuilder localStringBuilder = new StringBuilder("[shark_push][shark_conf]start: ");
        localStringBuilder.append(localt.aD);
        localStringBuilder.append(" keepAlive: ");
        localStringBuilder.append(localt.aE);
        localStringBuilder.append(" connPan: ");
        localStringBuilder.append(localt.aF);
        eh.f("SharkTcpControler", localStringBuilder.toString());
      }
    }
    localObject = new StringBuilder("[shark_push][shark_conf] scSharkConf.connIfNotWifi: ");
    ((StringBuilder)localObject).append(paramv.aQ);
    eh.f("SharkTcpControler", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder("[shark_push][shark_conf] scSharkConf.connIfScreenOff: ");
    ((StringBuilder)localObject).append(paramv.aR);
    eh.f("SharkTcpControler", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder("[shark_push][shark_conf] scSharkConf.reconnectInterval: ");
    ((StringBuilder)localObject).append(paramv.aS);
    eh.f("SharkTcpControler", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder("[shark_push][shark_conf] scSharkConf.delayOnNetworkChanging: ");
    ((StringBuilder)localObject).append(paramv.aT);
    eh.f("SharkTcpControler", ((StringBuilder)localObject).toString());
    eh.e("SharkTcpControler", "[shark_push][shark_conf]-----------------------------------------------------------");
  }
  
  boolean B(String paramString)
  {
    Object localObject = aq();
    if (localObject == null) {
      return true;
    }
    boolean bool1;
    if ((!((v)localObject).aQ) && (aqo.d != NetworkUtil.getNetworkType()))
    {
      eh.i("SharkTcpControler", "[tcp_control][shark_conf] shouldKeepAlive(), not allow in none wifi! timing: ".concat(String.valueOf(paramString)));
      bool1 = false;
    }
    else
    {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if (!((v)localObject).aR)
      {
        localObject = this.iB;
        if (localObject == null) {}
      }
    }
    try
    {
      bool2 = ((PowerManager)localObject).isScreenOn();
      i = bool2 ^ true;
    }
    catch (Throwable localThrowable)
    {
      int i;
      label96:
      break label96;
    }
    i = 0;
    bool2 = bool1;
    if (i != 0)
    {
      eh.i("SharkTcpControler", "[tcp_control][shark_conf] shouldKeepAlive(), not allow on screen off! timing: ".concat(String.valueOf(paramString)));
      bool2 = false;
    }
    return bool2;
  }
  
  public v aq()
  {
    try
    {
      if (this.lY == null)
      {
        this.lY = this.he.aL();
        if (this.lY != null)
        {
          d(this.lY);
        }
        else
        {
          this.lY = new v();
          if (cx.bB())
          {
            this.lY.aM = 30;
            this.lY.aP = 60;
          }
          else
          {
            this.lY.aM = 270;
            this.lY.aP = 300;
          }
          this.lY.aN = new ArrayList();
          this.lY.aO = ck();
          this.lY.aQ = true;
          this.lY.aR = true;
          this.lY.aS = 120;
          this.lY.aT = 2;
        }
      }
      return this.lY;
    }
    finally {}
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
  
  public void cc()
  {
    try
    {
      boolean bool = this.mc;
      if (bool) {
        return;
      }
      eh.e("SharkTcpControler", "[tcp_control][shark_conf]startTcpControl()");
      if (this.lX == null)
      {
        this.lX = new b((byte)0);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("action_keep_alive_close");
        localIntentFilter.addAction("action_keep_alive_cycle");
        try
        {
          this.mContext.registerReceiver(this.lX, localIntentFilter);
        }
        catch (Throwable localThrowable)
        {
          eh.g("SharkTcpControler", "[tcp_control][shark_conf]registerReceiver exception: ".concat(String.valueOf(localThrowable)));
        }
      }
      this.mHandler.sendEmptyMessage(3);
      this.mc = true;
      return;
    }
    finally {}
  }
  
  public void cd()
  {
    try
    {
      boolean bool = this.mc;
      if (!bool) {
        return;
      }
      eh.e("SharkTcpControler", "[tcp_control][shark_conf]stopTcpControl()");
      cm();
      b localb = this.lX;
      if (localb != null) {
        try
        {
          this.mContext.unregisterReceiver(this.lX);
          this.lX = null;
        }
        catch (Throwable localThrowable)
        {
          eh.g("SharkTcpControler", "[tcp_control][shark_conf]unregisterReceiver exception: ".concat(String.valueOf(localThrowable)));
        }
      }
      ci();
      this.mc = false;
      return;
    }
    finally {}
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
    eh.f("SharkTcpControler", "[tcp_control][shark_conf]tryCloseConnectionAsyn, refCount: ".concat(String.valueOf(i)));
    if (i <= 0)
    {
      this.lZ.set(0);
      this.lW.onClose();
    }
  }
  
  void g(long paramLong)
  {
    long l = aq().aP * 1000L;
    if (l >= paramLong) {
      paramLong = l;
    }
    try
    {
      if (!this.ma)
      {
        eh.f("SharkTcpControler", "[tcp_control][shark_conf] extendConnectOnSend(), markKeepConnection()");
        cj();
        this.ma = true;
      }
      StringBuilder localStringBuilder = new StringBuilder("[tcp_control][shark_conf] ");
      localStringBuilder.append(paramLong / 1000L);
      eh.f("SharkTcpControler", localStringBuilder.toString());
      dv.cQ().D("action_keep_alive_after_send_end");
      dv.cQ().a("action_keep_alive_after_send_end", paramLong, this.mb, 0);
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void cp();
    
    public abstract void onClose();
  }
  
  final class b
    extends BroadcastReceiver
  {
    private b() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      eh.e("SharkTcpControler", "[tcp_control][shark_conf]doOnRecv()");
      paramContext = paramIntent.getAction();
      paramIntent = paramIntent.getPackage();
      if ((paramContext != null) && (paramIntent != null) && (paramIntent.equals(bc.n().getPackageName())))
      {
        if (paramContext.equals("action_keep_alive_cycle"))
        {
          de.e(de.this).sendEmptyMessage(3);
          return;
        }
        if (paramContext.equals("action_keep_alive_close")) {
          de.e(de.this).sendEmptyMessage(1);
        }
        return;
      }
      eh.e("SharkTcpControler", "[tcp_control][shark_conf]TcpControlReceiver.onReceive(), null action or from other pkg, ignore");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.de
 * JD-Core Version:    0.7.0.1
 */