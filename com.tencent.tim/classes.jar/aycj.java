import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aycj
{
  public static aycj a;
  private rmz b;
  public String cWF;
  boolean dym = false;
  public int eJB = 0;
  public int eJC = 0;
  protected Object mLock = new Object();
  
  public static aycj a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aycj();
      }
      return a;
    }
    finally {}
  }
  
  public static String sN(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      int i = paramString.lastIndexOf('.');
      if ((i > -1) && (i < paramString.length() - 1)) {
        return paramString.substring(0, i) + ".pcm";
      }
    }
    return null;
  }
  
  public void adu(String paramString)
  {
    if (this.eJC == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StoryGameAudioMixManager", 2, "muxGameEffect called " + paramString);
      }
      if ((Build.VERSION.SDK_INT >= 16) && (this.b != null)) {
        this.b.sE(paramString);
      }
    }
  }
  
  public void eQe()
  {
    if ((Build.VERSION.SDK_INT >= 16) && (this.b != null)) {
      this.b.LM();
    }
  }
  
  public void eQf()
  {
    this.eJC = 0;
    this.cWF = null;
    this.dym = false;
    if (this.b != null)
    {
      this.b.aIS = false;
      this.b.stop();
      this.b.release();
      this.b = null;
    }
  }
  
  public void jT(String paramString1, String paramString2)
  {
    byte[] arrayOfByte = aqhq.fileToBytes(new File(paramString1));
    Object localObject = null;
    if (arrayOfByte == null)
    {
      QLog.e("StoryGameAudioMixManager", 1, "录音文件为空");
      return;
    }
    String str = sN(paramString2);
    if (str != null)
    {
      localObject = new File(str);
      if (!((File)localObject).exists())
      {
        if (!aycg.h(new File(paramString2), new File(str))) {
          break label135;
        }
        this.eJB = 2;
        if (QLog.isColorLevel()) {
          QLog.d("StoryGameAudioMixManager", 2, "convert mp3 in publish now");
        }
      }
      localObject = aqhq.fileToBytes((File)localObject);
    }
    else
    {
      if (localObject != null) {
        break label144;
      }
      QLog.e("StoryGameAudioMixManager", 1, "bgm为空" + str);
      return;
    }
    label135:
    QLog.e("StoryGameAudioMixManager", 1, "bgm conver fail");
    return;
    label144:
    paramString2 = new byte[arrayOfByte.length];
    if (aycg.a(paramString2, (byte[])localObject, arrayOfByte, arrayOfByte.length, 0.0D))
    {
      if (!QLog.isColorLevel()) {
        break label185;
      }
      QLog.d("StoryGameAudioMixManager", 2, "mixAudioFileToPcmBytes succedd");
    }
    for (;;)
    {
      aqhq.writeFile(paramString2, paramString1);
      return;
      label185:
      QLog.d("StoryGameAudioMixManager", 2, "mixAudioFileToPcmBytes fail");
    }
  }
  
  public boolean uk(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = paramString.split("/");
      paramString = paramString[(paramString.length - 1)];
    } while ((!"bg_audio.mp3".equals(paramString)) && (!"bgm.mp3".equals(paramString)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aycj
 * JD-Core Version:    0.7.0.1
 */