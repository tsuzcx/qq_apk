package CardPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqChannel
  extends JceStruct
  implements Cloneable
{
  static LBSInfo cache_lbsInfo;
  public LBSInfo lbsInfo = null;
  public int nfcSupported = 0;
  public String phoneModel = "";
  public int pid = 0;
  public int subCmd = 0;
  
  public ReqChannel() {}
  
  public ReqChannel(int paramInt1, int paramInt2, LBSInfo paramLBSInfo, String paramString, int paramInt3)
  {
    this.subCmd = paramInt1;
    this.pid = paramInt2;
    this.lbsInfo = paramLBSInfo;
    this.phoneModel = paramString;
    this.nfcSupported = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.subCmd = paramJceInputStream.read(this.subCmd, 0, true);
    this.pid = paramJceInputStream.read(this.pid, 1, true);
    if (cache_lbsInfo == null) {
      cache_lbsInfo = new LBSInfo();
    }
    this.lbsInfo = ((LBSInfo)paramJceInputStream.read(cache_lbsInfo, 2, true));
    this.phoneModel = paramJceInputStream.readString(3, true);
    this.nfcSupported = paramJceInputStream.read(this.nfcSupported, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.subCmd, 0);
    paramJceOutputStream.write(this.pid, 1);
    paramJceOutputStream.write(this.lbsInfo, 2);
    paramJceOutputStream.write(this.phoneModel, 3);
    paramJceOutputStream.write(this.nfcSupported, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     CardPay.ReqChannel
 * JD-Core Version:    0.7.0.1
 */