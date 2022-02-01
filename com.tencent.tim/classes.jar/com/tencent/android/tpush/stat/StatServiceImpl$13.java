package com.tencent.android.tpush.stat;

import com.tencent.android.tpush.stat.b.c;

final class StatServiceImpl$13
  implements Runnable
{
  public void run()
  {
    try
    {
      StatServiceImpl.b();
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.d().b(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.StatServiceImpl.13
 * JD-Core Version:    0.7.0.1
 */