package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRequestGetGroupMsg
  extends JceStruct
{
  public byte c30Min;
  public byte cGetGroupNick;
  public byte cGetPttUrl;
  public byte cGroupMsgRoam;
  public byte cMsgStoreType;
  public byte cRecivePic;
  public byte cSubCmd;
  public byte cVerifyType;
  public long lBeginSeq;
  public long lEndSeq;
  public long lGroupCode;
  public long lUin;
  
  public SvcRequestGetGroupMsg() {}
  
  public SvcRequestGetGroupMsg(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8)
  {
    this.lUin = paramLong1;
    this.lGroupCode = paramLong2;
    this.lBeginSeq = paramLong3;
    this.lEndSeq = paramLong4;
    this.c30Min = paramByte1;
    this.cRecivePic = paramByte2;
    this.cMsgStoreType = paramByte3;
    this.cVerifyType = paramByte4;
    this.cSubCmd = paramByte5;
    this.cGetGroupNick = paramByte6;
    this.cGroupMsgRoam = paramByte7;
    this.cGetPttUrl = paramByte8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.lGroupCode = paramJceInputStream.read(this.lGroupCode, 1, true);
    this.lBeginSeq = paramJceInputStream.read(this.lBeginSeq, 2, true);
    this.lEndSeq = paramJceInputStream.read(this.lEndSeq, 3, true);
    this.c30Min = paramJceInputStream.read(this.c30Min, 4, true);
    this.cRecivePic = paramJceInputStream.read(this.cRecivePic, 5, true);
    this.cMsgStoreType = paramJceInputStream.read(this.cMsgStoreType, 6, false);
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 7, false);
    this.cSubCmd = paramJceInputStream.read(this.cSubCmd, 8, false);
    this.cGetGroupNick = paramJceInputStream.read(this.cGetGroupNick, 9, false);
    this.cGroupMsgRoam = paramJceInputStream.read(this.cGroupMsgRoam, 10, false);
    this.cGetPttUrl = paramJceInputStream.read(this.cGetPttUrl, 11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.lGroupCode, 1);
    paramJceOutputStream.write(this.lBeginSeq, 2);
    paramJceOutputStream.write(this.lEndSeq, 3);
    paramJceOutputStream.write(this.c30Min, 4);
    paramJceOutputStream.write(this.cRecivePic, 5);
    paramJceOutputStream.write(this.cMsgStoreType, 6);
    paramJceOutputStream.write(this.cVerifyType, 7);
    paramJceOutputStream.write(this.cSubCmd, 8);
    paramJceOutputStream.write(this.cGetGroupNick, 9);
    paramJceOutputStream.write(this.cGroupMsgRoam, 10);
    paramJceOutputStream.write(this.cGetPttUrl, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcRequestGetGroupMsg
 * JD-Core Version:    0.7.0.1
 */