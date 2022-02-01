package com.tencent.stat;

import com.tencent.stat.common.StatLogger;
import com.tencent.stat.event.c;
import java.util.Map;

final class l
  implements Runnable
{
  l(String paramString, c paramc) {}
  
  public void run()
  {
    try
    {
      if (StatServiceImpl.a(this.a))
      {
        StatServiceImpl.f().error("The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
        return;
      }
      if (StatConfig.isDebugEnable()) {
        StatServiceImpl.f().i("add begin key:" + this.b.toString());
      }
      if (StatServiceImpl.j().containsKey(this.b))
      {
        StatServiceImpl.f().error("Duplicate CustomEvent key: " + this.b.toString() + ", trackCustomBeginEvent() repeated?");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
      return;
    }
    if (StatServiceImpl.j().size() <= StatConfig.getMaxParallelTimmingEvents())
    {
      StatServiceImpl.j().put(this.b, Long.valueOf(System.currentTimeMillis()));
      return;
    }
    StatServiceImpl.f().error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.stat.l
 * JD-Core Version:    0.7.0.1
 */