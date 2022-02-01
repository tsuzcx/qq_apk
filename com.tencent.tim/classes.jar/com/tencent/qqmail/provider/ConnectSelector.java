package com.tencent.qqmail.provider;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.ArrayList;

public class ConnectSelector
{
  private static final String TAG = "ConnectSelector";
  private boolean isCompleted = false;
  private boolean isExchangeConnected;
  private boolean isImapConnected;
  private boolean isPopConnected;
  private boolean isRunning = false;
  private boolean isSmtpConnected;
  private ArrayList<SelectionKey> keys = new ArrayList();
  public final Selector selector = Selector.open();
  
  public ConnectSelector()
    throws IOException
  {}
  
  private boolean isFinishConfig()
  {
    return ((!this.isPopConnected) && (!this.isImapConnected)) || ((this.isSmtpConnected) || (this.isExchangeConnected));
  }
  
  public void addKey(SelectionKey paramSelectionKey)
  {
    if (!this.isCompleted) {
      this.keys.add(paramSelectionKey);
    }
  }
  
  public void close()
    throws IOException
  {
    this.selector.close();
  }
  
  public boolean isCompleted()
  {
    return this.isCompleted;
  }
  
  public boolean isExchangeConnected()
  {
    return this.isExchangeConnected;
  }
  
  public boolean isImapConnected()
  {
    return this.isImapConnected;
  }
  
  public boolean isPopConnected()
  {
    return this.isPopConnected;
  }
  
  public boolean isSmtpConnected()
  {
    return this.isSmtpConnected;
  }
  
  /* Error */
  public boolean run()
  {
    // Byte code:
    //   0: ldc 11
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield 31	com/tencent/qqmail/provider/ConnectSelector:isRunning	Z
    //   7: ifeq +8 -> 15
    //   10: ldc 11
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: iconst_1
    //   17: putfield 31	com/tencent/qqmail/provider/ConnectSelector:isRunning	Z
    //   20: ldc 11
    //   22: monitorexit
    //   23: iconst_4
    //   24: ldc 11
    //   26: ldc 72
    //   28: invokestatic 78	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   31: ldc2_w 79
    //   34: lstore_3
    //   35: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   38: lstore 5
    //   40: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   43: lstore_1
    //   44: lload_3
    //   45: lconst_0
    //   46: lcmp
    //   47: ifle +119 -> 166
    //   50: aload_0
    //   51: getfield 46	com/tencent/qqmail/provider/ConnectSelector:selector	Ljava/nio/channels/Selector;
    //   54: lload_3
    //   55: invokevirtual 90	java/nio/channels/Selector:select	(J)I
    //   58: ifle +108 -> 166
    //   61: lload_3
    //   62: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   65: lload_1
    //   66: lsub
    //   67: lsub
    //   68: lstore_3
    //   69: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   72: lstore_1
    //   73: aload_0
    //   74: getfield 46	com/tencent/qqmail/provider/ConnectSelector:selector	Ljava/nio/channels/Selector;
    //   77: invokevirtual 94	java/nio/channels/Selector:selectedKeys	()Ljava/util/Set;
    //   80: invokeinterface 100 1 0
    //   85: astore 7
    //   87: aload 7
    //   89: invokeinterface 105 1 0
    //   94: ifeq +133 -> 227
    //   97: aload 7
    //   99: invokeinterface 109 1 0
    //   104: checkcast 111	java/nio/channels/SelectionKey
    //   107: astore 8
    //   109: aload 7
    //   111: invokeinterface 114 1 0
    //   116: aload 8
    //   118: invokevirtual 117	java/nio/channels/SelectionKey:isConnectable	()Z
    //   121: ifeq -34 -> 87
    //   124: aload 8
    //   126: invokevirtual 120	java/nio/channels/SelectionKey:attachment	()Ljava/lang/Object;
    //   129: checkcast 6	com/tencent/qqmail/provider/ConnectSelector$Connectable
    //   132: aload 8
    //   134: invokeinterface 123 2 0
    //   139: aload_0
    //   140: getfield 38	com/tencent/qqmail/provider/ConnectSelector:keys	Ljava/util/ArrayList;
    //   143: aload 8
    //   145: invokevirtual 125	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   148: pop
    //   149: goto -62 -> 87
    //   152: astore 7
    //   154: bipush 6
    //   156: ldc 11
    //   158: aload 7
    //   160: invokestatic 131	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   163: invokestatic 78	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   166: aload_0
    //   167: iconst_1
    //   168: putfield 33	com/tencent/qqmail/provider/ConnectSelector:isCompleted	Z
    //   171: aload_0
    //   172: invokevirtual 132	com/tencent/qqmail/provider/ConnectSelector:close	()V
    //   175: iconst_4
    //   176: ldc 11
    //   178: new 134	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   185: ldc 137
    //   187: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   193: lload 5
    //   195: lsub
    //   196: invokevirtual 144	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   199: ldc 146
    //   201: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_0
    //   205: invokespecial 148	com/tencent/qqmail/provider/ConnectSelector:isFinishConfig	()Z
    //   208: invokevirtual 151	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   211: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 78	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   217: iconst_1
    //   218: ireturn
    //   219: astore 7
    //   221: ldc 11
    //   223: monitorexit
    //   224: aload 7
    //   226: athrow
    //   227: iconst_4
    //   228: ldc 11
    //   230: new 134	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   237: ldc 157
    //   239: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_0
    //   243: getfield 38	com/tencent/qqmail/provider/ConnectSelector:keys	Ljava/util/ArrayList;
    //   246: invokevirtual 161	java/util/ArrayList:size	()I
    //   249: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   252: ldc 166
    //   254: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: lload_3
    //   258: invokevirtual 144	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   261: ldc 146
    //   263: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_0
    //   267: invokespecial 148	com/tencent/qqmail/provider/ConnectSelector:isFinishConfig	()Z
    //   270: invokevirtual 151	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   273: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 78	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   279: goto -235 -> 44
    //   282: astore 7
    //   284: bipush 6
    //   286: ldc 11
    //   288: aload 7
    //   290: invokestatic 131	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   293: invokestatic 78	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   296: goto -130 -> 166
    //   299: astore 7
    //   301: goto -126 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	ConnectSelector
    //   43	30	1	l1	long
    //   34	224	3	l2	long
    //   38	156	5	l3	long
    //   85	25	7	localIterator	java.util.Iterator
    //   152	7	7	localClosedSelectorException	java.nio.channels.ClosedSelectorException
    //   219	6	7	localObject	Object
    //   282	7	7	localIOException1	IOException
    //   299	1	7	localIOException2	IOException
    //   107	37	8	localSelectionKey	SelectionKey
    // Exception table:
    //   from	to	target	type
    //   50	87	152	java/nio/channels/ClosedSelectorException
    //   87	149	152	java/nio/channels/ClosedSelectorException
    //   227	279	152	java/nio/channels/ClosedSelectorException
    //   3	13	219	finally
    //   15	23	219	finally
    //   221	224	219	finally
    //   50	87	282	java/io/IOException
    //   87	149	282	java/io/IOException
    //   227	279	282	java/io/IOException
    //   171	175	299	java/io/IOException
  }
  
  public void setCompleted()
  {
    this.isCompleted = true;
  }
  
  public void setExchangeConnected(boolean paramBoolean)
  {
    this.isExchangeConnected = paramBoolean;
  }
  
  public void setImapConnected(boolean paramBoolean)
  {
    this.isImapConnected = paramBoolean;
  }
  
  public void setPopConnected(boolean paramBoolean)
  {
    this.isPopConnected = paramBoolean;
  }
  
  public void setSmtpConnected(boolean paramBoolean)
  {
    this.isSmtpConnected = paramBoolean;
  }
  
  public static abstract interface Connectable
  {
    public abstract void onConnectable(SelectionKey paramSelectionKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.provider.ConnectSelector
 * JD-Core Version:    0.7.0.1
 */