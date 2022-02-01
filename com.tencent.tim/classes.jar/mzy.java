import java.util.ArrayList;
import java.util.Iterator;

final class mzy
  extends mzx
{
  private final int maxSize;
  private ArrayList<Long> samples;
  
  public mzy(int paramInt)
  {
    this.maxSize = paramInt;
    this.samples = new ArrayList();
  }
  
  public void onIdle()
  {
    super.onIdle();
    this.samples.clear();
  }
  
  public long onSample(long paramLong)
  {
    if (this.samples.size() >= this.maxSize) {
      this.samples.remove(0);
    }
    this.samples.add(Long.valueOf(paramLong));
    Iterator localIterator = this.samples.iterator();
    for (paramLong = 0L; localIterator.hasNext(); paramLong = ((Long)localIterator.next()).longValue() + paramLong) {}
    return paramLong / this.samples.size();
  }
  
  public void reset()
  {
    super.reset();
    this.samples.clear();
  }
  
  public String toString()
  {
    return "MoveAvgPredictor(" + this.maxSize + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mzy
 * JD-Core Version:    0.7.0.1
 */