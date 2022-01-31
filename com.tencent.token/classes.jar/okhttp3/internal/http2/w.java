package okhttp3.internal.http2;

import com.tencent.token.gn;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.ByteString;
import okio.i;

final class w
  implements Closeable
{
  static final Logger a = Logger.getLogger(e.class.getName());
  final c b;
  private final i c;
  private final x d;
  private final boolean e;
  
  w(i parami, boolean paramBoolean)
  {
    this.c = parami;
    this.e = paramBoolean;
    this.d = new x(this.c);
    this.b = new c(4096, this.d);
  }
  
  static int a(int paramInt, byte paramByte, short paramShort)
  {
    short s = paramInt;
    if ((paramByte & 0x8) != 0) {
      s = paramInt - 1;
    }
    if (paramShort > s) {
      throw e.b("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] { Short.valueOf(paramShort), Integer.valueOf(s) });
    }
    return (short)(s - paramShort);
  }
  
  static int a(i parami)
  {
    return (parami.h() & 0xFF) << 16 | (parami.h() & 0xFF) << 8 | parami.h() & 0xFF;
  }
  
  private List a(int paramInt1, short paramShort, byte paramByte, int paramInt2)
  {
    x localx = this.d;
    this.d.d = paramInt1;
    localx.a = paramInt1;
    this.d.e = paramShort;
    this.d.b = paramByte;
    this.d.c = paramInt2;
    this.b.a();
    return this.b.b();
  }
  
  private void a(y paramy, int paramInt)
  {
    int i = this.c.j();
    if ((0x80000000 & i) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramy.a(paramInt, i & 0x7FFFFFFF, (this.c.h() & 0xFF) + 1, bool);
      return;
    }
  }
  
  private void a(y paramy, int paramInt1, byte paramByte, int paramInt2)
  {
    short s = 0;
    if (paramInt2 == 0) {
      throw e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }
    if ((paramByte & 0x1) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((paramByte & 0x8) != 0) {
        s = (short)(this.c.h() & 0xFF);
      }
      int i = paramInt1;
      if ((paramByte & 0x20) != 0)
      {
        a(paramy, paramInt2);
        i = paramInt1 - 5;
      }
      paramy.a(bool, paramInt2, -1, a(a(i, paramByte, s), s, paramByte, paramInt2));
      return;
    }
  }
  
  private void b(y paramy, int paramInt1, byte paramByte, int paramInt2)
  {
    int i = 1;
    short s = 0;
    if (paramInt2 == 0) {
      throw e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }
    boolean bool;
    if ((paramByte & 0x1) != 0)
    {
      bool = true;
      if ((paramByte & 0x20) == 0) {
        break label58;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label64;
      }
      throw e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
      bool = false;
      break;
      label58:
      i = 0;
    }
    label64:
    if ((paramByte & 0x8) != 0) {
      s = (short)(this.c.h() & 0xFF);
    }
    paramInt1 = a(paramInt1, paramByte, s);
    paramy.a(bool, paramInt2, this.c, paramInt1);
    this.c.h(s);
  }
  
  private void c(y paramy, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 != 5) {
      throw e.b("TYPE_PRIORITY length: %d != 5", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 == 0) {
      throw e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
    }
    a(paramy, paramInt2);
  }
  
  private void d(y paramy, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 != 4) {
      throw e.b("TYPE_RST_STREAM length: %d != 4", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 == 0) {
      throw e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
    }
    paramInt1 = this.c.j();
    ErrorCode localErrorCode = ErrorCode.a(paramInt1);
    if (localErrorCode == null) {
      throw e.b("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(paramInt1) });
    }
    paramy.a(paramInt2, localErrorCode);
  }
  
  private void e(y paramy, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt2 != 0) {
      throw e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
    }
    if ((paramByte & 0x1) != 0)
    {
      if (paramInt1 != 0) {
        throw e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
      }
      paramy.a();
      return;
    }
    if (paramInt1 % 6 != 0) {
      throw e.b("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    ai localai = new ai();
    paramInt2 = 0;
    if (paramInt2 < paramInt1)
    {
      byte b1 = this.c.i() & 0xFFFF;
      int i = this.c.j();
      paramByte = b1;
      switch (b1)
      {
      default: 
        paramByte = b1;
      }
      do
      {
        do
        {
          for (;;)
          {
            localai.a(paramByte, i);
            paramInt2 += 6;
            break;
            paramByte = b1;
            if (i != 0)
            {
              paramByte = b1;
              if (i != 1)
              {
                throw e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                paramByte = 4;
              }
            }
          }
          paramByte = 7;
        } while (i >= 0);
        throw e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
        if (i < 16384) {
          break label242;
        }
        paramByte = b1;
      } while (i <= 16777215);
      label242:
      throw e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] { Integer.valueOf(i) });
    }
    paramy.a(false, localai);
  }
  
  private void f(y paramy, int paramInt1, byte paramByte, int paramInt2)
  {
    short s = 0;
    if (paramInt2 == 0) {
      throw e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }
    if ((paramByte & 0x8) != 0) {
      s = (short)(this.c.h() & 0xFF);
    }
    paramy.a(paramInt2, this.c.j() & 0x7FFFFFFF, a(a(paramInt1 - 4, paramByte, s), s, paramByte, paramInt2));
  }
  
  private void g(y paramy, int paramInt1, byte paramByte, int paramInt2)
  {
    boolean bool = true;
    if (paramInt1 != 8) {
      throw e.b("TYPE_PING length != 8: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 != 0) {
      throw e.b("TYPE_PING streamId != 0", new Object[0]);
    }
    paramInt1 = this.c.j();
    paramInt2 = this.c.j();
    if ((paramByte & 0x1) != 0) {}
    for (;;)
    {
      paramy.a(bool, paramInt1, paramInt2);
      return;
      bool = false;
    }
  }
  
  private void h(y paramy, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 < 8) {
      throw e.b("TYPE_GOAWAY length < 8: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 != 0) {
      throw e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
    }
    paramByte = this.c.j();
    paramInt2 = this.c.j();
    paramInt1 -= 8;
    ErrorCode localErrorCode = ErrorCode.a(paramInt2);
    if (localErrorCode == null) {
      throw e.b("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(paramInt2) });
    }
    ByteString localByteString = ByteString.EMPTY;
    if (paramInt1 > 0) {
      localByteString = this.c.c(paramInt1);
    }
    paramy.a(paramByte, localErrorCode, localByteString);
  }
  
  private void i(y paramy, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 != 4) {
      throw e.b("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    long l = this.c.j() & 0x7FFFFFFF;
    if (l == 0L) {
      throw e.b("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) });
    }
    paramy.a(paramInt2, l);
  }
  
  public void a(y paramy)
  {
    if (this.e)
    {
      if (!a(true, paramy)) {
        throw e.b("Required SETTINGS preface not received", new Object[0]);
      }
    }
    else
    {
      paramy = this.c.c(e.a.g());
      if (a.isLoggable(Level.FINE)) {
        a.fine(gn.a("<< CONNECTION %s", new Object[] { paramy.e() }));
      }
      if (!e.a.equals(paramy)) {
        throw e.b("Expected a connection header but was %s", new Object[] { paramy.a() });
      }
    }
  }
  
  public boolean a(boolean paramBoolean, y paramy)
  {
    int i;
    try
    {
      this.c.a(9L);
      i = a(this.c);
      if ((i < 0) || (i > 16384)) {
        throw e.b("FRAME_SIZE_ERROR: %s", new Object[] { Integer.valueOf(i) });
      }
    }
    catch (IOException paramy)
    {
      return false;
    }
    byte b1 = (byte)(this.c.h() & 0xFF);
    if ((paramBoolean) && (b1 != 4)) {
      throw e.b("Expected a SETTINGS frame but was %s", new Object[] { Byte.valueOf(b1) });
    }
    byte b2 = (byte)(this.c.h() & 0xFF);
    int j = this.c.j() & 0x7FFFFFFF;
    if (a.isLoggable(Level.FINE)) {
      a.fine(e.a(true, j, i, b1, b2));
    }
    switch (b1)
    {
    default: 
      this.c.h(i);
      return true;
    case 0: 
      b(paramy, i, b2, j);
      return true;
    case 1: 
      a(paramy, i, b2, j);
      return true;
    case 2: 
      c(paramy, i, b2, j);
      return true;
    case 3: 
      d(paramy, i, b2, j);
      return true;
    case 4: 
      e(paramy, i, b2, j);
      return true;
    case 5: 
      f(paramy, i, b2, j);
      return true;
    case 6: 
      g(paramy, i, b2, j);
      return true;
    case 7: 
      h(paramy, i, b2, j);
      return true;
    }
    i(paramy, i, b2, j);
    return true;
  }
  
  public void close()
  {
    this.c.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.w
 * JD-Core Version:    0.7.0.1
 */