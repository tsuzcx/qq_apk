import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;

public class xmt
  implements Runnable
{
  public xmt(RedPacketManager paramRedPacketManager, String paramString1, String paramString2, int paramInt) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 30	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   7: invokestatic 37	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: invokevirtual 43	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   13: invokevirtual 49	android/content/Context:getFilesDir	()Ljava/io/File;
    //   16: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: ldc 55
    //   21: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 17	xmt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   28: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_0
    //   32: getfield 19	xmt:b	Ljava/lang/String;
    //   35: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc 60
    //   40: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: getfield 21	xmt:jdField_a_of_type_Int	I
    //   47: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: astore_1
    //   54: new 69	java/io/File
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: invokevirtual 76	java/io/File:exists	()Z
    //   65: ifeq +77 -> 142
    //   68: aload_1
    //   69: invokestatic 81	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)[B
    //   72: astore_1
    //   73: aload_1
    //   74: ifnull +68 -> 142
    //   77: aload_1
    //   78: arraylength
    //   79: ifle +63 -> 142
    //   82: new 83	com/qq/taf/jce/JceInputStream
    //   85: dup
    //   86: aload_1
    //   87: invokespecial 86	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   90: astore_2
    //   91: aload_2
    //   92: ldc 88
    //   94: invokevirtual 92	com/qq/taf/jce/JceInputStream:setServerEncoding	(Ljava/lang/String;)I
    //   97: pop
    //   98: new 94	Wallet/GetGroupRedPackListRsp
    //   101: dup
    //   102: invokespecial 95	Wallet/GetGroupRedPackListRsp:<init>	()V
    //   105: astore_1
    //   106: aload_1
    //   107: aload_2
    //   108: invokevirtual 99	Wallet/GetGroupRedPackListRsp:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   111: invokestatic 105	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   114: new 107	xmu
    //   117: dup
    //   118: aload_0
    //   119: aload_1
    //   120: invokespecial 110	xmu:<init>	(Lxmt;LWallet/GetGroupRedPackListRsp;)V
    //   123: invokevirtual 116	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   126: pop
    //   127: return
    //   128: astore_2
    //   129: aconst_null
    //   130: astore_1
    //   131: aload_2
    //   132: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   135: goto -24 -> 111
    //   138: astore_2
    //   139: goto -8 -> 131
    //   142: aconst_null
    //   143: astore_1
    //   144: goto -33 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	xmt
    //   53	91	1	localObject	Object
    //   90	18	2	localJceInputStream	com.qq.taf.jce.JceInputStream
    //   128	4	2	localThrowable1	java.lang.Throwable
    //   138	1	2	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	73	128	java/lang/Throwable
    //   77	106	128	java/lang/Throwable
    //   106	111	138	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xmt
 * JD-Core Version:    0.7.0.1
 */