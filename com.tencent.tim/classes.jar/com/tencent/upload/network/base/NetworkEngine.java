package com.tencent.upload.network.base;

import android.util.SparseArray;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.network.route.DomainNameParser;
import com.tencent.upload.network.route.DomainNameParser.ParseResult;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.StringUtils;
import com.tencent.upload.utils.UploadLog;
import java.util.concurrent.atomic.AtomicInteger;

public class NetworkEngine
  implements IMsgCallback, INetworkEngine
{
  private static final AtomicInteger PARAM_SEQUENCE = new AtomicInteger(0);
  private final String TAG;
  protected final IConnectionCallback mCallback;
  protected String mConnectedIp;
  private final String mId;
  protected final byte[] mLock = new byte[0];
  private ConnectionImpl mNativeConnection;
  protected SparseArray<Object> mParamMap = new SparseArray();
  
  public NetworkEngine(IConnectionCallback paramIConnectionCallback, String paramString)
  {
    this.mId = paramString;
    this.TAG = ("NetworkEngine-" + this.mId);
    int i = UploadConfiguration.getDoNotFragment();
    this.mCallback = paramIConnectionCallback;
    if (!ConnectionImpl.isLibraryPrepared())
    {
      UploadLog.e(this.TAG, "!isLibraryPrepared");
      return;
    }
    this.mNativeConnection = new ConnectionImpl(i, this.mId);
    this.mNativeConnection.setCallback(this.mCallback);
    this.mNativeConnection.setMsgCallback(this);
  }
  
  private static final int nextParamSequence()
  {
    return PARAM_SEQUENCE.incrementAndGet();
  }
  
  public boolean connectAsync(String arg1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    if (this.mNativeConnection == null) {
      return false;
    }
    paramString2 = new ConnectParam(???, paramInt1, paramString2, paramInt2, paramInt3);
    paramInt1 = nextParamSequence();
    synchronized (this.mLock)
    {
      this.mParamMap.put(paramInt1, paramString2);
      return this.mNativeConnection.PostMessage(0, null, paramInt1);
    }
  }
  
  public final String getConnectedIp()
  {
    return this.mConnectedIp;
  }
  
  public int hashCode()
  {
    if (this.mCallback != null) {
      return this.mCallback.hashCode();
    }
    return super.hashCode();
  }
  
  public boolean isRunning()
  {
    if (this.mNativeConnection == null) {
      return false;
    }
    return this.mNativeConnection.isRunning();
  }
  
  public void onMsgCallback(IMsgCallback paramIMsgCallback, int paramInt1, Object arg3, int paramInt2)
  {
    boolean bool = true;
    synchronized (this.mLock)
    {
      paramIMsgCallback = this.mParamMap.get(paramInt2);
      this.mParamMap.remove(paramInt2);
      switch (paramInt1)
      {
      }
    }
    if ((this.mNativeConnection != null) && ((paramIMsgCallback instanceof ConnectParam)))
    {
      ConnectParam localConnectParam = (ConnectParam)paramIMsgCallback;
      ??? = localConnectParam.ip;
      paramInt1 = UploadConfiguration.getMaxSegmentSize(???);
      paramIMsgCallback = ???;
      if (!StringUtils.isIpv4String(localConnectParam.ip))
      {
        paramIMsgCallback = ???;
        if (!StringUtils.isIpv6String(localConnectParam.ip))
        {
          paramIMsgCallback = new DomainNameParser.ParseResult();
          DomainNameParser.parse(localConnectParam.ip, paramIMsgCallback);
          ??? = paramIMsgCallback.parsedIp;
          paramIMsgCallback.parsedIp = null;
          paramIMsgCallback = ???;
          if (??? == null)
          {
            if (this.mCallback == null) {
              return;
            }
            this.mCallback.onConnect(this.mCallback, false, Const.UploadRetCode.DNS_PARSER_ERROR.getCode(), ???);
            return;
          }
        }
      }
      UploadLog.w(this.TAG, " OperationMsg.CONNECT, parsedIp:" + paramIMsgCallback + ", port:" + localConnectParam.port + ", proxyIp:" + localConnectParam.proxyIp + ", proxyPort:" + localConnectParam.proxyPort + " timeout:" + localConnectParam.timeout);
      this.mConnectedIp = paramIMsgCallback;
      this.mNativeConnection.connect(paramIMsgCallback, localConnectParam.port, localConnectParam.proxyIp, localConnectParam.proxyPort, localConnectParam.timeout, paramInt1);
    }
    else
    {
      ??? = this.TAG;
      paramIMsgCallback = new StringBuilder().append(" OperationMsg.CONNECT, obj instanceof ConnectParam:").append(paramIMsgCallback instanceof ConnectParam).append(" mNativeConnection != null:");
      if (this.mNativeConnection != null) {}
      for (bool = true;; bool = false)
      {
        UploadLog.w(???, bool);
        return;
      }
      if (this.mNativeConnection != null)
      {
        UploadLog.w(this.TAG, " OperationMsg.DISCONNECT");
        this.mNativeConnection.disconnect();
        return;
      }
      UploadLog.w(this.TAG, " OperationMsg.DISCONNECT, mNativeConnection == null");
      return;
      if ((this.mNativeConnection != null) && ((paramIMsgCallback instanceof SendParam)))
      {
        paramIMsgCallback = (SendParam)paramIMsgCallback;
        this.mNativeConnection.SendData(paramIMsgCallback.buf, paramIMsgCallback.sendSequence, paramIMsgCallback.sendTimeout, paramIMsgCallback.recvTimeout);
        return;
      }
      ??? = this.TAG;
      paramIMsgCallback = new StringBuilder().append(" OperationMsg.SEND, obj instanceof ConnectParam:").append(paramIMsgCallback instanceof SendParam).append("mNativeConnection != null:");
      if (this.mNativeConnection != null) {}
      for (;;)
      {
        UploadLog.w(???, bool);
        return;
        bool = false;
      }
    }
  }
  
  public boolean sendAsync(byte[] arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mNativeConnection == null) {
      return false;
    }
    SendParam localSendParam = new SendParam(???, paramInt1, paramInt2, paramInt3);
    paramInt1 = nextParamSequence();
    synchronized (this.mLock)
    {
      this.mParamMap.put(paramInt1, localSendParam);
      return this.mNativeConnection.PostMessage(2, null, paramInt1);
    }
  }
  
  public boolean start()
  {
    if (this.mNativeConnection == null) {
      return false;
    }
    if (this.mNativeConnection.isRunning())
    {
      UploadLog.w(this.TAG, "start, is running, return false");
      return false;
    }
    return this.mNativeConnection.start();
  }
  
  public boolean stop()
  {
    if (this.mNativeConnection == null) {
      return false;
    }
    this.mNativeConnection.removeAllSendData();
    boolean bool = this.mNativeConnection.stop();
    synchronized (this.mLock)
    {
      this.mParamMap.clear();
      return bool;
    }
  }
  
  public void wakeUp()
  {
    if (this.mNativeConnection == null) {
      return;
    }
    this.mNativeConnection.wakeUp();
  }
  
  static final class ConnectParam
  {
    public final String ip;
    public final int port;
    public final String proxyIp;
    public final int proxyPort;
    public final int timeout;
    
    public ConnectParam(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
    {
      this.ip = paramString1;
      this.port = paramInt1;
      this.proxyIp = paramString2;
      this.proxyPort = paramInt2;
      this.timeout = paramInt3;
    }
  }
  
  public static final class OperationMsg
  {
    public static final int CONNECT = 0;
    public static final int DISCONNECT = 1;
    public static final int ERROR = 3;
    public static final int SEND = 2;
    public static final int TIMEOUT = 4;
  }
  
  static final class SendParam
  {
    public final byte[] buf;
    public final int recvTimeout;
    public final int sendSequence;
    public final int sendTimeout;
    
    public SendParam(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    {
      this.buf = paramArrayOfByte;
      this.sendSequence = paramInt1;
      this.sendTimeout = paramInt2;
      this.recvTimeout = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.upload.network.base.NetworkEngine
 * JD-Core Version:    0.7.0.1
 */