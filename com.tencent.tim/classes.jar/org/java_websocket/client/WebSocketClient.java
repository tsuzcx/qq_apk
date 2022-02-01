package org.java_websocket.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLException;
import org.java_websocket.AbstractWebSocket;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeImpl1Client;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;

public abstract class WebSocketClient
  extends AbstractWebSocket
  implements Runnable, WebSocket
{
  private CountDownLatch closeLatch = new CountDownLatch(1);
  private CountDownLatch connectLatch = new CountDownLatch(1);
  private Thread connectReadThread;
  private int connectTimeout = 0;
  private Draft draft;
  private WebSocketImpl engine = null;
  private Map<String, String> headers;
  private OutputStream ostream;
  private Proxy proxy = Proxy.NO_PROXY;
  private Socket socket = null;
  private SocketFactory socketFactory = null;
  protected URI uri = null;
  private Thread writeThread;
  
  public WebSocketClient(URI paramURI)
  {
    this(paramURI, new Draft_6455());
  }
  
  public WebSocketClient(URI paramURI, Map<String, String> paramMap)
  {
    this(paramURI, new Draft_6455(), paramMap);
  }
  
  public WebSocketClient(URI paramURI, Draft paramDraft)
  {
    this(paramURI, paramDraft, null, 0);
  }
  
  public WebSocketClient(URI paramURI, Draft paramDraft, Map<String, String> paramMap)
  {
    this(paramURI, paramDraft, paramMap, 0);
  }
  
  public WebSocketClient(URI paramURI, Draft paramDraft, Map<String, String> paramMap, int paramInt)
  {
    if (paramURI == null) {
      throw new IllegalArgumentException();
    }
    if (paramDraft == null) {
      throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
    this.uri = paramURI;
    this.draft = paramDraft;
    this.headers = paramMap;
    this.connectTimeout = paramInt;
    setTcpNoDelay(false);
    setReuseAddr(false);
    this.engine = new WebSocketImpl(this, paramDraft);
  }
  
  private int getPort()
  {
    int j = this.uri.getPort();
    int i = j;
    String str;
    if (j == -1)
    {
      str = this.uri.getScheme();
      if ("wss".equals(str)) {
        i = 443;
      }
    }
    else
    {
      return i;
    }
    if ("ws".equals(str)) {
      return 80;
    }
    throw new IllegalArgumentException("unknown scheme: " + str);
  }
  
  private void handleIOException(IOException paramIOException)
  {
    if ((paramIOException instanceof SSLException)) {
      onError(paramIOException);
    }
    this.engine.eot();
  }
  
  private void reset()
  {
    Thread localThread = Thread.currentThread();
    if ((localThread == this.writeThread) || (localThread == this.connectReadThread)) {
      throw new IllegalStateException("You cannot initialize a reconnect out of the websocket thread. Use reconnect in another thread to insure a successful cleanup.");
    }
    try
    {
      closeBlocking();
      if (this.writeThread != null)
      {
        this.writeThread.interrupt();
        this.writeThread = null;
      }
      if (this.connectReadThread != null)
      {
        this.connectReadThread.interrupt();
        this.connectReadThread = null;
      }
      this.draft.reset();
      if (this.socket != null)
      {
        this.socket.close();
        this.socket = null;
      }
      this.connectLatch = new CountDownLatch(1);
      this.closeLatch = new CountDownLatch(1);
      this.engine = new WebSocketImpl(this, this.draft);
      return;
    }
    catch (Exception localException)
    {
      onError(localException);
      this.engine.closeConnection(1006, localException.getMessage());
    }
  }
  
  private void sendHandshake()
    throws InvalidHandshakeException
  {
    Object localObject2 = this.uri.getRawPath();
    Object localObject3 = this.uri.getRawQuery();
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = "/";
    }
    localObject2 = localObject1;
    if (localObject3 != null) {
      localObject2 = (String)localObject1 + '?' + (String)localObject3;
    }
    int i = getPort();
    localObject3 = new StringBuilder().append(this.uri.getHost());
    if ((i != 80) && (i != 443)) {}
    for (Object localObject1 = ":" + i;; localObject1 = "")
    {
      localObject3 = (String)localObject1;
      localObject1 = new HandshakeImpl1Client();
      ((HandshakeImpl1Client)localObject1).setResourceDescriptor((String)localObject2);
      ((HandshakeImpl1Client)localObject1).put("Host", (String)localObject3);
      if (this.headers == null) {
        break;
      }
      localObject2 = this.headers.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((HandshakeImpl1Client)localObject1).put((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
      }
    }
    this.engine.startHandshake((ClientHandshakeBuilder)localObject1);
  }
  
  public void close()
  {
    if (this.writeThread != null) {
      this.engine.close(1000);
    }
  }
  
  public void close(int paramInt)
  {
    this.engine.close(paramInt);
  }
  
  public void close(int paramInt, String paramString)
  {
    this.engine.close(paramInt, paramString);
  }
  
  public void closeBlocking()
    throws InterruptedException
  {
    close();
    this.closeLatch.await();
  }
  
  public void closeConnection(int paramInt, String paramString)
  {
    this.engine.closeConnection(paramInt, paramString);
  }
  
  public void connect()
  {
    if (this.connectReadThread != null) {
      throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }
    this.connectReadThread = new Thread(this);
    this.connectReadThread.setName("WebSocketConnectReadThread-" + this.connectReadThread.getId());
    this.connectReadThread.start();
  }
  
  public boolean connectBlocking()
    throws InterruptedException
  {
    connect();
    this.connectLatch.await();
    return this.engine.isOpen();
  }
  
  public boolean connectBlocking(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    connect();
    return (this.connectLatch.await(paramLong, paramTimeUnit)) && (this.engine.isOpen());
  }
  
  public <T> T getAttachment()
  {
    return this.engine.getAttachment();
  }
  
  public WebSocket getConnection()
  {
    return this.engine;
  }
  
  public Collection<WebSocket> getConnections()
  {
    return Collections.singletonList(this.engine);
  }
  
  public Draft getDraft()
  {
    return this.draft;
  }
  
  public InetSocketAddress getLocalSocketAddress()
  {
    return this.engine.getLocalSocketAddress();
  }
  
  public InetSocketAddress getLocalSocketAddress(WebSocket paramWebSocket)
  {
    if (this.socket != null) {
      return (InetSocketAddress)this.socket.getLocalSocketAddress();
    }
    return null;
  }
  
  public ReadyState getReadyState()
  {
    return this.engine.getReadyState();
  }
  
  public InetSocketAddress getRemoteSocketAddress()
  {
    return this.engine.getRemoteSocketAddress();
  }
  
  public InetSocketAddress getRemoteSocketAddress(WebSocket paramWebSocket)
  {
    if (this.socket != null) {
      return (InetSocketAddress)this.socket.getRemoteSocketAddress();
    }
    return null;
  }
  
  public String getResourceDescriptor()
  {
    return this.uri.getPath();
  }
  
  public Socket getSocket()
  {
    return this.socket;
  }
  
  public URI getURI()
  {
    return this.uri;
  }
  
  public boolean hasBufferedData()
  {
    return this.engine.hasBufferedData();
  }
  
  public boolean isClosed()
  {
    return this.engine.isClosed();
  }
  
  public boolean isClosing()
  {
    return this.engine.isClosing();
  }
  
  public boolean isFlushAndClose()
  {
    return this.engine.isFlushAndClose();
  }
  
  public boolean isOpen()
  {
    return this.engine.isOpen();
  }
  
  public abstract void onClose(int paramInt, String paramString, boolean paramBoolean);
  
  public void onCloseInitiated(int paramInt, String paramString) {}
  
  public void onClosing(int paramInt, String paramString, boolean paramBoolean) {}
  
  public abstract void onError(Exception paramException);
  
  public abstract void onMessage(String paramString);
  
  public void onMessage(ByteBuffer paramByteBuffer) {}
  
  public abstract void onOpen(ServerHandshake paramServerHandshake);
  
  public final void onWebsocketClose(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean)
  {
    stopConnectionLostTimer();
    if (this.writeThread != null) {
      this.writeThread.interrupt();
    }
    onClose(paramInt, paramString, paramBoolean);
    this.connectLatch.countDown();
    this.closeLatch.countDown();
  }
  
  public void onWebsocketCloseInitiated(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    onCloseInitiated(paramInt, paramString);
  }
  
  public void onWebsocketClosing(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean)
  {
    onClosing(paramInt, paramString, paramBoolean);
  }
  
  public final void onWebsocketError(WebSocket paramWebSocket, Exception paramException)
  {
    onError(paramException);
  }
  
  public final void onWebsocketMessage(WebSocket paramWebSocket, String paramString)
  {
    onMessage(paramString);
  }
  
  public final void onWebsocketMessage(WebSocket paramWebSocket, ByteBuffer paramByteBuffer)
  {
    onMessage(paramByteBuffer);
  }
  
  public final void onWebsocketOpen(WebSocket paramWebSocket, Handshakedata paramHandshakedata)
  {
    startConnectionLostTimer();
    onOpen((ServerHandshake)paramHandshakedata);
    this.connectLatch.countDown();
  }
  
  public final void onWriteDemand(WebSocket paramWebSocket) {}
  
  public void reconnect()
  {
    reset();
    connect();
  }
  
  public boolean reconnectBlocking()
    throws InterruptedException
  {
    reset();
    return connectBlocking();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 66	org/java_websocket/client/WebSocketClient:socketFactory	Ljavax/net/SocketFactory;
    //   6: ifnull +244 -> 250
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 66	org/java_websocket/client/WebSocketClient:socketFactory	Ljavax/net/SocketFactory;
    //   14: invokevirtual 437	javax/net/SocketFactory:createSocket	()Ljava/net/Socket;
    //   17: putfield 64	org/java_websocket/client/WebSocketClient:socket	Ljava/net/Socket;
    //   20: aload_0
    //   21: getfield 64	org/java_websocket/client/WebSocketClient:socket	Ljava/net/Socket;
    //   24: aload_0
    //   25: invokevirtual 440	org/java_websocket/client/WebSocketClient:isTcpNoDelay	()Z
    //   28: invokevirtual 441	java/net/Socket:setTcpNoDelay	(Z)V
    //   31: aload_0
    //   32: getfield 64	org/java_websocket/client/WebSocketClient:socket	Ljava/net/Socket;
    //   35: aload_0
    //   36: invokevirtual 444	org/java_websocket/client/WebSocketClient:isReuseAddr	()Z
    //   39: invokevirtual 447	java/net/Socket:setReuseAddress	(Z)V
    //   42: aload_0
    //   43: getfield 64	org/java_websocket/client/WebSocketClient:socket	Ljava/net/Socket;
    //   46: invokevirtual 450	java/net/Socket:isBound	()Z
    //   49: ifne +32 -> 81
    //   52: aload_0
    //   53: getfield 64	org/java_websocket/client/WebSocketClient:socket	Ljava/net/Socket;
    //   56: new 348	java/net/InetSocketAddress
    //   59: dup
    //   60: aload_0
    //   61: getfield 60	org/java_websocket/client/WebSocketClient:uri	Ljava/net/URI;
    //   64: invokevirtual 227	java/net/URI:getHost	()Ljava/lang/String;
    //   67: aload_0
    //   68: invokespecial 224	org/java_websocket/client/WebSocketClient:getPort	()I
    //   71: invokespecial 453	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   74: aload_0
    //   75: getfield 84	org/java_websocket/client/WebSocketClient:connectTimeout	I
    //   78: invokevirtual 456	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   81: iload_1
    //   82: ifeq +59 -> 141
    //   85: ldc 139
    //   87: aload_0
    //   88: getfield 60	org/java_websocket/client/WebSocketClient:uri	Ljava/net/URI;
    //   91: invokevirtual 137	java/net/URI:getScheme	()Ljava/lang/String;
    //   94: invokevirtual 145	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifeq +44 -> 141
    //   100: ldc_w 458
    //   103: invokestatic 464	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   106: astore_2
    //   107: aload_2
    //   108: aconst_null
    //   109: aconst_null
    //   110: aconst_null
    //   111: invokevirtual 468	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   114: aload_0
    //   115: aload_2
    //   116: invokevirtual 472	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   119: aload_0
    //   120: getfield 64	org/java_websocket/client/WebSocketClient:socket	Ljava/net/Socket;
    //   123: aload_0
    //   124: getfield 60	org/java_websocket/client/WebSocketClient:uri	Ljava/net/URI;
    //   127: invokevirtual 227	java/net/URI:getHost	()Ljava/lang/String;
    //   130: aload_0
    //   131: invokespecial 224	org/java_websocket/client/WebSocketClient:getPort	()I
    //   134: iconst_1
    //   135: invokevirtual 477	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   138: putfield 64	org/java_websocket/client/WebSocketClient:socket	Ljava/net/Socket;
    //   141: aload_0
    //   142: getfield 64	org/java_websocket/client/WebSocketClient:socket	Ljava/net/Socket;
    //   145: invokevirtual 481	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   148: astore_2
    //   149: aload_0
    //   150: aload_0
    //   151: getfield 64	org/java_websocket/client/WebSocketClient:socket	Ljava/net/Socket;
    //   154: invokevirtual 485	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   157: putfield 125	org/java_websocket/client/WebSocketClient:ostream	Ljava/io/OutputStream;
    //   160: aload_0
    //   161: invokespecial 487	org/java_websocket/client/WebSocketClient:sendHandshake	()V
    //   164: aload_0
    //   165: new 173	java/lang/Thread
    //   168: dup
    //   169: new 10	org/java_websocket/client/WebSocketClient$WebsocketWriteThread
    //   172: dup
    //   173: aload_0
    //   174: aload_0
    //   175: invokespecial 490	org/java_websocket/client/WebSocketClient$WebsocketWriteThread:<init>	(Lorg/java_websocket/client/WebSocketClient;Lorg/java_websocket/client/WebSocketClient;)V
    //   178: invokespecial 297	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   181: putfield 119	org/java_websocket/client/WebSocketClient:writeThread	Ljava/lang/Thread;
    //   184: aload_0
    //   185: getfield 119	org/java_websocket/client/WebSocketClient:writeThread	Ljava/lang/Thread;
    //   188: invokevirtual 312	java/lang/Thread:start	()V
    //   191: sipush 16384
    //   194: newarray byte
    //   196: astore_3
    //   197: aload_0
    //   198: invokevirtual 491	org/java_websocket/client/WebSocketClient:isClosing	()Z
    //   201: ifne +117 -> 318
    //   204: aload_0
    //   205: invokevirtual 492	org/java_websocket/client/WebSocketClient:isClosed	()Z
    //   208: ifne +110 -> 318
    //   211: aload_2
    //   212: aload_3
    //   213: invokevirtual 498	java/io/InputStream:read	([B)I
    //   216: istore_1
    //   217: iload_1
    //   218: iconst_m1
    //   219: if_icmpeq +99 -> 318
    //   222: aload_0
    //   223: getfield 62	org/java_websocket/client/WebSocketClient:engine	Lorg/java_websocket/WebSocketImpl;
    //   226: aload_3
    //   227: iconst_0
    //   228: iload_1
    //   229: invokestatic 504	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   232: invokevirtual 507	org/java_websocket/WebSocketImpl:decode	(Ljava/nio/ByteBuffer;)V
    //   235: goto -38 -> 197
    //   238: astore_2
    //   239: aload_0
    //   240: aload_2
    //   241: invokespecial 115	org/java_websocket/client/WebSocketClient:handleIOException	(Ljava/io/IOException;)V
    //   244: aload_0
    //   245: aconst_null
    //   246: putfield 179	org/java_websocket/client/WebSocketClient:connectReadThread	Ljava/lang/Thread;
    //   249: return
    //   250: aload_0
    //   251: getfield 64	org/java_websocket/client/WebSocketClient:socket	Ljava/net/Socket;
    //   254: ifnonnull +23 -> 277
    //   257: aload_0
    //   258: new 196	java/net/Socket
    //   261: dup
    //   262: aload_0
    //   263: getfield 73	org/java_websocket/client/WebSocketClient:proxy	Ljava/net/Proxy;
    //   266: invokespecial 510	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   269: putfield 64	org/java_websocket/client/WebSocketClient:socket	Ljava/net/Socket;
    //   272: iconst_1
    //   273: istore_1
    //   274: goto -254 -> 20
    //   277: aload_0
    //   278: getfield 64	org/java_websocket/client/WebSocketClient:socket	Ljava/net/Socket;
    //   281: invokevirtual 511	java/net/Socket:isClosed	()Z
    //   284: ifeq -264 -> 20
    //   287: new 430	java/io/IOException
    //   290: dup
    //   291: invokespecial 512	java/io/IOException:<init>	()V
    //   294: athrow
    //   295: astore_2
    //   296: aload_0
    //   297: aload_0
    //   298: getfield 62	org/java_websocket/client/WebSocketClient:engine	Lorg/java_websocket/WebSocketImpl;
    //   301: aload_2
    //   302: invokevirtual 514	org/java_websocket/client/WebSocketClient:onWebsocketError	(Lorg/java_websocket/WebSocket;Ljava/lang/Exception;)V
    //   305: aload_0
    //   306: getfield 62	org/java_websocket/client/WebSocketClient:engine	Lorg/java_websocket/WebSocketImpl;
    //   309: iconst_m1
    //   310: aload_2
    //   311: invokevirtual 202	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   314: invokevirtual 206	org/java_websocket/WebSocketImpl:closeConnection	(ILjava/lang/String;)V
    //   317: return
    //   318: aload_0
    //   319: getfield 62	org/java_websocket/client/WebSocketClient:engine	Lorg/java_websocket/WebSocketImpl;
    //   322: invokevirtual 168	org/java_websocket/WebSocketImpl:eot	()V
    //   325: goto -81 -> 244
    //   328: astore_2
    //   329: aload_0
    //   330: aload_2
    //   331: invokevirtual 165	org/java_websocket/client/WebSocketClient:onError	(Ljava/lang/Exception;)V
    //   334: aload_0
    //   335: getfield 62	org/java_websocket/client/WebSocketClient:engine	Lorg/java_websocket/WebSocketImpl;
    //   338: sipush 1006
    //   341: aload_2
    //   342: invokevirtual 515	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   345: invokevirtual 206	org/java_websocket/WebSocketImpl:closeConnection	(ILjava/lang/String;)V
    //   348: goto -104 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	WebSocketClient
    //   1	273	1	i	int
    //   106	106	2	localObject	Object
    //   238	3	2	localIOException	IOException
    //   295	16	2	localException	Exception
    //   328	14	2	localRuntimeException	java.lang.RuntimeException
    //   196	31	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   197	217	238	java/io/IOException
    //   222	235	238	java/io/IOException
    //   318	325	238	java/io/IOException
    //   2	20	295	java/lang/Exception
    //   20	81	295	java/lang/Exception
    //   85	141	295	java/lang/Exception
    //   141	164	295	java/lang/Exception
    //   250	272	295	java/lang/Exception
    //   277	295	295	java/lang/Exception
    //   197	217	328	java/lang/RuntimeException
    //   222	235	328	java/lang/RuntimeException
    //   318	325	328	java/lang/RuntimeException
  }
  
  public void send(String paramString)
  {
    this.engine.send(paramString);
  }
  
  public void send(ByteBuffer paramByteBuffer)
  {
    this.engine.send(paramByteBuffer);
  }
  
  public void send(byte[] paramArrayOfByte)
  {
    this.engine.send(paramArrayOfByte);
  }
  
  public void sendFragmentedFrame(Opcode paramOpcode, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    this.engine.sendFragmentedFrame(paramOpcode, paramByteBuffer, paramBoolean);
  }
  
  public void sendFrame(Collection<Framedata> paramCollection)
  {
    this.engine.sendFrame(paramCollection);
  }
  
  public void sendFrame(Framedata paramFramedata)
  {
    this.engine.sendFrame(paramFramedata);
  }
  
  public void sendPing()
  {
    this.engine.sendPing();
  }
  
  public <T> void setAttachment(T paramT)
  {
    this.engine.setAttachment(paramT);
  }
  
  public void setProxy(Proxy paramProxy)
  {
    if (paramProxy == null) {
      throw new IllegalArgumentException();
    }
    this.proxy = paramProxy;
  }
  
  @Deprecated
  public void setSocket(Socket paramSocket)
  {
    if (this.socket != null) {
      throw new IllegalStateException("socket has already been set");
    }
    this.socket = paramSocket;
  }
  
  public void setSocketFactory(SocketFactory paramSocketFactory)
  {
    this.socketFactory = paramSocketFactory;
  }
  
  class WebsocketWriteThread
    implements Runnable
  {
    private final WebSocketClient webSocketClient;
    
    WebsocketWriteThread(WebSocketClient paramWebSocketClient)
    {
      this.webSocketClient = paramWebSocketClient;
    }
    
    private void closeSocket()
    {
      try
      {
        if (WebSocketClient.this.socket != null) {
          WebSocketClient.this.socket.close();
        }
        return;
      }
      catch (IOException localIOException)
      {
        WebSocketClient.this.onWebsocketError(this.webSocketClient, localIOException);
      }
    }
    
    private void runWriteData()
      throws IOException
    {
      try
      {
        while (!Thread.interrupted())
        {
          ByteBuffer localByteBuffer1 = (ByteBuffer)WebSocketClient.this.engine.outQueue.take();
          WebSocketClient.this.ostream.write(localByteBuffer1.array(), 0, localByteBuffer1.limit());
          WebSocketClient.this.ostream.flush();
        }
        Iterator localIterator;
        ByteBuffer localByteBuffer2;
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localIterator = WebSocketClient.this.engine.outQueue.iterator();
        while (localIterator.hasNext())
        {
          localByteBuffer2 = (ByteBuffer)localIterator.next();
          WebSocketClient.this.ostream.write(localByteBuffer2.array(), 0, localByteBuffer2.limit());
          WebSocketClient.this.ostream.flush();
        }
        Thread.currentThread().interrupt();
      }
    }
    
    public void run()
    {
      Thread.currentThread().setName("WebSocketWriteThread-" + Thread.currentThread().getId());
      try
      {
        runWriteData();
        return;
      }
      catch (IOException localIOException)
      {
        WebSocketClient.this.handleIOException(localIOException);
        return;
      }
      finally
      {
        closeSocket();
        WebSocketClient.access$102(WebSocketClient.this, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.java_websocket.client.WebSocketClient
 * JD-Core Version:    0.7.0.1
 */