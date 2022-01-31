package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserBitFlagRes
  extends JceStruct
{
  public byte cAccout2Dis = -1;
  public byte cEmotionMall = -1;
  public byte cMyWallet = -1;
  public byte cPtt2Text = -1;
  
  public UserBitFlagRes() {}
  
  public UserBitFlagRes(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    this.cEmotionMall = paramByte1;
    this.cMyWallet = paramByte2;
    this.cPtt2Text = paramByte3;
    this.cAccout2Dis = paramByte4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cEmotionMall = paramJceInputStream.read(this.cEmotionMall, 0, false);
    this.cMyWallet = paramJceInputStream.read(this.cMyWallet, 1, false);
    this.cPtt2Text = paramJceInputStream.read(this.cPtt2Text, 2, false);
    this.cAccout2Dis = paramJceInputStream.read(this.cAccout2Dis, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cEmotionMall, 0);
    paramJceOutputStream.write(this.cMyWallet, 1);
    paramJceOutputStream.write(this.cPtt2Text, 2);
    paramJceOutputStream.write(this.cAccout2Dis, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     KQQ.UserBitFlagRes
 * JD-Core Version:    0.7.0.1
 */