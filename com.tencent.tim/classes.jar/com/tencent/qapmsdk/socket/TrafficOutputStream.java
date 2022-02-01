package com.tencent.qapmsdk.socket;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.socket.handler.TrafficOutputStreamHandlerDispatcher;
import com.tencent.qapmsdk.socket.model.SocketInfo;
import com.tencent.qapmsdk.socket.util.NetworkUtils;
import java.io.IOException;
import java.io.OutputStream;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class TrafficOutputStream
  extends OutputStream
{
  private static final String[] METHODS = { "GET", "POST", "PATCH", "PUT", "DELETE", "MOVE", "PROPPATCH", "REPORT", "HEAD", "PROPFIND", "CONNECT", "OPTIONS", "TRACE", "PRI" };
  private static final String TAG = "QAPM_Socket_TrafficOutputStream";
  private byte[] byteTemp = new byte[1];
  private OutputStream outputStream;
  private SocketInfo socketInfo;
  private TrafficOutputStreamHandlerDispatcher trafficOutputStreamHandlerDispatcher;
  
  public TrafficOutputStream(OutputStream paramOutputStream, SocketInfo paramSocketInfo)
  {
    this.outputStream = paramOutputStream;
    if (paramSocketInfo != null) {
      this.socketInfo = paramSocketInfo;
    }
  }
  
  public void close()
    throws IOException
  {
    this.outputStream.close();
  }
  
  public void flush()
    throws IOException
  {
    this.outputStream.flush();
  }
  
  public void initData(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    this.socketInfo.ssl = paramBoolean;
    this.socketInfo.host = paramString1;
    this.socketInfo.ip = paramString2;
    this.socketInfo.port = paramInt1;
    this.socketInfo.fd = paramString3;
    this.socketInfo.implHashCode = paramInt2;
    this.socketInfo.threadId = Thread.currentThread().getId();
    this.socketInfo.networkType = NetworkUtils.getNetworkType();
    this.trafficOutputStreamHandlerDispatcher = new TrafficOutputStreamHandlerDispatcher();
  }
  
  public void setSocketInfo(SocketInfo paramSocketInfo)
  {
    this.socketInfo = paramSocketInfo;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.byteTemp[0] = ((byte)paramInt);
    write(this.byteTemp, 0, 1);
  }
  
  public void write(@NonNull byte[] paramArrayOfByte)
    throws IOException
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    long l = SystemClock.elapsedRealtime();
    String str = new String(paramArrayOfByte, 0, paramInt2);
    String[] arrayOfString = METHODS;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (!str.startsWith(arrayOfString[i])) {
          break label281;
        }
        i = str.indexOf(" ");
        if (i != -1)
        {
          this.socketInfo.method = str.substring(0, i);
          i += 1;
          j = str.indexOf(" ", i);
          if (j != -1)
          {
            this.socketInfo.path = str.substring(i, j);
            i = j + 1;
            j = "HTTP/1.1".length();
            this.socketInfo.version = str.substring(i, j + i);
          }
        }
      }
      if (TrafficMonitor.config().isVerbose()) {
        Logger.INSTANCE.v(new String[] { "QAPM_Socket_TrafficOutputStream", "finish match, cost: ", SystemClock.elapsedRealtime() - l + "ms", ", method: ", this.socketInfo.method, ", version: ", this.socketInfo.version, ", path: ", this.socketInfo.path });
      }
      this.trafficOutputStreamHandlerDispatcher.dispatchWrite(paramArrayOfByte, paramInt1, paramInt2, this.socketInfo);
      this.outputStream.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
      label281:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.TrafficOutputStream
 * JD-Core Version:    0.7.0.1
 */