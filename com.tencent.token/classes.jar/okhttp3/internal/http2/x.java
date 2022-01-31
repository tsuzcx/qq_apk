package okhttp3.internal.http2;

import java.util.logging.Level;
import java.util.logging.Logger;
import okio.f;
import okio.i;
import okio.y;
import okio.z;

final class x
  implements y
{
  int a;
  byte b;
  int c;
  int d;
  short e;
  private final i f;
  
  x(i parami)
  {
    this.f = parami;
  }
  
  private void b()
  {
    int i = this.c;
    int j = w.a(this.f);
    this.d = j;
    this.a = j;
    byte b1 = (byte)(this.f.h() & 0xFF);
    this.b = ((byte)(this.f.h() & 0xFF));
    if (w.a.isLoggable(Level.FINE)) {
      w.a.fine(e.a(true, this.c, this.a, b1, this.b));
    }
    this.c = (this.f.j() & 0x7FFFFFFF);
    if (b1 != 9) {
      throw e.b("%s != TYPE_CONTINUATION", new Object[] { Byte.valueOf(b1) });
    }
    if (this.c != i) {
      throw e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
    }
  }
  
  public long a(f paramf, long paramLong)
  {
    if (this.d == 0)
    {
      this.f.h(this.e);
      this.e = 0;
      if ((this.b & 0x4) == 0) {}
    }
    do
    {
      return -1L;
      b();
      break;
      paramLong = this.f.a(paramf, Math.min(paramLong, this.d));
    } while (paramLong == -1L);
    this.d = ((int)(this.d - paramLong));
    return paramLong;
  }
  
  public z a()
  {
    return this.f.a();
  }
  
  public void close() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.x
 * JD-Core Version:    0.7.0.1
 */