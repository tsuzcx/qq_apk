package androidx.core.net;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;

class DatagramSocketWrapper
  extends Socket
{
  DatagramSocketWrapper(DatagramSocket paramDatagramSocket, FileDescriptor paramFileDescriptor)
    throws SocketException
  {
    super(new DatagramSocketImplWrapper(paramDatagramSocket, paramFileDescriptor));
  }
  
  static class DatagramSocketImplWrapper
    extends SocketImpl
  {
    DatagramSocketImplWrapper(DatagramSocket paramDatagramSocket, FileDescriptor paramFileDescriptor)
    {
      this.localport = paramDatagramSocket.getLocalPort();
      this.fd = paramFileDescriptor;
    }
    
    protected void accept(SocketImpl paramSocketImpl)
      throws IOException
    {
      throw new UnsupportedOperationException();
    }
    
    protected int available()
      throws IOException
    {
      throw new UnsupportedOperationException();
    }
    
    protected void bind(InetAddress paramInetAddress, int paramInt)
      throws IOException
    {
      throw new UnsupportedOperationException();
    }
    
    protected void close()
      throws IOException
    {
      throw new UnsupportedOperationException();
    }
    
    protected void connect(String paramString, int paramInt)
      throws IOException
    {
      throw new UnsupportedOperationException();
    }
    
    protected void connect(InetAddress paramInetAddress, int paramInt)
      throws IOException
    {
      throw new UnsupportedOperationException();
    }
    
    protected void connect(SocketAddress paramSocketAddress, int paramInt)
      throws IOException
    {
      throw new UnsupportedOperationException();
    }
    
    protected void create(boolean paramBoolean)
      throws IOException
    {
      throw new UnsupportedOperationException();
    }
    
    protected InputStream getInputStream()
      throws IOException
    {
      throw new UnsupportedOperationException();
    }
    
    public Object getOption(int paramInt)
      throws SocketException
    {
      throw new UnsupportedOperationException();
    }
    
    protected OutputStream getOutputStream()
      throws IOException
    {
      throw new UnsupportedOperationException();
    }
    
    protected void listen(int paramInt)
      throws IOException
    {
      throw new UnsupportedOperationException();
    }
    
    protected void sendUrgentData(int paramInt)
      throws IOException
    {
      throw new UnsupportedOperationException();
    }
    
    public void setOption(int paramInt, Object paramObject)
      throws SocketException
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.net.DatagramSocketWrapper
 * JD-Core Version:    0.7.0.1
 */