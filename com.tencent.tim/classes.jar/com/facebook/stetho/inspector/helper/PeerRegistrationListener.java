package com.facebook.stetho.inspector.helper;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;

public abstract interface PeerRegistrationListener
{
  public abstract void onPeerRegistered(JsonRpcPeer paramJsonRpcPeer);
  
  public abstract void onPeerUnregistered(JsonRpcPeer paramJsonRpcPeer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.helper.PeerRegistrationListener
 * JD-Core Version:    0.7.0.1
 */