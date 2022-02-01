package com.tencent.qqmail.namelist;

import com.tencent.qqmail.protocol.SimpleOnProtocolListener;

class NameListProtocolManager$1
  extends SimpleOnProtocolListener
{
  NameListProtocolManager$1(NameListProtocolManager paramNameListProtocolManager, int paramInt) {}
  
  /* Error */
  public void onCloudResult(com.tencent.qqmail.protocol.CloudProtocolResult paramCloudProtocolResult)
  {
    // Byte code:
    //   0: iconst_4
    //   1: ldc 24
    //   3: new 26	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   10: ldc 29
    //   12: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: getfield 38	com/tencent/qqmail/protocol/CloudProtocolResult:error_code_	I
    //   19: invokevirtual 41	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 51	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   28: aload_1
    //   29: getfield 38	com/tencent/qqmail/protocol/CloudProtocolResult:error_code_	I
    //   32: ifne +294 -> 326
    //   35: aload_1
    //   36: getfield 55	com/tencent/qqmail/protocol/CloudProtocolResult:lst_bw_contact_rsp_	Lcom/tencent/qqmail/protocol/UMA/CmdLstADBWContactRsp;
    //   39: ifnull +287 -> 326
    //   42: new 57	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 58	java/util/ArrayList:<init>	()V
    //   49: astore_2
    //   50: aload_1
    //   51: getfield 55	com/tencent/qqmail/protocol/CloudProtocolResult:lst_bw_contact_rsp_	Lcom/tencent/qqmail/protocol/UMA/CmdLstADBWContactRsp;
    //   54: getfield 64	com/tencent/qqmail/protocol/UMA/CmdLstADBWContactRsp:black_email	Ljava/util/LinkedList;
    //   57: ifnull +61 -> 118
    //   60: aload_1
    //   61: getfield 55	com/tencent/qqmail/protocol/CloudProtocolResult:lst_bw_contact_rsp_	Lcom/tencent/qqmail/protocol/UMA/CmdLstADBWContactRsp;
    //   64: getfield 64	com/tencent/qqmail/protocol/UMA/CmdLstADBWContactRsp:black_email	Ljava/util/LinkedList;
    //   67: invokevirtual 70	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   70: astore_3
    //   71: aload_3
    //   72: invokeinterface 76 1 0
    //   77: ifeq +41 -> 118
    //   80: aload_3
    //   81: invokeinterface 80 1 0
    //   86: checkcast 82	java/lang/String
    //   89: astore 4
    //   91: aload_2
    //   92: aload_0
    //   93: getfield 12	com/tencent/qqmail/namelist/NameListProtocolManager$1:this$0	Lcom/tencent/qqmail/namelist/NameListProtocolManager;
    //   96: aload_0
    //   97: getfield 14	com/tencent/qqmail/namelist/NameListProtocolManager$1:val$accountId	I
    //   100: aload 4
    //   102: getstatic 88	com/tencent/qqmail/namelist/model/NameListContact$NameListContactType:BLACK	Lcom/tencent/qqmail/namelist/model/NameListContact$NameListContactType;
    //   105: invokevirtual 92	com/tencent/qqmail/namelist/model/NameListContact$NameListContactType:ordinal	()I
    //   108: invokevirtual 98	com/tencent/qqmail/namelist/NameListProtocolManager:transformProtocolContactToNameListContact	(ILjava/lang/String;I)Lcom/tencent/qqmail/namelist/model/NameListContact;
    //   111: invokevirtual 102	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   114: pop
    //   115: goto -44 -> 71
    //   118: aload_1
    //   119: getfield 55	com/tencent/qqmail/protocol/CloudProtocolResult:lst_bw_contact_rsp_	Lcom/tencent/qqmail/protocol/UMA/CmdLstADBWContactRsp;
    //   122: getfield 105	com/tencent/qqmail/protocol/UMA/CmdLstADBWContactRsp:white_email	Ljava/util/LinkedList;
    //   125: ifnull +59 -> 184
    //   128: aload_1
    //   129: getfield 55	com/tencent/qqmail/protocol/CloudProtocolResult:lst_bw_contact_rsp_	Lcom/tencent/qqmail/protocol/UMA/CmdLstADBWContactRsp;
    //   132: getfield 105	com/tencent/qqmail/protocol/UMA/CmdLstADBWContactRsp:white_email	Ljava/util/LinkedList;
    //   135: invokevirtual 70	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   138: astore_1
    //   139: aload_1
    //   140: invokeinterface 76 1 0
    //   145: ifeq +39 -> 184
    //   148: aload_1
    //   149: invokeinterface 80 1 0
    //   154: checkcast 82	java/lang/String
    //   157: astore_3
    //   158: aload_2
    //   159: aload_0
    //   160: getfield 12	com/tencent/qqmail/namelist/NameListProtocolManager$1:this$0	Lcom/tencent/qqmail/namelist/NameListProtocolManager;
    //   163: aload_0
    //   164: getfield 14	com/tencent/qqmail/namelist/NameListProtocolManager$1:val$accountId	I
    //   167: aload_3
    //   168: getstatic 108	com/tencent/qqmail/namelist/model/NameListContact$NameListContactType:WHITE	Lcom/tencent/qqmail/namelist/model/NameListContact$NameListContactType;
    //   171: invokevirtual 92	com/tencent/qqmail/namelist/model/NameListContact$NameListContactType:ordinal	()I
    //   174: invokevirtual 98	com/tencent/qqmail/namelist/NameListProtocolManager:transformProtocolContactToNameListContact	(ILjava/lang/String;I)Lcom/tencent/qqmail/namelist/model/NameListContact;
    //   177: invokevirtual 102	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   180: pop
    //   181: goto -42 -> 139
    //   184: aload_0
    //   185: getfield 12	com/tencent/qqmail/namelist/NameListProtocolManager$1:this$0	Lcom/tencent/qqmail/namelist/NameListProtocolManager;
    //   188: invokestatic 112	com/tencent/qqmail/namelist/NameListProtocolManager:access$000	(Lcom/tencent/qqmail/namelist/NameListProtocolManager;)Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   191: invokevirtual 118	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:getWritableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   194: astore_1
    //   195: aload_1
    //   196: invokevirtual 123	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   199: aload_0
    //   200: getfield 12	com/tencent/qqmail/namelist/NameListProtocolManager$1:this$0	Lcom/tencent/qqmail/namelist/NameListProtocolManager;
    //   203: invokestatic 112	com/tencent/qqmail/namelist/NameListProtocolManager:access$000	(Lcom/tencent/qqmail/namelist/NameListProtocolManager;)Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   206: getfield 127	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:nameList	Lcom/tencent/qqmail/namelist/NameListSQLite;
    //   209: aload_1
    //   210: aload_0
    //   211: getfield 14	com/tencent/qqmail/namelist/NameListProtocolManager$1:val$accountId	I
    //   214: invokevirtual 133	com/tencent/qqmail/namelist/NameListSQLite:deleteNameListContactByAccountId	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;I)V
    //   217: aload_0
    //   218: getfield 12	com/tencent/qqmail/namelist/NameListProtocolManager$1:this$0	Lcom/tencent/qqmail/namelist/NameListProtocolManager;
    //   221: invokestatic 112	com/tencent/qqmail/namelist/NameListProtocolManager:access$000	(Lcom/tencent/qqmail/namelist/NameListProtocolManager;)Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   224: getfield 127	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:nameList	Lcom/tencent/qqmail/namelist/NameListSQLite;
    //   227: aload_1
    //   228: aload_2
    //   229: invokevirtual 137	com/tencent/qqmail/namelist/NameListSQLite:insertNameListContact	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;Ljava/util/ArrayList;)V
    //   232: aload_1
    //   233: invokevirtual 140	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   236: aload_1
    //   237: invokevirtual 143	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   240: aload_0
    //   241: getfield 14	com/tencent/qqmail/namelist/NameListProtocolManager$1:val$accountId	I
    //   244: iconst_1
    //   245: invokestatic 149	com/tencent/qqmail/model/mail/watcher/QMWatcherCenter:triggerLoadNameListSuccess	(IZ)V
    //   248: return
    //   249: astore_2
    //   250: bipush 6
    //   252: ldc 24
    //   254: new 26	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   261: ldc 151
    //   263: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_2
    //   267: invokevirtual 152	java/lang/Exception:toString	()Ljava/lang/String;
    //   270: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 51	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   279: aload_1
    //   280: invokevirtual 143	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   283: goto -43 -> 240
    //   286: astore_1
    //   287: bipush 6
    //   289: ldc 24
    //   291: new 26	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   298: ldc 154
    //   300: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload_1
    //   304: invokevirtual 152	java/lang/Exception:toString	()Ljava/lang/String;
    //   307: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 51	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   316: goto -76 -> 240
    //   319: astore_2
    //   320: aload_1
    //   321: invokevirtual 143	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   324: aload_2
    //   325: athrow
    //   326: aload_0
    //   327: getfield 14	com/tencent/qqmail/namelist/NameListProtocolManager$1:val$accountId	I
    //   330: aconst_null
    //   331: invokestatic 158	com/tencent/qqmail/model/mail/watcher/QMWatcherCenter:triggerLoadNameListError	(ILcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;)V
    //   334: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	1
    //   0	335	1	paramCloudProtocolResult	com.tencent.qqmail.protocol.CloudProtocolResult
    //   49	180	2	localArrayList	java.util.ArrayList
    //   249	18	2	localException	java.lang.Exception
    //   319	6	2	localObject1	java.lang.Object
    //   70	98	3	localObject2	java.lang.Object
    //   89	12	4	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   195	236	249	java/lang/Exception
    //   184	195	286	java/lang/Exception
    //   236	240	286	java/lang/Exception
    //   279	283	286	java/lang/Exception
    //   320	326	286	java/lang/Exception
    //   195	236	319	finally
    //   250	279	319	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.NameListProtocolManager.1
 * JD-Core Version:    0.7.0.1
 */