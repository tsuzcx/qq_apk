package com.tencent.service.update;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DiffUpdate
  extends JceStruct
{
  public boolean isDownloadYYB = true;
  public boolean isGradual = true;
  public String yybUrl = "";
  
  public void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public JceStruct newInit()
  {
    return new DiffUpdate();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.isGradual = paramJceInputStream.read(this.isGradual, 0, false);
    this.isDownloadYYB = paramJceInputStream.read(this.isDownloadYYB, 1, false);
    this.yybUrl = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.isGradual != true) {
      paramJceOutputStream.write(this.isGradual, 0);
    }
    if (this.isDownloadYYB != true) {
      paramJceOutputStream.write(this.isDownloadYYB, 1);
    }
    if (this.yybUrl != null) {
      paramJceOutputStream.write(this.yybUrl, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.DiffUpdate
 * JD-Core Version:    0.7.0.1
 */