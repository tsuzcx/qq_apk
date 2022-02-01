import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager.StickerInnerEffectFilterListener;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.CropFilter;
import com.tencent.ttpic.openapi.filter.SpaceFilter;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.PTHumanSegmenter;
import com.tencent.ttpic.util.MustRunOnGLThread;
import com.tencent.view.RendererUtils;
import dov.com.qq.im.ae.camera.filter.AEFilterProcessTex.2;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class awwg
  extends awwi
{
  private static final String TAG = awwg.class.getSimpleName();
  private static boolean dth;
  private static int eDo;
  private static int eDp;
  private static SparseArray<VideoMaterial> ed = new SparseArray();
  private static String mLutPath;
  private Queue<Runnable> Q = new ArrayDeque();
  private axca jdField_a_of_type_Axca = new axca();
  private axdc jdField_a_of_type_Axdc;
  private CropFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter;
  private AEFilterManager aeFilterManager;
  private BaseFilter c;
  private String cTo;
  private boolean dti;
  public boolean dtj = true;
  private Set<String> dz = new HashSet();
  private final int eDq;
  private Frame g;
  private int gender = -1;
  private BaseFilter mCopyFilter;
  private Frame mCopyFrame;
  private SpaceFilter mViewFilter;
  private AEFilterManager.StickerInnerEffectFilterListener stickerInnerLutFilterListener;
  
  public awwg(int paramInt)
  {
    this.eDq = paramInt;
    eGQ();
  }
  
  @Nullable
  private VideoMaterial a()
  {
    return (VideoMaterial)ed.get(this.eDq);
  }
  
  private boolean aOb()
  {
    if (this.aeFilterManager == null) {}
    while ((!aywy.a().aRm()) || (!isInited()) || (!this.aeFilterManager.canUseLargeImage())) {
      return false;
    }
    return true;
  }
  
  private void aX(int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      try
      {
        i = -((this.orientation - 90 + 360) % 360);
        this.mCopyFilter.setRotationAndFlip(i, 0, 0);
        if (this.orientation == 0) {
          break label133;
        }
        if (this.orientation != 180) {
          break label130;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Bitmap localBitmap;
        if (this.jdField_a_of_type_Awwg$a == null) {
          continue;
        }
        this.jdField_a_of_type_Awwg$a.onCaptureError(103);
        return;
      }
      this.mCopyFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.mCopyFrame);
      this.mCopyFilter.setRotationAndFlip(0, 0, 0);
      localBitmap = RendererUtils.saveTexture(this.mCopyFrame);
      if (this.jdField_a_of_type_Awwg$a != null) {
        this.jdField_a_of_type_Awwg$a.ao(localBitmap);
      }
      eGV();
      return;
      label130:
      continue;
      label133:
      int i = paramInt2;
      paramInt2 = paramInt3;
      paramInt3 = i;
    }
  }
  
  private void adt(int paramInt)
  {
    if (this.aeFilterManager != null) {
      this.aeFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.BASIC4, paramInt);
    }
  }
  
  private void c(@Nullable VideoMaterial paramVideoMaterial)
  {
    ed.put(this.eDq, paramVideoMaterial);
  }
  
  private void eGQ()
  {
    try
    {
      if (this.c == null) {
        this.c = new SurfaceTextureFilter();
      }
      if (this.mViewFilter == null) {
        this.mViewFilter = new SpaceFilter();
      }
      if (this.mCopyFilter == null) {
        this.mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
      }
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter == null) {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter = new CropFilter();
      }
      if (this.g == null) {
        this.g = new Frame();
      }
      if (this.mCopyFrame == null) {
        this.mCopyFrame = new Frame();
      }
      if (this.aeFilterManager == null) {
        this.aeFilterManager = new AEFilterManager();
      }
      if (this.jdField_a_of_type_Axdc == null) {
        this.jdField_a_of_type_Axdc = new axdc();
      }
      return;
    }
    finally {}
  }
  
  @MustRunOnGLThread
  private void eGR()
  {
    if (this.c != null) {
      this.c.applyFilterChain(true, this.previewWidth, this.previewHeight);
    }
    if (this.mViewFilter != null) {
      this.mViewFilter.applyFilterChain(true, this.previewWidth, this.previewHeight);
    }
    if (this.mCopyFilter != null) {
      this.mCopyFilter.applyFilterChain(true, this.previewWidth, this.previewHeight);
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter.apply();
    }
    if (this.g != null) {
      this.g = new Frame();
    }
    if (this.mCopyFrame != null) {
      this.mCopyFrame = new Frame();
    }
    if (this.aeFilterManager != null)
    {
      eGT();
      eGS();
    }
    if (this.jdField_a_of_type_Axdc != null) {
      this.jdField_a_of_type_Axdc.initial();
    }
    this.jdField_a_of_type_Axca.initial();
  }
  
  private void eGS()
  {
    Object localObject = a();
    if ((localObject != null) && (FeatureManager.ensureMaterialSoLoaded((VideoMaterial)localObject)))
    {
      this.aeFilterManager.updateMaterialGL((VideoMaterial)localObject);
      if (localObject == null) {
        break label94;
      }
    }
    label94:
    for (this.cTo = ((VideoMaterial)localObject).getId();; this.cTo = "none")
    {
      if (eDo > 0) {
        this.aeFilterManager.setSmoothLevel(eDo);
      }
      if (eDp > 0) {
        adt(eDp);
      }
      if (dth)
      {
        localObject = FeatureManager.getResourceDir();
        if (AIManager.installDetector(PTHumanSegmenter.class, (String)localObject, (String)localObject)) {
          XL(dth);
        }
      }
      return;
    }
  }
  
  private void eGT()
  {
    this.aeFilterManager.setParam("SET_ENABLE_ASYNC_INIT_FILTERS", Boolean.valueOf(true));
    int j = 100;
    Object localObject = axis.a().t("app_alg_filter_timeout_id", "", 4);
    int i = j;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      i = Integer.parseInt((String)localObject);
      this.aeFilterManager.setParam("SET_ENDURANCE_TIME", Integer.valueOf(i));
      this.aeFilterManager.initInGL(this.previewWidth, this.previewHeight);
      this.aeFilterManager.setStickerInnerLutFilterListener(this.stickerInnerLutFilterListener);
      LogUtils.setEnable(false);
      this.aeFilterManager.setOnMaterialLoadFinishListener(new awwh(this));
      this.aeFilterManager.defineFiltersAndOrder(new int[] { 113, 108, 101, 111, 104, 102, 105, 103 });
      this.aeFilterManager.setBeautyNormalAlpha(0.8F);
      this.aeFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.EYE_LIGHTEN, 35);
      this.aeFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.REMOVE_POUNCH, 40);
      this.aeFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 50);
      this.aeFilterManager.setSegStrokeWidthInPixel(18.0F);
      this.aeFilterManager.setSegStrokeGapInPixel(1.0F);
      this.aeFilterManager.setSegStrokeColor(new float[] { 1.0F, 1.0F, 1.0F, 1.0F });
      this.aeFilterManager.setSegBgColor(new float[] { 1.0F, 1.0F, 1.0F, 0.0F });
      this.aeFilterManager.switchFilterOn(111, false);
      this.aeFilterManager.setmNeedGenderDetect(true);
      while ((this.Q != null) && (!this.Q.isEmpty()))
      {
        localObject = (Runnable)this.Q.poll();
        if (localObject != null) {
          ((Runnable)localObject).run();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        i = j;
      }
    }
  }
  
  private void eGV()
  {
    if ((this.aeFilterManager != null) && (this.aeFilterManager.getmPTSticker() != null) && (this.aeFilterManager.getmPTSticker().getVideoMateral() != null))
    {
      this.aeFilterManager.getmPTSticker().getVideoMateral().setSupportPause(true);
      this.aeFilterManager.onStickerStatusChange(true);
    }
  }
  
  private void k(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glClearColor(0.92F, 0.93F, 0.96F, 1.0F);
      GLES20.glClear(16384);
      GlUtil.setBlendModeSrcAlpha(true);
    }
    this.mViewFilter.setRotationAndFlip(0, 0, 1);
    this.mViewFilter.RenderProcess(paramInt3, paramInt1, paramInt2, 0, 0.0D, this.g);
    if (paramBoolean) {
      GlUtil.setBlendModeSrcAlpha(false);
    }
  }
  
  public void XL(boolean paramBoolean)
  {
    dth = paramBoolean;
    AEFilterProcessTex.2 local2 = new AEFilterProcessTex.2(this, paramBoolean);
    if ((this.aeFilterManager != null) && (this.aeFilterManager.isInited()))
    {
      local2.run();
      return;
    }
    az(local2);
  }
  
  public void XP(boolean paramBoolean)
  {
    eDo = 0;
    eDp = 0;
    dth = false;
    if (paramBoolean) {
      c(null);
    }
  }
  
  public AEFilterManager a()
  {
    return this.aeFilterManager;
  }
  
  public void addTouchPoint(PointF paramPointF, int paramInt)
  {
    if (this.aeFilterManager == null) {
      return;
    }
    this.aeFilterManager.addMaskTouchPoint(paramPointF, paramInt);
  }
  
  public void az(Runnable paramRunnable)
  {
    this.Q.offer(paramRunnable);
  }
  
  public void b(VideoMaterial paramVideoMaterial)
  {
    c(paramVideoMaterial);
    if (this.aeFilterManager != null)
    {
      if ((paramVideoMaterial == null) || (paramVideoMaterial.getId() == null) || (paramVideoMaterial.getId().equals(this.cTo))) {
        break label67;
      }
      this.aeFilterManager.updateMaterialGL(paramVideoMaterial);
      this.cTo = paramVideoMaterial.getId();
    }
    for (;;)
    {
      if (eDp > 0) {
        adt(eDp);
      }
      return;
      label67:
      if ((paramVideoMaterial == null) || (paramVideoMaterial.getId() == null))
      {
        this.aeFilterManager.updateMaterialGL(null);
        this.cTo = "none";
      }
      else if ((!TextUtils.isEmpty(this.cTo)) && (this.dz.contains(this.cTo)))
      {
        this.aeFilterManager.updateMaterialGL(paramVideoMaterial);
        this.cTo = paramVideoMaterial.getId();
      }
    }
  }
  
  public int[] b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!isInited())
    {
      this.textures[0] = 0;
      this.textures[1] = 0;
      return this.textures;
    }
    boolean bool = this.cAv;
    this.c.updateMatrix(this.mTransformMatrix);
    this.c.setRotationAndFlip(0, 0, 1);
    Object localObject = this.c.RenderProcess(this.eDv, this.cameraWidth, this.cameraHeight);
    if (axca.dtY)
    {
      if (!this.jdField_a_of_type_Axca.aOr())
      {
        this.jdField_a_of_type_Axca.akY();
        this.cameraWidth = this.jdField_a_of_type_Axca.getWidth();
        this.cameraHeight = this.jdField_a_of_type_Axca.getHeight();
      }
      localObject = this.mCopyFilter.RenderProcess(this.jdField_a_of_type_Axca.QZ(), this.previewWidth, this.previewHeight);
    }
    for (;;)
    {
      int j;
      int i;
      label228:
      Frame localFrame;
      if ((bool) && (aOb()))
      {
        awyu.a.dtE = true;
        this.previewWidth = this.eDr;
        this.previewHeight = this.eDs;
        if (Math.abs(this.mViewAspectRatio - this.dn) <= 0.01D) {
          break label582;
        }
        if (this.mViewAspectRatio >= this.dn) {
          break label562;
        }
        j = this.cameraHeight;
        i = (int)(j * this.mViewAspectRatio);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter.updateCorpRect(i, j, this.cameraWidth, this.cameraHeight);
        localFrame = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter.RenderProcess(((Frame)localObject).getTextureId(), this.previewWidth, this.previewHeight);
        ((Frame)localObject).unlock();
      }
      for (;;)
      {
        try
        {
          localObject = (PTFaceAttr)this.aeFilterManager.getAIAttr().getFaceAttr();
          if (localObject == null) {
            continue;
          }
          localList = ((PTFaceAttr)localObject).getFaceStatusList();
          if ((localList != null) && (!localList.isEmpty())) {
            continue;
          }
          this.gender = -1;
        }
        catch (Throwable localThrowable)
        {
          List localList;
          label562:
          label582:
          QLog.d(TAG, 1, "AEKit 渲染 start Throwable = " + localThrowable.getMessage());
          continue;
          this.gender = ((FaceStatus)localThrowable.getFaceStatusList().get(0)).gender;
          continue;
          axip.a().setSex(-1);
          continue;
        }
        axip.a().setSex(this.gender);
        i = localFrame.getTextureId();
        if (this.aeFilterManager != null)
        {
          this.aeFilterManager.setRotationMatrix(this.dV);
          if (!this.dti) {
            axgk.a().acy("filterMgrDraw-begin");
          }
          i = this.aeFilterManager.drawFrame(localFrame.getTextureId(), bool, this.h.getTimestamp());
          if (!this.dti)
          {
            axgk.a().acy("filterMgrDraw-end");
            this.dti = true;
          }
          localFrame.unlock();
        }
        k(paramInt1, paramInt2, i, paramBoolean);
        if (bool)
        {
          QLog.d(TAG, 1, "in capture frame.");
          aX(i, this.previewWidth, this.previewHeight);
          this.cAv = false;
        }
        FrameBufferCache.getInstance().forceRecycle();
        this.mCopyFilter.setRotationAndFlip(0, 0, 1);
        this.mCopyFilter.RenderProcess(i, this.previewWidth, this.previewHeight, -1, 0.0D, this.mCopyFrame);
        this.mCopyFilter.setRotationAndFlip(0, 0, 0);
        this.textures[0] = i;
        this.textures[1] = this.mCopyFrame.getTextureId();
        return this.textures;
        this.previewWidth = this.eDt;
        this.previewHeight = this.eDu;
        break;
        i = this.cameraWidth;
        j = (int)(i / this.mViewAspectRatio);
        break label228;
        i = this.cameraWidth;
        j = this.cameraHeight;
        break label228;
        if (localList.size() <= 1) {
          continue;
        }
        this.gender = 3;
      }
    }
  }
  
  public void br(float paramFloat)
  {
    if (this.aeFilterManager != null) {
      this.aeFilterManager.setPhoneRoll(paramFloat);
    }
  }
  
  public boolean detectedFace()
  {
    if (this.aeFilterManager == null) {
      return false;
    }
    return this.aeFilterManager.detectedFace();
  }
  
  public void eGP()
  {
    eGR();
  }
  
  public void eGU()
  {
    if (this.c != null)
    {
      this.c.ClearGLSL();
      this.c = null;
    }
    if (this.mViewFilter != null)
    {
      this.mViewFilter.ClearGLSL();
      this.mViewFilter = null;
    }
    if (this.mCopyFilter != null)
    {
      this.mCopyFilter.ClearGLSL();
      this.mCopyFilter = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter.ClearGLSL();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter = null;
    }
    if (this.g != null)
    {
      this.g.clear();
      this.g = null;
    }
    if (this.mCopyFrame != null)
    {
      this.mCopyFrame.clear();
      this.mCopyFrame = null;
    }
    if (this.aeFilterManager != null)
    {
      this.aeFilterManager.destroy();
      this.aeFilterManager = null;
    }
    if (this.jdField_a_of_type_Axdc != null)
    {
      this.jdField_a_of_type_Axdc.clear();
      this.jdField_a_of_type_Axdc = null;
    }
    this.jdField_a_of_type_Axca.clear();
  }
  
  public void eGW()
  {
    if ((this.aeFilterManager != null) && (a() != null)) {
      this.aeFilterManager.stickerReset(true);
    }
  }
  
  public void eGX()
  {
    if (!TextUtils.isEmpty(this.cTo)) {
      this.dz.add(this.cTo);
    }
  }
  
  public void g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super.g(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    if (this.aeFilterManager != null)
    {
      this.aeFilterManager.updateWidthHeight(this.previewWidth, this.previewHeight);
      this.aeFilterManager.setSmoothSharpenSize(this.previewWidth, this.previewHeight);
    }
  }
  
  public AIAttr getAIAttr()
  {
    if (this.aeFilterManager == null) {
      return null;
    }
    return this.aeFilterManager.getAIAttr();
  }
  
  public boolean hasEffect()
  {
    if (this.aeFilterManager == null) {}
    while ((a() == null) && (eDo <= 0) && (eDp <= 0) && (mLutPath == null)) {
      return false;
    }
    return true;
  }
  
  public boolean isNeedFaceDetect()
  {
    VideoMaterial localVideoMaterial = a();
    if (localVideoMaterial == null) {}
    while ((TextUtils.isEmpty(localVideoMaterial.getDataPath())) || (!localVideoMaterial.needFaceInfo())) {
      return false;
    }
    return true;
  }
  
  public int lz(int paramInt)
  {
    Frame localFrame = new Frame(-1, paramInt, this.videoWidth, this.videoHeight);
    return this.jdField_a_of_type_Axdc.render(localFrame).getTextureId();
  }
  
  public boolean needMaskRecordTouchPoint()
  {
    if (this.aeFilterManager == null) {
      return false;
    }
    return this.aeFilterManager.needMaskRecordTouchPoint();
  }
  
  public void setIsAfterUpdateMaterial(boolean paramBoolean)
  {
    if (this.aeFilterManager != null) {
      this.aeFilterManager.setIsAfterUpdateMaterial(paramBoolean);
    }
  }
  
  public void setSharpFaceLevel(int paramInt)
  {
    eDp = paramInt;
    adt(paramInt);
  }
  
  public void setSmoothLevel(int paramInt)
  {
    eDo = paramInt;
    this.aeFilterManager.setSmoothLevel(paramInt);
  }
  
  public void setStickerInnerLutFilterListener(AEFilterManager.StickerInnerEffectFilterListener paramStickerInnerEffectFilterListener)
  {
    this.stickerInnerLutFilterListener = paramStickerInnerEffectFilterListener;
  }
  
  public void updateLutGL(String paramString)
  {
    mLutPath = paramString;
    if (this.aeFilterManager != null)
    {
      this.aeFilterManager.updateLutGL(paramString);
      this.aeFilterManager.setFilterInSmooth(true);
    }
  }
  
  public static abstract interface a
  {
    public abstract void ao(Bitmap paramBitmap);
    
    public abstract void onCaptureError(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awwg
 * JD-Core Version:    0.7.0.1
 */