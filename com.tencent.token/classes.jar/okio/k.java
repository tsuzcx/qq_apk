package okio;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class k
{
  static final Logger a = Logger.getLogger(k.class.getName());
  
  public static d a(p paramp)
  {
    return new l(paramp);
  }
  
  public static e a(q paramq)
  {
    return new m(paramq);
  }
  
  private static p a(final OutputStream paramOutputStream, r paramr)
  {
    if (paramOutputStream != null)
    {
      if (paramr != null) {
        new p()
        {
          public r a()
          {
            return k.this;
          }
          
          public void a_(c paramAnonymousc, long paramAnonymousLong)
          {
            s.a(paramAnonymousc.b, 0L, paramAnonymousLong);
            while (paramAnonymousLong > 0L)
            {
              k.this.g();
              n localn = paramAnonymousc.a;
              int i = (int)Math.min(paramAnonymousLong, localn.c - localn.b);
              paramOutputStream.write(localn.a, localn.b, i);
              localn.b += i;
              long l2 = i;
              long l1 = paramAnonymousLong - l2;
              paramAnonymousc.b -= l2;
              paramAnonymousLong = l1;
              if (localn.b == localn.c)
              {
                paramAnonymousc.a = localn.b();
                o.a(localn);
                paramAnonymousLong = l1;
              }
            }
          }
          
          public void close()
          {
            paramOutputStream.close();
          }
          
          public void flush()
          {
            paramOutputStream.flush();
          }
          
          public String toString()
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("sink(");
            localStringBuilder.append(paramOutputStream);
            localStringBuilder.append(")");
            return localStringBuilder.toString();
          }
        };
      }
      throw new IllegalArgumentException("timeout == null");
    }
    throw new IllegalArgumentException("out == null");
  }
  
  public static p a(Socket paramSocket)
  {
    if (paramSocket != null)
    {
      if (paramSocket.getOutputStream() != null)
      {
        a locala = c(paramSocket);
        return locala.a(a(paramSocket.getOutputStream(), locala));
      }
      throw new IOException("socket's output stream == null");
    }
    throw new IllegalArgumentException("socket == null");
  }
  
  public static q a(InputStream paramInputStream)
  {
    return a(paramInputStream, new r());
  }
  
  private static q a(final InputStream paramInputStream, r paramr)
  {
    if (paramInputStream != null)
    {
      if (paramr != null) {
        new q()
        {
          public long a(c paramAnonymousc, long paramAnonymousLong)
          {
            if (paramAnonymousLong >= 0L)
            {
              if (paramAnonymousLong == 0L) {
                return 0L;
              }
              try
              {
                k.this.g();
                n localn = paramAnonymousc.e(1);
                int i = (int)Math.min(paramAnonymousLong, 8192 - localn.c);
                i = paramInputStream.read(localn.a, localn.c, i);
                if (i == -1) {
                  return -1L;
                }
                localn.c += i;
                paramAnonymousLong = paramAnonymousc.b;
                long l = i;
                paramAnonymousc.b = (paramAnonymousLong + l);
                return l;
              }
              catch (AssertionError paramAnonymousc)
              {
                if (k.a(paramAnonymousc)) {
                  throw new IOException(paramAnonymousc);
                }
                throw paramAnonymousc;
              }
            }
            paramAnonymousc = new StringBuilder();
            paramAnonymousc.append("byteCount < 0: ");
            paramAnonymousc.append(paramAnonymousLong);
            throw new IllegalArgumentException(paramAnonymousc.toString());
          }
          
          public r a()
          {
            return k.this;
          }
          
          public void close()
          {
            paramInputStream.close();
          }
          
          public String toString()
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("source(");
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
  
  public static q b(Socket paramSocket)
  {
    if (paramSocket != null)
    {
      if (paramSocket.getInputStream() != null)
      {
        a locala = c(paramSocket);
        return locala.a(a(paramSocket.getInputStream(), locala));
      }
      throw new IOException("socket's input stream == null");
    }
    throw new IllegalArgumentException("socket == null");
  }
  
  private static a c(Socket paramSocket)
  {
    new a()
    {
      protected IOException a(@Nullable IOException paramAnonymousIOException)
      {
        SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
        if (paramAnonymousIOException != null) {
          localSocketTimeoutException.initCause(paramAnonymousIOException);
        }
        return localSocketTimeoutException;
      }
      
      protected void a()
      {
        try
        {
          k.this.close();
          return;
        }
        catch (AssertionError localAssertionError)
        {
          if (k.a(localAssertionError))
          {
            localLogger = k.a;
            localLevel = Level.WARNING;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Failed to close timed out socket ");
            localStringBuilder.append(k.this);
            localLogger.log(localLevel, localStringBuilder.toString(), localAssertionError);
            return;
          }
          throw localAssertionError;
        }
        catch (Exception localException)
        {
          Logger localLogger = k.a;
          Level localLevel = Level.WARNING;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to close timed out socket ");
          localStringBuilder.append(k.this);
          localLogger.log(localLevel, localStringBuilder.toString(), localException);
        }
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.k
 * JD-Core Version:    0.7.0.1
 */