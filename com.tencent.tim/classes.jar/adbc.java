import android.media.MediaPlayer;
import android.media.SoundPool;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class adbc
{
  private SoundPool a;
  private HashSet<Integer> aX;
  private HashSet<Integer> aY;
  private boolean bKP;
  private boolean bKQ;
  private boolean bKR;
  private boolean bKS;
  private boolean bKT;
  private String brA;
  private String brz;
  private int cBw;
  private HashMap<String, Integer> jr;
  MediaPlayer mediaPlayer = new MediaPlayer();
  
  public adbc(int paramInt, String... paramVarArgs)
  {
    try
    {
      this.bKT = true;
      this.jr = new HashMap();
      this.aX = new HashSet();
      this.aY = new HashSet();
      this.a = new SoundPool(paramInt, 3, 0);
      this.a.setOnLoadCompleteListener(new adbg(this));
      this.mediaPlayer = new MediaPlayer();
      this.mediaPlayer.setOnPreparedListener(new adbh(this));
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        int j = paramVarArgs.length;
        paramInt = i;
        while (paramInt < j)
        {
          String str = paramVarArgs[paramInt];
          if (!TextUtils.isEmpty(str))
          {
            i = this.a.load(str, 1);
            this.jr.put(str, Integer.valueOf(i));
            if (QLog.isColorLevel()) {
              QLog.d("ARMusicController", 2, "load file:" + str + ", id=" + i);
            }
          }
          paramInt += 1;
        }
      }
      return;
    }
    catch (Exception paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
  }
  
  public adbc(String paramString1, String paramString2)
  {
    try
    {
      this.brz = paramString1;
      this.brA = paramString2;
      this.a = new SoundPool(1, 3, 0);
      this.a.setOnLoadCompleteListener(new adbd(this));
      this.mediaPlayer = new MediaPlayer();
      this.mediaPlayer.setOnPreparedListener(new adbe(this));
      this.mediaPlayer.setOnErrorListener(new adbf(this));
      this.cBw = this.a.load(paramString2, 1);
      try
      {
        this.mediaPlayer.setDataSource(paramString1);
        this.mediaPlayer.prepareAsync();
        return;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void FQ(boolean paramBoolean)
  {
    try
    {
      if (this.bKQ) {
        this.mediaPlayer.start();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ARMusicController", 2, "playBgMusic : " + this.brz);
        return;
        this.bKS = true;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void bT(String paramString, boolean paramBoolean)
  {
    int i;
    for (;;)
    {
      try
      {
        if (!this.bKT) {
          return;
        }
        if (this.jr.containsKey(paramString))
        {
          i = ((Integer)this.jr.get(paramString)).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("ARMusicController", 2, "playSound path=" + paramString + ", id=" + i);
          }
          if (i == -1) {
            return;
          }
          if (!this.aY.contains(Integer.valueOf(i))) {
            break;
          }
          this.a.play(i, 1.0F, 1.0F, 1, 0, 1.0F);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ARMusicController", 2, paramString, new Object[0]);
        return;
      }
      i = -1;
    }
    if (paramBoolean)
    {
      this.aX.add(Integer.valueOf(i));
      return;
    }
    this.aX.remove(Integer.valueOf(i));
  }
  
  public void bsg()
  {
    FQ(false);
  }
  
  public void cPE()
  {
    try
    {
      this.mediaPlayer.stop();
      this.bKQ = false;
      this.mediaPlayer.prepareAsync();
      if (QLog.isColorLevel()) {
        QLog.d("ARMusicController", 2, "stopAllMusic");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void destroy()
  {
    try
    {
      this.mediaPlayer.release();
      this.a.release();
      this.jr = null;
      this.aX = null;
      this.aY = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void h(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (!new File(paramString).exists())
        {
          QLog.d("ARMusicController", 2, "playBgMusic file not exist" + paramString);
          return;
        }
        if (this.mediaPlayer.isPlaying()) {
          this.mediaPlayer.stop();
        }
        this.brz = paramString;
        this.mediaPlayer.reset();
        this.mediaPlayer.setDataSource(paramString);
        this.mediaPlayer.setLooping(paramBoolean1);
        this.mediaPlayer.prepareAsync();
        this.bKS = paramBoolean2;
        return;
      }
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("ARMusicController", 2, "playBgMusic exception", paramString);
        return;
      }
      QLog.d("ARMusicController", 1, "playBgMusic exception" + paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adbc
 * JD-Core Version:    0.7.0.1
 */