import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.1;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.3;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

public class adbk
  implements SurfaceTexture.OnFrameAvailableListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnDefinitionInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener
{
  private long RQ;
  private adbk.a jdField_a_of_type_Adbk$a;
  private addo jdField_a_of_type_Addo = new addo(0);
  private final boolean bKW = false;
  private boolean bKX;
  private boolean bKY;
  private boolean bKZ = true;
  private boolean bLa;
  private float[] ba = new float[16];
  private String brC;
  private int cBA = -1;
  private int cBB;
  private int cBC = 1;
  private int cBz;
  private ISuperPlayer jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer;
  private TextureRender jdField_d_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private ByteBuffer[] e = new ByteBuffer[3];
  private RenderBuffer f;
  private Runnable fS = new ARPromotionMediaPlayerWrapper.1(this);
  private volatile boolean isFinish;
  volatile boolean isSeeking = false;
  private int[] ks = new int[3];
  private float[] mMVPMatrix = new float[16];
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  
  public adbk(adbk.a parama, int paramInt)
  {
    this.jdField_a_of_type_Adbk$a = parama;
    this.cBz = paramInt;
  }
  
  private void Go(String paramString)
  {
    paramString = SuperPlayerFactory.createVideoInfoForUrl(paramString, 101, arwv.toMD5(paramString));
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.enableCodecReuse = false;
    localSuperPlayerOption.isPrePlay = false;
    this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(BaseApplicationImpl.getContext(), paramString, 0L, localSuperPlayerOption);
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((this.e[0] == null) || (this.ks[0] != paramArrayOfByte1.length)) {}
    try
    {
      this.e[0] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
      this.e[0].order(ByteOrder.nativeOrder());
      this.e[0].clear();
      this.ks[0] = paramArrayOfByte1.length;
      this.e[0].put(paramArrayOfByte1);
      this.e[0].position(0);
      if (this.e[1] != null) {
        if (this.ks[1] == paramArrayOfByte2.length) {
          break label128;
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        this.e[1] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
        this.e[1].order(ByteOrder.nativeOrder());
        label128:
        this.e[1].clear();
        this.ks[1] = paramArrayOfByte2.length;
        this.e[1].put(paramArrayOfByte2);
        this.e[1].position(0);
        if (this.e[2] != null) {
          if (this.ks[2] == paramArrayOfByte3.length) {
            break label212;
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          for (;;)
          {
            this.e[2] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
            this.e[2].order(ByteOrder.nativeOrder());
            label212:
            this.e[2].clear();
            this.ks[2] = paramArrayOfByte3.length;
            this.e[2].put(paramArrayOfByte3);
            this.e[2].position(0);
            return;
            localThrowable1 = localThrowable1;
            QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", localThrowable1);
          }
          localThrowable2 = localThrowable2;
          QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", localThrowable2);
        }
        catch (Throwable paramArrayOfByte1)
        {
          for (;;)
          {
            QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", paramArrayOfByte1);
          }
        }
      }
    }
  }
  
  private void cPH()
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, String.format("initVideoPlayer mVideoPlayer=%s", new Object[] { this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer }));
    if ((this.mSurfaceTexture == null) || (this.mSurface == null))
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      Matrix.setIdentityM(this.ba, 0);
      this.cBA = arrayOfInt[0];
      this.mSurfaceTexture = new SurfaceTexture(this.cBA);
      this.mSurfaceTexture.setOnFrameAvailableListener(this);
      this.mSurface = new Surface(this.mSurfaceTexture);
    }
    if (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 108, null);
    }
    for (;;)
    {
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.setSurface(this.mSurface);
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(this);
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.setOnDefinitionInfoListener(this);
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(this);
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.setOnSeekCompleteListener(this);
      return;
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.reset();
    }
  }
  
  private void cPI()
  {
    if ((this.f == null) && (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer != null))
    {
      this.f = new RenderBuffer(this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.getVideoWidth(), this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.getVideoHeight(), 33984);
      QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer line1");
    }
    if (this.jdField_d_of_type_ComTencentTtpicOpenapiFilterTextureRender == null)
    {
      this.jdField_d_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
      QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer line2");
    }
    if ((this.f != null) && (!GLES20.glIsTexture(this.f.getTexId()))) {
      QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer error happen,FBO texture ID is released");
    }
  }
  
  public void FS(boolean paramBoolean)
  {
    this.bKZ = paramBoolean;
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, String.format("playVideo videoUrl=%s videoSize=%s", new Object[] { paramString, Long.valueOf(paramLong) }));
    cPH();
    if ((this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (!this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying()))
    {
      this.bKZ = true;
      this.bKX = paramBoolean2;
      this.cBB = 0;
      int i = paramInt;
      if (paramInt <= 0) {
        i = 10000;
      }
      this.cBC = i;
      this.brC = paramString;
      Go(paramString);
      this.bKY = false;
    }
  }
  
  public void akG()
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "stopVideo");
    if (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer != null) {}
    for (;;)
    {
      try
      {
        this.RQ = 0L;
        if ((this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying()) || (this.bKY))
        {
          QLog.d("ARWorldCupMediaPlayerWrapper", 1, "run inner stopVideo");
          this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
          this.bKY = false;
        }
      }
      catch (Exception localException2)
      {
        localException2 = localException2;
        QLog.e("ARWorldCupMediaPlayerWrapper", 1, "playVideo fail.", localException2);
        try
        {
          if (this.f == null) {
            continue;
          }
          this.f = null;
          return;
        }
        catch (Exception localException3)
        {
          QLog.e("ARWorldCupMediaPlayerWrapper", 1, "stopVideo finllay fail." + localException3);
          return;
        }
      }
      finally {}
      try
      {
        if (this.f != null) {
          this.f = null;
        }
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("ARWorldCupMediaPlayerWrapper", 1, "stopVideo finllay fail." + localException1);
        return;
      }
    }
    try
    {
      if (this.f != null) {
        this.f = null;
      }
      throw localObject;
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        QLog.e("ARWorldCupMediaPlayerWrapper", 1, "stopVideo finllay fail." + localException4);
      }
    }
  }
  
  public long getCurrentPosition()
  {
    if (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
    }
    return -1L;
  }
  
  public boolean isPlaying()
  {
    if (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
      return false;
    }
    return this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying();
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    this.isSeeking = false;
    paramISuperPlayer = new ARPromotionMediaPlayerWrapper.3(this);
    if (this.jdField_a_of_type_Adbk$a != null) {
      this.jdField_a_of_type_Adbk$a.X(paramISuperPlayer);
    }
  }
  
  public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "onError");
    this.isSeeking = false;
    return false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (this.jdField_a_of_type_Adbk$a != null) {
      this.jdField_a_of_type_Adbk$a.X(this.fS);
    }
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onSeekComplete");
    if (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.isSeeking = false;
    }
    try
    {
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.start();
      return;
    }
    catch (Exception paramISuperPlayer)
    {
      QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onSeekComplete fail.", paramISuperPlayer);
    }
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onVideoPrepared");
    this.isSeeking = false;
    if (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer != null) {}
    try
    {
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.start();
      return;
    }
    catch (Exception paramISuperPlayer)
    {
      QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onVideoPrepared fail.", paramISuperPlayer);
    }
  }
  
  public void release()
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, String.format("releaseVideoPlayer mVideoPlayer=%s", new Object[] { this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer }));
    try
    {
      this.bKZ = true;
      this.jdField_a_of_type_Adbk$a = null;
      if (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer != null)
      {
        this.isFinish = true;
        this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
        this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.release();
        this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer = null;
        this.jdField_a_of_type_Addo.cQG();
        if (this.mSurfaceTexture != null)
        {
          this.mSurfaceTexture.setOnFrameAvailableListener(null);
          this.mSurfaceTexture.release();
          this.mSurfaceTexture = null;
        }
        if (this.mSurface != null)
        {
          this.mSurface.release();
          this.mSurface = null;
        }
        if (this.cBA != -1)
        {
          GLES20.glDeleteTextures(1, new int[] { this.cBA }, 0);
          this.cBA = -1;
        }
        if (this.f != null)
        {
          this.f.destroy();
          this.f = null;
        }
        if (this.jdField_d_of_type_ComTencentTtpicOpenapiFilterTextureRender != null) {
          this.jdField_d_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ARWorldCupMediaPlayerWrapper", 1, "release finllay fail.");
    }
  }
  
  public void restart()
  {
    try
    {
      if ((this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (!this.isSeeking))
      {
        this.isSeeking = true;
        this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.seekTo(0);
        QLog.d("ARWorldCupMediaPlayerWrapper", 1, "mVideoPlayer restart seekTo(0)");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ARWorldCupMediaPlayerWrapper", 1, "restart mVideoPlayer error happen", localException);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, "call setMu result:" + paramBoolean);
    this.bLa = paramBoolean;
    if (this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_d_of_type_ComTencentSuperplayerApiISuperPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public static abstract interface a
  {
    public abstract void X(Runnable paramRunnable);
    
    public abstract void aK(int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adbk
 * JD-Core Version:    0.7.0.1
 */