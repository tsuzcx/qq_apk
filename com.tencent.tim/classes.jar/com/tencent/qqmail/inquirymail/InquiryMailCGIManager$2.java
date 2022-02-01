package com.tencent.qqmail.inquirymail;

import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;

class InquiryMailCGIManager$2
  implements QMCallback.ISuccessCallback
{
  InquiryMailCGIManager$2(InquiryMailCGIManager paramInquiryMailCGIManager, int paramInt1, String paramString, boolean paramBoolean, int paramInt2, long paramLong) {}
  
  /* Error */
  public void run(com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest paramQMNetworkRequest, com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse paramQMNetworkResponse)
  {
    // Byte code:
    //   0: iconst_3
    //   1: ldc 41
    //   3: new 43	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   10: ldc 46
    //   12: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: getfield 23	com/tencent/qqmail/inquirymail/InquiryMailCGIManager$2:val$accountId	I
    //   19: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 63	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 25	com/tencent/qqmail/inquirymail/InquiryMailCGIManager$2:val$requestFilterKey	Ljava/lang/String;
    //   32: invokestatic 69	com/tencent/qqmail/network/filter/RequestFilter:resetRequestRunningState	(Ljava/lang/String;)V
    //   35: aload_2
    //   36: invokevirtual 75	com/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse:getResponseJson	()Ljava/lang/Object;
    //   39: checkcast 77	com/alibaba/fastjson/JSONObject
    //   42: astore_1
    //   43: aload_0
    //   44: getfield 21	com/tencent/qqmail/inquirymail/InquiryMailCGIManager$2:this$0	Lcom/tencent/qqmail/inquirymail/InquiryMailCGIManager;
    //   47: invokestatic 83	com/tencent/qqmail/inquirymail/InquiryMailCGIManager:access$000	(Lcom/tencent/qqmail/inquirymail/InquiryMailCGIManager;)Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   50: invokevirtual 89	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:getWritableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 94	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   58: aload_0
    //   59: getfield 21	com/tencent/qqmail/inquirymail/InquiryMailCGIManager$2:this$0	Lcom/tencent/qqmail/inquirymail/InquiryMailCGIManager;
    //   62: aload_1
    //   63: aload_0
    //   64: getfield 23	com/tencent/qqmail/inquirymail/InquiryMailCGIManager$2:val$accountId	I
    //   67: invokestatic 98	com/tencent/qqmail/inquirymail/InquiryMailCGIManager:access$100	(Lcom/tencent/qqmail/inquirymail/InquiryMailCGIManager;Lcom/alibaba/fastjson/JSONObject;I)Lcom/tencent/qqmail/inquirymail/model/InquiryMailPage;
    //   70: astore_2
    //   71: aload_0
    //   72: getfield 27	com/tencent/qqmail/inquirymail/InquiryMailCGIManager$2:val$isInitLoad	Z
    //   75: ifeq +21 -> 96
    //   78: aload_0
    //   79: getfield 21	com/tencent/qqmail/inquirymail/InquiryMailCGIManager$2:this$0	Lcom/tencent/qqmail/inquirymail/InquiryMailCGIManager;
    //   82: invokestatic 83	com/tencent/qqmail/inquirymail/InquiryMailCGIManager:access$000	(Lcom/tencent/qqmail/inquirymail/InquiryMailCGIManager;)Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   85: getfield 102	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:inquiryMail	Lcom/tencent/qqmail/inquirymail/InquiryMailSQLite;
    //   88: aload_3
    //   89: aload_0
    //   90: getfield 23	com/tencent/qqmail/inquirymail/InquiryMailCGIManager$2:val$accountId	I
    //   93: invokevirtual 108	com/tencent/qqmail/inquirymail/InquiryMailSQLite:deleteInquiryMail	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;I)V
    //   96: aload_0
    //   97: getfield 29	com/tencent/qqmail/inquirymail/InquiryMailCGIManager$2:val$page	I
    //   100: aload_2
    //   101: invokevirtual 114	com/tencent/qqmail/inquirymail/model/InquiryMailPage:getPage	()I
    //   104: if_icmpne +15 -> 119
    //   107: aload_0
    //   108: getfield 31	com/tencent/qqmail/inquirymail/InquiryMailCGIManager$2:val$edgeTime	J
    //   111: aload_2
    //   112: invokevirtual 118	com/tencent/qqmail/inquirymail/model/InquiryMailPage:getEdgeTime	()J
    //   115: lcmp
    //   116: ifeq +92 -> 208
    //   119: aload_0
    //   120: getfield 21	com/tencent/qqmail/inquirymail/InquiryMailCGIManager$2:this$0	Lcom/tencent/qqmail/inquirymail/InquiryMailCGIManager;
    //   123: aload_1
    //   124: aload_0
    //   125: getfield 23	com/tencent/qqmail/inquirymail/InquiryMailCGIManager$2:val$accountId	I
    //   128: aload_0
    //   129: getfield 29	com/tencent/qqmail/inquirymail/InquiryMailCGIManager$2:val$page	I
    //   132: aload_0
    //   133: getfield 31	com/tencent/qqmail/inquirymail/InquiryMailCGIManager$2:val$edgeTime	J
    //   136: invokestatic 122	com/tencent/qqmail/inquirymail/InquiryMailCGIManager:access$200	(Lcom/tencent/qqmail/inquirymail/InquiryMailCGIManager;Lcom/alibaba/fastjson/JSONObject;IIJ)Ljava/util/ArrayList;
    //   139: astore_1
    //   140: aload_0
    //   141: getfield 21	com/tencent/qqmail/inquirymail/InquiryMailCGIManager$2:this$0	Lcom/tencent/qqmail/inquirymail/InquiryMailCGIManager;
    //   144: invokestatic 83	com/tencent/qqmail/inquirymail/InquiryMailCGIManager:access$000	(Lcom/tencent/qqmail/inquirymail/InquiryMailCGIManager;)Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   147: getfield 102	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:inquiryMail	Lcom/tencent/qqmail/inquirymail/InquiryMailSQLite;
    //   150: aload_3
    //   151: aload_1
    //   152: invokevirtual 126	com/tencent/qqmail/inquirymail/InquiryMailSQLite:insertInquiryMail	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;Ljava/util/ArrayList;)V
    //   155: aload_3
    //   156: invokevirtual 129	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   159: aload_3
    //   160: invokevirtual 132	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   163: aload_0
    //   164: getfield 23	com/tencent/qqmail/inquirymail/InquiryMailCGIManager$2:val$accountId	I
    //   167: aload_1
    //   168: invokestatic 138	com/tencent/qqmail/model/mail/watcher/QMWatcherCenter:triggerLoadInquiryMailListSuccess	(ILjava/util/ArrayList;)V
    //   171: return
    //   172: astore_2
    //   173: aconst_null
    //   174: astore_1
    //   175: bipush 6
    //   177: ldc 41
    //   179: aload_2
    //   180: invokestatic 144	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   183: invokestatic 63	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   186: aload_3
    //   187: invokevirtual 132	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   190: goto -27 -> 163
    //   193: astore_1
    //   194: aload_3
    //   195: invokevirtual 132	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   198: aload_1
    //   199: athrow
    //   200: astore_2
    //   201: goto -26 -> 175
    //   204: astore_2
    //   205: goto -30 -> 175
    //   208: aconst_null
    //   209: astore_1
    //   210: goto -55 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	2
    //   0	213	1	paramQMNetworkRequest	com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest
    //   0	213	2	paramQMNetworkResponse	com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse
    //   53	142	3	localSQLiteDatabase	com.tencent.moai.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   54	96	172	java/lang/Exception
    //   96	119	172	java/lang/Exception
    //   119	140	172	java/lang/Exception
    //   54	96	193	finally
    //   96	119	193	finally
    //   119	140	193	finally
    //   140	155	193	finally
    //   155	159	193	finally
    //   175	186	193	finally
    //   140	155	200	java/lang/Exception
    //   155	159	204	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.InquiryMailCGIManager.2
 * JD-Core Version:    0.7.0.1
 */