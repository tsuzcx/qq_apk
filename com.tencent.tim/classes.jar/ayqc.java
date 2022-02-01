import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ayqc
  extends ayqr<ayqb, ayqb>
  implements ppe
{
  public final String aAV;
  public final int bqF;
  public final WeakReference<aydg> dh;
  public final WeakReference<aydh> di;
  
  public ayqc(aydg paramaydg)
  {
    this(paramaydg, null, 0);
  }
  
  public ayqc(aydg paramaydg, aydh paramaydh, int paramInt)
  {
    this(paramaydg, paramaydh, null, paramInt);
  }
  
  public ayqc(aydg paramaydg, aydh paramaydh, String paramString, int paramInt)
  {
    if (paramaydg == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.dh = new WeakReference(paramaydg);
    this.di = new WeakReference(paramaydh);
    this.aAV = paramString;
    this.bqF = paramInt;
  }
  
  public static Bitmap c(Bitmap paramBitmap, int paramInt)
  {
    if ((paramInt + 90) % 180 == 0) {
      try
      {
        ram.w("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation begin!");
        long l = System.currentTimeMillis();
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        Matrix localMatrix = new Matrix();
        localMatrix.reset();
        localMatrix.postRotate(paramInt);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
        ram.w("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation end, cost:" + (System.currentTimeMillis() - l) / 1000.0D);
        return paramBitmap;
      }
      catch (Exception paramBitmap)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 2, "rotate exception:" + paramBitmap);
        }
        return null;
      }
    }
    return null;
  }
  
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, ayqb paramayqb)
  {
    // Byte code:
    //   0: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 7
    //   5: aload_2
    //   6: getfield 142	ayqb:aAT	Ljava/lang/String;
    //   9: astore_1
    //   10: aload_1
    //   11: invokestatic 148	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +31 -> 45
    //   17: aload_0
    //   18: new 150	com/tencent/biz/qqstory/base/ErrorMessage
    //   21: dup
    //   22: iconst_m1
    //   23: ldc 152
    //   25: invokespecial 155	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   28: invokespecial 159	ayqr:notifyError	(Ljava/lang/Error;)V
    //   31: ldc 161
    //   33: ldc 163
    //   35: iconst_0
    //   36: iconst_m1
    //   37: iconst_0
    //   38: anewarray 165	java/lang/String
    //   41: invokestatic 171	rar:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   44: return
    //   45: aload_0
    //   46: getfield 42	ayqc:dh	Ljava/lang/ref/WeakReference;
    //   49: invokevirtual 175	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   52: checkcast 177	aydg
    //   55: astore 14
    //   57: aload_0
    //   58: getfield 44	ayqc:di	Ljava/lang/ref/WeakReference;
    //   61: invokevirtual 175	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   64: checkcast 179	aydh
    //   67: astore 15
    //   69: aload 14
    //   71: ifnull +841 -> 912
    //   74: aload 14
    //   76: aload_0
    //   77: getfield 48	ayqc:bqF	I
    //   80: invokeinterface 183 2 0
    //   85: ifeq +22 -> 107
    //   88: aload 15
    //   90: ifnull +822 -> 912
    //   93: aload 15
    //   95: aload_0
    //   96: getfield 48	ayqc:bqF	I
    //   99: invokeinterface 186 2 0
    //   104: ifeq +808 -> 912
    //   107: aload 14
    //   109: invokeinterface 189 1 0
    //   114: aload_0
    //   115: getfield 48	ayqc:bqF	I
    //   118: invokevirtual 195	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:h	(I)Landroid/graphics/Bitmap;
    //   121: astore 12
    //   123: aload 12
    //   125: ifnull +44 -> 169
    //   128: aload_2
    //   129: getfield 198	ayqb:businessId	I
    //   132: aload_2
    //   133: getfield 201	ayqb:aAU	Ljava/lang/String;
    //   136: ldc 203
    //   138: invokestatic 209	ayqu:f	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   141: astore 13
    //   143: aload 12
    //   145: aload 13
    //   147: aconst_null
    //   148: invokestatic 214	rop:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Lrop$a;)V
    //   151: aload_2
    //   152: getfield 218	ayqb:g	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   155: aload 13
    //   157: putfield 223	com/tencent/biz/qqstory/database/PublishVideoEntry:mosaicPath	Ljava/lang/String;
    //   160: ldc 54
    //   162: ldc 225
    //   164: aload 13
    //   166: invokestatic 228	ram:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   169: new 230	android/graphics/BitmapFactory$Options
    //   172: dup
    //   173: invokespecial 231	android/graphics/BitmapFactory$Options:<init>	()V
    //   176: astore 16
    //   178: aload 16
    //   180: iconst_1
    //   181: putfield 235	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   184: aload_1
    //   185: aload 16
    //   187: invokestatic 241	aqhu:d	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   190: pop
    //   191: aload 16
    //   193: getfield 244	android/graphics/BitmapFactory$Options:outWidth	I
    //   196: istore 5
    //   198: aload 16
    //   200: getfield 247	android/graphics/BitmapFactory$Options:outHeight	I
    //   203: istore 6
    //   205: aload 14
    //   207: invokeinterface 189 1 0
    //   212: invokevirtual 250	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:a	()Layjl;
    //   215: astore_1
    //   216: aload_1
    //   217: ifnull +29 -> 246
    //   220: aload_1
    //   221: iload 5
    //   223: iload 6
    //   225: iconst_1
    //   226: invokevirtual 255	ayjl:b	(IIZ)Ljava/lang/String;
    //   229: astore_1
    //   230: aload_1
    //   231: ifnull +15 -> 246
    //   234: aload_2
    //   235: getfield 218	ayqb:g	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   238: ldc_w 257
    //   241: aload_1
    //   242: invokevirtual 261	com/tencent/biz/qqstory/database/PublishVideoEntry:putExtra	(Ljava/lang/String;Ljava/lang/Object;)Z
    //   245: pop
    //   246: aload 14
    //   248: invokeinterface 189 1 0
    //   253: astore_1
    //   254: aload_1
    //   255: ifnull +28 -> 283
    //   258: aload_1
    //   259: aload_2
    //   260: getfield 201	ayqb:aAU	Ljava/lang/String;
    //   263: invokevirtual 265	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:sQ	(Ljava/lang/String;)Ljava/lang/String;
    //   266: astore_1
    //   267: aload_1
    //   268: ifnull +15 -> 283
    //   271: aload_2
    //   272: getfield 218	ayqb:g	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   275: ldc_w 267
    //   278: aload_1
    //   279: invokevirtual 261	com/tencent/biz/qqstory/database/PublishVideoEntry:putExtra	(Ljava/lang/String;Ljava/lang/Object;)Z
    //   282: pop
    //   283: aload 14
    //   285: aload_0
    //   286: getfield 48	ayqc:bqF	I
    //   289: iconst_0
    //   290: invokeinterface 270 3 0
    //   295: astore 13
    //   297: aload_0
    //   298: getfield 46	ayqc:aAV	Ljava/lang/String;
    //   301: astore 12
    //   303: aload 12
    //   305: astore_1
    //   306: aload 12
    //   308: ifnonnull +18 -> 326
    //   311: aload_2
    //   312: getfield 198	ayqb:businessId	I
    //   315: aload_2
    //   316: getfield 201	ayqb:aAU	Ljava/lang/String;
    //   319: ldc_w 272
    //   322: invokestatic 209	ayqu:f	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   325: astore_1
    //   326: aload 13
    //   328: ifnull +538 -> 866
    //   331: aload 15
    //   333: ifnull +48 -> 381
    //   336: aload 15
    //   338: aload_0
    //   339: getfield 48	ayqc:bqF	I
    //   342: invokeinterface 186 2 0
    //   347: ifeq +34 -> 381
    //   350: aload 15
    //   352: aload_0
    //   353: getfield 48	ayqc:bqF	I
    //   356: new 274	android/graphics/Canvas
    //   359: dup
    //   360: aload 13
    //   362: invokespecial 277	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   365: aload 13
    //   367: invokevirtual 74	android/graphics/Bitmap:getWidth	()I
    //   370: aload 13
    //   372: invokevirtual 77	android/graphics/Bitmap:getHeight	()I
    //   375: invokeinterface 280 5 0
    //   380: pop
    //   381: iload 6
    //   383: istore 4
    //   385: iload 5
    //   387: istore_3
    //   388: aload_2
    //   389: getfield 283	ayqb:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   392: instanceof 285
    //   395: ifeq +37 -> 432
    //   398: iload 6
    //   400: istore 4
    //   402: iload 5
    //   404: istore_3
    //   405: aload_2
    //   406: getfield 218	ayqb:g	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   409: ldc_w 287
    //   412: iconst_0
    //   413: invokevirtual 291	com/tencent/biz/qqstory/database/PublishVideoEntry:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   416: ifeq +16 -> 432
    //   419: aload 16
    //   421: getfield 247	android/graphics/BitmapFactory$Options:outHeight	I
    //   424: istore_3
    //   425: aload 16
    //   427: getfield 244	android/graphics/BitmapFactory$Options:outWidth	I
    //   430: istore 4
    //   432: aload_2
    //   433: getfield 294	ayqb:jdField_a_of_type_Ayqj	Layqj;
    //   436: getfield 299	ayqj:mOrientation	I
    //   439: istore 5
    //   441: aload_2
    //   442: getfield 198	ayqb:businessId	I
    //   445: istore 6
    //   447: iload 6
    //   449: iconst_2
    //   450: if_icmpeq +36 -> 486
    //   453: iload 6
    //   455: iconst_3
    //   456: if_icmpeq +30 -> 486
    //   459: iload 6
    //   461: iconst_5
    //   462: if_icmpeq +24 -> 486
    //   465: iload 6
    //   467: bipush 101
    //   469: if_icmpeq +17 -> 486
    //   472: iload 6
    //   474: bipush 6
    //   476: if_icmpeq +10 -> 486
    //   479: iload 6
    //   481: bipush 102
    //   483: if_icmpne +457 -> 940
    //   486: aload_2
    //   487: getfield 283	ayqb:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   490: instanceof 285
    //   493: ifeq +31 -> 524
    //   496: iconst_0
    //   497: istore 5
    //   499: ldc 54
    //   501: new 93	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   508: ldc_w 301
    //   511: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: iconst_0
    //   515: invokevirtual 304	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   518: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 62	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   524: aload 13
    //   526: iload 5
    //   528: invokestatic 306	ayqc:c	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   531: astore 12
    //   533: aload 12
    //   535: ifnull +405 -> 940
    //   538: aload 12
    //   540: iload_3
    //   541: iload 4
    //   543: iconst_1
    //   544: iconst_0
    //   545: invokestatic 309	rop:c	(Landroid/graphics/Bitmap;IIZZ)Landroid/graphics/Bitmap;
    //   548: astore 12
    //   550: aload 12
    //   552: ifnull +382 -> 934
    //   555: aload_2
    //   556: getfield 198	ayqb:businessId	I
    //   559: iconst_1
    //   560: if_icmpne +232 -> 792
    //   563: aload_2
    //   564: getfield 198	ayqb:businessId	I
    //   567: aload_2
    //   568: getfield 201	ayqb:aAU	Ljava/lang/String;
    //   571: ldc_w 272
    //   574: invokestatic 209	ayqu:f	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   577: astore 15
    //   579: aload 12
    //   581: aload 15
    //   583: aconst_null
    //   584: invokestatic 214	rop:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Lrop$a;)V
    //   587: aload_2
    //   588: getfield 218	ayqb:g	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   591: aload 15
    //   593: putfield 312	com/tencent/biz/qqstory/database/PublishVideoEntry:doodleRawPath	Ljava/lang/String;
    //   596: iconst_1
    //   597: istore 11
    //   599: aconst_null
    //   600: astore_1
    //   601: aload 14
    //   603: aload 13
    //   605: invokeinterface 315 2 0
    //   610: aload 12
    //   612: aload 13
    //   614: if_acmpeq +8 -> 622
    //   617: aload 12
    //   619: invokestatic 317	rop:f	(Landroid/graphics/Bitmap;)V
    //   622: aload 12
    //   624: ifnull +196 -> 820
    //   627: iload 11
    //   629: ifeq +191 -> 820
    //   632: ldc 54
    //   634: ldc_w 319
    //   637: invokestatic 321	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   640: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   643: lstore 9
    //   645: ldc 161
    //   647: ldc_w 323
    //   650: iconst_0
    //   651: iconst_0
    //   652: iconst_1
    //   653: anewarray 165	java/lang/String
    //   656: dup
    //   657: iconst_0
    //   658: new 93	java/lang/StringBuilder
    //   661: dup
    //   662: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   665: ldc_w 325
    //   668: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: lload 9
    //   673: lload 7
    //   675: lsub
    //   676: invokevirtual 328	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   679: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: aastore
    //   683: invokestatic 171	rar:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   686: ldc 161
    //   688: ldc 163
    //   690: iconst_0
    //   691: iconst_0
    //   692: iconst_0
    //   693: anewarray 165	java/lang/String
    //   696: invokestatic 171	rar:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   699: aload_2
    //   700: getfield 218	ayqb:g	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   703: aload_1
    //   704: putfield 331	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   707: aload_0
    //   708: aload_2
    //   709: invokespecial 334	ayqr:notifyResult	(Ljava/lang/Object;)V
    //   712: return
    //   713: astore_1
    //   714: ldc 54
    //   716: ldc_w 336
    //   719: aload_1
    //   720: invokestatic 340	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   723: aload_0
    //   724: new 150	com/tencent/biz/qqstory/base/ErrorMessage
    //   727: dup
    //   728: iconst_m1
    //   729: ldc 152
    //   731: invokespecial 155	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   734: invokespecial 159	ayqr:notifyError	(Ljava/lang/Error;)V
    //   737: return
    //   738: astore_1
    //   739: ldc 54
    //   741: ldc_w 342
    //   744: aload_1
    //   745: invokestatic 344	ram:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   748: aload_0
    //   749: new 346	com/tencent/biz/qqstory/base/BitmapError
    //   752: dup
    //   753: ldc 54
    //   755: bipush 6
    //   757: invokespecial 349	com/tencent/biz/qqstory/base/BitmapError:<init>	(Ljava/lang/String;I)V
    //   760: invokespecial 159	ayqr:notifyError	(Ljava/lang/Error;)V
    //   763: return
    //   764: astore 15
    //   766: ldc 54
    //   768: ldc_w 336
    //   771: aload 15
    //   773: invokestatic 340	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   776: aload 12
    //   778: getstatic 355	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   781: bipush 60
    //   783: aload_1
    //   784: invokestatic 358	rop:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   787: istore 11
    //   789: goto -188 -> 601
    //   792: aload 12
    //   794: getstatic 355	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   797: bipush 60
    //   799: aload_1
    //   800: invokestatic 358	rop:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   803: istore 11
    //   805: goto -204 -> 601
    //   808: astore_1
    //   809: aload 14
    //   811: aload 13
    //   813: invokeinterface 315 2 0
    //   818: aload_1
    //   819: athrow
    //   820: ldc 54
    //   822: ldc_w 360
    //   825: invokestatic 62	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   828: ldc 161
    //   830: ldc 163
    //   832: iconst_0
    //   833: bipush 254
    //   835: iconst_0
    //   836: anewarray 165	java/lang/String
    //   839: invokestatic 171	rar:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   842: aload_2
    //   843: getfield 218	ayqb:g	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   846: aconst_null
    //   847: putfield 331	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   850: aload_0
    //   851: new 150	com/tencent/biz/qqstory/base/ErrorMessage
    //   854: dup
    //   855: iconst_m1
    //   856: ldc_w 362
    //   859: invokespecial 155	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   862: invokespecial 159	ayqr:notifyError	(Ljava/lang/Error;)V
    //   865: return
    //   866: ldc 54
    //   868: ldc_w 364
    //   871: invokestatic 62	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   874: ldc 161
    //   876: ldc 163
    //   878: iconst_0
    //   879: bipush 254
    //   881: iconst_0
    //   882: anewarray 165	java/lang/String
    //   885: invokestatic 171	rar:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   888: aload_2
    //   889: getfield 218	ayqb:g	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   892: aconst_null
    //   893: putfield 331	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   896: aload_0
    //   897: new 150	com/tencent/biz/qqstory/base/ErrorMessage
    //   900: dup
    //   901: iconst_m1
    //   902: ldc_w 366
    //   905: invokespecial 155	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   908: invokespecial 159	ayqr:notifyError	(Ljava/lang/Error;)V
    //   911: return
    //   912: ldc 54
    //   914: ldc_w 368
    //   917: invokestatic 62	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   920: aload_2
    //   921: getfield 218	ayqb:g	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   924: aconst_null
    //   925: putfield 331	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   928: aload_0
    //   929: aload_2
    //   930: invokespecial 334	ayqr:notifyResult	(Ljava/lang/Object;)V
    //   933: return
    //   934: iconst_0
    //   935: istore 11
    //   937: goto -336 -> 601
    //   940: aload 13
    //   942: astore 12
    //   944: goto -406 -> 538
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	947	0	this	ayqc
    //   0	947	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	947	2	paramayqb	ayqb
    //   387	154	3	i	int
    //   383	159	4	j	int
    //   196	331	5	k	int
    //   203	281	6	m	int
    //   3	671	7	l1	long
    //   643	29	9	l2	long
    //   597	339	11	bool	boolean
    //   121	822	12	localObject1	java.lang.Object
    //   141	800	13	localObject2	java.lang.Object
    //   55	755	14	localaydg	aydg
    //   67	525	15	localObject3	java.lang.Object
    //   764	8	15	localThrowable	java.lang.Throwable
    //   176	250	16	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   143	169	713	java/io/IOException
    //   184	191	738	java/lang/OutOfMemoryError
    //   579	596	764	java/lang/Throwable
    //   336	381	808	finally
    //   388	398	808	finally
    //   405	432	808	finally
    //   432	447	808	finally
    //   486	496	808	finally
    //   499	524	808	finally
    //   524	533	808	finally
    //   538	550	808	finally
    //   555	579	808	finally
    //   579	596	808	finally
    //   766	789	808	finally
    //   792	805	808	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayqc
 * JD-Core Version:    0.7.0.1
 */