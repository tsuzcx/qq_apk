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
    String str = this.title;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.msg;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    int i = this.type;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
    i = this.askType;
    if (i != 0) {
      paramJceOutputStream.write(i, 3);
    }
    str = this.url;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.SilentDownloadInfo
 * JD-Core Version:    0.7.0.1
 */