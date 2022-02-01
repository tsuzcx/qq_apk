package com.tencent.mobileqq.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SendMessageHandler
  extends Handler
{
  private List<SendMessageRunnable> IQ = Collections.synchronizedList(new ArrayList());
  private long atf = System.currentTimeMillis();
  public final String cug = "period";
  public final String cuh = "msf";
  public final String cui = "server";
  private volatile int dZT;
  private volatile int dZU;
  public long msgSeq;
  
  public SendMessageHandler()
  {
    super(Looper.getMainLooper());
  }
  
  /* Error */
  private void aK(long paramLong, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 72	com/tencent/mobileqq/utils/SendMessageHandler:dZT	I
    //   6: aload_0
    //   7: getfield 63	com/tencent/mobileqq/utils/SendMessageHandler:IQ	Ljava/util/List;
    //   10: invokeinterface 78 1 0
    //   15: if_icmpge +20 -> 35
    //   18: aload_0
    //   19: getfield 63	com/tencent/mobileqq/utils/SendMessageHandler:IQ	Ljava/util/List;
    //   22: invokeinterface 78 1 0
    //   27: istore 4
    //   29: iload 4
    //   31: iconst_1
    //   32: if_icmpge +6 -> 38
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: getfield 72	com/tencent/mobileqq/utils/SendMessageHandler:dZT	I
    //   42: istore 4
    //   44: aload_0
    //   45: iload 4
    //   47: iconst_1
    //   48: iadd
    //   49: putfield 72	com/tencent/mobileqq/utils/SendMessageHandler:dZT	I
    //   52: aload_0
    //   53: getfield 63	com/tencent/mobileqq/utils/SendMessageHandler:IQ	Ljava/util/List;
    //   56: iload 4
    //   58: invokeinterface 82 2 0
    //   63: checkcast 6	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable
    //   66: astore 5
    //   68: aload 5
    //   70: iload 4
    //   72: putfield 85	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:aaU	I
    //   75: aload 5
    //   77: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   80: putfield 88	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:atk	J
    //   83: aload 5
    //   85: lload_1
    //   86: putfield 91	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:timeout	J
    //   89: aload 5
    //   91: aload_3
    //   92: putfield 94	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:reason	Ljava/lang/String;
    //   95: aload 5
    //   97: invokevirtual 97	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:run	()V
    //   100: goto -65 -> 35
    //   103: astore_3
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_3
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	SendMessageHandler
    //   0	108	1	paramLong	long
    //   0	108	3	paramString	String
    //   27	44	4	i	int
    //   66	30	5	localSendMessageRunnable	SendMessageRunnable
    // Exception table:
    //   from	to	target	type
    //   2	29	103	finally
    //   38	100	103	finally
  }
  
  public long Y(long paramLong)
  {
    try
    {
      long l = this.atf;
      return paramLong - l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(SendMessageRunnable paramSendMessageRunnable)
  {
    try
    {
      paramSendMessageRunnable.atj = this.atf;
      this.IQ.add(paramSendMessageRunnable);
      return;
    }
    finally
    {
      paramSendMessageRunnable = finally;
      throw paramSendMessageRunnable;
    }
  }
  
  /* Error */
  public boolean a(int paramInt, long paramLong1, long paramLong2, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 72	com/tencent/mobileqq/utils/SendMessageHandler:dZT	I
    //   7: if_icmpge +134 -> 141
    //   10: aload_0
    //   11: getfield 63	com/tencent/mobileqq/utils/SendMessageHandler:IQ	Ljava/util/List;
    //   14: iload_1
    //   15: invokeinterface 82 2 0
    //   20: checkcast 6	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable
    //   23: astore 8
    //   25: aload 8
    //   27: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   30: putfield 111	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:stopTime	J
    //   33: aload 8
    //   35: lload_2
    //   36: putfield 114	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:ath	J
    //   39: aload 8
    //   41: lload 4
    //   43: putfield 117	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:ati	J
    //   46: aload 8
    //   48: iconst_1
    //   49: putfield 121	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:cUC	Z
    //   52: aload 8
    //   54: aload 6
    //   56: putfield 125	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:hW	[Ljava/lang/String;
    //   59: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +71 -> 133
    //   65: ldc 133
    //   67: iconst_2
    //   68: new 135	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   75: ldc 138
    //   77: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: getfield 144	com/tencent/mobileqq/utils/SendMessageHandler:msgSeq	J
    //   84: invokevirtual 147	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   87: ldc 149
    //   89: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload_1
    //   93: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: ldc 154
    //   98: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: lload_2
    //   102: invokevirtual 147	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   105: ldc 156
    //   107: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: lload 4
    //   112: invokevirtual 147	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   115: ldc 158
    //   117: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_0
    //   121: invokevirtual 162	com/tencent/mobileqq/utils/SendMessageHandler:toString	()Ljava/lang/String;
    //   124: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: iconst_1
    //   134: istore 7
    //   136: aload_0
    //   137: monitorexit
    //   138: iload 7
    //   140: ireturn
    //   141: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +11 -> 155
    //   147: ldc 133
    //   149: iconst_2
    //   150: ldc 169
    //   152: invokestatic 172	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: iconst_0
    //   156: istore 7
    //   158: goto -22 -> 136
    //   161: astore 6
    //   163: aload_0
    //   164: monitorexit
    //   165: aload 6
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	SendMessageHandler
    //   0	168	1	paramInt	int
    //   0	168	2	paramLong1	long
    //   0	168	4	paramLong2	long
    //   0	168	6	paramArrayOfString	String[]
    //   134	23	7	bool	boolean
    //   23	30	8	localSendMessageRunnable	SendMessageRunnable
    // Exception table:
    //   from	to	target	type
    //   2	133	161	finally
    //   141	155	161	finally
  }
  
  /* Error */
  public boolean aFa()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_1
    //   4: iload_1
    //   5: aload_0
    //   6: getfield 175	com/tencent/mobileqq/utils/SendMessageHandler:dZU	I
    //   9: if_icmpge +37 -> 46
    //   12: aload_0
    //   13: getfield 63	com/tencent/mobileqq/utils/SendMessageHandler:IQ	Ljava/util/List;
    //   16: iload_1
    //   17: invokeinterface 82 2 0
    //   22: checkcast 6	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable
    //   25: getfield 121	com/tencent/mobileqq/utils/SendMessageHandler$SendMessageRunnable:cUC	Z
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
    //   3	40	1	i	int
    //   28	20	2	bool	boolean
    //   51	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	29	51	finally
  }
  
  /* Error */
  public boolean b(long paramLong1, long paramLong2, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 175	com/tencent/mobileqq/utils/SendMessageHandler:dZU	I
    //   6: istore 6
    //   8: aload_0
    //   9: getfield 63	com/tencent/mobileqq/utils/SendMessageHandler:IQ	Ljava/util/List;
    //   12: invokeinterface 78 1 0
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
    //   34: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +71 -> 108
    //   40: ldc 179
    //   42: iconst_2
    //   43: new 135	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   50: ldc 181
    //   52: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_0
    //   56: getfield 144	com/tencent/mobileqq/utils/SendMessageHandler:msgSeq	J
    //   59: invokevirtual 147	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: ldc 183
    //   64: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: lload_1
    //   68: invokevirtual 147	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   71: ldc 185
    //   73: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: lload_3
    //   77: invokevirtual 147	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   80: ldc 187
    //   82: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: getfield 175	com/tencent/mobileqq/utils/SendMessageHandler:dZU	I
    //   89: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: ldc 189
    //   94: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload 5
    //   99: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 175	com/tencent/mobileqq/utils/SendMessageHandler:dZU	I
    //   113: iconst_1
    //   114: iadd
    //   115: putfield 175	com/tencent/mobileqq/utils/SendMessageHandler:dZU	I
    //   118: aload_0
    //   119: new 191	com/tencent/mobileqq/utils/SendMessageHandler$1
    //   122: dup
    //   123: aload_0
    //   124: lload_3
    //   125: aload 5
    //   127: invokespecial 193	com/tencent/mobileqq/utils/SendMessageHandler$1:<init>	(Lcom/tencent/mobileqq/utils/SendMessageHandler;JLjava/lang/String;)V
    //   130: lload_1
    //   131: invokevirtual 197	com/tencent/mobileqq/utils/SendMessageHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   134: pop
    //   135: iconst_1
    //   136: istore 8
    //   138: goto -109 -> 29
    //   141: astore 5
    //   143: aload_0
    //   144: monitorexit
    //   145: aload 5
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	SendMessageHandler
    //   0	148	1	paramLong1	long
    //   0	148	3	paramLong2	long
    //   0	148	5	paramString	String
    //   6	18	6	i	int
    //   17	7	7	j	int
    //   27	110	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	19	141	finally
    //   34	108	141	finally
    //   108	135	141	finally
  }
  
  public void een()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.SendMessageHandler", 2, "stopAndRemoveRunnalbes");
      }
      removeCallbacksAndMessages(null);
      this.IQ.clear();
      this.dZT = 0;
      this.dZU = 0;
      return;
    }
    finally {}
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    try
    {
      int j = this.dZT;
      if (j > 0)
      {
        int i = this.IQ.size();
        if (i >= j)
        {
          i = 0;
          while (i < j) {
            try
            {
              localStringBuilder.append(((SendMessageRunnable)this.IQ.get(i)).toString());
              if (i != j - 1) {
                localStringBuilder.append(",");
              }
              i += 1;
            }
            catch (Exception localException)
            {
              localStringBuilder.append(localException.getMessage());
            }
          }
        }
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    finally {}
  }
  
  public static class SendMessageRunnable
    implements Runnable
  {
    public int aaU = -1;
    public long ath = 9223372036854775807L;
    public long ati = 9223372036854775807L;
    public long atj = -1L;
    public long atk = -1L;
    public boolean cUC;
    public String[] hW = new String[0];
    public String reason = "";
    public long stopTime = -1L;
    public long timeout = -1L;
    
    public void run() {}
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append("index:");
      localStringBuilder.append(String.valueOf(this.aaU));
      localStringBuilder.append(",reason:");
      localStringBuilder.append(this.reason);
      localStringBuilder.append(",startTime:");
      localStringBuilder.append(String.valueOf(this.atk - this.atj));
      localStringBuilder.append(",timeOut:");
      localStringBuilder.append(String.valueOf(this.atk - this.atj + this.timeout));
      if (this.cUC)
      {
        localStringBuilder.append(",duration:");
        localStringBuilder.append(String.valueOf(this.stopTime - this.atk));
        localStringBuilder.append(",error:");
        localStringBuilder.append(String.valueOf(this.ath));
        if (this.ati != 9223372036854775807L)
        {
          localStringBuilder.append(",serverReply:");
          localStringBuilder.append(String.valueOf(this.ati));
        }
      }
      for (;;)
      {
        localStringBuilder.append("}");
        return localStringBuilder.toString();
        localStringBuilder.append(",status:RUNNING");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SendMessageHandler
 * JD-Core Version:    0.7.0.1
 */