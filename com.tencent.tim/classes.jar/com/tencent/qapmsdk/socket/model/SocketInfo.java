package com.tencent.qapmsdk.socket.model;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.Apn;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.impl.instrumentation.QAPMTransactionStateUtil;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLException;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;

public class SocketInfo
{
  private static final long READ_TIME_TOLERANCE = 20000L;
  private static final String TAG = "QAPM_Socket_SocketInfo";
  public int apnType = NetworkWatcher.INSTANCE.getApn().getValue();
  public boolean chunked;
  public long contentLength;
  public String contentType = "";
  public long dnsTime;
  public long duringTime;
  public int errorCode = 0;
  public Exception exception = null;
  public String fd;
  public long firstPacketPeriod;
  public boolean gzip;
  public boolean hasSaved = false;
  public String host;
  public int implHashCode;
  public String ip = "";
  public boolean isEnd;
  public long lastWriteStamp;
  public String method = "";
  public String networkType;
  public String path;
  public int port;
  public String protocol;
  public long receivedBytes;
  public Map<String, String> requestHeaders = new HashMap();
  public Map<String, String> responseHeaders = new HashMap();
  public long sendBytes;
  public boolean ssl;
  public long sslTime;
  public long startTimeStamp;
  public int statusCode = 0;
  public long tcpTime;
  public long threadId;
  public long totalConnectPeriod;
  public String url = "";
  public String version;
  
  public static int getErrorCode(Exception paramException)
  {
    if ((paramException instanceof IOException))
    {
      if (QAPMTransactionStateUtil.isSocketECONNRESET(paramException)) {
        return 911;
      }
      String str = paramException.getMessage();
      if ((paramException != null) && (str != null) && (str.contains("ftruncate failed: ENOENT (No such file or directory)"))) {
        return 917;
      }
    }
    if ((paramException instanceof UnknownHostException)) {
      return 901;
    }
    if ((!(paramException instanceof SocketTimeoutException)) && (!(paramException instanceof ConnectTimeoutException)))
    {
      if ((paramException instanceof ConnectException)) {
        return 902;
      }
      if ((paramException instanceof MalformedURLException)) {
        return 900;
      }
      if ((paramException instanceof SSLException)) {
        return 908;
      }
      if ((paramException instanceof HttpResponseException)) {
        return ((HttpResponseException)paramException).getStatusCode();
      }
      if ((paramException instanceof ClientProtocolException)) {
        return 904;
      }
      if ((paramException instanceof AuthenticationException)) {
        return 907;
      }
      return -1;
    }
    return 903;
  }
  
  public void readStamp(long paramLong)
  {
    if (paramLong <= this.lastWriteStamp)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Socket_SocketInfo", "get first package", ", firstReadTime:", String.valueOf(paramLong), ", lastWriteStamp:", String.valueOf(this.lastWriteStamp), ", hostName:", this.host });
      return;
    }
    if (paramLong - this.lastWriteStamp >= 20000L)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Socket_SocketInfo", "first package is too big", ", firstReadTime:", String.valueOf(paramLong), ", lastWriteStamp:", String.valueOf(this.lastWriteStamp), ", hostName:", this.host });
      return;
    }
    if (!this.isEnd)
    {
      this.isEnd = true;
      this.firstPacketPeriod = ((int)(paramLong - this.lastWriteStamp));
    }
    this.totalConnectPeriod = (paramLong - this.lastWriteStamp);
  }
  
  public void resetForInput()
  {
    this.gzip = false;
    this.chunked = false;
    this.contentLength = 0L;
  }
  
  public void resetForOutput()
  {
    this.gzip = false;
    this.chunked = false;
    this.contentLength = 0L;
    this.requestHeaders = new HashMap();
    this.responseHeaders = new HashMap();
  }
  
  public void writeStamp(long paramLong)
  {
    this.lastWriteStamp = paramLong;
    this.isEnd = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.model.SocketInfo
 * JD-Core Version:    0.7.0.1
 */