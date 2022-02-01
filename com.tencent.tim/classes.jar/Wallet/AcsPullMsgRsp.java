package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class AcsPullMsgRsp
  extends JceStruct
{
  static ArrayList<AcsMsg> cache_msgs = new ArrayList();
  public String all_url = "";
  public String err_str = "";
  public ArrayList<AcsMsg> msgs;
  public int ret_code;
  
  static
  {
    AcsMsg localAcsMsg = new AcsMsg();
    cache_msgs.add(localAcsMsg);
  }
  
  public AcsPullMsgRsp() {}
  
  public AcsPullMsgRsp(int paramInt, String paramString1, ArrayList<AcsMsg> paramArrayList, String paramString2)
  {
    this.ret_code = paramInt;
    this.err_str = paramString1;
    this.msgs = paramArrayList;
    this.all_url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, false);
    this.err_str = paramJceInputStream.readString(1, false);
    this.msgs = ((ArrayList)paramJceInputStream.read(cache_msgs, 2, false));
    this.all_url = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    if (this.err_str != null) {
      paramJceOutputStream.write(this.err_str, 1);
    }
    if (this.msgs != null) {
      paramJceOutputStream.write(this.msgs, 2);
    }
    if (this.all_url != null) {
      paramJceOutputStream.write(this.all_url, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     Wallet.AcsPullMsgRsp
 * JD-Core Version:    0.7.0.1
 */