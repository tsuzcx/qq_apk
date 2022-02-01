package com.tencent.mobileqq.app.proxy;

import acrb;
import acxq;
import acxr;
import acxs;
import acxt;
import acxu;
import acxv;
import acxw;
import aebo;
import aegz;
import agne;
import ahcg;
import ahth;
import ajes;
import alkq;
import anaz;
import apds;
import auvk;
import avhp.b;
import awit;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportControllerImpl.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import toh;
import tom;
import too;
import top;

public class ProxyManager
  extends BaseProxyManager
{
  private static final Class[] g = { alkq.class, aegz.class };
  private acrb jdField_a_of_type_Acrb;
  private acxt jdField_a_of_type_Acxt;
  private acxv jdField_a_of_type_Acxv;
  private aebo jdField_a_of_type_Aebo;
  private aegz jdField_a_of_type_Aegz;
  private agne jdField_a_of_type_Agne;
  private ahcg jdField_a_of_type_Ahcg;
  private ahth jdField_a_of_type_Ahth;
  private ajes jdField_a_of_type_Ajes;
  private alkq jdField_a_of_type_Alkq;
  private apds jdField_a_of_type_Apds;
  private avhp.b jdField_a_of_type_Avhp$b;
  private ReportControllerImpl.a jdField_a_of_type_ComTencentMobileqqStatisticsReportControllerImpl$a;
  private too jdField_a_of_type_Too;
  private acxq[] jdField_a_of_type_ArrayOfAcxq;
  private QQAppInterface app;
  private acxt jdField_b_of_type_Acxt;
  private toh jdField_b_of_type_Toh;
  private boolean bKk = true;
  private Set<acxq> bZ = new HashSet();
  
  @Deprecated
  public ProxyManager() {}
  
  public ProxyManager(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.app = paramQQAppInterface;
    awit.eV(this.app);
    awit.eX(this.app);
    cOO();
  }
  
  private boolean a(acxq paramacxq)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      try
      {
        if (i < g.length)
        {
          Class localClass1 = paramacxq.getClass();
          Class localClass2 = g[i];
          if (localClass1 == localClass2) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      finally {}
    }
  }
  
  private void cOO()
  {
    this.jdField_a_of_type_Too = new too(this.app, this, new tom());
    this.jdField_a_of_type_Acrb = new acrb(this.app, this);
    this.jdField_b_of_type_Acxt = new acxs(this.app, this);
    this.jdField_a_of_type_Acxt = new acxr(this.app, this);
    this.jdField_a_of_type_Acxv = new acxv(this.app, this);
    this.jdField_a_of_type_Agne = new agne(this.app, this);
    this.jdField_a_of_type_Apds = new apds(this.app, this);
    this.jdField_a_of_type_Ahcg = new ahcg(this.app, this);
    this.jdField_a_of_type_ComTencentMobileqqStatisticsReportControllerImpl$a = new ReportControllerImpl.a(this.app, this);
    this.jdField_a_of_type_Avhp$b = new avhp.b(this.app, this);
    this.jdField_b_of_type_Toh = new toh(this.app, this);
    this.jdField_a_of_type_Alkq = new alkq(this.app, this);
    this.jdField_a_of_type_Aegz = new aegz(this.app, this);
    this.jdField_a_of_type_Ajes = new ajes(this.app, this);
    this.jdField_a_of_type_Aebo = new aebo(this.app, this);
    this.jdField_a_of_type_Ahth = new ahth(this.app, this, new tom());
    this.jdField_a_of_type_ArrayOfAcxq = new acxq[] { this.jdField_a_of_type_Too, this.jdField_b_of_type_Acxt, this.jdField_a_of_type_Acxt, this.jdField_a_of_type_Agne, this.jdField_a_of_type_ComTencentMobileqqStatisticsReportControllerImpl$a, this.jdField_a_of_type_Avhp$b, this.jdField_a_of_type_Ahcg, this.jdField_b_of_type_Toh, this.jdField_a_of_type_Alkq, this.jdField_a_of_type_Aegz, this.jdField_a_of_type_Apds, this.jdField_a_of_type_Ajes, this.jdField_a_of_type_Aebo, this.jdField_a_of_type_Ahth };
  }
  
  public acxt a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_b_of_type_Acxt.init();
      return this.jdField_b_of_type_Acxt;
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Acxt.init();
      return this.jdField_a_of_type_Acxt;
    }
    this.jdField_b_of_type_Acxt.init();
    return this.jdField_b_of_type_Acxt;
  }
  
  public acxv a()
  {
    return this.jdField_a_of_type_Acxv;
  }
  
  @Deprecated
  public acxw a()
  {
    return this.app.a();
  }
  
  public aebo a()
  {
    return this.jdField_a_of_type_Aebo;
  }
  
  public aegz a()
  {
    return this.jdField_a_of_type_Aegz;
  }
  
  public agne a()
  {
    return this.jdField_a_of_type_Agne;
  }
  
  public ahcg a()
  {
    return this.jdField_a_of_type_Ahcg;
  }
  
  public ahth a()
  {
    return this.jdField_a_of_type_Ahth;
  }
  
  public ajes a()
  {
    return this.jdField_a_of_type_Ajes;
  }
  
  public alkq a()
  {
    return this.jdField_a_of_type_Alkq;
  }
  
  public apds a()
  {
    return this.jdField_a_of_type_Apds;
  }
  
  public toh a()
  {
    return this.jdField_b_of_type_Toh;
  }
  
  public too a()
  {
    return this.jdField_a_of_type_Too;
  }
  
  public acrb b()
  {
    return this.jdField_a_of_type_Acrb;
  }
  
  public void bEx()
  {
    for (;;)
    {
      try
      {
        if (!this.isDestroyed)
        {
          boolean bool = this.bZ.isEmpty();
          if (!bool) {}
        }
        else
        {
          return;
        }
        Iterator localIterator = this.bZ.iterator();
        if (localIterator.hasNext())
        {
          acxq localacxq = (acxq)localIterator.next();
          auvk.traceBegin("i." + localacxq);
          long l = System.currentTimeMillis();
          localacxq.init();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "ProxyInit , proxy=" + localacxq.getClass().getName() + "cost=" + (System.currentTimeMillis() - l));
          }
          auvk.traceEnd();
        }
        else
        {
          this.bZ.clear();
        }
      }
      finally {}
    }
  }
  
  public void doAddMsgQueue(String paramString1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    if (QLog.isColorLevel())
    {
      MsgQueueItem localMsgQueueItem = new MsgQueueItem(paramString1, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
      if ((localMsgQueueItem.item instanceof MessageRecord)) {
        QLog.d("Q.msg.MsgProxy", 2, "addMsgQueueDonotNotify QueueItem.action: " + localMsgQueueItem.action + ",mr=" + localMsgQueueItem.item);
      }
    }
    super.doAddMsgQueue(paramString1, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
  }
  
  protected void doAfterTransSaveToDatabase()
  {
    super.doAfterTransSaveToDatabase();
    this.app.a().commit();
  }
  
  protected int getSaveInDBState()
  {
    return this.app.a.Bd();
  }
  
  protected void init()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i < this.jdField_a_of_type_ArrayOfAcxq.length) && (!this.isDestroyed)) {
          if (a(this.jdField_a_of_type_ArrayOfAcxq[i]))
          {
            this.bZ.add(this.jdField_a_of_type_ArrayOfAcxq[i]);
          }
          else
          {
            auvk.traceBegin("i." + this.jdField_a_of_type_ArrayOfAcxq[i]);
            long l = System.currentTimeMillis();
            this.jdField_a_of_type_ArrayOfAcxq[i].init();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "ProxyInit , proxy=" + this.jdField_a_of_type_ArrayOfAcxq[i].getClass().getName() + "cost=" + (System.currentTimeMillis() - l));
            }
            auvk.traceEnd();
          }
        }
      }
      finally {}
      return;
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    int j = 0;
    try
    {
      this.app.a().onDestroy();
      this.isDestroyed = true;
      ThreadManager.post(new ProxyManager.1(this), 8, null, false);
      int i = j;
      if (this.msgQueue != null) {}
      synchronized (this.msgQueueLock)
      {
        if (this.msgQueue != null) {
          this.msgQueueLock.notify();
        }
        i = j;
        if (i < this.jdField_a_of_type_ArrayOfAcxq.length)
        {
          this.jdField_a_of_type_ArrayOfAcxq[i].destory();
          i += 1;
        }
      }
    }
    finally {}
  }
  
  public void transSaveToDatabase(String paramString, int paramInt)
  {
    ArrayList localArrayList;
    synchronized (this.transSaveLock)
    {
      localArrayList = new ArrayList();
      synchronized (this.msgQueueLock)
      {
        if (this.msgQueue.isEmpty()) {
          return;
        }
        Iterator localIterator = this.msgQueue.iterator();
        while (localIterator.hasNext())
        {
          MsgQueueItem localMsgQueueItem = (MsgQueueItem)localIterator.next();
          if ((top.isSaveConversation(localMsgQueueItem.frindUin, paramString, localMsgQueueItem.type, paramInt)) && ((localMsgQueueItem.action == 1) || (localMsgQueueItem.action == 2) || (localMsgQueueItem.action == 0))) {
            localArrayList.add(localMsgQueueItem);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, new Object[] { "transSaveToDatabase writeRunnable msgQueue size:", Integer.valueOf(this.msgQueue.size()), " item size:", Integer.valueOf(localArrayList.size()) });
    }
    this.msgQueue.remove(localArrayList);
    transSaveToDatabaseIndeed(this.app.getEntityManagerFactory(this.app.getCurrentAccountUin()).createEntityManager(), localArrayList);
    this.app.a().commit();
  }
  
  /* Error */
  protected void transSaveToDatabaseIndeed(com.tencent.mobileqq.persistence.EntityManager paramEntityManager, List<MsgQueueItem> paramList)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 420 1 0
    //   6: ifeq +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: getfield 53	com/tencent/mobileqq/app/proxy/ProxyManager:bKk	Z
    //   14: ifeq +59 -> 73
    //   17: getstatic 423	acxu:ENABLE	Z
    //   20: ifeq +467 -> 487
    //   23: aload_0
    //   24: getfield 60	com/tencent/mobileqq/app/proxy/ProxyManager:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokestatic 429	aqoe:cg	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   30: ifeq +457 -> 487
    //   33: aload_0
    //   34: getfield 60	com/tencent/mobileqq/app/proxy/ProxyManager:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokevirtual 323	com/tencent/mobileqq/app/QQAppInterface:a	()Lacxu;
    //   40: invokevirtual 432	acxu:hasInit	()Z
    //   43: ifeq +30 -> 73
    //   46: aload_0
    //   47: getfield 60	com/tencent/mobileqq/app/proxy/ProxyManager:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   50: invokevirtual 323	com/tencent/mobileqq/app/QQAppInterface:a	()Lacxu;
    //   53: invokevirtual 435	acxu:a	()Lacxz;
    //   56: astore 17
    //   58: aload 17
    //   60: ifnull +8 -> 68
    //   63: aload 17
    //   65: invokevirtual 440	acxz:cOP	()V
    //   68: aload_0
    //   69: iconst_0
    //   70: putfield 53	com/tencent/mobileqq/app/proxy/ProxyManager:bKk	Z
    //   73: aconst_null
    //   74: astore 17
    //   76: invokestatic 445	anpc:ayC	()Z
    //   79: istore 10
    //   81: iload 10
    //   83: ifeq +412 -> 495
    //   86: iconst_0
    //   87: invokestatic 449	anpc:lH	(I)Z
    //   90: ifeq +405 -> 495
    //   93: iconst_1
    //   94: istore 7
    //   96: invokestatic 455	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   99: astore 18
    //   101: invokestatic 458	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   104: astore 19
    //   106: aload 18
    //   108: aload 19
    //   110: if_acmpne +391 -> 501
    //   113: iconst_1
    //   114: istore 9
    //   116: iload 9
    //   118: ifeq +36 -> 154
    //   121: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq +30 -> 154
    //   127: ldc 247
    //   129: iconst_2
    //   130: new 213	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   137: ldc_w 460
    //   140: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: iload 9
    //   145: invokevirtual 463	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   148: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload_1
    //   155: invokevirtual 469	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   158: astore 18
    //   160: aload 18
    //   162: astore 17
    //   164: invokestatic 472	java/lang/System:nanoTime	()J
    //   167: lstore 13
    //   169: aload 17
    //   171: invokevirtual 477	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   174: iload 7
    //   176: ifeq +2084 -> 2260
    //   179: invokestatic 472	java/lang/System:nanoTime	()J
    //   182: lload 13
    //   184: lsub
    //   185: ldc2_w 478
    //   188: ldiv
    //   189: lstore 11
    //   191: new 481	java/util/HashMap
    //   194: dup
    //   195: invokespecial 482	java/util/HashMap:<init>	()V
    //   198: astore 19
    //   200: iload 9
    //   202: ifeq +305 -> 507
    //   205: ldc_w 484
    //   208: astore 18
    //   210: aload 19
    //   212: ldc_w 486
    //   215: aload 18
    //   217: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   220: pop
    //   221: aload 19
    //   223: ldc_w 492
    //   226: ldc_w 494
    //   229: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   232: pop
    //   233: aload 19
    //   235: ldc_w 496
    //   238: lload 11
    //   240: invokestatic 501	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   243: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   246: pop
    //   247: aload 19
    //   249: ldc_w 503
    //   252: getstatic 508	com/tencent/mobileqq/app/SQLiteOpenHelper:WAL_ENABLE	Z
    //   255: invokestatic 511	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   258: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   261: pop
    //   262: invokestatic 517	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   265: invokestatic 520	anpc:a	(Landroid/content/Context;)Lanpc;
    //   268: aconst_null
    //   269: ldc_w 522
    //   272: iconst_1
    //   273: ldc2_w 523
    //   276: lconst_0
    //   277: aload 19
    //   279: aconst_null
    //   280: iconst_0
    //   281: invokevirtual 528	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   284: aload_2
    //   285: invokeinterface 529 1 0
    //   290: astore 18
    //   292: iconst_0
    //   293: istore_3
    //   294: iconst_0
    //   295: istore 4
    //   297: aload 18
    //   299: invokeinterface 207 1 0
    //   304: ifeq +1174 -> 1478
    //   307: aload 18
    //   309: invokeinterface 211 1 0
    //   314: checkcast 271	com/tencent/mobileqq/app/proxy/MsgQueueItem
    //   317: astore 19
    //   319: iload 4
    //   321: iconst_1
    //   322: iadd
    //   323: istore 4
    //   325: iload_3
    //   326: istore 6
    //   328: iload_3
    //   329: istore 5
    //   331: aload 19
    //   333: getfield 532	com/tencent/mobileqq/app/proxy/MsgQueueItem:tableName	Ljava/lang/String;
    //   336: astore 20
    //   338: iload_3
    //   339: istore 6
    //   341: iload_3
    //   342: istore 5
    //   344: aload 19
    //   346: getfield 536	com/tencent/mobileqq/app/proxy/MsgQueueItem:listener	Lcom/tencent/mobileqq/app/proxy/ProxyListener;
    //   349: astore 21
    //   351: iload_3
    //   352: istore 6
    //   354: iload_3
    //   355: istore 5
    //   357: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   360: ifeq +1908 -> 2268
    //   363: iload_3
    //   364: istore 6
    //   366: iload_3
    //   367: istore 5
    //   369: aload 19
    //   371: getfield 277	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   374: instanceof 279
    //   377: ifeq +138 -> 515
    //   380: iload_3
    //   381: iconst_1
    //   382: iadd
    //   383: istore_3
    //   384: iload_3
    //   385: istore 6
    //   387: iload_3
    //   388: istore 5
    //   390: ldc 247
    //   392: iconst_2
    //   393: iconst_4
    //   394: anewarray 74	java/lang/Object
    //   397: dup
    //   398: iconst_0
    //   399: ldc_w 538
    //   402: aastore
    //   403: dup
    //   404: iconst_1
    //   405: aload 19
    //   407: getfield 285	com/tencent/mobileqq/app/proxy/MsgQueueItem:action	I
    //   410: invokestatic 391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   413: aastore
    //   414: dup
    //   415: iconst_2
    //   416: ldc_w 540
    //   419: aastore
    //   420: dup
    //   421: iconst_3
    //   422: aload 19
    //   424: getfield 277	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   427: aastore
    //   428: invokestatic 397	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   431: aload 19
    //   433: getfield 285	com/tencent/mobileqq/app/proxy/MsgQueueItem:action	I
    //   436: istore 5
    //   438: iload 5
    //   440: tableswitch	default:+44 -> 484, 0:+221->661, 1:+494->934, 2:+755->1195, 3:+468->908, 4:+727->1167, 5:+970->1410, 6:+998->1438
    //   485: impdep2
    //   486: fstore_2
    //   487: aload_0
    //   488: iconst_0
    //   489: putfield 53	com/tencent/mobileqq/app/proxy/ProxyManager:bKk	Z
    //   492: goto -419 -> 73
    //   495: iconst_0
    //   496: istore 7
    //   498: goto -402 -> 96
    //   501: iconst_0
    //   502: istore 9
    //   504: goto -388 -> 116
    //   507: ldc_w 542
    //   510: astore 18
    //   512: goto -302 -> 210
    //   515: iload_3
    //   516: istore 6
    //   518: iload_3
    //   519: istore 5
    //   521: aload 19
    //   523: getfield 285	com/tencent/mobileqq/app/proxy/MsgQueueItem:action	I
    //   526: istore 8
    //   528: iload_3
    //   529: istore 6
    //   531: iload_3
    //   532: istore 5
    //   534: aload 19
    //   536: getfield 368	com/tencent/mobileqq/app/proxy/MsgQueueItem:frindUin	Ljava/lang/String;
    //   539: astore 22
    //   541: iload_3
    //   542: istore 6
    //   544: iload_3
    //   545: istore 5
    //   547: aload 19
    //   549: getfield 532	com/tencent/mobileqq/app/proxy/MsgQueueItem:tableName	Ljava/lang/String;
    //   552: astore 23
    //   554: iload_3
    //   555: istore 6
    //   557: iload_3
    //   558: istore 5
    //   560: aload 19
    //   562: getfield 546	com/tencent/mobileqq/app/proxy/MsgQueueItem:value	Landroid/content/ContentValues;
    //   565: ifnull +89 -> 654
    //   568: iload_3
    //   569: istore 6
    //   571: iload_3
    //   572: istore 5
    //   574: aload 19
    //   576: getfield 546	com/tencent/mobileqq/app/proxy/MsgQueueItem:value	Landroid/content/ContentValues;
    //   579: invokevirtual 551	android/content/ContentValues:hashCode	()I
    //   582: invokestatic 391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   585: astore_2
    //   586: iload_3
    //   587: istore 6
    //   589: iload_3
    //   590: istore 5
    //   592: ldc 247
    //   594: iconst_2
    //   595: bipush 8
    //   597: anewarray 74	java/lang/Object
    //   600: dup
    //   601: iconst_0
    //   602: ldc_w 538
    //   605: aastore
    //   606: dup
    //   607: iconst_1
    //   608: iload 8
    //   610: invokestatic 391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   613: aastore
    //   614: dup
    //   615: iconst_2
    //   616: ldc_w 553
    //   619: aastore
    //   620: dup
    //   621: iconst_3
    //   622: aload 22
    //   624: aastore
    //   625: dup
    //   626: iconst_4
    //   627: ldc_w 555
    //   630: aastore
    //   631: dup
    //   632: iconst_5
    //   633: aload 23
    //   635: aastore
    //   636: dup
    //   637: bipush 6
    //   639: ldc_w 557
    //   642: aastore
    //   643: dup
    //   644: bipush 7
    //   646: aload_2
    //   647: aastore
    //   648: invokestatic 397	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   651: goto +1617 -> 2268
    //   654: ldc_w 559
    //   657: astore_2
    //   658: goto -72 -> 586
    //   661: invokestatic 472	java/lang/System:nanoTime	()J
    //   664: lstore 11
    //   666: getstatic 423	acxu:ENABLE	Z
    //   669: ifeq +41 -> 710
    //   672: aload_0
    //   673: getfield 60	com/tencent/mobileqq/app/proxy/ProxyManager:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   676: invokestatic 429	aqoe:cg	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   679: ifeq +31 -> 710
    //   682: aload_0
    //   683: getfield 60	com/tencent/mobileqq/app/proxy/ProxyManager:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   686: invokestatic 562	aqoe:ch	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   689: ifeq +21 -> 710
    //   692: aload_0
    //   693: getfield 60	com/tencent/mobileqq/app/proxy/ProxyManager:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   696: invokevirtual 323	com/tencent/mobileqq/app/QQAppInterface:a	()Lacxu;
    //   699: invokevirtual 435	acxu:a	()Lacxz;
    //   702: aload 19
    //   704: getfield 277	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   707: invokevirtual 566	acxz:c	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   710: aload_1
    //   711: aload 19
    //   713: getfield 277	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   716: invokevirtual 569	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   719: invokestatic 472	java/lang/System:nanoTime	()J
    //   722: lload 11
    //   724: lsub
    //   725: ldc2_w 478
    //   728: ldiv
    //   729: lstore 15
    //   731: aload 21
    //   733: ifnull +12 -> 745
    //   736: aload 21
    //   738: aload 20
    //   740: invokeinterface 574 2 0
    //   745: getstatic 423	acxu:ENABLE	Z
    //   748: ifeq +42 -> 790
    //   751: aload_0
    //   752: getfield 60	com/tencent/mobileqq/app/proxy/ProxyManager:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   755: invokestatic 429	aqoe:cg	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   758: ifeq +32 -> 790
    //   761: aload_0
    //   762: getfield 60	com/tencent/mobileqq/app/proxy/ProxyManager:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   765: invokestatic 562	aqoe:ch	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   768: ifeq +22 -> 790
    //   771: aload_0
    //   772: getfield 60	com/tencent/mobileqq/app/proxy/ProxyManager:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   775: invokevirtual 323	com/tencent/mobileqq/app/QQAppInterface:a	()Lacxu;
    //   778: invokevirtual 435	acxu:a	()Lacxz;
    //   781: aload 19
    //   783: getfield 277	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   786: aload_1
    //   787: invokevirtual 577	acxz:a	(Lcom/tencent/mobileqq/persistence/Entity;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   790: lload 15
    //   792: lstore 11
    //   794: iload 10
    //   796: ifeq +1454 -> 2250
    //   799: lload 15
    //   801: lstore 11
    //   803: iconst_4
    //   804: invokestatic 449	anpc:lH	(I)Z
    //   807: ifeq +1443 -> 2250
    //   810: new 481	java/util/HashMap
    //   813: dup
    //   814: invokespecial 482	java/util/HashMap:<init>	()V
    //   817: astore 19
    //   819: iload 9
    //   821: ifeq +1450 -> 2271
    //   824: ldc_w 484
    //   827: astore_2
    //   828: aload 19
    //   830: ldc_w 486
    //   833: aload_2
    //   834: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   837: pop
    //   838: aload 19
    //   840: ldc_w 492
    //   843: ldc_w 579
    //   846: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   849: pop
    //   850: aload 19
    //   852: ldc_w 496
    //   855: lload 15
    //   857: invokestatic 501	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   860: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   863: pop
    //   864: aload 19
    //   866: ldc_w 503
    //   869: getstatic 508	com/tencent/mobileqq/app/SQLiteOpenHelper:WAL_ENABLE	Z
    //   872: invokestatic 511	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   875: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   878: pop
    //   879: invokestatic 517	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   882: invokestatic 520	anpc:a	(Landroid/content/Context;)Lanpc;
    //   885: aconst_null
    //   886: ldc_w 522
    //   889: iconst_1
    //   890: ldc2_w 523
    //   893: lconst_0
    //   894: aload 19
    //   896: aconst_null
    //   897: iconst_0
    //   898: invokevirtual 528	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   901: lload 15
    //   903: lstore 11
    //   905: goto -421 -> 484
    //   908: aload_1
    //   909: aload 19
    //   911: getfield 277	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   914: invokevirtual 569	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   917: aload 21
    //   919: ifnull -435 -> 484
    //   922: aload 21
    //   924: aload 20
    //   926: invokeinterface 574 2 0
    //   931: goto -447 -> 484
    //   934: getstatic 423	acxu:ENABLE	Z
    //   937: ifeq +39 -> 976
    //   940: aload_0
    //   941: getfield 60	com/tencent/mobileqq/app/proxy/ProxyManager:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   944: invokestatic 429	aqoe:cg	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   947: ifeq +29 -> 976
    //   950: aload_0
    //   951: getfield 60	com/tencent/mobileqq/app/proxy/ProxyManager:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   954: invokestatic 562	aqoe:ch	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   957: ifeq +19 -> 976
    //   960: aload_0
    //   961: getfield 60	com/tencent/mobileqq/app/proxy/ProxyManager:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   964: invokevirtual 323	com/tencent/mobileqq/app/QQAppInterface:a	()Lacxu;
    //   967: invokevirtual 435	acxu:a	()Lacxz;
    //   970: aload 19
    //   972: aload_1
    //   973: invokevirtual 582	acxz:a	(Lcom/tencent/mobileqq/app/proxy/MsgQueueItem;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   976: invokestatic 472	java/lang/System:nanoTime	()J
    //   979: lstore 15
    //   981: aload_0
    //   982: invokevirtual 586	com/tencent/mobileqq/app/proxy/ProxyManager:getDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   985: astore_2
    //   986: aload_2
    //   987: ifnull +1266 -> 2253
    //   990: aload_2
    //   991: aload 20
    //   993: aload 19
    //   995: getfield 546	com/tencent/mobileqq/app/proxy/MsgQueueItem:value	Landroid/content/ContentValues;
    //   998: aload 19
    //   1000: getfield 589	com/tencent/mobileqq/app/proxy/MsgQueueItem:whereClause	Ljava/lang/String;
    //   1003: aload 19
    //   1005: getfield 593	com/tencent/mobileqq/app/proxy/MsgQueueItem:whereArgs	[Ljava/lang/String;
    //   1008: invokevirtual 599	com/tencent/mobileqq/app/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1011: istore 5
    //   1013: invokestatic 472	java/lang/System:nanoTime	()J
    //   1016: lload 15
    //   1018: lsub
    //   1019: ldc2_w 478
    //   1022: ldiv
    //   1023: lstore 11
    //   1025: lload 11
    //   1027: lstore 15
    //   1029: aload 21
    //   1031: ifnull +18 -> 1049
    //   1034: aload 21
    //   1036: aload 20
    //   1038: iload 5
    //   1040: invokeinterface 602 3 0
    //   1045: lload 11
    //   1047: lstore 15
    //   1049: lload 15
    //   1051: lstore 11
    //   1053: iload 10
    //   1055: ifeq +1195 -> 2250
    //   1058: lload 15
    //   1060: lstore 11
    //   1062: iconst_5
    //   1063: invokestatic 449	anpc:lH	(I)Z
    //   1066: ifeq +1184 -> 2250
    //   1069: new 481	java/util/HashMap
    //   1072: dup
    //   1073: invokespecial 482	java/util/HashMap:<init>	()V
    //   1076: astore 19
    //   1078: iload 9
    //   1080: ifeq +1198 -> 2278
    //   1083: ldc_w 484
    //   1086: astore_2
    //   1087: aload 19
    //   1089: ldc_w 486
    //   1092: aload_2
    //   1093: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1096: pop
    //   1097: aload 19
    //   1099: ldc_w 492
    //   1102: ldc_w 603
    //   1105: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1108: pop
    //   1109: aload 19
    //   1111: ldc_w 496
    //   1114: lload 15
    //   1116: invokestatic 501	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1119: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1122: pop
    //   1123: aload 19
    //   1125: ldc_w 503
    //   1128: getstatic 508	com/tencent/mobileqq/app/SQLiteOpenHelper:WAL_ENABLE	Z
    //   1131: invokestatic 511	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1134: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1137: pop
    //   1138: invokestatic 517	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1141: invokestatic 520	anpc:a	(Landroid/content/Context;)Lanpc;
    //   1144: aconst_null
    //   1145: ldc_w 522
    //   1148: iconst_1
    //   1149: ldc2_w 523
    //   1152: lconst_0
    //   1153: aload 19
    //   1155: aconst_null
    //   1156: iconst_0
    //   1157: invokevirtual 528	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1160: lload 15
    //   1162: lstore 11
    //   1164: goto -680 -> 484
    //   1167: aload_1
    //   1168: aload 19
    //   1170: getfield 277	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   1173: invokevirtual 606	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   1176: pop
    //   1177: aload 21
    //   1179: ifnull -695 -> 484
    //   1182: aload 21
    //   1184: aload 20
    //   1186: iconst_1
    //   1187: invokeinterface 602 3 0
    //   1192: goto -708 -> 484
    //   1195: getstatic 423	acxu:ENABLE	Z
    //   1198: ifeq +39 -> 1237
    //   1201: aload_0
    //   1202: getfield 60	com/tencent/mobileqq/app/proxy/ProxyManager:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1205: invokestatic 429	aqoe:cg	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   1208: ifeq +29 -> 1237
    //   1211: aload_0
    //   1212: getfield 60	com/tencent/mobileqq/app/proxy/ProxyManager:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1215: invokestatic 562	aqoe:ch	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   1218: ifeq +19 -> 1237
    //   1221: aload_0
    //   1222: getfield 60	com/tencent/mobileqq/app/proxy/ProxyManager:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1225: invokevirtual 323	com/tencent/mobileqq/app/QQAppInterface:a	()Lacxu;
    //   1228: invokevirtual 435	acxu:a	()Lacxz;
    //   1231: aload 19
    //   1233: aload_1
    //   1234: invokevirtual 608	acxz:b	(Lcom/tencent/mobileqq/app/proxy/MsgQueueItem;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1237: invokestatic 472	java/lang/System:nanoTime	()J
    //   1240: lstore 11
    //   1242: aload_0
    //   1243: invokevirtual 586	com/tencent/mobileqq/app/proxy/ProxyManager:getDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   1246: aload 20
    //   1248: aload 19
    //   1250: getfield 589	com/tencent/mobileqq/app/proxy/MsgQueueItem:whereClause	Ljava/lang/String;
    //   1253: aload 19
    //   1255: getfield 593	com/tencent/mobileqq/app/proxy/MsgQueueItem:whereArgs	[Ljava/lang/String;
    //   1258: invokevirtual 612	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1261: istore 5
    //   1263: invokestatic 472	java/lang/System:nanoTime	()J
    //   1266: lload 11
    //   1268: lsub
    //   1269: ldc2_w 478
    //   1272: ldiv
    //   1273: lstore 15
    //   1275: aload 21
    //   1277: ifnull +14 -> 1291
    //   1280: aload 21
    //   1282: aload 20
    //   1284: iload 5
    //   1286: invokeinterface 615 3 0
    //   1291: lload 15
    //   1293: lstore 11
    //   1295: iload 10
    //   1297: ifeq +953 -> 2250
    //   1300: lload 15
    //   1302: lstore 11
    //   1304: bipush 6
    //   1306: invokestatic 449	anpc:lH	(I)Z
    //   1309: ifeq +941 -> 2250
    //   1312: new 481	java/util/HashMap
    //   1315: dup
    //   1316: invokespecial 482	java/util/HashMap:<init>	()V
    //   1319: astore 19
    //   1321: iload 9
    //   1323: ifeq +962 -> 2285
    //   1326: ldc_w 484
    //   1329: astore_2
    //   1330: aload 19
    //   1332: ldc_w 486
    //   1335: aload_2
    //   1336: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1339: pop
    //   1340: aload 19
    //   1342: ldc_w 492
    //   1345: ldc_w 616
    //   1348: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1351: pop
    //   1352: aload 19
    //   1354: ldc_w 496
    //   1357: lload 15
    //   1359: invokestatic 501	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1362: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1365: pop
    //   1366: aload 19
    //   1368: ldc_w 503
    //   1371: getstatic 508	com/tencent/mobileqq/app/SQLiteOpenHelper:WAL_ENABLE	Z
    //   1374: invokestatic 511	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1377: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1380: pop
    //   1381: invokestatic 517	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1384: invokestatic 520	anpc:a	(Landroid/content/Context;)Lanpc;
    //   1387: aconst_null
    //   1388: ldc_w 522
    //   1391: iconst_1
    //   1392: ldc2_w 523
    //   1395: lconst_0
    //   1396: aload 19
    //   1398: aconst_null
    //   1399: iconst_0
    //   1400: invokevirtual 528	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1403: lload 15
    //   1405: lstore 11
    //   1407: goto -923 -> 484
    //   1410: aload_1
    //   1411: aload 19
    //   1413: getfield 277	com/tencent/mobileqq/app/proxy/MsgQueueItem:item	Lcom/tencent/mobileqq/persistence/Entity;
    //   1416: invokevirtual 618	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   1419: pop
    //   1420: aload 21
    //   1422: ifnull -938 -> 484
    //   1425: aload 21
    //   1427: aload 20
    //   1429: iconst_1
    //   1430: invokeinterface 615 3 0
    //   1435: goto -951 -> 484
    //   1438: aload_0
    //   1439: invokevirtual 586	com/tencent/mobileqq/app/proxy/ProxyManager:getDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   1442: aload 20
    //   1444: aload 19
    //   1446: getfield 589	com/tencent/mobileqq/app/proxy/MsgQueueItem:whereClause	Ljava/lang/String;
    //   1449: aload 19
    //   1451: getfield 593	com/tencent/mobileqq/app/proxy/MsgQueueItem:whereArgs	[Ljava/lang/String;
    //   1454: invokevirtual 612	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1457: istore 5
    //   1459: aload 21
    //   1461: ifnull +14 -> 1475
    //   1464: aload 21
    //   1466: aload 20
    //   1468: iload 5
    //   1470: invokeinterface 615 3 0
    //   1475: goto -991 -> 484
    //   1478: aload 17
    //   1480: invokevirtual 619	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   1483: aload_0
    //   1484: sipush 1000
    //   1487: invokevirtual 623	com/tencent/mobileqq/app/proxy/ProxyManager:notifyEvent	(I)V
    //   1490: aload 17
    //   1492: ifnull -1483 -> 9
    //   1495: aload 17
    //   1497: invokevirtual 626	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1500: invokestatic 472	java/lang/System:nanoTime	()J
    //   1503: lload 13
    //   1505: lsub
    //   1506: ldc2_w 478
    //   1509: ldiv
    //   1510: lstore 11
    //   1512: iload 7
    //   1514: ifeq -1505 -> 9
    //   1517: new 481	java/util/HashMap
    //   1520: dup
    //   1521: invokespecial 482	java/util/HashMap:<init>	()V
    //   1524: astore_2
    //   1525: iload 9
    //   1527: ifeq +129 -> 1656
    //   1530: ldc_w 484
    //   1533: astore_1
    //   1534: aload_2
    //   1535: ldc_w 486
    //   1538: aload_1
    //   1539: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1542: pop
    //   1543: aload_2
    //   1544: ldc_w 492
    //   1547: ldc_w 628
    //   1550: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1553: pop
    //   1554: aload_2
    //   1555: ldc_w 496
    //   1558: lload 11
    //   1560: invokestatic 501	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1563: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1566: pop
    //   1567: aload_2
    //   1568: ldc_w 630
    //   1571: iload 4
    //   1573: invokestatic 633	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1576: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1579: pop
    //   1580: aload_2
    //   1581: ldc_w 635
    //   1584: iload_3
    //   1585: invokestatic 633	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1588: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1591: pop
    //   1592: aload_2
    //   1593: ldc_w 637
    //   1596: lload 11
    //   1598: l2f
    //   1599: iload 4
    //   1601: i2f
    //   1602: fdiv
    //   1603: invokestatic 640	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1606: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1609: pop
    //   1610: aload_2
    //   1611: ldc_w 642
    //   1614: ldc_w 628
    //   1617: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1620: pop
    //   1621: aload_2
    //   1622: ldc_w 503
    //   1625: getstatic 508	com/tencent/mobileqq/app/SQLiteOpenHelper:WAL_ENABLE	Z
    //   1628: invokestatic 511	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1631: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1634: pop
    //   1635: invokestatic 517	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1638: invokestatic 520	anpc:a	(Landroid/content/Context;)Lanpc;
    //   1641: aconst_null
    //   1642: ldc_w 644
    //   1645: iconst_1
    //   1646: lload 11
    //   1648: lconst_0
    //   1649: aload_2
    //   1650: aconst_null
    //   1651: iconst_0
    //   1652: invokevirtual 528	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1655: return
    //   1656: ldc_w 542
    //   1659: astore_1
    //   1660: goto -126 -> 1534
    //   1663: astore_1
    //   1664: ldc2_w 523
    //   1667: lstore 11
    //   1669: iconst_0
    //   1670: istore 4
    //   1672: iconst_0
    //   1673: istore 9
    //   1675: iconst_0
    //   1676: istore_3
    //   1677: aload 17
    //   1679: astore_2
    //   1680: aload_1
    //   1681: invokevirtual 647	java/lang/Exception:printStackTrace	()V
    //   1684: aload_0
    //   1685: sipush 1001
    //   1688: invokevirtual 623	com/tencent/mobileqq/app/proxy/ProxyManager:notifyEvent	(I)V
    //   1691: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1694: ifeq +32 -> 1726
    //   1697: ldc 247
    //   1699: iconst_2
    //   1700: new 213	java/lang/StringBuilder
    //   1703: dup
    //   1704: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   1707: ldc_w 649
    //   1710: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1713: aload_1
    //   1714: invokevirtual 652	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1717: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1720: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1723: invokestatic 655	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1726: aload_2
    //   1727: ifnull -1718 -> 9
    //   1730: aload_2
    //   1731: invokevirtual 626	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1734: invokestatic 472	java/lang/System:nanoTime	()J
    //   1737: lload 11
    //   1739: lsub
    //   1740: ldc2_w 478
    //   1743: ldiv
    //   1744: lstore 11
    //   1746: iload 7
    //   1748: ifeq -1739 -> 9
    //   1751: new 481	java/util/HashMap
    //   1754: dup
    //   1755: invokespecial 482	java/util/HashMap:<init>	()V
    //   1758: astore_2
    //   1759: iload 9
    //   1761: ifeq +129 -> 1890
    //   1764: ldc_w 484
    //   1767: astore_1
    //   1768: aload_2
    //   1769: ldc_w 486
    //   1772: aload_1
    //   1773: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1776: pop
    //   1777: aload_2
    //   1778: ldc_w 492
    //   1781: ldc_w 628
    //   1784: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1787: pop
    //   1788: aload_2
    //   1789: ldc_w 496
    //   1792: lload 11
    //   1794: invokestatic 501	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1797: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1800: pop
    //   1801: aload_2
    //   1802: ldc_w 630
    //   1805: iload 4
    //   1807: invokestatic 633	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1810: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1813: pop
    //   1814: aload_2
    //   1815: ldc_w 635
    //   1818: iload_3
    //   1819: invokestatic 633	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1822: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1825: pop
    //   1826: aload_2
    //   1827: ldc_w 637
    //   1830: lload 11
    //   1832: l2f
    //   1833: iload 4
    //   1835: i2f
    //   1836: fdiv
    //   1837: invokestatic 640	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1840: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1843: pop
    //   1844: aload_2
    //   1845: ldc_w 642
    //   1848: ldc_w 628
    //   1851: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1854: pop
    //   1855: aload_2
    //   1856: ldc_w 503
    //   1859: getstatic 508	com/tencent/mobileqq/app/SQLiteOpenHelper:WAL_ENABLE	Z
    //   1862: invokestatic 511	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1865: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1868: pop
    //   1869: invokestatic 517	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1872: invokestatic 520	anpc:a	(Landroid/content/Context;)Lanpc;
    //   1875: aconst_null
    //   1876: ldc_w 644
    //   1879: iconst_1
    //   1880: lload 11
    //   1882: lconst_0
    //   1883: aload_2
    //   1884: aconst_null
    //   1885: iconst_0
    //   1886: invokevirtual 528	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1889: return
    //   1890: ldc_w 542
    //   1893: astore_1
    //   1894: goto -126 -> 1768
    //   1897: astore_1
    //   1898: iconst_0
    //   1899: istore_3
    //   1900: iconst_0
    //   1901: istore 4
    //   1903: ldc2_w 523
    //   1906: lstore 13
    //   1908: iconst_0
    //   1909: istore 9
    //   1911: aconst_null
    //   1912: astore 17
    //   1914: aload 17
    //   1916: ifnull +173 -> 2089
    //   1919: aload 17
    //   1921: invokevirtual 626	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1924: invokestatic 472	java/lang/System:nanoTime	()J
    //   1927: lload 13
    //   1929: lsub
    //   1930: ldc2_w 478
    //   1933: ldiv
    //   1934: lstore 11
    //   1936: iload 7
    //   1938: ifeq +151 -> 2089
    //   1941: new 481	java/util/HashMap
    //   1944: dup
    //   1945: invokespecial 482	java/util/HashMap:<init>	()V
    //   1948: astore 17
    //   1950: iload 9
    //   1952: ifeq +139 -> 2091
    //   1955: ldc_w 484
    //   1958: astore_2
    //   1959: aload 17
    //   1961: ldc_w 486
    //   1964: aload_2
    //   1965: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1968: pop
    //   1969: aload 17
    //   1971: ldc_w 492
    //   1974: ldc_w 628
    //   1977: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1980: pop
    //   1981: aload 17
    //   1983: ldc_w 496
    //   1986: lload 11
    //   1988: invokestatic 501	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1991: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1994: pop
    //   1995: aload 17
    //   1997: ldc_w 630
    //   2000: iload 4
    //   2002: invokestatic 633	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2005: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2008: pop
    //   2009: aload 17
    //   2011: ldc_w 635
    //   2014: iload_3
    //   2015: invokestatic 633	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2018: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2021: pop
    //   2022: aload 17
    //   2024: ldc_w 637
    //   2027: lload 11
    //   2029: l2f
    //   2030: iload 4
    //   2032: i2f
    //   2033: fdiv
    //   2034: invokestatic 640	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   2037: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2040: pop
    //   2041: aload 17
    //   2043: ldc_w 642
    //   2046: ldc_w 628
    //   2049: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2052: pop
    //   2053: aload 17
    //   2055: ldc_w 503
    //   2058: getstatic 508	com/tencent/mobileqq/app/SQLiteOpenHelper:WAL_ENABLE	Z
    //   2061: invokestatic 511	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2064: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2067: pop
    //   2068: invokestatic 517	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2071: invokestatic 520	anpc:a	(Landroid/content/Context;)Lanpc;
    //   2074: aconst_null
    //   2075: ldc_w 644
    //   2078: iconst_1
    //   2079: lload 11
    //   2081: lconst_0
    //   2082: aload 17
    //   2084: aconst_null
    //   2085: iconst_0
    //   2086: invokevirtual 528	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   2089: aload_1
    //   2090: athrow
    //   2091: ldc_w 542
    //   2094: astore_2
    //   2095: goto -136 -> 1959
    //   2098: astore_1
    //   2099: iconst_0
    //   2100: istore_3
    //   2101: iconst_0
    //   2102: istore 4
    //   2104: ldc2_w 523
    //   2107: lstore 13
    //   2109: aconst_null
    //   2110: astore 17
    //   2112: goto -198 -> 1914
    //   2115: astore_1
    //   2116: iconst_0
    //   2117: istore_3
    //   2118: iconst_0
    //   2119: istore 4
    //   2121: ldc2_w 523
    //   2124: lstore 13
    //   2126: goto -212 -> 1914
    //   2129: astore_1
    //   2130: iconst_0
    //   2131: istore_3
    //   2132: iconst_0
    //   2133: istore 4
    //   2135: goto -221 -> 1914
    //   2138: astore_1
    //   2139: goto -225 -> 1914
    //   2142: astore_1
    //   2143: iload 6
    //   2145: istore_3
    //   2146: goto -232 -> 1914
    //   2149: astore_1
    //   2150: goto -236 -> 1914
    //   2153: astore_1
    //   2154: lload 11
    //   2156: lstore 13
    //   2158: aload_2
    //   2159: astore 17
    //   2161: goto -247 -> 1914
    //   2164: astore_1
    //   2165: iconst_0
    //   2166: istore_3
    //   2167: ldc2_w 523
    //   2170: lstore 11
    //   2172: iconst_0
    //   2173: istore 4
    //   2175: aload 17
    //   2177: astore_2
    //   2178: goto -498 -> 1680
    //   2181: astore_1
    //   2182: iconst_0
    //   2183: istore_3
    //   2184: ldc2_w 523
    //   2187: lstore 11
    //   2189: aload 17
    //   2191: astore_2
    //   2192: iconst_0
    //   2193: istore 4
    //   2195: goto -515 -> 1680
    //   2198: astore_1
    //   2199: iconst_0
    //   2200: istore_3
    //   2201: iconst_0
    //   2202: istore 4
    //   2204: lload 13
    //   2206: lstore 11
    //   2208: aload 17
    //   2210: astore_2
    //   2211: goto -531 -> 1680
    //   2214: astore_1
    //   2215: lload 13
    //   2217: lstore 11
    //   2219: aload 17
    //   2221: astore_2
    //   2222: goto -542 -> 1680
    //   2225: astore_1
    //   2226: lload 13
    //   2228: lstore 11
    //   2230: aload 17
    //   2232: astore_2
    //   2233: iload 5
    //   2235: istore_3
    //   2236: goto -556 -> 1680
    //   2239: astore_1
    //   2240: lload 13
    //   2242: lstore 11
    //   2244: aload 17
    //   2246: astore_2
    //   2247: goto -567 -> 1680
    //   2250: goto -1766 -> 484
    //   2253: lload 11
    //   2255: lstore 15
    //   2257: goto -1208 -> 1049
    //   2260: ldc2_w 523
    //   2263: lstore 11
    //   2265: goto -1981 -> 284
    //   2268: goto -1837 -> 431
    //   2271: ldc_w 542
    //   2274: astore_2
    //   2275: goto -1447 -> 828
    //   2278: ldc_w 542
    //   2281: astore_2
    //   2282: goto -1195 -> 1087
    //   2285: ldc_w 542
    //   2288: astore_2
    //   2289: goto -959 -> 1330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2292	0	this	ProxyManager
    //   0	2292	1	paramEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   0	2292	2	paramList	List<MsgQueueItem>
    //   293	1943	3	i	int
    //   295	1908	4	j	int
    //   329	1905	5	k	int
    //   326	1818	6	m	int
    //   94	1843	7	n	int
    //   526	83	8	i1	int
    //   114	1837	9	bool1	boolean
    //   79	1217	10	bool2	boolean
    //   189	2075	11	l1	long
    //   167	2074	13	l2	long
    //   729	1527	15	l3	long
    //   56	2189	17	localObject1	Object
    //   99	412	18	localObject2	Object
    //   104	1346	19	localObject3	Object
    //   336	1131	20	str1	String
    //   349	1116	21	localProxyListener	ProxyListener
    //   539	84	22	str2	String
    //   552	82	23	str3	String
    // Exception table:
    //   from	to	target	type
    //   96	106	1663	java/lang/Exception
    //   96	106	1897	finally
    //   121	154	2098	finally
    //   154	160	2098	finally
    //   164	169	2115	finally
    //   169	174	2129	finally
    //   179	200	2129	finally
    //   210	284	2129	finally
    //   284	292	2129	finally
    //   297	319	2138	finally
    //   1478	1490	2138	finally
    //   331	338	2142	finally
    //   344	351	2142	finally
    //   357	363	2142	finally
    //   369	380	2142	finally
    //   390	431	2142	finally
    //   521	528	2142	finally
    //   534	541	2142	finally
    //   547	554	2142	finally
    //   560	568	2142	finally
    //   574	586	2142	finally
    //   592	651	2142	finally
    //   431	438	2149	finally
    //   661	710	2149	finally
    //   710	731	2149	finally
    //   736	745	2149	finally
    //   745	790	2149	finally
    //   803	819	2149	finally
    //   828	901	2149	finally
    //   908	917	2149	finally
    //   922	931	2149	finally
    //   934	976	2149	finally
    //   976	986	2149	finally
    //   990	1025	2149	finally
    //   1034	1045	2149	finally
    //   1062	1078	2149	finally
    //   1087	1160	2149	finally
    //   1167	1177	2149	finally
    //   1182	1192	2149	finally
    //   1195	1237	2149	finally
    //   1237	1275	2149	finally
    //   1280	1291	2149	finally
    //   1304	1321	2149	finally
    //   1330	1403	2149	finally
    //   1410	1420	2149	finally
    //   1425	1435	2149	finally
    //   1438	1459	2149	finally
    //   1464	1475	2149	finally
    //   1680	1726	2153	finally
    //   121	154	2164	java/lang/Exception
    //   154	160	2164	java/lang/Exception
    //   164	169	2181	java/lang/Exception
    //   169	174	2198	java/lang/Exception
    //   179	200	2198	java/lang/Exception
    //   210	284	2198	java/lang/Exception
    //   284	292	2198	java/lang/Exception
    //   297	319	2214	java/lang/Exception
    //   1478	1490	2214	java/lang/Exception
    //   331	338	2225	java/lang/Exception
    //   344	351	2225	java/lang/Exception
    //   357	363	2225	java/lang/Exception
    //   369	380	2225	java/lang/Exception
    //   390	431	2225	java/lang/Exception
    //   521	528	2225	java/lang/Exception
    //   534	541	2225	java/lang/Exception
    //   547	554	2225	java/lang/Exception
    //   560	568	2225	java/lang/Exception
    //   574	586	2225	java/lang/Exception
    //   592	651	2225	java/lang/Exception
    //   431	438	2239	java/lang/Exception
    //   661	710	2239	java/lang/Exception
    //   710	731	2239	java/lang/Exception
    //   736	745	2239	java/lang/Exception
    //   745	790	2239	java/lang/Exception
    //   803	819	2239	java/lang/Exception
    //   828	901	2239	java/lang/Exception
    //   908	917	2239	java/lang/Exception
    //   922	931	2239	java/lang/Exception
    //   934	976	2239	java/lang/Exception
    //   976	986	2239	java/lang/Exception
    //   990	1025	2239	java/lang/Exception
    //   1034	1045	2239	java/lang/Exception
    //   1062	1078	2239	java/lang/Exception
    //   1087	1160	2239	java/lang/Exception
    //   1167	1177	2239	java/lang/Exception
    //   1182	1192	2239	java/lang/Exception
    //   1195	1237	2239	java/lang/Exception
    //   1237	1275	2239	java/lang/Exception
    //   1280	1291	2239	java/lang/Exception
    //   1304	1321	2239	java/lang/Exception
    //   1330	1403	2239	java/lang/Exception
    //   1410	1420	2239	java/lang/Exception
    //   1425	1435	2239	java/lang/Exception
    //   1438	1459	2239	java/lang/Exception
    //   1464	1475	2239	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.ProxyManager
 * JD-Core Version:    0.7.0.1
 */