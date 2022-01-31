package com.tencent.token.ui;

import android.os.Handler;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.fe;
import com.tencent.token.global.h;
import com.tencent.token.utils.e;
import com.tencent.token.utils.i;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

class ls
  implements Runnable
{
  ls(lp paramlp, Handler paramHandler) {}
  
  public void run()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    h.a("now check log upload");
    File localFile = new File(fe.b(), "upload.file");
    int i;
    String str;
    if (localFile.exists())
    {
      i = fe.a().j();
      if (i > 0)
      {
        str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(i * 1000L)) + "_android.zip";
        cw.a().a(this.a, localFile, str);
      }
    }
    for (;;)
    {
      return;
      if (i < 0)
      {
        h.a("upload log fail date=" + i);
        return;
      }
      str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(cx.c().s())) + "_android.zip";
      break;
      i = fe.a().j();
      if (i > 0)
      {
        str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(i * 1000L)) + "_android.zip";
        localObject = fe.a.a(i * 1000L);
        if ((localObject == null) || (!((File)localObject).isDirectory())) {
          throw new NullPointerException();
        }
        fe.a();
        localObject = fe.a.b((File)localObject);
        localObject = fe.a.a((File[])localObject);
        try
        {
          bool2 = localFile.createNewFile();
          bool1 = bool2;
        }
        catch (IOException localIOException1)
        {
          for (;;)
          {
            h.a("create uploadFile failed");
          }
        }
        if ((!bool1) || (!i.a((File[])localObject, localFile))) {
          continue;
        }
        cw.a().a(IndexActivity.access$100(this.b.a), localFile, str);
        return;
      }
      if (i < 0)
      {
        h.a("upload log fail date=" + i);
        return;
      }
      str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(cx.c().s())) + "_android.zip";
      Object localObject = fe.a.a();
      try
      {
        bool1 = localFile.createNewFile();
        if ((!bool1) || (!i.a((File)localObject, localFile))) {
          continue;
        }
        cw.a().a(IndexActivity.access$100(this.b.a), localFile, str);
        return;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          h.a("create uploadFile failed");
          bool1 = bool2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ls
 * JD-Core Version:    0.7.0.1
 */