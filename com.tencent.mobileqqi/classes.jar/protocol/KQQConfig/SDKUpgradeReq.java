package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SDKUpgradeReq
  extends JceStruct
{
  static ArrayList cache_vAppid;
  static ArrayList cache_vUin;
  public byte bJailbreak = 0;
  public boolean bSdkUpdateFlag = true;
  public byte cProtocolVer = 0;
  public int iActionType = 0;
  public int iHeight = 0;
  public int iWidth = 0;
  public ArrayList vAppid = null;
  public ArrayList vUin = null;
  
  public SDKUpgradeReq() {}
  
  public SDKUpgradeReq(byte paramByte1, ArrayList paramArrayList1, boolean paramBoolean, ArrayList paramArrayList2, int paramInt1, int paramInt2, int paramInt3, byte paramByte2)
  {
    this.cProtocolVer = paramByte1;
    this.vUin = paramArrayList1;
    this.bSdkUpdateFlag = paramBoolean;
    this.vAppid = paramArrayList2;
    this.iActionType = paramInt1;
    this.iWidth = paramInt2;
    this.iHeight = paramInt3;
    this.bJailbreak = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cProtocolVer = paramJceInputStream.read(this.cProtocolVer, 1, true);
    if (cache_vUin == null)
    {
      cache_vUin = new ArrayList();
      cache_vUin.add("");
    }
    this.vUin = ((ArrayList)paramJceInputStream.read(cache_vUin, 2, true));
    this.bSdkUpdateFlag = paramJceInputStream.read(this.bSdkUpdateFlag, 3, false);
    if (cache_vAppid == null)
    {
      cache_vAppid = new ArrayList();
      cache_vAppid.add(Integer.valueOf(0));
    }
    this.vAppid = ((ArrayList)paramJceInputStream.read(cache_vAppid, 4, false));
    this.iActionType = paramJceInputStream.read(this.iActionType, 5, false);
    this.iWidth = paramJceInputStream.read(this.iWidth, 6, false);
    this.iHeight = paramJceInputStream.read(this.iHeight, 7, false);
    this.bJailbreak = paramJceInputStream.read(this.bJailbreak, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cProtocolVer, 1);
    paramJceOutputStream.write(this.vUin, 2);
    paramJceOutputStream.write(this.bSdkUpdateFlag, 3);
    if (this.vAppid != null) {
      paramJceOutputStream.write(this.vAppid, 4);
    }
    paramJceOutputStream.write(this.iActionType, 5);
    paramJceOutputStream.write(this.iWidth, 6);
    paramJceOutputStream.write(this.iHeight, 7);
    paramJceOutputStream.write(this.bJailbreak, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     protocol.KQQConfig.SDKUpgradeReq
 * JD-Core Version:    0.7.0.1
 */