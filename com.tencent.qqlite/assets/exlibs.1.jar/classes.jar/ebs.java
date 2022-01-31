import android.app.Application;
import android.media.AudioTrack;
import android.os.Process;
import com.tencent.mobileqq.ptt.player.IPttPlayerListener;
import com.tencent.mobileqq.ptt.player.SilkPlayer;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;

public class ebs
  extends Thread
{
  private int jdField_a_of_type_Int;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private SilkCodecWrapper jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper;
  private boolean jdField_a_of_type_Boolean = true;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private byte[] b;
  
  public ebs(SilkPlayer paramSilkPlayer, Application paramApplication)
  {
    int i = RecordParams.a(SilkPlayer.a(paramSilkPlayer));
    this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper = new SilkCodecWrapper(paramApplication, false, i, 0);
    this.jdField_a_of_type_Int = RecordParams.a(i);
    this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
    this.b = new byte[this.jdField_a_of_type_Int];
    if (QLog.isColorLevel()) {
      QLog.d("SilkPlayer", 2, "SilkPlayerThread sampleRate=" + i + ", oneFrameSize=" + this.jdField_a_of_type_Int + ", currenttime:" + System.currentTimeMillis());
    }
  }
  
  public void run()
  {
    byte[] arrayOfByte = new byte[2];
    Process.setThreadPriority(-19);
    for (;;)
    {
      try
      {
        SilkPlayer.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer).b();
        if (SilkPlayer.b(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer) != -1) {
          if (SilkPlayer.b(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer) == this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer.a())
          {
            i = SilkPlayer.c(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer);
            j = SilkPlayer.c(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer);
            SilkPlayer.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer, -1);
            k = i;
            i = j;
            localFileInputStream = new FileInputStream(SilkPlayer.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer));
            if (k != 0) {
              continue;
            }
          }
        }
      }
      catch (Exception localException2)
      {
        int k;
        FileInputStream localFileInputStream;
        Object localObject1 = null;
        int j = 0;
        continue;
        int i = 0;
        Object localObject3 = localObject1;
        continue;
      }
      try
      {
        localFileInputStream.skip(10L);
        i += 10;
      }
      catch (Exception localException1)
      {
        j = 0;
        i = j;
        localObject3 = localFileInputStream;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SilkPlayer", 2, "silk play exception " + localException1.getMessage());
        i = j;
        localObject3 = localFileInputStream;
        continue;
        i = RecordParams.a(localException1);
        if (i > 0) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer.g();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SilkPlayer", 2, "silk decode error: error frame size=" + i);
        i = 0;
        localObject3 = localFileInputStream;
        continue;
        if (SilkPlayer.b(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer) != -1) {
          continue;
        }
        k = localFileInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, i);
        j += i;
        if (k != -1) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer.g();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SilkPlayer", 2, "silk decode error: failed to read frameSize=" + i);
        i = 0;
        localObject3 = localFileInputStream;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.a(this.jdField_a_of_type_ArrayOfByte, this.b, i, this.b.length) != 0) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer.g();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SilkPlayer", 2, "silk decode jni error");
        i = 0;
        localObject3 = localFileInputStream;
        continue;
        this.jdField_a_of_type_AndroidMediaAudioTrack.write(this.b, 0, this.jdField_a_of_type_Int);
        try
        {
          SilkPlayer.c(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer, j);
          SilkPlayer.e(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer);
          i = j;
          if (SilkPlayer.b(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer) == -1) {
            continue;
          }
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer.a() < SilkPlayer.b(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer)) {
            continue;
          }
          SilkPlayer.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer, -1);
          i = j;
          continue;
        }
        finally {}
        j += i;
        localFileInputStream.skip(i);
        continue;
      }
      if ((!this.jdField_a_of_type_Boolean) || (localFileInputStream == null)) {
        continue;
      }
      k = localFileInputStream.read(arrayOfByte, 0, 2);
      j = i + 2;
      if (k != -1) {
        continue;
      }
      k = 1;
      j = 1;
      i = j;
      localObject3 = localFileInputStream;
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.d("SilkPlayer", 2, "silk decode completed mCurrentPlayFrame=" + SilkPlayer.d(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer) + ", mCurrentFileOffset" + SilkPlayer.c(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer));
          localObject3 = localFileInputStream;
          i = j;
        }
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidMediaAudioTrack.stop();
        this.jdField_a_of_type_AndroidMediaAudioTrack.release();
        this.jdField_a_of_type_AndroidMediaAudioTrack = null;
        this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.b();
        if (i != 0) {
          this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer.h();
        }
        if (localObject3 == null) {}
      }
      catch (Exception localException3)
      {
        long l;
        j = k;
        continue;
      }
      try
      {
        ((FileInputStream)localObject3).close();
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return;
      }
      SilkPlayer.b(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer, 0);
      SilkPlayer.c(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer, 0);
      k = 0;
      i = 0;
      continue;
      l = k;
      localFileInputStream.skip(l);
    }
  }
  
  public void start()
  {
    int i = AudioTrack.getMinBufferSize(RecordParams.a(SilkPlayer.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer)), 4, 2);
    this.jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(SilkPlayer.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer), RecordParams.a(SilkPlayer.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer)), 4, 2, i, 1);
    if (QLog.isColorLevel()) {
      QLog.d("SilkPlayer", 2, "start play silk mStreamType=" + SilkPlayer.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer) + ", rate=" + RecordParams.a(SilkPlayer.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer)) + ", playBufferSize = " + i + ", currenttime:" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_AndroidMediaAudioTrack.play();
    super.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ebs
 * JD-Core Version:    0.7.0.1
 */