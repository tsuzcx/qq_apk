package com.facebook.stetho.inspector.helper;

import com.facebook.stetho.common.LogRedirector;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.DisconnectReceiver;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.PendingRequestCallback;
import java.nio.channels.NotYetConnectedException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class ChromePeerManager
{
  private static final String TAG = "ChromePeerManager";
  @GuardedBy("this")
  private PeerRegistrationListener mListener;
  @GuardedBy("this")
  private final Map<JsonRpcPeer, DisconnectReceiver> mReceivingPeers = new HashMap();
  @GuardedBy("this")
  private JsonRpcPeer[] mReceivingPeersSnapshot;
  
  private JsonRpcPeer[] getReceivingPeersSnapshot()
  {
    try
    {
      if (this.mReceivingPeersSnapshot == null) {
        this.mReceivingPeersSnapshot = ((JsonRpcPeer[])this.mReceivingPeers.keySet().toArray(new JsonRpcPeer[this.mReceivingPeers.size()]));
      }
      JsonRpcPeer[] arrayOfJsonRpcPeer = this.mReceivingPeersSnapshot;
      return arrayOfJsonRpcPeer;
    }
    finally {}
  }
  
  private void sendMessageToPeers(String paramString, Object paramObject, @Nullable PendingRequestCallback paramPendingRequestCallback)
  {
    JsonRpcPeer[] arrayOfJsonRpcPeer = getReceivingPeersSnapshot();
    int j = arrayOfJsonRpcPeer.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        JsonRpcPeer localJsonRpcPeer = arrayOfJsonRpcPeer[i];
        try
        {
          localJsonRpcPeer.invokeMethod(paramString, paramObject, paramPendingRequestCallback);
          i += 1;
        }
        catch (NotYetConnectedException localNotYetConnectedException)
        {
          for (;;)
          {
            LogRedirector.e("ChromePeerManager", "Error delivering data to Chrome", localNotYetConnectedException);
          }
        }
      }
    }
  }
  
  /* Error */
  public boolean addPeer(JsonRpcPeer paramJsonRpcPeer)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/facebook/stetho/inspector/helper/ChromePeerManager:mReceivingPeers	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 79 2 0
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq +9 -> 23
    //   17: iconst_0
    //   18: istore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_2
    //   22: ireturn
    //   23: new 6	com/facebook/stetho/inspector/helper/ChromePeerManager$UnregisterOnDisconnect
    //   26: dup
    //   27: aload_0
    //   28: aload_1
    //   29: invokespecial 82	com/facebook/stetho/inspector/helper/ChromePeerManager$UnregisterOnDisconnect:<init>	(Lcom/facebook/stetho/inspector/helper/ChromePeerManager;Lcom/facebook/stetho/inspector/jsonrpc/JsonRpcPeer;)V
    //   32: astore_3
    //   33: aload_1
    //   34: aload_3
    //   35: invokevirtual 86	com/facebook/stetho/inspector/jsonrpc/JsonRpcPeer:registerDisconnectReceiver	(Lcom/facebook/stetho/inspector/jsonrpc/DisconnectReceiver;)V
    //   38: aload_0
    //   39: getfield 30	com/facebook/stetho/inspector/helper/ChromePeerManager:mReceivingPeers	Ljava/util/Map;
    //   42: aload_1
    //   43: aload_3
    //   44: invokeinterface 90 3 0
    //   49: pop
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 35	com/facebook/stetho/inspector/helper/ChromePeerManager:mReceivingPeersSnapshot	[Lcom/facebook/stetho/inspector/jsonrpc/JsonRpcPeer;
    //   55: aload_0
    //   56: getfield 92	com/facebook/stetho/inspector/helper/ChromePeerManager:mListener	Lcom/facebook/stetho/inspector/helper/PeerRegistrationListener;
    //   59: ifnull +13 -> 72
    //   62: aload_0
    //   63: getfield 92	com/facebook/stetho/inspector/helper/ChromePeerManager:mListener	Lcom/facebook/stetho/inspector/helper/PeerRegistrationListener;
    //   66: aload_1
    //   67: invokeinterface 98 2 0
    //   72: iconst_1
    //   73: istore_2
    //   74: goto -55 -> 19
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	ChromePeerManager
    //   0	82	1	paramJsonRpcPeer	JsonRpcPeer
    //   12	62	2	bool	boolean
    //   32	12	3	localUnregisterOnDisconnect	UnregisterOnDisconnect
    // Exception table:
    //   from	to	target	type
    //   2	13	77	finally
    //   23	72	77	finally
  }
  
  /* Error */
  public boolean hasRegisteredPeers()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/facebook/stetho/inspector/helper/ChromePeerManager:mReceivingPeers	Ljava/util/Map;
    //   6: invokeinterface 103 1 0
    //   11: istore_1
    //   12: iload_1
    //   13: ifne +9 -> 22
    //   16: iconst_1
    //   17: istore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -6 -> 18
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	ChromePeerManager
    //   11	13	1	bool	boolean
    //   27	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	27	finally
  }
  
  public void invokeMethodOnPeers(String paramString, Object paramObject, PendingRequestCallback paramPendingRequestCallback)
  {
    Util.throwIfNull(paramPendingRequestCallback);
    sendMessageToPeers(paramString, paramObject, paramPendingRequestCallback);
  }
  
  public void removePeer(JsonRpcPeer paramJsonRpcPeer)
  {
    try
    {
      if (this.mReceivingPeers.remove(paramJsonRpcPeer) != null)
      {
        this.mReceivingPeersSnapshot = null;
        if (this.mListener != null) {
          this.mListener.onPeerUnregistered(paramJsonRpcPeer);
        }
      }
      return;
    }
    finally
    {
      paramJsonRpcPeer = finally;
      throw paramJsonRpcPeer;
    }
  }
  
  public void sendNotificationToPeers(String paramString, Object paramObject)
  {
    sendMessageToPeers(paramString, paramObject, null);
  }
  
  public void setListener(PeerRegistrationListener paramPeerRegistrationListener)
  {
    try
    {
      this.mListener = paramPeerRegistrationListener;
      return;
    }
    finally
    {
      paramPeerRegistrationListener = finally;
      throw paramPeerRegistrationListener;
    }
  }
  
  class UnregisterOnDisconnect
    implements DisconnectReceiver
  {
    private final JsonRpcPeer mPeer;
    
    public UnregisterOnDisconnect(JsonRpcPeer paramJsonRpcPeer)
    {
      this.mPeer = paramJsonRpcPeer;
    }
    
    public void onDisconnect()
    {
      ChromePeerManager.this.removePeer(this.mPeer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.helper.ChromePeerManager
 * JD-Core Version:    0.7.0.1
 */