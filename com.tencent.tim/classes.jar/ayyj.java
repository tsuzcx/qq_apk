import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.pkvideo.PKFilter;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import java.util.ArrayList;

@TargetApi(11)
public class ayyj
  implements amal, SurfaceTexture.OnFrameAvailableListener, HWDecodeListener
{
  private ArrayList<DynamicStickerData> GH;
  private ArrayList<TrackerStickerParam> GI;
  protected amae a;
  private amal jdField_a_of_type_Amal;
  private ayyj.a jdField_a_of_type_Ayyj$a;
  private ayyv jdField_a_of_type_Ayyv;
  ayyy jdField_a_of_type_Ayyy;
  private ayyz jdField_a_of_type_Ayyz;
  private ayza jdField_a_of_type_Ayza;
  private PKFilter jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter;
  private long aDm = -1L;
  private long aDn = -1L;
  private long aim = -1L;
  private long ain = -1L;
  protected aman b;
  protected DecodeConfig b;
  private boolean cBH;
  private boolean canceled;
  private boolean dBY;
  private boolean dBZ;
  public int dBg;
  private Object eA = new Object();
  private Object eB = new Object();
  private QQFilterRenderManager g;
  protected HWVideoDecoder hwVideoDecoder = new HWVideoDecoder();
  private RenderBuffer l;
  private GPUOESBaseFilter mEncodeGPUOESFilter;
  public int mErrorCode = 0;
  private boolean mFrameAvailable;
  private RenderBuffer mRenderFBO;
  private TransferData mTransferData;
  private GPUAlphaBlendFilter mWatermarkFilter;
  private int mWatermarkHeight;
  private int mWatermarkTextureIdForEncode = -1;
  private int mWatermarkWidth;
  private int textureId;
  
  public ayyj()
  {
    this.jdField_b_of_type_Aman = new aman();
  }
  
  private void dLM()
  {
    this.mEncodeGPUOESFilter.destroy();
    if (this.jdField_a_of_type_Ayyz != null) {
      this.jdField_a_of_type_Ayyz.onSurfaceDestroy();
    }
    if (this.jdField_a_of_type_Ayyv != null) {
      this.jdField_a_of_type_Ayyv.destroy();
    }
    if (this.mWatermarkFilter != null) {
      this.mWatermarkFilter.destroy();
    }
    if (this.jdField_a_of_type_Ayyy != null) {
      this.jdField_a_of_type_Ayyy.onSurfaceDestroy();
    }
    if (this.jdField_a_of_type_Ayza != null) {
      this.jdField_a_of_type_Ayza.onSurfaceDestroy();
    }
  }
  
  public HWVideoDecoder a()
  {
    return this.hwVideoDecoder;
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    this.mErrorCode = paramInt;
    this.hwVideoDecoder.stopDecode();
    if (this.jdField_a_of_type_Amal != null) {
      this.jdField_a_of_type_Amal.a(paramInt, paramThrowable);
    }
  }
  
  public void a(DecodeConfig paramDecodeConfig, amae paramamae, amal paramamal, ayyj.a parama)
  {
    this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig = paramDecodeConfig;
    this.jdField_a_of_type_Amae = paramamae;
    if ((paramDecodeConfig.speedType == 1) || (paramDecodeConfig.speedType == 3)) {
      this.dBZ = true;
    }
    if ((paramamae.cBD) && (paramamae.b != null) && (!TextUtils.isEmpty(paramamae.b.videoPath)))
    {
      FeatureManager.loadBasicFeatures();
      atao.init();
      awtj.init();
      VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.z());
      BadcaseReportUtils.registerReport(new alxf());
    }
    this.jdField_a_of_type_Amal = paramamal;
    this.jdField_a_of_type_Ayyj$a = parama;
    this.jdField_b_of_type_Aman.a(paramamae, this);
    this.canceled = false;
  }
  
  public void a(PKFilter paramPKFilter)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter = paramPKFilter;
  }
  
  public void adI(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.mTransferData = new TransferData();
      this.mTransferData.fromJSONObject(paramString);
    }
  }
  
  /* Error */
  public void auv()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 242
    //   3: invokestatic 248	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:createTexture	(I)I
    //   6: putfield 250	ayyj:textureId	I
    //   9: aload_0
    //   10: new 252	com/tencent/ttpic/openapi/filter/RenderBuffer
    //   13: dup
    //   14: aload_0
    //   15: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   18: getfield 255	amae:width	I
    //   21: aload_0
    //   22: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   25: getfield 258	amae:height	I
    //   28: ldc_w 259
    //   31: invokespecial 262	com/tencent/ttpic/openapi/filter/RenderBuffer:<init>	(III)V
    //   34: putfield 264	ayyj:mRenderFBO	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   37: aload_0
    //   38: new 252	com/tencent/ttpic/openapi/filter/RenderBuffer
    //   41: dup
    //   42: aload_0
    //   43: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   46: getfield 255	amae:width	I
    //   49: aload_0
    //   50: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   53: getfield 258	amae:height	I
    //   56: ldc_w 259
    //   59: invokespecial 262	com/tencent/ttpic/openapi/filter/RenderBuffer:<init>	(III)V
    //   62: putfield 266	ayyj:l	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   65: aload_0
    //   66: bipush 102
    //   68: invokestatic 271	ayyl:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   71: checkcast 104	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter
    //   74: putfield 102	ayyj:mEncodeGPUOESFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   77: aload_0
    //   78: getfield 102	ayyj:mEncodeGPUOESFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   81: aload_0
    //   82: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   85: getfield 255	amae:width	I
    //   88: aload_0
    //   89: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   92: getfield 258	amae:height	I
    //   95: invokevirtual 275	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:onOutputSizeChanged	(II)V
    //   98: aload_0
    //   99: getfield 102	ayyj:mEncodeGPUOESFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   102: invokevirtual 276	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:init	()V
    //   105: aload_0
    //   106: getfield 146	ayyj:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   109: getfield 279	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLocal	Z
    //   112: ifeq +94 -> 206
    //   115: aload_0
    //   116: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   119: getfield 282	amae:cBC	Z
    //   122: ifeq +84 -> 206
    //   125: aload_0
    //   126: getfield 146	ayyj:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   129: getfield 285	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLandscape	Z
    //   132: ifeq +826 -> 958
    //   135: bipush 166
    //   137: istore_1
    //   138: aload_0
    //   139: new 111	ayyz
    //   142: dup
    //   143: iload_1
    //   144: invokespecial 288	ayyz:<init>	(I)V
    //   147: putfield 109	ayyj:jdField_a_of_type_Ayyz	Layyz;
    //   150: aload_0
    //   151: getfield 109	ayyj:jdField_a_of_type_Ayyz	Layyz;
    //   154: aload_0
    //   155: getfield 146	ayyj:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   158: getfield 289	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:width	I
    //   161: aload_0
    //   162: getfield 146	ayyj:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   165: getfield 290	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:height	I
    //   168: aload_0
    //   169: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   172: getfield 255	amae:width	I
    //   175: aload_0
    //   176: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   179: getfield 258	amae:height	I
    //   182: invokevirtual 294	ayyz:ac	(IIII)V
    //   185: aload_0
    //   186: getfield 109	ayyj:jdField_a_of_type_Ayyz	Layyz;
    //   189: aload_0
    //   190: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   193: getfield 255	amae:width	I
    //   196: aload_0
    //   197: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   200: getfield 258	amae:height	I
    //   203: invokevirtual 297	ayyz:onSurfaceChange	(II)V
    //   206: aload_0
    //   207: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   210: getfield 300	amae:filterType	I
    //   213: invokestatic 304	ayyl:lb	(I)Z
    //   216: ifne +13 -> 229
    //   219: aload_0
    //   220: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   223: getfield 307	amae:mosaicPath	Ljava/lang/String;
    //   226: ifnull +112 -> 338
    //   229: aload_0
    //   230: new 118	ayyv
    //   233: dup
    //   234: invokespecial 308	ayyv:<init>	()V
    //   237: putfield 116	ayyj:jdField_a_of_type_Ayyv	Layyv;
    //   240: aload_0
    //   241: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   244: getfield 300	amae:filterType	I
    //   247: invokestatic 304	ayyl:lb	(I)Z
    //   250: ifeq +20 -> 270
    //   253: aload_0
    //   254: getfield 116	ayyj:jdField_a_of_type_Ayyv	Layyv;
    //   257: aload_0
    //   258: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   261: getfield 300	amae:filterType	I
    //   264: invokestatic 271	ayyl:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   267: invokevirtual 311	ayyv:a	(Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;)V
    //   270: aload_0
    //   271: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   274: getfield 307	amae:mosaicPath	Ljava/lang/String;
    //   277: astore_2
    //   278: aload_2
    //   279: ifnull +31 -> 310
    //   282: bipush 106
    //   284: invokestatic 271	ayyl:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   287: astore_2
    //   288: aload_2
    //   289: checkcast 313	ayyq
    //   292: aload_0
    //   293: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   296: getfield 307	amae:mosaicPath	Ljava/lang/String;
    //   299: invokevirtual 316	ayyq:Pv	(Ljava/lang/String;)V
    //   302: aload_0
    //   303: getfield 116	ayyj:jdField_a_of_type_Ayyv	Layyv;
    //   306: aload_2
    //   307: invokevirtual 311	ayyv:a	(Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;)V
    //   310: aload_0
    //   311: getfield 116	ayyj:jdField_a_of_type_Ayyv	Layyv;
    //   314: aload_0
    //   315: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   318: getfield 255	amae:width	I
    //   321: aload_0
    //   322: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   325: getfield 258	amae:height	I
    //   328: invokevirtual 317	ayyv:onOutputSizeChanged	(II)V
    //   331: aload_0
    //   332: getfield 116	ayyj:jdField_a_of_type_Ayyv	Layyv;
    //   335: invokevirtual 318	ayyv:init	()V
    //   338: aload_0
    //   339: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   342: getfield 321	amae:watermarkPath	Ljava/lang/String;
    //   345: astore_2
    //   346: aload_2
    //   347: ifnull +127 -> 474
    //   350: aload_0
    //   351: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   354: getfield 321	amae:watermarkPath	Ljava/lang/String;
    //   357: invokestatic 327	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   360: astore_3
    //   361: aload_0
    //   362: getfield 146	ayyj:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   365: getfield 279	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLocal	Z
    //   368: ifeq +517 -> 885
    //   371: aload_3
    //   372: astore_2
    //   373: aload_0
    //   374: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   377: getfield 330	amae:cBF	Z
    //   380: ifeq +24 -> 404
    //   383: aload_3
    //   384: astore_2
    //   385: aload_3
    //   386: invokevirtual 336	android/graphics/Bitmap:getWidth	()I
    //   389: aload_3
    //   390: invokevirtual 339	android/graphics/Bitmap:getHeight	()I
    //   393: if_icmple +11 -> 404
    //   396: aload_3
    //   397: ldc_w 340
    //   400: invokestatic 346	rpq:rotateBitmap	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   403: astore_2
    //   404: aload_0
    //   405: sipush 3553
    //   408: aload_2
    //   409: invokestatic 349	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:createTexture	(ILandroid/graphics/Bitmap;)I
    //   412: putfield 88	ayyj:mWatermarkTextureIdForEncode	I
    //   415: aload_0
    //   416: aload_2
    //   417: invokevirtual 336	android/graphics/Bitmap:getWidth	()I
    //   420: putfield 351	ayyj:mWatermarkWidth	I
    //   423: aload_0
    //   424: aload_2
    //   425: invokevirtual 339	android/graphics/Bitmap:getHeight	()I
    //   428: putfield 353	ayyj:mWatermarkHeight	I
    //   431: aload_2
    //   432: invokevirtual 356	android/graphics/Bitmap:recycle	()V
    //   435: aload_0
    //   436: new 123	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter
    //   439: dup
    //   440: invokespecial 357	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter:<init>	()V
    //   443: putfield 121	ayyj:mWatermarkFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter;
    //   446: aload_0
    //   447: getfield 121	ayyj:mWatermarkFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter;
    //   450: aload_0
    //   451: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   454: getfield 255	amae:width	I
    //   457: aload_0
    //   458: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   461: getfield 258	amae:height	I
    //   464: invokevirtual 358	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter:onOutputSizeChanged	(II)V
    //   467: aload_0
    //   468: getfield 121	ayyj:mWatermarkFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter;
    //   471: invokevirtual 359	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter:init	()V
    //   474: aload_0
    //   475: new 361	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager
    //   478: dup
    //   479: invokespecial 362	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:<init>	()V
    //   482: putfield 364	ayyj:g	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   485: aload_0
    //   486: getfield 364	ayyj:g	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   489: invokevirtual 368	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:getChainBuilder	()Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager$ChainBuilder;
    //   492: astore_2
    //   493: aload_2
    //   494: iconst_1
    //   495: invokevirtual 374	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager$ChainBuilder:setUseSort	(Z)V
    //   498: aload_0
    //   499: getfield 376	ayyj:GH	Ljava/util/ArrayList;
    //   502: ifnull +20 -> 522
    //   505: aload_0
    //   506: getfield 376	ayyj:GH	Ljava/util/ArrayList;
    //   509: invokevirtual 381	java/util/ArrayList:size	()I
    //   512: ifle +10 -> 522
    //   515: aload_2
    //   516: bipush 120
    //   518: aconst_null
    //   519: invokevirtual 385	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager$ChainBuilder:addFilter	(ILjava/lang/Object;)V
    //   522: aload_0
    //   523: getfield 387	ayyj:GI	Ljava/util/ArrayList;
    //   526: ifnull +10 -> 536
    //   529: aload_2
    //   530: bipush 110
    //   532: aconst_null
    //   533: invokevirtual 385	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager$ChainBuilder:addFilter	(ILjava/lang/Object;)V
    //   536: aload_2
    //   537: invokevirtual 390	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager$ChainBuilder:commit	()V
    //   540: aload_0
    //   541: getfield 364	ayyj:g	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   544: invokevirtual 394	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:getBusinessOperation	()Lcom/tencent/mobileqq/shortvideo/filter/FilterBusinessOperation;
    //   547: aload_0
    //   548: getfield 376	ayyj:GH	Ljava/util/ArrayList;
    //   551: invokevirtual 400	com/tencent/mobileqq/shortvideo/filter/FilterBusinessOperation:setDynamicStickerParam	(Ljava/util/List;)V
    //   554: aload_0
    //   555: getfield 364	ayyj:g	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   558: invokevirtual 394	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:getBusinessOperation	()Lcom/tencent/mobileqq/shortvideo/filter/FilterBusinessOperation;
    //   561: aload_0
    //   562: getfield 387	ayyj:GI	Ljava/util/ArrayList;
    //   565: invokevirtual 404	com/tencent/mobileqq/shortvideo/filter/FilterBusinessOperation:setTrackerStickerParam	(Ljava/util/ArrayList;)V
    //   568: aload_0
    //   569: getfield 364	ayyj:g	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   572: aload_0
    //   573: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   576: getfield 255	amae:width	I
    //   579: aload_0
    //   580: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   583: getfield 258	amae:height	I
    //   586: aload_0
    //   587: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   590: getfield 255	amae:width	I
    //   593: aload_0
    //   594: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   597: getfield 258	amae:height	I
    //   600: invokevirtual 407	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:surfaceCreate	(IIII)V
    //   603: aload_0
    //   604: getfield 218	ayyj:jdField_a_of_type_Ayyj$a	Layyj$a;
    //   607: ifnull +40 -> 647
    //   610: aload_0
    //   611: getfield 218	ayyj:jdField_a_of_type_Ayyj$a	Layyj$a;
    //   614: aload_0
    //   615: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   618: getfield 255	amae:width	I
    //   621: aload_0
    //   622: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   625: getfield 258	amae:height	I
    //   628: aload_0
    //   629: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   632: getfield 255	amae:width	I
    //   635: aload_0
    //   636: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   639: getfield 258	amae:height	I
    //   642: invokeinterface 408 5 0
    //   647: aload_0
    //   648: getfield 364	ayyj:g	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   651: invokevirtual 394	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:getBusinessOperation	()Lcom/tencent/mobileqq/shortvideo/filter/FilterBusinessOperation;
    //   654: aload_0
    //   655: getfield 146	ayyj:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   658: getfield 411	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:startTimeMillSecond	J
    //   661: invokevirtual 415	com/tencent/mobileqq/shortvideo/filter/FilterBusinessOperation:setVideoStartTime	(J)V
    //   664: aload_0
    //   665: getfield 233	ayyj:mTransferData	Lcom/tencent/mobileqq/shortvideo/videotransfer/TransferData;
    //   668: ifnull +133 -> 801
    //   671: aload_0
    //   672: getfield 364	ayyj:g	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   675: sipush 160
    //   678: invokevirtual 418	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:hasQQFilter	(I)Z
    //   681: ifne +272 -> 953
    //   684: aload_0
    //   685: getfield 364	ayyj:g	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   688: sipush 160
    //   691: aconst_null
    //   692: invokevirtual 422	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:pushChainBasedStackTopChain	(ILjava/lang/Object;)Ljava/lang/String;
    //   695: pop
    //   696: aload_0
    //   697: getfield 364	ayyj:g	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   700: sipush 160
    //   703: invokevirtual 426	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:getQQFilterByType	(I)Lcom/tencent/mobileqq/shortvideo/filter/QQBaseFilter;
    //   706: checkcast 428	com/tencent/mobileqq/shortvideo/filter/QQTransferFilter
    //   709: astore_2
    //   710: aload_2
    //   711: astore_3
    //   712: aload_2
    //   713: ifnonnull +62 -> 775
    //   716: aload_0
    //   717: getfield 364	ayyj:g	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   720: sipush 160
    //   723: invokevirtual 432	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:getQQFilters	(I)Ljava/util/List;
    //   726: astore 4
    //   728: aload_2
    //   729: astore_3
    //   730: aload 4
    //   732: ifnull +43 -> 775
    //   735: aload_2
    //   736: astore_3
    //   737: aload 4
    //   739: invokeinterface 435 1 0
    //   744: ifle +31 -> 775
    //   747: aload_2
    //   748: astore_3
    //   749: aload 4
    //   751: iconst_0
    //   752: invokeinterface 439 2 0
    //   757: instanceof 428
    //   760: ifeq +15 -> 775
    //   763: aload 4
    //   765: iconst_0
    //   766: invokeinterface 439 2 0
    //   771: checkcast 428	com/tencent/mobileqq/shortvideo/filter/QQTransferFilter
    //   774: astore_3
    //   775: aload_3
    //   776: ifnull +25 -> 801
    //   779: aload_3
    //   780: aload_0
    //   781: getfield 233	ayyj:mTransferData	Lcom/tencent/mobileqq/shortvideo/videotransfer/TransferData;
    //   784: invokevirtual 443	com/tencent/mobileqq/shortvideo/filter/QQTransferFilter:setTransferData	(Lcom/tencent/mobileqq/shortvideo/videotransfer/TransferData;)V
    //   787: aload_3
    //   788: aload_0
    //   789: getfield 146	ayyj:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   792: getfield 153	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:speedType	I
    //   795: invokestatic 447	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder:getSpeedRate	(I)F
    //   798: invokevirtual 451	com/tencent/mobileqq/shortvideo/filter/QQTransferFilter:setSpeedRate	(F)V
    //   801: aload_0
    //   802: getfield 98	ayyj:hwVideoDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder;
    //   805: aload_0
    //   806: getfield 146	ayyj:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   809: aload_0
    //   810: getfield 250	ayyj:textureId	I
    //   813: aload_0
    //   814: aload_0
    //   815: invokevirtual 455	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder:startDecode	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;ILandroid/graphics/SurfaceTexture$OnFrameAvailableListener;Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWDecodeListener;)V
    //   818: aload_0
    //   819: getfield 141	ayyj:jdField_a_of_type_Amal	Lamal;
    //   822: ifnull +141 -> 963
    //   825: aload_0
    //   826: getfield 141	ayyj:jdField_a_of_type_Amal	Lamal;
    //   829: invokeinterface 457 1 0
    //   834: return
    //   835: astore_2
    //   836: ldc_w 459
    //   839: iconst_1
    //   840: ldc_w 461
    //   843: aload_2
    //   844: invokestatic 467	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   847: goto -537 -> 310
    //   850: astore_2
    //   851: aload_0
    //   852: iconst_4
    //   853: aload_2
    //   854: invokevirtual 468	ayyj:a	(ILjava/lang/Throwable;)V
    //   857: ldc_w 459
    //   860: iconst_1
    //   861: new 470	java/lang/StringBuilder
    //   864: dup
    //   865: invokespecial 471	java/lang/StringBuilder:<init>	()V
    //   868: ldc_w 473
    //   871: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: aload_2
    //   875: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   878: invokevirtual 484	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   881: invokestatic 487	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   884: return
    //   885: aload_3
    //   886: sipush 360
    //   889: aload_0
    //   890: getfield 146	ayyj:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   893: getfield 490	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:adjustRotation	I
    //   896: isub
    //   897: i2f
    //   898: invokestatic 346	rpq:rotateBitmap	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   901: astore_2
    //   902: goto -498 -> 404
    //   905: astore_2
    //   906: invokestatic 493	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   909: ifeq +37 -> 946
    //   912: ldc_w 459
    //   915: iconst_2
    //   916: new 470	java/lang/StringBuilder
    //   919: dup
    //   920: invokespecial 471	java/lang/StringBuilder:<init>	()V
    //   923: ldc_w 495
    //   926: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: aload_0
    //   930: getfield 148	ayyj:jdField_a_of_type_Amae	Lamae;
    //   933: getfield 321	amae:watermarkPath	Ljava/lang/String;
    //   936: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: invokevirtual 484	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   942: aload_2
    //   943: invokestatic 467	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   946: aload_0
    //   947: iconst_1
    //   948: aload_2
    //   949: invokevirtual 468	ayyj:a	(ILjava/lang/Throwable;)V
    //   952: return
    //   953: aconst_null
    //   954: astore_2
    //   955: goto -245 -> 710
    //   958: iconst_0
    //   959: istore_1
    //   960: goto -822 -> 138
    //   963: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	964	0	this	ayyj
    //   137	823	1	i	int
    //   277	471	2	localObject1	Object
    //   835	9	2	localException1	Exception
    //   850	25	2	localException2	Exception
    //   901	1	2	localBitmap	android.graphics.Bitmap
    //   905	44	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   954	1	2	localObject2	Object
    //   360	526	3	localObject3	Object
    //   726	38	4	localList	java.util.List
    // Exception table:
    //   from	to	target	type
    //   282	310	835	java/lang/Exception
    //   0	135	850	java/lang/Exception
    //   138	206	850	java/lang/Exception
    //   206	229	850	java/lang/Exception
    //   229	270	850	java/lang/Exception
    //   270	278	850	java/lang/Exception
    //   310	338	850	java/lang/Exception
    //   338	346	850	java/lang/Exception
    //   350	371	850	java/lang/Exception
    //   373	383	850	java/lang/Exception
    //   385	404	850	java/lang/Exception
    //   404	435	850	java/lang/Exception
    //   435	474	850	java/lang/Exception
    //   474	522	850	java/lang/Exception
    //   522	536	850	java/lang/Exception
    //   536	647	850	java/lang/Exception
    //   647	710	850	java/lang/Exception
    //   716	728	850	java/lang/Exception
    //   737	747	850	java/lang/Exception
    //   749	775	850	java/lang/Exception
    //   779	801	850	java/lang/Exception
    //   801	834	850	java/lang/Exception
    //   836	847	850	java/lang/Exception
    //   885	902	850	java/lang/Exception
    //   906	946	850	java/lang/Exception
    //   946	952	850	java/lang/Exception
    //   350	371	905	java/lang/OutOfMemoryError
    //   373	383	905	java/lang/OutOfMemoryError
    //   385	404	905	java/lang/OutOfMemoryError
    //   404	435	905	java/lang/OutOfMemoryError
    //   885	902	905	java/lang/OutOfMemoryError
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
    this.mErrorCode = 6;
    this.hwVideoDecoder.stopDecode();
  }
  
  public void fF(ArrayList<DynamicStickerData> paramArrayList)
  {
    this.GH = paramArrayList;
  }
  
  public void fG(ArrayList<TrackerStickerParam> paramArrayList)
  {
    this.GI = paramArrayList;
  }
  
  public boolean isFinished()
  {
    return this.jdField_b_of_type_Aman.isFinished();
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
    this.g.surfaceDestroyed();
    if (this.textureId != -1)
    {
      GlUtil.deleteTexture(this.textureId);
      this.textureId = -1;
    }
    GlUtil.deleteTexture(this.textureId);
    dLM();
    this.mRenderFBO.destroy();
    this.l.destroy();
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
    this.cBH = true;
    this.mErrorCode = (paramInt + 10000);
    this.jdField_b_of_type_Aman.stopRecording();
    if (this.jdField_a_of_type_Amal != null) {
      this.jdField_a_of_type_Amal.a(this.mErrorCode, paramThrowable);
    }
  }
  
  public void onDecodeFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeFinish");
    }
    this.cBH = true;
    this.jdField_b_of_type_Aman.stopRecording();
  }
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
    throws InterruptedException
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeFrame wait timestamp = " + paramLong1 + " orgSampleTime: " + paramLong2);
    }
    synchronized (this.eA)
    {
      this.aim = paramLong1;
      this.aDm = paramLong2;
      synchronized (this.eB)
      {
        this.eB.notifyAll();
        if (QLog.isColorLevel()) {
          QLog.d("Mp4ReEncoder", 2, "onDecodeFrame start timestamp = " + paramLong1);
        }
      }
    }
  }
  
  public void onDecodeRepeat()
  {
    if ((this.jdField_a_of_type_Ayyj$a.getQQFilterRenderManager() != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter.onFilterDecodeRepeat();
    }
  }
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart()
  {
    this.cBH = false;
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeStart");
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.ain >= this.aim) && (!this.cBH))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Mp4ReEncoder", 2, "onFrameAvailable wait onDecodeFrame. mLastAvailableTimestamp = " + this.ain + ", mLastDecodeTimestamp " + this.aim + ", mLastDecodeSampleTimestamp :" + this.aDm);
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
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onFrameAvailable wait");
    }
    for (;;)
    {
      synchronized (this.eA)
      {
        if ((this.canceled) || (this.mErrorCode != 0) || (this.cBH))
        {
          this.mFrameAvailable = true;
          this.eA.notifyAll();
          QLog.w("Mp4ReEncoder", 2, "onFrameAvailable error=" + this.mErrorCode + "; canceled=" + this.canceled + "; stopped=" + this.cBH);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Mp4ReEncoder", 2, "onFrameAvailable start");
        }
        if (this.mFrameAvailable) {
          a(5, new RuntimeException("mFrameAvailable already set, frame could be dropped"));
        }
        try
        {
          paramSurfaceTexture.updateTexImage();
          this.ain = this.aim;
          if (QLog.isColorLevel()) {
            QLog.d("Mp4ReEncoder", 2, "onFrameAvailable timestap = " + this.ain);
          }
          float[] arrayOfFloat1 = new float[16];
          paramSurfaceTexture.getTransformMatrix(arrayOfFloat1);
          paramSurfaceTexture = this.mRenderFBO;
          this.mRenderFBO.recoverInitialTexId();
          float[] arrayOfFloat2 = new float[16];
          Matrix.setIdentityM(arrayOfFloat2, 0);
          Matrix.rotateM(arrayOfFloat2, 0, this.jdField_a_of_type_Amae.adjustRotation, 0.0F, 0.0F, 1.0F);
          Matrix.scaleM(arrayOfFloat2, 0, 1.0F, -1.0F, 1.0F);
          this.mRenderFBO.bind();
          this.mEncodeGPUOESFilter.drawTexture(this.textureId, arrayOfFloat1, arrayOfFloat2);
          this.mRenderFBO.unbind();
          if (this.jdField_a_of_type_Amae.cBD)
          {
            paramSurfaceTexture.unbind();
            if (this.jdField_a_of_type_Ayyy == null)
            {
              this.jdField_a_of_type_Ayyy = new ayyy();
              this.jdField_a_of_type_Ayyy.a(this.jdField_a_of_type_Amae.b);
              this.jdField_a_of_type_Ayyy.setVideoSize(this.jdField_a_of_type_Amae.dBd, this.jdField_a_of_type_Amae.dBe);
              this.jdField_a_of_type_Ayyy.onSurfaceCreate();
              this.jdField_a_of_type_Ayyy.onSurfaceChange(this.jdField_a_of_type_Amae.width, this.jdField_a_of_type_Amae.height);
            }
            this.jdField_a_of_type_Ayyy.setInputTextureID(paramSurfaceTexture.getTexId());
            this.jdField_a_of_type_Ayyy.onDrawFrame();
            i = this.jdField_a_of_type_Ayyy.getOutputTextureID();
            if (i != -1) {
              paramSurfaceTexture.setTexId(i);
            }
            paramSurfaceTexture.bind();
          }
          if (this.jdField_a_of_type_Amae.cBE)
          {
            if (this.jdField_a_of_type_Ayza == null)
            {
              if (!this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.isLandscape) {
                break label1142;
              }
              i = -90;
              this.jdField_a_of_type_Ayza = new ayza(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Amae.bZF, i);
              this.jdField_a_of_type_Ayza.ac(this.jdField_a_of_type_Amae.dBd, this.jdField_a_of_type_Amae.dBe, this.jdField_a_of_type_Amae.width, this.jdField_a_of_type_Amae.height);
            }
            i = this.jdField_a_of_type_Ayza.mh(paramSurfaceTexture.getTexId());
            if (i != -1) {
              paramSurfaceTexture.setTexId(i);
            }
          }
          if (this.jdField_a_of_type_Ayyz != null)
          {
            paramSurfaceTexture.bind();
            i = this.jdField_a_of_type_Ayyz.mh(paramSurfaceTexture.getTexId());
            if (i != -1) {
              paramSurfaceTexture.setTexId(i);
            }
            paramSurfaceTexture.unbind();
          }
          if (this.jdField_a_of_type_Ayyj$a != null)
          {
            paramSurfaceTexture.bind();
            i = this.jdField_a_of_type_Ayyj$a.g(paramSurfaceTexture.getTexId(), this.ain);
            if (i != -1) {
              paramSurfaceTexture.setTexId(i);
            }
            paramSurfaceTexture.unbind();
          }
          if (this.jdField_a_of_type_Ayyv == null) {
            break label1139;
          }
          paramSurfaceTexture.bind();
          this.jdField_a_of_type_Ayyv.drawTexture(paramSurfaceTexture.getTexId(), null, null);
          paramSurfaceTexture = this.jdField_a_of_type_Ayyv.a();
          paramSurfaceTexture.unbind();
          paramSurfaceTexture.bind();
          if (this.mWatermarkFilter != null)
          {
            arrayOfFloat1 = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_a_of_type_Amae.width, this.jdField_a_of_type_Amae.height, this.mWatermarkWidth, this.mWatermarkHeight);
            this.mWatermarkFilter.drawTexture(this.mWatermarkTextureIdForEncode, null, arrayOfFloat1);
          }
          paramSurfaceTexture.unbind();
          long l2 = this.ain;
          long l1 = l2;
          if (!this.dBY)
          {
            this.dBY = true;
            l1 = l2;
            if (this.ain > 0L) {
              l1 = 0L;
            }
          }
          this.g.getBusinessOperation().SetTimeStamp(l1, this.aDm);
          paramSurfaceTexture.setTexId(this.g.drawFrame(paramSurfaceTexture.getTexId()));
          if ((!this.dBZ) || (this.aDn == -1L) || (this.ain - this.aDn >= 16666666L))
          {
            arrayOfFloat1 = new float[16];
            Matrix.setIdentityM(arrayOfFloat1, 0);
            Matrix.scaleM(arrayOfFloat1, 0, 1.0F, -1.0F, 1.0F);
            this.aDn = this.ain;
            this.jdField_b_of_type_Aman.f(3553, paramSurfaceTexture.getTexId(), null, arrayOfFloat1, this.ain);
            i = 1;
            if (i <= this.dBg)
            {
              this.jdField_b_of_type_Aman.f(3553, paramSurfaceTexture.getTexId(), null, arrayOfFloat1, this.ain + i * 5 * 1000);
              i += 1;
              continue;
              paramSurfaceTexture = finally;
            }
          }
        }
        catch (Exception paramSurfaceTexture)
        {
          paramSurfaceTexture.printStackTrace();
          this.mFrameAvailable = true;
          this.eA.notifyAll();
          QLog.w("Mp4ReEncoder", 2, "onFrameAvailable error=" + this.mErrorCode + " ; canceled=" + this.canceled);
          return;
        }
      }
      paramSurfaceTexture.recoverInitialTexId();
      this.mFrameAvailable = true;
      this.eA.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("Mp4ReEncoder", 2, "onFrameAvailable end");
      }
      return;
      label1139:
      continue;
      label1142:
      int i = 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract int g(int paramInt, long paramLong);
    
    public abstract QQFilterRenderManager getQQFilterRenderManager();
    
    public abstract void surfaceCreate(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayyj
 * JD-Core Version:    0.7.0.1
 */