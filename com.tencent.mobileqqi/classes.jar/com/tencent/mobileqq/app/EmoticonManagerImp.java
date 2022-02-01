package com.tencent.mobileqq.app;

import android.os.Process;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonKeyword;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import fbv;
import fbw;
import fbx;
import fby;
import fbz;
import fca;
import fcb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EmoticonManagerImp
  implements EmoticonManager
{
  private static final int jdField_a_of_type_Int = 2;
  public static final String a = "EmoticonManagerImp";
  private static final int jdField_b_of_type_Int = 300;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public EmoticonPackageDownloadListener a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private LRULinkedHashMap jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(100);
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private LRULinkedHashMap jdField_b_of_type_ComTencentUtilLRULinkedHashMap;
  private LRULinkedHashMap c = new LRULinkedHashMap(1000);
  
  public EmoticonManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.b = new LRULinkedHashMap(250);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new fby(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    g();
  }
  
  private EmoticonTab a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (EmoticonTab)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonTab.class, paramString);
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    ThreadManager.a(new fca(this, paramLong, paramBoolean));
  }
  
  private void d(String paramString)
  {
    Process.setThreadPriority(10);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonKeyword.class, EmoticonKeyword.class.getSimpleName(), false, "epId=?", new String[] { paramString }, null, null, null, null);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          EmoticonKeyword localEmoticonKeyword = (EmoticonKeyword)((Iterator)localObject).next();
          try
          {
            Thread.sleep(300L);
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localEmoticonKeyword);
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManagerImp", 2, "asyncRemoveEmotionKeyword,epId=" + paramString);
    }
  }
  
  private void e(String paramString)
  {
    ThreadManager.a(new fcb(this, paramString));
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManagerImp", 2, "initTabs...start");
    }
    long l = System.currentTimeMillis();
    ??? = EmoticonPackage.class.getSimpleName();
    Object localObject2 = EmoticonTab.class.getSimpleName();
    Object localObject4 = new StringBuffer();
    ((StringBuffer)localObject4).append("select ").append((String)???).append(".* from ").append((String)???).append(" inner join ").append((String)localObject2).append(" on ").append((String)localObject2).append(".epId=").append((String)???).append(".epId order by ").append((String)localObject2).append("._id;");
    ??? = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonPackage.class, ((StringBuffer)localObject4).toString(), null);
    if ((??? == null) || (((ArrayList)???).size() < 1)) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      localObject2 = ((ArrayList)???).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (EmoticonPackage)((Iterator)localObject2).next();
        synchronized (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
        {
          this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(((EmoticonPackage)localObject4).epId, localObject4);
          this.jdField_a_of_type_JavaUtilArrayList.add(0, ((EmoticonPackage)localObject4).epId);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonManagerImp", 2, "initTabs...end time=" + (System.currentTimeMillis() - l));
  }
  
  private void h()
  {
    for (;;)
    {
      EmoticonKeyword localEmoticonKeyword;
      synchronized (this.c)
      {
        this.c.clear();
        Object localObject1 = EmoticonKeyword.class.getSimpleName();
        localObject1 = "select * from " + (String)localObject1 + " where valid=1 order by " + (String)localObject1 + "._index;";
        localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonKeyword.class, (String)localObject1, null);
        if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
          break;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localEmoticonKeyword = (EmoticonKeyword)((Iterator)localObject1).next();
        if (this.c.containsKey(localEmoticonKeyword.keyword))
        {
          localObject3 = (List)this.c.get(localEmoticonKeyword.keyword);
          if (((List)localObject3).size() >= 2) {
            continue;
          }
          ((List)localObject3).add(localEmoticonKeyword);
        }
      }
      Object localObject3 = new ArrayList();
      ((List)localObject3).add(localEmoticonKeyword);
      this.c.put(localEmoticonKeyword.keyword, localObject3);
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManagerImp", 2, "refreshEmoticonKeywordsCache, emoticon Keywords Cache size=" + this.c.size());
    }
  }
  
  /* Error */
  private void i()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 281	com/tencent/mobileqq/app/EmoticonManagerImp:b	()Ljava/util/List;
    //   6: astore 6
    //   8: aload 6
    //   10: invokeinterface 266 1 0
    //   15: istore_3
    //   16: iconst_0
    //   17: istore_1
    //   18: iload_1
    //   19: iload_3
    //   20: if_icmpge +363 -> 383
    //   23: aload 6
    //   25: iload_1
    //   26: invokeinterface 284 2 0
    //   31: checkcast 196	com/tencent/mobileqq/data/EmoticonPackage
    //   34: astore 7
    //   36: aload 7
    //   38: ifnull +267 -> 305
    //   41: aload 7
    //   43: getfield 287	com/tencent/mobileqq/data/EmoticonPackage:status	I
    //   46: iconst_2
    //   47: if_icmpne +258 -> 305
    //   50: aload_0
    //   51: aload 7
    //   53: getfield 234	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   56: invokevirtual 290	com/tencent/mobileqq/app/EmoticonManagerImp:a	(Ljava/lang/String;)Ljava/util/List;
    //   59: astore 8
    //   61: aload 8
    //   63: ifnull +242 -> 305
    //   66: aload_0
    //   67: getfield 69	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   70: invokevirtual 293	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   73: astore 5
    //   75: aload 5
    //   77: invokevirtual 297	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   80: aload 8
    //   82: invokeinterface 137 1 0
    //   87: astore 8
    //   89: aload 8
    //   91: invokeinterface 143 1 0
    //   96: ifeq +199 -> 295
    //   99: aload 8
    //   101: invokeinterface 147 1 0
    //   106: checkcast 299	com/tencent/mobileqq/data/Emoticon
    //   109: astore 9
    //   111: aload 9
    //   113: getfield 302	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   116: ifnull -27 -> 89
    //   119: aload 9
    //   121: getfield 302	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   124: invokevirtual 305	java/lang/String:length	()I
    //   127: ifle -38 -> 89
    //   130: new 307	org/json/JSONArray
    //   133: dup
    //   134: aload 9
    //   136: getfield 302	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   139: invokespecial 309	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   142: astore 10
    //   144: aload 10
    //   146: invokevirtual 310	org/json/JSONArray:length	()I
    //   149: istore 4
    //   151: iconst_0
    //   152: istore_2
    //   153: iload_2
    //   154: iload 4
    //   156: if_icmpge -67 -> 89
    //   159: aload 10
    //   161: iload_2
    //   162: invokevirtual 314	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   165: astore 11
    //   167: new 118	com/tencent/mobileqq/data/EmoticonKeyword
    //   170: dup
    //   171: invokespecial 315	com/tencent/mobileqq/data/EmoticonKeyword:<init>	()V
    //   174: astore 12
    //   176: aload 12
    //   178: aload 9
    //   180: getfield 316	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   183: putfield 317	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   186: aload 12
    //   188: aload 9
    //   190: getfield 320	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   193: putfield 321	com/tencent/mobileqq/data/EmoticonKeyword:eId	Ljava/lang/String;
    //   196: aload 12
    //   198: aload 9
    //   200: getfield 324	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   203: putfield 325	com/tencent/mobileqq/data/EmoticonKeyword:name	Ljava/lang/String;
    //   206: aload 12
    //   208: aload 9
    //   210: getfield 328	com/tencent/mobileqq/data/Emoticon:encryptKey	Ljava/lang/String;
    //   213: putfield 329	com/tencent/mobileqq/data/EmoticonKeyword:encryptKey	Ljava/lang/String;
    //   216: aload 12
    //   218: aload 11
    //   220: putfield 257	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   223: aload 12
    //   225: aload 9
    //   227: getfield 333	com/tencent/mobileqq/data/Emoticon:isSound	Z
    //   230: putfield 334	com/tencent/mobileqq/data/EmoticonKeyword:isSound	Z
    //   233: aload 12
    //   235: aload 9
    //   237: getfield 337	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   240: putfield 338	com/tencent/mobileqq/data/EmoticonKeyword:jobType	I
    //   243: aload 12
    //   245: aload 9
    //   247: getfield 341	com/tencent/mobileqq/data/Emoticon:width	I
    //   250: putfield 342	com/tencent/mobileqq/data/EmoticonKeyword:width	I
    //   253: aload 12
    //   255: aload 9
    //   257: getfield 345	com/tencent/mobileqq/data/Emoticon:height	I
    //   260: putfield 346	com/tencent/mobileqq/data/EmoticonKeyword:height	I
    //   263: aload 12
    //   265: iload_1
    //   266: putfield 349	com/tencent/mobileqq/data/EmoticonKeyword:_index	I
    //   269: aload 12
    //   271: aload 7
    //   273: getfield 352	com/tencent/mobileqq/data/EmoticonPackage:valid	Z
    //   276: putfield 353	com/tencent/mobileqq/data/EmoticonKeyword:valid	Z
    //   279: aload_0
    //   280: getfield 69	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   283: aload 12
    //   285: invokevirtual 356	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   288: iload_2
    //   289: iconst_1
    //   290: iadd
    //   291: istore_2
    //   292: goto -139 -> 153
    //   295: aload 5
    //   297: invokevirtual 358	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   300: aload 5
    //   302: invokevirtual 360	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   305: iload_1
    //   306: iconst_1
    //   307: iadd
    //   308: istore_1
    //   309: goto -291 -> 18
    //   312: astore 7
    //   314: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +14 -> 331
    //   320: ldc 12
    //   322: iconst_2
    //   323: ldc_w 362
    //   326: aload 7
    //   328: invokestatic 365	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   331: aload 5
    //   333: invokevirtual 360	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   336: goto -31 -> 305
    //   339: astore 5
    //   341: aload_0
    //   342: monitorexit
    //   343: aload 5
    //   345: athrow
    //   346: astore 7
    //   348: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   351: ifeq +14 -> 365
    //   354: ldc 12
    //   356: iconst_2
    //   357: ldc_w 367
    //   360: aload 7
    //   362: invokestatic 365	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   365: aload 5
    //   367: invokevirtual 360	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   370: goto -65 -> 305
    //   373: astore 6
    //   375: aload 5
    //   377: invokevirtual 360	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   380: aload 6
    //   382: athrow
    //   383: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq +35 -> 421
    //   389: ldc 12
    //   391: iconst_2
    //   392: new 168	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 369
    //   402: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload 6
    //   407: invokeinterface 266 1 0
    //   412: invokevirtual 274	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   415: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: aload_0
    //   422: monitorexit
    //   423: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	this	EmoticonManagerImp
    //   17	292	1	i	int
    //   152	140	2	j	int
    //   15	6	3	k	int
    //   149	8	4	m	int
    //   73	259	5	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   339	37	5	localObject1	Object
    //   6	18	6	localList	List
    //   373	33	6	localObject2	Object
    //   34	238	7	localEmoticonPackage	EmoticonPackage
    //   312	15	7	localJSONException	org.json.JSONException
    //   346	15	7	localException	Exception
    //   59	41	8	localObject3	Object
    //   109	147	9	localEmoticon	Emoticon
    //   142	18	10	localJSONArray	org.json.JSONArray
    //   165	54	11	str	String
    //   174	110	12	localEmoticonKeyword	EmoticonKeyword
    // Exception table:
    //   from	to	target	type
    //   75	89	312	org/json/JSONException
    //   89	151	312	org/json/JSONException
    //   159	288	312	org/json/JSONException
    //   295	300	312	org/json/JSONException
    //   2	16	339	finally
    //   23	36	339	finally
    //   41	61	339	finally
    //   66	75	339	finally
    //   300	305	339	finally
    //   331	336	339	finally
    //   365	370	339	finally
    //   375	383	339	finally
    //   383	421	339	finally
    //   75	89	346	java/lang/Exception
    //   89	151	346	java/lang/Exception
    //   159	288	346	java/lang/Exception
    //   295	300	346	java/lang/Exception
    //   75	89	373	finally
    //   89	151	373	finally
    //   159	288	373	finally
    //   295	300	373	finally
    //   314	331	373	finally
    //   348	365	373	finally
  }
  
  public Emoticon a(String paramString1, String arg2)
  {
    Emoticon localEmoticon = (Emoticon)this.b.get(paramString1 + "_" + ???);
    Object localObject = localEmoticon;
    if (localEmoticon == null)
    {
      paramString1 = (Emoticon)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Emoticon.class, "epId=? and eId=?", new String[] { paramString1, ??? });
      localObject = paramString1;
      if (paramString1 != null) {
        synchronized (this.b)
        {
          this.b.put(paramString1.getMapKey(), paramString1);
          return paramString1;
        }
      }
    }
    return localObject;
  }
  
  public EmoticonPackage a(String paramString)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
    ??? = localEmoticonPackage;
    if (localEmoticonPackage == null)
    {
      localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonPackage.class, paramString);
      ??? = localEmoticonPackage;
      if (localEmoticonPackage != null) {
        synchronized (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
        {
          this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(paramString, localEmoticonPackage);
          return localEmoticonPackage;
        }
      }
    }
    return ???;
  }
  
  public List a()
  {
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonPackage.class, false, null, null, null, null, "order_", null);
    if (localArrayList != null)
    {
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)localIterator.next();
        synchronized (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
        {
          this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(localEmoticonPackage.epId, localEmoticonPackage);
        }
      }
    }
    return localList;
  }
  
  public List a(String paramString)
  {
    paramString = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Emoticon.class, false, "epId=? ", new String[] { paramString }, null, null, null, null);
    if (paramString != null)
    {
      Iterator localIterator = paramString.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Emoticon localEmoticon = (Emoticon)localIterator.next();
          try
          {
            synchronized (this.b)
            {
              this.b.put(localEmoticon.getMapKey(), localEmoticon);
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    return paramString;
  }
  
  public void a()
  {
    EmosmHandler localEmosmHandler = (EmosmHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
    localEmosmHandler.a(new fbw(this, localEmosmHandler));
    localEmosmHandler.a(0, 0);
  }
  
  public void a(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return;
    }
    synchronized (this.b)
    {
      this.b.put(paramEmoticon.getMapKey(), paramEmoticon);
      a(paramEmoticon);
      return;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage != null) {}
    synchronized (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
    {
      this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(paramEmoticonPackage.epId, paramEmoticonPackage);
      a(paramEmoticonPackage);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    while (this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {
      return;
    }
    EmoticonTab localEmoticonTab = new EmoticonTab();
    localEmoticonTab.epId = paramString;
    this.jdField_a_of_type_JavaUtilArrayList.add(0, paramString);
    a(localEmoticonTab);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    paramString1 = b(paramString1);
    if (paramString1 != null)
    {
      int i = paramString1.latestVersion;
      paramString1.updateFlag = paramInt2;
      paramString1.updateTip = paramString2;
      paramString1.latestVersion = paramInt1;
      if ((EmoticonUtils.a(paramInt2)) && (i < paramInt1)) {
        paramString1.hasReadUpdatePage = false;
      }
      a(paramString1);
    }
  }
  
  public void a(String paramString, Boolean paramBoolean)
  {
    paramString = b(paramString);
    if ((paramString != null) && (paramString.hasReadUpdatePage != paramBoolean.booleanValue()))
    {
      paramString.hasReadUpdatePage = paramBoolean.booleanValue();
      a(paramString);
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((EmoticonPackage)paramList.next());
      }
    }
  }
  
  boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  public EmoticonPackage b(String paramString)
  {
    if (paramString == null) {}
    while (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {
      return null;
    }
    return a(paramString);
  }
  
  public List b()
  {
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    ArrayList localArrayList2 = new ArrayList();
    int j = localArrayList1.size();
    int i = 0;
    while (i < j)
    {
      String str = (String)localArrayList1.get(i);
      if (str != null)
      {
        EmoticonPackage localEmoticonPackage2 = (EmoticonPackage)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(str);
        EmoticonPackage localEmoticonPackage1 = localEmoticonPackage2;
        if (localEmoticonPackage2 == null) {
          localEmoticonPackage1 = a(str);
        }
        if (localEmoticonPackage1 != null) {
          localArrayList2.add(localEmoticonPackage1);
        }
      }
      i += 1;
    }
    return localArrayList2;
  }
  
  public List b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (List)this.c.get(paramString);
  }
  
  public void b()
  {
    EmosmHandler localEmosmHandler = (EmosmHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
    localEmosmHandler.a(new fbx(this, localEmosmHandler));
    localEmosmHandler.a(0, 0);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramString);
    EmoticonTab localEmoticonTab = (EmoticonTab)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonTab.class, paramString);
    if (localEmoticonTab != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localEmoticonTab);
    }
    EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    e(paramString);
  }
  
  public void b(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    ThreadManager.a(new fbv(this, paramString1, paramInt1));
  }
  
  public void b(List paramList)
  {
    if (paramList == null) {
      return;
    }
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a((String)paramList.get(i));
      i -= 1;
    }
    a(true, 300L);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonTab.class.getSimpleName());
  }
  
  public void c(String arg1)
  {
    ??? = (ArrayList)a(???);
    if (??? == null) {
      return;
    }
    Iterator localIterator = ???.iterator();
    while (localIterator.hasNext())
    {
      Emoticon localEmoticon = (Emoticon)localIterator.next();
      synchronized (this.b)
      {
        this.b.remove(localEmoticon.getMapKey());
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localEmoticon);
      }
    }
  }
  
  public void c(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((Emoticon)paramList.next());
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    synchronized (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
    {
      this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.clear();
      synchronized (this.b)
      {
        this.b.clear();
      }
    }
    synchronized (this.c)
    {
      this.c.clear();
      return;
      localObject1 = finally;
      throw localObject1;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonKeyword.class.getSimpleName());
  }
  
  public void f()
  {
    ThreadManager.a(new fbz(this));
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.EmoticonManagerImp
 * JD-Core Version:    0.7.0.1
 */