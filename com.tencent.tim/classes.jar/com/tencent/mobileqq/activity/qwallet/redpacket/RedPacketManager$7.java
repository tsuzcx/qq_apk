package com.tencent.mobileqq.activity.qwallet.redpacket;

class RedPacketManager$7
  implements Runnable
{
  RedPacketManager$7(RedPacketManager paramRedPacketManager, String paramString1, String paramString2, int paramInt) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 32	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   7: getstatic 38	aagi:bcV	Ljava/lang/String;
    //   10: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: aload_0
    //   14: getfield 19	com/tencent/mobileqq/activity/qwallet/redpacket/RedPacketManager$7:bcv	Ljava/lang/String;
    //   17: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_0
    //   21: getfield 21	com/tencent/mobileqq/activity/qwallet/redpacket/RedPacketManager$7:val$groupUin	Ljava/lang/String;
    //   24: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 44
    //   29: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 23	com/tencent/mobileqq/activity/qwallet/redpacket/RedPacketManager$7:cgi	I
    //   36: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore_1
    //   43: new 53	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: invokevirtual 60	java/io/File:exists	()Z
    //   54: ifeq +77 -> 131
    //   57: aload_1
    //   58: invokestatic 66	aqhq:readFile	(Ljava/lang/String;)[B
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +68 -> 131
    //   66: aload_1
    //   67: arraylength
    //   68: ifle +63 -> 131
    //   71: new 68	com/qq/taf/jce/JceInputStream
    //   74: dup
    //   75: aload_1
    //   76: invokespecial 71	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   79: astore_2
    //   80: aload_2
    //   81: ldc 73
    //   83: invokevirtual 77	com/qq/taf/jce/JceInputStream:setServerEncoding	(Ljava/lang/String;)I
    //   86: pop
    //   87: new 79	Wallet/GetGroupRedPackListRsp
    //   90: dup
    //   91: invokespecial 80	Wallet/GetGroupRedPackListRsp:<init>	()V
    //   94: astore_1
    //   95: aload_1
    //   96: aload_2
    //   97: invokevirtual 84	Wallet/GetGroupRedPackListRsp:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   100: invokestatic 90	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   103: new 92	com/tencent/mobileqq/activity/qwallet/redpacket/RedPacketManager$7$1
    //   106: dup
    //   107: aload_0
    //   108: aload_1
    //   109: invokespecial 95	com/tencent/mobileqq/activity/qwallet/redpacket/RedPacketManager$7$1:<init>	(Lcom/tencent/mobileqq/activity/qwallet/redpacket/RedPacketManager$7;LWallet/GetGroupRedPackListRsp;)V
    //   112: invokevirtual 101	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   115: pop
    //   116: return
    //   117: astore_2
    //   118: aconst_null
    //   119: astore_1
    //   120: aload_2
    //   121: invokevirtual 104	java/lang/Throwable:printStackTrace	()V
    //   124: goto -24 -> 100
    //   127: astore_2
    //   128: goto -8 -> 120
    //   131: aconst_null
    //   132: astore_1
    //   133: goto -33 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	7
    //   42	91	1	localObject	Object
    //   79	18	2	localJceInputStream	com.qq.taf.jce.JceInputStream
    //   117	4	2	localThrowable1	java.lang.Throwable
    //   127	1	2	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	62	117	java/lang/Throwable
    //   66	95	117	java/lang/Throwable
    //   95	100	127	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager.7
 * JD-Core Version:    0.7.0.1
 */