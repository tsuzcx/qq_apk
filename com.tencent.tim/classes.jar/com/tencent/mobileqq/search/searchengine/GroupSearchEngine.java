package com.tencent.mobileqq.search.searchengine;

import acfp;
import acxu;
import acxz;
import agnx;
import amnu;
import amnv;
import amol;
import ampf;
import ampi;
import ampk;
import ampl;
import ampm;
import ampq;
import ampt;
import ampv;
import ampw;
import ampx;
import amux;
import amvg;
import amvk;
import amvm;
import amvn;
import amvo;
import amvp;
import amvq;
import amvr;
import amvs;
import amvt;
import amvu;
import amvv;
import amvw;
import amvx;
import amvy;
import amvz;
import amwa;
import amwb;
import amwc;
import amwd;
import amwe;
import amwf;
import amwt;
import amxh;
import amxj;
import amxk;
import android.os.Bundle;
import anpc;
import aqoe;
import avju;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.globalsearch.FavoriteSearchEngine;
import cooperation.qqfav.globalsearch.FunctionSearchEngine;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GroupSearchEngine
  implements amwd<ampw>, Observer
{
  private static final Comparator<a> ab = new amvm();
  protected static final ThreadPoolExecutor m = new amvw(3, 5, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new amvv());
  private SearchRunnable jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable;
  private TroopMemberSearchRunnable jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$TroopMemberSearchRunnable;
  private long akl = -1L;
  private QQAppInterface app;
  private ScheduledFuture b;
  private boolean cDk;
  private ScheduledThreadPoolExecutor f;
  private int fromType;
  private String keyword;
  private Future l;
  private ArrayList<a> zE;
  
  public GroupSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.app = paramQQAppInterface;
    this.fromType = paramInt;
    this.zE = dC();
    paramQQAppInterface.a().a().b(this);
  }
  
  private ArrayList<a> dC()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.fromType == 12)
    {
      localArrayList.add(new amvx(this, new PublicAccountSearchEngine(this.app, this.fromType), "public_account", 50));
      localArrayList.add(new amvy(this, new NetSearchEngine(this.app, m, this.fromType), "net_search", 0));
      Collections.sort(localArrayList, ab);
      return localArrayList;
    }
    if (this.fromType == 14)
    {
      localArrayList.add(new amvz(this, new PublicAccountSearchEngine(this.app, this.fromType), "public_account", 50));
      localArrayList.add(new amwa(this, new NetSearchEngine(this.app, m, this.fromType), "net_search", 0));
      Collections.sort(localArrayList, ab);
      return localArrayList;
    }
    localArrayList.add(new amwb(this, new amvg(this.app, this.fromType, 197437, null), "people", 20));
    localArrayList.add(new amwc(this, new MiniProgramSearchEngine(this.app, this.fromType), "", 0));
    localArrayList.add(new amvn(this, new amux(this.app, this.fromType, 793, null), "people", 20));
    localArrayList.add(new amvo(this, new FunctionSearchEngine(this.app, this.fromType), "function", 130));
    boolean bool1 = amxh.awo();
    boolean bool2 = amxh.awn();
    if (bool1)
    {
      localArrayList.add(new amvp(this, new amvk(this.app, this.fromType), "create_discussion", 120));
      if ((bool2) && (acxu.ENABLE) && (aqoe.cg(this.app)) && (this.app.a().hasInit()) && (aqoe.cj(this.app)))
      {
        localArrayList.add(new amvq(this, new amnv(this.app), "fts_message", 40));
        if (QLog.isColorLevel()) {
          QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines add FTSMessageSearchEngine");
        }
        if ((bool2) && (acxu.ENABLE) && (aqoe.cg(this.app)) && (this.app.a().hasInit()) && (aqoe.an(this.app) != 1) && ((!aqoe.cg(this.app)) || (aqoe.cj(this.app)))) {
          break label673;
        }
        localArrayList.add(new amvr(this, new amwf(this.app), "message", 40));
        if (QLog.isColorLevel()) {
          QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines add MessageSearchEngine");
        }
      }
    }
    for (;;)
    {
      QLog.d("GroupSearchEngine", 2, "bShowMsgSearchResult : " + bool1 + "bEnableFtsSearch: " + bool2);
      localArrayList.add(new amvs(this, new FavoriteSearchEngine(this.app), "favorite", 60));
      localArrayList.add(new amvt(this, new FileManagerSearchEngine(this.app, this.fromType), "file", 100));
      Collections.sort(localArrayList, ab);
      return localArrayList;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines not add FTSMessageSearchEngine");
      break;
      label673:
      if (QLog.isColorLevel())
      {
        QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines not add MessageSearchEngine");
        continue;
        QLog.e("GroupSearchEngine", 2, "not show message search! ");
      }
    }
  }
  
  private void stopTask()
  {
    if (this.l != null)
    {
      this.l.cancel(true);
      if ((this.l instanceof Runnable)) {
        m.remove((Runnable)this.l);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable.cancel();
    }
    if (this.b != null)
    {
      this.b.cancel(true);
      if ((this.f != null) && ((this.b instanceof Runnable))) {
        this.f.remove((Runnable)this.b);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$TroopMemberSearchRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$TroopMemberSearchRunnable.cancel();
    }
  }
  
  public void Ps(boolean paramBoolean)
  {
    this.cDk = paramBoolean;
  }
  
  public List<ampw> a(amwt paramamwt)
  {
    return null;
  }
  
  public void a(amwt paramamwt, amwe<ampw> paramamwe)
  {
    this.keyword = paramamwt.keyword;
    if (paramamwt.extra == null) {
      paramamwt.extra = new Bundle();
    }
    paramamwt.extra.putBoolean("bSearchNet", true);
    paramamwt.extra.putInt("iNumber", 11);
    paramamwt.extra.putBoolean("SEARCH_REQUEST_EXTRA_TIME_LIMIT", true);
    paramamwt.extra.putBoolean("searchTroopMember", false);
    stopTask();
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable = new SearchRunnable(paramamwt, paramamwe);
    this.l = m.submit(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable);
    amxk.b("all_result", "active_local", new String[] { this.keyword });
  }
  
  public void bHZ()
  {
    ArrayList localArrayList = this.zE;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.zE.size())
        {
          a locala = (a)this.zE.get(i);
          if ((locala.a instanceof amnv)) {
            ((amnv)locala.a).bHZ();
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void bIa()
  {
    ArrayList localArrayList = this.zE;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.zE.size())
        {
          a locala = (a)this.zE.get(i);
          if ((locala.a instanceof amnv)) {
            ((amnv)locala.a).bIa();
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void cancel()
  {
    if (this.zE == null) {
      return;
    }
    amxj.dOC();
    ArrayList localArrayList = this.zE;
    int i = 0;
    try
    {
      while (i < this.zE.size())
      {
        ((a)this.zE.get(i)).a.cancel();
        i += 1;
      }
      stopTask();
      return;
    }
    finally {}
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 85	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 98	com/tencent/mobileqq/app/QQAppInterface:a	()Lacxu;
    //   7: invokevirtual 103	acxu:a	()Lacxz;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +8 -> 20
    //   15: aload_2
    //   16: aload_0
    //   17: invokevirtual 424	acxz:c	(Ljava/util/Observer;)V
    //   20: aload_0
    //   21: getfield 93	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:zE	Ljava/util/ArrayList;
    //   24: astore_2
    //   25: aload_2
    //   26: monitorenter
    //   27: iconst_0
    //   28: istore_1
    //   29: iload_1
    //   30: aload_0
    //   31: getfield 93	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:zE	Ljava/util/ArrayList;
    //   34: invokevirtual 402	java/util/ArrayList:size	()I
    //   37: if_icmpge +29 -> 66
    //   40: aload_0
    //   41: getfield 93	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:zE	Ljava/util/ArrayList;
    //   44: iload_1
    //   45: invokevirtual 406	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   48: checkcast 17	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$a
    //   51: getfield 409	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$a:a	Lamwd;
    //   54: invokeinterface 426 1 0
    //   59: iload_1
    //   60: iconst_1
    //   61: iadd
    //   62: istore_1
    //   63: goto -34 -> 29
    //   66: aload_2
    //   67: monitorexit
    //   68: aload_0
    //   69: getfield 83	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:akl	J
    //   72: ldc2_w 80
    //   75: lcmp
    //   76: ifeq +207 -> 283
    //   79: new 428	java/util/HashMap
    //   82: dup
    //   83: invokespecial 429	java/util/HashMap:<init>	()V
    //   86: astore_3
    //   87: aload_0
    //   88: getfield 93	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:zE	Ljava/util/ArrayList;
    //   91: astore_2
    //   92: aload_2
    //   93: monitorenter
    //   94: iconst_0
    //   95: istore_1
    //   96: iload_1
    //   97: aload_0
    //   98: getfield 93	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:zE	Ljava/util/ArrayList;
    //   101: invokevirtual 402	java/util/ArrayList:size	()I
    //   104: if_icmpge +106 -> 210
    //   107: aload_3
    //   108: aload_0
    //   109: getfield 93	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:zE	Ljava/util/ArrayList;
    //   112: iload_1
    //   113: invokevirtual 406	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   116: checkcast 17	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$a
    //   119: getfield 432	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$a:type	Ljava/lang/String;
    //   122: aload_0
    //   123: getfield 93	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:zE	Ljava/util/ArrayList;
    //   126: iload_1
    //   127: invokevirtual 406	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   130: checkcast 17	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$a
    //   133: getfield 433	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$a:akl	J
    //   136: invokestatic 437	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   139: invokevirtual 441	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   142: pop
    //   143: aload_3
    //   144: new 274	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   151: aload_0
    //   152: getfield 93	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:zE	Ljava/util/ArrayList;
    //   155: iload_1
    //   156: invokevirtual 406	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   159: checkcast 17	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$a
    //   162: getfield 432	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$a:type	Ljava/lang/String;
    //   165: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc_w 443
    //   171: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: aload_0
    //   178: getfield 93	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:zE	Ljava/util/ArrayList;
    //   181: iload_1
    //   182: invokevirtual 406	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   185: checkcast 17	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$a
    //   188: getfield 446	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$a:czb	I
    //   191: invokestatic 449	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   194: invokevirtual 441	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   197: pop
    //   198: iload_1
    //   199: iconst_1
    //   200: iadd
    //   201: istore_1
    //   202: goto -106 -> 96
    //   205: astore_3
    //   206: aload_2
    //   207: monitorexit
    //   208: aload_3
    //   209: athrow
    //   210: aload_2
    //   211: monitorexit
    //   212: aload_0
    //   213: getfield 119	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:keyword	Ljava/lang/String;
    //   216: ifnonnull +73 -> 289
    //   219: ldc 188
    //   221: astore_2
    //   222: aload_3
    //   223: ldc_w 450
    //   226: aload_2
    //   227: invokevirtual 441	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   230: pop
    //   231: aload_0
    //   232: getfield 119	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:keyword	Ljava/lang/String;
    //   235: ifnonnull +62 -> 297
    //   238: ldc_w 452
    //   241: astore_2
    //   242: aload_3
    //   243: ldc_w 454
    //   246: aload_2
    //   247: invokevirtual 441	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   250: pop
    //   251: invokestatic 460	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   254: invokestatic 465	anpc:a	(Landroid/content/Context;)Lanpc;
    //   257: aload_0
    //   258: getfield 85	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   261: invokevirtual 468	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   264: ldc_w 470
    //   267: iconst_1
    //   268: aload_0
    //   269: getfield 83	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:akl	J
    //   272: lconst_0
    //   273: aload_3
    //   274: invokestatic 473	amxk:f	(Ljava/util/HashMap;)Ljava/util/HashMap;
    //   277: ldc 188
    //   279: iconst_0
    //   280: invokevirtual 477	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   283: return
    //   284: astore_3
    //   285: aload_2
    //   286: monitorexit
    //   287: aload_3
    //   288: athrow
    //   289: aload_0
    //   290: getfield 119	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:keyword	Ljava/lang/String;
    //   293: astore_2
    //   294: goto -72 -> 222
    //   297: aload_0
    //   298: getfield 119	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:keyword	Ljava/lang/String;
    //   301: invokevirtual 480	java/lang/String:trim	()Ljava/lang/String;
    //   304: ldc_w 482
    //   307: invokevirtual 486	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   310: arraylength
    //   311: invokestatic 490	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   314: astore_2
    //   315: goto -73 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	GroupSearchEngine
    //   28	174	1	i	int
    //   10	305	2	localObject1	Object
    //   86	58	3	localHashMap1	java.util.HashMap
    //   205	69	3	localHashMap2	java.util.HashMap
    //   284	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   29	59	205	finally
    //   66	68	205	finally
    //   206	208	205	finally
    //   96	198	284	finally
    //   210	212	284	finally
    //   285	287	284	finally
  }
  
  public void init()
  {
    long l1 = System.currentTimeMillis();
    SearchConfigManager.dO(this.app);
    synchronized (this.zE)
    {
      Collections.sort(this.zE, ab);
      int i = 0;
      if (i < this.zE.size())
      {
        ((a)this.zE.get(i)).a.init();
        i += 1;
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchEngine", 2, "GroupSearchEngine.init() cost time : " + (l2 - l1));
    }
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(this.app.getCurrentAccountUin(), "GroupSearchEngineInit", true, l2 - l1, 0L, amxk.f(null), "", false);
  }
  
  public void pause()
  {
    ArrayList localArrayList = this.zE;
    int i = 0;
    try
    {
      while (i < this.zE.size())
      {
        ((a)this.zE.get(i)).a.pause();
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void resume()
  {
    ArrayList localArrayList = this.zE;
    int i = 0;
    try
    {
      while (i < this.zE.size())
      {
        ((a)this.zE.get(i)).a.resume();
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((acxu.ENABLE) && ((paramObservable instanceof acxu)))
    {
      paramObservable = this.zE;
      int i = 0;
      for (;;)
      {
        try
        {
          if (i >= this.zE.size()) {
            break;
          }
          paramObject = (a)this.zE.get(i);
          if ((paramObject.a instanceof amnv))
          {
            if (QLog.isColorLevel()) {
              QLog.d("GroupSearchEngine", 2, "update() searchEngines has add FTSMessageSearchEngine");
            }
            return;
          }
          if ((paramObject.a instanceof amwf))
          {
            paramObject = new amnv(this.app);
            paramObject.init();
            this.zE.add(i, new amvu(this, paramObject, "fts message", 40));
            if (aqoe.an(this.app) == 0) {
              this.zE.remove(i + 1);
            }
            if (QLog.isColorLevel()) {
              QLog.d("GroupSearchEngine", 2, "update() searchEngines add FTSMessageSearchEngine");
            }
            return;
          }
        }
        finally {}
        i += 1;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchEngine", 2, "update() illegal");
    }
  }
  
  class SearchRunnable
    implements Runnable
  {
    private boolean canceled;
    private amwe jdField_f_of_type_Amwe;
    private amwt jdField_f_of_type_Amwt;
    
    public SearchRunnable(amwt paramamwt, amwe paramamwe)
    {
      this.jdField_f_of_type_Amwt = paramamwt;
      this.jdField_f_of_type_Amwe = paramamwe;
    }
    
    public void cancel()
    {
      this.canceled = true;
      this.jdField_f_of_type_Amwe = null;
    }
    
    public void run()
    {
      ArrayList localArrayList1 = new ArrayList();
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "begin local search at :" + l1);
      }
      int j = 0;
      int k = 0;
      for (;;)
      {
        if (k >= GroupSearchEngine.a(GroupSearchEngine.this).size()) {
          break label821;
        }
        Object localObject3 = (GroupSearchEngine.a)GroupSearchEngine.a(GroupSearchEngine.this).get(k);
        if ((((GroupSearchEngine.a)localObject3).a instanceof NetSearchEngine)) {}
        try
        {
          if (this.canceled) {
            return;
          }
          Thread.sleep(300L);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            Object localObject1;
            Object localObject4;
            ArrayList localArrayList2;
            localInterruptedException.printStackTrace();
            continue;
            int i = 1;
            continue;
            localObject2 = (ampi)localInterruptedException.get(1);
          }
        }
        if (this.canceled) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("GroupSearchEngine", 2, "start search : " + ((GroupSearchEngine.a)localObject3).a.getClass().getSimpleName());
        }
        localObject1 = ((GroupSearchEngine.a)localObject3).a(this.jdField_f_of_type_Amwt);
        if (QLog.isColorLevel()) {
          QLog.d("GroupSearchEngine", 2, "end search : " + ((GroupSearchEngine.a)localObject3).a.getClass().getSimpleName());
        }
        i = j;
        if ((((GroupSearchEngine.a)localObject3).a instanceof amwf)) {
          if (localObject1 != null)
          {
            i = j;
            if (!((List)localObject1).isEmpty()) {}
          }
          else
          {
            if (localArrayList1.isEmpty()) {
              break;
            }
            localObject4 = new ampl(null, this.jdField_f_of_type_Amwt.keyword);
            localArrayList1.add(new ampf((ampw)localObject4));
            localArrayList1.add(localObject4);
            amxj.UD(40);
            i = j;
          }
        }
        j = i;
        if (localObject1 != null)
        {
          j = i;
          if (!((List)localObject1).isEmpty())
          {
            j = i;
            if ((((GroupSearchEngine.a)localObject3).a instanceof NetSearchEngine))
            {
              j = i;
              if (localArrayList1.isEmpty()) {
                j = 0;
              }
            }
            i = j;
            if (j != 0)
            {
              localObject4 = new ampl(null, this.jdField_f_of_type_Amwt.keyword);
              localArrayList1.add(new ampf((ampw)localObject4));
              localArrayList1.add(localObject4);
              amxj.UD(40);
              i = 0;
            }
            localArrayList1.addAll((Collection)localObject1);
            j = i;
            if (!(((GroupSearchEngine.a)localObject3).a instanceof NetSearchEngine))
            {
              amxj.UD(((GroupSearchEngine.a)localObject3).dDL);
              j = i;
            }
          }
        }
        if (((((GroupSearchEngine.a)localObject3).a instanceof amvg)) && (((amvg)((GroupSearchEngine.a)GroupSearchEngine.a(GroupSearchEngine.this).get(k)).a).Jc() != 64))
        {
          if (this.canceled) {
            return;
          }
          if ((this.jdField_f_of_type_Amwe != null) && (!localArrayList1.isEmpty())) {
            this.jdField_f_of_type_Amwe.cR(localArrayList1);
          }
          if (this.jdField_f_of_type_Amwt.extra == null) {
            this.jdField_f_of_type_Amwt.extra = new Bundle();
          }
          this.jdField_f_of_type_Amwt.extra.putBoolean("searchCreateDiscussion", true);
          localObject3 = ((GroupSearchEngine.a)localObject3).a.a(this.jdField_f_of_type_Amwt);
          if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
          {
            localObject4 = (ampx)((List)localObject3).get(0);
            if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
              break label805;
            }
            localArrayList2 = new ArrayList();
            localObject3 = new ampi(null, GroupSearchEngine.a(GroupSearchEngine.this), GroupSearchEngine.a(GroupSearchEngine.this));
            localArrayList2.add(new ampf((ampw)localObject3));
            localArrayList2.add(localObject3);
            localArrayList1.addAll(localArrayList2);
            localObject1 = localObject3;
            if (localArrayList2.size() > 0)
            {
              this.jdField_f_of_type_Amwt.extra.putBoolean("hasLocalPeopleOrTroop", true);
              localObject1 = localObject3;
            }
            ((ampi)localObject1).b((ampx)localObject4);
            if (this.canceled) {
              return;
            }
            if ((this.jdField_f_of_type_Amwe != null) && (!localArrayList1.isEmpty())) {
              this.jdField_f_of_type_Amwe.cR(localArrayList1);
            }
          }
        }
        if (this.canceled) {
          return;
        }
        if ((this.jdField_f_of_type_Amwe != null) && (!localArrayList1.isEmpty())) {
          this.jdField_f_of_type_Amwe.cR(localArrayList1);
        }
        k += 1;
      }
      label805:
      Object localObject2;
      label821:
      if (!this.canceled)
      {
        if (this.jdField_f_of_type_Amwt.extra == null) {
          this.jdField_f_of_type_Amwt.extra = new Bundle();
        }
        boolean bool = this.jdField_f_of_type_Amwt.extra.getBoolean("searchTroopMember");
        localObject2 = new CountDownLatch(1);
        if (bool)
        {
          this.jdField_f_of_type_Amwt.extra.putBoolean("searchCreateDiscussion", false);
          if (GroupSearchEngine.a(GroupSearchEngine.this) == null) {
            GroupSearchEngine.a(GroupSearchEngine.this, (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1));
          }
          GroupSearchEngine.a(GroupSearchEngine.this, new GroupSearchEngine.TroopMemberSearchRunnable(this.jdField_f_of_type_Amwt, (ArrayList)((ArrayList)localArrayList1).clone(), this.jdField_f_of_type_Amwe, GroupSearchEngine.a(GroupSearchEngine.this), (CountDownLatch)localObject2, GroupSearchEngine.this));
          GroupSearchEngine.a(GroupSearchEngine.this, GroupSearchEngine.a(GroupSearchEngine.this).schedule(GroupSearchEngine.a(GroupSearchEngine.this), 0L, TimeUnit.MILLISECONDS));
        }
        if (this.jdField_f_of_type_Amwe != null)
        {
          if (!bool) {
            break label1088;
          }
          this.jdField_f_of_type_Amwe.s(localArrayList1, 1);
          ((CountDownLatch)localObject2).countDown();
        }
        while (!this.canceled)
        {
          long l2 = System.currentTimeMillis();
          GroupSearchEngine.a(GroupSearchEngine.this, l2 - l1);
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("GroupSearchEngine", 4, "search process cost:" + GroupSearchEngine.a(GroupSearchEngine.this));
          return;
          label1088:
          if (this.jdField_f_of_type_Amwt.extra.getBoolean("hasLocalPeopleOrTroop", false)) {
            this.jdField_f_of_type_Amwe.s(localArrayList1, 5);
          } else {
            this.jdField_f_of_type_Amwe.s(localArrayList1, 4);
          }
        }
      }
    }
  }
  
  static class TroopMemberSearchRunnable
    implements Runnable
  {
    private boolean canceled;
    private String ccl;
    private amwe jdField_f_of_type_Amwe;
    private amwt jdField_f_of_type_Amwt;
    private WeakReference<GroupSearchEngine> hR;
    private CountDownLatch latch;
    private ArrayList<ampv> zF;
    
    public TroopMemberSearchRunnable(amwt paramamwt, ArrayList<ampv> paramArrayList, amwe paramamwe, String paramString, CountDownLatch paramCountDownLatch, GroupSearchEngine paramGroupSearchEngine)
    {
      this.jdField_f_of_type_Amwt = paramamwt;
      this.zF = paramArrayList;
      this.jdField_f_of_type_Amwe = paramamwe;
      this.ccl = paramString;
      this.latch = paramCountDownLatch;
      this.hR = new WeakReference(paramGroupSearchEngine);
    }
    
    public void cancel()
    {
      this.canceled = true;
      this.jdField_f_of_type_Amwe = null;
      while (this.latch.getCount() > 0L) {
        this.latch.countDown();
      }
    }
    
    public void dOz()
    {
      eP(this.zF);
    }
    
    public void eP(ArrayList<ampv> paramArrayList)
    {
      try
      {
        this.latch.await();
        if (this.canceled) {
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        do
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        } while (this.jdField_f_of_type_Amwe == null);
        if (this.jdField_f_of_type_Amwt.extra.getBoolean("hasLocalPeopleOrTroop", false))
        {
          this.jdField_f_of_type_Amwe.s(paramArrayList, 5);
          return;
        }
        this.jdField_f_of_type_Amwe.s(paramArrayList, 4);
      }
    }
    
    public void run()
    {
      int n = -1;
      int m = 0;
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable, begin local search at :" + l);
      }
      Object localObject1 = (GroupSearchEngine)this.hR.get();
      String str;
      if (localObject1 != null)
      {
        str = GroupSearchEngine.a((GroupSearchEngine)localObject1);
        if (localObject1 == null) {
          break label107;
        }
      }
      label107:
      for (int j = GroupSearchEngine.a((GroupSearchEngine)localObject1);; j = 0)
      {
        if ((localObject1 != null) && (this.ccl.equals(str))) {
          break label112;
        }
        dOz();
        return;
        str = "";
        break;
      }
      label112:
      Object localObject3 = GroupSearchEngine.a((GroupSearchEngine)localObject1);
      int i = 0;
      localObject1 = null;
      Object localObject2;
      for (;;)
      {
        localObject2 = localObject1;
        if (i < ((ArrayList)localObject3).size())
        {
          if ((((GroupSearchEngine.a)((ArrayList)localObject3).get(i)).a instanceof amvg))
          {
            localObject2 = (amvg)((GroupSearchEngine.a)((ArrayList)localObject3).get(i)).a;
            localObject1 = localObject2;
            if (((amvg)localObject2).Jc() == 64) {}
          }
        }
        else
        {
          if ((!this.canceled) && (localObject2 != null) && (this.zF != null)) {
            break;
          }
          dOz();
          return;
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable, start search");
      }
      localObject3 = ((amvg)localObject2).a(this.jdField_f_of_type_Amwt);
      if ((this.canceled) || (localObject3 == null) || (((List)localObject3).isEmpty()))
      {
        dOz();
        return;
      }
      localObject1 = new ArrayList();
      ((List)localObject1).addAll((Collection)localObject3);
      Object localObject4;
      int i1;
      if (!this.zF.isEmpty())
      {
        localObject3 = this.zF.iterator();
        i = -1;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ampv)((Iterator)localObject3).next();
          k = i + 1;
          i = k;
          if ((localObject4 instanceof ampi))
          {
            localObject3 = ((ampi)localObject4).Bu.iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((List)localObject1).add((ampt)((Iterator)localObject3).next());
            }
            i1 = 1;
            i = k;
          }
        }
      }
      for (int k = i1;; k = 0)
      {
        if (k != 0)
        {
          this.zF.remove(i - 1);
          this.zF.remove(i - 1);
        }
        if (SearchConfigManager.needSeparate)
        {
          localObject3 = this.zF.iterator();
          i = n;
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (ampv)((Iterator)localObject3).next();
            k = i + 1;
            i = k;
            if ((localObject4 instanceof ampk))
            {
              localObject3 = ((ampk)localObject4).Bu.iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((List)localObject1).add((ampt)((Iterator)localObject3).next());
              }
              n = 1;
              i = k;
            }
          }
        }
        for (k = n;; k = 0)
        {
          if (k != 0)
          {
            this.zF.remove(i - 1);
            this.zF.remove(i - 1);
          }
          localObject3 = new ArrayList();
          ((amvg)localObject2).a((List)localObject1, (List)localObject3, null, str);
          if ((this.canceled) || (((List)localObject3).isEmpty()))
          {
            dOz();
            return;
          }
          localObject2 = new ArrayList();
          localObject1 = ((List)localObject3).iterator();
          i = m;
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (ampt)((Iterator)localObject1).next();
            if ((localObject3 instanceof amol))
            {
              k = i + 1;
              i = k;
              if (k <= 200)
              {
                ((List)localObject2).add(localObject3);
                i = k;
              }
            }
            else
            {
              ((List)localObject2).add(localObject3);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable troopCount:" + i);
          }
          localObject3 = new ArrayList(((List)localObject2).size());
          localObject1 = new ArrayList(((List)localObject2).size());
          if (SearchConfigManager.needSeparate)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (ampt)((Iterator)localObject2).next();
              if (amxk.a((ampx)localObject4)) {
                ((List)localObject1).add(localObject4);
              } else {
                ((List)localObject3).add(localObject4);
              }
            }
          }
          ((List)localObject3).addAll((Collection)localObject2);
          localObject2 = new ArrayList();
          if (localObject3 != null)
          {
            localObject3 = new ampi((List)localObject3, str, j);
            ((ArrayList)localObject2).add(new ampf((ampw)localObject3));
            ((ArrayList)localObject2).add(localObject3);
          }
          if ((SearchConfigManager.needSeparate) && (localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localObject1 = new ampk((List)localObject1, str, j);
            ((ArrayList)localObject2).add(new ampf((ampw)localObject1));
            ((ArrayList)localObject2).add(localObject1);
          }
          if (!this.zF.isEmpty()) {
            ((ArrayList)localObject2).addAll(this.zF);
          }
          if ((this.canceled) || (!this.ccl.equals(str)))
          {
            dOz();
            return;
          }
          if ((this.jdField_f_of_type_Amwe != null) && (!((ArrayList)localObject2).isEmpty())) {
            eP((ArrayList)localObject2);
          }
          localObject1 = (GroupSearchEngine)this.hR.get();
          if (localObject1 == null) {
            break;
          }
          GroupSearchEngine.a((GroupSearchEngine)localObject1, System.currentTimeMillis() - l);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable, end search, cost: " + GroupSearchEngine.a((GroupSearchEngine)localObject1));
          return;
        }
      }
    }
  }
  
  public abstract class a
  {
    public final amwd a;
    public long akl;
    public int czb;
    public int dDL;
    public String type;
    
    public a(amwd paramamwd, String paramString, int paramInt)
    {
      this.a = paramamwd;
      this.type = paramString;
      this.dDL = paramInt;
    }
    
    protected abstract ampw a(List<ampx> paramList, String paramString);
    
    public List<ampw> a(amwt paramamwt)
    {
      boolean bool2 = false;
      long l = System.currentTimeMillis();
      if (paramamwt.extra == null) {
        paramamwt.extra = new Bundle();
      }
      paramamwt.extra.putBoolean("searchRequestFromHome", true);
      ArrayList localArrayList = new ArrayList();
      List localList = this.a.a(paramamwt);
      this.akl = (System.currentTimeMillis() - l);
      if ((localList != null) && (!localList.isEmpty()))
      {
        ampw localampw = a(localList, paramamwt.keyword);
        if (((localampw instanceof ampi)) && (localampw.eX() != null) && (localampw.eX().size() > 0)) {
          paramamwt.extra.putBoolean("hasLocalPeopleOrTroop", true);
        }
        boolean bool1;
        if (localampw != null)
        {
          bool1 = bool2;
          if (localampw.eX() != null)
          {
            bool1 = bool2;
            if (localampw.eX().size() > localampw.Ex()) {
              bool1 = true;
            }
          }
          if (!(localampw instanceof avju)) {
            break label385;
          }
        }
        for (;;)
        {
          localArrayList.add(localampw);
          localampw = b(localList, paramamwt.keyword);
          if (((localampw instanceof ampi)) && (localampw.eX() != null) && (localampw.eX().size() > 0)) {
            paramamwt.extra.putBoolean("hasLocalPeopleOrTroop", true);
          }
          if (localampw != null)
          {
            localArrayList.add(new ampf(localampw));
            localArrayList.add(localampw);
          }
          localampw = c(localList, paramamwt.keyword);
          if (((localampw instanceof ampk)) && (localampw.eX() != null) && (localampw.eX().size() > 0)) {
            paramamwt.extra.putBoolean("hasLocalPeopleOrTroop", true);
          }
          if (localampw != null)
          {
            localArrayList.add(new ampf(localampw));
            localArrayList.add(localampw);
          }
          this.czb = localList.size();
          return localArrayList;
          label385:
          if ((localampw instanceof agnx)) {
            localArrayList.add(new ampf(localampw, acfp.m(2131707071), bool1));
          } else if (aqoe.an(GroupSearchEngine.a(GroupSearchEngine.this)) == 1) {
            localArrayList.add(new ampf(localampw, localampw.getGroupName().toString() + " " + this.akl + "ms", bool1));
          } else if ((localampw instanceof ampq)) {
            localArrayList.add(new ampf(localampw, acfp.m(2131707051), true));
          } else if ((localampw instanceof ampm)) {
            localArrayList.add(new ampf(localampw, localampw.getGroupName(), bool1));
          } else if ((localampw instanceof amnu)) {
            localArrayList.add(new ampf(localampw, acfp.m(2131707059), bool1));
          } else {
            localArrayList.add(new ampf(localampw));
          }
        }
      }
      this.czb = 0;
      return localArrayList;
    }
    
    protected ampw b(List<ampx> paramList, String paramString)
    {
      return null;
    }
    
    protected ampw c(List<ampx> paramList, String paramString)
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine
 * JD-Core Version:    0.7.0.1
 */