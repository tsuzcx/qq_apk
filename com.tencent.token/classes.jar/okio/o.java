package okio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public final class o
{
  static final Logger a = Logger.getLogger(o.class.getName());
  
  public static h a(x paramx)
  {
    return new s(paramx);
  }
  
  public static i a(y paramy)
  {
    return new t(paramy);
  }
  
  private static x a(OutputStream paramOutputStream, z paramz)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    if (paramz == null) {
      throw new IllegalArgumentException("timeout == null");
    }
    return new p(paramz, paramOutputStream);
  }
  
  public static x a(Socket paramSocket)
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
  
  public static y a(InputStream paramInputStream)
  {
    return a(paramInputStream, new z());
  }
  
  private static y a(InputStream paramInputStream, z paramz)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("in == null");
    }
    if (paramz == null) {
      throw new IllegalArgumentException("timeout == null");
    }
    return new q(paramz, paramInputStream);
  }
  
  static boolean a(AssertionError paramAssertionError)
  {
    return (paramAssertionError.getCause() != null) && (paramAssertionError.getMessage() != null) && (paramAssertionError.getMessage().contains("getsockname failed"));
  }
  
  public static y b(Socket paramSocket)
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
    return new r(paramSocket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.o
 * JD-Core Version:    0.7.0.1
 */