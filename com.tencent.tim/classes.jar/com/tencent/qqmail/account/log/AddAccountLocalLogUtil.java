package com.tencent.qqmail.account.log;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Iterator;

public class AddAccountLocalLogUtil
{
  public static final int EmailAliasExist = 5;
  public static final int EmailExist = 4;
  public static final int EmailInvalid = 1;
  public static final int InputInvalid = 2;
  public static final int NetworkTips = 3;
  private static final String TAG = "AddAccountLocalLogUtil";
  private static final int local_inner_length = 5;
  
  public static String genAddAccountFailLog(String paramString, long paramLong)
  {
    return "DetailEventError -- AccountAddress:" + paramString + "&ErrorType:" + paramLong;
  }
  
  private static String genLocalAddAccountErrorCode(boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {
      localStringBuilder.append("19");
    }
    for (;;)
    {
      String str = String.valueOf(paramInt);
      if (str.length() > 5) {
        break label87;
      }
      int i = str.length();
      while (i < 5)
      {
        localStringBuilder.append("0");
        i += 1;
      }
      localStringBuilder.append("29");
    }
    localStringBuilder.append(paramInt);
    localStringBuilder.append("000");
    return localStringBuilder.toString();
    label87:
    QMLog.log(4, "AddAccountLocalLogUtil", "genLocalAddAccountErrorCode. errcode:" + paramInt);
    return "00000000";
  }
  
  public static String getAllAccountLog()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    Iterator localIterator = localAccountList.iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      localStringBuilder.append(localAccount.getId()).append(". ").append(localAccount.getEmail()).append("#profileString:").append(localAccount.getProfileString()).append("#protocolType:").append(localAccount.getProtocolType()).append("#protocol:").append(localAccount.getProtocol()).append("\r\n");
    }
    QMLog.log(4, "AddAccountLocalLogUtil", "getAllAccountLog. accs:" + localAccountList.size() + ",detail:" + localStringBuilder.toString());
    return localStringBuilder.toString();
  }
  
  public static void logAddAccountLocalFail(String paramString, AccountType paramAccountType, int paramInt)
  {
    boolean bool = true;
    int i;
    if ((paramAccountType != null) && ((paramAccountType == AccountType.qqmail) || (paramAccountType == AccountType.exmail)))
    {
      i = 1;
      if (i != 0) {
        break label58;
      }
    }
    for (;;)
    {
      long l = Long.parseLong(genLocalAddAccountErrorCode(bool, paramInt));
      DataCollector.logDetailEvent("DetailEvent_Local_AddAccount", 0L, l, genAddAccountFailLog(paramString, l));
      return;
      i = 0;
      break;
      label58:
      bool = false;
    }
  }
  
  /* Error */
  public static void timeLineAccountChange(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 176	java/io/File
    //   3: dup
    //   4: invokestatic 182	com/tencent/qqmail/utilities/log/LogPathManager:getInstance	()Lcom/tencent/qqmail/utilities/log/LogPathManager;
    //   7: invokevirtual 185	com/tencent/qqmail/utilities/log/LogPathManager:getQMLogTimelineFilePath	()Ljava/lang/String;
    //   10: invokespecial 188	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 191	java/io/File:exists	()Z
    //   18: ifne +8 -> 26
    //   21: aload_2
    //   22: invokevirtual 194	java/io/File:createNewFile	()Z
    //   25: pop
    //   26: new 196	java/io/BufferedWriter
    //   29: dup
    //   30: new 198	java/io/FileWriter
    //   33: dup
    //   34: aload_2
    //   35: iconst_1
    //   36: invokespecial 201	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   39: invokespecial 204	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   42: astore_3
    //   43: aload_3
    //   44: astore_2
    //   45: aload_3
    //   46: aload_0
    //   47: invokevirtual 207	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   50: aload_3
    //   51: astore_2
    //   52: aload_3
    //   53: ldc 209
    //   55: invokevirtual 207	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   58: aload_3
    //   59: astore_2
    //   60: aload_3
    //   61: invokestatic 215	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   64: invokevirtual 219	com/tencent/qqmail/QMApplicationContext:getVid	()J
    //   67: invokestatic 222	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   70: invokevirtual 207	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   73: aload_3
    //   74: astore_2
    //   75: aload_3
    //   76: ldc 209
    //   78: invokevirtual 207	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   81: aload_3
    //   82: astore_2
    //   83: aload_3
    //   84: new 224	java/text/SimpleDateFormat
    //   87: dup
    //   88: ldc 226
    //   90: invokespecial 227	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   93: new 229	java/util/Date
    //   96: dup
    //   97: invokespecial 230	java/util/Date:<init>	()V
    //   100: invokevirtual 234	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   103: invokevirtual 207	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   106: aload_3
    //   107: astore_2
    //   108: aload_3
    //   109: ldc 209
    //   111: invokevirtual 207	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   114: aload_3
    //   115: astore_2
    //   116: aload_3
    //   117: aload_1
    //   118: invokevirtual 207	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   121: aload_3
    //   122: astore_2
    //   123: aload_3
    //   124: ldc 209
    //   126: invokevirtual 207	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   129: aload_3
    //   130: astore_2
    //   131: aload_3
    //   132: invokestatic 239	com/tencent/qqmail/marcos/AppConfig:getCodeVersion	()Ljava/lang/String;
    //   135: invokevirtual 207	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   138: aload_3
    //   139: astore_2
    //   140: aload_3
    //   141: ldc 241
    //   143: invokevirtual 207	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   146: aload_3
    //   147: astore_2
    //   148: aload_3
    //   149: invokevirtual 244	java/io/BufferedWriter:flush	()V
    //   152: aload_3
    //   153: ifnull +7 -> 160
    //   156: aload_3
    //   157: invokevirtual 247	java/io/BufferedWriter:close	()V
    //   160: return
    //   161: astore_0
    //   162: bipush 6
    //   164: ldc 19
    //   166: new 29	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   173: ldc 249
    //   175: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_0
    //   179: invokevirtual 250	java/io/IOException:toString	()Ljava/lang/String;
    //   182: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 76	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   191: return
    //   192: astore 4
    //   194: aconst_null
    //   195: astore_0
    //   196: aload_0
    //   197: astore_2
    //   198: bipush 6
    //   200: ldc 19
    //   202: new 29	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   209: ldc 252
    //   211: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 4
    //   216: invokevirtual 253	java/lang/Exception:toString	()Ljava/lang/String;
    //   219: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc 112
    //   224: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_1
    //   228: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 76	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   237: aload_0
    //   238: ifnull -78 -> 160
    //   241: aload_0
    //   242: invokevirtual 247	java/io/BufferedWriter:close	()V
    //   245: return
    //   246: astore_0
    //   247: return
    //   248: astore_0
    //   249: aconst_null
    //   250: astore_2
    //   251: aload_2
    //   252: ifnull +7 -> 259
    //   255: aload_2
    //   256: invokevirtual 247	java/io/BufferedWriter:close	()V
    //   259: aload_0
    //   260: athrow
    //   261: astore_0
    //   262: return
    //   263: astore_1
    //   264: goto -5 -> 259
    //   267: astore_0
    //   268: goto -17 -> 251
    //   271: astore 4
    //   273: aload_3
    //   274: astore_0
    //   275: goto -79 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramString1	String
    //   0	278	1	paramString2	String
    //   13	243	2	localObject	Object
    //   42	232	3	localBufferedWriter	java.io.BufferedWriter
    //   192	23	4	localException1	java.lang.Exception
    //   271	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   21	26	161	java/io/IOException
    //   26	43	192	java/lang/Exception
    //   241	245	246	java/io/IOException
    //   26	43	248	finally
    //   156	160	261	java/io/IOException
    //   255	259	263	java/io/IOException
    //   45	50	267	finally
    //   52	58	267	finally
    //   60	73	267	finally
    //   75	81	267	finally
    //   83	106	267	finally
    //   108	114	267	finally
    //   116	121	267	finally
    //   123	129	267	finally
    //   131	138	267	finally
    //   140	146	267	finally
    //   148	152	267	finally
    //   198	237	267	finally
    //   45	50	271	java/lang/Exception
    //   52	58	271	java/lang/Exception
    //   60	73	271	java/lang/Exception
    //   75	81	271	java/lang/Exception
    //   83	106	271	java/lang/Exception
    //   108	114	271	java/lang/Exception
    //   116	121	271	java/lang/Exception
    //   123	129	271	java/lang/Exception
    //   131	138	271	java/lang/Exception
    //   140	146	271	java/lang/Exception
    //   148	152	271	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.log.AddAccountLocalLogUtil
 * JD-Core Version:    0.7.0.1
 */