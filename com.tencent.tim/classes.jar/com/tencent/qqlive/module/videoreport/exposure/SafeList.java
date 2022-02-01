package com.tencent.qqlive.module.videoreport.exposure;

import java.util.ArrayList;

abstract class SafeList<T>
  extends ArrayList<T>
{
  SafeList(int paramInt)
  {
    super(paramInt);
  }
  
  private void ensureElement(int paramInt)
  {
    while (size() < paramInt) {
      add(initValue());
    }
  }
  
  public T get(int paramInt)
  {
    ensureElement(paramInt + 1);
    return super.get(paramInt);
  }
  
  abstract T initValue();
  
  public T set(int paramInt, T paramT)
  {
    ensureElement(paramInt + 1);
    return super.set(paramInt, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.exposure.SafeList
 * JD-Core Version:    0.7.0.1
 */