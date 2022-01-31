package GroupPic;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqHeader
  extends JceStruct
{
  public byte cGroupIdType = 0;
  public int iSeq = 0;
  public long lUin = 0L;
  public short shVer = 0;
  public long uGroupUin = 0L;
  
  public ReqHeader() {}
  
  public ReqHeader(int paramInt, short paramShort, long paramLong1, long paramLong2, byte paramByte)
  {
    this.iSeq = paramInt;
    this.shVer = paramShort;
    this.lUin = paramLong1;
    this.uGroupUin = paramLong2;
    this.cGroupIdType = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iSeq = paramJceInputStream.read(this.iSeq, 0, true);
    this.shVer = paramJceInputStream.read(this.shVer, 1, true);
    this.lUin = paramJceInputStream.read(this.lUin, 2, true);
    this.uGroupUin = paramJceInputStream.read(this.uGroupUin, 3, true);
    this.cGroupIdType = paramJceInputStream.read(this.cGroupIdType, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iSeq, 0);
    paramJceOutputStream.write(this.shVer, 1);
    paramJceOutputStream.write(this.lUin, 2);
    paramJceOutputStream.write(this.uGroupUin, 3);
    paramJceOutputStream.write(this.cGroupIdType, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     GroupPic.ReqHeader
 * JD-Core Version:    0.7.0.1
 */