package com.tencent.service.update;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CSDCheckData
  extends JceStruct
{
  public long taskNo = 0L;
  
  public JceStruct newInit()
  {
    return new CSDCheckData();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.taskNo = paramJceInputStream.read(this.taskNo, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.taskNo, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.CSDCheckData
 * JD-Core Version:    0.7.0.1
 */