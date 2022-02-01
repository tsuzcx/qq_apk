package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import ayjn;
import java.util.ArrayList;
import org.json.JSONArray;

public class FaceLayer$1
  implements Runnable
{
  public FaceLayer$1(ayjn paramayjn, ArrayList paramArrayList, JSONArray paramJSONArray, boolean paramBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 20	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:Gn	Ljava/util/ArrayList;
    //   7: invokevirtual 41	java/util/ArrayList:size	()I
    //   10: if_icmpge +945 -> 955
    //   13: aload_0
    //   14: getfield 20	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:Gn	Ljava/util/ArrayList;
    //   17: iload_1
    //   18: invokevirtual 45	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   21: checkcast 47	dov/com/qq/im/capture/paster/PasterParcelData
    //   24: astore 10
    //   26: aload 10
    //   28: getfield 51	dov/com/qq/im/capture/paster/PasterParcelData:path	Ljava/lang/String;
    //   31: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   34: ifeq +10 -> 44
    //   37: iload_1
    //   38: iconst_1
    //   39: iadd
    //   40: istore_1
    //   41: goto -39 -> 2
    //   44: aload 10
    //   46: getfield 61	dov/com/qq/im/capture/paster/PasterParcelData:eGY	I
    //   49: iconst_1
    //   50: if_icmpne +296 -> 346
    //   53: getstatic 67	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   56: invokevirtual 71	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   59: aload 10
    //   61: getfield 51	dov/com/qq/im/capture/paster/PasterParcelData:path	Ljava/lang/String;
    //   64: ldc 73
    //   66: getstatic 79	aoop:TRANSPARENT	Landroid/graphics/drawable/Drawable;
    //   69: iconst_1
    //   70: newarray int
    //   72: dup
    //   73: iconst_0
    //   74: bipush 13
    //   76: iastore
    //   77: ldc 73
    //   79: aconst_null
    //   80: invokestatic 85	aqqx:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;[ILjava/lang/String;Landroid/os/Bundle;)Lcom/tencent/image/URLDrawable;
    //   83: astore 7
    //   85: aload 7
    //   87: ifnull +907 -> 994
    //   90: aload 7
    //   92: invokevirtual 90	com/tencent/image/URLDrawable:getStatus	()I
    //   95: iconst_1
    //   96: if_icmpeq +8 -> 104
    //   99: aload 7
    //   101: invokevirtual 93	com/tencent/image/URLDrawable:restartDownload	()V
    //   104: aload 7
    //   106: aload_0
    //   107: getfield 18	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:this$0	Layjn;
    //   110: invokestatic 98	ayjn:a	(Layjn;)Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   113: invokevirtual 104	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   116: aload 7
    //   118: ifnull -81 -> 37
    //   121: aload 10
    //   123: getfield 108	dov/com/qq/im/capture/paster/PasterParcelData:X	Landroid/graphics/RectF;
    //   126: getfield 114	android/graphics/RectF:left	F
    //   129: f2i
    //   130: istore_2
    //   131: aload 10
    //   133: getfield 108	dov/com/qq/im/capture/paster/PasterParcelData:X	Landroid/graphics/RectF;
    //   136: getfield 117	android/graphics/RectF:right	F
    //   139: f2i
    //   140: istore_3
    //   141: aload 7
    //   143: iload_2
    //   144: aload 10
    //   146: getfield 108	dov/com/qq/im/capture/paster/PasterParcelData:X	Landroid/graphics/RectF;
    //   149: getfield 120	android/graphics/RectF:top	F
    //   152: f2i
    //   153: iload_3
    //   154: aload 10
    //   156: getfield 108	dov/com/qq/im/capture/paster/PasterParcelData:X	Landroid/graphics/RectF;
    //   159: getfield 123	android/graphics/RectF:bottom	F
    //   162: f2i
    //   163: invokevirtual 127	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   166: aload 10
    //   168: getfield 130	dov/com/qq/im/capture/paster/PasterParcelData:text	Ljava/lang/String;
    //   171: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   174: ifeq +387 -> 561
    //   177: getstatic 133	ayjn:TAG	Ljava/lang/String;
    //   180: ldc 135
    //   182: invokestatic 141	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: new 143	ayjn$d
    //   188: dup
    //   189: aload 10
    //   191: getfield 147	dov/com/qq/im/capture/paster/PasterParcelData:centerP	Landroid/graphics/PointF;
    //   194: getfield 152	android/graphics/PointF:x	F
    //   197: aload 10
    //   199: getfield 147	dov/com/qq/im/capture/paster/PasterParcelData:centerP	Landroid/graphics/PointF;
    //   202: getfield 155	android/graphics/PointF:y	F
    //   205: aload 10
    //   207: getfield 158	dov/com/qq/im/capture/paster/PasterParcelData:scaleValue	F
    //   210: aload 10
    //   212: getfield 161	dov/com/qq/im/capture/paster/PasterParcelData:nI	F
    //   215: aload 10
    //   217: getfield 164	dov/com/qq/im/capture/paster/PasterParcelData:translateXValue	F
    //   220: aload 10
    //   222: getfield 167	dov/com/qq/im/capture/paster/PasterParcelData:translateYValue	F
    //   225: aload 10
    //   227: getfield 170	dov/com/qq/im/capture/paster/PasterParcelData:width	F
    //   230: f2i
    //   231: aload 10
    //   233: getfield 173	dov/com/qq/im/capture/paster/PasterParcelData:height	F
    //   236: f2i
    //   237: invokespecial 176	ayjn$d:<init>	(FFFFFFII)V
    //   240: astore 8
    //   242: new 178	ayjn$b
    //   245: dup
    //   246: aload_0
    //   247: getfield 18	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:this$0	Layjn;
    //   250: aload 7
    //   252: aload 8
    //   254: aload 10
    //   256: getfield 181	dov/com/qq/im/capture/paster/PasterParcelData:category	Ljava/lang/String;
    //   259: aload 10
    //   261: getfield 184	dov/com/qq/im/capture/paster/PasterParcelData:name	Ljava/lang/String;
    //   264: aload 10
    //   266: getfield 51	dov/com/qq/im/capture/paster/PasterParcelData:path	Ljava/lang/String;
    //   269: aload 10
    //   271: getfield 61	dov/com/qq/im/capture/paster/PasterParcelData:eGY	I
    //   274: invokespecial 187	ayjn$b:<init>	(Layjn;Landroid/graphics/drawable/Drawable;Layjn$d;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   277: astore 7
    //   279: aload 7
    //   281: getfield 191	ayjn$b:mSegmentKeeper	Lcom/tencent/mobileqq/richmedia/capture/data/SegmentKeeper;
    //   284: aload 10
    //   286: getfield 192	dov/com/qq/im/capture/paster/PasterParcelData:mSegmentKeeper	Lcom/tencent/mobileqq/richmedia/capture/data/SegmentKeeper;
    //   289: invokevirtual 198	com/tencent/mobileqq/richmedia/capture/data/SegmentKeeper:set	(Lcom/tencent/mobileqq/richmedia/capture/data/SegmentKeeper;)V
    //   292: aload 7
    //   294: iconst_0
    //   295: putfield 201	ayjn$b:aVB	I
    //   298: aload 7
    //   300: iconst_1
    //   301: putfield 204	ayjn$b:uj	I
    //   304: aload_0
    //   305: getfield 22	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:val$jsonArray	Lorg/json/JSONArray;
    //   308: ifnonnull +409 -> 717
    //   311: aload_0
    //   312: getfield 24	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:dzA	Z
    //   315: ifne +396 -> 711
    //   318: iconst_1
    //   319: istore 4
    //   321: aload 7
    //   323: iload 4
    //   325: invokevirtual 208	ayjn$b:Zx	(Z)V
    //   328: aload_0
    //   329: getfield 18	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:this$0	Layjn;
    //   332: getfield 212	ayjn:oJ	Ljava/util/List;
    //   335: aload 7
    //   337: invokeinterface 218 2 0
    //   342: pop
    //   343: goto -306 -> 37
    //   346: aconst_null
    //   347: astore 8
    //   349: aconst_null
    //   350: astore 9
    //   352: new 220	java/io/BufferedInputStream
    //   355: dup
    //   356: new 222	java/io/FileInputStream
    //   359: dup
    //   360: aload 10
    //   362: getfield 51	dov/com/qq/im/capture/paster/PasterParcelData:path	Ljava/lang/String;
    //   365: invokespecial 225	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   368: invokespecial 228	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   371: astore 7
    //   373: aload 7
    //   375: astore 8
    //   377: new 230	android/graphics/drawable/BitmapDrawable
    //   380: dup
    //   381: aconst_null
    //   382: aload 7
    //   384: aconst_null
    //   385: aconst_null
    //   386: invokestatic 236	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   389: invokespecial 239	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   392: astore 9
    //   394: aload 7
    //   396: ifnull +591 -> 987
    //   399: aload 7
    //   401: invokevirtual 242	java/io/BufferedInputStream:close	()V
    //   404: aload 9
    //   406: astore 7
    //   408: goto -292 -> 116
    //   411: astore 7
    //   413: aload 7
    //   415: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   418: goto -14 -> 404
    //   421: astore 7
    //   423: aload 7
    //   425: athrow
    //   426: astore 9
    //   428: aconst_null
    //   429: astore 7
    //   431: aload 7
    //   433: astore 8
    //   435: getstatic 133	ayjn:TAG	Ljava/lang/String;
    //   438: ldc 247
    //   440: aload 9
    //   442: invokestatic 251	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   445: aload 7
    //   447: ifnull +534 -> 981
    //   450: aload 7
    //   452: invokevirtual 242	java/io/BufferedInputStream:close	()V
    //   455: aconst_null
    //   456: astore 7
    //   458: goto -342 -> 116
    //   461: astore 7
    //   463: aload 7
    //   465: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   468: goto -13 -> 455
    //   471: astore 7
    //   473: aload 7
    //   475: athrow
    //   476: astore 8
    //   478: aload 9
    //   480: astore 7
    //   482: aload 8
    //   484: astore 9
    //   486: aload 7
    //   488: astore 8
    //   490: getstatic 133	ayjn:TAG	Ljava/lang/String;
    //   493: ldc 247
    //   495: aload 9
    //   497: invokestatic 251	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   500: aload 7
    //   502: ifnull +479 -> 981
    //   505: aload 7
    //   507: invokevirtual 242	java/io/BufferedInputStream:close	()V
    //   510: aconst_null
    //   511: astore 7
    //   513: goto -397 -> 116
    //   516: astore 7
    //   518: aload 7
    //   520: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   523: goto -13 -> 510
    //   526: astore 7
    //   528: aload 7
    //   530: athrow
    //   531: astore 7
    //   533: aload 8
    //   535: ifnull +8 -> 543
    //   538: aload 8
    //   540: invokevirtual 242	java/io/BufferedInputStream:close	()V
    //   543: aload 7
    //   545: athrow
    //   546: astore 8
    //   548: aload 8
    //   550: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   553: goto -10 -> 543
    //   556: astore 7
    //   558: aload 7
    //   560: athrow
    //   561: getstatic 133	ayjn:TAG	Ljava/lang/String;
    //   564: new 253	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   571: ldc_w 256
    //   574: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload 10
    //   579: getfield 130	dov/com/qq/im/capture/paster/PasterParcelData:text	Ljava/lang/String;
    //   582: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokestatic 141	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   591: new 143	ayjn$d
    //   594: dup
    //   595: aload 10
    //   597: getfield 147	dov/com/qq/im/capture/paster/PasterParcelData:centerP	Landroid/graphics/PointF;
    //   600: getfield 152	android/graphics/PointF:x	F
    //   603: aload 10
    //   605: getfield 147	dov/com/qq/im/capture/paster/PasterParcelData:centerP	Landroid/graphics/PointF;
    //   608: getfield 155	android/graphics/PointF:y	F
    //   611: aload 10
    //   613: getfield 158	dov/com/qq/im/capture/paster/PasterParcelData:scaleValue	F
    //   616: aload 10
    //   618: getfield 161	dov/com/qq/im/capture/paster/PasterParcelData:nI	F
    //   621: aload 10
    //   623: getfield 164	dov/com/qq/im/capture/paster/PasterParcelData:translateXValue	F
    //   626: aload 10
    //   628: getfield 167	dov/com/qq/im/capture/paster/PasterParcelData:translateYValue	F
    //   631: aload 10
    //   633: getfield 170	dov/com/qq/im/capture/paster/PasterParcelData:width	F
    //   636: f2i
    //   637: aload 10
    //   639: getfield 173	dov/com/qq/im/capture/paster/PasterParcelData:height	F
    //   642: f2i
    //   643: aload 10
    //   645: getfield 130	dov/com/qq/im/capture/paster/PasterParcelData:text	Ljava/lang/String;
    //   648: aload 10
    //   650: getfield 267	dov/com/qq/im/capture/paster/PasterParcelData:textColor	I
    //   653: aload 10
    //   655: getfield 270	dov/com/qq/im/capture/paster/PasterParcelData:textSize	I
    //   658: invokespecial 273	ayjn$d:<init>	(FFFFFFIILjava/lang/String;II)V
    //   661: astore 8
    //   663: new 275	ayjn$a
    //   666: dup
    //   667: aload_0
    //   668: getfield 18	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:this$0	Layjn;
    //   671: aload 7
    //   673: aload 8
    //   675: aload 10
    //   677: getfield 181	dov/com/qq/im/capture/paster/PasterParcelData:category	Ljava/lang/String;
    //   680: aload 10
    //   682: getfield 184	dov/com/qq/im/capture/paster/PasterParcelData:name	Ljava/lang/String;
    //   685: aload 10
    //   687: getfield 51	dov/com/qq/im/capture/paster/PasterParcelData:path	Ljava/lang/String;
    //   690: aload 10
    //   692: getfield 61	dov/com/qq/im/capture/paster/PasterParcelData:eGY	I
    //   695: invokespecial 276	ayjn$a:<init>	(Layjn;Landroid/graphics/drawable/Drawable;Layjn$d;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   698: astore 7
    //   700: aload 7
    //   702: checkcast 275	ayjn$a
    //   705: invokevirtual 279	ayjn$a:btN	()V
    //   708: goto -429 -> 279
    //   711: iconst_0
    //   712: istore 4
    //   714: goto -393 -> 321
    //   717: aload_0
    //   718: getfield 22	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:val$jsonArray	Lorg/json/JSONArray;
    //   721: iload_1
    //   722: invokevirtual 285	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   725: astore 8
    //   727: aload 7
    //   729: aload 8
    //   731: ldc_w 287
    //   734: invokevirtual 293	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   737: invokevirtual 208	ayjn$b:Zx	(Z)V
    //   740: aload 8
    //   742: ldc_w 295
    //   745: invokevirtual 298	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   748: ifeq -420 -> 328
    //   751: aload 7
    //   753: aload 8
    //   755: ldc_w 295
    //   758: invokevirtual 301	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   761: putfield 303	ayjn$b:isAnchor	Z
    //   764: aload 7
    //   766: aload 8
    //   768: ldc_w 305
    //   771: invokevirtual 301	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   774: putfield 308	ayjn$b:dzH	Z
    //   777: aload 7
    //   779: aload 8
    //   781: ldc_w 310
    //   784: invokevirtual 314	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   787: d2f
    //   788: putfield 317	ayjn$b:FH	F
    //   791: aload 7
    //   793: aload 8
    //   795: ldc_w 319
    //   798: invokevirtual 314	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   801: d2f
    //   802: putfield 322	ayjn$b:FI	F
    //   805: aload 7
    //   807: aload 8
    //   809: ldc_w 324
    //   812: invokevirtual 314	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   815: d2f
    //   816: putfield 327	ayjn$b:FJ	F
    //   819: aload 7
    //   821: aload 8
    //   823: ldc_w 329
    //   826: invokevirtual 314	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   829: d2f
    //   830: putfield 332	ayjn$b:FK	F
    //   833: aload 7
    //   835: aload 8
    //   837: ldc_w 305
    //   840: invokevirtual 301	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   843: putfield 308	ayjn$b:dzH	Z
    //   846: aload 7
    //   848: aload 8
    //   850: ldc_w 310
    //   853: invokevirtual 314	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   856: d2f
    //   857: putfield 317	ayjn$b:FH	F
    //   860: aload 7
    //   862: aload 8
    //   864: ldc_w 334
    //   867: invokevirtual 338	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   870: putfield 341	ayjn$b:eKr	I
    //   873: aload 8
    //   875: ldc_w 343
    //   878: invokevirtual 347	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   881: astore 8
    //   883: lconst_0
    //   884: lstore 5
    //   886: iconst_0
    //   887: istore_2
    //   888: iload_2
    //   889: aload 8
    //   891: invokevirtual 350	org/json/JSONArray:length	()I
    //   894: if_icmpge -566 -> 328
    //   897: iload_2
    //   898: iconst_2
    //   899: irem
    //   900: ifne +14 -> 914
    //   903: aload 8
    //   905: iload_2
    //   906: invokevirtual 354	org/json/JSONArray:getLong	(I)J
    //   909: lstore 5
    //   911: goto +89 -> 1000
    //   914: new 356	com/tencent/mobileqq/richmedia/capture/data/TrackerStickerParam$MotionInfo
    //   917: dup
    //   918: aload 8
    //   920: iload_2
    //   921: invokevirtual 285	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   924: invokespecial 359	com/tencent/mobileqq/richmedia/capture/data/TrackerStickerParam$MotionInfo:<init>	(Lorg/json/JSONObject;)V
    //   927: astore 9
    //   929: aload 7
    //   931: getfield 363	ayjn$b:qU	Ljava/util/Map;
    //   934: lload 5
    //   936: invokestatic 369	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   939: aload 9
    //   941: invokeinterface 375 3 0
    //   946: pop
    //   947: goto +53 -> 1000
    //   950: astore 8
    //   952: goto -624 -> 328
    //   955: aload_0
    //   956: getfield 18	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:this$0	Layjn;
    //   959: invokestatic 378	ayjn:b	(Layjn;)Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   962: invokevirtual 383	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:postInvalidate	()V
    //   965: return
    //   966: astore 7
    //   968: goto -435 -> 533
    //   971: astore 9
    //   973: goto -487 -> 486
    //   976: astore 9
    //   978: goto -547 -> 431
    //   981: aconst_null
    //   982: astore 7
    //   984: goto -868 -> 116
    //   987: aload 9
    //   989: astore 7
    //   991: goto -875 -> 116
    //   994: aconst_null
    //   995: astore 7
    //   997: goto -881 -> 116
    //   1000: iload_2
    //   1001: iconst_1
    //   1002: iadd
    //   1003: istore_2
    //   1004: goto -116 -> 888
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1007	0	this	1
    //   1	721	1	i	int
    //   130	874	2	j	int
    //   140	14	3	k	int
    //   319	394	4	bool	boolean
    //   884	51	5	l	long
    //   83	324	7	localObject1	Object
    //   411	3	7	localIOException1	java.io.IOException
    //   421	3	7	localObject2	Object
    //   429	28	7	localObject3	Object
    //   461	3	7	localIOException2	java.io.IOException
    //   471	3	7	localObject4	Object
    //   480	32	7	localObject5	Object
    //   516	3	7	localIOException3	java.io.IOException
    //   526	3	7	localObject6	Object
    //   531	13	7	localObject7	Object
    //   556	116	7	localDrawable	android.graphics.drawable.Drawable
    //   698	232	7	locala	ayjn.a
    //   966	1	7	localObject8	Object
    //   982	14	7	localObject9	Object
    //   240	194	8	localObject10	Object
    //   476	7	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   488	51	8	localObject11	Object
    //   546	3	8	localIOException4	java.io.IOException
    //   661	258	8	localObject12	Object
    //   950	1	8	localException	java.lang.Exception
    //   350	55	9	localBitmapDrawable	android.graphics.drawable.BitmapDrawable
    //   426	53	9	localIOException5	java.io.IOException
    //   484	456	9	localObject13	Object
    //   971	1	9	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   976	12	9	localIOException6	java.io.IOException
    //   24	667	10	localPasterParcelData	dov.com.qq.im.capture.paster.PasterParcelData
    // Exception table:
    //   from	to	target	type
    //   399	404	411	java/io/IOException
    //   399	404	421	finally
    //   413	418	421	finally
    //   352	373	426	java/io/IOException
    //   450	455	461	java/io/IOException
    //   450	455	471	finally
    //   463	468	471	finally
    //   352	373	476	java/lang/OutOfMemoryError
    //   505	510	516	java/io/IOException
    //   505	510	526	finally
    //   518	523	526	finally
    //   352	373	531	finally
    //   490	500	531	finally
    //   538	543	546	java/io/IOException
    //   538	543	556	finally
    //   548	553	556	finally
    //   717	883	950	java/lang/Exception
    //   888	897	950	java/lang/Exception
    //   903	911	950	java/lang/Exception
    //   914	947	950	java/lang/Exception
    //   377	394	966	finally
    //   435	445	966	finally
    //   377	394	971	java/lang/OutOfMemoryError
    //   377	394	976	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.1
 * JD-Core Version:    0.7.0.1
 */