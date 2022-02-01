import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.PreloadCookie;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arch
{
  public EntityManager c;
  public AppInterface mApp;
  
  public arch(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    paramAppInterface = this.mApp.getEntityManagerFactory();
    if (paramAppInterface != null) {
      this.c = paramAppInterface.createEntityManager();
    }
  }
  
  public List<String> bg(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject = this.c.query(PreloadCookie.class, false, "cookieKey=?", new String[] { paramString }, null, null, "hitCount DESC", "10");
        if (QLog.isColorLevel())
        {
          if (localObject == null)
          {
            i = 0;
            QLog.i("SwiftPreloadCookieManager", 2, String.format("now select records for cookieKey: %s, size: %d", new Object[] { paramString, Integer.valueOf(i) }));
          }
        }
        else
        {
          if ((localObject == null) || (((List)localObject).size() <= 0)) {
            break label148;
          }
          paramString = new ArrayList();
          localObject = ((List)localObject).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          paramString.add(((PreloadCookie)((Iterator)localObject).next()).host);
          continue;
        }
        int i = ((List)localObject).size();
      }
      finally {}
    }
    return paramString;
    label148:
    return null;
  }
  
  /* Error */
  public void iA(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield 29	arch:c	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   7: ldc 34
    //   9: iconst_2
    //   10: anewarray 38	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: aload_1
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: aload_2
    //   20: aastore
    //   21: invokevirtual 110	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   24: checkcast 34	com/tencent/mobileqq/data/PreloadCookie
    //   27: astore_3
    //   28: aload_3
    //   29: ifnull +67 -> 96
    //   32: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +38 -> 73
    //   38: ldc 56
    //   40: iconst_2
    //   41: ldc 112
    //   43: iconst_3
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload_1
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: aload_2
    //   54: aastore
    //   55: dup
    //   56: iconst_2
    //   57: aload_3
    //   58: getfield 116	com/tencent/mobileqq/data/PreloadCookie:hitCount	J
    //   61: lconst_1
    //   62: ladd
    //   63: invokestatic 121	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   66: aastore
    //   67: invokestatic 68	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   70: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: aload_3
    //   74: aload_3
    //   75: getfield 116	com/tencent/mobileqq/data/PreloadCookie:hitCount	J
    //   78: lconst_1
    //   79: ladd
    //   80: putfield 116	com/tencent/mobileqq/data/PreloadCookie:hitCount	J
    //   83: aload_0
    //   84: getfield 29	arch:c	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   87: aload_3
    //   88: invokevirtual 125	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   91: pop
    //   92: ldc 2
    //   94: monitorexit
    //   95: return
    //   96: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +26 -> 125
    //   102: ldc 56
    //   104: iconst_2
    //   105: ldc 127
    //   107: iconst_2
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_1
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: aload_2
    //   118: aastore
    //   119: invokestatic 68	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   122: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: new 34	com/tencent/mobileqq/data/PreloadCookie
    //   128: dup
    //   129: invokespecial 128	com/tencent/mobileqq/data/PreloadCookie:<init>	()V
    //   132: astore_3
    //   133: aload_3
    //   134: aload_1
    //   135: putfield 98	com/tencent/mobileqq/data/PreloadCookie:host	Ljava/lang/String;
    //   138: aload_3
    //   139: aload_2
    //   140: putfield 131	com/tencent/mobileqq/data/PreloadCookie:cookieKey	Ljava/lang/String;
    //   143: aload_3
    //   144: lconst_1
    //   145: putfield 116	com/tencent/mobileqq/data/PreloadCookie:hitCount	J
    //   148: aload_0
    //   149: getfield 29	arch:c	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   152: aload_3
    //   153: invokevirtual 135	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   156: goto -64 -> 92
    //   159: astore_1
    //   160: ldc 2
    //   162: monitorexit
    //   163: aload_1
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	arch
    //   0	165	1	paramString1	String
    //   0	165	2	paramString2	String
    //   27	126	3	localPreloadCookie	PreloadCookie
    // Exception table:
    //   from	to	target	type
    //   3	28	159	finally
    //   32	73	159	finally
    //   73	92	159	finally
    //   92	95	159	finally
    //   96	125	159	finally
    //   125	156	159	finally
    //   160	163	159	finally
  }
  
  public void iB(String paramString1, String paramString2)
  {
    try
    {
      PreloadCookie localPreloadCookie = (PreloadCookie)this.c.find(PreloadCookie.class, new String[] { paramString1, paramString2 });
      if (localPreloadCookie != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SwiftPreloadCookieManager", 2, "delete host: " + paramString1 + ", type: " + paramString2);
        }
        this.c.remove(localPreloadCookie);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arch
 * JD-Core Version:    0.7.0.1
 */