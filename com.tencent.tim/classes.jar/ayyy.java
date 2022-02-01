import android.annotation.TargetApi;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImage;
import com.tencent.mobileqq.shortvideo.filter.QQBaseFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQPtvVideoFilter;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilter;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilterCompose;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.util.List;

@TargetApi(11)
public class ayyy
  extends QQBaseFilter
{
  private FollowCaptureParam jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam;
  private GLImage jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage;
  private QQPtvVideoFilter jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPtvVideoFilter;
  private GaussianBlurFilterCompose jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose;
  private boolean dCb;
  private boolean dCc;
  private float[] ei;
  private float[] ej;
  private QQFilterRenderManager jdField_g_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = new QQFilterRenderManager();
  private RenderBuffer jdField_g_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private String mBackgroundImagePath;
  private float[] mMvpMatrix;
  private int mSurfaceHeight;
  private int mSurfaceWidth;
  private TextureRender mTextureRender;
  private int mVideoHeight;
  private int mVideoWidth;
  
  public ayyy()
  {
    super(0, null);
  }
  
  public static float[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = paramInt3 / paramInt4;
    float f2 = paramInt1 / paramInt2;
    if (f1 > f2)
    {
      f2 = paramInt4 * f2 / paramInt3;
      f1 = 1.0F;
    }
    for (;;)
    {
      float[] arrayOfFloat = new float[16];
      Matrix.setIdentityM(arrayOfFloat, 0);
      Matrix.scaleM(arrayOfFloat, 0, f2, f1, 1.0F);
      return arrayOfFloat;
      if (f1 < f2)
      {
        f1 = paramInt3 / (f2 * paramInt4);
        f2 = 1.0F;
      }
      else
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
    }
  }
  
  private void adJ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    long l = SystemClock.elapsedRealtime();
    VideoMaterial localVideoMaterial = QQTemplateParser.parseVideoMaterial(paramString, "params");
    localVideoMaterial.setDataPath(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QQFollowCaptureEditFilter", 2, "parseVideoMaterial  tempMaterail type: " + localVideoMaterial.getShaderType() + " patternPath=" + paramString);
    }
    paramString = new AESticker(localVideoMaterial, this.jdField_g_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getFaceDetector());
    if ((QLog.isColorLevel()) && (paramString.getFilters() != null)) {
      QLog.d("QQFollowCaptureEditFilter", 2, "createFilters = " + paramString.getFilters().size() + " tempMaterail getShaderType=" + localVideoMaterial.getShaderType());
    }
    l = (SystemClock.elapsedRealtime() - l) / 1000L;
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[setVideoFilter_parser=" + l / 1000.0D + "ms]");
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPtvVideoFilter.changeFilter(paramString, this.mSurfaceWidth, this.mSurfaceHeight, 1.0D, null);
      VideoMemoryManager.getInstance().loadAllImages(localVideoMaterial);
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void initTexture(int paramInt1, int paramInt2)
  {
    this.mSurfaceWidth = paramInt1;
    this.mSurfaceHeight = paramInt2;
    this.jdField_g_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.mSurfaceWidth, this.mSurfaceHeight, 33984);
  }
  
  public void a(FollowCaptureParam paramFollowCaptureParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam = paramFollowCaptureParam;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam.backgroundPath != null))
    {
      this.mBackgroundImagePath = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam.backgroundPath;
      this.dCb = new File(this.mBackgroundImagePath).exists();
      if (this.dCb) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage = new GLImage();
      }
      if ((!TextUtils.isEmpty(paramFollowCaptureParam.foregroundPath)) && (aqhq.fileExists(paramFollowCaptureParam.foregroundPath)))
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPtvVideoFilter = new QQPtvVideoFilter(40, this.jdField_g_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPtvVideoFilter.setNeedFlip(false);
      }
    }
  }
  
  public void onDrawFrame()
  {
    this.jdField_g_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    if (this.dCb)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.getTexture() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.loadTextureSync(this.mBackgroundImagePath);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.getTexture() != 0)
      {
        if (this.ei == null) {
          this.ei = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.getWidth(), this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.getHeight(), this.mSurfaceWidth, this.mSurfaceHeight);
        }
        this.mTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.getTexture(), null, this.ei);
      }
    }
    for (;;)
    {
      if (this.mMvpMatrix == null) {
        this.mMvpMatrix = a(this.mVideoWidth, this.mVideoHeight, this.mSurfaceWidth, this.mSurfaceHeight);
      }
      this.mTextureRender.drawTexture(3553, this.mInputTextureID, null, this.mMvpMatrix);
      this.jdField_g_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPtvVideoFilter == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPtvVideoFilter.setInputTextureID(this.jdField_g_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId());
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPtvVideoFilter.onDrawFrame();
      this.mOutputTextureID = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPtvVideoFilter.getOutputTextureID();
      return;
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose == null)
      {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose = new GaussianBlurFilterCompose();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose.init(this.mVideoWidth, this.mVideoHeight);
        this.dCc = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose.getFilter().isInitSucc();
        this.jdField_g_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      }
      if (this.ej == null) {
        this.ej = GPUBaseFilter.caculateCenterCropMvpMatrix(this.mVideoWidth, this.mVideoHeight, this.mSurfaceWidth, this.mSurfaceHeight);
      }
      if (this.dCc)
      {
        this.jdField_g_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose.drawTexture(this.mInputTextureID);
        this.jdField_g_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(32771, 771);
        GLES20.glBlendColor(0.0F, 0.0F, 0.0F, 0.8F);
        this.mTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose.getTextureId(), null, this.ej);
        GLES20.glDisable(3042);
      }
      else
      {
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(32771, 771);
        GLES20.glBlendColor(0.0F, 0.0F, 0.0F, 0.2F);
        this.mTextureRender.drawTexture(3553, this.mInputTextureID, null, this.ej);
        GLES20.glDisable(3042);
      }
    }
    this.mOutputTextureID = this.jdField_g_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    super.onSurfaceChange(paramInt1, paramInt2);
    initTexture(paramInt1, paramInt2);
    this.jdField_g_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceChange(this.mSurfaceWidth, this.mSurfaceHeight, this.mSurfaceWidth, this.mSurfaceHeight);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPtvVideoFilter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPtvVideoFilter.onSurfaceChange(paramInt1, paramInt2);
      adJ(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam.foregroundPath);
    }
  }
  
  public void onSurfaceCreate()
  {
    super.onSurfaceCreate();
    this.jdField_g_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceCreate(this.mSurfaceWidth, this.mSurfaceHeight, this.mSurfaceWidth, this.mSurfaceHeight);
    this.mTextureRender = new TextureRender();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPtvVideoFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPtvVideoFilter.onSurfaceCreate();
    }
    this.jdField_g_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.initAEDetector_sync();
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    this.jdField_g_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPtvVideoFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQPtvVideoFilter.onSurfaceDestroy();
    }
  }
  
  public void setVideoSize(int paramInt1, int paramInt2)
  {
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayyy
 * JD-Core Version:    0.7.0.1
 */