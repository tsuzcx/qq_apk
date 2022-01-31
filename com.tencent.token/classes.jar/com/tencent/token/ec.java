package com.tencent.token;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import okhttp3.at;
import okhttp3.av;
import okhttp3.g;
import okhttp3.h;

class ec
  implements h
{
  ec(ea paramea, long paramLong1, RandomAccessFile paramRandomAccessFile, File paramFile, int paramInt, long paramLong2) {}
  
  public void a(g paramg, IOException paramIOException)
  {
    ea.a(this.f, false);
  }
  
  public void a(g paramg, at paramat)
  {
    if (paramat.b() != 206)
    {
      ea.a(this.f);
      return;
    }
    paramg = paramat.e().b();
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(ea.c(this.f), "rw");
    localRandomAccessFile.seek(this.a);
    byte[] arrayOfByte = new byte[4096];
    int i = 0;
    for (;;)
    {
      int j = paramg.read(arrayOfByte);
      if (j <= 0) {
        break;
      }
      if (ea.e(this.f))
      {
        ea.a(this.f, new Closeable[] { this.b, paramg, paramat.e() });
        ea.a(this.f, new File[] { this.c });
        this.f.sendEmptyMessage(4);
        return;
      }
      if (ea.f(this.f))
      {
        ea.a(this.f, new Closeable[] { this.b, paramg, paramat.e() });
        this.f.sendEmptyMessage(3);
        return;
      }
      localRandomAccessFile.write(arrayOfByte, 0, j);
      i += j;
      long l = this.a + i;
      this.b.seek(0L);
      this.b.write((l + "").getBytes("UTF-8"));
      ea.g(this.f)[this.d] = (l - this.e);
      this.f.sendEmptyMessage(1);
    }
    ea.a(this.f, new Closeable[] { this.b, paramg, paramat.e() });
    ea.a(this.f, new File[] { this.c });
    this.f.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ec
 * JD-Core Version:    0.7.0.1
 */