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

public final class alh
{
  static final Logger a = Logger.getLogger(alh.class.getName());
  
  public static akz a(aln paramaln)
  {
    return new ali(paramaln);
  }
  
  public static ala a(alo paramalo)
  {
    return new alj(paramalo);
  }
  
  public static aln a(final Socket paramSocket)
  {
    if (paramSocket != null)
    {
      if (paramSocket.getOutputStream() != null)
      {
        akw localakw = c(paramSocket);
        paramSocket = paramSocket.getOutputStream();
        if (paramSocket != null) {
          new akw.1(localakw, new aln()
          {
            public final alp a()
            {
              return alh.this;
            }
            
            public final void a_(aky paramAnonymousaky, long paramAnonymousLong)
            {
              alq.a(paramAnonymousaky.b, 0L, paramAnonymousLong);
              while (paramAnonymousLong > 0L)
              {
                alh.this.f();
                alk localalk = paramAnonymousaky.a;
                int i = (int)Math.min(paramAnonymousLong, localalk.c - localalk.b);
                paramSocket.write(localalk.a, localalk.b, i);
                localalk.b += i;
                long l2 = i;
                long l1 = paramAnonymousLong - l2;
                paramAnonymousaky.b -= l2;
                paramAnonymousLong = l1;
                if (localalk.b == localalk.c)
                {
                  paramAnonymousaky.a = localalk.b();
                  all.a(localalk);
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
  
  public static alo a(InputStream paramInputStream)
  {
    return a(paramInputStream, new alp());
  }
  
  private static alo a(final InputStream paramInputStream, alp paramalp)
  {
    if (paramInputStream != null)
    {
      if (paramalp != null) {
        new alo()
        {
          public final long a(aky paramAnonymousaky, long paramAnonymousLong)
          {
            if (paramAnonymousLong >= 0L)
            {
              if (paramAnonymousLong == 0L) {
                return 0L;
              }
              try
              {
                alh.this.f();
                alk localalk = paramAnonymousaky.e(1);
                int i = (int)Math.min(paramAnonymousLong, 8192 - localalk.c);
                i = paramInputStream.read(localalk.a, localalk.c, i);
                if (i == -1) {
                  return -1L;
                }
                localalk.c += i;
                paramAnonymousLong = paramAnonymousaky.b;
                long l = i;
                paramAnonymousaky.b = (paramAnonymousLong + l);
                return l;
              }
              catch (AssertionError paramAnonymousaky)
              {
                if (alh.a(paramAnonymousaky)) {
                  throw new IOException(paramAnonymousaky);
                }
                throw paramAnonymousaky;
              }
            }
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramAnonymousLong)));
          }
          
          public final alp a()
          {
            return alh.this;
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
  
  public static alo b(Socket paramSocket)
  {
    if (paramSocket != null)
    {
      if (paramSocket.getInputStream() != null)
      {
        akw localakw = c(paramSocket);
        return new akw.2(localakw, a(paramSocket.getInputStream(), localakw));
      }
      throw new IOException("socket's input stream == null");
    }
    throw new IllegalArgumentException("socket == null");
  }
  
  private static akw c(Socket paramSocket)
  {
    new akw()
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
          alh.this.close();
          return;
        }
        catch (AssertionError localAssertionError)
        {
          if (alh.a(localAssertionError))
          {
            localLogger = alh.a;
            localLevel = Level.WARNING;
            localStringBuilder = new StringBuilder("Failed to close timed out socket ");
            localStringBuilder.append(alh.this);
            localLogger.log(localLevel, localStringBuilder.toString(), localAssertionError);
            return;
          }
          throw localAssertionError;
        }
        catch (Exception localException)
        {
          Logger localLogger = alh.a;
          Level localLevel = Level.WARNING;
          StringBuilder localStringBuilder = new StringBuilder("Failed to close timed out socket ");
          localStringBuilder.append(alh.this);
          localLogger.log(localLevel, localStringBuilder.toString(), localException);
        }
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alh
 * JD-Core Version:    0.7.0.1
 */