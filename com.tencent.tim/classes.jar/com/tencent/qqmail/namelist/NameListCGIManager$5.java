package com.tencent.qqmail.namelist;

import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;

class NameListCGIManager$5
  implements QMCallback.ISuccessCallback
{
  NameListCGIManager$5(NameListCGIManager paramNameListCGIManager, int paramInt1, int paramInt2, String[] paramArrayOfString) {}
  
  /* Error */
  public void run(com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest paramQMNetworkRequest, com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse paramQMNetworkResponse)
  {
    // Byte code:
    //   0: iconst_3
    //   1: ldc 33
    //   3: new 35	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   10: ldc 38
    //   12: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: getfield 19	com/tencent/qqmail/namelist/NameListCGIManager$5:val$type	I
    //   19: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc 47
    //   24: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 57	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: getfield 17	com/tencent/qqmail/namelist/NameListCGIManager$5:this$0	Lcom/tencent/qqmail/namelist/NameListCGIManager;
    //   37: invokestatic 63	com/tencent/qqmail/namelist/NameListCGIManager:access$000	(Lcom/tencent/qqmail/namelist/NameListCGIManager;)Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   40: invokevirtual 69	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:getWritableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   43: astore_1
    //   44: aload_1
    //   45: invokevirtual 74	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   48: aload_0
    //   49: getfield 17	com/tencent/qqmail/namelist/NameListCGIManager$5:this$0	Lcom/tencent/qqmail/namelist/NameListCGIManager;
    //   52: invokestatic 63	com/tencent/qqmail/namelist/NameListCGIManager:access$000	(Lcom/tencent/qqmail/namelist/NameListCGIManager;)Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   55: getfield 78	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:nameList	Lcom/tencent/qqmail/namelist/NameListSQLite;
    //   58: aload_1
    //   59: aload_0
    //   60: getfield 21	com/tencent/qqmail/namelist/NameListCGIManager$5:val$accountId	I
    //   63: aload_0
    //   64: getfield 23	com/tencent/qqmail/namelist/NameListCGIManager$5:val$emails	[Ljava/lang/String;
    //   67: invokevirtual 84	com/tencent/qqmail/namelist/NameListSQLite:deleteNameListContactByAccountIdAndEmail	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;I[Ljava/lang/String;)V
    //   70: aload_1
    //   71: invokevirtual 87	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   74: aload_1
    //   75: invokevirtual 90	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   78: aload_0
    //   79: getfield 21	com/tencent/qqmail/namelist/NameListCGIManager$5:val$accountId	I
    //   82: aload_0
    //   83: getfield 19	com/tencent/qqmail/namelist/NameListCGIManager$5:val$type	I
    //   86: aload_0
    //   87: getfield 23	com/tencent/qqmail/namelist/NameListCGIManager$5:val$emails	[Ljava/lang/String;
    //   90: invokestatic 96	com/tencent/qqmail/model/mail/watcher/QMWatcherCenter:triggerDeleteNameListSuccess	(II[Ljava/lang/String;)V
    //   93: return
    //   94: astore_2
    //   95: bipush 6
    //   97: ldc 33
    //   99: new 35	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   106: ldc 98
    //   108: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_2
    //   112: invokevirtual 99	java/lang/Exception:toString	()Ljava/lang/String;
    //   115: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 57	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   124: aload_1
    //   125: invokevirtual 90	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   128: goto -50 -> 78
    //   131: astore_1
    //   132: bipush 6
    //   134: ldc 33
    //   136: new 35	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   143: ldc 101
    //   145: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_1
    //   149: invokevirtual 99	java/lang/Exception:toString	()Ljava/lang/String;
    //   152: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 57	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   161: goto -83 -> 78
    //   164: astore_2
    //   165: aload_1
    //   166: invokevirtual 90	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   169: aload_2
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	5
    //   0	171	1	paramQMNetworkRequest	com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest
    //   0	171	2	paramQMNetworkResponse	com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse
    // Exception table:
    //   from	to	target	type
    //   44	74	94	java/lang/Exception
    //   33	44	131	java/lang/Exception
    //   74	78	131	java/lang/Exception
    //   124	128	131	java/lang/Exception
    //   165	171	131	java/lang/Exception
    //   44	74	164	finally
    //   95	124	164	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.NameListCGIManager.5
 * JD-Core Version:    0.7.0.1
 */