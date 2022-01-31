package com.tencent.mobileqq.multimsg;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dyd;
import dye;
import dyf;
import dyg;
import dyh;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.ServerConfigManager.ConfigType;

public class MultiMsgManager
{
  private static MultiMsgManager jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager;
  public static final String a = "MultiMsg";
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static final String b = "MultiMsg_time";
  private int jdField_a_of_type_Int = 100;
  private long jdField_a_of_type_Long;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public ArrayList a;
  public HashMap a;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 20;
  private long jdField_b_of_type_Long = 0L;
  public HashMap b;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 0L;
  private HashMap jdField_c_of_type_JavaUtilHashMap = new HashMap();
  
  public MultiMsgManager()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static MultiMsgManager a()
  {
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager == null) {
        jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager = new MultiMsgManager();
      }
      return jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, HashMap paramHashMap, MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    paramMessageObserver = PicBusiManager.a(7, 7);
    paramMessageObserver.a(paramArrayList2);
    paramMessageObserver.a(new dyf(this, paramArrayList1, paramQQAppInterface, paramString, paramInt, paramHashMap, paramMessageRecord));
    PicBusiManager.a(paramMessageObserver, paramQQAppInterface);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, HashMap paramHashMap, MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, ArrayList paramArrayList, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.d("MultiMsg", 4, "pack multi msg start.............................");
      QLog.d("MultiMsg", 4, paramArrayList.toString());
    }
    paramHashMap = paramQQAppInterface.a().a().a(paramMessageRecord, paramArrayList, paramHashMap, paramBoolean);
    if (paramHashMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "pack multi msg failed.............................");
      }
      paramMessageRecord.extraflag = 32768;
      paramQQAppInterface.a().d(paramString, paramInt, paramMessageRecord.uniseq);
      long l = paramMessageRecord.uniseq;
      ((MessageHandler)paramQQAppInterface.a(0)).a(MessageHandler.a(paramInt), false, new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "pack multi msg done.............................");
        }
        if (!a(paramQQAppInterface, paramHashMap, paramQQAppInterface.a(), paramString, paramString, paramInt, paramMessageRecord.uniseq, 1035, new dyg(this, paramMessageRecord, paramQQAppInterface, paramString, paramInt))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MultiMsg", 2, "sendMultiMsg successful, upload multi msg pack start.......................");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg", 2, "sendMultiMsg failed.......................");
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, UpCallBack paramUpCallBack)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "[sendMultiMsg]data.length = " + paramArrayOfByte.length);
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.jdField_b_of_type_Int = 131078;
    localTransferRequest.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    localTransferRequest.jdField_a_of_type_JavaLangString = paramString1;
    localTransferRequest.jdField_b_of_type_JavaLangString = paramString2;
    localTransferRequest.c = paramString3;
    localTransferRequest.jdField_a_of_type_Int = paramInt1;
    localTransferRequest.jdField_a_of_type_Long = paramLong;
    localTransferRequest.d = paramInt2;
    localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = paramUpCallBack;
    paramQQAppInterface.a().a(localTransferRequest);
    return true;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(Collection paramCollection)
  {
    paramCollection = paramCollection.iterator();
    int i = 0;
    Object localObject1;
    if (paramCollection.hasNext())
    {
      localObject1 = (ChatMessage)paramCollection.next();
      if ((localObject1 instanceof MessageForPic)) {
        i += 1;
      }
    }
    for (;;)
    {
      break;
      if ((localObject1 instanceof MessageForMixedMsg))
      {
        localObject1 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (((MessageRecord)((Iterator)localObject1).next() instanceof MessageForPic)) {
            i += 1;
          }
        }
      }
      else
      {
        int j = i;
        if (((ChatMessage)localObject1).msgtype == -1036)
        {
          localObject1 = ((MessageForLongMsg)localObject1).longMsgFragmentList.iterator();
          do
          {
            j = i;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
          } while (!(localObject2 instanceof MessageForMixedMsg));
          Object localObject2 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          j = i;
          for (;;)
          {
            i = j;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            if (((MessageRecord)((Iterator)localObject2).next() instanceof MessageForPic)) {
              j += 1;
            }
          }
          return i;
        }
        i = j;
      }
    }
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public String a(String paramString, long paramLong, QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong == 0L)) {}
    Object localObject;
    do
    {
      while (!paramQQAppInterface.hasNext())
      {
        do
        {
          return null;
          if (this.jdField_c_of_type_JavaUtilHashMap.size() > 0)
          {
            localObject = (List)this.jdField_c_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
            if ((localObject != null) && (((List)localObject).size() > 0))
            {
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                MultiMsgNick localMultiMsgNick = (MultiMsgNick)((Iterator)localObject).next();
                if ((localMultiMsgNick != null) && (paramString.equals(localMultiMsgNick.uin)) && (paramLong == localMultiMsgNick.uniseq)) {
                  return localMultiMsgNick.nick;
                }
              }
            }
          }
          this.jdField_c_of_type_JavaUtilHashMap.clear();
          paramQQAppInterface = paramQQAppInterface.a().createEntityManager().a(MultiMsgNick.class, new MultiMsgNick().getTableName(), false, "uniseq = ?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
        } while ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0));
        this.jdField_c_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), paramQQAppInterface);
        paramQQAppInterface = paramQQAppInterface.iterator();
      }
      localObject = (MultiMsgNick)paramQQAppInterface.next();
    } while ((localObject == null) || (!paramString.equals(((MultiMsgNick)localObject).uin)) || (paramLong != ((MultiMsgNick)localObject).uniseq));
    return ((MultiMsgNick)localObject).nick;
  }
  
  public List a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    Object localObject = paramQQAppInterface.a().a().a(paramLong);
    paramQQAppInterface = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramQQAppInterface.add((ChatMessage)((Iterator)localObject).next());
    }
    return paramQQAppInterface;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramSessionInfo.clone());
      return;
    }
    catch (CloneNotSupportedException paramSessionInfo) {}
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
    return;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    String str2;
    if (paramQQAppInterface != null)
    {
      String str1 = paramQQAppInterface.a(ServerConfigManager.ConfigType.user, "MMF_enable");
      str2 = paramQQAppInterface.a(ServerConfigManager.ConfigType.user, "MMF_maxMsgNum");
      paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.user, "MMF_maxPicNum");
      System.out.println("barry : initLimitCount enable = " + str1 + " maxMsgNum = " + str2 + " maxPicNum " + paramQQAppInterface);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg", 4, "initLimitCount enable = " + str1 + " maxMsgNum = " + str2 + " maxPicNum " + paramQQAppInterface);
      }
      if (!TextUtils.isEmpty(str1))
      {
        if (!str1.equals("1")) {
          break label188;
        }
        this.jdField_a_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str2)) {}
      try
      {
        this.jdField_a_of_type_Int = Integer.parseInt(str2);
        if (!TextUtils.isEmpty(paramQQAppInterface)) {}
        try
        {
          this.jdField_b_of_type_Int = Integer.parseInt(paramQQAppInterface);
          return;
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          label188:
          this.jdField_b_of_type_Int = 20;
        }
        this.jdField_a_of_type_Boolean = false;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          this.jdField_a_of_type_Int = 100;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageObserver paramMessageObserver, Intent paramIntent, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    paramQQAppInterface.a(new dyd(this, paramArrayList, paramIntent, paramSessionInfo, paramQQAppInterface, paramContext));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramQQAppInterface.a(new dyh(this, paramQQAppInterface, paramString, paramInt, paramLong, paramBoolean));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, long paramLong, DownCallBack paramDownCallBack)
  {
    a(paramQQAppInterface, paramString2, paramQQAppInterface.a(), paramString1, paramString1, paramInt, paramLong, 1035, paramDownCallBack);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, ArrayList paramArrayList, HashMap paramHashMap, MessageRecord paramMessageRecord, MessageObserver paramMessageObserver)
  {
    if (paramMessageRecord == null) {}
    while ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    paramQQAppInterface.a(new dye(this, paramArrayList, paramHashMap, paramMessageRecord, paramQQAppInterface, paramInt, paramString));
  }
  
  public void a(QQAppInterface paramQQAppInterface, List paramList, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localHashMap.put("result", i + "");
      if (paramList == null) {
        break;
      }
      i = paramList.size();
      int j = a().a(paramList);
      localHashMap.put("msgCount", i + "");
      localHashMap.put("picCount", j + "");
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), "multiMsgReceive", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
    StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), "multiMsgReceive", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramChatMessage == null) {
      return;
    }
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForLongMsg)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        if (paramChatMessage.uniseq == localChatMessage.uniseq)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(localChatMessage, Boolean.valueOf(paramBoolean));
          return;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, Boolean.valueOf(paramBoolean));
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg_time", 4, paramString + " =  " + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
    }
  }
  
  /* Error */
  public void a(HashMap paramHashMap, long paramLong, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +184 -> 185
    //   4: aload_1
    //   5: invokevirtual 272	java/util/HashMap:size	()I
    //   8: ifle +177 -> 185
    //   11: new 43	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 44	java/util/ArrayList:<init>	()V
    //   18: astore 5
    //   20: aload_1
    //   21: invokevirtual 468	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   24: invokeinterface 447 1 0
    //   29: astore_1
    //   30: aload_1
    //   31: invokeinterface 234 1 0
    //   36: ifeq +78 -> 114
    //   39: aload_1
    //   40: invokeinterface 238 1 0
    //   45: checkcast 470	java/util/Map$Entry
    //   48: astore 7
    //   50: aload 7
    //   52: invokeinterface 473 1 0
    //   57: checkcast 284	java/lang/String
    //   60: astore 6
    //   62: aload 7
    //   64: invokeinterface 476 1 0
    //   69: checkcast 284	java/lang/String
    //   72: astore 7
    //   74: new 279	com/tencent/mobileqq/multimsg/MultiMsgNick
    //   77: dup
    //   78: invokespecial 305	com/tencent/mobileqq/multimsg/MultiMsgNick:<init>	()V
    //   81: astore 8
    //   83: aload 8
    //   85: aload 6
    //   87: putfield 282	com/tencent/mobileqq/multimsg/MultiMsgNick:uin	Ljava/lang/String;
    //   90: aload 8
    //   92: lload_2
    //   93: putfield 289	com/tencent/mobileqq/multimsg/MultiMsgNick:uniseq	J
    //   96: aload 8
    //   98: aload 7
    //   100: putfield 292	com/tencent/mobileqq/multimsg/MultiMsgNick:nick	Ljava/lang/String;
    //   103: aload 5
    //   105: aload 8
    //   107: invokevirtual 477	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   110: pop
    //   111: goto -81 -> 30
    //   114: aload 4
    //   116: invokevirtual 298	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   119: invokevirtual 304	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   122: astore 4
    //   124: aload 4
    //   126: invokevirtual 480	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 484	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   134: aload 5
    //   136: invokevirtual 485	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   139: astore 5
    //   141: aload 5
    //   143: invokeinterface 234 1 0
    //   148: ifeq +38 -> 186
    //   151: aload 4
    //   153: aload 5
    //   155: invokeinterface 238 1 0
    //   160: checkcast 279	com/tencent/mobileqq/multimsg/MultiMsgNick
    //   163: invokevirtual 488	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   166: goto -25 -> 141
    //   169: astore 5
    //   171: aload 5
    //   173: invokevirtual 491	java/lang/Exception:printStackTrace	()V
    //   176: aload_1
    //   177: invokevirtual 493	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   180: aload 4
    //   182: invokevirtual 494	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   185: return
    //   186: aload_1
    //   187: invokevirtual 496	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   190: aload_1
    //   191: invokevirtual 493	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   194: goto -14 -> 180
    //   197: astore 4
    //   199: aload_1
    //   200: invokevirtual 493	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   203: aload 4
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	MultiMsgManager
    //   0	206	1	paramHashMap	HashMap
    //   0	206	2	paramLong	long
    //   0	206	4	paramQQAppInterface	QQAppInterface
    //   18	136	5	localObject1	Object
    //   169	3	5	localException	java.lang.Exception
    //   60	26	6	str	String
    //   48	51	7	localObject2	Object
    //   81	25	8	localMultiMsgNick	MultiMsgNick
    // Exception table:
    //   from	to	target	type
    //   130	141	169	java/lang/Exception
    //   141	166	169	java/lang/Exception
    //   186	190	169	java/lang/Exception
    //   130	141	197	finally
    //   141	166	197	finally
    //   171	176	197	finally
    //   186	190	197	finally
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, long paramLong, int paramInt2, DownCallBack paramDownCallBack)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_Boolean = false;
    localTransferRequest.jdField_b_of_type_Int = 131078;
    localTransferRequest.i = paramString1;
    localTransferRequest.jdField_a_of_type_JavaLangString = paramString2;
    localTransferRequest.jdField_b_of_type_JavaLangString = paramString3;
    localTransferRequest.c = paramString4;
    localTransferRequest.jdField_a_of_type_Int = paramInt1;
    localTransferRequest.jdField_a_of_type_Long = paramLong;
    localTransferRequest.d = paramInt2;
    localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack = paramDownCallBack;
    paramQQAppInterface.a().a(localTransferRequest);
    return true;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForLongMsg)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        if ((localChatMessage != null) && (paramChatMessage.uniseq == localChatMessage.uniseq) && (this.jdField_a_of_type_JavaUtilHashMap.get(localChatMessage) != null)) {
          return ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localChatMessage)).booleanValue();
        }
      }
      return false;
    }
    if ((paramChatMessage != null) && (this.jdField_a_of_type_JavaUtilHashMap.get(paramChatMessage) != null)) {
      return ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(paramChatMessage)).booleanValue();
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public void b(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg_time", 4, paramString + " =  " + (System.currentTimeMillis() - this.jdField_c_of_type_Long));
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (a().d() >= a().a()) {
      bool = true;
    }
    return bool;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void c()
  {
    this.jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean c()
  {
    boolean bool = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    int i = 0;
    Object localObject1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject1 = (ChatMessage)localIterator.next();
        if (((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1)).booleanValue()) {
          if ((localObject1 instanceof MessageForPic)) {
            i += 1;
          }
        }
      }
    }
    for (;;)
    {
      break;
      if ((localObject1 instanceof MessageForMixedMsg))
      {
        localObject1 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (((MessageRecord)((Iterator)localObject1).next() instanceof MessageForPic)) {
            i += 1;
          }
        }
      }
      else
      {
        int j = i;
        if (((ChatMessage)localObject1).msgtype == -1036)
        {
          localObject1 = ((MessageForLongMsg)localObject1).longMsgFragmentList.iterator();
          do
          {
            j = i;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
          } while (!(localObject2 instanceof MessageForMixedMsg));
          Object localObject2 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          j = i;
          for (;;)
          {
            i = j;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            if (((MessageRecord)((Iterator)localObject2).next() instanceof MessageForPic)) {
              j += 1;
            }
          }
          if (i >= a().b()) {
            bool = true;
          }
          return bool;
        }
        i = j;
      }
    }
  }
  
  public int d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (!((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localChatMessage)).booleanValue()) {
        break label60;
      }
      i += 1;
    }
    label60:
    for (;;)
    {
      break;
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager
 * JD-Core Version:    0.7.0.1
 */