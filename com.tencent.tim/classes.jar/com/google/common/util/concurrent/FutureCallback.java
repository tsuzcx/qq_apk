package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public abstract interface FutureCallback<V>
{
  public abstract void onFailure(Throwable paramThrowable);
  
  public abstract void onSuccess(@Nullable V paramV);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.FutureCallback
 * JD-Core Version:    0.7.0.1
 */