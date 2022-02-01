package com.facebook.stetho.inspector.network;

import com.facebook.stetho.inspector.helper.PeersRegisteredListener;

class NetworkPeerManager$1
  extends PeersRegisteredListener
{
  NetworkPeerManager$1(NetworkPeerManager paramNetworkPeerManager) {}
  
  public void onFirstPeerRegistered()
  {
    
    if ((NetworkPeerManager.access$000(this.this$0) == null) && (NetworkPeerManager.access$100(this.this$0) != null))
    {
      NetworkPeerManager.access$002(this.this$0, new AsyncPrettyPrinterRegistry());
      NetworkPeerManager.access$100(this.this$0).populatePrettyPrinters(NetworkPeerManager.access$000(this.this$0));
    }
    NetworkPeerManager.access$200(this.this$0).cleanupFiles();
  }
  
  public void onLastPeerUnregistered()
  {
    NetworkPeerManager.access$200(this.this$0).cleanupFiles();
    AsyncPrettyPrinterExecutorHolder.shutdown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.network.NetworkPeerManager.1
 * JD-Core Version:    0.7.0.1
 */