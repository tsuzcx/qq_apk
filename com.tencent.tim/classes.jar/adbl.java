import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class adbl
  implements SoundPool.OnLoadCompleteListener
{
  private boolean bLb;
  private Map<String, adbl.a> jC = new HashMap(10);
  private boolean mIsPaused;
  private SoundPool mSoundPool = new SoundPool(10, 3, 0);
  
  public adbl()
  {
    this.mSoundPool.setOnLoadCompleteListener(this);
  }
  
  private void cPJ()
  {
    try
    {
      Iterator localIterator = this.jC.entrySet().iterator();
      while (localIterator.hasNext())
      {
        adbl.a locala = (adbl.a)((Map.Entry)localIterator.next()).getValue();
        if ((locala != null) && (locala.isPlaying()))
        {
          this.mSoundPool.pause(locala.cBD);
          locala.mState = 2;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ARPromotionSoundPlayer", 2, "stopSound exception", localException);
      }
    }
  }
  
  public void bT(String paramString, boolean paramBoolean)
  {
    int i = -1;
    if (QLog.isColorLevel()) {
      QLog.d("ARPromotionSoundPlayer", 2, "playSound resPath: " + paramString);
    }
    this.bLb = false;
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("ARPromotionSoundPlayer", 2, "playSound resPath is empty!");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (new File(paramString).exists()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ARPromotionSoundPlayer", 2, "playSound file not exist");
        return;
      } while (this.bLb);
      if (!this.jC.containsKey(paramString)) {
        break;
      }
      cPJ();
      paramString = (adbl.a)this.jC.get(paramString);
    } while (paramString == null);
    if (QLog.isColorLevel()) {
      QLog.d("ARPromotionSoundPlayer", 2, "playSound contains resPath, state: " + paramString.mState);
    }
    if (!this.mIsPaused)
    {
      if (paramString.isLoaded())
      {
        localSoundPool = this.mSoundPool;
        j = paramString.cBE;
        if (paramBoolean) {
          paramString.cBD = localSoundPool.play(j, 1.0F, 1.0F, 0, i, 1.0F);
        }
      }
      while (!paramString.isPlaying()) {
        for (;;)
        {
          paramString.mState = 3;
          return;
          i = 0;
        }
      }
      SoundPool localSoundPool = this.mSoundPool;
      int j = paramString.cBE;
      if (paramBoolean) {}
      for (;;)
      {
        paramString.cBD = localSoundPool.play(j, 1.0F, 1.0F, 0, i, 1.0F);
        break;
        i = 0;
      }
    }
    paramString.mState = 4;
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ARPromotionSoundPlayer", 2, "playSound not contains resPath, load");
    }
    i = this.mSoundPool.load(paramString, 1);
    this.jC.put(paramString, new adbl.a(i, 3));
  }
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARPromotionSoundPlayer", 2, "onLoadComplete sampleId:" + paramInt1 + ", status:" + paramInt2);
    }
    if (paramInt2 == 0) {
      try
      {
        Iterator localIterator = this.jC.entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            locala = (adbl.a)((Map.Entry)localIterator.next()).getValue();
            if ((locala != null) && (locala.cBE == paramInt1))
            {
              if (locala.isLoading())
              {
                locala.mState = 2;
                return;
              }
              if (locala.isPlaying()) {
                if (!this.mIsPaused)
                {
                  locala.cBD = paramSoundPool.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F);
                  return;
                }
              }
            }
          }
        }
      }
      catch (Exception paramSoundPool)
      {
        adbl.a locala;
        paramSoundPool.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.e("ARPromotionSoundPlayer", 2, "onLoadComplete exception", paramSoundPool);
          return;
          locala.mState = 4;
        }
      }
    }
  }
  
  public void release()
  {
    ThreadManager.post(new ARPromotionSoundPlayer.1(this), 8, null, true);
  }
  
  public class a
  {
    public int cBD;
    public int cBE;
    public int mState;
    
    public a(int paramInt1, int paramInt2)
    {
      this.cBE = paramInt1;
      this.mState = paramInt2;
    }
    
    public boolean isLoaded()
    {
      return this.mState == 2;
    }
    
    public boolean isLoading()
    {
      return this.mState == 1;
    }
    
    public boolean isPlaying()
    {
      return this.mState == 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adbl
 * JD-Core Version:    0.7.0.1
 */