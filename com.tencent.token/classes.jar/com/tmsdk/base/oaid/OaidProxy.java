package com.tmsdk.base.oaid;

public class OaidProxy
{
  /* Error */
  public static java.lang.String doGetOaid(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: invokestatic 19	com/tmsdk/base/utils/PhoneInfoFetcher:isHUAWEI	()Z
    //   9: ifeq +77 -> 86
    //   12: new 21	android/content/Intent
    //   15: dup
    //   16: ldc 23
    //   18: invokespecial 26	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   21: astore 4
    //   23: aload 4
    //   25: ldc 28
    //   27: invokevirtual 32	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   30: pop
    //   31: new 34	com/tmsdk/base/oaid/OaidProxy$a
    //   34: dup
    //   35: aconst_null
    //   36: invokespecial 37	com/tmsdk/base/oaid/OaidProxy$a:<init>	(Lcom/tmsdk/base/oaid/OaidProxy$1;)V
    //   39: astore_3
    //   40: aload_0
    //   41: aload 4
    //   43: aload_3
    //   44: iconst_1
    //   45: invokevirtual 43	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   48: istore_2
    //   49: iload_2
    //   50: ifeq +36 -> 86
    //   53: aload_3
    //   54: invokevirtual 47	com/tmsdk/base/oaid/OaidProxy$a:getBinder	()Landroid/os/IBinder;
    //   57: invokestatic 53	btmsdkobf/g$a:a	(Landroid/os/IBinder;)Lbtmsdkobf/g;
    //   60: invokeinterface 59 1 0
    //   65: astore 4
    //   67: aload_0
    //   68: aload_3
    //   69: invokevirtual 63	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   72: aload 4
    //   74: areturn
    //   75: astore_0
    //   76: aload 4
    //   78: areturn
    //   79: astore 4
    //   81: aload_0
    //   82: aload_3
    //   83: invokevirtual 63	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   86: invokestatic 66	com/tmsdk/base/utils/PhoneInfoFetcher:isXIAOMI	()Z
    //   89: ifeq +20 -> 109
    //   92: aload_0
    //   93: invokestatic 70	btmsdkobf/f:a	(Landroid/content/Context;)Ljava/lang/String;
    //   96: astore_0
    //   97: aload_0
    //   98: areturn
    //   99: astore 4
    //   101: aload_0
    //   102: aload_3
    //   103: invokevirtual 63	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   106: aload 4
    //   108: athrow
    //   109: invokestatic 73	com/tmsdk/base/utils/PhoneInfoFetcher:isOPPO	()Z
    //   112: ifne +10 -> 122
    //   115: aload_0
    //   116: invokestatic 77	com/tmsdk/base/utils/PhoneInfoFetcher:isOnePlus	(Landroid/content/Context;)Z
    //   119: ifeq +8 -> 127
    //   122: aload_0
    //   123: invokestatic 80	btmsdkobf/ev:a	(Landroid/content/Context;)Ljava/lang/String;
    //   126: areturn
    //   127: invokestatic 83	com/tmsdk/base/utils/PhoneInfoFetcher:isVIVO	()Z
    //   130: ifeq +8 -> 138
    //   133: aload_0
    //   134: invokestatic 86	btmsdkobf/ew:a	(Landroid/content/Context;)Ljava/lang/String;
    //   137: areturn
    //   138: invokestatic 89	com/tmsdk/base/utils/PhoneInfoFetcher:isMEIZU	()Z
    //   141: ifeq +8 -> 149
    //   144: aload_0
    //   145: invokestatic 92	btmsdkobf/b:a	(Landroid/content/Context;)Ljava/lang/String;
    //   148: areturn
    //   149: invokestatic 95	com/tmsdk/base/utils/PhoneInfoFetcher:isLenovo	()Z
    //   152: istore_2
    //   153: iload_2
    //   154: ifeq +120 -> 274
    //   157: new 4	java/lang/Object
    //   160: dup
    //   161: invokespecial 8	java/lang/Object:<init>	()V
    //   164: astore_3
    //   165: new 97	java/util/ArrayList
    //   168: dup
    //   169: invokespecial 98	java/util/ArrayList:<init>	()V
    //   172: astore 4
    //   174: aload 4
    //   176: ldc 100
    //   178: invokevirtual 104	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   181: pop
    //   182: new 106	btmsdkobf/m
    //   185: dup
    //   186: invokespecial 107	btmsdkobf/m:<init>	()V
    //   189: aload_0
    //   190: new 109	com/tmsdk/base/oaid/OaidProxy$2
    //   193: dup
    //   194: aload 4
    //   196: aload_3
    //   197: invokespecial 112	com/tmsdk/base/oaid/OaidProxy$2:<init>	(Ljava/util/ArrayList;Ljava/lang/Object;)V
    //   200: invokevirtual 115	btmsdkobf/m:a	(Landroid/content/Context;Lbtmsdkobf/m$a;)I
    //   203: pop
    //   204: aload_3
    //   205: monitorenter
    //   206: aload 4
    //   208: iconst_0
    //   209: invokevirtual 119	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   212: checkcast 121	java/lang/String
    //   215: ldc 100
    //   217: invokevirtual 125	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   220: istore_1
    //   221: iload_1
    //   222: ifne +7 -> 229
    //   225: aload_3
    //   226: invokevirtual 128	java/lang/Object:wait	()V
    //   229: aload_3
    //   230: monitorexit
    //   231: aload 4
    //   233: invokevirtual 132	java/util/ArrayList:size	()I
    //   236: iconst_1
    //   237: if_icmple +37 -> 274
    //   240: aload 4
    //   242: iconst_1
    //   243: invokevirtual 119	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   246: checkcast 121	java/lang/String
    //   249: astore_0
    //   250: aload_0
    //   251: areturn
    //   252: astore_0
    //   253: aload_3
    //   254: monitorexit
    //   255: aload_0
    //   256: athrow
    //   257: astore_0
    //   258: goto +16 -> 274
    //   261: astore_3
    //   262: goto -176 -> 86
    //   265: astore_0
    //   266: goto -160 -> 106
    //   269: astore_0
    //   270: goto -41 -> 229
    //   273: astore_0
    //   274: aconst_null
    //   275: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramContext	android.content.Context
    //   220	2	1	i	int
    //   48	106	2	bool	boolean
    //   39	215	3	localObject1	Object
    //   261	1	3	localThrowable1	java.lang.Throwable
    //   21	56	4	localObject2	Object
    //   79	1	4	localThrowable2	java.lang.Throwable
    //   99	8	4	localObject3	Object
    //   172	69	4	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   67	72	75	java/lang/Throwable
    //   53	67	79	java/lang/Throwable
    //   53	67	99	finally
    //   206	221	252	finally
    //   225	229	252	finally
    //   229	231	252	finally
    //   253	255	252	finally
    //   157	206	257	java/lang/Throwable
    //   231	250	257	java/lang/Throwable
    //   255	257	257	java/lang/Throwable
    //   81	86	261	java/lang/Throwable
    //   101	106	265	java/lang/Throwable
    //   225	229	269	java/lang/Throwable
    //   6	49	273	java/lang/Throwable
    //   86	97	273	java/lang/Throwable
    //   106	109	273	java/lang/Throwable
    //   109	122	273	java/lang/Throwable
    //   122	127	273	java/lang/Throwable
    //   127	138	273	java/lang/Throwable
    //   138	149	273	java/lang/Throwable
    //   149	153	273	java/lang/Throwable
  }
  
  /* Error */
  public static java.lang.String getOaid(android.content.Context paramContext)
  {
    // Byte code:
    //   0: new 4	java/lang/Object
    //   3: dup
    //   4: invokespecial 8	java/lang/Object:<init>	()V
    //   7: astore_1
    //   8: new 135	java/util/concurrent/atomic/AtomicReference
    //   11: dup
    //   12: ldc 137
    //   14: invokespecial 140	java/util/concurrent/atomic/AtomicReference:<init>	(Ljava/lang/Object;)V
    //   17: astore_2
    //   18: new 142	com/tmsdk/base/oaid/OaidProxy$1
    //   21: dup
    //   22: aload_2
    //   23: aload_0
    //   24: aload_1
    //   25: invokespecial 145	com/tmsdk/base/oaid/OaidProxy$1:<init>	(Ljava/util/concurrent/atomic/AtomicReference;Landroid/content/Context;Ljava/lang/Object;)V
    //   28: invokevirtual 148	com/tmsdk/base/oaid/OaidProxy$1:start	()V
    //   31: aload_1
    //   32: monitorenter
    //   33: aload_1
    //   34: ldc2_w 149
    //   37: invokevirtual 153	java/lang/Object:wait	(J)V
    //   40: aload_1
    //   41: monitorexit
    //   42: aload_2
    //   43: invokevirtual 156	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   46: checkcast 121	java/lang/String
    //   49: areturn
    //   50: astore_0
    //   51: aload_1
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    //   55: astore_0
    //   56: goto -16 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	paramContext	android.content.Context
    //   7	45	1	localObject	Object
    //   17	26	2	localAtomicReference	java.util.concurrent.atomic.AtomicReference
    // Exception table:
    //   from	to	target	type
    //   33	40	50	finally
    //   40	42	50	finally
    //   51	53	50	finally
    //   33	40	55	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.oaid.OaidProxy
 * JD-Core Version:    0.7.0.1
 */