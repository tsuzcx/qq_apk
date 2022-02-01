import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.lang.ref.WeakReference;

@TargetApi(10)
public class ayqg
  extends ayqr<ayqb, ayqb>
{
  private final String aAX;
  public WeakReference<aydg> dh;
  
  public ayqg()
  {
    this(null);
  }
  
  public ayqg(String paramString)
  {
    this.aAX = paramString;
  }
  
  private Bitmap b(ayqb paramayqb, Bitmap paramBitmap)
  {
    Object localObject = null;
    if (paramBitmap == null) {
      return null;
    }
    ayym localayym = new ayym();
    localayym.init(paramBitmap.getWidth(), paramBitmap.getHeight());
    paramayqb = (ayqb)localObject;
    if (this.dh != null)
    {
      paramayqb = (ayqb)localObject;
      if (this.dh.get() == null) {}
    }
    try
    {
      paramayqb = ((aydg)this.dh.get()).a().h(0);
      localObject = paramBitmap;
      if (paramayqb != null)
      {
        localObject = (ayyq)ayyl.a(106);
        ((ayyq)localObject).ae(paramayqb);
        ((ayyq)localObject).init();
        paramayqb = localayym.a(paramBitmap, (GPUBaseFilter)localObject);
        ram.b("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, mosaicThumbBitmap = %s", paramayqb);
        if (paramayqb != null) {
          paramBitmap = paramayqb;
        }
        ((ayyq)localObject).destroy();
        localObject = paramBitmap;
      }
      localayym.destory();
      return localObject;
    }
    catch (Exception paramayqb)
    {
      for (;;)
      {
        ram.e("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, read mosaic bitmap " + paramayqb.toString());
        paramayqb = (ayqb)localObject;
      }
    }
  }
  
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, ayqb paramayqb)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 4
    //   3: aload_2
    //   4: getfield 122	ayqb:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   7: instanceof 124
    //   10: ifne +13 -> 23
    //   13: aload_2
    //   14: getfield 122	ayqb:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   17: instanceof 126
    //   20: ifeq +471 -> 491
    //   23: aload_0
    //   24: getfield 23	ayqg:aAX	Ljava/lang/String;
    //   27: astore 10
    //   29: aload 10
    //   31: ifnonnull +488 -> 519
    //   34: aload_2
    //   35: getfield 130	ayqb:businessId	I
    //   38: aload_2
    //   39: getfield 133	ayqb:aAU	Ljava/lang/String;
    //   42: ldc 135
    //   44: invokestatic 141	ayqu:f	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 10
    //   49: aload_2
    //   50: getfield 122	ayqb:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   53: instanceof 124
    //   56: ifeq +457 -> 513
    //   59: aload_2
    //   60: getfield 122	ayqb:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   63: checkcast 124	dov/com/tencent/biz/qqstory/takevideo/EditLocalVideoSource
    //   66: getfield 144	dov/com/tencent/biz/qqstory/takevideo/EditLocalVideoSource:startTime	I
    //   69: i2l
    //   70: lstore 6
    //   72: aload_2
    //   73: getfield 122	ayqb:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   76: invokeinterface 149 1 0
    //   81: astore_1
    //   82: new 151	android/media/MediaMetadataRetriever
    //   85: dup
    //   86: invokespecial 152	android/media/MediaMetadataRetriever:<init>	()V
    //   89: astore 11
    //   91: aload 11
    //   93: aload_1
    //   94: invokevirtual 155	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   97: aload_2
    //   98: getfield 158	ayqb:jdField_a_of_type_Ayqj	Layqj;
    //   101: getfield 164	ayqj:aIH	Z
    //   104: ifeq +418 -> 522
    //   107: aload_2
    //   108: getfield 122	ayqb:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   111: instanceof 124
    //   114: ifeq +262 -> 376
    //   117: aload_2
    //   118: getfield 122	ayqb:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   121: checkcast 124	dov/com/tencent/biz/qqstory/takevideo/EditLocalVideoSource
    //   124: getfield 167	dov/com/tencent/biz/qqstory/takevideo/EditLocalVideoSource:endTime	I
    //   127: istore_3
    //   128: iload_3
    //   129: i2l
    //   130: lstore 4
    //   132: new 169	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   135: dup
    //   136: invokespecial 170	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   139: astore 9
    //   141: aload 9
    //   143: aload_2
    //   144: getfield 122	ayqb:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   147: invokeinterface 171 1 0
    //   152: putfield 174	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   155: aload 9
    //   157: aload_2
    //   158: getfield 122	ayqb:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   161: invokeinterface 175 1 0
    //   166: putfield 178	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   169: aload_1
    //   170: aload 9
    //   172: lload 4
    //   174: invokestatic 183	ayzc:a	(Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;J)Landroid/graphics/Bitmap;
    //   177: astore_1
    //   178: aload_1
    //   179: astore 9
    //   181: aload_1
    //   182: ifnonnull +16 -> 198
    //   185: aload 11
    //   187: ldc2_w 184
    //   190: lload 6
    //   192: lmul
    //   193: invokevirtual 189	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   196: astore 9
    //   198: aload 9
    //   200: astore_1
    //   201: aload 9
    //   203: ifnull +24 -> 227
    //   206: aload 9
    //   208: astore_1
    //   209: aload_2
    //   210: getfield 193	ayqb:g	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   213: getfield 198	com/tencent/biz/qqstory/database/PublishVideoEntry:videoNeedRotate	Z
    //   216: ifeq +11 -> 227
    //   219: aload 9
    //   221: ldc 199
    //   223: invokestatic 205	rpq:rotateBitmap	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   226: astore_1
    //   227: aload_1
    //   228: astore 9
    //   230: aload_2
    //   231: getfield 122	ayqb:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   234: instanceof 126
    //   237: ifeq +11 -> 248
    //   240: aload_0
    //   241: aload_2
    //   242: aload_1
    //   243: invokespecial 207	ayqg:b	(Layqb;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   246: astore 9
    //   248: aload 9
    //   250: ifnull +218 -> 468
    //   253: aload 9
    //   255: getstatic 213	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   258: bipush 80
    //   260: aload 10
    //   262: invokestatic 218	rop:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   265: istore 8
    //   267: aload 9
    //   269: invokevirtual 221	android/graphics/Bitmap:recycle	()V
    //   272: iload 8
    //   274: ifeq +160 -> 434
    //   277: new 223	java/io/File
    //   280: dup
    //   281: aload 10
    //   283: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   286: astore_1
    //   287: aload_1
    //   288: invokevirtual 228	java/io/File:exists	()Z
    //   291: ifeq +151 -> 442
    //   294: aload_1
    //   295: invokevirtual 231	java/io/File:isFile	()Z
    //   298: ifeq +144 -> 442
    //   301: ldc 81
    //   303: ldc 233
    //   305: aload 10
    //   307: invokestatic 88	ram:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   310: aload_2
    //   311: aload 10
    //   313: putfield 236	ayqb:aAT	Ljava/lang/String;
    //   316: aload_0
    //   317: aload_2
    //   318: invokespecial 240	ayqr:notifyResult	(Ljava/lang/Object;)V
    //   321: aload 11
    //   323: ifnull +8 -> 331
    //   326: aload 11
    //   328: invokevirtual 243	android/media/MediaMetadataRetriever:release	()V
    //   331: return
    //   332: astore 9
    //   334: ldc 81
    //   336: new 96	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   343: ldc 245
    //   345: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload_1
    //   349: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: aload 9
    //   357: invokestatic 248	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   360: goto -263 -> 97
    //   363: astore_1
    //   364: aload 11
    //   366: ifnull +8 -> 374
    //   369: aload 11
    //   371: invokevirtual 243	android/media/MediaMetadataRetriever:release	()V
    //   374: aload_1
    //   375: athrow
    //   376: aload 11
    //   378: bipush 9
    //   380: invokevirtual 252	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   383: astore 9
    //   385: aload 9
    //   387: ifnull -255 -> 132
    //   390: aload 9
    //   392: invokestatic 258	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   395: invokevirtual 262	java/lang/Long:longValue	()J
    //   398: lstore 4
    //   400: goto -268 -> 132
    //   403: astore_1
    //   404: ldc 81
    //   406: ldc_w 264
    //   409: aload_1
    //   410: invokestatic 248	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   413: goto +109 -> 522
    //   416: astore 9
    //   418: ldc 81
    //   420: ldc_w 266
    //   423: aload 9
    //   425: invokestatic 248	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   428: aload_1
    //   429: astore 9
    //   431: goto -233 -> 198
    //   434: ldc 81
    //   436: ldc_w 268
    //   439: invokestatic 271	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: aload 11
    //   444: ifnull +8 -> 452
    //   447: aload 11
    //   449: invokevirtual 243	android/media/MediaMetadataRetriever:release	()V
    //   452: aload_0
    //   453: new 273	com/tencent/biz/qqstory/base/ErrorMessage
    //   456: dup
    //   457: iconst_m1
    //   458: ldc_w 275
    //   461: invokespecial 278	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   464: invokevirtual 282	ayqg:notifyError	(Ljava/lang/Error;)V
    //   467: return
    //   468: ldc 81
    //   470: ldc_w 284
    //   473: iconst_1
    //   474: anewarray 286	java/lang/Object
    //   477: dup
    //   478: iconst_0
    //   479: lload 6
    //   481: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   484: aastore
    //   485: invokestatic 292	ram:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   488: goto -46 -> 442
    //   491: ldc 81
    //   493: ldc_w 294
    //   496: iconst_1
    //   497: anewarray 286	java/lang/Object
    //   500: dup
    //   501: iconst_0
    //   502: aload_2
    //   503: getfield 122	ayqb:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   506: aastore
    //   507: invokestatic 292	ram:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   510: goto -58 -> 452
    //   513: lconst_0
    //   514: lstore 6
    //   516: goto -444 -> 72
    //   519: goto -470 -> 49
    //   522: aconst_null
    //   523: astore_1
    //   524: goto -346 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	527	0	this	ayqg
    //   0	527	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	527	2	paramayqb	ayqb
    //   127	2	3	i	int
    //   1	398	4	l1	long
    //   70	445	6	l2	long
    //   265	8	8	bool	boolean
    //   139	129	9	localObject	Object
    //   332	24	9	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   383	8	9	str1	String
    //   416	8	9	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   429	1	9	localJobContext	com.tribe.async.async.JobContext
    //   27	285	10	str2	String
    //   89	359	11	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   91	97	332	java/lang/IllegalArgumentException
    //   91	97	363	finally
    //   97	128	363	finally
    //   132	178	363	finally
    //   185	198	363	finally
    //   209	227	363	finally
    //   230	248	363	finally
    //   253	272	363	finally
    //   277	321	363	finally
    //   334	360	363	finally
    //   376	385	363	finally
    //   390	400	363	finally
    //   404	413	363	finally
    //   418	428	363	finally
    //   434	442	363	finally
    //   468	488	363	finally
    //   132	178	403	java/lang/OutOfMemoryError
    //   185	198	416	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayqg
 * JD-Core Version:    0.7.0.1
 */