package com.tencent.token;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class ali
{
  static final Logger a = Logger.getLogger(ali.class.getName());
  
  public static ala a(alo paramalo)
  {
    return new alj(paramalo);
  }
  
  public static alb a(alp paramalp)
  {
    return new alk(paramalp);
  }
  
  public static alo a(final Socket paramSocket)
  {
    if (paramSocket != null)
    {
      if (paramSocket.getOutputStream() != null)
      {
        akx localakx = c(paramSocket);
        paramSocket = paramSocket.getOutputStream();
        if (paramSocket != null) {
          new akx.1(localakx, new alo()
          {
            public final alq a()
            {
              return ali.this;
            }
            
            public final void a_(akz paramAnonymousakz, long paramAnonymousLong)
            {
              alr.a(paramAnonymousakz.b, 0L, paramAnonymousLong);
              while (paramAnonymousLong > 0L)
              {
                ali.this.f();
                all localall = paramAnonymousakz.a;
                int i = (int)Math.min(paramAnonymousLong, localall.c - localall.b);
                paramSocket.write(localall.a, localall.b, i);
                localall.b += i;
                long l2 = i;
                long l1 = paramAnonymousLong - l2;
                paramAnonymousakz.b -= l2;
                paramAnonymousLong = l1;
                if (localall.b == localall.c)
                {
                  paramAnonymousakz.a = localall.b();
                  alm.a(localall);
                  paramAnonymousLong = l1;
                }
              }
            }
            
            public final void close()
            {
              paramSocket.close();
            }
            
            public final void flush()
            {
              paramSocket.flush();
            }
            
            public final String toString()
            {
              StringBuilder localStringBuilder = new StringBuilder("sink(");
              localStringBuilder.append(paramSocket);
              localStringBuilder.append(")");
              return localStringBuilder.toString();
            }
          });
        }
        throw new IllegalArgumentException("out == null");
      }
      throw new IOException("socket's output stream == null");
    }
    throw new IllegalArgumentException("socket == null");
  }
  
  public static alp a(InputStream paramInputStream)
  {
    return a(paramInputStream, new alq());
  }
  
  private static alp a(final InputStream paramInputStream, alq paramalq)
  {
    if (paramInputStream != null)
    {
      if (paramalq != null) {
        new alp()
        {
          public final long a(akz paramAnonymousakz, long paramAnonymousLong)
          {
            if (paramAnonymousLong >= 0L)
            {
              if (paramAnonymousLong == 0L) {
                return 0L;
              }
              try
              {
                ali.this.f();
                all localall = paramAnonymousakz.e(1);
                int i = (int)Math.min(paramAnonymousLong, 8192 - localall.c);
                i = paramInputStream.read(localall.a, localall.c, i);
                if (i == -1) {
                  return -1L;
                }
                localall.c += i;
                paramAnonymousLong = paramAnonymousakz.b;
                long l = i;
                paramAnonymousakz.b = (paramAnonymousLong + l);
                return l;
              }
              catch (AssertionError paramAnonymousakz)
              {
                if (ali.a(paramAnonymousakz)) {
                  throw new IOException(paramAnonymousakz);
                }
                throw paramAnonymousakz;
              }
            }
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramAnonymousLong)));
          }
          
          public final alq a()
          {
            return ali.this;
          }
          
          public final void close()
          {
            paramInputStream.close();
          }
          
          public final String toString()
          {
            StringBuilder localStringBuilder = new StringBuilder("source(");
            localStringBuilder.append(paramInputStream);
            localStringBuilder.append(")");
            return localStringBuilder.toString();
          }
        };
      }
      throw new IllegalArgumentException("timeout == null");
    }
    throw new IllegalArgumentException("in == null");
  }
  
  static boolean a(AssertionError paramAssertionError)
  {
    return (paramAssertionError.getCause() != null) && (paramAssertionError.getMessage() != null) && (paramAssertionError.getMessage().contains("getsockname failed"));
  }
  
  public static alp b(Socket paramSocket)
  {
    if (paramSocket != null)
    {
      if (paramSocket.getInputStream() != null)
      {
        akx localakx = c(paramSocket);
        return new akx.2(localakx, a(paramSocket.getInputStream(), localakx));
      }
      throw new IOException("socket's input stream == null");
    }
    throw new IllegalArgumentException("socket == null");
  }
  
  private static akx c(Socket paramSocket)
  {
    new akx()
    {
      protected final IOException a(@Nullable IOException paramAnonymousIOException)
      {
        SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
        if (paramAnonymousIOException != null) {
          localSocketTimeoutException.initCause(paramAnonymousIOException);
        }
        return localSocketTimeoutException;
      }
      
      protected final void a()
      {
        try
        {
          ali.this.close();
          return;
        }
        catch (AssertionError localAssertionError)
        {
          if (ali.a(localAssertionError))
          {
            localLogger = ali.a;
            localLevel = Level.WARNING;
            localStringBuilder = new StringBuilder("Failed to close timed out socket ");
            localStringBuilder.append(ali.this);
            localLogger.log(localLevel, localStringBuilder.toString(), localAssertionError);
            return;
          }
          throw localAssertionError;
        }
        catch (Exception localException)
        {
          Logger localLogger = ali.a;
          Level localLevel = Level.WARNING;
          StringBuilder localStringBuilder = new StringBuilder("Failed to close timed out socket ");
          localStringBuilder.append(ali.this);
          localLogger.log(localLevel, localStringBuilder.toString(), localException);
        }
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ali
 * JD-Core Version:    0.7.0.1
 */