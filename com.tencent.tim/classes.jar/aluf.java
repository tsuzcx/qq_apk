import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.relationx.addFrd.AddFrdStateMng.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class aluf
{
  private static final String TAG = aluf.class.getSimpleName();
  boolean czu = false;
  public volatile boolean czv = false;
  final ConcurrentHashMap<String, Long> dk = new ConcurrentHashMap(5);
  WeakReference<QQAppInterface> mAppRef;
  public boolean mIsInit;
  SharedPreferences mPref = null;
  
  private void dJM()
  {
    if ((this.czu) && (!this.czv))
    {
      this.czv = true;
      ThreadManager.excute(new AddFrdStateMng.1(this), 16, null, false);
    }
  }
  
  private void dJN()
  {
    int i = 0;
    if (!this.czu) {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "save cache no change");
      }
    }
    do
    {
      return;
      SharedPreferences localSharedPreferences = getPref();
      if (localSharedPreferences != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "save cache pref is null");
    return;
    Map.Entry localEntry;
    try
    {
      this.czu = false;
      localObject1 = new ArrayList(this.dk.size());
      localObject2 = this.dk.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject2).next();
        if ((localEntry != null) && (localEntry.getValue() != null) && (((Long)localEntry.getValue()).longValue() != 0L)) {
          ((ArrayList)localObject1).add(localEntry);
        }
      }
      if (((ArrayList)localObject1).size() <= 100) {
        break label176;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return;
    }
    Collections.sort((List)localObject1, new alug(this));
    label176:
    Object localObject2 = new StringBuilder(200);
    Object localObject1 = ((ArrayList)localObject1).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject1).next();
        if (((StringBuilder)localObject2).length() > 0) {
          ((StringBuilder)localObject2).append(",");
        }
        ((StringBuilder)localObject2).append((String)localEntry.getKey()).append("|").append(localEntry.getValue());
        i += 1;
        if (i < 100) {}
      }
      else
      {
        localThrowable.edit().putString("add_frd_state_list", ((StringBuilder)localObject2).toString()).apply();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(TAG, 2, String.format("saveCache %s", new Object[] { ((StringBuilder)localObject2).toString() }));
        return;
      }
    }
  }
  
  public void OW(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      try
      {
        this.dk.put(paramString, Long.valueOf(l));
        this.czu = true;
        dJM();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(TAG, 2, String.format("markSendAddFrd uin:%s, time:%s", new Object[] { paramString, Long.valueOf(l) }));
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public void OX(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        Long localLong = (Long)this.dk.remove(paramString);
        if (localLong != null) {
          this.czu = true;
        }
        dJM();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(TAG, 2, String.format("removeFromCache uin:%s, change: %s", new Object[] { paramString, Boolean.valueOf(this.czu) }));
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          Object localObject = null;
        }
      }
    }
  }
  
  public int e(String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return 0;
    }
    int i = 3;
    long l = System.currentTimeMillis();
    try
    {
      localObject2 = (Long)this.dk.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Long.valueOf(0L);
      }
      localObject2 = localObject1;
      if (((Long)localObject1).longValue() != 0L)
      {
        localObject2 = localObject1;
        if (Math.abs(l - ((Long)localObject1).longValue()) >= 604800000L)
        {
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("getAddFrdState long time ago [time:%s, cur: %s, du: %s]", new Object[] { localObject1, Long.valueOf(l), Long.valueOf(Math.abs(l - ((Long)localObject1).longValue())) }));
          }
          localObject2 = Long.valueOf(0L);
          OX(paramString);
        }
      }
      if (((Long)localObject2).longValue() != 0L) {
        i = 2;
      }
      if (paramQQAppInterface != null)
      {
        localObject1 = paramQQAppInterface.getCurrentAccountUin();
        if ((localObject1 != null) && (((String)localObject1).equals(paramString))) {
          return 0;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        Object localObject2 = null;
      }
      if (((acff)paramQQAppInterface.getManager(51)).isFriend(paramString))
      {
        OX(paramString);
        return 1;
      }
    }
    return i;
  }
  
  public SharedPreferences getPref()
  {
    QQAppInterface localQQAppInterface;
    if (this.mPref == null)
    {
      if (this.mAppRef != null) {
        break label64;
      }
      localQQAppInterface = null;
      if (localQQAppInterface == null) {
        break label78;
      }
      String str = localQQAppInterface.getCurrentAccountUin();
      str = "add_frd_state_" + str;
      this.mPref = localQQAppInterface.getApplication().getSharedPreferences(str, 0);
    }
    for (;;)
    {
      return this.mPref;
      label64:
      localQQAppInterface = (QQAppInterface)this.mAppRef.get();
      break;
      label78:
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "getPref app is null");
      }
    }
  }
  
  /* Error */
  public void z(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 276	aluf:mIsInit	Z
    //   6: istore 6
    //   8: iload 6
    //   10: ifne +199 -> 209
    //   13: aload_1
    //   14: ifnull +15 -> 29
    //   17: aload_0
    //   18: new 268	java/lang/ref/WeakReference
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 279	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   26: putfield 253	aluf:mAppRef	Ljava/lang/ref/WeakReference;
    //   29: aload_0
    //   30: invokevirtual 79	aluf:getPref	()Landroid/content/SharedPreferences;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnonnull +64 -> 99
    //   38: aconst_null
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +187 -> 228
    //   44: aload_1
    //   45: invokevirtual 187	java/lang/String:length	()I
    //   48: ifle +180 -> 228
    //   51: aload_1
    //   52: ldc 144
    //   54: invokevirtual 283	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   57: astore 10
    //   59: aload 10
    //   61: arraylength
    //   62: ifle +166 -> 228
    //   65: aload 10
    //   67: arraylength
    //   68: istore_3
    //   69: iconst_0
    //   70: istore_2
    //   71: iload_2
    //   72: iload_3
    //   73: if_icmpge +155 -> 228
    //   76: aload 10
    //   78: iload_2
    //   79: aaload
    //   80: astore 11
    //   82: aload 11
    //   84: ifnull +189 -> 273
    //   87: aload 11
    //   89: invokevirtual 187	java/lang/String:length	()I
    //   92: iconst_3
    //   93: if_icmpge +21 -> 114
    //   96: goto +177 -> 273
    //   99: aload_1
    //   100: ldc 166
    //   102: ldc_w 285
    //   105: invokeinterface 289 3 0
    //   110: astore_1
    //   111: goto -71 -> 40
    //   114: aload 11
    //   116: ldc 155
    //   118: invokevirtual 293	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   121: istore 4
    //   123: iload 4
    //   125: ifle +148 -> 273
    //   128: aload 11
    //   130: invokevirtual 187	java/lang/String:length	()I
    //   133: istore 5
    //   135: iload 4
    //   137: iload 5
    //   139: iconst_1
    //   140: isub
    //   141: if_icmpge +132 -> 273
    //   144: aload 11
    //   146: iconst_0
    //   147: iload 4
    //   149: invokevirtual 297	java/lang/String:substring	(II)Ljava/lang/String;
    //   152: astore 9
    //   154: aload 11
    //   156: iload 4
    //   158: iconst_1
    //   159: iadd
    //   160: invokevirtual 300	java/lang/String:substring	(I)Ljava/lang/String;
    //   163: invokestatic 304	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   166: lstore 7
    //   168: aload 9
    //   170: ifnull +103 -> 273
    //   173: aload 9
    //   175: invokevirtual 187	java/lang/String:length	()I
    //   178: ifle +95 -> 273
    //   181: aload_0
    //   182: getfield 45	aluf:dk	Ljava/util/concurrent/ConcurrentHashMap;
    //   185: aload 9
    //   187: lload 7
    //   189: invokestatic 196	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   192: invokevirtual 200	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   195: pop
    //   196: goto +77 -> 273
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 125	java/lang/Throwable:printStackTrace	()V
    //   204: aload_0
    //   205: iconst_1
    //   206: putfield 276	aluf:mIsInit	Z
    //   209: aload_0
    //   210: monitorexit
    //   211: return
    //   212: astore 9
    //   214: aload 9
    //   216: invokevirtual 125	java/lang/Throwable:printStackTrace	()V
    //   219: lconst_0
    //   220: lstore 7
    //   222: aconst_null
    //   223: astore 9
    //   225: goto -57 -> 168
    //   228: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq -27 -> 204
    //   234: getstatic 28	aluf:TAG	Ljava/lang/String;
    //   237: iconst_2
    //   238: ldc_w 306
    //   241: iconst_2
    //   242: anewarray 4	java/lang/Object
    //   245: dup
    //   246: iconst_0
    //   247: aload_1
    //   248: aastore
    //   249: dup
    //   250: iconst_1
    //   251: aload_0
    //   252: getfield 45	aluf:dk	Ljava/util/concurrent/ConcurrentHashMap;
    //   255: invokevirtual 307	java/util/concurrent/ConcurrentHashMap:toString	()Ljava/lang/String;
    //   258: aastore
    //   259: invokestatic 184	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   262: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: goto -61 -> 204
    //   268: astore_1
    //   269: aload_0
    //   270: monitorexit
    //   271: aload_1
    //   272: athrow
    //   273: iload_2
    //   274: iconst_1
    //   275: iadd
    //   276: istore_2
    //   277: goto -206 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	aluf
    //   0	280	1	paramQQAppInterface	QQAppInterface
    //   70	207	2	i	int
    //   68	6	3	j	int
    //   121	39	4	k	int
    //   133	8	5	m	int
    //   6	3	6	bool	boolean
    //   166	55	7	l	long
    //   152	34	9	str1	String
    //   212	3	9	localThrowable	Throwable
    //   223	1	9	localObject	Object
    //   57	20	10	arrayOfString	String[]
    //   80	75	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   17	29	199	java/lang/Throwable
    //   29	34	199	java/lang/Throwable
    //   44	69	199	java/lang/Throwable
    //   87	96	199	java/lang/Throwable
    //   99	111	199	java/lang/Throwable
    //   114	123	199	java/lang/Throwable
    //   128	135	199	java/lang/Throwable
    //   173	196	199	java/lang/Throwable
    //   214	219	199	java/lang/Throwable
    //   228	265	199	java/lang/Throwable
    //   144	168	212	java/lang/Throwable
    //   2	8	268	finally
    //   17	29	268	finally
    //   29	34	268	finally
    //   44	69	268	finally
    //   87	96	268	finally
    //   99	111	268	finally
    //   114	123	268	finally
    //   128	135	268	finally
    //   144	168	268	finally
    //   173	196	268	finally
    //   200	204	268	finally
    //   204	209	268	finally
    //   214	219	268	finally
    //   228	265	268	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aluf
 * JD-Core Version:    0.7.0.1
 */