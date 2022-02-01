package com.tencent.mobileqq.richmedia.capture.view;

import aary;
import aath;
import aeah;
import alwb;
import alwt;
import alwx;
import alwy;
import alxa;
import alxa.a;
import alxg;
import alxo;
import alxp;
import alxq;
import alxr;
import amae;
import amal;
import aman;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.hardware.Camera;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import anhk;
import anho;
import anii;
import anij;
import anij.b;
import anil;
import anil.a;
import anim;
import anim.d;
import aniq;
import anjn;
import ankj;
import aqha;
import aqhq;
import awxf;
import axgk;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.a;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture.a;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQLowLightFilter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

@TargetApi(18)
public class CameraCaptureView
  extends GLSurfaceView
  implements amal, SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, anho, anil.a, anim.d, CameraCover.a, AudioCapture.a
{
  public static final anim b;
  private View Go;
  protected alwb a;
  private alxa.a jdField_a_of_type_Alxa$a;
  private alxa jdField_a_of_type_Alxa;
  protected amae a;
  private GLSurfaceView.EGLContextFactory jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory = new alxo(this);
  protected OrientationEventListener a;
  private anil jdField_a_of_type_Anil;
  protected AudioCapture a;
  private b jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$b;
  protected c a;
  protected d a;
  public e a;
  private f jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$f;
  public g a;
  protected EglHandlerThread a;
  public EGLConfig a;
  protected long ahP;
  protected long ahQ;
  private long ahR = System.currentTimeMillis();
  private long ahS;
  public long ahT;
  protected aary b;
  protected aman b;
  protected VideoCaptureResult b;
  protected SurfaceTexture c;
  private boolean cAA = true;
  private boolean cAB;
  protected boolean cAC = true;
  protected boolean cAD;
  protected boolean cAE;
  public boolean cAF = true;
  protected boolean cAG;
  private boolean cAH;
  private volatile boolean cAI;
  private volatile boolean cAJ;
  private boolean cAK;
  private boolean cAL = true;
  private boolean cAM;
  protected boolean cAN = true;
  private boolean cAq;
  private volatile boolean cAr;
  private boolean cAs;
  protected volatile boolean cAt;
  protected boolean cAu;
  protected volatile boolean cAv;
  private boolean cAw;
  private boolean cAx;
  private boolean cAy;
  private boolean cAz;
  protected int cIN;
  protected int dyL = 2;
  protected int dyS;
  protected int dyT;
  protected int dyU;
  protected int dyV;
  protected int dyW;
  protected int dyX;
  protected int dyY;
  protected int dyZ;
  protected int dza;
  protected int dzb;
  protected int dzc;
  protected int dzd;
  private int dze;
  private int dzf;
  protected int dzg;
  protected int dzh;
  private int dzi;
  private int dzj;
  private int dzk;
  private int dzl;
  public int dzm;
  public int dzn = 90;
  public int dzo;
  public EGLContext eglContext;
  public int frameCount;
  private boolean inited;
  private boolean isPaused;
  protected final float[] mSTMatrix = new float[16];
  protected Map<String, RenderBuffer> mV = new HashMap();
  public int orientation = 90;
  public int surfaceHeight;
  public int surfaceWidth;
  protected TextureRender textureRender;
  private Handler uiHandler;
  protected int videoHeight;
  protected int videoWidth;
  
  static
  {
    jdField_b_of_type_Anim = new anim(null, null);
  }
  
  public CameraCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
  }
  
  public CameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
  }
  
  private void CO(boolean paramBoolean)
  {
    Activity localActivity = (Activity)getContext();
    if (paramBoolean)
    {
      if (this.Go == null) {
        this.Go = new View(localActivity);
      }
      this.Go.setBackgroundColor(-1);
      this.Go.setAlpha(0.7F);
      if (this.Go.getParent() != null) {
        ((ViewGroup)this.Go.getParent()).removeView(this.Go);
      }
      localActivity.addContentView(this.Go, new ViewGroup.LayoutParams(-1, -1));
    }
    do
    {
      try
      {
        this.dzi = Settings.System.getInt(localActivity.getContentResolver(), "screen_brightness_mode");
        Settings.System.putInt(localActivity.getContentResolver(), "screen_brightness_mode", 0);
        this.dzj = Settings.System.getInt(localActivity.getContentResolver(), "screen_brightness");
        Settings.System.putInt(localActivity.getContentResolver(), "screen_brightness", 255);
        this.cAz = true;
        return;
      }
      catch (Exception localException)
      {
        do
        {
          this.dzi = 1;
          this.dzj = 100;
        } while (!QLog.isColorLevel());
        QLog.e("CameraCaptureView", 2, "turn FrontFlash Error ", localException);
        localException.printStackTrace();
        return;
      }
      if (this.cAz)
      {
        Settings.System.putInt(localException.getContentResolver(), "screen_brightness", this.dzj);
        Settings.System.putInt(localException.getContentResolver(), "screen_brightness_mode", this.dzi);
        this.cAz = false;
      }
    } while ((this.Go == null) || (this.Go.getParent() == null));
    ((ViewGroup)this.Go.getParent()).removeView(this.Go);
  }
  
  private void Os(boolean paramBoolean)
  {
    if (this.dyL == 1)
    {
      CO(paramBoolean);
      return;
    }
    jdField_b_of_type_Anim.PS(paramBoolean);
  }
  
  private void dKP()
  {
    if (!this.inited) {
      throw new RuntimeException("Not inited. Must be called after setCaptureParam");
    }
  }
  
  private void dKY() {}
  
  public void AE(String paramString)
  {
    b(new h(1, 0, paramString, null, this.orientation));
  }
  
  protected int C(boolean paramBoolean)
  {
    int i = this.cIN;
    if (paramBoolean) {
      paramBoolean = auS();
    }
    int k;
    int j;
    for (;;)
    {
      if (!this.cAE) {
        break label571;
      }
      if (paramBoolean)
      {
        Object localObject1 = (RenderBuffer)this.mV.get(e.bZn);
        if (localObject1 != null) {
          ((RenderBuffer)localObject1).bind();
        }
        synchronized (this.c)
        {
          this.c.getTransformMatrix(this.mSTMatrix);
          this.textureRender.drawTexture(36197, this.cIN, this.mSTMatrix, null);
          QmcfManager.getInstance().setSTMatrix(this.mSTMatrix);
          QmcfManager.getInstance().setIsQQRun(false);
          dKY();
          i = ((RenderBuffer)localObject1).getTexId();
          ((RenderBuffer)localObject1).unbind();
          ??? = (RenderBuffer)this.mV.get(e.bZo);
          k = i;
          if (??? != null)
          {
            k = i;
            if (localObject1 != null)
            {
              if (((RenderBuffer)localObject1).getWidth() == ((RenderBuffer)???).getWidth())
              {
                j = i;
                if (((RenderBuffer)localObject1).getHeight() == ((RenderBuffer)???).getHeight()) {}
              }
              else
              {
                ((RenderBuffer)???).bind();
                localObject1 = GPUBaseFilter.caculateCenterCropMvpMatrix(((RenderBuffer)localObject1).getWidth(), ((RenderBuffer)localObject1).getHeight(), ((RenderBuffer)???).getWidth(), ((RenderBuffer)???).getHeight());
                this.textureRender.drawTexture(3553, i, null, (float[])localObject1);
                j = ((RenderBuffer)???).getTexId();
                ((RenderBuffer)???).unbind();
              }
              if (this.dzc == ((RenderBuffer)???).getWidth())
              {
                k = j;
                if (this.dzd == ((RenderBuffer)???).getHeight()) {}
              }
              else
              {
                Op(true);
                k = j;
              }
            }
          }
          return k;
          if (this.cAE) {
            paramBoolean = auT();
          } else {
            paramBoolean = false;
          }
        }
      }
    }
    Object localObject3 = (RenderBuffer)this.mV.get(e.bZl);
    if (localObject3 != null) {
      ((RenderBuffer)localObject3).bind();
    }
    synchronized (this.c)
    {
      this.c.getTransformMatrix(this.mSTMatrix);
      this.textureRender.drawTexture(36197, this.cIN, this.mSTMatrix, null);
      QmcfManager.getInstance().setSTMatrix(this.mSTMatrix);
      QmcfManager.getInstance().setIsQQRun(false);
      dKY();
      i = ((RenderBuffer)localObject3).getTexId();
      ((RenderBuffer)localObject3).unbind();
      ??? = (RenderBuffer)this.mV.get(e.bZm);
      k = i;
      if (??? != null)
      {
        k = i;
        if (localObject3 != null)
        {
          if (((RenderBuffer)localObject3).getWidth() == ((RenderBuffer)???).getWidth())
          {
            j = i;
            if (((RenderBuffer)localObject3).getHeight() == ((RenderBuffer)???).getHeight()) {}
          }
          else
          {
            ((RenderBuffer)???).bind();
            localObject3 = GPUBaseFilter.caculateCenterCropMvpMatrix(((RenderBuffer)localObject3).getWidth(), ((RenderBuffer)localObject3).getHeight(), ((RenderBuffer)???).getWidth(), ((RenderBuffer)???).getHeight());
            this.textureRender.drawTexture(3553, i, null, (float[])localObject3);
            j = ((RenderBuffer)???).getTexId();
            ((RenderBuffer)???).unbind();
          }
          if (this.dzc == ((RenderBuffer)???).getWidth())
          {
            k = j;
            if (this.dzd == ((RenderBuffer)???).getHeight()) {}
          }
          else
          {
            Op(false);
            k = j;
          }
        }
      }
      return k;
    }
    label571:
    ??? = (RenderBuffer)this.mV.get(e.bZk);
    if (??? != null)
    {
      ((RenderBuffer)???).bind();
      synchronized (this.c)
      {
        this.c.getTransformMatrix(this.mSTMatrix);
        float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.dyS, this.dyT, ((RenderBuffer)???).getWidth(), ((RenderBuffer)???).getHeight());
        this.textureRender.drawTexture(36197, this.cIN, this.mSTMatrix, arrayOfFloat);
        QmcfManager.getInstance().setSTMatrix(this.mSTMatrix);
        dKY();
        ((RenderBuffer)???).unbind();
        return ((RenderBuffer)???).getTexId();
      }
    }
    return i;
  }
  
  public int Is()
  {
    return this.dyL;
  }
  
  protected int It()
  {
    return this.surfaceWidth;
  }
  
  protected int Iu()
  {
    return this.surfaceHeight;
  }
  
  protected void Op(boolean paramBoolean)
  {
    int[] arrayOfInt;
    if (this.cAE)
    {
      if (!paramBoolean) {
        break label235;
      }
      this.dzd = this.dyX;
      this.dzc = this.dyW;
      if (!this.cAD) {
        break label191;
      }
      arrayOfInt = alwy.a(this.dyY, this.dyZ, this.surfaceWidth, this.surfaceHeight, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.zb);
      this.videoWidth = arrayOfInt[0];
      this.videoHeight = arrayOfInt[1];
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Aary != null) {
        this.jdField_b_of_type_Aary.G(this.dzd, this.dzc, It(), Iu());
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "compress=" + paramBoolean + " onCameraSizeUpdate cameraClipHeight = " + this.dzd + " cameraClipWidth=" + this.dzc + " videoWidth=" + this.videoWidth + " videoHeight=" + this.videoHeight);
      }
      return;
      label191:
      arrayOfInt = alwy.a(this.dza, this.dzb, this.surfaceWidth, this.surfaceHeight, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.zb);
      this.videoWidth = arrayOfInt[0];
      this.videoHeight = arrayOfInt[1];
      continue;
      label235:
      this.dzd = this.dyV;
      this.dzc = this.dyU;
      arrayOfInt = alwy.a(this.dyY, this.dyZ, this.surfaceWidth, this.surfaceHeight, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.zb);
      this.videoWidth = arrayOfInt[0];
      this.videoHeight = arrayOfInt[1];
    }
  }
  
  public void Oq(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.resume();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.pause();
  }
  
  public void Or(boolean paramBoolean)
  {
    dKP();
    try
    {
      QQLowLightFilter.enableNightMode(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void Ot(boolean paramBoolean)
  {
    jdField_b_of_type_Anim.PU(paramBoolean);
  }
  
  public void Ou(boolean paramBoolean)
  {
    this.cAL = paramBoolean;
  }
  
  public void Pl(String paramString)
  {
    if (!this.jdField_a_of_type_Alwb.isActive())
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "onAudioCaptured filePath = " + paramString);
      }
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath = paramString;
      if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath != null) {
        b(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
      }
    }
  }
  
  public void Pm(String paramString)
  {
    if (this.jdField_a_of_type_Alwb.isActive())
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "onAudioCaptured filePath = " + paramString);
      }
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath = paramString;
      if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath != null) {
        b(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
      }
    }
  }
  
  public void Pn(String paramString) {}
  
  protected void TL(int paramInt) {}
  
  protected void TM(int paramInt)
  {
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
    this.textureRender.drawTexture(3553, paramInt, null, null);
  }
  
  public void Tx(int paramInt)
  {
    QLog.e("CameraCaptureView", 2, "onAudioError. errorCode = " + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    }
    ThreadManager.getUIHandler().post(new CameraCaptureView.12(this));
  }
  
  public void X(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_b_of_type_Aary == null) {
      return;
    }
    dKP();
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureView", 2, "requestCameraFocus x:" + paramFloat1 + "y: " + paramFloat2 + ", Orientation:" + ((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation());
    }
    anhk localanhk = new anhk();
    localanhk.x = paramFloat1;
    localanhk.y = paramFloat2;
    localanhk.screenWidth = It();
    localanhk.dGb = Iu();
    localanhk.c = this.jdField_b_of_type_Aary;
    localanhk.mOrientation = alwy.iP(this.dzm);
    jdField_b_of_type_Anim.a(localanhk, new alxq(this));
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.errorCode = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d.onCaptureError(104);
    }
  }
  
  protected void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    c(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, SystemClock.elapsedRealtimeNanos());
  }
  
  protected void a(anij.b paramb)
  {
    this.dyT = paramb.width;
    this.dyS = paramb.height;
    if (!this.cAE)
    {
      paramb = alwy.a(this.dyS, this.dyT, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.clipWidth, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.clipHeight, 1.0F);
      this.dzc = paramb[0];
      this.dzd = paramb[1];
      paramb = alwy.a(this.dyS, this.dyT, this.surfaceWidth, this.surfaceHeight, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.zb);
      this.videoWidth = paramb[0];
      this.videoHeight = paramb[1];
      paramb = alwy.b(e.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e), this.videoWidth, this.videoHeight);
      this.videoWidth = paramb[0];
      this.videoHeight = paramb[1];
      e.bZk = "key_aio_fbo" + this.dzc + this.dzd;
      queueEvent(new CameraCaptureView.7(this));
      if (QLog.isColorLevel()) {
        QLog.i("CameraCaptureView", 2, "onCameraSizeSelected(): cameraPreviewWidth=" + this.dyS + ",cameraPreviewHeight=" + this.dyT);
      }
    }
    int i;
    int j;
    int k;
    int m;
    do
    {
      return;
      paramb = alwy.b(e.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e), this.dyS, this.dyT);
      i = paramb[0];
      j = paramb[1];
      e.bZl = "key_riji_h_compress_fbo" + i + j;
      paramb = alwy.a(i, j, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.clipWidth, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.clipHeight, 1.0F);
      this.dyU = paramb[0];
      this.dyV = paramb[1];
      e.bZm = "key_riji_h_clip_fbo" + this.dyU + this.dyV;
      this.dyY = this.dyU;
      this.dyZ = this.dyV;
      e.f(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e);
      paramb = alwy.b(e.g(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e), this.dyS, this.dyT);
      k = paramb[0];
      m = paramb[1];
      e.bZn = "key_riji_l_compress_fbo" + k + m;
      paramb = alwy.a(k, m, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.clipWidth, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.clipHeight, 1.0F);
      this.dyW = paramb[0];
      this.dyX = paramb[1];
      e.bZo = "key_riji_l_clip_fbo" + this.dyW + this.dyX;
      this.dza = this.dyW;
      this.dzb = this.dyX;
      queueEvent(new CameraCaptureView.8(this, i, j, k, m));
    } while (!QLog.isColorLevel());
    QLog.i("CameraCaptureView", 2, "onCameraSizeSelected(): cameraPreviewWidth=" + this.dyS + ",cameraPreviewHeight=" + this.dyT + "， highCompressCameraPreviewWidth=" + i + ",highCompressCamerareviewHeight=" + j + "， highCameraClipWidth=" + this.dyU + ",highCameraClipHeight=" + this.dyV + ", highVideoWidth=" + this.dyY + ",highVideoHeight=" + this.dyZ + " ,lowCompressCameraPreviewWidth=" + k + ",lowCompressCamerareviewHeight=" + m + " ,lowCameraClipWidth=" + this.dyW + " ,lowCameraClipHeight=" + this.dyX + ",lowVideoWidth=" + this.dza + " ,lowVideoHeight=" + this.dzb);
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, " notify : eventId = " + paramInt + " ; sender = " + paramObject + " ; args = " + Arrays.toString(paramVarArgs));
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!(paramVarArgs[0] instanceof anij.b)) {
                  break;
                }
                a((anij.b)paramVarArgs[0]);
              } while (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d == null);
              this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d.ac(true, "");
              return;
            } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d == null));
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d.ac(false, (String)paramVarArgs[0]);
            return;
          } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d == null));
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d.ac(false, (String)paramVarArgs[0]);
          return;
        } while ((!(paramVarArgs[0] instanceof Integer)) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d == null));
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d.ac(false, "[Camera2]openCamera2 error:" + paramVarArgs[0]);
        return;
        if (!(paramVarArgs[0] instanceof anij.b)) {
          break;
        }
        a((anij.b)paramVarArgs[0]);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d != null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d.ac(true, "");
        }
      } while ((paramVarArgs.length < 2) || (!(paramVarArgs[1] instanceof anij.b)));
      paramObject = (anij.b)paramVarArgs[1];
      this.dzk = paramObject.width;
      this.dzl = paramObject.height;
      return;
    } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d == null));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d.ac(false, "[Camera2]setCamera2 Params error:" + paramVarArgs[0]);
  }
  
  public void a(RuntimeException paramRuntimeException) {}
  
  protected void aX(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = (this.orientation + 360 - 90) % 360;
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "captureFrame : width = " + paramInt2 + " ; height = " + paramInt3 + " ; orientation = " + i);
    }
    try
    {
      RenderBuffer localRenderBuffer = new RenderBuffer(paramInt2, paramInt3, 33984);
      localRenderBuffer.bind();
      this.textureRender.drawTexture(3553, paramInt1, null, null);
      localRenderBuffer.unbind();
      Bitmap localBitmap = GlUtil.captureFrame(localRenderBuffer.getTexId(), paramInt2, paramInt3, -i);
      localRenderBuffer.destroy();
      ThreadManager.excute(new CameraCaptureView.16(this, localBitmap), 64, null, false);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d == null) {}
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d.onCaptureError(103);
    }
  }
  
  protected boolean auO()
  {
    return aeah.afY();
  }
  
  public boolean auR()
  {
    return (this.videoWidth != 0) && (this.videoHeight != 0);
  }
  
  protected boolean auS()
  {
    return false;
  }
  
  protected boolean auT()
  {
    return false;
  }
  
  public boolean auU()
  {
    return this.cAt;
  }
  
  public void auv()
  {
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoFrameCount = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.cAP) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null))
    {
      if (!this.jdField_a_of_type_Alwb.isActive()) {
        break label66;
      }
      this.jdField_a_of_type_Alwb.init();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.startRecord();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d.bSV();
      }
      return;
      label66:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.startRecord();
    }
  }
  
  protected void b(VideoCaptureResult paramVideoCaptureResult)
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d.a(paramVideoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new CameraCaptureView.11(this));
    alxg.dKD();
    if (anij.a().dGP == 1) {}
    for (;;)
    {
      alwx.TH(i);
      return;
      i = 2;
    }
  }
  
  protected void b(h paramh)
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d.a(paramh);
    }
    ThreadManager.getUIHandler().post(new CameraCaptureView.10(this));
    alxg.dKC();
    if (anij.a().dGP == 1) {}
    for (;;)
    {
      alwx.TF(i);
      return;
      i = 2;
    }
  }
  
  public boolean bj(boolean paramBoolean)
  {
    dKP();
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 23))
    {
      Activity localActivity = (Activity)getContext();
      if (!Settings.System.canWrite(localActivity)) {
        aqha.b(localActivity, null, null);
      }
    }
    for (boolean bool = false;; bool = true)
    {
      if (bool) {
        this.cAy = paramBoolean;
      }
      return bool;
    }
  }
  
  public void btD()
  {
    VideoCaptureResult localVideoCaptureResult = this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult;
    localVideoCaptureResult.videoFrameCount += 1;
  }
  
  protected void c(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if ((this.cAt) && (this.jdField_a_of_type_Amae != null))
    {
      switch (this.dzg)
      {
      default: 
        throw new RuntimeException("unknown status " + this.dzg);
      case 0: 
        this.jdField_a_of_type_Amae.a(EGL14.eglGetCurrentContext());
        this.jdField_b_of_type_Aman.dLX();
        this.jdField_b_of_type_Aman.a(this.jdField_a_of_type_Amae, this);
        this.dzg = 1;
      }
      this.jdField_b_of_type_Aman.f(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      return;
    }
    switch (this.dzg)
    {
    case 0: 
    default: 
      throw new RuntimeException("unknown status " + this.dzg);
    }
    this.jdField_b_of_type_Aman.stopRecording();
    dKZ();
    this.dzg = 0;
  }
  
  protected void cTt()
  {
    boolean bool = true;
    if (!this.inited) {}
    while (this.cAr) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "openCamera");
    }
    this.cAs = false;
    this.dze = 0;
    this.dzf = 0;
    jdField_b_of_type_Anim.b(this);
    jdField_b_of_type_Anim.UW(this.dyL);
    this.cAr = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.cAP) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.dJZ();
    }
    aary localaary;
    if (this.jdField_b_of_type_Aary != null)
    {
      localaary = this.jdField_b_of_type_Aary;
      if (this.dyL != 1) {
        break label127;
      }
    }
    for (;;)
    {
      localaary.setMirror(bool);
      aaqh.cix = this.dyL;
      return;
      label127:
      bool = false;
    }
  }
  
  public void cTu()
  {
    if (!this.inited) {}
    while ((!this.cAw) || (!this.cAr) || ((this.cAs) && (this.dze == this.surfaceWidth) && (this.dzf == this.surfaceHeight))) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.clipWidth == 0) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.clipHeight == 0) || (this.cAL))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.clipWidth = this.surfaceWidth;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.clipHeight = this.surfaceHeight;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "startCameraPreview, clipWidth:" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.clipWidth + ", clipHeight:" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.clipHeight + ", surfaceWidth:" + this.surfaceWidth + ", surfaceHeight:" + this.surfaceHeight);
    }
    if (this.cAE) {
      jdField_b_of_type_Anim.a(new anij.b(this.surfaceHeight, this.surfaceWidth), new anij.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.clipWidth, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.clipHeight), 0, 30, this.cAE);
    }
    for (;;)
    {
      jdField_b_of_type_Anim.a(this.c, null, this, true);
      dKS();
      this.cAs = true;
      this.dze = this.surfaceWidth;
      this.dzf = this.surfaceHeight;
      return;
      jdField_b_of_type_Anim.a(new anij.b(e.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e), e.c(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e)), new anij.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.clipWidth, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.clipHeight), 0, 30, this.cAE);
    }
  }
  
  public void d(Exception paramException) {}
  
  public void dKM()
  {
    dKP();
    if (this.cAy) {
      Os(true);
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.bZj + "/" + System.currentTimeMillis() + ".mp4";
    if (this.cAC) {}
    for (int i = alwy.iO(this.orientation);; i = 0)
    {
      this.jdField_a_of_type_Amae = new amae(str, this.videoWidth, this.videoHeight, e.d(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e), e.e(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e), false, i);
      this.jdField_a_of_type_Amae.dzA = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.dzA;
      this.jdField_a_of_type_Amae.dzB = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.dzB;
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = new VideoCaptureResult();
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.orientation = this.orientation;
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.type = 0;
      if (this.dyL == 2) {
        jdField_b_of_type_Anim.dQp();
      }
      this.ahP = System.currentTimeMillis();
      this.cAt = true;
      alwy.cr(false, false);
      return;
    }
  }
  
  public void dKN()
  {
    if (this.cAt)
    {
      this.cAt = false;
      if (this.dzg != 0) {
        break label81;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d.onCaptureError(102);
      }
    }
    for (;;)
    {
      jdField_b_of_type_Anim.dQq();
      jdField_b_of_type_Anim.cye();
      this.ahQ = System.currentTimeMillis();
      alxg.videoDuration = this.ahQ - this.ahP;
      alwx.videoDuration = this.ahQ - this.ahP;
      return;
      label81:
      if (this.isPaused) {
        a(0, null, null);
      }
    }
  }
  
  public void dKQ()
  {
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$c != null))
    {
      Activity localActivity = (Activity)getContext();
      i = localActivity.checkSelfPermission("android.permission.CAMERA");
      int j = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, new Object[] { "startCameraWithPermission, camera: ", Integer.valueOf(i), " audio: ", Integer.valueOf(j) });
      }
      if ((i != 0) || (j != 0)) {
        if (!this.cAI)
        {
          this.cAI = true;
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$c.dLc();
        }
      }
    }
    for (;;)
    {
      return;
      for (i = 0; (i != 0) || (this.cAJ); i = 1)
      {
        cTt();
        cTu();
        return;
      }
    }
  }
  
  public void dKR()
  {
    if (!this.inited) {}
    do
    {
      do
      {
        return;
      } while (!this.cAr);
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "stopCamera");
      }
      jdField_b_of_type_Anim.PQ(false);
      this.cAs = false;
      jdField_b_of_type_Anim.PR(this.cAB);
      this.cAr = false;
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.cAP) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.dKa();
      }
      jdField_b_of_type_Anim.c(this);
      jdField_b_of_type_Anim.c(PeakAppInterface.a);
      alwt.Ty(this.dyL);
    } while ((!this.cAK) || (this.ahS <= 0L));
    this.ahT = (System.currentTimeMillis() - this.ahS);
    this.dzo = (this.frameCount - 15);
    this.ahS = 0L;
  }
  
  protected void dKS() {}
  
  public void dKT()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "changeCamera");
    }
    dKP();
    if (!aeah.agb()) {
      return;
    }
    aary localaary;
    if (this.dyL == 1)
    {
      this.dyL = 2;
      if (this.jdField_b_of_type_Aary != null)
      {
        localaary = this.jdField_b_of_type_Aary;
        if (this.dyL != 1) {
          break label134;
        }
      }
    }
    label134:
    for (boolean bool = true;; bool = false)
    {
      localaary.setMirror(bool);
      this.cAx = false;
      QmcfManager.getInstance().setCameraMode(this.dyL);
      aath.a().Dd(true);
      dKR();
      cTt();
      cTu();
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$b != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$b.dLb();
      }
      TL(this.dyL);
      return;
      this.dyL = 1;
      break;
    }
  }
  
  public void dKU()
  {
    int i = 0;
    dKP();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d.bSU();
    }
    Object localObject;
    boolean bool;
    if (auO())
    {
      if (this.cAy) {
        Os(true);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.bZj + "/" + System.currentTimeMillis() + ".jpg";
      aqhq.UD((String)localObject);
      localObject = new File((String)localObject);
      if (this.dyL == 1)
      {
        bool = true;
        if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.autoRotate) {
          break label219;
        }
        i = alwy.iP(this.dzm);
        label121:
        if (QLog.isColorLevel()) {
          QLog.i("CameraCaptureView", 2, "photoOrientation:" + i);
        }
        if ((!this.cAy) || (this.cAx)) {
          break label224;
        }
        jdField_b_of_type_Anim.a(new anhk(true), new alxr(this, (File)localObject, i, bool));
        label193:
        if (QLog.isColorLevel()) {
          QLog.d("CameraCaptureView", 2, "capturePhoto, use sysCamera");
        }
      }
    }
    for (;;)
    {
      dKV();
      return;
      bool = false;
      break;
      label219:
      i = 0;
      break label121;
      label224:
      jdField_b_of_type_Anim.a((File)localObject, new Rect(0, 0, this.surfaceWidth, this.surfaceHeight), this, i, bool, 1, this.dzm);
      break label193;
      if (this.cAy)
      {
        i = 1500;
        Os(true);
      }
      this.uiHandler.postDelayed(new CameraCaptureView.6(this), i);
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "capturePhoto, use captureFrame");
      }
    }
  }
  
  protected void dKV() {}
  
  protected void dKW()
  {
    alxg.dD(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoFrameCount, this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath);
  }
  
  protected void dKX()
  {
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new alxp(this, getContext());
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d.bST();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "Create to FirstFrameShown cost : " + (System.currentTimeMillis() - this.ahR) + "ms");
    }
  }
  
  protected void dKZ() {}
  
  public void dKe() {}
  
  public void dKf() {}
  
  public void dLa()
  {
    queueEvent(new CameraCaptureView.17(this));
  }
  
  public MediaFormat getMediaFormat()
  {
    if (this.jdField_b_of_type_Aman != null) {
      return this.jdField_b_of_type_Aman.getMediaFormat();
    }
    return null;
  }
  
  protected int iT(int paramInt)
  {
    return paramInt;
  }
  
  protected int iU(int paramInt)
  {
    return paramInt;
  }
  
  protected void init()
  {
    this.dyL = e.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e);
    if ((this.dyL == 1) && (!aeah.agb())) {
      this.dyL = 2;
    }
    if (this.cAN) {
      setEGLContextClientVersion(2);
    }
    this.uiHandler = new Handler();
    this.jdField_a_of_type_Anil = new anil(this.uiHandler, this);
    jdField_b_of_type_Anim.a(this.jdField_a_of_type_Anil);
    setRenderer(this);
    setRenderMode(0);
    this.jdField_b_of_type_Aman = new aman();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.cAP)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = new AudioCapture(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.bZj, 1, aniq.bth, aniq.ckG, aniq.mAudioFormat, this, jdField_b_of_type_Anim.a());
      this.jdField_a_of_type_Alwb = new alwb(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.bZj, aniq.bth, this);
    }
    this.jdField_b_of_type_Aary = new aary();
    this.jdField_a_of_type_Alxa = new alxa();
    QmcfManager.getInstance().setCameraMode(this.dyL);
    this.inited = true;
  }
  
  protected boolean isRecording()
  {
    return this.cAt;
  }
  
  public void kf(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onEncodeFinish filePath = " + paramString);
    }
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath = paramString;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.cAP) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)) {
      if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath != null) {
        b(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
      }
    }
    for (;;)
    {
      ThreadManager.postImmediately(new CameraCaptureView.9(this), null, false);
      return;
      if (this.jdField_a_of_type_Alwb.isActive())
      {
        this.jdField_a_of_type_Alwb.dKg();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.stopRecord();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.stopRecord();
        continue;
        paramString = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.bZj + "/noaudio";
        aqhq.UD(paramString);
        this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath = paramString;
        b(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
      }
    }
  }
  
  public void n(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if ((this.dyS == 0) || (this.dyT == 0) || (this.mV.size() == 0))
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "onDrawFrame clean");
      }
    }
    do
    {
      do
      {
        return;
        if (this.cAr) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("CameraCaptureView", 2, "onDrawFrame ignore");
      return;
      long l = System.currentTimeMillis();
      if ((!this.cAK) && (this.frameCount > 15))
      {
        this.cAK = true;
        this.ahS = l;
      }
      boolean bool = this.cAv;
      this.dzh = C(bool);
      int i = iU(this.dzh);
      TM(iT(i));
      a(i, null, null);
      if (!this.cAu)
      {
        this.cAu = true;
        dKX();
      }
      if (bool)
      {
        aX(i, this.dzc, this.dzd);
        this.cAv = false;
      }
      this.frameCount += 1;
      if (this.frameCount == 10) {}
      FrameBufferCache.getInstance().forceRecycle();
    } while (this.cAq);
    axgk.a().eJu();
    this.cAq = true;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.isInitSuccess()) && (!this.cAG))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.getHandler().post(new CameraCaptureView.14(this, paramSurfaceTexture));
      return;
    }
    queueEvent(new CameraCaptureView.15(this, paramSurfaceTexture));
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onPause");
    }
    this.cAH = false;
    this.isPaused = true;
    dKR();
    this.uiHandler.removeCallbacksAndMessages(null);
    if (this.cAy) {
      Os(false);
    }
    jdField_b_of_type_Anim.a(null);
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    }
    ThreadManagerV2.excute(new CameraCaptureView.3(this), 16, null, false);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.cAA)
    {
      int k = this.dyS;
      int m = this.dyT;
      int j = m;
      int i = k;
      if (this.dzk > 0)
      {
        j = m;
        i = k;
        if (this.dzl > 0)
        {
          i = this.dzl;
          j = this.dzk;
        }
      }
      this.jdField_a_of_type_Alxa.a(paramArrayOfByte, i, j, this.jdField_a_of_type_Alxa$a);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$g != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$g.onPreviewFrame(paramArrayOfByte, paramCamera);
    }
    anij.a().c(true, paramArrayOfByte);
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onResume");
    }
    this.isPaused = false;
    if (this.cAH)
    {
      QLog.d("CameraCaptureView", 1, "onResume, blockCameraFlag return");
      return;
    }
    dKQ();
    if (this.jdField_a_of_type_Alxa != null) {
      this.jdField_a_of_type_Alxa.czn();
    }
    if ((this.jdField_a_of_type_AndroidViewOrientationEventListener != null) && (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation())) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
    }
    ThreadManagerV2.excute(new CameraCaptureView.2(this), 16, null, false);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onSurfaceChanged(): width " + paramInt1 + ";height" + paramInt2);
    }
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    this.cAw = true;
    if ((this.cAH) || (this.isPaused)) {
      QLog.d("CameraCaptureView", 1, new Object[] { "onSurfaceChanged, blockCameraFlag return, ", Boolean.valueOf(this.cAH), " ", Boolean.valueOf(this.isPaused) });
    }
    while (this.cAM) {
      return;
    }
    dKQ();
    this.cAM = true;
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onSurfaceCreated");
    }
    this.cAw = false;
    paramEGLConfig = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread = new EglHandlerThread("update_texture", EGL14.eglGetCurrentContext());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.start();
    if (paramEGLConfig != null) {
      paramEGLConfig.quitSafely();
    }
    this.cIN = GlUtil.createTexture(36197);
    this.c = new SurfaceTexture(this.cIN);
    this.c.setOnFrameAvailableListener(this);
    this.textureRender = new TextureRender();
    this.dzg = 0;
    this.cAG = anii.isNeedDrawOnOpenGLSingleThread();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$f != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$f.akO();
    }
    anjn.QC(paramGL10.glGetString(7937));
  }
  
  public void onSurfaceDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onSurfaceDestroy");
    }
    this.cAw = false;
    if (!ankj.axS())
    {
      Iterator localIterator = this.mV.values().iterator();
      while (localIterator.hasNext()) {
        ((RenderBuffer)localIterator.next()).destroy();
      }
      this.mV.clear();
      GlUtil.deleteTexture(this.cIN);
      if (this.c != null) {
        this.c.release();
      }
      if (this.textureRender != null) {
        this.textureRender.release();
      }
    }
    if (this.c != null) {
      this.c.setOnFrameAvailableListener(null);
    }
    dKR();
  }
  
  public void release() {}
  
  public void setBlockCameraFlag(boolean paramBoolean)
  {
    this.cAH = paramBoolean;
  }
  
  public void setCameraChangeListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$b = paramb;
  }
  
  public void setCameraPermissionFinish(boolean paramBoolean)
  {
    this.cAJ = paramBoolean;
  }
  
  public void setCameraPermissionListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$c = paramc;
  }
  
  public void setCameraPermissionResult(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, new Object[] { "setCameraPermissionResult, ", Boolean.valueOf(paramBoolean) });
    }
    this.cAJ = true;
    cTt();
    cTu();
  }
  
  public void setCaptureListener(d paramd)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$d = paramd;
  }
  
  public void setCaptureParam(e parame)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e != null) {
      throw new RuntimeException("setCaptureParam is already called");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e = parame;
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "setCaptureParam : " + parame);
    }
    init();
  }
  
  public void setDarkModeEnable(boolean paramBoolean)
  {
    this.cAA = paramBoolean;
  }
  
  public void setDarkModeListener(alxa.a parama)
  {
    this.jdField_a_of_type_Alxa$a = parama;
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.cAE = paramBoolean;
  }
  
  public void setOnSurfaceCreatedListener(f paramf)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$f = paramf;
  }
  
  public void setPreviewCallback(g paramg)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$g = paramg;
  }
  
  public void setSceneMode(String paramString)
  {
    dKP();
    jdField_b_of_type_Anim.setSceneMode(paramString);
  }
  
  public void setSegmentMode(boolean paramBoolean)
  {
    this.cAD = paramBoolean;
  }
  
  public void setSyncStopCamera(boolean paramBoolean)
  {
    this.cAB = paramBoolean;
  }
  
  public void setUseVideoOrientation(boolean paramBoolean)
  {
    this.cAC = paramBoolean;
  }
  
  public void setZoom(int paramInt)
  {
    dKP();
    jdField_b_of_type_Anim.setZoom(paramInt);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "surfaceCreated");
    }
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "surfaceDestroyed");
    }
    super.surfaceDestroyed(paramSurfaceHolder);
  }
  
  public String yI()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.bZj;
  }
  
  public static class VideoCaptureResult
    implements Serializable
  {
    public static final int TYPE_MERGED = 1;
    public static final int TYPE_UNMERGED = 0;
    public String audioDataFilePath;
    public String bgmAudioDataFilePath;
    public int errorCode;
    public String mergedMp4FilePath;
    public int orientation;
    public int type;
    public int videoFrameCount;
    public String videoMp4FilePath;
    
    public String toString()
    {
      return "VideoCaptureResult{type=" + this.type + ", errorCode=" + this.errorCode + ", mergedMp4FilePath='" + this.mergedMp4FilePath + '\'' + ", videoMp4FilePath='" + this.videoMp4FilePath + '\'' + ", audioDataFilePath='" + this.audioDataFilePath + '\'' + '}';
    }
  }
  
  public static abstract interface a
  {
    public abstract void Ps(String paramString);
    
    public abstract void a(awxf paramawxf);
  }
  
  public static abstract interface b
  {
    public abstract void dLb();
  }
  
  public static abstract interface c
  {
    public abstract void dLc();
  }
  
  public static abstract interface d
  {
    public abstract void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult);
    
    public abstract void a(CameraCaptureView.h paramh);
    
    public abstract void ac(boolean paramBoolean, String paramString);
    
    public abstract void bST();
    
    public abstract void bSU();
    
    public abstract void bSV();
    
    public abstract void onCaptureError(int paramInt);
  }
  
  public static class e
  {
    public static final String bZi = BaseApplicationImpl.getContext().getFilesDir().getPath() + "/Android/data/com.tencent.mobileqq/qq/video/LightVideo/";
    public static String bZk = "key_aio_fbo";
    public static String bZl = "key_riji_h_compress_fbo";
    public static String bZm = "key_riji_h_clip_fbo";
    public static String bZn = "key_riji_l_compress_fbo";
    public static String bZo = "key_riji_l_clip_fbo";
    public static String bZp = "key_ae_gif_fbo";
    public long ahU = System.currentTimeMillis();
    protected boolean autoRotate = true;
    public String bZj = BaseApplicationImpl.getContext().getFilesDir().getPath() + "/Android/data/com.tencent.mobileqq/qq/video/Source/" + this.ahU;
    protected boolean cAP = true;
    public int clipHeight;
    public int clipWidth;
    private int dyQ = 1;
    protected int dzA = -1;
    protected int dzB = -1;
    private int dzu = 960;
    private int dzv = 720;
    private int dzw = 960;
    private int dzx = 720;
    private int dzy = 1;
    private int dzz = 1;
    private int screenHeight;
    private int screenWidth;
    private int videoBitRate = 2000000;
    protected float zb = 1.0F;
    
    public void Ov(boolean paramBoolean)
    {
      this.cAP = paramBoolean;
    }
    
    public void Ow(boolean paramBoolean)
    {
      this.autoRotate = paramBoolean;
    }
    
    public void TN(int paramInt)
    {
      this.dzu = paramInt;
    }
    
    public void TO(int paramInt)
    {
      this.dzv = paramInt;
    }
    
    public void TP(int paramInt)
    {
      this.dzw = paramInt;
    }
    
    public void TQ(int paramInt)
    {
      this.dzx = paramInt;
    }
    
    public void TR(int paramInt)
    {
      this.screenWidth = paramInt;
    }
    
    public void TS(int paramInt)
    {
      this.dzy = paramInt;
    }
    
    public void TT(int paramInt)
    {
      this.videoBitRate = paramInt;
    }
    
    public void TU(int paramInt)
    {
      this.dzz = paramInt;
    }
    
    public void TV(int paramInt)
    {
      this.dzA = paramInt;
    }
    
    public void bb(float paramFloat)
    {
      this.zb = paramFloat;
    }
    
    public void dLd()
    {
      this.bZj = (bZi + this.ahU);
    }
    
    public void setClipHeight(int paramInt)
    {
      this.clipHeight = paramInt;
    }
    
    public void setClipWidth(int paramInt)
    {
      this.clipWidth = paramInt;
    }
    
    public void setFunctionFlag(int paramInt)
    {
      this.dyQ = paramInt;
    }
    
    public void setScreenHeight(int paramInt)
    {
      this.screenHeight = paramInt;
    }
    
    public String toString()
    {
      return "CaptureParam{wantedPreviewWidth=" + this.dzu + ", wantedPreviewHeight=" + this.dzv + ", defaultCamera=" + this.dzy + ", videoSizeRate=" + this.zb + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.dzz + ", captureDir='" + this.bZj + '\'' + ", audioCaptureEnable=" + this.cAP + ", functionFlag=" + this.dyQ + '}';
    }
  }
  
  public static abstract interface f
  {
    public abstract void akO();
  }
  
  public static abstract interface g
  {
    public abstract void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera);
  }
  
  public static class h
  {
    public Bitmap bitmap;
    public int errorCode;
    public String filePath;
    public int orientation;
    public int type;
    
    public h(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap, int paramInt3)
    {
      this.type = paramInt1;
      this.errorCode = paramInt2;
      this.filePath = paramString;
      this.bitmap = paramBitmap;
      this.orientation = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView
 * JD-Core Version:    0.7.0.1
 */