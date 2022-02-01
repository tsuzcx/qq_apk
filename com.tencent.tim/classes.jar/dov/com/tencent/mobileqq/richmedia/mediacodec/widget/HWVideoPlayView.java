package dov.com.tencent.mobileqq.richmedia.mediacodec.widget;

import ambe;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import axvu;
import axvv;
import ayyl;
import ayzg;
import azbt;
import azbt.a;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import dov.com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder;
import dov.com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder.a;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import pog;
import rar;
import rpv;

@TargetApi(11)
public class HWVideoPlayView
  extends GLSurfaceView
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, HWDecodeListener
{
  private GLSurfaceView.EGLContextFactory jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory = new ayzg(this);
  private GPUOESBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter;
  protected AudioDecoder a;
  protected long aDp;
  private long ahS;
  public long ahT;
  protected final AudioDecoder.a b;
  private boolean cAK;
  public boolean dCd;
  private boolean dCe;
  protected boolean dCf;
  private boolean dCg;
  public int dzo;
  public int eNv;
  public int eNw;
  protected int eNx;
  public int frameCount;
  protected HWVideoDecoder hwVideoDecoder;
  protected int mCurrentState = 0;
  private HWDecodeListener mHWDecodeListener;
  private WeakReference<a> mListenerRef;
  protected int mSurfaceHeight;
  protected int mSurfaceWidth;
  private final DecodeConfig mVideoDecodeConfig = new DecodeConfig();
  public int mVideoHeight;
  public int mVideoWidth;
  protected SurfaceTexture surfaceTexture;
  private int textureId;
  public long videoDuration;
  
  public HWVideoPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HWVideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
    setEGLContextClientVersion(2);
    this.hwVideoDecoder = new HWVideoDecoder();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder = new AudioDecoder();
    this.b = new AudioDecoder.a();
    setRenderer(this);
    setRenderMode(0);
  }
  
  public void Z(int paramInt, boolean paramBoolean)
  {
    this.hwVideoDecoder.seekTo(paramInt);
    if (paramBoolean) {
      this.hwVideoDecoder.decodeFrame();
    }
  }
  
  public int a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (rpv.a(paramLocalMediaInfo)) {}
    for (this.eNx = (paramLocalMediaInfo.rotation + 90);; this.eNx = paramLocalMediaInfo.rotation)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoPlayView", 2, "adjustRotation: mVideoRotation=" + this.eNx);
      }
      return this.eNx;
    }
  }
  
  public void aH(long paramLong, boolean paramBoolean)
  {
    this.hwVideoDecoder.nextTo(paramLong);
    if (paramBoolean) {
      this.hwVideoDecoder.decodeFrame();
    }
  }
  
  public void dMb()
  {
    setPlayRange(0, 0);
  }
  
  protected void eUv()
  {
    if (axvu.dwO)
    {
      long l1 = System.currentTimeMillis();
      axvu.f.ay(2, l1);
      if (axvu.f.isEnabled())
      {
        l1 -= axvu.f.t[0];
        long l2 = axvu.f.t[1] - axvu.f.t[0];
        long l3 = axvu.f.t[2] - axvu.f.t[1];
        if ((rar.d(l1, 0L, 10000L)) && (rar.d(l2, 0L, 10000L)) && (rar.d(l3, 0L, 10000L))) {
          rar.a("OpenEditCost", true, l1, new String[] { String.valueOf(axvu.f.busType), String.valueOf(l2), String.valueOf(l3) });
        }
        axvu.f.stopMonitor();
      }
    }
  }
  
  protected void g(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.drawTexture(this.textureId, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public int getSpeedType()
  {
    return this.mVideoDecodeConfig.speedType;
  }
  
  public String getVideoFilePath()
  {
    return this.mVideoDecodeConfig.inputFilePath;
  }
  
  public int mi(int paramInt)
  {
    this.eNx = paramInt;
    return this.eNx;
  }
  
  public void onDecodeCancel()
  {
    if (Thread.currentThread().getId() == this.aDp) {
      this.mCurrentState = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "onDecodeCancel, mCurrentStat:", Integer.valueOf(this.mCurrentState) });
    }
    if (this.mHWDecodeListener != null) {
      this.mHWDecodeListener.onDecodeCancel();
    }
  }
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    QLog.e("HWVideoPlayView", 4, "onDecodeError errorCode = " + paramInt, paramThrowable);
    ambe.j(paramThrowable);
  }
  
  public void onDecodeFinish()
  {
    if (Thread.currentThread().getId() == this.aDp) {
      this.mCurrentState = 5;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "onDecodeFinish, mCurrentStat:", Integer.valueOf(this.mCurrentState) });
    }
    if (this.mHWDecodeListener != null) {
      this.mHWDecodeListener.onDecodeFinish();
    }
  }
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
    throws InterruptedException
  {
    if (this.mHWDecodeListener != null) {
      this.mHWDecodeListener.onDecodeFrame(paramLong1, paramLong2);
    }
  }
  
  public void onDecodeRepeat()
  {
    QLog.d("HWVideoPlayView", 4, "onDecodeRepeat");
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.dLH();
    if (this.mHWDecodeListener != null) {
      this.mHWDecodeListener.onDecodeRepeat();
    }
  }
  
  public void onDecodeSeekTo(long paramLong)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.seekTo(paramLong);
  }
  
  public void onDecodeStart()
  {
    this.mCurrentState = 3;
    this.aDp = Thread.currentThread().getId();
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "onDecodeStart, mCurrentStat:", Integer.valueOf(this.mCurrentState) });
    }
    if (this.mHWDecodeListener != null) {
      this.mHWDecodeListener.onDecodeStart();
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    try
    {
      if (this.surfaceTexture != null)
      {
        if (!this.dCg)
        {
          this.dCg = true;
          eUv();
        }
        long l1 = System.currentTimeMillis();
        if ((!this.cAK) && (this.frameCount > 15))
        {
          this.cAK = true;
          this.ahS = l1;
        }
        l1 = 0L;
        if (axvu.dwN)
        {
          axvu.d.startMonitor();
          l1 = SystemClock.elapsedRealtime();
        }
        this.surfaceTexture.updateTexImage();
        paramGL10 = new float[16];
        this.surfaceTexture.getTransformMatrix(paramGL10);
        g(paramGL10, GPUBaseFilter.caculateCenterCropMvpMatrix(this.mVideoWidth, this.mVideoHeight, this.mSurfaceWidth, this.mSurfaceHeight));
        this.frameCount += 1;
        if (axvu.d.isEnabled())
        {
          long l2 = SystemClock.elapsedRealtime();
          axvu.d.e(new Integer[] { Integer.valueOf((int)(l2 - l1)) });
          if (axvu.d.ov(8000)) {
            axvu.eOX();
          }
        }
      }
      return;
    }
    catch (Throwable paramGL10)
    {
      QLog.e("HWVideoPlayView", 2, "onDrawFrame error.", paramGL10);
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.surfaceTexture = paramSurfaceTexture;
    requestRender();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "onSurfaceChanged : " + paramInt1 + ";" + paramInt2);
    }
    this.textureId = GlUtil.createTexture(36197);
    if ((Build.VERSION.SDK_INT == 26) && (!Build.MANUFACTURER.equals("HUAWEI")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoPlayView", 4, "onSurfaceChanged special 8.0 device. Delay play.");
      }
      postDelayed(new HWVideoPlayView.2(this), 500L);
    }
    for (;;)
    {
      this.mSurfaceWidth = paramInt1;
      this.mSurfaceHeight = paramInt2;
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.onOutputSizeChanged(this.mVideoWidth, this.mVideoHeight);
      if (this.mListenerRef != null)
      {
        paramGL10 = (a)this.mListenerRef.get();
        if (paramGL10 != null) {
          paramGL10.eRU();
        }
      }
      return;
      startPlay();
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "onSurfaceCreated");
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter = ((GPUOESBaseFilter)ayyl.a(102));
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.init();
    this.dCe = false;
  }
  
  public void onSurfaceDestroy()
  {
    if (this.surfaceTexture != null)
    {
      this.surfaceTexture.release();
      this.surfaceTexture = null;
    }
    this.dCe = true;
    stopPlay();
    if (this.mListenerRef != null)
    {
      a locala = (a)this.mListenerRef.get();
      if (locala != null) {
        locala.eRV();
      }
    }
  }
  
  public void pausePlay()
  {
    this.hwVideoDecoder.pauseDecode();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.pausePlay();
    this.mCurrentState = 4;
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "pausePlay, mCurrentStat:", Integer.valueOf(this.mCurrentState) });
    }
    if (this.ahS != 0L)
    {
      this.ahT += System.currentTimeMillis() - this.ahS;
      this.dzo = (this.frameCount - 15);
      this.ahS = 0L;
    }
  }
  
  public void resumePlay()
  {
    this.hwVideoDecoder.resumeDecode();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.resumePlay();
    this.mCurrentState = 3;
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "resumePlay, mCurrentStat:", Integer.valueOf(this.mCurrentState) });
    }
    if (this.ahS == 0L) {
      this.ahS = System.currentTimeMillis();
    }
  }
  
  public void setBgmFilePath(String paramString)
  {
    this.b.cYj = paramString;
    this.b.b = AudioEncoder.a(paramString, null, 0);
  }
  
  public void setDecodeListener(HWDecodeListener paramHWDecodeListener)
  {
    this.mHWDecodeListener = paramHWDecodeListener;
  }
  
  public void setFilePath(String paramString1, String paramString2)
  {
    this.mVideoDecodeConfig.inputFilePath = paramString1;
    this.b.audioFilePath = paramString2;
    this.b.a = AudioEncoder.a(paramString2, null, 0);
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, "setFilePath: videoFilePath = " + this.mVideoDecodeConfig.inputFilePath + " ; audioFilePath = " + paramString2);
    }
    int m;
    int i;
    int j;
    if ((this.videoDuration == 0L) || (this.mVideoWidth == 0) || (this.mVideoHeight == 0))
    {
      this.videoDuration = pog.getDurationOfVideo(this.mVideoDecodeConfig.inputFilePath);
      this.b.videoDurationMs = this.videoDuration;
      paramString2 = new azbt.a();
      m = azbt.a(paramString1, paramString2);
      i = paramString2.mMetaData[0];
      j = paramString2.mMetaData[1];
      if ((this.eNx != 90) && (this.eNx != 270)) {
        break label323;
      }
    }
    label323:
    for (int k = j;; k = i)
    {
      this.mVideoWidth = k;
      if ((this.eNx == 90) || (this.eNx == 270)) {
        j = i;
      }
      this.mVideoHeight = j;
      this.eNv = this.mVideoWidth;
      this.eNw = this.mVideoHeight;
      QLog.d("HWVideoPlayView", 1, "setFilePath: errcode = " + m + " ; videoWidth = " + this.mVideoWidth + " , videoHeight=" + this.mVideoHeight + " , mVideoRotation=" + this.eNx + " , rotation=" + paramString2.mMetaData[2] + " videoDuration=" + this.videoDuration);
      return;
    }
  }
  
  public void setMediaInfo(LocalMediaInfo paramLocalMediaInfo)
  {
    this.videoDuration = paramLocalMediaInfo.mDuration;
    this.b.videoDurationMs = this.videoDuration;
    int i = paramLocalMediaInfo.mediaWidth;
    int j = paramLocalMediaInfo.mediaHeight;
    if ((this.eNx == 90) || (this.eNx == 270)) {}
    for (int k = j;; k = i)
    {
      this.mVideoWidth = k;
      if ((this.eNx == 90) || (this.eNx == 270)) {
        j = i;
      }
      this.mVideoHeight = j;
      this.eNv = this.mVideoWidth;
      this.eNw = this.mVideoHeight;
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoPlayView", 2, "videoWidth = " + this.mVideoWidth + " , videoHeight=" + this.mVideoHeight + " , mVideoRotation=" + this.eNx + " videoDuration=" + this.videoDuration);
      }
      return;
    }
  }
  
  public void setMuteAudio(boolean paramBoolean)
  {
    this.b.mMuteAudio = paramBoolean;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.setMuteAudio(paramBoolean);
  }
  
  public void setPlayRange(int paramInt1, int paramInt2)
  {
    if (this.mVideoDecodeConfig != null)
    {
      this.mVideoDecodeConfig.startTimeMillSecond = paramInt1;
      this.mVideoDecodeConfig.endTimeMillSecond = paramInt2;
    }
    if (this.b != null)
    {
      this.b.startTimeMs = paramInt1;
      this.b.endTimeMs = paramInt2;
    }
    if (this.hwVideoDecoder != null) {
      this.hwVideoDecoder.setPlayRange(paramInt1, paramInt2);
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.setPlayRange(paramInt1, paramInt2);
    }
  }
  
  public void setPlayViewListener(a parama)
  {
    if (parama == null)
    {
      this.mListenerRef = null;
      return;
    }
    this.mListenerRef = new WeakReference(parama);
  }
  
  public void setProlong(long paramLong)
  {
    this.mVideoDecodeConfig.prolongToTime = paramLong;
    this.hwVideoDecoder.setProlongToTime(paramLong);
  }
  
  public void setRepeat(boolean paramBoolean)
  {
    this.mVideoDecodeConfig.repeat = paramBoolean;
    this.b.repeat = paramBoolean;
  }
  
  public void setSpeedType(int paramInt)
  {
    this.mVideoDecodeConfig.speedType = paramInt;
    this.b.speedType = paramInt;
    this.hwVideoDecoder.setSpeedType(paramInt);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.setSpeedType(paramInt);
  }
  
  public void setVideoDecodeConfig(DecodeConfig paramDecodeConfig)
  {
    this.mVideoDecodeConfig.copyFrom(paramDecodeConfig);
  }
  
  public void setVolume(float paramFloat)
  {
    this.b.a.zO = paramFloat;
  }
  
  public void startPlay()
  {
    if (TextUtils.isEmpty(this.mVideoDecodeConfig.inputFilePath)) {
      throw new RuntimeException("startPlay failed. videoFilePath is empty.");
    }
    this.hwVideoDecoder.stopDecode();
    this.mCurrentState = 1;
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "startPlay, mCurrentStat:", Integer.valueOf(this.mCurrentState) });
    }
    this.hwVideoDecoder.startDecode(this.mVideoDecodeConfig, this.textureId, this, this);
    if (!TextUtils.isEmpty(this.b.audioFilePath)) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a(this.b);
    }
  }
  
  public void stopPlay()
  {
    this.hwVideoDecoder.pauseDecode();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.pausePlay();
    this.hwVideoDecoder.stopDecode();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.stopAudio();
    if ((this.cAK) && (this.ahS > 0L))
    {
      this.ahT = (System.currentTimeMillis() - this.ahS);
      this.dzo = (this.frameCount - 15);
      this.ahS = 0L;
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "surfaceDestroyed");
    }
    super.surfaceDestroyed(paramSurfaceHolder);
    stopPlay();
  }
  
  public static abstract interface a
  {
    public abstract void eRU();
    
    public abstract void eRV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.widget.HWVideoPlayView
 * JD-Core Version:    0.7.0.1
 */