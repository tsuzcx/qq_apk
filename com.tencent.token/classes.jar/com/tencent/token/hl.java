package com.tencent.token;

public class hl<T>
{
  public final T d;
  
  hl(T paramT)
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
 * Qualified Name:     com.tencent.token.hl
 * JD-Core Version:    0.7.0.1
 */