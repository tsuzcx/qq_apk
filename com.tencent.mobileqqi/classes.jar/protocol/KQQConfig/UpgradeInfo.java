package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UpgradeInfo
  extends JceStruct
{
  static PublicAccountInfo cache_stAccountInfo;
  public byte bAppType = 0;
  public byte bGray = 0;
  public byte bNewSwitch = 1;
  public int iActionType = 0;
  public int iAppid = 0;
  public int iDisplayDay = 0;
  public int iIncrementUpgrade = 0;
  public int iNewTimeStamp = 0;
  public int iTipsType = 0;
  public int iTipsWaitDay = 0;
  public int iUpgradeSdkId = 0;
  public int iUpgradeType = 0;
  public PublicAccountInfo stAccountInfo = null;
  public String strBannerPicUrl = "";
  public String strButtonDesc = "";
  public String strCancelButtonDesc = "";
  public String strNewSoftwareURL = "";
  public String strNewTipsDescURL = "";
  public String strNewUpgradeDescURL = "";
  public String strProgressName = "";
  public String strTitle = "";
  public String strUpgradeDesc = "";
  public String strUpgradePageUrl = "";
  public String strUrl = "";
  
  public UpgradeInfo() {}
  
  public UpgradeInfo(int paramInt1, byte paramByte1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, int paramInt4, byte paramByte2, int paramInt5, String paramString4, int paramInt6, int paramInt7, String paramString5, String paramString6, int paramInt8, int paramInt9, String paramString7, String paramString8, String paramString9, PublicAccountInfo paramPublicAccountInfo, byte paramByte3, String paramString10, String paramString11)
  {
    this.iAppid = paramInt1;
    this.bAppType = paramByte1;
    this.iUpgradeType = paramInt2;
    this.iUpgradeSdkId = paramInt3;
    this.strTitle = paramString1;
    this.strUpgradeDesc = paramString2;
    this.strUrl = paramString3;
    this.iActionType = paramInt4;
    this.bNewSwitch = paramByte2;
    this.iNewTimeStamp = paramInt5;
    this.strUpgradePageUrl = paramString4;
    this.iIncrementUpgrade = paramInt6;
    this.iTipsType = paramInt7;
    this.strBannerPicUrl = paramString5;
    this.strNewUpgradeDescURL = paramString6;
    this.iDisplayDay = paramInt8;
    this.iTipsWaitDay = paramInt9;
    this.strProgressName = paramString7;
    this.strNewTipsDescURL = paramString8;
    this.strNewSoftwareURL = paramString9;
    this.stAccountInfo = paramPublicAccountInfo;
    this.bGray = paramByte3;
    this.strButtonDesc = paramString10;
    this.strCancelButtonDesc = paramString11;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAppid = paramJceInputStream.read(this.iAppid, 1, true);
    this.bAppType = paramJceInputStream.read(this.bAppType, 2, true);
    this.iUpgradeType = paramJceInputStream.read(this.iUpgradeType, 3, true);
    this.iUpgradeSdkId = paramJceInputStream.read(this.iUpgradeSdkId, 4, true);
    this.strTitle = paramJceInputStream.readString(5, false);
    this.strUpgradeDesc = paramJceInputStream.readString(6, false);
    this.strUrl = paramJceInputStream.readString(7, false);
    this.iActionType = paramJceInputStream.read(this.iActionType, 8, false);
    this.bNewSwitch = paramJceInputStream.read(this.bNewSwitch, 9, false);
    this.iNewTimeStamp = paramJceInputStream.read(this.iNewTimeStamp, 10, false);
    this.strUpgradePageUrl = paramJceInputStream.readString(11, false);
    this.iIncrementUpgrade = paramJceInputStream.read(this.iIncrementUpgrade, 12, false);
    this.iTipsType = paramJceInputStream.read(this.iTipsType, 13, false);
    this.strBannerPicUrl = paramJceInputStream.readString(14, false);
    this.strNewUpgradeDescURL = paramJceInputStream.readString(15, false);
    this.iDisplayDay = paramJceInputStream.read(this.iDisplayDay, 16, false);
    this.iTipsWaitDay = paramJceInputStream.read(this.iTipsWaitDay, 17, false);
    this.strProgressName = paramJceInputStream.readString(18, false);
    this.strNewTipsDescURL = paramJceInputStream.readString(19, false);
    this.strNewSoftwareURL = paramJceInputStream.readString(20, false);
    if (cache_stAccountInfo == null) {
      cache_stAccountInfo = new PublicAccountInfo();
    }
    this.stAccountInfo = ((PublicAccountInfo)paramJceInputStream.read(cache_stAccountInfo, 21, false));
    this.bGray = paramJceInputStream.read(this.bGray, 22, false);
    this.strButtonDesc = paramJceInputStream.readString(23, false);
    this.strCancelButtonDesc = paramJceInputStream.readString(24, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAppid, 1);
    paramJceOutputStream.write(this.bAppType, 2);
    paramJceOutputStream.write(this.iUpgradeType, 3);
    paramJceOutputStream.write(this.iUpgradeSdkId, 4);
    if (this.strTitle != null) {
      paramJceOutputStream.write(this.strTitle, 5);
    }
    if (this.strUpgradeDesc != null) {
      paramJceOutputStream.write(this.strUpgradeDesc, 6);
    }
    if (this.strUrl != null) {
      paramJceOutputStream.write(this.strUrl, 7);
    }
    paramJceOutputStream.write(this.iActionType, 8);
    paramJceOutputStream.write(this.bNewSwitch, 9);
    paramJceOutputStream.write(this.iNewTimeStamp, 10);
    if (this.strUpgradePageUrl != null) {
      paramJceOutputStream.write(this.strUpgradePageUrl, 11);
    }
    paramJceOutputStream.write(this.iIncrementUpgrade, 12);
    paramJceOutputStream.write(this.iTipsType, 13);
    if (this.strBannerPicUrl != null) {
      paramJceOutputStream.write(this.strBannerPicUrl, 14);
    }
    if (this.strNewUpgradeDescURL != null) {
      paramJceOutputStream.write(this.strNewUpgradeDescURL, 15);
    }
    paramJceOutputStream.write(this.iDisplayDay, 16);
    paramJceOutputStream.write(this.iTipsWaitDay, 17);
    if (this.strProgressName != null) {
      paramJceOutputStream.write(this.strProgressName, 18);
    }
    if (this.strNewTipsDescURL != null) {
      paramJceOutputStream.write(this.strNewTipsDescURL, 19);
    }
    if (this.strNewSoftwareURL != null) {
      paramJceOutputStream.write(this.strNewSoftwareURL, 20);
    }
    if (this.stAccountInfo != null) {
      paramJceOutputStream.write(this.stAccountInfo, 21);
    }
    paramJceOutputStream.write(this.bGray, 22);
    if (this.strButtonDesc != null) {
      paramJceOutputStream.write(this.strButtonDesc, 23);
    }
    if (this.strCancelButtonDesc != null) {
      paramJceOutputStream.write(this.strCancelButtonDesc, 24);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     protocol.KQQConfig.UpgradeInfo
 * JD-Core Version:    0.7.0.1
 */