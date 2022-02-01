package okhttp3.internal.http2;

import com.tencent.token.fb;
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
    if (paramLong > 0L)
    {
      int i = (int)Math.min(this.f, paramLong);
      paramLong -= i;
      if (paramLong == 0L) {}
      for (byte b1 = 4;; b1 = 0)
      {
        a(paramInt, i, (byte)9, b1);
        this.c.a_(this.e, i);
        break;
      }
    }
  }
  
  public void a()
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    boolean bool = this.d;
    if (!bool) {}
    for (;;)
    {
      return;
      if (b.isLoggable(Level.FINE)) {
        b.fine(fb.a(">> CONNECTION %s", new Object[] { c.a.e() }));
      }
      this.c.c(c.a.h());
      this.c.flush();
    }
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
    if (paramInt2 > this.f) {
      throw c.a("FRAME_SIZE_ERROR length > %d: %d", new Object[] { Integer.valueOf(this.f), Integer.valueOf(paramInt2) });
    }
    if ((0x80000000 & paramInt1) != 0) {
      throw c.a("reserved bit set: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    a(this.c, paramInt2);
    this.c.i(paramByte1 & 0xFF);
    this.c.i(paramByte2 & 0xFF);
    this.c.g(0x7FFFFFFF & paramInt1);
  }
  
  public void a(int paramInt1, int paramInt2, List<a> paramList)
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    this.a.a(paramList);
    long l = this.e.b();
    int i = (int)Math.min(this.f - 4, l);
    if (l == i) {}
    for (byte b1 = 4;; b1 = 0)
    {
      a(paramInt1, i + 4, (byte)5, b1);
      this.c.g(0x7FFFFFFF & paramInt2);
      this.c.a_(this.e, i);
      if (l > i) {
        b(paramInt1, l - i);
      }
      return;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    if ((paramLong == 0L) || (paramLong > 2147483647L)) {
      throw c.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[] { Long.valueOf(paramLong) });
    }
    a(paramInt, 4, (byte)8, (byte)0);
    this.c.g((int)paramLong);
    this.c.flush();
  }
  
  public void a(int paramInt, ErrorCode paramErrorCode)
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    if (paramErrorCode.httpCode == -1) {
      throw new IllegalArgumentException();
    }
    a(paramInt, 4, (byte)3, (byte)0);
    this.c.g(paramErrorCode.httpCode);
    this.c.flush();
  }
  
  public void a(int paramInt, ErrorCode paramErrorCode, byte[] paramArrayOfByte)
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    if (paramErrorCode.httpCode == -1) {
      throw c.a("errorCode.httpCode == -1", new Object[0]);
    }
    a(0, paramArrayOfByte.length + 8, (byte)7, (byte)0);
    this.c.g(paramInt);
    this.c.g(paramErrorCode.httpCode);
    if (paramArrayOfByte.length > 0) {
      this.c.c(paramArrayOfByte);
    }
    this.c.flush();
  }
  
  public void a(k paramk)
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    this.f = paramk.d(this.f);
    if (paramk.c() != -1) {
      this.a.a(paramk.c());
    }
    a(0, 0, (byte)4, (byte)1);
    this.c.flush();
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    byte b1 = 0;
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    if (paramBoolean) {
      b1 = 1;
    }
    a(0, 8, (byte)6, b1);
    this.c.g(paramInt1);
    this.c.g(paramInt2);
    this.c.flush();
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, List<a> paramList)
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    a(paramBoolean, paramInt1, paramList);
  }
  
  void a(boolean paramBoolean, int paramInt, List<a> paramList)
  {
    if (this.g) {
      throw new IOException("closed");
    }
    this.a.a(paramList);
    long l = this.e.b();
    int i = (int)Math.min(this.f, l);
    if (l == i) {}
    for (byte b1 = 4;; b1 = 0)
    {
      byte b2 = b1;
      if (paramBoolean) {
        b2 = (byte)(b1 | 0x1);
      }
      a(paramInt, i, (byte)1, b2);
      this.c.a_(this.e, i);
      if (l > i) {
        b(paramInt, l - i);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, okio.c paramc, int paramInt2)
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    byte b1 = 0;
    if (paramBoolean) {
      b1 = (byte)1;
    }
    a(paramInt1, b1, paramc, paramInt2);
  }
  
  public void b()
  {
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    this.c.flush();
  }
  
  public void b(k paramk)
  {
    int i = 0;
    try
    {
      if (this.g) {
        throw new IOException("closed");
      }
    }
    finally {}
    a(0, paramk.b() * 6, (byte)4, (byte)0);
    if (i < 10) {
      if (paramk.a(i)) {
        break label110;
      }
    }
    for (;;)
    {
      label57:
      this.c.h(j);
      this.c.g(paramk.b(i));
      break label103;
      this.c.flush();
      return;
      label103:
      label110:
      do
      {
        j = i;
        break label57;
        i += 1;
        break;
        if (i == 4)
        {
          j = 3;
          break label57;
        }
      } while (i != 7);
      int j = 4;
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