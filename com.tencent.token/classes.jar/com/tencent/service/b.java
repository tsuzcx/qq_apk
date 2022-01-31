package com.tencent.service;

import android.util.Log;
import com.tencent.halley.downloader.c;

class b
  implements c
{
  b(a parama) {}
  
  public void a(com.tencent.halley.downloader.b paramb)
  {
    Log.i("DownloadService", "onTaskPendingMainloop");
  }
  
  public void b(com.tencent.halley.downloader.b paramb)
  {
    Log.i("DownloadService", "onTaskStartedMainloop");
  }
  
  public void c(com.tencent.halley.downloader.b paramb)
  {
    Log.i("DownloadService", "onTaskDetectedMainloop");
  }
  
  public void d(com.tencent.halley.downloader.b paramb)
  {
    Log.i("DownloadService", "onTaskReceivedMainloop");
  }
  
  public void e(com.tencent.halley.downloader.b paramb)
  {
    Log.i("DownloadService", "onTaskPendingMainloop");
  }
  
  public void f(com.tencent.halley.downloader.b paramb)
  {
    Log.i("DownloadService", "onTaskFailedMainloop");
  }
  
  public void g(com.tencent.halley.downloader.b paramb)
  {
    Log.i("DownloadService", "onTaskCompletedMainloop");
  }
  
  public void h(com.tencent.halley.downloader.b paramb)
  {
    Log.i("DownloadService", "onTaskStartedSubloop");
  }
  
  public void i(com.tencent.halley.downloader.b paramb)
  {
    Log.i("DownloadService", "onTaskDetectedSubloop");
  }
  
  public void j(com.tencent.halley.downloader.b paramb)
  {
    if (paramb != null) {
      this.a.a(paramb);
    }
  }
  
  public void k(com.tencent.halley.downloader.b paramb)
  {
    if (paramb != null) {
      this.a.b(paramb);
    }
  }
  
  public void l(com.tencent.halley.downloader.b paramb)
  {
    if (paramb != null) {
      this.a.b(paramb);
    }
  }
  
  public void m(com.tencent.halley.downloader.b paramb)
  {
    if (paramb != null) {
      this.a.b(paramb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.b
 * JD-Core Version:    0.7.0.1
 */