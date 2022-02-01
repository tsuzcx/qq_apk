package com.tencent.qapmsdk.socket;

import com.tencent.qapmsdk.socket.model.SocketInfo;

public class TrafficConnectReporter
{
  private static IConnectListener connectListener;
  
  public static void onConnected(boolean paramBoolean, String paramString, int paramInt, long paramLong, SocketInfo paramSocketInfo)
  {
    if (connectListener != null) {
      connectListener.onConnected(paramBoolean, paramString, paramInt, paramLong, paramSocketInfo);
    }
  }
  
  public static void onHandshakeCompleted(boolean paramBoolean, String paramString, int paramInt, long paramLong, SocketInfo paramSocketInfo)
  {
    if (connectListener != null) {
      connectListener.onHandshakeCompleted(paramBoolean, paramString, paramInt, paramLong, paramSocketInfo);
    }
  }
  
  public static void setConnectListener(IConnectListener paramIConnectListener)
  {
    connectListener = paramIConnectListener;
  }
  
  public static abstract interface IConnectListener
  {
    public abstract void onConnected(boolean paramBoolean, String paramString, int paramInt, long paramLong, SocketInfo paramSocketInfo);
    
    public abstract void onHandshakeCompleted(boolean paramBoolean, String paramString, int paramInt, long paramLong, SocketInfo paramSocketInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.TrafficConnectReporter
 * JD-Core Version:    0.7.0.1
 */