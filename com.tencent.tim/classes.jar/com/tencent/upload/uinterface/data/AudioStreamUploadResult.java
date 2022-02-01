package com.tencent.upload.uinterface.data;

import NS_COMM_UPLOAD_PROTOCOL.CUploadDownstream;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class AudioStreamUploadResult
  extends JceStruct
{
  static CUploadDownstream cache_rsp = new CUploadDownstream();
  public String filePath;
  public CUploadDownstream rsp;
  
  public AudioStreamUploadResult() {}
  
  public AudioStreamUploadResult(CUploadDownstream paramCUploadDownstream, String paramString)
  {
    this.rsp = paramCUploadDownstream;
    this.filePath = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rsp = ((CUploadDownstream)paramJceInputStream.read(cache_rsp, 0, false));
    this.filePath = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.rsp != null) {
      paramJceOutputStream.write(this.rsp, 0);
    }
    if (this.filePath != null) {
      paramJceOutputStream.write(this.filePath, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.AudioStreamUploadResult
 * JD-Core Version:    0.7.0.1
 */