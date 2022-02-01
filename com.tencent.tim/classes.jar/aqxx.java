import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.mobileqq.vpng.glrenderer.GLRenderer;
import com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer.2;
import com.tencent.qphone.base.util.QLog;
import cooperation.liveroom.LiveRoomGiftCallback;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class aqxx
  extends GLRenderer
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static final short[] sDrawOrder = { 0, 1, 2, 0, 2, 3 };
  private aqxw a;
  private boolean aEj;
  private MediaPlayer.OnCompletionListener b;
  private boolean cWS;
  private float[] dB = { -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F };
  private float[] dC;
  private float[] dD;
  private float[] dE;
  private float[] dF;
  private float[] dG;
  private float[] dH;
  private float[] dI;
  private float[] dw = new float[16];
  private SurfaceTexture e;
  private int edC;
  private int edD = 0;
  private FloatBuffer m;
  private LiveRoomGiftCallback mCallback;
  private ShortBuffer mDrawListBuffer;
  private String mFilePath;
  private long mFirstTime;
  private boolean mFrameAvailable;
  private int mHeight;
  private volatile boolean mIsPrepared;
  private boolean mIsReady;
  public MediaPlayer mMediaPlayer;
  private int mPositionHandle;
  private int mShaderProgram;
  private int mTextureAlphaCoordinateHandle;
  private FloatBuffer mTextureBuffer;
  private int mTextureCoordinateHandle;
  private float[] mTextureCoords;
  private int mTextureParamHandle;
  private int[] mTextures = new int[1];
  private FloatBuffer mVertexBuffer;
  private int mWidth;
  
  aqxx(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    init();
  }
  
  /* Error */
  private void draw()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 103	aqxx:mIsReady	Z
    //   6: ifne +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_0
    //   15: getfield 85	aqxx:mShaderProgram	I
    //   18: invokestatic 109	android/opengl/GLES20:glUseProgram	(I)V
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 111	aqxx:mFrameAvailable	Z
    //   27: ifeq +50 -> 77
    //   30: aload_0
    //   31: getfield 113	aqxx:mMediaPlayer	Landroid/media/MediaPlayer;
    //   34: ifnull +43 -> 77
    //   37: aload_0
    //   38: getfield 115	aqxx:e	Landroid/graphics/SurfaceTexture;
    //   41: ifnull +36 -> 77
    //   44: aload_0
    //   45: getfield 113	aqxx:mMediaPlayer	Landroid/media/MediaPlayer;
    //   48: invokevirtual 121	android/media/MediaPlayer:isPlaying	()Z
    //   51: ifeq +26 -> 77
    //   54: aload_0
    //   55: getfield 115	aqxx:e	Landroid/graphics/SurfaceTexture;
    //   58: invokevirtual 126	android/graphics/SurfaceTexture:updateTexImage	()V
    //   61: aload_0
    //   62: getfield 115	aqxx:e	Landroid/graphics/SurfaceTexture;
    //   65: aload_0
    //   66: getfield 77	aqxx:dw	[F
    //   69: invokevirtual 130	android/graphics/SurfaceTexture:getTransformMatrix	([F)V
    //   72: aload_0
    //   73: iconst_0
    //   74: putfield 111	aqxx:mFrameAvailable	Z
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_0
    //   80: aload_0
    //   81: getfield 133	aqxx:edA	I
    //   84: aload_0
    //   85: getfield 136	aqxx:edB	I
    //   88: invokespecial 139	aqxx:jH	(II)V
    //   91: return
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    //   97: astore_1
    //   98: ldc 141
    //   100: iconst_2
    //   101: new 143	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   108: ldc 147
    //   110: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_1
    //   114: invokevirtual 155	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   117: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: goto -49 -> 77
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	aqxx
    //   92	4	1	localObject1	java.lang.Object
    //   97	17	1	localException	Exception
    //   129	4	1	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	11	92	finally
    //   12	14	92	finally
    //   93	95	92	finally
    //   23	77	97	java/lang/Exception
    //   23	77	129	finally
    //   77	79	129	finally
    //   98	126	129	finally
    //   130	132	129	finally
  }
  
  private void eC(int paramInt1, int paramInt2)
  {
    float f2 = this.mWidth;
    float f1 = this.mHeight;
    float f3;
    if ((this.edD == 1) || (this.edD == 0))
    {
      f2 /= 2.0F;
      f3 = paramInt1 / f2 * f1 / paramInt2;
      if ((this.edD != 1) && (this.edD != 2)) {
        break label204;
      }
      if (paramInt2 * f2 < paramInt1 * f1) {
        break label194;
      }
      f3 = paramInt2 / f1;
      label81:
      f2 = f2 * f3 / paramInt1;
      f1 = f1 * f3 / paramInt2;
    }
    for (;;)
    {
      this.dB[0] = (-f2);
      this.dB[1] = f1;
      this.dB[2] = (-f2);
      this.dB[3] = (-f1);
      this.dB[4] = f2;
      this.dB[5] = (-f1);
      this.dB[6] = f2;
      this.dB[7] = f1;
      this.mVertexBuffer.put(this.dB);
      this.mVertexBuffer.position(0);
      return;
      f1 /= 2.0F;
      break;
      label194:
      f3 = paramInt1 / f2;
      break label81;
      label204:
      f1 = f3;
      f2 = 1.0F;
    }
  }
  
  private void egn()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.mTextureCoords.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.mTextureBuffer = localByteBuffer.asFloatBuffer();
    this.mTextureBuffer.put(this.mTextureCoords);
    this.mTextureBuffer.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(this.dC.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.m = localByteBuffer.asFloatBuffer();
    this.m.put(this.dC);
    this.m.position(0);
  }
  
  private void init()
  {
    this.dF = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.5F, 1.0F };
    this.dG = new float[] { 0.5F, 1.0F, 0.5F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.dE = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.5F, 1.0F };
    this.dD = new float[] { 0.5F, 1.0F, 0.5F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.mTextureCoords = this.dF;
    this.dC = this.dG;
    this.dH = new float[] { 0.0F, 1.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F, 1.0F };
    this.dI = new float[] { 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.5F };
    this.mMediaPlayer = new MediaPlayer();
    this.mMediaPlayer.setOnCompletionListener(new aqxy(this));
    as(new VPNGRenderer.2(this));
  }
  
  private void jH(int paramInt1, int paramInt2)
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
    GLES20.glVertexAttribPointer(this.mTextureCoordinateHandle, 2, 5126, false, 0, this.mTextureBuffer);
    GLES20.glEnableVertexAttribArray(this.mTextureAlphaCoordinateHandle);
    GLES20.glVertexAttribPointer(this.mTextureAlphaCoordinateHandle, 2, 5126, false, 0, this.m);
    GLES20.glUniformMatrix4fv(this.edC, 1, false, this.dw, 0);
    GLES20.glDrawElements(4, sDrawOrder.length, 5123, this.mDrawListBuffer);
    GLES20.glDisableVertexAttribArray(this.mPositionHandle);
    GLES20.glDisableVertexAttribArray(this.mTextureCoordinateHandle);
    GLES20.glDisableVertexAttribArray(this.mTextureAlphaCoordinateHandle);
  }
  
  private void play(String paramString)
  {
    float[] arrayOfFloat;
    if (((this.mFilePath == null) || (!this.mFilePath.equals(paramString)) || (!this.mIsPrepared) || (this.cWS)) && (this.mMediaPlayer != null)) {
      if (this.edD == 0)
      {
        arrayOfFloat = this.dF;
        this.mTextureCoords = arrayOfFloat;
        if (this.edD != 0) {
          break label180;
        }
        arrayOfFloat = this.dG;
        label68:
        this.dC = arrayOfFloat;
        this.mMediaPlayer.reset();
        if (this.cWS)
        {
          this.cWS = false;
          this.mFirstTime = 0L;
          egn();
        }
      }
    }
    for (;;)
    {
      try
      {
        this.mMediaPlayer.setDataSource(paramString);
        this.mMediaPlayer.prepare();
        this.mWidth = this.mMediaPlayer.getVideoWidth();
        this.mHeight = this.mMediaPlayer.getVideoHeight();
        this.mMediaPlayer.start();
        this.mIsPrepared = true;
        this.mFilePath = paramString;
        return;
        if (this.edD == 1)
        {
          arrayOfFloat = this.dD;
          break;
        }
        arrayOfFloat = this.dI;
        break;
        label180:
        if (this.edD == 1)
        {
          arrayOfFloat = this.dE;
          break label68;
        }
        arrayOfFloat = this.dH;
      }
      catch (Exception localException)
      {
        QLog.e("VPNGRenderer", 2, "playVideo Exception: " + localException.getMessage());
        if (this.b == null) {
          continue;
        }
        this.b.onCompletion(this.mMediaPlayer);
        continue;
      }
      if (this.mIsPrepared) {
        resumeVideo();
      }
    }
  }
  
  private void rp()
  {
    try
    {
      if ((this.mIsPrepared) && (this.mMediaPlayer != null) && (!this.mMediaPlayer.isPlaying())) {
        this.mMediaPlayer.start();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("VPNGRenderer", 1, "playVideo(" + this.mFilePath + "): " + localException.getMessage());
    }
  }
  
  private void setupGraphics()
  {
    this.mShaderProgram = anzc.loadProgram("attribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nattribute vec4 vTexAlphaCoordinate;\nuniform mat4 textureTransform;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    v_TexAlphaCoordinate = (textureTransform * vTexAlphaCoordinate).xy;\n    gl_Position = vPosition;\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nvoid main () {\n    vec4 color = texture2D(texture, v_TexCoordinate);\n    float r = texture2D(texture, v_TexAlphaCoordinate).r;\n    float g = texture2D(texture, v_TexAlphaCoordinate).g;\n    float b = texture2D(texture, v_TexAlphaCoordinate).b;\n    float alpha = min(r, min(g, b)) * texture2D(texture, v_TexAlphaCoordinate).a;\n    gl_FragColor = color;\n    gl_FragColor.a = gl_FragColor.a * alpha;\n    gl_FragColor.r = gl_FragColor.r * alpha;\n    gl_FragColor.g = gl_FragColor.g * alpha;\n    gl_FragColor.b = gl_FragColor.b * alpha;\n}");
    GLES20.glUseProgram(this.mShaderProgram);
    this.mTextureParamHandle = GLES20.glGetUniformLocation(this.mShaderProgram, "texture");
    this.mTextureCoordinateHandle = GLES20.glGetAttribLocation(this.mShaderProgram, "vTexCoordinate");
    this.mTextureAlphaCoordinateHandle = GLES20.glGetAttribLocation(this.mShaderProgram, "vTexAlphaCoordinate");
    this.mPositionHandle = GLES20.glGetAttribLocation(this.mShaderProgram, "vPosition");
    this.edC = GLES20.glGetUniformLocation(this.mShaderProgram, "textureTransform");
  }
  
  private void setupTexture()
  {
    if (this.mMediaPlayer == null) {
      return;
    }
    egn();
    GLES20.glActiveTexture(33984);
    GLES20.glGenTextures(1, this.mTextures, 0);
    GLES20.glBindTexture(36197, this.mTextures[0]);
    this.e = new SurfaceTexture(this.mTextures[0]);
    this.e.setOnFrameAvailableListener(this);
    Surface localSurface = new Surface(this.e);
    try
    {
      this.mMediaPlayer.setSurface(localSurface);
      localSurface.release();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("VPNGRenderer", 1, "setupTexture(" + this.mFilePath + "): " + localException.getMessage());
      }
    }
  }
  
  private void setupVertexBuffer()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(sDrawOrder.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.mDrawListBuffer = localByteBuffer.asShortBuffer();
    this.mDrawListBuffer.put(sDrawOrder);
    this.mDrawListBuffer.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(this.dB.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.mVertexBuffer = localByteBuffer.asFloatBuffer();
    this.mVertexBuffer.put(this.dB);
    this.mVertexBuffer.position(0);
  }
  
  void a(aqxw paramaqxw)
  {
    this.a = paramaqxw;
  }
  
  public void a(String paramString, int paramInt, LiveRoomGiftCallback paramLiveRoomGiftCallback)
  {
    this.edD = paramInt;
    this.mFilePath = paramString;
    this.mCallback = paramLiveRoomGiftCallback;
  }
  
  public void egl()
  {
    setupGraphics();
    setupVertexBuffer();
    setupTexture();
    rp();
    this.a.onDrawBegin();
  }
  
  public void egm() {}
  
  public void onDestroy()
  {
    try
    {
      if (this.mMediaPlayer != null) {
        this.mMediaPlayer.pause();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("VPNGRenderer", 2, "onDestroy: " + localException.getMessage());
    }
  }
  
  public void onDrawFrame()
  {
    if (this.mSurface == null) {
      GLES20.glClearColor(1.0F, 1.0F, 1.0F, 0.0F);
    }
    for (;;)
    {
      GLES20.glClear(16640);
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      draw();
      GLES20.glFinish();
      return;
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    }
  }
  
  /* Error */
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 111	aqxx:mFrameAvailable	Z
    //   7: aload_0
    //   8: iconst_1
    //   9: putfield 103	aqxx:mIsReady	Z
    //   12: aload_0
    //   13: getfield 294	aqxx:mFirstTime	J
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +33 -> 51
    //   21: aload_0
    //   22: invokestatic 451	java/lang/System:currentTimeMillis	()J
    //   25: putfield 294	aqxx:mFirstTime	J
    //   28: aload_0
    //   29: getfield 91	aqxx:mCallback	Lcooperation/liveroom/LiveRoomGiftCallback;
    //   32: ifnull +16 -> 48
    //   35: aload_0
    //   36: getfield 91	aqxx:mCallback	Lcooperation/liveroom/LiveRoomGiftCallback;
    //   39: iconst_4
    //   40: ldc_w 453
    //   43: invokeinterface 459 3 0
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_0
    //   52: getfield 91	aqxx:mCallback	Lcooperation/liveroom/LiveRoomGiftCallback;
    //   55: ifnull -7 -> 48
    //   58: aload_0
    //   59: getfield 91	aqxx:mCallback	Lcooperation/liveroom/LiveRoomGiftCallback;
    //   62: iconst_5
    //   63: ldc_w 453
    //   66: invokeinterface 459 3 0
    //   71: goto -23 -> 48
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	aqxx
    //   0	79	1	paramSurfaceTexture	SurfaceTexture
    // Exception table:
    //   from	to	target	type
    //   2	48	74	finally
    //   48	50	74	finally
    //   51	71	74	finally
    //   75	77	74	finally
  }
  
  public void pauseVideo()
  {
    this.mIsPause = true;
    if (this.mMediaPlayer != null) {}
    try
    {
      this.mMediaPlayer.pause();
      if (this.mCallback != null) {
        this.mCallback.onCall(3, "");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("VPNGRenderer", 2, "pauseVideo: " + localException.getMessage());
      }
    }
  }
  
  public void play()
  {
    play(this.mFilePath);
  }
  
  public void release()
  {
    stopRender();
    if (this.e != null)
    {
      this.e.release();
      this.e = null;
    }
    if (this.mMediaPlayer != null) {}
    try
    {
      this.mMediaPlayer.stop();
      this.mMediaPlayer.release();
      this.mMediaPlayer.setOnCompletionListener(null);
      this.mMediaPlayer = null;
      this.mIsReady = false;
      if (this.mCallback != null) {
        this.mCallback.onCall(6, "");
      }
      super.release();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("VPNGRenderer", 2, "release: " + localException.getMessage());
      }
    }
  }
  
  public void resumeVideo()
  {
    this.mIsPause = false;
    if ((this.mIsPrepared) && (this.mMediaPlayer != null)) {}
    try
    {
      this.mMediaPlayer.start();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("VPNGRenderer", 2, "resumeVideo: " + localException.getMessage());
    }
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.aEj = paramBoolean;
  }
  
  public void setRefresh(boolean paramBoolean)
  {
    this.cWS = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqxx
 * JD-Core Version:    0.7.0.1
 */