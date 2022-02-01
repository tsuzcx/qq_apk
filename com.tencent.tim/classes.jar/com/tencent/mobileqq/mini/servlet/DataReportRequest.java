package com.tencent.mobileqq.mini.servlet;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportRsp;
import com.tencent.qphone.base.util.QLog;

public class DataReportRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_report_transfer.DataReport";
  private byte[] datas;
  
  public DataReportRequest(byte[] paramArrayOfByte)
  {
    this.datas = paramArrayOfByte;
  }
  
  public static APP_REPORT_TRANSFER.StDataReportRsp onResponse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      APP_REPORT_TRANSFER.StDataReportRsp localStDataReportRsp = new APP_REPORT_TRANSFER.StDataReportRsp();
      try
      {
        localStDataReportRsp.mergeFrom(decode(paramArrayOfByte));
        return localStDataReportRsp;
      }
      catch (Exception paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("ProtoBufRequest", 2, "onResponse fail." + paramArrayOfByte);
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.datas;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.DataReportRequest
 * JD-Core Version:    0.7.0.1
 */