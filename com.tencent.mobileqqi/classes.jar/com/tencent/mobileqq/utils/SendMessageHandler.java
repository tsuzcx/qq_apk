package com.tencent.mobileqq.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SendMessageHandler
  extends Handler
{
  public static final int a = 0;
  public static final String a = "Q.msg.SendMessageHandler";
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static final boolean jdField_a_of_type_Boolean = false;
  public static final int b = 1;
  public static final int c = 2;
  public long a;
  private List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private long b;
  public final String b;
  public final String c = "msf";
  private int d;
  public final String d;
  private int e;
  private int f;
  private int g;
  private volatile int h = 0;
  private volatile int i = 0;
  
  public SendMessageHandler()
  {
    super(Looper.getMainLooper());
    this.jdField_b_of_type_JavaLangString = "period";
    this.jdField_d_of_type_JavaLangString = "server";
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Long = 0L;
  }
  
  public SendMessageHandler(Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_b_of_type_JavaLangString = "period";
    this.jdField_d_of_type_JavaLangString = "server";
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Long = 0L;
  }
  
  public static int a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return a(paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public static int a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return 0;
    }
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq", -1L);
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    long l3 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    int j = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.SendMessageHandler", 2, "proc response, seq:" + l1 + ",timeout:" + l2 + " retryIndex:" + l3 + " retCode:" + j);
    }
    SendMessageHandler localSendMessageHandler = (SendMessageHandler)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l1));
    if (localSendMessageHandler == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.SendMessageHandler", 2, "no handler found");
      }
      return 0;
    }
    localSendMessageHandler.a((int)l3, j, 0L, MessageHandlerUtils.a(paramToServiceMsg, paramFromServiceMsg));
    if (j == 1000)
    {
      if (paramStatictisInfo != null) {
        paramStatictisInfo.c = localSendMessageHandler.h;
      }
      localSendMessageHandler.a();
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l1));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.SendMessageHandler", 2, " handler removed , seq:" + l1);
      }
      return 1;
    }
    if (j == 2901)
    {
      l2 = localSendMessageHandler.a(System.currentTimeMillis());
      if (l2 < localSendMessageHandler.g)
      {
        l3 = localSendMessageHandler.f;
        localSendMessageHandler.getClass();
        if (localSendMessageHandler.a(0L, l3 - l2 - 5000L, "msf")) {
          return 0;
        }
      }
    }
    if (localSendMessageHandler.a())
    {
      if (paramStatictisInfo != null) {
        paramStatictisInfo.c = localSendMessageHandler.h;
      }
      localSendMessageHandler.a();
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l1));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.SendMessageHandler", 2, " handler removed , seq:" + l1);
      }
      return 2;
    }
    return 0;
  }
  
  public static boolean a(long paramLong, SendMessageHandler.SendMessageRunnable[] paramArrayOfSendMessageRunnable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramArrayOfSendMessageRunnable == null) || (paramArrayOfSendMessageRunnable.length == 0) || (paramInt2 == 0) || (paramInt1 == 0)) {
      return false;
    }
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    int j = 0;
    while (j < paramArrayOfSendMessageRunnable.length)
    {
      localSendMessageHandler.a(paramArrayOfSendMessageRunnable[j]);
      j += 1;
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), localSendMessageHandler);
    localSendMessageHandler.jdField_a_of_type_Long = paramLong;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.SendMessageHandler", 2, "add handler, seq:" + paramLong);
    }
    localSendMessageHandler.e = paramInt1;
    localSendMessageHandler.f = paramInt2;
    localSendMessageHandler.jdField_d_of_type_Int = paramArrayOfSendMessageRunnable.length;
    localSendMessageHandler.g = paramInt4;
    localSendMessageHandler.jdField_b_of_type_Long = System.currentTimeMillis();
    paramInt4 = 0;
    if (paramInt4 < paramInt1)
    {
      if (paramInt4 == 0) {}
      for (paramLong = paramInt2;; paramLong = (paramInt1 - paramInt4) * paramInt2 / paramInt1 - paramInt4 * paramInt3)
      {
        long l = paramInt4 * paramInt2 / paramInt1;
        localSendMessageHandler.getClass();
        localSendMessageHandler.a(l, paramLong, "period");
        paramInt4 += 1;
        break;
      }
    }
    return true;
  }
  
  public long a(long paramLong)
  {
    try
    {
      long l = this.jdField_b_of_type_Long;
      return paramLong - l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    try
    {
      removeCallbacksAndMessages(null);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.h = 0;
      this.i = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(SendMessageHandler.SendMessageRunnable paramSendMessageRunnable)
  {
    try
    {
      paramSendMessageRunnable.h = this.jdField_b_of_type_Long;
      this.jdField_a_of_type_JavaUtilList.add(paramSendMessageRunnable);
      return;
    }
    finally
    {
      paramSendMessageRunnable = finally;
      throw paramSendMessageRunnable;
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_1
    //   4: iload_1
    //   5: aload_0
    //   6: getfield 78	com/tencent/mobileqq/utils/SendMessageHandler:i	I
    //   9: if_icmpge +37 -> 46
    //   12: aload_0
    //   13: getfield 74	com/tencent/mobileqq/utils/SendMessageHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   16: iload_1
    //   17: invokeinterface 239 2 0
    //   22: checkcast 230	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable
    //   25: getfield 241	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:c	Z
    //   28: istore_2
    //   29: iload_2
    //   30: ifne +9 -> 39
    //   33: iconst_0
    //   34: istore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: iload_2
    //   38: ireturn
    //   39: iload_1
    //   40: iconst_1
    //   41: iadd
    //   42: istore_1
    //   43: goto -39 -> 4
    //   46: iconst_1
    //   47: istore_2
    //   48: goto -13 -> 35
    //   51: astore_3
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_3
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	SendMessageHandler
    //   3	40	1	j	int
    //   28	20	2	bool	boolean
    //   51	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	29	51	finally
  }
  
  /* Error */
  public boolean a(int paramInt, long paramLong1, long paramLong2, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 76	com/tencent/mobileqq/utils/SendMessageHandler:h	I
    //   7: if_icmpge +138 -> 145
    //   10: aload_0
    //   11: getfield 74	com/tencent/mobileqq/utils/SendMessageHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   14: iload_1
    //   15: invokeinterface 239 2 0
    //   20: checkcast 230	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable
    //   23: astore 8
    //   25: aload 8
    //   27: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   30: putfield 244	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:j	J
    //   33: aload 8
    //   35: lload_2
    //   36: putfield 246	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:f	J
    //   39: aload 8
    //   41: lload 4
    //   43: putfield 248	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:g	J
    //   46: aload 8
    //   48: iconst_1
    //   49: putfield 241	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:c	Z
    //   52: aload 8
    //   54: aload 6
    //   56: putfield 251	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:a	[Ljava/lang/String;
    //   59: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +75 -> 137
    //   65: ldc 253
    //   67: iconst_2
    //   68: new 126	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   75: ldc 255
    //   77: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: getfield 80	com/tencent/mobileqq/utils/SendMessageHandler:jdField_a_of_type_Long	J
    //   84: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   87: ldc_w 257
    //   90: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: iload_1
    //   94: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: ldc_w 259
    //   100: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: lload_2
    //   104: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   107: ldc_w 261
    //   110: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: lload 4
    //   115: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   118: ldc_w 263
    //   121: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_0
    //   125: invokevirtual 264	com/tencent/mobileqq/utils/SendMessageHandler:toString	()Ljava/lang/String;
    //   128: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: iconst_1
    //   138: istore 7
    //   140: aload_0
    //   141: monitorexit
    //   142: iload 7
    //   144: ireturn
    //   145: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +12 -> 160
    //   151: ldc 253
    //   153: iconst_2
    //   154: ldc_w 266
    //   157: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: iconst_0
    //   161: istore 7
    //   163: goto -23 -> 140
    //   166: astore 6
    //   168: aload_0
    //   169: monitorexit
    //   170: aload 6
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	SendMessageHandler
    //   0	173	1	paramInt	int
    //   0	173	2	paramLong1	long
    //   0	173	4	paramLong2	long
    //   0	173	6	paramArrayOfString	String[]
    //   138	24	7	bool	boolean
    //   23	30	8	localSendMessageRunnable	SendMessageHandler.SendMessageRunnable
    // Exception table:
    //   from	to	target	type
    //   2	137	166	finally
    //   145	160	166	finally
  }
  
  /* Error */
  public boolean a(long paramLong1, long paramLong2, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 78	com/tencent/mobileqq/utils/SendMessageHandler:i	I
    //   6: istore 6
    //   8: aload_0
    //   9: getfield 74	com/tencent/mobileqq/utils/SendMessageHandler:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   12: invokeinterface 271 1 0
    //   17: istore 7
    //   19: iload 6
    //   21: iload 7
    //   23: if_icmplt +11 -> 34
    //   26: iconst_0
    //   27: istore 8
    //   29: aload_0
    //   30: monitorexit
    //   31: iload 8
    //   33: ireturn
    //   34: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +75 -> 112
    //   40: ldc 10
    //   42: iconst_2
    //   43: new 126	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 273
    //   53: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield 80	com/tencent/mobileqq/utils/SendMessageHandler:jdField_a_of_type_Long	J
    //   60: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: ldc_w 275
    //   66: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: lload_1
    //   70: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   73: ldc 138
    //   75: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: lload_3
    //   79: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: ldc_w 277
    //   85: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_0
    //   89: getfield 78	com/tencent/mobileqq/utils/SendMessageHandler:i	I
    //   92: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: ldc_w 279
    //   98: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload 5
    //   103: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 78	com/tencent/mobileqq/utils/SendMessageHandler:i	I
    //   117: iconst_1
    //   118: iadd
    //   119: putfield 78	com/tencent/mobileqq/utils/SendMessageHandler:i	I
    //   122: aload_0
    //   123: new 281	hik
    //   126: dup
    //   127: aload_0
    //   128: lload_3
    //   129: aload 5
    //   131: invokespecial 284	hik:<init>	(Lcom/tencent/mobileqq/utils/SendMessageHandler;JLjava/lang/String;)V
    //   134: lload_1
    //   135: invokevirtual 288	com/tencent/mobileqq/utils/SendMessageHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   138: pop
    //   139: iconst_1
    //   140: istore 8
    //   142: goto -113 -> 29
    //   145: astore 5
    //   147: aload_0
    //   148: monitorexit
    //   149: aload 5
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	SendMessageHandler
    //   0	152	1	paramLong1	long
    //   0	152	3	paramLong2	long
    //   0	152	5	paramString	String
    //   6	18	6	j	int
    //   17	7	7	k	int
    //   27	114	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	19	145	finally
    //   34	112	145	finally
    //   112	139	145	finally
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    int k = this.h;
    int j = 0;
    while (j < k)
    {
      localStringBuilder.append(((SendMessageHandler.SendMessageRunnable)this.jdField_a_of_type_JavaUtilList.get(j)).toString());
      if (j != k - 1) {
        localStringBuilder.append(",");
      }
      j += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SendMessageHandler
 * JD-Core Version:    0.7.0.1
 */