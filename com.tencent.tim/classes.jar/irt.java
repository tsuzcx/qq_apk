import android.media.MediaPlayer;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class irt
  implements jhb
{
  private boolean UC;
  public VideoController a;
  public irx.a a;
  public irx a;
  private jgq a;
  private int asQ;
  private ArrayList<String> iA;
  public VideoAppInterface mApp;
  private boolean mHasInit;
  public MediaPlayer mediaPlayer;
  
  public irt(VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    QLog.i("AVRedPacketMusicPlayer", 1, "AVRedPacketMusicPlayer usePcm=" + paramBoolean);
    this.mApp = paramVideoAppInterface;
    this.UC = paramBoolean;
    if (!jdh.wz())
    {
      QLog.i("AVRedPacketMusicPlayer", 1, "AVRedPacketMusicPlayer system not support, using mp3");
      this.UC = false;
    }
  }
  
  private String G(String paramString1, String paramString2)
  {
    paramString2 = new StringBuilder().append(paramString1).append(paramString2);
    if (this.UC) {}
    for (paramString1 = ".pcm";; paramString1 = ".mp3") {
      return paramString1;
    }
  }
  
  private String aN(int paramInt)
  {
    jhr.a locala = jik.a(this.mApp).a();
    if (!locala.Zp) {
      return null;
    }
    switch (paramInt)
    {
    case 6: 
    default: 
      return null;
    case 1: 
      return G(locala.RY, "321go");
    case 2: 
      return G(locala.RY, "cool");
    case 3: 
      return G(locala.RY, "perfect");
    case 4: 
      return G(locala.RY, "miss");
    case 5: 
      return G(locala.RY, "excellent");
    }
    return G(locala.RY, "background" + this.asQ);
  }
  
  public void C(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketMusicPlayer", 2, "playMusic, musicType = " + paramInt + ",loop = " + paramBoolean);
    }
    String str;
    if (this.UC) {
      if (this.jdField_a_of_type_Jgq != null)
      {
        str = aN(paramInt);
        if (paramInt != 7) {
          break label75;
        }
        this.jdField_a_of_type_Jgq.ku(str);
      }
    }
    label75:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Jgq.kv(str);
        return;
        if (paramInt != 7) {
          break;
        }
        if (this.mediaPlayer != null)
        {
          this.mediaPlayer.start();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AVRedPacketMusicPlayer", 2, "playMusic, mediaPlayer is null");
      return;
      if (this.jdField_a_of_type_Irx != null)
      {
        str = aN(paramInt);
        this.jdField_a_of_type_Irx.Z(str, paramBoolean);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AVRedPacketMusicPlayer", 2, "playMusic, soundPoolHelper is null");
  }
  
  public void a(int paramInt, jhr.a parama)
  {
    if ((parama == null) || (this.mHasInit) || (this.jdField_a_of_type_ComTencentAvVideoController == null))
    {
      QLog.i("AVRedPacketMusicPlayer", 1, "init ,configInfo == null || mHasInit || mVideoController == null");
      return;
    }
    this.mHasInit = true;
    this.asQ = paramInt;
    String str1 = G(parama.RY, "321go");
    String str2 = G(parama.RY, "cool");
    String str3 = G(parama.RY, "perfect");
    String str4 = G(parama.RY, "miss");
    String str5 = G(parama.RY, "excellent");
    parama = G(parama.RY, "background" + this.asQ);
    if (QLog.isColorLevel()) {
      QLog.i("AVRedPacketMusicPlayer", 2, "init ,bgFilePath = " + parama);
    }
    if (this.UC)
    {
      this.jdField_a_of_type_Jgq = new jgq(4096);
      this.iA = new ArrayList(6);
      this.iA.add(str1);
      this.iA.add(str2);
      this.iA.add(str3);
      this.iA.add(str4);
      this.iA.add(str5);
      this.iA.add(parama);
      this.jdField_a_of_type_ComTencentAvVideoController.a(1, this);
      this.jdField_a_of_type_ComTencentAvVideoController.b().Qs = true;
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording)
      {
        paramInt = this.jdField_a_of_type_ComTencentAvVideoController.registerDAudioDataCallback(3, true);
        i = this.jdField_a_of_type_ComTencentAvVideoController.c(3, 48000, 1, 16);
        QLog.d("AVRedPacketMusicPlayer", 1, "init, registerDAudioDataCallback, mix = true, ret3=" + paramInt + ", set3=" + i);
        this.jdField_a_of_type_ComTencentAvVideoController.b().Qq = true;
        this.jdField_a_of_type_ComTencentAvVideoController.b().Qr = true;
        return;
      }
      paramInt = this.jdField_a_of_type_ComTencentAvVideoController.registerDAudioDataCallback(3, false);
      int i = this.jdField_a_of_type_ComTencentAvVideoController.c(3, 48000, 1, 16);
      QLog.d("AVRedPacketMusicPlayer", 1, "init, registerDAudioDataCallback, mix = false, ret3=" + paramInt + ", set3=" + i);
      this.jdField_a_of_type_ComTencentAvVideoController.b().Qq = false;
      this.jdField_a_of_type_ComTencentAvVideoController.b().Qr = false;
      return;
    }
    this.mediaPlayer = new MediaPlayer();
    try
    {
      this.mediaPlayer.setAudioStreamType(0);
      this.mediaPlayer.setDataSource(parama);
      this.mediaPlayer.setLooping(true);
      long l1 = System.currentTimeMillis();
      this.mediaPlayer.prepare();
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketMusicPlayer", 2, "init, mediaPlayer.prepare cost = " + (l2 - l1));
      }
      parama = new ArrayList();
      parama.add(str1);
      parama.add(str2);
      parama.add(str3);
      parama.add(str4);
      parama.add(str5);
      this.jdField_a_of_type_Irx = new irx(parama, 0);
      return;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        QLog.e("AVRedPacketMusicPlayer", 1, "init  exception", parama);
      }
    }
  }
  
  public void a(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  public void a(irx.a parama)
  {
    if (!this.mHasInit) {
      QLog.i("AVRedPacketMusicPlayer", 1, "preloadMusic MusicPlayer not init, return");
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Irx$a = parama;
        if (!this.UC) {
          break;
        }
        if ((this.iA != null) && (this.jdField_a_of_type_Jgq != null) && (this.iA.size() > 0))
        {
          parama = this.iA.iterator();
          while (parama.hasNext())
          {
            String str = (String)parama.next();
            this.jdField_a_of_type_Jgq.cF(str);
          }
        }
      } while (this.jdField_a_of_type_Irx$a == null);
      this.jdField_a_of_type_Irx$a.onLoadFinish();
      return;
    } while (this.jdField_a_of_type_Irx == null);
    this.jdField_a_of_type_Irx.b(new iru(this));
  }
  
  public void g(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.UC) && (this.jdField_a_of_type_Jgq != null)) {
      this.jdField_a_of_type_Jgq.e(paramArrayOfByte, paramInt2);
    }
  }
  
  public void lF(int paramInt)
  {
    if (this.UC) {
      if (this.jdField_a_of_type_Jgq != null)
      {
        if (paramInt != 7) {
          break label28;
        }
        this.jdField_a_of_type_Jgq.awf();
      }
    }
    label28:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Jgq.awg();
        return;
        if (paramInt != 7) {
          break;
        }
        if (this.mediaPlayer != null)
        {
          this.mediaPlayer.stop();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AVRedPacketMusicPlayer", 2, "stopMusic, mediaPlayer is null");
      return;
      if (this.jdField_a_of_type_Irx != null)
      {
        String str = aN(paramInt);
        this.jdField_a_of_type_Irx.jx(str);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AVRedPacketMusicPlayer", 2, "stopMusic, soundPoolHelper is null");
  }
  
  public void release()
  {
    try
    {
      if (this.UC)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.b().Qs = false;
        this.jdField_a_of_type_ComTencentAvVideoController.a(1, null);
        QLog.i("AVRedPacketMusicPlayer", 1, "release unregisterDAudioDataCallbackAll, mix=" + this.jdField_a_of_type_ComTencentAvVideoController.b().Qr);
        int i = this.jdField_a_of_type_ComTencentAvVideoController.unregisterDAudioDataCallback(3, this.jdField_a_of_type_ComTencentAvVideoController.b().Qr);
        QLog.i("AVRedPacketMusicPlayer", 1, "release unregisterDAudioDataCallbackAll, ret3=" + i);
        this.jdField_a_of_type_ComTencentAvVideoController.b().Qr = false;
        this.jdField_a_of_type_ComTencentAvVideoController.b().Qq = false;
        if (this.jdField_a_of_type_Jgq != null) {
          this.jdField_a_of_type_Jgq.release();
        }
        this.jdField_a_of_type_Jgq = null;
      }
      for (;;)
      {
        this.iA = null;
        this.mHasInit = false;
        return;
        if (this.jdField_a_of_type_Irx != null)
        {
          this.jdField_a_of_type_Irx.aqi();
          this.jdField_a_of_type_Irx = null;
        }
        if (this.mediaPlayer != null)
        {
          this.mediaPlayer.reset();
          this.mediaPlayer.release();
          this.mediaPlayer = null;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AVRedPacketMusicPlayer", 1, "setGameFinish exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     irt
 * JD-Core Version:    0.7.0.1
 */