import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.SystemClock;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQImage2FrameFilter;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

public class xnk
  extends xnr
{
  long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  long jdField_b_of_type_Long;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  
  public xnk(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private int a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramBitmap == null) || (paramInt2 == 0) || (paramInt1 == 0)) {
      if (paramBitmap == null) {
        paramInt1 = i;
      }
    }
    do
    {
      return paramInt1;
      try
      {
        return GlUtil.createTexture(3553, paramBitmap);
      }
      catch (IllegalStateException paramBitmap) {}
      i = GlUtil.createTexture(3553, paramBitmap);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = new QQFilterRenderManager();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceCreate(paramInt1, paramInt2, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceChange(paramInt1, paramInt2, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.pushChain(new int[] { 170 }, null);
      List localList = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getQQFilters(170);
      if ((localList != null) && (localList.size() > 0) && ((localList.get(0) instanceof QQImage2FrameFilter))) {
        ((QQImage2FrameFilter)localList.get(0)).setImageSize(paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.drawFrame(i);
      paramInt1 = paramInt2;
    } while (i <= 0);
    GlUtil.deleteTexture(i);
    return paramInt2;
    return -1;
  }
  
  /* Error */
  private int a(String paramString)
  {
    // Byte code:
    //   0: new 89	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 90	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_1
    //   12: invokevirtual 94	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   15: aload 4
    //   17: bipush 9
    //   19: invokevirtual 98	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   22: invokestatic 103	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   25: istore_2
    //   26: iload_2
    //   27: istore_3
    //   28: aload 4
    //   30: ifnull +10 -> 40
    //   33: aload 4
    //   35: invokevirtual 106	android/media/MediaMetadataRetriever:release	()V
    //   38: iload_2
    //   39: istore_3
    //   40: iload_3
    //   41: ireturn
    //   42: astore_1
    //   43: aconst_null
    //   44: astore 4
    //   46: iconst_m1
    //   47: istore_3
    //   48: aload 4
    //   50: ifnull -10 -> 40
    //   53: aload 4
    //   55: invokevirtual 106	android/media/MediaMetadataRetriever:release	()V
    //   58: iconst_m1
    //   59: ireturn
    //   60: astore_1
    //   61: aconst_null
    //   62: astore 4
    //   64: aload 4
    //   66: ifnull +8 -> 74
    //   69: aload 4
    //   71: invokevirtual 106	android/media/MediaMetadataRetriever:release	()V
    //   74: aload_1
    //   75: athrow
    //   76: astore_1
    //   77: goto -13 -> 64
    //   80: astore_1
    //   81: goto -35 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	xnk
    //   0	84	1	paramString	String
    //   25	14	2	i	int
    //   27	21	3	j	int
    //   7	63	4	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   0	9	42	java/lang/Exception
    //   0	9	60	finally
    //   9	26	76	finally
    //   9	26	80	java/lang/Exception
  }
  
  @TargetApi(16)
  public static MediaFormat a()
  {
    axvi localaxvi = new axvi("", 720, 1280, axpy.a().a(1) * 1000, 1, false, 0);
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat("video/avc", 720, 1280);
    localMediaFormat.setInteger("color-format", 2130708361);
    localMediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[] { 0, 0, 0, 1, 103, 66, -128, 31, -38, 2, -48, 40, 105, 72, 40, 48, 40, 54, -123, 9, -88 }));
    localMediaFormat.setByteBuffer("csd-1", ByteBuffer.wrap(new byte[] { 0, 0, 0, 1, 104, -50, 6, -30 }));
    localMediaFormat.setInteger("bitrate", localaxvi.c);
    localMediaFormat.setInteger("frame-rate", localaxvi.d);
    localMediaFormat.setInteger("i-frame-interval", localaxvi.e);
    return localMediaFormat;
  }
  
  @TargetApi(16)
  public static MediaFormat a(String paramString)
  {
    localMediaExtractor = new MediaExtractor();
    try
    {
      long l = SystemClock.elapsedRealtime();
      localMediaExtractor.setDataSource(paramString);
      int i = 0;
      while (i < localMediaExtractor.getTrackCount())
      {
        paramString = localMediaExtractor.getTrackFormat(i);
        if (paramString.getString("mime").startsWith("video/"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ImageToVideo", 2, "getVideoFormatFromVideo, elapsed Time : " + (SystemClock.elapsedRealtime() - l));
          }
          return paramString;
        }
        i += 1;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, bhsw.a(paramString));
        }
        localMediaExtractor.release();
      }
    }
    finally
    {
      localMediaExtractor.release();
    }
    return null;
  }
  
  private int b(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap == null) || (paramInt2 == 0) || (paramInt1 == 0))
    {
      if (paramBitmap == null) {
        return 0;
      }
      return GlUtil.createTexture(3553, paramBitmap);
    }
    Object localObject1 = Image2Video.a(paramBitmap, 0.05F, 5, false);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
    float f2 = paramInt1 * 1.0F / paramInt2;
    float f1 = paramBitmap.getWidth() * 1.0F / paramBitmap.getHeight();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    localObject1 = new Matrix();
    ((Matrix)localObject1).postTranslate(i * -0.5F, j * -0.5F);
    float f3;
    float f4;
    Object localObject2;
    if (f1 > f2)
    {
      ((Matrix)localObject1).postScale(1.0F, paramInt1 * 1.0F / paramBitmap.getWidth() * paramBitmap.getHeight() / paramInt2);
      f2 = paramInt2;
      f3 = paramInt1 / f1;
      f4 = paramInt1;
      float f5 = paramInt2;
      localObject2 = new RectF(0.0F, 0.5F * (f2 - f3), f4, (paramInt1 / f1 + f5) * 0.5F);
      localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, i, j), (RectF)localObject2, null);
    }
    for (;;)
    {
      ((Matrix)localObject1).postTranslate(paramInt1 * 0.5F, paramInt2 * 0.5F);
      return GlUtil.createTexture(3553, localBitmap);
      ((Matrix)localObject1).postScale(paramInt2 * 1.0F / paramBitmap.getHeight() * paramBitmap.getWidth() / paramInt1, 1.0F);
      localObject2 = new Rect(0, 0, i, j);
      f2 = paramInt1;
      f3 = paramInt2;
      f4 = paramInt1;
      localCanvas.drawBitmap(paramBitmap, (Rect)localObject2, new RectF((f2 - f3 * f1) * 0.5F, 0.0F, (f1 * paramInt2 + f4) * 0.5F, paramInt2), null);
    }
  }
  
  /* Error */
  public void a(xno paramxno)
  {
    // Byte code:
    //   0: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +32 -> 35
    //   6: ldc 244
    //   8: iconst_2
    //   9: new 246	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 328
    //   19: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: getfield 332	xno:d	Z
    //   26: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 338	xnk:a	(Lxnq;)Z
    //   40: ifeq +34 -> 74
    //   43: ldc_w 340
    //   46: iconst_1
    //   47: anewarray 232	java/lang/String
    //   50: dup
    //   51: iconst_0
    //   52: ldc_w 342
    //   55: aastore
    //   56: invokestatic 347	wxj:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   59: aload_0
    //   60: bipush 9
    //   62: aload_1
    //   63: getfield 349	xno:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   66: aconst_null
    //   67: aconst_null
    //   68: aconst_null
    //   69: aload_1
    //   70: invokevirtual 352	xnk:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lxnq;)V
    //   73: return
    //   74: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   77: lstore_3
    //   78: new 359	java/io/FileInputStream
    //   81: dup
    //   82: aload_1
    //   83: getfield 349	xno:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   86: invokespecial 361	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   89: astore 10
    //   91: new 363	java/io/BufferedInputStream
    //   94: dup
    //   95: aload 10
    //   97: ldc_w 364
    //   100: invokespecial 367	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   103: astore 9
    //   105: aload_0
    //   106: aload 9
    //   108: aconst_null
    //   109: aload_1
    //   110: getfield 369	xno:jdField_a_of_type_Int	I
    //   113: aload_1
    //   114: getfield 370	xno:jdField_b_of_type_Int	I
    //   117: invokestatic 375	bdal:a	(Ljava/io/InputStream;Landroid/graphics/Rect;II)Landroid/graphics/Bitmap;
    //   120: putfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   123: aload 9
    //   125: ifnull +8 -> 133
    //   128: aload 9
    //   130: invokevirtual 378	java/io/BufferedInputStream:close	()V
    //   133: aload 10
    //   135: ifnull +8 -> 143
    //   138: aload 10
    //   140: invokevirtual 379	java/io/FileInputStream:close	()V
    //   143: aload_0
    //   144: getfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   147: ifnonnull +22 -> 169
    //   150: aload_0
    //   151: aload_1
    //   152: getfield 349	xno:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   155: aload_1
    //   156: getfield 369	xno:jdField_a_of_type_Int	I
    //   159: aload_1
    //   160: getfield 370	xno:jdField_b_of_type_Int	I
    //   163: invokestatic 382	bdal:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   166: putfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   169: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   172: lstore 5
    //   174: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +51 -> 228
    //   180: ldc 244
    //   182: iconst_2
    //   183: new 246	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   190: ldc_w 384
    //   193: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_1
    //   197: getfield 386	xno:jdField_b_of_type_Long	J
    //   200: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   203: ldc_w 388
    //   206: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: lload 5
    //   211: lload_3
    //   212: lsub
    //   213: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   216: ldc_w 390
    //   219: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload_0
    //   229: getfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   232: ifnonnull +204 -> 436
    //   235: aload_1
    //   236: iconst_0
    //   237: putfield 332	xno:d	Z
    //   240: ldc_w 340
    //   243: iconst_1
    //   244: anewarray 232	java/lang/String
    //   247: dup
    //   248: iconst_0
    //   249: ldc_w 392
    //   252: aastore
    //   253: invokestatic 347	wxj:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   256: aload_0
    //   257: iconst_5
    //   258: aload_1
    //   259: getfield 349	xno:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   262: aconst_null
    //   263: aconst_null
    //   264: aconst_null
    //   265: aload_1
    //   266: invokevirtual 352	xnk:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lxnq;)V
    //   269: return
    //   270: astore 8
    //   272: aload_0
    //   273: aconst_null
    //   274: putfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   277: aload_0
    //   278: getfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   281: ifnonnull +310 -> 591
    //   284: aload_1
    //   285: iconst_0
    //   286: putfield 332	xno:d	Z
    //   289: ldc_w 340
    //   292: iconst_1
    //   293: anewarray 232	java/lang/String
    //   296: dup
    //   297: iconst_0
    //   298: ldc_w 392
    //   301: aastore
    //   302: invokestatic 347	wxj:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   305: aload_0
    //   306: iconst_5
    //   307: aload_1
    //   308: getfield 349	xno:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   311: aconst_null
    //   312: aconst_null
    //   313: aconst_null
    //   314: aload_1
    //   315: invokevirtual 352	xnk:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lxnq;)V
    //   318: return
    //   319: astore 10
    //   321: aconst_null
    //   322: astore 8
    //   324: aconst_null
    //   325: astore 9
    //   327: aload 10
    //   329: invokevirtual 395	java/lang/Exception:printStackTrace	()V
    //   332: aload 9
    //   334: ifnull +8 -> 342
    //   337: aload 9
    //   339: invokevirtual 378	java/io/BufferedInputStream:close	()V
    //   342: aload 8
    //   344: ifnull -201 -> 143
    //   347: aload 8
    //   349: invokevirtual 379	java/io/FileInputStream:close	()V
    //   352: goto -209 -> 143
    //   355: astore 8
    //   357: goto -214 -> 143
    //   360: astore 8
    //   362: aconst_null
    //   363: astore 10
    //   365: aconst_null
    //   366: astore 9
    //   368: aload 9
    //   370: ifnull +8 -> 378
    //   373: aload 9
    //   375: invokevirtual 378	java/io/BufferedInputStream:close	()V
    //   378: aload 10
    //   380: ifnull +8 -> 388
    //   383: aload 10
    //   385: invokevirtual 379	java/io/FileInputStream:close	()V
    //   388: aload 8
    //   390: athrow
    //   391: astore 8
    //   393: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   396: ifeq +32 -> 428
    //   399: ldc 244
    //   401: iconst_2
    //   402: new 246	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   409: ldc_w 397
    //   412: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload_1
    //   416: getfield 386	xno:jdField_b_of_type_Long	J
    //   419: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   422: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: aload_0
    //   429: aconst_null
    //   430: putfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   433: goto -156 -> 277
    //   436: aload_1
    //   437: getfield 349	xno:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   440: invokestatic 401	bdhj:b	(Ljava/lang/String;)I
    //   443: istore_2
    //   444: iload_2
    //   445: ifeq +88 -> 533
    //   448: iload_2
    //   449: bipush 90
    //   451: irem
    //   452: ifne +81 -> 533
    //   455: new 297	android/graphics/Matrix
    //   458: dup
    //   459: invokespecial 298	android/graphics/Matrix:<init>	()V
    //   462: astore 8
    //   464: aload 8
    //   466: iload_2
    //   467: i2f
    //   468: aload_0
    //   469: getfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   472: invokevirtual 69	android/graphics/Bitmap:getWidth	()I
    //   475: i2f
    //   476: fconst_2
    //   477: fdiv
    //   478: aload_0
    //   479: getfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   482: invokevirtual 72	android/graphics/Bitmap:getHeight	()I
    //   485: i2f
    //   486: fconst_2
    //   487: fdiv
    //   488: invokevirtual 405	android/graphics/Matrix:postRotate	(FFF)Z
    //   491: pop
    //   492: aload_0
    //   493: getfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   496: iconst_0
    //   497: iconst_0
    //   498: aload_0
    //   499: getfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   502: invokevirtual 69	android/graphics/Bitmap:getWidth	()I
    //   505: aload_0
    //   506: getfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   509: invokevirtual 72	android/graphics/Bitmap:getHeight	()I
    //   512: aload 8
    //   514: iconst_1
    //   515: invokestatic 408	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   518: astore 8
    //   520: aload_0
    //   521: getfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   524: invokevirtual 411	android/graphics/Bitmap:recycle	()V
    //   527: aload_0
    //   528: aload 8
    //   530: putfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   533: aload_0
    //   534: aload_1
    //   535: invokevirtual 338	xnk:a	(Lxnq;)Z
    //   538: ifeq -261 -> 277
    //   541: aload_0
    //   542: getfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   545: ifnull +15 -> 560
    //   548: aload_0
    //   549: getfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   552: invokevirtual 411	android/graphics/Bitmap:recycle	()V
    //   555: aload_0
    //   556: aconst_null
    //   557: putfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   560: ldc_w 340
    //   563: iconst_1
    //   564: anewarray 232	java/lang/String
    //   567: dup
    //   568: iconst_0
    //   569: ldc_w 342
    //   572: aastore
    //   573: invokestatic 347	wxj:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   576: aload_0
    //   577: bipush 9
    //   579: aload_1
    //   580: getfield 349	xno:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   583: aconst_null
    //   584: aconst_null
    //   585: aconst_null
    //   586: aload_1
    //   587: invokevirtual 352	xnk:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lxnq;)V
    //   590: return
    //   591: new 413	java/io/File
    //   594: dup
    //   595: getstatic 415	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   598: invokespecial 416	java/io/File:<init>	(Ljava/lang/String;)V
    //   601: astore 8
    //   603: aload 8
    //   605: invokevirtual 419	java/io/File:exists	()Z
    //   608: ifne +43 -> 651
    //   611: aload 8
    //   613: invokevirtual 422	java/io/File:mkdirs	()Z
    //   616: istore 7
    //   618: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   621: ifeq +30 -> 651
    //   624: ldc 244
    //   626: iconst_2
    //   627: new 246	java/lang/StringBuilder
    //   630: dup
    //   631: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   634: ldc_w 424
    //   637: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: iload 7
    //   642: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   645: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   651: new 413	java/io/File
    //   654: dup
    //   655: aload_1
    //   656: getfield 349	xno:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   659: invokespecial 416	java/io/File:<init>	(Ljava/lang/String;)V
    //   662: astore 9
    //   664: aload 9
    //   666: ifnull +1045 -> 1711
    //   669: aload 9
    //   671: invokevirtual 427	java/io/File:getName	()Ljava/lang/String;
    //   674: astore 8
    //   676: aload 8
    //   678: invokestatic 433	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   681: ifne +1027 -> 1708
    //   684: aload 8
    //   686: ldc_w 435
    //   689: ldc_w 437
    //   692: invokevirtual 441	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   695: astore 8
    //   697: new 246	java/lang/StringBuilder
    //   700: dup
    //   701: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   704: aload 8
    //   706: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: ldc_w 437
    //   712: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: aload 9
    //   717: invokevirtual 444	java/io/File:length	()J
    //   720: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   723: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   726: astore 8
    //   728: new 246	java/lang/StringBuilder
    //   731: dup
    //   732: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   735: aload 8
    //   737: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: ldc_w 446
    //   743: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: astore 8
    //   751: invokestatic 451	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/common/app/AppInterface;
    //   754: iconst_1
    //   755: invokevirtual 456	com/tencent/common/app/AppInterface:getBusinessHandler	(I)Ljava/lang/Object;
    //   758: checkcast 458	xnh
    //   761: astore 9
    //   763: aload 9
    //   765: aload_1
    //   766: getfield 349	xno:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   769: invokevirtual 461	xnh:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   772: ifnull +37 -> 809
    //   775: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   778: ifeq -705 -> 73
    //   781: ldc 244
    //   783: iconst_2
    //   784: new 246	java/lang/StringBuilder
    //   787: dup
    //   788: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   791: aload 8
    //   793: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: ldc_w 463
    //   799: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   808: return
    //   809: aload_0
    //   810: new 246	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   817: getstatic 466	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   820: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload 8
    //   825: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: invokespecial 468	xnk:a	(Ljava/lang/String;)I
    //   834: sipush 1000
    //   837: if_icmplt +168 -> 1005
    //   840: new 246	java/lang/StringBuilder
    //   843: dup
    //   844: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   847: getstatic 466	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   850: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: aload 8
    //   855: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: ldc_w 470
    //   861: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   867: invokestatic 474	bdhb:a	(Ljava/lang/String;)Z
    //   870: ifeq +135 -> 1005
    //   873: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   876: ifeq +30 -> 906
    //   879: ldc 244
    //   881: iconst_2
    //   882: new 246	java/lang/StringBuilder
    //   885: dup
    //   886: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   889: aload 8
    //   891: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: ldc_w 476
    //   897: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   906: new 478	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   909: dup
    //   910: invokespecial 479	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   913: astore 10
    //   915: aload 10
    //   917: new 246	java/lang/StringBuilder
    //   920: dup
    //   921: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   924: getstatic 466	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   927: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: aload 8
    //   932: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   938: putfield 482	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   941: aload 10
    //   943: ldc_w 484
    //   946: putfield 487	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   949: aload 10
    //   951: new 246	java/lang/StringBuilder
    //   954: dup
    //   955: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   958: getstatic 466	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   961: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: aload 8
    //   966: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: ldc_w 470
    //   972: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   975: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   978: putfield 490	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mAudioPath	Ljava/lang/String;
    //   981: aload 10
    //   983: iconst_0
    //   984: putfield 493	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mHasAudioTrack	Z
    //   987: aload 10
    //   989: iconst_1
    //   990: putfield 496	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mSampleRate	I
    //   993: aload 9
    //   995: aload_1
    //   996: getfield 349	xno:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   999: aload 10
    //   1001: invokevirtual 499	xnh:a	(Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V
    //   1004: return
    //   1005: aload_0
    //   1006: new 246	java/lang/StringBuilder
    //   1009: dup
    //   1010: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1013: getstatic 415	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1016: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: aload 8
    //   1021: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1027: putfield 500	xnk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1030: aload_0
    //   1031: new 246	java/lang/StringBuilder
    //   1034: dup
    //   1035: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1038: aload_0
    //   1039: getfield 500	xnk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1042: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: ldc_w 502
    //   1048: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   1054: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1057: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1060: putfield 504	xnk:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1063: aload_0
    //   1064: getfield 504	xnk:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1067: invokestatic 509	xrg:g	(Ljava/lang/String;)Z
    //   1070: pop
    //   1071: aload_1
    //   1072: getfield 511	xno:jdField_a_of_type_Long	J
    //   1075: l2i
    //   1076: istore_2
    //   1077: aload_0
    //   1078: lconst_0
    //   1079: putfield 114	xnk:jdField_c_of_type_Long	J
    //   1082: aload_1
    //   1083: ldc2_w 512
    //   1086: aload_1
    //   1087: getfield 511	xno:jdField_a_of_type_Long	J
    //   1090: lmul
    //   1091: putfield 511	xno:jdField_a_of_type_Long	J
    //   1094: aload_1
    //   1095: aload_1
    //   1096: getfield 511	xno:jdField_a_of_type_Long	J
    //   1099: ldc2_w 514
    //   1102: ldiv
    //   1103: putfield 511	xno:jdField_a_of_type_Long	J
    //   1106: aload_0
    //   1107: aload_1
    //   1108: invokevirtual 338	xnk:a	(Lxnq;)Z
    //   1111: ifeq +53 -> 1164
    //   1114: aload_0
    //   1115: getfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1118: ifnull +15 -> 1133
    //   1121: aload_0
    //   1122: getfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1125: invokevirtual 411	android/graphics/Bitmap:recycle	()V
    //   1128: aload_0
    //   1129: aconst_null
    //   1130: putfield 118	xnk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1133: ldc_w 340
    //   1136: iconst_1
    //   1137: anewarray 232	java/lang/String
    //   1140: dup
    //   1141: iconst_0
    //   1142: ldc_w 342
    //   1145: aastore
    //   1146: invokestatic 347	wxj:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1149: aload_0
    //   1150: bipush 9
    //   1152: aload_1
    //   1153: getfield 349	xno:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1156: aconst_null
    //   1157: aconst_null
    //   1158: aconst_null
    //   1159: aload_1
    //   1160: invokevirtual 352	xnk:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lxnq;)V
    //   1163: return
    //   1164: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   1167: lstore 5
    //   1169: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1172: ifeq +51 -> 1223
    //   1175: ldc 244
    //   1177: iconst_2
    //   1178: new 246	java/lang/StringBuilder
    //   1181: dup
    //   1182: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1185: ldc_w 517
    //   1188: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1191: aload_1
    //   1192: getfield 386	xno:jdField_b_of_type_Long	J
    //   1195: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1198: ldc_w 519
    //   1201: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: lload 5
    //   1206: lload_3
    //   1207: lsub
    //   1208: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1211: ldc_w 390
    //   1214: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1220: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1223: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   1226: lstore_3
    //   1227: new 246	java/lang/StringBuilder
    //   1230: dup
    //   1231: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1234: getstatic 415	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1237: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: aload 8
    //   1242: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: ldc_w 470
    //   1248: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1251: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1254: astore 8
    //   1256: aload 8
    //   1258: invokestatic 521	xrg:e	(Ljava/lang/String;)Z
    //   1261: ifeq +9 -> 1270
    //   1264: aload 8
    //   1266: invokestatic 524	xrg:f	(Ljava/lang/String;)Z
    //   1269: pop
    //   1270: aload 8
    //   1272: iload_2
    //   1273: bipush 42
    //   1275: iadd
    //   1276: bipush 15
    //   1278: iadd
    //   1279: invokestatic 528	xrd:a	(Ljava/lang/String;I)V
    //   1282: aload 8
    //   1284: invokestatic 521	xrg:e	(Ljava/lang/String;)Z
    //   1287: ifne +80 -> 1367
    //   1290: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1293: ifeq +43 -> 1336
    //   1296: ldc 244
    //   1298: iconst_2
    //   1299: new 246	java/lang/StringBuilder
    //   1302: dup
    //   1303: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1306: ldc_w 530
    //   1309: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: aload_1
    //   1313: getfield 386	xno:jdField_b_of_type_Long	J
    //   1316: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1319: ldc_w 532
    //   1322: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: aload 8
    //   1327: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1333: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1336: ldc_w 340
    //   1339: iconst_1
    //   1340: anewarray 232	java/lang/String
    //   1343: dup
    //   1344: iconst_0
    //   1345: ldc_w 534
    //   1348: aastore
    //   1349: invokestatic 347	wxj:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1352: aload_0
    //   1353: bipush 8
    //   1355: aload_1
    //   1356: getfield 349	xno:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1359: aconst_null
    //   1360: aconst_null
    //   1361: aconst_null
    //   1362: aload_1
    //   1363: invokevirtual 352	xnk:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lxnq;)V
    //   1366: return
    //   1367: aload_0
    //   1368: aload 8
    //   1370: putfield 535	xnk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1373: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   1376: lstore 5
    //   1378: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1381: ifeq +51 -> 1432
    //   1384: ldc 244
    //   1386: iconst_2
    //   1387: new 246	java/lang/StringBuilder
    //   1390: dup
    //   1391: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1394: ldc_w 537
    //   1397: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: aload_1
    //   1401: getfield 386	xno:jdField_b_of_type_Long	J
    //   1404: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1407: ldc_w 539
    //   1410: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: lload 5
    //   1415: lload_3
    //   1416: lsub
    //   1417: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1420: ldc_w 390
    //   1423: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1429: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1432: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   1435: lstore_3
    //   1436: aload_0
    //   1437: new 541	axvw
    //   1440: dup
    //   1441: invokespecial 542	axvw:<init>	()V
    //   1444: putfield 545	xnk:jdField_a_of_type_Axvw	Laxvw;
    //   1447: new 125	axvi
    //   1450: dup
    //   1451: aload_0
    //   1452: getfield 504	xnk:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1455: aload_1
    //   1456: getfield 369	xno:jdField_a_of_type_Int	I
    //   1459: aload_1
    //   1460: getfield 370	xno:jdField_b_of_type_Int	I
    //   1463: invokestatic 132	axpy:a	()Laxpy;
    //   1466: iconst_1
    //   1467: invokevirtual 134	axpy:a	(I)I
    //   1470: sipush 1000
    //   1473: imul
    //   1474: iconst_1
    //   1475: iconst_0
    //   1476: iconst_0
    //   1477: invokespecial 137	axvi:<init>	(Ljava/lang/String;IIIIZI)V
    //   1480: astore 8
    //   1482: aload 8
    //   1484: invokestatic 551	android/opengl/EGL14:eglGetCurrentContext	()Landroid/opengl/EGLContext;
    //   1487: invokevirtual 554	axvi:a	(Landroid/opengl/EGLContext;)V
    //   1490: aload_0
    //   1491: getfield 545	xnk:jdField_a_of_type_Axvw	Laxvw;
    //   1494: aload 8
    //   1496: new 556	xnl
    //   1499: dup
    //   1500: aload_0
    //   1501: aload_1
    //   1502: invokespecial 559	xnl:<init>	(Lxnk;Lxno;)V
    //   1505: invokevirtual 562	axvw:a	(Laxvi;Laxvu;)V
    //   1508: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   1511: lstore 5
    //   1513: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1516: ifeq +51 -> 1567
    //   1519: ldc 244
    //   1521: iconst_2
    //   1522: new 246	java/lang/StringBuilder
    //   1525: dup
    //   1526: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1529: ldc_w 564
    //   1532: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: aload_1
    //   1536: getfield 386	xno:jdField_b_of_type_Long	J
    //   1539: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1542: ldc_w 566
    //   1545: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1548: lload 5
    //   1550: lload_3
    //   1551: lsub
    //   1552: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1555: ldc_w 390
    //   1558: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1561: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1564: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1567: aload_0
    //   1568: monitorenter
    //   1569: aload_0
    //   1570: invokevirtual 571	java/lang/Object:wait	()V
    //   1573: aload_0
    //   1574: monitorexit
    //   1575: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1578: ifeq -1505 -> 73
    //   1581: ldc 244
    //   1583: iconst_2
    //   1584: new 246	java/lang/StringBuilder
    //   1587: dup
    //   1588: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1591: ldc_w 573
    //   1594: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1597: aload_1
    //   1598: getfield 386	xno:jdField_b_of_type_Long	J
    //   1601: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1604: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1607: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1610: return
    //   1611: astore 8
    //   1613: aload_0
    //   1614: monitorexit
    //   1615: aload 8
    //   1617: athrow
    //   1618: astore 8
    //   1620: aload 8
    //   1622: invokevirtual 574	java/lang/InterruptedException:printStackTrace	()V
    //   1625: goto -50 -> 1575
    //   1628: astore 8
    //   1630: goto -1497 -> 133
    //   1633: astore 8
    //   1635: goto -1492 -> 143
    //   1638: astore 9
    //   1640: goto -1298 -> 342
    //   1643: astore 9
    //   1645: goto -1267 -> 378
    //   1648: astore 9
    //   1650: goto -1262 -> 388
    //   1653: astore 8
    //   1655: aconst_null
    //   1656: astore 9
    //   1658: goto -1290 -> 368
    //   1661: astore 8
    //   1663: goto -1295 -> 368
    //   1666: astore 11
    //   1668: aload 8
    //   1670: astore 10
    //   1672: aload 11
    //   1674: astore 8
    //   1676: goto -1308 -> 368
    //   1679: astore 11
    //   1681: aconst_null
    //   1682: astore 9
    //   1684: aload 10
    //   1686: astore 8
    //   1688: aload 11
    //   1690: astore 10
    //   1692: goto -1365 -> 327
    //   1695: astore 11
    //   1697: aload 10
    //   1699: astore 8
    //   1701: aload 11
    //   1703: astore 10
    //   1705: goto -1378 -> 327
    //   1708: goto -957 -> 751
    //   1711: aconst_null
    //   1712: astore 8
    //   1714: goto -963 -> 751
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1717	0	this	xnk
    //   0	1717	1	paramxno	xno
    //   443	833	2	i	int
    //   77	1474	3	l1	long
    //   172	1377	5	l2	long
    //   616	25	7	bool	boolean
    //   270	1	8	localException1	java.lang.Exception
    //   322	26	8	localObject1	Object
    //   355	1	8	localException2	java.lang.Exception
    //   360	29	8	localObject2	Object
    //   391	1	8	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   462	1033	8	localObject3	Object
    //   1611	5	8	localObject4	Object
    //   1618	3	8	localInterruptedException	java.lang.InterruptedException
    //   1628	1	8	localException3	java.lang.Exception
    //   1633	1	8	localException4	java.lang.Exception
    //   1653	1	8	localObject5	Object
    //   1661	8	8	localObject6	Object
    //   1674	39	8	localObject7	Object
    //   103	891	9	localObject8	Object
    //   1638	1	9	localException5	java.lang.Exception
    //   1643	1	9	localException6	java.lang.Exception
    //   1648	1	9	localException7	java.lang.Exception
    //   1656	27	9	localObject9	Object
    //   89	50	10	localFileInputStream	java.io.FileInputStream
    //   319	9	10	localException8	java.lang.Exception
    //   363	1341	10	localObject10	Object
    //   1666	7	11	localObject11	Object
    //   1679	10	11	localException9	java.lang.Exception
    //   1695	7	11	localException10	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   143	169	270	java/lang/Exception
    //   169	228	270	java/lang/Exception
    //   228	269	270	java/lang/Exception
    //   388	391	270	java/lang/Exception
    //   436	444	270	java/lang/Exception
    //   455	533	270	java/lang/Exception
    //   533	560	270	java/lang/Exception
    //   560	590	270	java/lang/Exception
    //   78	91	319	java/lang/Exception
    //   347	352	355	java/lang/Exception
    //   78	91	360	finally
    //   128	133	391	java/lang/OutOfMemoryError
    //   138	143	391	java/lang/OutOfMemoryError
    //   143	169	391	java/lang/OutOfMemoryError
    //   169	228	391	java/lang/OutOfMemoryError
    //   228	269	391	java/lang/OutOfMemoryError
    //   337	342	391	java/lang/OutOfMemoryError
    //   347	352	391	java/lang/OutOfMemoryError
    //   373	378	391	java/lang/OutOfMemoryError
    //   383	388	391	java/lang/OutOfMemoryError
    //   388	391	391	java/lang/OutOfMemoryError
    //   436	444	391	java/lang/OutOfMemoryError
    //   455	533	391	java/lang/OutOfMemoryError
    //   533	560	391	java/lang/OutOfMemoryError
    //   560	590	391	java/lang/OutOfMemoryError
    //   1569	1575	1611	finally
    //   1613	1615	1611	finally
    //   1567	1569	1618	java/lang/InterruptedException
    //   1615	1618	1618	java/lang/InterruptedException
    //   128	133	1628	java/lang/Exception
    //   138	143	1633	java/lang/Exception
    //   337	342	1638	java/lang/Exception
    //   373	378	1643	java/lang/Exception
    //   383	388	1648	java/lang/Exception
    //   91	105	1653	finally
    //   105	123	1661	finally
    //   327	332	1666	finally
    //   91	105	1679	java/lang/Exception
    //   105	123	1695	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xnk
 * JD-Core Version:    0.7.0.1
 */