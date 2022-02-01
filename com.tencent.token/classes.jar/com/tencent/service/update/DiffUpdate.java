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
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final JceStruct newInit()
  {
    return new DiffUpdate();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.isGradual = paramJceInputStream.read(this.isGradual, 0, false);
    this.isDownloadYYB = paramJceInputStream.read(this.isDownloadYYB, 1, false);
    this.yybUrl = paramJceInputStream.readString(2, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    boolean bool = this.isGradual;
    if (bool != true) {
      paramJceOutputStream.write(bool, 0);
    }
    bool = this.isDownloadYYB;
    if (bool != true) {
      paramJceOutputStream.write(bool, 1);
    }
    String str = this.yybUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.DiffUpdate
 * JD-Core Version:    0.7.0.1
 */