package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRequestGetRoamMsg
  extends JceStruct
{
  static byte[] cache_vPwd;
  static byte[] cache_vSig;
  public byte cMsgStoreType = 0;
  public long lPeerUin = 0L;
  public long lRandom = 0L;
  public long lReqLastMsgTime = 0L;
  public int shReadCnt = 0;
  public byte[] vPwd = null;
  public byte[] vSig = null;
  
  public SvcRequestGetRoamMsg() {}
  
  public SvcRequestGetRoamMsg(long paramLong1, long paramLong2, long paramLong3, int paramInt, byte paramByte, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.lPeerUin = paramLong1;
    this.lReqLastMsgTime = paramLong2;
    this.lRandom = paramLong3;
    this.shReadCnt = paramInt;
    this.cMsgStoreType = paramByte;
    this.vSig = paramArrayOfByte1;
    this.vPwd = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lPeerUin = paramJceInputStream.read(this.lPeerUin, 0, true);
    this.lReqLastMsgTime = paramJceInputStream.read(this.lReqLastMsgTime, 1, true);
    this.lRandom = paramJceInputStream.read(this.lRandom, 2, true);
    this.shReadCnt = paramJceInputStream.read(this.shReadCnt, 3, true);
    this.cMsgStoreType = paramJceInputStream.read(this.cMsgStoreType, 4, true);
    if (cache_vSig == null)
    {
      cache_vSig = (byte[])new byte[1];
      ((byte[])cache_vSig)[0] = 0;
    }
    this.vSig = ((byte[])paramJceInputStream.read(cache_vSig, 5, true));
    if (cache_vPwd == null)
    {
      cache_vPwd = (byte[])new byte[1];
      ((byte[])cache_vPwd)[0] = 0;
    }
    this.vPwd = ((byte[])paramJceInputStream.read(cache_vPwd, 6, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lPeerUin, 0);
    paramJceOutputStream.write(this.lReqLastMsgTime, 1);
    paramJceOutputStream.write(this.lRandom, 2);
    paramJceOutputStream.write(this.shReadCnt, 3);
    paramJceOutputStream.write(this.cMsgStoreType, 4);
    paramJceOutputStream.write(this.vSig, 5);
    paramJceOutputStream.write(this.vPwd, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcRequestGetRoamMsg
 * JD-Core Version:    0.7.0.1
 */