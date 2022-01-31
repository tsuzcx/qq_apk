package com.tencent.token.ui;

import android.os.Handler;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.gb;
import com.tencent.token.utils.i;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

final class md
  implements Runnable
{
  md(mb parammb, Handler paramHandler) {}
  
  public final void run()
  {
    boolean bool1 = false;
    com.tencent.token.global.e.a("now check log upload");
    File localFile = new File(gb.b(), "upload.file");
    int i;
    String str;
    if (localFile.exists())
    {
      gb.a();
      i = gb.g();
      if (i > 0)
      {
        str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(i * 1000L)) + "_android.zip";
        af.a().a(this.a, localFile, str);
      }
    }
    for (;;)
    {
      return;
      if (i < 0)
      {
        com.tencent.token.global.e.a("upload log fail date=" + i);
        return;
      }
      str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(ag.c().r())) + "_android.zip";
      break;
      gb.a();
      i = gb.g();
      if (i > 0)
      {
        str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(i * 1000L)) + "_android.zip";
        localObject = gb.a.a(i * 1000L);
        if ((localObject == null) || (!((File)localObject).isDirectory())) {
          throw new NullPointerException();
        }
        gb.a();
        localObject = gb.a.b((File)localObject);
        localObject = gb.a.a((File[])localObject);
        try
        {
          boolean bool2 = localFile.createNewFile();
          bool1 = bool2;
        }
        catch (IOException localIOException1)
        {
          for (;;)
          {
            com.tencent.token.global.e.a("create uploadFile failed");
          }
        }
        if ((!bool1) || (!i.a((File[])localObject, localFile))) {
          continue;
        }
        af.a().a(IndexActivity.access$300(this.b.a), localFile, str);
        return;
      }
      if (i < 0)
      {
        com.tencent.token.global.e.a("upload log fail date=" + i);
        return;
      }
      str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(ag.c().r())) + "_android.zip";
      Object localObject = gb.a.a();
      try
      {
        bool1 = localFile.createNewFile();
        if (!bool1) {
          continue;
        }
        if (!i.a(new File[] { localObject }, localFile)) {
          continue;
        }
        af.a().a(IndexActivity.access$300(this.b.a), localFile, str);
        return;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          com.tencent.token.global.e.a("create uploadFile failed");
          bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.md
 * JD-Core Version:    0.7.0.1
 */