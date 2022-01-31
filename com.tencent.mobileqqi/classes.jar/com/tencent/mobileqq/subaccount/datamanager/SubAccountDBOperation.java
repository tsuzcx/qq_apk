package com.tencent.mobileqq.subaccount.datamanager;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class SubAccountDBOperation
{
  private static String a = "Q.subaccount.SubAccountDBOperation";
  
  private SubAccountInfo a(EntityManager paramEntityManager, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramEntityManager != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString)) {
        localObject1 = (SubAccountInfo)paramEntityManager.a(SubAccountInfo.class, "subuin=?", new String[] { paramString });
      }
    }
    return localObject1;
  }
  
  public SubAccountInfo a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    try
    {
      SubAccountInfo localSubAccountInfo2 = (SubAccountInfo)localEntityManager.a(SubAccountInfo.class, "subuin=?", new String[] { paramString });
      SubAccountInfo localSubAccountInfo1 = localSubAccountInfo2;
      if (localSubAccountInfo2 == null)
      {
        localSubAccountInfo1 = new SubAccountInfo();
        localSubAccountInfo1.subuin = paramString;
        localSubAccountInfo1.subname = "";
        localSubAccountInfo1.isbind = 0;
        localSubAccountInfo1.trunkuin = paramQQAppInterface.a();
        localSubAccountInfo1.lasttime = 0L;
        localSubAccountInfo1.cookie = null;
        localEntityManager.a(localSubAccountInfo1);
      }
      return localSubAccountInfo1;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      return null;
    }
    finally
    {
      localEntityManager.a();
    }
  }
  
  public SubAccountMessage a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      try
      {
        paramString = (SubAccountMessage)paramQQAppInterface.a(SubAccountMessage.class, "senderuin=?", new String[] { paramString });
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      finally
      {
        paramQQAppInterface.a();
      }
    }
    return null;
  }
  
  /* Error */
  public java.util.List a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: ifnull +24 -> 27
    //   6: aload_1
    //   7: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   10: invokevirtual 48	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore_2
    //   14: aload_2
    //   15: ldc 86
    //   17: invokevirtual 92	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   20: astore_1
    //   21: aload_2
    //   22: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   25: aload_1
    //   26: astore_2
    //   27: aload_2
    //   28: areturn
    //   29: astore_1
    //   30: aload_2
    //   31: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   34: aconst_null
    //   35: areturn
    //   36: astore_1
    //   37: aload_2
    //   38: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	SubAccountDBOperation
    //   0	43	1	paramQQAppInterface	QQAppInterface
    //   1	37	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	21	29	java/lang/Exception
    //   14	21	36	finally
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    try
    {
      String str = new SubAccountMessage().getTableName();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("isread", Boolean.valueOf(true));
      boolean bool = paramQQAppInterface.a(str, localContentValues, "isread=?", new String[] { "0" });
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "setAllSubMessageReaded state, isOK = " + bool);
      }
      localContentValues = new ContentValues();
      localContentValues.put("unreadNum", Integer.valueOf(0));
      bool = paramQQAppInterface.a(str, localContentValues, "unreadNum>?", new String[] { "0" });
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "setAllSubMessageReaded num, isOK= " + bool);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      paramQQAppInterface.a();
    }
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, SubAccountInfo paramSubAccountInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +139 -> 140
    //   4: aload_2
    //   5: ifnull +135 -> 140
    //   8: aload_2
    //   9: getfield 52	com/tencent/mobileqq/data/SubAccountInfo:subuin	Ljava/lang/String;
    //   12: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +125 -> 140
    //   18: aload_1
    //   19: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   22: invokevirtual 48	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   25: astore_1
    //   26: aload_1
    //   27: ldc 25
    //   29: ldc 27
    //   31: iconst_1
    //   32: anewarray 29	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: aload_2
    //   38: getfield 52	com/tencent/mobileqq/data/SubAccountInfo:subuin	Ljava/lang/String;
    //   41: aastore
    //   42: invokevirtual 34	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   45: checkcast 25	com/tencent/mobileqq/data/SubAccountInfo
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +91 -> 141
    //   53: aload_3
    //   54: aload_2
    //   55: getfield 52	com/tencent/mobileqq/data/SubAccountInfo:subuin	Ljava/lang/String;
    //   58: putfield 52	com/tencent/mobileqq/data/SubAccountInfo:subuin	Ljava/lang/String;
    //   61: aload_3
    //   62: aload_2
    //   63: getfield 57	com/tencent/mobileqq/data/SubAccountInfo:subname	Ljava/lang/String;
    //   66: putfield 57	com/tencent/mobileqq/data/SubAccountInfo:subname	Ljava/lang/String;
    //   69: aload_3
    //   70: aload_2
    //   71: getfield 67	com/tencent/mobileqq/data/SubAccountInfo:trunkuin	Ljava/lang/String;
    //   74: putfield 67	com/tencent/mobileqq/data/SubAccountInfo:trunkuin	Ljava/lang/String;
    //   77: aload_3
    //   78: aload_2
    //   79: getfield 61	com/tencent/mobileqq/data/SubAccountInfo:isbind	B
    //   82: putfield 61	com/tencent/mobileqq/data/SubAccountInfo:isbind	B
    //   85: aload_3
    //   86: aload_2
    //   87: getfield 71	com/tencent/mobileqq/data/SubAccountInfo:lasttime	J
    //   90: putfield 71	com/tencent/mobileqq/data/SubAccountInfo:lasttime	J
    //   93: aload_3
    //   94: aload_2
    //   95: getfield 162	com/tencent/mobileqq/data/SubAccountInfo:serverErrorMsg	Ljava/lang/String;
    //   98: putfield 162	com/tencent/mobileqq/data/SubAccountInfo:serverErrorMsg	Ljava/lang/String;
    //   101: aload_3
    //   102: aload_2
    //   103: getfield 166	com/tencent/mobileqq/data/SubAccountInfo:serverErrorType	I
    //   106: putfield 166	com/tencent/mobileqq/data/SubAccountInfo:serverErrorType	I
    //   109: aload_2
    //   110: getfield 75	com/tencent/mobileqq/data/SubAccountInfo:cookie	[B
    //   113: ifnull +17 -> 130
    //   116: aload_3
    //   117: aload_2
    //   118: getfield 75	com/tencent/mobileqq/data/SubAccountInfo:cookie	[B
    //   121: invokevirtual 171	[B:clone	()Ljava/lang/Object;
    //   124: checkcast 167	[B
    //   127: putfield 75	com/tencent/mobileqq/data/SubAccountInfo:cookie	[B
    //   130: aload_1
    //   131: aload_3
    //   132: invokevirtual 174	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   135: pop
    //   136: aload_1
    //   137: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   140: return
    //   141: aload_1
    //   142: aload_2
    //   143: invokevirtual 78	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   146: goto -10 -> 136
    //   149: astore_2
    //   150: aload_2
    //   151: invokevirtual 83	java/lang/Exception:printStackTrace	()V
    //   154: aload_1
    //   155: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   158: return
    //   159: astore_2
    //   160: aload_1
    //   161: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   164: aload_2
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	SubAccountDBOperation
    //   0	166	1	paramQQAppInterface	QQAppInterface
    //   0	166	2	paramSubAccountInfo	SubAccountInfo
    //   48	84	3	localSubAccountInfo	SubAccountInfo
    // Exception table:
    //   from	to	target	type
    //   26	49	149	java/lang/Exception
    //   53	130	149	java/lang/Exception
    //   130	136	149	java/lang/Exception
    //   141	146	149	java/lang/Exception
    //   26	49	159	finally
    //   53	130	159	finally
    //   130	136	159	finally
    //   141	146	159	finally
    //   150	154	159	finally
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, SubAccountMessage paramSubAccountMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +246 -> 247
    //   4: aload_2
    //   5: ifnull +242 -> 247
    //   8: aload_2
    //   9: getfield 178	com/tencent/mobileqq/data/SubAccountMessage:senderuin	Ljava/lang/String;
    //   12: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +232 -> 247
    //   18: aload_1
    //   19: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   22: invokevirtual 48	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   25: astore_1
    //   26: aload_1
    //   27: ldc 86
    //   29: ldc 88
    //   31: iconst_1
    //   32: anewarray 29	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: aload_2
    //   38: getfield 178	com/tencent/mobileqq/data/SubAccountMessage:senderuin	Ljava/lang/String;
    //   41: aastore
    //   42: invokevirtual 34	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   45: checkcast 86	com/tencent/mobileqq/data/SubAccountMessage
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +198 -> 248
    //   53: aload_3
    //   54: aload_2
    //   55: getfield 181	com/tencent/mobileqq/data/SubAccountMessage:selfuin	Ljava/lang/String;
    //   58: putfield 181	com/tencent/mobileqq/data/SubAccountMessage:selfuin	Ljava/lang/String;
    //   61: aload_3
    //   62: aload_2
    //   63: getfield 184	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   66: putfield 184	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   69: aload_3
    //   70: aload_2
    //   71: getfield 187	com/tencent/mobileqq/data/SubAccountMessage:sendername	Ljava/lang/String;
    //   74: putfield 187	com/tencent/mobileqq/data/SubAccountMessage:sendername	Ljava/lang/String;
    //   77: aload_3
    //   78: aload_2
    //   79: getfield 178	com/tencent/mobileqq/data/SubAccountMessage:senderuin	Ljava/lang/String;
    //   82: putfield 178	com/tencent/mobileqq/data/SubAccountMessage:senderuin	Ljava/lang/String;
    //   85: aload_3
    //   86: aload_2
    //   87: getfield 190	com/tencent/mobileqq/data/SubAccountMessage:time	J
    //   90: putfield 190	com/tencent/mobileqq/data/SubAccountMessage:time	J
    //   93: aload_3
    //   94: aload_2
    //   95: getfield 193	com/tencent/mobileqq/data/SubAccountMessage:msgtype	I
    //   98: putfield 193	com/tencent/mobileqq/data/SubAccountMessage:msgtype	I
    //   101: aload_3
    //   102: aload_2
    //   103: getfield 196	com/tencent/mobileqq/data/SubAccountMessage:msg	Ljava/lang/String;
    //   106: putfield 196	com/tencent/mobileqq/data/SubAccountMessage:msg	Ljava/lang/String;
    //   109: aload_3
    //   110: aload_2
    //   111: getfield 199	com/tencent/mobileqq/data/SubAccountMessage:isread	Z
    //   114: putfield 199	com/tencent/mobileqq/data/SubAccountMessage:isread	Z
    //   117: aload_3
    //   118: aload_2
    //   119: getfield 202	com/tencent/mobileqq/data/SubAccountMessage:isValid	Z
    //   122: putfield 202	com/tencent/mobileqq/data/SubAccountMessage:isValid	Z
    //   125: aload_3
    //   126: aload_2
    //   127: getfield 205	com/tencent/mobileqq/data/SubAccountMessage:msgData	[B
    //   130: putfield 205	com/tencent/mobileqq/data/SubAccountMessage:msgData	[B
    //   133: aload_3
    //   134: aload_2
    //   135: getfield 208	com/tencent/mobileqq/data/SubAccountMessage:extInt	I
    //   138: putfield 208	com/tencent/mobileqq/data/SubAccountMessage:extInt	I
    //   141: aload_3
    //   142: aload_2
    //   143: getfield 208	com/tencent/mobileqq/data/SubAccountMessage:extInt	I
    //   146: putfield 211	com/tencent/mobileqq/data/SubAccountMessage:extLong	I
    //   149: aload_3
    //   150: aload_2
    //   151: getfield 214	com/tencent/mobileqq/data/SubAccountMessage:extraflag	I
    //   154: putfield 214	com/tencent/mobileqq/data/SubAccountMessage:extraflag	I
    //   157: aload_3
    //   158: aload_2
    //   159: getfield 217	com/tencent/mobileqq/data/SubAccountMessage:extStr	Ljava/lang/String;
    //   162: putfield 217	com/tencent/mobileqq/data/SubAccountMessage:extStr	Ljava/lang/String;
    //   165: aload_3
    //   166: aload_2
    //   167: getfield 220	com/tencent/mobileqq/data/SubAccountMessage:longMsgCount	I
    //   170: putfield 220	com/tencent/mobileqq/data/SubAccountMessage:longMsgCount	I
    //   173: aload_3
    //   174: aload_2
    //   175: getfield 223	com/tencent/mobileqq/data/SubAccountMessage:longMsgId	I
    //   178: putfield 223	com/tencent/mobileqq/data/SubAccountMessage:longMsgId	I
    //   181: aload_3
    //   182: aload_2
    //   183: getfield 226	com/tencent/mobileqq/data/SubAccountMessage:longMsgIndex	I
    //   186: putfield 226	com/tencent/mobileqq/data/SubAccountMessage:longMsgIndex	I
    //   189: aload_3
    //   190: aload_2
    //   191: getfield 229	com/tencent/mobileqq/data/SubAccountMessage:msgseq	J
    //   194: putfield 229	com/tencent/mobileqq/data/SubAccountMessage:msgseq	J
    //   197: aload_3
    //   198: aload_2
    //   199: getfield 232	com/tencent/mobileqq/data/SubAccountMessage:shmsgseq	J
    //   202: putfield 232	com/tencent/mobileqq/data/SubAccountMessage:shmsgseq	J
    //   205: aload_3
    //   206: aload_2
    //   207: getfield 235	com/tencent/mobileqq/data/SubAccountMessage:uniseq	J
    //   210: putfield 235	com/tencent/mobileqq/data/SubAccountMessage:uniseq	J
    //   213: aload_3
    //   214: aload_2
    //   215: getfield 237	com/tencent/mobileqq/data/SubAccountMessage:unreadNum	I
    //   218: putfield 237	com/tencent/mobileqq/data/SubAccountMessage:unreadNum	I
    //   221: aload_3
    //   222: aload_2
    //   223: getfield 240	com/tencent/mobileqq/data/SubAccountMessage:vipBubbleID	J
    //   226: putfield 240	com/tencent/mobileqq/data/SubAccountMessage:vipBubbleID	J
    //   229: aload_3
    //   230: aload_2
    //   231: getfield 243	com/tencent/mobileqq/data/SubAccountMessage:istroop	I
    //   234: putfield 243	com/tencent/mobileqq/data/SubAccountMessage:istroop	I
    //   237: aload_1
    //   238: aload_3
    //   239: invokevirtual 174	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   242: pop
    //   243: aload_1
    //   244: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   247: return
    //   248: aload_1
    //   249: aload_2
    //   250: invokevirtual 78	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   253: goto -10 -> 243
    //   256: astore_2
    //   257: aload_2
    //   258: invokevirtual 83	java/lang/Exception:printStackTrace	()V
    //   261: aload_1
    //   262: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   265: return
    //   266: astore_2
    //   267: aload_1
    //   268: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   271: aload_2
    //   272: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	SubAccountDBOperation
    //   0	273	1	paramQQAppInterface	QQAppInterface
    //   0	273	2	paramSubAccountMessage	SubAccountMessage
    //   48	191	3	localSubAccountMessage	SubAccountMessage
    // Exception table:
    //   from	to	target	type
    //   26	49	256	java/lang/Exception
    //   53	243	256	java/lang/Exception
    //   248	253	256	java/lang/Exception
    //   26	49	266	finally
    //   53	243	266	finally
    //   248	253	266	finally
    //   257	261	266	finally
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    try
    {
      paramString = (SubAccountMessage)paramQQAppInterface.a(SubAccountMessage.class, "senderuin=?", new String[] { paramString });
      if (paramString == null) {
        return;
      }
      boolean bool = paramQQAppInterface.b(paramString);
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "removeMsg: isDelete = " + bool);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    finally
    {
      paramQQAppInterface.a();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString1))) {
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    }
    try
    {
      paramString1 = (SubAccountInfo)paramQQAppInterface.a(SubAccountInfo.class, "subuin=?", new String[] { paramString1 });
      if (paramString1 == null) {
        return;
      }
      paramString1.serverErrorMsg = paramString2;
      paramString1.serverErrorType = paramInt;
      paramQQAppInterface.a(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    finally
    {
      paramQQAppInterface.a();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString))) {
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    }
    try
    {
      paramString = (SubAccountInfo)paramQQAppInterface.a(SubAccountInfo.class, "subuin=?", new String[] { paramString });
      if (paramString == null) {
        return;
      }
      paramString.cookie = paramArrayOfByte;
      paramQQAppInterface.a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    finally
    {
      paramQQAppInterface.a();
    }
  }
  
  public SubAccountInfo b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      try
      {
        paramString = (SubAccountInfo)paramQQAppInterface.a(SubAccountInfo.class, "subuin=?", new String[] { paramString });
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      finally
      {
        paramQQAppInterface.a();
      }
    }
    return null;
  }
  
  /* Error */
  public java.util.List b(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: ifnull +24 -> 27
    //   6: aload_1
    //   7: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   10: invokevirtual 48	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore_2
    //   14: aload_2
    //   15: ldc 25
    //   17: invokevirtual 92	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   20: astore_1
    //   21: aload_2
    //   22: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   25: aload_1
    //   26: astore_2
    //   27: aload_2
    //   28: areturn
    //   29: astore_1
    //   30: aload_2
    //   31: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   34: aconst_null
    //   35: areturn
    //   36: astore_1
    //   37: aload_2
    //   38: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	SubAccountDBOperation
    //   0	43	1	paramQQAppInterface	QQAppInterface
    //   1	37	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	21	29	java/lang/Exception
    //   14	21	36	finally
  }
  
  /* Error */
  public void b(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +69 -> 70
    //   4: aload_1
    //   5: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   8: invokevirtual 48	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: astore_1
    //   12: aload_1
    //   13: ldc 86
    //   15: invokevirtual 92	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   18: astore_2
    //   19: aload_2
    //   20: ifnull +51 -> 71
    //   23: aload_2
    //   24: invokeinterface 257 1 0
    //   29: ifle +42 -> 71
    //   32: aload_2
    //   33: invokeinterface 261 1 0
    //   38: astore_2
    //   39: aload_2
    //   40: invokeinterface 266 1 0
    //   45: ifeq +26 -> 71
    //   48: aload_1
    //   49: aload_2
    //   50: invokeinterface 269 1 0
    //   55: checkcast 86	com/tencent/mobileqq/data/SubAccountMessage
    //   58: invokevirtual 247	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   61: pop
    //   62: goto -23 -> 39
    //   65: astore_2
    //   66: aload_1
    //   67: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   70: return
    //   71: aload_1
    //   72: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   75: return
    //   76: astore_2
    //   77: aload_1
    //   78: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   81: aload_2
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	SubAccountDBOperation
    //   0	83	1	paramQQAppInterface	QQAppInterface
    //   18	32	2	localObject1	Object
    //   65	1	2	localException	Exception
    //   76	6	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	19	65	java/lang/Exception
    //   23	39	65	java/lang/Exception
    //   39	62	65	java/lang/Exception
    //   12	19	76	finally
    //   23	39	76	finally
    //   39	62	76	finally
  }
  
  public void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString))) {
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    }
    try
    {
      paramString = a(paramQQAppInterface, paramString);
      if (paramString != null) {
        paramQQAppInterface.b(paramString);
      }
      return;
    }
    catch (Exception paramString) {}finally
    {
      paramQQAppInterface.a();
    }
  }
  
  /* Error */
  public void c(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +69 -> 70
    //   4: aload_1
    //   5: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   8: invokevirtual 48	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: astore_1
    //   12: aload_1
    //   13: ldc 25
    //   15: invokevirtual 92	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   18: astore_2
    //   19: aload_2
    //   20: ifnull +51 -> 71
    //   23: aload_2
    //   24: invokeinterface 257 1 0
    //   29: ifle +42 -> 71
    //   32: aload_2
    //   33: invokeinterface 261 1 0
    //   38: astore_2
    //   39: aload_2
    //   40: invokeinterface 266 1 0
    //   45: ifeq +26 -> 71
    //   48: aload_1
    //   49: aload_2
    //   50: invokeinterface 269 1 0
    //   55: checkcast 25	com/tencent/mobileqq/data/SubAccountInfo
    //   58: invokevirtual 247	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   61: pop
    //   62: goto -23 -> 39
    //   65: astore_2
    //   66: aload_1
    //   67: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   70: return
    //   71: aload_1
    //   72: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   75: return
    //   76: astore_2
    //   77: aload_1
    //   78: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   81: aload_2
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	SubAccountDBOperation
    //   0	83	1	paramQQAppInterface	QQAppInterface
    //   18	32	2	localObject1	Object
    //   65	1	2	localException	Exception
    //   76	6	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	19	65	java/lang/Exception
    //   23	39	65	java/lang/Exception
    //   39	62	65	java/lang/Exception
    //   12	19	76	finally
    //   23	39	76	finally
    //   39	62	76	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.datamanager.SubAccountDBOperation
 * JD-Core Version:    0.7.0.1
 */