package com.tencent.token;

import com.tencent.halley.downloader.d.a.a;
import com.tencent.halley.downloader.d.a.b;
import com.tencent.halley.downloader.d.a.d;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public final class ak
  implements an
{
  private static ak e = null;
  private b a;
  private b b;
  private com.tencent.halley.downloader.d.a.h c;
  private com.tencent.halley.downloader.d.a.h d;
  
  private ak()
  {
    Object localObject = new a(64);
    this.a = new b(h.a(), h.a(), 60L, TimeUnit.MILLISECONDS, (BlockingQueue)localObject, new al("HallyDownload-MassTaskPool"));
    ((a)localObject).a(this.a);
    localObject = new a(64);
    this.b = new b(1, h.b(), 60L, TimeUnit.MILLISECONDS, (BlockingQueue)localObject, new al("HallyDownload-EaseTaskPool"));
    ((a)localObject).a(this.b);
    localObject = new d(16);
    this.c = new com.tencent.halley.downloader.d.a.h(1, h.a() + h.b() + 1, 60L, TimeUnit.MILLISECONDS, (BlockingQueue)localObject, new al("HallyDownload-DirectPool"));
    ((d)localObject).a(this.c);
    localObject = new d(16);
    this.d = new com.tencent.halley.downloader.d.a.h(1, (h.a() << 1) + 1, 60L, TimeUnit.MILLISECONDS, (BlockingQueue)localObject, new al("HallyDownload-SchedulePool"));
    ((d)localObject).a(this.d);
  }
  
  public static ak a()
  {
    try
    {
      if (e == null) {
        e = new ak();
      }
      ak localak = e;
      return localak;
    }
    finally {}
  }
  
  public final am a(Runnable paramRunnable)
  {
    return new am(this.a.submit(paramRunnable));
  }
  
  public final am b(Runnable paramRunnable)
  {
    return new am(this.b.submit(paramRunnable));
  }
  
  public final am c(Runnable paramRunnable)
  {
    return new am(this.c.submit(paramRunnable));
  }
  
  public final am d(Runnable paramRunnable)
  {
    return new am(this.d.submit(paramRunnable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ak
 * JD-Core Version:    0.7.0.1
 */