import com.tencent.mobileqq.jsp.MediaApiPlugin;
import java.util.concurrent.atomic.AtomicBoolean;

public class dwh
  implements Runnable
{
  public dwh(MediaApiPlugin paramMediaApiPlugin, String paramString1, String paramString2, AtomicBoolean paramAtomicBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 36	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 37	org/json/JSONObject:<init>	()V
    //   7: astore 4
    //   9: invokestatic 43	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   12: astore 5
    //   14: invokestatic 43	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   17: aload_0
    //   18: getfield 17	dwh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: aconst_null
    //   22: ldc 45
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokestatic 50	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Lorg/apache/http/HttpResponse;
    //   29: astore 6
    //   31: aload 6
    //   33: ifnull +236 -> 269
    //   36: aload 6
    //   38: invokeinterface 56 1 0
    //   43: invokeinterface 62 1 0
    //   48: istore_1
    //   49: iload_1
    //   50: istore_2
    //   51: iload_1
    //   52: sipush 200
    //   55: if_icmpne +216 -> 271
    //   58: aload 6
    //   60: invokestatic 65	com/tencent/biz/common/util/HttpUtil:a	(Lorg/apache/http/HttpResponse;)Ljava/io/ByteArrayOutputStream;
    //   63: invokevirtual 71	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   66: astore 6
    //   68: aload 4
    //   70: ldc 73
    //   72: iload_1
    //   73: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   76: pop
    //   77: aload_0
    //   78: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   81: aload 6
    //   83: invokestatic 82	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;[B)Ljava/lang/String;
    //   86: astore 6
    //   88: aload 4
    //   90: ldc 84
    //   92: iconst_0
    //   93: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   96: pop
    //   97: aload 4
    //   99: ldc 86
    //   101: aload 5
    //   103: ldc 87
    //   105: invokevirtual 93	android/content/Context:getString	(I)Ljava/lang/String;
    //   108: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   111: pop
    //   112: aload 4
    //   114: ldc 98
    //   116: aload 6
    //   118: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   121: pop
    //   122: aload_0
    //   123: getfield 19	dwh:b	Ljava/lang/String;
    //   126: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   129: ifne +38 -> 167
    //   132: aload_0
    //   133: getfield 21	dwh:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   136: iconst_0
    //   137: iconst_1
    //   138: invokevirtual 110	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   141: ifeq +26 -> 167
    //   144: aload_0
    //   145: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   148: aload_0
    //   149: getfield 19	dwh:b	Ljava/lang/String;
    //   152: iconst_1
    //   153: anewarray 112	java/lang/String
    //   156: dup
    //   157: iconst_0
    //   158: aload 4
    //   160: invokevirtual 116	org/json/JSONObject:toString	()Ljava/lang/String;
    //   163: aastore
    //   164: invokevirtual 120	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   167: aload_0
    //   168: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   171: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   174: ifnull +26 -> 200
    //   177: aload_0
    //   178: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   181: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   184: invokevirtual 129	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   187: ifeq +13 -> 200
    //   190: aload_0
    //   191: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   194: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   197: invokevirtual 132	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   200: return
    //   201: astore 6
    //   203: aload 4
    //   205: ldc 84
    //   207: iconst_1
    //   208: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   211: pop
    //   212: aload 4
    //   214: ldc 86
    //   216: aload 5
    //   218: ldc 133
    //   220: invokevirtual 93	android/content/Context:getString	(I)Ljava/lang/String;
    //   223: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   226: pop
    //   227: goto -105 -> 122
    //   230: astore 6
    //   232: goto -110 -> 122
    //   235: astore 6
    //   237: aload 4
    //   239: ldc 84
    //   241: iconst_2
    //   242: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   245: pop
    //   246: aload 4
    //   248: ldc 86
    //   250: aload 5
    //   252: ldc 134
    //   254: invokevirtual 93	android/content/Context:getString	(I)Ljava/lang/String;
    //   257: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   260: pop
    //   261: goto -139 -> 122
    //   264: astore 6
    //   266: goto -144 -> 122
    //   269: iconst_m1
    //   270: istore_2
    //   271: iload_2
    //   272: istore_3
    //   273: aload_0
    //   274: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   277: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   280: ifnull +30 -> 310
    //   283: iload_2
    //   284: istore_3
    //   285: aload_0
    //   286: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   289: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   292: invokevirtual 129	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   295: ifeq +15 -> 310
    //   298: aload_0
    //   299: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   302: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   305: invokevirtual 132	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   308: iload_2
    //   309: istore_3
    //   310: aload 4
    //   312: ldc 84
    //   314: iconst_3
    //   315: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   318: pop
    //   319: aload 4
    //   321: ldc 86
    //   323: aload 5
    //   325: ldc 135
    //   327: invokevirtual 93	android/content/Context:getString	(I)Ljava/lang/String;
    //   330: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   333: pop
    //   334: aload 4
    //   336: ldc 73
    //   338: iload_3
    //   339: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   342: pop
    //   343: aload_0
    //   344: getfield 19	dwh:b	Ljava/lang/String;
    //   347: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   350: ifne -150 -> 200
    //   353: aload_0
    //   354: getfield 21	dwh:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   357: iconst_0
    //   358: iconst_1
    //   359: invokevirtual 110	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   362: ifeq -162 -> 200
    //   365: aload_0
    //   366: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   369: aload_0
    //   370: getfield 19	dwh:b	Ljava/lang/String;
    //   373: iconst_1
    //   374: anewarray 112	java/lang/String
    //   377: dup
    //   378: iconst_0
    //   379: aload 4
    //   381: invokevirtual 116	org/json/JSONObject:toString	()Ljava/lang/String;
    //   384: aastore
    //   385: invokevirtual 120	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   388: return
    //   389: astore 6
    //   391: iconst_m1
    //   392: istore_1
    //   393: aload 4
    //   395: ldc 84
    //   397: iconst_m1
    //   398: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   401: pop
    //   402: aload 4
    //   404: ldc 86
    //   406: aload 5
    //   408: ldc 136
    //   410: invokevirtual 93	android/content/Context:getString	(I)Ljava/lang/String;
    //   413: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   416: pop
    //   417: aload 4
    //   419: ldc 73
    //   421: iload_1
    //   422: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   425: pop
    //   426: aload_0
    //   427: getfield 19	dwh:b	Ljava/lang/String;
    //   430: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   433: ifne +38 -> 471
    //   436: aload_0
    //   437: getfield 21	dwh:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   440: iconst_0
    //   441: iconst_1
    //   442: invokevirtual 110	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   445: ifeq +26 -> 471
    //   448: aload_0
    //   449: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   452: aload_0
    //   453: getfield 19	dwh:b	Ljava/lang/String;
    //   456: iconst_1
    //   457: anewarray 112	java/lang/String
    //   460: dup
    //   461: iconst_0
    //   462: aload 4
    //   464: invokevirtual 116	org/json/JSONObject:toString	()Ljava/lang/String;
    //   467: aastore
    //   468: invokevirtual 120	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   471: aload_0
    //   472: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   475: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   478: ifnull -278 -> 200
    //   481: aload_0
    //   482: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   485: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   488: invokevirtual 129	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   491: ifeq -291 -> 200
    //   494: aload_0
    //   495: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   498: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   501: invokevirtual 132	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   504: return
    //   505: astore 6
    //   507: iconst_m1
    //   508: istore_1
    //   509: iload_1
    //   510: istore_3
    //   511: aload_0
    //   512: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   515: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   518: ifnull -208 -> 310
    //   521: iload_1
    //   522: istore_3
    //   523: aload_0
    //   524: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   527: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   530: invokevirtual 129	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   533: ifeq -223 -> 310
    //   536: aload_0
    //   537: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   540: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   543: invokevirtual 132	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   546: iload_1
    //   547: istore_3
    //   548: goto -238 -> 310
    //   551: astore 4
    //   553: aload_0
    //   554: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   557: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   560: ifnull +26 -> 586
    //   563: aload_0
    //   564: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   567: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   570: invokevirtual 129	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   573: ifeq +13 -> 586
    //   576: aload_0
    //   577: getfield 15	dwh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   580: getfield 123	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   583: invokevirtual 132	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   586: aload 4
    //   588: athrow
    //   589: astore 5
    //   591: goto -248 -> 343
    //   594: astore 6
    //   596: goto -87 -> 509
    //   599: astore 5
    //   601: goto -175 -> 426
    //   604: astore 6
    //   606: goto -213 -> 393
    //   609: astore 6
    //   611: goto -489 -> 122
    //   614: astore 7
    //   616: goto -539 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	this	dwh
    //   48	499	1	i	int
    //   50	259	2	j	int
    //   272	276	3	k	int
    //   7	456	4	localJSONObject	org.json.JSONObject
    //   551	36	4	localObject1	Object
    //   12	395	5	localContext	android.content.Context
    //   589	1	5	localJSONException1	org.json.JSONException
    //   599	1	5	localJSONException2	org.json.JSONException
    //   29	88	6	localObject2	Object
    //   201	1	6	localIOException1	java.io.IOException
    //   230	1	6	localJSONException3	org.json.JSONException
    //   235	1	6	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   264	1	6	localJSONException4	org.json.JSONException
    //   389	1	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   505	1	6	localIOException2	java.io.IOException
    //   594	1	6	localIOException3	java.io.IOException
    //   604	1	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   609	1	6	localJSONException5	org.json.JSONException
    //   614	1	7	localJSONException6	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   77	88	201	java/io/IOException
    //   88	122	201	java/io/IOException
    //   203	227	230	org/json/JSONException
    //   77	88	235	java/lang/IllegalArgumentException
    //   88	122	235	java/lang/IllegalArgumentException
    //   237	261	264	org/json/JSONException
    //   14	31	389	java/lang/OutOfMemoryError
    //   36	49	389	java/lang/OutOfMemoryError
    //   14	31	505	java/io/IOException
    //   36	49	505	java/io/IOException
    //   14	31	551	finally
    //   36	49	551	finally
    //   58	68	551	finally
    //   68	77	551	finally
    //   77	88	551	finally
    //   88	122	551	finally
    //   122	167	551	finally
    //   203	227	551	finally
    //   237	261	551	finally
    //   393	426	551	finally
    //   426	471	551	finally
    //   310	343	589	org/json/JSONException
    //   58	68	594	java/io/IOException
    //   68	77	594	java/io/IOException
    //   122	167	594	java/io/IOException
    //   203	227	594	java/io/IOException
    //   237	261	594	java/io/IOException
    //   393	426	599	org/json/JSONException
    //   58	68	604	java/lang/OutOfMemoryError
    //   68	77	604	java/lang/OutOfMemoryError
    //   77	88	604	java/lang/OutOfMemoryError
    //   88	122	604	java/lang/OutOfMemoryError
    //   122	167	604	java/lang/OutOfMemoryError
    //   203	227	604	java/lang/OutOfMemoryError
    //   237	261	604	java/lang/OutOfMemoryError
    //   88	122	609	org/json/JSONException
    //   68	77	614	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dwh
 * JD-Core Version:    0.7.0.1
 */