package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestPushStatus
  extends JceStruct
{
  public byte cDataLine = 0;
  public byte cPrintable = 0;
  public byte cStatus = 0;
  public byte cViewPcFile = 0;
  public long lUin = 0L;
  
  public RequestPushStatus() {}
  
  public RequestPushStatus(long paramLong, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    this.lUin = paramLong;
    this.cStatus = paramByte1;
    this.cDataLine = paramByte2;
    this.cPrintable = paramByte3;
    this.cViewPcFile = paramByte4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cStatus = paramJceInputStream.read(this.cStatus, 1, true);
    this.cDataLine = paramJceInputStream.read(this.cDataLine, 2, false);
    this.cPrintable = paramJceInputStream.read(this.cPrintable, 3, false);
    this.cViewPcFile = paramJceInputStream.read(this.cViewPcFile, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cStatus, 1);
    paramJceOutputStream.write(this.cDataLine, 2);
    paramJceOutputStream.write(this.cPrintable, 3);
    paramJceOutputStream.write(this.cViewPcFile, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     MessageSvcPack.RequestPushStatus
 * JD-Core Version:    0.7.0.1
 */