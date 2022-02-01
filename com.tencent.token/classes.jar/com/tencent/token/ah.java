package com.tencent.token;

import java.util.concurrent.Future;

public class ah
{
  private Future a;
  
  public ah(Future paramFuture)
  {
    this.a = paramFuture;
  }
  
  public boolean a()
  {
    Future localFuture = this.a;
    if (localFuture != null) {
      try
      {
        boolean bool = localFuture.cancel(false);
        return bool;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ah
 * JD-Core Version:    0.7.0.1
 */