package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespUpload
  extends JceStruct
{
  public byte cFileExist = 0;
  public byte cSumCmd = 0;
  public long lPackSize = 0L;
  public int lReplyCode = 0;
  public long lReserve = 0L;
  public long lUploadIP = 0L;
  public short shUploadPort = 0;
  public String strFlieKey = "";
  public String strFliePath = "";
  public String strReserve = "";
  public String strResult = "";
  
  public RespUpload() {}
  
  public RespUpload(byte paramByte1, int paramInt, String paramString1, long paramLong1, short paramShort, String paramString2, String paramString3, byte paramByte2, long paramLong2, long paramLong3, String paramString4)
  {
    this.cSumCmd = paramByte1;
    this.lReplyCode = paramInt;
    this.strResult = paramString1;
    this.lUploadIP = paramLong1;
    this.shUploadPort = paramShort;
    this.strFliePath = paramString2;
    this.strFlieKey = paramString3;
    this.cFileExist = paramByte2;
    this.lPackSize = paramLong2;
    this.lReserve = paramLong3;
    this.strReserve = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cSumCmd = paramJceInputStream.read(this.cSumCmd, 0, true);
    this.lReplyCode = paramJceInputStream.read(this.lReplyCode, 1, true);
    this.strResult = paramJceInputStream.readString(2, true);
    this.lUploadIP = paramJceInputStream.read(this.lUploadIP, 3, true);
    this.shUploadPort = paramJceInputStream.read(this.shUploadPort, 4, true);
    this.strFliePath = paramJceInputStream.readString(5, true);
    this.strFlieKey = paramJceInputStream.readString(6, true);
    this.cFileExist = paramJceInputStream.read(this.cFileExist, 7, true);
    this.lPackSize = paramJceInputStream.read(this.lPackSize, 8, true);
    this.lReserve = paramJceInputStream.read(this.lReserve, 9, true);
    this.strReserve = paramJceInputStream.readString(10, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cSumCmd, 0);
    paramJceOutputStream.write(this.lReplyCode, 1);
    paramJceOutputStream.write(this.strResult, 2);
    paramJceOutputStream.write(this.lUploadIP, 3);
    paramJceOutputStream.write(this.shUploadPort, 4);
    paramJceOutputStream.write(this.strFliePath, 5);
    paramJceOutputStream.write(this.strFlieKey, 6);
    paramJceOutputStream.write(this.cFileExist, 7);
    paramJceOutputStream.write(this.lPackSize, 8);
    paramJceOutputStream.write(this.lReserve, 9);
    paramJceOutputStream.write(this.strReserve, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.RespUpload
 * JD-Core Version:    0.7.0.1
 */