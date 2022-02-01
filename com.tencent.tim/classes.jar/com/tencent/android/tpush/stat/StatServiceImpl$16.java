package com.tencent.android.tpush.stat;

import com.tencent.android.tpush.stat.event.Event;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

final class StatServiceImpl$16
  implements e
{
  StatServiceImpl$16(Event paramEvent) {}
  
  public void a()
  {
    StatServiceImpl.e().set(0);
  }
  
  public void b()
  {
    if (StatServiceImpl.e().getAndIncrement() < StatServiceImpl.f().intValue())
    {
      CommonWorkingThread.getInstance().execute(new StatServiceImpl.16.1(this), StatServiceImpl.e().get() * 1000L);
      return;
    }
    StatServiceImpl.e().set(0);
    StatServiceImpl.b(Arrays.asList(new Event[] { this.a }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.StatServiceImpl.16
 * JD-Core Version:    0.7.0.1
 */