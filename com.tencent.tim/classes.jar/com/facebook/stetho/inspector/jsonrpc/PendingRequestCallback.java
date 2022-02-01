package com.facebook.stetho.inspector.jsonrpc;

import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcResponse;

public abstract interface PendingRequestCallback
{
  public abstract void onResponse(JsonRpcPeer paramJsonRpcPeer, JsonRpcResponse paramJsonRpcResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.jsonrpc.PendingRequestCallback
 * JD-Core Version:    0.7.0.1
 */