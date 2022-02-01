import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.singtogether.FetchOpenIdManager.1;
import com.tencent.mobileqq.intervideo.singtogether.OpenIdItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.manager.Manager;

public class aigv
  implements Manager
{
  private List<OpenIdItem> Cz;
  private acfd jdField_a_of_type_Acfd = new aigx(this);
  private aigy jdField_a_of_type_Aigy = new aigw(this);
  private int ddm = -1;
  private HashMap<Long, HashMap<Long, String>> jC;
  private QQAppInterface mApp;
  
  public aigv(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.jC = new HashMap();
    this.Cz = new ArrayList();
    this.mApp.registObserver(this.jdField_a_of_type_Aigy);
    this.mApp.addObserver(this.jdField_a_of_type_Acfd);
    db(paramQQAppInterface);
  }
  
  /* Error */
  private OpenIdItem a(OpenIdItem paramOpenIdItem, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	aigv:Cz	Ljava/util/List;
    //   6: invokeinterface 75 1 0
    //   11: astore 4
    //   13: aload 4
    //   15: invokeinterface 81 1 0
    //   20: ifeq +125 -> 145
    //   23: aload 4
    //   25: invokeinterface 85 1 0
    //   30: checkcast 87	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem
    //   33: astore_3
    //   34: aload_3
    //   35: getfield 91	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:uin	J
    //   38: aload_1
    //   39: getfield 91	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:uin	J
    //   42: lcmp
    //   43: ifne -30 -> 13
    //   46: aload_3
    //   47: getfield 94	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:appId	J
    //   50: aload_1
    //   51: getfield 94	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:appId	J
    //   54: lcmp
    //   55: ifne -42 -> 13
    //   58: iload_2
    //   59: ifeq +11 -> 70
    //   62: aload_3
    //   63: aload_1
    //   64: getfield 98	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:openId	Ljava/lang/String;
    //   67: putfield 98	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:openId	Ljava/lang/String;
    //   70: aload_3
    //   71: astore_1
    //   72: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +66 -> 141
    //   78: ldc 105
    //   80: iconst_2
    //   81: new 107	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   88: ldc 110
    //   90: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_3
    //   94: getfield 91	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:uin	J
    //   97: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   100: ldc 119
    //   102: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_3
    //   106: getfield 94	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:appId	J
    //   109: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   112: ldc 121
    //   114: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_3
    //   118: getfield 98	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:openId	Ljava/lang/String;
    //   121: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc 123
    //   126: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: iload_2
    //   130: invokevirtual 126	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   133: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload_3
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: areturn
    //   145: aload_0
    //   146: getfield 50	aigv:Cz	Ljava/util/List;
    //   149: aload_1
    //   150: invokeinterface 138 2 0
    //   155: pop
    //   156: goto -15 -> 141
    //   159: astore_1
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	aigv
    //   0	164	1	paramOpenIdItem	OpenIdItem
    //   0	164	2	paramBoolean	boolean
    //   33	107	3	localOpenIdItem	OpenIdItem
    //   11	13	4	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	159	finally
    //   13	58	159	finally
    //   62	70	159	finally
    //   72	139	159	finally
    //   145	156	159	finally
  }
  
  private void db(QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (this.ddm == -1)
      {
        this.ddm = 0;
        ThreadManagerV2.excute(new FetchOpenIdManager.1(this, paramQQAppInterface), 16, null, true);
      }
      return;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  private void k(long paramLong1, long paramLong2, String paramString)
  {
    try
    {
      HashMap localHashMap2 = (HashMap)this.jC.get(Long.valueOf(paramLong1));
      HashMap localHashMap1 = localHashMap2;
      if (localHashMap2 == null)
      {
        localHashMap1 = new HashMap();
        this.jC.put(Long.valueOf(paramLong1), localHashMap1);
      }
      localHashMap1.put(Long.valueOf(paramLong2), paramString);
      return;
    }
    finally {}
  }
  
  public String e(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (HashMap)this.jC.get(Long.valueOf(paramLong2));
        if (localObject1 != null)
        {
          localObject1 = (String)((HashMap)localObject1).get(Long.valueOf(paramLong1));
          if (QLog.isColorLevel()) {
            QLog.d("FetchOpenIdManager", 2, " getOpenId openId=" + (String)localObject1 + " uin=" + paramLong1 + " state= " + this.ddm);
          }
          boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (!bool) {
            return localObject1;
          }
          if ((this.ddm == 0) || (!paramBoolean)) {
            continue;
          }
          aigz.a(paramLong1, paramLong2, this.mApp);
          continue;
        }
        String str = "";
      }
      finally {}
    }
  }
  
  /* Error */
  public void l(long paramLong1, long paramLong2, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +47 -> 52
    //   8: ldc 105
    //   10: iconst_2
    //   11: new 107	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   18: ldc 198
    //   20: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: ldc 177
    //   29: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: lload_3
    //   33: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   36: ldc 200
    //   38: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload 5
    //   43: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 45	aigv:jC	Ljava/util/HashMap;
    //   56: lload_1
    //   57: invokestatic 161	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   60: invokevirtual 165	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 42	java/util/HashMap
    //   66: astore 7
    //   68: aload 7
    //   70: astore 6
    //   72: aload 7
    //   74: ifnonnull +26 -> 100
    //   77: new 42	java/util/HashMap
    //   80: dup
    //   81: invokespecial 43	java/util/HashMap:<init>	()V
    //   84: astore 6
    //   86: aload_0
    //   87: getfield 45	aigv:jC	Ljava/util/HashMap;
    //   90: lload_1
    //   91: invokestatic 161	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   94: aload 6
    //   96: invokevirtual 169	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   99: pop
    //   100: aload_0
    //   101: getfield 40	aigv:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   104: invokevirtual 203	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   107: invokevirtual 209	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   110: astore 7
    //   112: aload 6
    //   114: lload_3
    //   115: invokestatic 161	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   118: aload 5
    //   120: invokevirtual 169	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   123: pop
    //   124: new 87	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem
    //   127: dup
    //   128: invokespecial 210	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:<init>	()V
    //   131: astore 6
    //   133: aload 6
    //   135: lload_1
    //   136: putfield 94	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:appId	J
    //   139: aload 6
    //   141: aload 5
    //   143: putfield 98	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:openId	Ljava/lang/String;
    //   146: aload 6
    //   148: lload_3
    //   149: putfield 91	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:uin	J
    //   152: aload_0
    //   153: aload 6
    //   155: iconst_1
    //   156: invokespecial 69	aigv:a	(Lcom/tencent/mobileqq/intervideo/singtogether/OpenIdItem;Z)Lcom/tencent/mobileqq/intervideo/singtogether/OpenIdItem;
    //   159: astore 5
    //   161: aload 5
    //   163: invokevirtual 214	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:getStatus	()I
    //   166: sipush 1000
    //   169: if_icmpne +18 -> 187
    //   172: aload 7
    //   174: aload 5
    //   176: invokevirtual 220	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   179: aload 7
    //   181: invokevirtual 223	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   184: aload_0
    //   185: monitorexit
    //   186: return
    //   187: aload 7
    //   189: aload 5
    //   191: invokevirtual 227	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   194: pop
    //   195: goto -16 -> 179
    //   198: astore 5
    //   200: aload_0
    //   201: monitorexit
    //   202: aload 5
    //   204: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	aigv
    //   0	205	1	paramLong1	long
    //   0	205	3	paramLong2	long
    //   0	205	5	paramString	String
    //   70	84	6	localObject1	Object
    //   66	122	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	52	198	finally
    //   52	68	198	finally
    //   77	100	198	finally
    //   100	179	198	finally
    //   179	184	198	finally
    //   187	195	198	finally
  }
  
  public void onDestroy()
  {
    try
    {
      this.jC.clear();
      this.Cz.clear();
      this.mApp.unRegistObserver(this.jdField_a_of_type_Aigy);
      this.mApp.removeObserver(this.jdField_a_of_type_Acfd);
      this.ddm = -1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean y(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 45	aigv:jC	Ljava/util/HashMap;
    //   9: lload_1
    //   10: invokestatic 161	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   13: invokevirtual 165	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast 42	java/util/HashMap
    //   19: astore 7
    //   21: iload 6
    //   23: istore 5
    //   25: aload 7
    //   27: ifnull +25 -> 52
    //   30: aload 7
    //   32: lload_3
    //   33: invokestatic 161	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   36: invokevirtual 243	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 173	java/lang/String
    //   42: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifeq +163 -> 208
    //   48: iload 6
    //   50: istore 5
    //   52: aload_0
    //   53: getfield 50	aigv:Cz	Ljava/util/List;
    //   56: invokeinterface 75 1 0
    //   61: astore 8
    //   63: aload 8
    //   65: invokeinterface 81 1 0
    //   70: ifeq +144 -> 214
    //   73: aload 8
    //   75: invokeinterface 85 1 0
    //   80: checkcast 87	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem
    //   83: astore 7
    //   85: aload 7
    //   87: getfield 91	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:uin	J
    //   90: lload_3
    //   91: lcmp
    //   92: ifne -29 -> 63
    //   95: aload 7
    //   97: getfield 94	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:appId	J
    //   100: lload_1
    //   101: lcmp
    //   102: ifne -39 -> 63
    //   105: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +58 -> 166
    //   111: ldc 105
    //   113: iconst_2
    //   114: new 107	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   121: ldc 110
    //   123: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 7
    //   128: getfield 91	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:uin	J
    //   131: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   134: ldc 119
    //   136: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 7
    //   141: getfield 94	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:appId	J
    //   144: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   147: ldc 121
    //   149: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload 7
    //   154: getfield 98	com/tencent/mobileqq/intervideo/singtogether/OpenIdItem:openId	Ljava/lang/String;
    //   157: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload_0
    //   167: getfield 50	aigv:Cz	Ljava/util/List;
    //   170: aload 7
    //   172: invokeinterface 245 2 0
    //   177: pop
    //   178: aload_0
    //   179: getfield 40	aigv:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   182: invokevirtual 203	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   185: invokevirtual 209	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   188: astore 8
    //   190: aload 8
    //   192: aload 7
    //   194: invokevirtual 247	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   197: pop
    //   198: aload 8
    //   200: invokevirtual 223	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   203: aload_0
    //   204: monitorexit
    //   205: iload 5
    //   207: ireturn
    //   208: iconst_1
    //   209: istore 5
    //   211: goto -159 -> 52
    //   214: goto -11 -> 203
    //   217: astore 7
    //   219: aload_0
    //   220: monitorexit
    //   221: aload 7
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	aigv
    //   0	224	1	paramLong1	long
    //   0	224	3	paramLong2	long
    //   23	187	5	bool1	boolean
    //   1	48	6	bool2	boolean
    //   19	174	7	localObject1	Object
    //   217	5	7	localObject2	Object
    //   61	138	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   5	21	217	finally
    //   30	48	217	finally
    //   52	63	217	finally
    //   63	166	217	finally
    //   166	203	217	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aigv
 * JD-Core Version:    0.7.0.1
 */