package com.tencent.qapmsdk.socket.handler;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.socket.model.SocketInfo;

public class FirstPackageInputFactory
  implements ITrafficInputStreamHandlerFactory
{
  private FirstPackageInputMonitor firstPackageInputMonitor = new FirstPackageInputMonitor(null);
  
  public ITrafficInputStreamHandler create()
  {
    if (this.firstPackageInputMonitor == null) {
      this.firstPackageInputMonitor = new FirstPackageInputMonitor(null);
    }
    return this.firstPackageInputMonitor;
  }
  
  class FirstPackageInputMonitor
    implements ITrafficInputStreamHandler
  {
    private FirstPackageInputMonitor() {}
    
    public void onClose() {}
    
    public void onInput(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, @Nullable SocketInfo paramSocketInfo)
    {
      paramSocketInfo.readStamp(SystemClock.elapsedRealtime());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.FirstPackageInputFactory
 * JD-Core Version:    0.7.0.1
 */