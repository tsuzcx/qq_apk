package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import android.support.annotation.Nullable;
import java.util.ArrayList;

public abstract class BaseDataSource
  implements DataSource
{
  @Nullable
  private DataSpec dataSpec;
  private final boolean isNetwork;
  private int listenerCount;
  private final ArrayList<TransferListener> listeners;
  
  protected BaseDataSource(boolean paramBoolean)
  {
    this.isNetwork = paramBoolean;
    this.listeners = new ArrayList(1);
  }
  
  public final void addTransferListener(TransferListener paramTransferListener)
  {
    if (!this.listeners.contains(paramTransferListener))
    {
      this.listeners.add(paramTransferListener);
      this.listenerCount += 1;
    }
  }
  
  protected final void bytesTransferred(int paramInt)
  {
    DataSpec localDataSpec = (DataSpec)Assertions.castNonNull(this.dataSpec);
    int i = 0;
    while (i < this.listenerCount)
    {
      ((TransferListener)this.listeners.get(i)).onBytesTransferred(this, localDataSpec, this.isNetwork, paramInt);
      i += 1;
    }
  }
  
  protected final void transferEnded()
  {
    DataSpec localDataSpec = (DataSpec)Assertions.castNonNull(this.dataSpec);
    int i = 0;
    while (i < this.listenerCount)
    {
      ((TransferListener)this.listeners.get(i)).onTransferEnd(this, localDataSpec, this.isNetwork);
      i += 1;
    }
    this.dataSpec = null;
  }
  
  protected final void transferInitializing(DataSpec paramDataSpec)
  {
    int i = 0;
    while (i < this.listenerCount)
    {
      ((TransferListener)this.listeners.get(i)).onTransferInitializing(this, paramDataSpec, this.isNetwork);
      i += 1;
    }
  }
  
  protected final void transferStarted(DataSpec paramDataSpec)
  {
    this.dataSpec = paramDataSpec;
    int i = 0;
    while (i < this.listenerCount)
    {
      ((TransferListener)this.listeners.get(i)).onTransferStart(this, paramDataSpec, this.isNetwork);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.BaseDataSource
 * JD-Core Version:    0.7.0.1
 */