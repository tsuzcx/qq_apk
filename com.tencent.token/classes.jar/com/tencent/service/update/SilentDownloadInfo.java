package com.tencent.service.update;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SilentDownloadInfo
  extends JceStruct
{
  public int askType = 0;
  public String msg = "";
  public String title = "";
  public int type = 0;
  public String url = "";
  
  public void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public JceStruct newInit()
  {
    return new SilentDownloadInfo();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.type = paramJceInputStream.read(this.type, 2, false);
    this.askType = paramJceInputStream.read(this.askType, 3, false);
    this.url = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 0);
    }
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.type != 0) {
      paramJceOutputStream.write(this.type, 2);
    }
    if (this.askType != 0) {
      paramJceOutputStream.write(this.askType, 3);
    }
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.SilentDownloadInfo
 * JD-Core Version:    0.7.0.1
 */