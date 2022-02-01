import QQService.AddDiscussMemberInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<LQQService.AddDiscussMemberInfo;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class acdu
  implements Manager
{
  private QQAppInterface app;
  private boolean bHl;
  public Set<String> bL = Collections.synchronizedSet(new HashSet());
  private ConcurrentHashMap<String, DiscussionInfo> dN = new QQConcurrentHashMap(1016, 0, 350);
  private ConcurrentHashMap<String, DiscussionInfo> dO = new QQConcurrentHashMap(1022, 0, 350);
  private EntityManager em;
  private QQLruCache<String, Map<String, DiscussionMemberInfo>> g = new QQLruCache(2006, 100, 130);
  public Map<String, String[]> jj = new ConcurrentHashMap();
  ArrayList<DiscussionInfo> sZ = new ArrayList();
  
  public acdu(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.em = paramQQAppInterface.a().createEntityManager();
  }
  
  private void cIo()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "initDisscussCache begin");
    }
    localObject2 = (ArrayList)this.em.query(DiscussionInfo.class, false, null, null, null, null, null, null);
    if (localObject2 != null) {}
    ConcurrentHashMap localConcurrentHashMap;
    ArrayList localArrayList;
    for (int i = ((ArrayList)localObject2).size();; i = 0)
    {
      localConcurrentHashMap = new ConcurrentHashMap(i);
      if (localObject2 == null) {
        break label309;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "initDisscussCache disList.size: " + ((ArrayList)localObject2).size());
      }
      localArrayList = new ArrayList(10);
      i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((ArrayList)localObject2).get(i);
        localConcurrentHashMap.put(localDiscussionInfo.uin, localDiscussionInfo);
        if (aqgv.b(this.app, localDiscussionInfo))
        {
          Map localMap = n(localDiscussionInfo.uin);
          if (aqgv.a(this.app, localDiscussionInfo.uin, localDiscussionInfo, localMap, false)) {
            localArrayList.add(localDiscussionInfo);
          }
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "initDisscussCache, updateList=" + localArrayList.size());
    }
    if (localArrayList.size() > 0)
    {
      localObject2 = this.em.getTransaction();
      ((EntityTransaction)localObject2).begin();
      i = j;
    }
    try
    {
      while (i < localArrayList.size())
      {
        a((Entity)localArrayList.get(i));
        i += 1;
      }
      ((EntityTransaction)localObject2).commit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ((EntityTransaction)localObject2).end();
      }
    }
    finally
    {
      ((EntityTransaction)localObject2).end();
    }
    localArrayList.clear();
    label309:
    this.dN.putAll(localConcurrentHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "initDisscussCache end: " + localConcurrentHashMap.size());
    }
  }
  
  private void cIp()
  {
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.contacttab.dscs", 1, "buildDiscussUI, begin, discussList[" + this.sZ.size() + "], hideDiscussCache[" + this.dO.size() + "]");
        }
        QQConcurrentHashMap localQQConcurrentHashMap = new QQConcurrentHashMap(1022, 0, 350);
        localArrayList = new ArrayList();
        if (this.dN == null) {
          break;
        }
        int i = this.dN.size();
        if (i <= 0) {
          break;
        }
        localArrayList.ensureCapacity(i);
        Iterator localIterator = this.dN.values().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)localIterator.next();
        if ((localDiscussionInfo.mCompareSpell == null) || (localDiscussionInfo.mCompareSpell.length() == 0)) {
          acdb.c(localDiscussionInfo);
        }
        if (localDiscussionInfo.isHidden()) {
          localQQConcurrentHashMap.put(localDiscussionInfo.uin, localDiscussionInfo);
        } else {
          localArrayList.add(localDiscussionInfo);
        }
      }
      finally {}
    }
    try
    {
      this.sZ = localArrayList;
      this.dO = localObject1;
      if (QLog.isColorLevel()) {
        QLog.w("Q.contacttab.dscs", 1, "buildDiscussUI, end, discussList[" + this.sZ.size() + "], hideDiscussCache[" + this.dO.size() + "]");
      }
      return;
    }
    finally {}
  }
  
  public ArrayList<String> A(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = this.em.query(DiscussionMemberInfo.class, false, "discussionUin=?", new String[] { paramString }, null, null, "memberUin", String.valueOf(5));
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        localArrayList.add(((DiscussionMemberInfo)paramString.next()).memberUin);
      }
    }
    for (paramString = GroupIconHelper.ac(localArrayList);; paramString = localArrayList)
    {
      if (paramString.isEmpty()) {
        paramString.add(this.app.getCurrentAccountUin());
      }
      return paramString;
    }
  }
  
  public int Aq()
  {
    int j;
    if (this.bHl)
    {
      Iterator localIterator = this.sZ.iterator();
      int i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label52;
      }
      if (!((DiscussionInfo)localIterator.next()).hasCollect) {
        break label54;
      }
      i += 1;
    }
    label52:
    label54:
    for (;;)
    {
      break;
      j = 0;
      return j;
    }
  }
  
  public DiscussionInfo a(String paramString)
  {
    return a(paramString, false);
  }
  
  public DiscussionInfo a(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    if (!DiscussionInfo.isValidDisUin(paramString)) {
      localObject2 = null;
    }
    Object localObject1;
    do
    {
      return localObject2;
      localObject2 = (DiscussionInfo)this.dN.get(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!paramBoolean)
        {
          localObject1 = localObject2;
          if (!this.bHl)
          {
            localObject2 = (DiscussionInfo)this.em.find(DiscussionInfo.class, paramString);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder().append("findDiscussionInfoByID db ");
              if (localObject2 == null) {
                break;
              }
              paramBoolean = true;
              QLog.d("Q.contacttab.dscs", 2, paramBoolean);
            }
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              this.dN.put(paramString, localObject2);
              localObject1 = localObject2;
            }
          }
        }
      }
      localObject2 = localObject1;
    } while (!QLog.isColorLevel());
    Object localObject2 = new StringBuilder().append("findDiscussionInfoByID, discussionID[").append(paramString).append("], isDiscussCacheInited[").append(this.bHl).append("], discussionInfo[");
    if (localObject1 != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject2 = ((StringBuilder)localObject2).append(paramBoolean).append("], hideDiscussCache[");
      paramBoolean = bool;
      if (this.dO.get(paramString) != null) {
        paramBoolean = true;
      }
      QLog.w("Q.contacttab.dscs", 1, paramBoolean + "]");
      return localObject1;
      paramBoolean = false;
      break;
    }
  }
  
  @Nullable
  protected DiscussionInfo a(@NonNull List<AddDiscussMemberInfo> paramList)
  {
    Object localObject = new ArrayList();
    Iterator localIterator1 = this.dN.entrySet().iterator();
    label242:
    label248:
    for (;;)
    {
      DiscussionInfo localDiscussionInfo;
      if (localIterator1.hasNext())
      {
        localDiscussionInfo = (DiscussionInfo)((Map.Entry)localIterator1.next()).getValue();
        if (!localDiscussionInfo.isDiscussHrMeeting())
        {
          Map localMap = n(localDiscussionInfo.uin);
          if ((localMap != null) && (paramList.size() + 1 == localMap.size()))
          {
            Iterator localIterator2 = paramList.iterator();
            do
            {
              if (!localIterator2.hasNext()) {
                break;
              }
            } while (localMap.containsKey(String.valueOf(((AddDiscussMemberInfo)localIterator2.next()).getUin())));
          }
        }
      }
      else
      {
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label248;
          }
          ((ArrayList)localObject).add(localDiscussionInfo);
          break;
          if (((ArrayList)localObject).size() == 0) {
            return null;
          }
          if (((ArrayList)localObject).size() == 1) {
            return (DiscussionInfo)((ArrayList)localObject).get(0);
          }
          long l = 0L;
          localIterator1 = ((ArrayList)localObject).iterator();
          paramList = null;
          if (localIterator1.hasNext())
          {
            localObject = (DiscussionInfo)localIterator1.next();
            if (((DiscussionInfo)localObject).createTime <= l) {
              break label242;
            }
            l = ((DiscussionInfo)localObject).createTime;
            paramList = (List<AddDiscussMemberInfo>)localObject;
          }
          for (;;)
          {
            break;
            return paramList;
          }
        }
      }
    }
  }
  
  public DiscussionMemberInfo a(String paramString1, String paramString2)
  {
    Object localObject = null;
    paramString1 = n(paramString1);
    if (paramString1 != null) {
      paramString1 = (DiscussionMemberInfo)paramString1.get(paramString2);
    }
    do
    {
      return paramString1;
      paramString1 = localObject;
    } while (!QLog.isColorLevel());
    QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfo null");
    return null;
  }
  
  public DiscussionMemberInfo a(byte[] paramArrayOfByte, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      paramString1 = null;
    }
    do
    {
      do
      {
        DiscussionInfo localDiscussionInfo;
        do
        {
          return paramString1;
          paramString2 = a(paramString1, paramString2);
          localDiscussionInfo = a(paramString1);
          if (localDiscussionInfo == null) {
            break;
          }
          paramString1 = paramString2;
        } while (localDiscussionInfo.isDiscussHrMeeting());
        paramString1 = paramString2;
      } while (paramString2 == null);
      paramArrayOfByte = new String(paramArrayOfByte);
      if (paramString2.inteRemark == null) {
        break;
      }
      paramString1 = paramString2;
    } while (paramString2.inteRemark.equals(paramArrayOfByte));
    paramString2.inteRemark = paramArrayOfByte;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.equals(paramString2.memberName))) {}
    for (paramString2.inteRemarkSource = 129L;; paramString2.inteRemarkSource = 128L)
    {
      paramString1 = paramString2;
      if (!paramBoolean) {
        break;
      }
      a(paramString2);
      return paramString2;
    }
  }
  
  public Map<String, ArrayList<DiscussionMemberInfo>> a(String[] paramArrayOfString)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localHashMap.put(paramArrayOfString[i], new ArrayList());
      i += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("discussionUin in (");
    i = 0;
    while (i < paramArrayOfString.length)
    {
      if (i != 0) {
        ((StringBuilder)localObject).append(",");
      }
      ((StringBuilder)localObject).append("?");
      i += 1;
    }
    ((StringBuilder)localObject).append(")");
    String[] arrayOfString = new String[paramArrayOfString.length];
    i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = SecurityUtile.encode(paramArrayOfString[i]);
      i += 1;
    }
    paramArrayOfString = this.em.query(DiscussionMemberInfo.class, false, ((StringBuilder)localObject).toString(), arrayOfString, "memberUin", null, "memberUin", null);
    if (paramArrayOfString != null)
    {
      paramArrayOfString = paramArrayOfString.iterator();
      while (paramArrayOfString.hasNext())
      {
        localObject = (DiscussionMemberInfo)paramArrayOfString.next();
        ((List)localHashMap.get(((DiscussionMemberInfo)localObject).discussionUin)).add(localObject);
      }
    }
    return localHashMap;
  }
  
  public void a(DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    if (paramDiscussionMemberInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "saveDiscussionMemberInfo " + paramDiscussionMemberInfo);
      }
      Map localMap = n(paramDiscussionMemberInfo.discussionUin);
      if (localMap != null) {
        localMap.put(paramDiscussionMemberInfo.memberUin, paramDiscussionMemberInfo);
      }
      a(paramDiscussionMemberInfo);
      DiscussionInfo localDiscussionInfo = a(paramDiscussionMemberInfo.discussionUin);
      if ((localDiscussionInfo != null) && (aqgv.a(this.app, paramDiscussionMemberInfo.discussionUin, localDiscussionInfo, localMap, false))) {
        a(localDiscussionInfo);
      }
    }
  }
  
  /* Error */
  public void a(String paramString, DiscussionInfo paramDiscussionInfo, long paramLong1, Map<String, DiscussionMemberInfo> paramMap, long paramLong2)
  {
    // Byte code:
    //   0: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +57 -> 60
    //   6: ldc_w 414
    //   9: iconst_2
    //   10: new 119	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 416
    //   20: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc_w 418
    //   30: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 5
    //   35: invokeinterface 332 1 0
    //   40: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: ldc_w 420
    //   46: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: lload 6
    //   51: invokevirtual 423	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   54: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: aload_0
    //   61: getfield 47	acdu:g	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   64: aload_1
    //   65: aload 5
    //   67: invokevirtual 424	com/tencent/commonsdk/cache/QQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: checkcast 331	java/util/Map
    //   73: astore 9
    //   75: aload 9
    //   77: ifnull +57 -> 134
    //   80: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +51 -> 134
    //   86: ldc 96
    //   88: iconst_2
    //   89: new 119	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 426
    //   99: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 9
    //   104: invokeinterface 332 1 0
    //   109: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: ldc_w 428
    //   115: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload 5
    //   120: invokeinterface 332 1 0
    //   125: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: new 54	java/util/HashSet
    //   137: dup
    //   138: invokespecial 55	java/util/HashSet:<init>	()V
    //   141: astore 10
    //   143: aload_0
    //   144: getfield 84	acdu:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   147: invokevirtual 169	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   150: astore 9
    //   152: aload 9
    //   154: invokevirtual 174	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   157: aload 5
    //   159: invokeinterface 429 1 0
    //   164: invokeinterface 320 1 0
    //   169: astore 11
    //   171: aload 11
    //   173: invokeinterface 223 1 0
    //   178: ifeq +141 -> 319
    //   181: aload 11
    //   183: invokeinterface 227 1 0
    //   188: checkcast 322	java/util/Map$Entry
    //   191: invokeinterface 325 1 0
    //   196: checkcast 250	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   199: astore 12
    //   201: new 119	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   208: aload 12
    //   210: getfield 404	com/tencent/mobileqq/data/DiscussionMemberInfo:discussionUin	Ljava/lang/String;
    //   213: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc_w 431
    //   219: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload 12
    //   224: getfield 263	com/tencent/mobileqq/data/DiscussionMemberInfo:memberUin	Ljava/lang/String;
    //   227: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: astore 13
    //   235: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +30 -> 268
    //   241: ldc 96
    //   243: iconst_2
    //   244: new 119	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   251: ldc_w 433
    //   254: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload 13
    //   259: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: aload 10
    //   270: aload 13
    //   272: invokevirtual 436	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   275: ifne -104 -> 171
    //   278: aload 10
    //   280: aload 13
    //   282: invokevirtual 437	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   285: pop
    //   286: aload_0
    //   287: aload 12
    //   289: invokevirtual 179	acdu:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   292: pop
    //   293: goto -122 -> 171
    //   296: astore_1
    //   297: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +13 -> 313
    //   303: ldc 96
    //   305: iconst_2
    //   306: ldc_w 439
    //   309: aload_1
    //   310: invokestatic 442	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   313: aload 9
    //   315: invokevirtual 185	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   318: return
    //   319: aload_0
    //   320: getfield 70	acdu:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   323: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   326: ifnull +77 -> 403
    //   329: aload_0
    //   330: getfield 70	acdu:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   333: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   336: new 250	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   339: dup
    //   340: invokespecial 447	com/tencent/mobileqq/data/DiscussionMemberInfo:<init>	()V
    //   343: invokevirtual 450	com/tencent/mobileqq/data/DiscussionMemberInfo:getTableName	()Ljava/lang/String;
    //   346: ldc_w 452
    //   349: iconst_2
    //   350: anewarray 232	java/lang/String
    //   353: dup
    //   354: iconst_0
    //   355: aload_1
    //   356: aastore
    //   357: dup
    //   358: iconst_1
    //   359: lload 6
    //   361: invokestatic 341	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   364: aastore
    //   365: invokevirtual 458	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   368: istore 8
    //   370: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   373: ifeq +30 -> 403
    //   376: ldc 96
    //   378: iconst_2
    //   379: new 119	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   386: ldc_w 460
    //   389: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: iload 8
    //   394: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: aload_0
    //   404: getfield 70	acdu:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   407: aload_1
    //   408: aload_2
    //   409: aload 5
    //   411: iconst_0
    //   412: invokestatic 159	aqgv:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/data/DiscussionInfo;Ljava/util/Map;Z)Z
    //   415: pop
    //   416: aload_2
    //   417: lload_3
    //   418: putfield 463	com/tencent/mobileqq/data/DiscussionInfo:infoSeq	J
    //   421: aload_0
    //   422: aload_2
    //   423: invokevirtual 465	acdu:d	(Lcom/tencent/mobileqq/data/DiscussionInfo;)V
    //   426: aload 9
    //   428: invokevirtual 182	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   431: aload 9
    //   433: invokevirtual 185	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   436: return
    //   437: astore_1
    //   438: aload 9
    //   440: invokevirtual 185	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   443: aload_1
    //   444: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	acdu
    //   0	445	1	paramString	String
    //   0	445	2	paramDiscussionInfo	DiscussionInfo
    //   0	445	3	paramLong1	long
    //   0	445	5	paramMap	Map<String, DiscussionMemberInfo>
    //   0	445	6	paramLong2	long
    //   368	25	8	i	int
    //   73	366	9	localObject	Object
    //   141	138	10	localHashSet	HashSet
    //   169	13	11	localIterator	Iterator
    //   199	89	12	localDiscussionMemberInfo	DiscussionMemberInfo
    //   233	48	13	str	String
    // Exception table:
    //   from	to	target	type
    //   157	171	296	java/lang/Exception
    //   171	268	296	java/lang/Exception
    //   268	293	296	java/lang/Exception
    //   319	403	296	java/lang/Exception
    //   403	431	296	java/lang/Exception
    //   157	171	437	finally
    //   171	268	437	finally
    //   268	293	437	finally
    //   297	313	437	finally
    //   319	403	437	finally
    //   403	431	437	finally
  }
  
  public void a(String paramString, Set<String> paramSet)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "deleteDiscussionMembers disuin=" + paramString);
    }
    if ((!DiscussionInfo.isValidDisUin(paramString)) || (paramSet == null) || (paramSet.size() == 0)) {}
    for (;;)
    {
      return;
      EntityTransaction localEntityTransaction = this.em.getTransaction();
      try
      {
        localEntityTransaction.begin();
        localMap = n(paramString);
        if (localMap != null)
        {
          localStringBuilder = new StringBuilder(paramSet.size() * 8);
          if (QLog.isColorLevel()) {
            localStringBuilder.append("remove member=");
          }
          paramSet = paramSet.iterator();
          while (paramSet.hasNext())
          {
            String str = (String)paramSet.next();
            DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localMap.remove(str);
            if (localDiscussionMemberInfo != null)
            {
              this.em.remove(localDiscussionMemberInfo);
              if (QLog.isColorLevel()) {
                localStringBuilder.append(str.substring(0, 4)).append("|");
              }
            }
          }
        }
      }
      catch (Exception paramSet)
      {
        Map localMap;
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, "deleteDiscussionMembers exp disUin=" + paramString, paramSet);
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, localStringBuilder.toString());
        }
        paramSet = a(paramString);
        if (aqgv.a(this.app, paramString, paramSet, localMap, false)) {
          this.em.update(paramSet);
        }
        localEntityTransaction.commit();
        return;
      }
      finally
      {
        if (localEntityTransaction != null) {
          localEntityTransaction.end();
        }
      }
    }
  }
  
  public boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.em.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.em.update(paramEntity);
  }
  
  boolean a(ArrayList<DiscussionInfo> paramArrayList, long paramLong, boolean paramBoolean)
  {
    EntityTransaction localEntityTransaction = this.em.getTransaction();
    label298:
    for (;;)
    {
      try
      {
        localEntityTransaction.begin();
        int i;
        DiscussionInfo localDiscussionInfo;
        if ((paramArrayList != null) && (paramArrayList.size() > 0))
        {
          i = 0;
          if (i < paramArrayList.size())
          {
            localDiscussionInfo = (DiscussionInfo)paramArrayList.get(i);
            this.dN.put(localDiscussionInfo.uin, localDiscussionInfo);
            a(localDiscussionInfo);
            if (!QLog.isColorLevel()) {
              break label298;
            }
            QLog.d("Q.contacttab.dscs", 2, "disUin=" + localDiscussionInfo.uin.substring(0, 4) + " has been updated");
            break label298;
          }
        }
        if (paramBoolean)
        {
          paramArrayList = this.dN.entrySet().iterator();
          if (paramArrayList.hasNext())
          {
            localDiscussionInfo = (DiscussionInfo)((Map.Entry)paramArrayList.next()).getValue();
            if (localDiscussionInfo.timeSec >= paramLong) {
              continue;
            }
            paramArrayList.remove();
            this.em.remove(localDiscussionInfo);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.contacttab.dscs", 2, "disUin=" + localDiscussionInfo.uin.substring(0, 4) + " has been removed");
            continue;
          }
        }
        i += 1;
      }
      catch (Exception paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.contacttab.dscs", 2, "saveAllDiscussions exception:", paramArrayList);
        }
        localEntityTransaction.end();
        paramBoolean = false;
        cIp();
        return paramBoolean;
        localEntityTransaction.commit();
        localEntityTransaction.end();
        paramBoolean = true;
      }
      finally
      {
        localEntityTransaction.end();
      }
    }
  }
  
  public boolean au(String paramString1, String paramString2)
  {
    boolean bool = false;
    if ((ArrayList)this.em.query(DiscussionMemberInfo.class, false, "discussionUin=? and memberUin=?", new String[] { paramString1, paramString2 }, null, null, "memberUin", null) != null) {
      bool = true;
    }
    return bool;
  }
  
  public void cIn()
  {
    cIo();
    cIp();
    this.bHl = true;
  }
  
  public int cn(String paramString)
  {
    paramString = n(paramString);
    if (paramString != null) {
      return paramString.size();
    }
    return 0;
  }
  
  public void d(DiscussionInfo paramDiscussionInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("saveDiscussInfo ");
      if (paramDiscussionInfo == null) {
        break label48;
      }
    }
    label48:
    for (Object localObject1 = paramDiscussionInfo.uin;; localObject1 = Integer.valueOf(-1))
    {
      QLog.d("Q.contacttab.dscs", 2, localObject1);
      if (paramDiscussionInfo != null) {
        break;
      }
      return;
    }
    if (this.dN != null) {
      this.dN.put(paramDiscussionInfo.uin, paramDiscussionInfo);
    }
    a(paramDiscussionInfo);
    localObject1 = this.app.a();
    Object localObject2 = ((ProxyManager)localObject1).a().a(paramDiscussionInfo.uin, 3000);
    if (((RecentUser)localObject2).getStatus() == 1001)
    {
      ((RecentUser)localObject2).displayName = paramDiscussionInfo.discussionName;
      ((ProxyManager)localObject1).a().e((RecentUser)localObject2);
    }
    cIp();
  }
  
  public void e(DiscussionInfo paramDiscussionInfo)
  {
    if ((paramDiscussionInfo != null) && (this.sZ != null))
    {
      Iterator localIterator = this.sZ.iterator();
      while (localIterator.hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)localIterator.next();
        if (localDiscussionInfo.uin.equals(paramDiscussionInfo.uin)) {
          localDiscussionInfo.hasCollect = paramDiscussionInfo.hasCollect;
        }
      }
    }
  }
  
  public void eG(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "deleteDiscussionMember disUin=" + paramString1 + " memberUin=" + paramString2);
    }
    Object localObject1 = (Map)this.g.get(paramString1);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (DiscussionMemberInfo)((Map)localObject1).remove(paramString2);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        if ("removed from cache " + localObject2 == null) {
          break label181;
        }
        localObject1 = "true";
        QLog.d("Q.contacttab.dscs", 2, (String)localObject1);
      }
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (DiscussionMemberInfo)this.em.find(DiscussionMemberInfo.class, new String[] { paramString1, paramString2 });
      }
      if (localObject2 != null)
      {
        this.em.remove((Entity)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, "removed from db ");
        }
      }
      return;
      label181:
      localObject1 = "false";
      break;
    }
  }
  
  /* Error */
  public void eH(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 96
    //   8: iconst_2
    //   9: new 119	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 579
    //   19: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 581
    //   29: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_1
    //   43: invokestatic 586	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifeq +4 -> 50
    //   49: return
    //   50: aload_0
    //   51: getfield 84	acdu:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   54: invokevirtual 169	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 174	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   62: aload_0
    //   63: getfield 84	acdu:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   66: ldc 250
    //   68: iconst_0
    //   69: ldc_w 588
    //   72: iconst_1
    //   73: anewarray 232	java/lang/String
    //   76: dup
    //   77: iconst_0
    //   78: aload_1
    //   79: aastore
    //   80: aconst_null
    //   81: aconst_null
    //   82: ldc 254
    //   84: aconst_null
    //   85: invokevirtual 110	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   88: checkcast 65	java/util/ArrayList
    //   91: astore 4
    //   93: aload 4
    //   95: ifnull +174 -> 269
    //   98: aload 4
    //   100: invokevirtual 114	java/util/ArrayList:size	()I
    //   103: ifle +166 -> 269
    //   106: aload 4
    //   108: invokevirtual 281	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   111: astore 4
    //   113: aload 4
    //   115: invokeinterface 223 1 0
    //   120: ifeq +149 -> 269
    //   123: aload 4
    //   125: invokeinterface 227 1 0
    //   130: checkcast 250	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   133: getfield 404	com/tencent/mobileqq/data/DiscussionMemberInfo:discussionUin	Ljava/lang/String;
    //   136: astore 5
    //   138: aload_0
    //   139: aload 5
    //   141: invokevirtual 360	acdu:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   144: astore 6
    //   146: aload_0
    //   147: aload 5
    //   149: invokevirtual 156	acdu:n	(Ljava/lang/String;)Ljava/util/Map;
    //   152: astore 7
    //   154: aload 7
    //   156: ifnull +45 -> 201
    //   159: aload 7
    //   161: aload_1
    //   162: invokeinterface 353 2 0
    //   167: checkcast 250	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   170: astore 8
    //   172: aload 8
    //   174: ifnull +27 -> 201
    //   177: aload 8
    //   179: aload_2
    //   180: putfield 366	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   183: aload 8
    //   185: ldc2_w 381
    //   188: putfield 377	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemarkSource	J
    //   191: aload_0
    //   192: getfield 84	acdu:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   195: aload 8
    //   197: invokevirtual 489	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   200: pop
    //   201: aload 6
    //   203: ifnull -90 -> 113
    //   206: aload 6
    //   208: aload 6
    //   210: getfield 591	com/tencent/mobileqq/data/DiscussionInfo:DiscussionFlag	J
    //   213: ldc2_w 592
    //   216: lor
    //   217: putfield 591	com/tencent/mobileqq/data/DiscussionInfo:DiscussionFlag	J
    //   220: aload_0
    //   221: getfield 70	acdu:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   224: aload 5
    //   226: aload 6
    //   228: aload 7
    //   230: iconst_0
    //   231: invokestatic 159	aqgv:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/data/DiscussionInfo;Ljava/util/Map;Z)Z
    //   234: ifeq -121 -> 113
    //   237: aload_0
    //   238: aload 6
    //   240: invokevirtual 179	acdu:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   243: pop
    //   244: goto -131 -> 113
    //   247: astore_1
    //   248: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq +13 -> 264
    //   254: ldc 96
    //   256: iconst_2
    //   257: ldc_w 595
    //   260: aload_1
    //   261: invokestatic 597	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   264: aload_3
    //   265: invokevirtual 185	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   268: return
    //   269: aload_3
    //   270: invokevirtual 182	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   273: aload_3
    //   274: invokevirtual 185	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   277: return
    //   278: astore_1
    //   279: aload_3
    //   280: invokevirtual 185	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   283: aload_1
    //   284: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	this	acdu
    //   0	285	1	paramString1	String
    //   0	285	2	paramString2	String
    //   57	223	3	localEntityTransaction	EntityTransaction
    //   91	33	4	localObject	Object
    //   136	89	5	str	String
    //   144	95	6	localDiscussionInfo	DiscussionInfo
    //   152	77	7	localMap	Map
    //   170	26	8	localDiscussionMemberInfo	DiscussionMemberInfo
    // Exception table:
    //   from	to	target	type
    //   58	93	247	java/lang/Exception
    //   98	113	247	java/lang/Exception
    //   113	154	247	java/lang/Exception
    //   159	172	247	java/lang/Exception
    //   177	201	247	java/lang/Exception
    //   206	244	247	java/lang/Exception
    //   269	273	247	java/lang/Exception
    //   58	93	278	finally
    //   98	113	278	finally
    //   113	154	278	finally
    //   159	172	278	finally
    //   177	201	278	finally
    //   206	244	278	finally
    //   248	264	278	finally
    //   269	273	278	finally
  }
  
  public ArrayList<DiscussionInfo> getDiscussList()
  {
    if (!this.bHl) {
      cIn();
    }
    return this.sZ;
  }
  
  public void iG(List<String> paramList)
  {
    auvk.traceBegin("queryDiscs_" + paramList.size());
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "preloadData size=" + paramList.size());
    }
    if (paramList.size() > 0)
    {
      Object localObject = new StringBuilder("uin=? ");
      int i = 1;
      while (i < paramList.size())
      {
        ((StringBuilder)localObject).append("or uin=? ");
        i += 1;
      }
      paramList = this.em.query(DiscussionInfo.class, true, ((StringBuilder)localObject).toString(), (String[])paramList.toArray(new String[paramList.size()]), null, null, null, null);
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (DiscussionInfo)paramList.next();
          this.dN.put(((DiscussionInfo)localObject).uin, localObject);
        }
      }
    }
    auvk.traceEnd();
  }
  
  public void iH(List<DiscussionMemberInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "saveDiscussionMemberInfoList");
    }
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    if (paramList.size() == 1)
    {
      a((DiscussionMemberInfo)paramList.get(0));
      return;
    }
    HashSet localHashSet = new HashSet();
    EntityTransaction localEntityTransaction = this.em.getTransaction();
    localEntityTransaction.begin();
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localStringBuffer = new StringBuffer();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramList.next();
            String str = localDiscussionMemberInfo.discussionUin + "_" + localDiscussionMemberInfo.memberUin;
            if (QLog.isColorLevel())
            {
              localStringBuffer.append(str);
              localStringBuffer.append(";");
            }
            if (localHashSet.contains(str)) {
              continue;
            }
            a(localDiscussionMemberInfo);
            localHashSet.add(str);
            continue;
          }
        }
        StringBuffer localStringBuffer = null;
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.contacttab.dscs", 2, "saveDiscussionMemberInfoList ex=", paramList);
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, "saveDiscussionMemberInfoList info=" + localStringBuffer.toString());
        }
        localEntityTransaction.commit();
        return;
      }
      finally
      {
        localEntityTransaction.end();
      }
    }
  }
  
  public boolean jT(String paramString)
  {
    DiscussionInfo localDiscussionInfo = a(paramString);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("hideDiscuss begin, uin[").append(paramString).append("], info[");
      if (localDiscussionInfo == null) {
        break label196;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      QLog.w("Q.contacttab.dscs", 1, bool + "], discussList[" + this.sZ.size() + "], hideDiscussCache[" + this.dO.size() + "]");
      if (localDiscussionInfo != null) {}
      label196:
      try
      {
        this.dO.put(localDiscussionInfo.uin, localDiscussionInfo);
        this.sZ.remove(localDiscussionInfo);
        if (QLog.isColorLevel()) {
          QLog.w("Q.contacttab.dscs", 1, "hideDiscuss end, uin[" + paramString + "], discussList[" + this.sZ.size() + "], hideDiscussCache[" + this.dO.size() + "]");
        }
        return true;
      }
      finally {}
    }
  }
  
  public boolean jU(String paramString)
  {
    boolean bool2 = false;
    DiscussionInfo localDiscussionInfo = a(paramString);
    Object localObject;
    boolean bool1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("reShowDiscuss begin, uin[").append(paramString).append("], info[");
      if (localDiscussionInfo != null)
      {
        bool1 = true;
        QLog.w("Q.contacttab.dscs", 1, bool1 + "], discussList[" + this.sZ.size() + "], hideDiscussCache[" + this.dO.size() + "]");
      }
    }
    else
    {
      if (localDiscussionInfo == null) {
        break label293;
      }
    }
    for (;;)
    {
      try
      {
        this.dO.remove(localDiscussionInfo.uin);
        localObject = this.sZ.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label288;
        }
        if (((DiscussionInfo)((Iterator)localObject).next()).uin != localDiscussionInfo.uin) {
          continue;
        }
        bool1 = true;
        if (!bool1) {
          this.sZ.add(localDiscussionInfo);
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder().append("reShowDiscuss end, uin[").append(paramString).append("], info[");
          if (localDiscussionInfo != null) {
            bool2 = true;
          }
          QLog.w("Q.contacttab.dscs", 1, bool2 + "], bExist[" + bool1 + "], discussList[" + this.sZ.size() + "], hideDiscussCache[" + this.dO.size() + "]");
        }
        return true;
      }
      finally {}
      bool1 = false;
      break;
      label288:
      bool1 = false;
      continue;
      label293:
      bool1 = false;
    }
  }
  
  public boolean jV(String paramString)
  {
    DiscussionInfo localDiscussionInfo = a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "deleteDiscuss uin=" + paramString);
    }
    if (localDiscussionInfo != null)
    {
      this.dN.remove(paramString);
      this.g.remove(paramString);
      paramString = "delete from DiscussionMemberInfo where discussionUin='" + paramString + "'";
      this.em.execSQL(paramString);
      this.em.remove(localDiscussionInfo);
      cIp();
    }
    return true;
  }
  
  public Map<String, DiscussionMemberInfo> n(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfoListByUin param is null");
      }
      return null;
    }
    Object localObject2 = (Map)this.g.get(paramString);
    Object localObject1;
    int i;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("getDiscussionMemberInfoListByUin from map list disUin=").append(paramString).append(" size=");
        if (localObject2 != null) {
          break label101;
        }
        i = -1;
        label82:
        QLog.d("Q.contacttab.dscs", 2, i);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      return localObject1;
      label101:
      i = ((Map)localObject2).size();
      break label82;
      localObject2 = this.em.query(DiscussionMemberInfo.class, false, "discussionUin=? ", new String[] { paramString }, null, null, "memberUin", null);
      if (localObject2 == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfoListByUin from DB list is null disUin=" + paramString);
        return null;
      }
      localObject1 = new HashMap(((List)localObject2).size());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject2).next();
        ((Map)localObject1).put(localDiscussionMemberInfo.memberUin, localDiscussionMemberInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfoListByUin from db list disUin=" + paramString + " size=" + ((Map)localObject1).size());
      }
      this.g.put(paramString, localObject1);
    }
  }
  
  public void onDestroy()
  {
    this.em.close();
  }
  
  public ArrayList<DiscussionMemberInfo> z(String paramString)
  {
    paramString = n(paramString);
    ArrayList localArrayList = new ArrayList();
    if ((paramString != null) && (paramString.size() > 0)) {
      localArrayList.addAll(paramString.values());
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acdu
 * JD-Core Version:    0.7.0.1
 */