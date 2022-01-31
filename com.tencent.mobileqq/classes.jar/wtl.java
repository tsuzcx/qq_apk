import com.tencent.mobileqq.activity.photo.MediaScanner;
import java.lang.ref.WeakReference;

public class wtl
  implements Runnable
{
  public wtl(MediaScanner paramMediaScanner, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	wtl:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 33	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: checkcast 35	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   10: astore 6
    //   12: aload_0
    //   13: getfield 18	wtl:b	Ljava/lang/ref/WeakReference;
    //   16: invokevirtual 33	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   19: checkcast 37	com/tencent/mobileqq/activity/photo/MediaScanner$OnMediaInfoScannerListener
    //   22: astore 7
    //   24: aload 6
    //   26: ifnull +8 -> 34
    //   29: aload 7
    //   31: ifnonnull +12 -> 43
    //   34: ldc 39
    //   36: iconst_2
    //   37: ldc 41
    //   39: invokestatic 47	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: return
    //   43: aload 6
    //   45: getfield 51	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   48: ldc 53
    //   50: invokevirtual 59	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +444 -> 497
    //   56: new 61	android/media/MediaMetadataRetriever
    //   59: dup
    //   60: invokespecial 62	android/media/MediaMetadataRetriever:<init>	()V
    //   63: astore 8
    //   65: aload 8
    //   67: aload 6
    //   69: getfield 65	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   72: invokevirtual 69	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   75: aload 8
    //   77: bipush 9
    //   79: invokevirtual 73	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   82: astore 9
    //   84: aload 6
    //   86: aload 9
    //   88: invokestatic 79	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   91: putfield 83	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   94: getstatic 89	android/os/Build$VERSION:SDK_INT	I
    //   97: bipush 17
    //   99: if_icmplt +22 -> 121
    //   102: aload 8
    //   104: bipush 24
    //   106: invokevirtual 73	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   109: astore 9
    //   111: aload 6
    //   113: aload 9
    //   115: invokestatic 95	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   118: putfield 98	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   121: getstatic 89	android/os/Build$VERSION:SDK_INT	I
    //   124: bipush 14
    //   126: if_icmplt +41 -> 167
    //   129: aload 8
    //   131: bipush 18
    //   133: invokevirtual 73	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   136: astore 9
    //   138: aload 8
    //   140: bipush 19
    //   142: invokevirtual 73	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   145: astore 10
    //   147: aload 6
    //   149: aload 9
    //   151: invokestatic 95	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   154: putfield 101	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   157: aload 6
    //   159: aload 10
    //   161: invokestatic 95	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   164: putfield 104	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   167: getstatic 89	android/os/Build$VERSION:SDK_INT	I
    //   170: bipush 15
    //   172: if_icmplt +135 -> 307
    //   175: aload 8
    //   177: bipush 23
    //   179: invokevirtual 73	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   182: astore 8
    //   184: aload 8
    //   186: ifnull +121 -> 307
    //   189: new 106	java/util/ArrayList
    //   192: dup
    //   193: iconst_3
    //   194: invokespecial 109	java/util/ArrayList:<init>	(I)V
    //   197: astore 9
    //   199: new 111	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   206: astore 10
    //   208: aload 8
    //   210: invokevirtual 116	java/lang/String:toCharArray	()[C
    //   213: astore 11
    //   215: aload 11
    //   217: arraylength
    //   218: istore 5
    //   220: iconst_0
    //   221: istore_2
    //   222: iconst_0
    //   223: istore 4
    //   225: goto +594 -> 819
    //   228: iload_2
    //   229: istore_3
    //   230: aload 10
    //   232: invokevirtual 120	java/lang/StringBuilder:length	()I
    //   235: ifle +35 -> 270
    //   238: aload 9
    //   240: aload 10
    //   242: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 130	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   248: ldc2_w 131
    //   251: dmul
    //   252: d2i
    //   253: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: invokevirtual 140	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   259: pop
    //   260: aload 10
    //   262: iconst_0
    //   263: invokevirtual 143	java/lang/StringBuilder:setLength	(I)V
    //   266: iload_2
    //   267: iconst_1
    //   268: iadd
    //   269: istore_3
    //   270: aload 10
    //   272: iload_1
    //   273: invokevirtual 147	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: iload_3
    //   278: istore_2
    //   279: goto +583 -> 862
    //   282: iload_1
    //   283: invokestatic 153	java/lang/Character:isDigit	(C)Z
    //   286: ifne +9 -> 295
    //   289: iload_1
    //   290: bipush 46
    //   292: if_icmpne +95 -> 387
    //   295: aload 10
    //   297: iload_1
    //   298: invokevirtual 147	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: goto +560 -> 862
    //   305: astore 8
    //   307: aload 7
    //   309: aload 6
    //   311: iconst_1
    //   312: invokeinterface 156 3 0
    //   317: invokestatic 162	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   320: invokestatic 167	com/tencent/mobileqq/activity/photo/MediaScanner:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/activity/photo/MediaScanner;
    //   323: invokestatic 170	com/tencent/mobileqq/activity/photo/MediaScanner:a	(Lcom/tencent/mobileqq/activity/photo/MediaScanner;)Lcom/tencent/mobileqq/activity/photo/MediaDatabaseHelper;
    //   326: aload 6
    //   328: getfield 65	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   331: aload 6
    //   333: getfield 83	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   336: invokevirtual 175	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:a	(Ljava/lang/String;J)V
    //   339: return
    //   340: astore 8
    //   342: ldc 39
    //   344: iconst_2
    //   345: new 111	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   352: ldc 177
    //   354: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload 8
    //   359: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   362: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 47	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: aload 7
    //   373: ifnull +445 -> 818
    //   376: aload 7
    //   378: aload 6
    //   380: iconst_0
    //   381: invokeinterface 156 3 0
    //   386: return
    //   387: ldc 39
    //   389: iconst_2
    //   390: new 111	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   397: ldc 185
    //   399: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload 8
    //   404: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: ldc 187
    //   409: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 47	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: goto +444 -> 862
    //   421: aload 10
    //   423: invokevirtual 120	java/lang/StringBuilder:length	()I
    //   426: ifle +25 -> 451
    //   429: aload 9
    //   431: aload 10
    //   433: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokestatic 130	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   439: ldc2_w 131
    //   442: dmul
    //   443: d2i
    //   444: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   447: invokevirtual 140	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   450: pop
    //   451: aload 9
    //   453: invokevirtual 190	java/util/ArrayList:size	()I
    //   456: iconst_2
    //   457: if_icmplt -150 -> 307
    //   460: aload 6
    //   462: aload 9
    //   464: iconst_0
    //   465: invokevirtual 193	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   468: checkcast 91	java/lang/Integer
    //   471: invokevirtual 196	java/lang/Integer:intValue	()I
    //   474: putfield 199	com/tencent/mobileqq/activity/photo/LocalMediaInfo:latitude	I
    //   477: aload 6
    //   479: aload 9
    //   481: iconst_1
    //   482: invokevirtual 193	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   485: checkcast 91	java/lang/Integer
    //   488: invokevirtual 196	java/lang/Integer:intValue	()I
    //   491: putfield 202	com/tencent/mobileqq/activity/photo/LocalMediaInfo:longitude	I
    //   494: goto -187 -> 307
    //   497: new 204	android/media/ExifInterface
    //   500: dup
    //   501: aload 6
    //   503: getfield 65	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   506: invokespecial 206	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   509: astore 11
    //   511: aload 11
    //   513: ldc 208
    //   515: invokevirtual 212	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   518: astore 8
    //   520: aload 11
    //   522: ldc 214
    //   524: invokevirtual 212	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   527: astore 9
    //   529: aload 11
    //   531: ldc 216
    //   533: invokevirtual 212	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   536: astore 10
    //   538: aload 11
    //   540: ldc 218
    //   542: invokevirtual 212	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   545: astore 11
    //   547: aload 8
    //   549: ifnull +58 -> 607
    //   552: aload 9
    //   554: ifnull +53 -> 607
    //   557: aload 10
    //   559: ifnull +48 -> 607
    //   562: aload 11
    //   564: ifnull +43 -> 607
    //   567: aload 9
    //   569: ldc 220
    //   571: invokevirtual 223	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   574: ifeq +199 -> 773
    //   577: aload 6
    //   579: aload 8
    //   581: invokestatic 227	com/tencent/mobileqq/activity/photo/PhotoUtils:a	(Ljava/lang/String;)I
    //   584: putfield 199	com/tencent/mobileqq/activity/photo/LocalMediaInfo:latitude	I
    //   587: aload 11
    //   589: ldc 229
    //   591: invokevirtual 223	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   594: ifeq +194 -> 788
    //   597: aload 6
    //   599: aload 10
    //   601: invokestatic 227	com/tencent/mobileqq/activity/photo/PhotoUtils:a	(Ljava/lang/String;)I
    //   604: putfield 202	com/tencent/mobileqq/activity/photo/LocalMediaInfo:longitude	I
    //   607: aload 6
    //   609: getfield 101	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   612: ifeq +11 -> 623
    //   615: aload 6
    //   617: getfield 104	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   620: ifne +142 -> 762
    //   623: ldc 39
    //   625: iconst_2
    //   626: new 111	java/lang/StringBuilder
    //   629: dup
    //   630: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   633: ldc 231
    //   635: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload 6
    //   640: getfield 65	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   643: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: invokestatic 47	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   652: new 233	android/graphics/BitmapFactory$Options
    //   655: dup
    //   656: invokespecial 234	android/graphics/BitmapFactory$Options:<init>	()V
    //   659: astore 8
    //   661: aload 8
    //   663: iconst_1
    //   664: putfield 238	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   667: aload 6
    //   669: getfield 65	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   672: aload 8
    //   674: invokestatic 244	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   677: pop
    //   678: aload 6
    //   680: aload 8
    //   682: getfield 247	android/graphics/BitmapFactory$Options:outWidth	I
    //   685: putfield 101	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   688: aload 6
    //   690: aload 8
    //   692: getfield 250	android/graphics/BitmapFactory$Options:outHeight	I
    //   695: putfield 104	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   698: aload 8
    //   700: getfield 253	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   703: astore 8
    //   705: ldc 39
    //   707: iconst_2
    //   708: new 111	java/lang/StringBuilder
    //   711: dup
    //   712: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   715: ldc 255
    //   717: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: aload 6
    //   722: getfield 101	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   725: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   728: ldc_w 260
    //   731: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: aload 6
    //   736: getfield 104	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   739: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   742: ldc_w 262
    //   745: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: aload 6
    //   750: getfield 51	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   753: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 47	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   762: aload 7
    //   764: aload 6
    //   766: iconst_1
    //   767: invokeinterface 156 3 0
    //   772: return
    //   773: aload 6
    //   775: iconst_0
    //   776: aload 8
    //   778: invokestatic 227	com/tencent/mobileqq/activity/photo/PhotoUtils:a	(Ljava/lang/String;)I
    //   781: isub
    //   782: putfield 199	com/tencent/mobileqq/activity/photo/LocalMediaInfo:latitude	I
    //   785: goto -198 -> 587
    //   788: aload 6
    //   790: iconst_0
    //   791: aload 10
    //   793: invokestatic 227	com/tencent/mobileqq/activity/photo/PhotoUtils:a	(Ljava/lang/String;)I
    //   796: isub
    //   797: putfield 202	com/tencent/mobileqq/activity/photo/LocalMediaInfo:longitude	I
    //   800: goto -193 -> 607
    //   803: astore 9
    //   805: goto -638 -> 167
    //   808: astore 9
    //   810: goto -689 -> 121
    //   813: astore 9
    //   815: goto -721 -> 94
    //   818: return
    //   819: iload 4
    //   821: iload 5
    //   823: if_icmpge -402 -> 421
    //   826: aload 11
    //   828: iload 4
    //   830: caload
    //   831: istore_1
    //   832: iload_2
    //   833: iconst_2
    //   834: if_icmpge -413 -> 421
    //   837: iload_1
    //   838: bipush 43
    //   840: if_icmpeq -612 -> 228
    //   843: iload_1
    //   844: bipush 45
    //   846: if_icmpeq -618 -> 228
    //   849: iload_1
    //   850: bipush 10
    //   852: if_icmpeq -624 -> 228
    //   855: iload_1
    //   856: ifne -574 -> 282
    //   859: goto -631 -> 228
    //   862: iload 4
    //   864: iconst_1
    //   865: iadd
    //   866: istore 4
    //   868: goto -49 -> 819
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	871	0	this	wtl
    //   272	584	1	c	char
    //   221	614	2	i	int
    //   229	49	3	j	int
    //   223	644	4	k	int
    //   218	606	5	m	int
    //   10	779	6	localLocalMediaInfo	com.tencent.mobileqq.activity.photo.LocalMediaInfo
    //   22	741	7	localOnMediaInfoScannerListener	com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener
    //   63	146	8	localObject1	Object
    //   305	1	8	localNumberFormatException1	java.lang.NumberFormatException
    //   340	63	8	localException	java.lang.Exception
    //   518	259	8	localObject2	Object
    //   82	486	9	localObject3	Object
    //   803	1	9	localNumberFormatException2	java.lang.NumberFormatException
    //   808	1	9	localNumberFormatException3	java.lang.NumberFormatException
    //   813	1	9	localNumberFormatException4	java.lang.NumberFormatException
    //   145	647	10	localObject4	Object
    //   213	614	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   189	220	305	java/lang/NumberFormatException
    //   230	266	305	java/lang/NumberFormatException
    //   270	277	305	java/lang/NumberFormatException
    //   282	289	305	java/lang/NumberFormatException
    //   295	302	305	java/lang/NumberFormatException
    //   387	418	305	java/lang/NumberFormatException
    //   421	451	305	java/lang/NumberFormatException
    //   451	494	305	java/lang/NumberFormatException
    //   34	42	340	java/lang/Exception
    //   43	84	340	java/lang/Exception
    //   84	94	340	java/lang/Exception
    //   94	111	340	java/lang/Exception
    //   111	121	340	java/lang/Exception
    //   121	147	340	java/lang/Exception
    //   147	167	340	java/lang/Exception
    //   167	184	340	java/lang/Exception
    //   189	220	340	java/lang/Exception
    //   230	266	340	java/lang/Exception
    //   270	277	340	java/lang/Exception
    //   282	289	340	java/lang/Exception
    //   295	302	340	java/lang/Exception
    //   307	339	340	java/lang/Exception
    //   387	418	340	java/lang/Exception
    //   421	451	340	java/lang/Exception
    //   451	494	340	java/lang/Exception
    //   497	547	340	java/lang/Exception
    //   567	587	340	java/lang/Exception
    //   587	607	340	java/lang/Exception
    //   607	623	340	java/lang/Exception
    //   623	762	340	java/lang/Exception
    //   762	772	340	java/lang/Exception
    //   773	785	340	java/lang/Exception
    //   788	800	340	java/lang/Exception
    //   147	167	803	java/lang/NumberFormatException
    //   111	121	808	java/lang/NumberFormatException
    //   84	94	813	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wtl
 * JD-Core Version:    0.7.0.1
 */