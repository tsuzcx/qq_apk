import android.media.SoundPool;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class irx
{
  HashSet<Integer> E;
  SoundPool a;
  int asT;
  int asU;
  HashMap<String, Integer> cH;
  HashMap<String, Integer> cI;
  List<String> ft;
  int streamType;
  
  public irx(List<String> paramList, int paramInt)
  {
    this.ft = paramList;
    this.cH = new HashMap();
    this.cI = new HashMap();
    this.E = new HashSet();
    this.asT = paramList.size();
    this.streamType = paramInt;
  }
  
  public void Z(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoundPoolHelper", 2, "playMusic, path = " + paramString + ",loop = " + paramBoolean);
    }
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("SoundPoolHelper", 2, "playMusic fail path is empty ");
      }
    }
    Integer localInteger;
    do
    {
      do
      {
        do
        {
          return;
          localInteger = (Integer)this.cH.get(paramString);
          if (localInteger != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("SoundPoolHelper", 2, "playMusic fail soundID is null, path = " + paramString + ",loop = " + paramBoolean);
        return;
        if (this.E.contains(localInteger)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SoundPoolHelper", 2, "playMusic fail soundID is not ready, path = " + paramString + ",loop = " + paramBoolean);
      return;
    } while (this.a == null);
    SoundPool localSoundPool = this.a;
    int j = localInteger.intValue();
    if (paramBoolean) {}
    for (int i = -1;; i = 0)
    {
      i = localSoundPool.play(j, 1.0F, 1.0F, 1, i, 1.0F);
      this.cI.put(paramString, Integer.valueOf(i));
      return;
    }
  }
  
  public void aqi()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoundPoolHelper", 2, "releaseMusic");
    }
    if (this.a != null)
    {
      this.a.release();
      this.a = null;
      this.cH.clear();
      this.E.clear();
      this.cI.clear();
      this.asU = 0;
    }
  }
  
  public void b(irx.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoundPoolHelper", 2, "loadMusic ,soundPool = " + this.a);
    }
    if ((this.ft == null) || (this.ft.size() < 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("SoundPoolHelper", 2, "loadMusic fail filPathList is empty");
      }
    }
    for (;;)
    {
      return;
      if (this.a == null)
      {
        this.a = new SoundPool(this.ft.size(), this.streamType, 0);
        this.a.setOnLoadCompleteListener(new iry(this, parama));
      }
      parama = this.ft.iterator();
      while (parama.hasNext())
      {
        String str = (String)parama.next();
        int i = this.a.load(str, 1);
        this.cH.put(str, Integer.valueOf(i));
      }
    }
  }
  
  public void jx(String paramString)
  {
    Integer localInteger = (Integer)this.cH.get(paramString);
    if (localInteger == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SoundPoolHelper", 2, "stopMusic fail soundID is null, path = " + paramString);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (this.E.contains(localInteger)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("SoundPoolHelper", 2, "stopMusic fail soundID is not ready, path = " + paramString);
        return;
        localInteger = (Integer)this.cI.get(paramString);
        if (localInteger != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SoundPoolHelper", 2, "stopMusic fail steamID is null, path = " + paramString);
      return;
    } while (this.a == null);
    this.a.stop(localInteger.intValue());
  }
  
  public static abstract interface a
  {
    public abstract void onLoadFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     irx
 * JD-Core Version:    0.7.0.1
 */