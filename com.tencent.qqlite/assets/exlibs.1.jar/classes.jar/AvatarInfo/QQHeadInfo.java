package AvatarInfo;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QQHeadInfo
  extends JceStruct
  implements Cloneable
{
  public byte cHeadType = 0;
  public String downLoadUrl = "";
  public byte dstUsrType = 0;
  public byte dwFaceFlgas = 0;
  public long dwTimestamp = 0L;
  public String phoneNum = "";
  public byte soruceType = 0;
  public int subType;
  public short systemHeadID = 0;
  public long uin = 0L;
  
  public QQHeadInfo() {}
  
  public QQHeadInfo(long paramLong1, long paramLong2, byte paramByte1, byte paramByte2, byte paramByte3, String paramString1, short paramShort, String paramString2)
  {
    this.uin = paramLong1;
    this.dwTimestamp = paramLong2;
    this.cHeadType = paramByte1;
    this.dstUsrType = paramByte2;
    this.dwFaceFlgas = paramByte3;
    this.downLoadUrl = paramString1;
    this.systemHeadID = paramShort;
    this.phoneNum = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.dwTimestamp = paramJceInputStream.read(this.dwTimestamp, 1, true);
    this.cHeadType = paramJceInputStream.read(this.cHeadType, 2, true);
    this.dstUsrType = paramJceInputStream.read(this.dstUsrType, 3, true);
    this.dwFaceFlgas = paramJceInputStream.read(this.dwFaceFlgas, 4, true);
    this.downLoadUrl = paramJceInputStream.readString(5, true);
    this.systemHeadID = paramJceInputStream.read(this.systemHeadID, 6, false);
    this.phoneNum = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.dwTimestamp, 1);
    paramJceOutputStream.write(this.cHeadType, 2);
    paramJceOutputStream.write(this.dstUsrType, 3);
    paramJceOutputStream.write(this.dwFaceFlgas, 4);
    paramJceOutputStream.write(this.downLoadUrl, 5);
    paramJceOutputStream.write(this.systemHeadID, 6);
    if (this.phoneNum != null) {
      paramJceOutputStream.write(this.phoneNum, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     AvatarInfo.QQHeadInfo
 * JD-Core Version:    0.7.0.1
 */