package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class BatchDownloadActionResponse
  extends JceStruct
{
  private static ArrayList cache_batchData;
  public ArrayList batchData = null;
  public int batchRequestType = 0;
  
  public BatchDownloadActionResponse() {}
  
  public BatchDownloadActionResponse(int paramInt, ArrayList paramArrayList)
  {
    this.batchRequestType = paramInt;
    this.batchData = paramArrayList;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.batchRequestType = paramJceInputStream.read(this.batchRequestType, 0, true);
    if (cache_batchData == null)
    {
      cache_batchData = new ArrayList();
      IPCQueryDownloadInfo localIPCQueryDownloadInfo = new IPCQueryDownloadInfo();
      cache_batchData.add(localIPCQueryDownloadInfo);
    }
    this.batchData = ((ArrayList)paramJceInputStream.read(cache_batchData, 1, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.batchRequestType, 0);
    if (this.batchData != null) {
      paramJceOutputStream.write(this.batchData, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.param.jce.BatchDownloadActionResponse
 * JD-Core Version:    0.7.0.1
 */