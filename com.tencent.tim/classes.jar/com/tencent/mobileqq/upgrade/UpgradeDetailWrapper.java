package com.tencent.mobileqq.upgrade;

import akrf;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Xml;
import aqaq;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeDetailWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<UpgradeDetailWrapper> CREATOR = new aqaq();
  static String TAG = "UpgradeDetailWrapper";
  public ApkUpdateDetail a;
  public a a;
  public UpgradeInfo a;
  public NewUpgradeConfig b;
  public UpgradeInfo b;
  public boolean cTt;
  public String csh = "";
  public int dYl;
  public int dYm;
  
  public UpgradeDetailWrapper(UpgradeInfo paramUpgradeInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo = paramUpgradeInfo;
    this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail = paramApkUpdateDetail;
  }
  
  private void a(XmlPullParser paramXmlPullParser, String paramString)
    throws IOException, XmlPullParserException
  {
    if (a(paramXmlPullParser, paramString)) {}
    while ((b(paramXmlPullParser, paramString)) || (!c(paramXmlPullParser, paramString))) {
      return;
    }
  }
  
  private boolean a(XmlPullParser paramXmlPullParser, String paramString)
    throws IOException, XmlPullParserException
  {
    if (paramString.equalsIgnoreCase("configId"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.id = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("taskName"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.name = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("taskTime"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.time = akrf.ah(paramXmlPullParser.nextText());
      return true;
    }
    if (paramString.equalsIgnoreCase("showTime"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.showTime = akrf.ah(paramXmlPullParser.nextText());
      return true;
    }
    if (paramString.equalsIgnoreCase("title"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.title = paramXmlPullParser.nextText();
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strTitle = this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.title;
      return true;
    }
    if (paramString.equalsIgnoreCase("content"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.content = paramXmlPullParser.nextText();
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc = this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.content;
      return true;
    }
    if (paramString.equalsIgnoreCase("desc"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.desc = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("installFail"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.csb = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("info"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.info = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("yellowBar"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.aCm = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("barContent"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.csc = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("barContent2"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.csd = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("lBtnText"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.cse = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("rBtnText"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.csf = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("downloadDialogMaxTimes"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.dYf = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("downloadDialogDayRate"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.dYg = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("installDialogMaxTimes"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.dYh = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("installDialogDayRate"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.dYi = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("preDownloadYYB"))
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.cTi = paramXmlPullParser.nextText().equals("1");
      return true;
    }
    return false;
  }
  
  private boolean b(XmlPullParser paramXmlPullParser, String paramString)
    throws IOException, XmlPullParserException
  {
    if (paramString.equalsIgnoreCase("status"))
    {
      paramXmlPullParser = paramXmlPullParser.nextText();
      if ("on".equalsIgnoreCase(paramXmlPullParser)) {
        this.dYl = 1;
      }
      while (!"off".equalsIgnoreCase(paramXmlPullParser)) {
        return true;
      }
      this.dYl = 2;
      return true;
    }
    if (paramString.equalsIgnoreCase("jumpMarketSupportPhone"))
    {
      this.csh = paramXmlPullParser.nextText();
      return true;
    }
    return false;
  }
  
  private boolean c(XmlPullParser paramXmlPullParser, String paramString)
    throws IOException, XmlPullParserException
  {
    if (paramString.equalsIgnoreCase("iUpgradeSdkId"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("iUpgradeType"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("iDownloadPageUrl"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUrl = paramXmlPullParser.nextText();
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradePageUrl = this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUrl;
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewUpgradeDescURL = this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUrl;
      return true;
    }
    if (paramString.equalsIgnoreCase("iActionType"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iActionType = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("bNewSwitch"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.bNewSwitch = Byte.valueOf(paramXmlPullParser.nextText()).byteValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("iIncrementUpgrade"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("iTipsType"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("strProgressName"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strProgressName = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("strNewSoftwareURL"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("strNewSoftwareMD5"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareMD5 = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("bGray"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.bGray = Byte.valueOf(paramXmlPullParser.nextText()).byteValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("strButtonDesc"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strButtonDesc = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("strCancelButtonDesc"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strCancelButtonDesc = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("iNewTimeStamp"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iNewTimeStamp = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("strNewTipsDescURL"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewTipsDescURL = paramXmlPullParser.nextText();
      return true;
    }
    return false;
  }
  
  public void bj(String paramString)
  {
    if (this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo == null) {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo = new UpgradeInfo();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig = NewUpgradeConfig.getInstance();
      this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.prepareDialog();
    }
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    try
    {
      localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
      for (int i = localXmlPullParser.getEventType(); i != 1; i = localXmlPullParser.next()) {
        if (i == 2) {
          a(localXmlPullParser, localXmlPullParser.getName());
        }
      }
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iAppid = AppSetting.getAppId();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog = null;
        QLog.e(TAG, 1, "parseConfig fail." + paramString);
      }
    }
    ede();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void ede()
  {
    QLog.d(TAG, 1, "parsed wrapper info:\nmTempUpgradeInfo.iUpgradeSdkId=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId + "\nmTempUpgradeInfo.iUpgradeType=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType + "\nmTempUpgradeInfo.strUrl=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUrl + "\nmTempUpgradeInfo.strUpgradePageUrl=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradePageUrl + "\nmTempUpgradeInfo.strNewUpgradeDescURL=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewUpgradeDescURL + "\nmTempUpgradeInfo.iActionType=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iActionType + "\nmTempUpgradeInfo.bNewSwitch=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.bNewSwitch + "\nmTempUpgradeInfo.iIncrementUpgrade=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade + "\nmTempUpgradeInfo.iTipsType=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType + "\nmTempUpgradeInfo.strProgressName=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strProgressName + "\nmTempUpgradeInfo.strNewSoftwareURL=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL + "\nmTempUpgradeInfo.strNewSoftwareMD5=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareMD5 + "\nmTempUpgradeInfo.bGray=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.bGray + "\nmTempUpgradeInfo.strButtonDesc=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strButtonDesc + "\nmTempUpgradeInfo.strCancelButtonDesc=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strCancelButtonDesc + "\nmTempUpgradeInfo.strTitle=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strTitle + "\nmTempUpgradeInfo.strUpgradeDesc=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc + "\nmNewUpgradeConfig.dialog.id=" + this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.id + "\nmNewUpgradeConfig.dialog.name=" + this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.name + "\nmNewUpgradeConfig.dialog.time=" + this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.time + "\nmNewUpgradeConfig.dialog.showTime=" + this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.showTime + "\nmNewUpgradeConfig.dialog.title=" + this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.title + "\nmNewUpgradeConfig.dialog.content=" + this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.content + "\nmNewUpgradeConfig.dialog.desc=" + this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.desc + "\nmNewUpgradeConfig.dialog.installFail=" + this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.csb + "\nmNewUpgradeConfig.dialog.info=" + this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.info + "\nmNewUpgradeConfig.dialog.rate=" + this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.aCm + "\nmNewUpgradeConfig.dialog.barContent=" + this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.csc + "\nmNewUpgradeConfig.dialog.barContent2=" + this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.csd + "\nmNewUpgradeConfig.dialog.lBtnText=" + this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.cse + "\nmNewUpgradeConfig.dialog.rBtnText=" + this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.csf + "\nmNewUpgradeConfig.dialog.downloadDialogMaxTimes=" + this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.dYf + "\nmNewUpgradeConfig.dialog.downloadDialogDayRate=" + this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.dYg + "\nmNewUpgradeConfig.dialog.installDialogMaxTimes=" + this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.dYh + "\nmNewUpgradeConfig.dialog.installDialogDayRate=" + this.jdField_b_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.dYi + "\npreloadSwitchConfigValue=" + this.dYl + "\njumpMarketSupportPhone=" + this.csh);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iAppid);
      paramParcel.writeByte(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.bAppType);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUrl);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iActionType);
      paramParcel.writeByte(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.bNewSwitch);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iNewTimeStamp);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradePageUrl);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strBannerPicUrl);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewUpgradeDescURL);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iDisplayDay);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsWaitDay);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strProgressName);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewTipsDescURL);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
      paramParcel.writeString(this.csh);
    }
    while (this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeString(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.fileMd5);
      paramParcel.writeInt(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.newapksize);
      paramParcel.writeString(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.packageName);
      paramParcel.writeInt(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.patchsize);
      paramParcel.writeString(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.sigMd5);
      paramParcel.writeInt(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod);
      paramParcel.writeString(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url);
      paramParcel.writeInt(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.versioncode);
      paramParcel.writeString(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.versionname);
      return;
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(0);
  }
  
  public static class a
  {
    public long asx;
    public String csi;
    public String csj;
    public int dYn = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeDetailWrapper
 * JD-Core Version:    0.7.0.1
 */