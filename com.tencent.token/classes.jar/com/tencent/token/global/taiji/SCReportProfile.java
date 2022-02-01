package com.tencent.token.global.taiji;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SCReportProfile
  extends JceStruct
{
  public String msg = "";
  public int retCode = 0;
  
  public final JceStruct newInit()
  {
    return new SCReportProfile();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.msg = paramJceInputStream.readString(0, false);
    this.retCode = paramJceInputStream.read(this.retCode, 1, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.msg;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    int i = this.retCode;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.SCReportProfile
 * JD-Core Version:    0.7.0.1
 */