package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class STRetInfo
  extends JceStruct
{
  public int nExcess = 0;
  public int nLeft = 0;
  public int nPaMoney = 0;
  public int nPaNet = 0;
  public int nStopType = 0;
  public int nType = 0;
  public int nUsed = 0;
  public int ntime = 0;
  public int specialType = 0;
  public String strMsg = "";
  
  public STRetInfo() {}
  
  public STRetInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString, int paramInt9)
  {
    this.nType = paramInt1;
    this.nLeft = paramInt2;
    this.nUsed = paramInt3;
    this.nExcess = paramInt4;
    this.nPaNet = paramInt5;
    this.nPaMoney = paramInt6;
    this.ntime = paramInt7;
    this.nStopType = paramInt8;
    this.strMsg = paramString;
    this.specialType = paramInt9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nType = paramJceInputStream.read(this.nType, 0, true);
    this.nLeft = paramJceInputStream.read(this.nLeft, 1, true);
    this.nUsed = paramJceInputStream.read(this.nUsed, 2, true);
    this.nExcess = paramJceInputStream.read(this.nExcess, 3, true);
    this.nPaNet = paramJceInputStream.read(this.nPaNet, 4, true);
    this.nPaMoney = paramJceInputStream.read(this.nPaMoney, 5, true);
    this.ntime = paramJceInputStream.read(this.ntime, 6, true);
    this.nStopType = paramJceInputStream.read(this.nStopType, 7, false);
    this.strMsg = paramJceInputStream.readString(8, false);
    this.specialType = paramJceInputStream.read(this.specialType, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nType, 0);
    paramJceOutputStream.write(this.nLeft, 1);
    paramJceOutputStream.write(this.nUsed, 2);
    paramJceOutputStream.write(this.nExcess, 3);
    paramJceOutputStream.write(this.nPaNet, 4);
    paramJceOutputStream.write(this.nPaMoney, 5);
    paramJceOutputStream.write(this.ntime, 6);
    paramJceOutputStream.write(this.nStopType, 7);
    String str = this.strMsg;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    paramJceOutputStream.write(this.specialType, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.STRetInfo
 * JD-Core Version:    0.7.0.1
 */