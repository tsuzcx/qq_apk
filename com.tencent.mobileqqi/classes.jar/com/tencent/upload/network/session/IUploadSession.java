package com.tencent.upload.network.session;

import com.tencent.upload.network.action.IActionRequest;
import com.tencent.upload.network.route.UploadRoute;

public abstract interface IUploadSession
{
  public abstract void cancel(int paramInt);
  
  public abstract void close();
  
  public abstract String getClientIp();
  
  public abstract String getConnectedIp();
  
  public abstract UploadRoute getRedirectRoute();
  
  public abstract UploadRoute getUploadRoute();
  
  public abstract boolean isEstablished();
  
  public abstract boolean isIdle();
  
  public abstract boolean isRedirect();
  
  public abstract boolean open(UploadRoute paramUploadRoute);
  
  public abstract boolean open(UploadRoute paramUploadRoute, int paramInt);
  
  public abstract boolean send(IActionRequest paramIActionRequest);
  
  public static final class SessionState
  {
    public static final int CONNECTING = 1;
    public static final int ESTALISHED = 2;
    public static final int NO_CONNECTION = 0;
    
    public static final String print(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "unknown";
      case 0: 
        return "noconnection";
      case 1: 
        return "connecting";
      }
      return "established";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.upload.network.session.IUploadSession
 * JD-Core Version:    0.7.0.1
 */