package com.tribe.async.async;

import android.support.annotation.NonNull;

public abstract class SimpleJob<Result>
  extends Job<Void, Void, Result>
{
  public SimpleJob()
  {
    this("SimpleJob");
  }
  
  public SimpleJob(@NonNull String paramString)
  {
    super(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tribe.async.async.SimpleJob
 * JD-Core Version:    0.7.0.1
 */