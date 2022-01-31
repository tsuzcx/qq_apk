package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcResponseGetGroupFilter
  extends JceStruct
{
  public byte cOp = 0;
  public byte cReplyCode = 0;
  public long lGroupCode = 0L;
  public long lUin = 0L;
  public String strResult = "";
  
  public SvcResponseGetGroupFilter() {}
  
  public SvcResponseGetGroupFilter(long paramLong1, byte paramByte1, long paramLong2, byte paramByte2, String paramString)
  {
    this.lUin = paramLong1;
    this.cReplyCode = paramByte1;
    this.lGroupCode = paramLong2;
    this.cOp = paramByte2;
    this.strResult = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cReplyCode = paramJceInputStream.read(this.cReplyCode, 1, true);
    this.lGroupCode = paramJceInputStream.read(this.lGroupCode, 2, true);
    this.cOp = paramJceInputStream.read(this.cOp, 3, true);
    this.strResult = paramJceInputStream.readString(4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cReplyCode, 1);
    paramJceOutputStream.write(this.lGroupCode, 2);
    paramJceOutputStream.write(this.cOp, 3);
    paramJceOutputStream.write(this.strResult, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcResponseGetGroupFilter
 * JD-Core Version:    0.7.0.1
 */