package com.tencent.mobileqq.app;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonKeyword;
import com.tencent.mobileqq.data.EmoticonKeywordForCloud;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import csl;
import csm;
import csn;
import cso;
import csp;
import csq;
import csr;
import css;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EmoticonManagerImp
  implements EmoticonManager
{
  public static final int a = 4;
  public static final String a = "EmoticonManagerImp";
  private static final int jdField_d_of_type_Int = 300;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public EmoticonPackageDownloadListener a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new csl(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  private LRULinkedHashMap jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(100);
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public Map a;
  private int jdField_b_of_type_Int = -1;
  private DownloadListener jdField_b_of_type_ComTencentMobileqqVipDownloadListener = new csp(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  private LRULinkedHashMap jdField_b_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(250);
  private int jdField_c_of_type_Int = -1;
  private LRULinkedHashMap jdField_c_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(1000);
  private LRULinkedHashMap jdField_d_of_type_ComTencentUtilLRULinkedHashMap;
  
  public EmoticonManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.d = new LRULinkedHashMap(9000);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new cso(this);
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
    ThreadManager.a(new csr(this, paramLong, paramBoolean));
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
    ThreadManager.a(new css(this, paramString));
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
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_c_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   4: astore 8
    //   6: aload 8
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 49	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_c_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   13: invokevirtual 275	com/tencent/util/LRULinkedHashMap:clear	()V
    //   16: new 30	java/util/ArrayList
    //   19: dup
    //   20: invokespecial 31	java/util/ArrayList:<init>	()V
    //   23: astore 9
    //   25: aload_0
    //   26: getfield 93	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   29: ldc_w 277
    //   32: iconst_0
    //   33: aconst_null
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: invokevirtual 280	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   42: astore 7
    //   44: aload 7
    //   46: ifnull +79 -> 125
    //   49: aload 7
    //   51: invokeinterface 281 1 0
    //   56: iconst_1
    //   57: isub
    //   58: istore_1
    //   59: iload_1
    //   60: iflt +65 -> 125
    //   63: aload 7
    //   65: iload_1
    //   66: invokeinterface 285 2 0
    //   71: checkcast 277	com/tencent/mobileqq/data/RecentEmotionData
    //   74: astore 10
    //   76: aload 10
    //   78: ifnull +924 -> 1002
    //   81: aload 10
    //   83: getfield 288	com/tencent/mobileqq/data/RecentEmotionData:type	I
    //   86: iconst_5
    //   87: if_icmpne +915 -> 1002
    //   90: aload_0
    //   91: aload 10
    //   93: getfield 291	com/tencent/mobileqq/data/RecentEmotionData:emoIndex	I
    //   96: invokestatic 295	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   99: aload 10
    //   101: getfield 298	com/tencent/mobileqq/data/RecentEmotionData:emoPath	Ljava/lang/String;
    //   104: invokevirtual 301	com/tencent/mobileqq/app/EmoticonManagerImp:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/Emoticon;
    //   107: astore 10
    //   109: aload 10
    //   111: ifnull +891 -> 1002
    //   114: aload 9
    //   116: aload 10
    //   118: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   121: pop
    //   122: goto +880 -> 1002
    //   125: aload 9
    //   127: invokevirtual 247	java/util/ArrayList:size	()I
    //   130: istore 4
    //   132: iconst_0
    //   133: istore_1
    //   134: iload_1
    //   135: iload 4
    //   137: if_icmpge +534 -> 671
    //   140: aload 9
    //   142: iload_1
    //   143: invokevirtual 305	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   146: checkcast 307	com/tencent/mobileqq/data/Emoticon
    //   149: astore 10
    //   151: aload 10
    //   153: ifnull +18 -> 171
    //   156: aload 10
    //   158: getfield 310	com/tencent/mobileqq/data/Emoticon:encryptKey	Ljava/lang/String;
    //   161: invokestatic 316	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: istore 6
    //   166: iload 6
    //   168: ifeq +10 -> 178
    //   171: iload_1
    //   172: iconst_1
    //   173: iadd
    //   174: istore_1
    //   175: goto -41 -> 134
    //   178: aload 10
    //   180: getfield 319	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   183: ifnull +136 -> 319
    //   186: new 321	org/json/JSONArray
    //   189: dup
    //   190: aload 10
    //   192: getfield 319	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   195: invokespecial 323	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   198: astore 7
    //   200: aload 7
    //   202: invokevirtual 326	org/json/JSONArray:length	()I
    //   205: iconst_1
    //   206: if_icmpge +79 -> 285
    //   209: aload 10
    //   211: getfield 329	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   214: ifnull +25 -> 239
    //   217: aload 10
    //   219: getfield 329	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   222: invokevirtual 330	java/lang/String:length	()I
    //   225: ifle +14 -> 239
    //   228: aload 7
    //   230: aload 10
    //   232: getfield 329	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   235: invokevirtual 333	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   238: pop
    //   239: aload 10
    //   241: getfield 336	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   244: ifnull +41 -> 285
    //   247: aload 10
    //   249: getfield 336	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   252: invokevirtual 330	java/lang/String:length	()I
    //   255: ifle +30 -> 285
    //   258: aload 10
    //   260: getfield 336	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   263: aload 10
    //   265: getfield 329	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   268: invokevirtual 339	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   271: ifne +14 -> 285
    //   274: aload 7
    //   276: aload 10
    //   278: getfield 336	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   281: invokevirtual 333	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   284: pop
    //   285: aload 7
    //   287: invokevirtual 326	org/json/JSONArray:length	()I
    //   290: istore 5
    //   292: iconst_0
    //   293: istore_2
    //   294: iload_2
    //   295: iload 5
    //   297: if_icmpge -126 -> 171
    //   300: aload 7
    //   302: iload_2
    //   303: invokevirtual 342	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   306: astore 11
    //   308: aload 11
    //   310: invokestatic 316	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   313: ifeq +18 -> 331
    //   316: goto +693 -> 1009
    //   319: new 321	org/json/JSONArray
    //   322: dup
    //   323: invokespecial 343	org/json/JSONArray:<init>	()V
    //   326: astore 7
    //   328: goto -128 -> 200
    //   331: aload 11
    //   333: invokevirtual 346	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   336: astore 12
    //   338: new 141	com/tencent/mobileqq/data/EmoticonKeyword
    //   341: dup
    //   342: invokespecial 347	com/tencent/mobileqq/data/EmoticonKeyword:<init>	()V
    //   345: astore 11
    //   347: aload 11
    //   349: aload 10
    //   351: getfield 348	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   354: putfield 349	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   357: aload 11
    //   359: aload 10
    //   361: getfield 352	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   364: putfield 353	com/tencent/mobileqq/data/EmoticonKeyword:eId	Ljava/lang/String;
    //   367: aload 11
    //   369: aload 10
    //   371: getfield 336	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   374: putfield 354	com/tencent/mobileqq/data/EmoticonKeyword:name	Ljava/lang/String;
    //   377: aload 11
    //   379: aload 10
    //   381: getfield 310	com/tencent/mobileqq/data/Emoticon:encryptKey	Ljava/lang/String;
    //   384: putfield 355	com/tencent/mobileqq/data/EmoticonKeyword:encryptKey	Ljava/lang/String;
    //   387: aload 11
    //   389: aload 12
    //   391: putfield 356	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   394: aload 11
    //   396: aload 10
    //   398: getfield 360	com/tencent/mobileqq/data/Emoticon:isSound	Z
    //   401: putfield 361	com/tencent/mobileqq/data/EmoticonKeyword:isSound	Z
    //   404: aload 11
    //   406: aload 10
    //   408: getfield 364	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   411: putfield 365	com/tencent/mobileqq/data/EmoticonKeyword:jobType	I
    //   414: aload 11
    //   416: aload 10
    //   418: getfield 368	com/tencent/mobileqq/data/Emoticon:width	I
    //   421: putfield 369	com/tencent/mobileqq/data/EmoticonKeyword:width	I
    //   424: aload 11
    //   426: aload 10
    //   428: getfield 372	com/tencent/mobileqq/data/Emoticon:height	I
    //   431: putfield 373	com/tencent/mobileqq/data/EmoticonKeyword:height	I
    //   434: aload 11
    //   436: iload_1
    //   437: putfield 376	com/tencent/mobileqq/data/EmoticonKeyword:_index	I
    //   440: aload 11
    //   442: iconst_1
    //   443: putfield 379	com/tencent/mobileqq/data/EmoticonKeyword:valid	Z
    //   446: aload_0
    //   447: getfield 93	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   450: aload 11
    //   452: invokevirtual 382	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   455: aload_0
    //   456: getfield 49	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_c_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   459: aload 12
    //   461: invokevirtual 385	com/tencent/util/LRULinkedHashMap:containsKey	(Ljava/lang/Object;)Z
    //   464: ifeq +148 -> 612
    //   467: aload_0
    //   468: getfield 49	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_c_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   471: aload 11
    //   473: getfield 356	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   476: invokevirtual 388	com/tencent/util/LRULinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   479: checkcast 156	java/util/List
    //   482: astore 12
    //   484: aload 12
    //   486: invokeinterface 281 1 0
    //   491: iconst_4
    //   492: if_icmpge +517 -> 1009
    //   495: aload 12
    //   497: invokeinterface 160 1 0
    //   502: astore 13
    //   504: aload 13
    //   506: invokeinterface 166 1 0
    //   511: ifeq +486 -> 997
    //   514: aload 13
    //   516: invokeinterface 170 1 0
    //   521: checkcast 141	com/tencent/mobileqq/data/EmoticonKeyword
    //   524: astore 14
    //   526: aload 14
    //   528: getfield 353	com/tencent/mobileqq/data/EmoticonKeyword:eId	Ljava/lang/String;
    //   531: aload 10
    //   533: getfield 352	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   536: invokevirtual 339	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   539: ifeq -35 -> 504
    //   542: aload 14
    //   544: getfield 349	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   547: aload 10
    //   549: getfield 348	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   552: invokevirtual 339	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   555: ifeq -51 -> 504
    //   558: iconst_1
    //   559: istore_3
    //   560: iload_3
    //   561: ifne +448 -> 1009
    //   564: aload 12
    //   566: aload 11
    //   568: invokeinterface 389 2 0
    //   573: pop
    //   574: goto +435 -> 1009
    //   577: astore 7
    //   579: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   582: ifeq -411 -> 171
    //   585: ldc 12
    //   587: iconst_2
    //   588: ldc_w 391
    //   591: aload 7
    //   593: invokestatic 394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   596: goto -425 -> 171
    //   599: astore 7
    //   601: aload 7
    //   603: athrow
    //   604: astore 7
    //   606: aload 8
    //   608: monitorexit
    //   609: aload 7
    //   611: athrow
    //   612: new 30	java/util/ArrayList
    //   615: dup
    //   616: invokespecial 31	java/util/ArrayList:<init>	()V
    //   619: astore 12
    //   621: aload 12
    //   623: aload 11
    //   625: invokeinterface 389 2 0
    //   630: pop
    //   631: aload_0
    //   632: getfield 49	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_c_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   635: aload 11
    //   637: getfield 356	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   640: aload 12
    //   642: invokevirtual 261	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   645: pop
    //   646: goto +363 -> 1009
    //   649: astore 7
    //   651: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   654: ifeq -483 -> 171
    //   657: ldc 12
    //   659: iconst_2
    //   660: ldc_w 396
    //   663: aload 7
    //   665: invokestatic 394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   668: goto -497 -> 171
    //   671: ldc 141
    //   673: invokevirtual 147	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   676: astore 7
    //   678: new 191	java/lang/StringBuilder
    //   681: dup
    //   682: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   685: ldc_w 398
    //   688: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: aload 7
    //   693: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: ldc_w 400
    //   699: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload 7
    //   704: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: ldc_w 402
    //   710: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: astore 7
    //   718: aload_0
    //   719: getfield 93	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   722: ldc 141
    //   724: aload 7
    //   726: aconst_null
    //   727: invokevirtual 243	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;
    //   730: checkcast 30	java/util/ArrayList
    //   733: astore 7
    //   735: aload 7
    //   737: ifnull +213 -> 950
    //   740: aload 7
    //   742: invokevirtual 247	java/util/ArrayList:size	()I
    //   745: ifle +205 -> 950
    //   748: aload 7
    //   750: invokevirtual 254	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   753: astore 7
    //   755: aload 7
    //   757: invokeinterface 166 1 0
    //   762: ifeq +188 -> 950
    //   765: aload 7
    //   767: invokeinterface 170 1 0
    //   772: checkcast 141	com/tencent/mobileqq/data/EmoticonKeyword
    //   775: astore 9
    //   777: aload 9
    //   779: getfield 355	com/tencent/mobileqq/data/EmoticonKeyword:encryptKey	Ljava/lang/String;
    //   782: invokestatic 316	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   785: ifne -30 -> 755
    //   788: aload_0
    //   789: getfield 49	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_c_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   792: aload 9
    //   794: getfield 356	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   797: invokevirtual 385	com/tencent/util/LRULinkedHashMap:containsKey	(Ljava/lang/Object;)Z
    //   800: ifeq +113 -> 913
    //   803: aload_0
    //   804: getfield 49	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_c_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   807: aload 9
    //   809: getfield 356	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   812: invokevirtual 388	com/tencent/util/LRULinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   815: checkcast 156	java/util/List
    //   818: astore 10
    //   820: aload 10
    //   822: invokeinterface 160 1 0
    //   827: astore 11
    //   829: aload 11
    //   831: invokeinterface 166 1 0
    //   836: ifeq +156 -> 992
    //   839: aload 11
    //   841: invokeinterface 170 1 0
    //   846: checkcast 141	com/tencent/mobileqq/data/EmoticonKeyword
    //   849: astore 12
    //   851: aload 12
    //   853: getfield 353	com/tencent/mobileqq/data/EmoticonKeyword:eId	Ljava/lang/String;
    //   856: aload 9
    //   858: getfield 353	com/tencent/mobileqq/data/EmoticonKeyword:eId	Ljava/lang/String;
    //   861: invokevirtual 339	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   864: ifeq -35 -> 829
    //   867: aload 12
    //   869: getfield 349	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   872: aload 9
    //   874: getfield 349	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   877: invokevirtual 339	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   880: ifeq -51 -> 829
    //   883: iconst_1
    //   884: istore_1
    //   885: aload 10
    //   887: invokeinterface 281 1 0
    //   892: iconst_4
    //   893: if_icmpge -138 -> 755
    //   896: iload_1
    //   897: ifne -142 -> 755
    //   900: aload 10
    //   902: aload 9
    //   904: invokeinterface 389 2 0
    //   909: pop
    //   910: goto -155 -> 755
    //   913: new 30	java/util/ArrayList
    //   916: dup
    //   917: invokespecial 31	java/util/ArrayList:<init>	()V
    //   920: astore 10
    //   922: aload 10
    //   924: aload 9
    //   926: invokeinterface 389 2 0
    //   931: pop
    //   932: aload_0
    //   933: getfield 49	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_c_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   936: aload 9
    //   938: getfield 356	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   941: aload 10
    //   943: invokevirtual 261	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   946: pop
    //   947: goto -192 -> 755
    //   950: aload 8
    //   952: monitorexit
    //   953: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   956: ifeq +35 -> 991
    //   959: ldc 12
    //   961: iconst_2
    //   962: new 191	java/lang/StringBuilder
    //   965: dup
    //   966: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   969: ldc_w 404
    //   972: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   975: aload_0
    //   976: getfield 49	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_c_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   979: invokevirtual 405	com/tencent/util/LRULinkedHashMap:size	()I
    //   982: invokevirtual 408	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   985: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: invokestatic 204	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   991: return
    //   992: iconst_0
    //   993: istore_1
    //   994: goto -109 -> 885
    //   997: iconst_0
    //   998: istore_3
    //   999: goto -439 -> 560
    //   1002: iload_1
    //   1003: iconst_1
    //   1004: isub
    //   1005: istore_1
    //   1006: goto -947 -> 59
    //   1009: iload_2
    //   1010: iconst_1
    //   1011: iadd
    //   1012: istore_2
    //   1013: goto -719 -> 294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1016	0	this	EmoticonManagerImp
    //   58	948	1	i	int
    //   293	720	2	j	int
    //   559	440	3	k	int
    //   130	8	4	m	int
    //   290	8	5	n	int
    //   164	3	6	bool	boolean
    //   42	285	7	localObject1	Object
    //   577	15	7	localJSONException	org.json.JSONException
    //   599	3	7	localObject2	Object
    //   604	6	7	localObject3	Object
    //   649	15	7	localException	Exception
    //   676	90	7	localObject4	Object
    //   4	947	8	localLRULinkedHashMap	LRULinkedHashMap
    //   23	914	9	localObject5	Object
    //   74	868	10	localObject6	Object
    //   306	534	11	localObject7	Object
    //   336	532	12	localObject8	Object
    //   502	13	13	localIterator	Iterator
    //   524	19	14	localEmoticonKeyword	EmoticonKeyword
    // Exception table:
    //   from	to	target	type
    //   178	200	577	org/json/JSONException
    //   200	239	577	org/json/JSONException
    //   239	285	577	org/json/JSONException
    //   285	292	577	org/json/JSONException
    //   300	316	577	org/json/JSONException
    //   319	328	577	org/json/JSONException
    //   331	504	577	org/json/JSONException
    //   504	558	577	org/json/JSONException
    //   564	574	577	org/json/JSONException
    //   612	646	577	org/json/JSONException
    //   178	200	599	finally
    //   200	239	599	finally
    //   239	285	599	finally
    //   285	292	599	finally
    //   300	316	599	finally
    //   319	328	599	finally
    //   331	504	599	finally
    //   504	558	599	finally
    //   564	574	599	finally
    //   579	596	599	finally
    //   612	646	599	finally
    //   651	668	599	finally
    //   9	44	604	finally
    //   49	59	604	finally
    //   63	76	604	finally
    //   81	109	604	finally
    //   114	122	604	finally
    //   125	132	604	finally
    //   140	151	604	finally
    //   156	166	604	finally
    //   601	604	604	finally
    //   606	609	604	finally
    //   671	735	604	finally
    //   740	755	604	finally
    //   755	829	604	finally
    //   829	883	604	finally
    //   885	896	604	finally
    //   900	910	604	finally
    //   913	947	604	finally
    //   950	953	604	finally
    //   178	200	649	java/lang/Exception
    //   200	239	649	java/lang/Exception
    //   239	285	649	java/lang/Exception
    //   285	292	649	java/lang/Exception
    //   300	316	649	java/lang/Exception
    //   319	328	649	java/lang/Exception
    //   331	504	649	java/lang/Exception
    //   504	558	649	java/lang/Exception
    //   564	574	649	java/lang/Exception
    //   612	646	649	java/lang/Exception
  }
  
  /* Error */
  private void i()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 411	com/tencent/mobileqq/app/EmoticonManagerImp:b	()Ljava/util/List;
    //   6: astore 6
    //   8: aload 6
    //   10: invokeinterface 281 1 0
    //   15: istore_3
    //   16: iconst_0
    //   17: istore_1
    //   18: iload_1
    //   19: iload_3
    //   20: if_icmpge +374 -> 394
    //   23: aload 6
    //   25: iload_1
    //   26: invokeinterface 285 2 0
    //   31: checkcast 219	com/tencent/mobileqq/data/EmoticonPackage
    //   34: astore 7
    //   36: aload 7
    //   38: ifnull +278 -> 316
    //   41: aload 7
    //   43: getfield 414	com/tencent/mobileqq/data/EmoticonPackage:status	I
    //   46: iconst_2
    //   47: if_icmpne +269 -> 316
    //   50: aload_0
    //   51: aload 7
    //   53: getfield 257	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   56: invokevirtual 417	com/tencent/mobileqq/app/EmoticonManagerImp:a	(Ljava/lang/String;)Ljava/util/List;
    //   59: astore 8
    //   61: aload 8
    //   63: ifnull +253 -> 316
    //   66: aload_0
    //   67: getfield 93	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   70: invokevirtual 420	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   73: astore 5
    //   75: aload 5
    //   77: invokevirtual 424	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   80: aload 8
    //   82: invokeinterface 160 1 0
    //   87: astore 8
    //   89: aload 8
    //   91: invokeinterface 166 1 0
    //   96: ifeq +210 -> 306
    //   99: aload 8
    //   101: invokeinterface 170 1 0
    //   106: checkcast 307	com/tencent/mobileqq/data/Emoticon
    //   109: astore 9
    //   111: aload 9
    //   113: getfield 319	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   116: ifnull -27 -> 89
    //   119: aload 9
    //   121: getfield 319	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   124: invokevirtual 330	java/lang/String:length	()I
    //   127: ifle -38 -> 89
    //   130: new 321	org/json/JSONArray
    //   133: dup
    //   134: aload 9
    //   136: getfield 319	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   139: invokespecial 323	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   142: astore 10
    //   144: aload 10
    //   146: invokevirtual 326	org/json/JSONArray:length	()I
    //   149: istore 4
    //   151: iconst_0
    //   152: istore_2
    //   153: iload_2
    //   154: iload 4
    //   156: if_icmpge -67 -> 89
    //   159: aload 10
    //   161: iload_2
    //   162: invokevirtual 342	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   165: astore 11
    //   167: new 141	com/tencent/mobileqq/data/EmoticonKeyword
    //   170: dup
    //   171: invokespecial 347	com/tencent/mobileqq/data/EmoticonKeyword:<init>	()V
    //   174: astore 12
    //   176: aload 12
    //   178: aload 9
    //   180: getfield 348	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   183: putfield 349	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   186: aload 12
    //   188: aload 9
    //   190: getfield 352	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   193: putfield 353	com/tencent/mobileqq/data/EmoticonKeyword:eId	Ljava/lang/String;
    //   196: aload 12
    //   198: aload 9
    //   200: getfield 336	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   203: putfield 354	com/tencent/mobileqq/data/EmoticonKeyword:name	Ljava/lang/String;
    //   206: aload 12
    //   208: aload 9
    //   210: getfield 310	com/tencent/mobileqq/data/Emoticon:encryptKey	Ljava/lang/String;
    //   213: putfield 355	com/tencent/mobileqq/data/EmoticonKeyword:encryptKey	Ljava/lang/String;
    //   216: aload 11
    //   218: invokestatic 316	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   221: ifne +13 -> 234
    //   224: aload 12
    //   226: aload 11
    //   228: invokevirtual 346	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   231: putfield 356	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   234: aload 12
    //   236: aload 9
    //   238: getfield 360	com/tencent/mobileqq/data/Emoticon:isSound	Z
    //   241: putfield 361	com/tencent/mobileqq/data/EmoticonKeyword:isSound	Z
    //   244: aload 12
    //   246: aload 9
    //   248: getfield 364	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   251: putfield 365	com/tencent/mobileqq/data/EmoticonKeyword:jobType	I
    //   254: aload 12
    //   256: aload 9
    //   258: getfield 368	com/tencent/mobileqq/data/Emoticon:width	I
    //   261: putfield 369	com/tencent/mobileqq/data/EmoticonKeyword:width	I
    //   264: aload 12
    //   266: aload 9
    //   268: getfield 372	com/tencent/mobileqq/data/Emoticon:height	I
    //   271: putfield 373	com/tencent/mobileqq/data/EmoticonKeyword:height	I
    //   274: aload 12
    //   276: iload_1
    //   277: putfield 376	com/tencent/mobileqq/data/EmoticonKeyword:_index	I
    //   280: aload 12
    //   282: aload 7
    //   284: getfield 425	com/tencent/mobileqq/data/EmoticonPackage:valid	Z
    //   287: putfield 379	com/tencent/mobileqq/data/EmoticonKeyword:valid	Z
    //   290: aload_0
    //   291: getfield 93	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   294: aload 12
    //   296: invokevirtual 382	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   299: iload_2
    //   300: iconst_1
    //   301: iadd
    //   302: istore_2
    //   303: goto -150 -> 153
    //   306: aload 5
    //   308: invokevirtual 427	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   311: aload 5
    //   313: invokevirtual 429	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   316: iload_1
    //   317: iconst_1
    //   318: iadd
    //   319: istore_1
    //   320: goto -302 -> 18
    //   323: astore 7
    //   325: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   328: ifeq +14 -> 342
    //   331: ldc 12
    //   333: iconst_2
    //   334: ldc_w 431
    //   337: aload 7
    //   339: invokestatic 394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   342: aload 5
    //   344: invokevirtual 429	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   347: goto -31 -> 316
    //   350: astore 5
    //   352: aload_0
    //   353: monitorexit
    //   354: aload 5
    //   356: athrow
    //   357: astore 7
    //   359: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +14 -> 376
    //   365: ldc 12
    //   367: iconst_2
    //   368: ldc_w 433
    //   371: aload 7
    //   373: invokestatic 394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   376: aload 5
    //   378: invokevirtual 429	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   381: goto -65 -> 316
    //   384: astore 6
    //   386: aload 5
    //   388: invokevirtual 429	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   391: aload 6
    //   393: athrow
    //   394: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +35 -> 432
    //   400: ldc 12
    //   402: iconst_2
    //   403: new 191	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   410: ldc_w 435
    //   413: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload 6
    //   418: invokeinterface 281 1 0
    //   423: invokevirtual 408	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   426: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 204	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload_0
    //   433: monitorexit
    //   434: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	this	EmoticonManagerImp
    //   17	303	1	i	int
    //   152	151	2	j	int
    //   15	6	3	k	int
    //   149	8	4	m	int
    //   73	270	5	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   350	37	5	localObject1	Object
    //   6	18	6	localList	List
    //   384	33	6	localObject2	Object
    //   34	249	7	localEmoticonPackage	EmoticonPackage
    //   323	15	7	localJSONException	org.json.JSONException
    //   357	15	7	localException	Exception
    //   59	41	8	localObject3	Object
    //   109	158	9	localEmoticon	Emoticon
    //   142	18	10	localJSONArray	org.json.JSONArray
    //   165	62	11	str	String
    //   174	121	12	localEmoticonKeyword	EmoticonKeyword
    // Exception table:
    //   from	to	target	type
    //   75	89	323	org/json/JSONException
    //   89	151	323	org/json/JSONException
    //   159	234	323	org/json/JSONException
    //   234	299	323	org/json/JSONException
    //   306	311	323	org/json/JSONException
    //   2	16	350	finally
    //   23	36	350	finally
    //   41	61	350	finally
    //   66	75	350	finally
    //   311	316	350	finally
    //   342	347	350	finally
    //   376	381	350	finally
    //   386	394	350	finally
    //   394	432	350	finally
    //   75	89	357	java/lang/Exception
    //   89	151	357	java/lang/Exception
    //   159	234	357	java/lang/Exception
    //   234	299	357	java/lang/Exception
    //   306	311	357	java/lang/Exception
    //   75	89	384	finally
    //   89	151	384	finally
    //   159	234	384	finally
    //   234	299	384	finally
    //   306	311	384	finally
    //   325	342	384	finally
    //   359	376	384	finally
  }
  
  public int a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.d.containsKey(paramString.toUpperCase()))) {
      return ((Integer)this.d.get(paramString.toUpperCase())).intValue();
    }
    return 0;
  }
  
  public Emoticon a(String paramString1, String arg2)
  {
    Emoticon localEmoticon = (Emoticon)this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.get(paramString1 + "_" + ???);
    Object localObject = localEmoticon;
    if (localEmoticon == null)
    {
      paramString1 = (Emoticon)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Emoticon.class, "epId=? and eId=?", new String[] { paramString1, ??? });
      localObject = paramString1;
      if (paramString1 != null) {
        synchronized (this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap)
        {
          this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.put(paramString1.getMapKey(), paramString1);
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
            synchronized (this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap)
            {
              this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.put(localEmoticon.getMapKey(), localEmoticon);
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
    localEmosmHandler.a(new csm(this, localEmosmHandler));
    localEmosmHandler.a(0, 0);
  }
  
  public void a(int paramInt) {}
  
  public void a(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return;
    }
    if (TextUtils.isEmpty(paramEmoticon.encryptKey))
    {
      Emoticon localEmoticon = (Emoticon)this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.get(paramEmoticon.epId + "_" + paramEmoticon.eId);
      if (localEmoticon != null)
      {
        ??? = localEmoticon;
        if (!TextUtils.isEmpty(localEmoticon.encryptKey)) {}
      }
      else
      {
        ??? = (Emoticon)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Emoticon.class, "epId=? and eId=?", new String[] { paramEmoticon.epId, paramEmoticon.eId });
      }
      if ((??? != null) && (TextUtils.isEmpty(((Emoticon)???).encryptKey))) {
        paramEmoticon.encryptKey = ((Emoticon)???).encryptKey;
      }
    }
    synchronized (this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap)
    {
      this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.put(paramEmoticon.getMapKey(), paramEmoticon);
      if ((paramEmoticon instanceof EmoticonKeywordForCloud))
      {
        ??? = new Emoticon();
        ((Emoticon)???).eId = paramEmoticon.eId;
        ((Emoticon)???).encryptKey = paramEmoticon.encryptKey;
        ((Emoticon)???).epId = paramEmoticon.epId;
        ((Emoticon)???).name = paramEmoticon.name;
        ((Emoticon)???).magicValue = paramEmoticon.magicValue;
        ((Emoticon)???).keywords = paramEmoticon.keywords;
        ((Emoticon)???).keyword = paramEmoticon.keyword;
        ((Emoticon)???).jobType = paramEmoticon.jobType;
        ((Emoticon)???).isSound = paramEmoticon.isSound;
        ((Emoticon)???).height = paramEmoticon.height;
        ((Emoticon)???).value = paramEmoticon.value;
        ((Emoticon)???).width = paramEmoticon.width;
        ((Emoticon)???).setStatus(paramEmoticon.getStatus());
        ((Emoticon)???).setId(paramEmoticon.getId());
        a((Entity)???);
        return;
      }
    }
    a(paramEmoticon);
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
    if (!TextUtils.isEmpty(paramString)) {
      return (List)this.jdField_c_of_type_ComTencentUtilLRULinkedHashMap.get(paramString.toUpperCase());
    }
    return null;
  }
  
  public void b()
  {
    EmosmHandler localEmosmHandler = (EmosmHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
    localEmosmHandler.a(new csn(this, localEmosmHandler));
    localEmosmHandler.a(0, 0);
  }
  
  /* Error */
  public void b(Emoticon arg1)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: getfield 310	com/tencent/mobileqq/data/Emoticon:encryptKey	Ljava/lang/String;
    //   8: invokestatic 316	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: aload_0
    //   16: getfield 49	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_c_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   19: astore 6
    //   21: aload 6
    //   23: monitorenter
    //   24: aload_1
    //   25: getfield 319	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   28: ifnull +127 -> 155
    //   31: new 321	org/json/JSONArray
    //   34: dup
    //   35: aload_1
    //   36: getfield 319	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   39: invokespecial 323	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   42: astore 5
    //   44: aload 5
    //   46: invokevirtual 326	org/json/JSONArray:length	()I
    //   49: iconst_1
    //   50: if_icmpge +71 -> 121
    //   53: aload_1
    //   54: getfield 329	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   57: ifnull +23 -> 80
    //   60: aload_1
    //   61: getfield 329	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   64: invokevirtual 330	java/lang/String:length	()I
    //   67: ifle +13 -> 80
    //   70: aload 5
    //   72: aload_1
    //   73: getfield 329	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   76: invokevirtual 333	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   79: pop
    //   80: aload_1
    //   81: getfield 336	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   84: ifnull +37 -> 121
    //   87: aload_1
    //   88: getfield 336	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   91: invokevirtual 330	java/lang/String:length	()I
    //   94: ifle +27 -> 121
    //   97: aload_1
    //   98: getfield 336	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   101: aload_1
    //   102: getfield 329	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   105: invokevirtual 339	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   108: ifne +13 -> 121
    //   111: aload 5
    //   113: aload_1
    //   114: getfield 336	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   117: invokevirtual 333	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   120: pop
    //   121: aload 5
    //   123: invokevirtual 326	org/json/JSONArray:length	()I
    //   126: istore 4
    //   128: iconst_0
    //   129: istore_2
    //   130: iload_2
    //   131: iload 4
    //   133: if_icmpge +283 -> 416
    //   136: aload 5
    //   138: iload_2
    //   139: invokevirtual 342	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   142: astore 7
    //   144: aload 7
    //   146: invokestatic 316	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifeq +18 -> 167
    //   152: goto +346 -> 498
    //   155: new 321	org/json/JSONArray
    //   158: dup
    //   159: invokespecial 343	org/json/JSONArray:<init>	()V
    //   162: astore 5
    //   164: goto -120 -> 44
    //   167: aload 7
    //   169: invokevirtual 346	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   172: astore 8
    //   174: new 141	com/tencent/mobileqq/data/EmoticonKeyword
    //   177: dup
    //   178: invokespecial 347	com/tencent/mobileqq/data/EmoticonKeyword:<init>	()V
    //   181: astore 7
    //   183: aload 7
    //   185: aload_1
    //   186: getfield 348	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   189: putfield 349	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   192: aload 7
    //   194: aload_1
    //   195: getfield 352	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   198: putfield 353	com/tencent/mobileqq/data/EmoticonKeyword:eId	Ljava/lang/String;
    //   201: aload 7
    //   203: aload_1
    //   204: getfield 336	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   207: putfield 354	com/tencent/mobileqq/data/EmoticonKeyword:name	Ljava/lang/String;
    //   210: aload 7
    //   212: aload_1
    //   213: getfield 310	com/tencent/mobileqq/data/Emoticon:encryptKey	Ljava/lang/String;
    //   216: putfield 355	com/tencent/mobileqq/data/EmoticonKeyword:encryptKey	Ljava/lang/String;
    //   219: aload 7
    //   221: aload 8
    //   223: putfield 356	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   226: aload 7
    //   228: aload_1
    //   229: getfield 360	com/tencent/mobileqq/data/Emoticon:isSound	Z
    //   232: putfield 361	com/tencent/mobileqq/data/EmoticonKeyword:isSound	Z
    //   235: aload 7
    //   237: aload_1
    //   238: getfield 364	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   241: putfield 365	com/tencent/mobileqq/data/EmoticonKeyword:jobType	I
    //   244: aload 7
    //   246: aload_1
    //   247: getfield 368	com/tencent/mobileqq/data/Emoticon:width	I
    //   250: putfield 369	com/tencent/mobileqq/data/EmoticonKeyword:width	I
    //   253: aload 7
    //   255: aload_1
    //   256: getfield 372	com/tencent/mobileqq/data/Emoticon:height	I
    //   259: putfield 373	com/tencent/mobileqq/data/EmoticonKeyword:height	I
    //   262: aload 7
    //   264: sipush 1000
    //   267: putfield 376	com/tencent/mobileqq/data/EmoticonKeyword:_index	I
    //   270: aload 7
    //   272: iconst_1
    //   273: putfield 379	com/tencent/mobileqq/data/EmoticonKeyword:valid	Z
    //   276: aload_0
    //   277: getfield 49	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_c_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   280: aload 8
    //   282: invokevirtual 385	com/tencent/util/LRULinkedHashMap:containsKey	(Ljava/lang/Object;)Z
    //   285: ifeq +148 -> 433
    //   288: aload_0
    //   289: getfield 49	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_c_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   292: aload 7
    //   294: getfield 356	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   297: invokevirtual 388	com/tencent/util/LRULinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   300: checkcast 156	java/util/List
    //   303: astore 8
    //   305: iconst_0
    //   306: istore_3
    //   307: iload_3
    //   308: aload 8
    //   310: invokeinterface 281 1 0
    //   315: if_icmpge +178 -> 493
    //   318: aload 8
    //   320: iload_3
    //   321: invokeinterface 285 2 0
    //   326: checkcast 141	com/tencent/mobileqq/data/EmoticonKeyword
    //   329: astore 9
    //   331: aload 9
    //   333: getfield 353	com/tencent/mobileqq/data/EmoticonKeyword:eId	Ljava/lang/String;
    //   336: aload_1
    //   337: getfield 352	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   340: invokevirtual 339	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   343: ifeq +83 -> 426
    //   346: aload 9
    //   348: getfield 349	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   351: aload_1
    //   352: getfield 348	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   355: invokevirtual 339	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   358: ifeq +68 -> 426
    //   361: aload 8
    //   363: iload_3
    //   364: invokeinterface 550 2 0
    //   369: pop
    //   370: aload 8
    //   372: iconst_0
    //   373: aload 9
    //   375: invokeinterface 551 3 0
    //   380: iconst_1
    //   381: istore_3
    //   382: iload_3
    //   383: ifne +115 -> 498
    //   386: aload 8
    //   388: iconst_0
    //   389: aload 7
    //   391: invokeinterface 551 3 0
    //   396: goto +102 -> 498
    //   399: astore_1
    //   400: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq +13 -> 416
    //   406: ldc 12
    //   408: iconst_2
    //   409: ldc_w 553
    //   412: aload_1
    //   413: invokestatic 394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   416: aload 6
    //   418: monitorexit
    //   419: return
    //   420: astore_1
    //   421: aload 6
    //   423: monitorexit
    //   424: aload_1
    //   425: athrow
    //   426: iload_3
    //   427: iconst_1
    //   428: iadd
    //   429: istore_3
    //   430: goto -123 -> 307
    //   433: new 30	java/util/ArrayList
    //   436: dup
    //   437: invokespecial 31	java/util/ArrayList:<init>	()V
    //   440: astore 8
    //   442: aload 8
    //   444: aload 7
    //   446: invokeinterface 389 2 0
    //   451: pop
    //   452: aload_0
    //   453: getfield 49	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_c_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   456: aload 7
    //   458: getfield 356	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   461: aload 8
    //   463: invokevirtual 261	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   466: pop
    //   467: goto +31 -> 498
    //   470: astore_1
    //   471: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   474: ifeq -58 -> 416
    //   477: ldc 12
    //   479: iconst_2
    //   480: ldc_w 555
    //   483: aload_1
    //   484: invokestatic 394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   487: goto -71 -> 416
    //   490: astore_1
    //   491: aload_1
    //   492: athrow
    //   493: iconst_0
    //   494: istore_3
    //   495: goto -113 -> 382
    //   498: iload_2
    //   499: iconst_1
    //   500: iadd
    //   501: istore_2
    //   502: goto -372 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	this	EmoticonManagerImp
    //   129	373	2	i	int
    //   306	189	3	j	int
    //   126	8	4	k	int
    //   42	121	5	localJSONArray	org.json.JSONArray
    //   19	403	6	localLRULinkedHashMap	LRULinkedHashMap
    //   142	315	7	localObject1	Object
    //   172	290	8	localObject2	Object
    //   329	45	9	localEmoticonKeyword	EmoticonKeyword
    // Exception table:
    //   from	to	target	type
    //   24	44	399	org/json/JSONException
    //   44	80	399	org/json/JSONException
    //   80	121	399	org/json/JSONException
    //   121	128	399	org/json/JSONException
    //   136	152	399	org/json/JSONException
    //   155	164	399	org/json/JSONException
    //   167	305	399	org/json/JSONException
    //   307	380	399	org/json/JSONException
    //   386	396	399	org/json/JSONException
    //   433	467	399	org/json/JSONException
    //   416	419	420	finally
    //   421	424	420	finally
    //   491	493	420	finally
    //   24	44	470	java/lang/Exception
    //   44	80	470	java/lang/Exception
    //   80	121	470	java/lang/Exception
    //   121	128	470	java/lang/Exception
    //   136	152	470	java/lang/Exception
    //   155	164	470	java/lang/Exception
    //   167	305	470	java/lang/Exception
    //   307	380	470	java/lang/Exception
    //   386	396	470	java/lang/Exception
    //   433	467	470	java/lang/Exception
    //   24	44	490	finally
    //   44	80	490	finally
    //   80	121	490	finally
    //   121	128	490	finally
    //   136	152	490	finally
    //   155	164	490	finally
    //   167	305	490	finally
    //   307	380	490	finally
    //   386	396	490	finally
    //   400	416	490	finally
    //   433	467	490	finally
    //   471	487	490	finally
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
    paramString2 = b(paramString1);
    if (paramString2 == null) {
      return;
    }
    paramString2.jsonVersion = paramInt1;
    a(paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManagerImp", 2, paramInt1 + "==========KeywordJsonupdate============" + paramString1);
    }
    ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(39)).a(paramString2.epId, EmojiManager.d, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
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
      synchronized (this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap)
      {
        this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.remove(localEmoticon.getMapKey());
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
      synchronized (this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap)
      {
        this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.clear();
      }
    }
    synchronized (this.jdField_c_of_type_ComTencentUtilLRULinkedHashMap)
    {
      this.jdField_c_of_type_ComTencentUtilLRULinkedHashMap.clear();
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
    ThreadManager.a(new csq(this));
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.EmoticonManagerImp
 * JD-Core Version:    0.7.0.1
 */