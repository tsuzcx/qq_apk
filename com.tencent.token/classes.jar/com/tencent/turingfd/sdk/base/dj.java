package com.tencent.turingfd.sdk.base;

public abstract class dj
{
  public volatile Object a;
  
  public abstract Object a();
  
  public final Object b()
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      try
      {
        Object localObject3 = this.a;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = a();
          this.a = localObject1;
        }
        return localObject1;
      }
      finally {}
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.dj
 * JD-Core Version:    0.7.0.1
 */