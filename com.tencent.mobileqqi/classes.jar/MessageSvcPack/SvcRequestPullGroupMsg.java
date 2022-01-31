package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRequestPullGroupMsg
  extends JceStruct
{
  public byte cGetGroupNick = 0;
  public byte cGetPttUrl = 0;
  public byte cGroupMsgRoam = 0;
  public byte cMsgStoreType = 0;
  public byte cVerifyType = 0;
  public long lBeginSeq = 0L;
  public long lEndSeq = 0L;
  public long lGroupCode = 0L;
  
  public SvcRequestPullGroupMsg() {}
  
  public SvcRequestPullGroupMsg(byte paramByte1, long paramLong1, long paramLong2, long paramLong3, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5)
  {
    this.cVerifyType = paramByte1;
    this.lGroupCode = paramLong1;
    this.lBeginSeq = paramLong2;
    this.lEndSeq = paramLong3;
    this.cGetGroupNick = paramByte2;
    this.cGroupMsgRoam = paramByte3;
    this.cMsgStoreType = paramByte4;
    this.cGetPttUrl = paramByte5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 0, true);
    this.lGroupCode = paramJceInputStream.read(this.lGroupCode, 1, true);
    this.lBeginSeq = paramJceInputStream.read(this.lBeginSeq, 2, true);
    this.lEndSeq = paramJceInputStream.read(this.lEndSeq, 3, true);
    this.cGetGroupNick = paramJceInputStream.read(this.cGetGroupNick, 4, false);
    this.cGroupMsgRoam = paramJceInputStream.read(this.cGroupMsgRoam, 5, false);
    this.cMsgStoreType = paramJceInputStream.read(this.cMsgStoreType, 6, false);
    this.cGetPttUrl = paramJceInputStream.read(this.cGetPttUrl, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cVerifyType, 0);
    paramJceOutputStream.write(this.lGroupCode, 1);
    paramJceOutputStream.write(this.lBeginSeq, 2);
    paramJceOutputStream.write(this.lEndSeq, 3);
    paramJceOutputStream.write(this.cGetGroupNick, 4);
    paramJceOutputStream.write(this.cGroupMsgRoam, 5);
    paramJceOutputStream.write(this.cMsgStoreType, 6);
    paramJceOutputStream.write(this.cGetPttUrl, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcRequestPullGroupMsg
 * JD-Core Version:    0.7.0.1
 */