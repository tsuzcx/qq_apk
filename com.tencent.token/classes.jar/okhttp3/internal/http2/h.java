package okhttp3.internal.http2;

import com.tencent.token.fc;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.ByteString;
import okio.d;

final class h
  implements Closeable
{
  private static final Logger b = Logger.getLogger(c.class.getName());
  final b.b a;
  private final d c;
  private final boolean d;
  private final okio.c e;
  private int f;
  private boolean g;
  
  h(d paramd, boolean paramBoolean)
  {
    this.c = paramd;
    this.d = paramBoolean;
    this.e = new okio.c();
    this.a = new b.b(this.e);
    this.f = 16384;
  }
  
  private static void a(d paramd, int paramInt)
  {
    paramd.i(paramInt >>> 16 & 0xFF);
    paramd.i(paramInt >>> 8 & 0xFF);
    paramd.i(paramInt & 0xFF);
  }
  
  private void b(int paramInt, long paramLong)
  {
    while (paramLong > 0L)
    {
      int i = (int)Math.min(this.f, paramLong);
      long l = i;
      paramLong -= l;
      byte b1;
      if (paramLong == 0L) {
        b1 = 4;
      } else {
        b1 = 0;
      }
      a(paramInt, i, (byte)9, b1);
      this.c.a_(this.e, l);
    }
  }
  
  public void a()
  {
    try
    {
      if (!this.g)
      {
        boolean bool = this.d;
        if (!bool) {
          return;
        }
        if (b.isLoggable(Level.FINE)) {
          b.fine(fc.a(">> CONNECTION %s", new Object[] { c.a.e() }));
        }
        this.c.c(c.a.h());
        this.c.flush();
        return;
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  void a(int paramInt1, byte paramByte, okio.c paramc, int paramInt2)
  {
    a(paramInt1, paramInt2, (byte)0, paramByte);
    if (paramInt2 > 0) {
      this.c.a_(paramc, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    if (b.isLoggable(Level.FINE)) {
      b.fine(c.a(false, paramInt1, paramInt2, paramByte1, paramByte2));
    }
    int i = this.f;
    if (paramInt2 <= i)
    {
      if ((0x80000000 & paramInt1) == 0)
      {
        a(this.c, paramInt2);
        this.c.i(paramByte1 & 0xFF);
        this.c.i(paramByte2 & 0xFF);
        this.c.g(paramInt1 & 0x7FFFFFFF);
        return;
      }
      throw c.a("reserved bit set: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    throw c.a("FRAME_SIZE_ERROR length > %d: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
  }
  
  public void a(int paramInt1, int paramInt2, List<a> paramList)
  {
    for (;;)
    {
      try
      {
        if (!this.g)
        {
          this.a.a(paramList);
          long l1 = this.e.b();
          int i = (int)Math.min(this.f - 4, l1);
          long l2 = i;
          if (l1 == l2)
          {
            b1 = 4;
            a(paramInt1, i + 4, (byte)5, b1);
            this.c.g(paramInt2 & 0x7FFFFFFF);
            this.c.a_(this.e, l2);
            if (l1 > l2) {
              b(paramInt1, l1 - l2);
            }
          }
        }
        else
        {
          throw new IOException("closed");
        }
      }
      finally {}
      byte b1 = 0;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    try
    {
      if (!this.g)
      {
        if ((paramLong != 0L) && (paramLong <= 2147483647L))
        {
          a(paramInt, 4, (byte)8, (byte)0);
          this.c.g((int)paramLong);
          this.c.flush();
          return;
        }
        throw c.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[] { Long.valueOf(paramLong) });
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public void a(int paramInt, ErrorCode paramErrorCode)
  {
    try
    {
      if (!this.g)
      {
        if (paramErrorCode.httpCode != -1)
        {
          a(paramInt, 4, (byte)3, (byte)0);
          this.c.g(paramErrorCode.httpCode);
          this.c.flush();
          return;
        }
        throw new IllegalArgumentException();
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public void a(int paramInt, ErrorCode paramErrorCode, byte[] paramArrayOfByte)
  {
    try
    {
      if (!this.g)
      {
        if (paramErrorCode.httpCode != -1)
        {
          a(0, paramArrayOfByte.length + 8, (byte)7, (byte)0);
          this.c.g(paramInt);
          this.c.g(paramErrorCode.httpCode);
          if (paramArrayOfByte.length > 0) {
            this.c.c(paramArrayOfByte);
          }
          this.c.flush();
          return;
        }
        throw c.a("errorCode.httpCode == -1", new Object[0]);
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public void a(k paramk)
  {
    try
    {
      if (!this.g)
      {
        this.f = paramk.d(this.f);
        if (paramk.c() != -1) {
          this.a.a(paramk.c());
        }
        a(0, 0, (byte)4, (byte)1);
        this.c.flush();
        return;
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        if (!this.g)
        {
          if (paramBoolean)
          {
            b1 = 1;
            a(0, 8, (byte)6, b1);
            this.c.g(paramInt1);
            this.c.g(paramInt2);
            this.c.flush();
          }
        }
        else {
          throw new IOException("closed");
        }
      }
      finally {}
      byte b1 = 0;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, List<a> paramList)
  {
    try
    {
      if (!this.g)
      {
        a(paramBoolean, paramInt1, paramList);
        return;
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  void a(boolean paramBoolean, int paramInt, List<a> paramList)
  {
    if (!this.g)
    {
      this.a.a(paramList);
      long l1 = this.e.b();
      int i = (int)Math.min(this.f, l1);
      long l2 = i;
      byte b1;
      if (l1 == l2) {
        b1 = 4;
      } else {
        b1 = 0;
      }
      byte b2 = b1;
      if (paramBoolean) {
        b2 = (byte)(b1 | 0x1);
      }
      a(paramInt, i, (byte)1, b2);
      this.c.a_(this.e, l2);
      if (l1 > l2) {
        b(paramInt, l1 - l2);
      }
      return;
    }
    throw new IOException("closed");
  }
  
  public void a(boolean paramBoolean, int paramInt1, okio.c paramc, int paramInt2)
  {
    try
    {
      if (!this.g)
      {
        byte b1 = 0;
        if (paramBoolean) {
          b1 = (byte)1;
        }
        a(paramInt1, b1, paramc, paramInt2);
        return;
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      if (!this.g)
      {
        this.c.flush();
        return;
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public void b(k paramk)
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        if (!this.g)
        {
          j = paramk.b();
          i = 0;
          a(0, j * 6, (byte)4, (byte)0);
          if (i < 10)
          {
            if (!paramk.a(i))
            {
              break label126;
              this.c.h(j);
              this.c.g(paramk.b(i));
            }
          }
          else {
            this.c.flush();
          }
        }
        else
        {
          throw new IOException("closed");
        }
      }
      finally {}
      if (i == 4)
      {
        j = 3;
      }
      else if (i == 7)
      {
        j = 4;
      }
      else
      {
        j = i;
        continue;
        label126:
        i += 1;
      }
    }
  }
  
  public int c()
  {
    return this.f;
  }
  
  public void close()
  {
    try
    {
      this.g = true;
      this.c.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.h
 * JD-Core Version:    0.7.0.1
 */