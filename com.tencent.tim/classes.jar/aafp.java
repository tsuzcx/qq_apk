import VACDReport.ReportBody;
import VACDReport.ReportHeader;
import VACDReport.ReportInfo;
import VACDReport.ReportItem;
import VACDReport.ReportReq;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr.2;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr.4;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr.6;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;

public class aafp
  implements Manager
{
  private static boolean bvr;
  private static byte[] cw = new byte[0];
  private static byte[] mLock = new byte[0];
  public final long LP = 3600000L;
  private aafo a = new aafo(BaseApplicationImpl.getApplication());
  private Handler cj;
  private Handler ck;
  private Handler cl;
  private BusinessObserver h = new aafr(this);
  public long ib;
  private boolean isInit;
  private Map<Long, ReportInfo> iy = Collections.synchronizedMap(new HashMap(8));
  private Map<Long, Long> iz = Collections.synchronizedMap(new HashMap(8));
  private ArrayList<ReportHeader> sa = new ArrayList(8);
  private ArrayList<ReportItem> sb = new ArrayList(8);
  private HandlerThread w;
  private HandlerThread x;
  private HandlerThread z;
  
  private void Cg(boolean paramBoolean)
  {
    Handler localHandler;
    VACDReportMgr.2 local2;
    if (this.x == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "TimeOutThread start. isOnlyCheckTimeoutOnQQStart=" + paramBoolean);
      }
      this.x = new HandlerThread("QWalletReport_Check");
      this.x.start();
      this.ck = new Handler(this.x.getLooper());
      localHandler = this.ck;
      local2 = new VACDReportMgr.2(this, paramBoolean);
      if (!paramBoolean) {
        break label111;
      }
    }
    label111:
    for (long l = 5000L;; l = 0L)
    {
      localHandler.postDelayed(local2, l);
      return;
    }
  }
  
  private void FT(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VACDReport", 2, "writeCacheToDB, from=" + paramInt + ", headerSize=" + this.sa.size() + ", itemSize=" + this.sb.size());
    }
    if (this.sa.size() > 0)
    {
      this.a.hB(this.sa);
      this.sa.clear();
    }
    if (this.sb.size() > 0)
    {
      this.a.hA(this.sb);
      this.sb.clear();
    }
  }
  
  private void FU(int paramInt)
  {
    FT(paramInt);
    if ((this.iy != null) && (!this.iy.isEmpty()))
    {
      boolean bool;
      do
      {
        ArrayList localArrayList = new ArrayList();
        bool = ab(localArrayList);
        hC(localArrayList);
      } while (bool);
    }
  }
  
  private boolean ab(List<ReportInfo> paramList)
  {
    Object localObject;
    ReportInfo localReportInfo;
    ArrayList localArrayList;
    int i;
    label253:
    do
    {
      try
      {
        localObject = new ArrayList(this.iy.values());
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break;
        }
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext())
        {
          localReportInfo = (ReportInfo)localIterator.next();
          if ((localReportInfo != null) && (localReportInfo.body != null) && (localReportInfo.body.reportItems != null) && (!localReportInfo.body.reportItems.isEmpty()) && (localReportInfo.header != null) && (localReportInfo.header.totalTime >= 0L))
          {
            long l = localReportInfo.header.seqno;
            if (this.iz.containsKey(Long.valueOf(l)))
            {
              if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - ((Long)this.iz.get(Long.valueOf(l))).longValue()) > 35000L) {
                this.iz.remove(Long.valueOf(l));
              }
            }
            else
            {
              if (paramList.size() > 10L) {
                return true;
              }
              paramList.add(localReportInfo);
              Collections.sort(localReportInfo.body.reportItems);
              localArrayList = localReportInfo.body.reportItems;
              localObject = null;
              i = 0;
              if (i >= localArrayList.size()) {
                break label316;
              }
              ReportItem localReportItem = (ReportItem)localArrayList.get(i);
              if (i == 0) {
                localReportItem.costTime = 0L;
              } else {
                localReportItem.costTime = (localReportItem.createTime - ((ReportItem)localObject).createTime);
              }
            }
          }
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
      return false;
      if ((localObject != null) && (((ReportItem)localObject).result != 0)) {
        localReportInfo.header.result = ((ReportItem)localObject).result;
      }
    } while (localReportInfo.header.result != -1);
    label316:
    int j = 0;
    int k = localArrayList.size() - 2;
    for (;;)
    {
      boolean bool;
      if (k >= 0)
      {
        localObject = (ReportItem)localArrayList.get(k);
        if (localObject == null) {
          break label652;
        }
        i = j;
        if (!TextUtils.isEmpty(((ReportItem)localObject).step))
        {
          i = j;
          if (((ReportItem)localObject).step.equals("qpay_gate.cgi.end"))
          {
            bool = TextUtils.isEmpty(((ReportItem)localObject).params);
            i = j;
            if (bool) {}
          }
        }
        try
        {
          int m = ((ReportItem)localObject).params.indexOf("&cardtype=");
          i = j;
          if (m != -1)
          {
            i = "&cardtype=".length() + m;
            i = Integer.valueOf(((ReportItem)localObject).params.substring(i, i + 1)).intValue();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
        }
        j = i;
        if (((ReportItem)localObject).result == 0) {
          break label652;
        }
        j = i;
        if (((ReportItem)localObject).result == -1) {
          break label652;
        }
        localReportInfo.header.result = ((ReportItem)localObject).result;
        bool = false;
      }
      for (;;)
      {
        if ((bool) && (i > 0)) {
          localReportInfo.header.result = (i + 668900);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("VACDReport", 2, "handleUserGiveUp seqno=" + localReportInfo.header.seqno + ",result:" + localReportInfo.header.result + ",isUserGiveUp" + bool);
        break;
        bool = true;
        i = j;
      }
      return false;
      i += 1;
      localObject = localException;
      break label253;
      label652:
      k -= 1;
    }
  }
  
  public static void ctY()
  {
    if (!bvr) {
      new aafp().init(true);
    }
  }
  
  private void ctZ()
  {
    if (this.z == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "ReportThread start.");
      }
      this.z = new HandlerThread("QWalletReport_Report");
      this.z.start();
      this.cl = new aafq(this, this.z.getLooper());
    }
  }
  
  private void cua()
  {
    if (this.w == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "WriteDBThread start.");
      }
      this.w = new HandlerThread("QWalletReport_WriteDB");
      this.w.start();
      this.cj = new Handler(this.w.getLooper());
      this.cj.postDelayed(new VACDReportMgr.4(this, new byte[0]), 2000L);
    }
  }
  
  private void hC(List<ReportInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new StringBuffer();
        i = 0;
        if (i < paramList.size())
        {
          this.iz.put(Long.valueOf(((ReportInfo)paramList.get(i)).header.seqno), Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
          ((StringBuffer)localObject).append(((ReportInfo)paramList.get(i)).header.seqno);
          if (i < paramList.size() - 1) {
            ((StringBuffer)localObject).append('|');
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("VACDReport", 2, "sendReports, sendingSize=" + this.iz.size() + ", seqnoList=" + ((StringBuffer)localObject).toString());
          }
          localObject = new ReportReq();
          ((ReportReq)localObject).reports = new ArrayList(paramList);
          paramList = BaseApplicationImpl.getApplication().getRuntime();
          NewIntent localNewIntent = new NewIntent(paramList.getApplication(), aafs.class);
          localNewIntent.putExtra("req", (Serializable)localObject);
          localNewIntent.putExtra("cmd_type", 1);
          localNewIntent.setObserver(this.h);
          paramList.startServlet(localNewIntent);
          return;
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  private void hD(List<ReportHeader> paramList)
  {
    ThreadManager.post(new VACDReportMgr.6(this, paramList), 10, null, true);
  }
  
  private void init()
  {
    init(false);
  }
  
  /* Error */
  private void init(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 281	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   4: putfield 495	aafp:ib	J
    //   7: aload_0
    //   8: getfield 214	aafp:isInit	Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: getstatic 43	aafp:cw	[B
    //   18: astore_2
    //   19: aload_2
    //   20: monitorenter
    //   21: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +29 -> 53
    //   27: ldc 105
    //   29: iconst_2
    //   30: new 107	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 497
    //   40: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_1
    //   44: invokevirtual 117	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: iconst_1
    //   55: putfield 214	aafp:isInit	Z
    //   58: iconst_1
    //   59: putstatic 391	aafp:bvr	Z
    //   62: new 499	com/tencent/mobileqq/activity/qwallet/report/VACDReportMgr$1
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 500	com/tencent/mobileqq/activity/qwallet/report/VACDReportMgr$1:<init>	(Laafp;)V
    //   70: bipush 10
    //   72: aconst_null
    //   73: iconst_0
    //   74: invokestatic 492	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   77: iload_1
    //   78: ifne +11 -> 89
    //   81: aload_0
    //   82: invokespecial 502	aafp:cua	()V
    //   85: aload_0
    //   86: invokespecial 504	aafp:ctZ	()V
    //   89: aload_0
    //   90: iload_1
    //   91: invokespecial 506	aafp:Cg	(Z)V
    //   94: aload_2
    //   95: monitorexit
    //   96: return
    //   97: astore_3
    //   98: aload_2
    //   99: monitorexit
    //   100: aload_3
    //   101: athrow
    //   102: astore_3
    //   103: ldc 105
    //   105: iconst_1
    //   106: ldc_w 508
    //   109: aload_3
    //   110: invokestatic 512	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload_0
    //   114: invokevirtual 515	aafp:onDestroy	()V
    //   117: goto -23 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	aafp
    //   0	120	1	paramBoolean	boolean
    //   97	4	3	localObject	Object
    //   102	8	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   21	53	97	finally
    //   53	77	97	finally
    //   81	89	97	finally
    //   89	94	97	finally
    //   94	96	97	finally
    //   98	100	97	finally
    //   103	117	97	finally
    //   21	53	102	java/lang/Throwable
    //   53	77	102	java/lang/Throwable
    //   81	89	102	java/lang/Throwable
    //   89	94	102	java/lang/Throwable
  }
  
  public void a(long paramLong, ReportItem paramReportItem)
  {
    if (paramReportItem == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "endReport seqno=" + paramLong + "  item is null return.");
      }
    }
    Message localMessage;
    do
    {
      do
      {
        return;
        init();
      } while (this.cl == null);
      localMessage = this.cl.obtainMessage();
    } while (localMessage == null);
    localMessage.arg1 = 3;
    localMessage.obj = new Object[] { Long.valueOf(paramLong), paramReportItem };
    this.cl.sendMessage(localMessage);
  }
  
  public void a(long paramLong, String paramString, ReportItem paramReportItem)
  {
    if (paramReportItem == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "addReportItem seqno=" + paramLong + "  item is null return.");
      }
    }
    Message localMessage;
    do
    {
      do
      {
        return;
        init();
      } while (this.cl == null);
      localMessage = this.cl.obtainMessage();
    } while (localMessage == null);
    localMessage.arg1 = 2;
    localMessage.obj = new Object[] { Long.valueOf(paramLong), paramString, paramReportItem };
    this.cl.sendMessage(localMessage);
  }
  
  public void a(String paramString, ReportHeader paramReportHeader, ReportItem paramReportItem)
  {
    if (paramReportHeader == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "startReport header is null return");
      }
    }
    Message localMessage;
    do
    {
      do
      {
        do
        {
          return;
          if (paramReportHeader.seqno > 0L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VACDReport", 2, "startReport header seqno=" + paramReportHeader.seqno + " is illegal!");
        return;
        init();
      } while (this.cl == null);
      localMessage = this.cl.obtainMessage();
    } while (localMessage == null);
    localMessage.arg1 = 1;
    localMessage.obj = new Object[] { paramString, paramReportHeader, paramReportItem };
    this.cl.sendMessage(localMessage);
  }
  
  public void b(String paramString, ReportHeader paramReportHeader, ReportItem paramReportItem)
  {
    if (paramReportHeader == null) {
      if (QLog.isColorLevel()) {
        QLog.i("VACDReport", 2, "singleReport:header is null return");
      }
    }
    Message localMessage;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramReportHeader.seqno > 0L) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("VACDReport", 2, "singleReport header seqno=" + paramReportHeader.seqno + " is illegal!");
          return;
          if (paramReportItem != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("VACDReport", 2, "singleReport:item is null return");
        return;
        init();
      } while (this.cl == null);
      localMessage = this.cl.obtainMessage();
    } while (localMessage == null);
    localMessage.arg1 = 4;
    localMessage.obj = new Object[] { paramString, paramReportHeader, paramReportItem };
    this.cl.sendMessage(localMessage);
  }
  
  public void onDestroy()
  {
    synchronized (mLock)
    {
      if (!this.isInit) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "VACDReportMgr destroy@" + hashCode());
      }
      this.isInit = false;
      mLock.notifyAll();
      if (this.cl != null) {
        this.cl.removeCallbacksAndMessages(null);
      }
      if (this.z != null)
      {
        this.z.quit();
        this.z = null;
      }
      if (this.w != null)
      {
        this.w.quit();
        this.w = null;
      }
      if (this.ck != null) {
        this.ck.removeCallbacksAndMessages(null);
      }
      if (this.x != null)
      {
        this.x.quit();
        this.x = null;
      }
      if (this.iy != null) {
        this.iy.clear();
      }
      if (this.iz != null) {
        this.iz.clear();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aafp
 * JD-Core Version:    0.7.0.1
 */