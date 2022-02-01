package com.tencent.token;

public class hh<T>
{
  public final T d;
  
  hh(T paramT)
  {
    if (paramT != null)
    {
      this.d = paramT;
      return;
    }
    throw new IllegalArgumentException("Wrapped Object can not be null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hh
 * JD-Core Version:    0.7.0.1
 */