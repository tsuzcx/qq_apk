package com.facebook.stetho.inspector.jsonrpc;

import android.database.Observable;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcRequest;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.websocket.SimpleSession;
import java.nio.channels.NotYetConnectedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import org.json.JSONObject;

@ThreadSafe
public class JsonRpcPeer
{
  private final DisconnectObservable mDisconnectObservable = new DisconnectObservable(null);
  @GuardedBy("this")
  private long mNextRequestId;
  private final ObjectMapper mObjectMapper;
  private final SimpleSession mPeer;
  @GuardedBy("this")
  private final Map<Long, PendingRequest> mPendingRequests = new HashMap();
  
  public JsonRpcPeer(ObjectMapper paramObjectMapper, SimpleSession paramSimpleSession)
  {
    this.mObjectMapper = paramObjectMapper;
    this.mPeer = ((SimpleSession)Util.throwIfNull(paramSimpleSession));
  }
  
  private long preparePendingRequest(PendingRequestCallback paramPendingRequestCallback)
  {
    try
    {
      long l = this.mNextRequestId;
      this.mNextRequestId = (1L + l);
      this.mPendingRequests.put(Long.valueOf(l), new PendingRequest(l, paramPendingRequestCallback));
      return l;
    }
    finally
    {
      paramPendingRequestCallback = finally;
      throw paramPendingRequestCallback;
    }
  }
  
  public PendingRequest getAndRemovePendingRequest(long paramLong)
  {
    try
    {
      PendingRequest localPendingRequest = (PendingRequest)this.mPendingRequests.remove(Long.valueOf(paramLong));
      return localPendingRequest;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public SimpleSession getWebSocket()
  {
    return this.mPeer;
  }
  
  public void invokeDisconnectReceivers()
  {
    this.mDisconnectObservable.onDisconnect();
  }
  
  public void invokeMethod(String paramString, Object paramObject, @Nullable PendingRequestCallback paramPendingRequestCallback)
    throws NotYetConnectedException
  {
    Util.throwIfNull(paramString);
    if (paramPendingRequestCallback != null) {}
    for (paramPendingRequestCallback = Long.valueOf(preparePendingRequest(paramPendingRequestCallback));; paramPendingRequestCallback = null)
    {
      paramString = new JsonRpcRequest(paramPendingRequestCallback, paramString, (JSONObject)this.mObjectMapper.convertValue(paramObject, JSONObject.class));
      paramString = ((JSONObject)this.mObjectMapper.convertValue(paramString, JSONObject.class)).toString();
      this.mPeer.sendText(paramString);
      return;
    }
  }
  
  public void registerDisconnectReceiver(DisconnectReceiver paramDisconnectReceiver)
  {
    this.mDisconnectObservable.registerObserver(paramDisconnectReceiver);
  }
  
  public void unregisterDisconnectReceiver(DisconnectReceiver paramDisconnectReceiver)
  {
    this.mDisconnectObservable.unregisterObserver(paramDisconnectReceiver);
  }
  
  static class DisconnectObservable
    extends Observable<DisconnectReceiver>
  {
    public void onDisconnect()
    {
      int j = this.mObservers.size();
      int i = 0;
      while (i < j)
      {
        ((DisconnectReceiver)this.mObservers.get(i)).onDisconnect();
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer
 * JD-Core Version:    0.7.0.1
 */