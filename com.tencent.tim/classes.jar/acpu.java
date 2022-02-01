import android.os.SystemClock;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class acpu
{
  acpx jdField_a_of_type_Acpx = new acpx();
  acpy jdField_a_of_type_Acpy;
  FullMessageSearchResult jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult;
  Set<String> bY = new HashSet();
  Object cI = new Object();
  int cyX = 0;
  volatile int cyY = 0;
  private QQAppInterface mApp;
  String mKey;
  volatile int searchType = 0;
  List<Object> xX = new ArrayList();
  
  acpu(QQAppInterface paramQQAppInterface, String paramString, acpy paramacpy)
  {
    this.mApp = paramQQAppInterface;
    this.mKey = paramString;
    this.jdField_a_of_type_Acpy = paramacpy;
  }
  
  private Pair<Boolean, Integer> a(String paramString, List<FullMessageSearchResult.SearchResultItem> paramList, RecentUser paramRecentUser, long paramLong, QQMessageFacade.Message paramMessage)
  {
    try
    {
      if (acpz.a(this.mApp, paramRecentUser))
      {
        long l1 = SystemClock.uptimeMillis();
        paramString = this.mApp.a(paramRecentUser.getType()).a(paramRecentUser.uin, paramRecentUser.getType(), paramString, acpz.czd, this);
        long l2 = SystemClock.uptimeMillis();
        if ((this.cyY == 2) || (this.cyY == 3)) {
          return new Pair(Boolean.valueOf(true), Integer.valueOf(2));
        }
        acpx localacpx = this.jdField_a_of_type_Acpx;
        localacpx.cza += 1;
        localacpx = this.jdField_a_of_type_Acpx;
        localacpx.totalTime = (l2 - l1 + localacpx.totalTime);
        if ((paramString != null) && (((paramString.secondPageList != null) && (paramString.secondPageList.size() > 0)) || ((paramString.secondPageMessageUniseq != null) && (paramString.secondPageMessageUniseq.size() > 0))))
        {
          paramString.user = paramRecentUser;
          paramString.lastMessage = paramMessage;
          paramList.add(paramList.size(), paramString);
        }
      }
      if ((this.searchType == 0) && (SystemClock.uptimeMillis() - paramLong > acpz.czf))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.FullMessageSearchTask", 2, "queryHistroyByUser timeout! " + acpz.czf);
        }
        paramString = new Pair(Boolean.valueOf(true), Integer.valueOf(3));
        return paramString;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.FullMessageSearchTask", 2, "queryHistroyByUser oom!");
      }
      return new Pair(Boolean.valueOf(true), Integer.valueOf(3));
    }
    if (SystemClock.uptimeMillis() - paramLong > acpz.cze)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.FullMessageSearchTask", 2, "queryHistroyByUser timeout! " + acpz.cze);
      }
      return new Pair(Boolean.valueOf(true), Integer.valueOf(3));
    }
    paramString = new Pair(Boolean.valueOf(false), Integer.valueOf(0));
    return paramString;
  }
  
  private FullMessageSearchResult a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.FullMessageSearchTask", 2, "startTask " + this);
    }
    start(paramInt);
    if ((this.mKey == null) || (this.mKey.trim().length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.FullMessageSearchTask", 2, "queryAllHistroyByKey key is null!");
      }
      return null;
    }
    long l = SystemClock.uptimeMillis();
    Object localObject = this.mApp.a().a().q(false);
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      if ((localRecentUser.getType() != 0) && (localRecentUser.getType() != 1) && (localRecentUser.getType() != 3000)) {
        localIterator.remove();
      }
    }
    Collections.sort((List)localObject, new acpv(this));
    if (localObject != null) {
      this.xX.addAll((Collection)localObject);
    }
    localObject = (acff)this.mApp.getManager(51);
    if (localObject != null)
    {
      localObject = ((acff)localObject).cs();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.FullMessageSearchTask", 2, "friends size = " + ((List)localObject).size());
      }
      this.xX.addAll((Collection)localObject);
      localObject = ((acdu)this.mApp.getManager(53)).getDiscussList();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.FullMessageSearchTask", 2, "discussions size = " + ((List)localObject).size());
      }
      this.xX.addAll((Collection)localObject);
      localObject = (TroopManager)this.mApp.getManager(52);
      if (localObject == null) {
        break label428;
      }
    }
    label428:
    for (localObject = ((TroopManager)localObject).cE();; localObject = new ArrayList())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.FullMessageSearchTask", 2, "troops size = " + ((List)localObject).size());
      }
      this.xX.addAll((Collection)localObject);
      return a(l);
      localObject = new ArrayList();
      break;
    }
  }
  
  private FullMessageSearchResult a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.FullMessageSearchTask", 2, "queryAllHistroyByKey ,task=" + this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult = new FullMessageSearchResult();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.xW == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.xW = new ArrayList();
    }
    Object localObject3;
    Object localObject2;
    label129:
    label331:
    long l;
    anpc localanpc;
    if (this.cyX < this.xX.size())
    {
      localObject3 = this.xX.get(this.cyX);
      localObject2 = new RecentUser();
      if ((localObject3 instanceof RecentUser))
      {
        localObject1 = (RecentUser)localObject3;
        localObject2 = top.u(((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType());
        if (!this.bY.contains(localObject2)) {
          break label331;
        }
      }
      do
      {
        this.cyX += 1;
        break;
        if ((localObject3 instanceof Friends))
        {
          localObject1 = (Friends)localObject3;
          ((RecentUser)localObject2).uin = ((Friends)localObject1).uin;
          ((RecentUser)localObject2).setType(0);
          ((RecentUser)localObject2).displayName = ((Friends)localObject1).getFriendNickWithAlias();
          localObject1 = localObject2;
          break label129;
        }
        if ((localObject3 instanceof DiscussionInfo))
        {
          localObject1 = (DiscussionInfo)localObject3;
          ((RecentUser)localObject2).uin = ((DiscussionInfo)localObject1).uin;
          ((RecentUser)localObject2).setType(3000);
          ((RecentUser)localObject2).displayName = aqgv.b(this.mApp, BaseApplicationImpl.getApplication(), ((DiscussionInfo)localObject1).uin);
          localObject1 = localObject2;
          break label129;
        }
        localObject1 = localObject2;
        if (!(localObject3 instanceof TroopInfo)) {
          break label129;
        }
        localObject1 = (TroopInfo)localObject3;
        ((RecentUser)localObject2).uin = ((TroopInfo)localObject1).troopuin;
        ((RecentUser)localObject2).setType(1);
        ((RecentUser)localObject2).displayName = ((TroopInfo)localObject1).troopname;
        localObject1 = localObject2;
        break label129;
        this.bY.add(localObject2);
        localObject2 = this.mApp.b().c(((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType());
        if (localObject2 != null) {
          break label813;
        }
        l = 0L;
        ((RecentUser)localObject1).lastmsgtime = l;
        int i = this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.xW.size();
        localObject2 = a(this.mKey, this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.xW, (RecentUser)localObject1, paramLong, (QQMessageFacade.Message)localObject2);
        if (this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.xW.size() != i) {
          this.jdField_a_of_type_Acpy.a(this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult);
        }
      } while (!((Boolean)((Pair)localObject2).first).booleanValue());
      if (((Integer)((Pair)localObject2).second).intValue() == 3)
      {
        pause();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.FullMessageSearchTask", 2, "finish search scs=" + this.jdField_a_of_type_Acpx.toString() + ",searchType=" + this.searchType + ",searchStatus=" + this.cyY + ",searchFinFlag=" + ((Pair)localObject2).second);
        }
        if (this.jdField_a_of_type_Acpx.cyZ > 0)
        {
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("queryMessageSize", Integer.toString(this.jdField_a_of_type_Acpx.cyZ));
          ((HashMap)localObject3).put("queryConversationSize", Integer.toString(this.jdField_a_of_type_Acpx.cza));
          ((HashMap)localObject3).put("resultSize", Integer.toString(this.jdField_a_of_type_Acpx.czb));
          ((HashMap)localObject3).put("keyLength", Integer.toString(this.mKey.length()));
          localanpc = anpc.a(BaseApplication.getContext());
          if (this.searchType != 1) {
            break label823;
          }
        }
      }
    }
    label813:
    label823:
    for (Object localObject1 = "SearchMessageStatistic";; localObject1 = "RecentSearchStatistic")
    {
      localanpc.collectPerformance(null, (String)localObject1, false, this.jdField_a_of_type_Acpx.totalTime, 0L, (HashMap)localObject3, null);
      this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.cyW = ((Integer)((Pair)localObject2).second).intValue();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.FullMessageSearchTask", 2, "pause " + this);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.FullMessageSearchTask", 2, "queryAllHistroyByKey search result=" + this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.toString());
      }
      if ((this.cyY != 2) && (this.cyY != 3))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.cyW = 1;
        sm(1);
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult;
      l = ((QQMessageFacade.Message)localObject2).time;
      break;
    }
  }
  
  /* Error */
  public FullMessageSearchResult a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 154
    //   10: iconst_2
    //   11: new 156	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 447
    //   21: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: getfield 45	acpu:cyY	I
    //   38: ifne +12 -> 50
    //   41: aload_0
    //   42: invokevirtual 449	acpu:c	()Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult;
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: areturn
    //   50: aload_0
    //   51: getfield 45	acpu:cyY	I
    //   54: iconst_2
    //   55: if_icmpeq +11 -> 66
    //   58: aload_0
    //   59: getfield 45	acpu:cyY	I
    //   62: iconst_1
    //   63: if_icmpne +24 -> 87
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 45	acpu:cyY	I
    //   71: aload_0
    //   72: iconst_1
    //   73: putfield 43	acpu:searchType	I
    //   76: aload_0
    //   77: invokestatic 73	android/os/SystemClock:uptimeMillis	()J
    //   80: invokespecial 278	acpu:a	(J)Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult;
    //   83: astore_1
    //   84: goto -38 -> 46
    //   87: aload_0
    //   88: getfield 45	acpu:cyY	I
    //   91: iconst_3
    //   92: if_icmpne +11 -> 103
    //   95: aload_0
    //   96: getfield 282	acpu:jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult	Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult;
    //   99: astore_1
    //   100: goto -54 -> 46
    //   103: aconst_null
    //   104: astore_1
    //   105: goto -59 -> 46
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	acpu
    //   45	60	1	localFullMessageSearchResult	FullMessageSearchResult
    //   108	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	108	finally
    //   34	46	108	finally
    //   50	66	108	finally
    //   66	84	108	finally
    //   87	100	108	finally
  }
  
  /* Error */
  public FullMessageSearchResult b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 154
    //   10: iconst_2
    //   11: new 156	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 451
    //   21: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: getfield 45	acpu:cyY	I
    //   38: iconst_2
    //   39: if_icmpeq +11 -> 50
    //   42: aload_0
    //   43: getfield 45	acpu:cyY	I
    //   46: iconst_1
    //   47: if_icmpne +12 -> 59
    //   50: aload_0
    //   51: invokevirtual 453	acpu:a	()Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult;
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: areturn
    //   59: aload_0
    //   60: getfield 45	acpu:cyY	I
    //   63: iconst_3
    //   64: if_icmpne +11 -> 75
    //   67: aload_0
    //   68: getfield 282	acpu:jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult	Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult;
    //   71: astore_1
    //   72: goto -17 -> 55
    //   75: aload_0
    //   76: iconst_0
    //   77: invokespecial 455	acpu:a	(I)Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult;
    //   80: astore_1
    //   81: goto -26 -> 55
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	acpu
    //   54	27	1	localFullMessageSearchResult	FullMessageSearchResult
    //   84	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	84	finally
    //   34	50	84	finally
    //   50	55	84	finally
    //   59	72	84	finally
    //   75	81	84	finally
  }
  
  /* Error */
  public FullMessageSearchResult c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 154
    //   10: iconst_2
    //   11: new 156	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 457
    //   21: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: getfield 45	acpu:cyY	I
    //   38: ifne +13 -> 51
    //   41: aload_0
    //   42: iconst_1
    //   43: invokespecial 455	acpu:a	(I)Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult;
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: areturn
    //   51: aload_0
    //   52: getfield 45	acpu:cyY	I
    //   55: iconst_2
    //   56: if_icmpeq +11 -> 67
    //   59: aload_0
    //   60: getfield 45	acpu:cyY	I
    //   63: iconst_1
    //   64: if_icmpne +11 -> 75
    //   67: aload_0
    //   68: invokevirtual 453	acpu:a	()Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult;
    //   71: astore_1
    //   72: goto -25 -> 47
    //   75: aload_0
    //   76: getfield 45	acpu:cyY	I
    //   79: iconst_3
    //   80: if_icmpne +11 -> 91
    //   83: aload_0
    //   84: getfield 282	acpu:jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult	Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult;
    //   87: astore_1
    //   88: goto -41 -> 47
    //   91: aconst_null
    //   92: astore_1
    //   93: goto -46 -> 47
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	acpu
    //   46	47	1	localFullMessageSearchResult	FullMessageSearchResult
    //   96	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	96	finally
    //   34	47	96	finally
    //   51	67	96	finally
    //   67	72	96	finally
    //   75	88	96	finally
  }
  
  public void pause()
  {
    synchronized (this.cI)
    {
      if (this.cyY == 1) {
        this.cyY = 2;
      }
      return;
    }
  }
  
  public void sm(int paramInt)
  {
    for (;;)
    {
      synchronized (this.cI)
      {
        if (this.cyY == 3) {
          return;
        }
        if (this.cyY == 1) {
          this.cyY = 3;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.FullMessageSearchTask", 2, "finish search scs=" + this.jdField_a_of_type_Acpx.toString() + ",searchType=" + this.searchType + ",searchStatus=" + this.cyY + ",searchFinFlag=" + paramInt);
        }
        if ((this.jdField_a_of_type_Acpx.cyZ > 0) && (this.cyY == 3) && (paramInt == 1))
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("queryMessageSize", Integer.toString(this.jdField_a_of_type_Acpx.cyZ));
          localHashMap.put("queryConversationSize", Integer.toString(this.jdField_a_of_type_Acpx.cza));
          localHashMap.put("resultSize", Integer.toString(this.jdField_a_of_type_Acpx.czb));
          localHashMap.put("keyLength", Integer.toString(this.mKey.length()));
          anpc localanpc = anpc.a(BaseApplication.getContext());
          if (this.searchType == 1)
          {
            String str1 = "SearchMessageStatistic";
            localanpc.collectPerformance(null, str1, true, this.jdField_a_of_type_Acpx.totalTime, 0L, localHashMap, null);
          }
        }
        else
        {
          return;
        }
      }
      String str2 = "RecentSearchStatistic";
    }
  }
  
  void start(int paramInt)
  {
    try
    {
      this.cyX = 0;
      this.xX.clear();
      this.bY.clear();
      this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult = null;
      this.cyY = 1;
      this.searchType = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SearchStatus:");
    localStringBuilder.append("key=");
    localStringBuilder.append(this.mKey);
    localStringBuilder.append(",searchConvList.size=");
    localStringBuilder.append(this.xX.size());
    localStringBuilder.append(",searchIndex=");
    localStringBuilder.append(this.cyX);
    localStringBuilder.append(",SearchType=");
    localStringBuilder.append(this.searchType);
    localStringBuilder.append(",SearchStatus=");
    localStringBuilder.append(this.cyY);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acpu
 * JD-Core Version:    0.7.0.1
 */