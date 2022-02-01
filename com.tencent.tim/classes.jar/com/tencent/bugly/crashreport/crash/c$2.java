package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class c$2
  extends Thread
{
  c$2(c paramc) {}
  
  public final void run()
  {
    if (!z.a(c.b(this.a), "local_crash_lock", 10000L))
    {
      x.c("Failed to lock file for uploading local crash.", new Object[0]);
      return;
    }
    List localList = this.a.p.a();
    if ((localList != null) && (localList.size() > 0))
    {
      x.c("Size of crash list: %s", new Object[] { Integer.valueOf(localList.size()) });
      int j = localList.size();
      if (j > 20L)
      {
        ArrayList localArrayList = new ArrayList();
        Collections.sort(localList);
        int i = 0;
        for (;;)
        {
          localObject = localArrayList;
          if (i >= 20L) {
            break;
          }
          localArrayList.add(localList.get(j - 1 - i));
          i += 1;
        }
      }
      Object localObject = localList;
      this.a.p.a((List)localObject, 0L, false, false, false);
    }
    for (;;)
    {
      z.b(c.b(this.a), "local_crash_lock");
      return;
      x.c("no crash need to be uploaded at this start", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.c.2
 * JD-Core Version:    0.7.0.1
 */