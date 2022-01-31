package com.tencent.upload.network.route;

import java.io.Serializable;

public class RecentRouteSet
  implements Serializable
{
  private static final long serialVersionUID = 1000L;
  private UploadRoute mRecentHttpRoute = null;
  private UploadRoute mRecentTcpRoute = null;
  private long mTimeStamp = 0L;
  
  public UploadRoute getRecentHttpRoute()
  {
    return this.mRecentHttpRoute;
  }
  
  public UploadRoute getRecentTcpRoute()
  {
    return this.mRecentTcpRoute;
  }
  
  public long getTimeStamp()
  {
    return this.mTimeStamp;
  }
  
  public void setRecentRoute(UploadRoute paramUploadRoute)
  {
    int i = paramUploadRoute.getProtocol();
    if (i == 2) {
      this.mRecentHttpRoute = paramUploadRoute;
    }
    while (i != 1) {
      return;
    }
    this.mRecentTcpRoute = paramUploadRoute;
  }
  
  public void setTimeStamp(long paramLong)
  {
    this.mTimeStamp = paramLong;
  }
  
  public String toString()
  {
    return "mRecentTcpRoute = " + this.mRecentTcpRoute + ", mRecentHttpRoute = " + this.mRecentHttpRoute + ",mTimeStamp = " + this.mTimeStamp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.upload.network.route.RecentRouteSet
 * JD-Core Version:    0.7.0.1
 */