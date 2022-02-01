import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public abstract class ttg<K, A>
{
  @Nullable
  private tsl<K> a;
  private boolean isDiscrete;
  private final List<? extends tsl<K>> keyframes;
  final List<ttg.a> listeners = new ArrayList();
  private float progress;
  
  ttg(List<? extends tsl<K>> paramList)
  {
    this.keyframes = paramList;
  }
  
  private tsl<K> a()
  {
    int i = 0;
    if (this.keyframes.isEmpty()) {
      throw new IllegalStateException("There are no keyframes");
    }
    if ((this.a != null) && (this.a.containsProgress(this.progress))) {
      return this.a;
    }
    tsl localtsl2 = (tsl)this.keyframes.get(0);
    tsl localtsl1 = localtsl2;
    if (this.progress < localtsl2.getStartProgress())
    {
      this.a = localtsl2;
      return localtsl2;
    }
    while ((!localtsl1.containsProgress(this.progress)) && (i < this.keyframes.size()))
    {
      localtsl1 = (tsl)this.keyframes.get(i);
      i += 1;
    }
    this.a = localtsl1;
    return localtsl1;
  }
  
  private float aF()
  {
    if (this.isDiscrete) {}
    tsl localtsl;
    do
    {
      return 0.0F;
      localtsl = a();
    } while (localtsl.isStatic());
    float f1 = this.progress;
    float f2 = localtsl.getStartProgress();
    float f3 = localtsl.getEndProgress();
    float f4 = localtsl.getStartProgress();
    return localtsl.interpolator.getInterpolation((f1 - f2) / (f3 - f4));
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  private float getEndProgress()
  {
    if (this.keyframes.isEmpty()) {
      return 1.0F;
    }
    return ((tsl)this.keyframes.get(this.keyframes.size() - 1)).getEndProgress();
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  private float getStartDelayProgress()
  {
    if (this.keyframes.isEmpty()) {
      return 0.0F;
    }
    return ((tsl)this.keyframes.get(0)).getStartProgress();
  }
  
  abstract A a(tsl<K> paramtsl, float paramFloat);
  
  public void b(ttg.a parama)
  {
    this.listeners.add(parama);
  }
  
  public float getProgress()
  {
    return this.progress;
  }
  
  public A getValue()
  {
    return a(a(), aF());
  }
  
  public void setIsDiscrete()
  {
    this.isDiscrete = true;
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    float f;
    if (paramFloat < getStartDelayProgress())
    {
      f = 0.0F;
      if (f != this.progress) {
        break label37;
      }
    }
    for (;;)
    {
      return;
      f = paramFloat;
      if (paramFloat <= getEndProgress()) {
        break;
      }
      f = 1.0F;
      break;
      label37:
      this.progress = f;
      int i = 0;
      while (i < this.listeners.size())
      {
        ((ttg.a)this.listeners.get(i)).onValueChanged();
        i += 1;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onValueChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ttg
 * JD-Core Version:    0.7.0.1
 */