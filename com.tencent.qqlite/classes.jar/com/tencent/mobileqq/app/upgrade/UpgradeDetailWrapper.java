package com.tencent.mobileqq.app.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import daf;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeDetailWrapper
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new daf();
  public ApkUpdateDetail a;
  public UpgradeDetailWrapper.NewApkInfo a;
  public UpgradeInfo a;
  
  public UpgradeDetailWrapper(UpgradeInfo paramUpgradeInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo = paramUpgradeInfo;
    this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail = paramApkUpdateDetail;
  }
  
  public int describeContents()
  {
    return 0;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper
 * JD-Core Version:    0.7.0.1
 */