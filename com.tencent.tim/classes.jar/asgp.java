import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.qg.sdk.video.IMediaPlayer;
import com.tencent.qg.sdk.video.VideoPlayer;
import com.tencent.qg.video.videodecoder.MediaDecoder;
import com.tencent.qg.video.videodecoder.MediaDecoder.a;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class asgp
  implements IMediaPlayer
{
  private MediaDecoder.a jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$a = new asgq(this);
  private MediaDecoder jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder;
  private GPUOESBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter;
  private String cEE;
  private boolean dem;
  private boolean den;
  private boolean deo;
  private volatile boolean dep;
  private int elV;
  private int elW;
  private int elX = -1;
  private int elY = -1;
  private volatile int elZ = 0;
  private RenderBuffer h;
  private int mHeight;
  private long mPlayerHandle;
  private String mSrc;
  private SurfaceTexture mSurfaceTexture;
  private int mWidth;
  
  private int[] aj()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(36197, arrayOfInt[0]);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    return arrayOfInt;
  }
  
  private void eni()
  {
    ram.d("DefaultMediaPlayer", "onVideoPlayEnded");
    VideoPlayer.nativeEvent(this.mPlayerHandle, "ended");
    this.dep = true;
  }
  
  private void enj()
  {
    ram.d("DefaultMediaPlayer", "onVideoPlayRepeated");
    this.dep = false;
  }
  
  private void enl()
  {
    boolean bool2 = true;
    asgr.aP(hashCode(), "[Player] handle play cmd from qg");
    ram.b("DefaultMediaPlayer", "handleStartPlay , src = %s", this.mSrc);
    this.elW = aj()[0];
    if (this.h == null) {
      this.h = new RenderBuffer(this.mWidth, this.mHeight, 33984);
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter == null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter = ((GPUOESBaseFilter)amas.a(102));
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.init();
    }
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.enr();
    }
    this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder = new MediaDecoder(this.mSrc, this.elW, this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$a, false, hashCode());
    this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.enq();
    MediaDecoder localMediaDecoder;
    if (this.elY != -1)
    {
      localMediaDecoder = this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder;
      if (this.elY == 1)
      {
        bool1 = true;
        localMediaDecoder.setLoop(bool1);
      }
    }
    else if (this.elX != -1)
    {
      localMediaDecoder = this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder;
      if (this.elX != 1) {
        break label218;
      }
    }
    label218:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localMediaDecoder.setMuted(bool1);
      this.dep = false;
      this.elZ = 0;
      asgr.aP(hashCode(), "[Player] handle play cmd from qg finish");
      return;
      bool1 = false;
      break;
    }
  }
  
  private void enm()
  {
    ram.b("DefaultMediaPlayer", "handleResumePlay , src = %s", this.mSrc);
    this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.resumeDecode();
  }
  
  private void enn()
  {
    if (this.mSurfaceTexture != null) {
      this.mSurfaceTexture.updateTexImage();
    }
    this.h.setTexId(this.elV);
    this.h.bind();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.drawTexture(this.elW, null, null);
    this.h.unbind();
    if (this.elZ == 1)
    {
      this.elZ = 2;
      VideoPlayer.nativeEvent(this.mPlayerHandle, "ready");
      asgr.aP(hashCode(), "[Player] render first frame to qg");
    }
  }
  
  public void XJ(String paramString)
  {
    this.cEE = paramString;
  }
  
  public void create(long paramLong)
  {
    ram.d("DefaultMediaPlayer", "qg -> create");
    this.mPlayerHandle = paramLong;
  }
  
  public void destroy()
  {
    ram.d("DefaultMediaPlayer", "qg -> destroy");
    onStop();
    if (this.h != null) {
      this.h.destroy();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.destroy();
    }
  }
  
  public void enk()
  {
    if (this.dem)
    {
      this.dem = false;
      this.deo = false;
      enl();
    }
    do
    {
      return;
      if (this.den)
      {
        this.den = false;
        enm();
        return;
      }
    } while (!isPlaying());
    enn();
  }
  
  public int getCurrentPosition()
  {
    return (int)this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.ih();
  }
  
  public int getDuration()
  {
    return (int)pog.getDurationOfVideo(this.mSrc);
  }
  
  public boolean isEnd()
  {
    return this.dep;
  }
  
  public boolean isMuted()
  {
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
      return this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.isMuted();
    }
    return false;
  }
  
  public boolean isPlaying()
  {
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
      return this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.aHP();
    }
    return false;
  }
  
  public void onPause()
  {
    ram.d("DefaultMediaPlayer", "onPause");
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.pauseDecode();
    }
  }
  
  public void onResume()
  {
    ram.d("DefaultMediaPlayer", "onResume");
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.resumeDecode();
    }
  }
  
  public void onStop()
  {
    ram.d("DefaultMediaPlayer", "onStop");
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.enr();
    }
  }
  
  public void pause()
  {
    ram.d("DefaultMediaPlayer", "qg -> pause");
    onPause();
  }
  
  public void play(int paramInt1, int paramInt2, int paramInt3)
  {
    ram.a("DefaultMediaPlayer", "qg -> play , texture id = %d , width = %d , height = %d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
    asgr.aP(hashCode(), "[Player] receive play cmd from qg");
    this.elV = paramInt1;
    this.mWidth = paramInt2;
    this.mHeight = paramInt3;
    if ((!this.deo) && (isPlaying())) {
      return;
    }
    if ((!this.deo) && (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) && (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.isPause()))
    {
      this.den = true;
      this.dem = false;
      return;
    }
    this.den = false;
    this.dem = true;
  }
  
  public void seekTo(int paramInt)
    throws IllegalStateException
  {
    this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.seekTo(paramInt);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.elY = i;
      if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
        this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.setLoop(paramBoolean);
      }
      return;
    }
  }
  
  public void setMuted(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.elX = i;
      if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
        this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.setMuted(paramBoolean);
      }
      return;
    }
  }
  
  public void setSrc(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(this.cEE))
    {
      str = paramString;
      if (!paramString.startsWith(this.cEE)) {
        str = this.cEE + paramString;
      }
    }
    if (!TextUtils.equals(str, this.mSrc)) {}
    for (boolean bool = true;; bool = false)
    {
      this.deo = bool;
      this.mSrc = str;
      ram.b("DefaultMediaPlayer", "qg -> set Src , src = %s , isSrcChanged :%s", str, Boolean.valueOf(this.deo));
      return;
    }
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    ram.d("DefaultMediaPlayer", "qg -> setVolume , not support yet");
  }
  
  public void stop()
  {
    ram.d("DefaultMediaPlayer", "qg -> stop");
    onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asgp
 * JD-Core Version:    0.7.0.1
 */