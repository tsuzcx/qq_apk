import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import protocol.KQQConfig.UpgradeInfo;

public final class zti
  implements Parcelable.Creator
{
  public UpgradeDetailWrapper a(Parcel paramParcel)
  {
    ApkUpdateDetail localApkUpdateDetail = null;
    UpgradeInfo localUpgradeInfo;
    if (paramParcel.readInt() == 1)
    {
      localUpgradeInfo = new UpgradeInfo();
      localUpgradeInfo.iAppid = paramParcel.readInt();
      localUpgradeInfo.bAppType = paramParcel.readByte();
      localUpgradeInfo.iUpgradeType = paramParcel.readInt();
      localUpgradeInfo.iUpgradeSdkId = paramParcel.readInt();
      localUpgradeInfo.strTitle = paramParcel.readString();
      localUpgradeInfo.strUpgradeDesc = paramParcel.readString();
      localUpgradeInfo.strUrl = paramParcel.readString();
      localUpgradeInfo.iActionType = paramParcel.readInt();
      localUpgradeInfo.bNewSwitch = paramParcel.readByte();
      localUpgradeInfo.iNewTimeStamp = paramParcel.readInt();
      localUpgradeInfo.strUpgradePageUrl = paramParcel.readString();
      localUpgradeInfo.iIncrementUpgrade = paramParcel.readInt();
      localUpgradeInfo.iTipsType = paramParcel.readInt();
      localUpgradeInfo.strBannerPicUrl = paramParcel.readString();
      localUpgradeInfo.strNewUpgradeDescURL = paramParcel.readString();
      localUpgradeInfo.iDisplayDay = paramParcel.readInt();
      localUpgradeInfo.iTipsWaitDay = paramParcel.readInt();
      localUpgradeInfo.strProgressName = paramParcel.readString();
      localUpgradeInfo.strNewTipsDescURL = paramParcel.readString();
      localUpgradeInfo.strNewSoftwareURL = paramParcel.readString();
    }
    for (;;)
    {
      if (paramParcel.readInt() == 1)
      {
        localApkUpdateDetail = new ApkUpdateDetail();
        localApkUpdateDetail.fileMd5 = paramParcel.readString();
        localApkUpdateDetail.newapksize = paramParcel.readInt();
        localApkUpdateDetail.packageName = paramParcel.readString();
        localApkUpdateDetail.patchsize = paramParcel.readInt();
        localApkUpdateDetail.sigMd5 = paramParcel.readString();
        localApkUpdateDetail.updatemethod = paramParcel.readInt();
        localApkUpdateDetail.url = paramParcel.readString();
        localApkUpdateDetail.versioncode = paramParcel.readInt();
        localApkUpdateDetail.versionname = paramParcel.readString();
      }
      paramParcel = new UpgradeDetailWrapper(localUpgradeInfo, localApkUpdateDetail);
      paramParcel.a = ConfigHandler.a(localUpgradeInfo);
      return paramParcel;
      localUpgradeInfo = null;
    }
  }
  
  public UpgradeDetailWrapper[] a(int paramInt)
  {
    return new UpgradeDetailWrapper[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zti
 * JD-Core Version:    0.7.0.1
 */