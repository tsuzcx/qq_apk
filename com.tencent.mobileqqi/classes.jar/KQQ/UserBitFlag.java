package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserBitFlag
  extends JceStruct
{
  public byte cEmotionMall = -1;
  public byte cSyncShuoShuo = -1;
  
  public UserBitFlag() {}
  
  public UserBitFlag(byte paramByte1, byte paramByte2)
  {
    this.cEmotionMall = paramByte1;
    this.cSyncShuoShuo = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cEmotionMall = paramJceInputStream.read(this.cEmotionMall, 0, false);
    this.cSyncShuoShuo = paramJceInputStream.read(this.cSyncShuoShuo, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cEmotionMall, 0);
    paramJceOutputStream.write(this.cSyncShuoShuo, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     KQQ.UserBitFlag
 * JD-Core Version:    0.7.0.1
 */