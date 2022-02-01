package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import android.os.SystemClock;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoy;
import com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceDetectTask;
import com.tencent.mobileqq.shortvideo.facedancegame.GestureDetectManager;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.util.PhoneProperty;
import java.util.TreeSet;

@SuppressLint({"NewApi"})
public class QQFaceDanceDetectFilter
  extends QQBaseFilter
{
  public static final String TAG = "QQFaceDanceDetect";
  boolean isInit = false;
  boolean isInitFaceDetectSDK = false;
  boolean isInitGestureDetectSDK = false;
  QQFilterRenderManager mFilterRenderManager;
  private VideoFilterBase mFlipFilter = new VideoFilterBase("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  public Frame mFlipFrame = new Frame();
  private int[] mFlipTextureID = new int[1];
  private RenderBuffer mRenderInFBO;
  private RenderBuffer mRenderOutFBO;
  private int scaleTexture;
  private boolean shouldInitTexture = false;
  private int surfaceHeight;
  private int surfaceWidth;
  private TextureRender textureRender;
  
  public QQFaceDanceDetectFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    this.mFilterRenderManager = paramQQFilterRenderManager;
  }
  
  private void initSDK()
  {
    if (!this.isInitFaceDetectSDK)
    {
      this.mFilterRenderManager.initAEDetector_sync();
      FaceDanceDetectTask.getInstance().setQQFilterRenderManager(this.mFilterRenderManager);
      this.isInitFaceDetectSDK = true;
    }
    if (!this.isInitGestureDetectSDK)
    {
      initGestureDetectSDK();
      this.isInitGestureDetectSDK = true;
    }
  }
  
  private void initTexture()
  {
    if (this.mRenderInFBO != null) {
      this.mRenderInFBO.destroy();
    }
    if (this.mRenderOutFBO != null) {
      this.mRenderOutFBO.destroy();
    }
    if (this.textureRender != null) {
      this.textureRender.release();
    }
    this.mRenderOutFBO = new RenderBuffer(this.surfaceWidth, this.surfaceHeight, 33984);
    this.textureRender = new TextureRender();
  }
  
  public void clearFlipFrame()
  {
    if (this.mFlipFrame != null) {
      this.mFlipFrame.clear();
    }
  }
  
  public void initGestureDetectSDK()
  {
    GestureDetectManager.getInstance().LoadSDK();
  }
  
  public boolean isFilterWork()
  {
    return QQFaceDanceMechineFilter.isEnableFaceDance;
  }
  
  public void onDrawFrame()
  {
    this.mOutputTextureID = this.mInputTextureID;
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    GLES20.glDeleteTextures(this.mFlipTextureID.length, this.mFlipTextureID, 0);
    FaceDanceDetectTask.getInstance().DestoryTask();
    if ((this.mFlipFilter != null) && (this.isInit))
    {
      this.mFlipFilter.clearGLSLSelf();
      this.mFlipFrame.clear();
    }
    this.isInit = false;
  }
  
  public void postDetectTask(TreeSet<GLLittleBoy> paramTreeSet)
  {
    if ((paramTreeSet == null) || (paramTreeSet.size() == 0)) {}
    do
    {
      return;
      initSDK();
    } while (FaceDanceDetectTask.getInstance().checkIsRunning());
    if (!this.isInit)
    {
      GLES20.glGenTextures(this.mFlipTextureID.length, this.mFlipTextureID, 0);
      this.mFlipFilter.clearGLSLSelf();
      this.mFlipFilter.ApplyGLSLFilter();
      this.mFlipFilter.setRotationAndFlip(0, false, true);
      this.isInit = true;
      return;
    }
    long l2 = SystemClock.elapsedRealtimeNanos();
    int i = this.mFilterRenderManager.getFaceDetectWidth();
    int j = this.mFilterRenderManager.getFaceDetectHeight();
    byte[] arrayOfByte = this.mFilterRenderManager.getFaceDetectDataByTexture(this.mInputTextureID, i, j);
    long l1 = SystemClock.elapsedRealtimeNanos();
    FaceDanceDetectTask.logTimeInfo("frist getFaceDetectDataByTexture", l2, l1);
    this.mFlipFilter.RenderProcess(this.mInputTextureID, getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight(), this.mFlipTextureID[0], 0.0D, this.mFlipFrame);
    if (PhoneProperty.instance().isCannotReuseFrameBuffer()) {
      this.mFlipFrame.clear();
    }
    l2 = SystemClock.elapsedRealtimeNanos();
    FaceDanceDetectTask.logTimeInfo("Flip Texture", l1, l2);
    FaceDanceDetectTask.logTimeInfo("second getFaceDetectDataByTexture", l2, SystemClock.elapsedRealtimeNanos());
    FaceDanceDetectTask.getInstance().postTask(arrayOfByte, this.mFlipFrame, i, j, paramTreeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQFaceDanceDetectFilter
 * JD-Core Version:    0.7.0.1
 */