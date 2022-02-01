package com.tencent.token;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class amc
  implements Closeable
{
  private static final Logger c = Logger.getLogger(alx.class.getName());
  int a;
  final alw.b b;
  private final amw d;
  private final boolean e;
  private final amv f;
  private boolean g;
  
  amc(amw paramamw, boolean paramBoolean)
  {
    this.d = paramamw;
    this.e = paramBoolean;
    this.f = new amv();
    this.b = new alw.b(this.f);
    this.a = 16384;
  }
  
  private void a(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    if (c.isLoggable(Level.FINE)) {
      c.fine(alx.a(false, paramInt1, paramInt2, paramByte1, paramByte2));
    }
    int i = this.a;
    if (paramInt2 <= i)
    {
      if ((0x80000000 & paramInt1) == 0)
      {
        a(this.d, paramInt2);
        this.d.h(paramByte1 & 0xFF);
        this.d.h(paramByte2 & 0xFF);
        this.d.f(paramInt1 & 0x7FFFFFFF);
        return;
      }
      throw alx.a("reserved bit set: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    throw alx.a("FRAME_SIZE_ERROR length > %d: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
  }
  
  private static void a(amw paramamw, int paramInt)
  {
    paramamw.h(paramInt >>> 16 & 0xFF);
    paramamw.h(paramInt >>> 8 & 0xFF);
    paramamw.h(paramInt & 0xFF);
  }
  
  private void b(int paramInt, long paramLong)
  {
    while (paramLong > 0L)
    {
      int i = (int)Math.min(this.a, paramLong);
      long l = i;
      paramLong -= l;
      byte b1;
      if (paramLong == 0L) {
        b1 = 4;
      } else {
        b1 = 0;
      }
      a(paramInt, i, (byte)9, b1);
      this.d.a_(this.f, l);
    }
  }
  
  public final void a()
  {
    try
    {
      if (!this.g)
      {
        boolean bool = this.e;
        if (!bool) {
          return;
        }
        if (c.isLoggable(Level.FINE)) {
          c.fine(akt.a(">> CONNECTION %s", new Object[] { alx.a.e() }));
        }
        this.d.c(alx.a.h());
        this.d.flush();
        return;
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public final void a(int paramInt, long paramLong)
  {
    try
    {
      if (!this.g)
      {
        if ((paramLong != 0L) && (paramLong <= 2147483647L))
        {
          a(paramInt, 4, (byte)8, (byte)0);
          this.d.f((int)paramLong);
          this.d.flush();
          return;
        }
        throw alx.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[] { Long.valueOf(paramLong) });
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public final void a(int paramInt, alu paramalu)
  {
    try
    {
      if (!this.g)
      {
        if (paramalu.l != -1)
        {
          a(paramInt, 4, (byte)3, (byte)0);
          this.d.f(paramalu.l);
          this.d.flush();
          return;
        }
        throw new IllegalArgumentException();
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public final void a(int paramInt, alu paramalu, byte[] paramArrayOfByte)
  {
    try
    {
      if (!this.g)
      {
        if (paramalu.l != -1)
        {
          a(0, paramArrayOfByte.length + 8, (byte)7, (byte)0);
          this.d.f(paramInt);
          this.d.f(paramalu.l);
          if (paramArrayOfByte.length > 0) {
            this.d.c(paramArrayOfByte);
          }
          this.d.flush();
          return;
        }
        throw alx.a("errorCode.httpCode == -1", new Object[0]);
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public final void a(amf paramamf)
  {
    try
    {
      if (!this.g)
      {
        int i = this.a;
        if ((paramamf.a & 0x20) != 0) {
          i = paramamf.b[5];
        }
        this.a = i;
        if (paramamf.a() != -1) {
          this.b.a(paramamf.a());
        }
        a(0, 0, (byte)4, (byte)1);
        this.d.flush();
        return;
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2)
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
            this.d.f(paramInt1);
            this.d.f(paramInt2);
            this.d.flush();
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
  
  public final void a(boolean paramBoolean, int paramInt1, amv paramamv, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void a(boolean paramBoolean, int paramInt, List<alv> paramList)
  {
    for (;;)
    {
      try
      {
        if (!this.g)
        {
          if (!this.g)
          {
            this.b.a(paramList);
            long l1 = this.f.b;
            int i = (int)Math.min(this.a, l1);
            long l2 = i;
            if (l1 == l2)
            {
              b1 = 4;
              break label139;
              a(paramInt, i, (byte)1, b2);
              this.d.a_(this.f, l2);
              if (l1 > l2) {
                b(paramInt, l1 - l2);
              }
            }
          }
          else
          {
            throw new IOException("closed");
          }
        }
        else {
          throw new IOException("closed");
        }
      }
      finally {}
      byte b1 = 0;
      label139:
      byte b2 = b1;
      if (paramBoolean) {
        b2 = (byte)(b1 | 0x1);
      }
    }
  }
  
  public final void b()
  {
    try
    {
      if (!this.g)
      {
        this.d.flush();
        return;
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public final void b(amf paramamf)
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        if (!this.g)
        {
          j = Integer.bitCount(paramamf.a);
          i = 0;
          a(0, j * 6, (byte)4, (byte)0);
          if (i < 10)
          {
            if (!paramamf.a(i)) {
              break label127;
            }
            if (i == 4)
            {
              j = 3;
              this.d.g(j);
              this.d.f(paramamf.b[i]);
              break label127;
            }
          }
          else
          {
            this.d.flush();
          }
        }
        else
        {
          throw new IOException("closed");
        }
      }
      finally {}
      if (i == 7)
      {
        j = 4;
      }
      else
      {
        j = i;
        continue;
        label127:
        i += 1;
      }
    }
  }
  
  public final void close()
  {
    try
    {
      this.g = true;
      this.d.close();
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
 * Qualified Name:     com.tencent.token.amc
 * JD-Core Version:    0.7.0.1
 */