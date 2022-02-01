package com.tencent.ttpic.model;

import java.util.concurrent.CopyOnWriteArrayList;

public class Audio2Text
{
  public static final int MODE_FIFO = 2;
  public static final int MODE_LOOP_REPLACE = 1;
  public int segmentCount;
  public double segmentTime;
  public int sentenceCount;
  public int sentenceMode = 2;
  public double silenceTime;
  public String triggerWords;
  
  public static class FIFOList<T>
    extends CopyOnWriteArrayList<T>
  {
    private int mCapacity;
    
    public FIFOList(int paramInt)
    {
      this.mCapacity = paramInt;
    }
    
    public boolean add(T paramT)
    {
      if (size() >= this.mCapacity)
      {
        remove(0);
        return super.add(paramT);
      }
      return super.add(paramT);
    }
  }
  
  public static class LoopRepList<T>
    extends CopyOnWriteArrayList<T>
  {
    private int mCapacity;
    private int mCurrent;
    
    public LoopRepList(int paramInt)
    {
      this.mCapacity = paramInt;
      this.mCurrent = 0;
    }
    
    public boolean add(T paramT)
    {
      if (size() >= this.mCapacity)
      {
        if (this.mCurrent >= this.mCapacity) {
          this.mCurrent = 0;
        }
        int i = this.mCurrent;
        this.mCurrent = (i + 1);
        super.set(i, paramT);
        return true;
      }
      return super.add(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.model.Audio2Text
 * JD-Core Version:    0.7.0.1
 */