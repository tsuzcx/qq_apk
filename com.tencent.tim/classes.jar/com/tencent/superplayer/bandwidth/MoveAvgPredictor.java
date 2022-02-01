package com.tencent.superplayer.bandwidth;

import java.util.ArrayList;
import java.util.Iterator;

public class MoveAvgPredictor
  extends AbstractPredictor
{
  private final int maxSize;
  private final ArrayList<Long> samples;
  
  public MoveAvgPredictor(int paramInt)
  {
    this.maxSize = paramInt;
    this.samples = new ArrayList();
  }
  
  public final int getSampleSize()
  {
    return this.samples.size();
  }
  
  public void onIdle()
  {
    super.onIdle();
    this.samples.clear();
  }
  
  public long onSample(long paramLong)
  {
    if ((this.samples.size() >= this.maxSize) && (this.samples.size() > 0)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.MoveAvgPredictor
 * JD-Core Version:    0.7.0.1
 */