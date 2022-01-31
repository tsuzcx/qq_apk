import com.dataline.util.DBNetworkUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.HttpNotify;
import com.tencent.mobileqq.service.HttpRequestWifiphotoHandler;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import org.apache.http.HttpServerConnection;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.impl.DefaultHttpServerConnection;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpRequestHandlerRegistry;
import org.apache.http.protocol.HttpService;
import org.apache.http.protocol.ResponseConnControl;
import org.apache.http.protocol.ResponseContent;
import org.apache.http.protocol.ResponseDate;
import org.apache.http.protocol.ResponseServer;

public class edj
  extends Thread
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HttpNotify jdField_a_of_type_ComTencentMobileqqServiceHttpNotify = null;
  private String jdField_a_of_type_JavaLangString;
  private ServerSocket jdField_a_of_type_JavaNetServerSocket;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HttpParams jdField_a_of_type_OrgApacheHttpParamsHttpParams;
  private boolean jdField_a_of_type_Boolean = false;
  
  public edj(String paramString, HttpNotify paramHttpNotify, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceHttpNotify = paramHttpNotify;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private String a()
  {
    return DBNetworkUtil.b();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaNetServerSocket != null) {
      return this.jdField_a_of_type_JavaNetServerSocket.getLocalPort();
    }
    return 0;
  }
  
  public InetAddress a()
  {
    try
    {
      InetAddress localInetAddress = InetAddress.getByName(a());
      return localInetAddress;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      localUnknownHostException.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    try
    {
      this.jdField_a_of_type_JavaNetServerSocket.close();
      label12:
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((Thread)this.jdField_a_of_type_JavaUtilArrayList.get(i)).interrupt();
        i += 1;
      }
      interrupt();
      this.jdField_a_of_type_JavaNetServerSocket = null;
      return;
    }
    catch (Exception localException)
    {
      break label12;
    }
  }
  
  public void a(Thread paramThread)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramThread);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.isEmpty();
  }
  
  public boolean b()
  {
    try
    {
      this.jdField_a_of_type_JavaNetServerSocket = new ServerSocket(0, 20);
      if (this.jdField_a_of_type_JavaNetServerSocket.isClosed())
      {
        this.jdField_a_of_type_Boolean = false;
        return false;
      }
      this.jdField_a_of_type_OrgApacheHttpParamsHttpParams = new BasicHttpParams();
      this.jdField_a_of_type_OrgApacheHttpParamsHttpParams.setIntParameter("http.socket.timeout", 30000).setIntParameter("http.socket.buffer-size", 8192).setBooleanParameter("http.connection.stalecheck", false).setBooleanParameter("http.tcp.nodelay", true).setParameter("http.origin-server", "HttpComponents/1.1");
      start();
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_Boolean = false;
    }
    return false;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaNetServerSocket != null) && (!this.jdField_a_of_type_JavaNetServerSocket.isClosed());
  }
  
  public void run()
  {
    for (;;)
    {
      if (!Thread.interrupted()) {}
      label43:
      do
      {
        try
        {
          if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaNetServerSocket != null))
          {
            boolean bool = this.jdField_a_of_type_JavaNetServerSocket.isClosed();
            if (!bool) {
              break label43;
            }
          }
        }
        catch (InterruptedIOException localInterruptedIOException)
        {
          for (;;)
          {
            Object localObject2;
            Object localObject1;
            BasicHttpProcessor localBasicHttpProcessor;
            HttpRequestHandlerRegistry localHttpRequestHandlerRegistry;
            this.jdField_a_of_type_JavaNetServerSocket = null;
            this.jdField_a_of_type_Boolean = false;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            this.jdField_a_of_type_JavaNetServerSocket = null;
            this.jdField_a_of_type_Boolean = false;
            System.err.println("I/O error initialising connection thread: " + localIOException.getMessage());
          }
        }
        this.jdField_a_of_type_JavaNetServerSocket = null;
        this.jdField_a_of_type_Boolean = false;
        return;
        localObject2 = this.jdField_a_of_type_JavaNetServerSocket.accept();
      } while ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaNetServerSocket == null) || (this.jdField_a_of_type_JavaNetServerSocket.isClosed()) || (Thread.interrupted()));
      localObject1 = new DefaultHttpServerConnection();
      ((DefaultHttpServerConnection)localObject1).bind((Socket)localObject2, this.jdField_a_of_type_OrgApacheHttpParamsHttpParams);
      localBasicHttpProcessor = new BasicHttpProcessor();
      localBasicHttpProcessor.addInterceptor(new ResponseDate());
      localBasicHttpProcessor.addInterceptor(new ResponseServer());
      localBasicHttpProcessor.addInterceptor(new ResponseContent());
      localBasicHttpProcessor.addInterceptor(new ResponseConnControl());
      localHttpRequestHandlerRegistry = new HttpRequestHandlerRegistry();
      localHttpRequestHandlerRegistry.register("/wifiphoto*", new HttpRequestWifiphotoHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      localHttpRequestHandlerRegistry.register("*", new edi(this.jdField_a_of_type_JavaLangString, (Socket)localObject2));
      localObject2 = new HttpService(localBasicHttpProcessor, new DefaultConnectionReuseStrategy(), new DefaultHttpResponseFactory());
      ((HttpService)localObject2).setParams(this.jdField_a_of_type_OrgApacheHttpParamsHttpParams);
      ((HttpService)localObject2).setHandlerResolver(localHttpRequestHandlerRegistry);
      localObject1 = new edk((HttpService)localObject2, (HttpServerConnection)localObject1, this.jdField_a_of_type_ComTencentMobileqqServiceHttpNotify, localHttpRequestHandlerRegistry, this);
      ((edk)localObject1).setDaemon(true);
      ((edk)localObject1).start();
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     edj
 * JD-Core Version:    0.7.0.1
 */