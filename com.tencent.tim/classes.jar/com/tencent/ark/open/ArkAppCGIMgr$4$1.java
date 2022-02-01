package com.tencent.ark.open;

import com.tencent.ark.open.delegate.IArkDelegateNetCallback;
import java.io.File;

class ArkAppCGIMgr$4$1
  extends IArkDelegateNetCallback
{
  ArkAppCGIMgr$4$1(ArkAppCGIMgr.4 param4, File paramFile) {}
  
  /* Error */
  public void onDownload(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 26	com/tencent/ark/open/delegate/IArkDelegateNetCallback:onDownload	(I)V
    //   5: iload_1
    //   6: ifne +82 -> 88
    //   9: aload_0
    //   10: getfield 14	com/tencent/ark/open/ArkAppCGIMgr$4$1:val$file	Ljava/io/File;
    //   13: invokevirtual 32	java/io/File:length	()J
    //   16: l2i
    //   17: istore_2
    //   18: iload_2
    //   19: ifne +126 -> 145
    //   22: new 22	java/lang/Exception
    //   25: dup
    //   26: ldc 34
    //   28: invokespecial 37	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   31: athrow
    //   32: astore 5
    //   34: aconst_null
    //   35: astore 4
    //   37: aload 4
    //   39: astore_3
    //   40: invokestatic 43	com/tencent/ark/open/ArkAppCGIMgr:access$100	()Lcom/tencent/ark/ArkEnvironmentManager;
    //   43: ldc 45
    //   45: ldc 47
    //   47: iconst_2
    //   48: anewarray 49	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: aload_0
    //   54: getfield 12	com/tencent/ark/open/ArkAppCGIMgr$4$1:this$1	Lcom/tencent/ark/open/ArkAppCGIMgr$4;
    //   57: getfield 55	com/tencent/ark/open/ArkAppCGIMgr$4:val$task	Lcom/tencent/ark/open/ArkAppCGIMgr$QueryTask;
    //   60: getfield 61	com/tencent/ark/open/ArkAppCGIMgr$QueryTask:url	Ljava/lang/String;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload 5
    //   68: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   71: aastore
    //   72: invokestatic 71	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   75: invokevirtual 77	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload 4
    //   80: ifnull +8 -> 88
    //   83: aload 4
    //   85: invokevirtual 82	java/io/FileInputStream:close	()V
    //   88: invokestatic 43	com/tencent/ark/open/ArkAppCGIMgr:access$100	()Lcom/tencent/ark/ArkEnvironmentManager;
    //   91: ldc 45
    //   93: ldc 84
    //   95: iconst_2
    //   96: anewarray 49	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: aload_0
    //   102: getfield 12	com/tencent/ark/open/ArkAppCGIMgr$4$1:this$1	Lcom/tencent/ark/open/ArkAppCGIMgr$4;
    //   105: getfield 55	com/tencent/ark/open/ArkAppCGIMgr$4:val$task	Lcom/tencent/ark/open/ArkAppCGIMgr$QueryTask;
    //   108: getfield 61	com/tencent/ark/open/ArkAppCGIMgr$QueryTask:url	Ljava/lang/String;
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: iload_1
    //   115: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: aastore
    //   119: invokestatic 71	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   122: invokevirtual 77	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_0
    //   126: getfield 12	com/tencent/ark/open/ArkAppCGIMgr$4$1:this$1	Lcom/tencent/ark/open/ArkAppCGIMgr$4;
    //   129: getfield 94	com/tencent/ark/open/ArkAppCGIMgr$4:this$0	Lcom/tencent/ark/open/ArkAppCGIMgr;
    //   132: aload_0
    //   133: getfield 12	com/tencent/ark/open/ArkAppCGIMgr$4$1:this$1	Lcom/tencent/ark/open/ArkAppCGIMgr$4;
    //   136: getfield 55	com/tencent/ark/open/ArkAppCGIMgr$4:val$task	Lcom/tencent/ark/open/ArkAppCGIMgr$QueryTask;
    //   139: iconst_0
    //   140: aconst_null
    //   141: invokestatic 98	com/tencent/ark/open/ArkAppCGIMgr:access$600	(Lcom/tencent/ark/open/ArkAppCGIMgr;Lcom/tencent/ark/open/ArkAppCGIMgr$QueryTask;Z[B)V
    //   144: return
    //   145: new 79	java/io/FileInputStream
    //   148: dup
    //   149: aload_0
    //   150: getfield 14	com/tencent/ark/open/ArkAppCGIMgr$4$1:val$file	Ljava/io/File;
    //   153: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   156: astore 4
    //   158: aload 4
    //   160: astore_3
    //   161: iload_2
    //   162: newarray byte
    //   164: astore 5
    //   166: aload 4
    //   168: astore_3
    //   169: aload 4
    //   171: aload 5
    //   173: invokevirtual 105	java/io/FileInputStream:read	([B)I
    //   176: pop
    //   177: aload 4
    //   179: astore_3
    //   180: aload 4
    //   182: invokevirtual 82	java/io/FileInputStream:close	()V
    //   185: aload 4
    //   187: astore_3
    //   188: aload_0
    //   189: getfield 14	com/tencent/ark/open/ArkAppCGIMgr$4$1:val$file	Ljava/io/File;
    //   192: invokevirtual 109	java/io/File:delete	()Z
    //   195: pop
    //   196: aload 4
    //   198: astore_3
    //   199: aload_0
    //   200: getfield 12	com/tencent/ark/open/ArkAppCGIMgr$4$1:this$1	Lcom/tencent/ark/open/ArkAppCGIMgr$4;
    //   203: getfield 94	com/tencent/ark/open/ArkAppCGIMgr$4:this$0	Lcom/tencent/ark/open/ArkAppCGIMgr;
    //   206: aload_0
    //   207: getfield 12	com/tencent/ark/open/ArkAppCGIMgr$4$1:this$1	Lcom/tencent/ark/open/ArkAppCGIMgr$4;
    //   210: getfield 55	com/tencent/ark/open/ArkAppCGIMgr$4:val$task	Lcom/tencent/ark/open/ArkAppCGIMgr$QueryTask;
    //   213: iconst_1
    //   214: aload 5
    //   216: invokestatic 98	com/tencent/ark/open/ArkAppCGIMgr:access$600	(Lcom/tencent/ark/open/ArkAppCGIMgr;Lcom/tencent/ark/open/ArkAppCGIMgr$QueryTask;Z[B)V
    //   219: aload 4
    //   221: ifnull -77 -> 144
    //   224: aload 4
    //   226: invokevirtual 82	java/io/FileInputStream:close	()V
    //   229: return
    //   230: astore_3
    //   231: invokestatic 43	com/tencent/ark/open/ArkAppCGIMgr:access$100	()Lcom/tencent/ark/ArkEnvironmentManager;
    //   234: ldc 45
    //   236: ldc 111
    //   238: iconst_2
    //   239: anewarray 49	java/lang/Object
    //   242: dup
    //   243: iconst_0
    //   244: aload_0
    //   245: getfield 12	com/tencent/ark/open/ArkAppCGIMgr$4$1:this$1	Lcom/tencent/ark/open/ArkAppCGIMgr$4;
    //   248: getfield 55	com/tencent/ark/open/ArkAppCGIMgr$4:val$task	Lcom/tencent/ark/open/ArkAppCGIMgr$QueryTask;
    //   251: getfield 61	com/tencent/ark/open/ArkAppCGIMgr$QueryTask:url	Ljava/lang/String;
    //   254: aastore
    //   255: dup
    //   256: iconst_1
    //   257: aload_3
    //   258: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   261: aastore
    //   262: invokestatic 71	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   265: invokevirtual 77	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: return
    //   269: astore_3
    //   270: invokestatic 43	com/tencent/ark/open/ArkAppCGIMgr:access$100	()Lcom/tencent/ark/ArkEnvironmentManager;
    //   273: ldc 45
    //   275: ldc 111
    //   277: iconst_2
    //   278: anewarray 49	java/lang/Object
    //   281: dup
    //   282: iconst_0
    //   283: aload_0
    //   284: getfield 12	com/tencent/ark/open/ArkAppCGIMgr$4$1:this$1	Lcom/tencent/ark/open/ArkAppCGIMgr$4;
    //   287: getfield 55	com/tencent/ark/open/ArkAppCGIMgr$4:val$task	Lcom/tencent/ark/open/ArkAppCGIMgr$QueryTask;
    //   290: getfield 61	com/tencent/ark/open/ArkAppCGIMgr$QueryTask:url	Ljava/lang/String;
    //   293: aastore
    //   294: dup
    //   295: iconst_1
    //   296: aload_3
    //   297: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   300: aastore
    //   301: invokestatic 71	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   304: invokevirtual 77	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: goto -219 -> 88
    //   310: astore 5
    //   312: aconst_null
    //   313: astore 4
    //   315: aload 4
    //   317: astore_3
    //   318: invokestatic 43	com/tencent/ark/open/ArkAppCGIMgr:access$100	()Lcom/tencent/ark/ArkEnvironmentManager;
    //   321: ldc 45
    //   323: ldc 113
    //   325: iconst_2
    //   326: anewarray 49	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: aload_0
    //   332: getfield 12	com/tencent/ark/open/ArkAppCGIMgr$4$1:this$1	Lcom/tencent/ark/open/ArkAppCGIMgr$4;
    //   335: getfield 55	com/tencent/ark/open/ArkAppCGIMgr$4:val$task	Lcom/tencent/ark/open/ArkAppCGIMgr$QueryTask;
    //   338: getfield 61	com/tencent/ark/open/ArkAppCGIMgr$QueryTask:url	Ljava/lang/String;
    //   341: aastore
    //   342: dup
    //   343: iconst_1
    //   344: aload 5
    //   346: invokevirtual 114	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   349: aastore
    //   350: invokestatic 71	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   353: invokevirtual 77	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload 4
    //   358: ifnull -270 -> 88
    //   361: aload 4
    //   363: invokevirtual 82	java/io/FileInputStream:close	()V
    //   366: goto -278 -> 88
    //   369: astore_3
    //   370: invokestatic 43	com/tencent/ark/open/ArkAppCGIMgr:access$100	()Lcom/tencent/ark/ArkEnvironmentManager;
    //   373: ldc 45
    //   375: ldc 111
    //   377: iconst_2
    //   378: anewarray 49	java/lang/Object
    //   381: dup
    //   382: iconst_0
    //   383: aload_0
    //   384: getfield 12	com/tencent/ark/open/ArkAppCGIMgr$4$1:this$1	Lcom/tencent/ark/open/ArkAppCGIMgr$4;
    //   387: getfield 55	com/tencent/ark/open/ArkAppCGIMgr$4:val$task	Lcom/tencent/ark/open/ArkAppCGIMgr$QueryTask;
    //   390: getfield 61	com/tencent/ark/open/ArkAppCGIMgr$QueryTask:url	Ljava/lang/String;
    //   393: aastore
    //   394: dup
    //   395: iconst_1
    //   396: aload_3
    //   397: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   400: aastore
    //   401: invokestatic 71	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   404: invokevirtual 77	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: goto -319 -> 88
    //   410: astore 4
    //   412: aconst_null
    //   413: astore_3
    //   414: aload_3
    //   415: ifnull +7 -> 422
    //   418: aload_3
    //   419: invokevirtual 82	java/io/FileInputStream:close	()V
    //   422: aload 4
    //   424: athrow
    //   425: astore_3
    //   426: invokestatic 43	com/tencent/ark/open/ArkAppCGIMgr:access$100	()Lcom/tencent/ark/ArkEnvironmentManager;
    //   429: ldc 45
    //   431: ldc 111
    //   433: iconst_2
    //   434: anewarray 49	java/lang/Object
    //   437: dup
    //   438: iconst_0
    //   439: aload_0
    //   440: getfield 12	com/tencent/ark/open/ArkAppCGIMgr$4$1:this$1	Lcom/tencent/ark/open/ArkAppCGIMgr$4;
    //   443: getfield 55	com/tencent/ark/open/ArkAppCGIMgr$4:val$task	Lcom/tencent/ark/open/ArkAppCGIMgr$QueryTask;
    //   446: getfield 61	com/tencent/ark/open/ArkAppCGIMgr$QueryTask:url	Ljava/lang/String;
    //   449: aastore
    //   450: dup
    //   451: iconst_1
    //   452: aload_3
    //   453: invokevirtual 65	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   456: aastore
    //   457: invokestatic 71	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   460: invokevirtual 77	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   463: goto -41 -> 422
    //   466: astore 4
    //   468: goto -54 -> 414
    //   471: astore 5
    //   473: goto -158 -> 315
    //   476: astore 5
    //   478: goto -441 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	481	0	this	1
    //   0	481	1	paramInt	int
    //   17	145	2	i	int
    //   39	160	3	localFileInputStream1	java.io.FileInputStream
    //   230	28	3	localException1	java.lang.Exception
    //   269	28	3	localException2	java.lang.Exception
    //   317	1	3	localFileInputStream2	java.io.FileInputStream
    //   369	28	3	localException3	java.lang.Exception
    //   413	6	3	localObject1	java.lang.Object
    //   425	28	3	localException4	java.lang.Exception
    //   35	327	4	localFileInputStream3	java.io.FileInputStream
    //   410	13	4	localObject2	java.lang.Object
    //   466	1	4	localObject3	java.lang.Object
    //   32	35	5	localException5	java.lang.Exception
    //   164	51	5	arrayOfByte	byte[]
    //   310	35	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   471	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   476	1	5	localException6	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   9	18	32	java/lang/Exception
    //   22	32	32	java/lang/Exception
    //   145	158	32	java/lang/Exception
    //   224	229	230	java/lang/Exception
    //   83	88	269	java/lang/Exception
    //   9	18	310	java/lang/OutOfMemoryError
    //   22	32	310	java/lang/OutOfMemoryError
    //   145	158	310	java/lang/OutOfMemoryError
    //   361	366	369	java/lang/Exception
    //   9	18	410	finally
    //   22	32	410	finally
    //   145	158	410	finally
    //   418	422	425	java/lang/Exception
    //   40	78	466	finally
    //   161	166	466	finally
    //   169	177	466	finally
    //   180	185	466	finally
    //   188	196	466	finally
    //   199	219	466	finally
    //   318	356	466	finally
    //   161	166	471	java/lang/OutOfMemoryError
    //   169	177	471	java/lang/OutOfMemoryError
    //   180	185	471	java/lang/OutOfMemoryError
    //   188	196	471	java/lang/OutOfMemoryError
    //   199	219	471	java/lang/OutOfMemoryError
    //   161	166	476	java/lang/Exception
    //   169	177	476	java/lang/Exception
    //   180	185	476	java/lang/Exception
    //   188	196	476	java/lang/Exception
    //   199	219	476	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCGIMgr.4.1
 * JD-Core Version:    0.7.0.1
 */