package com.tencent.token;

final class mr
  implements Runnable
{
  public final void run()
  {
    try
    {
      lx.a();
      lz.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.mr
 * JD-Core Version:    0.7.0.1
 */