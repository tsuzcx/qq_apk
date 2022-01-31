package com.tencent.mobileqq.managers;

import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class DraftTextManager
{
  private static final int jdField_a_of_type_Int = 10;
  private static LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
  private static DraftTextManager jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  private static final String jdField_a_of_type_JavaLangString = "DraftTextManger";
  private static HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private static final int jdField_b_of_type_Int = 99;
  private static LruCache jdField_b_of_type_AndroidSupportV4UtilLruCache;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  static
  {
    b = new LruCache(99);
  }
  
  private static DraftSummaryInfo a(DraftTextInfo paramDraftTextInfo)
  {
    if (paramDraftTextInfo == null) {
      return null;
    }
    DraftSummaryInfo localDraftSummaryInfo = new DraftSummaryInfo();
    localDraftSummaryInfo.setUin(paramDraftTextInfo.uin);
    localDraftSummaryInfo.setType(paramDraftTextInfo.type);
    localDraftSummaryInfo.setTime(paramDraftTextInfo.time);
    localDraftSummaryInfo.setSummary(a(paramDraftTextInfo.text));
    return localDraftSummaryInfo;
  }
  
  public static DraftTextManager a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      throw new IllegalArgumentException("DraftTextManager this.app == null");
    }
    if (jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager == null)
    {
      jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = new DraftTextManager();
      a(paramQQAppInterface);
    }
    return jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  }
  
  private static String a(String paramString)
  {
    return Utils.a(paramString, 50);
  }
  
  private static String a(String paramString, int paramInt)
  {
    return MsgProxyUtils.a(paramString, paramInt);
  }
  
  private static List a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    try
    {
      List localList = paramQQAppInterface.a(DraftTextInfo.class, new DraftTextInfo().getTableName(), false, null, null, null, null, null, null);
      if (localList != null)
      {
        int i = localList.size();
        if (i > 0) {
          return localList;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        paramQQAppInterface.a();
      }
    }
    finally
    {
      paramQQAppInterface.a();
    }
    return new ArrayList();
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface).iterator();
    while (paramQQAppInterface.hasNext())
    {
      DraftTextInfo localDraftTextInfo = (DraftTextInfo)paramQQAppInterface.next();
      if (!TextUtils.isEmpty(localDraftTextInfo.text))
      {
        String str = a(localDraftTextInfo.uin, localDraftTextInfo.type);
        jdField_a_of_type_JavaUtilHashSet.add(str);
        jdField_a_of_type_AndroidSupportV4UtilLruCache.put(str, localDraftTextInfo);
        b.put(str, a(localDraftTextInfo));
      }
    }
  }
  
  public DraftSummaryInfo a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str = a(paramString, paramInt);
    Object localObject1;
    if (!jdField_a_of_type_JavaUtilHashSet.contains(str)) {
      localObject1 = null;
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject2 = (DraftSummaryInfo)b.get(str);
          localObject1 = localObject2;
        } while (localObject2 != null);
        Object localObject2 = (DraftTextInfo)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(str);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a(paramQQAppInterface, paramString, paramInt);
        }
        paramQQAppInterface = a((DraftTextInfo)localObject1);
        localObject1 = paramQQAppInterface;
      } while (paramQQAppInterface == null);
      localObject1 = paramQQAppInterface;
    } while (TextUtils.isEmpty(paramQQAppInterface.getSummary()));
    b.put(str, paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public DraftTextInfo a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      try
      {
        paramString = paramQQAppInterface.a(DraftTextInfo.class, new DraftTextInfo().getTableName(), false, "uin=? AND type=?", new String[] { paramString, String.valueOf(paramInt) }, null, null, null, null);
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = (DraftTextInfo)paramString.get(0);
          paramQQAppInterface.a();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramQQAppInterface.a();
        }
        paramQQAppInterface = finally;
        throw paramQQAppInterface;
      }
      finally
      {
        paramQQAppInterface.a();
      }
      return new DraftTextInfo();
    }
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DraftTextManger", 4, "Get draft text| uin=" + paramString + " draftList=" + jdField_a_of_type_JavaUtilHashSet + " cache=" + jdField_a_of_type_AndroidSupportV4UtilLruCache);
    }
    String str = a(paramString, paramInt);
    if (!jdField_a_of_type_JavaUtilHashSet.contains(str)) {
      return null;
    }
    DraftTextInfo localDraftTextInfo = (DraftTextInfo)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(str);
    if (localDraftTextInfo != null) {
      return localDraftTextInfo.text;
    }
    paramQQAppInterface = a(paramQQAppInterface, paramString, paramInt);
    if ((paramQQAppInterface != null) && (!StringUtil.b(paramQQAppInterface.text))) {
      jdField_a_of_type_AndroidSupportV4UtilLruCache.put(str, paramQQAppInterface);
    }
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.text;
    }
    return "";
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = null;
    jdField_a_of_type_JavaUtilHashSet.clear();
    jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
    b = new LruCache(99);
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, DraftTextInfo paramDraftTextInfo)
  {
    // Byte code:
    //   0: invokestatic 197	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 12
    //   8: iconst_2
    //   9: ldc 233
    //   11: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 38	com/tencent/mobileqq/managers/DraftTextManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   18: astore_3
    //   19: aload_3
    //   20: monitorenter
    //   21: aload_2
    //   22: ifnonnull +6 -> 28
    //   25: aload_3
    //   26: monitorexit
    //   27: return
    //   28: aload_2
    //   29: getfield 47	com/tencent/mobileqq/data/DraftTextInfo:uin	Ljava/lang/String;
    //   32: aload_2
    //   33: getfield 54	com/tencent/mobileqq/data/DraftTextInfo:type	I
    //   36: invokestatic 156	com/tencent/mobileqq/managers/DraftTextManager:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   39: astore 4
    //   41: getstatic 34	com/tencent/mobileqq/managers/DraftTextManager:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   44: aload 4
    //   46: invokevirtual 170	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   49: ifne +12 -> 61
    //   52: getstatic 34	com/tencent/mobileqq/managers/DraftTextManager:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   55: aload 4
    //   57: invokevirtual 160	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   60: pop
    //   61: getstatic 26	com/tencent/mobileqq/managers/DraftTextManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   64: aload 4
    //   66: aload_2
    //   67: invokevirtual 164	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: pop
    //   71: getstatic 28	com/tencent/mobileqq/managers/DraftTextManager:b	Landroid/support/v4/util/LruCache;
    //   74: aload 4
    //   76: aload_2
    //   77: invokestatic 166	com/tencent/mobileqq/managers/DraftTextManager:a	(Lcom/tencent/mobileqq/data/DraftTextInfo;)Lcom/tencent/mobileqq/data/DraftSummaryInfo;
    //   80: invokevirtual 164	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: aload_1
    //   85: invokevirtual 103	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   88: invokevirtual 109	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   91: astore 4
    //   93: aload 4
    //   95: invokevirtual 236	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 239	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   103: aload 4
    //   105: aload_2
    //   106: invokevirtual 242	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   109: aload_1
    //   110: invokevirtual 245	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   113: aload_1
    //   114: invokevirtual 247	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   117: aload 4
    //   119: invokevirtual 127	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   122: aload_3
    //   123: monitorexit
    //   124: return
    //   125: astore_1
    //   126: aload_3
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    //   130: astore_2
    //   131: aload_2
    //   132: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   135: aload_1
    //   136: invokevirtual 247	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   139: goto -22 -> 117
    //   142: astore_2
    //   143: aload_1
    //   144: invokevirtual 247	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   147: aload_2
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	DraftTextManager
    //   0	149	1	paramQQAppInterface	QQAppInterface
    //   0	149	2	paramDraftTextInfo	DraftTextInfo
    //   18	109	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   25	27	125	finally
    //   28	61	125	finally
    //   61	99	125	finally
    //   113	117	125	finally
    //   117	124	125	finally
    //   126	128	125	finally
    //   135	139	125	finally
    //   143	149	125	finally
    //   99	113	130	java/lang/Exception
    //   99	113	142	finally
    //   131	135	142	finally
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String arg2, int paramInt)
  {
    String str = a(???, paramInt);
    if (!jdField_a_of_type_JavaUtilHashSet.contains(str)) {
      return false;
    }
    DraftTextInfo localDraftTextInfo2 = (DraftTextInfo)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(str);
    DraftTextInfo localDraftTextInfo1 = localDraftTextInfo2;
    if (localDraftTextInfo2 == null) {
      localDraftTextInfo1 = a(paramQQAppInterface, ???, paramInt);
    }
    jdField_a_of_type_JavaUtilHashSet.remove(str);
    jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(str);
    b.remove(str);
    boolean bool;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt);
    return jdField_a_of_type_JavaUtilHashSet.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.managers.DraftTextManager
 * JD-Core Version:    0.7.0.1
 */