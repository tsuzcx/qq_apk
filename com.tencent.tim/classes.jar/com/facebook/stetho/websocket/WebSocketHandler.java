package com.facebook.stetho.websocket;

import android.util.Base64;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.http.HttpHandler;
import com.facebook.stetho.server.http.LightHttpBody;
import com.facebook.stetho.server.http.LightHttpMessage;
import com.facebook.stetho.server.http.LightHttpRequest;
import com.facebook.stetho.server.http.LightHttpResponse;
import com.facebook.stetho.server.http.LightHttpServer;
import com.facebook.stetho.server.http.LightHttpServer.HttpMessageWriter;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nullable;

public class WebSocketHandler
  implements HttpHandler
{
  private static final String HEADER_CONNECTION = "Connection";
  private static final String HEADER_CONNECTION_UPGRADE = "Upgrade";
  private static final String HEADER_SEC_WEBSOCKET_ACCEPT = "Sec-WebSocket-Accept";
  private static final String HEADER_SEC_WEBSOCKET_KEY = "Sec-WebSocket-Key";
  private static final String HEADER_SEC_WEBSOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
  private static final String HEADER_SEC_WEBSOCKET_VERSION = "Sec-WebSocket-Version";
  private static final String HEADER_SEC_WEBSOCKET_VERSION_13 = "13";
  private static final String HEADER_UPGRADE = "Upgrade";
  private static final String HEADER_UPGRADE_WEBSOCKET = "websocket";
  private static final String SERVER_KEY_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
  private final SimpleEndpoint mEndpoint;
  
  public WebSocketHandler(SimpleEndpoint paramSimpleEndpoint)
  {
    this.mEndpoint = paramSimpleEndpoint;
  }
  
  private void doUpgrade(SocketLike paramSocketLike, LightHttpRequest paramLightHttpRequest, LightHttpResponse paramLightHttpResponse)
    throws IOException
  {
    paramLightHttpResponse.code = 101;
    paramLightHttpResponse.reasonPhrase = "Switching Protocols";
    paramLightHttpResponse.addHeader("Upgrade", "websocket");
    paramLightHttpResponse.addHeader("Connection", "Upgrade");
    paramLightHttpResponse.body = null;
    paramLightHttpRequest = getFirstHeaderValue(paramLightHttpRequest, "Sec-WebSocket-Key");
    if (paramLightHttpRequest != null) {
      paramLightHttpResponse.addHeader("Sec-WebSocket-Accept", generateServerKey(paramLightHttpRequest));
    }
    paramLightHttpRequest = paramSocketLike.getInput();
    paramSocketLike = paramSocketLike.getOutput();
    LightHttpServer.writeResponseMessage(paramLightHttpResponse, new LightHttpServer.HttpMessageWriter(new BufferedOutputStream(paramSocketLike)));
    new WebSocketSession(paramLightHttpRequest, paramSocketLike, this.mEndpoint).handle();
  }
  
  private static String generateServerKey(String paramString)
  {
    try
    {
      paramString = paramString + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(Utf8Charset.encodeUTF8(paramString));
      paramString = Base64.encodeToString(localMessageDigest.digest(), 2);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  @Nullable
  private static String getFirstHeaderValue(LightHttpMessage paramLightHttpMessage, String paramString)
  {
    return paramLightHttpMessage.getFirstHeaderValue(paramString);
  }
  
  private static boolean isSupportableUpgradeRequest(LightHttpRequest paramLightHttpRequest)
  {
    return ("websocket".equalsIgnoreCase(getFirstHeaderValue(paramLightHttpRequest, "Upgrade"))) && ("Upgrade".equals(getFirstHeaderValue(paramLightHttpRequest, "Connection"))) && ("13".equals(getFirstHeaderValue(paramLightHttpRequest, "Sec-WebSocket-Version")));
  }
  
  public boolean handleRequest(SocketLike paramSocketLike, LightHttpRequest paramLightHttpRequest, LightHttpResponse paramLightHttpResponse)
    throws IOException
  {
    if (!isSupportableUpgradeRequest(paramLightHttpRequest))
    {
      paramLightHttpResponse.code = 501;
      paramLightHttpResponse.reasonPhrase = "Not Implemented";
      paramLightHttpResponse.body = LightHttpBody.create("Not a supported WebSocket upgrade request\n", "text/plain");
      return true;
    }
    doUpgrade(paramSocketLike, paramLightHttpRequest, paramLightHttpResponse);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.websocket.WebSocketHandler
 * JD-Core Version:    0.7.0.1
 */