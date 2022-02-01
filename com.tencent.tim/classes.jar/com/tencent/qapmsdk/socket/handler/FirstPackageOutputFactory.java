package com.tencent.qapmsdk.socket.handler;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.qapmsdk.socket.model.SocketInfo;

public class FirstPackageOutputFactory
  implements ITrafficOutputStreamHandlerFactory
{
  private FirstPackageOutputMonitor firstPackageOutputMonitor = new FirstPackageOutputMonitor(null);
  
  public ITrafficOutputStreamHandler create()
  {
    if (this.firstPackageOutputMonitor == null) {
      this.firstPackageOutputMonitor = new FirstPackageOutputMonitor(null);
    }
    return this.firstPackageOutputMonitor;
  }
  
  class FirstPackageOutputMonitor
    implements ITrafficOutputStreamHandler
  {
    private FirstPackageOutputMonitor() {}
    
    public void onOutput(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, SocketInfo paramSocketInfo)
    {
      paramSocketInfo.writeStamp(SystemClock.elapsedRealtime());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.FirstPackageOutputFactory
 * JD-Core Version:    0.7.0.1
 */