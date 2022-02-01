package com.tencent.webbundle.sdk;

public abstract interface IStateHolder<T>
{
  public abstract T getPreloadState();
  
  public abstract void setPreloadState(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.webbundle.sdk.IStateHolder
 * JD-Core Version:    0.7.0.1
 */