package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRequestGetGroupFilter
  extends JceStruct
{
  public byte cVerifyType = 0;
  public long lGroupCode = 0L;
  public long lUin = 0L;
  
  public SvcRequestGetGroupFilter() {}
  
  public SvcRequestGetGroupFilter(long paramLong1, long paramLong2, byte paramByte)
  {
    this.lUin = paramLong1;
    this.lGroupCode = paramLong2;
    this.cVerifyType = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.lGroupCode = paramJceInputStream.read(this.lGroupCode, 1, true);
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.lGroupCode, 1);
    paramJceOutputStream.write(this.cVerifyType, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     MessageSvcPack.SvcRequestGetGroupFilter
 * JD-Core Version:    0.7.0.1
 */