package com.tencent.service.update;

import android.util.Log;
import com.tencent.service.a;
import com.tencent.service.d;
import java.util.ArrayList;
import java.util.List;

public class b
{
  protected static boolean a = true;
  protected List b = new ArrayList();
  d c;
  
  b(String paramString)
  {
    this.b.add(paramString);
  }
  
  public d a()
  {
    if (this.c == null) {
      this.c = k.a().b(false);
    }
    return this.c;
  }
  
  public d a(String paramString1, String paramString2)
  {
    d locald = a.a().a(paramString1);
    if (locald != null) {
      return locald;
    }
    locald = new d();
    locald.a = "com.tencent.token";
    locald.c = paramString1;
    locald.d = paramString2;
    return locald;
  }
  
  public void a(d paramd)
  {
    if (a) {
      Log.d("DownloadController", "invoke deleteDownloadTask");
    }
    if (paramd == null) {
      Log.e("DownloadController", "error when deleteDownloadTask, task is null!");
    }
  }
  
  public void b()
  {
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.b
 * JD-Core Version:    0.7.0.1
 */