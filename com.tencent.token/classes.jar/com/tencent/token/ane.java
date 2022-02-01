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

public final class ane
{
  static final Logger a = Logger.getLogger(ane.class.getName());
  
  public static amw a(ank paramank)
  {
    return new anf(paramank);
  }
  
  public static amx a(anl paramanl)
  {
    return new ang(paramanl);
  }
  
  public static ank a(final Socket paramSocket)
  {
    if (paramSocket != null)
    {
      if (paramSocket.getOutputStream() != null)
      {
        amt localamt = c(paramSocket);
        paramSocket = paramSocket.getOutputStream();
        if (paramSocket != null) {
          new amt.1(localamt, new ank()
          {
            public final anm a()
            {
              return ane.this;
            }
            
            public final void a_(amv paramAnonymousamv, long paramAnonymousLong)
            {
              ann.a(paramAnonymousamv.b, 0L, paramAnonymousLong);
              while (paramAnonymousLong > 0L)
              {
                ane.this.f();
                anh localanh = paramAnonymousamv.a;
                int i = (int)Math.min(paramAnonymousLong, localanh.c - localanh.b);
                paramSocket.write(localanh.a, localanh.b, i);
                localanh.b += i;
                long l2 = i;
                long l1 = paramAnonymousLong - l2;
                paramAnonymousamv.b -= l2;
                paramAnonymousLong = l1;
                if (localanh.b == localanh.c)
                {
                  paramAnonymousamv.a = localanh.b();
                  ani.a(localanh);
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
  
  public static anl a(InputStream paramInputStream)
  {
    return a(paramInputStream, new anm());
  }
  
  private static anl a(final InputStream paramInputStream, anm paramanm)
  {
    if (paramInputStream != null)
    {
      if (paramanm != null) {
        new anl()
        {
          public final long a(amv paramAnonymousamv, long paramAnonymousLong)
          {
            if (paramAnonymousLong >= 0L)
            {
              if (paramAnonymousLong == 0L) {
                return 0L;
              }
              try
              {
                ane.this.f();
                anh localanh = paramAnonymousamv.e(1);
                int i = (int)Math.min(paramAnonymousLong, 8192 - localanh.c);
                i = paramInputStream.read(localanh.a, localanh.c, i);
                if (i == -1) {
                  return -1L;
                }
                localanh.c += i;
                paramAnonymousLong = paramAnonymousamv.b;
                long l = i;
                paramAnonymousamv.b = (paramAnonymousLong + l);
                return l;
              }
              catch (AssertionError paramAnonymousamv)
              {
                if (ane.a(paramAnonymousamv)) {
                  throw new IOException(paramAnonymousamv);
                }
                throw paramAnonymousamv;
              }
            }
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramAnonymousLong)));
          }
          
          public final anm a()
          {
            return ane.this;
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
  
  public static anl b(Socket paramSocket)
  {
    if (paramSocket != null)
    {
      if (paramSocket.getInputStream() != null)
      {
        amt localamt = c(paramSocket);
        return new amt.2(localamt, a(paramSocket.getInputStream(), localamt));
      }
      throw new IOException("socket's input stream == null");
    }
    throw new IllegalArgumentException("socket == null");
  }
  
  private static amt c(Socket paramSocket)
  {
    new amt()
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
          ane.this.close();
          return;
        }
        catch (AssertionError localAssertionError)
        {
          if (ane.a(localAssertionError))
          {
            localLogger = ane.a;
            localLevel = Level.WARNING;
            localStringBuilder = new StringBuilder("Failed to close timed out socket ");
            localStringBuilder.append(ane.this);
            localLogger.log(localLevel, localStringBuilder.toString(), localAssertionError);
            return;
          }
          throw localAssertionError;
        }
        catch (Exception localException)
        {
          Logger localLogger = ane.a;
          Level localLevel = Level.WARNING;
          StringBuilder localStringBuilder = new StringBuilder("Failed to close timed out socket ");
          localStringBuilder.append(ane.this);
          localLogger.log(localLevel, localStringBuilder.toString(), localException);
        }
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ane
 * JD-Core Version:    0.7.0.1
 */