import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class mzv
  extends mzx
{
  private mzy a;
  private int currentWeight;
  private int maxWeight;
  private final ArrayList<Long> samples;
  private final float weightFactor;
  
  public mzv(float paramFloat)
  {
    this.weightFactor = paramFloat;
    this.samples = new ArrayList();
    this.maxWeight = 500;
    this.a = new mzy((int)paramFloat);
    a(this.a);
  }
  
  private void resetMaxWeight()
  {
    int i = (int)(Math.sqrt(this.a.prediction) * this.weightFactor);
    if (i > 0) {
      this.maxWeight = i;
    }
  }
  
  public void onIdle()
  {
    resetMaxWeight();
    super.onIdle();
  }
  
  public long onSample(long paramLong)
  {
    long l2 = 0L;
    double d = Math.sqrt(paramLong);
    long l1;
    while ((this.currentWeight + d > this.maxWeight) && (this.samples.size() > 0))
    {
      l1 = ((Long)this.samples.remove(0)).longValue();
      this.currentWeight = ((int)(this.currentWeight - Math.sqrt(l1)));
    }
    this.samples.add(Long.valueOf(paramLong));
    this.currentWeight = ((int)(this.currentWeight + d));
    int i = this.maxWeight / 2;
    Object localObject = (List)this.samples.clone();
    Collections.sort((List)localObject);
    Long localLong;
    if (this.currentWeight > i)
    {
      localObject = ((List)localObject).iterator();
      l1 = 0L;
      do
      {
        paramLong = l2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localLong = (Long)((Iterator)localObject).next();
        paramLong = (l1 + Math.sqrt(localLong.longValue()));
        l1 = paramLong;
      } while (paramLong <= i);
    }
    for (paramLong = localLong.longValue();; paramLong = ((Long)((List)localObject).get(((List)localObject).size() - 1)).longValue())
    {
      if (this.samples.size() >= this.weightFactor) {
        resetMaxWeight();
      }
      return paramLong;
    }
  }
  
  public void reset()
  {
    super.reset();
    this.samples.clear();
    this.currentWeight = 0;
  }
  
  public String toString()
  {
    return "ExoPredictor(" + this.maxWeight + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mzv
 * JD-Core Version:    0.7.0.1
 */