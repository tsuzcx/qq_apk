package com.tencent.map.lbsapi.api;

import com.tencent.map.location.h;

public class SOSOMapLBSApiListener
{
  private int mReqDelay = 12;
  private int mReqGeoType = 1;
  private int mReqLevel = 0;
  private int mReqType = 1;
  
  public SOSOMapLBSApiListener(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    h.a("argument: " + this.mReqType + " " + this.mReqGeoType + " " + this.mReqLevel);
    if ((paramInt1 >= 0) && (paramInt1 <= 1)) {
      this.mReqType = paramInt1;
    }
    if ((paramInt2 >= 0) && (paramInt2 <= 1)) {
      this.mReqGeoType = paramInt2;
    }
    if ((paramInt3 == 0) || (paramInt3 == 1) || (paramInt3 == 3) || (paramInt3 == 4) || (paramInt3 == 7)) {
      this.mReqLevel = paramInt3;
    }
    if (this.mReqGeoType == 0) {
      this.mReqLevel = 0;
    }
    this.mReqDelay = paramInt4;
  }
  
  public int getReqDelay()
  {
    return this.mReqDelay;
  }
  
  public int getReqGeoType()
  {
    return this.mReqGeoType;
  }
  
  public int getReqLevel()
  {
    return this.mReqLevel;
  }
  
  public int getReqType()
  {
    return this.mReqType;
  }
  
  public void onLocationDataUpdate(byte[] paramArrayOfByte, int paramInt) {}
  
  public void onLocationUpdate(SOSOMapLBSApiResult paramSOSOMapLBSApiResult) {}
  
  public void onStatusUpdate(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.map.lbsapi.api.SOSOMapLBSApiListener
 * JD-Core Version:    0.7.0.1
 */