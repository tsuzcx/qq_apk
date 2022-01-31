package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class BatchDownloadActionRequest
  extends JceStruct
{
  private static ArrayList cache_batchData;
  public ArrayList batchData = null;
  public int batchRequestType = 0;
  public String uin = "";
  public String uinType = "";
  public String via = "";
  
  public BatchDownloadActionRequest() {}
  
  public BatchDownloadActionRequest(int paramInt, ArrayList paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    this.batchRequestType = paramInt;
    this.batchData = paramArrayList;
    this.uin = paramString1;
    this.uinType = paramString2;
    this.via = paramString3;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.batchRequestType = paramJceInputStream.read(this.batchRequestType, 0, true);
    if (cache_batchData == null)
    {
      cache_batchData = new ArrayList();
      IPCDownloadParam localIPCDownloadParam = new IPCDownloadParam();
      cache_batchData.add(localIPCDownloadParam);
    }
    this.batchData = ((ArrayList)paramJceInputStream.read(cache_batchData, 1, false));
    this.uin = paramJceInputStream.readString(2, false);
    this.uinType = paramJceInputStream.readString(3, false);
    this.via = paramJceInputStream.readString(4, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.batchRequestType, 0);
    if (this.batchData != null) {
      paramJceOutputStream.write(this.batchData, 1);
    }
    if (this.uin != null) {
      paramJceOutputStream.write(this.uin, 2);
    }
    if (this.uinType != null) {
      paramJceOutputStream.write(this.uinType, 3);
    }
    if (this.via != null) {
      paramJceOutputStream.write(this.via, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.param.jce.BatchDownloadActionRequest
 * JD-Core Version:    0.7.0.1
 */