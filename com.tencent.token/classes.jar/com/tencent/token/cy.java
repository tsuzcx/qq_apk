package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.aa;
import okhttp3.e;
import okhttp3.f;
import okhttp3.z;

public class cy
  extends Handler
{
  private final int a = 4;
  private cz b;
  private long c;
  private volatile boolean d = false;
  private AtomicInteger e = new AtomicInteger(0);
  private AtomicInteger f = new AtomicInteger(0);
  private AtomicInteger g = new AtomicInteger(0);
  private da h;
  private long[] i;
  private File[] j;
  private File k;
  private volatile boolean l;
  private volatile boolean m;
  private cw n;
  
  public cy(cz paramcz, cw paramcw)
  {
    this.b = paramcz;
    this.n = paramcw;
    this.i = new long[4];
    this.j = new File[4];
    this.h = da.a();
  }
  
  private void a(final long paramLong1, long paramLong2, final int paramInt)
  {
    final File localFile = new File(this.b.c(), "thread" + paramInt + "_" + this.b.a() + ".cache");
    this.j[paramInt] = localFile;
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "rwd");
    String str;
    if (localFile.exists())
    {
      str = localRandomAccessFile.readLine();
      if (str == null) {}
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(str))
        {
          if (this.n == null) {
            break label188;
          }
          this.n.b();
          l1 = paramLong1;
          this.h.a(this.b.b(), l1, paramLong2, new f()
          {
            public void a(e paramAnonymouse, IOException paramAnonymousIOException)
            {
              cy.a(cy.this, false);
            }
            
            public void a(e paramAnonymouse, z paramAnonymousz)
            {
              if (paramAnonymousz.b() != 206)
              {
                cy.a(cy.this);
                return;
              }
              paramAnonymouse = paramAnonymousz.e().b();
              RandomAccessFile localRandomAccessFile = new RandomAccessFile(cy.c(cy.this), "rw");
              localRandomAccessFile.seek(l1);
              byte[] arrayOfByte = new byte[4096];
              int i = 0;
              for (;;)
              {
                int j = paramAnonymouse.read(arrayOfByte);
                if (j <= 0) {
                  break;
                }
                if (cy.e(cy.this))
                {
                  cy.a(cy.this, new Closeable[] { localFile, paramAnonymouse, paramAnonymousz.e() });
                  cy.a(cy.this, new File[] { paramInt });
                  cy.this.sendEmptyMessage(4);
                  return;
                }
                if (cy.f(cy.this))
                {
                  cy.a(cy.this, new Closeable[] { localFile, paramAnonymouse, paramAnonymousz.e() });
                  cy.this.sendEmptyMessage(3);
                  return;
                }
                localRandomAccessFile.write(arrayOfByte, 0, j);
                i += j;
                long l = l1 + i;
                localFile.seek(0L);
                localFile.write((l + "").getBytes("UTF-8"));
                cy.g(cy.this)[paramLong1] = (l - this.e);
                cy.this.sendEmptyMessage(1);
              }
              cy.a(cy.this, new Closeable[] { localFile, paramAnonymouse, paramAnonymousz.e() });
              cy.a(cy.this, new File[] { paramInt });
              cy.this.sendEmptyMessage(2);
            }
          });
          return;
        }
        int i1 = Integer.parseInt(str);
        l1 = i1;
        continue;
        l1 = paramLong1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
      continue;
      label188:
      final long l1 = paramLong1;
    }
  }
  
  private void a(Closeable... paramVarArgs)
  {
    i4 = 0;
    i5 = 0;
    int i3 = 0;
    i6 = paramVarArgs.length;
    i1 = 0;
    int i2 = i3;
    if ((i1 >= i6) || (paramVarArgs[i1] != null)) {}
    for (;;)
    {
      try
      {
        paramVarArgs[i1].close();
        i1 += 1;
        break;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        i1 = i4;
        if (i1 >= i6) {
          continue;
        }
        paramVarArgs[i1] = null;
        i1 += 1;
        continue;
        if (i1 >= i6) {
          continue;
        }
        paramVarArgs[i1] = null;
        i1 += 1;
        continue;
        throw localIOException;
        return;
      }
      finally
      {
        i1 = i5;
        continue;
      }
      if (i2 >= i6) {
        continue;
      }
      paramVarArgs[i2] = null;
      i2 += 1;
    }
  }
  
  private void a(File... paramVarArgs)
  {
    int i1 = 0;
    int i2 = paramVarArgs.length;
    while (i1 < i2)
    {
      if (paramVarArgs[i1] != null) {
        paramVarArgs[i1].delete();
      }
      i1 += 1;
    }
  }
  
  private boolean a(AtomicInteger paramAtomicInteger)
  {
    return paramAtomicInteger.incrementAndGet() % 4 != 0;
  }
  
  private void d()
  {
    this.l = false;
    this.m = false;
    this.d = false;
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        Log.d("DownloadTask", "start: " + this.d + "\t" + this.b.b());
        boolean bool = this.d;
        if (!bool) {
          continue;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        d();
        continue;
      }
      finally {}
      return;
      this.d = true;
      this.h.a(this.b.b(), new f()
      {
        public void a(e paramAnonymouse, IOException paramAnonymousIOException)
        {
          cy.a(cy.this);
        }
        
        public void a(e paramAnonymouse, z paramAnonymousz)
        {
          int i = 0;
          if (paramAnonymousz.b() != 200)
          {
            cy.a(cy.this, new Closeable[] { paramAnonymousz.e() });
            cy.a(cy.this);
          }
          for (;;)
          {
            return;
            cy.a(cy.this, paramAnonymousz.e().a());
            cy.a(cy.this, new Closeable[] { paramAnonymousz.e() });
            cy.a(cy.this, new File(cy.b(cy.this).c(), cy.b(cy.this).a() + ".tmp"));
            if (!cy.c(cy.this).getParentFile().exists()) {
              cy.c(cy.this).getParentFile().mkdirs();
            }
            new RandomAccessFile(cy.c(cy.this), "rw").setLength(cy.d(cy.this));
            long l2 = cy.d(cy.this) / 4L;
            while (i < 4)
            {
              long l3 = i;
              long l1 = (i + 1) * l2 - 1L;
              if (i == 3) {
                l1 = cy.d(cy.this) - 1L;
              }
              cy.a(cy.this, l3 * l2, l1, i);
              i += 1;
            }
          }
        }
      });
    }
  }
  
  public void b()
  {
    this.l = true;
    this.d = false;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.n == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1: 
            long l1 = 0L;
            int i1 = 0;
            int i2 = this.i.length;
            while (i1 < i2)
            {
              l1 += this.i[i1];
              i1 += 1;
            }
            this.n.a((float)l1 * 1.0F / (float)this.c);
            return;
          case 3: 
            this.n.b();
          }
        } while (a(this.f));
        d();
        return;
      } while (a(this.g));
      this.k.renameTo(new File(this.b.c(), this.b.a()));
      d();
      this.n.a();
      return;
    } while (a(this.e));
    d();
    this.i = new long[4];
    this.n.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cy
 * JD-Core Version:    0.7.0.1
 */