package acs;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ResCommon
  extends JceStruct
{
  public byte cByte;
  public int cInt;
  public long cLong;
  public String cString = "";
  
  public ResCommon() {}
  
  public ResCommon(byte paramByte, int paramInt, long paramLong, String paramString)
  {
    this.cByte = paramByte;
    this.cInt = paramInt;
    this.cLong = paramLong;
    this.cString = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cByte = paramJceInputStream.read(this.cByte, 0, false);
    this.cInt = paramJceInputStream.read(this.cInt, 1, false);
    this.cLong = paramJceInputStream.read(this.cLong, 2, false);
    this.cString = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cByte, 0);
    paramJceOutputStream.write(this.cInt, 1);
    paramJceOutputStream.write(this.cLong, 2);
    if (this.cString != null) {
      paramJceOutputStream.write(this.cString, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acs.ResCommon
 * JD-Core Version:    0.7.0.1
 */