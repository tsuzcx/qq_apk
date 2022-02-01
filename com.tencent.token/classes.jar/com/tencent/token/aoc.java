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

public final class aoc
{
  static final Logger a = Logger.getLogger(aoc.class.getName());
  
  public static anu a(aoi paramaoi)
  {
    return new aod(paramaoi);
  }
  
  public static anv a(aoj paramaoj)
  {
    return new aoe(paramaoj);
  }
  
  public static aoi a(final Socket paramSocket)
  {
    if (paramSocket != null)
    {
      if (paramSocket.getOutputStream() != null)
      {
        anr localanr = c(paramSocket);
        paramSocket = paramSocket.getOutputStream();
        if (paramSocket != null) {
          new anr.1(localanr, new aoi()
          {
            public final aok a()
            {
              return aoc.this;
            }
            
            public final void a_(ant paramAnonymousant, long paramAnonymousLong)
            {
              aol.a(paramAnonymousant.b, 0L, paramAnonymousLong);
              while (paramAnonymousLong > 0L)
              {
                aoc.this.f();
                aof localaof = paramAnonymousant.a;
                int i = (int)Math.min(paramAnonymousLong, localaof.c - localaof.b);
                paramSocket.write(localaof.a, localaof.b, i);
                localaof.b += i;
                long l2 = i;
                long l1 = paramAnonymousLong - l2;
                paramAnonymousant.b -= l2;
                paramAnonymousLong = l1;
                if (localaof.b == localaof.c)
                {
                  paramAnonymousant.a = localaof.b();
                  aog.a(localaof);
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
  
  public static aoj a(InputStream paramInputStream)
  {
    return a(paramInputStream, new aok());
  }
  
  private static aoj a(final InputStream paramInputStream, aok paramaok)
  {
    if (paramInputStream != null)
    {
      if (paramaok != null) {
        new aoj()
        {
          public final long a(ant paramAnonymousant, long paramAnonymousLong)
          {
            if (paramAnonymousLong >= 0L)
            {
              if (paramAnonymousLong == 0L) {
                return 0L;
              }
              try
              {
                aoc.this.f();
                aof localaof = paramAnonymousant.e(1);
                int i = (int)Math.min(paramAnonymousLong, 8192 - localaof.c);
                i = paramInputStream.read(localaof.a, localaof.c, i);
                if (i == -1) {
                  return -1L;
                }
                localaof.c += i;
                paramAnonymousLong = paramAnonymousant.b;
                long l = i;
                paramAnonymousant.b = (paramAnonymousLong + l);
                return l;
              }
              catch (AssertionError paramAnonymousant)
              {
                if (aoc.a(paramAnonymousant)) {
                  throw new IOException(paramAnonymousant);
                }
                throw paramAnonymousant;
              }
            }
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramAnonymousLong)));
          }
          
          public final aok a()
          {
            return aoc.this;
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
  
  public static aoj b(Socket paramSocket)
  {
    if (paramSocket != null)
    {
      if (paramSocket.getInputStream() != null)
      {
        anr localanr = c(paramSocket);
        return new anr.2(localanr, a(paramSocket.getInputStream(), localanr));
      }
      throw new IOException("socket's input stream == null");
    }
    throw new IllegalArgumentException("socket == null");
  }
  
  private static anr c(Socket paramSocket)
  {
    new anr()
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
          aoc.this.close();
          return;
        }
        catch (AssertionError localAssertionError)
        {
          if (aoc.a(localAssertionError))
          {
            localLogger = aoc.a;
            localLevel = Level.WARNING;
            localStringBuilder = new StringBuilder("Failed to close timed out socket ");
            localStringBuilder.append(aoc.this);
            localLogger.log(localLevel, localStringBuilder.toString(), localAssertionError);
            return;
          }
          throw localAssertionError;
        }
        catch (Exception localException)
        {
          Logger localLogger = aoc.a;
          Level localLevel = Level.WARNING;
          StringBuilder localStringBuilder = new StringBuilder("Failed to close timed out socket ");
          localStringBuilder.append(aoc.this);
          localLogger.log(localLevel, localStringBuilder.toString(), localException);
        }
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aoc
 * JD-Core Version:    0.7.0.1
 */