package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GroupFilterInfo
  extends JceStruct
{
  public byte cOp = 0;
  public long lGroupCode = 0L;
  
  public GroupFilterInfo() {}
  
  public GroupFilterInfo(long paramLong, byte paramByte)
  {
    this.lGroupCode = paramLong;
    this.cOp = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lGroupCode = paramJceInputStream.read(this.lGroupCode, 0, true);
    this.cOp = paramJceInputStream.read(this.cOp, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lGroupCode, 0);
    paramJceOutputStream.write(this.cOp, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     MessageSvcPack.GroupFilterInfo
 * JD-Core Version:    0.7.0.1
 */