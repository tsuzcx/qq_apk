package com.tencent.token;

import java.util.HashMap;

public final class afi
{
  static
  {
    afz.a(afz.bb);
  }
  
  /* Error */
  public static java.lang.String a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: getstatic 32	com/tencent/turingfd/sdk/qps/Pistachio:b	Lcom/tencent/turingfd/sdk/qps/Pistachio;
    //   3: astore_1
    //   4: aload_1
    //   5: aload_0
    //   6: invokevirtual 36	com/tencent/turingfd/sdk/qps/Pistachio:c	(Landroid/content/Context;)V
    //   9: aload_1
    //   10: getfield 39	com/tencent/turingfd/sdk/qps/Pistachio:c	Lcom/tencent/turingfd/sdk/qps/Gooseberry;
    //   13: getfield 45	com/tencent/turingfd/sdk/qps/Gooseberry:k	Ljava/util/Map;
    //   16: ldc 47
    //   18: invokeinterface 53 2 0
    //   23: astore_0
    //   24: aload_0
    //   25: ifnull +11 -> 36
    //   28: aload_0
    //   29: checkcast 55	java/lang/String
    //   32: astore_0
    //   33: goto +6 -> 39
    //   36: ldc 57
    //   38: astore_0
    //   39: aload_0
    //   40: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifeq +6 -> 49
    //   46: ldc 57
    //   48: areturn
    //   49: new 65	java/util/HashSet
    //   52: dup
    //   53: invokespecial 68	java/util/HashSet:<init>	()V
    //   56: astore_1
    //   57: aload_0
    //   58: ldc 70
    //   60: invokevirtual 74	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   63: astore_0
    //   64: aload_0
    //   65: ifnonnull +6 -> 71
    //   68: ldc 57
    //   70: areturn
    //   71: aload_1
    //   72: aload_0
    //   73: invokestatic 80	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   76: invokeinterface 86 2 0
    //   81: pop
    //   82: new 88	java/util/HashMap
    //   85: dup
    //   86: invokespecial 89	java/util/HashMap:<init>	()V
    //   89: astore_2
    //   90: aload_1
    //   91: invokevirtual 93	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   94: astore_3
    //   95: aload_3
    //   96: invokeinterface 99 1 0
    //   101: ifeq +209 -> 310
    //   104: aload_3
    //   105: invokeinterface 103 1 0
    //   110: checkcast 55	java/lang/String
    //   113: astore 4
    //   115: new 88	java/util/HashMap
    //   118: dup
    //   119: invokespecial 89	java/util/HashMap:<init>	()V
    //   122: astore 5
    //   124: new 105	com/tencent/token/acv$b
    //   127: dup
    //   128: aload 4
    //   130: aload 4
    //   132: invokespecial 108	com/tencent/token/acv$b:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: astore_0
    //   136: aconst_null
    //   137: astore_1
    //   138: getstatic 113	com/tencent/token/acu:a	Lcom/tencent/token/acv;
    //   141: astore 6
    //   143: aload 6
    //   145: ifnonnull +32 -> 177
    //   148: ldc 110
    //   150: monitorenter
    //   151: getstatic 113	com/tencent/token/acu:a	Lcom/tencent/token/acv;
    //   154: ifnonnull +11 -> 165
    //   157: ldc 115
    //   159: invokestatic 118	com/tencent/token/acu:a	(Ljava/lang/String;)Lcom/tencent/token/acv;
    //   162: putstatic 113	com/tencent/token/acu:a	Lcom/tencent/token/acv;
    //   165: ldc 110
    //   167: monitorexit
    //   168: goto +9 -> 177
    //   171: astore_0
    //   172: ldc 110
    //   174: monitorexit
    //   175: aload_0
    //   176: athrow
    //   177: getstatic 113	com/tencent/token/acu:a	Lcom/tencent/token/acv;
    //   180: aload_0
    //   181: invokevirtual 123	com/tencent/token/acv:a	(Lcom/tencent/token/acv$b;)Lcom/tencent/token/acv$c;
    //   184: astore_0
    //   185: goto +71 -> 256
    //   188: astore 6
    //   190: aload 6
    //   192: instanceof 26
    //   195: ifne +13 -> 208
    //   198: aload_1
    //   199: astore_0
    //   200: aload 6
    //   202: instanceof 125
    //   205: ifeq +51 -> 256
    //   208: aload_1
    //   209: astore_0
    //   210: getstatic 113	com/tencent/token/acu:a	Lcom/tencent/token/acv;
    //   213: ifnull +43 -> 256
    //   216: ldc 110
    //   218: monitorenter
    //   219: getstatic 113	com/tencent/token/acu:a	Lcom/tencent/token/acv;
    //   222: ifnull +20 -> 242
    //   225: getstatic 113	com/tencent/token/acu:a	Lcom/tencent/token/acv;
    //   228: astore_0
    //   229: aload_0
    //   230: invokevirtual 129	java/lang/Object:getClass	()Ljava/lang/Class;
    //   233: pop
    //   234: aload_0
    //   235: invokevirtual 131	com/tencent/token/acv:a	()V
    //   238: aconst_null
    //   239: putstatic 113	com/tencent/token/acu:a	Lcom/tencent/token/acv;
    //   242: ldc 110
    //   244: monitorexit
    //   245: aload_1
    //   246: astore_0
    //   247: goto +9 -> 256
    //   250: astore_0
    //   251: ldc 110
    //   253: monitorexit
    //   254: aload_0
    //   255: athrow
    //   256: aload_0
    //   257: astore_1
    //   258: aload_0
    //   259: ifnonnull +15 -> 274
    //   262: new 133	com/tencent/token/acv$c
    //   265: dup
    //   266: ldc 57
    //   268: ldc 135
    //   270: invokespecial 136	com/tencent/token/acv$c:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: astore_1
    //   274: aload 5
    //   276: ldc 138
    //   278: aload_1
    //   279: getfield 141	com/tencent/token/acv$c:a	Ljava/lang/String;
    //   282: invokevirtual 145	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   285: pop
    //   286: aload 5
    //   288: ldc 147
    //   290: aload_1
    //   291: getfield 149	com/tencent/token/acv$c:b	Ljava/lang/String;
    //   294: invokevirtual 145	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   297: pop
    //   298: aload_2
    //   299: aload 4
    //   301: aload 5
    //   303: invokevirtual 145	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   306: pop
    //   307: goto -212 -> 95
    //   310: getstatic 154	com/tencent/token/ahg:a	Lcom/tencent/token/ahg;
    //   313: astore_0
    //   314: getstatic 159	com/tencent/turingfd/sdk/qps/for:a	Lcom/tencent/turingfd/sdk/qps/for;
    //   317: astore_1
    //   318: invokestatic 165	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   321: astore_3
    //   322: getstatic 170	com/tencent/turingfd/sdk/qps/throw:a	Lcom/tencent/turingfd/sdk/qps/throw;
    //   325: astore 4
    //   327: invokestatic 174	java/util/Collections:emptyList	()Ljava/util/List;
    //   330: pop
    //   331: invokestatic 174	java/util/Collections:emptyList	()Ljava/util/List;
    //   334: pop
    //   335: new 176	com/tencent/token/ahx
    //   338: dup
    //   339: aload_0
    //   340: aload_1
    //   341: aload_3
    //   342: aload 4
    //   344: invokestatic 174	java/util/Collections:emptyList	()Ljava/util/List;
    //   347: invokespecial 179	com/tencent/token/ahx:<init>	(Lcom/tencent/token/ahg;Lcom/tencent/token/ahl;Ljava/util/Map;Lcom/tencent/turingfd/sdk/qps/throw;Ljava/util/List;)V
    //   350: astore_0
    //   351: new 6	com/tencent/token/afi$a
    //   354: dup
    //   355: invokespecial 180	com/tencent/token/afi$a:<init>	()V
    //   358: getfield 185	com/tencent/token/aek:b	Ljava/lang/reflect/Type;
    //   361: astore_1
    //   362: new 187	java/io/StringWriter
    //   365: dup
    //   366: invokespecial 188	java/io/StringWriter:<init>	()V
    //   369: astore_3
    //   370: aload_0
    //   371: getfield 192	com/tencent/token/ahx:h	Z
    //   374: ifeq +9 -> 383
    //   377: aload_3
    //   378: ldc 194
    //   380: invokevirtual 200	java/io/Writer:write	(Ljava/lang/String;)V
    //   383: new 202	com/tencent/token/aep
    //   386: dup
    //   387: aload_3
    //   388: invokespecial 205	com/tencent/token/aep:<init>	(Ljava/io/Writer;)V
    //   391: astore 4
    //   393: aload_0
    //   394: getfield 208	com/tencent/token/ahx:j	Z
    //   397: ifeq +17 -> 414
    //   400: aload 4
    //   402: ldc 210
    //   404: putfield 212	com/tencent/token/aep:k	Ljava/lang/String;
    //   407: aload 4
    //   409: ldc 214
    //   411: putfield 217	com/tencent/token/aep:l	Ljava/lang/String;
    //   414: aload 4
    //   416: aload_0
    //   417: getfield 220	com/tencent/token/ahx:g	Z
    //   420: putfield 223	com/tencent/token/aep:p	Z
    //   423: aload_0
    //   424: aload_2
    //   425: aload_1
    //   426: aload 4
    //   428: invokevirtual 226	com/tencent/token/ahx:a	(Ljava/lang/Object;Ljava/lang/reflect/Type;Lcom/tencent/token/aep;)V
    //   431: aload_3
    //   432: invokevirtual 230	java/io/StringWriter:toString	()Ljava/lang/String;
    //   435: areturn
    //   436: astore_0
    //   437: new 232	com/tencent/turingfd/sdk/qps/break
    //   440: dup
    //   441: aload_0
    //   442: invokespecial 235	com/tencent/turingfd/sdk/qps/break:<init>	(Ljava/lang/Throwable;)V
    //   445: athrow
    //   446: astore_0
    //   447: goto -411 -> 36
    //   450: astore_0
    //   451: goto -213 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	454	0	paramContext	android.content.Context
    //   3	423	1	localObject1	Object
    //   89	336	2	localHashMap1	HashMap
    //   94	338	3	localObject2	Object
    //   113	314	4	localObject3	Object
    //   122	180	5	localHashMap2	HashMap
    //   141	3	6	localacv	acv
    //   188	13	6	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   151	165	171	finally
    //   165	168	171	finally
    //   172	175	171	finally
    //   138	143	188	java/lang/Exception
    //   148	151	188	java/lang/Exception
    //   175	177	188	java/lang/Exception
    //   177	185	188	java/lang/Exception
    //   219	234	250	finally
    //   238	242	250	finally
    //   242	245	250	finally
    //   251	254	250	finally
    //   370	383	436	java/io/IOException
    //   383	414	436	java/io/IOException
    //   414	431	436	java/io/IOException
    //   9	24	446	finally
    //   28	33	446	finally
    //   234	238	450	finally
  }
  
  public final class a
    extends aek<HashMap>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afi
 * JD-Core Version:    0.7.0.1
 */