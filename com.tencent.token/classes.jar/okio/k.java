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
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    if (paramr == null) {
      throw new IllegalArgumentException("timeout == null");
    }
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
          long l = paramAnonymousLong - i;
          paramAnonymousc.b -= i;
          paramAnonymousLong = l;
          if (localn.b == localn.c)
          {
            paramAnonymousc.a = localn.b();
            o.a(localn);
            paramAnonymousLong = l;
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
        return "sink(" + paramOutputStream + ")";
      }
    };
  }
  
  public static p a(Socket paramSocket)
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("socket == null");
    }
    if (paramSocket.getOutputStream() == null) {
      throw new IOException("socket's output stream == null");
    }
    a locala = c(paramSocket);
    return locala.a(a(paramSocket.getOutputStream(), locala));
  }
  
  public static q a(InputStream paramInputStream)
  {
    return a(paramInputStream, new r());
  }
  
  private static q a(final InputStream paramInputStream, r paramr)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("in == null");
    }
    if (paramr == null) {
      throw new IllegalArgumentException("timeout == null");
    }
    new q()
    {
      public long a(c paramAnonymousc, long paramAnonymousLong)
      {
        if (paramAnonymousLong < 0L) {
          throw new IllegalArgumentException("byteCount < 0: " + paramAnonymousLong);
        }
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
          paramAnonymousc.b += i;
          return i;
        }
        catch (AssertionError paramAnonymousc)
        {
          if (k.a(paramAnonymousc)) {
            throw new IOException(paramAnonymousc);
          }
          throw paramAnonymousc;
        }
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
        return "source(" + paramInputStream + ")";
      }
    };
  }
  
  static boolean a(AssertionError paramAssertionError)
  {
    return (paramAssertionError.getCause() != null) && (paramAssertionError.getMessage() != null) && (paramAssertionError.getMessage().contains("getsockname failed"));
  }
  
  public static q b(Socket paramSocket)
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("socket == null");
    }
    if (paramSocket.getInputStream() == null) {
      throw new IOException("socket's input stream == null");
    }
    a locala = c(paramSocket);
    return locala.a(a(paramSocket.getInputStream(), locala));
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
        catch (Exception localException)
        {
          k.a.log(Level.WARNING, "Failed to close timed out socket " + k.this, localException);
          return;
        }
        catch (AssertionError localAssertionError)
        {
          if (k.a(localAssertionError))
          {
            k.a.log(Level.WARNING, "Failed to close timed out socket " + k.this, localAssertionError);
            return;
          }
          throw localAssertionError;
        }
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.k
 * JD-Core Version:    0.7.0.1
 */