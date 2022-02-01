import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.qqdaily.FrontBackData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xe27.oidb_cmd0xe27.InOutQQ;

public class acyn
  implements Handler.Callback, Manager
{
  private static long RD;
  private boolean TK;
  private acyt.a a;
  private boolean aOD = true;
  private MqqHandler b;
  private boolean bKp = true;
  private BroadcastReceiver bc;
  private QQAppInterface mApp;
  private EntityManager mEntityManager;
  private List<oidb_cmd0xe27.InOutQQ> yc;
  private List<oidb_cmd0xe27.InOutQQ> yd;
  
  public acyn(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.b = new aqgw(ThreadManagerV2.getSubThreadLooper(), this);
    this.yc = new ArrayList();
    this.yd = new ArrayList();
    this.a = new acyo(this);
    cB(paramQQAppInterface);
    qh();
  }
  
  private String B(List<oidb_cmd0xe27.InOutQQ> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0xe27.InOutQQ localInOutQQ = (oidb_cmd0xe27.InOutQQ)paramList.next();
      localStringBuilder.append("data: ").append(localInOutQQ.enum_biz_id.get()).append(", timestamp: ").append(localInOutQQ.uint32_timestamp.get()).append("\n");
    }
    return localStringBuilder.toString();
  }
  
  private String C(List<FrontBackData> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FrontBackData localFrontBackData = (FrontBackData)paramList.next();
      localStringBuilder.append("data: ").append(localFrontBackData.type).append(", timestamp: ").append(localFrontBackData.time).append("\n");
    }
    return localStringBuilder.toString();
  }
  
  private void Ko(int paramInt)
  {
    hd(paramInt, 1);
  }
  
  public static void Kp(int paramInt)
  {
    acyn localacyn = (acyn)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(359);
    if (localacyn != null) {
      localacyn.Ko(paramInt);
    }
  }
  
  private oidb_cmd0xe27.InOutQQ a(FrontBackData paramFrontBackData)
  {
    oidb_cmd0xe27.InOutQQ localInOutQQ = new oidb_cmd0xe27.InOutQQ();
    localInOutQQ.uint32_timestamp.set((int)paramFrontBackData.time);
    localInOutQQ.enum_biz_id.set(paramFrontBackData.type);
    return localInOutQQ;
  }
  
  private void aO(Message paramMessage)
  {
    if (am(aS(this.yd))) {
      this.yd.clear();
    }
  }
  
  private void aP(Message paramMessage)
  {
    if ((paramMessage.obj instanceof oidb_cmd0xe27.InOutQQ))
    {
      paramMessage = (oidb_cmd0xe27.InOutQQ)paramMessage.obj;
      this.yc.add(paramMessage);
      this.yd.add(paramMessage);
      cPa();
      int i = this.yc.size();
      if (i > 20) {
        this.yc = this.yc.subList(i - 20, i);
      }
      jt(this.yc);
    }
  }
  
  private List<FrontBackData> aS(List<oidb_cmd0xe27.InOutQQ> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0xe27.InOutQQ localInOutQQ = (oidb_cmd0xe27.InOutQQ)paramList.next();
      FrontBackData localFrontBackData = new FrontBackData();
      localFrontBackData.time = localInOutQQ.uint32_timestamp.get();
      localFrontBackData.type = localInOutQQ.enum_biz_id.get();
      localArrayList.add(localFrontBackData);
    }
    return localArrayList;
  }
  
  /* Error */
  private boolean am(List<FrontBackData> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: iload 4
    //   7: istore_3
    //   8: aload_1
    //   9: ifnull +30 -> 39
    //   12: iload 4
    //   14: istore_3
    //   15: aload_1
    //   16: invokeinterface 212 1 0
    //   21: ifeq +18 -> 39
    //   24: aload_1
    //   25: invokeinterface 212 1 0
    //   30: istore_2
    //   31: iload_2
    //   32: iconst_1
    //   33: if_icmpge +10 -> 43
    //   36: iload 4
    //   38: istore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_3
    //   42: ireturn
    //   43: aload_0
    //   44: getfield 226	acyn:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   47: ifnonnull +30 -> 77
    //   50: iload 4
    //   52: istore_3
    //   53: aload_0
    //   54: getfield 39	acyn:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: invokevirtual 229	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   60: ifeq -21 -> 39
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 39	acyn:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   68: invokevirtual 232	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   71: invokevirtual 238	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   74: putfield 226	acyn:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   77: aload_0
    //   78: getfield 226	acyn:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   81: invokevirtual 244	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   84: astore 5
    //   86: aload 5
    //   88: invokevirtual 249	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   91: aload_1
    //   92: invokeinterface 84 1 0
    //   97: astore 6
    //   99: aload 6
    //   101: invokeinterface 90 1 0
    //   106: ifeq +110 -> 216
    //   109: aload 6
    //   111: invokeinterface 94 1 0
    //   116: checkcast 135	com/tencent/mobileqq/app/qqdaily/FrontBackData
    //   119: astore 7
    //   121: aload_0
    //   122: getfield 226	acyn:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   125: aload 7
    //   127: invokevirtual 253	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   130: goto -31 -> 99
    //   133: astore 6
    //   135: invokestatic 258	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +16 -> 154
    //   141: ldc_w 260
    //   144: iconst_2
    //   145: aload 6
    //   147: iconst_0
    //   148: anewarray 4	java/lang/Object
    //   151: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   154: aload 5
    //   156: invokevirtual 267	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   159: invokestatic 258	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +49 -> 211
    //   165: ldc_w 260
    //   168: iconst_2
    //   169: new 77	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 269
    //   179: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_1
    //   183: invokeinterface 212 1 0
    //   188: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: ldc_w 271
    //   194: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_0
    //   198: aload_1
    //   199: invokespecial 273	acyn:C	(Ljava/util/List;)Ljava/lang/String;
    //   202: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 277	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: iconst_1
    //   212: istore_3
    //   213: goto -174 -> 39
    //   216: aload 5
    //   218: invokevirtual 280	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   221: aload 5
    //   223: invokevirtual 267	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   226: goto -67 -> 159
    //   229: astore_1
    //   230: aload_0
    //   231: monitorexit
    //   232: aload_1
    //   233: athrow
    //   234: astore_1
    //   235: aload 5
    //   237: invokevirtual 267	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   240: aload_1
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	acyn
    //   0	242	1	paramList	List<FrontBackData>
    //   30	4	2	i	int
    //   7	206	3	bool1	boolean
    //   1	50	4	bool2	boolean
    //   84	152	5	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   97	13	6	localIterator	Iterator
    //   133	13	6	localException	Exception
    //   119	7	7	localFrontBackData	FrontBackData
    // Exception table:
    //   from	to	target	type
    //   86	99	133	java/lang/Exception
    //   99	130	133	java/lang/Exception
    //   216	221	133	java/lang/Exception
    //   15	31	229	finally
    //   43	50	229	finally
    //   53	77	229	finally
    //   77	86	229	finally
    //   154	159	229	finally
    //   159	211	229	finally
    //   221	226	229	finally
    //   235	242	229	finally
    //   86	99	234	finally
    //   99	130	234	finally
    //   135	154	234	finally
    //   216	221	234	finally
  }
  
  private void cB(QQAppInterface paramQQAppInterface)
  {
    this.bc = new acyp(this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGIN");
    paramQQAppInterface.getApp().registerReceiver(this.bc, localIntentFilter);
  }
  
  private void cOY()
  {
    this.bKp = true;
    hd(1, 2);
  }
  
  private void cOZ()
  {
    int i = 0;
    Iterator localIterator;
    try
    {
      if (this.mEntityManager == null) {
        this.mEntityManager = this.mApp.a().createEntityManager();
      }
      localIterator = null;
      try
      {
        localObject = this.mEntityManager.query(FrontBackData.class);
        if (localObject != null)
        {
          int j = ((List)localObject).size();
          if (j != 0) {}
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject = localIterator;
          if (QLog.isColorLevel())
          {
            QLog.e("FrontBackReportManager", 2, localException, new Object[0]);
            localObject = localIterator;
          }
        }
      }
      localIterator = localList.iterator();
    }
    finally {}
    for (;;)
    {
      if (localIterator.hasNext())
      {
        FrontBackData localFrontBackData = (FrontBackData)localIterator.next();
        if (localFrontBackData.time > fe())
        {
          this.yc.add(a(localFrontBackData));
        }
        else
        {
          this.mEntityManager.remove(localFrontBackData);
          i += 1;
        }
      }
      else
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FrontBackReportManager", 2, "query " + localList.size() + " items, delete " + i + " items.\n" + C(localList));
        break;
      }
    }
  }
  
  private void cPa()
  {
    if (this.yd.size() >= 1)
    {
      this.b.removeMessages(4);
      this.b.sendEmptyMessage(4);
    }
  }
  
  private static long fe()
  {
    long l = System.currentTimeMillis() / 1000L;
    if ((RD != 0L) && (86400L + RD > l)) {
      return RD;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    l = localCalendar.getTimeInMillis() / 1000L;
    RD = l;
    return l;
  }
  
  private void ff()
  {
    this.bKp = false;
    Ko(2);
  }
  
  private void hd(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    int j = 1;
    if ((!this.aOD) && (paramInt1 != 2) && (paramInt1 != 1)) {
      return;
    }
    if ((paramInt1 == 1) && (!this.TK) && ((this.bKp) || (paramInt2 == 2))) {
      this.TK = true;
    }
    for (int i = 1;; i = 0)
    {
      if ((paramInt1 == 2) && (this.TK))
      {
        if (paramInt2 == 2) {
          bool = true;
        }
        this.TK = bool;
      }
      for (paramInt2 = 1; paramInt2 != 0; paramInt2 = i)
      {
        Message localMessage = Message.obtain();
        localMessage.what = 3;
        oidb_cmd0xe27.InOutQQ localInOutQQ = new oidb_cmd0xe27.InOutQQ();
        PBEnumField localPBEnumField = localInOutQQ.enum_biz_id;
        if (paramInt1 == 1) {}
        for (paramInt1 = j;; paramInt1 = 2)
        {
          localPBEnumField.set(paramInt1);
          localInOutQQ.uint32_timestamp.set((int)(System.currentTimeMillis() / 1000L));
          localMessage.obj = localInOutQQ;
          this.b.sendMessage(localMessage);
          return;
        }
      }
      break;
    }
  }
  
  private void jt(List<oidb_cmd0xe27.InOutQQ> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return;
      acyt localacyt = (acyt)this.mApp.getBusinessHandler(173);
      localacyt.jt(paramList);
      localacyt.a(this.a);
    } while (!QLog.isColorLevel());
    QLog.d("FrontBackReportManager", 2, "report " + paramList.size() + " entities success.\n" + B(paramList));
  }
  
  private void qh()
  {
    this.b.sendEmptyMessage(5);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 3) {
      aP(paramMessage);
    }
    for (;;)
    {
      return false;
      if (paramMessage.what == 4) {
        aO(paramMessage);
      } else if (paramMessage.what == 5) {
        cOZ();
      } else if (paramMessage.what == 6) {
        this.aOD = true;
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.mEntityManager != null) {}
    try
    {
      this.mEntityManager.close();
      ((acyt)this.mApp.getBusinessHandler(173)).b(this.a);
      this.mApp.getApp().unregisterReceiver(this.bc);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acyn
 * JD-Core Version:    0.7.0.1
 */