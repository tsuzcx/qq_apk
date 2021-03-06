package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class VipOpenInfo
  extends JceStruct
{
  public boolean bOpen;
  public int iVipFlag;
  public int iVipLevel = -1;
  public int iVipType = -1;
  public long lNameplateId;
  
  public VipOpenInfo() {}
  
  public VipOpenInfo(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.bOpen = paramBoolean;
    this.iVipType = paramInt1;
    this.iVipLevel = paramInt2;
    this.iVipFlag = paramInt3;
    this.lNameplateId = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bOpen = paramJceInputStream.read(this.bOpen, 0, true);
    this.iVipType = paramJceInputStream.read(this.iVipType, 1, true);
    this.iVipLevel = paramJceInputStream.read(this.iVipLevel, 2, true);
    this.iVipFlag = paramJceInputStream.read(this.iVipFlag, 3, false);
    this.lNameplateId = paramJceInputStream.read(this.lNameplateId, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bOpen, 0);
    paramJceOutputStream.write(this.iVipType, 1);
    paramJceOutputStream.write(this.iVipLevel, 2);
    paramJceOutputStream.write(this.iVipFlag, 3);
    paramJceOutputStream.write(this.lNameplateId, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.VipOpenInfo
 * JD-Core Version:    0.7.0.1
 */