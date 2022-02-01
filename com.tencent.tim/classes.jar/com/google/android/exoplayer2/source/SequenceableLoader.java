package com.google.android.exoplayer2.source;

public abstract interface SequenceableLoader
{
  public abstract boolean continueLoading(long paramLong);
  
  public abstract long getBufferedPositionUs();
  
  public abstract long getNextLoadPositionUs();
  
  public abstract void reevaluateBuffer(long paramLong);
  
  public static abstract interface Callback<T extends SequenceableLoader>
  {
    public abstract void onContinueLoadingRequested(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.SequenceableLoader
 * JD-Core Version:    0.7.0.1
 */