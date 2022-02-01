import com.tencent.mobileqq.service.HttpNotify;
import org.apache.http.HttpServerConnection;
import org.apache.http.protocol.HttpService;

public class gin
  extends Thread
{
  private HttpNotify jdField_a_of_type_ComTencentMobileqqServiceHttpNotify = null;
  private gim jdField_a_of_type_Gim = null;
  private final HttpServerConnection jdField_a_of_type_OrgApacheHttpHttpServerConnection;
  private final HttpService jdField_a_of_type_OrgApacheHttpProtocolHttpService;
  
  public gin(HttpService paramHttpService, HttpServerConnection paramHttpServerConnection, HttpNotify paramHttpNotify, gim paramgim)
  {
    this.jdField_a_of_type_OrgApacheHttpProtocolHttpService = paramHttpService;
    this.jdField_a_of_type_OrgApacheHttpHttpServerConnection = paramHttpServerConnection;
    this.jdField_a_of_type_ComTencentMobileqqServiceHttpNotify = paramHttpNotify;
    this.jdField_a_of_type_Gim = paramgim;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 30	org/apache/http/protocol/BasicHttpContext
    //   3: dup
    //   4: aconst_null
    //   5: invokespecial 33	org/apache/http/protocol/BasicHttpContext:<init>	(Lorg/apache/http/protocol/HttpContext;)V
    //   8: astore_1
    //   9: aload_1
    //   10: ldc 35
    //   12: aload_0
    //   13: getfield 16	gin:jdField_a_of_type_ComTencentMobileqqServiceHttpNotify	Lcom/tencent/mobileqq/service/HttpNotify;
    //   16: invokeinterface 41 3 0
    //   21: aload_0
    //   22: getfield 18	gin:jdField_a_of_type_Gim	Lgim;
    //   25: invokevirtual 47	gim:c	()Z
    //   28: ifeq +55 -> 83
    //   31: invokestatic 50	java/lang/Thread:interrupted	()Z
    //   34: ifne +49 -> 83
    //   37: aload_0
    //   38: getfield 22	gin:jdField_a_of_type_OrgApacheHttpHttpServerConnection	Lorg/apache/http/HttpServerConnection;
    //   41: invokeinterface 55 1 0
    //   46: ifeq +37 -> 83
    //   49: aload_0
    //   50: getfield 20	gin:jdField_a_of_type_OrgApacheHttpProtocolHttpService	Lorg/apache/http/protocol/HttpService;
    //   53: aload_0
    //   54: getfield 22	gin:jdField_a_of_type_OrgApacheHttpHttpServerConnection	Lorg/apache/http/HttpServerConnection;
    //   57: aload_1
    //   58: invokevirtual 61	org/apache/http/protocol/HttpService:handleRequest	(Lorg/apache/http/HttpServerConnection;Lorg/apache/http/protocol/HttpContext;)V
    //   61: goto -40 -> 21
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 18	gin:jdField_a_of_type_Gim	Lgim;
    //   69: aload_0
    //   70: invokevirtual 64	gim:a	(Ljava/lang/Thread;)V
    //   73: aload_0
    //   74: getfield 22	gin:jdField_a_of_type_OrgApacheHttpHttpServerConnection	Lorg/apache/http/HttpServerConnection;
    //   77: invokeinterface 67 1 0
    //   82: return
    //   83: aload_0
    //   84: getfield 18	gin:jdField_a_of_type_Gim	Lgim;
    //   87: aload_0
    //   88: invokevirtual 64	gim:a	(Ljava/lang/Thread;)V
    //   91: aload_0
    //   92: getfield 22	gin:jdField_a_of_type_OrgApacheHttpHttpServerConnection	Lorg/apache/http/HttpServerConnection;
    //   95: invokeinterface 67 1 0
    //   100: return
    //   101: astore_1
    //   102: return
    //   103: astore_1
    //   104: aload_0
    //   105: getfield 18	gin:jdField_a_of_type_Gim	Lgim;
    //   108: aload_0
    //   109: invokevirtual 64	gim:a	(Ljava/lang/Thread;)V
    //   112: aload_0
    //   113: getfield 22	gin:jdField_a_of_type_OrgApacheHttpHttpServerConnection	Lorg/apache/http/HttpServerConnection;
    //   116: invokeinterface 67 1 0
    //   121: aload_1
    //   122: athrow
    //   123: astore_2
    //   124: goto -3 -> 121
    //   127: astore_1
    //   128: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	gin
    //   8	50	1	localBasicHttpContext	org.apache.http.protocol.BasicHttpContext
    //   64	1	1	localException	java.lang.Exception
    //   101	1	1	localIOException1	java.io.IOException
    //   103	19	1	localObject	java.lang.Object
    //   127	1	1	localIOException2	java.io.IOException
    //   123	1	2	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   21	61	64	java/lang/Exception
    //   91	100	101	java/io/IOException
    //   21	61	103	finally
    //   112	121	123	java/io/IOException
    //   73	82	127	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gin
 * JD-Core Version:    0.7.0.1
 */