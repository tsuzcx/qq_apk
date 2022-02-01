package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.inspector.jsonrpc.DisconnectReceiver;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import java.util.Map;

final class Runtime$2
  implements DisconnectReceiver
{
  Runtime$2(JsonRpcPeer paramJsonRpcPeer) {}
  
  public void onDisconnect()
  {
    Runtime.access$100().remove(this.val$peer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.protocol.module.Runtime.2
 * JD-Core Version:    0.7.0.1
 */