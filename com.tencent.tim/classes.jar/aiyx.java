import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.managers.DraftTextManager.2;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class aiyx
{
  private static aiyx jdField_b_of_type_Aiyx;
  private static LruCache<String, DraftTextInfo> jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
  private static HashSet<String> bg = new HashSet();
  private static LruCache<String, DraftSummaryInfo> x = new LruCache(99);
  private Object ed = new Object();
  
  public static aiyx a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      throw new IllegalArgumentException("DraftTextManager this.app == null");
    }
    if (jdField_b_of_type_Aiyx == null)
    {
      jdField_b_of_type_Aiyx = new aiyx();
      dg(paramQQAppInterface);
    }
    return jdField_b_of_type_Aiyx;
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
    localDraftSummaryInfo.setAtInfoStr(paramDraftTextInfo.mAtInfoStr);
    if ((paramDraftTextInfo.sourceMsgSeq != 0L) && (TextUtils.isEmpty(paramDraftTextInfo.text)))
    {
      localDraftSummaryInfo.setSummary(" ");
      return localDraftSummaryInfo;
    }
    localDraftSummaryInfo.setSummary(lK(paramDraftTextInfo.text));
    return localDraftSummaryInfo;
  }
  
  private static void dg(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = j(paramQQAppInterface).iterator();
    while (paramQQAppInterface.hasNext())
    {
      DraftTextInfo localDraftTextInfo = (DraftTextInfo)paramQQAppInterface.next();
      if ((!TextUtils.isEmpty(localDraftTextInfo.text)) || (localDraftTextInfo.sourceMsgSeq != 0L))
      {
        String str = u(localDraftTextInfo.uin, localDraftTextInfo.type);
        bg.add(str);
        jdField_b_of_type_AndroidSupportV4UtilLruCache.put(str, localDraftTextInfo);
        x.put(str, a(localDraftTextInfo));
      }
    }
  }
  
  private static List<DraftTextInfo> j(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    try
    {
      List localList = paramQQAppInterface.query(DraftTextInfo.class, new DraftTextInfo().getTableName(), false, null, null, null, null, null, null);
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
        paramQQAppInterface.close();
      }
    }
    finally
    {
      paramQQAppInterface.close();
    }
    return new ArrayList();
  }
  
  private static String lK(String paramString)
  {
    return aqft.aH(paramString, 50);
  }
  
  private static String u(String paramString, int paramInt)
  {
    return top.u(paramString, paramInt);
  }
  
  public boolean D(String paramString, int paramInt)
  {
    paramString = u(paramString, paramInt);
    return bg.contains(paramString);
  }
  
  public DraftSummaryInfo a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str = u(paramString, paramInt);
    Object localObject1;
    if (!bg.contains(str)) {
      localObject1 = null;
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject2 = (DraftSummaryInfo)x.get(str);
          localObject1 = localObject2;
        } while (localObject2 != null);
        Object localObject2 = (DraftTextInfo)jdField_b_of_type_AndroidSupportV4UtilLruCache.get(str);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a(paramQQAppInterface, paramString, paramInt);
        }
        paramQQAppInterface = a((DraftTextInfo)localObject1);
        localObject1 = paramQQAppInterface;
      } while (paramQQAppInterface == null);
      localObject1 = paramQQAppInterface;
    } while (TextUtils.isEmpty(paramQQAppInterface.getSummary()));
    x.put(str, paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public DraftTextInfo a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    synchronized (this.ed)
    {
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      try
      {
        paramString = paramQQAppInterface.query(DraftTextInfo.class, new DraftTextInfo().getTableName(), false, "uin=? AND type=?", new String[] { paramString, String.valueOf(paramInt) }, null, null, null, null);
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = (DraftTextInfo)paramString.get(0);
          paramQQAppInterface.close();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramQQAppInterface.close();
        }
        paramQQAppInterface = finally;
        throw paramQQAppInterface;
      }
      finally
      {
        paramQQAppInterface.close();
      }
      return new DraftTextInfo();
    }
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, DraftTextInfo paramDraftTextInfo)
  {
    // Byte code:
    //   0: invokestatic 222	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 224
    //   8: iconst_2
    //   9: ldc 226
    //   11: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 37	aiyx:ed	Ljava/lang/Object;
    //   18: astore_3
    //   19: aload_3
    //   20: monitorenter
    //   21: aload_2
    //   22: ifnonnull +6 -> 28
    //   25: aload_3
    //   26: monitorexit
    //   27: return
    //   28: aload_2
    //   29: getfield 63	com/tencent/mobileqq/data/DraftTextInfo:uin	Ljava/lang/String;
    //   32: aload_2
    //   33: getfield 70	com/tencent/mobileqq/data/DraftTextInfo:type	I
    //   36: invokestatic 132	aiyx:u	(Ljava/lang/String;I)Ljava/lang/String;
    //   39: astore 4
    //   41: getstatic 33	aiyx:bg	Ljava/util/HashSet;
    //   44: aload 4
    //   46: invokevirtual 194	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   49: ifne +12 -> 61
    //   52: getstatic 33	aiyx:bg	Ljava/util/HashSet;
    //   55: aload 4
    //   57: invokevirtual 136	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   60: pop
    //   61: getstatic 25	aiyx:jdField_b_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   64: aload 4
    //   66: aload_2
    //   67: invokevirtual 140	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: pop
    //   71: getstatic 27	aiyx:x	Landroid/support/v4/util/LruCache;
    //   74: aload 4
    //   76: aload_2
    //   77: invokestatic 142	aiyx:a	(Lcom/tencent/mobileqq/data/DraftTextInfo;)Lcom/tencent/mobileqq/data/DraftSummaryInfo;
    //   80: invokevirtual 140	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: new 232	com/tencent/mobileqq/managers/DraftTextManager$1
    //   87: dup
    //   88: aload_0
    //   89: aload_1
    //   90: aload_2
    //   91: invokespecial 235	com/tencent/mobileqq/managers/DraftTextManager$1:<init>	(Laiyx;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/DraftTextInfo;)V
    //   94: bipush 8
    //   96: aconst_null
    //   97: iconst_0
    //   98: invokestatic 241	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   101: aload_3
    //   102: monitorexit
    //   103: return
    //   104: astore_1
    //   105: aload_3
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	aiyx
    //   0	109	1	paramQQAppInterface	QQAppInterface
    //   0	109	2	paramDraftTextInfo	DraftTextInfo
    //   18	88	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   25	27	104	finally
    //   28	61	104	finally
    //   61	103	104	finally
    //   105	107	104	finally
  }
  
  public DraftTextInfo b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    DraftTextInfo localDraftTextInfo = null;
    String str = u(paramString, paramInt);
    if (bg.contains(str)) {
      localDraftTextInfo = (DraftTextInfo)jdField_b_of_type_AndroidSupportV4UtilLruCache.get(str);
    }
    Object localObject = localDraftTextInfo;
    if (localDraftTextInfo == null)
    {
      paramQQAppInterface = a(paramQQAppInterface, paramString, paramInt);
      localObject = paramQQAppInterface;
      if (paramQQAppInterface != null)
      {
        localObject = paramQQAppInterface;
        if (!aqmr.isEmpty(paramQQAppInterface.text))
        {
          jdField_b_of_type_AndroidSupportV4UtilLruCache.put(str, paramQQAppInterface);
          localObject = paramQQAppInterface;
        }
      }
    }
    return localObject;
  }
  
  public String b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DraftTextManger", 4, "Get draft text| uin=" + paramString + " draftList=" + bg + " cache=" + jdField_b_of_type_AndroidSupportV4UtilLruCache);
    }
    String str = u(paramString, paramInt);
    if (!bg.contains(str)) {
      return null;
    }
    DraftTextInfo localDraftTextInfo = (DraftTextInfo)jdField_b_of_type_AndroidSupportV4UtilLruCache.get(str);
    if (localDraftTextInfo != null) {
      return localDraftTextInfo.text;
    }
    paramQQAppInterface = a(paramQQAppInterface, paramString, paramInt);
    if ((paramQQAppInterface != null) && (!aqmr.isEmpty(paramQQAppInterface.text))) {
      jdField_b_of_type_AndroidSupportV4UtilLruCache.put(str, paramQQAppInterface);
    }
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.text;
    }
    return "";
  }
  
  public void dvD()
  {
    jdField_b_of_type_Aiyx = null;
    bg.clear();
    jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
    x = new LruCache(99);
  }
  
  public boolean o(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    synchronized (this.ed)
    {
      String str = u(paramString, paramInt);
      if (!bg.contains(str)) {
        return false;
      }
      DraftTextInfo localDraftTextInfo = (DraftTextInfo)jdField_b_of_type_AndroidSupportV4UtilLruCache.get(str);
      bg.remove(str);
      jdField_b_of_type_AndroidSupportV4UtilLruCache.remove(str);
      x.remove(str);
      ThreadManager.post(new DraftTextManager.2(this, localDraftTextInfo, paramQQAppInterface, paramString, paramInt), 8, null, false);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiyx
 * JD-Core Version:    0.7.0.1
 */