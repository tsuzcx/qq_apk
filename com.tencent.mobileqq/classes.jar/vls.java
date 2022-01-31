import com.tencent.mobileqq.activity.aio.item.SignatureView;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;

public class vls
  implements Runnable
{
  public vls(SignatureView paramSignatureView, int paramInt, String paramString, SignatureTemplateInfo.DynamicItem paramDynamicItem) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	vls:jdField_a_of_type_Int	I
    //   4: invokestatic 38	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   7: aload_0
    //   8: getfield 19	vls:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokestatic 43	com/tencent/mobileqq/vas/SignatureTemplateConfig:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14: astore 6
    //   16: new 45	java/io/File
    //   19: dup
    //   20: aload 6
    //   22: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +17 -> 44
    //   30: aload_3
    //   31: invokevirtual 52	java/io/File:exists	()Z
    //   34: ifeq +10 -> 44
    //   37: aload_3
    //   38: invokevirtual 55	java/io/File:isDirectory	()Z
    //   41: ifne +18 -> 59
    //   44: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +11 -> 58
    //   50: ldc 62
    //   52: iconst_2
    //   53: ldc 64
    //   55: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: return
    //   59: aload 6
    //   61: invokestatic 73	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   64: astore_3
    //   65: aload_3
    //   66: invokevirtual 79	java/util/ArrayList:size	()I
    //   69: ifle -11 -> 58
    //   72: aload_3
    //   73: invokevirtual 79	java/util/ArrayList:size	()I
    //   76: anewarray 81	java/lang/String
    //   79: astore_3
    //   80: new 83	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   87: astore 4
    //   89: aload 4
    //   91: aload 6
    //   93: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: getstatic 91	java/io/File:separator	Ljava/lang/String;
    //   99: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc 93
    //   104: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 4
    //   110: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: astore 4
    //   115: aload_3
    //   116: arraylength
    //   117: istore_2
    //   118: iconst_0
    //   119: istore_1
    //   120: iload_1
    //   121: iload_2
    //   122: if_icmpge +31 -> 153
    //   125: aload_3
    //   126: iload_1
    //   127: aload 4
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: iload_1
    //   136: iconst_1
    //   137: iadd
    //   138: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   141: aastore
    //   142: invokestatic 104	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   145: aastore
    //   146: iload_1
    //   147: iconst_1
    //   148: iadd
    //   149: istore_1
    //   150: goto -30 -> 120
    //   153: aload_0
    //   154: getfield 15	vls:jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView	Lcom/tencent/mobileqq/activity/aio/item/SignatureView;
    //   157: invokestatic 109	com/tencent/mobileqq/activity/aio/item/SignatureView:a	(Lcom/tencent/mobileqq/activity/aio/item/SignatureView;)Lcom/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable;
    //   160: astore 4
    //   162: aload_0
    //   163: getfield 21	vls:jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   166: getfield 114	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_c_of_type_Int	I
    //   169: ifeq +373 -> 542
    //   172: aload_0
    //   173: getfield 21	vls:jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   176: getfield 114	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_c_of_type_Int	I
    //   179: istore_1
    //   180: aload 4
    //   182: aload_3
    //   183: iload_1
    //   184: invokevirtual 119	com/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable:a	([Ljava/lang/String;I)V
    //   187: aload_0
    //   188: getfield 15	vls:jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView	Lcom/tencent/mobileqq/activity/aio/item/SignatureView;
    //   191: invokestatic 109	com/tencent/mobileqq/activity/aio/item/SignatureView:a	(Lcom/tencent/mobileqq/activity/aio/item/SignatureView;)Lcom/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable;
    //   194: bipush 103
    //   196: invokevirtual 122	com/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable:a	(I)V
    //   199: aload_0
    //   200: getfield 15	vls:jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView	Lcom/tencent/mobileqq/activity/aio/item/SignatureView;
    //   203: invokestatic 109	com/tencent/mobileqq/activity/aio/item/SignatureView:a	(Lcom/tencent/mobileqq/activity/aio/item/SignatureView;)Lcom/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable;
    //   206: astore 4
    //   208: aload_0
    //   209: getfield 15	vls:jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView	Lcom/tencent/mobileqq/activity/aio/item/SignatureView;
    //   212: invokestatic 125	com/tencent/mobileqq/activity/aio/item/SignatureView:a	(Lcom/tencent/mobileqq/activity/aio/item/SignatureView;)Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   215: getfield 128	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_b_of_type_Int	I
    //   218: ifeq +330 -> 548
    //   221: aload_0
    //   222: getfield 15	vls:jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView	Lcom/tencent/mobileqq/activity/aio/item/SignatureView;
    //   225: invokestatic 125	com/tencent/mobileqq/activity/aio/item/SignatureView:a	(Lcom/tencent/mobileqq/activity/aio/item/SignatureView;)Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   228: getfield 128	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_b_of_type_Int	I
    //   231: istore_1
    //   232: aload 4
    //   234: iload_1
    //   235: putfield 131	com/tencent/mobileqq/activity/aio/anim/VipPngPlayAnimationDrawable:f	I
    //   238: aload_0
    //   239: getfield 15	vls:jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView	Lcom/tencent/mobileqq/activity/aio/item/SignatureView;
    //   242: iconst_1
    //   243: putfield 134	com/tencent/mobileqq/activity/aio/item/SignatureView:c	Z
    //   246: aload_0
    //   247: getfield 15	vls:jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView	Lcom/tencent/mobileqq/activity/aio/item/SignatureView;
    //   250: invokevirtual 138	com/tencent/mobileqq/activity/aio/item/SignatureView:getHandler	()Landroid/os/Handler;
    //   253: astore 4
    //   255: aload 4
    //   257: ifnull +20 -> 277
    //   260: aload 4
    //   262: new 140	vlt
    //   265: dup
    //   266: aload_0
    //   267: invokespecial 143	vlt:<init>	(Lvls;)V
    //   270: ldc2_w 144
    //   273: invokevirtual 151	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   276: pop
    //   277: new 153	java/io/BufferedInputStream
    //   280: dup
    //   281: new 155	java/io/FileInputStream
    //   284: dup
    //   285: aload_3
    //   286: iconst_0
    //   287: aaload
    //   288: invokespecial 156	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   291: invokespecial 159	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   294: astore 4
    //   296: aload 4
    //   298: astore_3
    //   299: new 161	android/graphics/BitmapFactory$Options
    //   302: dup
    //   303: invokespecial 162	android/graphics/BitmapFactory$Options:<init>	()V
    //   306: astore 5
    //   308: aload 4
    //   310: astore_3
    //   311: aload 5
    //   313: sipush 320
    //   316: putfield 165	android/graphics/BitmapFactory$Options:inDensity	I
    //   319: aload 4
    //   321: astore_3
    //   322: aload 5
    //   324: aload_0
    //   325: getfield 15	vls:jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView	Lcom/tencent/mobileqq/activity/aio/item/SignatureView;
    //   328: invokevirtual 169	com/tencent/mobileqq/activity/aio/item/SignatureView:getResources	()Landroid/content/res/Resources;
    //   331: invokevirtual 175	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   334: getfield 180	android/util/DisplayMetrics:densityDpi	I
    //   337: putfield 183	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   340: aload 4
    //   342: astore_3
    //   343: aload 4
    //   345: aconst_null
    //   346: aload 5
    //   348: invokestatic 189	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   351: invokestatic 192	com/tencent/mobileqq/activity/aio/item/SignatureView:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   354: pop
    //   355: aload 4
    //   357: ifnull +8 -> 365
    //   360: aload 4
    //   362: invokevirtual 197	java/io/InputStream:close	()V
    //   365: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   368: ifeq -310 -> 58
    //   371: ldc 62
    //   373: iconst_2
    //   374: new 83	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   381: ldc 199
    //   383: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload_0
    //   387: getfield 17	vls:jdField_a_of_type_Int	I
    //   390: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   393: ldc 204
    //   395: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload_0
    //   399: getfield 19	vls:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   402: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: ldc 206
    //   407: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload_0
    //   411: getfield 21	vls:jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   414: getfield 207	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_a_of_type_Int	I
    //   417: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   420: ldc 209
    //   422: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload_0
    //   426: getfield 21	vls:jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   429: getfield 210	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   432: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: ldc 212
    //   437: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload_0
    //   441: getfield 21	vls:jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   444: getfield 215	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_a_of_type_Float	F
    //   447: invokevirtual 218	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   450: ldc 220
    //   452: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload_0
    //   456: getfield 21	vls:jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   459: getfield 222	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_b_of_type_Float	F
    //   462: invokevirtual 218	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   465: ldc 224
    //   467: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: aload_0
    //   471: getfield 21	vls:jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   474: getfield 226	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_c_of_type_Float	F
    //   477: invokevirtual 218	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   480: ldc 228
    //   482: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload_0
    //   486: getfield 21	vls:jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   489: getfield 230	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:d	F
    //   492: invokevirtual 218	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   495: ldc 232
    //   497: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: aload_0
    //   501: getfield 21	vls:jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   504: getfield 128	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_b_of_type_Int	I
    //   507: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   510: ldc 234
    //   512: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: aload_0
    //   516: getfield 21	vls:jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   519: getfield 114	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_c_of_type_Int	I
    //   522: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   525: ldc 236
    //   527: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload 6
    //   532: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   541: return
    //   542: bipush 50
    //   544: istore_1
    //   545: goto -365 -> 180
    //   548: iconst_3
    //   549: istore_1
    //   550: goto -318 -> 232
    //   553: astore 5
    //   555: aload 4
    //   557: astore_3
    //   558: aload 5
    //   560: invokevirtual 239	java/lang/OutOfMemoryError:printStackTrace	()V
    //   563: aload 4
    //   565: astore_3
    //   566: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   569: ifeq -214 -> 355
    //   572: aload 4
    //   574: astore_3
    //   575: ldc 62
    //   577: iconst_2
    //   578: ldc 241
    //   580: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   583: goto -228 -> 355
    //   586: astore 5
    //   588: aload 4
    //   590: astore_3
    //   591: aload 5
    //   593: invokevirtual 242	java/io/FileNotFoundException:printStackTrace	()V
    //   596: aload 4
    //   598: ifnull -233 -> 365
    //   601: aload 4
    //   603: invokevirtual 197	java/io/InputStream:close	()V
    //   606: goto -241 -> 365
    //   609: astore_3
    //   610: aload_3
    //   611: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   614: goto -249 -> 365
    //   617: astore_3
    //   618: aload_3
    //   619: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   622: goto -257 -> 365
    //   625: astore 4
    //   627: aconst_null
    //   628: astore_3
    //   629: aload_3
    //   630: ifnull +7 -> 637
    //   633: aload_3
    //   634: invokevirtual 197	java/io/InputStream:close	()V
    //   637: aload 4
    //   639: athrow
    //   640: astore_3
    //   641: aload_3
    //   642: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   645: goto -8 -> 637
    //   648: astore 4
    //   650: goto -21 -> 629
    //   653: astore 5
    //   655: aconst_null
    //   656: astore 4
    //   658: goto -70 -> 588
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	661	0	this	vls
    //   119	431	1	i	int
    //   117	6	2	j	int
    //   25	566	3	localObject1	Object
    //   609	2	3	localIOException1	java.io.IOException
    //   617	2	3	localIOException2	java.io.IOException
    //   628	6	3	localObject2	Object
    //   640	2	3	localIOException3	java.io.IOException
    //   87	515	4	localObject3	Object
    //   625	13	4	localObject4	Object
    //   648	1	4	localObject5	Object
    //   656	1	4	localObject6	Object
    //   306	41	5	localOptions	android.graphics.BitmapFactory.Options
    //   553	6	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   586	6	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   653	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   14	517	6	str	String
    // Exception table:
    //   from	to	target	type
    //   299	308	553	java/lang/OutOfMemoryError
    //   311	319	553	java/lang/OutOfMemoryError
    //   322	340	553	java/lang/OutOfMemoryError
    //   343	355	553	java/lang/OutOfMemoryError
    //   299	308	586	java/io/FileNotFoundException
    //   311	319	586	java/io/FileNotFoundException
    //   322	340	586	java/io/FileNotFoundException
    //   343	355	586	java/io/FileNotFoundException
    //   558	563	586	java/io/FileNotFoundException
    //   566	572	586	java/io/FileNotFoundException
    //   575	583	586	java/io/FileNotFoundException
    //   601	606	609	java/io/IOException
    //   360	365	617	java/io/IOException
    //   277	296	625	finally
    //   633	637	640	java/io/IOException
    //   299	308	648	finally
    //   311	319	648	finally
    //   322	340	648	finally
    //   343	355	648	finally
    //   558	563	648	finally
    //   566	572	648	finally
    //   575	583	648	finally
    //   591	596	648	finally
    //   277	296	653	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vls
 * JD-Core Version:    0.7.0.1
 */