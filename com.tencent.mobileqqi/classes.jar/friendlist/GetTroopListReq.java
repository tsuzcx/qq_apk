package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetTroopListReq
  extends JceStruct
{
  public byte bGetMSFMsgFlag = 0;
  public long uin = 0L;
  
  public GetTroopListReq() {}
  
  public GetTroopListReq(long paramLong, byte paramByte)
  {
    this.uin = paramLong;
    this.bGetMSFMsgFlag = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.bGetMSFMsgFlag = paramJceInputStream.read(this.bGetMSFMsgFlag, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.bGetMSFMsgFlag, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     friendlist.GetTroopListReq
 * JD-Core Version:    0.7.0.1
 */