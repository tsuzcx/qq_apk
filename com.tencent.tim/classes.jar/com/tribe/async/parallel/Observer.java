package com.tribe.async.parallel;

import android.support.annotation.NonNull;

public abstract interface Observer
{
  public abstract void addObserverFunction(Integer paramInteger);
  
  public abstract void onAllFunctionComplete(boolean paramBoolean);
  
  public abstract void onOneFunctionErr(Integer paramInteger, @NonNull Error paramError);
  
  public abstract void onOneFunctionSuc(Integer paramInteger, Object paramObject);
  
  public abstract void onStreamCancel();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tribe.async.parallel.Observer
 * JD-Core Version:    0.7.0.1
 */