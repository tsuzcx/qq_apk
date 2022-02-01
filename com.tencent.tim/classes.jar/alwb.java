import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture.a;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.initializer.VoiceChangerInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.voicechanger.common.audio.VoiceChanger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public class alwb
  implements amaj.b
{
  public static int AUDIO_INPUT_BUFFER_SIZE = (int)(AUDIO_SAMPLE_RATE_IN_HZ * 0.02D * 1.0D * 4.0D);
  public static int AUDIO_SAMPLE_RATE_IN_HZ = com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat.SAMPLE_RATES[4];
  private final String TAG = "AudioChangerManager";
  amaj a;
  private AudioCapture.a b;
  private String bYJ;
  private String bYK;
  private boolean czS;
  private int dyx;
  private byte[] fn;
  private String mAudioFilePath;
  private int mEnvironment;
  private boolean mIsActive;
  private RandomAccessFile mMicfile;
  protected VoiceChanger mVoiceChanger;
  private int mVoiceKind;
  
  public alwb(String paramString, int paramInt, AudioCapture.a parama)
  {
    this.bYK = (FileUtils.genSeperateFileDir(paramString) + "audio_data_cache" + File.separator);
    this.b = parama;
  }
  
  private boolean auD()
  {
    try
    {
      File localFile = new File(this.bYK);
      if (!localFile.exists()) {
        return localFile.mkdir();
      }
      if (localFile.isFile())
      {
        localFile.delete();
        boolean bool = localFile.mkdir();
        return bool;
      }
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private boolean isValid()
  {
    return (auD()) && (!TextUtils.isEmpty(this.bYK)) && (this.b != null);
  }
  
  public void aK(boolean paramBoolean, String paramString)
  {
    this.czS = paramBoolean;
    this.bYJ = paramString;
  }
  
  public void dKc()
  {
    axiy.d("AudioChangerManager", "[onAudioFileEncoded]");
    this.b.Pm(this.bYJ);
    this.a = null;
  }
  
  public void dKd()
  {
    axiy.d("AudioChangerManager", "[onAudioFileEncodeFailed]");
    if (this.b != null) {
      this.b.Tx(-6);
    }
    this.a = null;
  }
  
  public void dKg()
  {
    if (this.mVoiceChanger != null) {
      this.mVoiceChanger.release();
    }
    if (this.mMicfile != null) {}
    try
    {
      this.mMicfile.close();
      this.fn = null;
      if (this.a != null) {
        this.a.onStop();
      }
      if (!this.czS) {
        this.b.Pm(this.mAudioFilePath);
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public void init()
  {
    if (!isValid()) {}
    for (;;)
    {
      return;
      this.mAudioFilePath = (this.bYK + anlb.Ab() + ".pcm");
      this.mVoiceChanger = new VoiceChanger(this.mAudioFilePath, AUDIO_SAMPLE_RATE_IN_HZ, this.mVoiceKind, this.mEnvironment);
      try
      {
        this.mMicfile = new RandomAccessFile(this.mAudioFilePath, "rw");
        if (this.fn == null) {
          this.fn = new byte[AUDIO_INPUT_BUFFER_SIZE];
        }
        this.dyx = 0;
        if ((!this.czS) || (this.a != null)) {
          continue;
        }
        this.a = new amaj();
        this.a.Ui(aniq.bth);
        this.a.a(this);
        this.a.onStart(this.bYJ);
        axiy.d("AudioChangerManager", "New mHwAudioEncoder");
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
        }
      }
    }
  }
  
  public boolean isActive()
  {
    return (this.mIsActive) && (FeatureManager.Features.VOICE_CHANGDER.isFunctionReady());
  }
  
  public void o(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((isActive()) && (isValid()))
    {
      paramInt1 = 0;
      if (paramInt2 < AUDIO_INPUT_BUFFER_SIZE) {
        break label202;
      }
      if (this.fn != null) {
        break label31;
      }
    }
    label31:
    label202:
    while ((paramInt2 <= 0) || (this.fn == null)) {
      for (;;)
      {
        return;
        System.arraycopy(paramArrayOfByte, paramInt1, this.fn, this.dyx, AUDIO_INPUT_BUFFER_SIZE - this.dyx);
        Object localObject = new short[AUDIO_INPUT_BUFFER_SIZE / 2];
        ByteBuffer.wrap(this.fn).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get((short[])localObject);
        localObject = this.mVoiceChanger.writeVoiceFrames((short[])localObject);
        if (localObject != null) {
          try
          {
            if (!this.czS) {
              this.mMicfile.write((byte[])localObject, 0, localObject.length);
            }
            if ((this.a != null) && (this.czS))
            {
              byte[] arrayOfByte = new byte[localObject.length];
              System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
              this.a.j(arrayOfByte, 0L);
            }
            paramInt1 += AUDIO_INPUT_BUFFER_SIZE - this.dyx;
            paramInt2 -= AUDIO_INPUT_BUFFER_SIZE - this.dyx;
            this.dyx = 0;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              localIOException.printStackTrace();
            }
          }
        }
      }
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.fn, this.dyx, paramInt2);
    this.dyx = paramInt2;
  }
  
  public void t(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.mIsActive = paramBoolean;
    this.mVoiceKind = paramInt1;
    this.mEnvironment = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwb
 * JD-Core Version:    0.7.0.1
 */