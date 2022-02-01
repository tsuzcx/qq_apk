package com.tencent.token;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeoutException;

public final class acv
{
  public final Object a;
  public final Object b;
  public Process c;
  public DataOutputStream d;
  public a e;
  public a f;
  public ByteArrayOutputStream g;
  public ByteArrayOutputStream h;
  
  public acv(String arg1)
  {
    Object localObject1 = new Object();
    this.a = localObject1;
    this.b = new Object();
    this.g = new ByteArrayOutputStream();
    this.h = new ByteArrayOutputStream();
    if ((??? != null) && (???.length() != 0))
    {
      if ((???.startsWith("/")) && (!new File(???).exists())) {
        throw new FileNotFoundException();
      }
      this.c = Runtime.getRuntime().exec(???);
      int i;
      label130:
      try
      {
        localObject1.wait(10L);
      }
      finally {}
    }
    try
    {
      this.c.exitValue();
      i = 1;
    }
    catch (Exception ???)
    {
      break label130;
    }
    i = 0;
    if (i == 0)
    {
      this.d = new DataOutputStream(this.c.getOutputStream());
      this.e = new a("s", this.c.getInputStream(), this.g);
      this.f = new a("e", this.c.getErrorStream(), this.h);
      synchronized (this.a)
      {
        this.a.wait(10L);
        this.e.start();
        this.f.start();
        return;
      }
    }
    throw new IOException();
    throw new IllegalArgumentException();
  }
  
  private c a(long paramLong)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        synchronized (this.b)
        {
          i = new String(this.g.toByteArray()).lastIndexOf(":RET=");
          int j = 1;
          if (i == -1)
          {
            i = 1;
            if (i != 0) {
              this.a.wait(paramLong);
            }
            synchronized (this.b)
            {
              Object localObject5 = this.g.toByteArray();
              ??? = this.h.toByteArray();
              localObject5 = new String((byte[])localObject5);
              ??? = new String((byte[])???);
              if (((String)localObject5).lastIndexOf(":RET=") != -1)
              {
                this.g.reset();
                this.h.reset();
                if (((String)localObject5).lastIndexOf(":RET=0") != -1)
                {
                  ??? = new c(((String)localObject5).substring(0, ((String)localObject5).lastIndexOf(":RET=")), (String)???);
                  return ???;
                }
                if ((((String)localObject5).lastIndexOf(":RET=EOF") != -1) || (((String)???).lastIndexOf(":RET=EOF") != -1)) {
                  break label276;
                }
                i = j;
                ??? = new c(((String)localObject5).substring(0, ((String)localObject5).lastIndexOf(":RET=")), (String)???);
                return ???;
              }
              return null;
            }
          }
        }
      }
      int i = 0;
      continue;
      label276:
      i = 2;
    }
  }
  
  public final c a(b paramb)
  {
    for (;;)
    {
      try
      {
        ??? = paramb.a;
        if ((??? != null) && (((String)???).length() > 0))
        {
          ??? = paramb.b;
          if ((??? != null) && (((String)???).length() > 0))
          {
            i = 0;
            if ((i == 0) && (paramb.c >= 0L)) {
              synchronized (this.b)
              {
                this.g.reset();
                this.h.reset();
                ??? = new StringBuilder();
                ((StringBuilder)???).append(paramb.b);
                ((StringBuilder)???).append("\n");
                ??? = ((StringBuilder)???).toString();
                this.d.write(((String)???).getBytes());
                this.d.flush();
                synchronized (this.a)
                {
                  this.a.wait(10L);
                  this.d.writeBytes("echo :RET=$?\n");
                  this.d.flush();
                  long l2 = System.nanoTime();
                  long l1 = 0L;
                  long l3 = paramb.c;
                  if (l3 != 0L)
                  {
                    l1 = l3 - (System.nanoTime() - l2) / 1000000L;
                    if (l1 <= 0L) {
                      throw new TimeoutException("t");
                    }
                  }
                  ??? = a(l1);
                  if (??? == null) {
                    continue;
                  }
                  return ???;
                }
              }
            }
            throw new IllegalArgumentException("v");
          }
        }
      }
      finally {}
      int i = 1;
    }
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 98	com/tencent/token/acv:d	Ljava/io/DataOutputStream;
    //   4: ldc 211
    //   6: invokevirtual 180	java/lang/String:getBytes	()[B
    //   9: invokevirtual 183	java/io/DataOutputStream:write	([B)V
    //   12: aload_0
    //   13: getfield 98	com/tencent/token/acv:d	Ljava/io/DataOutputStream;
    //   16: invokevirtual 186	java/io/DataOutputStream:flush	()V
    //   19: aload_0
    //   20: getfield 76	com/tencent/token/acv:c	Ljava/lang/Process;
    //   23: ldc2_w 212
    //   26: invokevirtual 82	java/lang/Object:wait	(J)V
    //   29: aload_0
    //   30: getfield 109	com/tencent/token/acv:e	Lcom/tencent/token/acv$a;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull +12 -> 47
    //   38: aload_1
    //   39: invokevirtual 216	java/lang/Thread:interrupt	()V
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 109	com/tencent/token/acv:e	Lcom/tencent/token/acv$a;
    //   47: aload_0
    //   48: getfield 115	com/tencent/token/acv:f	Lcom/tencent/token/acv$a;
    //   51: astore_1
    //   52: aload_1
    //   53: ifnull +12 -> 65
    //   56: aload_1
    //   57: invokevirtual 216	java/lang/Thread:interrupt	()V
    //   60: aload_0
    //   61: aconst_null
    //   62: putfield 115	com/tencent/token/acv:f	Lcom/tencent/token/acv$a;
    //   65: aload_0
    //   66: getfield 76	com/tencent/token/acv:c	Ljava/lang/Process;
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull +12 -> 83
    //   74: aload_1
    //   75: invokevirtual 219	java/lang/Process:destroy	()V
    //   78: aload_0
    //   79: aconst_null
    //   80: putfield 76	com/tencent/token/acv:c	Ljava/lang/Process;
    //   83: return
    //   84: astore_1
    //   85: goto -56 -> 29
    //   88: astore_1
    //   89: goto -11 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	acv
    //   33	42	1	localObject1	Object
    //   84	1	1	localException	Exception
    //   88	1	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	29	84	java/lang/Exception
    //   74	78	88	finally
  }
  
  public final void finalize()
  {
    try
    {
      a();
      label4:
      super.finalize();
      return;
    }
    finally
    {
      break label4;
    }
  }
  
  public final class a
    extends Thread
  {
    public InputStream a;
    public ByteArrayOutputStream b;
    
    public a(String paramString, InputStream paramInputStream, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      super();
      this.a = paramInputStream;
      this.b = paramByteArrayOutputStream;
    }
    
    public final void run()
    {
      try
      {
        ??? = new byte[1024];
        int i;
        do
        {
          i = this.a.read((byte[])???);
          if (i < 0) {
            synchronized (acv.this.b)
            {
              byte[] arrayOfByte = ":RET=EOF".getBytes();
              this.b.write(arrayOfByte);
              this.b.flush();
              synchronized (acv.this.a)
              {
                acv.this.a.notifyAll();
                return;
              }
            }
          }
        } while (i <= 0);
        synchronized (acv.this.b)
        {
          for (;;)
          {
            this.b.write((byte[])???, 0, i);
            this.b.flush();
            synchronized (acv.this.a)
            {
              acv.this.a.notifyAll();
            }
          }
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  public static final class b
  {
    public final String a;
    public final String b;
    public final long c;
    
    public b(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = 5000L;
    }
  }
  
  public static final class c
  {
    public final String a;
    public final String b;
    
    public c(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acv
 * JD-Core Version:    0.7.0.1
 */