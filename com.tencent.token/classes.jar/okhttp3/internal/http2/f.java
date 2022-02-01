package okhttp3.internal.http2;

import com.tencent.token.ff;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.ByteString;
import okio.e;
import okio.q;
import okio.r;

final class f
  implements Closeable
{
  static final Logger a = Logger.getLogger(c.class.getName());
  final b.a b;
  private final e c;
  private final a d;
  private final boolean e;
  
  f(e parame, boolean paramBoolean)
  {
    this.c = parame;
    this.e = paramBoolean;
    this.d = new a(this.c);
    this.b = new b.a(4096, this.d);
  }
  
  static int a(int paramInt, byte paramByte, short paramShort)
  {
    short s = paramInt;
    if ((paramByte & 0x8) != 0) {
      s = paramInt - 1;
    }
    if (paramShort <= s) {
      return (short)(s - paramShort);
    }
    throw c.b("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] { Short.valueOf(paramShort), Integer.valueOf(s) });
  }
  
  static int a(e parame)
  {
    int i = parame.h();
    int j = parame.h();
    return parame.h() & 0xFF | (i & 0xFF) << 16 | (j & 0xFF) << 8;
  }
  
  private List<a> a(int paramInt1, short paramShort, byte paramByte, int paramInt2)
  {
    a locala = this.d;
    locala.d = paramInt1;
    locala.a = paramInt1;
    locala.e = paramShort;
    locala.b = paramByte;
    locala.c = paramInt2;
    this.b.a();
    return this.b.b();
  }
  
  private void a(b paramb, int paramInt)
  {
    int i = this.c.j();
    boolean bool;
    if ((0x80000000 & i) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramb.a(paramInt, i & 0x7FFFFFFF, (this.c.h() & 0xFF) + 1, bool);
  }
  
  private void a(b paramb, int paramInt1, byte paramByte, int paramInt2)
  {
    short s = 0;
    if (paramInt2 != 0)
    {
      boolean bool;
      if ((paramByte & 0x1) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      if ((paramByte & 0x8) != 0) {
        s = (short)(this.c.h() & 0xFF);
      }
      int i = paramInt1;
      if ((paramByte & 0x20) != 0)
      {
        a(paramb, paramInt2);
        i = paramInt1 - 5;
      }
      paramb.a(bool, paramInt2, -1, a(a(i, paramByte, s), s, paramByte, paramInt2));
      return;
    }
    throw c.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
  }
  
  private void b(b paramb, int paramInt1, byte paramByte, int paramInt2)
  {
    short s = 0;
    if (paramInt2 != 0)
    {
      int i = 1;
      boolean bool;
      if ((paramByte & 0x1) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      if ((paramByte & 0x20) == 0) {
        i = 0;
      }
      if (i == 0)
      {
        if ((paramByte & 0x8) != 0) {
          s = (short)(this.c.h() & 0xFF);
        }
        paramInt1 = a(paramInt1, paramByte, s);
        paramb.a(bool, paramInt2, this.c, paramInt1);
        this.c.h(s);
        return;
      }
      throw c.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
    }
    throw c.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
  }
  
  private void c(b paramb, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 == 5)
    {
      if (paramInt2 != 0)
      {
        a(paramb, paramInt2);
        return;
      }
      throw c.b("TYPE_PRIORITY streamId == 0", new Object[0]);
    }
    throw c.b("TYPE_PRIORITY length: %d != 5", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  private void d(b paramb, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 == 4)
    {
      if (paramInt2 != 0)
      {
        paramInt1 = this.c.j();
        ErrorCode localErrorCode = ErrorCode.a(paramInt1);
        if (localErrorCode != null)
        {
          paramb.a(paramInt2, localErrorCode);
          return;
        }
        throw c.b("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      throw c.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
    }
    throw c.b("TYPE_RST_STREAM length: %d != 4", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  private void e(b paramb, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      if ((paramByte & 0x1) != 0)
      {
        if (paramInt1 == 0)
        {
          paramb.a();
          return;
        }
        throw c.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
      }
      if (paramInt1 % 6 == 0)
      {
        k localk = new k();
        paramInt2 = 0;
        while (paramInt2 < paramInt1)
        {
          byte b1 = this.c.i() & 0xFFFF;
          int i = this.c.j();
          paramByte = b1;
          switch (b1)
          {
          default: 
            paramByte = b1;
            break;
          case 5: 
            if ((i >= 16384) && (i <= 16777215)) {
              paramByte = b1;
            } else {
              throw c.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] { Integer.valueOf(i) });
            }
            break;
          case 4: 
            paramByte = 7;
            if (i < 0) {
              throw c.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
            }
            break;
          case 3: 
            paramByte = 4;
            break;
          case 2: 
            paramByte = b1;
            if (i != 0) {
              if (i == 1) {
                paramByte = b1;
              } else {
                throw c.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
              }
            }
            break;
          }
          localk.a(paramByte, i);
          paramInt2 += 6;
        }
        paramb.a(false, localk);
        return;
      }
      throw c.b("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    throw c.b("TYPE_SETTINGS streamId != 0", new Object[0]);
  }
  
  private void f(b paramb, int paramInt1, byte paramByte, int paramInt2)
  {
    short s = 0;
    if (paramInt2 != 0)
    {
      if ((paramByte & 0x8) != 0) {
        s = (short)(this.c.h() & 0xFF);
      }
      paramb.a(paramInt2, this.c.j() & 0x7FFFFFFF, a(a(paramInt1 - 4, paramByte, s), s, paramByte, paramInt2));
      return;
    }
    throw c.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
  }
  
  private void g(b paramb, int paramInt1, byte paramByte, int paramInt2)
  {
    boolean bool = false;
    if (paramInt1 == 8)
    {
      if (paramInt2 == 0)
      {
        paramInt1 = this.c.j();
        paramInt2 = this.c.j();
        if ((paramByte & 0x1) != 0) {
          bool = true;
        }
        paramb.a(bool, paramInt1, paramInt2);
        return;
      }
      throw c.b("TYPE_PING streamId != 0", new Object[0]);
    }
    throw c.b("TYPE_PING length != 8: %s", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  private void h(b paramb, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 >= 8)
    {
      if (paramInt2 == 0)
      {
        paramByte = this.c.j();
        paramInt2 = this.c.j();
        paramInt1 -= 8;
        ErrorCode localErrorCode = ErrorCode.a(paramInt2);
        if (localErrorCode != null)
        {
          ByteString localByteString = ByteString.EMPTY;
          if (paramInt1 > 0) {
            localByteString = this.c.c(paramInt1);
          }
          paramb.a(paramByte, localErrorCode, localByteString);
          return;
        }
        throw c.b("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(paramInt2) });
      }
      throw c.b("TYPE_GOAWAY streamId != 0", new Object[0]);
    }
    throw c.b("TYPE_GOAWAY length < 8: %s", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  private void i(b paramb, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 == 4)
    {
      long l = this.c.j() & 0x7FFFFFFF;
      if (l != 0L)
      {
        paramb.a(paramInt2, l);
        return;
      }
      throw c.b("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) });
    }
    throw c.b("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  public void a(b paramb)
  {
    if (this.e)
    {
      if (a(true, paramb)) {
        return;
      }
      throw c.b("Required SETTINGS preface not received", new Object[0]);
    }
    paramb = this.c.c(c.a.g());
    if (a.isLoggable(Level.FINE)) {
      a.fine(ff.a("<< CONNECTION %s", new Object[] { paramb.e() }));
    }
    if (c.a.equals(paramb)) {
      return;
    }
    throw c.b("Expected a connection header but was %s", new Object[] { paramb.a() });
  }
  
  public boolean a(boolean paramBoolean, b paramb)
  {
    try
    {
      this.c.a(9L);
      int i = a(this.c);
      if ((i >= 0) && (i <= 16384))
      {
        byte b1 = (byte)(this.c.h() & 0xFF);
        if ((paramBoolean) && (b1 != 4)) {
          throw c.b("Expected a SETTINGS frame but was %s", new Object[] { Byte.valueOf(b1) });
        }
        byte b2 = (byte)(this.c.h() & 0xFF);
        int j = this.c.j() & 0x7FFFFFFF;
        if (a.isLoggable(Level.FINE)) {
          a.fine(c.a(true, j, i, b1, b2));
        }
        switch (b1)
        {
        default: 
          this.c.h(i);
          return true;
        case 8: 
          i(paramb, i, b2, j);
          return true;
        case 7: 
          h(paramb, i, b2, j);
          return true;
        case 6: 
          g(paramb, i, b2, j);
          return true;
        case 5: 
          f(paramb, i, b2, j);
          return true;
        case 4: 
          e(paramb, i, b2, j);
          return true;
        case 3: 
          d(paramb, i, b2, j);
          return true;
        case 2: 
          c(paramb, i, b2, j);
          return true;
        case 1: 
          a(paramb, i, b2, j);
          return true;
        }
        b(paramb, i, b2, j);
        return true;
      }
      throw c.b("FRAME_SIZE_ERROR: %s", new Object[] { Integer.valueOf(i) });
    }
    catch (IOException paramb) {}
    return false;
  }
  
  public void close()
  {
    this.c.close();
  }
  
  static final class a
    implements q
  {
    int a;
    byte b;
    int c;
    int d;
    short e;
    private final e f;
    
    a(e parame)
    {
      this.f = parame;
    }
    
    private void b()
    {
      int i = this.c;
      int j = f.a(this.f);
      this.d = j;
      this.a = j;
      byte b1 = (byte)(this.f.h() & 0xFF);
      this.b = ((byte)(this.f.h() & 0xFF));
      if (f.a.isLoggable(Level.FINE)) {
        f.a.fine(c.a(true, this.c, this.a, b1, this.b));
      }
      this.c = (this.f.j() & 0x7FFFFFFF);
      if (b1 == 9)
      {
        if (this.c == i) {
          return;
        }
        throw c.b("TYPE_CONTINUATION streamId changed", new Object[0]);
      }
      throw c.b("%s != TYPE_CONTINUATION", new Object[] { Byte.valueOf(b1) });
    }
    
    public long a(okio.c paramc, long paramLong)
    {
      int i;
      for (;;)
      {
        i = this.d;
        if (i != 0) {
          break;
        }
        this.f.h(this.e);
        this.e = 0;
        if ((this.b & 0x4) != 0) {
          return -1L;
        }
        b();
      }
      paramLong = this.f.a(paramc, Math.min(paramLong, i));
      if (paramLong == -1L) {
        return -1L;
      }
      this.d = ((int)(this.d - paramLong));
      return paramLong;
    }
    
    public r a()
    {
      return this.f.a();
    }
    
    public void close() {}
  }
  
  static abstract interface b
  {
    public abstract void a();
    
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
    
    public abstract void a(int paramInt1, int paramInt2, List<a> paramList);
    
    public abstract void a(int paramInt, long paramLong);
    
    public abstract void a(int paramInt, ErrorCode paramErrorCode);
    
    public abstract void a(int paramInt, ErrorCode paramErrorCode, ByteString paramByteString);
    
    public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2);
    
    public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2, List<a> paramList);
    
    public abstract void a(boolean paramBoolean, int paramInt1, e parame, int paramInt2);
    
    public abstract void a(boolean paramBoolean, k paramk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.f
 * JD-Core Version:    0.7.0.1
 */