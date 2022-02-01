package com.tencent.token;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class ama
  implements Closeable
{
  static final Logger a = Logger.getLogger(alx.class.getName());
  final amx b;
  final boolean c;
  final alw.a d;
  private final a e;
  
  ama(amx paramamx, boolean paramBoolean)
  {
    this.b = paramamx;
    this.c = paramBoolean;
    this.e = new a(this.b);
    this.d = new alw.a(this.e);
  }
  
  private static int a(int paramInt, byte paramByte, short paramShort)
  {
    short s = paramInt;
    if ((paramByte & 0x8) != 0) {
      s = paramInt - 1;
    }
    if (paramShort <= s) {
      return (short)(s - paramShort);
    }
    throw alx.b("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] { Short.valueOf(paramShort), Integer.valueOf(s) });
  }
  
  static int a(amx paramamx)
  {
    int i = paramamx.f();
    int j = paramamx.f();
    return paramamx.f() & 0xFF | (i & 0xFF) << 16 | (j & 0xFF) << 8;
  }
  
  private List<alv> a(int paramInt1, short paramShort, byte paramByte, int paramInt2)
  {
    a locala = this.e;
    locala.d = paramInt1;
    locala.a = paramInt1;
    locala.e = paramShort;
    locala.b = paramByte;
    locala.c = paramInt2;
    this.d.a();
    return this.d.b();
  }
  
  private void a()
  {
    this.b.h();
    this.b.f();
  }
  
  public final boolean a(boolean paramBoolean, b paramb)
  {
    short s1 = 0;
    short s2 = 0;
    short s3 = 0;
    boolean bool = false;
    try
    {
      this.b.a(9L);
      int k = a(this.b);
      if ((k >= 0) && (k <= 16384))
      {
        byte b1 = (byte)(this.b.f() & 0xFF);
        if ((paramBoolean) && (b1 != 4)) {
          throw alx.b("Expected a SETTINGS frame but was %s", new Object[] { Byte.valueOf(b1) });
        }
        byte b2 = (byte)(this.b.f() & 0xFF);
        int j = this.b.h() & 0x7FFFFFFF;
        if (a.isLoggable(Level.FINE)) {
          a.fine(alx.a(true, j, k, b1, b2));
        }
        int i;
        Object localObject;
        switch (b1)
        {
        default: 
          this.b.g(k);
          return true;
        case 8: 
          if (k == 4)
          {
            long l = this.b.h() & 0x7FFFFFFF;
            if (l != 0L)
            {
              paramb.a(j, l);
              return true;
            }
            throw alx.b("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) });
          }
          throw alx.b("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] { Integer.valueOf(k) });
        case 7: 
          if (k >= 8)
          {
            if (j == 0)
            {
              i = this.b.h();
              j = this.b.h();
              k -= 8;
              if (alu.a(j) != null)
              {
                localObject = amy.b;
                if (k > 0) {
                  this.b.c(k);
                }
                paramb.a(i);
                return true;
              }
              throw alx.b("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(j) });
            }
            throw alx.b("TYPE_GOAWAY streamId != 0", new Object[0]);
          }
          throw alx.b("TYPE_GOAWAY length < 8: %s", new Object[] { Integer.valueOf(k) });
        case 6: 
          if (k == 8)
          {
            if (j == 0)
            {
              i = this.b.h();
              j = this.b.h();
              paramBoolean = bool;
              if ((b2 & 0x1) != 0) {
                paramBoolean = true;
              }
              paramb.a(paramBoolean, i, j);
              return true;
            }
            throw alx.b("TYPE_PING streamId != 0", new Object[0]);
          }
          throw alx.b("TYPE_PING length != 8: %s", new Object[] { Integer.valueOf(k) });
        case 5: 
          if (j != 0)
          {
            if ((b2 & 0x8) != 0) {
              s1 = (short)(this.b.f() & 0xFF);
            }
            paramb.a(this.b.h() & 0x7FFFFFFF, a(a(k - 4, b2, s1), s1, b2, j));
            return true;
          }
          throw alx.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        case 4: 
          if (j == 0)
          {
            if ((b2 & 0x1) != 0)
            {
              if (k == 0) {
                return true;
              }
              throw alx.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            if (k % 6 == 0)
            {
              localObject = new amf();
              j = 0;
              while (j < k)
              {
                int m = this.b.g() & 0xFFFF;
                int n = this.b.h();
                i = m;
                switch (m)
                {
                default: 
                  i = m;
                  break;
                case 5: 
                  if ((n >= 16384) && (n <= 16777215)) {
                    i = m;
                  } else {
                    throw alx.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] { Integer.valueOf(n) });
                  }
                  break;
                case 4: 
                  i = 7;
                  if (n < 0) {
                    throw alx.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                  }
                  break;
                case 3: 
                  i = 4;
                  break;
                case 2: 
                  i = m;
                  if (n != 0) {
                    if (n == 1) {
                      i = m;
                    } else {
                      throw alx.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    }
                  }
                  break;
                }
                ((amf)localObject).a(i, n);
                j += 6;
              }
              paramb.a((amf)localObject);
              return true;
            }
            throw alx.b("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] { Integer.valueOf(k) });
          }
          throw alx.b("TYPE_SETTINGS streamId != 0", new Object[0]);
        case 3: 
          if (k == 4)
          {
            if (j != 0)
            {
              i = this.b.h();
              localObject = alu.a(i);
              if (localObject != null)
              {
                paramb.a(j, (alu)localObject);
                return true;
              }
              throw alx.b("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(i) });
            }
            throw alx.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
          }
          throw alx.b("TYPE_RST_STREAM length: %d != 4", new Object[] { Integer.valueOf(k) });
        case 2: 
          if (k == 5)
          {
            if (j != 0)
            {
              a();
              return true;
            }
            throw alx.b("TYPE_PRIORITY streamId == 0", new Object[0]);
          }
          throw alx.b("TYPE_PRIORITY length: %d != 5", new Object[] { Integer.valueOf(k) });
        case 1: 
          if (j != 0)
          {
            if ((b2 & 0x1) != 0) {
              paramBoolean = true;
            } else {
              paramBoolean = false;
            }
            s1 = s2;
            if ((b2 & 0x8) != 0) {
              s1 = (short)(this.b.f() & 0xFF);
            }
            i = k;
            if ((b2 & 0x20) != 0)
            {
              a();
              i = k - 5;
            }
            paramb.a(paramBoolean, j, a(a(i, b2, s1), s1, b2, j));
            return true;
          }
          throw alx.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        if (j != 0)
        {
          if ((b2 & 0x1) != 0) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          }
          if ((b2 & 0x20) != 0) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0)
          {
            s1 = s3;
            if ((b2 & 0x8) != 0) {
              s1 = (short)(this.b.f() & 0xFF);
            }
            i = a(k, b2, s1);
            paramb.a(paramBoolean, j, this.b, i);
            this.b.g(s1);
            return true;
          }
          throw alx.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw alx.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
      }
      throw alx.b("FRAME_SIZE_ERROR: %s", new Object[] { Integer.valueOf(k) });
    }
    catch (IOException paramb) {}
    return false;
  }
  
  public final void close()
  {
    this.b.close();
  }
  
  static final class a
    implements anl
  {
    int a;
    byte b;
    int c;
    int d;
    short e;
    private final amx f;
    
    a(amx paramamx)
    {
      this.f = paramamx;
    }
    
    public final long a(amv paramamv, long paramLong)
    {
      int i;
      byte b1;
      do
      {
        i = this.d;
        if (i != 0) {
          break label203;
        }
        this.f.g(this.e);
        this.e = 0;
        if ((this.b & 0x4) != 0) {
          return -1L;
        }
        i = this.c;
        int j = ama.a(this.f);
        this.d = j;
        this.a = j;
        b1 = (byte)(this.f.f() & 0xFF);
        this.b = ((byte)(this.f.f() & 0xFF));
        if (ama.a.isLoggable(Level.FINE)) {
          ama.a.fine(alx.a(true, this.c, this.a, b1, this.b));
        }
        this.c = (this.f.h() & 0x7FFFFFFF);
        if (b1 != 9) {
          break;
        }
      } while (this.c == i);
      throw alx.b("TYPE_CONTINUATION streamId changed", new Object[0]);
      throw alx.b("%s != TYPE_CONTINUATION", new Object[] { Byte.valueOf(b1) });
      label203:
      paramLong = this.f.a(paramamv, Math.min(paramLong, i));
      if (paramLong == -1L) {
        return -1L;
      }
      this.d = ((int)(this.d - paramLong));
      return paramLong;
    }
    
    public final anm a()
    {
      return this.f.a();
    }
    
    public final void close() {}
  }
  
  static abstract interface b
  {
    public abstract void a(int paramInt);
    
    public abstract void a(int paramInt, long paramLong);
    
    public abstract void a(int paramInt, alu paramalu);
    
    public abstract void a(int paramInt, List<alv> paramList);
    
    public abstract void a(amf paramamf);
    
    public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2);
    
    public abstract void a(boolean paramBoolean, int paramInt1, amx paramamx, int paramInt2);
    
    public abstract void a(boolean paramBoolean, int paramInt, List<alv> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ama
 * JD-Core Version:    0.7.0.1
 */