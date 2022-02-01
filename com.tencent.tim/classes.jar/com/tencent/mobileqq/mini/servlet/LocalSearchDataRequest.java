package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_SEARCH.SEARCH.StLocalSearchDataReq;
import NS_MINI_APP_SEARCH.SEARCH.StLocalSearchDataRsp;
import com.tencent.qphone.base.util.QLog;

public class LocalSearchDataRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_search.LocalSearchData";
  public static final String TAG = "LocalSearchDataRequest";
  private SEARCH.StLocalSearchDataReq req = new SEARCH.StLocalSearchDataReq();
  
  public LocalSearchDataRequest(COMM.StCommonExt paramStCommonExt)
  {
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static SEARCH.StLocalSearchDataRsp onResponse(byte[] paramArrayOfByte)
  {
    SEARCH.StLocalSearchDataRsp localStLocalSearchDataRsp = new SEARCH.StLocalSearchDataRsp();
    try
    {
      localStLocalSearchDataRsp.mergeFrom(decode(paramArrayOfByte));
      return localStLocalSearchDataRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocalSearchDataRequest", 2, "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.LocalSearchDataRequest
 * JD-Core Version:    0.7.0.1
 */