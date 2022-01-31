package com.tencent.mobileqq.app.message;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.MsgQueueItem;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import cyn;
import cyo;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class MsgProxy
  extends BaseProxy
{
  public static final int a = -1;
  static final String jdField_a_of_type_JavaLangString = "Q.msg.MsgProxy";
  public static final int b = 1;
  public static final int c = 2;
  protected MessageRecordEntityManager a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public MsgProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager = null;
  }
  
  private int a(String paramString, int paramInt)
  {
    synchronized (MsgPool.a().a(paramString, paramInt))
    {
      List localList = d(paramString, paramInt);
      int i = 0;
      if (localList != null)
      {
        i = localList.size();
        localList.clear();
      }
      if (MsgPool.a().b().containsKey(a(paramString, paramInt))) {
        MsgPool.a().b().remove(a(paramString, paramInt));
      }
      return i;
    }
  }
  
  private QQMessageFacade.Message a(String paramString, EntityManager paramEntityManager, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a().size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramEntityManager);
    }
    int i;
    String str2;
    String str1;
    if ((paramString.startsWith("mr_discusssion")) || (paramString.startsWith("mr_troop")))
    {
      i = 1;
      boolean bool = paramString.endsWith("_New");
      str2 = "select m.*,(select count() from %s mr where mr.isread=0) as unReadNum,(select count() from %s mr where mr.issend=0) as hasReply from %s m where m.isValid=1 and m.msgtype " + MsgProxyUtils.a() + " and m.longMsgId='%d' and m.issend='%d' order by %s limit 1";
      if (!bool) {
        break label189;
      }
      if (i == 0) {
        break label182;
      }
      str1 = "longMsgIndex asc , shmsgseq desc , _id desc";
    }
    for (;;)
    {
      paramString = paramEntityManager.a(QQMessageFacade.Message.class, String.format(str2, new Object[] { paramString, paramString, paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1 }), null);
      if ((paramString == null) || (paramString.isEmpty())) {
        break label196;
      }
      return (QQMessageFacade.Message)paramString.get(0);
      i = 0;
      break;
      label182:
      str1 = "longMsgIndex asc , time desc , _id desc";
      continue;
      label189:
      str1 = "_id desc";
    }
    label196:
    return null;
  }
  
  private List a(List paramList)
  {
    paramList = new ArrayList(paramList);
    HashSet localHashSet = new HashSet();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      if (localHashSet.contains(((MessageRecord)paramList.get(i)).senderuin)) {
        paramList.remove(i);
      }
      for (;;)
      {
        i -= 1;
        break;
        localHashSet.add(((MessageRecord)paramList.get(i)).senderuin);
      }
    }
    Collections.reverse(paramList);
    return paramList;
  }
  
  public static List a(List paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if (localMessageRecord.time >= paramLong) {
        localArrayList.add(localMessageRecord);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void a(String paramString, int paramInt, Entity arg3)
  {
    Object localObject;
    synchronized (MsgPool.a().a(paramString, paramInt))
    {
      localObject = d(paramString, paramInt);
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "setMsgRead " + localMessageRecord.getBaseInfoString());
        }
        if (!localMessageRecord.isread) {
          localMessageRecord.isread = true;
        }
      }
    }
    paramString = f(paramString, paramInt);
    if ((paramString == null) || (paramString.isEmpty())) {
      return;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      localObject = (MessageRecord)paramString.next();
      if (!((MessageRecord)localObject).isread) {
        ((MessageRecord)localObject).isread = true;
      }
    }
  }
  
  private boolean a()
  {
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        Iterator localIterator = MsgPool.a().a().keySet().iterator();
        StringBuilder localStringBuilder = null;
        if (!localIterator.hasNext()) {
          break label401;
        }
        String str = (String)localIterator.next();
        if (((str != null) && (MsgPool.a().b().keySet().contains(str))) || ((str != null) && (MsgProxyUtils.b(str)))) {
          continue;
        }
        if (str != null)
        {
          List localList = (List)MsgPool.a().a().get(str);
          localObject4 = str;
          localObject5 = localList;
          if (localList != null)
          {
            localObject4 = str;
            localObject5 = localList;
            if (localList.size() > 0)
            {
              localObject4 = (MessageRecord)localList.get(0);
              if (a(((MessageRecord)localObject4).frienduin, ((MessageRecord)localObject4).istroop, true)) {
                continue;
              }
              localObject4 = str;
              localObject5 = localList;
              if (localStringBuilder == null) {
                break label381;
              }
              if (localStringBuilder.size() == 0)
              {
                localObject4 = str;
                localObject5 = localList;
                break label381;
              }
              if ((localList == null) || (localList.size() <= 0)) {
                break label391;
              }
              localObject4 = str;
              localObject5 = localList;
              if (((MessageRecord)localList.get(localList.size() - 1)).time < ((MessageRecord)localStringBuilder.get(localStringBuilder.size() - 1)).time) {
                break label381;
              }
              break label391;
            }
          }
          if (localObject4 != null)
          {
            MsgPool.a().a().remove(localObject4);
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder().append("MsgPool.getPoolInstance().getMsgPool().remove:").append((String)localObject4).append(",time=");
              if ((localObject5 == null) || (((List)localObject5).size() <= 0)) {
                continue;
              }
              l = ((MessageRecord)((List)localObject5).get(((List)localObject5).size() - 1)).time;
              QLog.d("Q.msg.MsgProxy", 2, l);
            }
          }
          return true;
          long l = 0L;
          continue;
          localObject3 = localObject4;
        }
      }
      finally {}
      label381:
      Object localObject2;
      for (;;)
      {
        localObject2 = localObject5;
        break;
        label391:
        localObject4 = localObject3;
        localObject5 = localObject2;
      }
      label401:
      Object localObject4 = localObject3;
      Object localObject5 = localObject2;
    }
  }
  
  private int b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    synchronized (MsgPool.a().a(paramString, paramInt))
    {
      paramString = d(paramString, paramInt);
      paramInt = 0;
      if (paramString != null)
      {
        paramInt = paramString.size();
        Object localObject2 = new ArrayList();
        ((List)localObject2).addAll(paramString);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
          if ((localMessageRecord.time >= paramLong1) && (localMessageRecord.time <= paramLong2) && (MsgProxyUtils.b(localMessageRecord.msgtype))) {
            paramString.remove(localMessageRecord);
          }
        }
      }
    }
    c();
    return paramInt;
  }
  
  /* Error */
  private void b(String paramString, int paramInt, List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 36	com/tencent/mobileqq/app/message/MsgPool:a	()Lcom/tencent/mobileqq/app/message/MsgPool;
    //   5: invokevirtual 225	com/tencent/mobileqq/app/message/MsgPool:a	()Ljava/util/concurrent/ConcurrentHashMap;
    //   8: invokevirtual 269	java/util/concurrent/ConcurrentHashMap:size	()I
    //   11: istore 4
    //   13: getstatic 272	com/tencent/mobileqq/app/message/MsgProxyUtils:a	[Ljava/lang/String;
    //   16: arraylength
    //   17: istore 5
    //   19: iload 4
    //   21: iload 5
    //   23: bipush 40
    //   25: iadd
    //   26: if_icmple +45 -> 71
    //   29: iconst_0
    //   30: istore 7
    //   32: aload_0
    //   33: invokespecial 274	com/tencent/mobileqq/app/message/MsgProxy:a	()Z
    //   36: istore 6
    //   38: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +30 -> 71
    //   44: ldc 10
    //   46: iconst_2
    //   47: new 104	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   54: ldc_w 276
    //   57: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload 6
    //   62: invokevirtual 279	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: invokestatic 36	com/tencent/mobileqq/app/message/MsgPool:a	()Lcom/tencent/mobileqq/app/message/MsgPool;
    //   74: invokevirtual 225	com/tencent/mobileqq/app/message/MsgPool:a	()Ljava/util/concurrent/ConcurrentHashMap;
    //   77: aload_0
    //   78: aload_1
    //   79: iload_2
    //   80: invokevirtual 58	com/tencent/mobileqq/app/message/MsgProxy:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   83: aload_3
    //   84: invokevirtual 283	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload_0
    //   89: monitorexit
    //   90: return
    //   91: astore 8
    //   93: iload 7
    //   95: istore 6
    //   97: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq -62 -> 38
    //   103: ldc 10
    //   105: iconst_2
    //   106: ldc_w 285
    //   109: aload 8
    //   111: invokestatic 289	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   114: iload 7
    //   116: istore 6
    //   118: goto -80 -> 38
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	MsgProxy
    //   0	126	1	paramString	String
    //   0	126	2	paramInt	int
    //   0	126	3	paramList	List
    //   11	16	4	i	int
    //   17	9	5	j	int
    //   36	81	6	bool1	boolean
    //   30	85	7	bool2	boolean
    //   91	19	8	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   32	38	91	java/lang/Exception
    //   2	19	121	finally
    //   32	38	121	finally
    //   38	71	121	finally
    //   71	88	121	finally
    //   97	114	121	finally
  }
  
  private void b(List paramList, ProxyListener paramProxyListener)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (localMessageRecord.versionCode > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "proxy addSync id=" + localMessageRecord.vipBubbleID);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(localMessageRecord.frienduin, localMessageRecord.istroop, MessageRecord.getTableName(localMessageRecord.frienduin, localMessageRecord.istroop), localMessageRecord, 0, paramProxyListener);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
  }
  
  private List c(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (a(paramString1, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    String str1;
    String str2;
    if (paramInt2 > 0)
    {
      str1 = "limit " + paramInt2;
      str2 = "select * from " + MessageRecord.getTableName(paramString1, paramInt1) + " where time<%d %s order by time desc, _id desc %s";
      if (paramString2 != null) {
        break label272;
      }
    }
    label272:
    for (paramString2 = "";; paramString2 = "and " + paramString2)
    {
      paramString2 = String.format(str2, new Object[] { Long.valueOf(paramLong), paramString2, str1 });
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTime: sql=" + paramString2 + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      paramString2 = a().a(paramString2, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramString2 != null) {
        Collections.reverse(paramString2);
      }
      if (paramString2 == null) {
        break label298;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTime: list size =" + paramString2.size() + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      return paramString2;
      str1 = "";
      break;
    }
    label298:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTime: null list , peeruin = " + paramString1 + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  private MessageRecord e(String paramString, int paramInt, long paramLong)
  {
    Object localObject2 = MsgPool.a().a(paramString, paramInt);
    List localList = null;
    for (;;)
    {
      Object localObject1;
      try
      {
        Object localObject3 = d(paramString, paramInt);
        localObject1 = localList;
        if (localObject3 != null)
        {
          Iterator localIterator = ((List)localObject3).iterator();
          localObject1 = localList;
          if (localIterator.hasNext())
          {
            localObject1 = (MessageRecord)localIterator.next();
            if (((MessageRecord)localObject1).getId() != paramLong) {
              continue;
            }
            ((List)localObject3).remove(localObject1);
          }
        }
        localList = f(paramString, paramInt);
        if (localList != null)
        {
          localObject3 = localList.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            paramString = (MessageRecord)((Iterator)localObject3).next();
            if (paramString.getId() != paramLong) {
              continue;
            }
            localList.remove(paramString);
            return paramString;
          }
        }
      }
      finally {}
      paramString = (String)localObject1;
    }
  }
  
  protected int a(int paramInt)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      synchronized (MsgPool.a().a(AppConstants.al, paramInt))
      {
        Object localObject2 = d(AppConstants.al, 4001);
        if (localObject2 != null)
        {
          int k = ((List)localObject2).size() - 1;
          i = j;
          j = k;
          if (j >= 0)
          {
            if (((MessageRecord)((List)localObject2).get(j)).msgtype == paramInt)
            {
              ((List)localObject2).remove(j);
              i += 1;
            }
          }
          else {
            a(String.valueOf(AppConstants.al), 4001, MessageRecord.getTableName(String.valueOf(AppConstants.al), 4001), "msgtype=?", new String[] { String.valueOf(paramInt) }, null);
          }
        }
        else
        {
          if ((localObject2 != null) && (((List)localObject2).size() == 0) && (GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) <= 0))
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
            RecentUser localRecentUser = ((RecentUserProxy)localObject2).a(AppConstants.aj, 9000);
            if (localRecentUser != null) {
              ((RecentUserProxy)localObject2).b(localRecentUser);
            }
          }
          return i;
        }
      }
      j -= 1;
    }
  }
  
  protected int a(int paramInt, QQMessageFacade.Message paramMessage)
  {
    int i = 0;
    String str = String.valueOf(AppConstants.al);
    label305:
    label308:
    for (;;)
    {
      synchronized (MsgPool.a().a(str, 4001))
      {
        localObject2 = d(str, 4001);
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
          return 0;
        }
        localObject2 = ((List)localObject2).iterator();
        MessageRecord localMessageRecord;
        if (((Iterator)localObject2).hasNext())
        {
          localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "setRecommendMsgReaded " + localMessageRecord.getBaseInfoString());
          }
          if ((localMessageRecord.msgtype != paramInt) || (localMessageRecord.isread)) {
            break label305;
          }
          localMessageRecord.isread = true;
          i += 1;
          break label308;
        }
        localObject2 = f(str, 4001);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          localObject2 = ((List)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
            if ((localMessageRecord.msgtype != paramInt) || (localMessageRecord.isread)) {
              continue;
            }
            localMessageRecord.isread = true;
          }
        }
      }
      Object localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("isread", Boolean.valueOf(true));
      a(str, 4001, paramMessage.versionCode, (ContentValues)localObject2, "msgtype=? and isread=?", new String[] { String.valueOf(paramInt), "0" }, null);
      return i;
    }
  }
  
  protected int a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return -1;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("--->deleteC2CMsgByMessageRecord : peerUin:").append(paramMessageRecord.frienduin).append(" type:").append(paramMessageRecord.istroop).append(" uniseq:").append(paramMessageRecord.uniseq).append(" mr:").append(paramMessageRecord).append(" dbid:");
      if (paramMessageRecord != null)
      {
        localObject = Long.valueOf(paramMessageRecord.getId());
        QLog.d("Q.msg.MsgProxy", 2, localObject);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label192;
      }
      e(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getId());
      label126:
      long l = paramMessageRecord.getId();
      if (l <= 0L) {
        break label212;
      }
      a(paramMessageRecord.frienduin, paramMessageRecord.istroop, MessageRecord.getTableName(paramMessageRecord.frienduin, paramMessageRecord.istroop), "_id=?", new String[] { String.valueOf(l) }, null);
    }
    for (;;)
    {
      if (!paramMessageRecord.isread)
      {
        return 2;
        localObject = "mr is null.";
        break;
        label192:
        c(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
        break label126;
        label212:
        if (paramMessageRecord.uniseq != 0L) {
          a(paramMessageRecord.frienduin, paramMessageRecord.istroop, MessageRecord.getTableName(paramMessageRecord.frienduin, paramMessageRecord.istroop), "uniseq=?", new String[] { String.valueOf(paramMessageRecord.uniseq) }, null);
        } else {
          return -1;
        }
      }
    }
    return 1;
  }
  
  protected int a(String paramString, int paramInt, long paramLong)
  {
    String str3 = MessageRecord.getTableName(paramString, paramInt);
    int i;
    String str1;
    if ((paramInt == 3000) || (paramInt == 1))
    {
      i = 1;
      if (i == 0) {
        break label162;
      }
      str1 = "shmsgseq desc , _id desc";
      label32:
      if (i == 0) {
        break label170;
      }
    }
    label162:
    label170:
    for (String str2 = "shmsgseq";; str2 = "time")
    {
      str1 = String.format("select m.*,(select count() from %s mr where mr.isread=0 and mr.issend='0' and mr.%s>'%d') as unReadNum from %s m where m.%s>'%d' order by %s limit 1", new Object[] { str3, str2, Long.valueOf(paramLong), str3, str2, Long.valueOf(paramLong), str1 });
      if (a(paramString, paramInt, true)) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
      }
      paramString = a().a(QQMessageFacade.Message.class, str1, null);
      if ((paramString == null) || (paramString.isEmpty())) {
        break label178;
      }
      return ((QQMessageFacade.Message)paramString.get(0)).unReadNum;
      i = 0;
      break;
      str1 = "time desc , _id desc";
      break label32;
    }
    label178:
    return 0;
  }
  
  protected int a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    String str = "time>=? and time<=? and msgtype " + MsgProxyUtils.c();
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(paramLong1);
    arrayOfString[1] = String.valueOf(paramLong2);
    int i = b(paramString, paramInt, paramLong1, paramLong2);
    a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), str, arrayOfString, null);
    a(paramString, paramInt, MessageRecord.getOldTableName(paramString, paramInt), str, arrayOfString, null);
    return i;
  }
  
  protected int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    int i = 0;
    String str1 = null;
    String str2 = MessageRecord.getTableName(paramString, paramInt);
    paramString = str1;
    if (MsgProxyUtils.a(paramInt))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager;
      str1 = "( msgtype " + MsgProxyUtils.b() + " and isValid=1 ) " + "and ( time < ? or (time = ? and longMsgIndex <= ? and _id <= ?))";
      long l1 = paramMessageRecord.time;
      long l2 = paramMessageRecord.time;
      paramInt = paramMessageRecord.longMsgIndex;
      long l3 = paramMessageRecord.getId();
      paramString = paramString.a(false, str2, new String[] { "_id" }, str1, new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(paramInt), String.valueOf(l3) }, null, null, null, null);
    }
    paramInt = i;
    if (paramString != null)
    {
      paramInt = paramString.getCount();
      paramString.close();
    }
    return paramInt;
  }
  
  protected int a(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = a(paramString, paramInt);
    if (paramBoolean)
    {
      a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), null, null, null);
      a(paramString, paramInt, MessageRecord.getOldTableName(paramString, paramInt), null, null, null);
    }
    return i;
  }
  
  @Deprecated
  public Cursor a(String paramString, int paramInt)
  {
    int j = 0;
    List localList = b(paramString, paramInt);
    if (paramString.equals(String.valueOf(AppConstants.Y)))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        localArrayList.add(localList.get(localList.size() - i - 1));
        i += 1;
      }
      new ArrayList();
      paramString = a(paramString, paramInt, 2147483647);
      if (paramString != null)
      {
        paramInt = j;
        while (paramInt < paramString.size())
        {
          localArrayList.add(paramString.get(paramString.size() - paramInt - 1));
          paramInt += 1;
        }
      }
      return new cyo(this, localArrayList);
    }
    return new cyo(this, (List)((ArrayList)localList).clone());
  }
  
  @Deprecated
  protected Cursor a(List paramList)
  {
    return new cyo(this, paramList);
  }
  
  protected QQMessageFacade.Message a(String paramString, EntityManager paramEntityManager)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a().size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramEntityManager);
    }
    int i;
    Object localObject2;
    Object localObject1;
    if ((paramString.startsWith("mr_discusssion")) || (paramString.startsWith("mr_troop")))
    {
      i = 1;
      boolean bool = paramString.endsWith("_New");
      localObject2 = "select m.*,(select count() from %s mr where mr.isread=0) as unReadNum,(select count() from %s mr where mr.issend=0) as hasReply from %s m where m.isValid=1 and m.msgtype " + MsgProxyUtils.a() + " order by %s limit 1";
      if (!bool) {
        break label223;
      }
      if (i == 0) {
        break label215;
      }
      localObject1 = "shmsgseq desc , _id desc";
    }
    for (;;)
    {
      localObject1 = paramEntityManager.a(QQMessageFacade.Message.class, String.format((String)localObject2, new Object[] { paramString, paramString, paramString, localObject1 }), null);
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        break label230;
      }
      localObject2 = (QQMessageFacade.Message)((List)localObject1).get(0);
      localObject1 = localObject2;
      if (((QQMessageFacade.Message)localObject2).isLongMsg())
      {
        localObject1 = localObject2;
        if (((QQMessageFacade.Message)localObject2).longMsgIndex > 0) {
          localObject1 = a(paramString, paramEntityManager, ((QQMessageFacade.Message)localObject2).longMsgId, ((QQMessageFacade.Message)localObject2).issend);
        }
      }
      return localObject1;
      i = 0;
      break;
      label215:
      localObject1 = "time desc , _id desc";
      continue;
      label223:
      localObject1 = "_id desc";
    }
    label230:
    return null;
  }
  
  protected ChatHistorySearchData a(Cursor paramCursor, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramCursor == null) || (paramCursor.getCount() == 0) || (paramSessionInfo == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    String str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
    int j = paramSessionInfo.jdField_a_of_type_Int;
    String str2 = paramString.toLowerCase(Locale.US);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramString = new HashSet();
    a(paramSessionInfo, str1, j, paramString);
    HashSet localHashSet = new HashSet();
    paramString = paramString.iterator();
    Object localObject;
    while (paramString.hasNext())
    {
      str1 = (String)paramString.next();
      if (str1 != null)
      {
        localObject = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo, str1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), str1);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).toLowerCase(Locale.US).contains(str2))) {
          localHashSet.add(str1);
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getSearchResult, keyuins = " + localHashSet.toString());
    }
    if (paramCursor.isBeforeFirst()) {
      paramCursor.moveToFirst();
    }
    if (!paramCursor.isAfterLast())
    {
      paramString = a(paramCursor, paramSessionInfo, j);
      if ((TextUtils.isEmpty(paramString)) || (!localHashSet.contains(paramString))) {
        break label468;
      }
    }
    label465:
    label468:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
        str1 = "";
        paramString = str1;
        if (localObject != null) {
          paramString = str1;
        }
      }
      for (;;)
      {
        try
        {
          if (localObject.length > 0) {
            paramString = new String((byte[])localObject, "utf-8");
          }
          if (!paramString.toLowerCase(Locale.US).contains(str2)) {
            break label465;
          }
          i = 1;
          if (i != 0)
          {
            if (localArrayList1.size() >= 50) {
              continue;
            }
            paramString = (MessageRecord)this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a(MessageRecord.class, null, paramCursor);
            if (paramString != null) {
              localArrayList1.add(paramString);
            }
          }
          paramCursor.moveToNext();
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          paramString = "";
          continue;
          localArrayList2.add(Integer.valueOf(paramCursor.getInt(0)));
          continue;
        }
        if (localArrayList1.size() > 0)
        {
          paramCursor = new ChatHistorySearchData();
          paramCursor.mSearchData1 = localArrayList1;
          paramCursor.mSearchData2 = localArrayList2;
          return paramCursor;
        }
        return null;
      }
    }
  }
  
  /* Error */
  protected ChatHistorySearchData a(SessionInfo paramSessionInfo, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload 4
    //   5: astore_3
    //   6: aload_1
    //   7: ifnull +26 -> 33
    //   10: aload 4
    //   12: astore_3
    //   13: aload_1
    //   14: getfield 548	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: invokestatic 544	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +13 -> 33
    //   23: aload_2
    //   24: invokestatic 544	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifeq +8 -> 35
    //   30: aload 4
    //   32: astore_3
    //   33: aload_3
    //   34: areturn
    //   35: aload_1
    //   36: getfield 548	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   39: aload_1
    //   40: getfield 550	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   43: invokestatic 303	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   46: astore_3
    //   47: aload_0
    //   48: getfield 22	com/tencent/mobileqq/app/message/MsgProxy:jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager	Lcom/tencent/mobileqq/persistence/MessageRecordEntityManager;
    //   51: iconst_0
    //   52: aload_3
    //   53: aconst_null
    //   54: ldc_w 631
    //   57: iconst_1
    //   58: anewarray 91	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: sipush -1000
    //   66: invokestatic 363	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   69: aastore
    //   70: aconst_null
    //   71: aconst_null
    //   72: ldc_w 633
    //   75: aconst_null
    //   76: invokevirtual 488	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   79: astore 5
    //   81: aload_0
    //   82: aload 5
    //   84: aload_1
    //   85: aload_2
    //   86: invokevirtual 635	com/tencent/mobileqq/app/message/MsgProxy:a	(Landroid/database/Cursor;Lcom/tencent/mobileqq/activity/aio/SessionInfo;Ljava/lang/String;)Lcom/tencent/mobileqq/data/ChatHistorySearchData;
    //   89: astore_1
    //   90: aload_1
    //   91: astore_3
    //   92: aload 5
    //   94: ifnull -61 -> 33
    //   97: aload 5
    //   99: invokeinterface 496 1 0
    //   104: aload_1
    //   105: areturn
    //   106: astore_1
    //   107: aload 4
    //   109: astore_3
    //   110: aload 5
    //   112: ifnull -79 -> 33
    //   115: aload 5
    //   117: invokeinterface 496 1 0
    //   122: aconst_null
    //   123: areturn
    //   124: astore_1
    //   125: aload 5
    //   127: ifnull +10 -> 137
    //   130: aload 5
    //   132: invokeinterface 496 1 0
    //   137: aload_1
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	MsgProxy
    //   0	139	1	paramSessionInfo	SessionInfo
    //   0	139	2	paramString	String
    //   5	105	3	localObject1	Object
    //   1	107	4	localObject2	Object
    //   79	52	5	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   81	90	106	java/lang/Exception
    //   81	90	124	finally
  }
  
  protected MessageRecord a(MessageRecord paramMessageRecord, int paramInt, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    paramMessageRecord.msgtype = paramInt;
    ContentValues localContentValues;
    if (localMessageRecord != null)
    {
      localMessageRecord.msgtype = paramInt;
      localContentValues = new ContentValues();
      localContentValues.put("msgtype", Integer.valueOf(paramInt));
      if (localMessageRecord == null) {
        break label180;
      }
      if (localMessageRecord.getId() <= 0L) {
        break label137;
      }
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
    }
    for (;;)
    {
      return localMessageRecord;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.msg.MsgProxy", 2, "update : updateMessageType : set fail !");
      break;
      label137:
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      continue;
      label180:
      if (paramMessageRecord.getId() > 0L) {
        a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, null);
      }
    }
  }
  
  protected MessageRecord a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    paramMessageRecord.isValid = paramBoolean1;
    ContentValues localContentValues;
    if (localMessageRecord != null)
    {
      localMessageRecord.isValid = paramBoolean1;
      localContentValues = new ContentValues();
      localContentValues.put("isValid", Boolean.valueOf(paramBoolean1));
      if (localMessageRecord == null) {
        break label196;
      }
      if (localMessageRecord.getId() <= 0L) {
        break label153;
      }
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
      label116:
      if ((localMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)localMessageRecord).reParse();
      }
    }
    for (;;)
    {
      return localMessageRecord;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.msg.MsgProxy", 2, "update : setMessageIsValidFlag : set fail !");
      break;
      label153:
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      break label116;
      label196:
      if (paramMessageRecord.getId() > 0L) {
        a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, null);
      }
    }
  }
  
  protected MessageRecord a(String paramString, int paramInt)
  {
    synchronized (MsgPool.a().a(paramString, paramInt))
    {
      paramString = d(paramString, paramInt);
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        paramString = (MessageRecord)paramString.get(paramString.size() - 1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "getLastMsgFromList mr = " + paramString.getBaseInfoString());
        }
        return paramString;
      }
      return null;
    }
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong)
  {
    MessageRecord localMessageRecord2 = null;
    if ((paramLong == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    Iterator localIterator = b(paramString, paramInt).iterator();
    MessageRecord localMessageRecord1;
    do
    {
      localMessageRecord1 = localMessageRecord2;
      if (!localIterator.hasNext()) {
        break;
      }
      localMessageRecord1 = (MessageRecord)localIterator.next();
    } while (localMessageRecord1.uniseq != paramLong);
    if (localMessageRecord1 == null)
    {
      paramString = e(paramString, paramInt);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localMessageRecord2 = (MessageRecord)paramString.next();
          if (localMessageRecord2.uniseq == paramLong) {
            return localMessageRecord2;
          }
        }
      }
    }
    return localMessageRecord1;
  }
  
  protected MessageRecord a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt1, paramLong);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("extraflag", Integer.valueOf(paramInt2));
    localContentValues.put("sendFailCode", Integer.valueOf(paramInt3));
    if (localMessageRecord != null)
    {
      localMessageRecord.extraflag = paramInt2;
      localMessageRecord.sendFailCode = paramInt3;
      if (localMessageRecord.getId() > 0L) {
        a(paramString, paramInt1, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
      }
      for (;;)
      {
        if ((localMessageRecord instanceof ChatMessage)) {
          ((ChatMessage)localMessageRecord).reParse();
        }
        return localMessageRecord;
        a(paramString, paramInt1, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      }
    }
    a(paramString, paramInt1, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    return localMessageRecord;
  }
  
  protected MessageRecord a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong1);
    if (localMessageRecord != null)
    {
      localMessageRecord.time = paramLong2;
      int i = localMessageRecord.versionCode;
      if ((localMessageRecord.extraflag == 32772) || (localMessageRecord.extraflag == 32768))
      {
        localMessageRecord.extraflag = 0;
        localMessageRecord.sendFailCode = 0;
      }
      d(paramString, paramInt, paramLong1);
      a(paramString, paramInt, localMessageRecord);
      if (localMessageRecord.msgtype == -2005) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.uniseq, localMessageRecord.frienduin, localMessageRecord.istroop, paramLong2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "update msgTime set msg =" + localMessageRecord.getBaseInfoString());
      }
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("time", Long.valueOf(paramLong2));
    if ((localMessageRecord != null) && (localMessageRecord.extraflag == 0))
    {
      localContentValues.put("extraflag", Integer.valueOf(0));
      localContentValues.put("sendFailCode", Integer.valueOf(0));
    }
    if (localMessageRecord != null)
    {
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        return localMessageRecord;
      }
      a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
      return localMessageRecord;
    }
    a(paramString, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
    return localMessageRecord;
  }
  
  protected MessageRecord a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong1);
    if (localMessageRecord != null)
    {
      localMessageRecord.time = paramLong2;
      localMessageRecord.shmsgseq = paramLong3;
      d(paramString, paramInt, paramLong1);
      a(paramString, paramInt, localMessageRecord);
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("time", Long.valueOf(paramLong2));
    localContentValues.put("shmsgseq", Long.valueOf(paramLong3));
    if (localMessageRecord != null)
    {
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        return localMessageRecord;
      }
      a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
      return localMessageRecord;
    }
    a(paramString, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
    return localMessageRecord;
  }
  
  protected MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    if (paramString2 == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramString1, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    if ((localMessageRecord == null) || (localMessageRecord.versionCode > 0)) {}
    try
    {
      localContentValues.put("msgData", paramString2.getBytes("UTF-8"));
      label54:
      localMessageRecord.msg = paramString2;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "updateMsgContentByUniseq: set msg =" + localMessageRecord.getBaseInfoString());
      }
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString1, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        label139:
        if ((localMessageRecord instanceof ChatMessage)) {
          ((ChatMessage)localMessageRecord).reParse();
        }
      }
      for (;;)
      {
        return localMessageRecord;
        localContentValues.put("msg", paramString2);
        break;
        a(paramString1, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
        break label139;
        try
        {
          localContentValues.put("msgData", paramString2.getBytes("UTF-8"));
          label218:
          a(paramString1, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
        }
        catch (UnsupportedEncodingException paramString2)
        {
          break label218;
        }
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label54;
    }
  }
  
  protected MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    if (a(paramString1, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString2 = String.format("select * from " + MessageRecord.getTableName(paramString1, paramInt) + " where time=%d and senderuin=%s", new Object[] { Long.valueOf(paramLong), paramString2 });
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMsgByConstraints: sql=" + paramString2 + ", peeruin = " + paramString1 + ", type = " + paramInt);
    }
    paramString1 = a().a(paramString2, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramString1 != null)
    {
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (MessageRecord)paramString1.next();
        if (paramString2.msg.equals(paramString3)) {
          return paramString2;
        }
      }
    }
    return null;
  }
  
  protected MessageRecord a(String paramString1, int paramInt1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt2)
  {
    MessageRecord localMessageRecord = a(paramString1, paramInt1, paramLong1);
    if (localMessageRecord != null)
    {
      paramString3 = TransfileUtile.b(localMessageRecord.msg, paramString2, paramString3, paramLong2, paramInt2);
      localMessageRecord.msg = paramString3;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "updateMsgContentToForward: set msg =" + localMessageRecord.getBaseInfoString());
      }
      paramString2 = new ContentValues();
      if ((localMessageRecord.versionCode <= 0) || (paramString3 == null)) {
        break label174;
      }
    }
    try
    {
      paramString2.put("msgData", paramString3.getBytes("UTF-8"));
      label113:
      if (localMessageRecord.getId() > 0L) {
        a(paramString1, paramInt1, localMessageRecord.versionCode, paramString2, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
      }
      for (;;)
      {
        if ((localMessageRecord instanceof ChatMessage)) {
          ((ChatMessage)localMessageRecord).reParse();
        }
        return localMessageRecord;
        label174:
        paramString2.put("msg", paramString3);
        break;
        a(paramString1, paramInt1, localMessageRecord.versionCode, paramString2, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      }
    }
    catch (UnsupportedEncodingException paramString3)
    {
      break label113;
    }
  }
  
  protected MessageRecord a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    if (paramArrayOfByte != null) {
      localContentValues.put("msgData", paramArrayOfByte);
    }
    if (localMessageRecord != null)
    {
      localMessageRecord.msgData = paramArrayOfByte;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "updateMsgContent: set msg =" + localMessageRecord.getBaseInfoString());
      }
      if (localMessageRecord.getId() > 0L) {
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
      }
      for (;;)
      {
        if ((localMessageRecord instanceof ChatMessage)) {
          ((ChatMessage)localMessageRecord).reParse();
        }
        return localMessageRecord;
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
      }
    }
    a(paramString, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    return localMessageRecord;
  }
  
  protected MessageRecord a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryLastMsgForMessageTabFromDB, peerUin = " + paramString1 + ", type " + paramInt);
    }
    if (a(paramString1, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    StringBuilder localStringBuilder = new StringBuilder().append("select * from ").append(MessageRecord.getTableName(paramString1, paramInt)).append(" where isValid=1 and msgtype ").append(MsgProxyUtils.a()).append(" ");
    if (paramString2 != null) {}
    for (paramString1 = "and " + paramString2;; paramString1 = "")
    {
      paramString1 = paramString1 + " order by _id desc limit 1";
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryLastTABSupportMessageFromDB : sqlStr:" + paramString1);
      }
      paramString1 = a().a(paramString1, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((paramString1 != null) && (paramString1.size() >= 1)) {
        break;
      }
      return null;
    }
    return (MessageRecord)paramString1.get(0);
  }
  
  protected MessageRecordEntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager = ((MessageRecordEntityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createMessageRecordEntityManager());
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager;
    }
  }
  
  protected String a(Cursor paramCursor, SessionInfo paramSessionInfo, int paramInt)
  {
    paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
    if (MsgUtils.a(paramCursor.getInt(paramCursor.getColumnIndex("issend")))) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
    return paramSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  protected String a(String paramString, int paramInt)
  {
    return MsgProxyUtils.a(paramString, paramInt);
  }
  
  public List a(String paramString, int paramInt)
  {
    return a(b(paramString, paramInt));
  }
  
  protected List a(String paramString, int paramInt1, int paramInt2)
  {
    if (a(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    Object localObject = String.format("select _id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong from ( select _id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong from " + MessageRecord.getOldTableName(paramString, paramInt1) + " order by _id desc limit " + paramInt2 + " ) order by _id asc", new Object[0]);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromOldDB: sqlStr=" + (String)localObject + ", peeruin = " + paramString + ", type = " + paramInt1);
    }
    localObject = a().a((String)localObject, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromOldDB: list size =" + ((List)localObject).size() + ", peeruin = " + paramString + ", type = " + paramInt1);
      }
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromOldDB: null list , peeruin = " + paramString + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  protected List a(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getAllMessages uin " + paramString + " , type = " + paramInt1 + " , customTypes = " + Arrays.toString(paramArrayOfInt));
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = e(paramString, paramInt1);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "getAllMessages from AIO CACHE FAIL！ ");
      }
      localObject1 = b(paramString, paramInt1);
    }
    for (;;)
    {
      long l3 = 9223372036854775807L;
      long l1 = 9223372036854775807L;
      HashSet localHashSet = new HashSet();
      int i;
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
      {
        i = 0;
        while (i < paramArrayOfInt.length)
        {
          localHashSet.add(Integer.valueOf(paramArrayOfInt[i]));
          i += 1;
        }
      }
      long l2;
      int j;
      long l5;
      long l4;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        if (((List)localObject1).size() >= paramInt2)
        {
          localArrayList.addAll(((List)localObject1).subList(((List)localObject1).size() - paramInt2, ((List)localObject1).size()));
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "getAllMessages size = " + localArrayList.size());
          }
          return localArrayList;
        }
        Object localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
          if (localMessageRecord.shmsgseq < l3) {
            l3 = localMessageRecord.shmsgseq;
          }
        }
        localObject1 = ((List)localObject1).iterator();
        i = 3;
        l2 = 9223372036854775807L;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if (((paramInt1 != 3000) && (paramInt1 != 1)) || (((MessageRecord)localObject2).versionCode != 3) || (((MessageRecord)localObject2).shmsgseq != l3) || (l3 == 0L))
          {
            if (!localHashSet.contains(Integer.valueOf(((MessageRecord)localObject2).msgtype)))
            {
              j = i;
              l5 = l1;
              l4 = l2;
              if (!localHashSet.isEmpty()) {
                break label677;
              }
            }
            j = i;
            if (((MessageRecord)localObject2).versionCode < i) {
              j = ((MessageRecord)localObject2).versionCode;
            }
            l4 = l2;
            if (((MessageRecord)localObject2).getId() > 0L)
            {
              l4 = l2;
              if (((MessageRecord)localObject2).getId() < l2) {
                l4 = ((MessageRecord)localObject2).getId();
              }
            }
            l5 = l1;
            if (((MessageRecord)localObject2).time < l1) {
              l5 = ((MessageRecord)localObject2).time;
            }
            localArrayList.add(localObject2);
            if (localArrayList.size() < paramInt2) {
              break label677;
            }
            return localArrayList;
          }
        }
        l4 = l3;
        l3 = l1;
      }
      for (l1 = l4;; l1 = 9223372036854775807L)
      {
        if ((paramInt1 == 3000) || (paramInt1 == 1)) {
          localArrayList.addAll(0, a(paramString, paramInt1, l2, i, l1, paramInt2 - localArrayList.size(), paramArrayOfInt));
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "getAllMessages size = " + localArrayList.size());
          }
          return localArrayList;
          localArrayList.addAll(0, a(paramString, paramInt1, l2, i, l3, paramInt2 - localArrayList.size(), paramArrayOfInt));
        }
        label677:
        i = j;
        l1 = l5;
        l2 = l4;
        break;
        l3 = 9223372036854775807L;
        i = 3;
        l2 = 9223372036854775807L;
      }
    }
  }
  
  protected List a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByMsgUidFromDB, peerUin[" + FileManagerUtil.e(paramString) + "] type[" + paramInt + "] msgUid[" + paramLong + "]");
    }
    if ((paramLong == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByMsgUidFromDB Warning! msgUid==0");
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where msguid=?";
    MessageRecordEntityManager localMessageRecordEntityManager = a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramString = localMessageRecordEntityManager.a(paramString, new String[] { String.valueOf(paramLong) }, localQQAppInterface);
    if (paramString != null) {
      return paramString;
    }
    return new ArrayList();
  }
  
  protected List a(String paramString1, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryTimedMessageDBUnion, peerUin = " + paramString1 + ", type " + paramInt1 + ",_id = " + paramLong1 + ",versionCode = " + paramInt2 + ", from " + paramLong2 + ",count = " + paramInt3 + ",whrere = " + paramString2);
    }
    paramString2 = MessageDBUtils.a(MessageRecord.getOldTableName(paramString1, paramInt1), MessageRecord.getTableName(paramString1, paramInt1), paramLong1, paramInt2, paramLong2, paramInt3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(), paramString2);
    if (paramString2 != null)
    {
      if (a(paramString1, paramInt1, true)) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
      }
      paramString1 = a().a(paramString2.toString(), null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.i("QQMessageFacade", 2, paramString2.toString());
      }
      if (paramString1 != null)
      {
        Collections.reverse(paramString1);
        paramString2 = paramString1.iterator();
        while (paramString2.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramString2.next();
          if (QLog.isColorLevel()) {
            QLog.i("QQMessageFacade", 2, "queryTimedMessageDBUnion " + localMessageRecord.time + ", " + localMessageRecord.getId() + ", " + localMessageRecord.getLogColorContent());
          }
        }
        return paramString1;
      }
    }
    return new ArrayList();
  }
  
  public List a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryC2CMessageFromDB_UnionTables, peerUin = " + paramString + ", type " + paramInt1 + ",_id = " + paramLong1 + ",versionCode = " + paramInt2 + ", from " + paramLong2 + ",count = " + paramInt3 + ",customTypes = " + Arrays.toString(paramArrayOfInt));
    }
    Object localObject2 = null;
    if (a(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
    }
    Object localObject1 = localObject2;
    if (paramArrayOfInt != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfInt.length > 0)
      {
        localObject1 = new StringBuilder(" and msgtype in ( ");
        int i = 0;
        while (i < paramArrayOfInt.length)
        {
          ((StringBuilder)localObject1).append(paramArrayOfInt[i]);
          if (i < paramArrayOfInt.length - 1) {
            ((StringBuilder)localObject1).append(" , ");
          }
          i += 1;
        }
        ((StringBuilder)localObject1).append(") ");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    paramArrayOfInt = a(paramString, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, (String)localObject1);
    paramString = paramArrayOfInt;
    if (paramArrayOfInt == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  protected List a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTimeOrSeq:uin=" + paramString1 + ",type=" + paramInt1 + ",seq=" + paramLong + ",count=" + paramInt2);
    }
    if (a(paramString1, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
    }
    int i = j;
    if (paramInt1 != 3000)
    {
      if (paramInt1 == 1) {
        i = j;
      }
    }
    else
    {
      if (!MessageDBUtils.a(MessageRecord.getTableName(paramString1, paramInt1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b())) {
        break label165;
      }
      if (i == 0) {
        break label150;
      }
    }
    label150:
    for (paramString1 = b(paramString1, paramInt1, paramLong, paramInt2, paramString2);; paramString1 = c(paramString1, paramInt1, paramLong, paramInt2, paramString2))
    {
      if (paramString1 == null) {
        break label165;
      }
      return paramString1;
      i = 0;
      break;
    }
    label165:
    return new ArrayList();
  }
  
  public List a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromBySeq, peerUin = " + paramString + ", type " + paramInt + ",beginSeq = " + paramLong1 + ",endSeq = " + paramLong2);
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where shmsgseq>=? and shmsgseq<=? order by shmsgseq asc";
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromBySeq " + paramString);
    }
    Object localObject = a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = ((MessageRecordEntityManager)localObject).a(paramString, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, localQQAppInterface);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  public List a(String paramString, int paramInt, long paramLong, Map paramMap)
  {
    Object localObject1 = paramMap;
    if (paramMap == null) {
      localObject1 = new HashMap();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "querySameSeqMessageWithFilter,  peerUin = " + paramString + ", type " + paramInt + ", seq = " + paramLong + ", filterMsgSet.size = " + ((Map)localObject1).size() + ",filterMsgSet = " + ((Map)localObject1).keySet());
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where shmsgseq=?";
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "querySameSeqMessageWithFilter " + paramString);
    }
    paramMap = a();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramMap = paramMap.a(paramString, new String[] { String.valueOf(paramLong) }, (QQAppInterface)localObject2);
    if (paramMap == null) {
      return new ArrayList();
    }
    paramString = new ArrayList();
    paramMap = paramMap.iterator();
    while (paramMap.hasNext())
    {
      localObject2 = (MessageRecord)paramMap.next();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "filter msg , seq = " + ((MessageRecord)localObject2).shmsgseq + " ,id = " + ((MessageRecord)localObject2).getId() + ",uniseq=" + ((MessageRecord)localObject2).uniseq);
      }
      if ((!((Map)localObject1).containsKey("id&" + ((MessageRecord)localObject2).getId() + "&" + ((MessageRecord)localObject2).shmsgseq)) && (!((Map)localObject1).containsKey("uniseq&" + ((MessageRecord)localObject2).uniseq + "&" + ((MessageRecord)localObject2).shmsgseq))) {
        paramString.add(localObject2);
      }
    }
    return paramString;
  }
  
  /* Error */
  protected List a(String paramString, int paramInt, List paramList)
  {
    // Byte code:
    //   0: aload_3
    //   1: astore 4
    //   3: aload_3
    //   4: invokeinterface 49 1 0
    //   9: bipush 50
    //   11: if_icmple +14 -> 25
    //   14: aload_3
    //   15: iconst_0
    //   16: bipush 50
    //   18: invokeinterface 807 3 0
    //   23: astore 4
    //   25: aload_1
    //   26: iload_2
    //   27: invokestatic 303	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   30: astore_1
    //   31: iconst_1
    //   32: anewarray 91	java/lang/String
    //   35: astore_3
    //   36: new 155	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 184	java/util/ArrayList:<init>	()V
    //   43: astore 5
    //   45: aload 4
    //   47: invokeinterface 194 1 0
    //   52: astore 6
    //   54: aload 6
    //   56: invokeinterface 199 1 0
    //   61: ifeq +110 -> 171
    //   64: aload_3
    //   65: iconst_0
    //   66: aload 6
    //   68: invokeinterface 203 1 0
    //   73: checkcast 127	java/lang/Integer
    //   76: invokevirtual 948	java/lang/Integer:intValue	()I
    //   79: invokestatic 363	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   82: aastore
    //   83: aload_0
    //   84: getfield 22	com/tencent/mobileqq/app/message/MsgProxy:jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager	Lcom/tencent/mobileqq/persistence/MessageRecordEntityManager;
    //   87: iconst_0
    //   88: aload_1
    //   89: aconst_null
    //   90: ldc_w 950
    //   93: aload_3
    //   94: aconst_null
    //   95: aconst_null
    //   96: aconst_null
    //   97: aconst_null
    //   98: invokevirtual 488	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   101: astore 4
    //   103: aload 5
    //   105: aload_0
    //   106: getfield 22	com/tencent/mobileqq/app/message/MsgProxy:jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager	Lcom/tencent/mobileqq/persistence/MessageRecordEntityManager;
    //   109: ldc 163
    //   111: aconst_null
    //   112: aload 4
    //   114: invokevirtual 608	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Lcom/tencent/mobileqq/persistence/Entity;
    //   117: checkcast 163	com/tencent/mobileqq/data/MessageRecord
    //   120: invokevirtual 609	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   123: pop
    //   124: aload 4
    //   126: ifnull -72 -> 54
    //   129: aload 4
    //   131: invokeinterface 496 1 0
    //   136: goto -82 -> 54
    //   139: astore 7
    //   141: aload 4
    //   143: ifnull -89 -> 54
    //   146: aload 4
    //   148: invokeinterface 496 1 0
    //   153: goto -99 -> 54
    //   156: astore_1
    //   157: aload 4
    //   159: ifnull +10 -> 169
    //   162: aload 4
    //   164: invokeinterface 496 1 0
    //   169: aload_1
    //   170: athrow
    //   171: aload 5
    //   173: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	MsgProxy
    //   0	174	1	paramString	String
    //   0	174	2	paramInt	int
    //   0	174	3	paramList	List
    //   1	162	4	localObject	Object
    //   43	129	5	localArrayList	ArrayList
    //   52	15	6	localIterator	Iterator
    //   139	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   103	124	139	java/lang/Exception
    //   103	124	156	finally
  }
  
  protected List a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList peerUin: " + paramString + " type: " + paramInt + " , autoInit = " + paramBoolean1);
    }
    label549:
    for (;;)
    {
      Object localObject2;
      synchronized (MsgPool.a().a(paramString, paramInt))
      {
        localObject1 = (List)MsgPool.a().b().get(a(paramString, paramInt));
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          break label508;
        }
        if (!paramBoolean1) {
          break label472;
        }
        localObject2 = d(paramString, paramInt);
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
          break label459;
        }
        localObject1 = new ArrayList();
        if (paramInt != 0) {
          break label446;
        }
        if (((List)localObject2).size() > 15)
        {
          ((List)localObject1).addAll(((List)localObject2).subList(((List)localObject2).size() - 15, ((List)localObject2).size()));
          if ((((List)localObject2).size() > 15) && (MsgProxyUtils.a(paramString, paramInt, (List)localObject1)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList : pull more long msg");
            }
            ((List)localObject1).clear();
            if (((List)localObject2).size() > 30) {
              ((List)localObject1).addAll(((List)localObject2).subList(((List)localObject2).size() - 30, ((List)localObject2).size()));
            }
          }
          else
          {
            localObject2 = a((List)localObject1, ((Long)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString).first).longValue());
            if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
              break label549;
            }
            localObject1 = localObject2;
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "continuedList :" + ((List)localObject2).size());
            }
            MsgPool.a().b().put(a(paramString, paramInt), localObject2);
            return (List)MsgPool.a().b().get(a(paramString, paramInt));
          }
        }
        else
        {
          ((List)localObject1).addAll((Collection)localObject2);
        }
      }
      ((List)localObject1).addAll((Collection)localObject2);
      continue;
      label446:
      ((List)localObject1).addAll((Collection)localObject2);
      continue;
      label459:
      Object localObject1 = a(paramString, paramInt, 15);
      continue;
      label472:
      MsgPool.a().b().remove(a(paramString, paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "MsgPool.getPoolInstance().getAioMsgPool().remove :");
      }
      return null;
      label508:
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList from aiopool size = " + ((List)localObject1).size());
      }
    }
  }
  
  protected void a() {}
  
  protected void a(SessionInfo paramSessionInfo, String paramString, int paramInt, Set paramSet)
  {
    paramSet.add(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    paramSet.add(paramSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  protected void a(MessageRecord paramMessageRecord)
  {
    if (!paramMessageRecord.isSendFromLocal())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) {
        break label102;
      }
      if (paramMessageRecord.istroop != 1) {
        break label87;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.frienduin, paramMessageRecord.istroop)) {
        break label58;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c("recv_msg_back_group", 1);
    }
    label58:
    label87:
    label102:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c("recv_msg_back_notify_group", 1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c("recv_msg_notify", 1);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c("recv_msg_notify", 1);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c("recv_msg_notify", 1);
    } while (paramMessageRecord.istroop != 1);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c("recv_msg_fore_num_group", 1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c("recv_msg_fore_notify_group", 1);
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    if (paramInt2 > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt1, MessageRecord.getTableName(paramString1, paramInt1), paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt1, MessageRecord.getOldTableName(paramString1, paramInt1), paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    b(paramString, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    int i;
    if ((paramInt == 3000) || (paramInt == 1))
    {
      i = 1;
      if (i == 0) {
        break label106;
      }
    }
    label106:
    for (String str = "shmsgseq";; str = "time")
    {
      a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), localContentValues, String.format("isread=? and %s<=?", new Object[] { str }), new String[] { "0", String.valueOf(paramLong) }, null);
      return;
      i = 0;
      break;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong, List paramList)
  {
    int j = 0;
    Object localObject2 = a(paramString, paramInt);
    for (;;)
    {
      synchronized (MsgPool.a().a(paramString, paramInt))
      {
        if (!MsgPool.a().a().containsKey(localObject2)) {
          break label339;
        }
        localObject2 = (List)MsgPool.a().a().get(localObject2);
        i = 0;
        if (i >= ((List)localObject2).size()) {
          break label343;
        }
        Object localObject3 = (MessageRecord)((List)localObject2).get(i);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "find cache " + ((MessageRecord)localObject3).getBaseInfoString());
        }
        if (((MessageRecord)localObject3).uniseq != paramLong) {
          break label349;
        }
        if ((i > 0) && (i < ((List)localObject2).size()))
        {
          localObject3 = new ArrayList();
          if (j < i)
          {
            MessageRecord localMessageRecord = (MessageRecord)((List)localObject2).get(j);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "removeList " + localMessageRecord.getBaseInfoString());
            }
            ((List)localObject3).add(localMessageRecord);
            j += 1;
            continue;
          }
          ((List)localObject2).removeAll((Collection)localObject3);
          ((List)localObject3).clear();
          ((List)localObject2).addAll(0, paramList);
          if (((List)localObject2).size() > 40)
          {
            i = ((List)localObject2).size() - 40;
            if (i > 0)
            {
              ((List)localObject2).remove(0);
              i -= 1;
              continue;
            }
          }
        }
        else
        {
          if (i != 0) {
            continue;
          }
          ((List)localObject2).addAll(0, paramList);
        }
      }
      b(paramString, paramInt, (List)localObject2);
      label339:
      return;
      label343:
      int i = 0;
      continue;
      label349:
      i += 1;
    }
  }
  
  protected void a(String paramString, int paramInt, QQMessageFacade.Message paramMessage)
  {
    a(paramString, paramInt, paramMessage);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    String str;
    if ((paramInt == 1001) && (paramMessage.msgtype != -1003) && (paramMessage.msgtype != -1031) && (paramMessage.msgtype != -1032) && (paramMessage.msgtype != 201)) {
      if (paramMessage.versionCode > 0)
      {
        str = MessageRecord.getTableName(String.valueOf(AppConstants.Z), 1001);
        a(paramString, paramInt, str, localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
      }
    }
    for (;;)
    {
      a(paramString, paramInt, paramMessage.versionCode, localContentValues, "isread=?", new String[] { "0" }, null);
      return;
      str = MessageRecord.getOldTableName(String.valueOf(AppConstants.Z), 1001);
      break;
      if (paramInt == 1009) {
        a(paramString, paramInt, MessageRecord.getTableName(AppConstants.S, 1009), localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
      }
    }
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    synchronized (MsgPool.a().a(paramString, paramInt))
    {
      List localList = (List)MsgPool.a().a().get(a(paramString, paramInt));
      if (localList != null)
      {
        MsgProxyUtils.a(localList, paramMessageRecord, true);
        if (localList.size() > 40) {
          localList.remove(0);
        }
        b(paramString, paramInt, localList);
      }
      return;
    }
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener)
  {
    if (paramMessageRecord.versionCode > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), paramMessageRecord, 0, paramProxyListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((MsgProxyUtils.e(paramMessageRecord.msgtype)) && (!MsgProxyUtils.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))) {}
    while (!paramBoolean2) {
      return;
    }
    if (paramBoolean1)
    {
      a(paramString, paramInt, paramMessageRecord, paramProxyListener);
      return;
    }
    a(paramString, paramInt, paramMessageRecord, paramProxyListener);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramString, paramInt, paramMessageRecord, paramBoolean3);
    a(paramString, paramInt, paramMessageRecord, paramProxyListener, paramBoolean1, paramBoolean2);
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "insertToList " + paramMessageRecord.getBaseInfoString());
    }
    synchronized (MsgPool.a().a(paramString, paramInt))
    {
      Object localObject1;
      for (;;)
      {
        localObject1 = d(paramString, paramInt);
        Object localObject2 = a(paramString, paramInt);
        MsgProxyUtils.a((List)localObject1, paramMessageRecord, true);
        if ((((List)localObject1).size() > 40) && (!MsgProxyUtils.a(paramString))) {
          ((List)localObject1).remove(0);
        }
        if ((MsgPool.a().b().containsKey(localObject2)) && (paramBoolean))
        {
          localObject2 = (List)MsgPool.a().b().get(localObject2);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new ArrayList();
          }
          if (!paramString.equals(AppConstants.Y)) {
            break;
          }
          ((List)localObject1).add(0, paramMessageRecord);
        }
        a(paramMessageRecord);
        return;
        QLog.d("Q.msg.MsgProxy", 1, "insertToList " + paramMessageRecord.getUserLogString());
      }
      ((List)localObject1).add(paramMessageRecord);
    }
  }
  
  protected void a(String paramString, int paramInt, Entity paramEntity, ProxyListener paramProxyListener)
  {
    if (((paramEntity instanceof MessageRecord)) && (((MessageRecord)paramEntity).versionCode > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), paramEntity, 0, paramProxyListener);
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt, paramString2, paramContentValues, paramString3, paramArrayOfString, 1, paramProxyListener);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    ArrayList localArrayList;
    Iterator localIterator;
    MessageRecord localMessageRecord;
    synchronized (MsgPool.a().a(paramString1, paramInt))
    {
      localList = d(paramString1, paramInt);
      localArrayList = new ArrayList();
      if (localList != null)
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localMessageRecord = (MessageRecord)localIterator.next();
          if ((localMessageRecord.senderuin != null) && (localMessageRecord.selfuin != null) && (localMessageRecord.senderuin.equals(paramString2)) && (localMessageRecord.selfuin.equals(paramString3))) {
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    localList.removeAll(localArrayList);
    localArrayList.clear();
    List localList = f(paramString1, paramInt);
    if (localList != null)
    {
      localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        localMessageRecord = (MessageRecord)localIterator.next();
        if ((localMessageRecord.senderuin != null) && (localMessageRecord.selfuin != null) && (localMessageRecord.senderuin.equals(paramString2)) && (localMessageRecord.selfuin.equals(paramString3))) {
          localArrayList.add(localMessageRecord);
        }
      }
      localList.removeAll(localArrayList);
      localArrayList.clear();
    }
    a(paramString1, paramInt, MessageRecord.getTableName(paramString1, paramInt), "senderuin=? and selfuin=?", new String[] { paramString2, paramString3 }, null);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, String paramString3, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt, paramString2, paramString3, paramArrayOfString, 2, paramProxyListener);
  }
  
  public void a(String paramString, int paramInt, List paramList)
  {
    synchronized (MsgPool.a().a(paramString, paramInt))
    {
      if (MsgPool.a().b().containsKey(a(paramString, paramInt)))
      {
        List localList = (List)MsgPool.a().b().get(a(paramString, paramInt));
        paramString = localList;
        if (localList == null) {
          paramString = new ArrayList();
        }
        localList = MsgProxyUtils.a(paramString, paramList);
        paramString.addAll(0, localList);
        paramList.clear();
        paramList.addAll(localList);
      }
      return;
    }
  }
  
  protected void a(String paramString, int paramInt, boolean paramBoolean)
  {
    new Thread(new cyn(this, paramBoolean), "report_troop_aio_break").start();
  }
  
  public void a(List paramList, ProxyListener paramProxyListener)
  {
    b(MsgProxyUtils.a(paramList), paramProxyListener);
  }
  
  protected boolean a(int paramInt, long paramLong, MessageRecord paramMessageRecord)
  {
    if ((paramInt == 3000) || (paramInt == 1)) {
      if (paramLong < paramMessageRecord.shmsgseq) {}
    }
    while (paramLong >= paramMessageRecord.time)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    Iterator localIterator = ((Vector)this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a().clone()).iterator();
    while (localIterator.hasNext())
    {
      MsgQueueItem localMsgQueueItem = (MsgQueueItem)localIterator.next();
      if ((paramString.equals(localMsgQueueItem.jdField_a_of_type_JavaLangString)) && ((paramInt == localMsgQueueItem.h) || ((paramInt != 3000) && (paramInt != 1))) && ((localMsgQueueItem.i == 1) || (localMsgQueueItem.i == 2) || ((paramBoolean) && (localMsgQueueItem.i == 0))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "needTransSaveToDatabase uin=" + paramString + ", type=" + paramInt + ", hasInsertAction=" + paramBoolean + ",result=true");
        }
        return true;
      }
    }
    return false;
  }
  
  protected int b(String paramString, int paramInt, long paramLong)
  {
    MessageRecord localMessageRecord = c(paramString, paramInt, paramLong);
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("--->removeSingleMsg : peerUin:").append(paramString).append(" type:").append(paramInt).append(" uniseq:").append(paramLong).append(" mr:").append(localMessageRecord).append(" dbid:");
      if (localMessageRecord != null)
      {
        localObject = Long.valueOf(localMessageRecord.getId());
        QLog.d("Q.msg.MsgProxy", 2, localObject);
      }
    }
    else
    {
      if (localMessageRecord == null) {
        break label199;
      }
      long l = localMessageRecord.getId();
      if (l == -1L) {
        break label168;
      }
      a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), "_id=?", new String[] { String.valueOf(l) }, null);
    }
    for (;;)
    {
      if (!localMessageRecord.isread) {
        break label197;
      }
      return 1;
      localObject = "mr is null.";
      break;
      label168:
      a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    }
    label197:
    return 2;
    label199:
    a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    return 1;
  }
  
  @Deprecated
  public Cursor b(String paramString, int paramInt)
  {
    return a(a(b(paramString, paramInt)));
  }
  
  protected MessageRecord b(String paramString, int paramInt, long paramLong)
  {
    Object localObject2;
    if ((paramLong == 0L) || (paramString == null) || (paramString.length() == 0))
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = c(paramString, paramInt);
    if (localObject1 != null)
    {
      localObject2 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (MessageRecord)((Iterator)localObject2).next();
      } while (((MessageRecord)localObject1).uniseq != paramLong);
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      paramString = b(paramString, paramInt, paramLong);
      localObject2 = localObject1;
      if (paramString == null) {
        break;
      }
      localObject2 = localObject1;
      if (paramString.isEmpty()) {
        break;
      }
      return (MessageRecord)paramString.get(0);
      localObject1 = null;
    }
  }
  
  protected String b(String paramString, int paramInt)
  {
    if (MsgProxyUtils.a(paramString)) {
      return "select * from " + MessageRecord.getTableName(paramString, paramInt) + " order by time desc , _id desc";
    }
    if (MsgProxyUtils.a(paramInt)) {
      return "select * from " + MessageRecord.getTableName(paramString, paramInt) + " order by time desc , _id desc limit " + 40;
    }
    return "select * from " + MessageRecord.getTableName(paramString, paramInt) + " order by _id desc limit " + 40;
  }
  
  public List b(String paramString, int paramInt)
  {
    synchronized (MsgPool.a().a(paramString, paramInt))
    {
      paramString = d(paramString, paramInt);
      if (paramString != null)
      {
        paramString = (List)((ArrayList)paramString).clone();
        return paramString;
      }
      return paramString;
    }
  }
  
  protected List b(String paramString, int paramInt1, int paramInt2)
  {
    if (a(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    Object localObject = String.format("select * from " + MessageRecord.getTableName(paramString, paramInt1) + " where isValid=1 and msgtype != ? order by shmsgseq asc limit ?", new Object[0]);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryValidMessageBySeq: sql=" + (String)localObject + ", peeruin = " + paramString + ", type = " + paramInt1);
    }
    MessageRecordEntityManager localMessageRecordEntityManager = a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = localMessageRecordEntityManager.a((String)localObject, new String[] { String.valueOf(-2006), String.valueOf(paramInt2) }, localQQAppInterface);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryValidMessageBySeq: list size =" + ((List)localObject).size() + ", peeruin = " + paramString + ", type = " + paramInt1);
      }
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryValidMessageBySeq: null list , peeruin = " + paramString + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  protected List b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB, peerUin[" + FileManagerUtil.e(paramString) + "] type[" + paramInt + "] uniseq[" + paramLong + "]");
    }
    if ((paramLong == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB Warning! uniseq==0");
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where uniseq=?";
    MessageRecordEntityManager localMessageRecordEntityManager = a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramString = localMessageRecordEntityManager.a(paramString, new String[] { String.valueOf(paramLong) }, localQQAppInterface);
    if (paramString != null) {
      return paramString;
    }
    return new ArrayList();
  }
  
  protected List b(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (a(paramString1, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    Object localObject = "select * from " + MessageRecord.getTableName(paramString1, paramInt1) + " where shmsgseq<=? and shmsgseq>? %s order by shmsgseq asc";
    long l;
    if (paramString2 == null)
    {
      paramString2 = "";
      paramString2 = String.format((String)localObject, new Object[] { paramString2 });
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageBySeq: sql=" + paramString2 + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      if (paramInt2 > 0) {
        break label274;
      }
      l = 0L;
    }
    for (;;)
    {
      localObject = a();
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramString2 = ((MessageRecordEntityManager)localObject).a(paramString2, new String[] { String.valueOf(paramLong), String.valueOf(l) }, localQQAppInterface);
      if (paramString2 == null) {
        break label298;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageBySeq: list size =" + paramString2.size() + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      return paramString2;
      paramString2 = "and " + paramString2;
      break;
      label274:
      if (paramLong > paramInt2) {
        l = paramLong - paramInt2;
      } else {
        l = 0L;
      }
    }
    label298:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageBySeq: null list , peeruin = " + paramString1 + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a();
    }
  }
  
  protected void b(String paramString, int paramInt, long paramLong)
  {
    Object localObject2;
    synchronized (MsgPool.a().a(paramString, paramInt))
    {
      localObject2 = d(paramString, paramInt);
      if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
        return;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
        if ((!localMessageRecord.isread) && (a(paramInt, paramLong, localMessageRecord))) {
          localMessageRecord.isread = true;
        }
      }
    }
    paramString = f(paramString, paramInt);
    if ((paramString == null) || (paramString.isEmpty())) {
      return;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      localObject2 = (MessageRecord)paramString.next();
      if ((!((MessageRecord)localObject2).isread) && (a(paramInt, paramLong, (MessageRecord)localObject2))) {
        ((MessageRecord)localObject2).isread = true;
      }
    }
  }
  
  protected void b(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.uniseq != 0L)) {}
    do
    {
      return;
      if (paramMessageRecord.getId() > 0L)
      {
        paramMessageRecord.createMessageUniseq();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("uniseq", Long.valueOf(paramMessageRecord.uniseq));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "updateUniseqByID: set msg =" + paramMessageRecord.getBaseInfoString());
        }
        a(paramString, paramInt, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, null);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.msg.MsgProxy", 2, "updateUniseqByID ERROR: _id<0 !");
  }
  
  protected MessageRecord c(String paramString, int paramInt, long paramLong)
  {
    Object localObject2 = MsgPool.a().a(paramString, paramInt);
    List localList = null;
    for (;;)
    {
      Object localObject1;
      try
      {
        Object localObject3 = d(paramString, paramInt);
        localObject1 = localList;
        if (localObject3 != null)
        {
          Iterator localIterator = ((List)localObject3).iterator();
          localObject1 = localList;
          if (localIterator.hasNext())
          {
            localObject1 = (MessageRecord)localIterator.next();
            if (((MessageRecord)localObject1).uniseq != paramLong) {
              continue;
            }
            ((List)localObject3).remove(localObject1);
          }
        }
        localList = f(paramString, paramInt);
        if (localList != null)
        {
          localObject3 = localList.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            paramString = (MessageRecord)((Iterator)localObject3).next();
            if (paramString.uniseq != paramLong) {
              continue;
            }
            localList.remove(paramString);
            return paramString;
          }
        }
      }
      finally {}
      paramString = (String)localObject1;
    }
  }
  
  protected List c(String paramString, int paramInt)
  {
    synchronized (MsgPool.a().a(paramString, paramInt))
    {
      paramString = (List)MsgPool.a().a().get(a(paramString, paramInt));
      if (paramString != null)
      {
        paramString = (List)((ArrayList)paramString).clone();
        return paramString;
      }
      return paramString;
    }
  }
  
  protected void c()
  {
    try
    {
      MsgPool.a().b().clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected MessageRecord d(String paramString, int paramInt, long paramLong)
  {
    for (;;)
    {
      synchronized (MsgPool.a().a(paramString, paramInt))
      {
        List localList = (List)MsgPool.a().a().get(a(paramString, paramInt));
        if (localList != null)
        {
          Iterator localIterator = localList.iterator();
          if (localIterator.hasNext())
          {
            paramString = (MessageRecord)localIterator.next();
            if (paramString.uniseq != paramLong) {
              continue;
            }
            localList.remove(paramString);
            return paramString;
          }
        }
      }
      paramString = null;
    }
  }
  
  protected List d(String paramString, int paramInt)
  {
    synchronized (MsgPool.a().a(paramString, paramInt))
    {
      List localList2 = (List)MsgPool.a().a().get(a(paramString, paramInt));
      List localList1 = localList2;
      if (localList2 == null)
      {
        localList1 = g(paramString, paramInt);
        b(paramString, paramInt, localList1);
      }
      if ((localList1 != null) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.MsgProxy", 2, "getMsgList uin " + paramString + " , type = " + paramInt + " itemList size=" + localList1.size());
      }
      return localList1;
    }
  }
  
  protected void d()
  {
    MsgPool.a().a().clear();
    MsgPool.a().b().clear();
  }
  
  public List e(String paramString, int paramInt)
  {
    synchronized (MsgPool.a().a(paramString, paramInt))
    {
      paramString = f(paramString, paramInt);
      if (paramString != null)
      {
        paramString = (List)((ArrayList)paramString).clone();
        return paramString;
      }
      return paramString;
    }
  }
  
  /* Error */
  protected void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 76	com/tencent/mobileqq/app/message/MsgProxy:jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager	Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   4: invokevirtual 307	com/tencent/mobileqq/app/proxy/ProxyManager:c	()V
    //   7: aload_0
    //   8: getfield 76	com/tencent/mobileqq/app/message/MsgProxy:jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager	Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   11: invokevirtual 1186	com/tencent/mobileqq/app/proxy/ProxyManager:d	()V
    //   14: aload_0
    //   15: getfield 72	com/tencent/mobileqq/app/message/MsgProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   18: invokevirtual 1188	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   21: astore 11
    //   23: aload 11
    //   25: invokevirtual 1193	com/tencent/mobileqq/app/SQLiteDatabase:b	()[Ljava/lang/String;
    //   28: astore 12
    //   30: aload 12
    //   32: ifnonnull +4 -> 36
    //   35: return
    //   36: iconst_0
    //   37: istore_1
    //   38: iload_1
    //   39: aload 12
    //   41: arraylength
    //   42: if_icmpge -7 -> 35
    //   45: aload 12
    //   47: iload_1
    //   48: aaload
    //   49: astore 13
    //   51: aload 13
    //   53: ldc_w 1195
    //   56: invokevirtual 95	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   59: ifeq +357 -> 416
    //   62: new 104	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 1197
    //   72: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload 13
    //   77: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc_w 1199
    //   83: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload 13
    //   88: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 1201
    //   94: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore 8
    //   102: aload 8
    //   104: ifnull +246 -> 350
    //   107: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq +31 -> 141
    //   113: ldc_w 322
    //   116: iconst_2
    //   117: new 104	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 1203
    //   127: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload 8
    //   132: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload 11
    //   143: aload 8
    //   145: aconst_null
    //   146: invokevirtual 1206	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   149: astore 9
    //   151: aload 9
    //   153: ifnull +175 -> 328
    //   156: aload 9
    //   158: astore 8
    //   160: aload 9
    //   162: invokeinterface 493 1 0
    //   167: ifle +161 -> 328
    //   170: aload 9
    //   172: astore 8
    //   174: aload 9
    //   176: invokeinterface 583 1 0
    //   181: pop
    //   182: aload 9
    //   184: astore 8
    //   186: aload 9
    //   188: aload 9
    //   190: ldc_w 1208
    //   193: invokeinterface 1211 2 0
    //   198: invokeinterface 1215 2 0
    //   203: lstore 6
    //   205: aload 9
    //   207: astore 8
    //   209: aload 9
    //   211: aload 9
    //   213: ldc_w 1216
    //   216: invokeinterface 1211 2 0
    //   221: invokeinterface 767 2 0
    //   226: astore 10
    //   228: aload 9
    //   230: astore 8
    //   232: aload 9
    //   234: aload 9
    //   236: ldc_w 1217
    //   239: invokeinterface 1211 2 0
    //   244: invokeinterface 618 2 0
    //   249: istore_2
    //   250: aload 9
    //   252: astore 8
    //   254: aload 9
    //   256: aload 9
    //   258: ldc_w 768
    //   261: invokeinterface 1211 2 0
    //   266: invokeinterface 618 2 0
    //   271: istore_3
    //   272: lload 6
    //   274: lstore 4
    //   276: iload_2
    //   277: sipush 3000
    //   280: if_icmpeq +29 -> 309
    //   283: lload 6
    //   285: lstore 4
    //   287: iload_2
    //   288: iconst_1
    //   289: if_icmpeq +20 -> 309
    //   292: lload 6
    //   294: lstore 4
    //   296: iload_3
    //   297: iconst_1
    //   298: if_icmpne +11 -> 309
    //   301: lload 6
    //   303: ldc2_w 1218
    //   306: ladd
    //   307: lstore 4
    //   309: aload 9
    //   311: astore 8
    //   313: aload_0
    //   314: getfield 72	com/tencent/mobileqq/app/message/MsgProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   317: invokevirtual 965	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   320: aload 10
    //   322: iload_2
    //   323: lload 4
    //   325: invokevirtual 1221	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;IJ)V
    //   328: aload 9
    //   330: ifnull +10 -> 340
    //   333: aload 9
    //   335: invokeinterface 496 1 0
    //   340: aload 11
    //   342: aload 13
    //   344: aconst_null
    //   345: aconst_null
    //   346: invokevirtual 1224	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   349: pop
    //   350: iload_1
    //   351: iconst_1
    //   352: iadd
    //   353: istore_1
    //   354: goto -316 -> 38
    //   357: astore 10
    //   359: aconst_null
    //   360: astore 9
    //   362: aload 9
    //   364: astore 8
    //   366: aload 10
    //   368: invokevirtual 615	java/lang/Exception:printStackTrace	()V
    //   371: aload 9
    //   373: ifnull -33 -> 340
    //   376: aload 9
    //   378: invokeinterface 496 1 0
    //   383: goto -43 -> 340
    //   386: astore 9
    //   388: aconst_null
    //   389: astore 8
    //   391: aload 8
    //   393: ifnull +10 -> 403
    //   396: aload 8
    //   398: invokeinterface 496 1 0
    //   403: aload 9
    //   405: athrow
    //   406: astore 9
    //   408: goto -17 -> 391
    //   411: astore 10
    //   413: goto -51 -> 362
    //   416: aconst_null
    //   417: astore 8
    //   419: goto -317 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	MsgProxy
    //   37	317	1	i	int
    //   249	74	2	j	int
    //   271	28	3	k	int
    //   274	50	4	l1	long
    //   203	99	6	l2	long
    //   100	318	8	localObject1	Object
    //   149	228	9	localCursor	Cursor
    //   386	18	9	localObject2	Object
    //   406	1	9	localObject3	Object
    //   226	95	10	str1	String
    //   357	10	10	localException1	Exception
    //   411	1	10	localException2	Exception
    //   21	320	11	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    //   28	18	12	arrayOfString	String[]
    //   49	294	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   141	151	357	java/lang/Exception
    //   141	151	386	finally
    //   160	170	406	finally
    //   174	182	406	finally
    //   186	205	406	finally
    //   209	228	406	finally
    //   232	250	406	finally
    //   254	272	406	finally
    //   313	328	406	finally
    //   366	371	406	finally
    //   160	170	411	java/lang/Exception
    //   174	182	411	java/lang/Exception
    //   186	205	411	java/lang/Exception
    //   209	228	411	java/lang/Exception
    //   232	250	411	java/lang/Exception
    //   254	272	411	java/lang/Exception
    //   313	328	411	java/lang/Exception
  }
  
  protected List f(String paramString, int paramInt)
  {
    return a(paramString, paramInt, false, false);
  }
  
  protected void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a().size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager);
    }
  }
  
  List g(String paramString, int paramInt)
  {
    Object localObject1;
    long l1;
    String str;
    boolean bool;
    synchronized (MsgPool.a().a(paramString, paramInt))
    {
      localObject1 = (List)MsgPool.a().a().get(a(paramString, paramInt));
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "init from cache, uin=" + paramString);
        }
        return localObject1;
      }
      l1 = System.currentTimeMillis();
      str = b(paramString, paramInt);
      bool = a(paramString, paramInt, false);
      if (bool) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
      }
      List localList = h(paramString, paramInt);
      Object localObject2 = a().a(str, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localObject2 != null)
      {
        int j = ((List)localObject2).size() / 2;
        paramInt = ((List)localObject2).size();
        int i = 0;
        paramInt -= 1;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= j) {
            break;
          }
          localObject1 = (MessageRecord)((List)localObject2).get(i);
          ((List)localObject2).set(i, ((List)localObject2).get(paramInt));
          ((List)localObject2).set(paramInt, localObject1);
          i += 1;
          paramInt -= 1;
        }
      }
      localObject1 = new ArrayList();
      localObject2 = MsgProxyUtils.a((List)localObject1, localList).iterator();
      if (((Iterator)localObject2).hasNext()) {
        MsgProxyUtils.a((List)localObject1, (MessageRecord)((Iterator)localObject2).next(), true);
      }
    }
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      QLog.d("Q.msg.MsgProxy", 2, "init from db, uin=" + paramString + ", isSaveToDatabase=" + bool + ", cost=" + (l2 - l1) + " sqlStr = " + str + " size =" + ((List)localObject1).size());
    }
    return localObject1;
  }
  
  protected List h(String paramString, int paramInt)
  {
    Object localObject = (Vector)this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a().clone();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Vector)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MsgQueueItem localMsgQueueItem = (MsgQueueItem)((Iterator)localObject).next();
      if ((localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof MessageRecord))
      {
        MessageRecord localMessageRecord = (MessageRecord)localMsgQueueItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
        if ((localMessageRecord.frienduin.equals(paramString)) && (localMessageRecord.istroop == paramInt) && (localMsgQueueItem.i == 0)) {
          localArrayList.add(localMessageRecord);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getMsgListFromQueue uin=" + paramString + ", type=" + paramInt + ", size=" + localArrayList.size());
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.MsgProxy
 * JD-Core Version:    0.7.0.1
 */