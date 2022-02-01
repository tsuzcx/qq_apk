package com.tencent.qqmail.namelist;

import com.tencent.qqmail.protocol.SimpleOnProtocolListener;

class NameListProtocolManager$3
  extends SimpleOnProtocolListener
{
  NameListProtocolManager$3(NameListProtocolManager paramNameListProtocolManager, int paramInt1, String[] paramArrayOfString, int paramInt2) {}
  
  /* Error */
  public void onCloudResult(com.tencent.qqmail.protocol.CloudProtocolResult paramCloudProtocolResult)
  {
    // Byte code:
    //   0: iconst_4
    //   1: ldc 31
    //   3: new 33	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   10: ldc 36
    //   12: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: getfield 45	com/tencent/qqmail/protocol/CloudProtocolResult:error_code_	I
    //   19: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 58	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   28: aload_1
    //   29: getfield 45	com/tencent/qqmail/protocol/CloudProtocolResult:error_code_	I
    //   32: ifne +141 -> 173
    //   35: aload_0
    //   36: getfield 15	com/tencent/qqmail/namelist/NameListProtocolManager$3:this$0	Lcom/tencent/qqmail/namelist/NameListProtocolManager;
    //   39: invokestatic 64	com/tencent/qqmail/namelist/NameListProtocolManager:access$000	(Lcom/tencent/qqmail/namelist/NameListProtocolManager;)Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   42: invokevirtual 70	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:getWritableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   45: astore_1
    //   46: aload_1
    //   47: invokevirtual 75	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   50: aload_0
    //   51: getfield 15	com/tencent/qqmail/namelist/NameListProtocolManager$3:this$0	Lcom/tencent/qqmail/namelist/NameListProtocolManager;
    //   54: invokestatic 64	com/tencent/qqmail/namelist/NameListProtocolManager:access$000	(Lcom/tencent/qqmail/namelist/NameListProtocolManager;)Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   57: getfield 79	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:nameList	Lcom/tencent/qqmail/namelist/NameListSQLite;
    //   60: aload_1
    //   61: aload_0
    //   62: getfield 17	com/tencent/qqmail/namelist/NameListProtocolManager$3:val$accountId	I
    //   65: aload_0
    //   66: getfield 19	com/tencent/qqmail/namelist/NameListProtocolManager$3:val$emails	[Ljava/lang/String;
    //   69: invokevirtual 85	com/tencent/qqmail/namelist/NameListSQLite:deleteNameListContactByAccountIdAndEmail	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;I[Ljava/lang/String;)V
    //   72: aload_1
    //   73: invokevirtual 88	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   76: aload_1
    //   77: invokevirtual 91	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   80: aload_0
    //   81: getfield 17	com/tencent/qqmail/namelist/NameListProtocolManager$3:val$accountId	I
    //   84: aload_0
    //   85: getfield 21	com/tencent/qqmail/namelist/NameListProtocolManager$3:val$type	I
    //   88: aload_0
    //   89: getfield 19	com/tencent/qqmail/namelist/NameListProtocolManager$3:val$emails	[Ljava/lang/String;
    //   92: invokestatic 97	com/tencent/qqmail/model/mail/watcher/QMWatcherCenter:triggerDeleteNameListSuccess	(II[Ljava/lang/String;)V
    //   95: return
    //   96: astore_2
    //   97: bipush 6
    //   99: ldc 31
    //   101: new 33	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   108: ldc 99
    //   110: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_2
    //   114: invokevirtual 100	java/lang/Exception:toString	()Ljava/lang/String;
    //   117: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 58	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   126: aload_1
    //   127: invokevirtual 91	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   130: goto -50 -> 80
    //   133: astore_1
    //   134: bipush 6
    //   136: ldc 31
    //   138: new 33	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   145: ldc 102
    //   147: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_1
    //   151: invokevirtual 100	java/lang/Exception:toString	()Ljava/lang/String;
    //   154: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 58	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   163: goto -83 -> 80
    //   166: astore_2
    //   167: aload_1
    //   168: invokevirtual 91	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   171: aload_2
    //   172: athrow
    //   173: aload_0
    //   174: getfield 17	com/tencent/qqmail/namelist/NameListProtocolManager$3:val$accountId	I
    //   177: aload_0
    //   178: getfield 21	com/tencent/qqmail/namelist/NameListProtocolManager$3:val$type	I
    //   181: aload_0
    //   182: getfield 19	com/tencent/qqmail/namelist/NameListProtocolManager$3:val$emails	[Ljava/lang/String;
    //   185: aconst_null
    //   186: invokestatic 106	com/tencent/qqmail/model/mail/watcher/QMWatcherCenter:triggerDeleteNameListError	(II[Ljava/lang/String;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;)V
    //   189: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	3
    //   0	190	1	paramCloudProtocolResult	com.tencent.qqmail.protocol.CloudProtocolResult
    //   96	18	2	localException	java.lang.Exception
    //   166	6	2	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   46	76	96	java/lang/Exception
    //   35	46	133	java/lang/Exception
    //   76	80	133	java/lang/Exception
    //   126	130	133	java/lang/Exception
    //   167	173	133	java/lang/Exception
    //   46	76	166	finally
    //   97	126	166	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.NameListProtocolManager.3
 * JD-Core Version:    0.7.0.1
 */