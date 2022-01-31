package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GroupMngReq
  extends JceStruct
{
  static int cache_reqtype;
  static byte[] cache_vecBody;
  public byte cCheckInGroup = 0;
  public byte cIfGetAuthInfo = 0;
  public byte cIsSupportAuthQuestionJoin = 0;
  public byte cStatOption = 0;
  public long dwDiscussUin = 0L;
  public int reqtype = 0;
  public String sGroupLocation = "";
  public long uin = 0L;
  public byte[] vecBody = null;
  public int wSourceID = 0;
  public int wSourceSubID = 0;
  
  public GroupMngReq() {}
  
  public GroupMngReq(int paramInt1, long paramLong1, byte[] paramArrayOfByte, byte paramByte1, String paramString, byte paramByte2, int paramInt2, int paramInt3, byte paramByte3, byte paramByte4, long paramLong2)
  {
    this.reqtype = paramInt1;
    this.uin = paramLong1;
    this.vecBody = paramArrayOfByte;
    this.cCheckInGroup = paramByte1;
    this.sGroupLocation = paramString;
    this.cStatOption = paramByte2;
    this.wSourceID = paramInt2;
    this.wSourceSubID = paramInt3;
    this.cIsSupportAuthQuestionJoin = paramByte3;
    this.cIfGetAuthInfo = paramByte4;
    this.dwDiscussUin = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reqtype = paramJceInputStream.read(this.reqtype, 0, true);
    this.uin = paramJceInputStream.read(this.uin, 1, true);
    if (cache_vecBody == null)
    {
      cache_vecBody = (byte[])new byte[1];
      ((byte[])cache_vecBody)[0] = 0;
    }
    this.vecBody = ((byte[])paramJceInputStream.read(cache_vecBody, 2, true));
    this.cCheckInGroup = paramJceInputStream.read(this.cCheckInGroup, 3, false);
    this.sGroupLocation = paramJceInputStream.readString(4, false);
    this.cStatOption = paramJceInputStream.read(this.cStatOption, 5, false);
    this.wSourceID = paramJceInputStream.read(this.wSourceID, 6, false);
    this.wSourceSubID = paramJceInputStream.read(this.wSourceSubID, 7, false);
    this.cIsSupportAuthQuestionJoin = paramJceInputStream.read(this.cIsSupportAuthQuestionJoin, 8, false);
    this.cIfGetAuthInfo = paramJceInputStream.read(this.cIfGetAuthInfo, 9, false);
    this.dwDiscussUin = paramJceInputStream.read(this.dwDiscussUin, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reqtype, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.vecBody, 2);
    paramJceOutputStream.write(this.cCheckInGroup, 3);
    if (this.sGroupLocation != null) {
      paramJceOutputStream.write(this.sGroupLocation, 4);
    }
    paramJceOutputStream.write(this.cStatOption, 5);
    paramJceOutputStream.write(this.wSourceID, 6);
    paramJceOutputStream.write(this.wSourceSubID, 7);
    paramJceOutputStream.write(this.cIsSupportAuthQuestionJoin, 8);
    paramJceOutputStream.write(this.cIfGetAuthInfo, 9);
    paramJceOutputStream.write(this.dwDiscussUin, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     KQQ.GroupMngReq
 * JD-Core Version:    0.7.0.1
 */