package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GrpMemberNature
  extends JceStruct
{
  public long Mid = 0L;
  public byte Nature = 0;
  
  public GrpMemberNature() {}
  
  public GrpMemberNature(long paramLong, byte paramByte)
  {
    this.Mid = paramLong;
    this.Nature = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Mid = paramJceInputStream.read(this.Mid, 0, true);
    this.Nature = paramJceInputStream.read(this.Nature, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Mid, 0);
    paramJceOutputStream.write(this.Nature, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.GrpMemberNature
 * JD-Core Version:    0.7.0.1
 */