package com.tencent.token;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.at;
import okhttp3.av;
import okhttp3.g;
import okhttp3.h;

class eb
  implements h
{
  eb(ea paramea) {}
  
  public void a(g paramg, IOException paramIOException)
  {
    ea.a(this.a);
  }
  
  public void a(g paramg, at paramat)
  {
    int i = 0;
    if (paramat.b() != 200)
    {
      ea.a(this.a, new Closeable[] { paramat.e() });
      ea.a(this.a);
    }
    for (;;)
    {
      return;
      ea.a(this.a, paramat.e().a());
      ea.a(this.a, new Closeable[] { paramat.e() });
      ea.a(this.a, new File(ea.b(this.a).c(), ea.b(this.a).a() + ".tmp"));
      if (!ea.c(this.a).getParentFile().exists()) {
        ea.c(this.a).getParentFile().mkdirs();
      }
      new RandomAccessFile(ea.c(this.a), "rw").setLength(ea.d(this.a));
      long l2 = ea.d(this.a) / 4L;
      while (i < 4)
      {
        long l3 = i;
        long l1 = (i + 1) * l2 - 1L;
        if (i == 3) {
          l1 = ea.d(this.a) - 1L;
        }
        ea.a(this.a, l3 * l2, l1, i);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.eb
 * JD-Core Version:    0.7.0.1
 */