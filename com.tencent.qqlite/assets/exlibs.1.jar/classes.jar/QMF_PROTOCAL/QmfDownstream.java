package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QmfDownstream
  extends JceStruct
{
  static byte[] cache_BusiBuff;
  static byte[] cache_Extra;
  public short BizCode = 0;
  public byte[] BusiBuff = null;
  public byte[] Extra = null;
  public int Seq = 0;
  public String ServiceCmd = "";
  public long Uin = 0L;
  public short WnsCode = 0;
  
  public QmfDownstream() {}
  
  public QmfDownstream(int paramInt, long paramLong, short paramShort1, short paramShort2, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.Seq = paramInt;
    this.Uin = paramLong;
    this.WnsCode = paramShort1;
    this.BizCode = paramShort2;
    this.ServiceCmd = paramString;
    this.BusiBuff = paramArrayOfByte1;
    this.Extra = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Seq = paramJceInputStream.read(this.Seq, 0, true);
    this.Uin = paramJceInputStream.read(this.Uin, 1, true);
    this.WnsCode = paramJceInputStream.read(this.WnsCode, 2, true);
    this.BizCode = paramJceInputStream.read(this.BizCode, 3, true);
    this.ServiceCmd = paramJceInputStream.readString(4, true);
    if (cache_BusiBuff == null)
    {
      cache_BusiBuff = (byte[])new byte[1];
      ((byte[])cache_BusiBuff)[0] = 0;
    }
    this.BusiBuff = ((byte[])paramJceInputStream.read(cache_BusiBuff, 5, true));
    if (cache_Extra == null)
    {
      cache_Extra = (byte[])new byte[1];
      ((byte[])cache_Extra)[0] = 0;
    }
    this.Extra = ((byte[])paramJceInputStream.read(cache_Extra, 6, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Seq, 0);
    paramJceOutputStream.write(this.Uin, 1);
    paramJceOutputStream.write(this.WnsCode, 2);
    paramJceOutputStream.write(this.BizCode, 3);
    paramJceOutputStream.write(this.ServiceCmd, 4);
    paramJceOutputStream.write(this.BusiBuff, 5);
    paramJceOutputStream.write(this.Extra, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QMF_PROTOCAL.QmfDownstream
 * JD-Core Version:    0.7.0.1
 */