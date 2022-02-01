package com.facebook.stetho.inspector;

import com.facebook.stetho.common.LogRedirector;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.PendingRequest;
import com.facebook.stetho.inspector.jsonrpc.PendingRequestCallback;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcRequest;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcResponse;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.websocket.SimpleEndpoint;
import com.facebook.stetho.websocket.SimpleSession;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ChromeDevtoolsServer
  implements SimpleEndpoint
{
  public static final String PATH = "/inspector";
  private static final String TAG = "ChromeDevtoolsServer";
  private final MethodDispatcher mMethodDispatcher;
  private final ObjectMapper mObjectMapper = new ObjectMapper();
  private final Map<SimpleSession, JsonRpcPeer> mPeers = Collections.synchronizedMap(new HashMap());
  
  public ChromeDevtoolsServer(Iterable<ChromeDevtoolsDomain> paramIterable)
  {
    this.mMethodDispatcher = new MethodDispatcher(this.mObjectMapper, paramIterable);
  }
  
  private void closeSafely(SimpleSession paramSimpleSession, int paramInt, String paramString)
  {
    paramSimpleSession.close(paramInt, paramString);
  }
  
  private void handleRemoteMessage(JsonRpcPeer paramJsonRpcPeer, String paramString)
    throws IOException, MessageHandlingException, JSONException
  {
    JSONObject localJSONObject = new JSONObject(paramString);
    if (localJSONObject.has("method"))
    {
      handleRemoteRequest(paramJsonRpcPeer, localJSONObject);
      return;
    }
    if (localJSONObject.has("result"))
    {
      handleRemoteResponse(paramJsonRpcPeer, localJSONObject);
      return;
    }
    throw new MessageHandlingException("Improper JSON-RPC message: " + paramString);
  }
  
  private void handleRemoteRequest(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
    throws MessageHandlingException
  {
    JsonRpcRequest localJsonRpcRequest = (JsonRpcRequest)this.mObjectMapper.convertValue(paramJSONObject, JsonRpcRequest.class);
    try
    {
      localJSONObject = this.mMethodDispatcher.dispatch(paramJsonRpcPeer, localJsonRpcRequest.method, localJsonRpcRequest.params);
      paramJSONObject = null;
    }
    catch (JsonRpcException paramJSONObject)
    {
      try
      {
        paramJSONObject = paramJSONObject.toString();
        paramJsonRpcPeer.getWebSocket().sendText(paramJSONObject);
        return;
        paramJSONObject = paramJSONObject;
        logDispatchException(paramJSONObject);
        paramJSONObject = (JSONObject)this.mObjectMapper.convertValue(paramJSONObject.getErrorMessage(), JSONObject.class);
        JSONObject localJSONObject = null;
      }
      catch (OutOfMemoryError paramJSONObject)
      {
        for (;;)
        {
          JsonRpcResponse localJsonRpcResponse;
          localJsonRpcResponse.result = null;
          localJsonRpcResponse.error = ((JSONObject)this.mObjectMapper.convertValue(paramJSONObject.getMessage(), JSONObject.class));
          paramJSONObject = ((JSONObject)this.mObjectMapper.convertValue(localJsonRpcResponse, JSONObject.class)).toString();
        }
      }
    }
    if (localJsonRpcRequest.id != null)
    {
      localJsonRpcResponse = new JsonRpcResponse();
      localJsonRpcResponse.id = localJsonRpcRequest.id.longValue();
      localJsonRpcResponse.result = localJSONObject;
      localJsonRpcResponse.error = paramJSONObject;
      paramJSONObject = (JSONObject)this.mObjectMapper.convertValue(localJsonRpcResponse, JSONObject.class);
    }
  }
  
  private void handleRemoteResponse(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
    throws MismatchedResponseException
  {
    paramJSONObject = (JsonRpcResponse)this.mObjectMapper.convertValue(paramJSONObject, JsonRpcResponse.class);
    PendingRequest localPendingRequest = paramJsonRpcPeer.getAndRemovePendingRequest(paramJSONObject.id);
    if (localPendingRequest == null) {
      throw new MismatchedResponseException(paramJSONObject.id);
    }
    if (localPendingRequest.callback != null) {
      localPendingRequest.callback.onResponse(paramJsonRpcPeer, paramJSONObject);
    }
  }
  
  private static void logDispatchException(JsonRpcException paramJsonRpcException)
  {
    JsonRpcError localJsonRpcError = paramJsonRpcException.getErrorMessage();
    switch (ChromeDevtoolsServer.1.$SwitchMap$com$facebook$stetho$inspector$jsonrpc$protocol$JsonRpcError$ErrorCode[localJsonRpcError.code.ordinal()])
    {
    default: 
      LogRedirector.w("ChromeDevtoolsServer", "Error processing remote message", paramJsonRpcException);
      return;
    }
    LogRedirector.d("ChromeDevtoolsServer", "Method not implemented: " + localJsonRpcError.message);
  }
  
  public void onClose(SimpleSession paramSimpleSession, int paramInt, String paramString)
  {
    LogRedirector.d("ChromeDevtoolsServer", "onClose: reason=" + paramInt + " " + paramString);
    paramSimpleSession = (JsonRpcPeer)this.mPeers.remove(paramSimpleSession);
    if (paramSimpleSession != null) {
      paramSimpleSession.invokeDisconnectReceivers();
    }
  }
  
  public void onError(SimpleSession paramSimpleSession, Throwable paramThrowable)
  {
    LogRedirector.e("ChromeDevtoolsServer", "onError: ex=" + paramThrowable.toString());
  }
  
  public void onMessage(SimpleSession paramSimpleSession, String paramString)
  {
    if (LogRedirector.isLoggable("ChromeDevtoolsServer", 2)) {
      LogRedirector.v("ChromeDevtoolsServer", "onMessage: message=" + paramString);
    }
    try
    {
      JsonRpcPeer localJsonRpcPeer = (JsonRpcPeer)this.mPeers.get(paramSimpleSession);
      Util.throwIfNull(localJsonRpcPeer);
      handleRemoteMessage(localJsonRpcPeer, paramString);
      return;
    }
    catch (IOException paramString)
    {
      if (LogRedirector.isLoggable("ChromeDevtoolsServer", 2)) {
        LogRedirector.v("ChromeDevtoolsServer", "Unexpected I/O exception processing message: " + paramString);
      }
      closeSafely(paramSimpleSession, 1011, paramString.getClass().getSimpleName());
      return;
    }
    catch (MessageHandlingException paramString)
    {
      LogRedirector.i("ChromeDevtoolsServer", "Message could not be processed by implementation: " + paramString);
      closeSafely(paramSimpleSession, 1011, paramString.getClass().getSimpleName());
      return;
    }
    catch (JSONException paramString)
    {
      LogRedirector.v("ChromeDevtoolsServer", "Unexpected JSON exception processing message", paramString);
      closeSafely(paramSimpleSession, 1011, paramString.getClass().getSimpleName());
    }
  }
  
  public void onMessage(SimpleSession paramSimpleSession, byte[] paramArrayOfByte, int paramInt)
  {
    LogRedirector.d("ChromeDevtoolsServer", "Ignoring binary message of length " + paramInt);
  }
  
  public void onOpen(SimpleSession paramSimpleSession)
  {
    LogRedirector.d("ChromeDevtoolsServer", "onOpen");
    this.mPeers.put(paramSimpleSession, new JsonRpcPeer(this.mObjectMapper, paramSimpleSession));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.ChromeDevtoolsServer
 * JD-Core Version:    0.7.0.1
 */