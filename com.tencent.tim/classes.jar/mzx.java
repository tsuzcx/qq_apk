import java.util.ArrayList;
import java.util.Iterator;

abstract class mzx
{
  private ArrayList<mzx> childPredictors = new ArrayList();
  protected long currentPredition;
  protected long prediction;
  
  protected void a(mzx parammzx)
  {
    if (this.childPredictors.indexOf(parammzx) < 0) {
      this.childPredictors.add(parammzx);
    }
  }
  
  public void onIdle()
  {
    Iterator localIterator = this.childPredictors.iterator();
    while (localIterator.hasNext()) {
      ((mzx)localIterator.next()).onIdle();
    }
    this.currentPredition = 0L;
  }
  
  abstract long onSample(long paramLong);
  
  public void reset()
  {
    Iterator localIterator = this.childPredictors.iterator();
    while (localIterator.hasNext()) {
      ((mzx)localIterator.next()).reset();
    }
    this.prediction = 0L;
  }
  
  public void sample(long paramLong)
  {
    Iterator localIterator = this.childPredictors.iterator();
    while (localIterator.hasNext()) {
      ((mzx)localIterator.next()).sample(paramLong);
    }
    this.currentPredition = onSample(paramLong);
    if (this.currentPredition < 0L) {
      this.currentPredition = 0L;
    }
    if ((float)Math.abs(this.currentPredition - this.prediction) / (float)this.prediction < 0.2F)
    {
      this.prediction = Math.max(this.currentPredition, this.prediction);
      return;
    }
    this.prediction = this.currentPredition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mzx
 * JD-Core Version:    0.7.0.1
 */