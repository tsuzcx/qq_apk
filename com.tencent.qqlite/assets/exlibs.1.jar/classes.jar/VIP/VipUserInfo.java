package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class VipUserInfo
  extends JceStruct
{
  public int iGrowthSpeed = -1;
  public int iGrowthValue = -1;
  public int iOpenSVip = -1;
  public int iOpenVip = -1;
  public int iVipLevel = -1;
  public int iVipType = -1;
  
  public VipUserInfo() {}
  
  public VipUserInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.iOpenVip = paramInt1;
    this.iOpenSVip = paramInt2;
    this.iVipLevel = paramInt3;
    this.iVipType = paramInt4;
    this.iGrowthValue = paramInt5;
    this.iGrowthSpeed = paramInt6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iOpenVip = paramJceInputStream.read(this.iOpenVip, 1, true);
    this.iOpenSVip = paramJceInputStream.read(this.iOpenSVip, 2, true);
    this.iVipLevel = paramJceInputStream.read(this.iVipLevel, 3, true);
    this.iVipType = paramJceInputStream.read(this.iVipType, 4, true);
    this.iGrowthValue = paramJceInputStream.read(this.iGrowthValue, 5, true);
    this.iGrowthSpeed = paramJceInputStream.read(this.iGrowthSpeed, 6, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iOpenVip, 1);
    paramJceOutputStream.write(this.iOpenSVip, 2);
    paramJceOutputStream.write(this.iVipLevel, 3);
    paramJceOutputStream.write(this.iVipType, 4);
    paramJceOutputStream.write(this.iGrowthValue, 5);
    paramJceOutputStream.write(this.iGrowthSpeed, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     VIP.VipUserInfo
 * JD-Core Version:    0.7.0.1
 */