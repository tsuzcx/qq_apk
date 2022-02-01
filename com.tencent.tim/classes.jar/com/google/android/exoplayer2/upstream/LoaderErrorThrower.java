package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public abstract interface LoaderErrorThrower
{
  public abstract void maybeThrowError()
    throws IOException;
  
  public abstract void maybeThrowError(int paramInt)
    throws IOException;
  
  public static final class Dummy
    implements LoaderErrorThrower
  {
    public void maybeThrowError()
      throws IOException
    {}
    
    public void maybeThrowError(int paramInt)
      throws IOException
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.LoaderErrorThrower
 * JD-Core Version:    0.7.0.1
 */