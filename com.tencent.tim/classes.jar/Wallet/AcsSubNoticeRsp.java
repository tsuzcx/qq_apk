package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AcsSubNoticeRsp
  extends JceStruct
{
  static AcsMsg cache_msg = new AcsMsg();
  public String err_str = "";
  public AcsMsg msg;
  public int ret_code;
  
  public AcsSubNoticeRsp() {}
  
  public AcsSubNoticeRsp(int paramInt, String paramString, AcsMsg paramAcsMsg)
  {
    this.ret_code = paramInt;
    this.err_str = paramString;
    this.msg = paramAcsMsg;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, false);
    this.err_str = paramJceInputStream.readString(1, false);
    this.msg = ((AcsMsg)paramJceInputStream.read(cache_msg, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    if (this.err_str != null) {
      paramJceOutputStream.write(this.err_str, 1);
    }
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     Wallet.AcsSubNoticeRsp
 * JD-Core Version:    0.7.0.1
 */