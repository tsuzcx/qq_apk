package com.tencent.android.tpns.mqtt.internal.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WebSocketHandshake
{
  private static final String ACCEPT_SALT = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
  private static final String EMPTY = "";
  private static final String HTTP_HEADER_CONNECTION = "connection";
  private static final String HTTP_HEADER_CONNECTION_VALUE = "upgrade";
  private static final String HTTP_HEADER_SEC_WEBSOCKET_ACCEPT = "sec-websocket-accept";
  private static final String HTTP_HEADER_SEC_WEBSOCKET_PROTOCOL = "sec-websocket-protocol";
  private static final String HTTP_HEADER_UPGRADE = "upgrade";
  private static final String HTTP_HEADER_UPGRADE_WEBSOCKET = "websocket";
  private static final String LINE_SEPARATOR = "\r\n";
  private static final String SHA1_PROTOCOL = "SHA1";
  String host;
  InputStream input;
  OutputStream output;
  int port;
  String uri;
  
  public WebSocketHandshake(InputStream paramInputStream, OutputStream paramOutputStream, String paramString1, String paramString2, int paramInt)
  {
    this.input = paramInputStream;
    this.output = paramOutputStream;
    this.uri = paramString1;
    this.host = paramString2;
    this.port = paramInt;
  }
  
  private Map getHeaders(ArrayList paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int i = 1;
    while (i < paramArrayList.size())
    {
      String[] arrayOfString = ((String)paramArrayList.get(i)).split(":");
      localHashMap.put(arrayOfString[0].toLowerCase(), arrayOfString[1]);
      i += 1;
    }
    return localHashMap;
  }
  
  private void receiveHandshakeResponse(String paramString)
    throws IOException
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(this.input, "UTF-8"));
    ArrayList localArrayList = new ArrayList();
    String str = localBufferedReader.readLine();
    Object localObject = str;
    if (str == null) {
      throw new IOException("WebSocket Response header: Invalid response from Server, It may not support WebSockets.");
    }
    while ((localObject != null) && (!((String)localObject).equals("")))
    {
      localArrayList.add(localObject);
      localObject = localBufferedReader.readLine();
    }
    localObject = getHeaders(localArrayList);
    str = (String)((Map)localObject).get("connection");
    if ((str == null) || (str.equalsIgnoreCase("upgrade"))) {
      throw new IOException("WebSocket Response header: Incorrect connection header");
    }
    str = (String)((Map)localObject).get("upgrade");
    if ((str == null) || (!str.toLowerCase().contains("websocket"))) {
      throw new IOException("WebSocket Response header: Incorrect upgrade.");
    }
    if ((String)((Map)localObject).get("sec-websocket-protocol") == null) {
      throw new IOException("WebSocket Response header: empty sec-websocket-protocol");
    }
    if (!((Map)localObject).containsKey("sec-websocket-accept")) {
      throw new IOException("WebSocket Response header: Missing Sec-WebSocket-Accept");
    }
    try
    {
      verifyWebSocketKey(paramString, (String)((Map)localObject).get("sec-websocket-accept"));
      return;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new IOException(paramString.getMessage());
    }
    catch (HandshakeFailedException paramString)
    {
      throw new IOException("WebSocket Response header: Incorrect Sec-WebSocket-Key");
    }
  }
  
  /* Error */
  private void sendHandshakeRequest(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: ldc 164
    //   2: astore_3
    //   3: new 166	java/net/URI
    //   6: dup
    //   7: aload_0
    //   8: getfield 52	com/tencent/android/tpns/mqtt/internal/websocket/WebSocketHandshake:uri	Ljava/lang/String;
    //   11: invokespecial 167	java/net/URI:<init>	(Ljava/lang/String;)V
    //   14: astore 4
    //   16: aload_3
    //   17: astore_2
    //   18: aload 4
    //   20: invokevirtual 170	java/net/URI:getRawPath	()Ljava/lang/String;
    //   23: ifnull +73 -> 96
    //   26: aload_3
    //   27: astore_2
    //   28: aload 4
    //   30: invokevirtual 170	java/net/URI:getRawPath	()Ljava/lang/String;
    //   33: invokevirtual 174	java/lang/String:isEmpty	()Z
    //   36: ifne +60 -> 96
    //   39: aload 4
    //   41: invokevirtual 170	java/net/URI:getRawPath	()Ljava/lang/String;
    //   44: astore_3
    //   45: aload_3
    //   46: astore_2
    //   47: aload 4
    //   49: invokevirtual 177	java/net/URI:getRawQuery	()Ljava/lang/String;
    //   52: ifnull +44 -> 96
    //   55: aload_3
    //   56: astore_2
    //   57: aload 4
    //   59: invokevirtual 177	java/net/URI:getRawQuery	()Ljava/lang/String;
    //   62: invokevirtual 174	java/lang/String:isEmpty	()Z
    //   65: ifne +31 -> 96
    //   68: new 179	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   75: aload_3
    //   76: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc 186
    //   81: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 4
    //   86: invokevirtual 177	java/net/URI:getRawQuery	()Ljava/lang/String;
    //   89: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: astore_2
    //   96: new 191	java/io/PrintWriter
    //   99: dup
    //   100: aload_0
    //   101: getfield 50	com/tencent/android/tpns/mqtt/internal/websocket/WebSocketHandshake:output	Ljava/io/OutputStream;
    //   104: invokespecial 194	java/io/PrintWriter:<init>	(Ljava/io/OutputStream;)V
    //   107: astore_3
    //   108: aload_3
    //   109: new 179	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   116: ldc 196
    //   118: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_2
    //   122: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 198
    //   127: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 30
    //   132: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokevirtual 201	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   141: aload_0
    //   142: getfield 56	com/tencent/android/tpns/mqtt/internal/websocket/WebSocketHandshake:port	I
    //   145: bipush 80
    //   147: if_icmpeq +160 -> 307
    //   150: aload_0
    //   151: getfield 56	com/tencent/android/tpns/mqtt/internal/websocket/WebSocketHandshake:port	I
    //   154: sipush 443
    //   157: if_icmpeq +150 -> 307
    //   160: aload_3
    //   161: new 179	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   168: ldc 203
    //   170: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_0
    //   174: getfield 54	com/tencent/android/tpns/mqtt/internal/websocket/WebSocketHandshake:host	Ljava/lang/String;
    //   177: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc 76
    //   182: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_0
    //   186: getfield 56	com/tencent/android/tpns/mqtt/internal/websocket/WebSocketHandshake:port	I
    //   189: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: ldc 30
    //   194: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokevirtual 201	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   203: aload_3
    //   204: ldc 208
    //   206: invokevirtual 201	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   209: aload_3
    //   210: ldc 210
    //   212: invokevirtual 201	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   215: aload_3
    //   216: new 179	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   223: ldc 212
    //   225: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_1
    //   229: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc 30
    //   234: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokevirtual 201	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   243: aload_3
    //   244: ldc 214
    //   246: invokevirtual 201	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   249: aload_3
    //   250: ldc 216
    //   252: invokevirtual 201	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   255: aload 4
    //   257: invokevirtual 219	java/net/URI:getUserInfo	()Ljava/lang/String;
    //   260: astore_1
    //   261: aload_1
    //   262: ifnull +34 -> 296
    //   265: aload_3
    //   266: new 179	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   273: ldc 221
    //   275: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_1
    //   279: invokestatic 227	com/tencent/android/tpns/mqtt/internal/websocket/Base64:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   282: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc 30
    //   287: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokevirtual 201	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   296: aload_3
    //   297: ldc 30
    //   299: invokevirtual 201	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   302: aload_3
    //   303: invokevirtual 230	java/io/PrintWriter:flush	()V
    //   306: return
    //   307: aload_3
    //   308: new 179	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   315: ldc 203
    //   317: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_0
    //   321: getfield 54	com/tencent/android/tpns/mqtt/internal/websocket/WebSocketHandshake:host	Ljava/lang/String;
    //   324: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc 30
    //   329: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokevirtual 201	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   338: goto -135 -> 203
    //   341: astore_1
    //   342: new 232	java/lang/IllegalStateException
    //   345: dup
    //   346: aload_1
    //   347: invokevirtual 233	java/net/URISyntaxException:getMessage	()Ljava/lang/String;
    //   350: invokespecial 234	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   353: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	this	WebSocketHandshake
    //   0	354	1	paramString	String
    //   17	105	2	localObject1	Object
    //   2	306	3	localObject2	Object
    //   14	242	4	localURI	java.net.URI
    // Exception table:
    //   from	to	target	type
    //   3	16	341	java/net/URISyntaxException
    //   18	26	341	java/net/URISyntaxException
    //   28	45	341	java/net/URISyntaxException
    //   47	55	341	java/net/URISyntaxException
    //   57	96	341	java/net/URISyntaxException
    //   96	203	341	java/net/URISyntaxException
    //   203	261	341	java/net/URISyntaxException
    //   265	296	341	java/net/URISyntaxException
    //   296	306	341	java/net/URISyntaxException
    //   307	338	341	java/net/URISyntaxException
  }
  
  private byte[] sha1(String paramString)
    throws NoSuchAlgorithmException
  {
    return MessageDigest.getInstance("SHA1").digest(paramString.getBytes());
  }
  
  private void verifyWebSocketKey(String paramString1, String paramString2)
    throws NoSuchAlgorithmException, HandshakeFailedException
  {
    if (!Base64.encodeBytes(sha1(paramString1 + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11")).trim().equals(paramString2.trim())) {
      throw new HandshakeFailedException();
    }
  }
  
  public void execute()
    throws IOException
  {
    Object localObject = new byte[16];
    System.arraycopy("".getBytes(), 0, localObject, 0, 16);
    localObject = Base64.encodeBytes((byte[])localObject);
    sendHandshakeRequest((String)localObject);
    receiveHandshakeResponse((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.websocket.WebSocketHandshake
 * JD-Core Version:    0.7.0.1
 */