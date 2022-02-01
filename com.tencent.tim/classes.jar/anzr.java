import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class anzr
  extends SSLSocketFactory
{
  private final SSLSocketFactory c;
  
  public anzr()
  {
    this.c = HttpsURLConnection.getDefaultSSLSocketFactory();
  }
  
  public anzr(SSLSocketFactory paramSSLSocketFactory)
  {
    this.c = paramSSLSocketFactory;
  }
  
  private Socket b(Socket paramSocket)
  {
    if ((paramSocket instanceof SSLSocket))
    {
      paramSocket = new anzr.b((SSLSocket)paramSocket, null);
      ((anzr.b)paramSocket).setEnabledProtocols(new String[] { "TLSv1.1", "TLSv1.2" });
      return paramSocket;
    }
    return paramSocket;
  }
  
  public Socket createSocket(String paramString, int paramInt)
    throws IOException
  {
    return b(this.c.createSocket(paramString, paramInt));
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException
  {
    return b(this.c.createSocket(paramString, paramInt1, paramInetAddress, paramInt2));
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    return b(this.c.createSocket(paramInetAddress, paramInt));
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    return b(this.c.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2));
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    return b(this.c.createSocket(paramSocket, paramString, paramInt, paramBoolean));
  }
  
  public String[] getDefaultCipherSuites()
  {
    return this.c.getDefaultCipherSuites();
  }
  
  public String[] getSupportedCipherSuites()
  {
    return this.c.getSupportedCipherSuites();
  }
  
  public class a
    extends SSLSocket
  {
    protected final SSLSocket a;
    
    a(SSLSocket paramSSLSocket)
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket = paramSSLSocket;
    }
    
    public void addHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.addHandshakeCompletedListener(paramHandshakeCompletedListener);
    }
    
    public void bind(SocketAddress paramSocketAddress)
      throws IOException
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.bind(paramSocketAddress);
    }
    
    public void close()
      throws IOException
    {
      try
      {
        this.jdField_a_of_type_JavaxNetSslSSLSocket.close();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void connect(SocketAddress paramSocketAddress)
      throws IOException
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.connect(paramSocketAddress);
    }
    
    public void connect(SocketAddress paramSocketAddress, int paramInt)
      throws IOException
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.connect(paramSocketAddress, paramInt);
    }
    
    public boolean equals(Object paramObject)
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.equals(paramObject);
    }
    
    public SocketChannel getChannel()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getChannel();
    }
    
    public boolean getEnableSessionCreation()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getEnableSessionCreation();
    }
    
    public String[] getEnabledCipherSuites()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getEnabledCipherSuites();
    }
    
    public String[] getEnabledProtocols()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getEnabledProtocols();
    }
    
    public InetAddress getInetAddress()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getInetAddress();
    }
    
    public InputStream getInputStream()
      throws IOException
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getInputStream();
    }
    
    public boolean getKeepAlive()
      throws SocketException
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getKeepAlive();
    }
    
    public InetAddress getLocalAddress()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getLocalAddress();
    }
    
    public int getLocalPort()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getLocalPort();
    }
    
    public SocketAddress getLocalSocketAddress()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getLocalSocketAddress();
    }
    
    public boolean getNeedClientAuth()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getNeedClientAuth();
    }
    
    public boolean getOOBInline()
      throws SocketException
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getOOBInline();
    }
    
    public OutputStream getOutputStream()
      throws IOException
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getOutputStream();
    }
    
    public int getPort()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getPort();
    }
    
    public int getReceiveBufferSize()
      throws SocketException
    {
      try
      {
        int i = this.jdField_a_of_type_JavaxNetSslSSLSocket.getReceiveBufferSize();
        return i;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public SocketAddress getRemoteSocketAddress()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getRemoteSocketAddress();
    }
    
    public boolean getReuseAddress()
      throws SocketException
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getReuseAddress();
    }
    
    public int getSendBufferSize()
      throws SocketException
    {
      try
      {
        int i = this.jdField_a_of_type_JavaxNetSslSSLSocket.getSendBufferSize();
        return i;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public SSLSession getSession()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getSession();
    }
    
    public int getSoLinger()
      throws SocketException
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getSoLinger();
    }
    
    public int getSoTimeout()
      throws SocketException
    {
      try
      {
        int i = this.jdField_a_of_type_JavaxNetSslSSLSocket.getSoTimeout();
        return i;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public String[] getSupportedCipherSuites()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getSupportedCipherSuites();
    }
    
    public String[] getSupportedProtocols()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getSupportedProtocols();
    }
    
    public boolean getTcpNoDelay()
      throws SocketException
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getTcpNoDelay();
    }
    
    public int getTrafficClass()
      throws SocketException
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getTrafficClass();
    }
    
    public boolean getUseClientMode()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getUseClientMode();
    }
    
    public boolean getWantClientAuth()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.getWantClientAuth();
    }
    
    public boolean isBound()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.isBound();
    }
    
    public boolean isClosed()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.isClosed();
    }
    
    public boolean isConnected()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.isConnected();
    }
    
    public boolean isInputShutdown()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.isInputShutdown();
    }
    
    public boolean isOutputShutdown()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.isOutputShutdown();
    }
    
    public void removeHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.removeHandshakeCompletedListener(paramHandshakeCompletedListener);
    }
    
    public void sendUrgentData(int paramInt)
      throws IOException
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.sendUrgentData(paramInt);
    }
    
    public void setEnableSessionCreation(boolean paramBoolean)
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.setEnableSessionCreation(paramBoolean);
    }
    
    public void setEnabledCipherSuites(String[] paramArrayOfString)
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.setEnabledCipherSuites(paramArrayOfString);
    }
    
    public void setEnabledProtocols(String[] paramArrayOfString)
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.setEnabledProtocols(paramArrayOfString);
    }
    
    public void setKeepAlive(boolean paramBoolean)
      throws SocketException
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.setKeepAlive(paramBoolean);
    }
    
    public void setNeedClientAuth(boolean paramBoolean)
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.setNeedClientAuth(paramBoolean);
    }
    
    public void setOOBInline(boolean paramBoolean)
      throws SocketException
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.setOOBInline(paramBoolean);
    }
    
    public void setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
    }
    
    public void setReceiveBufferSize(int paramInt)
      throws SocketException
    {
      try
      {
        this.jdField_a_of_type_JavaxNetSslSSLSocket.setReceiveBufferSize(paramInt);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void setReuseAddress(boolean paramBoolean)
      throws SocketException
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.setReuseAddress(paramBoolean);
    }
    
    public void setSendBufferSize(int paramInt)
      throws SocketException
    {
      try
      {
        this.jdField_a_of_type_JavaxNetSslSSLSocket.setSendBufferSize(paramInt);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void setSoLinger(boolean paramBoolean, int paramInt)
      throws SocketException
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.setSoLinger(paramBoolean, paramInt);
    }
    
    public void setSoTimeout(int paramInt)
      throws SocketException
    {
      try
      {
        this.jdField_a_of_type_JavaxNetSslSSLSocket.setSoTimeout(paramInt);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void setTcpNoDelay(boolean paramBoolean)
      throws SocketException
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.setTcpNoDelay(paramBoolean);
    }
    
    public void setTrafficClass(int paramInt)
      throws SocketException
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.setTrafficClass(paramInt);
    }
    
    public void setUseClientMode(boolean paramBoolean)
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.setUseClientMode(paramBoolean);
    }
    
    public void setWantClientAuth(boolean paramBoolean)
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.setWantClientAuth(paramBoolean);
    }
    
    public void shutdownInput()
      throws IOException
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.shutdownInput();
    }
    
    public void shutdownOutput()
      throws IOException
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.shutdownOutput();
    }
    
    public void startHandshake()
      throws IOException
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.startHandshake();
    }
    
    public String toString()
    {
      return this.jdField_a_of_type_JavaxNetSslSSLSocket.toString();
    }
  }
  
  class b
    extends anzr.a
  {
    private b(SSLSocket paramSSLSocket)
    {
      super(paramSSLSocket);
    }
    
    public void setEnabledProtocols(String[] paramArrayOfString)
    {
      String[] arrayOfString = paramArrayOfString;
      if (paramArrayOfString != null)
      {
        arrayOfString = paramArrayOfString;
        if (paramArrayOfString.length == 1)
        {
          arrayOfString = paramArrayOfString;
          if ("SSLv3".equals(paramArrayOfString[0]))
          {
            paramArrayOfString = new ArrayList(Arrays.asList(this.jdField_a_of_type_JavaxNetSslSSLSocket.getEnabledProtocols()));
            if (paramArrayOfString.size() <= 1) {
              break label101;
            }
            paramArrayOfString.remove("SSLv3");
            QLog.i("setEnabledProtocols", 1, "Removed SSLv3 from enabled protocols");
          }
        }
      }
      for (;;)
      {
        arrayOfString = (String[])paramArrayOfString.toArray(new String[paramArrayOfString.size()]);
        if (arrayOfString != null) {
          super.setEnabledProtocols(arrayOfString);
        }
        return;
        label101:
        QLog.i("setEnabledProtocols", 1, "SSL stuck with protocol available for " + String.valueOf(paramArrayOfString));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anzr
 * JD-Core Version:    0.7.0.1
 */