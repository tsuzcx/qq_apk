package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import android.net.Uri;
import android.support.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract interface DataSource
{
  public abstract void addTransferListener(TransferListener paramTransferListener);
  
  public abstract void close()
    throws IOException;
  
  public abstract Map<String, List<String>> getResponseHeaders();
  
  @Nullable
  public abstract Uri getUri();
  
  public abstract long open(DataSpec paramDataSpec)
    throws IOException;
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public static abstract interface Factory
  {
    public abstract DataSource createDataSource();
    
    public abstract DataSource createDataSource(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.DataSource
 * JD-Core Version:    0.7.0.1
 */