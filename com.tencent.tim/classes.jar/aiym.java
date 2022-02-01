import android.media.SoundPool;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.magicface.service.SoundPoolUtil.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;

public class aiym
{
  protected HashMap<String, Integer> cS;
  public SoundPool mSoundPool;
  
  public void LK(String paramString)
  {
    if (this.cS != null)
    {
      Integer localInteger = (Integer)this.cS.get(paramString);
      if (localInteger != null)
      {
        aqge.m(BaseApplicationImpl.getContext(), false);
        this.mSoundPool.stop(localInteger.intValue());
        this.cS.remove(paramString);
      }
    }
  }
  
  public boolean h(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return false;
        aqge.m(BaseApplicationImpl.getContext(), true);
        if (this.mSoundPool == null) {
          this.mSoundPool = new SoundPool(1, paramInt2, 0);
        }
        if (this.cS == null) {
          this.cS = new HashMap();
        }
        if (this.cS.containsKey(paramString)) {
          break;
        }
      } while (!ne(paramString));
      if (Build.VERSION.SDK_INT >= 8) {
        this.mSoundPool.setOnLoadCompleteListener(new aiyn(this, paramInt1, paramString));
      }
      do
      {
        for (;;)
        {
          return true;
          paramInt1 = ((Integer)this.cS.get(paramString)).intValue();
          ThreadManager.getTimer().schedule(new SoundPoolUtil.2(this, paramInt1, paramString), 200L);
        }
        paramInt1 = ((Integer)this.cS.get(paramString)).intValue();
      } while (this.mSoundPool.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F) != 0);
    } while (!QLog.isColorLevel());
    QLog.d("SoundPoolUtil", 2, "play failure filepath=" + paramString);
    return false;
  }
  
  public boolean ne(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ((this.cS != null) && (this.cS.containsKey(paramString)))) {}
    int i;
    do
    {
      File localFile;
      do
      {
        return false;
        localFile = new File(paramString);
      } while (!localFile.exists());
      if (this.mSoundPool == null) {
        this.mSoundPool = new SoundPool(1, 3, 0);
      }
      if (this.cS == null) {
        this.cS = new HashMap();
      }
      if (Build.VERSION.SDK_INT >= 8) {
        this.mSoundPool.setOnLoadCompleteListener(null);
      }
      i = this.mSoundPool.load(localFile.getAbsolutePath(), 1);
      if (i != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SoundPoolUtil", 2, "load failure filepath=" + paramString);
    return false;
    this.cS.put(paramString, Integer.valueOf(i));
    return true;
  }
  
  public void release()
  {
    if (this.mSoundPool != null)
    {
      aqge.m(BaseApplicationImpl.getContext(), false);
      this.mSoundPool.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiym
 * JD-Core Version:    0.7.0.1
 */