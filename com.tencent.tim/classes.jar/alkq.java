import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcall.QCallProxy.1;
import com.tencent.mobileqq.qcall.QCallProxy.3;
import com.tencent.mobileqq.qcall.QCallProxy.5;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class alkq
  extends acxq
{
  private static volatile boolean mIsInit;
  private final List<QCallRecent> Fa = new ArrayList(20);
  private ConcurrentHashMap<String, List<QCallRecord>> ag = new ConcurrentHashMap();
  private Object bE = new Object();
  private ConcurrentHashMap<String, Object> cM = new ConcurrentHashMap();
  private boolean cxx;
  private int duS = 20;
  EntityManager em = null;
  private final Map<String, QCallRecent> mA = new HashMap();
  
  public alkq(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private Cursor a(String paramString)
  {
    Object localObject = null;
    paramString = top.gY(paramString);
    paramString = "select name from sqlite_master where (type='table') and (name like 'qc/_%/_" + paramString + "' escape '/') and (name not like 'qc/_" + 3000 + "/_" + paramString + "' escape '/') and (name not like 'qc/_" + 8 + "/_" + paramString + "' escape '/') order by name;";
    try
    {
      paramString = this.app.getReadableDatabase().rawQuery(paramString, null);
      return paramString;
    }
    catch (Exception localException)
    {
      do
      {
        paramString = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("QCallProxy", 2, localException.getMessage(), localException);
    }
    return null;
  }
  
  private void a(QCallRecent paramQCallRecent, boolean paramBoolean)
  {
    if ((paramQCallRecent == null) || (paramQCallRecent.uin == null) || (paramQCallRecent.uin.length() < 2)) {
      aqft.printCallStack("QCallProxy");
    }
    while ((paramQCallRecent == null) || (paramQCallRecent.uin == null) || (paramQCallRecent.uin.length() < 2)) {
      return;
    }
    List localList = this.Fa;
    Object localObject1 = paramQCallRecent;
    for (;;)
    {
      try
      {
        if (paramQCallRecent.type != 1)
        {
          localObject1 = paramQCallRecent;
          if (paramQCallRecent.type != 3000)
          {
            localObject1 = paramQCallRecent;
            if (paramQCallRecent.type != 8)
            {
              localObject2 = new ArrayList();
              localObject1 = top.eW;
              j = localObject1.length;
              i = 0;
              if (i < j)
              {
                int k = localObject1[i];
                if (k == paramQCallRecent.type) {
                  break label695;
                }
                QCallRecent localQCallRecent = (QCallRecent)this.mA.remove(at(paramQCallRecent.uin, k));
                if (localQCallRecent == null) {
                  break label695;
                }
                ((ArrayList)localObject2).add(localQCallRecent);
                break label695;
              }
              j = ((ArrayList)localObject2).size();
              localObject1 = paramQCallRecent;
              if (j > 0)
              {
                if (paramQCallRecent.getStatus() != 1000) {
                  break label690;
                }
                localObject1 = (QCallRecent)((ArrayList)localObject2).get(0);
                this.Fa.remove(localObject1);
                ((QCallRecent)localObject1).type = paramQCallRecent.type;
                ((QCallRecent)localObject1).troopUin = paramQCallRecent.troopUin;
                ((QCallRecent)localObject1).displayName = paramQCallRecent.displayName;
                ((QCallRecent)localObject1).lastCallTime = paramQCallRecent.lastCallTime;
                ((QCallRecent)localObject1).lastCallMsg = paramQCallRecent.lastCallMsg;
                ((QCallRecent)localObject1).sendFlag = paramQCallRecent.sendFlag;
                ((QCallRecent)localObject1).isVideo = paramQCallRecent.isVideo;
                ((QCallRecent)localObject1).missedCallCount = paramQCallRecent.missedCallCount;
                ((QCallRecent)localObject1).isLastCallRealMissed = paramQCallRecent.isLastCallRealMissed;
                i = 1;
                paramQCallRecent = (QCallRecent)localObject1;
                localObject1 = paramQCallRecent;
                if (i < j)
                {
                  localObject1 = (QCallRecent)((ArrayList)localObject2).get(i);
                  this.Fa.remove(localObject1);
                  d((QCallRecent)localObject1);
                  i += 1;
                  continue;
                }
              }
            }
          }
        }
        paramQCallRecent = this.mA.keySet();
        Object localObject2 = new String[paramQCallRecent.size()];
        paramQCallRecent.toArray((Object[])localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("QCallProxy", 2, "saveRecentCall before put:" + Arrays.toString((Object[])localObject2));
        }
        this.mA.put(at(((QCallRecent)localObject1).uin, ((QCallRecent)localObject1).type), localObject1);
        paramQCallRecent = this.mA.keySet();
        localObject2 = new String[paramQCallRecent.size()];
        paramQCallRecent.toArray((Object[])localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("QCallProxy", 2, "saveRecentCall after put:" + Arrays.toString((Object[])localObject2));
        }
        this.Fa.remove(localObject1);
        int j = this.Fa.size();
        i = 0;
        if (i < j)
        {
          paramQCallRecent = (QCallRecent)this.Fa.get(i);
          if (((QCallRecent)localObject1).lastCallTime > paramQCallRecent.lastCallTime)
          {
            this.Fa.add(i, localObject1);
            i = 1;
            if (i == 0) {
              this.Fa.add(this.Fa.size(), localObject1);
            }
            if (!paramBoolean) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QCallProxy", 2, "insertOrUpdateRecentCallToDB uin: " + ((QCallRecent)localObject1).uin + ",callstatus:" + ((QCallRecent)localObject1).state);
            }
            e((QCallRecent)localObject1);
            return;
          }
          i += 1;
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label690:
      int i = 0;
      continue;
      label695:
      i += 1;
    }
  }
  
  private boolean a(QCallRecord paramQCallRecord)
  {
    this.a.addMsgQueue(paramQCallRecord.friendUin, paramQCallRecord.uinType, paramQCallRecord.getTableName(), paramQCallRecord, 3, null);
    return true;
  }
  
  private boolean ag(String paramString, int paramInt)
  {
    if ((paramInt == 3000) || (paramInt == 8)) {
      this.a.addMsgQueue(paramString, paramInt, QCallRecord.getTableName(paramString, paramInt), null, null, 2, null);
    }
    for (;;)
    {
      return true;
      ThreadManager.post(new QCallProxy.3(this, paramString), 5, null, false);
    }
  }
  
  private String at(String paramString, int paramInt)
  {
    return paramString + "&" + paramInt;
  }
  
  private EntityManager b()
  {
    if ((this.em == null) || (!this.em.isOpen())) {}
    synchronized (this.bE)
    {
      if ((this.em == null) || (!this.em.isOpen())) {
        this.em = this.app.a().createEntityManager();
      }
      return this.em;
    }
  }
  
  private Object c(String arg1, int paramInt)
  {
    String str = u(???, paramInt);
    if (!this.cM.containsKey(str)) {}
    synchronized (this.cM)
    {
      if (!this.cM.containsKey(str)) {
        this.cM.put(str, new Object());
      }
      return this.cM.get(str);
    }
  }
  
  private int dL(String paramString)
  {
    paramString = paramString.split("[^0-9]");
    int k = -1;
    for (;;)
    {
      try
      {
        int m = paramString.length;
        i = 0;
        j = k;
        if (i < m)
        {
          String str = paramString[i];
          if ((str == null) || (str.length() <= 0)) {
            continue;
          }
          j = Integer.parseInt(str);
        }
      }
      catch (Exception paramString)
      {
        int i;
        int j = k;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("QCallProxy", 2, paramString.getMessage(), paramString);
      }
      return j;
      i += 1;
    }
    return -1;
  }
  
  private String u(String paramString, int paramInt)
  {
    String str = this.app.getCurrentAccountUin().concat("_").concat(paramString);
    if (paramInt != 3000)
    {
      paramString = str;
      if (paramInt != 8) {}
    }
    else
    {
      paramString = str.concat(String.valueOf(paramInt));
    }
    return paramString;
  }
  
  /* Error */
  private List<QCallRecord> u(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: getfield 105	alkq:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10: invokevirtual 354	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   13: astore 8
    //   15: aload 8
    //   17: ifnonnull +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: iload_2
    //   23: sipush 3000
    //   26: if_icmpeq +9 -> 35
    //   29: iload_2
    //   30: bipush 8
    //   32: if_icmpne +165 -> 197
    //   35: aload_1
    //   36: iload_2
    //   37: invokestatic 285	com/tencent/mobileqq/data/QCallRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   40: astore_1
    //   41: aload 8
    //   43: aload_1
    //   44: invokevirtual 357	com/tencent/mobileqq/app/SQLiteDatabase:getCount	(Ljava/lang/String;)I
    //   47: istore_2
    //   48: iload_2
    //   49: aload_0
    //   50: getfield 49	alkq:duS	I
    //   53: if_icmple +39 -> 92
    //   56: aload 8
    //   58: ldc_w 359
    //   61: iconst_3
    //   62: anewarray 44	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload_1
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: aload_1
    //   72: aastore
    //   73: dup
    //   74: iconst_2
    //   75: iload_2
    //   76: aload_0
    //   77: getfield 49	alkq:duS	I
    //   80: isub
    //   81: invokestatic 362	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: aastore
    //   85: invokestatic 366	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   88: invokevirtual 370	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   91: pop
    //   92: new 81	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 372
    //   102: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc_w 374
    //   112: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore_1
    //   119: aload_0
    //   120: invokespecial 376	alkq:b	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   123: ldc_w 267
    //   126: aload_1
    //   127: aconst_null
    //   128: invokevirtual 379	com/tencent/mobileqq/persistence/EntityManager:rawQuery	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;
    //   131: astore_1
    //   132: aload_1
    //   133: ifnull +311 -> 444
    //   136: invokestatic 385	anaz:gQ	()J
    //   139: lstore 4
    //   141: aload_1
    //   142: invokeinterface 389 1 0
    //   147: astore 6
    //   149: aload 6
    //   151: invokeinterface 394 1 0
    //   156: ifeq +288 -> 444
    //   159: aload 6
    //   161: invokeinterface 398 1 0
    //   166: checkcast 267	com/tencent/mobileqq/data/QCallRecord
    //   169: astore 7
    //   171: aload 7
    //   173: ifnull -24 -> 149
    //   176: aload 7
    //   178: getfield 401	com/tencent/mobileqq/data/QCallRecord:time	J
    //   181: lload 4
    //   183: lcmp
    //   184: ifle -35 -> 149
    //   187: aload 7
    //   189: lload 4
    //   191: putfield 401	com/tencent/mobileqq/data/QCallRecord:time	J
    //   194: goto -45 -> 149
    //   197: aload_0
    //   198: aload_1
    //   199: invokespecial 71	alkq:a	(Ljava/lang/String;)Landroid/database/Cursor;
    //   202: astore_1
    //   203: aload_1
    //   204: ifnull +202 -> 406
    //   207: new 51	java/util/ArrayList
    //   210: dup
    //   211: invokespecial 161	java/util/ArrayList:<init>	()V
    //   214: astore 6
    //   216: aload_1
    //   217: ldc_w 403
    //   220: invokeinterface 408 2 0
    //   225: istore_2
    //   226: aload_1
    //   227: invokeinterface 411 1 0
    //   232: ifeq +174 -> 406
    //   235: aload_1
    //   236: iload_2
    //   237: invokeinterface 414 2 0
    //   242: invokestatic 419	com/tencent/mobileqq/utils/SecurityUtile:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   245: astore 7
    //   247: aload 8
    //   249: aload 7
    //   251: invokevirtual 357	com/tencent/mobileqq/app/SQLiteDatabase:getCount	(Ljava/lang/String;)I
    //   254: istore_3
    //   255: iload_3
    //   256: ifle -30 -> 226
    //   259: iload_3
    //   260: aload_0
    //   261: getfield 49	alkq:duS	I
    //   264: if_icmple +41 -> 305
    //   267: aload 8
    //   269: ldc_w 359
    //   272: iconst_3
    //   273: anewarray 44	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: aload 7
    //   280: aastore
    //   281: dup
    //   282: iconst_1
    //   283: aload 7
    //   285: aastore
    //   286: dup
    //   287: iconst_2
    //   288: iload_3
    //   289: aload_0
    //   290: getfield 49	alkq:duS	I
    //   293: isub
    //   294: invokestatic 362	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   297: aastore
    //   298: invokestatic 366	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   301: invokevirtual 370	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   304: pop
    //   305: new 81	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   312: ldc_w 372
    //   315: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload 7
    //   320: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: ldc_w 374
    //   326: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: astore 7
    //   334: aload_0
    //   335: invokespecial 376	alkq:b	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   338: ldc_w 267
    //   341: aload 7
    //   343: aconst_null
    //   344: invokevirtual 379	com/tencent/mobileqq/persistence/EntityManager:rawQuery	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;
    //   347: astore 7
    //   349: aload 7
    //   351: ifnull +13 -> 364
    //   354: aload 6
    //   356: aload 7
    //   358: invokeinterface 423 2 0
    //   363: pop
    //   364: aload 6
    //   366: new 425	alks
    //   369: dup
    //   370: aload_0
    //   371: invokespecial 428	alks:<init>	(Lalkq;)V
    //   374: invokestatic 434	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   377: goto -151 -> 226
    //   380: astore 7
    //   382: aload_1
    //   383: astore 7
    //   385: aload 6
    //   387: astore_1
    //   388: aload 7
    //   390: ifnull -258 -> 132
    //   393: aload 7
    //   395: invokeinterface 437 1 0
    //   400: aload 6
    //   402: astore_1
    //   403: goto -271 -> 132
    //   406: aload_1
    //   407: ifnull +65 -> 472
    //   410: aload_1
    //   411: invokeinterface 437 1 0
    //   416: aload 6
    //   418: astore_1
    //   419: goto -287 -> 132
    //   422: astore_1
    //   423: aconst_null
    //   424: astore 7
    //   426: aload_1
    //   427: astore 6
    //   429: aload 7
    //   431: ifnull +10 -> 441
    //   434: aload 7
    //   436: invokeinterface 437 1 0
    //   441: aload 6
    //   443: athrow
    //   444: aload_1
    //   445: areturn
    //   446: astore 6
    //   448: aload_1
    //   449: astore 7
    //   451: goto -22 -> 429
    //   454: astore_1
    //   455: aconst_null
    //   456: astore 6
    //   458: goto -73 -> 385
    //   461: astore 6
    //   463: aconst_null
    //   464: astore 6
    //   466: aload_1
    //   467: astore 7
    //   469: goto -84 -> 385
    //   472: aload 6
    //   474: astore_1
    //   475: goto -343 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	this	alkq
    //   0	478	1	paramString	String
    //   0	478	2	paramInt	int
    //   254	40	3	i	int
    //   139	51	4	l	long
    //   1	441	6	localObject1	Object
    //   446	1	6	localObject2	Object
    //   456	1	6	localObject3	Object
    //   461	1	6	localException1	Exception
    //   464	9	6	localObject4	Object
    //   4	353	7	localObject5	Object
    //   380	1	7	localException2	Exception
    //   383	85	7	str	String
    //   13	255	8	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   216	226	380	java/lang/Exception
    //   226	255	380	java/lang/Exception
    //   259	305	380	java/lang/Exception
    //   305	349	380	java/lang/Exception
    //   354	364	380	java/lang/Exception
    //   364	377	380	java/lang/Exception
    //   197	203	422	finally
    //   207	216	446	finally
    //   216	226	446	finally
    //   226	255	446	finally
    //   259	305	446	finally
    //   305	349	446	finally
    //   354	364	446	finally
    //   364	377	446	finally
    //   197	203	454	java/lang/Exception
    //   207	216	461	java/lang/Exception
  }
  
  private ArrayList<QCallRecord> y(List<QCallRecord> paramList)
  {
    if (paramList == null) {
      return null;
    }
    Collections.sort(paramList, new alkr(this));
    SparseIntArray localSparseIntArray = new SparseIntArray();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      QCallRecord localQCallRecord1 = (QCallRecord)localIterator.next();
      if ((localQCallRecord1 != null) && (localQCallRecord1.type != QCallRecord.TYPE_DATE))
      {
        if (localSparseIntArray.get(localQCallRecord1.getDate(), -1) == -1)
        {
          QCallRecord localQCallRecord2 = new QCallRecord(QCallRecord.TYPE_DATE);
          localQCallRecord2.time = localQCallRecord1.time;
          localArrayList.add(localQCallRecord2);
          localSparseIntArray.put(localQCallRecord1.getDate(), 0);
        }
        localArrayList.add(localQCallRecord1);
      }
    }
    paramList.clear();
    return localArrayList;
  }
  
  public void NR(boolean paramBoolean)
  {
    this.cxx = paramBoolean;
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).edit();
    localEditor.putBoolean("Conversation_call_prompt_flag", false);
    localEditor.commit();
  }
  
  public List<QCallRecent> a(alkq.a arg1)
  {
    ThreadManager.post(new QCallProxy.5(this, ???), 5, null, false);
    synchronized (this.Fa)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.Fa.iterator();
      while (localIterator.hasNext())
      {
        QCallRecent localQCallRecent = (QCallRecent)localIterator.next();
        if ((localQCallRecent == null) || (localQCallRecent.uin == null) || (localQCallRecent.uin.length() < 2)) {
          aqft.printCallStack("QCallProxy");
        }
        if ((localQCallRecent != null) && (localQCallRecent.uin != null) && (localQCallRecent.uin.length() >= 2)) {
          localArrayList.add(localQCallRecent);
        }
      }
    }
    return localList;
  }
  
  public void a(QCallRecord paramQCallRecord)
  {
    if (paramQCallRecord == null) {
      return;
    }
    for (;;)
    {
      synchronized (c(paramQCallRecord.friendUin, paramQCallRecord.uinType))
      {
        String str = u(paramQCallRecord.friendUin, paramQCallRecord.uinType);
        List localList = (List)this.ag.get(str);
        if (localList == null)
        {
          localList = s(paramQCallRecord.friendUin, paramQCallRecord.uinType);
          localList.add(paramQCallRecord);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("insertRecord ThreadName:").append(Thread.currentThread().getName()).append(" insertRecord records size:");
            if (localList != null)
            {
              i = localList.size();
              QLog.d("QCallProxy", 2, i);
            }
          }
          else
          {
            this.ag.put(str, y(localList));
            a(paramQCallRecord);
            return;
          }
          int i = 0;
        }
      }
    }
  }
  
  public boolean atJ()
  {
    return (this.cxx) && (this.Fa.size() > 0);
  }
  
  public QCallRecent b(String paramString, int paramInt)
  {
    synchronized (this.mA)
    {
      QCallRecent localQCallRecent2 = (QCallRecent)this.mA.get(at(paramString, paramInt));
      QCallRecent localQCallRecent1 = localQCallRecent2;
      if (localQCallRecent2 == null)
      {
        localQCallRecent1 = new QCallRecent();
        localQCallRecent1.uin = paramString;
        localQCallRecent1.type = paramInt;
        localQCallRecent1.displayName = localQCallRecent1.uin;
      }
      return localQCallRecent1;
    }
  }
  
  public void b(QCallRecent paramQCallRecent)
  {
    a(paramQCallRecent, false);
  }
  
  public QCallRecent c(String paramString, int paramInt)
  {
    synchronized (this.mA)
    {
      paramString = (QCallRecent)this.mA.get(at(paramString, paramInt));
      return paramString;
    }
  }
  
  public void clearCache()
  {
    if (this.ag != null) {
      this.ag.clear();
    }
  }
  
  public void d(QCallRecent paramQCallRecent)
  {
    synchronized (this.Fa)
    {
      this.Fa.remove(paramQCallRecent);
      this.mA.remove(at(paramQCallRecent.uin, paramQCallRecent.type));
      this.a.addMsgQueueDonotNotify(paramQCallRecent.uin, paramQCallRecent.type, paramQCallRecent.getTableName(), paramQCallRecent, 5, null);
      return;
    }
  }
  
  public void dGw()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCallProxy", 2, "recentDoInit ====start====");
    }
    this.cxx = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getBoolean("Conversation_call_prompt_flag", true);
    EntityManager localEntityManager = this.app.a().createEntityManager();
    List localList2;
    Object localObject5;
    Object localObject4;
    try
    {
      List localList1 = localEntityManager.query(QCallRecent.class, false, null, null, null, null, "lastCallTime desc", null);
      localList2 = this.Fa;
      if (localList1 == null) {
        break label515;
      }
      long l1;
      boolean bool;
      Object localObject1;
      label284:
      try
      {
        if (localList1.size() <= 0) {
          break label515;
        }
        localObject5 = localList1;
        if (localList1.size() > 100)
        {
          l1 = System.currentTimeMillis();
          localObject4 = localList1;
        }
      }
      finally {}
    }
    finally
    {
      localEntityManager.close();
    }
    try
    {
      bool = localEntityManager.execSQL("delete from" + "recent_call" + " where lastCallTime < " + ((QCallRecent)localList1.get(90)).lastCallTime + ";");
      localObject1 = localList1;
      if (bool)
      {
        localObject4 = localList1;
        localObject1 = new ArrayList(localList1.subList(0, 90));
      }
      localObject5 = localObject1;
      localObject4 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject4 = localObject1;
        long l2 = System.currentTimeMillis();
        localObject4 = localObject1;
        QLog.d("QCallProxy", 2, "doInit cache data > 100 isOk = " + bool + ",time:" + (l2 - l1));
        localObject5 = localObject1;
      }
    }
    catch (Exception localException)
    {
      localObject5 = localObject4;
      if (!QLog.isDevelopLevel()) {
        break label284;
      }
      QLog.e("QCallProxy", 4, localException.getMessage(), localException);
      localObject5 = localObject4;
      break label284;
      localIterator = this.Fa.iterator();
    }
    this.Fa.clear();
    localObject1 = ((List)localObject5).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject4 = (QCallRecent)((Iterator)localObject1).next();
        if ((((QCallRecent)localObject4).state == 5) || (((QCallRecent)localObject4).state == 6) || (((QCallRecent)localObject4).state == 7) || (((QCallRecent)localObject4).state == 1)) {
          ((QCallRecent)localObject4).state = 0;
        }
        if ((((QCallRecent)localObject4).uin != null) && (((QCallRecent)localObject4).uin.length() >= 2)) {
          this.Fa.add(localObject4);
        }
      }
      else
      {
        Iterator localIterator;
        while (localIterator.hasNext())
        {
          localObject4 = (QCallRecent)localIterator.next();
          this.mA.put(at(((QCallRecent)localObject4).uin, ((QCallRecent)localObject4).type), localObject4);
        }
      }
    }
    label515:
    if (QLog.isDevelopLevel()) {
      QLog.d("QCallProxy", 4, this.Fa.toString());
    }
    localEntityManager.close();
    if (QLog.isColorLevel()) {
      QLog.d("QCallProxy", 2, "recentDoInit ====end====");
    }
  }
  
  public void dGx()
  {
    synchronized (this.Fa)
    {
      this.Fa.clear();
      this.mA.clear();
      return;
    }
  }
  
  protected void destory()
  {
    if ((this.em != null) && (this.em.isOpen())) {
      this.em.close();
    }
    dGx();
    clearCache();
    mIsInit = false;
  }
  
  public void e(QCallRecent paramQCallRecent)
  {
    if (paramQCallRecent.getStatus() == 1000)
    {
      this.a.addMsgQueueDonotNotify(paramQCallRecent.uin, paramQCallRecent.type, paramQCallRecent.getTableName(), paramQCallRecent, 3, null);
      return;
    }
    this.a.addMsgQueueDonotNotify(paramQCallRecent.uin, paramQCallRecent.type, paramQCallRecent.getTableName(), paramQCallRecent, 4, null);
  }
  
  public void f(QCallRecent paramQCallRecent)
  {
    a(paramQCallRecent, true);
  }
  
  public void fF(String paramString, int paramInt)
  {
    Object localObject = u(paramString, paramInt);
    localObject = (List)this.ag.get(localObject);
    if (localObject != null) {
      ((List)localObject).clear();
    }
    ag(paramString, paramInt);
  }
  
  public List<QCallRecent> fO()
  {
    return a(null);
  }
  
  public void g(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (!u(paramString1, paramInt1).equals(u(paramString2, paramInt2)))
    {
      Object localObject = s(paramString1, paramInt1);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          QCallRecord localQCallRecord = (QCallRecord)((Iterator)localObject).next();
          localQCallRecord.friendUin = paramString2;
          localQCallRecord.uinType = paramInt2;
          a(localQCallRecord);
        }
        fF(paramString1, paramInt1);
      }
    }
  }
  
  protected void init()
  {
    if (mIsInit) {
      return;
    }
    mIsInit = true;
    ThreadManager.excute(new QCallProxy.1(this), 32, null, true);
  }
  
  public List<QCallRecord> s(String paramString, int paramInt)
  {
    String str = u(paramString, paramInt);
    Object localObject = c(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("QCallProxy", 2, "getListRecord ThreadName:" + Thread.currentThread().getName() + " getListRecord friendUin:" + paramString + ",uinType:" + paramInt);
    }
    try
    {
      List localList = (List)this.ag.get(str);
      if (localList != null) {
        return localList;
      }
      localList = u(paramString, paramInt);
      paramString = localList;
      if (localList == null) {
        paramString = new ArrayList();
      }
      if (QLog.isColorLevel())
      {
        QLog.d("QCallProxy", 2, "getListRecord ThreadName:" + Thread.currentThread().getName() + " getListRecord (DB) records size:" + paramString.size());
        QLog.d("QCallProxy", 2, "getListRecord" + paramString);
      }
      paramString = y(paramString);
      this.ag.put(str, paramString);
      return paramString;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void lS(List<QCallRecent> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alkq
 * JD-Core Version:    0.7.0.1
 */