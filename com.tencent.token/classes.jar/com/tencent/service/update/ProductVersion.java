package com.tencent.service.update;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ProductVersion
  extends JceStruct
{
  public int cversion = 0;
  public int hotfix = 0;
  public int pversion = 0;
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.pversion = paramJceInputStream.read(this.pversion, 1, true);
    this.cversion = paramJceInputStream.read(this.cversion, 2, true);
    this.hotfix = paramJceInputStream.read(this.hotfix, 3, true);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.pversion, 1);
    paramJceOutputStream.write(this.cversion, 2);
    paramJceOutputStream.write(this.hotfix, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.ProductVersion
 * JD-Core Version:    0.7.0.1
 */