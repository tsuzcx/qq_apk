package com.tencent.android.tpush.stat;

import com.tencent.android.tpush.stat.b.c;
import com.tencent.android.tpush.stat.event.Event;

final class StatServiceImpl$10
  implements Runnable
{
  StatServiceImpl$10(Event paramEvent) {}
  
  public void run()
  {
    try
    {
      StatServiceImpl.a(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.d().b(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.StatServiceImpl.10
 * JD-Core Version:    0.7.0.1
 */