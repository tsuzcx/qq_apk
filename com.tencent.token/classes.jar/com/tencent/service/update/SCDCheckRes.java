package com.tencent.service.update;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SCDCheckRes
  extends JceStruct
{
  public int res = 0;
  public int retCode = 0;
  public long taskNo = 0L;
  
  public final JceStruct newInit()
  {
    return new SCDCheckRes();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.retCode = paramJceInputStream.read(this.retCode, 0, true);
    this.taskNo = paramJceInputStream.read(this.taskNo, 1, true);
    this.res = paramJceInputStream.read(this.res, 2, true);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.retCode, 0);
    paramJceOutputStream.write(this.taskNo, 1);
    paramJceOutputStream.write(this.res, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.SCDCheckRes
 * JD-Core Version:    0.7.0.1
 */