import com.tencent.mobileqq.service.HttpNotify;
import org.apache.http.HttpServerConnection;
import org.apache.http.protocol.HttpRequestHandlerRegistry;
import org.apache.http.protocol.HttpService;

public class ede
  extends Thread
{
  private HttpNotify jdField_a_of_type_ComTencentMobileqqServiceHttpNotify = null;
  private edd jdField_a_of_type_Edd = null;
  private final HttpServerConnection jdField_a_of_type_OrgApacheHttpHttpServerConnection;
  private HttpRequestHandlerRegistry jdField_a_of_type_OrgApacheHttpProtocolHttpRequestHandlerRegistry = null;
  private final HttpService jdField_a_of_type_OrgApacheHttpProtocolHttpService;
  
  public ede(HttpService paramHttpService, HttpServerConnection paramHttpServerConnection, HttpNotify paramHttpNotify, HttpRequestHandlerRegistry paramHttpRequestHandlerRegistry, edd paramedd)
  {
    this.jdField_a_of_type_OrgApacheHttpProtocolHttpService = paramHttpService;
    this.jdField_a_of_type_OrgApacheHttpHttpServerConnection = paramHttpServerConnection;
    this.jdField_a_of_type_ComTencentMobileqqServiceHttpNotify = paramHttpNotify;
    this.jdField_a_of_type_Edd = paramedd;
    this.jdField_a_of_type_OrgApacheHttpProtocolHttpRequestHandlerRegistry = paramHttpRequestHandlerRegistry;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 33	org/apache/http/protocol/BasicHttpContext
    //   3: dup
    //   4: aconst_null
    //   5: invokespecial 36	org/apache/http/protocol/BasicHttpContext:<init>	(Lorg/apache/http/protocol/HttpContext;)V
    //   8: astore_1
    //   9: aload_1
    //   10: ldc 38
    //   12: aload_0
    //   13: getfield 17	ede:jdField_a_of_type_ComTencentMobileqqServiceHttpNotify	Lcom/tencent/mobileqq/service/HttpNotify;
    //   16: invokeinterface 44 3 0
    //   21: aload_0
    //   22: getfield 19	ede:jdField_a_of_type_Edd	Ledd;
    //   25: invokevirtual 50	edd:c	()Z
    //   28: ifeq +89 -> 117
    //   31: invokestatic 53	java/lang/Thread:interrupted	()Z
    //   34: ifne +83 -> 117
    //   37: aload_0
    //   38: getfield 25	ede:jdField_a_of_type_OrgApacheHttpHttpServerConnection	Lorg/apache/http/HttpServerConnection;
    //   41: invokeinterface 58 1 0
    //   46: ifeq +71 -> 117
    //   49: aload_0
    //   50: getfield 23	ede:jdField_a_of_type_OrgApacheHttpProtocolHttpService	Lorg/apache/http/protocol/HttpService;
    //   53: aload_0
    //   54: getfield 25	ede:jdField_a_of_type_OrgApacheHttpHttpServerConnection	Lorg/apache/http/HttpServerConnection;
    //   57: aload_1
    //   58: invokevirtual 64	org/apache/http/protocol/HttpService:handleRequest	(Lorg/apache/http/HttpServerConnection;Lorg/apache/http/protocol/HttpContext;)V
    //   61: goto -40 -> 21
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 21	ede:jdField_a_of_type_OrgApacheHttpProtocolHttpRequestHandlerRegistry	Lorg/apache/http/protocol/HttpRequestHandlerRegistry;
    //   69: ifnull +30 -> 99
    //   72: aload_0
    //   73: getfield 21	ede:jdField_a_of_type_OrgApacheHttpProtocolHttpRequestHandlerRegistry	Lorg/apache/http/protocol/HttpRequestHandlerRegistry;
    //   76: ldc 66
    //   78: invokevirtual 72	org/apache/http/protocol/HttpRequestHandlerRegistry:lookup	(Ljava/lang/String;)Lorg/apache/http/protocol/HttpRequestHandler;
    //   81: ifnull +18 -> 99
    //   84: aload_0
    //   85: getfield 21	ede:jdField_a_of_type_OrgApacheHttpProtocolHttpRequestHandlerRegistry	Lorg/apache/http/protocol/HttpRequestHandlerRegistry;
    //   88: ldc 66
    //   90: invokevirtual 72	org/apache/http/protocol/HttpRequestHandlerRegistry:lookup	(Ljava/lang/String;)Lorg/apache/http/protocol/HttpRequestHandler;
    //   93: checkcast 74	com/tencent/mobileqq/service/HttpRequestWifiphotoHandler
    //   96: invokevirtual 76	com/tencent/mobileqq/service/HttpRequestWifiphotoHandler:a	()V
    //   99: aload_0
    //   100: getfield 19	ede:jdField_a_of_type_Edd	Ledd;
    //   103: aload_0
    //   104: invokevirtual 79	edd:a	(Ljava/lang/Thread;)V
    //   107: aload_0
    //   108: getfield 25	ede:jdField_a_of_type_OrgApacheHttpHttpServerConnection	Lorg/apache/http/HttpServerConnection;
    //   111: invokeinterface 82 1 0
    //   116: return
    //   117: aload_0
    //   118: getfield 21	ede:jdField_a_of_type_OrgApacheHttpProtocolHttpRequestHandlerRegistry	Lorg/apache/http/protocol/HttpRequestHandlerRegistry;
    //   121: ifnull +30 -> 151
    //   124: aload_0
    //   125: getfield 21	ede:jdField_a_of_type_OrgApacheHttpProtocolHttpRequestHandlerRegistry	Lorg/apache/http/protocol/HttpRequestHandlerRegistry;
    //   128: ldc 66
    //   130: invokevirtual 72	org/apache/http/protocol/HttpRequestHandlerRegistry:lookup	(Ljava/lang/String;)Lorg/apache/http/protocol/HttpRequestHandler;
    //   133: ifnull +18 -> 151
    //   136: aload_0
    //   137: getfield 21	ede:jdField_a_of_type_OrgApacheHttpProtocolHttpRequestHandlerRegistry	Lorg/apache/http/protocol/HttpRequestHandlerRegistry;
    //   140: ldc 66
    //   142: invokevirtual 72	org/apache/http/protocol/HttpRequestHandlerRegistry:lookup	(Ljava/lang/String;)Lorg/apache/http/protocol/HttpRequestHandler;
    //   145: checkcast 74	com/tencent/mobileqq/service/HttpRequestWifiphotoHandler
    //   148: invokevirtual 76	com/tencent/mobileqq/service/HttpRequestWifiphotoHandler:a	()V
    //   151: aload_0
    //   152: getfield 19	ede:jdField_a_of_type_Edd	Ledd;
    //   155: aload_0
    //   156: invokevirtual 79	edd:a	(Ljava/lang/Thread;)V
    //   159: aload_0
    //   160: getfield 25	ede:jdField_a_of_type_OrgApacheHttpHttpServerConnection	Lorg/apache/http/HttpServerConnection;
    //   163: invokeinterface 82 1 0
    //   168: return
    //   169: astore_1
    //   170: return
    //   171: astore_1
    //   172: aload_0
    //   173: getfield 21	ede:jdField_a_of_type_OrgApacheHttpProtocolHttpRequestHandlerRegistry	Lorg/apache/http/protocol/HttpRequestHandlerRegistry;
    //   176: ifnull +30 -> 206
    //   179: aload_0
    //   180: getfield 21	ede:jdField_a_of_type_OrgApacheHttpProtocolHttpRequestHandlerRegistry	Lorg/apache/http/protocol/HttpRequestHandlerRegistry;
    //   183: ldc 66
    //   185: invokevirtual 72	org/apache/http/protocol/HttpRequestHandlerRegistry:lookup	(Ljava/lang/String;)Lorg/apache/http/protocol/HttpRequestHandler;
    //   188: ifnull +18 -> 206
    //   191: aload_0
    //   192: getfield 21	ede:jdField_a_of_type_OrgApacheHttpProtocolHttpRequestHandlerRegistry	Lorg/apache/http/protocol/HttpRequestHandlerRegistry;
    //   195: ldc 66
    //   197: invokevirtual 72	org/apache/http/protocol/HttpRequestHandlerRegistry:lookup	(Ljava/lang/String;)Lorg/apache/http/protocol/HttpRequestHandler;
    //   200: checkcast 74	com/tencent/mobileqq/service/HttpRequestWifiphotoHandler
    //   203: invokevirtual 76	com/tencent/mobileqq/service/HttpRequestWifiphotoHandler:a	()V
    //   206: aload_0
    //   207: getfield 19	ede:jdField_a_of_type_Edd	Ledd;
    //   210: aload_0
    //   211: invokevirtual 79	edd:a	(Ljava/lang/Thread;)V
    //   214: aload_0
    //   215: getfield 25	ede:jdField_a_of_type_OrgApacheHttpHttpServerConnection	Lorg/apache/http/HttpServerConnection;
    //   218: invokeinterface 82 1 0
    //   223: aload_1
    //   224: athrow
    //   225: astore_2
    //   226: goto -3 -> 223
    //   229: astore_1
    //   230: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	ede
    //   8	50	1	localBasicHttpContext	org.apache.http.protocol.BasicHttpContext
    //   64	1	1	localException	java.lang.Exception
    //   169	1	1	localIOException1	java.io.IOException
    //   171	53	1	localObject	java.lang.Object
    //   229	1	1	localIOException2	java.io.IOException
    //   225	1	2	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   21	61	64	java/lang/Exception
    //   159	168	169	java/io/IOException
    //   21	61	171	finally
    //   214	223	225	java/io/IOException
    //   107	116	229	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ede
 * JD-Core Version:    0.7.0.1
 */