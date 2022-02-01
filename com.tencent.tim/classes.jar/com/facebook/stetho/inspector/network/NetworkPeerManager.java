package com.facebook.stetho.inspector.network;

import android.content.Context;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import javax.annotation.Nullable;

public class NetworkPeerManager
  extends ChromePeerManager
{
  private static NetworkPeerManager sInstance;
  private AsyncPrettyPrinterRegistry mAsyncPrettyPrinterRegistry;
  private AsyncPrettyPrinterInitializer mPrettyPrinterInitializer;
  private final ResponseBodyFileManager mResponseBodyFileManager;
  private final PeersRegisteredListener mTempFileCleanup = new NetworkPeerManager.1(this);
  
  public NetworkPeerManager(ResponseBodyFileManager paramResponseBodyFileManager)
  {
    this.mResponseBodyFileManager = paramResponseBodyFileManager;
    setListener(this.mTempFileCleanup);
  }
  
  @Nullable
  public static NetworkPeerManager getInstanceOrNull()
  {
    try
    {
      NetworkPeerManager localNetworkPeerManager = sInstance;
      return localNetworkPeerManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static NetworkPeerManager getOrCreateInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null) {
        sInstance = new NetworkPeerManager(new ResponseBodyFileManager(paramContext.getApplicationContext()));
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  @Nullable
  public AsyncPrettyPrinterRegistry getAsyncPrettyPrinterRegistry()
  {
    return this.mAsyncPrettyPrinterRegistry;
  }
  
  public ResponseBodyFileManager getResponseBodyFileManager()
  {
    return this.mResponseBodyFileManager;
  }
  
  public void setPrettyPrinterInitializer(AsyncPrettyPrinterInitializer paramAsyncPrettyPrinterInitializer)
  {
    Util.throwIfNotNull(this.mPrettyPrinterInitializer);
    this.mPrettyPrinterInitializer = ((AsyncPrettyPrinterInitializer)Util.throwIfNull(paramAsyncPrettyPrinterInitializer));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.network.NetworkPeerManager
 * JD-Core Version:    0.7.0.1
 */