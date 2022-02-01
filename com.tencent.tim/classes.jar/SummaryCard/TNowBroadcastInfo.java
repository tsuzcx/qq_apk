package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TNowBroadcastInfo
  extends JceStruct
{
  static byte[] cache_vAnchorDataRsp = (byte[])new byte[1];
  public int iFlag;
  public String strHrefURL = "";
  public String strIconURL = "";
  public byte[] vAnchorDataRsp;
  
  static
  {
    ((byte[])cache_vAnchorDataRsp)[0] = 0;
  }
  
  public TNowBroadcastInfo() {}
  
  public TNowBroadcastInfo(int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    this.iFlag = paramInt;
    this.strIconURL = paramString1;
    this.strHrefURL = paramString2;
    this.vAnchorDataRsp = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iFlag = paramJceInputStream.read(this.iFlag, 0, false);
    this.strIconURL = paramJceInputStream.readString(1, false);
    this.strHrefURL = paramJceInputStream.readString(2, false);
    this.vAnchorDataRsp = ((byte[])paramJceInputStream.read(cache_vAnchorDataRsp, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iFlag, 0);
    if (this.strIconURL != null) {
      paramJceOutputStream.write(this.strIconURL, 1);
    }
    if (this.strHrefURL != null) {
      paramJceOutputStream.write(this.strHrefURL, 2);
    }
    if (this.vAnchorDataRsp != null) {
      paramJceOutputStream.write(this.vAnchorDataRsp, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SummaryCard.TNowBroadcastInfo
 * JD-Core Version:    0.7.0.1
 */