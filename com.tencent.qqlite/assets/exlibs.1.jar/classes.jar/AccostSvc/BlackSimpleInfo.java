package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BlackSimpleInfo
  extends JceStruct
{
  public byte cAge = 0;
  public byte cSex = 0;
  public long lBlackID = 0L;
  public String strNick = "";
  public short wFace = 0;
  
  public BlackSimpleInfo() {}
  
  public BlackSimpleInfo(long paramLong, short paramShort, byte paramByte1, byte paramByte2, String paramString)
  {
    this.lBlackID = paramLong;
    this.wFace = paramShort;
    this.cSex = paramByte1;
    this.cAge = paramByte2;
    this.strNick = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lBlackID = paramJceInputStream.read(this.lBlackID, 0, true);
    this.wFace = paramJceInputStream.read(this.wFace, 1, true);
    this.cSex = paramJceInputStream.read(this.cSex, 2, true);
    this.cAge = paramJceInputStream.read(this.cAge, 3, true);
    this.strNick = paramJceInputStream.readString(4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lBlackID, 0);
    paramJceOutputStream.write(this.wFace, 1);
    paramJceOutputStream.write(this.cSex, 2);
    paramJceOutputStream.write(this.cAge, 3);
    paramJceOutputStream.write(this.strNick, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     AccostSvc.BlackSimpleInfo
 * JD-Core Version:    0.7.0.1
 */