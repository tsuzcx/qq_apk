import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.HWVideoDecoder;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

@TargetApi(11)
public class amah
  implements alzd, alzt, amal, SurfaceTexture.OnFrameAvailableListener
{
  private alza jdField_a_of_type_Alza;
  private amae jdField_a_of_type_Amae;
  private amah.a jdField_a_of_type_Amah$a;
  private amal jdField_a_of_type_Amal;
  private amba jdField_a_of_type_Amba;
  private HWVideoDecoder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder = new HWVideoDecoder();
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private long aim = -1L;
  private long ain = -1L;
  private aatn jdField_b_of_type_Aatn;
  private aman jdField_b_of_type_Aman = new aman();
  private GPUBaseFilter jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private GPUBaseFilter c;
  private boolean cBG;
  private boolean cBH;
  private boolean canceled;
  public int dBg;
  private Object eA = new Object();
  private Object eB = new Object();
  private GPUOESBaseFilter mEncodeGPUOESFilter;
  private int mErrorCode = 0;
  private boolean mFrameAvailable;
  private RenderBuffer mRenderFBO;
  private int mWatermarkHeight;
  private int mWatermarkTextureIdForEncode = -1;
  private int mWatermarkWidth;
  private int textureId;
  
  private void dLM()
  {
    this.mEncodeGPUOESFilter.destroy();
    if (this.jdField_a_of_type_Amba != null) {
      this.jdField_a_of_type_Amba.destroy();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
    }
    if (this.c != null) {
      this.c.destroy();
    }
    if (this.jdField_b_of_type_Aatn != null) {
      this.jdField_b_of_type_Aatn.unInit();
    }
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    this.mErrorCode = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder.stopDecode();
    if (this.jdField_a_of_type_Amal != null) {
      this.jdField_a_of_type_Amal.a(paramInt, paramThrowable);
    }
  }
  
  public void a(alza paramalza, amae paramamae, amal paramamal, amah.a parama)
  {
    this.jdField_a_of_type_Alza = paramalza;
    this.jdField_a_of_type_Amae = paramamae;
    this.jdField_a_of_type_Amal = paramamal;
    this.jdField_a_of_type_Amah$a = parama;
    this.jdField_b_of_type_Aman.a(paramamae, this);
    this.canceled = false;
  }
  
  /* Error */
  public void auv()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 135
    //   3: invokestatic 141	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:createTexture	(I)I
    //   6: putfield 143	amah:textureId	I
    //   9: aload_0
    //   10: new 145	com/tencent/ttpic/openapi/filter/RenderBuffer
    //   13: dup
    //   14: aload_0
    //   15: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   18: getfield 150	amae:width	I
    //   21: aload_0
    //   22: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   25: getfield 153	amae:height	I
    //   28: ldc 154
    //   30: invokespecial 157	com/tencent/ttpic/openapi/filter/RenderBuffer:<init>	(III)V
    //   33: putfield 159	amah:mRenderFBO	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   36: aload_0
    //   37: bipush 102
    //   39: invokestatic 164	amas:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   42: checkcast 85	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter
    //   45: putfield 83	amah:mEncodeGPUOESFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   48: aload_0
    //   49: getfield 83	amah:mEncodeGPUOESFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   52: aload_0
    //   53: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   56: getfield 150	amae:width	I
    //   59: aload_0
    //   60: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   63: getfield 153	amae:height	I
    //   66: invokevirtual 168	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:onOutputSizeChanged	(II)V
    //   69: aload_0
    //   70: getfield 83	amah:mEncodeGPUOESFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   73: invokevirtual 171	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:init	()V
    //   76: aload_0
    //   77: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   80: getfield 174	amae:filterType	I
    //   83: invokestatic 178	amas:lb	(I)Z
    //   86: ifne +13 -> 99
    //   89: aload_0
    //   90: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   93: getfield 182	amae:mosaicPath	Ljava/lang/String;
    //   96: ifnull +110 -> 206
    //   99: aload_0
    //   100: new 92	amba
    //   103: dup
    //   104: invokespecial 183	amba:<init>	()V
    //   107: putfield 90	amah:jdField_a_of_type_Amba	Lamba;
    //   110: aload_0
    //   111: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   114: getfield 174	amae:filterType	I
    //   117: invokestatic 178	amas:lb	(I)Z
    //   120: ifeq +20 -> 140
    //   123: aload_0
    //   124: getfield 90	amah:jdField_a_of_type_Amba	Lamba;
    //   127: aload_0
    //   128: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   131: getfield 174	amae:filterType	I
    //   134: invokestatic 164	amas:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   137: invokevirtual 186	amba:a	(Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;)V
    //   140: aload_0
    //   141: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   144: getfield 182	amae:mosaicPath	Ljava/lang/String;
    //   147: ifnull +31 -> 178
    //   150: bipush 106
    //   152: invokestatic 164	amas:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   155: astore_1
    //   156: aload_1
    //   157: checkcast 188	amax
    //   160: aload_0
    //   161: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   164: getfield 182	amae:mosaicPath	Ljava/lang/String;
    //   167: invokevirtual 192	amax:Pv	(Ljava/lang/String;)V
    //   170: aload_0
    //   171: getfield 90	amah:jdField_a_of_type_Amba	Lamba;
    //   174: aload_1
    //   175: invokevirtual 186	amba:a	(Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;)V
    //   178: aload_0
    //   179: getfield 90	amah:jdField_a_of_type_Amba	Lamba;
    //   182: aload_0
    //   183: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   186: getfield 150	amae:width	I
    //   189: aload_0
    //   190: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   193: getfield 153	amae:height	I
    //   196: invokevirtual 193	amba:onOutputSizeChanged	(II)V
    //   199: aload_0
    //   200: getfield 90	amah:jdField_a_of_type_Amba	Lamba;
    //   203: invokevirtual 194	amba:init	()V
    //   206: aload_0
    //   207: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   210: getfield 197	amae:subtitleData	Ljava/lang/String;
    //   213: invokestatic 203	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   216: ifne +313 -> 529
    //   219: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq +11 -> 233
    //   225: ldc 211
    //   227: iconst_2
    //   228: ldc 213
    //   230: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aload_0
    //   234: aload_0
    //   235: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   238: getfield 197	amae:subtitleData	Ljava/lang/String;
    //   241: aload_0
    //   242: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   245: getfield 150	amae:width	I
    //   248: i2f
    //   249: aload_0
    //   250: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   253: getfield 153	amae:height	I
    //   256: i2f
    //   257: ldc 218
    //   259: aload_0
    //   260: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   263: getfield 221	amae:frameRate	I
    //   266: i2f
    //   267: fdiv
    //   268: f2i
    //   269: invokestatic 226	aatg:a	(Ljava/lang/String;FFI)Laatn;
    //   272: putfield 102	amah:jdField_b_of_type_Aatn	Laatn;
    //   275: aload_0
    //   276: getfield 102	amah:jdField_b_of_type_Aatn	Laatn;
    //   279: ifnull +50 -> 329
    //   282: aload_0
    //   283: getfield 102	amah:jdField_b_of_type_Aatn	Laatn;
    //   286: iconst_1
    //   287: invokevirtual 230	aatn:aJ	(Z)Z
    //   290: pop
    //   291: aload_0
    //   292: sipush 1000
    //   295: invokestatic 164	amas:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   298: putfield 100	amah:c	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   301: aload_0
    //   302: getfield 100	amah:c	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   305: aload_0
    //   306: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   309: getfield 150	amae:width	I
    //   312: aload_0
    //   313: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   316: getfield 153	amae:height	I
    //   319: invokevirtual 231	com/tencent/ttpic/openapi/filter/GPUBaseFilter:onOutputSizeChanged	(II)V
    //   322: aload_0
    //   323: getfield 100	amah:c	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   326: invokevirtual 232	com/tencent/ttpic/openapi/filter/GPUBaseFilter:init	()V
    //   329: aload_0
    //   330: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   333: getfield 235	amae:watermarkPath	Ljava/lang/String;
    //   336: astore_1
    //   337: aload_1
    //   338: ifnull +120 -> 458
    //   341: aload_0
    //   342: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   345: getfield 235	amae:watermarkPath	Ljava/lang/String;
    //   348: invokestatic 241	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   351: astore_2
    //   352: aload_0
    //   353: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   356: getfield 244	amae:orientation	I
    //   359: ifeq +222 -> 581
    //   362: aload_2
    //   363: sipush 360
    //   366: aload_0
    //   367: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   370: getfield 244	amae:orientation	I
    //   373: isub
    //   374: i2f
    //   375: invokestatic 250	rpq:rotateBitmap	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   378: astore_1
    //   379: aload_0
    //   380: sipush 3553
    //   383: aload_1
    //   384: invokestatic 253	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:createTexture	(ILandroid/graphics/Bitmap;)I
    //   387: putfield 69	amah:mWatermarkTextureIdForEncode	I
    //   390: aload_0
    //   391: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   394: getfield 256	amae:dBc	I
    //   397: ifne +216 -> 613
    //   400: aload_0
    //   401: aload_1
    //   402: invokevirtual 262	android/graphics/Bitmap:getWidth	()I
    //   405: putfield 264	amah:mWatermarkWidth	I
    //   408: aload_0
    //   409: aload_1
    //   410: invokevirtual 267	android/graphics/Bitmap:getHeight	()I
    //   413: putfield 269	amah:mWatermarkHeight	I
    //   416: aload_1
    //   417: invokevirtual 272	android/graphics/Bitmap:recycle	()V
    //   420: aload_0
    //   421: sipush 1000
    //   424: invokestatic 164	amas:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   427: putfield 95	amah:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   430: aload_0
    //   431: getfield 95	amah:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   434: aload_0
    //   435: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   438: getfield 150	amae:width	I
    //   441: aload_0
    //   442: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   445: getfield 153	amae:height	I
    //   448: invokevirtual 231	com/tencent/ttpic/openapi/filter/GPUBaseFilter:onOutputSizeChanged	(II)V
    //   451: aload_0
    //   452: getfield 95	amah:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   455: invokevirtual 232	com/tencent/ttpic/openapi/filter/GPUBaseFilter:init	()V
    //   458: aload_0
    //   459: bipush 101
    //   461: invokestatic 164	amas:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   464: putfield 109	amah:jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   467: aload_0
    //   468: getfield 109	amah:jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   471: aload_0
    //   472: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   475: getfield 150	amae:width	I
    //   478: aload_0
    //   479: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   482: getfield 153	amae:height	I
    //   485: invokevirtual 231	com/tencent/ttpic/openapi/filter/GPUBaseFilter:onOutputSizeChanged	(II)V
    //   488: aload_0
    //   489: getfield 109	amah:jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   492: invokevirtual 232	com/tencent/ttpic/openapi/filter/GPUBaseFilter:init	()V
    //   495: aload_0
    //   496: getfield 79	amah:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder;
    //   499: aload_0
    //   500: getfield 120	amah:jdField_a_of_type_Alza	Lalza;
    //   503: aload_0
    //   504: getfield 143	amah:textureId	I
    //   507: aload_0
    //   508: aload_0
    //   509: invokevirtual 275	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder:a	(Lalza;ILandroid/graphics/SurfaceTexture$OnFrameAvailableListener;Lalzd;)V
    //   512: aload_0
    //   513: getfield 115	amah:jdField_a_of_type_Amal	Lamal;
    //   516: ifnull +162 -> 678
    //   519: aload_0
    //   520: getfield 115	amah:jdField_a_of_type_Amal	Lamal;
    //   523: invokeinterface 277 1 0
    //   528: return
    //   529: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   532: ifeq -203 -> 329
    //   535: ldc 211
    //   537: iconst_2
    //   538: ldc_w 279
    //   541: invokestatic 282	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   544: goto -215 -> 329
    //   547: astore_1
    //   548: aload_0
    //   549: iconst_4
    //   550: aload_1
    //   551: invokevirtual 283	amah:a	(ILjava/lang/Throwable;)V
    //   554: ldc 211
    //   556: iconst_1
    //   557: new 285	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   564: ldc_w 288
    //   567: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: aload_1
    //   571: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   574: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokestatic 282	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   580: return
    //   581: aload_2
    //   582: astore_1
    //   583: aload_0
    //   584: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   587: getfield 256	amae:dBc	I
    //   590: ifeq -211 -> 379
    //   593: aload_2
    //   594: sipush 360
    //   597: aload_0
    //   598: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   601: getfield 256	amae:dBc	I
    //   604: isub
    //   605: i2f
    //   606: invokestatic 250	rpq:rotateBitmap	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   609: astore_1
    //   610: goto -231 -> 379
    //   613: aload_0
    //   614: aload_1
    //   615: invokevirtual 267	android/graphics/Bitmap:getHeight	()I
    //   618: putfield 264	amah:mWatermarkWidth	I
    //   621: aload_0
    //   622: aload_1
    //   623: invokevirtual 262	android/graphics/Bitmap:getWidth	()I
    //   626: putfield 269	amah:mWatermarkHeight	I
    //   629: goto -213 -> 416
    //   632: astore_1
    //   633: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   636: ifeq +36 -> 672
    //   639: ldc 211
    //   641: iconst_2
    //   642: new 285	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   649: ldc_w 301
    //   652: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: aload_0
    //   656: getfield 122	amah:jdField_a_of_type_Amae	Lamae;
    //   659: getfield 235	amae:watermarkPath	Ljava/lang/String;
    //   662: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: aload_1
    //   669: invokestatic 304	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   672: aload_0
    //   673: iconst_1
    //   674: aload_1
    //   675: invokevirtual 283	amah:a	(ILjava/lang/Throwable;)V
    //   678: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	679	0	this	amah
    //   155	262	1	localObject1	Object
    //   547	24	1	localException	Exception
    //   582	41	1	localObject2	Object
    //   632	43	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   351	243	2	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   0	99	547	java/lang/Exception
    //   99	140	547	java/lang/Exception
    //   140	178	547	java/lang/Exception
    //   178	206	547	java/lang/Exception
    //   206	233	547	java/lang/Exception
    //   233	329	547	java/lang/Exception
    //   329	337	547	java/lang/Exception
    //   341	379	547	java/lang/Exception
    //   379	416	547	java/lang/Exception
    //   416	420	547	java/lang/Exception
    //   420	458	547	java/lang/Exception
    //   458	528	547	java/lang/Exception
    //   529	544	547	java/lang/Exception
    //   583	610	547	java/lang/Exception
    //   613	629	547	java/lang/Exception
    //   633	672	547	java/lang/Exception
    //   672	678	547	java/lang/Exception
    //   341	379	632	java/lang/OutOfMemoryError
    //   379	416	632	java/lang/OutOfMemoryError
    //   416	420	632	java/lang/OutOfMemoryError
    //   583	610	632	java/lang/OutOfMemoryError
    //   613	629	632	java/lang/OutOfMemoryError
  }
  
  public void btD()
  {
    if (this.jdField_a_of_type_Amal != null) {
      this.jdField_a_of_type_Amal.btD();
    }
  }
  
  public void dJU()
  {
    ram.w("Richard", "cancelEncode");
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "cancelEncode");
    }
    this.canceled = true;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder.stopDecode();
  }
  
  public void fp(long paramLong)
    throws InterruptedException
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeFrame wait timestamp = " + paramLong);
    }
    synchronized (this.eA)
    {
      if (this.aim >= paramLong)
      {
        this.cBG = true;
        QLog.e("Mp4ReEncoder", 2, "mLastDecodeTimestamp >= timestampNanos; mLastDecodeTimestamp = " + this.aim + " timestampNanos = " + paramLong);
        return;
      }
      this.cBG = false;
      this.aim = paramLong;
    }
    synchronized (this.eB)
    {
      this.eB.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("Mp4ReEncoder", 2, "onDecodeFrame start timestamp = " + paramLong);
      }
      try
      {
        this.eA.wait(2000L);
        if ((!this.mFrameAvailable) && (this.mErrorCode == 0) && (!this.canceled)) {
          a(3, new RuntimeException("frame wait timed out"));
        }
        if (QLog.isColorLevel()) {
          QLog.d("Mp4ReEncoder", 2, "onDecodeFrame end timestamp = " + paramLong);
        }
        this.mFrameAvailable = false;
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        if (!QLog.isColorLevel()) {
          break label274;
        }
        QLog.d("Mp4ReEncoder", 2, "onDecodeFrame InterruptedException");
        this.mFrameAvailable = false;
        throw localInterruptedException;
      }
      localObject3 = finally;
      throw localObject3;
    }
  }
  
  public void kf(String paramString)
  {
    if (this.jdField_a_of_type_Amal != null) {
      this.jdField_a_of_type_Amal.kf(paramString);
    }
    if (this.mWatermarkTextureIdForEncode != -1)
    {
      GlUtil.deleteTexture(this.mWatermarkTextureIdForEncode);
      this.mWatermarkTextureIdForEncode = -1;
    }
    if (this.textureId != -1)
    {
      GlUtil.deleteTexture(this.textureId);
      this.textureId = -1;
    }
    GlUtil.deleteTexture(this.textureId);
    dLM();
    this.mRenderFBO.destroy();
  }
  
  public void onDecodeCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_b_of_type_Aman.stopRecording();
  }
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    a(paramInt + 10000, paramThrowable);
  }
  
  public void onDecodeFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeFinish");
    }
    this.cBH = true;
    this.jdField_b_of_type_Aman.stopRecording();
  }
  
  public void onDecodeRepeat() {}
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeStart");
    }
    this.cBH = false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.ain >= this.aim) && (!this.cBG) && (!this.cBH))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Mp4ReEncoder", 2, "onFrameAvailable wait onDecodeFrame. mLastAvailableTimestamp = " + this.ain + " , mLastDecodeTimestamp " + this.aim);
      }
      try
      {
        synchronized (this.eB)
        {
          this.eB.wait(5L);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    if (this.cBG)
    {
      QLog.e("Mp4ReEncoder", 2, "onFrameAvailable skipDecode");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onFrameAvailable wait");
    }
    synchronized (this.eA)
    {
      if ((this.canceled) || (this.mErrorCode != 0) || (this.cBH))
      {
        this.mFrameAvailable = true;
        this.eA.notifyAll();
        QLog.w("Mp4ReEncoder", 2, "onFrameAvailable error=" + this.mErrorCode + " ; canceled=" + this.canceled + "; stopped=" + this.cBH);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onFrameAvailable start");
    }
    if (this.mFrameAvailable) {
      a(5, new RuntimeException("mFrameAvailable already set, frame could be dropped"));
    }
    label754:
    for (;;)
    {
      try
      {
        paramSurfaceTexture.updateTexImage();
        this.ain = this.aim;
        if (QLog.isColorLevel()) {
          QLog.d("Mp4ReEncoder", 2, "onFrameAvailable timestap = " + this.ain);
        }
        float[] arrayOfFloat = new float[16];
        paramSurfaceTexture.getTransformMatrix(arrayOfFloat);
        ??? = this.mRenderFBO;
        this.mRenderFBO.bind();
        this.mEncodeGPUOESFilter.drawTexture(this.textureId, null, null);
        paramSurfaceTexture = (SurfaceTexture)???;
        if (this.jdField_a_of_type_Amba != null)
        {
          this.mRenderFBO.unbind();
          this.jdField_a_of_type_Amba.drawTexture(((RenderBuffer)???).getTexId(), null, null);
          paramSurfaceTexture = this.jdField_a_of_type_Amba.a();
          paramSurfaceTexture.bind();
        }
        if ((this.c != null) && (this.jdField_b_of_type_Aatn != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Mp4ReEncoder", 2, "subtitle encoder begin");
          }
          paramSurfaceTexture.unbind();
          if (!this.jdField_b_of_type_Aatn.bA(this.ain / 1000000L)) {
            break label754;
          }
          paramSurfaceTexture.bind();
          i = this.jdField_b_of_type_Aatn.zf();
          if (i >= 0)
          {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            this.c.drawTexture(i, null, null);
            GLES20.glDisable(3042);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Mp4ReEncoder", 2, "subtitle draw texture end");
          }
        }
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null)
        {
          ??? = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_a_of_type_Amae.width, this.jdField_a_of_type_Amae.height, this.mWatermarkWidth, this.mWatermarkHeight);
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(this.mWatermarkTextureIdForEncode, null, (float[])???);
          GLES20.glDisable(3042);
        }
        if (this.jdField_a_of_type_Amah$a != null) {
          this.jdField_a_of_type_Amah$a.onRenderFrame();
        }
        paramSurfaceTexture.unbind();
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(paramSurfaceTexture.getTexId(), arrayOfFloat, null);
        this.jdField_b_of_type_Aman.f(3553, paramSurfaceTexture.getTexId(), arrayOfFloat, null, this.ain);
        int i = 1;
        if (i > this.dBg) {
          break;
        }
        this.jdField_b_of_type_Aman.f(3553, paramSurfaceTexture.getTexId(), arrayOfFloat, null, this.ain + i * 5 * 1000);
        i += 1;
        continue;
        paramSurfaceTexture.bind();
      }
      catch (Exception paramSurfaceTexture)
      {
        this.mFrameAvailable = true;
        this.eA.notifyAll();
        QLog.w("Mp4ReEncoder", 2, "onFrameAvailable error=" + this.mErrorCode + " ; canceled=" + this.canceled, paramSurfaceTexture);
        return;
      }
    }
    this.mFrameAvailable = true;
    this.eA.notifyAll();
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onFrameAvailable end");
    }
  }
  
  public static abstract interface a
  {
    public abstract void onRenderFrame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amah
 * JD-Core Version:    0.7.0.1
 */