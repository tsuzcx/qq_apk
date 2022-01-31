public final class wyk
  implements Runnable
{
  public wyk(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 27
    //   2: astore_1
    //   3: invokestatic 32	com/tencent/mobileqq/activity/qwallet/utils/QWalletTools:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +8 -> 16
    //   11: aload_2
    //   12: invokevirtual 38	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   15: astore_1
    //   16: new 40	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   23: invokestatic 47	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   26: invokevirtual 53	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   29: invokevirtual 59	android/content/Context:getFilesDir	()Ljava/io/File;
    //   32: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: ldc 65
    //   37: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore_2
    //   48: aload_2
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 14	wyk:jdField_a_of_type_Int	I
    //   54: iconst_1
    //   55: if_icmpne +61 -> 116
    //   58: aload_2
    //   59: astore_1
    //   60: aload_0
    //   61: getfield 16	wyk:b	I
    //   64: ifle +52 -> 116
    //   67: aload_2
    //   68: astore_1
    //   69: aload_0
    //   70: getfield 16	wyk:b	I
    //   73: iconst_3
    //   74: if_icmpge +42 -> 116
    //   77: new 40	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   84: aload_2
    //   85: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc 73
    //   90: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_0
    //   94: getfield 14	wyk:jdField_a_of_type_Int	I
    //   97: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   100: ldc 73
    //   102: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 16	wyk:b	I
    //   109: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore_1
    //   116: new 78	java/io/File
    //   119: dup
    //   120: aload_1
    //   121: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
    //   124: invokevirtual 85	java/io/File:exists	()Z
    //   127: ifeq +81 -> 208
    //   130: aload_1
    //   131: invokestatic 90	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)[B
    //   134: astore_1
    //   135: aload_1
    //   136: ifnull +72 -> 208
    //   139: aload_1
    //   140: arraylength
    //   141: ifle +67 -> 208
    //   144: new 92	com/qq/taf/jce/JceInputStream
    //   147: dup
    //   148: aload_1
    //   149: invokespecial 95	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   152: astore_2
    //   153: aload_2
    //   154: ldc 97
    //   156: invokevirtual 101	com/qq/taf/jce/JceInputStream:setServerEncoding	(Ljava/lang/String;)I
    //   159: pop
    //   160: new 103	Wallet/PfaFriendRsp
    //   163: dup
    //   164: invokespecial 104	Wallet/PfaFriendRsp:<init>	()V
    //   167: astore_1
    //   168: aload_1
    //   169: aload_2
    //   170: invokevirtual 108	Wallet/PfaFriendRsp:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   173: iconst_0
    //   174: putstatic 111	com/tencent/mobileqq/activity/qwallet/TopayManager:jdField_a_of_type_Int	I
    //   177: getstatic 114	com/tencent/mobileqq/activity/qwallet/TopayManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   180: new 116	wyl
    //   183: dup
    //   184: aload_0
    //   185: aload_1
    //   186: invokespecial 119	wyl:<init>	(Lwyk;LWallet/PfaFriendRsp;)V
    //   189: invokevirtual 125	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   192: pop
    //   193: return
    //   194: astore_2
    //   195: aconst_null
    //   196: astore_1
    //   197: aload_2
    //   198: invokevirtual 128	java/lang/Exception:printStackTrace	()V
    //   201: goto -28 -> 173
    //   204: astore_2
    //   205: goto -8 -> 197
    //   208: aconst_null
    //   209: astore_1
    //   210: goto -37 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	wyk
    //   2	208	1	localObject1	Object
    //   6	164	2	localObject2	Object
    //   194	4	2	localException1	java.lang.Exception
    //   204	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   11	16	194	java/lang/Exception
    //   16	48	194	java/lang/Exception
    //   50	58	194	java/lang/Exception
    //   60	67	194	java/lang/Exception
    //   69	116	194	java/lang/Exception
    //   116	135	194	java/lang/Exception
    //   139	168	194	java/lang/Exception
    //   168	173	204	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wyk
 * JD-Core Version:    0.7.0.1
 */