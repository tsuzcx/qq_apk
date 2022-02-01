package com.oasisfeng.condom.util;

import android.support.annotation.Keep;

@Keep
public abstract class Lazy<T>
{
  private T mInstance;
  
  protected abstract T create();
  
  public final T get()
  {
    try
    {
      Object localObject1;
      if (this.mInstance != null)
      {
        localObject1 = this.mInstance;
      }
      else
      {
        localObject1 = create();
        this.mInstance = localObject1;
      }
      return localObject1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.oasisfeng.condom.util.Lazy
 * JD-Core Version:    0.7.0.1
 */