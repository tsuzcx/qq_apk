package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import anya;
import anyo.a;
import anyu;
import anzc;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import mqq.util.WeakReference;

public class VideoSprite
  extends anyu
  implements SurfaceTexture.OnFrameAvailableListener, GLTextureView.a, SpriteGLView.a, Runnable
{
  protected static final short[] sDrawOrder = { 0, 1, 2, 0, 2, 3 };
  protected float HALF = 0.5F;
  protected c a;
  public d a;
  protected boolean aEj;
  protected boolean afw;
  protected anya b;
  protected SpriteGLView b;
  public boolean cKM;
  public boolean cKN;
  protected float[] dw = new float[16];
  protected SurfaceTexture e;
  protected anyo.a e;
  public boolean isFullScreen;
  protected ShortBuffer mDrawListBuffer;
  protected String mFilePath;
  protected boolean mFrameAvailable;
  public Handler mHandler = new Handler(Looper.getMainLooper());
  protected int mHeight;
  protected boolean mIsPause;
  public boolean mIsPrepared;
  protected boolean mIsReady;
  protected boolean mIsSupportAlpha;
  public MediaPlayer mMediaPlayer;
  protected int mPositionHandle;
  protected int mShaderProgram;
  protected float[] mSquareCoords = { -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F };
  protected int mSupportAlphaHandle;
  protected Surface mSurface;
  protected int mTextureAlphaCoordinateHandle;
  protected FloatBuffer mTextureBuffer;
  protected FloatBuffer mTextureBuffer2;
  protected int mTextureCoordinateHandle;
  protected float[] mTextureCoords;
  protected float[] mTextureCoords2;
  protected int mTextureParamHandle;
  protected int mTextureTranformHandle;
  protected int[] mTextures = new int[1];
  protected FloatBuffer mVertexBuffer;
  protected int mWidth;
  
  public VideoSprite(SpriteGLView paramSpriteGLView, Context paramContext, boolean paramBoolean)
  {
    this.jdField_b_of_type_Anya = new anya(0.0F, 0.0F);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.cKD = true;
    this.mIsSupportAlpha = paramBoolean;
    if (paramBoolean) {}
    for (float f = 0.5F;; f = 1.0F)
    {
      this.HALF = f;
      this.mTextureCoords = new float[] { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, this.HALF, 0.0F, 0.0F, 1.0F, this.HALF, 1.0F, 0.0F, 1.0F };
      this.mTextureCoords2 = new float[] { this.HALF, 1.0F, 0.0F, 1.0F, this.HALF, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
      this.mMediaPlayer = new MediaPlayer();
      this.mMediaPlayer.setOnCompletionListener(new a(this, null));
      this.mMediaPlayer.setOnErrorListener(new b(this, null));
      paramSpriteGLView.a(this);
      paramSpriteGLView.al(new VideoSprite.1(this));
      return;
    }
  }
  
  private void setupTexture()
  {
    if (this.mMediaPlayer == null) {}
    do
    {
      return;
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.mTextureCoords.length * 4);
      localByteBuffer.order(ByteOrder.nativeOrder());
      this.mTextureBuffer = localByteBuffer.asFloatBuffer();
      this.mTextureBuffer.put(this.mTextureCoords);
      this.mTextureBuffer.position(0);
      localByteBuffer = ByteBuffer.allocateDirect(this.mTextureCoords2.length * 4);
      localByteBuffer.order(ByteOrder.nativeOrder());
      this.mTextureBuffer2 = localByteBuffer.asFloatBuffer();
      this.mTextureBuffer2.put(this.mTextureCoords2);
      this.mTextureBuffer2.position(0);
      GLES20.glActiveTexture(33984);
      GLES20.glGenTextures(1, this.mTextures, 0);
      checkGlError("Texture generate");
      GLES20.glBindTexture(36197, this.mTextures[0]);
      checkGlError("Texture bind");
      this.jdField_e_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.mTextures[0]);
      this.jdField_e_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
      if (this.mSurface != null) {
        this.mSurface.release();
      }
      this.mSurface = new Surface(this.jdField_e_of_type_AndroidGraphicsSurfaceTexture);
      try
      {
        this.mMediaPlayer.setSurface(this.mSurface);
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("VideoSprite", 2, QLog.getStackTraceString(localException));
  }
  
  private void setupVertexBuffer()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(sDrawOrder.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.mDrawListBuffer = localByteBuffer.asShortBuffer();
    this.mDrawListBuffer.put(sDrawOrder);
    this.mDrawListBuffer.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(this.mSquareCoords.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.mVertexBuffer = localByteBuffer.asFloatBuffer();
    this.mVertexBuffer.put(this.mSquareCoords);
    this.mVertexBuffer.position(0);
  }
  
  protected String Aw()
  {
    return anzc.D(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), "troop" + File.separator + "shaders" + File.separator + "VertexShaderVideo.glsl");
  }
  
  public void Go(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "playVideo: " + paramString);
    }
    if (((this.mFilePath == null) || (!this.mFilePath.equals(paramString)) || (!this.mIsPrepared)) && (this.mMediaPlayer != null)) {}
    try
    {
      this.mMediaPlayer.stop();
    }
    catch (Exception localException2)
    {
      try
      {
        this.mMediaPlayer.reset();
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            this.mMediaPlayer.setDataSource(paramString);
            this.mMediaPlayer.prepareAsync();
            this.mMediaPlayer.setOnPreparedListener(new e(this, null));
            this.mFilePath = paramString;
            return;
            localException1 = localException1;
            if (QLog.isColorLevel())
            {
              QLog.e("VideoSprite", 2, "playVideo Exception: " + QLog.getStackTraceString(localException1));
              continue;
              localException2 = localException2;
              if (QLog.isColorLevel()) {
                QLog.e("VideoSprite", 2, "playVideo Exception: " + QLog.getStackTraceString(localException2));
              }
            }
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("VideoSprite", 2, "playVideo Exception: " + QLog.getStackTraceString(localException3));
            }
            if (this.jdField_e_of_type_Anyo$a != null) {
              this.jdField_e_of_type_Anyo$a.byj();
            }
          }
        }
      }
    }
  }
  
  public void a(anyo.a parama)
  {
    this.jdField_e_of_type_Anyo$a = parama;
  }
  
  /* Error */
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 361	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:mIsReady	Z
    //   6: ifne +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_0
    //   15: getfield 363	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:mShaderProgram	I
    //   18: invokestatic 366	android/opengl/GLES20:glUseProgram	(I)V
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 368	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:mFrameAvailable	Z
    //   27: istore 9
    //   29: iload 9
    //   31: ifeq +54 -> 85
    //   34: aload_0
    //   35: getfield 236	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_e_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   38: invokevirtual 371	android/graphics/SurfaceTexture:updateTexImage	()V
    //   41: aload_0
    //   42: getfield 236	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_e_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   45: aload_0
    //   46: getfield 102	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:dw	[F
    //   49: invokevirtual 375	android/graphics/SurfaceTexture:getTransformMatrix	([F)V
    //   52: aload_0
    //   53: iconst_0
    //   54: putfield 368	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:mFrameAvailable	Z
    //   57: aload_0
    //   58: getfield 377	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:afw	Z
    //   61: ifeq +24 -> 85
    //   64: aload_0
    //   65: getfield 379	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$c	Lcom/tencent/mobileqq/surfaceviewaction/gl/VideoSprite$c;
    //   68: ifnull +17 -> 85
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 377	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:afw	Z
    //   76: aload_0
    //   77: getfield 379	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$c	Lcom/tencent/mobileqq/surfaceviewaction/gl/VideoSprite$c;
    //   80: invokeinterface 382 1 0
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_0
    //   88: iload_1
    //   89: iload_2
    //   90: invokevirtual 385	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jH	(II)V
    //   93: return
    //   94: astore 8
    //   96: aload_0
    //   97: monitorexit
    //   98: aload 8
    //   100: athrow
    //   101: astore 8
    //   103: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq -54 -> 52
    //   109: ldc_w 262
    //   112: iconst_2
    //   113: aload 8
    //   115: invokestatic 266	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   118: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: goto -69 -> 52
    //   124: astore 8
    //   126: aload_0
    //   127: monitorexit
    //   128: aload 8
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	VideoSprite
    //   0	131	1	paramInt1	int
    //   0	131	2	paramInt2	int
    //   0	131	3	paramInt3	int
    //   0	131	4	paramInt4	int
    //   0	131	5	paramInt5	int
    //   0	131	6	paramInt6	int
    //   0	131	7	paramInt7	int
    //   0	131	8	paramArrayOfFloat	float[]
    //   27	3	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	11	94	finally
    //   12	14	94	finally
    //   96	98	94	finally
    //   34	52	101	java/lang/Exception
    //   23	29	124	finally
    //   34	52	124	finally
    //   52	85	124	finally
    //   85	87	124	finally
    //   103	121	124	finally
    //   126	128	124	finally
  }
  
  public void checkGlError(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      Log.e("SurfaceTest", paramString + ": glError " + GLUtils.getEGLErrorString(i));
    }
  }
  
  protected void eC(int paramInt1, int paramInt2)
  {
    this.JO = paramInt1;
    this.mViewHeight = paramInt2;
    float f4;
    label45:
    float f1;
    label62:
    float f2;
    if (this.width != 0.0F)
    {
      f3 = this.width / this.HALF;
      if (this.height == 0.0F) {
        break label322;
      }
      f4 = this.height;
      if (!this.isFullScreen) {
        break label332;
      }
      f1 = this.scale * bv();
      f2 = f1;
      if (this.cKN)
      {
        f2 = f1;
        if (this.isFullScreen)
        {
          f2 = f1;
          if (paramInt1 / f3 < paramInt2 / f4) {
            f2 = f1 * (paramInt2 * f3 / (paramInt1 * f4));
          }
        }
      }
      f4 = paramInt1 / this.HALF / f3 * f2 * f4 / paramInt2;
      a(this.jdField_b_of_type_Anya);
      if (!this.cKM) {
        break label356;
      }
      f1 = this.jdField_b_of_type_Anya.x * bv() / this.HALF / paramInt1;
      label171:
      if (!this.cKM) {
        break label385;
      }
    }
    label385:
    for (float f3 = this.jdField_b_of_type_Anya.y * bv() / this.HALF / paramInt2;; f3 = (this.jdField_b_of_type_Anya.y * bv() - paramInt2 / 2) / this.HALF / paramInt2)
    {
      this.mSquareCoords[0] = (-f2 + f1);
      this.mSquareCoords[1] = (f4 + f3);
      this.mSquareCoords[2] = (-f2 + f1);
      this.mSquareCoords[3] = (-f4 + f3);
      this.mSquareCoords[4] = (f2 + f1);
      this.mSquareCoords[5] = (-f4 + f3);
      this.mSquareCoords[6] = (f1 + f2);
      this.mSquareCoords[7] = (f3 + f4);
      this.mVertexBuffer.put(this.mSquareCoords);
      this.mVertexBuffer.position(0);
      return;
      f3 = this.mWidth;
      break;
      label322:
      f4 = this.mHeight;
      break label45;
      label332:
      f1 = this.scale * bv() * (this.HALF * f3) / paramInt1;
      break label62;
      label356:
      f1 = (this.jdField_b_of_type_Anya.x * bv() - paramInt1 / 2) / this.HALF / paramInt1;
      break label171;
    }
  }
  
  public void ga(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "playVideo with seek: " + paramString);
    }
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.al(new VideoSprite.2(this, paramString, paramInt));
  }
  
  public int getCurrentTime()
  {
    if (this.mMediaPlayer != null) {
      try
      {
        int i = this.mMediaPlayer.getCurrentPosition();
        return i;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoSprite", 2, "getCurrentTime: " + QLog.getStackTraceString(localException));
        }
      }
    }
    return 0;
  }
  
  public boolean isReleased()
  {
    return this.mMediaPlayer == null;
  }
  
  protected void jH(int paramInt1, int paramInt2)
  {
    if (this.mVertexBuffer == null) {
      return;
    }
    eC(paramInt1, paramInt2);
    GLES20.glEnableVertexAttribArray(this.mPositionHandle);
    GLES20.glVertexAttribPointer(this.mPositionHandle, 2, 5126, false, 0, this.mVertexBuffer);
    GLES20.glBindTexture(3553, this.mTextures[0]);
    GLES20.glUniform1i(this.mTextureParamHandle, 0);
    GLES20.glEnableVertexAttribArray(this.mTextureCoordinateHandle);
    GLES20.glVertexAttribPointer(this.mTextureCoordinateHandle, 4, 5126, false, 0, this.mTextureBuffer);
    if (this.mIsSupportAlpha)
    {
      GLES20.glUniform1i(this.mSupportAlphaHandle, 1);
      GLES20.glEnableVertexAttribArray(this.mTextureAlphaCoordinateHandle);
      GLES20.glVertexAttribPointer(this.mTextureAlphaCoordinateHandle, 4, 5126, false, 0, this.mTextureBuffer2);
    }
    for (;;)
    {
      GLES20.glUniformMatrix4fv(this.mTextureTranformHandle, 1, false, this.dw, 0);
      GLES20.glDrawElements(4, sDrawOrder.length, 5123, this.mDrawListBuffer);
      GLES20.glDisableVertexAttribArray(this.mPositionHandle);
      GLES20.glDisableVertexAttribArray(this.mTextureCoordinateHandle);
      GLES20.glDisableVertexAttribArray(this.mTextureAlphaCoordinateHandle);
      return;
      GLES20.glUniform1i(this.mSupportAlphaHandle, 0);
    }
  }
  
  protected String nw()
  {
    return anzc.D(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), "troop" + File.separator + "shaders" + File.separator + "FragmentShaderVideo.glsl");
  }
  
  public void onCreate()
  {
    setupGraphics();
    setupVertexBuffer();
    setupTexture();
    rp();
  }
  
  public void onDestroy()
  {
    try
    {
      if (this.mMediaPlayer != null) {
        this.mMediaPlayer.pause();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if (this.mSurface != null) {
            this.mSurface.release();
          }
          this.mHandler.removeCallbacksAndMessages(null);
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.e("VideoSprite", 2, "onDestroy->mMediaPlayer.pause(): " + QLog.getStackTraceString(localException1));
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoSprite", 2, "onDestroy->release surface: " + QLog.getStackTraceString(localException2));
          }
        }
      }
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.mFrameAvailable = true;
      if (!this.mIsReady)
      {
        this.afw = true;
        this.mIsReady = true;
      }
      return;
    }
    finally {}
  }
  
  public void pause()
  {
    super.pause();
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "pause");
    }
    try
    {
      if ((this.mMediaPlayer != null) && (!this.mIsPause) && (this.mMediaPlayer.isPlaying()))
      {
        this.mMediaPlayer.pause();
        this.mIsPause = true;
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoSprite", 2, "pause: " + QLog.getStackTraceString(localException));
    }
  }
  
  public void release()
  {
    if (this.mMediaPlayer != null) {}
    try
    {
      this.mMediaPlayer.setOnCompletionListener(null);
      this.mMediaPlayer.setOnErrorListener(null);
      this.mMediaPlayer.setOnPreparedListener(null);
    }
    catch (Exception localException2)
    {
      try
      {
        this.mMediaPlayer.stop();
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mIsReady = false;
            this.jdField_e_of_type_Anyo$a = null;
            this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$c = null;
            this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.al(new VideoSprite.4(this));
            this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(this);
            this.mHandler.removeCallbacksAndMessages(null);
            return;
            localException1 = localException1;
            if (QLog.isColorLevel())
            {
              QLog.e("VideoSprite", 2, QLog.getStackTraceString(localException1));
              continue;
              localException2 = localException2;
              if (QLog.isColorLevel()) {
                QLog.e("VideoSprite", 2, QLog.getStackTraceString(localException2));
              }
            }
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("VideoSprite", 2, QLog.getStackTraceString(localException3));
            }
          }
        }
      }
    }
  }
  
  public void resume()
  {
    super.resume();
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "resume");
    }
    if ((this.mMediaPlayer == null) || (this.mIsPause)) {}
    for (;;)
    {
      try
      {
        this.mMediaPlayer.start();
        this.mIsPause = false;
        return;
      }
      catch (Exception localException) {}
      if (this.mFilePath != null)
      {
        Go(this.mFilePath);
        return;
      }
    }
  }
  
  protected void rp()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "playVideo");
    }
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.al(new VideoSprite.3(this));
  }
  
  public void run()
  {
    int j;
    if ((this.mMediaPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$d != null))
    {
      this.mHandler.postDelayed(this, 33L);
      j = 0;
    }
    try
    {
      i = this.mMediaPlayer.getCurrentPosition();
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$d.Ce(i);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("VideoSprite", 2, "run: " + QLog.getStackTraceString(localException));
          i = j;
        }
      }
    }
  }
  
  public void setFilePath(String paramString)
  {
    this.mFilePath = paramString;
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.aEj = paramBoolean;
  }
  
  public void setOnPlayedListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$c = paramc;
  }
  
  public void setOnProgressChangedListener(d paramd)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$d = paramd;
  }
  
  protected void setupGraphics()
  {
    String str1 = Aw();
    String str2 = nw();
    try
    {
      this.mShaderProgram = anzc.loadProgram(str1, str2);
      GLES20.glUseProgram(this.mShaderProgram);
      this.mTextureParamHandle = GLES20.glGetUniformLocation(this.mShaderProgram, "texture");
      this.mTextureCoordinateHandle = GLES20.glGetAttribLocation(this.mShaderProgram, "vTexCoordinate");
      this.mTextureAlphaCoordinateHandle = GLES20.glGetAttribLocation(this.mShaderProgram, "vTexAlphaCoordinate");
      this.mPositionHandle = GLES20.glGetAttribLocation(this.mShaderProgram, "vPosition");
      this.mTextureTranformHandle = GLES20.glGetUniformLocation(this.mShaderProgram, "textureTransform");
      this.mSupportAlphaHandle = GLES20.glGetUniformLocation(this.mShaderProgram, "v_isAlpha");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("VideoSprite", 2, "setupGraphics: " + QLog.getStackTraceString(localException));
      }
    }
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "stop");
    }
    if ((this.mMediaPlayer != null) && ((this.mIsPrepared) || (this.mIsReady) || (this.mIsPause))) {}
    try
    {
      this.mMediaPlayer.stop();
      this.mIsPrepared = false;
      this.mIsReady = false;
      this.mIsPause = false;
      return;
    }
    catch (Exception localException) {}
  }
  
  static class a
    implements MediaPlayer.OnCompletionListener
  {
    private WeakReference<VideoSprite> aY;
    
    private a(VideoSprite paramVideoSprite)
    {
      this.aY = new WeakReference(paramVideoSprite);
    }
    
    public void onCompletion(MediaPlayer paramMediaPlayer)
    {
      paramMediaPlayer = (VideoSprite)this.aY.get();
      if (paramMediaPlayer == null) {}
      do
      {
        return;
        if (paramMediaPlayer.aEj)
        {
          paramMediaPlayer.b.al(new VideoSprite.CompletionListener.1(this, paramMediaPlayer));
          return;
        }
        paramMediaPlayer.mIsPrepared = false;
        paramMediaPlayer.mHandler.removeCallbacksAndMessages(null);
      } while (paramMediaPlayer.e == null);
      paramMediaPlayer.e.byj();
    }
  }
  
  static class b
    implements MediaPlayer.OnErrorListener
  {
    private WeakReference<VideoSprite> aY;
    
    private b(VideoSprite paramVideoSprite)
    {
      this.aY = new WeakReference(paramVideoSprite);
    }
    
    public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      paramMediaPlayer = (VideoSprite)this.aY.get();
      if (paramMediaPlayer == null) {}
      do
      {
        return true;
        if (QLog.isColorLevel()) {
          QLog.e("VideoSprite", 2, "onError: " + paramInt1);
        }
      } while (paramInt1 != 1);
      if (paramMediaPlayer.e != null) {
        paramMediaPlayer.e.byj();
      }
      paramMediaPlayer.stop();
      return true;
    }
  }
  
  public static abstract interface c
  {
    public abstract void byk();
  }
  
  public static abstract interface d
  {
    public abstract void Ce(int paramInt);
  }
  
  static class e
    implements MediaPlayer.OnPreparedListener
  {
    private WeakReference<VideoSprite> aY;
    
    private e(VideoSprite paramVideoSprite)
    {
      this.aY = new WeakReference(paramVideoSprite);
    }
    
    public void onPrepared(MediaPlayer paramMediaPlayer)
    {
      paramMediaPlayer = (VideoSprite)this.aY.get();
      if (paramMediaPlayer == null) {}
      do
      {
        for (;;)
        {
          return;
          try
          {
            paramMediaPlayer.mWidth = paramMediaPlayer.mMediaPlayer.getVideoWidth();
            paramMediaPlayer.mHeight = paramMediaPlayer.mMediaPlayer.getVideoHeight();
            paramMediaPlayer.mMediaPlayer.start();
            paramMediaPlayer.mIsPrepared = true;
            if (paramMediaPlayer.a != null)
            {
              paramMediaPlayer.mHandler.postDelayed(paramMediaPlayer, 33L);
              return;
            }
          }
          catch (Exception paramMediaPlayer) {}
        }
      } while (!QLog.isColorLevel());
      QLog.e("VideoSprite", 2, "playVideo Exception: " + QLog.getStackTraceString(paramMediaPlayer));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite
 * JD-Core Version:    0.7.0.1
 */