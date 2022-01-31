package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGroupInfo
  extends JceStruct
{
  public long lGroupCode = 0L;
  public long lGroupUin = 0L;
  
  public stGroupInfo() {}
  
  public stGroupInfo(long paramLong1, long paramLong2)
  {
    this.lGroupCode = paramLong1;
    this.lGroupUin = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lGroupCode = paramJceInputStream.read(this.lGroupCode, 0, true);
    this.lGroupUin = paramJceInputStream.read(this.lGroupUin, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lGroupCode, 0);
    paramJceOutputStream.write(this.lGroupUin, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.stGroupInfo
 * JD-Core Version:    0.7.0.1
 */