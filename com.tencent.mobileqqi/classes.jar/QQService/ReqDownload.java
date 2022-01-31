package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqDownload
  extends JceStruct
{
  public byte cSumCmd = 0;
  public long lReserve = 0L;
  public long lSeq = 0L;
  public long lToUIN = 0L;
  public String strFliePath = "";
  public String strReserve = "";
  
  public ReqDownload() {}
  
  public ReqDownload(byte paramByte, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2)
  {
    this.cSumCmd = paramByte;
    this.lToUIN = paramLong1;
    this.lSeq = paramLong2;
    this.strFliePath = paramString1;
    this.lReserve = paramLong3;
    this.strReserve = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cSumCmd = paramJceInputStream.read(this.cSumCmd, 0, true);
    this.lToUIN = paramJceInputStream.read(this.lToUIN, 1, true);
    this.lSeq = paramJceInputStream.read(this.lSeq, 2, true);
    this.strFliePath = paramJceInputStream.readString(3, true);
    this.lReserve = paramJceInputStream.read(this.lReserve, 4, true);
    this.strReserve = paramJceInputStream.readString(5, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cSumCmd, 0);
    paramJceOutputStream.write(this.lToUIN, 1);
    paramJceOutputStream.write(this.lSeq, 2);
    paramJceOutputStream.write(this.strFliePath, 3);
    paramJceOutputStream.write(this.lReserve, 4);
    paramJceOutputStream.write(this.strReserve, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ReqDownload
 * JD-Core Version:    0.7.0.1
 */