import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.DoodleItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.view.RendererUtils;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityOperator.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class aymu
  extends ayml
{
  aymt jdField_a_of_type_Aymt = null;
  BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  boolean aHZ = false;
  boolean aIa = false;
  boolean aIb = false;
  public boolean aIc;
  boolean aId = true;
  boolean aIe = false;
  public boolean aIf;
  aymi jdField_b_of_type_Aymi;
  BaseFilter jdField_b_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  int brQ = 0;
  public int brR = this.mWidth;
  Frame e = new Frame();
  protected int[] ed = new int[2];
  int[] ee = new int[1];
  int[] ef = new int[1];
  int[] eg = new int[1];
  Frame f = new Frame();
  HashMap<String, VideoFilterBase> filterMap = new HashMap();
  Frame g = new Frame();
  protected double mAspectRatio = 0.75D;
  int mCount = 0;
  public int mHeight;
  Frame mTempFrame = new Frame();
  public int mWidth;
  int mWindowHeight = 480;
  int mWindowWidth = 320;
  VideoMaterial material;
  
  public aymu(aymi paramaymi)
  {
    this.jdField_b_of_type_Aymi = paramaymi;
  }
  
  public static VideoFilterBase a(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    do
    {
      return null;
      if ((paramVideoMaterial.getDoodleItem() == null) && (QLog.isColorLevel())) {
        QLog.w("PersonalityOperator", 2, "material.getDoodleItem is null!");
      }
      if (paramVideoMaterial.getShaderType() == 13) {
        return b(paramVideoMaterial);
      }
      if (paramVideoMaterial.getShaderType() == 15) {
        return c(paramVideoMaterial);
      }
    } while (paramVideoMaterial.getShaderType() != 14);
    return d(paramVideoMaterial);
  }
  
  static VideoFilterBase b(VideoMaterial paramVideoMaterial)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramVideoMaterial != null)
    {
      DoodleItem localDoodleItem = paramVideoMaterial.getDoodleItem();
      localObject1 = localObject2;
      if (localDoodleItem != null) {
        localObject1 = new ayms(localDoodleItem, paramVideoMaterial.getDataPath());
      }
    }
    return localObject1;
  }
  
  static VideoFilterBase c(VideoMaterial paramVideoMaterial)
  {
    return new aymq();
  }
  
  static VideoFilterBase d(VideoMaterial paramVideoMaterial)
  {
    return new aymr(paramVideoMaterial.getDoodleItem(), paramVideoMaterial.getDataPath());
  }
  
  public void ApplyGLSLFilter(String paramString)
  {
    if (this.filterMap.isEmpty()) {
      return;
    }
    paramString = (VideoFilterBase)this.filterMap.get(paramString);
    paramString.ApplyGLSLFilter();
    paramString.setRenderMode(1);
  }
  
  public void a(int paramInt1, int paramInt2, aymt paramaymt)
  {
    if ((this.filterMap == null) || (this.filterMap.size() < 1)) {
      return;
    }
    Frame localFrame = new Frame(this.e.getFBO(), this.e.getTextureId(), paramInt1, paramInt2);
    GlUtil.setBlendMode(true);
    GLES20.glBindFramebuffer(36160, this.e.getFBO());
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(paramaymt.mCacheFrame.getTextureId(), paramInt1, paramInt2, this.e.getTextureId(), 1.0D, localFrame);
    GlUtil.setBlendMode(false);
    paramaymt.aHV = true;
  }
  
  public void a(aymt paramaymt)
  {
    if ((paramaymt.aHX) && (paramaymt.aHV)) {}
    do
    {
      do
      {
        return;
      } while (this.aIa);
      if ((!paramaymt.aHV) && (paramaymt.UL))
      {
        if (paramaymt.aHW) {
          a(this.mWidth, this.mHeight, paramaymt);
        }
        this.aIe = true;
        return;
      }
    } while (paramaymt.w.size() <= 1);
    a(this.mTempFrame, this.mWidth, this.mHeight, paramaymt);
  }
  
  public void a(Frame paramFrame, int paramInt1, int paramInt2, aymt paramaymt)
  {
    if ((this.filterMap == null) || (this.filterMap.size() < 1)) {
      return;
    }
    GlUtil.setBlendMode(true);
    GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
    ArrayList localArrayList = new ArrayList();
    boolean bool = paramaymt.aHX;
    localArrayList.addAll(paramaymt.w);
    Object localObject = (VideoFilterBase)this.filterMap.get(paramaymt.mId);
    if ((localObject instanceof ayms))
    {
      localObject = (ayms)localObject;
      ((ayms)localObject).setTouchPoints(localArrayList);
      ((ayms)localObject).renderTexture(paramFrame.getTextureId(), paramInt1, paramInt2);
      if (bool)
      {
        this.e.bindFrame(this.ef[0], paramInt1, paramInt2, 1.0D);
        GLES20.glBindFramebuffer(36160, this.e.getFBO());
        GLES20.glViewport(0, 0, paramInt1, paramInt2);
        ((ayms)localObject).setTouchPoints(paramaymt.w);
        ((ayms)localObject).renderTexture(this.e.getTextureId(), paramInt1, paramInt2);
        paramaymt.buI();
      }
    }
    for (;;)
    {
      GlUtil.setBlendMode(false);
      if ((!paramaymt.aHX) || (!paramaymt.aHW)) {
        break;
      }
      paramFrame = paramaymt.b(paramInt1, paramInt2);
      t(paramFrame.getFBO(), paramFrame.getTextureId(), paramInt1, paramInt2);
      return;
      if ((localObject instanceof aymq))
      {
        localObject = (aymq)localObject;
        ((aymq)localObject).buF();
        ((aymq)localObject).a(localArrayList, bool, paramaymt);
        GLES20.glViewport(0, 0, paramInt1, paramInt2);
        GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
        ((aymq)localObject).renderTexture(paramFrame.getTextureId(), paramInt1, paramInt2);
        if (bool)
        {
          this.e.bindFrame(this.ef[0], paramInt1, paramInt2, 1.0D);
          GLES20.glBindFramebuffer(36160, this.e.getFBO());
          GLES20.glViewport(0, 0, paramInt1, paramInt2);
          ((aymq)localObject).xy(this.e.getTextureId());
          paramaymt.buI();
        }
      }
      else if ((localObject instanceof aymr))
      {
        localObject = (aymr)localObject;
        ((aymr)localObject).setTouchPoints(localArrayList);
        aymv.a(this.f, this.eg[0], paramInt1, paramInt2, true);
        ((aymr)localObject).Lz();
        aymv.a(this.jdField_a_of_type_ComTencentFilterBaseFilter, paramFrame, this.f, this.eg[0], paramInt1, paramInt2);
        if (bool)
        {
          ((aymr)localObject).setTouchPoints(paramaymt.w);
          this.e.bindFrame(this.ef[0], paramInt1, paramInt2, 1.0D);
          aymv.a(this.jdField_a_of_type_ComTencentFilterBaseFilter, this.e, this.f, this.eg[0], paramInt1, paramInt2);
          paramaymt.buI();
        }
      }
    }
  }
  
  public void apk()
  {
    this.aHZ = true;
    this.mCount = 0;
    if (this.jdField_b_of_type_Aymi != null) {
      this.jdField_b_of_type_Aymi.buo();
    }
  }
  
  public void buJ()
  {
    this.mTempFrame.bindFrame(this.ed[0], this.mWidth, this.mHeight, this.mAspectRatio);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glFlush();
    this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.mTempFrame.getTextureId(), this.mWidth, this.mHeight, 0, this.mAspectRatio, this.g);
    if (!this.aIa)
    {
      if (!this.aHZ) {
        break label122;
      }
      this.e.bindFrame(this.ef[0], this.mWidth, this.mHeight, 1.0D);
      aymv.buM();
      this.aHZ = false;
    }
    for (;;)
    {
      this.aIe = false;
      return;
      label122:
      t(this.mTempFrame.getFBO(), this.mTempFrame.getTextureId(), this.mWidth, this.mHeight);
    }
  }
  
  /* Error */
  public void buK()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 106	aymu:aIe	Z
    //   4: ifeq +29 -> 33
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 90	aymu:mTempFrame	Lcom/tencent/aekit/openrender/internal/Frame;
    //   12: invokevirtual 184	com/tencent/aekit/openrender/internal/Frame:getFBO	()I
    //   15: aload_0
    //   16: getfield 90	aymu:mTempFrame	Lcom/tencent/aekit/openrender/internal/Frame;
    //   19: invokevirtual 187	com/tencent/aekit/openrender/internal/Frame:getTextureId	()I
    //   22: aload_0
    //   23: getfield 108	aymu:mWidth	I
    //   26: aload_0
    //   27: getfield 230	aymu:mHeight	I
    //   30: invokevirtual 275	aymu:t	(IIII)V
    //   33: aload_0
    //   34: getfield 86	aymu:jdField_b_of_type_ComTencentFilterBaseFilter	Lcom/tencent/filter/BaseFilter;
    //   37: aload_0
    //   38: getfield 90	aymu:mTempFrame	Lcom/tencent/aekit/openrender/internal/Frame;
    //   41: invokevirtual 187	com/tencent/aekit/openrender/internal/Frame:getTextureId	()I
    //   44: aload_0
    //   45: getfield 49	aymu:mWindowWidth	I
    //   48: aload_0
    //   49: getfield 51	aymu:mWindowHeight	I
    //   52: iconst_0
    //   53: aload_0
    //   54: getfield 55	aymu:mAspectRatio	D
    //   57: aload_0
    //   58: getfield 88	aymu:g	Lcom/tencent/aekit/openrender/internal/Frame;
    //   61: invokevirtual 215	com/tencent/filter/BaseFilter:RenderProcess	(IIIIDLcom/tencent/aekit/openrender/internal/Frame;)V
    //   64: aload_0
    //   65: getfield 112	aymu:jdField_b_of_type_Aymi	Laymi;
    //   68: ifnull +23 -> 91
    //   71: aload_0
    //   72: getfield 112	aymu:jdField_b_of_type_Aymi	Laymi;
    //   75: instanceof 325
    //   78: ifeq +13 -> 91
    //   81: aload_0
    //   82: getfield 112	aymu:jdField_b_of_type_Aymi	Laymi;
    //   85: checkcast 325	aymk
    //   88: invokevirtual 328	aymk:bus	()V
    //   91: aload_0
    //   92: getfield 330	aymu:aIf	Z
    //   95: ifeq +285 -> 380
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 330	aymu:aIf	Z
    //   103: aconst_null
    //   104: astore 8
    //   106: aconst_null
    //   107: astore 7
    //   109: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +12 -> 124
    //   115: ldc 128
    //   117: iconst_2
    //   118: ldc_w 332
    //   121: invokestatic 334	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: invokestatic 340	java/lang/System:currentTimeMillis	()J
    //   127: lstore_2
    //   128: aload 8
    //   130: astore 6
    //   132: aload_0
    //   133: getfield 49	aymu:mWindowWidth	I
    //   136: aload_0
    //   137: getfield 51	aymu:mWindowHeight	I
    //   140: imul
    //   141: invokestatic 346	java/nio/IntBuffer:allocate	(I)Ljava/nio/IntBuffer;
    //   144: astore 9
    //   146: aload 8
    //   148: astore 6
    //   150: iconst_0
    //   151: iconst_0
    //   152: aload_0
    //   153: getfield 49	aymu:mWindowWidth	I
    //   156: aload_0
    //   157: getfield 51	aymu:mWindowHeight	I
    //   160: sipush 6408
    //   163: sipush 5121
    //   166: aload 9
    //   168: invokestatic 350	android/opengl/GLES20:glReadPixels	(IIIIIILjava/nio/Buffer;)V
    //   171: aload 8
    //   173: astore 6
    //   175: aload 9
    //   177: invokevirtual 354	java/nio/IntBuffer:array	()[I
    //   180: astore 10
    //   182: aload 8
    //   184: astore 6
    //   186: aload_0
    //   187: getfield 49	aymu:mWindowWidth	I
    //   190: aload_0
    //   191: getfield 51	aymu:mWindowHeight	I
    //   194: getstatic 360	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   197: invokestatic 366	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   200: astore 9
    //   202: aload 8
    //   204: astore 6
    //   206: aload 9
    //   208: aload 10
    //   210: invokestatic 370	java/nio/IntBuffer:wrap	([I)Ljava/nio/IntBuffer;
    //   213: invokevirtual 374	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   216: aload 9
    //   218: ifnull +331 -> 549
    //   221: aload 8
    //   223: astore 6
    //   225: aload_0
    //   226: getfield 110	aymu:brR	I
    //   229: i2f
    //   230: fconst_1
    //   231: fmul
    //   232: aload_0
    //   233: getfield 49	aymu:mWindowWidth	I
    //   236: i2f
    //   237: fdiv
    //   238: fstore_1
    //   239: aload 8
    //   241: astore 6
    //   243: new 376	android/graphics/Matrix
    //   246: dup
    //   247: invokespecial 377	android/graphics/Matrix:<init>	()V
    //   250: astore 10
    //   252: aload 8
    //   254: astore 6
    //   256: aload 10
    //   258: ldc_w 378
    //   261: invokevirtual 382	android/graphics/Matrix:postRotate	(F)Z
    //   264: pop
    //   265: aload 8
    //   267: astore 6
    //   269: aload 10
    //   271: ldc_w 383
    //   274: fload_1
    //   275: fmul
    //   276: fload_1
    //   277: fconst_1
    //   278: fmul
    //   279: invokevirtual 387	android/graphics/Matrix:postScale	(FF)Z
    //   282: pop
    //   283: aload 8
    //   285: astore 6
    //   287: aload 9
    //   289: iconst_0
    //   290: iconst_0
    //   291: aload 9
    //   293: invokevirtual 390	android/graphics/Bitmap:getWidth	()I
    //   296: aload 9
    //   298: invokevirtual 393	android/graphics/Bitmap:getHeight	()I
    //   301: aload 10
    //   303: iconst_0
    //   304: invokestatic 396	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   307: astore 8
    //   309: aload 8
    //   311: astore 6
    //   313: aload 6
    //   315: astore 7
    //   317: aload_0
    //   318: iconst_0
    //   319: putfield 398	aymu:aIc	Z
    //   322: aload_0
    //   323: getfield 112	aymu:jdField_b_of_type_Aymi	Laymi;
    //   326: ifnull +14 -> 340
    //   329: aload_0
    //   330: getfield 112	aymu:jdField_b_of_type_Aymi	Laymi;
    //   333: aload 6
    //   335: invokeinterface 402 2 0
    //   340: invokestatic 340	java/lang/System:currentTimeMillis	()J
    //   343: lstore 4
    //   345: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq +32 -> 380
    //   351: ldc 128
    //   353: iconst_2
    //   354: new 404	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   361: ldc_w 407
    //   364: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: lload 4
    //   369: lload_2
    //   370: lsub
    //   371: invokevirtual 414	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   374: invokevirtual 417	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 334	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: return
    //   381: astore 8
    //   383: aconst_null
    //   384: astore 6
    //   386: aload 6
    //   388: astore 7
    //   390: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq +20 -> 413
    //   396: aload 6
    //   398: astore 7
    //   400: ldc_w 419
    //   403: iconst_2
    //   404: aload 8
    //   406: iconst_0
    //   407: anewarray 421	java/lang/Object
    //   410: invokestatic 424	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   413: aload_0
    //   414: getfield 112	aymu:jdField_b_of_type_Aymi	Laymi;
    //   417: ifnull -77 -> 340
    //   420: aload_0
    //   421: getfield 112	aymu:jdField_b_of_type_Aymi	Laymi;
    //   424: aload 6
    //   426: invokeinterface 402 2 0
    //   431: goto -91 -> 340
    //   434: astore 8
    //   436: aload 7
    //   438: astore 6
    //   440: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   443: ifeq +35 -> 478
    //   446: aload 7
    //   448: astore 6
    //   450: ldc_w 419
    //   453: iconst_2
    //   454: new 404	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   461: ldc_w 426
    //   464: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload 8
    //   469: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 417	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 431	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: aload_0
    //   479: getfield 112	aymu:jdField_b_of_type_Aymi	Laymi;
    //   482: ifnull -142 -> 340
    //   485: aload_0
    //   486: getfield 112	aymu:jdField_b_of_type_Aymi	Laymi;
    //   489: aload 7
    //   491: invokeinterface 402 2 0
    //   496: goto -156 -> 340
    //   499: astore 8
    //   501: aload 6
    //   503: astore 7
    //   505: aload 8
    //   507: astore 6
    //   509: aload_0
    //   510: getfield 112	aymu:jdField_b_of_type_Aymi	Laymi;
    //   513: ifnull +14 -> 527
    //   516: aload_0
    //   517: getfield 112	aymu:jdField_b_of_type_Aymi	Laymi;
    //   520: aload 7
    //   522: invokeinterface 402 2 0
    //   527: aload 6
    //   529: athrow
    //   530: astore 6
    //   532: goto -23 -> 509
    //   535: astore 8
    //   537: aload 6
    //   539: astore 7
    //   541: goto -105 -> 436
    //   544: astore 8
    //   546: goto -160 -> 386
    //   549: aconst_null
    //   550: astore 6
    //   552: goto -239 -> 313
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	555	0	this	aymu
    //   238	39	1	f1	float
    //   127	243	2	l1	long
    //   343	25	4	l2	long
    //   130	398	6	localObject1	Object
    //   530	8	6	localObject2	Object
    //   550	1	6	localObject3	Object
    //   107	433	7	localObject4	Object
    //   104	206	8	localBitmap	Bitmap
    //   381	24	8	localException1	java.lang.Exception
    //   434	34	8	localOutOfMemoryError1	OutOfMemoryError
    //   499	7	8	localObject5	Object
    //   535	1	8	localOutOfMemoryError2	OutOfMemoryError
    //   544	1	8	localException2	java.lang.Exception
    //   144	153	9	localObject6	Object
    //   180	122	10	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   132	146	381	java/lang/Exception
    //   150	171	381	java/lang/Exception
    //   175	182	381	java/lang/Exception
    //   186	202	381	java/lang/Exception
    //   206	216	381	java/lang/Exception
    //   225	239	381	java/lang/Exception
    //   243	252	381	java/lang/Exception
    //   256	265	381	java/lang/Exception
    //   269	283	381	java/lang/Exception
    //   287	309	381	java/lang/Exception
    //   132	146	434	java/lang/OutOfMemoryError
    //   150	171	434	java/lang/OutOfMemoryError
    //   175	182	434	java/lang/OutOfMemoryError
    //   186	202	434	java/lang/OutOfMemoryError
    //   206	216	434	java/lang/OutOfMemoryError
    //   225	239	434	java/lang/OutOfMemoryError
    //   243	252	434	java/lang/OutOfMemoryError
    //   256	265	434	java/lang/OutOfMemoryError
    //   269	283	434	java/lang/OutOfMemoryError
    //   287	309	434	java/lang/OutOfMemoryError
    //   132	146	499	finally
    //   150	171	499	finally
    //   175	182	499	finally
    //   186	202	499	finally
    //   206	216	499	finally
    //   225	239	499	finally
    //   243	252	499	finally
    //   256	265	499	finally
    //   269	283	499	finally
    //   287	309	499	finally
    //   440	446	499	finally
    //   450	478	499	finally
    //   317	322	530	finally
    //   390	396	530	finally
    //   400	413	530	finally
    //   317	322	535	java/lang/OutOfMemoryError
    //   317	322	544	java/lang/Exception
  }
  
  public void buL()
  {
    this.aIa = true;
    if (this.jdField_b_of_type_Aymi != null) {
      this.jdField_b_of_type_Aymi.buo();
    }
  }
  
  public void bum()
  {
    this.aHZ = true;
    this.mCount -= 1;
    if (this.jdField_b_of_type_Aymi != null) {
      this.jdField_b_of_type_Aymi.buo();
    }
  }
  
  public Bitmap c(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = RendererUtils.saveTexture(this.mTempFrame.getTextureId(), paramInt1, paramInt2);
    if (localBitmap != null)
    {
      Object localObject = new Matrix();
      ((Matrix)localObject).postScale(1.0F, (float)-this.mAspectRatio);
      localObject = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), (Matrix)localObject, true);
      localBitmap.recycle();
      return rop.b((Bitmap)localObject, this.mWindowWidth, this.mWindowHeight, true);
    }
    return null;
  }
  
  public void clear()
  {
    this.mCount = 0;
    try
    {
      this.g.clear();
      this.jdField_b_of_type_ComTencentFilterBaseFilter.ClearGLSL();
      if (this.aId)
      {
        this.aId = false;
        if (!this.filterMap.isEmpty())
        {
          Iterator localIterator = this.filterMap.entrySet().iterator();
          while (localIterator.hasNext()) {
            ((VideoFilterBase)((Map.Entry)localIterator.next()).getValue()).clearGLSLSelf();
          }
          this.filterMap.clear();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PersonalityOperator", 2, "clear " + localThrowable.toString());
      }
      return;
    }
    this.e.clear();
    this.jdField_a_of_type_ComTencentFilterBaseFilter.ClearGLSL();
    GLES20.glDeleteTextures(this.ee.length, this.ee, 0);
    GLES20.glDeleteTextures(this.ef.length, this.ef, 0);
    GLES20.glDeleteTextures(this.eg.length, this.eg, 0);
  }
  
  public void d(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    PointF localPointF = new PointF(paramFloat1, paramFloat2);
    paramFloat1 = this.mWidth / this.mWindowWidth;
    localPointF.x *= paramFloat1;
    localPointF.y = (paramFloat1 * localPointF.y);
    localPointF = new PointF(localPointF.x - this.mWidth * 0.5F, localPointF.y - this.mHeight * 0.5F);
    this.jdField_a_of_type_Aymt.w.add(localPointF);
    this.jdField_a_of_type_Aymt.aHX = paramBoolean;
  }
  
  public void eSO()
  {
    if (this.jdField_b_of_type_Aymi != null) {
      this.jdField_b_of_type_Aymi.buo();
    }
  }
  
  public void onDestroy()
  {
    this.mTempFrame.clear();
    GLES20.glDeleteTextures(this.ed.length, this.ed, 0);
  }
  
  public void onInit()
  {
    clear();
    GLES20.glGenTextures(this.ed.length, this.ed, 0);
    this.jdField_b_of_type_ComTencentFilterBaseFilter.apply();
    this.jdField_a_of_type_ComTencentFilterBaseFilter.apply();
    GLES20.glGenTextures(this.ee.length, this.ee, 0);
    GLES20.glGenTextures(this.ef.length, this.ef, 0);
    GLES20.glGenTextures(this.eg.length, this.eg, 0);
  }
  
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    float f1 = Math.min(720.0F / Math.min(paramInt1, paramInt2), 1.0F);
    this.mWidth = ((int)(paramInt1 * f1));
    this.mHeight = ((int)(f1 * paramInt2));
    if (!this.filterMap.isEmpty()) {
      updateVideoSize(this.mWidth, this.mHeight, 1.0D);
    }
    this.mWindowWidth = paramInt1;
    this.mWindowHeight = paramInt2;
    if (this.aIb) {
      tO(true);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.filterMap.isEmpty()) {
      if ((QLog.isColorLevel()) && (paramMotionEvent.getAction() == 0)) {
        QLog.w("PersonalityOperator", 2, "onTouch filterMap is empty");
      }
    }
    do
    {
      return true;
      if ((this.mCount + 1 <= 50) || (this.jdField_a_of_type_Aymt == null) || (!this.jdField_a_of_type_Aymt.aHX)) {
        break;
      }
    } while (paramMotionEvent.getAction() != 0);
    QQStoryContext.a();
    QQToast.a(QQStoryContext.c().getApp(), acfp.m(2131709462), 0).show();
    return true;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i;
    if (paramMotionEvent.getAction() == 2) {
      if (this.jdField_a_of_type_Aymt != null)
      {
        d(f1, f2, false);
        i = this.brQ + 1;
        this.brQ = i;
        this.brQ = (i % 4);
        if (this.brQ != 0) {}
      }
    }
    for (;;)
    {
      this.aIc = true;
      if (this.jdField_b_of_type_Aymi == null) {
        break;
      }
      this.jdField_b_of_type_Aymi.buo();
      return true;
      if (paramMotionEvent.getAction() == 0)
      {
        if ((this.material != null) && (!TextUtils.isEmpty(this.material.getId())))
        {
          paramMotionEvent = this.material.getId();
          if (this.jdField_b_of_type_Aymi != null) {}
          for (i = this.jdField_b_of_type_Aymi.RY();; i = 0)
          {
            this.jdField_a_of_type_Aymt = new aymt(102, paramMotionEvent, i);
            this.mCount += 1;
            this.jdField_a_of_type_Aymt.aHW = true;
            if (this.jdField_b_of_type_Aymi != null) {
              this.jdField_b_of_type_Aymi.a(this.jdField_a_of_type_Aymt);
            }
            d(f1, f2, false);
            this.brQ = 0;
            break;
          }
        }
      }
      else if (((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) && (this.jdField_a_of_type_Aymt != null)) {
        d(f1, f2, true);
      }
    }
  }
  
  public void setVideoFilter(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      if (!this.filterMap.containsKey(paramVideoMaterial.getId()))
      {
        VideoFilterBase localVideoFilterBase = a(paramVideoMaterial);
        if (localVideoFilterBase != null) {
          this.filterMap.put(paramVideoMaterial.getId(), localVideoFilterBase);
        }
      }
      this.material = paramVideoMaterial;
      paramVideoMaterial = new PersonalityOperator.1(this, paramVideoMaterial);
      if (this.jdField_b_of_type_Aymi != null) {
        this.jdField_b_of_type_Aymi.N(paramVideoMaterial);
      }
      return;
    }
    ram.d("PersonalityOperator", "material is null!");
  }
  
  public void t(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.filterMap == null) || (this.filterMap.size() < 1)) {
      return;
    }
    Frame localFrame = new Frame(paramInt1, paramInt2, paramInt3, paramInt4);
    GlUtil.setBlendMode(true);
    GLES20.glBindFramebuffer(36160, paramInt1);
    GLES20.glViewport(0, 0, paramInt3, paramInt4);
    this.e.bindFrame(this.ef[0], paramInt3, paramInt4, 1.0D);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(this.e.getTextureId(), paramInt3, paramInt4, paramInt2, 1.0D, localFrame);
    GlUtil.setBlendMode(false);
  }
  
  public void tO(boolean paramBoolean)
  {
    boolean bool = true;
    this.aIa = false;
    this.aHZ = true;
    if (!paramBoolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.aIb = paramBoolean;
      if (this.jdField_b_of_type_Aymi != null) {
        this.jdField_b_of_type_Aymi.buo();
      }
      return;
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (paramInt1 / paramInt2 > 0.75D) {
      paramInt2 = (int)(paramInt1 / 0.75D);
    }
    while (this.filterMap.isEmpty())
    {
      return;
      paramInt1 = (int)(paramInt2 * 0.75D);
    }
    Iterator localIterator = this.filterMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)((Map.Entry)localIterator.next()).getValue()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.ee[0]);
    GLES20.glTexImage2D(3553, 0, 6402, paramInt1, paramInt2, 0, 6402, 5123, null);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexParameteri(3553, 10240, 9728);
    GLES20.glTexParameteri(3553, 10241, 9728);
  }
  
  public void xt(int paramInt)
  {
    this.aIf = true;
    this.brR = paramInt;
    if (this.jdField_b_of_type_Aymi != null) {
      this.jdField_b_of_type_Aymi.buo();
    }
  }
  
  public void xz(int paramInt)
  {
    try
    {
      this.aIf = true;
      this.brR = paramInt;
      Bitmap localBitmap = c(this.mWidth, this.mHeight);
      if (localBitmap == null)
      {
        this.aIf = false;
        ram.e("PersonalityOperator", "saveTextureToBitmap failed, bitmapFromTexture is null");
        return;
      }
      localBitmap = rop.b(localBitmap, 1.0F * this.brR / this.mWindowWidth, true);
      this.aIc = false;
      if (this.jdField_b_of_type_Aymi != null)
      {
        this.jdField_b_of_type_Aymi.v(localBitmap);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Personality", 2, localOutOfMemoryError, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aymu
 * JD-Core Version:    0.7.0.1
 */