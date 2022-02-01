import android.os.SystemClock;
import android.util.SparseArray;
import android.view.animation.AccelerateInterpolator;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class axxj
{
  public static final AccelerateInterpolator b = new AccelerateInterpolator();
  public static final SparseArray<ConcurrentHashMap<String, axxj>> ej;
  public static final ConcurrentHashMap<String, axxj> kn = new ConcurrentHashMap();
  float Fq = 1.0F;
  long aCx = 0L;
  long aCy = 0L;
  public byte bJ = 1;
  public ArrayList<WeakReference<axxj.a>> mObservers = new ArrayList();
  long mStartTime;
  
  static
  {
    ej = new SparseArray(3);
  }
  
  static axxj a(int paramInt, String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)ej.get(paramInt);
    if (localConcurrentHashMap == null)
    {
      localConcurrentHashMap = new ConcurrentHashMap(50);
      ej.put(paramInt, localConcurrentHashMap);
    }
    for (;;)
    {
      axxj localaxxj2 = (axxj)localConcurrentHashMap.get(paramString);
      axxj localaxxj1 = localaxxj2;
      if (localaxxj2 == null)
      {
        localaxxj1 = new axxj();
        localConcurrentHashMap.put(paramString, localaxxj1);
      }
      return localaxxj1;
    }
  }
  
  public static axxj a(Object paramObject)
  {
    axxj localaxxj = null;
    if ((paramObject instanceof axqc)) {
      localaxxj = a(1, ((axqc)paramObject).getUniqueKey());
    }
    do
    {
      return localaxxj;
      if ((paramObject instanceof PtvTemplateManager.PtvTemplateInfo)) {
        return a(3, ((PtvTemplateManager.PtvTemplateInfo)paramObject).id);
      }
      if ((paramObject instanceof axbu)) {
        return a(3, ((axbu)paramObject).id);
      }
      if ((paramObject instanceof MusicItemInfo)) {
        return a(2, ((MusicItemInfo)paramObject).mMusicName);
      }
      if ((paramObject instanceof axqf)) {
        return a(4, ((axqf)paramObject).getUniqueKey());
      }
    } while (!(paramObject instanceof axqm));
    return a(5, ((axqm)paramObject).getUniqueKey());
  }
  
  public void a(axxj.a parama)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      axxj.a locala = (axxj.a)((WeakReference)this.mObservers.get(i)).get();
      if ((locala == null) || (locala == parama)) {
        this.mObservers.remove(i);
      }
      i -= 1;
    }
  }
  
  public void b(axxj.a parama)
  {
    this.mObservers.add(new WeakReference(parama));
  }
  
  public void by(float paramFloat)
  {
    int i = this.mObservers.size() - 1;
    if (i >= 0)
    {
      axxj.a locala = (axxj.a)((WeakReference)this.mObservers.get(i)).get();
      if (locala == null) {
        this.mObservers.remove(i);
      }
      for (;;)
      {
        i -= 1;
        break;
        locala.onUpdate();
      }
    }
  }
  
  public void ePh()
  {
    this.bJ = 1;
  }
  
  public void ePi()
  {
    this.bJ = 3;
  }
  
  public float getProgress()
  {
    float f1 = 0.01F;
    switch (this.bJ)
    {
    }
    for (;;)
    {
      return this.Fq;
      if (this.mStartTime == 0L) {
        return 0.0F;
      }
      long l = SystemClock.elapsedRealtime() - this.mStartTime;
      if ((float)l > 4250.0F) {
        f1 = 0.85F;
      }
      float f2;
      for (;;)
      {
        this.Fq = f1;
        break;
        f2 = (float)l * 1.0F / 5000.0F;
        if (f2 >= 0.01F) {
          f1 = f2;
        }
      }
      if (this.aCx == 0L)
      {
        this.aCx = SystemClock.elapsedRealtime();
      }
      else
      {
        l = SystemClock.elapsedRealtime() - this.aCx;
        if (l > 1L)
        {
          this.Fq = 1.0F;
        }
        else
        {
          f1 = this.Fq;
          f2 = this.Fq;
          this.Fq = (b.getInterpolation((float)l * 1.0F / 1.0F) * (1.0F - f2) + f1);
          continue;
          if (this.aCy == 0L)
          {
            this.aCy = SystemClock.elapsedRealtime();
          }
          else
          {
            l = SystemClock.elapsedRealtime() - this.aCy;
            if (l > 1L) {
              this.Fq = 0.0F;
            }
            this.Fq *= (1.0F - (float)l * 1.0F / 1.0F);
          }
        }
      }
    }
  }
  
  public void start()
  {
    if ((this.Fq == 0.0F) || (this.Fq == 1.0F))
    {
      this.bJ = 2;
      this.mStartTime = SystemClock.elapsedRealtime();
      this.aCx = 0L;
      this.aCy = 0L;
      this.Fq = 0.01F;
      by(0.01F);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onUpdate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axxj
 * JD-Core Version:    0.7.0.1
 */