package com.tencent.service.update;

import android.util.Log;
import com.tencent.service.a;
import com.tencent.service.a.a;
import java.util.ArrayList;
import java.util.List;

public class b
{
  protected static boolean a = true;
  protected List<String> b = new ArrayList();
  a.a c;
  
  b(String paramString)
  {
    this.b.add(paramString);
  }
  
  public a.a a()
  {
    if (this.c == null) {
      this.c = f.a().b(false);
    }
    return this.c;
  }
  
  public a.a a(String paramString1, String paramString2)
  {
    a.a locala = a.a().a(paramString1);
    if (locala != null) {
      return locala;
    }
    locala = new a.a();
    locala.a = "com.tencent.token";
    locala.c = paramString1;
    locala.d = paramString2;
    return locala;
  }
  
  public void a(a.a parama)
  {
    if (a) {
      Log.d("DownloadController", "invoke deleteDownloadTask");
    }
    if (parama == null) {
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