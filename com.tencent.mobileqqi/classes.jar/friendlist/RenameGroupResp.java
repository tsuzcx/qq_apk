package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RenameGroupResp
  extends JceStruct
{
  public byte cLen = 0;
  public long dwSequence = 0L;
  public long dwToUin = 0L;
  public String sGroupName = "";
  
  public RenameGroupResp() {}
  
  public RenameGroupResp(long paramLong1, long paramLong2, byte paramByte, String paramString)
  {
    this.dwToUin = paramLong1;
    this.dwSequence = paramLong2;
    this.cLen = paramByte;
    this.sGroupName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwToUin = paramJceInputStream.read(this.dwToUin, 0, true);
    this.dwSequence = paramJceInputStream.read(this.dwSequence, 1, true);
    this.cLen = paramJceInputStream.read(this.cLen, 2, true);
    this.sGroupName = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwToUin, 0);
    paramJceOutputStream.write(this.dwSequence, 1);
    paramJceOutputStream.write(this.cLen, 2);
    paramJceOutputStream.write(this.sGroupName, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     friendlist.RenameGroupResp
 * JD-Core Version:    0.7.0.1
 */