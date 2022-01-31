package com.tencent.token.global.taiji;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SCReportProfile
  extends JceStruct
{
  public String msg = "";
  public int retCode = 0;
  
  public JceStruct newInit()
  {
    return new SCReportProfile();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.msg = paramJceInputStream.readString(0, false);
    this.retCode = paramJceInputStream.read(this.retCode, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 0);
    }
    if (this.retCode != 0) {
      paramJceOutputStream.write(this.retCode, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.SCReportProfile
 * JD-Core Version:    0.7.0.1
 */