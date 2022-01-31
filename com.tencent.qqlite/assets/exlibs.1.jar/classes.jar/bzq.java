import android.os.AsyncTask;
import com.tencent.mobileqq.activity.aio.photo.AIOImageInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import java.util.ArrayList;

public class bzq
  extends AsyncTask
{
  static final int jdField_a_of_type_Int = 0;
  static final int b = 1;
  static final int c = 2;
  static final int d = 0;
  static final int e = 1;
  static final int f = 2;
  static final int g = 10;
  static final int h = 11;
  static final int i = 20;
  static final int j = 21;
  static final int k = 22;
  static final int l = 23;
  static final int m = 24;
  static final int n = 30;
  public AIOImageInfo a;
  private boolean jdField_a_of_type_Boolean = true;
  AIOImageInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIOImageInfo;
  int o;
  
  public bzq(AIOImageListScene paramAIOImageListScene, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIOImageInfo = ((AIOImageInfo[])paramArrayList.toArray(new AIOImageInfo[0]));
  }
  
  /* Error */
  protected Integer a(Integer... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +766 -> 769
    //   6: ldc 70
    //   8: iconst_2
    //   9: new 72	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   16: ldc 75
    //   18: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: goto +738 -> 769
    //   34: iload_3
    //   35: aload_1
    //   36: arraylength
    //   37: if_icmpge +722 -> 759
    //   40: aload_1
    //   41: iload_3
    //   42: aaload
    //   43: invokevirtual 95	java/lang/Integer:intValue	()I
    //   46: istore 4
    //   48: aload_0
    //   49: getfield 44	bzq:jdField_a_of_type_Boolean	Z
    //   52: ifne +8 -> 60
    //   55: iconst_1
    //   56: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: areturn
    //   60: aload_0
    //   61: iconst_1
    //   62: anewarray 91	java/lang/Integer
    //   65: dup
    //   66: iconst_0
    //   67: iload_3
    //   68: bipush 100
    //   70: imul
    //   71: aload_1
    //   72: arraylength
    //   73: idiv
    //   74: ldc 100
    //   76: iand
    //   77: iload 4
    //   79: bipush 16
    //   81: ishl
    //   82: ior
    //   83: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   86: aastore
    //   87: invokevirtual 104	bzq:publishProgress	([Ljava/lang/Object;)V
    //   90: iload 4
    //   92: tableswitch	default:+684 -> 776, 0:+691->783, 1:+349->441, 2:+691->783
    //   121: aload_0
    //   122: getfield 55	bzq:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIOImageInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIOImageInfo;
    //   125: arraylength
    //   126: if_icmpge +203 -> 329
    //   129: aload_0
    //   130: getfield 44	bzq:jdField_a_of_type_Boolean	Z
    //   133: ifne +8 -> 141
    //   136: iconst_1
    //   137: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: areturn
    //   141: aload_0
    //   142: iconst_1
    //   143: anewarray 91	java/lang/Integer
    //   146: dup
    //   147: iconst_0
    //   148: iload_3
    //   149: bipush 100
    //   151: imul
    //   152: aload_1
    //   153: arraylength
    //   154: idiv
    //   155: iload_2
    //   156: bipush 100
    //   158: imul
    //   159: aload_1
    //   160: arraylength
    //   161: idiv
    //   162: aload_0
    //   163: getfield 55	bzq:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIOImageInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIOImageInfo;
    //   166: arraylength
    //   167: idiv
    //   168: iadd
    //   169: ldc 100
    //   171: iand
    //   172: iload 4
    //   174: bipush 16
    //   176: ishl
    //   177: ior
    //   178: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   181: aastore
    //   182: invokevirtual 104	bzq:publishProgress	([Ljava/lang/Object;)V
    //   185: aload_0
    //   186: getfield 55	bzq:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIOImageInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIOImageInfo;
    //   189: iload_2
    //   190: aaload
    //   191: astore 8
    //   193: aload 8
    //   195: getfield 107	com/tencent/mobileqq/activity/aio/photo/AIOImageInfo:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;
    //   198: getfield 112	com/tencent/mobileqq/activity/aio/photo/AIOImageData:e	Ljava/lang/String;
    //   201: astore 9
    //   203: ldc 114
    //   205: aload 9
    //   207: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   210: ifeq +6 -> 216
    //   213: goto +575 -> 788
    //   216: aload_0
    //   217: aload 8
    //   219: putfield 122	bzq:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageInfo;
    //   222: aload_0
    //   223: getfield 44	bzq:jdField_a_of_type_Boolean	Z
    //   226: ifeq +127 -> 353
    //   229: aload 9
    //   231: ifnull +28 -> 259
    //   234: aload 9
    //   236: ldc 124
    //   238: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   241: ifne +18 -> 259
    //   244: new 126	java/io/File
    //   247: dup
    //   248: aload 9
    //   250: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   253: invokevirtual 132	java/io/File:exists	()Z
    //   256: ifne +97 -> 353
    //   259: aload_0
    //   260: getfield 39	bzq:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageListScene;
    //   263: invokestatic 137	com/tencent/mobileqq/activity/aio/photo/AIOImageListScene:a	(Lcom/tencent/mobileqq/activity/aio/photo/AIOImageListScene;)Lcom/tencent/mobileqq/activity/aio/photo/IAIOImageProvider;
    //   266: aload 8
    //   268: getfield 107	com/tencent/mobileqq/activity/aio/photo/AIOImageInfo:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;
    //   271: getfield 140	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	J
    //   274: aload 8
    //   276: getfield 107	com/tencent/mobileqq/activity/aio/photo/AIOImageInfo:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;
    //   279: getfield 142	com/tencent/mobileqq/activity/aio/photo/AIOImageData:d	I
    //   282: iconst_2
    //   283: invokeinterface 147 5 0
    //   288: aload_0
    //   289: getfield 122	bzq:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageInfo;
    //   292: astore 9
    //   294: aload 9
    //   296: monitorenter
    //   297: aload_0
    //   298: getfield 122	bzq:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageInfo;
    //   301: invokevirtual 152	java/lang/Object:wait	()V
    //   304: aload 9
    //   306: monitorexit
    //   307: ldc 154
    //   309: aload_0
    //   310: getfield 122	bzq:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageInfo;
    //   313: getfield 107	com/tencent/mobileqq/activity/aio/photo/AIOImageInfo:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;
    //   316: getfield 112	com/tencent/mobileqq/activity/aio/photo/AIOImageData:e	Ljava/lang/String;
    //   319: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   322: istore 5
    //   324: iload 5
    //   326: ifeq +27 -> 353
    //   329: iload 4
    //   331: iconst_2
    //   332: if_icmpne +463 -> 795
    //   335: bipush 30
    //   337: istore_2
    //   338: goto +438 -> 776
    //   341: astore_1
    //   342: aload 9
    //   344: monitorexit
    //   345: aload_1
    //   346: athrow
    //   347: astore_1
    //   348: iconst_2
    //   349: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: areturn
    //   353: aload_0
    //   354: getfield 44	bzq:jdField_a_of_type_Boolean	Z
    //   357: ifne +8 -> 365
    //   360: iconst_1
    //   361: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   364: areturn
    //   365: aload 8
    //   367: getfield 107	com/tencent/mobileqq/activity/aio/photo/AIOImageInfo:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;
    //   370: iconst_2
    //   371: invokevirtual 157	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   374: ifnonnull +414 -> 788
    //   377: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   380: ifeq +44 -> 424
    //   383: ldc 70
    //   385: iconst_2
    //   386: new 72	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   393: ldc 159
    //   395: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: iload_2
    //   399: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   402: ldc 164
    //   404: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload 8
    //   409: getfield 107	com/tencent/mobileqq/activity/aio/photo/AIOImageInfo:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;
    //   412: getfield 112	com/tencent/mobileqq/activity/aio/photo/AIOImageData:e	Ljava/lang/String;
    //   415: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   424: aload_0
    //   425: aload_0
    //   426: getfield 55	bzq:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIOImageInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIOImageInfo;
    //   429: arraylength
    //   430: iload_2
    //   431: isub
    //   432: putfield 166	bzq:o	I
    //   435: bipush 11
    //   437: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   440: areturn
    //   441: invokestatic 171	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   444: ldc 173
    //   446: invokevirtual 177	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   449: ifne +23 -> 472
    //   452: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   455: ifeq +11 -> 466
    //   458: ldc 70
    //   460: iconst_2
    //   461: ldc 179
    //   463: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: bipush 23
    //   468: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   471: areturn
    //   472: new 126	java/io/File
    //   475: dup
    //   476: getstatic 184	com/tencent/mobileqq/app/AppConstants:au	Ljava/lang/String;
    //   479: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   482: astore 8
    //   484: aload 8
    //   486: invokevirtual 132	java/io/File:exists	()Z
    //   489: ifne +312 -> 801
    //   492: aload 8
    //   494: invokevirtual 187	java/io/File:mkdirs	()Z
    //   497: pop
    //   498: goto +303 -> 801
    //   501: iload_2
    //   502: aload_0
    //   503: getfield 55	bzq:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIOImageInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIOImageInfo;
    //   506: arraylength
    //   507: if_icmpge +235 -> 742
    //   510: aload_0
    //   511: getfield 55	bzq:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIOImageInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIOImageInfo;
    //   514: iload_2
    //   515: aaload
    //   516: astore 9
    //   518: aload_0
    //   519: getfield 44	bzq:jdField_a_of_type_Boolean	Z
    //   522: ifne +8 -> 530
    //   525: iconst_1
    //   526: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   529: areturn
    //   530: aload_0
    //   531: iconst_1
    //   532: anewarray 91	java/lang/Integer
    //   535: dup
    //   536: iconst_0
    //   537: iload_3
    //   538: bipush 100
    //   540: imul
    //   541: aload_1
    //   542: arraylength
    //   543: idiv
    //   544: iload_2
    //   545: bipush 100
    //   547: imul
    //   548: aload_1
    //   549: arraylength
    //   550: idiv
    //   551: aload_0
    //   552: getfield 55	bzq:jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIOImageInfo	[Lcom/tencent/mobileqq/activity/aio/photo/AIOImageInfo;
    //   555: arraylength
    //   556: idiv
    //   557: iadd
    //   558: ldc 100
    //   560: iand
    //   561: iload 4
    //   563: bipush 16
    //   565: ishl
    //   566: ior
    //   567: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   570: aastore
    //   571: invokevirtual 104	bzq:publishProgress	([Ljava/lang/Object;)V
    //   574: aload 9
    //   576: getfield 107	com/tencent/mobileqq/activity/aio/photo/AIOImageInfo:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;
    //   579: iconst_2
    //   580: invokevirtual 157	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   583: astore 9
    //   585: aload 9
    //   587: ifnull +219 -> 806
    //   590: invokestatic 191	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   593: invokestatic 197	com/tencent/image/Utils:getUsableSpace	(Ljava/io/File;)J
    //   596: lstore 6
    //   598: aload 9
    //   600: invokevirtual 201	java/io/File:length	()J
    //   603: lload 6
    //   605: lcmp
    //   606: ifle +23 -> 629
    //   609: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   612: ifeq +11 -> 623
    //   615: ldc 70
    //   617: iconst_2
    //   618: ldc 203
    //   620: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   623: bipush 22
    //   625: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   628: areturn
    //   629: new 126	java/io/File
    //   632: dup
    //   633: aload 8
    //   635: new 72	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   642: aload 9
    //   644: invokevirtual 206	java/io/File:getName	()Ljava/lang/String;
    //   647: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: ldc 208
    //   652: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   658: invokespecial 211	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   661: astore 10
    //   663: aload 9
    //   665: aload 10
    //   667: invokestatic 216	com/dataline/util/file/FileUtil:a	(Ljava/io/File;Ljava/io/File;)Z
    //   670: ifne +54 -> 724
    //   673: invokestatic 171	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   676: ldc 173
    //   678: invokevirtual 177	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   681: ifne +23 -> 704
    //   684: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   687: ifeq +11 -> 698
    //   690: ldc 70
    //   692: iconst_2
    //   693: ldc 218
    //   695: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   698: bipush 24
    //   700: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   703: areturn
    //   704: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   707: ifeq +11 -> 718
    //   710: ldc 70
    //   712: iconst_2
    //   713: ldc 220
    //   715: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   718: bipush 21
    //   720: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   723: areturn
    //   724: aload_0
    //   725: getfield 39	bzq:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageListScene;
    //   728: invokestatic 223	com/tencent/mobileqq/activity/aio/photo/AIOImageListScene:a	(Lcom/tencent/mobileqq/activity/aio/photo/AIOImageListScene;)Landroid/app/Activity;
    //   731: aload 10
    //   733: invokevirtual 226	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   736: invokestatic 231	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   739: goto +67 -> 806
    //   742: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   745: ifeq +68 -> 813
    //   748: ldc 70
    //   750: iconst_2
    //   751: ldc 233
    //   753: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   756: goto +57 -> 813
    //   759: iload_2
    //   760: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   763: areturn
    //   764: astore 10
    //   766: goto -462 -> 304
    //   769: iconst_0
    //   770: istore_3
    //   771: iconst_0
    //   772: istore_2
    //   773: goto -739 -> 34
    //   776: iload_3
    //   777: iconst_1
    //   778: iadd
    //   779: istore_3
    //   780: goto -746 -> 34
    //   783: iconst_0
    //   784: istore_2
    //   785: goto -665 -> 120
    //   788: iload_2
    //   789: iconst_1
    //   790: iadd
    //   791: istore_2
    //   792: goto -672 -> 120
    //   795: bipush 10
    //   797: istore_2
    //   798: goto -22 -> 776
    //   801: iconst_0
    //   802: istore_2
    //   803: goto -302 -> 501
    //   806: iload_2
    //   807: iconst_1
    //   808: iadd
    //   809: istore_2
    //   810: goto -309 -> 501
    //   813: bipush 20
    //   815: istore_2
    //   816: goto -40 -> 776
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	819	0	this	bzq
    //   0	819	1	paramVarArgs	Integer[]
    //   120	696	2	i1	int
    //   34	746	3	i2	int
    //   46	520	4	i3	int
    //   322	3	5	bool	boolean
    //   596	8	6	l1	long
    //   191	443	8	localObject1	java.lang.Object
    //   661	71	10	localFile	java.io.File
    //   764	1	10	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   297	304	341	finally
    //   304	307	341	finally
    //   342	345	341	finally
    //   0	31	347	java/lang/Throwable
    //   34	60	347	java/lang/Throwable
    //   60	90	347	java/lang/Throwable
    //   120	141	347	java/lang/Throwable
    //   141	213	347	java/lang/Throwable
    //   216	229	347	java/lang/Throwable
    //   234	259	347	java/lang/Throwable
    //   259	297	347	java/lang/Throwable
    //   307	324	347	java/lang/Throwable
    //   345	347	347	java/lang/Throwable
    //   353	365	347	java/lang/Throwable
    //   365	424	347	java/lang/Throwable
    //   424	441	347	java/lang/Throwable
    //   441	466	347	java/lang/Throwable
    //   466	472	347	java/lang/Throwable
    //   472	498	347	java/lang/Throwable
    //   501	530	347	java/lang/Throwable
    //   530	585	347	java/lang/Throwable
    //   590	623	347	java/lang/Throwable
    //   623	629	347	java/lang/Throwable
    //   629	698	347	java/lang/Throwable
    //   698	704	347	java/lang/Throwable
    //   704	718	347	java/lang/Throwable
    //   718	724	347	java/lang/Throwable
    //   724	739	347	java/lang/Throwable
    //   742	756	347	java/lang/Throwable
    //   297	304	764	java/lang/InterruptedException
  }
  
  protected void a(Integer paramInteger)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a(paramInteger.intValue(), this.o);
    AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene, null);
  }
  
  protected void a(Integer... paramVarArgs)
  {
    int i1 = paramVarArgs[(paramVarArgs.length - 1)].intValue();
    AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene, i1 >> 16, 0xFFFF & i1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bzq
 * JD-Core Version:    0.7.0.1
 */